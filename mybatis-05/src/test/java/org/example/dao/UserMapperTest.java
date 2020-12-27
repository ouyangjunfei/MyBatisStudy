package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.User;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {

    @Test
    public void getUserList() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void getUserById() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(2);
            System.out.println(user);
        }
    }

    @Test
    public void addUserTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            assertEquals(1, userMapper.addUser(new User("Sunny", "124332")));
        }
    }

    @Test
    public void updateUserTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("id", 2);
            map.put("name", "Alice");
            map.put("pwd", "8888");
            assertEquals(1, userMapper.updateUser(map));
        }
    }

    @Test
    public void deleteUserTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            assertEquals(1, userMapper.deleteUser(10));
        }
    }
}