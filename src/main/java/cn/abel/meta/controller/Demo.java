package cn.abel.meta.controller;

import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.Message;
import com.unfbx.chatgpt.interceptor.OpenAILogger;
import okhttp3.logging.HttpLoggingInterceptor;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Collections;

public class Demo {


    private final OpenAiClient v2;

    {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        v2 = new OpenAiClient("sk-******************************************");
//        v2 = new OpenAiClient("sk-******************************************", null, null);
//        v2 = new OpenAiClient("sk-**********************************",
//                120,
//                120,
//                120,
//                proxy,
//                httpLoggingInterceptor);

        v2 = OpenAiClient.builder()
                .apiKey("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")
                .connectTimeout(50)
                .writeTimeout(50)
                .readTimeout(50)
                .interceptor(Collections.singletonList(httpLoggingInterceptor))
//                .proxy(proxy)
                .build();
    }


    public void chat() {
        //聊天模型：gpt-3.5
        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！").build();
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(Collections.singletonList(message)).build();
        ChatCompletionResponse chatCompletionResponse = v2.chatCompletion(chatCompletion);
        chatCompletionResponse.getChoices().forEach(e -> {
            System.out.println(e.getMessage());
        });
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.chat();


//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
//
//        //配置api keys
//        OpenAiClient openAiClient = new OpenAiClient("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",proxy);
////        OpenAiClient openAiClient = new OpenAiClient("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",60,60,60,null);
////        OpenAiClient openAiClient = new OpenAiClient("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");
//        CompletionResponse completions = openAiClient.completions("你好");
//        Arrays.stream(completions.getChoices()).forEach(System.out::println);
//
//        System.out.println(openAiClient.models());


//        OpenAiStreamClient client = new OpenAiStreamClient("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", 60, 60, 60);
//        ConsoleEventSourceListener eventSourceListener = new ConsoleEventSourceListener();
//        Completion q = Completion.builder()
//                .prompt("一句话描述下开心的心情")
//                .stream(true)
//                .build();
//        client.streamCompletions(q, eventSourceListener);
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
