package com.atguigu.test;

import com.atguigu.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    ClassPathXmlApplicationContext apc = null;


    @Before
    public void init() {
        apc = new ClassPathXmlApplicationContext("bean.xml");
    }

    @Test
    public void test1(){
        User user1 = (User)apc.getBean("user1");
        User user2 = apc.getBean("user1", User.class);
        User user3 = apc.getBean(User.class);
        System.out.println(user1 == user2);
        System.out.println(user2 == user3);
    }

    @Test
    public void test2() {
        User user = apc.getBean("user1", User.class);
        System.out.println(user);
    }
    @Test
    public void test3() {
        User user2 = apc.getBean("user2", User.class);
        System.out.println(user2);
    }

    @Test
    public void test4() {
        User user3 = apc.getBean("user3", User.class);
        System.out.println(user3);
    }

    @Test
    public void test5() {
        User user4 = apc.getBean("user4", User.class);
        System.out.println(user4);
    }

    @Test
    public void testNull() {
        User user5 = apc.getBean("user5", User.class);
        System.out.println(user5);
    }


    @Test
    public void test6() {
        User user6 = apc.getBean("user6", User.class);
        System.out.println(user6);
    }

    @Test
    public void test7() {
        User user7 = apc.getBean("user7", User.class);
        System.out.println(user7);
    }

    @Test
    public void test8(){
        User user8 = apc.getBean("user8", User.class);
        System.out.println(user8);
    }

    @Test
    public void test9(){
        User user9 = apc.getBean("user9", User.class);
        System.out.println(user9);
    }

    @Test
    public void tset10() {
        User user10 = apc.getBean("user10", User.class);
        System.out.println(user10);
    }

    @Test
    public void tset11() {
        User user11 = apc.getBean("user11", User.class);
        System.out.println(user11);
    }
}
