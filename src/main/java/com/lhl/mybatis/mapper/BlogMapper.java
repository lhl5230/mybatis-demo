package com.lhl.mybatis.mapper;

import com.lhl.mybatis.beans.Blog;

/**
 * Created by hongliang.liu on 2018/5/28.
 */
public interface BlogMapper {
    Blog selectBlog(int id);
}
