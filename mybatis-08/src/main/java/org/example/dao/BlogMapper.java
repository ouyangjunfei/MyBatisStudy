package org.example.dao;

import org.example.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    /**
     * 插入博客数据
     *
     * @param blog 博客实体
     * @return 成功插入的数量
     */
    int addBlog(Blog blog);

    /**
     * 根据标题、作者模糊查询
     * <p>
     * 两者可以根据需要动态传入
     * <p>
     * 如果都传入了则两者都需要满足
     *
     * @param map 传入title或者author
     * @return 根据传入条件查询到的博客结果
     */
    List<Blog> queryBlogByIf(Map<String, Object> map);

    /**
     * 根据标题、作者模糊查询
     * <p>
     * 两者可以根据需要动态传入
     * <p>
     * 优先级 标题 > 作者
     * <p>
     * 只会根据一个条件查询
     * <p>
     * 如果不传入条件默认返回浏览量大于一定数值的博客
     *
     * @param map 传入title或者author，并包括一个views整型
     * @return 根据传入条件查询到的博客结果
     */
    List<Blog> queryBlogByChoose(Map<String, Object> map);


    /**
     * 更新指定ID的博客字段
     *
     * @param map 包含ID的K-V键值对
     * @return 成功修改的条数
     */
    int updateBlog(Map<String, Object> map);

    /**
     * 查询指定ID的博客
     *
     * @param list 包含若干ID值的list集合
     * @return 对应的博客
     */
    List<Blog> queryBlogByForeach(List<Integer> list);
}
