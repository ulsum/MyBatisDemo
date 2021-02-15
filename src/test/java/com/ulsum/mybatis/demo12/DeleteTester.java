package com.ulsum.mybatis.demo12;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DeleteTester {

    @Test
    public void testUpdate() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            int num = sqlSession.delete("goods.delete", 739);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();  // 回滚
            }
        } finally {
            if (sqlSession != null) {
                MyBatisUtil.closeSession(sqlSession);
            }
        }
    }

}
