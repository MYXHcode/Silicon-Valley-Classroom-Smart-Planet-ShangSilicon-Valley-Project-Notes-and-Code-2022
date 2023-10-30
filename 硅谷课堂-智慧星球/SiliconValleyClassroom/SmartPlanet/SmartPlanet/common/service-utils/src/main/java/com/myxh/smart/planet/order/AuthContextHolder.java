package com.myxh.smart.planet.order;

/**
 * @author MYXH
 * @date 2023/10/21
 * @description 获取登录用户信息类
 */
public class AuthContextHolder
{
    // 后台管理用户 id
    private static final ThreadLocal<Long> adminId = new ThreadLocal<>();

    // 会员用户 id
    private static final ThreadLocal<Long> userId = new ThreadLocal<>();

    public static Long getAdminId()
    {
        return adminId.get();
    }

    public static void setAdminId(Long _adminId)
    {
        adminId.set(_adminId);
    }

    public static Long getUserId()
    {
        return userId.get();
    }

    public static void setUserId(Long _userId)
    {
        userId.set(_userId);
    }
}
