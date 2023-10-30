package com.myxh.smart.planet.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author MYXH
 * @date 2023/9/29
 */
@SpringBootApplication
@ComponentScan("com.myxh.smart.planet")
@EnableDiscoveryClient
public class ServiceVodApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceVodApplication.class, args);
    }
}
