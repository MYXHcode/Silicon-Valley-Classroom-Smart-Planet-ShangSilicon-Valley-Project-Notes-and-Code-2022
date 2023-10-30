package com.myxh.smart.planet.activity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



/**
 * @author MYXH
 * @date 2023/10/15
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.myxh.smart.planet")
@MapperScan("com.myxh.smart.planet.activity.mapper")
public class ServiceActivityApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceActivityApplication.class, args);
    }
}
