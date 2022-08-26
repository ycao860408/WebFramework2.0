package com.atguigu.test;

import com.atguigu.config.SpringConfig;
import com.atguigu.pojo.Girl;
import com.atguigu.pojo.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext apx = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(apx.getBean("girl", Girl.class));
    }
}
