package com.atguigu.dao.impl;

import com.atguigu.dao.LogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class LogDaoImpl implements LogDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void log(String from, String to, Integer money) {
        String sql = "insert into log (`log`, `time`) values(?, now())";
        jdbcTemplate.update(sql, from + " send $" + money + " to " + to + ".");
    }
}
