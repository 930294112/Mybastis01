package com.lanou.test;

import com.lanou.domain.User;
import com.lanou.mapper.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
public class UserDaoTest {

    private SqlSession session;

    @Before
    public void init() throws IOException {
        /*1.获取mybatis配置文件输入流*/
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        /*2.构建sessionFactory对象*/
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        /*3.打开session会话*/
        session = sessionFactory.openSession();
    }

    @After
    public void close(){
        session.close(); //关闭session会话
    }

    @Test
    public void findAll(){
        //获得映射文件对应的接口对象
        UserDao dao = session.getMapper(UserDao.class);
        //调用查询所有
        List<User> users = dao.findAll();
        //遍历结果集
        for (User user : users) {
            System.out.println(user);
        }
    }
}
