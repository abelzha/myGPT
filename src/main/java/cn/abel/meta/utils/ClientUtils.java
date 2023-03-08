package cn.abel.meta.utils;

import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.OpenAiStreamClient;
import com.unfbx.chatgpt.interceptor.OpenAILogger;
import okhttp3.logging.HttpLoggingInterceptor;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;

public class ClientUtils {
    public static OpenAiClient openAiClient;

    public static OpenAiStreamClient aiStreamClient;
    private static final String KEY = "";

    static {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new OpenAILogger());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        openAiClient = OpenAiClient.builder()
                .apiKey(KEY)
                .connectTimeout(50)
                .writeTimeout(50)
                .readTimeout(50)
                .interceptor(Arrays.asList(httpLoggingInterceptor))
                .proxy(proxy)
                .build();

    }

    static {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890));
//        client = new OpenAiStreamClient("sk-**********************",
//                60,
//                60,
//                60,
//                proxy);
        aiStreamClient = OpenAiStreamClient.builder()
                .connectTimeout(50)
                .readTimeout(50)
                .writeTimeout(50)
                .apiKey(KEY)
                .proxy(proxy)
                .build();
    }
}
