package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void updateUser() {
        String sql = "update user set username = '張翼德' where id= 1";
        jdbcTemplate.update(sql);
    }
}
