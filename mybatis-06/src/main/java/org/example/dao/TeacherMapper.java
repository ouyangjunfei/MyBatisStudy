package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> getTeachers();

    Teacher getTeacherById(@Param("id") int id);
}
