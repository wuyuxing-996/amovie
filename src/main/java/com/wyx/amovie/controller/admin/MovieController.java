package com.wyx.amovie.controller.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyx.amovie.entity.Movie;
import com.wyx.amovie.entity.MovieForm;
import com.wyx.amovie.entity.Scene;
import com.wyx.amovie.service.MovieService;
import com.wyx.amovie.service.SceneService;
import com.wyx.amovie.utils.Msg;
import com.wyx.amovie.utils.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * @author wyx
 */
@CrossOrigin
@Controller
@RequestMapping(value = "/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private SceneService sceneService;

    @GetMapping
    public ResponseEntity getMovie(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "20") Integer size) {
        Page<Movie> movies = PageHelper.startPage(page, size).doSelectPage(() -> movieService.getAll());
        return new ResponseEntity(movies.toPageInfo(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Movie movie = movieService.getById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "{id}/scenes")
    public ResponseEntity getSceneCount(@PathVariable(value = "id") Integer id) {
        List<Scene> scenes = sceneService.getSceneCount(id);
        return ResponseEntity.ok(scenes);
    }

    @GetMapping(value = "/released")
    public ResponseEntity getMovies() {
        List<Movie> movies = movieService.getMovieReleased();
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity addMovie(@RequestBody MovieForm movieForm) {
        Movie movie = toMovie(movieForm);
        Integer[] categoryIds = movieForm.getCategoryIds();
        int result = movieService.addMovie(movie, categoryIds);
        return Result.checkAdd(result);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity updateMovie(@PathVariable(value = "id") Integer id,
                                      @RequestBody MovieForm movieForm) {
        Movie movie = toMovie(movieForm);
        Movie movie1 = movieService.getById(id);
        if (movie1 == null) {
            Msg msg = Msg.fail().add("原因", "该电影不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        movie.setId(id);
        Integer[] categoryIds = movieForm.getCategoryIds();
        int result = movieService.updateMovie(movie);
        if (result != 0) {
            return ResponseEntity.ok(Msg.success());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteMovie(@PathVariable(value = "id") Integer id) {
        Movie movie = movieService.getById(id);
        if (movie == null) {
            Msg msg = Msg.fail().add("原因", "该电影不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        int result = movieService.deleteMovie(id);
        if (result != 0) {
            return ResponseEntity.ok(Msg.success());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * MovieForm对象转到Movie
     *
     * @param movieForm
     * @return
     */
    Movie toMovie(MovieForm movieForm) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieForm, movie);
        //TODO 时间转换
        movie.setName(movieForm.getMovieName());
        movie.setReleaseDate(new Date());
        return movie;
    }
}
