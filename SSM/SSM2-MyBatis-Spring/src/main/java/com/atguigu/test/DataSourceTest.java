package com.atguigu.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DataSourceTest {
    @Autowired
    DataSource dataSource;

    @Test
    public void test1() {
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
