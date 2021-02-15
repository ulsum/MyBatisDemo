package com.ulsum.mybatis.demo2;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * MyBatisUtils工具类,创建全局唯一的SqlSessionFactory对象
 */
public class MyBatisUtil {
    // 利用static(静态)属于类不属于对象,且全局唯一
    private static SqlSessionFactory sqlSessionFactory = null;

    // 利用静态块在初始化类时实例化sqlSessionFactory
    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            // 初始化错误时,通过抛出异常ExceptionInInitializerError通知调用者
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    public static void closeSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
