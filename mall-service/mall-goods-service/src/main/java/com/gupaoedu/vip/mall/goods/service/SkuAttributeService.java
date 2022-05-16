package com.gupaoedu.vip.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.goods.model.SkuAttribute;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wqz
 * @since 2022-04-27
 */
public interface SkuAttributeService extends IService<SkuAttribute> {
    /***
     * 根据分类ID查询属性加集合
     */
    List<SkuAttribute> queryList(Integer id);
}
