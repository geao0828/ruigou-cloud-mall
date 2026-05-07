package com.ruigou.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruigou.mall.goods.model.Product;
import com.ruigou.mall.goods.model.Spu;

public interface SpuService extends IService<Spu> {
    //保存商品
    void saveProduct(Product product);
}