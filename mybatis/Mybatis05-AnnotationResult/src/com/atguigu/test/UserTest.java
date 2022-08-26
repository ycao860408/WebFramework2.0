package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
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

public class UserTest {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    UserMapper userMapper;
    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis-Config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

   @Test
   public void queryUserAll() {
       List<User> users = userMapper.queryUserAll();
       users.forEach(System.out::println);
   }


    @After
    public void destroy() {
        sqlSession.close();
    }
}
