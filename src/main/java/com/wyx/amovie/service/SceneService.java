package com.wyx.amovie.service;

import com.wyx.amovie.entity.Scene;

import java.util.List;

/**
 * @author wyx
 */
public interface SceneService {

    /**
     * 查询所有场次
     *
     * @return
     */
    List<Scene> getAll();

    /**
     * 根据id查询场次
     *
     * @param id
     * @return
     */
    Scene getById(Integer id);

    /**
     * 添加场次
     *
     * @param scene
     * @return
     */
    int addScene(Scene scene);

    /**
     * 更新场次
     *
     * @param scene
     * @return
     */
    int updateScene(Scene scene);

    /**
     * 删除场次
     *
     * @param id
     * @return
     */
    int deleteScene(Integer id);

    /**
     * 获取电影场次
     *
     * @param movieId
     * @return
     */
    List<Scene> getSceneCount(Integer movieId);
}
