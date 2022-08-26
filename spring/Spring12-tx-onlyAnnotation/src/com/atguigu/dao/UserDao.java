package com.atguigu.dao;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


public interface UserDao {

    public Object queryUserById(Integer id);

    public void inMany(Integer id, Integer money);

    public void outMany(Integer id, Integer money);
}
