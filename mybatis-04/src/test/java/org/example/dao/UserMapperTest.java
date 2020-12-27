package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.example.pojo.User;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getUserByIdTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(3);
            System.out.println(user);
        }
    }

    @Test
    public void testLog4j() {
        logger.info("这是INFO等级");
        logger.warn("这是WARN等级");
        logger.debug("这是DEBUG等级");
        logger.error("这是ERROR等级");
    }

    @Test
    public void getUserByLimitTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("startIndex", 0);
            map.put("offset", 2);
            List<User> userList = userMapper.getUserByLimit(map);
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }
}