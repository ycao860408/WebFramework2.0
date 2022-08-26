package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class BookService {
    @Autowired
    private BookDao bookDao;


    public void updateBook() {
       /* int i = 10 / 0;*/
        bookDao.updateBook();
    }
}
