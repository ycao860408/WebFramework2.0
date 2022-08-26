package com.atguigu.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class User {
    private Integer id;
    private String name;
    private String phone;
    private Integer age;
    private Car car;
    List<String> list;
    Map<String, Object> map;
    Properties properties;

    public User() {
    }

    public User(Integer id, String name, String phone, Integer age, Car car) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.car = car;
    }

    public User(Integer id, String name, String phone, Integer age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public User(Car car) {
        this.car = car;
    }

    public void init() {
        System.out.println("User Bean has been created! Do some necessary preparation!");
    }

    public void destroy() {
        System.out.println("User Bean is destroying!");
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

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
