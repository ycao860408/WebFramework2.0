package com.atguigu.pojo;

public class Person {
    private Integer id;
    private String name;
    private String phone;
    private Integer age;
    private Car car;

    public Person() {
    }

    public Person(Integer id, String name, String phone, Integer age, Car car) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
