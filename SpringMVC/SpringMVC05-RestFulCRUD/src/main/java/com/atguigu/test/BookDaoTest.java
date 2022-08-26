package com.atguigu.test;


import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@ContextConfiguration(locations = {"classpath:SpringMVC.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BookDaoTest {

    @Autowired
    BookDao bookDao;

    @Test
    public void test1() {
        Book book = bookDao.queryBookById(2);
        System.out.println(book);
    }

    @Test
    public void test2() {
        bookDao.queryBookAll().forEach(System.out::println);
    }

    @Test
    public void test3() {
        //Integer id, String name, String author, BigDecimal price, Integer sales, Integer stock
        System.out.println(bookDao.insertBook(new Book(null, "射雕英雄傳", "金庸", new BigDecimal("89.32"), 32, 44)));
    }

    @Test
    public void test4() {
        System.out.println(bookDao.deleteBookById(21));
    }

    @Test
    public void test5() {
        System.out.println(bookDao.updateBookById(new Book(22, "神雕俠侶", "金庸", new BigDecimal("89.32"), 32, 44)));
    }
}
