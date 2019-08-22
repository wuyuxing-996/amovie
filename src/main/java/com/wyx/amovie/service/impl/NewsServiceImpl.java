package com.wyx.amovie.service.impl;

import com.wyx.amovie.entity.News;
import com.wyx.amovie.mapper.NewsMapper;
import com.wyx.amovie.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wyx
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> getAll() {
        return newsMapper.getAll();
    }

    @Override
    public News getById(Integer id) {
        return newsMapper.getById(id);
    }

    @Override
    public int addNews(News news) {
        return newsMapper.addNews(news);
    }

    @Override
    public int updateNews(News news) {
        return newsMapper.updateNews(news);
    }

    @Override
    public int deleteNews(Integer id) {
        return newsMapper.deleteNews(id);
    }
}
