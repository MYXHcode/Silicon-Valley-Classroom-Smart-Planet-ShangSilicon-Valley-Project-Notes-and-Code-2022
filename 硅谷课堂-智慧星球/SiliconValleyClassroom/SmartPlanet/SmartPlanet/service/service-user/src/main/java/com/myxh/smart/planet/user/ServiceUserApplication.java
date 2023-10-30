package com.myxh.smart.planet.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author MYXH
 * @date 2023/10/15
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.myxh.smart.planet.user.mapper")
public class ServiceUserApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceUserApplication.class, args);
    }
}
