# MyBatis学习记录

*参考视频*

[【狂神说Java】Mybatis最新完整教程IDEA版通俗易懂](https://www.bilibili.com/video/BV1NE411Q7Nx)

## 资源

[MyBatis3中文官网](https://mybatis.org/mybatis-3/zh/index.html)

以及B站视频下方**评论区**

[Maven仓库官网](https://mvnrepository.com/)

## 项目环境

- Java : 1.8 (要求)
- IDEA : 2020.3 Ultimate (建议)
- Maven : Bundled (3.6.3)
- MySQL : 5.7.31 (建议使用5.7.x)
- pom.xml的各项依赖没有特别需要注意的，使用最新或者较新版本都可以
- 使用IDEA的Database功能需要下载指定的Driver，这里我使用的是8.x.x的Driver，此处非必须配置，与项目无关

MySQL数据库如果用8.x.x版本涉及到配置参数URL的修改

## 模块内容

1. 基本的CRUD，没有配置别名，没有扫包，数据库参数写定于`mybatis-config.xml`文件
2. 在`mybatis-config.xml`中配置别名，同时从`config.properties`文件中获取数据库参数
3. 引入`resultMap`解决数据库列名与实体类字段名不一致的问题
4. 为MyBatis配置日志工厂，初学`log4j`，配置默认日志
   ```xml
   <settings>
     <setting name="logImpl" value="STDOUT_LOGGING"/>
   </settings>
   ```
5. 抛弃`***Mapper.xml`，改用注解的形式编写SQL语句
6. 使用扫包的方式添加`***Mapper.xml`文件；学生实体类有Teacher字段关联一个老师，需要查询所有老师及其教的学生，在`resultMap`中使用`association`
   标签映射学生实体类中的老师字段，需要指定`javaType`，没有查询结果的字段值为空
   ```xml
   <select id="getStudentsWithTeacher" resultMap="studentWithTeacher">
        select s.id sid, s.name sname, t.name tname
        from mybatis.teacher t,
             mybatis.student s
        where s.tid = t.id
   </select>
   
   <resultMap id="studentWithTeacher" type="student">
        <!--更加直观，写好SQL后只用调整查询结果的关系-->
        <result property="id" column="sid"/>
        <result property="name" column="sname"/>
        <association property="teacher" javaType="teacher">
            <result property="name" column="tname"/>
        </association>
   </resultMap>
   ```
7. 学生实体类用id关联一个老师，需要查询某个老师的所有学生，在`resultMap`中使用`collection`标签映射，需要用`ofType`指定泛型中的Java实体类
   ```xml
    <select id="getTeacherWithStudents" parameterType="_int" resultMap="teacherWithStudents">
        select t.id tid, t.name tname, s.id sid, s.name sname
        from mybatis.student s,
             mybatis.teacher t
        where t.id = #{id}
          and s.tid = t.id
    </select>
   
   <resultMap id="teacherWithStudents" type="teacher">
        <result property="id" column="tid"/>
        <result property="name" column="tname"/>
        <!--集合用collection
        集合中的泛型信息，使用ofType获取-->
        <collection property="students" ofType="student">
            <result property="id" column="sid"/>
            <result property="name" column="sname"/>
            <result property="tid" column="tid"/>
        </collection>
   </resultMap>
   ```
8. 使用MyBatis提供的数据库列名下划线方式自动转换驼峰式实体类字段名，学习`<where>`、`<set>`、`<if>`、`<choose>/<when>/<otherwise>`和`<foreach>`
   标签用于构建动态SQL；使用`concat`进行模糊查询防止SQL注入
   ```xml
   <settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
   </settings>
   
   <select id="queryBlogByIf" parameterType="map" resultType="blog">
        select * from mybatis.blog
        <where>
            <if test="title != null">
                title like concat('%',#{title},'%')
            </if>
            <if test="author != null">
                and author like concat('%',#{author},'%')
            </if>
        </where>
   </select>
   
   <update id="updateBlog" parameterType="map">
        update mybatis.blog
        <set>
            <if test="title != null">
                title = #{title},
            </if>
            <if test="author != null">
                author = #{author}
            </if>
        </set>
        where id = #{id}
   </update>
   ```
9. 开启MyBatis二级缓存
   ```xml
   <cache readOnly="true"/>
   ```