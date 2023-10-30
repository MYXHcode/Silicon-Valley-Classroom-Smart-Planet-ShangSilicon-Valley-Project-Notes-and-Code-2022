package com.myxh.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MyBatisPlusDemoApplicationTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    // 注入 user
    @Autowired
    User user;

    /**
     * 查询 User 表中的所有用户数据
     */
    @Test
    public void testFindAllUsers()
    {
        List<User> userList = userMapper.selectList(null);

        for (User user : userList)
        {
            System.out.println("user = " + user);
        }
    }

    /**
     * 添加用户数据
     */
    @Test
    public void testAddUser()
    {
        user.setName("末影小黑xh");
        user.setAge(21);
        user.setEmail("1735350920@qq.com");
        int rows = userMapper.insert(user);
        System.out.println("rows = " + rows);

        // 添加成功之后，把添加之后生成 id 值，回填到 user 对象里面
        System.out.println("user = " + user);
    }

    /**
     * 修改用户数据
     */
    @Test
    public void testUpdateUser()
    {
        // 1、根据 id 查询
        User userById = userMapper.selectById(1706273960528822274L);

        // 2、设置修改值
        userById.setEmail("myxh@qq.com");

        // 3、调用方法实现修改
        int rows = userMapper.updateById(userById);
        System.out.println("rows = " + rows);
        System.out.println("userById = " + userById);
    }

    /**
     * 分页查询 User 表中的所有用户数据
     */
    @Test
    public void testFindAllUsersByPage()
    {
        // 创建 Page 对象，传递两个参数：当前页、每页显示记录数
        Page<User> userPage = new Page<>(1, 5);

        // 调用 userMapper 的方法实现分页
        // IPage<User> userPageModel = userMapper.selectPage(userPage, null);
        userMapper.selectPage(userPage, null);
        List<User> records = userPage.getRecords();
        System.out.println("records = " + records);
        long pages = userPage.getPages();
        System.out.println("pages = " + pages);
        long size = userPage.getSize();
        System.out.println("size = " + size);
        long total = userPage.getTotal();
        System.out.println("total = " + total);
        boolean hasNext = userPage.hasNext();
        System.out.println("hasNext = " + hasNext);
        boolean hasPrevious = userPage.hasPrevious();
        System.out.println("hasPrevious = " + hasPrevious);
    }

    /**
     * 根据 id 删除用户数据（逻辑删除）
     */
    @Test
    public void testDeleteUserById()
    {
        int rows = userMapper.deleteById(9L);
        System.out.println("rows = " + rows);
    }

    /**
     * 根据 id 批量删除用户数据（逻辑删除）
     */
    @Test
    public void testDeleteBatchUserById()
    {
        int rows = userMapper.deleteBatchIds(Arrays.asList(5, 6, 7, 8, 9));
        System.out.println("rows = " + rows);
    }
}
