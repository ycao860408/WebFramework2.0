package com.atguigu.pojo;

public class Calculator implements  Calculation{
    @Override
    public int add2(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int add3(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    @Override
    public int div(int num1, int num2) {
        return num1 / num2 ;
    }
}
