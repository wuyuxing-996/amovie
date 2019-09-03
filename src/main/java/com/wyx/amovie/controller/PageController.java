package com.wyx.amovie.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyx.amovie.entity.MovieScore;
import com.wyx.amovie.entity.News;
import com.wyx.amovie.service.MovieService;
import com.wyx.amovie.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wyx
 * @date 2019-08-22 21:49
 */
@Controller
public class PageController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/")
    public String index(@RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "size", defaultValue = "6") Integer size,
                        Model model) {
        //首页top5
        Page<MovieScore> movies = PageHelper.startPage(page, size)
                .doSelectPage(() -> movieService.getMovieScore());
        model.addAttribute("movies", movies.toPageInfo());
        //首页已经上映
        Page<MovieScore> movieList = PageHelper.startPage(1, 8)
                .doSelectPage(() -> movieService.getMovieScoreReleased());
        model.addAttribute("movieList", movieList.toPageInfo());

        //首页底部推荐新闻
        Page<News> newsList = PageHelper.startPage(1, 3)
                .doSelectPage(() -> newsService.getAll());
        model.addAttribute("newsList", newsList.toPageInfo());

        return "index";
    }

    @RequestMapping(value = "/register")
    public String test() {
        return "register";
    }

    @RequestMapping(value = "/news-list")
    public String newsList() {
        return "news-list";
    }

    @RequestMapping(value = "/404")
    public String error() {
        return "error";
    }

    @RequestMapping(value = "/news")
    public String news() {
        return "news";
    }
}
