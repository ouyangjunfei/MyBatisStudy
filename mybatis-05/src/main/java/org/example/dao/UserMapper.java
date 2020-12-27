package org.example.dao;

import org.apache.ibatis.annotations.*;
import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 查询全部用户
     *
     * @return 一个包括所有用户的List
     */
    @Select("select * from user")
    List<User> getUserList();

    /**
     * 根据ID查询对应用户信息
     *
     * @param id 指定ID
     * @return 对应用户
     */
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);
    // 方法存在多个参数，所有的参数前面必须加上@Param("")注解

    @Insert("insert into user (name, pwd) values (#{name}, #{pwd})")
    int addUser(User user);

    @Update("update user set name = #{name}, pwd = #{pwd} where id = #{id}")
    int updateUser(Map<String, Object> map);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}
