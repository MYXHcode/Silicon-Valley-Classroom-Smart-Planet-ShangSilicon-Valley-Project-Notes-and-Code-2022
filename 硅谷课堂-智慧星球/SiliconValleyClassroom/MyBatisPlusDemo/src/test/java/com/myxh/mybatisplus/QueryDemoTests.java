package com.myxh.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@SpringBootTest
public class QueryDemoTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * queryWrapper
     * ge、gt、le、lt
     */
    @Test
    public void testQuery1()
    {
        // 创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // ge、gt、le、lt
        // ge 为例有两个参数：第一个参数是表字段名称，第二个参数是值
        wrapper.ge("age", 21);

        // 调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }

    /**
     * queryWrapper
     * eq、ne
     */
    @Test
    public void testQuery2()
    {
        // 创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // eq、ne
        // eq 为例有两个参数：第一个参数是表字段名称，第二个参数是值
        wrapper.eq("name", "MYXH");

        // 调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }

    /**
     * queryWrapper
     * like、likeLeft、likeRight
     */
    @Test
    public void testQuery3()
    {
        // 创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // like、likeLeft、likeRight
        // like、likeLeft 为例有两个参数：第一个参数是表字段名称，第二个参数是值
        // wrapper.like("name","MYXH");
        wrapper.likeLeft("name", "XH");

        // 调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }

    /**
     * queryWrapper
     * orderByDesc、orderByAsc
     */
    @Test
    public void testQuery4()
    {
        // 创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // orderByDesc、orderByAsc
        // orderByDesc 为例有一个参数：参数是表字段名称
        wrapper.orderByDesc("id");

        // 调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }

    /**
     * LambdaQueryWrapper
     */
    @Test
    public void testLambdaQuery1()
    {
        // 创建条件构造对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName, "MYXH");

        // 调用方法查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }

    /**
     * LambdaQueryWrapper
     */
    @Test
    public void testLambdaQuery2()
    {
        // 创建条件构造对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName, "MYXH");

        // 调用方法查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }
}
