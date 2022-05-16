package com.gupaoedu.vip.mall.goods.controller;


import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.goods.model.Brand;
import com.gupaoedu.vip.mall.goods.model.Product;
import com.gupaoedu.vip.mall.goods.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wqz
 * @since 2022-04-27
 */
@RestController
@RequestMapping("/spu")
@CrossOrigin
public class SpuController {
    @Autowired
    private SpuService spuService;


    /*****
     * 产品保存
     */
    @PostMapping(value = "/save")
    public RespResult save(@RequestBody Product product){
        spuService.saveProduct(product);
        return RespResult.ok();
    }

    /*****
     * 产品保存
     */
    @PostMapping(value = "/list/{page}/{pagesize}")
    public RespResult save(@PathVariable(value = "page")Long page,
                           @PathVariable(value = "size")Long size,
                           @RequestBody Product product){
        spuService.saveProduct(product);
        return RespResult.ok();
    }
}

