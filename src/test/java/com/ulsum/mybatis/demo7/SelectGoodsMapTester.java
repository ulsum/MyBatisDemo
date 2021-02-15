package com.ulsum.mybatis.demo7;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectGoodsMapTester {

    @Test
    public void testSelectGoodsMap() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            List<Map> list = sqlSession.selectList("goods.selectGoodsMap");
            for (Map map : list) {
                System.out.println(map);
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
