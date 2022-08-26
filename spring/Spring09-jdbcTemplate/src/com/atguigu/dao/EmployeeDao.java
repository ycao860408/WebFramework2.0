package com.atguigu.dao;

import com.atguigu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> queryAll() {
        String sql = "select `id`, `name`, `salary` from employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
    }
}
