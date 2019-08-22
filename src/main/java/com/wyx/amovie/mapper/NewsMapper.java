package com.wyx.amovie.mapper;


import com.wyx.amovie.entity.News;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wyx
 */
@Repository
@Mapper
public interface NewsMapper {

    /**
     * 查询所有资讯
     *
     * @return
     */
    @Select("select * from news")
    List<News> getAll();

    /**
     * 根据id查询资讯
     *
     * @param id
     * @return
     */
    @Select("select * from news where id=#{id}")
    News getById(Integer id);

    /**
     * 添加资讯
     *
     * @param news
     * @return
     */
    @Insert("insert into news(content,create_time) values(#{content},#{createTime})")
    int addNews(News news);

    /**
     * 更新资讯
     *
     * @param news
     * @return
     */
    @Update("update news set content=#{content},create_time=#{createTime} where id=#{id}")
    int updateNews(News news);

    /**
     * 删除资讯
     *
     * @param id
     * @return
     */
    @Delete("delete from news where id=#{id}")
    int deleteNews(Integer id);
}
