package cn.abel.meta.listener;


import cn.abel.meta.utils.MessageUtils;
import cn.abel.meta.vo.ChatParam;
import cn.abel.meta.vo.StreamData;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.unfbx.chatgpt.entity.chat.Message;
import lombok.extern.slf4j.Slf4j;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Slf4j
public class CustomEventListener2 extends EventSourceListener {
    private final SseEmitter emitter;
    private final ChatParam chatParam;
    String msgId = "";
    StringBuilder sysAnswer = new StringBuilder(100);

    public CustomEventListener2(SseEmitter emitter, ChatParam chatParam) {
        this.emitter = emitter;
        this.chatParam = chatParam;
    }

    public void onEvent(EventSource eventSource, String id, String type, String data) {
        try {
            log.info("OpenAI返回数据：{}", data);
//            StreamData streamData = JSONUtil.toBean(data, StreamData.class);
            if ("[DONE]".equals(data)) {
                log.info("OpenAI返回数据结束了");
                emitter.send(data);
                emitter.complete();
                Message message = Message.builder().role(Message.Role.ASSISTANT).content(sysAnswer.toString()).build();
                chatParam.getMessages().add(message);
                MessageUtils.saveMsg(msgId, chatParam);
            } else {
                if (StrUtil.isEmpty(msgId)) {
                    StreamData streamData = JSONUtil.toBean(data, StreamData.class);
                    msgId = streamData.getId();
                }
                if (StrUtil.isNotEmpty(data)) {
                    getData(sysAnswer, data);
                    emitter.send(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            emitter.completeWithError(e);
        }
    }

    private void getData(StringBuilder sysAnswer, String data) {
        try {
            JSONObject jsonObject = JSONUtil.parseObj(data);
            String content = jsonObject.getByPath("choices[0].delta.content", String.class);
            log.info("content===:{}", content);
            if (StrUtil.isEmpty(content) || "null".equals(content)) {
                return;
            }
            sysAnswer.append(content);
        } catch (Exception e) {
            log.info("getData 异常：{}", e.getMessage());
        }
    }
}

