package com.atguigu.controller;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/list")
    public String queryBookAll(Map<String, Object> map) {
        List<Book> books = bookService.queryBookAll();
        map.put("books", books);
        return "bookList";
    }

    @RequestMapping("/deleteById")
    public String deleteBookById(Integer id) {
        bookService.deleteBookById(id);
        return "redirect:/books/list";
    }

    @RequestMapping("/insertBook")
    public String insertBook(Book book) {
        bookService.insertBook(book);
        return "redirect:/books/list";
    }

    @RequestMapping("/queryBookById")
    public String queryBookById(Integer id, Map<String, Object> map) {
        Book book = bookService.queryBookById(id);
        map.put("book", book);
        return "bookEdit";
    }

    @RequestMapping("/updateBookById")
    public String updateBookById(Book book) {
        bookService.updateBookById(book);
        return "redirect:/books/list";
    }
}
