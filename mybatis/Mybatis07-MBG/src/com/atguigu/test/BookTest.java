package com.atguigu.test;

import com.atguigu.mapper.BookMapper;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.BookExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BookTest {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    BookMapper bookMapper = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis-Config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        bookMapper = sqlSession.getMapper(BookMapper.class);
    }

    @Test
    public void countByExample() {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andNameLike("%媳妇%");
        BookExample.Criteria or = bookExample.or();
        or.andPriceBetween(new BigDecimal("11"), new BigDecimal("20"));
        System.out.println(bookMapper.countByExample(bookExample));
    }

    @Test
    public void select1() {
        Book book = bookMapper.selectByPrimaryKey(1);
        System.out.println(book);
    }

    @Test
    public void select2() {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andAuthorLike("%哥%");
        bookExample.setOrderByClause("price desc");
        List<Book> books = bookMapper.selectByExample(bookExample);
        books.forEach(System.out::println);
    }

    @Test
    public void delete1() {
        System.out.println(bookMapper.deleteByPrimaryKey(3));
    }

    @Test
    public void delete2() {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andIdIn(Arrays.asList(1, 2, 4));
        System.out.println(bookMapper.deleteByExample(bookExample));
    }

    @Test
    public void insert1() {
        //String name, String author, BigDecimal price, Integer sales, Integer stock
        Book book = new Book(null, "笑傲江湖", "金庸", new BigDecimal("34.2"), 100, 2000);
        bookMapper.insert(book);
    }

    @Test
    public void insert2() {
        Book book = new Book(null, "射雕英雄傳", null, new BigDecimal("34.2"), 100, 2000);
        bookMapper.insertSelective(book);
    }

    @Test
    public void update1() {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andIdEqualTo(9);
        Book book = new Book(9, "射雕英雄傳", "金庸", new BigDecimal("34.2"), 10, 205);
        bookMapper.updateByExample(book, bookExample);
    }

    @Test
    public void update2() {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        criteria.andIdEqualTo(8);
        Book book = new Book(null, "小李飛刀", "古龍", new BigDecimal("34.2"), 10, 205);
        bookMapper.updateByExampleSelective(book, bookExample);
    }

    @After
    public void destroy() {
        sqlSession.close();
    }
}
