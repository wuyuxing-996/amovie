package com.wyx.amovie.mapper;


import com.wyx.amovie.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wyx
 */
@Repository
@Mapper
public interface CategoryMapper {

    /**
     * 查询所有类别
     *
     * @return
     */
    @Select("select * from category")
    List<Category> getAll();

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Select("select * from category where id=#{id}")
    Category getById(Integer id);

    /**
     * 添加类别
     *
     * @param category
     * @return
     */
    @Insert("insert into category(name) values(#{name})")
    int addCategory(Category category);

    /**
     * 根据内容查询
     *
     * @param name
     * @return
     */
    @Select("select * from category where name=#{name}")
    Category getByName(String name);

    /**
     * 更新类型
     *
     * @param category
     * @return
     */
    @Update("update category set name=#{name} where id=#{id}")
    int updateCategory(Category category);

    /**
     * 删除类型
     *
     * @param id
     * @return
     */
    @Delete("delete from category where id=#{id}")
    int deleteCategory(Integer id);

    /**
     * 添加电影和类别的关系
     *
     * @param movieId
     * @param categoryId
     * @return
     */
    @Insert("insert into movie_category(movie_id,category_id) values(#{movieId},#{categoryId})")
    int addCategoryForMovie(Integer movieId, Integer categoryId);

    /**
     * 删除电影时，同步删除类别
     *
     * @param movieId
     * @return
     */
    @Delete("delete from movie_category where movie_id=#{movieId}")
    int deleteCategoryForMovie(Integer movieId);

}
