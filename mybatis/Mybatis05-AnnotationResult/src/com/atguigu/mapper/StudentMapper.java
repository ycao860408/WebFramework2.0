package com.atguigu.mapper;

import com.atguigu.pojo.Student;
import com.atguigu.pojo.Teacher;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface StudentMapper {

    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(id = false, column = "name", property = "name"),
            @Result(id = false, column = "tid", property = "teacher.id"),
            @Result(id = false, column = "tname", property = "teacher.name")
    })
    @Select("select stu.`id`, stu.`name`, tea.`id` tid, tea.`name` tname \n" +
            "            from t_student stu  \n" +
            "            left join  \n" +
            "            t_teacher tea \n" +
            "            on stu.`teacher_id` = tea.`id` \n" +
            "            where stu.`id` = #{id};")
    Student queryStudentById(@Param("id") Integer id);

    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(column = "teacher_id",property = "teacher",one=@One(select = "com.atguigu.mapper.TeacherMapper.queryTeacherById", fetchType = FetchType.LAZY))
    })
    @Select("select `id`, `name`, `teacher_id` from t_student where `id` = #{id}")
    Student queryStudentByIdWithTwoStep(@Param("id") Integer id);
}
