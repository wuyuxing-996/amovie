package com.wyx.amovie.mapper;

import com.wyx.amovie.entity.Movie;
import org.apache.ibatis.annotations.*;
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
    @Select("select * from movie where name like CONCAT('%',#{name},'%')")
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
    @Delete("delete from movie where id=#{id}")
    int deleteMovie(Integer id);

    /**
     * 根据类别查电影
     *
     * @param id
     * @return
     */
    List<Movie> getByCategory(Integer id);

    /**
     * 获取上映电影
     *
     * @return
     */
    List<Movie> getMovieReleased(Integer status);

    /**
     * 获取某人收藏的所有电影
     *
     * @param userId
     * @return
     */
    List<Movie> getUserMovie(Integer userId);
}
