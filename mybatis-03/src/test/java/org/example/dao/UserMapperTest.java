package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.User;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

public class UserMapperTest {

    @Test
    public void getUserByIdTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(3);
            System.out.println(user);
        }
    }
}