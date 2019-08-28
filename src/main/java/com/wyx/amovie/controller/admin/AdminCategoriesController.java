package com.wyx.amovie.controller.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wyx.amovie.entity.Category;
import com.wyx.amovie.service.CategoryService;
import com.wyx.amovie.utils.Msg;
import com.wyx.amovie.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wyx
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/categories")
public class AdminCategoriesController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity getCategory(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "20") Integer size) {
        Page<Category> categories = PageHelper.startPage(page, size)
                .doSelectPage(() -> categoryService.getAll());
        return new ResponseEntity(categories.toPageInfo(), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity getAll() {
        List<Category> categories = categoryService.getAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        Category category = categoryService.getById(id);
        return Result.checkObject(category);
    }

    @PostMapping
    public ResponseEntity addCategory(@RequestBody Category category) {
        if (categoryService.getByName(category.getName()) != null) {
            Msg msg = Msg.fail().add("原因", "该类型已经存在！");
            return new ResponseEntity(msg, HttpStatus.ALREADY_REPORTED);
        }
        int result = categoryService.addCategory(category);
        return Result.checkAdd(result);
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
        return Result.checkUpdate(result);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteCategory(@PathVariable(value = "id") Integer id) {
        Category category = categoryService.getById(id);
        if (category == null) {
            Msg msg = Msg.fail().add("原因", "该类型不存在！");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        int result = categoryService.deleteCategory(id);
        return Result.checkDelete(result);
    }
}
