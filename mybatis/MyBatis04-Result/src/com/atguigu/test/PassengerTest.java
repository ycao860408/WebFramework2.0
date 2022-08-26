package com.atguigu.test;


import com.atguigu.mapper.BusMapper;
import com.atguigu.mapper.PassengerMapper;
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
import java.util.List;

public class PassengerTest {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sqlSession = null;
    PassengerMapper passengerMapper = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis-Config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        passengerMapper = sqlSession.getMapper(PassengerMapper.class);
    }
    @Test
    public void queryPassengerByBusId() {
        List<Passenger> passengers = passengerMapper.queryPassengersByBusId(1);
        for (Passenger pass : passengers) {
            //System.out.println(pass.getId() + " " + pass.getName() + " " + pass.getBusId());
        }
    }

    @Test
    public void queryPassengerById() {
        Passenger pass = passengerMapper.queryPassengerById(1);

    }
     @Test
     public void queryPassengerById2() {
         Passenger pass = passengerMapper.queryPassengerById2(1);
         //System.out.println(pass.getId() + " " + pass.getName() + " " + pass.getBus().getName());
     }


    @After
    public void destroy() {
        sqlSession.close();
    }
}
