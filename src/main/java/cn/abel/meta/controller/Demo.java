package cn.abel.meta.controller;

import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.OpenAiStreamClient;
import com.unfbx.chatgpt.entity.completions.Completion;
import com.unfbx.chatgpt.entity.completions.CompletionResponse;
import com.unfbx.chatgpt.sse.ConsoleEventSourceListener;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Demo {

    public static void main(String[] args) {
        //配置api keys
//        OpenAiClient openAiClient = new OpenAiClient("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",60,60,60);
////        OpenAiClient openAiClient = new OpenAiClient("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",60,60,60,null);
////        OpenAiClient openAiClient = new OpenAiClient("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");
//        CompletionResponse completions = openAiClient.completions("我想申请转专业，从计算机专业转到会计学专业，帮我完成一份两百字左右的申请书");
//        Arrays.stream(completions.getChoices()).forEach(System.out::println);






        OpenAiStreamClient client = new OpenAiStreamClient("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", 60, 60, 60);
            ConsoleEventSourceListener eventSourceListener = new ConsoleEventSourceListener();
            Completion q = Completion.builder()
                    .prompt("一句话描述下开心的心情")
                    .stream(true)
                    .build();
        client.streamCompletions(q, eventSourceListener);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
