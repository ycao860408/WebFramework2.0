package com.atguigu.mapper;

import com.atguigu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("select `id`, `name` from t_teacher where `id` = #{id}")
    Teacher queryTeacherById(@Param("id") Integer id);
}
