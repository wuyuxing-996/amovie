package com.wyx.amovie.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyx.amovie.entity.News;
import com.wyx.amovie.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wyx
 * @date 2019-08-30 14:58
 */
@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/news-list")
    public String getNews(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "3") Integer size,
            Model model) {
        Page<News> newsList = PageHelper.startPage(page, size)
                .doSelectPage(() -> newsService.getAll());
        model.addAttribute("newsList", newsList.toPageInfo());
        return "news-list";
    }

    @GetMapping(value = "/news/{id}")
    public String getNewsById(@PathVariable(value = "id") Integer id, Model model) {
        News news = newsService.getById(id);
        model.addAttribute(news);
        return "news";
    }
}
