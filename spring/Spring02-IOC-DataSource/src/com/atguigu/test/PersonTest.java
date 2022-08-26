package com.atguigu.test;

import com.atguigu.pojo.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
    ClassPathXmlApplicationContext cpx = null;

    @Before
    public void init() {
        cpx = new ClassPathXmlApplicationContext("bean2.xml");
    }

    @Test
    public void test1() {
        System.out.println(cpx.getBean("person", Person.class));
    }
}
