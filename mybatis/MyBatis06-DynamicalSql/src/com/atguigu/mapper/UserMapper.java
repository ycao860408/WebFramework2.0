package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@CacheNamespace
public interface UserMapper {
    List<User> queryUserLikeLastNameAndGender(User user);

    List<User> selectUserByUserChooseWhenOtherwise(User user);

    int updateUser(User user);

    List<User> queryUserByIds(List<Integer> list);

    int insertMany(@Param("users") List<User> users);


    List<User> queryUserAll();

    User queryUserById(Integer id);
}
