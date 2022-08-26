package com.atguigu.test;

import com.atguigu.mapper.BookMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BookMapperTest {
    @Autowired
    public BookMapper bookMapper;

    @Test
    public void test1() {
        bookMapper.selectAll().forEach(System.out::println);
    }


}
