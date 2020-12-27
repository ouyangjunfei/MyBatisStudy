package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

import java.util.Map;

public interface UserMapper {

    User queryUserById(@Param("id") int id);

    int updateUser(Map<String, Object> map);
}
