package com.myxh.smart.planet.vod.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/10/5
 * @description 常量类，读取配置文件 application.properties 中的配置
 */
@Component
public class ConstantPropertiesUtil implements InitializingBean
{
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String END_POINT;
    public static String BUCKET_NAME;
    @Value("${tencent.cos.file.secretid}")
    private String secretId;
    @Value("${tencent.cos.file.secretkey}")
    private String secretKey;
    @Value("${tencent.cos.file.region}")
    private String region;
    @Value("${tencent.cos.file.bucketname}")
    private String bucketName;

    @Override
    public void afterPropertiesSet() throws Exception
    {
        ACCESS_KEY_ID = secretId;
        END_POINT = region;
        ACCESS_KEY_SECRET = secretKey;
        BUCKET_NAME = bucketName;
    }
}
