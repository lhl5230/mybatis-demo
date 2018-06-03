package com.lhl.mybatis.demo;

import com.lhl.mybatis.beans.Blog;
import com.lhl.mybatis.beans.Test;
import com.lhl.mybatis.mapper.BlogMapper;
import com.lhl.mybatis.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hongliang.liu on 2018/5/27.
 */
public class SqlSessionFactoryDemo1 {
    public static SqlSession getSqlSession() throws IOException {
        String resource = "F:\\workspace_gupao\\mybatis-demo\\src\\main\\java\\com\\lhl\\mybatis\\demo\\mybatis-config.xml";
        InputStream inputStream = new FileInputStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
//            Test test = new Test(2,"lhl");
//            System.out.println(testMapper.insert(test));

            System.out.println(testMapper.selectById(1));
            sqlSession.commit();

//            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//            Blog blog = mapper.selectBlog(1);
//            System.out.println(blog);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
