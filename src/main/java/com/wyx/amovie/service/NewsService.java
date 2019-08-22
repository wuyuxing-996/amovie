package com.wyx.amovie.service;

import com.wyx.amovie.entity.News;

import java.util.List;

/**
 * @author wyx
 */
public interface NewsService {

    /**
     * 获取所有资讯
     *
     * @return
     */
    List<News> getAll();

    /**
     * 根据id获取资讯
     *
     * @param id
     * @return
     */
    News getById(Integer id);

    /**
     * 添加资讯
     *
     * @param news
     * @return
     */
    int addNews(News news);

    /**
     * 更新资讯
     *
     * @param news
     * @return
     */
    int updateNews(News news);

    /**
     * 删除资讯
     *
     * @param id
     * @return
     */
    int deleteNews(Integer id);
}
