package com.atguigu.test;

import com.atguigu.pojo.Calculation;
import com.atguigu.pojo.Calculator;
import com.atguigu.proxy.CglibProxy;
import com.atguigu.proxy.JDKProxy;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void JDKProxyTest() {
        Calculation calculator = new Calculator();
        Calculation proxy = (Calculation) JDKProxy.createProxy(calculator);
        proxy.add3(1, 3, 4);

        proxy.div(1, 0);
    }

    @Test
    public void CglibProxyTest() {
        Calculator calculator = new Calculator();
        Calculator proxy = (Calculator) CglibProxy.createProxy(calculator);
        proxy.add3(1, 3, 4);
        proxy.div(1, 0);
    }
}
