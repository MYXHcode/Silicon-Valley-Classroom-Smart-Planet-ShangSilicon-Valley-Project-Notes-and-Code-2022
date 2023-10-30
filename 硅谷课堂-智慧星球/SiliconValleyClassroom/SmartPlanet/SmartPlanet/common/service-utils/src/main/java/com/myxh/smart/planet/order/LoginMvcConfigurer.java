package com.myxh.smart.planet.order;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Configuration
public class LoginMvcConfigurer implements WebMvcConfigurer
{
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        // 添加自定义拦截器，设置路径
        registry.addInterceptor(new UserLoginInterceptor(redisTemplate)).addPathPatterns("/api/**");
        registry.addInterceptor(new AdminLoginInterceptor(redisTemplate)).addPathPatterns("/admin/**");
    }
}
