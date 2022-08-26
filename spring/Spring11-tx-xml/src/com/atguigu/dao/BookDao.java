package com.atguigu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


public class BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateBook() {
        String sql = "update book set name = '三國演義' where id = 1";
        jdbcTemplate.update(sql);
    }
}
