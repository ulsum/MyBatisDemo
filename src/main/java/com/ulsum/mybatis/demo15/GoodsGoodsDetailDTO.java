package com.ulsum.mybatis.demo15;

import com.ulsum.mybatis.demo3.Goods;

import java.util.List;

public class GoodsGoodsDetailDTO {

    private Goods goods;
    private List<GoodsDetail> goodsDetailList;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<GoodsDetail> getGoodsDetailList() {
        return goodsDetailList;
    }

    public void setGoodsDetailList(List<GoodsDetail> goodsDetailList) {
        this.goodsDetailList = goodsDetailList;
    }

}
