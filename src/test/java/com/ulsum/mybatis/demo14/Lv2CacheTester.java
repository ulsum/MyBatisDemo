package com.ulsum.mybatis.demo14;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import com.ulsum.mybatis.demo3.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Lv2CacheTester {

    @Test
    public void testLv2Cache() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            Goods goods1 = sqlSession.selectOne("goods.selectById", 1603);
            System.out.println(goods1.getTitle() + " - " + goods1);
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

        try {
            sqlSession = MyBatisUtil.openSession();
            Goods goods2 = sqlSession.selectOne("goods.selectById", 1603);
            System.out.println(goods2.getTitle() + " - " + goods2);
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
