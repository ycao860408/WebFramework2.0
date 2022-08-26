package com.atguigu.service;

import com.atguigu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional(propagation = Propagation.NESTED)
    public void updateBook() {
       /* int i = 10 / 0;*/
        bookDao.updateBook();
    }
}
