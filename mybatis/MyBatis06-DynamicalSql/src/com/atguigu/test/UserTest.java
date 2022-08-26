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
import java.util.Arrays;
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
       List<User> users = userMapper.queryUserLikeLastNameAndGender(new User(null, null, 0));
       System.out.println(users);
   }

   @Test
   public void queryUserCondition() {
       List<User> users = userMapper.selectUserByUserChooseWhenOtherwise(new User(null, null, null));
       System.out.println(users);
   }

    @Test
    public void updateUser() {
        userMapper.updateUser(new User(18, "Cat", null));
    }

    @Test
    public void queryUsersByIds() {
        List<User> users = userMapper.queryUserByIds(Arrays.asList(15, 16, 17, 18));
        users.forEach(System.out::println);
    }

    @Test
    public void insertMany() {
        userMapper.insertMany(Arrays.asList(new User(null, "Dog", 0), new User(null, "Dragon", 1), new User(null, "Pig", 0)));
    }


    public void queryUserAllTwice() {
        userMapper.queryUserAll();
        userMapper.queryUserAll();
    }

    @Test
    public void testCache1() {
        queryUserAllTwice();
    }

    @Test
    public void testCache2() {
        SqlSession s1 = sqlSessionFactory.openSession(true);
        SqlSession s2 = sqlSessionFactory.openSession(true);
        UserMapper m1 = s1.getMapper(UserMapper.class);
        UserMapper m2 = s2.getMapper(UserMapper.class);

        m1.queryUserAll();
        m2.queryUserAll();
    }

    @Test
    public void testCache3() {
       userMapper.queryUserById(1);
       userMapper.queryUserById(2);
    }

    @Test
    public void testCache4() {
        userMapper.queryUserById(1);
        userMapper.updateUser(new User(18, "Fox", null));
        userMapper.queryUserById(1);
    }

    @Test
    public void testCache5() {
        userMapper.queryUserById(1);
        sqlSession.clearCache();
        userMapper.queryUserById(1);
    }

    @Test
    public void testCache6() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true );
        UserMapper m = sqlSession.getMapper(UserMapper.class);
        m.queryUserById(1);
        // 注銷掉下一句，那麽之後那個commit雖然把一級緩存給清空了，但是卻寫入了二級緩存。
        m.updateUser(new User(1, "Pumma", 1)); // 無論手動提交還是自動提交，都會把一級緩存給冲刷了。
        sqlSession.commit(); // 因爲此時設置了提交不刷二級緩存，所以下面的應該還能命中
        m.queryUserById(1);
    }

    @Test
    public void testSecondCache1() {
        SqlSession s1 = sqlSessionFactory.openSession(true);
        UserMapper m1 = s1.getMapper(UserMapper.class);
        m1.queryUserById(1);
        s1.close();
        userMapper.queryUserById(1);
    }

    @Test
    public void testSecondCache2() {
        SqlSession s1 = sqlSessionFactory.openSession(true);
        UserMapper m1 = s1.getMapper(UserMapper.class);
        m1.queryUserById(1);
        s1.close();
        userMapper.updateUser(new User(13, "Shark", 1));
        userMapper.queryUserById(1);
    }
    @After
    public void destroy() {
        sqlSession.close();
    }
}
