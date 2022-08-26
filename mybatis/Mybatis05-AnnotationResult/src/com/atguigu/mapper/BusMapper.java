package com.atguigu.mapper;

import com.atguigu.pojo.Bus;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface BusMapper {
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "id", property = "passengers", many = @Many(select = "com.atguigu.mapper.PassengerMapper.queryPassengerByBusId",fetchType = FetchType.LAZY))
    })
    @Select("select `id`, `name` from t_bus where `id` = #{id}")
    Bus queryBusByIdWithTwoSteps(@Param("id") Integer id);


    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "{bid=id, name=name}", property = "passengers", many = @Many(select = "com.atguigu.mapper.PassengerMapper.queryPassengerByBusIdOrLikeName",fetchType = FetchType.LAZY))
    })
    @Select("select `id`, `name` from t_bus where `id` = #{id}")
    Bus queryBusByIdAndLikeName(@Param("id") Integer id);
}
