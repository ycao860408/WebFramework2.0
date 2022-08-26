package com.atguigu.service;

import com.atguigu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;


public class UserService {
    @Autowired
    UserDao userDao;


    public void updateUser(){
        int i = 10 / 0;
        userDao.updateUser();
    }
}
