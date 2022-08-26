package com.atguigu.mapper;

import com.atguigu.pojo.Passenger;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PassengerMapper {
    List<Passenger> queryPassengersByBusId(Integer id);
    Passenger queryPassengerById(Integer id);
    Passenger queryPassengerById2(Integer id);
    List<Passenger> queryPassengerWithBusIdAndLikeName(@Param("bid") Integer bid, @Param("name") String name);
}
