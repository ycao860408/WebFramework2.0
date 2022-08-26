package com.atguigu.dao;

import org.springframework.stereotype.Repository;

@Repository("dao")
public class PersonDao {
    public void queryPerson() {
        System.out.println("select person!");
    }
}
