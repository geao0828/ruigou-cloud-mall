package com.ruigou.mall.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruigou.mall.goods.Brand;
import com.ruigou.mall.goods.service.BrandService;
import com.ruigou.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /***
     * 增加品牌
     */
    @PostMapping
    public RespResult add(@RequestBody Brand brand){
        // 增加品牌
        brandService.save(brand);
        return RespResult.ok();
    }

    /****
     * 修改
     */
    @PutMapping
    public RespResult update(@RequestBody Brand brand){
        //修改品牌
        brandService.updateById(brand);
        return RespResult.ok();
    }

    /****
     * 删除品牌
     */
    @DeleteMapping("/{id}")
    public RespResult delete(@PathVariable(value = "id") Integer id){
        //删除品牌
        brandService.removeById(id);
        return RespResult.ok();
    }

    /****
     * 条件查询
     */
    @PostMapping(value = "/list")
    public RespResult<List<Brand>> list(@RequestBody(required = false) Brand brand){
        // 查询
        List<Brand> brands = brandService.queryList(brand);
        return RespResult.ok(brands);
    }

    /****
     * 条件分页查询
     */
    @PostMapping(value = "/list/{page}/{size}")
    public RespResult<Page<Brand>> list(
            @PathVariable(value = "page")Long currentPage,
            @PathVariable(value = "size")Long size,
            @RequestBody(required = false) Brand brand){
        // 分页查询
        Page<Brand> brandPage = brandService.queryPageList(currentPage,size,brand);
        return RespResult.ok(brandPage);
    }

    /****
     * 根据分类ID查询品牌
     */
    @GetMapping(value = "/category/{id}")
    public RespResult<List<Brand>> categoryBrands(@PathVariable(value = "id")Integer id){
        List<Brand> brands = brandService.queryByCategoryId(id);
        return RespResult.ok(brands);
    }
}