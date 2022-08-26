package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnotherController {
    @RequestMapping("/anotherGreeting")
    public String hello() {
        System.out.println("This is another hello!");
        int i = 1 / 0;
        return "ok";
    }

    /*@ExceptionHandler
    public String localExceptionHandler1(ArithmeticException e) {
        System.out.println("the exception found by the local eh is " + e);
        return "error1";
    }*/

    //@ExceptionHandler
    public String localExceptionHandler2(Exception e) {
        System.out.println("the broad exception found by the local eh is " + e);
        return "error2";
    }
}
