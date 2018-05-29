package com.lhl.mybatis.beans;

import lombok.Data;

/**
 * Created by hongliang.liu on 2018/5/28.
 */
@Data
public class Test {
    private Integer id;
    private Integer nums;
    private String name;

    public Test(Integer nums, String name) {
        this.nums = nums;
        this.name = name;
    }

    public Test(Integer id, Integer nums, String name) {
        this(nums,name);
        this.id = id;

    }
}
