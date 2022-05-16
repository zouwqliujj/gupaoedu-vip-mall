package com.gupaoedu.vip.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.vip.mall.goods.mapper.BrandMapper;
import com.gupaoedu.vip.mall.goods.model.Brand;
import com.gupaoedu.vip.mall.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /****
     * 条件查询
     * return List<Brand>
     */
    @Override
    public List<Brand> queryList(Brand brand) {
        QueryWrapper<Brand> queryWrapper=new QueryWrapper<Brand>();
        queryWrapper.like("name",brand.getName());
        queryWrapper.eq("initial",brand.getInitial());
        return brandMapper.selectList(queryWrapper);
    }
    /****
     * 条件分页查询
     * return Page<Brand>
     */
    @Override
    public Page<Brand> queryPageList(Brand brand, Long currentPage, Long size) {
        QueryWrapper<Brand> queryWrapper=new QueryWrapper<Brand>();
        queryWrapper.like("name",brand.getName());
        queryWrapper.eq("initial",brand.getInitial());
        return brandMapper.selectPage(new Page<Brand>(currentPage,size),queryWrapper);
    }
    /****
     * 根据分类ID查询品牌集合
     * @param id:分类ID
     * @return
     */
    @Override
    public List<Brand> queryByCategoryId(Integer id) {
        //根据分类ID查询品牌ID集合
        List<Integer> brandIds = brandMapper.queryBrandIds(id);
        //根据品牌ID集合查询品牌集合
        if(brandIds!=null && brandIds.size()>0){
            return brandMapper.selectList(new QueryWrapper<Brand>().in("id",brandIds));
        }
        return null;
    }
}
