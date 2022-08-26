package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource(value="classpath:jdbc.properties")
@ComponentScan(basePackages = "com.atguigu")
@EnableTransactionManagement
public class SpringConfig {

    @Value("${user}")
    String userName;
    @Value("${url}")
    String url;
    @Value("${password}")
    String password;
    @Value("${driverClassName}")
    String driverClassName;
    @Value("${initialSize}")
    Integer initialSize;
    @Value("${maxActive}")
    Integer maxActive;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(userName);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate result = new JdbcTemplate();
        result.setDataSource(dataSource);
        return result;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager result = new DataSourceTransactionManager();
        result.setDataSource(dataSource);
        return result;
    }
}
