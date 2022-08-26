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
import java.util.Map;

public class UserTest1 {
    SqlSessionFactory factory = null;
    SqlSession session = null;
    UserMapper userMapper = null;
    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession(true);
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void queryUserAll() {
        List<User> users = userMapper.queryUserAll();
        users.stream().forEach(System.out::println);
    }

    @Test
    public void updateUserById() {
        userMapper.updateUserById(new User(2,"Leo", 2));
        //session.commit();
    }

    @Test
    public void deleteUserById() {
        System.out.println(userMapper.deleteUserById(2));
    }

    @Test
    public void insertUser() {
        User user = new User(null, "Nio", 2);
        System.out.println(userMapper.insertUser(user));
        System.out.println(user.getId());
    }

    @Test
    public void queryUserMapById() {
        Map<Integer, User> map = userMapper.queryUserMapById(5);
        System.out.println(map);
    }

    @Test
    public void queryUserAllMap() {
        Map<Integer, User> map = userMapper.queryUserAllMap();
        System.out.println(map);
    }

    @After
    public void destroy() {
        session.close();
    }
}
