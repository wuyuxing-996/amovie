package com.wyx.amovie.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyx.amovie.entity.Movie;
import com.wyx.amovie.entity.MovieScore;
import com.wyx.amovie.entity.ReviewVo;
import com.wyx.amovie.entity.Scene;
import com.wyx.amovie.service.MovieService;
import com.wyx.amovie.service.ReviewService;
import com.wyx.amovie.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author wyx
 * @date 2019-08-28 09:03
 */
@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private SceneService sceneService;

    @Autowired
    private ReviewService reviewService;


    @RequestMapping(value = "/movie-list")
    public String movieList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "3") Integer size,
                            Model model) {
        Page<MovieScore> movies = PageHelper.startPage(page, size).doSelectPage(() -> movieService.getAll());
        model.addAttribute("movies", movies.toPageInfo());
        return "movie-list";
    }

    @RequestMapping("/movie/{id}")
    public String getOneMovie(@PathVariable(value = "id") Integer id, Model model) {
        Movie movie = movieService.getById(id);
        List<Scene> scenes = sceneService.getSceneCount(id);
        List<ReviewVo> reviews = reviewService.getMovieReview(id);
        model.addAttribute("reviews", reviews);
        model.addAttribute("movie", movie);
        model.addAttribute("scenes", scenes);
        return "movie";
    }

    @GetMapping("/rate")
    public String getMovieScore(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "5") Integer size,
                                Model model) {
        Page<MovieScore> movieScores = PageHelper.startPage(page, size).doSelectPage(() -> movieService.getMovieScore());
        model.addAttribute("movies", movieScores.toPageInfo());
        return "rate";
    }
}
