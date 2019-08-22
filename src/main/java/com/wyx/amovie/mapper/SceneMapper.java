package com.wyx.amovie.mapper;

import com.wyx.amovie.entity.Scene;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wyx
 */
@Repository
@Mapper
public interface SceneMapper {

    /**
     * 查询所有场次
     *
     * @return
     */
    @Select("select * from scene")
    List<Scene> getAll();

    /**
     * 根据id查询场次
     *
     * @param id
     * @return
     */
    @Select("select * from scene where id=#{id}")
    Scene getById(Integer id);

    /**
     * 获取某电影场次
     *
     * @param movieId
     * @return
     */
    @Select(("select * from scene where movie_id=#{movieId}"))
    List<Scene> getSceneCount(Integer movieId);

    /**
     * 添加场次
     *
     * @param scene
     * @return
     */
    @Insert("insert into scene(movie_id,movie_name,price,seat_num,showtime,booked_seat)" +
            " values(#{movieId},#{movieName},#{price},#{seatNum},#{showtime},#{bookedSeat})")
    int addScene(Scene scene);

    /**
     * 更新场次
     *
     * @param scene
     * @return
     */
    @Update("update scene set movie_id=#{movieId},movie_name=#{movieName},price=#{price}" +
            ",seat_num=#{seatNum},showtime=#{showtime},booked_seat=#{bookedSeat} where id=#{id}")
    int updateScene(Scene scene);

    /**
     * 删除场次
     *
     * @param id
     * @return
     */
    @Delete("delete from scene where id=#{id}")
    int deleteScene(Integer id);
}
