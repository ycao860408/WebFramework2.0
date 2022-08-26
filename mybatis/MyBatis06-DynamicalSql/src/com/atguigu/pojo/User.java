package com.atguigu.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("user")
public class User implements Serializable {
    private Integer id;
    private String lastName;
    private Integer gender;

    public User() {
    }

    public User(Integer id, String lastName, Integer gender) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
