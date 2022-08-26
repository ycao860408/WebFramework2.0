package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ant")
public class AntController {

    @RequestMapping(value = "/fun")
    public String map1() {
        System.out.println("exact match!");
        return "ok";
    }

    @RequestMapping(value = "/fu?")
    public String map2() {
        System.out.println("? match!");
        return "ok";
    }

    @RequestMapping(value = "/fu*")
    public String map3() {
        System.out.println("* match!");
        return "ok";
    }

    @RequestMapping(value = "/?/fun")
    public String map4() {
        System.out.println("single char layer match~");
        return "ok";
    }

    @RequestMapping(value = "/?/fu?")
    public String map5() {
        System.out.println("single char layer combined match~");
        return "ok";
    }

    @RequestMapping(value = "/*/fu?")
    public String map6() {
        System.out.println("multiple char combined match~");
        return "ok";
    }

    @RequestMapping(value = "/**/fu?")
    public String map7() {
        System.out.println("multiple layer and  char combined match~");
        return "ok";
    }
}
