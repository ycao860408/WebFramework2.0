package com.atguigu.Service;

import com.atguigu.pojo.Calculation;
import org.springframework.stereotype.Service;


public class Calculator implements Calculation {
    @Override
    public Integer add2(Integer num1, Integer num2) {
        return num1 + num2;
    }

    @Override
    public Integer add3(Integer num1, Integer num2, Integer num3) {
        return num1 + num2 + num3;
    }

    @Override
    public Integer div(Integer num1, Integer num2) {
        System.out.println("==================running method!===================");
        return num1 / num2 ;
    }
}
