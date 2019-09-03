package com.wyx.amovie.mapper;

import com.wyx.amovie.entity.Movie;
import com.wyx.amovie.entity.MovieScore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieMapperTest {

    @Autowired
    private MovieMapper movieMapper;

    @Test
    public void getAll() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void addMovie() {
    }

    @Test
    public void getByName() {
    }

    @Test
    public void updateMovie() {
    }

    @Test
    public void deleteMovie() {
    }

    @Test
    public void getByCategoryId() {
        List<Movie> movies = movieMapper.getByCategoryId(2);
        System.out.println(movies);
    }

    @Test
    public void getMovieScore() {
        List<MovieScore> movieScores = movieMapper.getMovieScore();
        System.out.println(movieScores);
    }

    @Test
    public void getByCategory() {
        List<MovieScore> movies = movieMapper.getByCategory("科幻");
        System.out.println(movies);
    }
}