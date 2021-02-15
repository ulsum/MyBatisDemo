package com.ulsum.mybatis.demo16;

import com.ulsum.mybatis.demo15.GoodsDetail;
import com.ulsum.mybatis.demo3.Goods;

public class GoodsDetailGoodsDTO {

    private GoodsDetail goodsDetail;
    private Goods goods;

    public GoodsDetail getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(GoodsDetail goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

}
