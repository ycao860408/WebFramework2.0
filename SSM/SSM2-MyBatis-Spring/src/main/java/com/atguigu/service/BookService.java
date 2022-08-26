package com.atguigu.service;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookService {
    public int deleteById(Integer id);

    public int insert(Book book);

    public Book selectByPrimaryKey(Integer id);

    public List<Book> selectAll();

    public int updateByPrimaryKey(Book record);
}
