package com.ulsum.mybatis.demo15;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class OneToManyTester {

    @Test
    public void testOneToMany() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            List<GoodsGoodsDetailDTO> list = sqlSession.selectList("goods.selectOneToMany");
            for (GoodsGoodsDetailDTO goods: list){
                System.out.println(goods.getGoods().getTitle() + " : " + goods.getGoodsDetailList().size());
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
