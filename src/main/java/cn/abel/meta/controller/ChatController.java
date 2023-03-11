package cn.abel.meta.controller;


import cn.abel.meta.listener.CustomEventListener;
import cn.abel.meta.listener.CustomEventListener2;
import cn.abel.meta.utils.ClientUtils;
import cn.abel.meta.utils.MessageUtils;
import cn.abel.meta.vo.ChatParam;
import cn.abel.meta.vo.ResponseMsg;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.Message;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("chat")
public class ChatController {

    @PostMapping("say")
    public ResponseMsg say(@RequestBody ChatParam param) {
        Message sysMessage = Message.builder().role(Message.Role.SYSTEM).content("你是一个销售数据分析师， 你会分析销售对话内容， 给出对话中买家和卖家做的好的和不好的地方，以及分析总结对话者的意图。" +
                "请注意，在一次对话过程中只有买家和卖家的关系").build();
        param.getMessages().add(0, sysMessage);

        // 参数处理
        for (Message paramMessage : param.getMessages()) {
            paramMessage.setRole(Message.Role.USER.getName());
        }
        param.getMessages().add(Message.builder().role(Message.Role.USER).content("请用表格分析总结上述对话的内容，列名有买家的需求、卖家好的地方、卖家不好的地方").build());

        ChatCompletion chatCompletion = ChatCompletion.builder().messages(param.getMessages()).build();
        ChatCompletionResponse chatCompletionResponse = ClientUtils.openAiClient.chatCompletion(chatCompletion);
        chatCompletionResponse.getChoices().forEach(e -> {
            System.out.println(e.getMessage());
        });
        return ResponseMsg.ok(chatCompletionResponse);
    }


    @GetMapping("say2")
    public void say2(HttpServletResponse response, HttpServletRequest request) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CustomEventListener eventSourceListener = new CustomEventListener(request, response, countDownLatch);
        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！请给我一个100字左右的文章").build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(ListUtil.of(message)).build();
        ClientUtils.aiStreamClient.streamChatCompletion(chatCompletion, eventSourceListener);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/say3")
    public SseEmitter stream(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        SseEmitter emitter = new SseEmitter();
        CustomEventListener2 eventSourceListener = new CustomEventListener2(emitter, null);
        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！请给我一个100字左右的文章").build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(ListUtil.of(message)).build();
        ClientUtils.aiStreamClient.streamChatCompletion(chatCompletion, eventSourceListener);
        return emitter;
    }


    @GetMapping("/say4")
    public SseEmitter say4(@RequestParam(name = "param") String param,
                           @RequestParam(name = "id", required = false) String id,
                           HttpServletResponse response) throws UnsupportedEncodingException {
        String decodedParam = URLDecoder.decode(param, "UTF-8");
        ChatParam chatParam = JSONUtil.toBean(decodedParam, ChatParam.class);
        // 角色参数处理
        for (Message paramMessage : chatParam.getMessages()) {
            if (StrUtil.isEmpty(paramMessage.getRole())) {
                paramMessage.setRole(Message.Role.USER.getName());
            }
        }

        ChatParam historyChatParam = MessageUtils.getMsg(id);
        if (ObjectUtil.isNotEmpty(historyChatParam)) {
            historyChatParam.getMessages().addAll(chatParam.getMessages());
            chatParam = historyChatParam;
        } else {
            // 首次的请求，设置默认问答
            Message sysMessage = Message.builder().role(Message.Role.SYSTEM).content("你是一个销售数据分析师， 你会分析对话内容， 给出对话中卖家做的好的和不好的地方" +
                    "请注意，在一次对话过程中只有买家和卖家两种角色").build();
            chatParam.getMessages().add(0, sysMessage);
            chatParam.getMessages().add(Message.builder().role(Message.Role.USER).content("请给出对话中买家和卖家做的好的和不好的地方。请注意：" +
                    "1.如果不存在买家和卖家的关系，请直接总结对话内容，或者回答问题." +
                    "2.尽量保持回答的精简").build());
        }

        response.setCharacterEncoding("UTF-8");
        SseEmitter emitter = new SseEmitter();
        CustomEventListener2 eventSourceListener = new CustomEventListener2(emitter, chatParam);
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(chatParam.getMessages()).temperature(0.2).build();
        ClientUtils.aiStreamClient.streamChatCompletion(chatCompletion, eventSourceListener);

        return emitter;
    }

    @GetMapping("/say5")
    public SseEmitter stream(String parentMessageId,
                             String msg,
                             HttpServletResponse response) {
        ChatParam historyChatParam = MessageUtils.getMsg(parentMessageId);
        historyChatParam.getMessages().add(Message.builder().role(Message.Role.USER).content(msg).build());

        response.setCharacterEncoding("UTF-8");
        SseEmitter emitter = new SseEmitter();
        CustomEventListener2 eventSourceListener = new CustomEventListener2(emitter, historyChatParam);
//        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！请给我一个100字左右的文章").build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(historyChatParam.getMessages()).build();
        ClientUtils.aiStreamClient.streamChatCompletion(chatCompletion, eventSourceListener);
        return emitter;
    }
}
