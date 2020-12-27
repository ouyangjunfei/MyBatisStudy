package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.Teacher;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

public class TeacherMapperTest {

    @Test
    public void getTeachers() {
    }

    @Test
    public void getTeacherById() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = teacherMapper.getTeacherById(1);
            System.out.println(teacher);
        }
    }
}