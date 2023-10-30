package com.myxh.smart.planet.order;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author MYXH
 * @date 2023/10/21
 */
public class AdminLoginInterceptor implements HandlerInterceptor
{
    private final RedisTemplate redisTemplate;

    public AdminLoginInterceptor(RedisTemplate redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        this.initUserLoginVo(request);

        return true;
    }

    private void initUserLoginVo(HttpServletRequest request)
    {
        String userId = request.getHeader("userId");

        if (!StringUtils.hasLength(userId))
        {
            AuthContextHolder.setAdminId(1L);
        }
        else
        {
            AuthContextHolder.setAdminId(Long.parseLong(userId));
        }
    }
}
