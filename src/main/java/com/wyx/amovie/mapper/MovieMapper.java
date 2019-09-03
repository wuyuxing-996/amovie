package com.wyx.amovie.mapper;

import com.wyx.amovie.entity.Movie;
import com.wyx.amovie.entity.MovieScore;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wyx
 */
@Repository
@Mapper
public interface MovieMapper {

    /**
     * 查询所有电影
     *
     * @return
     */
    List<Movie> getAll();

    /**
     * 根据id查询电影
     *
     * @param id
     * @return
     */
    Movie getById(Integer id);

    /**
     * 添加电影
     *
     * @param movie
     * @return
     */
    @Insert("insert into movie(" +
            "name,duration,directors,actors,release_date,status,plot," +
            "poster,country)" +
            " values(#{name},#{duration},#{directors},#{actors},#{releaseDate}," +
            "#{status},#{plot},#{poster},#{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int addMovie(Movie movie);

    /**
     * 根据电影名查询
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
    @Delete("delete from movie where id=#{id}")
    int deleteMovie(Integer id);

    /**
     * 根据类别id查电影
     *
     * @param id
     * @return
     */
    List<Movie> getByCategoryId(Integer id);

    /**
     * 获取上映电影
     * @param status
     * @return
     */
    List<Movie> getMovieReleased(Integer status);

    /**
     * 获取某人收藏的所有电影
     *
     * @param userId
     * @return
     */
    List<MovieScore> getUserMovie(Integer userId);

    /**
     * 获取电影所有评分
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
     * 根据类型名称查询电影
     *
     * @param category
     * @return
     */
    List<MovieScore> getByCategory(String category);

    /**
     * 获取已经上映电影及其评分
     *
     * @param status
     * @return
     */
    List<MovieScore> getMovieScoreReleased(Integer status);
}
