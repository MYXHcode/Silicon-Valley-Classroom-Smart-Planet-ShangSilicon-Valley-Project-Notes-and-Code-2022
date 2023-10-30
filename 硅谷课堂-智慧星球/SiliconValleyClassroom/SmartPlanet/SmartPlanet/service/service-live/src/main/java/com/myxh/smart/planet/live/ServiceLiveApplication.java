package com.myxh.smart.planet.live;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author MYXH
 * @date 2023/10/26
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.myxh.smart.planet")
@MapperScan("com.myxh.smart.planet.live.mapper")
public class ServiceLiveApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceLiveApplication.class, args);
    }
}
