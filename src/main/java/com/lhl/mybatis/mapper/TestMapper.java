package com.lhl.mybatis.mapper;

import com.lhl.mybatis.beans.Test;

/**
 * Created by hongliang.liu on 2018/5/28.
 */
public interface TestMapper {
    int insert(Test record);
    Test selectById(int id);
}
