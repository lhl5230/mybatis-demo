package com.lhl.mybatis.plugins;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * Created by hongliang.liu on 2018/5/30.
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}),
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
        )})
public class ExamplePlugin implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        Object[] queryArgs = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) queryArgs[0];
        Object parameter = queryArgs[1];
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        String sql = boundSql.getSql();
        String name = invocation.getMethod().getName();
        queryArgs[1] = 2;
        System.err.println("拦截的方法名是：" + name);
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        System.err.println("代理的对象是：" + target);
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        Object name = properties.getProperty("name");//你好
        System.err.println(name);
    }
}
