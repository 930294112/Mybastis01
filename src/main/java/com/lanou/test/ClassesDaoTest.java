package com.lanou.test;

import com.lanou.domain.Classes;
import com.lanou.domain.User;
import com.lanou.mapper.ClassesDao;
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
public class ClassesDaoTest {

    private SqlSession session;
    private SqlSessionFactory sessionFactory;

    @Before
    public void init() throws IOException {
        /*1.获取mybatis配置文件输入流*/
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        /*2.构建sessionFactory对象*/
        sessionFactory = new SqlSessionFactoryBuilder().build(is);
        /*3.打开session会话*/
        session = sessionFactory.openSession();
    }

    @After
    public void close(){
        session.commit();
        session.close(); //关闭session会话

    }

    @Test
    public void findAll(){
        //获得映射文件对应的接口对象
       ClassesDao dao = session.getMapper(ClassesDao.class);
        //插入数据
       Classes c = new Classes("j0703","java web");
        dao.addClasses(c);
        //查询所有
        List<Classes> classesList = dao.findAll();
        //遍历结果集
        for (Classes classes : classesList) {
            System.out.println(classes);
        }
    }

    @Test
    public void findByName(){
        ClassesDao dao = session.getMapper(ClassesDao.class);
        List<Classes> classesList = dao.findByName("j0703");
        for (Classes classes : classesList) {
            System.out.println(classes);
        }
    }

    @Test
    public void findByName2(){
        ClassesDao dao = session.getMapper(ClassesDao.class);
        Classes params = new Classes();
        params.setClassName("j0703");
        List<Classes> classesList = dao.findByName2(params);
        for (Classes classes : classesList) {
            System.out.println(classes);
        }
    }
}
