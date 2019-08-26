package com.wyx.amovie.controller.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyx.amovie.entity.News;
import com.wyx.amovie.service.NewsService;
import com.wyx.amovie.utils.Msg;
import com.wyx.amovie.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author wyx
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public ResponseEntity getCategory(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "20") Integer size) {
        Page<News> news = PageHelper.startPage(page, size)
                .doSelectPage(() -> newsService.getAll());
        return new ResponseEntity(news.toPageInfo(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        News news = newsService.getById(id);
        return Result.checkObject(news);
    }

    @PostMapping
    public ResponseEntity addNews(@RequestBody News news) {
        news.setCreateTime(new Date());
        int result = newsService.addNews(news);
        return Result.checkAdd(result);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity updateCategory(@PathVariable(value = "id") Integer id,
                                         @RequestBody News news) {
        News news1 = newsService.getById(id);
        if (news1 == null) {
            Msg msg = Msg.fail().add("原因", "该资讯不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        news.setId(id);
        news.setCreateTime(new Date());
        int result = newsService.updateNews(news);
        return Result.checkUpdate(result);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteCategory(@PathVariable(value = "id") Integer id) {
        News news = newsService.getById(id);
        if (news == null) {
            Msg msg = Msg.fail().add("原因", "该资讯不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        int result = newsService.deleteNews(id);
        return Result.checkDelete(result);
    }
}
