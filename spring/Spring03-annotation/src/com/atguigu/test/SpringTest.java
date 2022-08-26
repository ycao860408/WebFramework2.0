package com.atguigu.test;

import com.atguigu.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:bean.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class SpringTest {
    @Autowired
    private PersonService personService;

    @Test
    public void test() {
        System.out.println(personService);
    }
}
