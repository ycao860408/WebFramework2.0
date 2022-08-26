package com.atguigu.mapper;

import com.atguigu.pojo.Bus;
import org.apache.ibatis.annotations.Param;

public interface BusMapper {
    Bus queryBussByIdWithCollection(Integer id);
    Bus queryBussByIdWithTwoSteps(Integer id);
    Bus queryBusById(Integer id);
    Bus queryBusWithIdAndLikeName(Integer id);
}
