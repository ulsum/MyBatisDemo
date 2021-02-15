package com.ulsum.mybatis.demo14;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import com.ulsum.mybatis.demo3.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Lv1CacheTester {

    @Test
    public void testLv1Cache() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            Goods goods1 = sqlSession.selectOne("goods.selectById", 1603);
            Goods goods2 = sqlSession.selectOne("goods.selectById", 1603);
            System.out.println(goods1.getTitle() + " - " + goods1);       // goods1和goods2地址是一样的
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

        try {
            sqlSession = MyBatisUtil.openSession();
            Goods goods3 = sqlSession.selectOne("goods.selectById", 1603);
            Goods goods4 = sqlSession.selectOne("goods.selectById", 1603);
            System.out.println(goods3.getTitle() + " - " + goods3);       // goods3和goods4地址是一样的，但与goods1不一样
            System.out.println(goods4.getTitle() + " - " + goods4);
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
            Goods goods5 = sqlSession.selectOne("goods.selectById", 1603);
            sqlSession.commit();
            Goods goods6 = sqlSession.selectOne("goods.selectById", 1603);
            System.out.println(goods5.getTitle() + " - " + goods5);     // goods5和goods6地址不一样，因为commit()之后缓存被清
            System.out.println(goods6.getTitle() + " - " + goods6);
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
