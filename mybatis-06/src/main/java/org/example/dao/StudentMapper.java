package org.example.dao;

import org.example.pojo.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 查询所有学生及其对应的老师信息
     *
     * @return 学生
     */
    List<Student> getStudentsWithTeacher();

    List<Student> getStudentsWithTeacher2();
}
