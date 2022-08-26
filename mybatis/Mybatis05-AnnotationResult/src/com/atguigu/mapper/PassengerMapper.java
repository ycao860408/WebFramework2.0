package com.atguigu.mapper;

import com.atguigu.pojo.Passenger;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PassengerMapper {

    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "bus_id", property = "busId")
    })
    @Select("select `id`, `name`, `bus_id` from t_passenger where `bus_id`= #{busId}")
    List<Passenger> queryPassengerByBusId(@Param("busId") Integer id);

    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "bus_id", property = "busId")
    })
    @Select("select `id`, `name`, `bus_id` from t_passenger where `bus_id`= #{bid} or `name` like concat('%', #{name} ,'%')")
    List<Passenger> queryPassengerByBusIdOrLikeName(@Param("bid") Integer id, @Param("name") String name);
}
