package com.wyx.amovie.controller;

import com.wyx.amovie.entity.MovieScore;
import com.wyx.amovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author wyx
 * @date 2019-08-30 16:05
 */
@Controller
public class SearchController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/byTitle/{keyword}")
    public String searchByName(@PathVariable(value = "keyword") String keyword,
                               Model model) {
        List<MovieScore> movies = movieService.getByName(keyword.replaceAll(" ", ""));
        model.addAttribute("movies", movies);
        return "search";
    }

    @GetMapping(value = "/byDirector/{keyword}")
    public String searchByDirector(@PathVariable(value = "keyword") String keyword,
                                   Model model) {
        List<MovieScore> movies = movieService.getByDirector(keyword.replaceAll(" ", ""));
        model.addAttribute("movies", movies);
        return "search";
    }

    @GetMapping(value = "/byActors/{keyword}")
    public String searchByActors(@PathVariable(value = "keyword") String keyword,
                                 Model model) {
        List<MovieScore> movies = movieService.getByActor(keyword.replaceAll(" ", ""));
        model.addAttribute("movies", movies);
        return "search";
    }

    @GetMapping(value = "/byCountry/{keyword}")
    public String searchByCountry(@PathVariable(value = "keyword") String keyword,
                                  Model model) {
        List<MovieScore> movies = movieService.getByCountry(keyword.replaceAll(" ", ""));
        model.addAttribute("movies", movies);
        return "search";
    }

    @GetMapping(value = "/byCategory/{keyword}")
    public String searchByCategory(@PathVariable(value = "keyword") String keyword,
                                   Model model) {
        List<MovieScore> movies = movieService.getByCategory(keyword.replaceAll(" ", ""));
        model.addAttribute("movies", movies);
        return "search";
    }
}
