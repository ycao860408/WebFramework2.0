package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
//@ControllerAdvice
public class HelloController {

    //@ExceptionHandler
    public String exceptionHandler1(ArithmeticException e) {
        System.out.println("The exception the handler found is " + e);
        return "error1";
    }
    @RequestMapping("/greeting")
    public String helloMethod() throws FileNotFoundException {
        System.out.println("This is hello method!");
        //int i = 1 / 0;
        if (true) throw new FileNotFoundException("File not found");
        return "ok";
    }

    //@ExceptionHandler
    public String exceptionHandler2(Exception e) {
        System.out.println("The exception the handler found is " + e);
        return "error2";
    }
}
