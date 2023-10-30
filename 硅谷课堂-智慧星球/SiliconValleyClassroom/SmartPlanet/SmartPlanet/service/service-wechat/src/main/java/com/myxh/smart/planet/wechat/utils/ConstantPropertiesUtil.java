package com.myxh.smart.planet.wechat.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/10/17
 * @description 常量类，读取配置文件 application.properties 中的配置
 */
@Component
public class ConstantPropertiesUtil implements InitializingBean
{
    @Value("${wechat.appId}")
    private String appId;

    @Value("${wechat.appSecret}")
    private String appSecret;

    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception
    {
        ACCESS_KEY_ID = appId;
        ACCESS_KEY_SECRET = appSecret;
    }
}
