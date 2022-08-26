package com.atguigu.controller;

import com.atguigu.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/persons")
public class JsonController {

    @GetMapping("/1")
    public Person getPerson() {
        return new Person(1, "Thomas");
    }

    @GetMapping("/2")
    public List<Person> getPersons(){
        List<Person> ret = new ArrayList<>();
        ret.add(new Person(1, "James"));
        ret.add(new Person(2, "Thomas"));
        return ret;
    }

    @GetMapping("/3")
    public Map<String, Person> getMapPerson() {
        Map<String, Person> map = new HashMap<>();
        map.put("James", new Person(33, "James"));
        return map;
    }

    @PostMapping("/4")
    public Person savePerson(@RequestBody  Person person) {
        System.out.println(person);
        person.setName("Oliver");
        return person;
    }

    @PostMapping("/5")
    public List<Person> savePersons(@RequestBody List<Person> persons) {
        System.out.println(persons);
        return persons;
    }

}
