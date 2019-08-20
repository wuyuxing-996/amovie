package com.wyx.amovie.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器的自定义实现类
 */
public class ItemExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object object,
                                         Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        //判断异常
        if (e instanceof MessageException) {
            MessageException me = (MessageException) e;
            modelAndView.addObject("error", me.getMessage());
        } else {
            modelAndView.addObject("error", "未知异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
