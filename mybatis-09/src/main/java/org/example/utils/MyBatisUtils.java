package org.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    public static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到SqlSession对象
     *
     * @return 成功获取则为SqlSession对象，否则为null
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(true);
    }

}
