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

    /**
     * 增加一个用户
     *
     * @param user 用户实体
     * @return 插入成功与否
     */
    int addUser(User user);

    /**
     * 修改一个用户
     *
     * @param user 用户实体
     * @return 修改成功与否
     */
    int updateUser(User user);

    /**
     * 删除一个用户
     *
     * @param id 用户ID
     * @return 删除成功与否
     */
    int deleteUser(int id);

}
