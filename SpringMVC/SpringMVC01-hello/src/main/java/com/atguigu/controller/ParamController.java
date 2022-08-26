package com.atguigu.controller;

import com.atguigu.pojo.Person;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {

    @RequestMapping("/param1")
    public String map1(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(request.getParameter("username"));
        System.out.println(request.getContextPath());
        System.out.println(session.getId());
        return "ok";
    }

    @RequestMapping(value="/param2")
    public String map2(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return "ok";
    }

    @RequestMapping(value="/param3")
    public String map3(String[] hobbies) {
        System.out.println(Arrays.toString(hobbies));
        return "ok";
    }

    @RequestMapping(value = "/param4")
    public String map4(@RequestParam(name="user", required = false, defaultValue = "haha") String username) {
        System.out.println(username);
        return "ok";
    }

    @RequestMapping(value = "/param5")
    public String map5(@RequestHeader(name = "User-Agent") String userAgent) {
        System.out.println(userAgent);
        return "ok";
    }

    @RequestMapping(value = "/param6")
    public String map6(@CookieValue("JSESSIONID") String jsessionID) {
        System.out.println(jsessionID);
        return "ok";
    }

    @RequestMapping(value = "/param7")
    public String map7(Person person) {
        System.out.println(person);
        return "ok";
    }
}
