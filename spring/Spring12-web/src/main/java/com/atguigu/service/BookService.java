package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;


public class BookService {
    @Autowired
    private BookDao bookDao;


    public void updateBook() {
       /* int i = 10 / 0;*/
        bookDao.updateBook();
    }
}
