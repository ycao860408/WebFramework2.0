package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(id = false, column = "last_name", property = "lastName"),
            @Result(id = false, column = "gender", property = "gender")
    })
    @Select("select `id`, `last_name`, `gender` from t_user")
    List<User> queryUserAll();
}
