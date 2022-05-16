package com.gupaoedu.vip.mall.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gupaoedu.vip.mall.goods.model.Category;

import java.util.List;

/**
 * <p>
 * 商品类目 服务类
 * </p>
 *
 * @author wqz
 * @since 2022-04-27
 */
public interface CategoryService extends IService<Category> {
    /***
     * 根据分类父ID查询所有子类
     */
    List<Category> findByParentId(Integer pid);
}
