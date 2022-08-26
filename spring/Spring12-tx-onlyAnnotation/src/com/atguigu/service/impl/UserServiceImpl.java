package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void inMoney(Integer id, Integer money) {
        userDao.inMany(id, money);
    }

    @Override
    public void outMoney(Integer id, Integer money) {
        userDao.outMany(id, money);
    }

    @Override
    public String queryUserNameById(Integer id) {
        return (String)userDao.queryUserById(id);
    }
}
