package com.atguigu.config;

import com.atguigu.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.atguigu"})

public class SpringConfig {
    @Bean("p")
    public Person createPerson(){
        return new Person();
    }


}
