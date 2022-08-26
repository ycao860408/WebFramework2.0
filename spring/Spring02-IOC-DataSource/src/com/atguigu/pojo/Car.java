package com.atguigu.pojo;

public class Car {
    private String name;
    private String carNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String noStaticFun() {
        return "non static method";
    }

    public static String staticFun() {
        return "static method";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", carNo='" + carNo + '\'' +
                '}';
    }
}
