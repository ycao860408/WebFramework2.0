package com.atguigu.test;

import com.atguigu.factory.A;
import com.atguigu.pojo.SonUser;
import com.atguigu.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaticUserTest {
    ClassPathXmlApplicationContext sapc = null;
    @Before
    public void init() {
        sapc = new ClassPathXmlApplicationContext("staticFactory.xml");
    }

    @Test
    public void testStaticUser() {
        User staticUser = sapc.getBean("staticUser", User.class);
        System.out.println(staticUser);
    }

    @Test
    public void testInstanceUser() {
        System.out.println(sapc.getBean("instanceUser", User.class));
    }

    @Test
    public void testFactoryBean() {
        System.out.println(sapc.getBean("factoryBean", User.class));
    }

    @Test
    public void testInherit(){
        System.out.println(sapc.getBean("kid", User.class));
    }

    @Test
    public void testInherit1() {
        SonUser kid1 = sapc.getBean("kid1", SonUser.class);
        System.out.println(kid1.getCount());
    }

    @Test
    public void testOrder() {
        A a = sapc.getBean("A", A.class);
        System.out.println(a);
    }

    @Test
    public void testLife() {
        User kk = sapc.getBean("kk", User.class);
        System.out.println(kk);
        sapc.close();
    }

    @Test
    public void testautInjection() {
        System.out.println(sapc.getBean("autoUser", User.class));
    }
}