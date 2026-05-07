package com.ruigou.mall.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruigou.mall.goods.mapper.SkuAttributeMapper;
import com.ruigou.mall.goods.model.SkuAttribute;
import com.ruigou.mall.goods.service.SkuAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkuAttributeServiceImpl extends ServiceImpl<SkuAttributeMapper, SkuAttribute> implements SkuAttributeService {

    @Autowired
    SkuAttributeMapper skuAttributeMapper;
    /***
     * 根据分类ID查询属性集合
     * @param id
     * @return
     */
    @Override
    public List<SkuAttribute> queryList(Integer id) {
        return skuAttributeMapper.queryByCategoryId(id);
    }
}
