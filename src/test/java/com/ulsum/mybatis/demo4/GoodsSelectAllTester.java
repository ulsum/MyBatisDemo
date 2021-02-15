package com.ulsum.mybatis.demo4;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import com.ulsum.mybatis.demo3.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class GoodsSelectAllTester {

    @Test
    public void testGoodsSelectAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            List<Goods> list = sqlSession.selectList("goods.selectAll");
            for (Goods g:list){
                System.out.println(g.getGoodsId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null){
                MyBatisUtil.closeSession(sqlSession);
            }
        }
    }

}
