package com.atguigu.test;

import com.atguigu.mapper.StudentMapper;
import com.atguigu.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class StudentTest {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession sq = null;
    StudentMapper studentMapper = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("MyBatis-Config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sq = sqlSessionFactory.openSession(true);
        studentMapper = sq.getMapper(StudentMapper.class);
    }

    @Test
    public void queryStudentById() {
        Student student = studentMapper.queryStudentById(1);
        System.out.println(student );
    }

    @Test
    public void queryStudAndTeaByIdWithAssociation() {
        System.out.println(studentMapper.queryStudAndTeaByIdWithAssociation(1));
    }

    @Test
    public void queryStudentByTwoStep() {
        Student student = studentMapper.queryStuByTwoSteps(1);
        System.out.println(student.getName());
        System.out.println(student.getTeacher().getName());
    }

    @After
    public void destroy() {
        sq.close();
    }
}
