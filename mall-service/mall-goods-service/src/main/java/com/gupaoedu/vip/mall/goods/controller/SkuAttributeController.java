package com.gupaoedu.vip.mall.goods.controller;


import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.goods.model.SkuAttribute;
import com.gupaoedu.vip.mall.goods.service.SkuAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wqz
 * @since 2022-04-27
 */
@RestController
@RequestMapping("/sku-attribute")
@CrossOrigin
public class SkuAttributeController {
    @Autowired
    private SkuAttributeService skuAttributeService;

    /*****
     * 根据分类ID查询属性集合
     */
    @GetMapping(value = "/category/{id}")
    public RespResult<List<SkuAttributeController>> categorySkuAttributeList(@PathVariable(value = "id")Integer id){
        List<SkuAttribute> skuAttributes = skuAttributeService.queryList(id);
        return RespResult.ok(skuAttributes);
    }
}

