package com.wyx.amovie.mapper;


import com.wyx.amovie.entity.Watch;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wyx
 */
@Repository
@Mapper
public interface WatchMapper {

    /**
     * 查看所有清单
     *
     * @return
     */
    @Select("select * from watch")
    List<Watch> getAll();

    /**
     * 添加到列表
     *
     * @param watch
     * @return
     */
    @Insert("insert into `watch`(user_id, movie_id, create_time) values(#{userId},#{movieId},#{createTime})")
    int addWatch(Watch watch);

    /**
     * 从列表中删除
     *
     * @param movieId
     * @return
     */
    @Delete("delete from `watch` where movie_id=#{movieId}")
    int deleteWatch(Integer movieId);
}
