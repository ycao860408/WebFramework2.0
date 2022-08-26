package com.atguigu.mapper;

import com.atguigu.pojo.Student;

public interface StudentMapper {
    Student queryStudentById(Integer id);
    Student queryStudAndTeaByIdWithAssociation(Integer id);
    Student queryStuByTwoSteps(Integer id);
}
