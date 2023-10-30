package com.myxh.smart.planet.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author MYXH
 * @date 2023/10/16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.myxh.smart.planet")
@MapperScan("com.myxh.smart.planet.wechat.mapper")
public class ServiceWechatApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceWechatApplication.class, args);
    }
}
