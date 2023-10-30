package com.myxh.smart.planet.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author MYXH
 * @date 2023/10/14
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.myxh.smart.planet")
public class ServiceOrderApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }
}
