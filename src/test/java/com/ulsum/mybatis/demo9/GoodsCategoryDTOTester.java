package com.ulsum.mybatis.demo9;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class GoodsCategoryDTOTester {

    @Test
    public void testGoodsCategoryDTO(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            List<GoodsDTO> list = sqlSession.selectList("goods.selectGoodsCategoryDTO");
            for (GoodsDTO dto : list) {
                System.out.println(dto.getGoods().getTitle());
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
