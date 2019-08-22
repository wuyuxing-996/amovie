package com.wyx.amovie.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyx.amovie.entity.Category;
import com.wyx.amovie.service.CategoryService;
import com.wyx.amovie.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author wyx
 */
@RestController
@RequestMapping(value = "/categories")
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity getCategory(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "2") Integer size) {
        Page<Category> categories = PageHelper.startPage(page, size)
                .doSelectPage(() -> categoryService.getAll());
        return new ResponseEntity(categories.toPageInfo(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Category category = categoryService.getById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity addCategory(@RequestBody Category category) {
        if (categoryService.getByName(category.getName()) != null) {
            Msg msg = Msg.fail().add("原因", "该类型已经存在！");
            return new ResponseEntity(msg, HttpStatus.ALREADY_REPORTED);
        }
        if (categoryService.addCategory(category) != 0) {
            return ResponseEntity.ok(Msg.success());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity updateCategory(@PathVariable(value = "id") Integer id,
                                         @RequestBody Category category) {
        Category category1 = categoryService.getById(id);
        if (category1 == null) {
            Msg msg = Msg.fail().add("原因", "该类型不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        category.setId(id);
        int result = categoryService.updateCategory(category);
        if (result != 0) {
            return ResponseEntity.ok(Msg.success());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteCategory(@PathVariable(value = "id") Integer id) {
        Category category = categoryService.getById(id);
        if (category == null) {
            Msg msg = Msg.fail().add("原因", "该类型不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        int result = categoryService.deleteCategory(id);
        if (result != 0) {
            return ResponseEntity.ok(Msg.success());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
