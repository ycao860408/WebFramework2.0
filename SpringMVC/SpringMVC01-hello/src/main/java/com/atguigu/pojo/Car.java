package com.atguigu.pojo;

public class Car {

    private String type;
    private Integer carNo;

    public Car() {
    }

    public Car(String type, Integer carNo) {
        this.type = type;
        this.carNo = carNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCarNo() {
        return carNo;
    }

    public void setCarNo(Integer carNo) {
        this.carNo = carNo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", carNo=" + carNo +
                '}';
    }
}
