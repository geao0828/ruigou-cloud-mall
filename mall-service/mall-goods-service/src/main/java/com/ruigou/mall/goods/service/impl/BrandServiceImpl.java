package com.ruigou.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruigou.mall.goods.Brand;
import com.ruigou.mall.goods.mapper.BrandMapper;
import com.ruigou.mall.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /****
     * 多条件查询
     * @param brand
     * @return
     */
    @Override
    public List<Brand> queryList(Brand brand) {
        // 多条件构造器
        if(brand == null){
            return brandMapper.selectList(null);
        }

        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
        if(!StringUtils.isEmpty(brand.getName())){
            queryWrapper.like("name",brand.getName());
        }
        if(!StringUtils.isEmpty(brand.getInitial())){
            queryWrapper.eq("initial",brand.getInitial());
        }
        return brandMapper.selectList(queryWrapper);
    }

    /***
     * 分页查询
     * @param brand
     * @return
     */
    @Override
    public Page<Brand> queryPageList(Long currentPage, Long size, Brand brand) {
        // 1. 先判断 brand 是否为 null，避免空指针
        if (brand == null) {
            brand = new Brand();
        }

        // 2. 构建分页和条件
        Page<Brand> page = new Page<>(currentPage, size);
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();

        // 3. 只有 name 不为空时，才加 like 条件
        if (!StringUtils.isEmpty(brand.getName())) {
            queryWrapper.like("name", brand.getName());
        }

        // 4. 执行查询
        return brandMapper.selectPage(page, queryWrapper);
    }

    /***
     * 根据分类ID查询品牌
     * @param id
     * @return
     */
    @Override
    public List<Brand> queryByCategoryId(Integer id) {
        //查询分类ID对应的品牌集合
        List<Integer> brandIds = brandMapper.queryBrandIds(id);
        //根据品牌ID集合查询品牌信息
        List<Brand> brands = brandMapper.selectBatchIds(brandIds);
        return brands;
    }
}