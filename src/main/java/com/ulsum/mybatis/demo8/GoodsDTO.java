package com.ulsum.mybatis.demo8;

import com.ulsum.mybatis.demo3.Goods;

/**
 * DTO是特殊的Java Bean，叫做数据传输对象（Data Transfer Object），作用是对原始的对象进行扩展，用于数据保存和传递
 */
public class GoodsDTO {

    private Goods goods;
    private String categoryName;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
