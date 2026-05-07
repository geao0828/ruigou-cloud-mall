package com.ruigou.mall.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruigou.mall.goods.Brand;

import java.util.List;

public interface BrandService extends IService<Brand> {

    /**
     * 条件查询
     * @param brand
     * @return
     */
    List<Brand> queryList(Brand brand);

    /**
     * 分页查询
     * @param currentPage
     * @param size
     * @param brand
     * @return
     */
    Page<Brand> queryPageList(Long currentPage, Long size, Brand brand);

    //根据分类ID查询品牌
    List<Brand> queryByCategoryId(Integer id);
}