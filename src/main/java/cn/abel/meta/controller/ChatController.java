package cn.abel.meta.controller;


import cn.abel.meta.listener.CustomEventListener;
import cn.abel.meta.utils.ClientUtils;
import cn.abel.meta.vo.ChatParam;
import cn.abel.meta.vo.ResponseMsg;
import cn.hutool.core.collection.ListUtil;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.Message;
import com.unfbx.chatgpt.sse.ConsoleEventSourceListener;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("chat")
public class ChatController {


    @PostMapping("say")
    public ResponseMsg say(@RequestBody ChatParam param) {
//        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！").build();
        Message sysMessage = Message.builder().role(Message.Role.SYSTEM).content("你是一个汽车销售数据分析师， 你会分析基层销售人员和消费者的对话， 给出销售人员做的好的和不好的地方，以及分析总结买家的需求。" +
                "请注意，在一次对话过程中只有买家和卖家的关系").build();

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
    public ResponseMsg say2(HttpServletResponse response, HttpServletRequest request) {
////        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！").build();
//        Message sysMessage = Message.builder().role(Message.Role.SYSTEM).content("你是一个汽车销售数据分析师， 你会分析基层销售人员和消费者的对话， 给出销售人员做的好的和不好的地方，以及分析总结买家的需求。" +
//                "请注意，在一次对话过程中只有买家和卖家的关系").build();
//
        // 参数处理
//        for (Message paramMessage : param.getMessages()) {
//            paramMessage.setRole(Message.Role.USER.getName());
//        }
//        param.getMessages().add(Message.builder().role(Message.Role.USER).content("请用表格分析总结上述对话的内容，列名有买家的需求、卖家好的地方、卖家不好的地方").build());
//
//        ChatCompletion chatCompletion = ChatCompletion.builder().messages(param.getMessages()).build();
//        ChatCompletionResponse chatCompletionResponse = ClientUtils.v2.chatCompletion(chatCompletion);
//        chatCompletionResponse.getChoices().forEach(e -> {
//            System.out.println(e.getMessage());
//        });


        CountDownLatch countDownLatch = new CountDownLatch(1);

        CustomEventListener eventSourceListener = new CustomEventListener(request, response, countDownLatch);
        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！").build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(ListUtil.of(message)).build();

        ClientUtils.aiStreamClient.streamChatCompletion(chatCompletion, eventSourceListener);

//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return ResponseMsg.ok();
    }

}
