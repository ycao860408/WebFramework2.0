package com.atguigu.service;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.UserDao;
import com.sun.xml.internal.ws.server.provider.SyncProviderInvokerTube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

@Service
public class TransactionService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;


    @Transactional(timeout= 3)
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

    @Transactional(propagation = Propagation.REQUIRED)
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
