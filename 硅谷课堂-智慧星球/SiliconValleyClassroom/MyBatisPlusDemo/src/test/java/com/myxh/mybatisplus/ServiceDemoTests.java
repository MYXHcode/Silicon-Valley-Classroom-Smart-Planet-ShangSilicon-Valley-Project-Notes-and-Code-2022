package com.myxh.mybatisplus;

import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@SpringBootTest
public class ServiceDemoTests
{
    // 注入 userService
    @Autowired
    private UserService userService;

    /**
     * 查询 User 表中的所有用户数据
     */
    @Test
    public void testFindAllUsers()
    {
        List<User> userList = userService.list();

        for (User user : userList)
        {
            System.out.println("user = " + user);
        }
    }
}
