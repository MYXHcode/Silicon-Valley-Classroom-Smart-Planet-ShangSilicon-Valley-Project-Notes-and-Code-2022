package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/2
 */
@RestController
@RequestMapping("/admin/vod/user")
// 允许跨域请求
// @CrossOrigin
public class UserLoginController
{
    /**
     * login 用户登录
     *
     * @return Result 全局统一返回结果
     */
    @PostMapping("login")
    public Result<Map<String, Object>> login()
    {
        // 前端接口：{"code":20000,"data":{"token":"admin-token"}}
        Map<String, Object> data = new HashMap<>();
        data.put("token", "admin-token");

        return Result.ok(data);
    }

    /**
     * info 用户信息
     *
     * @return Result 全局统一返回结果
     */
    @GetMapping("info")
    public Result<Map<String, Object>> info()
    {
        /*
        前端接口：
        {
            "code":20000,
            "data":
                {
                    "roles":["admin"],
                    "introduction":"I am a super administrator",
                    "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif"
                    "name":"Super Admin"
                }
        }
         */

        Map<String, Object> data = new HashMap<>();
        data.put("roles", "admin");
        data.put("introduction", "我是一名超级管理员");
        data.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        data.put("name", "超级管理员");

        return Result.ok(data);
    }

    /**
     * logout 退出登录
     *
     * @return Result 全局统一返回结果
     */
    @PostMapping("logout")
    public Result<Void> logout()
    {
        // 前端接口：{"code":20000,"data":null}
        return Result.ok(null);
    }
}
