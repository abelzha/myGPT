package cn.abel.meta.socket;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.WebSocket;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

/**
 * socket客户端
 *
 * @author junzhang27
 */
@Slf4j
@Component
public class SocketClient {

    private volatile FantasyWebSocketClient webSocketClient;

    /**
     * DCL 单例获取WebSocketClient
     *
     * @return
     */
    public FantasyWebSocketClient getWebSocketClient() {
        if (webSocketClient == null) {
            synchronized (this) {
                if (webSocketClient == null) {
                    try {
                        webSocketClient = new FantasyWebSocketClient("ws://localhost:8080/meta/websocket/backend");
                        webSocketClient.connect();
                        while (!WebSocket.READYSTATE.OPEN.equals(webSocketClient.getReadyState())) {
                            log.info("socket连接还没有打开");
                        }
                        log.info("websocket连接建立成功");
                    } catch (URISyntaxException e) {
                        log.error("[websocket] URISyntaxException", e);
                    }
                }
            }
        }
        return webSocketClient;
    }

    /**
     * 发送消息
     *
     * @param message
     */
    public void sendMsg(String message) {
        getWebSocketClient().send(message);
    }
}