package com.ruigou.mall.goods.controller;

import com.ruigou.mall.goods.model.Category;
import com.ruigou.mall.goods.service.CategoryService;
import com.ruigou.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /****
     * 根据父ID查询子分类
     */
    @GetMapping(value = "/parent/{pid}")
    public RespResult<List<Category>> list(@PathVariable(value = "pid")Integer pid){
        List<Category> categories = categoryService.queryByParentId(pid);
        return RespResult.ok(categories);
    }
}