package com.myxh.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import com.myxh.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{
    // 注入 userMapper
    // @Autowired
    // private UserMapper userMapper;
}
