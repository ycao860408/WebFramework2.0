package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Object queryUserById(Integer id) {
        String sql = "select `username` from user where id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, id);
    }

    @Override
    public void inMany(Integer id, Integer money) {
        String sql = "update user set `money` = `money` + ? where id = ?";
        jdbcTemplate.update(sql, money, id);
    }

    @Override
    public void outMany(Integer id, Integer money) {
        String sql = "update user set `money` = `money` - ? where id = ?";
        jdbcTemplate.update(sql, money, id);
    }
}
