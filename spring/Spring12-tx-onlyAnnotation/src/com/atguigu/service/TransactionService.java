package com.atguigu.service;

import com.mysql.jdbc.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransactionService {
    @Autowired
    UserService userService;
    @Autowired
    LogService logService;

    @Transactional
    public void transfer(Integer from, Integer to, Integer money) {
        String f = userService.queryUserNameById(from);
        String t = userService.queryUserNameById(to);
        System.out.println(f + " " + t);
        try {
            userService.inMoney(to, money);
            int i = 1 / 0;
            userService.outMoney(from, money);
        } finally {
            logService.log(f, t, money);
        }
    }
}
