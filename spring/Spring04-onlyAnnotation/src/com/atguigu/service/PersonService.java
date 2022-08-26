package com.atguigu.service;

import com.atguigu.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("service")
public class PersonService {

    @Autowired(required = false)
            @Qualifier(value = "daoExt")
    PersonDao personDao;

    @Override
    public String toString() {
        return "PersonService{" +
                "personDao=" + personDao +
                '}';
    }

    @Autowired
    public void show(@Qualifier(value = "dao") PersonDao personDao) {
        personDao.queryPerson();
        System.out.println("show()");
    }
}
