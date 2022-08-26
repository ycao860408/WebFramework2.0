package com.atguigu.test;

import com.atguigu.dao.PersonDao;
import com.atguigu.pojo.Girl;
import com.atguigu.pojo.Person;
import com.atguigu.service.PersonService;
import com.atguigu.web.PersonController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoTest {
    ClassPathXmlApplicationContext cpx = null;
    @Before
    public void init() {
        cpx = new ClassPathXmlApplicationContext("bean.xml");
    }

    @Test
    public void testFirstAnno() {
        Person p1 = cpx.getBean("person", Person.class);
        Person p2 = cpx.getBean("person", Person.class);
        System.out.println(p1 == p2);
    }

    @Test
    public void testTwoAnno() {
        Person p = cpx.getBean("person", Person.class);
        cpx.close();
    }

    @Test
    public void testDaoAnoo() {
        PersonDao test = cpx.getBean("dao", PersonDao.class);
        System.out.println(test);
    }

    @Test
    public void testService() {
        System.out.println(cpx.getBean("service", PersonService.class));
    }

    @Test
    public void testController() {
        System.out.println(cpx.getBean("controller", PersonController.class)); 
    }
    
    @Test
    public void testGirl() {
        Girl girl = cpx.getBean("girl", Girl.class);
    }

    @Test
    public void testAutowire() {
        System.out.println(cpx.getBean("service", PersonService.class));
    }


    @After
    public void destroy() {
        cpx.close();
    }
}
