package com.atguigu.service;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;


public class TransactionService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;


    public void multiUpdate() throws FileNotFoundException{
        userDao.updateUser();
       /* int i = 10 / 0;*/
        /*if (true )throw new FileNotFoundException();*/
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bookDao.updateBook();
    }

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;


    public void multiTransactional() {

       /* try {
            bookService.updateBook();
        } catch(ArithmeticException e) {
            System.out.println(e);
        }*/
        bookService.updateBook();
        /*int i = 10 / 0;*/
        userService.updateUser();
    }
}
