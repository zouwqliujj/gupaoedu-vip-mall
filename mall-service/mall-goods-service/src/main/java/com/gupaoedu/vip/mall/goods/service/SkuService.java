package com.gupaoedu.vip.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.goods.model.Sku;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author wqz
 * @since 2022-04-27
 */
public interface SkuService extends IService<Sku> {
    List<Sku> typeSkuItems(Integer id);

    void delTypeSkuItems(Integer id);

    List<Sku> updateTypeSkuItems(Integer id);

}
