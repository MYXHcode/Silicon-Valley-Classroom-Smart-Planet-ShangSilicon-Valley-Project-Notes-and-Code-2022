package com.myxh.smart.planet.order;

import com.myxh.smart.planet.jwt.JwtHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author MYXH
 * @date 2023/10/21
 */
public class UserLoginInterceptor implements HandlerInterceptor
{
    private final RedisTemplate redisTemplate;

    public UserLoginInterceptor(RedisTemplate redisTemplate)
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
        String token = request.getHeader("token");
        System.out.println("token = " + token);

        if (!StringUtils.hasLength(token))
        {
            AuthContextHolder.setUserId(1L);
        }

        else
        {
            Long userId = JwtHelper.getUserId(token);
            System.out.println("当前用户 userId：" + userId);

            if (ObjectUtils.isEmpty(userId))
            {
                AuthContextHolder.setUserId(1L);
            }
            else
            {
                AuthContextHolder.setUserId(userId);
            }
        }
    }
}
