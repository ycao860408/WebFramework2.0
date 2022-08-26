package com.atguigu.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface LogService {
    public void log(String from, String to, Integer money);
}
