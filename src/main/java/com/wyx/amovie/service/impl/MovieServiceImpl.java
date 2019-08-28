package com.wyx.amovie.service.impl;

import com.wyx.amovie.constant.Status;
import com.wyx.amovie.entity.Movie;
import com.wyx.amovie.mapper.CategoryMapper;
import com.wyx.amovie.mapper.MovieMapper;
import com.wyx.amovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wyx
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Movie> getAll() {
        return movieMapper.getAll();
    }

    @Override
    public Movie getById(Integer id) {
        return movieMapper.getById(id);
    }

    @Override
    public int addMovie(Movie movie, Integer[] categoryIds) {
        int result = movieMapper.addMovie(movie);
        int movieId = movie.getId();
        for (Integer categoryId : categoryIds) {
            categoryMapper.addCategoryForMovie(movieId, categoryId);
        }
        return result;
    }

    @Override
    public List<Movie> getByName(String name) {
        return movieMapper.getByName(name);
    }

    @Override
    public int updateMovie(Movie movie) {
        return movieMapper.updateMovie(movie);
    }

    @Override
    public int deleteMovie(Integer id) {
        int result = movieMapper.deleteMovie(id);
        int result1 = categoryMapper.deleteCategoryForMovie(id);
        return result + result1;
    }

    @Override
    public List<Movie> getMovieReleased() {
        return movieMapper.getMovieReleased(Status.ON);
    }

    @Override
    public List<Movie> getUserMovie(Integer userId) {
        return movieMapper.getUserMovie(userId);
    }
}
