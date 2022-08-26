package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User queryUserById(Integer id);

    List<User> queryUserAll();

    int updateUserById(User user);

    int deleteUserById(Integer id);

    int insertUser(User user);

    @MapKey("id")
    Map<Integer, User> queryUserMapById(Integer id);

    @MapKey("id")
    Map<Integer, User> queryUserAllMap();
}
