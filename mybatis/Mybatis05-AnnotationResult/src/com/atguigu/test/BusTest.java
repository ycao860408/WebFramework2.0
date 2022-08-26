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
    public void queryBusById() {
        Bus bus = busMapper.queryBusByIdWithTwoSteps(1);
        System.out.println(bus.getId());
        System.out.println(bus.getName());
        for (Passenger pass: bus.getPassengers()) {
            System.out.println(pass.getId() + " " + pass.getName() + " " + pass.getBusId());
        }
    }

    @Test
    public void queryBusByIdAndLikeName() {
        Bus bus = busMapper.queryBusByIdAndLikeName(1);
        System.out.println(bus.getId());
        System.out.println(bus.getName());
        for (Passenger pass: bus.getPassengers()) {
            System.out.println(pass.getId() + " " + pass.getName() + " " + pass.getBusId());
        }
    }



    @After
    public void destroy() {
        sqlSession.close();
    }
}
