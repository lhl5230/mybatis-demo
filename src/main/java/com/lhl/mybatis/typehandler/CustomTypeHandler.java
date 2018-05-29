package com.lhl.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hongliang.liu on 2018/5/29.
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
//@MappedTypes({String.class}) //泛型有此注释功能
public class CustomTypeHandler extends BaseTypeHandler<String> {
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter+"aaa");
    }

    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getObject(columnName) + "bbb";
    }

    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getObject(columnIndex) + "bbb";
    }

    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getString(columnIndex);
    }
}
