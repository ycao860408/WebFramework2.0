package com.atguigu.dao;

import com.atguigu.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public Book queryBookById(Integer id) {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock` from t_book where `id` = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
    }

    public List<Book> queryBookAll() {
        String sql = "select `id`, `name`, `author`, `price`, `sales`, `stock` from t_book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
    }

    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where `id` = ?";
        return jdbcTemplate.update(sql, id);
    }

    public int insertBook(Book book) {
        String sql = "insert into t_book (`name`, `author`, `price`, `sales`, `stock`) values(?,?,?,?,?)";
        return jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock());
    }

    public int updateBookById(Book book) {
        String sql = "update t_book set `name` = ?, `author` = ? , `price` = ?, `sales` = ? , `stock` = ? where `id` = ?";
        return jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getId());
    }
}
