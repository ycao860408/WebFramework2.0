package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnController {
    @RequestMapping("return1")
    public String map1() {
        System.out.println("implicitly dispatch!");
        return "ok";
    }

    @RequestMapping("return2")
    public String map2() {
        System.out.println("explicitly dispatch!");
        return "forward:/pages/ok.jsp";
    }

    @RequestMapping("return3")
    public String map3() {
        System.out.println("redirect");
        return "redirect:/pages/ok.jsp";
    }

    @RequestMapping("return4")
    public ModelAndView map4() {
        ModelAndView mv = new ModelAndView("ok");
        //mv.setViewName("ok");
        return mv;
    }

    @RequestMapping("return5")
    public ModelAndView mp5() {
        ModelAndView mv = new ModelAndView("forward:/pages/ok.jsp");
        return mv;
    }

    @RequestMapping("return6")
    public ModelAndView mp6() {
        ModelAndView mv= new ModelAndView("redirect:/pages/ok.jsp");
        return mv;
    }
}
