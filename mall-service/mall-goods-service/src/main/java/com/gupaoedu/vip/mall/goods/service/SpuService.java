package com.gupaoedu.vip.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.goods.model.Product;
import com.gupaoedu.vip.mall.goods.model.Spu;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wqz
 * @since 2022-04-27
 */
public interface SpuService extends IService<Spu> {
    /****
     * 产品保存
     */
    void saveProduct(Product product);
}
