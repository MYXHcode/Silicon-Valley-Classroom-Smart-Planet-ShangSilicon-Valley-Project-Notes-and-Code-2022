package com.myxh.smart.planet.user.controller;

import com.myxh.smart.planet.model.user.UserInfo;
import com.myxh.smart.planet.user.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 用户信息 前端控制器
 * </p>
 */
@Tag(name = "用户信息管理", description = "用户信息管理接口")
@RestController
@RequestMapping("/admin/user/user/info")
public class UserInfoController
{
    @Autowired
    private UserInfoService userService;

    /**
     * 根据 id 查询用户信息
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询", description = "根据 id 查询用户信息")
    @GetMapping("inner/get/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") Long id)
    {
        UserInfo userInfo = userService.getById(id);

        return userInfo;
    }
}
