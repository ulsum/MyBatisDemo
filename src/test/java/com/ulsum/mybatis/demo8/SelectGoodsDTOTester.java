package com.ulsum.mybatis.demo8;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SelectGoodsDTOTester {

    @Test
    public void testSelectGoodsDTO() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            List<GoodsDTO> list = sqlSession.selectList("goods.selectGoodsDTO");
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
