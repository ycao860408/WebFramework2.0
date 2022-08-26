package com.atguigu.pojo;

public class SonUser extends User{
    private Integer count;

    public SonUser(Integer count) {
        this.count = count;
    }

    public SonUser() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
