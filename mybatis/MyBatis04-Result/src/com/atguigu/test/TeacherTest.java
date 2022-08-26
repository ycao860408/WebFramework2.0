package com.atguigu.test;

import com.atguigu.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TeacherTest {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    TeacherMapper teacherMapper = null;

    @Before
    public void init() throws IOException {
        InputStream inputstream = Resources.getResourceAsStream("MyBatis-Config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
        sqlSession = sqlSessionFactory.openSession(true);
        teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    }

    @Test
    public void queryTeaById() {
        System.out.println(teacherMapper.queryTeaById(1));
    }

    @After
    public void destroy() {
        sqlSession.close();
    }
}
