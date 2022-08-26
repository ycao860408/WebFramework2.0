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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println(userMapper.queryUserById(7));
    }
    
    @Test
    public void queryUserByIdOrGender() {
        List<User> users = userMapper.queryUserByIdOrGender(2, 1);
        users.forEach(System.out::println);
    }

    @Test
    public void queryUserByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);
        map.put("gender", 1);
        userMapper.queryUserByMap(map).forEach(System.out::println);
    }

    @Test
    public void insertUser() {
        System.out.println(userMapper.insertUser(new User(null, "Kangaroo", 1)));
    }

    @Test
    public void insertUsers() {
        System.out.println(userMapper.insertUsers(new User(null, "Crab", new Integer(1)), new User(null, "JellyFish", new Integer(0))));
    }

    @Test
    public void queryUsesByLikeName() {
        userMapper.queryUsersLikeName("D"  ).forEach(System.out::println);
    }
    @After
    public void destroy() {
        sqlSession.close();
    }
}
