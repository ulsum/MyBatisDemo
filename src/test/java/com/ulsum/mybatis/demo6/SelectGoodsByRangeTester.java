package com.ulsum.mybatis.demo6;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import com.ulsum.mybatis.demo3.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多个参数
 */
public class SelectGoodsByRangeTester {

    @Test
    public void testSelectGoodsByRange() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            Map param = new HashMap();
            param.put("min", 100);
            param.put("max", 1000);
            param.put("limit", 10);
            List<Goods> list = sqlSession.selectList("goods.selectByPriceRange", param);
            for (Goods goods : list) {
                System.out.println(goods.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSession(sqlSession);
            }
        }
    }

}
