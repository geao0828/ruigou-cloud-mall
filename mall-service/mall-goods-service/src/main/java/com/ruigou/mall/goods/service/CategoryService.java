package com.ruigou.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruigou.mall.goods.model.Category;

import java.util.List;

public interface CategoryService extends IService<Category> {

    /**
     * 根据父ID查询子分类
     * @param pid
     * @return
     */
    List<Category> queryByParentId(Integer pid);
}