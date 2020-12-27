package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.Student;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {

    @Test
    public void getStudentsWithTeacher() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> studentList = studentMapper.getStudentsWithTeacher2();
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }
}