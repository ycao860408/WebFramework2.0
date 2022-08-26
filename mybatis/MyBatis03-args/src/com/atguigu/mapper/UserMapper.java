package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User queryUserById(Integer id);

    List<User> queryUserByIdOrGender(@Param("id") Integer id, @Param("gender") Integer gender);

    List<User> queryUserByMap(Map<String, Object> map);

    int insertUser(User user);

    //int insertUsers(User user1, User user2);
    int insertUsers(@Param("user1") User user1,@Param("user2") User user2);

    List<User> queryUsersLikeName(String name);
}
