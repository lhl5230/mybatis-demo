package com.lhl.mybaits.demo;

import org.apache.ibatis.io.Resources;
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
        String resource = "F:\\workspace_gupao\\mybatis-demo\\src\\main\\java\\com\\lhl\\mybaits\\demo\\mybatis-config.xml";
        InputStream inputStream = new FileInputStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = getSqlSession();
            System.out.println(sqlSession);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
