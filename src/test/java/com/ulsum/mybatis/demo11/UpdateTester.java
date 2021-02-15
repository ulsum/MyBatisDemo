package com.ulsum.mybatis.demo11;

import com.ulsum.mybatis.demo2.MyBatisUtil;
import com.ulsum.mybatis.demo3.Goods;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UpdateTester {

    @Test
    public void testUpdate(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.openSession();
            Goods goods = sqlSession.selectOne("goods.selectById",739);
            goods.setTitle("更新测试商品");
            int num = sqlSession.update("goods.update", goods);
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
