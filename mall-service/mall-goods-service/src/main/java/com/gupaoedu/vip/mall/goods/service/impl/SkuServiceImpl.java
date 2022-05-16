package com.gupaoedu.vip.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.vip.mall.goods.mapper.AdItemsMapper;
import com.gupaoedu.vip.mall.goods.mapper.SkuMapper;
import com.gupaoedu.vip.mall.goods.model.AdItems;
import com.gupaoedu.vip.mall.goods.model.Sku;
import com.gupaoedu.vip.mall.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author wqz
 * @since 2022-04-27
 */
@Service
@CacheConfig(cacheNames = "ad-items-skus")
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements SkuService {

    @Autowired
    private AdItemsMapper adItemsMapper;

    @Autowired
    private SkuMapper skuMapper;

    /***
     * 根据推广产品分类ID查询指定分类下的产品列表
     * @param id
     * @return
     * ad-items-skus::1
     */
    //@Cacheable(cacheNames = "ad-items-skus",key ="#id" )
    @Cacheable(key ="#id" )
    @Override
    public List<Sku> typeSkuItems(Integer id) {
        //1.查询当前分类下的所有列表信息
        QueryWrapper<AdItems> adItemsQueryWrapper = new QueryWrapper<AdItems>();
        adItemsQueryWrapper.eq("type",id);
        List<AdItems> adItems = adItemsMapper.selectList(adItemsQueryWrapper);

        //2.根据推广列表查询产品列表信息
        List<String> skuids = adItems.stream().map(adItem->adItem.getSkuId()).collect(Collectors.toList());
        return skuids==null || skuids.size()<=0? null : skuMapper.selectBatchIds(skuids);
    }

    /***
     * 根据分类id删除指定推广数据
     * @param id
     * @return
     */
    //@CacheEvict(cacheNames = "ad-items-skus",key ="#id" )
    @CacheEvict(key ="#id" )
    @Override
    public void delTypeSkuItems(Integer id) {}

    /****
     * 修改缓存
     * @param id
     * @return
     */
    //@CachePut(cacheNames = "ad-items-skus",key = "#id")
    @CachePut(key = "#id")
    @Override
    public List<Sku> updateTypeSkuItems(Integer id) {
        //1.查询当前分类下的所有列表信息
        QueryWrapper<AdItems> adItemsQueryWrapper = new QueryWrapper<AdItems>();
        adItemsQueryWrapper.eq("type",id);
        List<AdItems> adItems = adItemsMapper.selectList(adItemsQueryWrapper);

        //2.根据推广列表查询产品列表信息
        List<String> skuids = adItems.stream().map(adItem->adItem.getSkuId()).collect(Collectors.toList());
        return skuids==null || skuids.size()<=0? null : skuMapper.selectBatchIds(skuids);
    }
}
