package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {
    @Autowired
    BookService bookService;

    @Test
    public void test() {
        bookService.selectAll().forEach(System.out::println);
    }

    @Test
    public void tx() {
        bookService.insert(new Book(null, "時間簡史","霍金", new BigDecimal("34.2"), 123, 22));
    }
}
