package org.example.dao;

import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 查询全部用户
     *
     * @return 一个包括所有用户的List
     */
    List<User> getUserList();

    /**
     * 根据ID查询对应用户信息
     *
     * @param id 指定ID
     * @return 对应用户
     */
    User getUserById(int id);

}
