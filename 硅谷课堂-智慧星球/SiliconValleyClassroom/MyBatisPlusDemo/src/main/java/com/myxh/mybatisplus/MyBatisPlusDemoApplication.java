package com.myxh.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.myxh.mybatisplus.mapper")
public class MyBatisPlusDemoApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MyBatisPlusDemoApplication.class, args);
    }
}
