package com.atguigu.test;

import com.atguigu.mapper.BusMapper;
import com.atguigu.pojo.Bus;
import com.atguigu.pojo.Passenger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class BusTest {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    BusMapper busMapper = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis-Config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        busMapper = sqlSession.getMapper(BusMapper.class);
    }

    @Test
    public void queryBusByIdWithCollection() {
        Bus bus = busMapper.queryBussByIdWithCollection(1);
        System.out.println(bus);
        for (Passenger p : bus.getPassengers()) {
            System.out.println(p.getName());
        }
    }

    @Test
    public void queryBusByIdWithTwoSteps() {
        Bus bus = busMapper.queryBussByIdWithTwoSteps(1);
        System.out.println(bus.getName());
        System.out.println(bus.getPassengers().get(0).getName());
    }

    @Test
    public void queryBusByTwoArgs() {
        Bus bus = busMapper.queryBusWithIdAndLikeName(1);
        System.out.println(bus);
    }

    @After
    public void destroy() {
        sqlSession.close();
    }
}
