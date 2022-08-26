package com.atguigu.test;

import com.atguigu.factory.B;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PostBeanProcessorTest {
    @Test
    public void testPost() {
        ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("postBeanProcessor.xml");
        B b = cpx.getBean("B", B.class);
        System.out.println("This is B: " + b);
    }
}
