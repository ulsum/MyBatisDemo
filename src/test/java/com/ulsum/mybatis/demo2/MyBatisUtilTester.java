package com.ulsum.mybatis.demo2;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;

public class MyBatisUtilTester {

    @Test
    public void testOpenSession() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (sqlSession!=null){
                MyBatisUtil.closeSession(sqlSession);
            }
        }
    }

}
