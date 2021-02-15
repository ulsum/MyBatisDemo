package com.ulsum.mybatis.demo16;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ManyToOneTester {

    @Test
    public void testOneToMany() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            List<GoodsDetailGoodsDTO> list = sqlSession.selectList("goodsDetail.selectManyToOne");
            for (GoodsDetailGoodsDTO dto:list){
                System.out.println(dto.getGoods().getTitle() + " - " + dto.getGoodsDetail().getGdPicUrl());
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSession(sqlSession);
            }
        }
    }

}
