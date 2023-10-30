package com.myxh.smart.planet.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author MYXH
 * @date 2023/10/14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
