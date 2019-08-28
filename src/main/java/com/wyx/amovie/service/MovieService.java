package com.wyx.amovie.service;

import com.wyx.amovie.entity.Movie;

import java.util.List;

/**
 * @author wyx
 */
public interface MovieService {

    /**
     * 获取所有电影
     *
     * @return
     */
    List<Movie> getAll();

    /**
     * 根据id获取电影
     *
     * @param id
     * @return
     */
    Movie getById(Integer id);

    /**
     * 添加电影
     * @param movie
     * @return
     */
    int addMovie(Movie movie, Integer[] categoryIds);

    /**
     * 根据名字查电影
     *
     * @param name
     * @return
     */
    List<Movie> getByName(String name);

    /**
     * 更新电影
     *
     * @param movie
     * @return
     */
    int updateMovie(Movie movie);

    /**
     * 删除电影
     *
     * @param id
     * @return
     */
    int deleteMovie(Integer id);

    /**
     * 获取上映电影
     *
     * @param
     * @return
     */
    List<Movie> getMovieReleased();

    /**
     * 获取某人收藏的电影
     *
     * @param userId
     * @return
     */
    List<Movie> getUserMovie(Integer userId);
}
