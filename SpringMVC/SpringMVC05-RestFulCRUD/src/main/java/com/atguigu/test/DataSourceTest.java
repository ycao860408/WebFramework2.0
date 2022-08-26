package com.atguigu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ContextConfiguration(locations = {"classpath:SpringMVC.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        System.out.println(jdbcTemplate);
    }
}
