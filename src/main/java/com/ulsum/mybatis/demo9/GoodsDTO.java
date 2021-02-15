package com.ulsum.mybatis.demo9;

import com.ulsum.mybatis.demo3.Goods;

public class GoodsDTO {

    private Goods goods;
    private Category category;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
