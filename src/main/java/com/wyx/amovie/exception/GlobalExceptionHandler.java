package com.wyx.amovie.exception;

import com.wyx.amovie.utils.Msg;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器的自定义实现类
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler{

    @ExceptionHandler(value = Exception.class)
    public Msg resolveException(HttpServletRequest request,
                                HttpServletResponse response,
                                Object object,
                                Exception e) {
        Msg msg = new Msg();
        //判断异常
        if (e instanceof MessageException) {
            MessageException me = (MessageException) e;
            msg = Msg.fail().add("error",me.getMessage());
        } else {
            msg = Msg.fail().add("error", "未知异常！");
        }
        return msg;
    }
}
