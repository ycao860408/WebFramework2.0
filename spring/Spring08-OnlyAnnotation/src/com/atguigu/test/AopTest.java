package com.atguigu.test;

import com.atguigu.Service.Calculator;
import com.atguigu.config.AopConfig;
import com.atguigu.pojo.Calculation;
import com.atguigu.utils.LogUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AopConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {

    @Autowired
    private LogUtils logUtils;

    @Autowired
    private Calculation calculator;

    @Test
    public void test() {
        System.out.println(logUtils);
        System.out.println(calculator);
    }

    @Test
    public void testAspect() {
        System.out.println(calculator.div(6, 3));
    }
}
