package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    /**
     * 获得指定老师下的所有学生及老师的信息
     *
     * @param id 老师的ID
     * @return 老师的信息
     */
    Teacher getTeacherWithStudents(@Param("id") int id);

    List<Teacher> getTeachers();
}
