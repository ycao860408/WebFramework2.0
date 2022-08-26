package com.atguigu.service.impl;

import com.atguigu.dao.LogDao;
import com.atguigu.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao logDao;

    @Override
    public void log(String from, String to, Integer money) {
        logDao.log(from, to, money);
    }
}
