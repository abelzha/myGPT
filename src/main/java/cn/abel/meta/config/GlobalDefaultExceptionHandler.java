package cn.abel.meta.config;

import cn.abel.meta.vo.ResponseMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author junzhang27
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseMsg defaultErrorHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseMsg.errResponse("服务太火爆啦");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseMsg handleMissingServletRequestParameter(Exception e) {
        return ResponseMsg.errResponse("参数有误");
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseMsg handleHttpRequestMethodNotSupportedException(Exception e) {
        return ResponseMsg.errResponse("请求错误：" + e.getMessage());
    }
}
