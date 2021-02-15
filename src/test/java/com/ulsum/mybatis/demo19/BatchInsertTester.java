package com.ulsum.mybatis.demo19;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import com.ulsum.mybatis.demo3.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BatchInsertTester {

    @Test
    public void testBatchInsert() {
        SqlSession sqlSession = null;
        List list = new ArrayList();
        try {
            sqlSession = MyBatisUtil.openSession();
            for (int i = 0; i < 10000; i++) {
                Goods goods = new Goods();
                goods.setTitle("测试商品");
                goods.setTitle("测试商品");
                goods.setSubTitle("测试子标题");
                goods.setOriginalCost(200f);
                goods.setCurrentPrice(100f);
                goods.setDiscount(0.5f);
                goods.setIsFreeDelivery(1);
                goods.setCategoryId(43);
                //insert()方法返回值代表本次成功插入的记录总数
                list.add(goods);
            }
            sqlSession.insert("goods.batchInsert", list);
            sqlSession.commit();
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

    @Test
    public void testBatchDelete() {
        SqlSession sqlSession = null;
        List list = new ArrayList();
        try {
            sqlSession = MyBatisUtil.openSession();
            list.add(1920);
            list.add(1921);
            list.add(1922);
            sqlSession.delete("goods.batchDelete", list);
            sqlSession.commit();
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
