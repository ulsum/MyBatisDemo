package com.ulsum.mybatis.demo10;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import com.ulsum.mybatis.demo3.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class InsertTester {

    @Test
    public void testInsert(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            Goods goods = new Goods();
            goods.setTitle("测试商品");
            goods.setSubTitle("测试子标题");
            goods.setOriginalCost(200f);
            goods.setCurrentPrice(100f);
            goods.setDiscount(0.5f);
            goods.setIsFreeDelivery(1);
            goods.setCategoryId(43);
            //insert()方法返回值代表本次成功插入的记录总数
            int num = sqlSession.insert("goods.insert", goods);
            sqlSession.commit();//提交事务数据
            System.out.println("" + goods.getGoodsId());
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null){
                sqlSession.rollback();  // 回滚
            }
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSession(sqlSession);
            }
        }
    }

}
