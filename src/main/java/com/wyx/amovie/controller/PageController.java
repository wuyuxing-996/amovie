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
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/register")
    public String test() {
        return "register";
    }

    @RequestMapping(value = "/rate")
    public String rate() {
        return "rate";
    }

    @RequestMapping(value = "/news-list")
    public String newsList() {
        return "news-list";
    }

    @RequestMapping(value = "/404")
    public String error() {
        return "404";
    }
}
