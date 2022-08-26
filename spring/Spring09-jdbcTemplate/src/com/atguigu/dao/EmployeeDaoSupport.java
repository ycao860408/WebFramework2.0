package com.atguigu.dao;

import com.atguigu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeDaoSupport  extends JdbcDaoSupport {
    @Autowired
    public void  setJdbcDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public List<Employee> queryAll() {
        String sql = "select id, name, salary from employee";
        return super.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
    }
}
