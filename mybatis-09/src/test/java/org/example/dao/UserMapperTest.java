package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.User;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {

    @Test
    public void queryUserByIdTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user1 = userMapper.queryUserById(1);
            System.out.println(user1);
            System.out.println("============================");

            Map<String, Object> map = new HashMap<>();

            map.put("id", 2);
            map.put("pwd", "0000");

            assertEquals(1, userMapper.updateUser(map));

            System.out.println("============================");

//            sqlSession.clearCache();    //手动清理缓存

            User user2 = userMapper.queryUserById(2);
            System.out.println(user2);
            System.out.println("============================");
            System.out.println(user1.equals(user2));
        }

        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user1 = userMapper.queryUserById(1);
            System.out.println(user1);
            System.out.println("============================");


            User user2 = userMapper.queryUserById(2);
            System.out.println(user2);
            System.out.println("============================");
            System.out.println(user1.equals(user2));
        }
    }
}