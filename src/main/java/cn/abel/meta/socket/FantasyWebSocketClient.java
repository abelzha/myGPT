package cn.abel.meta.socket;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author junzhang27
 */
@Slf4j
public class FantasyWebSocketClient extends WebSocketClient {

    public FantasyWebSocketClient(String url) throws URISyntaxException {
        super(new URI(url));
    }

    @Override
    public void onOpen(ServerHandshake shake) {
        log.info("[FantasyWebSocketClient]连接成功");
    }

    @Override
    public void onMessage(String message) {
        log.info("[FantasyWebSocketClient] 收到消息={}", message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log.info("[FantasyWebSocketClient] 退出连接, code:{}, reason:{}", code, reason);

    }

    @Override
    public void onError(Exception e) {
        log.info("[FantasyWebSocketClient] 连接错误={}", e.getMessage());
    }
}
