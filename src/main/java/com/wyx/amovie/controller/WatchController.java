package com.wyx.amovie.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyx.amovie.entity.Movie;
import com.wyx.amovie.entity.User;
import com.wyx.amovie.entity.Watch;
import com.wyx.amovie.service.MovieService;
import com.wyx.amovie.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author wyx
 * @date 2019-08-28 20:25
 */
@Controller
public class WatchController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private WatchService watchService;

    @GetMapping(value = "/watch")
    public String watchList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "size", defaultValue = "3") Integer size,
                            Model model, HttpSession session) {
        User user = (User) session.getAttribute("login");
        Page<Movie> movies = PageHelper.startPage(page, size).doSelectPage(() -> movieService.getUserMovie(user.getId()));
        model.addAttribute("movies", movies);
        model.addAttribute("pageNum", movies.getPageNum());
        return "watchlist";
    }

    @PostMapping(value = "/watch")
    public ResponseEntity addWatch(HttpSession session, Integer movieId) {
        User user = (User) session.getAttribute("login");
        Watch watch = new Watch();
        watch.setMovieId(movieId);
        watch.setUserId(user.getId());
        watch.setCreateTime(new Date());
        int result = watchService.addWatch(watch);
        if (result != 0) {
            return ResponseEntity.ok("添加成功！");
        }
        return ResponseEntity.ok("添加异常！");
    }

    @DeleteMapping(value = "/watch/{movieId}")
    public ResponseEntity deleteWatch(@PathVariable(value = "movieId") Integer movieId) {
        int result = watchService.deleteWatch(movieId);
        if (result != 0) {
            return ResponseEntity.ok("删除成功！");
        }
        return ResponseEntity.ok("删除异常！");
    }
}
