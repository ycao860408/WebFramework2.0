package com.atguigu.test;


import com.atguigu.config.SpringConfig;
import com.atguigu.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SpringConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {
    @Autowired
            @Qualifier(value = "p1")
    Person person;

    @Test
    public void testPerson() {
        System.out.println(person);
    }
}
