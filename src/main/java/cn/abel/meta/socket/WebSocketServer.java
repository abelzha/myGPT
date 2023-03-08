package cn.abel.meta.socket;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author junzhang27
 */
@Slf4j
@Component
@ServerEndpoint("/websocket/{name}")
public class WebSocketServer {

    /**
     * 用于存所有的连接服务的客户端，这个对象存储是安全的
     */
    private static final ConcurrentHashMap<String, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();
    /**
     * 与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;
    /**
     * 标识当前连接客户端的用户名
     */
    private String name;

    @OnOpen
    public void OnOpen(Session session, @PathParam(value = "name") String name) {
        this.session = session;
        this.name = name;
        // name是用来表示唯一客户端，如果需要指定发送，需要指定发送通过name来区分
        webSocketSet.put(this.name, this);
        log.info("客户端{}连接成功，当前连接人数为：{}", this.name, webSocketSet.size());
        log.info("连接的客户端名称列表：{}", JSONObject.toJSONString(webSocketSet));
    }

    @OnClose
    public void OnClose() {
        webSocketSet.remove(this.name);
        log.info("客户端{}退出成功，当前连接人数为：{}", this.name, webSocketSet.size());
    }

    @OnMessage
    public void OnMessage(String message) {
        log.info("客户端{}收到消息：{}", this.name, message);
        sending(message);
    }

    /**
     * 发送消息
     *
     * @param message
     */
    public void sending(String message) {
        try {
            String socketName = ((JSONObject) JSONObject.parse(message)).getString("socketName");
            if (StringUtils.isNotBlank(socketName)) {
                appointSending(socketName, message);
            } else {
                groupSending(message);
            }
        } catch (Exception e) {
            log.error("客户端{}sending失败", this.name, e);
        }

    }

    /**
     * 群发
     *
     * @param message
     */
    public void groupSending(String message) {
        for (String name : webSocketSet.keySet()) {
            try {
                webSocketSet.get(name).session.getBasicRemote().sendText(message);
            } catch (NullPointerException np) {
                log.info("当前环境下客户端{}不存在", name);
            } catch (Exception e) {
                log.error("客户端{}群发消息失败", this.name, e);
            }
        }
    }

    /**
     * 指定发送
     *
     * @param curName
     * @param message
     */
    public void appointSending(String curName, String message) {
        try {
            webSocketSet.get(curName).session.getBasicRemote().sendText(message);
        } catch (NullPointerException np) {
            log.info("当前环境下客户端{}不存在", name);
        } catch (Exception e) {
            log.error("客户端{}向客户端{}指定发送消息失败", this.name, curName, e);
        }
    }
}