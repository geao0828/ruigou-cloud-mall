package com.ruigou.mall.goods.controller;

import com.ruigou.mall.goods.model.Product;
import com.ruigou.mall.goods.service.SpuService;
import com.ruigou.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SpuController {

    @Autowired
    private SpuService spuService;

    /***
     * 保存
     */
    @PostMapping(value = "/save")
    public RespResult save(@RequestBody Product product){
        //保存
        spuService.saveProduct(product);
        return RespResult.ok();
    }
}
