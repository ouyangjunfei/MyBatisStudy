package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.User;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void getUserListTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }
}