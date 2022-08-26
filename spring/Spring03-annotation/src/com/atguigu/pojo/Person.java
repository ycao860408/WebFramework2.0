package com.atguigu.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class Person {
    @PostConstruct
    public void init() {
        System.out.println("This is the init method!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("This is the destroy method!");
    }
}
