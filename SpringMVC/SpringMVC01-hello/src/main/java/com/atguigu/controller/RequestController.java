package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class RequestController {

    @RequestMapping(value = {"/xxx", "/sss", "/ddd"})
    public String map1() {
        System.out.println("@RequestMapping Annotation!");
        return "ok";
    }

    @RequestMapping(value= "/params", params = "username=abc")
    public String map2() {
        System.out.println("@RequestMapping Annotation --- params");
        return "ok";
    }

    @RequestMapping(value = "/header", headers = {"User-Agent"})
    public String map3() {
        System.out.println("@RequestMapping Annotation --- header");
        return "ok";
    }

    @RequestMapping(value = "/method", method = RequestMethod.GET)
    public String map4() {
        System.out.println("@RequestMapping Annotation --- Method");
        return "ok";
    }
}
