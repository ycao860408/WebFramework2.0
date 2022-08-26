package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.crypto.Data;
import java.util.Date;

@Controller
public class ConvertController {

    @RequestMapping("/convert")
    public String convert(Date date) {
        System.out.println("The date get from the frontend is " + date);
        return "ok";
    }
}
