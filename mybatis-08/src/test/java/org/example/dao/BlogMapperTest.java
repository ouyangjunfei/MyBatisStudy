package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.Blog;
import org.example.utils.IdUtils;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class BlogMapperTest {

    @Test
    public void addBlogTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog(IdUtils.getUUID(), "Java初学必看", "欧阳", new Date(), 6542);
            assertEquals(1, blogMapper.addBlog(blog));
        }
    }

    @Test
    public void queryBlogByIfTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

            Map<String, Object> map = new HashMap<>();

            map.put("title", "Java");
//            map.put("author", "欧阳");

            List<Blog> blogList = blogMapper.queryBlogByIf(map);
            for (Blog blog : blogList) {
                System.out.println(blog);
            }
        }
    }

    @Test
    public void queryBlogByChooseTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

            Map<String, Object> map = new HashMap<>();

            map.put("title", "Java");
//            map.put("author", "欧阳");
            map.put("views", 4000);

            List<Blog> blogList = blogMapper.queryBlogByChoose(map);
            for (Blog blog : blogList) {
                System.out.println(blog);
            }
        }
    }

    @Test
    public void updateBlogTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

            Map<String, Object> map = new HashMap<>();

            map.put("id", "5");
//            map.put("title", "Linux基础");
//            map.put("author", "张三");

            assertEquals(1, blogMapper.updateBlog(map));

        }
    }

    @Test
    public void queryBlogByForeachTest() {
        try (SqlSession sqlSession = MyBatisUtils.getSqlSession()) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

            List<Integer> list = new ArrayList<>();

            list.add(1);
            //list.add(3);
            //list.add(6);

            List<Blog> blogList = blogMapper.queryBlogByForeach(list);
            for (Blog blog : blogList) {
                System.out.println(blog);
            }

        }
    }
}