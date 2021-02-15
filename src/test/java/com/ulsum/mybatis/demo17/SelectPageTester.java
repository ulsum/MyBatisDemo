package com.ulsum.mybatis.demo17;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ulsum.mybatis.demo2.MyBatisUtil;
import com.ulsum.mybatis.demo3.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SelectPageTester {

    @Test
    public void testOneToMany() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            // startPage()方法会自动将下一次查询进行分页
            PageHelper.startPage(2,10);
            Page<Goods> page = (Page)sqlSession.selectList("goods.selectPage");
            System.out.println("总页数:" + page.getPages());
            System.out.println("总记录数:" + page.getTotal());
            System.out.println("开始行号:" + page.getStartRow());
            System.out.println("结束行号:" + page.getEndRow());
            System.out.println("当前页码:" + page.getPageNum());
            List<Goods> data = page.getResult();//当前页数据
            for (Goods g : data) {
                System.out.println(g.getTitle());
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
