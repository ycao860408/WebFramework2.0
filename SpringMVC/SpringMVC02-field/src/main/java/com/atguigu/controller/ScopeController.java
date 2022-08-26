package com.atguigu.controller;

import com.atguigu.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@SessionAttributes(types = {String.class, Integer.class})
public class ScopeController {

    @Autowired
    ServletContext servletContext;

    @ModelAttribute
    public void show(Map<String, Person> map) {
        System.out.println("show()");
        map.put("persons", new Person(1, "Steven Jobs"));
    }

    @RequestMapping("/scope9")
    public String map9(@ModelAttribute("persons") Person person) {
        System.out.println(person);
        return "scope";
    }

    @RequestMapping(value = "/scope1")
    public String map1(HttpServletRequest request) {
        System.out.println("requestScope");
        request.setAttribute("name", "John");
        request.setAttribute("age", 18);
        return "scope";
    }

    @RequestMapping("/scope2")
    public String map2(HttpSession session) {
        System.out.println("sessionScope");
        session.setAttribute("name", "Peter");
        session.setAttribute("age", 12);
        return "scope";
    }

    @RequestMapping("/scope3")
    public String map3() {
        System.out.println("applicationScope");
        servletContext.setAttribute("name", "James");
        servletContext.setAttribute("age", 22);
        return "scope";
    }

    @RequestMapping("/scope4")
    public String map4(Map<String, Object> map) {
        System.out.println("map to request");
        map.put("name", "Christina");
        map.put("age", 18);
        return "scope";
    }

    @RequestMapping("/scope5")
    public String map5(Model model) {
        System.out.println("model to request");
        model.addAttribute("name", "Biden");
        model.addAttribute("age", 80);
        return "scope";
    }

    @RequestMapping("/scope6")
    public String map6(ModelMap modelMap) {
        System.out.println("modelMap to request");
        modelMap.addAttribute("name", "Dirac");
        modelMap.addAttribute("age", 18);
        return "scope";
    }

    @RequestMapping("/scope7")
    public String map7(Map<String, Object> map, Model model, ModelMap modelMap) {
        System.out.println("Model and ModelMap and Map");
        System.out.println(map);
        System.out.println(model);
        System.out.println(modelMap);
        map.put("name", "Bush");
        System.out.println("================================");
        System.out.println(map);
        System.out.println(model);
        System.out.println(modelMap);
        model.addAttribute("age", 80);
        System.out.println("================================");
        System.out.println(map);
        System.out.println(model);
        System.out.println(modelMap);
        modelMap.addAttribute("gender", "male");
        System.out.println("================================");
        System.out.println(map);
        System.out.println(model);
        System.out.println(modelMap);
        return "scope";
    }

    @RequestMapping("/scope8")
    public ModelAndView map8() {
        System.out.println("ModelAndView");
        ModelAndView modelAndView = new ModelAndView("scope");
        modelAndView.addObject("name", "Washington");
        modelAndView.addObject("age", 100);
        modelAndView.addObject("gender", "male");
        return modelAndView;
    }
}
