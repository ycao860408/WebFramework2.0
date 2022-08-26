package com.atguigu.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {
    ClassPathXmlApplicationContext cpx = null;
    @Before
    public void init() {
        cpx = new ClassPathXmlApplicationContext("bean.xml");
    }

    @Test
    public void testConnection() throws SQLException {
        DataSource dataSource = cpx.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
    @After
    public void destroy() {
        cpx.close();
    }
}
