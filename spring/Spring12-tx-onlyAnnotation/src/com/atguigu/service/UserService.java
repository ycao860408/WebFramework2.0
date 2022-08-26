package com.atguigu.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional(propagation = Propagation.REQUIRED)
public interface UserService {

    public void inMoney(Integer id, Integer money);

    public void outMoney(Integer id, Integer money) ;

    public String queryUserNameById(Integer id);
}
