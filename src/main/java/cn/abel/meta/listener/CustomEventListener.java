package cn.abel.meta.listener;


import lombok.extern.slf4j.Slf4j;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class CustomEventListener extends EventSourceListener {

    private HttpServletResponse response;
    private AsyncContext asyncContext;
    private CountDownLatch countDownLatch;

    public CustomEventListener(HttpServletRequest request, HttpServletResponse response, CountDownLatch countDownLatch) {
        this.response = response;
        this.asyncContext = request.startAsync();
        this.countDownLatch = countDownLatch;
    }

    public void onEvent(EventSource eventSource, String id, String type, String data) {
        try {
            log.info("OpenAI返回数据：{}", data);
            if ("[DONE]".equals(data)) {
                log.info("OpenAI返回数据结束了");
                countDownLatch.countDown();
//                response.flushBuffer();
            }

            // 将数据作为text/event-stream格式发送到前端
            response.setContentType("text/event-stream");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(data);
//            response.flushBuffer();

//            response.getWriter().println(data);
//            response.flushBuffer();

            // 触发异步上下文的完成
//            asyncContext.complete();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}

