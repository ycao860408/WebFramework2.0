package com.atguigu.service;

import com.atguigu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



public class UserService {
    @Autowired
    UserDao userDao;


    public void updateUser(){
        int i = 10 / 0;
        userDao.updateUser();
    }
}
