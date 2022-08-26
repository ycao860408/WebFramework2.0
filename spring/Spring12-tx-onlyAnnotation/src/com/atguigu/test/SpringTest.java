package com.atguigu.test;

import com.atguigu.config.SpringConfig;
import com.atguigu.dao.LogDao;
import com.atguigu.dao.UserDao;
import com.atguigu.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@ContextConfiguration(classes = SpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

    @Autowired
    TransactionService transactionService;

    @Test
    public void transactionTest() {
        transactionService.transfer(1, 2, 100);
    }

    @Autowired
    UserDao userDao;

    @Test
    public void testUserDao() {
        System.out.println(userDao.queryUserById(2));
        userDao.inMany(1, 100);
    }

    @Autowired
    LogDao logDao;

    @Test
    public void testLogDao(){
        String from = (String) userDao.queryUserById(1);
        String to = (String) userDao.queryUserById(2);
        logDao.log(from, to,23);
    }


}
