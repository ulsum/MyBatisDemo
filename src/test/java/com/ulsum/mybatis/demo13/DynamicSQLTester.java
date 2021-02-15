package com.ulsum.mybatis.demo13;

import com.oracle.tools.packager.mac.MacAppBundler;
import com.ulsum.mybatis.demo2.MyBatisUtil;
import com.ulsum.mybatis.demo3.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicSQLTester {

    @Test
    public void testDynamicSQL() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            Map param = new HashMap();
            param.put("categoryId", 44);
            param.put("currentPrice", 500);
            List<Goods> list = sqlSession.selectList("goods.dynamicSQL", param);
            for (Goods goods : list) {
                System.out.println(goods.getTitle());
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
