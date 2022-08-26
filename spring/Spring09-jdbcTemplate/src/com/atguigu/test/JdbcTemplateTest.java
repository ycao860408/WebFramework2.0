package com.atguigu.test;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.dao.EmployeeDaoSupport;
import com.atguigu.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.*;

@ContextConfiguration(locations = "classpath:bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void updateTest() {
        String sql = "update employee set salary = ? where id = ?";
        System.out.println(jdbcTemplate.update(sql, new BigDecimal("1300.00"), 5));
    }

    @Test
    public void batchInsertTest() {
        String sql = "insert into employee (`name`, `salary`) values (?, ?)";
        List<Object[]> elms = new ArrayList<>();
        elms.add(new Object[]{"陳真", new BigDecimal("234.6")});
        elms.add(new Object[]{"霍元甲", new BigDecimal("274.6")});
        elms.add(new Object[]{"黃飛鴻", new BigDecimal("294.6")});
        elms.add(new Object[]{"陳近南", new BigDecimal("224.6")});
        elms.add(new Object[]{"洪熙官", new BigDecimal("264.6")});
        elms.add(new Object[]{"方世玉", new BigDecimal("21244.6")});
        int[] results = jdbcTemplate.batchUpdate(sql, elms);
        System.out.println(Arrays.toString(results));
    }

    @Test
    public void selectForOneTest() {
        String sql = "select id, name, salary from employee where id = ?";
        Employee result = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Employee>(Employee.class), 5);
        System.out.println(result);
    }

    @Test
    public void selectForManyTest() {
        String sql = "select id, name, salary from employee where salary > ?";
        jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class), new BigDecimal("4000")).forEach(System.out::println);
    }

    @Test
    public void selectMaxTest() {
        String sql = "select max(salary) from employee";
        System.out.println(jdbcTemplate.queryForObject(sql, BigDecimal.class));
    }

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void namedInsertTest() {
        String sql = "insert into employee (name, salary) values(:name, :salary)";
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("name", "令狐衝");
        paraMap.put("salary", new BigDecimal("2435.22"));
        System.out.println(namedParameterJdbcTemplate.update(sql, paraMap));
    }

    @Test
    public void namedSqlParamInsertTest() {
        String sql = "insert into employee (name, salary) values(:name, :salary)";
        Employee employee = new Employee(null, "岳不群", new BigDecimal("1324.22"));
        System.out.println(namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee)));
    }

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void employeeDaoTest() {
        employeeDao.queryAll().forEach(System.out::println);
    }

    @Autowired
    EmployeeDaoSupport employeeDaoSupport;

    @Test
    public void setEmployeeDaoSupportTest() {
        employeeDaoSupport.queryAll().forEach(System.out::println);
    }

}
