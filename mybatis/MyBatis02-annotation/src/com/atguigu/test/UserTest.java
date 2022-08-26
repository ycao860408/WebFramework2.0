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
    public void queryUserById() {
        User user = userMapper.queryUserById(1);
        System.out.println(user);
    }

    @Test
    public void queryUserAll() {
        userMapper.queryUserAll().stream().forEach(System.out::println);
    }

    @Test
    public void deleteUserById() {
        System.out.println(userMapper.deleteUserById(8));
    }

    @Test
    public void updateUserById() {
        System.out.println(userMapper.updateUserById(new User(5, "Nio", 1)));
    }

    @Test
    public void insertUser() {
        System.out.println(userMapper.insertUser(new User(null, "Dragon", 2)));
    }

    @Test
    public void insertUserWithReturnKey() {
        User donkey = new User(null, "Donkey", 1);
        System.out.println(userMapper.insertUser(donkey));
        System.out.println(donkey.getId());
    }


    @After
    public void destroy() {
        sqlSession.close();
    }
}
