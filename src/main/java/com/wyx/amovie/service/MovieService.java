package com.wyx.amovie.service;

import com.wyx.amovie.entity.Movie;
import com.wyx.amovie.entity.MovieScore;

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
    List<MovieScore> getByName(String name);

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
    List<MovieScore> getUserMovie(Integer userId);

    /**
     * 获取电影及评分
     *
     * @return
     */
    List<MovieScore> getMovieScore();

    /**
     * 根据导演查电影
     *
     * @param director
     * @return
     */
    List<MovieScore> getByDirector(String director);

    /**
     * 根据演员查电影
     *
     * @param actor
     * @return
     */
    List<MovieScore> getByActor(String actor);

    /**
     * 根据国家查电影
     *
     * @param country
     * @return
     */
    List<MovieScore> getByCountry(String country);

    /**
     * 获取已经上映电影及其评分
     *
     * @return
     */
    List<MovieScore> getMovieScoreReleased();

    /**
     * 根据类型名称查询电影
     *
     * @param category
     * @return
     */
    List<MovieScore> getByCategory(String category);
}
