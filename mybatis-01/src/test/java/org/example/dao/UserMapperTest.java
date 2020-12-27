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
    public void getUserListTest() {
        //1.获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //2.获取Mapper对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //3.执行SQL
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println("user = " + user);
        }
        //4.关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserByIdTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getUserByMapTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Andy");
        map.put("id", 3);
        User user = userMapper.getUserByMap(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUserTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        assertEquals(1, userMapper.addUser(new User("Andrew", "984332")));
        //提交事务--重要
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUserByMapTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();

        map.put("name", "Jane");
        map.put("pwd", "322222");
        assertEquals(1, userMapper.addUserByMap(map));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("id", 2);
            map.put("name", "Andy");
            map.put("pwd", "999999");
            assertEquals(1, userMapper.updateUser(map));
            sqlSession.commit();
        }
    }

    @Test
    public void deleteUserTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        assertEquals(1, userMapper.deleteUser(1));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserLikeTest() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserLike("And");
        for (User user : userList) {
            System.out.println("user = " + user);
        }
        sqlSession.close();
    }
}