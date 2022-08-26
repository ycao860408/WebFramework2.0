package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book queryBookById(@PathVariable("id") Integer id) {
        return bookService.selectByPrimaryKey(id);
    }

    @GetMapping
    public List<Book> queryAll() {
        return bookService.selectAll();
    }

}
