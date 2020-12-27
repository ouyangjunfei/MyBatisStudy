package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.Teacher;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

public class TeacherMapperTest {

    @Test
    public void getTeacherWithStudents() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            Teacher teacher = sqlSession.getMapper(TeacherMapper.class).getTeacherWithStudents(1);
            System.out.println(teacher);
        }
    }
}