package com.atguigu.controller;

import com.atguigu.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String queryAll() {
        System.out.println("Query All Books");
        return "ok";
    }

    @GetMapping("/{id}/{author}")
    public String queryById(@PathVariable("id") Integer id, @PathVariable(value = "author") String author) {
        System.out.println("query book" + id + " whose author is " + author);
        return "ok";
    }

    @PostMapping
    public String addBook(Book book){
        System.out.println(book);
        return "ok";
    }

    @PutMapping
    public String updateBook(Book book){
        System.out.println(book);
        return "ok";
    }

    @DeleteMapping
    public String deleteBookByName(String name) {
        System.out.println(name + " is deleted!");
        return "ok";
    }
}
