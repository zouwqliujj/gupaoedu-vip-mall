package com.gupaoedu.vip.mall.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wqz
 * @since 2022-04-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "ad_items")
public class AdItems implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    /**
     * 分类，1首页推广,2列表页推广
     */
    private Integer type;

    /**
     * 展示的产品
     */
    private String skuId;

    /**
     * 排序
     */
    private Integer sort;


}
