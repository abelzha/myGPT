package cn.abel.meta.controller;


import cn.abel.meta.listener.CustomEventListener2;
import cn.abel.meta.utils.ClientUtils;
import cn.abel.meta.utils.MessageUtils;
import cn.abel.meta.vo.ChatParam;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("chat/http")
public class ChatHttpController {


    /**
     * 对话
     *
     * @param parentMessageId
     * @param msg
     * @param response
     * @return
     */
    @GetMapping("/say")
    public SseEmitter stream(@RequestParam(name = "id", required = false) String parentMessageId,
                             String msg,
                             HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        SseEmitter emitter = new SseEmitter();

        // 构建参数
        ChatParam chatParam = new ChatParam();
        List<Message> messages;
        if (ObjectUtil.isNotEmpty(MessageUtils.getMsg(parentMessageId))) {
            chatParam = MessageUtils.getMsg(parentMessageId);
            chatParam.getMessages().add(Message.builder().role(Message.Role.USER).content(msg).build());
            messages = chatParam.getMessages();
        } else {
            // 没有历史消息 表示是首次对话
            messages = ListUtil.toList(Message.builder().role(Message.Role.USER).content(msg).build());
            chatParam.setMessages(messages);
        }

        CustomEventListener2 eventSourceListener = new CustomEventListener2(emitter, chatParam);
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(messages).build();
        ClientUtils.aiStreamClient.streamChatCompletion(chatCompletion, eventSourceListener);
        return emitter;
    }
}
