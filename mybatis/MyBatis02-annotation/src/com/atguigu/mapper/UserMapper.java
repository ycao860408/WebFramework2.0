package com.atguigu.mapper;

import com.atguigu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select `id`, `last_name`, `gender` from t_user where `id` = #{id}")
    User queryUserById(Integer id);

    @Select("select `id`, `last_name`, `gender` from t_user")
    List<User> queryUserAll();

    @Update("delete from t_user where id = #{id}")
    int deleteUserById(Integer id);

    @Update("update t_user set `last_name` = #{lastName}, `gender` = #{gender} where `id` = #{id}")
    int updateUserById(User user);

    @Insert("insert into t_user (last_name, gender) values (#{lastName}, #{gender})")
    @SelectKey(before = false, keyColumn = "id", keyProperty = "id", statement = {"select last_insert_id()"}, resultType = Integer.class)
    int insertUser(User user);

}
