package com.atguigu.service.impl;

import com.atguigu.mapper.BookMapper;
import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    @Override
    public int deleteById(Integer id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Book book) {

        /*int i = 1 / 0;
        bookMapper.insert(book);*/
        return bookMapper.insert(book);
    }

    @Override
    public Book selectByPrimaryKey(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Book> selectAll() {
        return bookMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return 0;
    }
}
