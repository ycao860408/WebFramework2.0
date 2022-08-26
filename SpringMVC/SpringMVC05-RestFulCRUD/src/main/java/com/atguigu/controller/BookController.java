package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String queryBookAll(Map<String, Object> map) {
        List<Book> books = bookService.queryBookAll();
        map.put("books", books);
        return "bookList";
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable("id") Integer id) {
        System.out.println("haha");
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

    @PostMapping
    public String insertBook(Book book) {
        bookService.insertBook(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String queryBookById(@PathVariable("id") Integer id, Map<String, Object> map) {
        Book book = bookService.queryBookById(id);
        map.put("book", book);
        return "bookEdit";
    }

    @PutMapping
    public String updateBookById(Book book) {
        bookService.updateBookById(book);
        return "redirect:/books";
    }
}
