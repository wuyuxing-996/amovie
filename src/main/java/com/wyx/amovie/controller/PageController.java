package com.wyx.amovie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wyx
 * @date 2019-08-22 21:49
 */
@Controller
public class PageController {

    @RequestMapping(value = "/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/test")
    public String test() {
        return "register";
    }
}
