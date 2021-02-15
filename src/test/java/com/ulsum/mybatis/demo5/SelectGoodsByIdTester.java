package com.ulsum.mybatis.demo5;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import com.ulsum.mybatis.demo3.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 一个参数
 */
public class SelectGoodsByIdTester {

    @Test
    public void testSelectGoodsById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            Goods goods = sqlSession.selectOne("goods.selectById", 1608);
            System.out.println(goods.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSession(sqlSession);
            }
        }
    }

}
