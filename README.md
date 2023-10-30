# 硅谷课堂-智慧星球——尚硅谷项目笔记 2022 年

[TOC]

## Day 1-项目概述和 MyBatis Plus 使用

### 一、硅谷课堂-智慧星球概述

#### 1、项目介绍

硅谷课堂是尚硅谷与腾讯云官方合作的项目，是一款基于微信公众号 B2C 模式的在线学习平台，该平台包含三大模块：直播、教学与微信消息服务。平台会定期推出直播课程，方便学生与名师之间的交流互动，学生也可以购买教学视频在线学习，分享直播与教学视频获取平台收益，平台支持直播、腾讯云视频点播、微信支付、微信授权登录、微信菜单、微信消息与腾讯云文件存储等一系列功能，为学生构建了一个全方位的在线学习平台。

硅谷课堂项目具有很强的实用性，业务场景贴近实际，技术应用紧跟市场潮流，完全按照市场需求开发。既是对主流 Java 技术的系统性梳理和整合，同时也是各种主流技术实际应用的练兵场，能够帮助 Java 程序员积累项目经验。本套教程会在腾讯云开发者社区同步上线，也可以在“腾讯云开发者社区”学习和下载教程。

硅谷课堂-智慧星球项目是我作为一名 Java 初学者的第一款微服务实战项目，希望能通过学习和开发这款项目，提高自身编码能力，积累项目开发经验，帮助我拿到校招 Offer。

> 我是一名主修计算机科学与技术的大四学生，同时也是一个编程爱好者。目前，我正在学习 Java Spring，并且经常分享我的学习经验。我对 Unity 很感兴趣，希望将来成为一名独立的游戏开发者。
>
> 在夜空所有星星熄灭的时候，所有梦想、所有溪流，都能汇入同一片大海中，那时我们终会相见。
>
> 联系方式：
>
> QQ: 1735350920
>
> WeChat 微信: MYXH1735350920
>
> Email 邮箱: denglei_myxh@qq.com
>
> Twitter 推特: https://twitter.com/MYXH1735350920
>
> Bilibili 哔哩哔哩: https://b23.tv/F3Nv0DP
>
> GitHub: https://github.com/MYXHcode
>
> CSDN: https://blog.csdn.net/qq_40734758

#### 2、硅谷课堂-智慧星球流程图

![硅谷课堂-智慧星球流程图](https://img-blog.csdnimg.cn/c1014a49a5bd4afc8af23f95d1504567.png)

#### 3、硅谷课堂-智慧星球功能架构

![硅谷课堂-智慧星球功能架构](https://img-blog.csdnimg.cn/adca25505401464d9203b6b984588adf.png)

#### 4、硅谷课堂-智慧星球技术架构

![硅谷课堂-智慧星球技术架构](https://img-blog.csdnimg.cn/809aa543967747459b1f9be4d39eb53c.png)

#### 5、硅谷课堂-智慧星球核心技术

##### 5.1、后端技术

SpringBoot：简化 Spring 应用的初始搭建以及开发过程。

SpringCloud：基于 Spring Boot 实现的云原生应用开发工具，SpringCloud 使用的技术有 Spring Cloud Gateway、Spring Cloud Alibaba Nacos、Spring Cloud Alibaba Sentinel、Spring Cloud Alibaba Seata、Spring Cloud Task 和 Spring Cloud Feign 等。

Mysql：关系型数据库。

MyBatis Plus：持久层框架。

Redis：内存缓存。

RabbitMQ：消息中间件。

腾讯云：文件存储。

腾讯云：视频点播。

欢拓云直播：直播平台。

微信支付：支付工具。

Nginx：负载均衡。

Lombok：简化实体类。

##### 5.2、前端技术

Vue.js：Web 界面的渐进式框架。

Node.js：JavaScript 运行环境。

Axios：Axios 是一个基于 promise 的 HTTP 库。

NPM：包管理器。

Babel：转码器。

Webpack：打包工具。

##### 5.3、其他技术

Git：代码管理工具。

Docker：容器技术。

DockerFile：管理 Docker 镜像命令文本。

### 二、技术点-MyBatis Plus

#### 1、MyBatis Plus 简介

##### 1.1、概述

官网：https://baomidou.com

[MyBatis-Plus](https://github.com/baomidou/mybatis-plus)（简称 MP）是一个 [MyBatis](http://www.mybatis.org/mybatis-3/) 的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。

##### 1.2、特性

- **无侵入**：只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑。

- **损耗小**：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作。

- **强大的 CRUD 操作**：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求。

- **支持 Lambda 形式调用**：通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错。

- **支持多种数据库**：支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、Postgre、SQLServer2005、SQLServer 等多种数据库。

- **支持主键自动生成**：支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - Sequence），可自由配置，完美解决主键问题。

- **支持 XML 热加载**：Mapper 对应的 XML 支持热加载，对于简单的 CRUD 操作，甚至可以无 XML 启动。

- **支持 ActiveRecord 模式**：支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作。

- **支持自定义全局通用操作**：支持全局通用方法注入（Write once, use anywhere）。

- **支持关键词自动转义**：支持数据库关键词（order、key ...）自动转义，还可自定义关键词。

- **内置代码生成器**：采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、 Controller 层代码，支持模板引擎，更有超多自定义配置使用。

- **内置分页插件**：基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List 查询。

- **内置性能分析插件**：可输出 SQL 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询。

- **内置全局拦截插件**：提供全表 delete、update 操作智能分析阻断，也可自定义拦截规则，预防误操作。

- **内置 SQL 注入剥离器**：支持 SQL 注入剥离，有效预防 SQL 注入攻击。

#### 2、MyBatis Plus 入门

![MyBatis Plus 入门](https://img-blog.csdnimg.cn/f131483bba3a441d9a041e333f144ebb.png)

##### 2.1、创建测试数据库和表

**mybatis_plus**

其表结构如下：

| id  | name   | age | email         |
| --- | ------ | --- | ------------- |
| 1   | Jone   | 18  | Jone@qq.com   |
| 2   | Jack   | 20  | Jack@qq.com   |
| 3   | Tom    | 28  | Tom@qq.com    |
| 4   | Sandy  | 21  | Sandy@qq.com  |
| 5   | Billie | 24  | Billie@qq.com |

其对应的建表语句如下：

```sql
# 创建数据库 mybatis_plus
CREATE DATABASE IF NOT EXISTS `mybatis_plus`;

# 选择数据库 mybatis_plus
USE `mybatis_plus`;

# 创建用户表 user
CREATE TABLE IF NOT EXISTS `user`
(
    `id`    BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`  VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    `age`   INT(11)     NULL DEFAULT NULL COMMENT '年龄',
    `email` VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (`id`)
);
```

其对应的数据库 Data 脚本如下：

```sql
# 添加用户表 user 的数据
INSERT INTO `user` (`id`, `name`, `age`, `email`)
VALUES (1, 'MYXH', 21, '1735350920@qq.com'),
       (2, 'root', 21, 'root@qq.com'),
       (3, 'admin', 21, 'admin@qq.com'),
       (4, 'test', 18, 'test@qq.com'),
       (5, 'Jon', 18, 'jon@qq.com'),
       (6, 'Jack', 20, 'jack@qq.com'),
       (7, 'Tom', 28, 'tom@qq.com'),
       (8, 'Sandy', 21, 'sandy@qq.com'),
       (9, 'Billie', 24, 'billie@qq.com');
```

##### 2.2、创建项目和添加依赖

**（1）使用 Spring Initializr 初始化 Spring Boot 工程**

GroupId：com.myxh.mybatisplus

ArtifactId：MyBatisPlusDemo

Spring Boot 版本：3.0.2

**（2）项目引入依赖**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.0.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.myxh.mybatisplus</groupId>
    <artifactId>MyBatisPlusDemo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>MyBatisPlusDemo</name>
    <description>MyBatisPlusDemo</description>
    <properties>
        <java.version>17</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Mybatis Plus -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.5.3.2</version>
        </dependency>

        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-extension</artifactId>
            <version>3.5.3.2</version>
        </dependency>

        <!-- MySQL -->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- lombok 用来简化实体类 -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

**（3）IDEA 中安装 Lombok 插件**

![创建项目和添加依赖](https://img-blog.csdnimg.cn/20ee31cef8494f668ff45bd9bb1f007e.png)

##### 2.3、创建配置文件

**MySQL 5**

```properties
# 配置 MySQL 数据源
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/mybatis_plus
spring.datasource.username=root
spring.datasource.password=123456
```

**mysql8 以上（Spring Boot 2.1 以上），注意：driver 和 url 的变化。**

```properties
# 配置 MySQL 数据源
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/mybatis_plus?serverTimezone=GMT%2B8
spring.datasource.username=MYXH
spring.datasource.password=520.ILY!
```

**注意：**

1、这里的 url 使用了 ?serverTimezone=GMT%2B8 后缀，因为 Spring Boot 2.1 及以上集成了 8.0 版本的 jdbc 驱动，这个版本的 jdbc 驱动需要添加这个后缀，否则运行测试用例报告如下错误：

java.sql.SQLException: The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more

2、这里的 driver-class-name 使用了 com.mysql.cj.jdbc.Driver ，在 jdbc 8 中 建议使用这个驱动，之前的 com.mysql.jdbc.Driver 已经被废弃，否则运行测试用例的时候会有 WARN 信息。

##### 2.4、编写代码

**（1）创建启动类**

在 Spring Boot 启动类中添加 `@MapperScan` 注解，扫描 Mapper 文件夹。

```java
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
```

**（2）创建实体类**

```java
package com.myxh.mybatisplus.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@Component
@Data
public class User
{
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
```

**（3）创建 Mapper**

```java
package com.myxh.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxh.mybatisplus.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@Repository
public interface UserMapper extends BaseMapper<User>
{

}
```

**（4）功能测试-查询所有记录**

```java
package com.myxh.mybatisplus;

import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisPlusDemoApplicationTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询 User 表中的所有用户数据
     */
    @Test
    public void testFindAllUsers()
    {
        List<User> userList = userMapper.selectList(null);

        for (User user : userList)
        {
            System.out.println("user = " + user);
        }
    }
}
```

**注意：**

IDEA 在 userMapper 处报错，因为找不到注入的对象，因为类是动态创建的，但是程序可以正确的执行。

为了避免报错，可以在 DAO 层 的接口上添加 @Repository 注解。

#### 3、MyBatis Plus 实现 CRUD 操作

##### 3.1、插入操作

```java
package com.myxh.mybatisplus;

import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBatisPlusDemoApplicationTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    // 注入 user
    @Autowired
    User user;

    /**
     * 添加用户数据
     */
    @Test
    public void testAddUser()
    {
        user.setName("末影小黑xh");
        user.setAge(21);
        user.setEmail("1735350920@qq.com");
        int rows = userMapper.insert(user);
        System.out.println("rows = " + rows);

        // 添加成功之后，把添加之后生成 id 值，回填到 user 对象里面
        System.out.println("user = " + user);
    }
}
```

**注意：** 数据库插入 id 值默认为全局唯一 id。

![插入操作](https://img-blog.csdnimg.cn/b31bb598f8d94123acec2444a5c59454.png)

**查看 sql 输出日志**

```properties
# 配置 MyBatis Plus 日志
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```

##### 3.2、主键策略

**（1）ID_WORKER**

MyBatis-Plus 默认的主键策略是：ID_WORKER 全局唯一 ID。

**（2）自增策略**

- 要想主键自增需要配置如下主键策略：

  - 需要在创建数据表的时候设置主键自增。

  - 实体字段中配置 @TableId(type = IdType.AUTO)。

    ```java
    package com.myxh.mybatisplus.entity;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.annotation.TableId;
    import lombok.Data;
    import org.springframework.stereotype.Component;

    /**
     * @author MYXH
     * @date 2023/9/25
     */
    @Component
    @Data
    public class User
    {
        @TableId(type = IdType.AUTO)
        private Long id;
        private String name;
        private Integer age;
        private String email;
    }
    ```

- 其它主键策略：分析 IdType 源码可知。

  ```java
  /*
  * Copyright (c) 2011-2023, baomidou (jobob@qq.com).
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *     http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
  package com.baomidou.mybatisplus.annotation;

  import lombok.Getter;

  /**
   * 生成ID类型枚举类
   *
   * @author hubin
   * @since 2015-11-10
   */
  @Getter
  public enum IdType {
      /**
       * 数据库ID自增
       * <p>该类型请确保数据库设置了 ID自增 否则无效</p>
       */
      AUTO(0),
      /**
       * 该类型为未设置主键类型(注解里等于跟随全局,全局里约等于 INPUT)
       */
      NONE(1),
      /**
       * 用户输入ID
       * <p>该类型可以通过自己注册自动填充插件进行填充</p>
       */
      INPUT(2),

      /* 以下2种类型、只有当插入对象ID 为空，才自动填充。 */
      /**
       * 分配ID (主键类型为number或string）,
       * 默认实现类 {@link com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator}(雪花算法)
       *
       * @since 3.3.0
       */
      ASSIGN_ID(3),
      /**
       * 分配UUID (主键类型为 string)
       * 默认实现类 {@link com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator}(UUID.replace("-",""))
       */
      ASSIGN_UUID(4);

      private final int key;

      IdType(int key) {
          this.key = key;
      }

      public int getKey() {
          return this.key;
      }
  }
  ```

##### 3.3、根据 id 更新操作

**注意：** update 时生成的 sql 自动是动态 sql：UPDATE user SET email=? WHERE id=?

```java
package com.myxh.mybatisplus;

import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBatisPlusDemoApplicationTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * 修改用户数据
     */
    @Test
    public void testUpdateUser()
    {
        // 1、根据 id 查询
        User userById = userMapper.selectById(1706273960528822274L);

        // 2、设置修改值
        userById.setEmail("myxh@qq.com");

        // 3、调用方法实现修改
        int rows = userMapper.updateById(userById);
        System.out.println("rows = " + rows);
        System.out.println("userById = " + userById);
    }
}
```

##### 3.4、分页查询

MyBatis Plus 自带分页插件，只要简单的配置即可实现分页功能。

**（1）创建配置类**

```java
package com.myxh.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@Configuration
public class MyBatisPlusConfig
{
    /**
     * 分页插件
     *
     * @return MyBatis Plus 拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor()
    {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        return interceptor;
    }
}
```

**（2）测试 selectPage 分页**

**测试：** 最终通过 page 对象获取相关数据。

```java
package com.myxh.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisPlusDemoApplicationTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询 User 表中的所有用户数据
     */
    @Test
    public void testFindAllUsersByPage()
    {
        // 创建 Page 对象，传递两个参数：当前页、每页显示记录数
        Page<User> userPage = new Page<>(1, 5);

        // 调用 userMapper 的方法实现分页
        // IPage<User> userPageModel = userMapper.selectPage(userPage, null);
        userMapper.selectPage(userPage, null);
        List<User> records = userPage.getRecords();
        System.out.println("records = " + records);
        long pages = userPage.getPages();
        System.out.println("pages = " + pages);
        long size = userPage.getSize();
        System.out.println("size = " + size);
        long total = userPage.getTotal();
        System.out.println("total = " + total);
        boolean hasNext = userPage.hasNext();
        System.out.println("hasNext = " + hasNext);
        boolean hasPrevious = userPage.hasPrevious();
        System.out.println("hasPrevious = " + hasPrevious);
    }
}
```

控制台 SQL 语句打印：SELECT id,name,age,email,create_time,update_time FROM user LIMIT 0,5

##### 3.5、根据 id 删除记录

```java
package com.myxh.mybatisplus;

import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBatisPlusDemoApplicationTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据 id 删除用户数据
     */
    @Test
    public void testDeleteUserById()
    {
        int rows = userMapper.deleteById(9L);
        System.out.println("rows = " + rows);
    }
}
```

##### 3.6、批量删除

```java
package com.myxh.mybatisplus;

import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class MyBatisPlusDemoApplicationTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据 id 批量删除用户数据
     */
    @Test
    public void testDeleteBatchUserById()
    {
        int rows = userMapper.deleteBatchIds(Arrays.asList(5, 6, 7, 8, 9));
        System.out.println("rows = " + rows);
    }
}
```

##### 3.7、逻辑删除

- 物理删除：真实删除，将对应数据从数据库中删除，之后查询不到此条被删除数据。
- 逻辑删除：假删除，将对应数据中代表是否被删除字段状态修改为“被删除状态”，之后在数据库中仍旧能看到此条数据记录。

**（1）数据库中添加 deleted 字段**

```sql
# user 表中添加 deleted 字段
ALTER TABLE `user` ADD COLUMN `deleted` BOOLEAN DEFAULT 0;
```

**（2）实体类添加 deleted 字段**

并加上 @TableLogic 注解。

```java
package com.myxh.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@Component
@Data
public class User
{
    // @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    // 逻辑删除标志
    @TableLogic
    private Integer deleted;
}
```

**（3）application.properties 加入配置**

此为默认值，如果你的默认值和 MyBatis Plus 默认的一样，该配置可无。

```properties
# 配置 MyBatis Plus 逻辑删除标志，默认 0 代表没有删除，1 代表已经删除
mybatis-plus.global-config.db-config.logic-delete-value=1
mybatis-plus.global-config.db-config.logic-not-delete-value=0
```

**（5）测试逻辑删除**

- 测试后发现，数据并没有被删除，deleted 字段的值由 0 变成了 1。

- 测试后分析打印的 SQL 语句，是一条 update。

- **注意：** 被删除数据的 deleted 字段的值必须是 0，才能被选取出来执行逻辑删除的操作。

```java
package com.myxh.mybatisplus;

import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBatisPlusDemoApplicationTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据 id 删除用户数据（逻辑删除）
     */
    @Test
    public void testDeleteUserById()
    {
        int rows = userMapper.deleteById(9L);
        System.out.println("rows = " + rows);
    }
}
```

**（7）测试逻辑删除后的查询**

MyBatis Plus 中查询操作也会自动添加逻辑删除字段的判断。

```java
package com.myxh.mybatisplus;

import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisPlusDemoApplicationTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询 User 表中的所有用户数据
     */
    @Test
    public void testFindAllUsers()
    {
        List<User> userList = userMapper.selectList(null);

        for (User user : userList)
        {
            System.out.println("user = " + user);
        }
    }
}
```

测试后分析打印的 SQL 语句，包含 WHERE deleted=0。

SELECT id,name,age,email,create_time,update_time,deleted FROM user WHERE deleted=0

#### 4、MyBatis Plus 条件构造器

![MyBatis Plus 条件构造器](https://img-blog.csdnimg.cn/2272c6ef775b4e0398d779a81652f22e.png)

Wrapper：条件构造抽象类，最顶端父类。

AbstractWrapper：用于查询条件封装，生成 SQL 的 where 条件。

​QueryWrapper：Entity 对象封装操作类，不是用 Lambda 语法。

UpdateWrapper：Update 条件封装，用于 Entity 对象更新操作。

AbstractLambdaWrapper：Lambda 语法使用 Wrapper 统一处理解析 Lambda 获取 column。

LambdaQueryWrapper：看名称也能明白就是用于 Lambda 语法使用的查询 Wrapper。

​LambdaUpdateWrapper：Lambda 更新封装 Wrapper。

**注意：以下条件构造器的方法入参中的 `column` 均表示数据库字段**

##### 4.1、QueryWrapper 使用

**（1）ge、gt、le、lt**

```java
package com.myxh.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@SpringBootTest
public class QueryDemoTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * queryWrapper
     * ge、gt、le、lt
     */
    @Test
    public void testQuery1()
    {
        // 创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // ge、gt、le、lt
        // ge 为例有两个参数：第一个参数是表字段名称，第二个参数是值
        wrapper.ge("age", 21);

        // 调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }
}
```

**（2）eq、ne**

**注意：** seletOne 返回的是一条实体记录，当出现多条时会报错。selectList 返回的是多条实体记录。

```java
package com.myxh.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@SpringBootTest
public class QueryDemoTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * queryWrapper
     * eq、ne
     */
    @Test
    public void testQuery2()
    {
        // 创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // eq、ne
        // eq 为例有两个参数：第一个参数是表字段名称，第二个参数是值
        wrapper.eq("name", "MYXH");

        // 调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }
}
```

SELECT id,name,age,email,create_time,update_time,deleted,version FROM user WHERE deleted=0 AND name = ?

**（3）like、likeLeft、likeRight**

selectMaps 返回 Map 集合列表。

```java
package com.myxh.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@SpringBootTest
public class QueryDemoTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * queryWrapper
     * like、likeLeft、likeRight
     */
    @Test
    public void testQuery3()
    {
        // 创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // like、likeLeft、likeRight
        // like、likeLeft 为例有两个参数：第一个参数是表字段名称，第二个参数是值
        // wrapper.like("name","MYXH");
        wrapper.likeLeft("name", "XH");

        // 调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }
}
```

SELECT id,name,age,email,create_time,update_time,deleted,version

FROM user WHERE deleted=0 AND name LIKE ?

**（4）orderByDesc、orderByAsc**

```java
package com.myxh.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@SpringBootTest
public class QueryDemoTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * queryWrapper
     * orderByDesc、orderByAsc
     */
    @Test
    public void testQuery4()
    {
        // 创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // orderByDesc、orderByAsc
        // orderByDesc 为例有一个参数：参数是表字段名称
        wrapper.orderByDesc("id");

        // 调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }
}
```

SELECT id,name,age,email,create_time,update_time,deleted,version

FROM user WHERE deleted=0 ORDER BY id DESC

##### 4.2、LambdaQueryWrapper 使用

```java
package com.myxh.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@SpringBootTest
public class QueryDemoTests
{
    // 注入 userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * LambdaQueryWrapper
     */
    @Test
    public void testLambdaQuery1()
    {
        // 创建条件构造对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getName, "MYXH");

        // 调用方法查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }

    /**
     * LambdaQueryWrapper
     */
    @Test
    public void testLambdaQuery2()
    {
        // 创建条件构造对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName, "MYXH");

        // 调用方法查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }
}
```

SELECT id,name,age,email,create_time,update_time,deleted,version

FROM user WHERE deleted=0 AND name = ?

SELECT id,name,age,email,create_time,update_time,deleted,version

FROM user WHERE deleted=0 AND name LIKE ?

#### 5、MyBatis Plus 封装 Service 层

##### 5.1、创建 service

```java
package com.myxh.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.mybatisplus.entity.User;

/**
 * @author MYXH
 * @date 2023/9/25
 */
public interface UserService extends IService<User>
{

}
```

##### 5.2、创建 service 实现类

```java
package com.myxh.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.mapper.UserMapper;
import com.myxh.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{
    // 注入 userMapper
    // @Autowired
    // private UserMapper userMapper;
}
```

**底层封装了注入 Mapper 过程**

![底层封装了注入 Mapper 过程](https://img-blog.csdnimg.cn/19be511f8b4243feae64707496e58706.png)

##### 5.3、方法调用测试

```java
package com.myxh.mybatisplus;

import com.myxh.mybatisplus.entity.User;
import com.myxh.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/25
 */
@SpringBootTest
public class ServiceDemoTests
{
    // 注入 userService
    @Autowired
    private UserService userService;

    /**
     * 查询 User 表中的所有用户数据
     */
    @Test
    public void testFindAllUsers()
    {
        List<User> userList = userService.list();

        for (User user : userList)
        {
            System.out.println("user = " + user);
        }
    }
}
```

## Day 2-搭建项目环境和开发教师管理接口

### 一、搭建项目工程

#### 1、项目数据库设计

##### 1.1、创建数据库和表

![创建数据库和表](https://img-blog.csdnimg.cn/db049d5d65c648f5b869017fdbedbab5.png)

##### 1.2、数据库设计规则

**以下规则只针对本模块，更全面的文档参考《阿里巴巴 Java 开发手册》：**

1、库名与应用名称尽量一致。

2、表名、字段名必须使用小写字母或数字，禁止出现数字开头。

3、表名不使用复数名词。

4、表的命名最好是加上“业务名称\_表的作用”。如，edu_teacher。

5、表必备三字段：id, gmt_create, gmt_modified。

说明：

其中 id 必为主键，类型为 bigint unsigned、单表时自增、步长为 1。

如果使用分库分表集群部署，则 id 类型为 verchar，非自增，业务中使用分布式 id 生成器。

gmt_create, gmt_modified 的类型均为 datetime 类型，前者现在时表示主动创建，后者过去分词表示被动更新。

6、单表行数超过 500 万行或者单表容量超过 2GB，才推荐进行分库分表。说明：如果预计三年后的数据量根本达不到这个级别，请不要在创建表时就分库分表。

7、表达是与否概念的字段，必须使用 is_xxx 的方式命名，数据类型是 unsigned tinyint （1 表示是，0 表示否）。

说明：任何字段如果为非负数，必须是 unsigned。

注意：POJO 类中的任何布尔类型的变量，都不要加 is 前缀。数据库表示是与否的值，使用 tinyint 类型，坚持 is_xxx 的 命名方式是为了明确其取值含义与取值范围。

正例：表达逻辑删除的字段名 is_deleted，1 表示删除，0 表示未删除。

8、小数类型为 decimal，禁止使用 float 和 double。 说明：float 和 double 在存储的时候，存在精度损失的问题，很可能在值的比较时，得到不正确的结果。如果存储的数据范围超过 decimal 的范围，建议将数据拆成整数和小数分开存储。

9、如果存储的字符串长度几乎相等，使用 char 定长字符串类型。

10、varchar 是可变长字符串，不预先分配存储空间，长度不要超过 5000，如果存储长度大于此值，定义字段类型为 text，独立出来一张表，用主键来对应，避免影响其它字段索引效率。

11、唯一索引名为 uk\*字段名；普通索引名则为 idx\*字段名。

说明：uk* 即 unique key；idx* 即 index 的简称

12、不得使用外键与级联，一切外键概念必须在应用层解决。外键与级联更新适用于单机低并发，不适合分布式、高并发集群；级联更新是强阻塞，存在数据库更新风暴的风险；外键影响数据库的插入速度。

#### 2、工程目录结构

![工程目录结构](https://img-blog.csdnimg.cn/c479fa79c6b442108d8d23485996206d.png)

**模块说明：**

**SmartPlanet：** 智慧星球根目录（父工程），管理多个子模块。

**common：公共模块父节点。**

​common-util：工具类模块，所有模块都可以依赖于它。

service-utils：service 服务的 base 包，包含 service 服务的公共配置类，所有 service 模块依赖于它。

​rabbit-utils：rabbitmq 封装工具类。

**model：实体类相关模块。**

**server-gateway：服务网关。**

**service：API 接口服务父节点。**

​service-acl：权限管理接口服务。

service-activity：优惠券 API 接口服务。

service-live：直播课程 API 接口服务。

service-order：订单 API 接口服务。

service-user：用户 API 接口服务。

service-vod：点播课程 API 接口服务。

service-wechat：公众号 API 接口服务。

**service-client：feign 服务调用父节点。**

service-activity-client：优惠券 API 接口。

service-live-client：直播课程 API 接口。

service-order-client：订单 API 接口。

service-user-client：用户 API 接口。

service-vod-client：点播课程 API 接口。

#### 3、创建父工程

##### 3.1、创建父工程 SmartPlanet

在 IDEA 开发工具中，使用 Spring Initializr 快速初始化一个 Spring Boot 模块。

![创建父工程 SmartPlanet](https://img-blog.csdnimg.cn/0f5bdd76fc45470e9947ec1d9b5dfa1d.png)

**配置：**

groupId：com.myxh.smart.planet

artifactId：SmartPlanet

![创建父工程 SmartPlanet](https://img-blog.csdnimg.cn/b10426a0007a4b2fbe6c48316687800d.png)

##### 3.2、删除 src 目录

##### 3.3、引入依赖

使用 SpringBoot 版本为 ：3.0.2

![引入依赖](https://img-blog.csdnimg.cn/9fef7580d3d641e386eca895858bdd4d.png)

**添加如下依赖：**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.0.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.myxh.smart.planet</groupId>
    <artifactId>SmartPlanet</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>pom</packaging>
    <name>SmartPlanet</name>
    <description>SmartPlanet</description>
    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <skipTests>true</skipTests>
        <java.version>17</java.version>
        <spring-cloud.version>2022.0.0</spring-cloud.version>
        <spring-cloud-alibaba.version>2022.0.0.0</spring-cloud-alibaba.version>
        <mybatis-plus.version>3.5.3.2</mybatis-plus.version>
        <mysql-connector-j.version>8.0.32</mysql-connector-j.version>
        <knife4j>3.0.3</knife4j>
        <jjwt-api.version>0.11.5</jjwt-api.version>
        <httpclient.version>4.5.13</httpclient.version>
        <fastjson.version>2.0.32</fastjson.version>
        <easyexcel.version>3.3.2</easyexcel.version>
        <aliyun-java-sdk-core.version>4.5.16</aliyun-java-sdk-core.version>
        <aliyun-sdk-oss.version>3.17.1</aliyun-sdk-oss.version>
        <joda-time.version>2.12.5</joda-time.version>
        <xxl-job-core.version>2.4.0</xxl-job-core.version>
        <springdoc-openapi-starter-webmvc-ui>2.1.0</springdoc-openapi-starter-webmvc-ui>
    </properties>

    <!--配置 dependencyManagement 锁定依赖的版本-->
    <dependencyManagement>
        <dependencies>
            <!-- Spring Cloud -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <!-- Spring Cloud Alibaba -->
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${spring-cloud-alibaba.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <!-- Mybatis Plus 持久层 -->
            <dependency>
                <groupId>com.baomidou</groupId>
                <artifactId>mybatis-plus-boot-starter</artifactId>
                <version>${mybatis-plus.version}</version>
            </dependency>

            <!-- MySQL -->
            <dependency>
                <groupId>com.mysql</groupId>
                <artifactId>mysql-connector-j</artifactId>
                <version>${mysql-connector-j.version}</version>
            </dependency>

            <!-- knife4j -->
            <dependency>
                <groupId>com.github.xiaoymin</groupId>
                <artifactId>knife4j-spring-boot-starter</artifactId>
                <version>${knife4j}</version>
            </dependency>

            <!-- jjwt -->
            <dependency>
                <groupId>io.jsonwebtoken</groupId>
                <artifactId>jjwt-api</artifactId>
                <version>${jjwt-api.version}</version>
            </dependency>

            <!-- httpclient -->
            <dependency>
                <groupId>org.apache.httpcomponents</groupId>
                <artifactId>httpclient</artifactId>
                <version>${httpclient.version}</version>
            </dependency>

            <!-- fastjson -->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>fastjson</artifactId>
                <version>${fastjson.version}</version>
            </dependency>

            <!-- easyexcel -->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>easyexcel</artifactId>
                <version>${easyexcel.version}</version>
            </dependency>

            <!-- aliyun-java-sdk-core -->
            <dependency>
                <groupId>com.aliyun</groupId>
                <artifactId>aliyun-java-sdk-core</artifactId>
                <version>${aliyun-java-sdk-core.version}</version>
            </dependency>

            <!--aliyunOSS-->
            <dependency>
                <groupId>com.aliyun.oss</groupId>
                <artifactId>aliyun-sdk-oss</artifactId>
                <version>${aliyun-sdk-oss.version}</version>
            </dependency>

            <!-- 日期时间工具 -->
            <dependency>
                <groupId>joda-time</groupId>
                <artifactId>joda-time</artifactId>
                <version>${joda-time.version}</version>
            </dependency>

            <!-- xxl-job-core -->
            <dependency>
                <groupId>com.xuxueli</groupId>
                <artifactId>xxl-job-core</artifactId>
                <version>${xxl-job-core.version}</version>
            </dependency>

            <!-- OpenAPI 3 整合 Swagger -->
            <dependency>
                <groupId>org.springdoc</groupId>
                <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
                <version>${springdoc-openapi-starter-webmvc-ui}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

#### 4、创建 model 模块

##### 4.1、创建子模块 model

![创建子模块 model](https://img-blog.csdnimg.cn/53b741b3918a482c9b2bcf533c89f776.png)

##### 4.2、配置模块

groupId：com.myxh.smart.planet

artifactId：model

![配置模块](https://img-blog.csdnimg.cn/06b33bb1d03e461d9c36004d4f5063f2.png)

##### 4.3、引入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.myxh.smart.planet</groupId>
        <artifactId>SmartPlanet</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>model</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- lombok 用来简化实体类 -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

        <!-- Mybatis Plus 持久层 -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- easyexcel -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>easyexcel</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- knife4j -->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>knife4j-spring-boot-starter</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- data-mongodb -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- fastjson -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- data-elasticsearch 创建索引库 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- OpenAPI 3 整合 Swagger -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        </dependency>
    </dependencies>
</project>
```

##### 4.4、编写 model 代码

![编写 model 代码](https://img-blog.csdnimg.cn/3d0fa6b52d8442a99e7a89847ee825c4.png)

#### 5、创建 service 模块

##### 5.1、创建子模块 service

![创建子模块 service](https://img-blog.csdnimg.cn/390ce07580e94e04ae50b1dcac8495ab.png)

##### 5.2、service 模块引入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.myxh.smart.planet</groupId>
        <artifactId>SmartPlanet</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>service</artifactId>
    <packaging>pom</packaging>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- model 数据载体 -->
        <dependency>
            <groupId>com.myxh.smart.planet</groupId>
            <artifactId>model</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>

        <!-- Web 需要启动项目 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Mybatis Plus 持久层 -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
        </dependency>

        <!-- MySQL -->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
        </dependency>

        <!-- alibaba-nacos-discovery 服务注册 -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>

        <!-- openfeign 服务调用 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

        <!-- alibaba-sentinel 流量控制 -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>

        <!-- devtools 开发者工具 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>
</project>
```

#### 6、创建 service-vod 模块

**在 service 模块创建子模块 service-vod。**

![创建 service-vod 模块](https://img-blog.csdnimg.cn/a6b56d9f6a3345b19843924c642de70f.png)

### 二、后台管理系统-教师管理接口

#### 1、教师管理模块需求

添加课程时候，需要选择所属教师，所以要对教师进行管理，就是基于教师的 CRUD 操作。

#### 2、教师管理模块配置

##### 2.1、生成模块代码

**（1）引入代码生成器依赖**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.myxh.smart.planet</groupId>
        <artifactId>service</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>service-vod</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- model 数据载体 -->
        <dependency>
            <groupId>com.myxh.smart.planet</groupId>
            <artifactId>model</artifactId>
            <version>0.0.1-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>

        <!-- mybatis-plus-generator -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.5.3.1</version>
        </dependency>

        <!-- freemarker -->
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>2.3.32</version>
        </dependency>
    </dependencies>
</project>
```

**（2）编写生成代码工具类**

修改代码中路径、数据库、包和表，创建在 test 目录下。

**（3）实体类统一替换为 model 模块的实体类**

##### 2.2、创建配置文件和启动类

**配置文件：**

```properties
# 服务端口
server.port=8301

# 服务名
spring.application.name=service-vod

# 环境设置：dev、test、prod
spring.profiles.active=dev

# MySQL 数据库连接
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/smart_planet_vod?characterEncoding=utf-8&useSSL=false
spring.datasource.username=MYXH
spring.datasource.password=520.ILY!

# 返回 Json 的全局时间格式
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8

# MyBatis 日志
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```

**启动类：**

```java
package com.myxh.smart.planet.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MYXH
 * @date 2023/9/29
 */
@SpringBootApplication
public class ServiceVodApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceVodApplication.class, args);
    }
}
```

#### 3、查询所有教师列表接口

##### 3.1、编写 controller

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有教师
     *
     * @return teacherList 所有教师
     */
    @GetMapping("find/all")
    public List<Teacher> findAllTeacher()
    {
        List<Teacher> teacherList = teacherService.list();

        return teacherList;
    }
}
```

##### 3.2、编写配置类

```java
package com.myxh.smart.planet.vod.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author MYXH
 * @date 2023/9/29
 * @description 配置类
 */
@Configuration
@MapperScan("com.myxh.smart.planet.vod.mapper")
public class VodConfig
{

}
```

##### 3.3、运行启动类

访问 http://localhost:8301/admin/vod/teacher/find/all

得到 json 数据。

#### 4、逻辑删除教师接口

##### 4.1、编写 controller

TeacherController 添加删除方法。

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 逻辑删除教师
     *
     * @param id id
     * @return isSuccess 是否成功
     */
    @DeleteMapping("remove/{id}")
    public boolean removeTeacher(@PathVariable("id") Long id)
    {
        boolean isSuccess = teacherService.removeById(id);

        return isSuccess;
    }
}
```

​ 因为删除教师接口是 delete 提交方式，使用浏览器无法直接访问测试，可以通过工具测试，比如 Postman，这里通过整合 Swagger 进行接口测试。

#### 5、配置 Swagger 生成 API 接口文档

##### 5.1、概述

​ 前后端分离开发模式中，api 文档是最好的沟通方式。Swagger 是一个规范和完整的框架，用于生成、描述、调用和可视化 RESTful 风格的 Web 服务。及时性 (接口变更后，能够及时准确地通知相关前后端开发人员)、规范性 (并且保证接口的规范性，如接口的地址，请求方式，参数及响应格式和错误信息)、一致性(接口信息一致，不会出现因开发人员拿到的文档版本不一致，而出现分歧)、可测性(直接在接口文档上进行测试，以方便理解业务)。

##### 5.2、配置 Swagger

**（1）在 SmartPlanet 下创建子模块 common。**

![配置 Swagger](https://img-blog.csdnimg.cn/b472d971f7a740b6b1590609942748c0.png)

**（2）在 common 模块引入依赖。**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.myxh.smart.planet</groupId>
        <artifactId>SmartPlanet</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>common</artifactId>
    <packaging>pom</packaging>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- Spring MVC -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <scope>provided </scope>
        </dependency>

        <!-- Mybatis Plus 持久层 -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <scope>provided </scope>
        </dependency>

        <!-- lombok 用来简化实体类 -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

        <!-- fastjson -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
        </dependency>

        <!-- OpenAPI 3 整合 Swagger -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        </dependency>
    </dependencies>
</project>
```

**（3）在 common 下创建子模块 service-utils。**

![配置 Swagger](https://img-blog.csdnimg.cn/d746e12dec6b4ff09173d46ac38d793f.png)

**（4）在 service-utils 创建 swagger 配置类。**

```java
package com.myxh.smart.planet.swagger;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MYXH
 * @date 2023/9/29
 */
@Configuration
public class SwaggerConfig
{
    @Bean
    public GroupedOpenApi webApiConfig()
    {
        return GroupedOpenApi.builder()
                .group("smart.planet")
                .pathsToMatch("/admin/**")
                .addOpenApiMethodFilter(method -> true)
                .build();
    }

    private OpenAPI webApiInfo()
    {
        return new OpenAPI()
                .info(new Info().title("网站-API文档")
                        .description("本文档描述了网站微服务接口定义")
                        .version("0.0.1-SNAPSHOT")
                        .license(new License().name("GNU GENERAL PUBLIC LICENSE Version 3")
                                .url("https://www.gnu.org/licenses/gpl-3.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("智慧星球官网")
                        .url("https://myxh.smart.planet.com"));
    }
}
```

**（5）在 service 模块引入 service-utils 依赖。**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.myxh.smart.planet</groupId>
        <artifactId>SmartPlanet</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>service</artifactId>
    <packaging>pom</packaging>
    <modules>
        <module>service-vod</module>
    </modules>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- model 数据载体 -->
        <dependency>
            <groupId>com.myxh.smart.planet</groupId>
            <artifactId>model</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>

        <!-- service-utils -->
        <dependency>
            <groupId>com.myxh.smart.planet</groupId>
            <artifactId>service-utils</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>

        <!-- Web 需要启动项目 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Mybatis Plus 持久层 -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
        </dependency>

        <!-- MySQL -->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
        </dependency>

        <!-- alibaba-nacos-discovery 服务注册 -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>

        <!-- openfeign 服务调用 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>

        <!-- alibaba-sentinel 流量控制 -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>

        <!-- devtools 开发者工具 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>
</project>
```

**（6）在 service-vod 启动类上添加注解，进行测试。**

```java
package com.myxh.smart.planet.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author MYXH
 * @date 2023/9/29
 */
@SpringBootApplication
@ComponentScan("com.myxh.smart.planet")
public class ServiceVodApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceVodApplication.class, args);
    }
}
```

##### 5.3、定义接口说明和参数说明

定义在类上：@Tag

定义在方法上：@Operation

定义在参数上：@Parameter

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.vod.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@Tag(name = "教师接口", description = "教师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有教师
     *
     * @return teacherList 所有教师
     */
    @Operation(summary = "查询", description = "查询所有教师")
    @GetMapping("find/all")
    public List<Teacher> findAllTeacher()
    {
        List<Teacher> teacherList = teacherService.list();

        return teacherList;
    }

    /**
     * 逻辑删除教师
     *
     * @param id id
     * @return isSuccess 是否成功
     */
    @Operation(summary = "删除", description = "逻辑删除教师")
    @DeleteMapping("remove/{id}")
    public boolean removeTeacher(@Parameter(name = "id", description = "ID", required = true)
                                 @PathVariable("id") Long id)
    {
        boolean isSuccess = teacherService.removeById(id);

        return isSuccess;
    }
}
```

##### 5.4、swagger 测试

**（1）浏览器输入固定地址** http://localhost:8301/swagger-ui.html

![swagger 测试](https://img-blog.csdnimg.cn/ed310a94968a46eea9071f7db821400f.png)

**（2）测试接口**

![swagger 测试](https://img-blog.csdnimg.cn/6bf28fa988bd48ad931d3324e662b403.png)

**（3）执行接口**

![swagger 测试](https://img-blog.csdnimg.cn/6055312368aa48efaa68ea709df7eaa1.jpeg)

#### 6、定义统一返回结果对象

项目中会将响应封装成 json 返回，一般会将所有接口的数据格式统一， 使前端(iOS, Android, Web)对数据的操作更一致、轻松。

一般情况下，统一返回数据格式没有固定的格式，只要能描述清楚返回的数据状态以及要返回的具体数据就可以。但是一般会包含状态码、返回消息、数据这几部分内容。

例如，系统要求返回的基本数据格式如下：

**列表：**

```json
{
  "code": 200,
  "message": "成功",
  "data": [
    {
      "id": 1,
      "name": "张老师",
      "intro": "高级教师"
    }
  ],
  "ok": true
}
```

**分页：**

```json
{
  "code": 200,
  "message": "成功",
  "data": {
    "records": [
      {
        "id": 1,
        "name": "张老师",
        "intro": "高级教师"
      },
      {
        "id": 2,
        "name": "李老师",
        "intro": "高级教师"
      },
      {
        "id": 3,
        "name": "钟老师",
        "intro": "高级老师"
      }
    ],
    "total": 5,
    "size": 3,
    "current": 1,
    "orders": [],
    "hitCount": false,
    "searchCount": true,
    "pages": 2
  },
  "ok": true
}
```

**没有返回数据：**

```json
{
  "code": 200,
  "message": "成功",
  "data": null,
  "ok": true
}
```

**失败：**

```json
{
  "code": 201,
  "message": "失败",
  "data": null,
  "ok": false
}
```

##### 6.1、创建结果类

**在 service-utils 模块创建 interfacle 定义返回状态码。**

```java
package com.myxh.smart.planet.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

/**
 * @author MYXH
 * @date 2023/9/30
 * @description 统一返回结果状态信息类
 */
@Schema(description = "统一返回结果状态信息")
@Getter
public enum ResultCodeEnum
{
    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    SERVICE_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    ILLEGAL_REQUEST(205, "非法请求"),
    REPEAT_SUBMIT(206, "重复提交"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),

    PHONE_CODE_ERROR(211, "手机验证码错误"),

    MTCLOUD_ERROR(210, "直播接口异常"),

    COUPON_GET(220, "优惠券已经领取"),
    COUPON_LIMIT_GET(221, "优惠券已发放完毕"),

    FILE_UPLOAD_ERROR(21004, "文件上传错误"),
    FILE_DELETE_ERROR(21005, "文件刪除错误"),

    VOD_PALY_ERROR(209, "请购买后观看"),
    ;

    @Schema(description = "状态码")
    private final Integer code;

    @Schema(description = "返回状态信息（成功、失败）")
    private final String message;

    ResultCodeEnum(Integer code, String message)
    {
        this.code = code;
        this.message = message;
    }
}
```

**在 service-utils 模块创建结果类。**

```java
package com.myxh.smart.planet.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MYXH
 * @date 2023/9/30
 * @description 全局统一返回结果类
 */
@Schema(description = "全局统一返回结果")
@NoArgsConstructor
@Data
public class Result<T>
{
    @Schema(description = "状态码")
    private Integer code;

    @Schema(description = "返回状态信息（成功、失败）")
    private String message;

    @Schema(description = "返回数据")
    private T data;

    /**
     * 使用 ResultCodeEnum 枚举构建 Result 实例
     *
     * @param body   返回数据
     * @param resultCodeEnum ResultCodeEnum 结果码枚举
     * @return 构建好的 Result 实例
     * @param <T> 数据类型
     */
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum)
    {
        Result<T> result = new Result<>();

        if (body != null)
        {
            result.setData(body);
        }

        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());

        return result;
    }

    /**
     * 操作成功，有 data 数据
     *
     * @param data 数据
     * @param <T>  数据 data 类型 T
     * @return result 结果
     */
    public static <T> Result<T> ok(T data)
    {
        return build(data, ResultCodeEnum.SUCCESS);
    }

    /**
     * 操作失败，有 data 数据
     *
     * @param data 数据
     * @param <T>  数据 data 类型 T
     * @return result 结果
     */
    public static <T> Result<T> fail(T data)
    {
        return build(data, ResultCodeEnum.FAIL);
    }

    /**
     * 设置消息字段值
     *
     * @param message 要设置的值
     * @return 结果实例（用于链式调用）
     */
    public Result<T> message(String message)
    {
        this.setMessage(message);

        return this;
    }

    /**
     * 设置代码字段值
     *
     * @param code 要设置的值
     * @return 结果实例（用于链式调用）
     */
    public Result<T> code(Integer code)
    {
        this.setCode(code);

        return this;
    }

    /**
     * 操作成功，没有 data 数据
     *
     * @return result 结果
     * @param <T> 数据 data 类型 T
     */
    /*
    public static <T> Result<T> ok()
    {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("成功");

        return result;
    }
     */


    /**
     * 操作失败，没有 data 数据
     *
     * @return result 结果
     * @param <T> 数据 data 类型 T
     */
    /*
    public static <T> Result<T> fail()
    {
        Result<T> result = new Result<>();
        result.setCode(201);
        result.setMessage("失败");

        return result;
    }
     */
}
```

##### 6.2、修改 controller 返回结果

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@Tag(name = "教师接口", description = "教师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有教师
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询所有", description = "查询所有教师")
    @GetMapping("find/all")
    public Result<List<Teacher>> findAllTeacher()
    {
        List<Teacher> teacherList = teacherService.list();

        return Result.ok(teacherList).message("查询所有教师数据成功");
    }

    /**
     * 逻辑删除教师
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除", description = "逻辑删除教师")
    @DeleteMapping("remove/{id}")
    public Result<Void> removeTeacher(@Parameter(name = "id", description = "ID", required = true)
                                      @PathVariable("id") Long id)
    {
        boolean isSuccess = teacherService.removeById(id);

        if (isSuccess)
        {
            return Result.<Void>ok(null).message("逻辑删除教师数据成功");
        }
        else
        {
            return Result.<Void>fail(null).message("逻辑删除教师数据失败");
        }
    }
}
```

#### 7、条件分页查询教师列表接口

##### 7.1、创建配置类

```java
package com.myxh.smart.planet.vod.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MYXH
 * @date 2023/9/29
 * @description 配置类
 */
@Configuration
@MapperScan("com.myxh.smart.planet.vod.mapper")
public class VodConfig
{
    /**
     * 分页插件
     *
     * @return MyBatis Plus 拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor()
    {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        return interceptor;
    }
}
```

##### 7.2、创建查询条件对象

![创建查询条件对象](https://img-blog.csdnimg.cn/b4bcdfc4e7b84096ae79c06b7ab5b66f.png)

```java
package com.myxh.smart.planet.vo.vod;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class TeacherQueryVo
{
    @Schema(description = "教师姓名")
    private String name;

    @Schema(description = "头衔：1 -> 高级教师，2 -> 首席教师")
    private Integer level;

    @Schema(description = "入驻时间")
    private String joinDateBegin;

    @Schema(description = "入驻时间")
    private String joinDateEnd;
}
```

##### 7.3、编写 controller

```java
package com.myxh.smart.planet.vod.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.TeacherQueryVo;
import com.myxh.smart.planet.vod.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@Tag(name = "教师接口", description = "教师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 条件查询教师分页
     *
     * @param current        当前页码
     * @param limit          每页记录数
     * @param teacherQueryVo 查询对象
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "条件查询分页", description = "条件查询教师分页")
    @PostMapping("find/query/page/{current}/{limit}")
    public Result<IPage<Teacher>> findTeacherPage(@Parameter(name = "current", description = "当前页码", required = true) @PathVariable("current") Long current,
                                                  @Parameter(name = "limit", description = "每页记录数", required = true) @PathVariable("limit") Long limit,
                                                  @Parameter(name = "TeacherQueryVo", description = "查询对象") @RequestBody(required = false) TeacherQueryVo teacherQueryVo)
    {
        // 创建 page 对象，传递当前页和每页记录数
        Page<Teacher> teacherPageParam = new Page<>(current, limit);

        // 判断 teacherQueryVo 对象是否为空
        if (teacherQueryVo == null)
        {
            // 查询所有教师
            IPage<Teacher> teacherPageModel = teacherService.page(teacherPageParam, null);

            return Result.ok(teacherPageModel);
        }
        else
        {
            // 获取条件值
            // 教师名称
            String name = teacherQueryVo.getName();
            // 教师级别
            Integer level = teacherQueryVo.getLevel();
            // 开始时间
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();
            // 结束时间
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();

            // 进行非空判断，条件封装
            QueryWrapper<Teacher> wrapper = new QueryWrapper<>();

            if (StringUtils.hasLength(name))
            {
                wrapper.like("name", name);
            }
            if (!ObjectUtils.isEmpty(level))
            {
                wrapper.eq("level", level);
            }
            if (StringUtils.hasLength(joinDateBegin))
            {
                wrapper.ge("join_date", joinDateBegin);
            }
            if (StringUtils.hasLength(joinDateEnd))
            {
                wrapper.le("join_date", joinDateEnd);
            }

            //调用方法得到分页查询结果
            IPage<Teacher> teacherPageModel = teacherService.page(teacherPageParam, wrapper);

            // 返回结果
            return Result.ok(teacherPageModel);
        }
    }
}
```

#### 8、添加教师接口

##### 8.1、编写 controller

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@Tag(name = "教师接口", description = "教师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 添加教师
     *
     * @param teacher 教师数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加", description = "添加教师")
    @PostMapping("save")
    public Result<Void> saveTeacher(@RequestBody Teacher teacher)
    {
        boolean isSuccess = teacherService.save(teacher);

        if (isSuccess)
        {
            return Result.ok(null);
        }
        else
        {
            return Result.fail(null);
        }
    }
}
```

#### 9、修改教师接口

##### 9.1、编写 id 查询方法

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@Tag(name = "教师接口", description = "教师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 根据 id 查询教师
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询", description = "根据 id 查询教师")
    @GetMapping("get/{id}")
    public Result<Teacher> getTeacher(@Parameter(name = "id", description = "ID", required = true) @PathVariable Long id)
    {
        Teacher teacher = teacherService.getById(id);

        return Result.ok(teacher);
    }
}
```

##### 9.2、编写修改方法

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@Tag(name = "教师接口", description = "教师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 修改教师
     *
     * @param teacher 教师数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改", description = "修改教师")
    @PostMapping("update")
    public Result<Void> updateTeacher(@RequestBody Teacher teacher)
    {
        boolean isSuccess = teacherService.updateById(teacher);

        if (isSuccess)
        {
            return Result.ok(null);
        }
        else
        {
            return Result.fail(null);
        }
    }
}
```

#### 10、批量删除教师接口

##### 10.1、编写 controller

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@Tag(name = "教师接口", description = "教师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 批量删除教师
     *
     * @param idList id 数组，Json 数组 [1,2,3,...]
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "批量删除", description = "批量删除教师")
    @DeleteMapping("remove/batch")
    public Result<Void> removeBatchTeacher(@RequestBody List<Long> idList)
    {
        boolean isSuccess = teacherService.removeByIds(idList);

        if (isSuccess)
        {
            return Result.ok(null);
        }
        else
        {
            return Result.fail(null);
        }
    }
}
```

### 三、统一异常处理

#### 1、制造异常

**除以 0。**

```java
// 模拟异常
int n = 10 / 0;
```

想让异常结果也显示为统一的返回结果对象，并且统一处理系统的异常信息，那么需要统一异常处理。

#### 2、全局异常处理

##### 2.1、创建统一异常处理器

**在 service-utils 中创建统一异常处理类 GlobalExceptionHandler.java：**

```java
package com.myxh.smart.planet.exception;

import com.myxh.smart.planet.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MYXH
 * @date 2023/9/30
 */
// 底层通过 AOP 实现
@ControllerAdvice
public class GlobalExceptionHandler
{
    /**
     * 全局异常处理
     *
     * @return Result 全局统一返回结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e)
    {
        e.printStackTrace();

        return Result.fail(null).message("执行全局异常处理");
    }
}
```

##### 2.2、测试

#### 3、处理特定异常

##### 3.1、添加异常处理方法

**GlobalExceptionHandler.java 中添加：**

```java
package com.myxh.smart.planet.exception;

import com.myxh.smart.planet.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MYXH
 * @date 2023/9/30
 */
// 底层通过 AOP 实现
@ControllerAdvice
public class GlobalExceptionHandler
{
    /**
     * 特定异常处理
     *
     * @return Result 全局统一返回结果
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e)
    {
        e.printStackTrace();

        return Result.fail(null).message("执行 ArithmeticException 特定异常处理");
    }
}
```

##### 3.2、测试

#### 4、处理自定义异常

##### 4.1、创建自定义异常类

```java
package com.myxh.smart.planet.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MYXH
 * @date 2023/9/30
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SmartPlanetException extends RuntimeException
{
    private Integer code;
    private String message;
}
```

##### 4.2、业务中需要位置抛出

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@Tag(name = "教师接口", description = "教师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 查询所有教师
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询所有", description = "查询所有教师")
    @GetMapping("find/all")
    public Result<List<Teacher>> findAllTeacher()
    {
        try
        {
            // 模拟异常
            int n = 10 / 0;
        }
        catch (Exception e)
        {
            // 抛出异常
            throw new SmartPlanetException(201, "执行 SmartPlanetException 自定义异常处理");
        }

        List<Teacher> teacherList = teacherService.list();

        return Result.ok(teacherList).message("查询所有教师数据成功");
    }
}
```

##### 4.3、添加异常处理方法

**GlobalExceptionHandler.java 中添加**

```java
package com.myxh.smart.planet.exception;

import com.myxh.smart.planet.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MYXH
 * @date 2023/9/30
 */
// 底层通过 AOP 实现
@ControllerAdvice
public class GlobalExceptionHandler
{
    /**
     * SmartPlanetException 自定义异常处理
     *
     * @return Result 全局统一返回结果
     */
    @ExceptionHandler(SmartPlanetException.class)
    @ResponseBody
    public Result error(SmartPlanetException e)
    {
        e.printStackTrace();

        return Result.fail(null).code(e.getCode()).message(e.getMessage());
    }
}
```

##### 4.4、测试

## Day 3-前端基础知识

### 一、前端开发和前端开发工具

#### 1、前端开发介绍

前端工程师“Front-End-Developer”源自于美国。大约从 2005 年开始正式的前端工程师角色被行业所认可，到了 2010 年，互联网开始全面进入移动时代，前端开发的工作越来越重要。

最初所有的开发工作都是由后端工程师完成的，随着业务越来越繁杂，工作量变大，于将项目中的可视化部分和一部分交互功能的开发工作剥离出来，形成了前端开发。

由于互联网行业的急速发展，导致了在不同的国家，有着截然不同的分工体制。

在日本和一些人口比较稀疏的国家，例如加拿大、澳洲等，流行“Full-Stack Engineer”，也就是通常所说的全栈工程师。通俗点说就是一个人除了完成前端开发和后端开发工作以外，有的公司从产品设计到项目开发再到后期运维可能都是同一个人，甚至可能还要负责 UI、配动画、写文档等等。

而在美国等互联网环境比较发达的国家项目开发的分工协作更为明确，整个项目开发分为前端、中间层和后端三个开发阶段，这三个阶段分别由三个或者更多的人来协同完成。

国内的大部分互联网公司只有前端工程师和后端工程师，中间层的工作有的由前端来完成，有的由后端来完成。

PRD（产品原型-产品经理）、PSD（视觉设计-UI 工程师）、HTML/CSS/JavaScript（PC/移动端网页，实现网页端的视觉展示和交互-前端工程师）。

#### 2、下载和安装 VS Code

##### 2.1、下载地址

https://code.visualstudio.com/

##### 2.2、插件安装

为方便后续开发，建议安装如下插件

![插件安装](https://img-blog.csdnimg.cn/25494f2ce83c4f2ba6d3adf0bf6cfb2e.png)

##### 2.3、创建项目

VS Code 本身没有新建项目的选项，所以要先创建一个空的文件夹，如 project_xxx。

然后打开 VS Code，再在 VS Code 里面选择 File -> Open Folder 打开文件夹，这样才可以创建项目。

##### 2.4、保存工作区

打开文件夹后，选择“文件 -> 将工作区另存为...”，为工作区文件起一个名字，存储在刚才的文件夹下即可。

##### 2.5、新建文件夹和网页

##### 2.6、预览网页

**以文件路径方式打开网页预览：**

需要安装“open in browser”插件：

文件右键 -> Open In Default Browser

**以服务器方式打开网页预览：**

需要安装“Live Server”插件：

文件右键 -> Open with Live Server

##### 2.7、设置字体大小

左边栏 Manage -> settings -> 搜索 “font” -> Font size

### 二、ECMAScript 6 简介

ECMAScript 6.0（以下简称 ES6）是 JavaScript 语言的下一代标准，已经在 2015 年 6 月正式发布了。它的目标是使得 JavaScript 语言可以用来编写复杂的大型应用程序，成为企业级开发语言。

#### 1、与 JavaScript 的关系

一个常见的问题是，ECMAScript 和 JavaScript 到底是什么关系？

要讲清楚这个问题，需要回顾历史。1996 年 11 月，JavaScript 的创造者 Netscape 公司，决定将 JavaScript 提交给标准化组织 ECMA，希望这种语言能够成为国际标准。次年，ECMA 发布 262 号标准文件（ECMA-262）的第一版，规定了浏览器脚本语言的标准，并将这种语言称为 ECMAScript，这个版本就是 1.0 版。

因此，ECMAScript 和 JavaScript 的关系是，前者是后者的规格，后者是前者的一种实现（另外的 ECMAScript 方言还有 Jscript 和 ActionScript）。

#### 2、与 ECMAScript 2015 的关系

ECMAScript 2015（简称 ES2015）这个词，也是经常可以看到的。它与 ES6 是什么关系呢？

2011 年，ECMAScript 5.1 版发布后，就开始制定 6.0 版了。因此，ES6 这个词的原意，就是指 JavaScript 语言的下一个版本。

ES6 的第一个版本，在 2015 年 6 月发布，正式名称是《ECMAScript 2015 标准》（简称 ES2015）。

2016 年 6 月，小幅修订的《ECMAScript 2016 标准》（简称 ES2016）如期发布，这个版本可以看作是 ES6.1 版，因为两者的差异非常小，基本上是同一个标准。根据计划，2017 年 6 月发布 ES2017 标准。

因此，ES6 既是一个历史名词，也是一个泛指，含义是 5.1 版以后的 JavaScript 的下一代标准，涵盖了 ES2015、ES2016、ES2017 等等，而 ES2015 则是正式名称，特指该年发布的正式版本的语言标准。

### 三、ES6 基本语法

ES 标准中不包含 DOM 和 BOM 的定义，只涵盖基本数据类型、关键字、语句、运算符、内建对象、内建函数等通用语法。

本部分只学习前端开发中 ES6 的最少必要知识，方便后面项目开发中对代码的理解。

#### 1、let 声明变量

创建 let.html。

```javascript
/*
1、
var 声明的变量没有局部作用域
let 声明的变量有局部作用域
 */
{
  var a = 0;
  let b = 1;
}

// 0
console.log(a);

// ReferenceError: b is not defined
console.log(b);
```

```javascript
/*
2、
var 可以声明多次
let 只能声明一次
 */
var m = 1;
var m = 2;
let n = 3;
let n = 4;

// 2
console.log(m);

// Identifier 'n' has already been declared
console.log(n);
```

#### 2、const 声明常量（只读变量）

创建 const.html。

```javascript
// 1、声明之后不允许改变
const PI = "3.1415926";

// TypeError: Assignment to constant variable.
PI = 3.14;
```

```javascript
// 2、一但声明必须初始化，否则会报错
// SyntaxError: Missing initializer in const declaration
const MY_NAME
```

#### 3、解构赋值

创建解构赋值.html。

解构赋值是对赋值运算符的扩展。

是一种针对数组或者对象进行模式匹配，然后对其中的变量进行赋值。

在代码书写上简洁且易读，语义更加清晰明了；也方便了复杂对象中数据字段获取。

```javascript
// 对象解构
let user = { name: "MYXH", age: 21 };

// 1、传统
let myName = user.name;
let myAge = user.age;
console.log(name1, age1);

// 2、ES6
//注意：结构的变量必须是 user 中的属性
let { name, age } = user;
console.log(name, age);
```

#### 4、模板字符串

创建模板字符串.html。

模板字符串相当于加强版的字符串，用反引号 `,除了作为普通字符串，还可以在字符串中加入变量和表达式。

```javascript
// 1、字符串插入变量和表达式，变量名写在 ${} 中，${} 中可以放入 JavaScript 表达式
let name = "MYXH";
let age = 21;
let info = `My Name is ${name},I am ${age + 1} years.`;

// My Name is MYXH,I am 28 years.
console.log(info);
```

```javascript
// 2、字符串中调用函数
function f() {
  return "have fun!";
}

let string = `Game start,${f()}`;

// Game start,have fun!
console.log(string);
```

#### 5、定义方法简写

创建定义方法简写.html。

```javascript
// 1、传统
const person1 = {
  sayHi: function () {
    console.log("Hi!");
  },
};

//"Hi!"
person1.sayHi();

// 2、ES6
const person2 = {
  sayHi() {
    console.log("Hi!");
  },
};

//"Hi!"
person2.sayHi();
```

#### 6、对象拓展运算符

创建对象拓展运算符.html。

拓展运算符（...）用于取出参数对象所有可遍历属性然后拷贝到当前对象。

```javascript
// 1、拷贝对象
let person1 = { name: "MYXH", age: 21 };
let person2 = { ...person1 };

//{name: "MYXH", age: 21}
console.log(person2);
```

#### 7、箭头函数

创建箭头函数.html。

箭头函数提供了一种更加简洁的函数书写方式，基本语法是：`参数 => 函数体`。

```javascript
// 1、传统
var f1 = function (a) {
  return a;
};

console.log(f1(1));

// 2、ES6
var f2 = (a) => a;
console.log(f2(1));

/*
当箭头函数没有参数或者有多个参数，要用 () 括起来。
当箭头函数函数体有多行语句，用 {} 包裹起来，表示代码块，
当只有一行语句，并且需要返回结果时，可以省略 {} , 结果会自动返回。
 */
var f3 = (a, b) => {
  let result = a + b;

  return result;
};

// 3
console.log(f3(1, 2));

// 前面代码相当于：
var f4 = (a, b) => a + b;

// 3
console.log(f4(1, 2));
```

箭头函数多用于匿名函数的定义。

### 四、Vue

#### 1、Vue.js 是什么

Vue (读音 /vjuː/，类似于 view) 是一套用于构建用户界面的渐进式框架。

Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，当与现代化的工具链以及各种支持类库结合使用时，Vue 也完全能够为复杂的单页应用提供驱动。

官方网站：https://cn.vuejs.org

#### 2、初始 Vue.js

创建 demo.html。

```html
<!-- id 标识 vue 作用的范围 -->
<div id="app">
  <!-- {{}} 插值表达式，绑定 vue 中的 data 数据 -->
  {{ message }}
</div>

<script src="vue.min.js"></script>
<script>
  // 创建一个 vue 对象
  new Vue({
    // 绑定 vue 作用的范围
    el: "#app",

    data: {
      // 定义页面中显示的模型数据
      message: "Hello Vue!",
    },
  });
</script>
```

这就是声明式渲染：Vue.js 的核心是一个允许采用简洁的模板语法来声明式地将数据渲染进 DOM 的系统。

这里的核心思想就是没有繁琐的 DOM 操作，例如 jQuery 中，需要先找到 div 节点，获取到 DOM 对象，然后进行一系列的节点操作。

**在 vs code 中创建代码片段：**

文件 -> 首选项 -> 用户代码片段 -> 新建全局代码片段或文件夹代码片段：vue-html.code-snippets

**注意：制作代码片段的时候，字符串中如果包含文件中复制过来的“Tab”键的空格，要换成“空格键”的空格。**

```json
{
  "vue html": {
    "scope": "html",
    "prefix": "vue-html",
    "body": [
      "<!DOCTYPE html>",
      "<html lang=\"en\">",
      "<head>",
      "    <meta charset=\"UTF-8\">",
      "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">",
      "    <title>Document</title>",
      "</head>",
      "",
      "<body>",
      "    <div id=\"app\">",
      "",
      "    </div>",
      "",
      "    <script src=\"vue.min.js\"></script>",
      "    <script>",
      "        new Vue({",
      "            el: '#app',",
      "            data: {",
      "                $1",
      "            }",
      "        })",
      "    </script>",
      "</body>",
      "</html>"
    ],
    "description": "my vue template in html"
  }
}
```

#### 3、Vue 指令和差值表达式

##### 3.1、基本数据渲染和指令

创建 01-基本数据渲染和指令.html。

你看到的 v-bind 特性被称为指令。指令带有前缀 v-。

除了使用插值表达式{{}}进行数据渲染，也可以使用 v-bind 指令，它的简写的形式就是一个冒号:。

```javascript
data: {
    content: '我是标题',
    message: '页面加载于 ' + new Date().toLocaleString()
}
```

```html
<!--
如果要将模型数据绑定在 html 属性中，则使用 v-bind 指令
此时 title 中显示的是模型数据
 -->
<h1 v-bind:title="message">{{content}}</h1>

<!-- v-bind 指令的简写形式：冒号: -->
<h1 :title="message">{{content}}</h1>
```

##### 3.2、双向数据绑定

创建 02-双向数据绑定.html。

双向数据绑定和单向数据绑定：使用 v-model 进行双向数据绑定。

```javascript
data: {
  searchMap: {
    keyWord: "MYXH";
  }
}
```

```html
<!-- v-bind:value 只能进行单向的数据渲染 -->
<input type="text" v-bind:value="searchMap.keyWord" />

<!-- v-model 可以进行双向的数据绑定  -->
<input type="text" v-model="searchMap.keyWord" />
<p>您要查询的是：{{searchMap.keyWord}}</p>
```

##### 3.3、事件

创建 03-事件.html。

**需求：** 点击查询按钮，调用方法。

增加 methods 节点 并定义 search 方法。

```javascript
data: {

},

methods:{
    search(){
        console.log('search')
    }
}
```

html 中增加 button 和 p。

使用 v-on 进行数件处理，v-on:click 表示处理鼠标点击事件，事件调用的方法定义在 vue 对象声明的 methods 节点中。

```html
<!-- v-on 指令绑定事件，click 指定绑定的事件类型，事件发生时调用 vue 中 methods 节点中定义的方法 -->
<button v-on:click="search()">查询</button>
```

简写：

```html
<!-- v-on 指令的简写形式 @ -->
<button @click="search()">查询</button>
```

##### 3.4、条件渲染

创建 04-条件渲染.html。

v-if：条件指令。

```javascript
data: {
  ok: false;
}
```

注意：单个复选框绑定到布尔值。

```html
<input type="checkbox" v-model="ok" />同意许可协议

<!-- v:if 条件指令：还有v-else、v-else-if ，要注意性能开销 -->
<h1 v-if="ok">这是一个通用的中文占位文本短语，用于表示占位文本的内容。</h1>
<h1 v-else>no</h1>
```

##### 3.5、列表渲染

创建 05-列表渲染.html。

v-for：列表循环指令。

**例 1：遍历数据列表。**

```javascript
data: {
  userList: [
    { id: 1, username: "helen" },
    { id: 2, username: "peter" },
    { id: 3, username: "andy" },
  ];
}
```

```html
<!-- 遍历数据列表 -->
<table border="1">
  <!-- <tr v-for="item in userList"></tr> -->
  <tr v-for="(item, index) in userList">
    <td>{{index}}</td>
    <td>{{item.id}}</td>
    <td>{{item.username}}</td>
  </tr>
</table>
```

#### 4、Vue 生命周期

![Vue 生命周期](https://img-blog.csdnimg.cn/990d194ad41c4777a96c4e44205dc441.png)

创建 vue 实例的生命周期.html。

```html
<h1 id="h1">{{ message }}</h1>
```

分析生命周期相关方法的执行时机

```javascript
data: {
    message: 'Vue 生命周期'
},

// 在渲染之前执行
created() {
    console.log("created...")
},

// 在渲染之后执行
mounted() {
    console.log("mounted...")
},

methods: {

}
```

#### 5、Vue 组件

组件（Component）是 Vue.js 最强大的功能之一。

组件可以扩展 HTML 元素，封装可重用的代码。组件系统让我们可以用独立可复用的小组件来构建大型应用，几乎任意类型的应用的界面都可以抽象为一个组件树。

![Vue 组件](https://img-blog.csdnimg.cn/f9c36bffea774608b9a5f10bc490d9fc.png)

##### 5.1、定义组件

```javascript
var app = new Vue({
  el: "#app",

  // 定义局部组件，这里可以定义多个局部组件
  components: {
    // 组件的名字
    Navbar: {
      // 组件的内容
      template: "<ul><li>首页</li><li>用户管理</li></ul>",
    },
  },
});
```

##### 5.2、使用组件

```html
<div id="app">
  <Navbar></Navbar>
</div>
```

#### 6、路由

Vue.js 路由允许通过不同的 URL 访问不同的内容。

通过 Vue.js 可以实现多视图的单页 Web 应用（single page web application，SPA）。

Vue.js 路由需要载入 vue-router 库。

创建 路由.html。

##### 6.1、引入 js

```javascript
<script src="vue.min.js"></script>
<script src="vue-router.min.js"></script>
```

##### 6.2、编写 html

```html
<div id="app">
  <h1>Hello App!</h1>

  <p>
    <!-- 使用 router-link 组件来导航 -->
    <!-- 通过传入 to 属性指定链接 -->
    <!-- <router-link> 默认会被渲染成一个 <a> 标签 -->
    <router-link to="/">首页</router-link>
    <router-link to="/student">学生管理</router-link>
    <router-link to="/teacher">教师管理</router-link>
  </p>

  <!-- 路由出口 -->
  <!-- 路由匹配到的组件将渲染在这里 -->
  <router-view></router-view>
</div>
```

##### 6.3、编写 js

```html
<script>
  // 1、定义（路由）组件
  // 可以从其他文件 import 进来
  const Welcome = { template: "<div>欢迎</div>" };
  const Student = { template: "<div>student list</div>" };
  const Teacher = { template: "<div>teacher list</div>" };

  // 2、定义路由
  // 每个路由应该映射一个组件
  const routes = [
    // 设置默认指向的路径
    { path: "/", redirect: "/welcome" },
    { path: "/welcome", component: Welcome },
    { path: "/student", component: Student },
    { path: "/teacher", component: Teacher },
  ];

  // 3、创建 router 实例，然后传 routes 配置
  const router = new VueRouter({
    // 缩写，相当于 routes: routes
    routes,
  });

  // 4、创建和挂载根实例
  // 从而让整个应用都有路由功能
  const app = new Vue({
    el: "#app",

    router,
  });

  // 现在，应用已经启动了
</script>
```

#### 7、axios

axios 是独立于 vue 的一个项目，基于 promise 用于浏览器和 node.js 的 http 客户端。

- 在浏览器中可以完成 ajax 请求的发送。

- 在 node.js 中可以向远程接口发送请求。

##### 7.1、获取数据

```html
<script src="vue.min.js"></script>
<script src="axios.min.js"></script>
```

```javascript
var app = new Vue({
  el: "#app",

  data: {
    // 数组
    memberList: [],
  },

  created() {
    this.getList();
  },

  methods: {
    getList(id) {
      // vm = this
      axios
        .get("data.json")
        .then((response) => {
          console.log(response);
          this.memberList = response.data.data.items;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
});
```

**控制台查看输出。**

##### 7.2、显示数据

```html
<div id="app">
    <table border="1">
        <tr>
            <td>id</td>
            <td>姓名</td>
        </tr>

        <tr v-for="item in memberList">
            <td>{{item.memberId}}</td>
            <td>{{item.nickname}}</td>
        </td>
    </tr>
</table>
</div>
```

#### 8、element-ui

element-ui 是饿了么前端出品的基于 Vue.js 的 后台组件库，方便程序员进行页面快速布局和构建。

官网： http://element-cn.eleme.io/#/zh-CN

ui 相关组件在项目中学习。

### 五、Node.js

#### 1、Node.js 简介

##### 1.1、什么是 Node.js

简单的说 Node.js 就是运行在服务端的 JavaScript。

Node.js 是一个事件驱动 I/O 服务端 JavaScript 环境，基于 Google 的 V8 引擎，V8 引擎执行 Javascript 的速度非常快，性能非常好。

##### 1.2、Node.js 有什么用

如果你是一个前端程序员，你不懂得像 PHP、Python 或 Ruby 等动态编程语言，然后你想创建自己的服务，那么 Node.js 是一个非常好的选择。

Node.js 是运行在服务端的 JavaScript，如果你熟悉 Javascript，那么你将会很容易的学会 Node.js。

当然，如果你是后端程序员，想部署一些高性能的服务，那么学习 Node.js 也是一个非常好的选择。

#### 2、Node.js 安装

##### 2.1、下载

官网：https://nodejs.org/en/

中文网：http://nodejs.cn/

LTS：长期支持版本。

Current：最新版。

##### 2.2、安装和查看版本

```shell
node -v
```

#### 3、简单入门

创建控制台程序.js。

```javascript
console.log("Hello Node.js");
```

进入到程序所在的目录，输入：

```shell
node 控制台程序.js
```

浏览器的内核包括两部分核心：

- DOM 渲染引擎；

- js 解析器（js 引擎），

- js 运行在浏览器中的内核中的 js 引擎内部。

Node.js 是脱离浏览器环境运行的 JavaScript 程序，基于 V8 引擎（Chrome 的 JavaScript 的引擎）。

## Day 4-前端基础知识

### 一、NPM

#### 1、NPM 简介

##### 1.1、什么是 NPM

NPM 全称 Node Package Manager，是 Node.js 包管理工具，是全球最大的模块生态系统，里面所有的模块都是开源免费的，也是 Node.js 的包管理工具，相当于前端的 Maven。

##### 1.2、NPM 工具的安装位置

通过 npm 可以很方便地下载 js 库，管理前端工程。

Node.js 默认安装的 npm 包和工具的位置：Node.js 目录\node_modules

- 在这个目录下你可以看见 npm 目录，npm 本身就是被 NPM 包管理器管理的一个工具，说明 Node.js 已经集成了 npm 工具。

```shell
# 在命令提示符输入 npm -v 可查看当前 npm 版本
npm -v
```

#### 2、使用 npm 管理项目

##### 2.1、创建文件夹 npm

##### 2.2、项目初始化

```shell
# 建立一个空文件夹，在命令提示符进入该文件夹，执行命令初始化
npm init

# 按照提示输入相关信息，如果是用默认值则直接回车即可
# name: 项目名称
# version: 项目版本号
# description: 项目描述
# keywords: {Array} 关键词，便于用户搜索到的项目
# 最后会生成 package.json 文件，这个是包的配置文件，相当于 maven 的 pom.xml
# 之后也可以根据需要进行修改。
```

```shell
# 如果想直接生成 package.json 文件，那么可以使用命令
npm init -y
```

##### 2.3、修改 npm 镜像

NPM 官方的管理的包都是从 http://npmjs.com 下载的，但是这个网站在国内速度很慢。

这里推荐使用淘宝 NPM 镜像 http://npm.taobao.org/ ，淘宝 NPM 镜像是一个完整 npmjs.com 镜像，同步频率目前为 10 分钟一次，以保证尽量与官方服务同步。

**设置镜像地址：**

```shell
# 经过下面的配置，以后所有的 npm install 都会经过淘宝的镜像地址下载
npm config set registry https://registry.npm.taobao.org

# 查看 npm 配置信息
npm config list
```

##### 2.4、npm install 命令的使用

```shell
# 使用 npm install 安装依赖包的最新版
# 模块安装的位置：项目目录\node_modules
# 安装会自动在项目目录下添加 package-lock.json 文件，这个文件帮助锁定安装包的版本
# 同时 package.json 文件中，依赖包会被添加到 dependencies 节点下，类似 maven 中的 <dependencies>
npm install jquery

# npm管理的项目在备份和传输的时候一般不携带 node_modules 文件夹
# 根据 package.json 中的配置下载依赖，初始化项目
npm install

# 如果安装时想指定特定的版本
npm install jquery@2.1.x

#  局部安装
# devDependencies节点：开发时的依赖包，项目打包到生产环境的时候不包含的依赖
# 使用 -D参数将依赖添加到 devDependencies 节点
npm install --save-dev eslint

# 或

npm install -D eslint

# 全局安装
# Node.js 全局安装的 npm 包和工具的位置：用户目录\AppData\Roaming\npm\node_modules
# 一些命令行工具常使用全局安装的方式
npm install -g webpack

# 或

npm install --global webpack
```

##### 2.5、其它命令

```shell
# 更新包（更新到最新版本）
npm update 包名

# 全局更新
npm update -g 包名

# 卸载包
npm uninstall 包名

# 全局卸载
npm uninstall -g 包名
```

### 二、模块化开发（一）

#### 1、模块化简介

##### 1.1、模块化产生的背景

随着网站逐渐变成"互联网应用程序"，嵌入网页的 Javascript 代码越来越庞大，越来越复杂。

![模块化产生的背景](https://img-blog.csdnimg.cn/8f15bfee2bfd4ee690a48f3dc6314633.png)

Javascript 模块化编程，已经成为一个迫切的需求。理想情况下，开发者只需要实现核心的业务逻辑，其他都可以加载别人已经写好的模块。

但是，Javascript 不是一种模块化编程语言，它不支持"类"（class），包（package）等概念，更遑论"模块"（module）了。

##### 1.2、什么是模块化开发

传统非模块化开发有如下的缺点：

- 命名冲突。

- 文件依赖。

模块化规范：

- CommonJS 模块化规范。

- ES6 模块化规范。

#### 2、ES5 模块化

每个文件就是一个模块，有自己作用域。在一个文件里定义的变量、函数、类，都是私有的，对其他文件不可见。

##### 2.1、创建“module”文件夹

##### 2.2、导出模块

创建 es5/四则运算.js。

```javascript
// 定义成员
const sum = function (a, b) {
  return parseInt(a) + parseInt(b);
};

const subtract = function (a, b) {
  return parseInt(a) - parseInt(b);
};
```

导出模块中的成员。

```javascript
// 导出成员
module.exports = {
  sum: sum,
  subtract: subtract,
};
```

简写：

```javascript
// 简写
module.exports = {
  sum,
  subtract,
};
```

##### 2.3、导入模块

创建 es5/引入模块.js。

```javascript
// 引入模块，注意：当前路径必须写 ./
const m = require("./四则运算.js");
console.log(m);
const result1 = m.sum(1, 2);
const result2 = m.subtract(2, 1);
console.log(result1, result2);
```

##### 2.4、运行程序

```shell
node es5/引入模块.js
```

CommonJS 使用 exports 和 require 来导出、导入模块。

### 三、模块化开发（二）

#### 1、ES6 模块化写法（一）

ES6 使用 export 和 import 来导出、导入模块。

##### 1.1、导出模块

创建 es6/userApi1.js。

```javascript
export function getList() {
  console.log("获取数据列表1");
}

export function save() {
  console.log("保存数据1");
}
```

##### 1.2、导入模块

创建 es6/userComponent1.js。

```javascript
// 只取需要的方法即可，多个方法用逗号分隔
import { getList, save } from "./userApi1.js";

getList();
save();
```

**注意：这时程序无法运行，因为 ES6 的模块化无法在 Node.js 中执行，需要用 Babel 编辑成 ES5 后再执行。**

##### 1.3、安装 Babel

Babel 是一个广泛使用的转码器，可以将 ES6 代码转为 ES5 代码，从而在现有环境执行执行。

**安装命令行转码工具。**

Babel 提供 babel-cli 工具，用于命令行转码。它的安装命令如下：

```shell
npm install -global @babel/cli

# 查看是否安装成功
babel --version
```

##### 1.4、配置 .babelrc

Babel 的配置文件是 .babelrc，存放在项目的根目录下，该文件用来设置转码规则和插件，presets 字段设定转码规则，将 es2015 规则加入 .babelrc：

```javascript
{
    "presets": ["es2015"],
    "plugins": []
}
```

##### 1.5、安装转码器

在项目中安装。

```shell
npm install --save-dev babel-preset-es2015
```

##### 1.6、转码

```shell
# 整个目录转码
mkdir dist1

# --out-dir 或 -d 参数指定输出目录
babel es6 -d dist1
```

##### 1.7、运行程序

```shell
node dist1/userComponent1.js
```

#### 2、ES6 模块化写法（二）

##### 2.1、导出模块

创建 es6/userApi2.js。

```javascript
export default {
  getList() {
    console.log("获取数据列表2");
  },

  save() {
    console.log("保存数据2");
  },
};
```

##### 2.2、导入模块

创建 es6/userComponent2.js。

```javascript
import user from "./userApi2.js";

user.getList();
user.save();
```

##### 2.3、转码

```shell
# 整个目录转码
mkdir dist2

# --out-dir 或 -d 参数指定输出目录
babel es6 -d dist2
```

##### 2.4、运行程序

```shell
node dist2/userComponent2.js
```

### 四、搭建项目前端环境

#### 1、vue-admin-template 模板

vue-admin-template 是基于 vue-element-admin 的一套后台管理系统基础模板（最少精简版），可作为模板进行二次开发。

![vue-admin-template 模板](https://img-blog.csdnimg.cn/fb50d4f727964788a76751b3885b1a74.png)

GitHub 地址：https://github.com/PanJiaChen/vue-admin-template

#### 2、搭建环境

```shell
# 解压压缩包
# 进入目录
cd vue-admin-template

# 安装依赖
npm install

# 启动执行后，浏览器自动弹出并访问 http://localhost:9528/
npm run dev
```

#### 3、修改登录功能

##### 3.1、创建登录接口

**创建 LoginController**

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/2
 */
@RestController
@RequestMapping("/admin/vod/user")
// 允许跨域请求
@CrossOrigin
public class UserLoginController
{
    /**
     * login 用户登录
     *
     * @return Result 全局统一返回结果
     */
    @PostMapping("login")
    public Result<Map<String, Object>> login()
    {
        // 前端接口：{"code":20000,"data":{"token":"admin-token"}}
        Map<String, Object> data = new HashMap<>();
        data.put("token", "admin-token");

        return Result.ok(data);
    }

    /**
     * info 用户信息
     *
     * @return Result 全局统一返回结果
     */
    @GetMapping("info")
    public Result<Map<String, Object>> info()
    {
        /*
        前端接口：
        {
            "code":20000,
            "data":
                {
                    "roles":["admin"],
                    "introduction":"I am a super administrator",
                    "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif"
                    "name":"Super Admin"
                }
        }
         */

        Map<String, Object> data = new HashMap<>();
        data.put("roles", "admin");
        data.put("introduction", "我是一名超级管理员");
        data.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        data.put("name", "超级管理员");

        return Result.ok(data);
    }

    /**
     * logout 退出登录
     *
     * @return Result 全局统一返回结果
     */
    @PostMapping("logout")
    public Result<Void> logout()
    {
        // 前端接口：{"code":20000,"data":null}
        return Result.ok(null);
    }
}
```

##### 3.2、修改登录前端

##### 3.2.1、修改接口路径

![修改接口路径](https://img-blog.csdnimg.cn/a023f02e8b254d00853a4e14e317f96a.png)

##### 3.2.2、修改 js 文件

![修改 js 文件](https://img-blog.csdnimg.cn/9f6b2d3d31f7457f91c82b569d345441.png)

```javascript
import request from "@/utils/request";

export function login(data) {
  return request({
    // url: '/vue-admin-template/user/login',
    url: "/admin/vod/user/login",
    method: "post",
    data,
  });
}

export function getInfo(token) {
  return request({
    // url: '/vue-admin-template/user/info',
    url: "/admin/vod/user/info",
    method: "get",
    params: { token },
  });
}

export function logout() {
  return request({
    // url: '/vue-admin-template/user/logout',
    url: "/admin/vod/user/logout",
    method: "post",
  });
}
```

### 五、跨域问题

#### 1、什么是跨域

（1）浏览器从一个域名的网页去请求另一个域名的资源时，域名、端口、协议任一不同，都是跨域 。前后端分离开发中，需要考虑 ajax 跨域的问题。

**（2）跨域的本质：浏览器对 Ajax 请求的一种限制。**

（3）这里可以从服务端解决这个问题。

#### 2、配置

**在 Controller 类上添加注解**

```java
// 允许跨域请求
@CrossOrigin
```

## Day 5-教师管理模块前端

### 一、设置路由定义

#### 1、修改路由

**修改 src/router/index.js 文件，重新定义 constantRouterMap。**

**注意：** 每个路由的 name 不能相同。

```javascript
import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

/* Layout */
import Layout from "@/layout";

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: "/login",
    component: () => import("@/views/login/index"),
    hidden: true,
  },

  {
    path: "/404",
    component: () => import("@/views/404"),
    hidden: true,
  },

  // 首页
  {
    path: "/",
    component: Layout,
    redirect: "/dashboard",
    children: [
      {
        path: "dashboard",
        name: "Dashboard",
        component: () => import("@/views/dashboard/index"),
        // meta: { title: "Dashboard", icon: "dashboard" },
        meta: { title: "智慧星球后台管理系统", icon: "dashboard" },
      },
    ],
  },

  // 教师管理
  {
    path: "/vod",
    component: Layout,
    redirect: "/vod/teacher/list",
    name: "vod",
    meta: { title: "教师管理", icon: "el-icon-s-help" },
    alwaysShow: true,
    children: [
      {
        path: "teacher/list",
        name: "TeacherList",
        component: () => import("@/views/vod/teacher/list"),
        meta: { title: "教师列表", icon: "table" },
      },
      {
        path: "teacher/create",
        name: "teacherCreate",
        component: () => import("@/views/vod/teacher/form"),
        meta: { title: "添加教师", icon: "tree" },
      },
      {
        path: "teacher/edit/:id",
        name: "TeacherEdit",
        component: () => import("@/views/vod/teacher/form"),
        meta: { title: "编辑教师" },
        hidden: true,
      },
    ],
  },

  {
    path: "external-link",
    component: Layout,
    children: [
      {
        path: "https://github.com/MYXHcode",
        meta: { title: "联系作者", icon: "link" },
      },
    ],
  },

  /*
  {
    path: "/example",
    component: Layout,
    redirect: "/example/table",
    name: "Example",
    meta: { title: "Example", icon: "el-icon-s-help" },
    children: [
      {
        path: "table",
        name: "Table",
        component: () => import("@/views/table/index"),
        meta: { title: "Table", icon: "table" },
      },
      {
        path: "tree",
        name: "Tree",
        component: () => import("@/views/tree/index"),
        meta: { title: "Tree", icon: "tree" },
      },
    ],
  },
   */

  /*
  {
    path: "/form",
    component: Layout,
    children: [
      {
        path: "index",
        name: "Form",
        component: () => import("@/views/form/index"),
        meta: { title: "Form", icon: "form" },
      },
    ],
  },
   */

  /*
  {
    path: "/nested",
    component: Layout,
    redirect: "/nested/menu1",
    name: "Nested",
    meta: {
      title: "Nested",
      icon: "nested",
    },
    children: [
      {
        path: "menu1",
        component: () => import("@/views/nested/menu1/index"), // Parent router-view
        name: "Menu1",
        meta: { title: "Menu1" },
        children: [
          {
            path: "menu1-1",
            component: () => import("@/views/nested/menu1/menu1-1"),
            name: "Menu1-1",
            meta: { title: "Menu1-1" },
          },
          {
            path: "menu1-2",
            component: () => import("@/views/nested/menu1/menu1-2"),
            name: "Menu1-2",
            meta: { title: "Menu1-2" },
            children: [
              {
                path: "menu1-2-1",
                component: () =>
                  import("@/views/nested/menu1/menu1-2/menu1-2-1"),
                name: "Menu1-2-1",
                meta: { title: "Menu1-2-1" },
              },
              {
                path: "menu1-2-2",
                component: () =>
                  import("@/views/nested/menu1/menu1-2/menu1-2-2"),
                name: "Menu1-2-2",
                meta: { title: "Menu1-2-2" },
              },
            ],
          },
          {
            path: "menu1-3",
            component: () => import("@/views/nested/menu1/menu1-3"),
            name: "Menu1-3",
            meta: { title: "Menu1-3" },
          },
        ],
      },
      {
        path: "menu2",
        component: () => import("@/views/nested/menu2/index"),
        name: "Menu2",
        meta: { title: "menu2" },
      },
    ],
  },
   */

  /*
  {
    path: "external-link",
    component: Layout,
    children: [
      {
        path: "https://panjiachen.github.io/vue-element-admin-site/#/",
        meta: { title: "External Link", icon: "link" },
      },
    ],
  },
   */

  // 404 page must be placed at the end !!!
  { path: "*", redirect: "/404", hidden: true },
];

const createRouter = () =>
  new Router({
    // mode: 'history', // require service support
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRoutes,
  });

const router = createRouter();

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter();
  router.matcher = newRouter.matcher; // reset router
}

export default router;
```

#### 2、创建 vue 组件

在 src/views 文件夹下创建以下文件夹和文件。

![创建 vue 组件](https://img-blog.csdnimg.cn/f5b948e40efc4b1ba0a606d191494753.png)

#### 3、form.vue

```html
<template>
  <div class="app-container">
    <h1>教师表单</h1>
  </div>
</template>
```

#### 4、list.vue

```html
<template>
  <div class="app-container">
    <h1>教师列表</h1>
  </div>
</template>
```

### 二、教师分页列表

#### 1、定义 api

**创建文件 src/api/vod/teacher.js。**

```javascript
import request from "@/utils/request";

const TEACHER_API = "/admin/vod/teacher";

export default {
  /**
   * 条件查询教师分页
   *
   * @param {number} current   - 当前页码
   * @param {number} limit     - 每页记录数
   * @param {Object} searchObj - 查询对象
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  teacherListPage(current, limit, searchObj) {
    return request({
      url: `${TEACHER_API}/find/query/page/${current}/${limit}`,
      method: "post",

      /*
      使用参数格式传递，写法是 params:searchObj
      使用 json 格式传递，写法是 data:searchObj
       */
      data: searchObj,
    });
  },
};
```

#### 2、初始化 vue 组件

**src/views/vod/teacher/list.vue**

```html
<template>
  <div class="app-container">
    <h1>教师列表</h1>
  </div>
</template>

<script>
  // 引入定义接口的 js 文件
  import teacherAPI from "@/api/vod/teacher";

  export default {
    // 初始值
    data() {
      return {};
    },

    //页面渲染之前
    created() {
      this.fetchData();
    },

    // 具体方法
    methods: {
      fetchData() {},
    },
  };
</script>
```

#### 3、定义 data

```javascript
// 初始值
data() {
  return {
    // 教师列表
    list: [],
    // 总记录数
    total: 0,
    // 当前页码
    page: 1,
    // 每页记录数
    limit: 10,
    // 查询对象
    searchObj: {},
    // 批量删除选中的记录列表
    multipleSelection: [],
  };
},
```

#### 4、定义 methods

```javascript
methods: {
  fetchData() {
    // 验证开始时间和结束时间的合法性
    if (!this.validateDateRange()) {
      return;
    }

    // 调用 API，进行 ajax 请求
    teacherAPI
    .teacherListPage(this.page, this.limit, this.searchObj)
    .then((response) => {
      this.list = response.data.records;
      this.total = response.data.total;
    });
  },
}
```

#### 5、表格渲染

```html
<!-- 表格 -->
<el-table :data="list" border stripe @selection-change="handleSelectionChange">
  <el-table-column type="selection" />
  <el-table-column label="序号" width="50">
    <template slot-scope="scope">
      {{ (page - 1) * limit + scope.$index + 1 }}
    </template>
  </el-table-column>
  <el-table-column prop="name" label="名称" width="80" />
  <el-table-column label="头衔" width="90">
    <template slot-scope="scope">
      <el-tag v-if="scope.row.level === 1" type="success" size="mini"
        >高级教师</el-tag
      >
      <el-tag v-if="scope.row.level === 0" size="mini">首席教师</el-tag>
    </template>
  </el-table-column>
  <el-table-column prop="intro" label="简介" />
  <el-table-column prop="sort" label="排序" width="60" />
  <el-table-column prop="joinDate" label="入驻时间" width="160" />
  <el-table-column label="操作" width="200" align="center">
    <template slot-scope="scope">
      <el-button type="text" size="mini" @click="removeById(scope.row.id)"
        >删除</el-button
      >
      <router-link :to="'/vod/teacher/edit/' + scope.row.id">
        <el-button type="text" size="mini">修改</el-button>
      </router-link>
    </template>
  </el-table-column>
</el-table>
```

#### 6、分页组件

```html
<!-- 分页组件 -->
<el-pagination
  :current-page="page"
  :total="total"
  :page-size="limit"
  :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
  style="padding: 30px 0; text-align: center"
  layout="total, sizes, prev, pager, next, jumper"
  @size-change="changePageSize"
  @current-change="changeCurrentPage"
/>
```

#### 7、顶部查询表单

```html
<!--查询表单-->
<el-card class="operate-container" shadow="never">
  <el-form :inline="true" class="demo-form-inline">
    <el-form-item label="名称">
      <el-input v-model="searchObj.name" placeholder="教师名称" />
    </el-form-item>

    <el-form-item label="头衔">
      <el-select v-model="searchObj.level" clearable placeholder="头衔">
        <el-option value="1" label="高级教师" />
        <el-option value="0" label="首席教师" />
      </el-select>
    </el-form-item>

    <el-form-item label="入驻时间">
      <el-date-picker
        v-model="searchObj.joinDateBegin"
        placeholder="开始时间"
        value-format="yyyy-MM-dd"
      />
    </el-form-item>
    <el-form-item label="-">
      <el-date-picker
        v-model="searchObj.joinDateEnd"
        placeholder="结束时间"
        value-format="yyyy-MM-dd"
      />
    </el-form-item>

    <el-button type="primary" icon="el-icon-search" @click="fetchData()"
      >查询</el-button
    >
    <el-button type="default" @click="resetData()">清空</el-button>
  </el-form>
</el-card>
```

**验证开始时间和结束时间的合法性的方法。**

```javascript
// 验证开始时间和结束时间的合法性
validateDateRange() {
  if (
    this.searchObj.joinDateBegin &&
    this.searchObj.joinDateEnd &&
    this.searchObj.joinDateBegin > this.searchObj.joinDateEnd
  ) {
    this.$message.error("开始时间不能晚于结束时间");
    return false;
  }
  return true;
},
```

**清空和分页方法。**

```javascript
// 清空表单
resetData() {
  this.searchObj = {};
  this.fetchData();
},

// 改变每页显示的记录数，size：回调参数，表示当前选中的“每页条数”
changePageSize(size) {
  this.limit = size;
  this.fetchData();
},

// 改变页码数，page：回调参数，表示当前选中的“页码”
changeCurrentPage(page) {
  this.page = page;
  this.fetchData();
},
```

### 三、教师删除

#### 1、定义 api

**src/api/vod/teacher.js**

```javascript
import request from "@/utils/request";

const TEACHER_API = "/admin/vod/teacher";

export default {
  /**
   * 逻辑删除教师
   *
   * @param {number} id - id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeTeacherById(id) {
    return request({
      url: `${TEACHER_API}/remove/${id}`,
      method: "delete",
    });
  },
};
```

#### 2、定义 methods

**src/views/vod/teacher/list.vue**

使用 MessageBox 弹框组件。

```javascript
// 逻辑删除教师
removeById(id) {
  this.$confirm("此操作将删除该教师信息, 是否继续?", "提示", {
    confirmButtonText: "确定",
    cancelButtonText: "取消",
    type: "warning",
  }).then(() => {
    // 调用接口删除
    teacherAPI.removeTeacherById(id).then((response) => {
      // 提示信息
      this.$message({
        type: "success",
        message: "删除成功!",
      });
      // 刷新页面
      this.fetchData();
    });
  });
},
```

### 四、教师新增

#### 1、定义 api

**src/api/vod/teacher.js**

```javascript
import request from "@/utils/request";

const TEACHER_API = "/admin/vod/teacher";

export default {
  /**
   * 添加教师
   *
   * @param {Object} teacher - 教师数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  saveTeacher(teacher) {
    return request({
      url: `${TEACHER_API}/save`,
      method: "post",
      data: teacher,
    });
  },
};
```

#### 2、初始化组件

**src/views/vod/teacher/form.vue**

```html
<template>
  <div class="app-container">
    <h1>教师表单</h1>

    <!-- 输入表单 -->
    <el-form label-width="120px">
      <el-form-item label="教师名称">
        <el-input v-model="teacher.name" />
      </el-form-item>
      <el-form-item label="入驻时间">
        <el-date-picker v-model="teacher.joinDate" value-format="yyyy-MM-dd" />
      </el-form-item>
      <el-form-item label="教师排序">
        <el-input-number v-model="teacher.sort" :min="0" />
      </el-form-item>
      <el-form-item label="教师头衔">
        <el-select v-model="teacher.level">
          <!--
            数据类型一定要和取出的 json 中的一致，否则没法回填
            因此，这里 value 使用动态绑定的值，保证其数据类型是 number
            -->
          <el-option :value="1" label="高级教师" />
          <el-option :value="0" label="首席教师" />
        </el-select>
      </el-form-item>
      <el-form-item label="教师简介">
        <el-input v-model="teacher.intro" />
      </el-form-item>
      <el-form-item label="教师资历">
        <el-input v-model="teacher.career" :rows="10" type="textarea" />
      </el-form-item>

      <!-- 教师头像 -->
      <el-form-item label="教师头像"> </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="saveOrUpdate()">保存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
```

#### 3、实现新增功能

```javascript
<script>
import teacherAPI from "@/api/vod/teacher";

export default {
  data() {
    return {
      teacher: {
        // 初始化教师默认数据
        sort: 0,
        level: 1,
      },

      // 保存按钮是否禁用，防止表单重复提交
      saveBtnDisabled: false,
    };
  },

  created() {},

  methods: {
    // 添加教师
    save() {
      teacherAPI.saveTeacher(this.teacher).then((response) => {
        // 提示信息
        this.$message({
          type: "success",
          message: "添加成功!",
        });

        // 跳转列表页面
        this.$router.push({ path: "/vod/teacher/list" });
      });
    },

    // 修改教师
    update() {},

    // 添加或修改教师
    saveOrUpdate() {
      // 禁用保存按钮
      this.saveBtnDisabled = true;

      if (!this.teacher.id) {
        // 教师数据中没有 id，添加
        if (!this.teacher.name) {
          this.$message.error("请输入教师名称");
          this.saveBtnDisabled = false;
          return;
        }

        this.save();
      } else {
        // 教师数据中有 id，修改
        this.update();
      }
    },
  },
};
</script>
```

### 五、教师修改-数据回显

#### 1、定义 api

**src/api/vod/teacher.js**

```javascript
import request from "@/utils/request";

const TEACHER_API = "/admin/vod/teacher";

export default {
  /**
   * 根据 id 查询教师
   *
   * @param {number} id - id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getTeacherById(id) {
    return request({
      url: `${TEACHER_API}/get/${id}`,
      method: "get",
    });
  },
};
```

#### 2、组件中调用 api

**methods 中定义 fetchDataById。**

```javascript
// 根据 id 查询教师
fetchDataById(id) {
    teacherAPI.getTeacherById(id).then((response) => {
    this.teacher = response.data;
  });
},
```

#### 3、页面渲染前调用 fetchDataById

```javascript
created() {
  // 获取路径中的 id 值，根据 id 查询得到数据，进行回显
  if (this.$route.params.id) {
    const id = this.$route.params.id;
    this.fetchDataById(id);
  }
},
```

### 六、教师修改-更新

#### 1、定义 api

```javascript
import request from "@/utils/request";

const TEACHER_API = "/admin/vod/teacher";

export default {
  /**
   * 修改教师
   *
   * @param {Object} teacher - 教师数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateTeacher(teacher) {
    return request({
      url: `${TEACHER_API}/update`,
      method: "post",
      data: teacher,
    });
  },
};
```

#### 2、组件中调用 api

**methods 中定义 updateData。**

```javascript
// 修改教师
update() {
  teacherAPI.updateTeacher(this.teacher).then((response) => {
  // 提示信息
  this.$message({
      type: "success",
      message: "修改成功!",
  });

  // 跳转列表页面
  this.$router.push({ path: "/vod/teacher/list" });
  });
},
```

#### 3、完善 saveOrUpdate 方法

```javascript
// 添加或修改教师
saveOrUpdate() {
  // 禁用保存按钮
  this.saveBtnDisabled = true;

  if (!this.teacher.id) {
    // 教师数据中没有 id，添加
    if (!this.teacher.name) {
      this.$message.error("请输入教师名称");
      this.saveBtnDisabled = false;
      return;
    }

    this.save();
  } else {
    // 教师数据中有 id，修改
    this.update();
  }
},
```

### 七、教师批量删除

#### 1、定义 api

**src/api/vod/teacher.js**

```javascript
import request from "@/utils/request";

const TEACHER_API = "/admin/vod/teacher";

export default {
  /**
   * 批量删除教师
   *
   * @param {Array}idList id 数组，Json 数组 [1,2,3,...]
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeBatchTeacher(idList) {
    return request({
      url: `${TEACHER_API}/remove/batch`,
      method: `delete`,
      data: idList,
    });
  },
};
```

#### 2、初始化组件

**src/views/vod/teacher/list.vue**

在 table 组件上添加 **批量删除按钮。**

```html
<!-- 工具按钮 -->
<el-card class="operate-container" shadow="never">
  <i class="el-icon-tickets" style="margin-top: 5px"></i>
  <span style="margin-top: 5px">数据列表</span>
  <el-button class="btn-add" @click="add()" style="margin-left: 10px"
    >添加</el-button
  >
  <el-button class="btn-add" @click="batchRemove()">批量删除</el-button>
</el-card>
```

**在 table 组件上添加复选框**

```html
<!-- 表格 -->
<el-table :data="list" border stripe @selection-change="handleSelectionChange">
  <el-table-column type="selection" />
  <el-table-column label="序号" width="50">
    <template slot-scope="scope">
      {{ (page - 1) * limit + scope.$index + 1 }}
    </template>
  </el-table-column>
  <el-table-column prop="name" label="名称" width="80" />
  <el-table-column label="头衔" width="90">
    <template slot-scope="scope">
      <el-tag v-if="scope.row.level === 1" type="success" size="mini"
        >高级教师</el-tag
      >
      <el-tag v-if="scope.row.level === 0" size="mini">首席教师</el-tag>
    </template>
  </el-table-column>
  <el-table-column prop="intro" label="简介" />
  <el-table-column prop="sort" label="排序" width="60" />
  <el-table-column prop="joinDate" label="入驻时间" width="160" />
  <el-table-column label="操作" width="200" align="center">
    <template slot-scope="scope">
      <el-button type="text" size="mini" @click="removeById(scope.row.id)"
        >删除</el-button
      >
      <router-link :to="'/vod/teacher/edit/' + scope.row.id">
        <el-button type="text" size="mini">修改</el-button>
      </router-link>
    </template>
  </el-table-column>
</el-table>
```

#### 3、实现功能

**data 定义数据**

```javascript
// 初始值
data() {
  return {
    // 教师列表
    list: [],
    // 总记录数
    total: 0,
    // 当前页码
    page: 1,
    // 每页记录数
    limit: 10,
    // 查询对象
    searchObj: {},
    // 批量删除选中的记录列表
    multipleSelection: [],
  };
},
```

**完善方法。**

```javascript
// 跳转到添加表单页面
add() {
  this.$router.push({ path: "/vod/teacher/create" });
},

// 复选框发生变化，调用方法，选中复选框行的内容传递
handleSelectionChange(selection) {
  this.multipleSelection = selection;
  // console.log(this.multipleSelection);
},

// 批量删除教师
batchRemove() {
  // 判断非空
  if (this.multipleSelection.length === 0) {
    this.$message.warning("请选择要删除的记录！");
    return;
  }

  this.$confirm("此操作将删除该教师信息, 是否继续?", "提示", {
    confirmButtonText: "确定",
    cancelButtonText: "取消",
    type: "warning",
  }).then(() => {
    let idList = [];

    // 遍历数组 multipleSelection
    this.multipleSelection.forEach((item) => {
      // 放到数组 idList
      idList.push(item.id);
    });

    // 调用接口批量删除
    teacherAPI.removeBatchTeacher(idList).then((response) => {
      // 提示信息
      this.$message({
        type: "success",
        message: "删除成功!",
      });
      // 刷新页面
      this.fetchData();
    });
  });
},
```

## Day 6-整合腾讯云对象存储和课程分类管理

### 一、教师管理模块整合腾讯云对象存储

#### 1、腾讯云对象存储介绍

![腾讯云对象存储介绍](https://img-blog.csdnimg.cn/279c396198f34d2bba6ef39d477dadea.png)

##### 1.1、开通“对象存储 COS”服务

（1）申请腾讯云账号：https://cloud.tencent.com/

（2）实名认证。

（3）开通“对象存储 COS”服务。

（4）进入管理控制台。

![开通“对象存储 COS”服务](https://img-blog.csdnimg.cn/c8ba94cf5b5f4867a95c04ceaaeac9c2.png)

##### 1.2、创建 Bucket

**进入管理控制台，找到存储桶列表， 创建存储桶。**

![创建 Bucket](https://img-blog.csdnimg.cn/e5967f3a9b7443ea9dc79c2d62a4d8b3.png)

**输入桶名称，选择：公有读取，其他默认。**

![创建 Bucket](https://img-blog.csdnimg.cn/c1ab3ab9d056423588443332a9ca0433.png)

**点击桶名称，进入详情页，可测试上传文件。**

![创建 Bucket](https://img-blog.csdnimg.cn/2dc383042b134296a05ac7d0999db32d.png)

##### 1.3、创建 API 秘钥

**进入 API 秘钥管理。**

![创建 API 秘钥](https://img-blog.csdnimg.cn/0811354e3c4644fa874dc289bf0cb747.png)

**新建秘钥。**

![创建 API 秘钥](https://img-blog.csdnimg.cn/20d2196bef7d4d63bc1ac380ef896955.png)

##### 1.4、快速入门

参考文档：https://cloud.tencent.com/document/product/436/10199

**引入依赖。**

```xml
<!--腾讯云对象存储（Cloud Object Storage，COS） -->
<dependency>
    <groupId>com.qcloud</groupId>
    <artifactId>cos_api</artifactId>
    <version>5.6.173</version>
</dependency>
```

**测试上传。**

```java
package com.myxh.smart.planet;

import com.alibaba.fastjson.JSON;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.apache.ibatis.javassist.LoaderClassPath;

import java.io.File;
import java.net.URI;

/**
 * @author MYXH
 * @date 2023/10/5
 */
public class TestCOS
{
    public static void main(String[] args)
    {
        // 1、初始化用户身份信息（secretId, secretKey）
        // SECRETID 和 SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        // 用户的 SecretId，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretId = "AKIDeOxIPH0VlnaBYgAQUKvIfqmUyFI7kAPS";

        // 用户的 SecretKey，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretKey = "wfFqEQPDpEQPDpEQYWHpBMNBmCRUKxVr";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        // 2、设置 bucket 的地域, COS 地域的简称请参见 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分
        Region region = new Region("ap-beijing");
        ClientConfig clientConfig = new ClientConfig(region);

        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);

        // 3、生成 cos 客户端
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 4、测试上传
        try
        {
            // 指定要上传的文件
            URI uri = LoaderClassPath.class.getResource("/image/大户爱.png").toURI();
            File localFile = new File(uri);

            // 指定文件将要存放的存储桶
            String bucketName = "smart-planet-1315007088";

            // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
            String key = "TestCOS/image/大户爱.png";
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

            System.out.println(JSON.toJSONString(putObjectResult));
        } catch (Exception clientException)
        {
            clientException.printStackTrace();
        }
    }
}
```

#### 2、整合腾讯云对象存储

##### 2.1、service-vod 模块引入依赖

```xml
<!--腾讯云对象存储（Cloud Object Storage，COS） -->
<dependency>
    <groupId>com.qcloud</groupId>
    <artifactId>cos_api</artifactId>
    <version>5.6.173</version>
</dependency>

<!-- 日期时间工具 -->
<dependency>
    <groupId>joda-time</groupId>
    <artifactId>joda-time</artifactId>
</dependency>
```

##### 2.2、配置 application.properties

添加如下内容：

```properties
# 设置上传文件的大小
spring.servlet.multipart.max-file-size=1024MB
spring.servlet.multipart.max-request-size=1024MB

# 设置初始化用户身份信息
tencent.cos.file.secretid=AKIDeOxIPH0VlnaBYgAQUKvIfqmUyFI7kAPS
tencent.cos.file.secretkey=wfFqEQPDpEQPDpEQYWHpBMNBmCRUKxVr

# 设置 bucket 的地域
tencent.cos.file.region=ap-beijing

# 设置指定文件将要存放的存储桶
tencent.cos.file.bucketname=smart-planet-1315007088
```

##### 3.3、创建工具类

```java
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
    @Value("${tencent.cos.file.secretid}")
    private String secretId;

    @Value("${tencent.cos.file.secretkey}")
    private String secretKey;

    @Value("${tencent.cos.file.region}")
    private String region;

    @Value("${tencent.cos.file.bucketname}")
    private String bucketName;

    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String END_POINT;
    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception
    {
        ACCESS_KEY_ID = secretId;
        END_POINT = region;
        ACCESS_KEY_SECRET = secretKey;
        BUCKET_NAME = bucketName;
    }
}
```

##### 3.4、创建 Service

**创建 Interface：FileService.java。**

```java
package com.myxh.smart.planet.vod.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author MYXH
 * @date 2023/10/5
 */
public interface FileService
{
    /**
     * 上传文件
     *
     * @param file 文件
     * @return url 文件地址
     */
    String upload(MultipartFile file);
}
```

**实现：FileServiceImpl.java。**

![创建 Service](https://img-blog.csdnimg.cn/64fb9947307d4fb6b3869d4108c55834.png)

```java
package com.myxh.smart.planet.vod.service.impl;

import com.myxh.smart.planet.vod.service.FileService;
import com.myxh.smart.planet.vod.utils.ConstantPropertiesUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author MYXH
 * @date 2023/10/5
 */
@Service
public class FileServiceImpl implements FileService
{
    /**
     * 上传文件
     *
     * @param file 文件
     * @return url 文件地址
     */
    @Override
    public String upload(MultipartFile file)
    {
        // 1、初始化用户身份信息（secretId, secretKey）
        // SECRETID 和 SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        // 用户的 SecretId，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretId = ConstantPropertiesUtil.ACCESS_KEY_ID;

        // 用户的 SecretKey，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretKey = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        // 2、设置 bucket 的地域, COS 地域的简称请参见 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分
        Region region = new Region(ConstantPropertiesUtil.END_POINT);
        ClientConfig clientConfig = new ClientConfig(region);

        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);

        // 3、生成 cos 客户端
        COSClient cosClient = new COSClient(cred, clientConfig);

        try
        {
            // 4、上传文件
            // 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
            String bucketName = ConstantPropertiesUtil.BUCKET_NAME;

            // 对象键(Key)是对象在存储桶中的唯一标识
            // 在文件名称前面添加 uuid 值
            String key = UUID.randomUUID().toString().replaceAll("-", "")
                    + file.getOriginalFilename();

            // 在文件名称前面添加日期时间格式文件夹
            String dateTime = new DateTime().toString("yyyy/MM/dd");
            key = "ProductionCOS/image/" + dateTime + "/" + key;

            System.out.println("key = " + key);

            // 获取上传文件的输入流
            InputStream inputStream = file.getInputStream();

            ObjectMetadata objectMetadata = new ObjectMetadata();

            // 指定文件上传到 COS 上的路径，即对象键
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, objectMetadata);

            // 执行文件上传
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

            // 返回上传文件路径
            String url = "https://" + bucketName + "." + "cos" + "." + ConstantPropertiesUtil.END_POINT + ".myqcloud.com" + "/" + key;

            return url;

        } catch (CosClientException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return null;
    }
}
```

##### 3.5、创建 Controller

FileUploadController.java

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author MYXH
 * @date 2023/10/5
 */
@Tag(name = "文件接口", description = "文件上传接口")
@RestController
@RequestMapping("/admin/vod/file")
@CrossOrigin
public class FileUploadController
{
    @Autowired
    private FileService fileService;

    /**
     * 上传文件
     *
     * @param file 文件
     * @return url 文件地址
     */
    @Operation(summary = "上传", description = "上传文件")
    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file)
    {
        String url = fileService.upload(file);

        return Result.ok(url).message("上传文件成功");
    }
}
```

#### 3、添加教师前端完善

##### 3.1、添加上传组件

**操作 teacher 目录下的 form.vue 页面。**

```html
<!-- 教师头像 -->
<el-form-item label="教师头像">
  <el-upload
    :show-file-list="false"
    :on-success="handleAvatarSuccess"
    :before-upload="beforeAvatarUpload"
    :on-error="handleAvatarError"
    :action="BASE_API + '/admin/vod/file/upload'"
    class="avatar-uploader"
  >
    <img
      v-if="teacher.avatar"
      :src="teacher.avatar"
      style="width: 200px; height: auto"
    />
    <i v-else class="el-icon-plus avatar-uploader-icon" />
  </el-upload>
</el-form-item>
```

##### 3.2、添加上传方法

**初始化访问路径。**

```javascript
data() {
  return {
    teacher: {
      // 初始化教师默认数据
      sort: 0,
      level: 1,
    },

    BASE_API: "http://localhost:8301",
  };
},
```

**添加上传操作方法。**

```javascript
// 上传成功回调
handleAvatarSuccess(response, file) {
  if (response.code == 20000) {
    // console.log(response);
    this.teacher.avatar = response.data;
    // 强制重新渲染
    this.$forceUpdate();
  } else {
    this.$message.error("上传失败");
  }
},

// 上传校验
beforeAvatarUpload(file) {
  const isJPG = file.type === "image/jpeg";
  const isPNG = file.type === "image/png";
  const isLt2M = file.size / 1024 / 1024 < 2;

  if (!isJPG && !isPNG) {
    this.$message.error("上传头像图片只能是 JPG 或 PNG 格式!");
  }
  if (!isLt2M) {
    this.$message.error("上传头像图片大小不能超过 2MB!");
  }

  return (isJPG || isPNG) && isLt2M;
},

// 错误处理
handleAvatarError() {
  console.log("error");
  this.$message.error("上传失败（http 失败）");
},
```

##### 3.3 添加显示头像组件

**操作 teacher 目录下的 list.vue 页面。**

```html
<el-table-column label="头像" width="80">
  <template slot-scope="scope">
    <img
      v-if="scope.row.avatar"
      :src="scope.row.avatar"
      style="
              width: 50px;
              height: 50px;
              border-radius: 50%;
              object-fit: cover;
            "
    />
  </template>
</el-table-column>
```

##### 3.4 设置 referrer，正常显示图片

**在 teacher 目录下的 list.vue 和 form.vue 页面，设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示部分使用了外链存储的图片，达到节省 Bucket 存储桶服务器流量的目的。**

```html
<head>
  <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
  <meta name="referrer" content="no-referrer" />
</head>
```

### 二、后台管理系统-课程分类管理模块

#### 1、课程分类管理模块需求

**（1）课程分类列表功能。**

![课程分类列表功能](https://img-blog.csdnimg.cn/21492e881ec245e896f7df47b9f5f5ad.png)

**（2）课程分类导入功能。**

![课程分类导入功能](https://img-blog.csdnimg.cn/b4fb91ea70de43dfb038c574da930b1c.png)

**（3）课程分类导出功能。**

![课程分类导出功能](https://img-blog.csdnimg.cn/f4f96f93c22a437a8e4fab9b208a720f.png)

#### 2、课程分类数据库设计

**（1）创建课程分类表 subject。**

![创建课程分类表 subject](https://img-blog.csdnimg.cn/99656a0a99f34421bae3b38ef903907f.png)

**（2）课程分类表结构分析**

![课程分类表结构分析](https://img-blog.csdnimg.cn/11fb5a30e1644e489939f3d40971640c.png)

#### 3、功能实现-课程分类列表

##### 3.1、接口实现分析

课程分类采用树形展示，使用“树形数据与懒加载”的方式展现数据列表，因此需要提供的接口如下：根据上级 id 获取下级数据，参考 element-ui 文档：https://element.eleme.cn/#/zh-CN/component/table ，页面搜索：树形数据与懒加载。

![接口实现分析](https://img-blog.csdnimg.cn/419aff52e9be4c34aaa53c07a10af5fb.png)

![接口实现分析](https://img-blog.csdnimg.cn/95d0de9d199a42e48bd3dacee87c0776.png)

##### 3.2、编写 SubjectController

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Subject;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.SubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/6
 *
 * <p>
 * 课程科目 前端控制器
 * </p>
 */
@Tag(name = "课程分类接口", description = "课程分类管理接口")
@RestController
@RequestMapping(value = "/admin/vod/subject")
@CrossOrigin
public class SubjectController
{
    @Autowired
    private SubjectService subjectService;

    /**
     * 查询下一层的课程分类列表
     * 根据 parent_id，懒加载，每次查询一层数据
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询课程分类", description = "查询下一层的课程分类")
    @GetMapping("get/child/subject/{id}")
    public Result<List<Subject>> getChildSubject(@Parameter(name = "id", description = "ID", required = true)
                                                 @PathVariable("id") Long id)
    {
        List<Subject> list = subjectService.selectSubjectList(id);

        return Result.ok(list);
    }
}
```

##### 3.3、编写 SubjectService

```java
package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.Subject;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/6
 *
 * <p>
 * 课程科目 服务类
 * </p>
 */
public interface SubjectService extends IService<Subject>
{
    /**
     * 查询下一层的课程分类列表
     * 根据 parent_id，懒加载，每次查询一层数据
     *
     * @param id id
     * @return subjectList 下一层的课程分类列表
     */
    List<Subject> selectSubjectList(Long id);
}
```

##### 3.4、编写 SubjectServiceImpl

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Subject;
import com.myxh.smart.planet.vod.mapper.SubjectMapper;
import com.myxh.smart.planet.vod.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/6
 *
 * <p>
 * 课程科目 服务实现类
 * </p>
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService
{
    /**
     * 查询下一层的课程分类列表
     * 根据 parent_id，懒加载，每次查询一层数据
     *
     * @param id id
     * @return subjectList 下一层的课程分类列表
     */
    @Override
    public List<Subject> selectSubjectList(Long id)
    {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        List<Subject> subjectList = baseMapper.selectList(wrapper);

        // 遍历 subjectList，得到每个 Subject 对象，判断是否有下一层数据，如果有，则向 subjectList 集合每个 Subject 对象中设置 hasChildren
        for (Subject subject : subjectList)
        {
            // 获取 subject 的 id 值
            Long subjectId = subject.getId();

            // 查询
            boolean isChild = this.isChildren(subjectId);

            // 封装到对象里面
            subject.setHasChildren(isChild);
        }

        return subjectList;
    }

    /**
     * 判断 id 下面是否有子节点
     *
     * @param subjectId 课程 id
     * @return isChild 是否有子节点
     */
    private boolean isChildren(Long subjectId)
    {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", subjectId);
        Long count = baseMapper.selectCount(wrapper);

        return count > 0;
    }
}
```

##### 3.5、开发课程分类列表前端

**（1）添加数据字典路由。**

修改 router/index.js 文件。

```javascript
// 课程分类管理
{
  path: "/subject",
  component: Layout,
  redirect: "/subject/list",
  name: "课程分类管理",
  meta: { title: "课程分类管理", icon: "example" },
  alwaysShow: true,
  children: [
    {
      path: "list",
      name: "课程分类列表",
      component: () => import("@/views/vod/subject/list"),
      meta: { title: "课程分类列表", icon: "table" },
    },
  ],
},
```

**（2）定义数据字典列表接口。**

**创建文件 src/api/vod/subject.js。**

```javascript
import request from "@/utils/request";

const SUBJECT_API = "/admin/vod/subject";

export default {
  /**
   * 课程分类列表
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getChildList(id) {
    return request({
      url: `${SUBJECT_API}/get/child/subject/${id}`,
      method: "get",
    });
  },
};
```

**（3）编写 subject/list.vue。**

```html
<template>
  <div class="app-container">
    <el-table
      :data="list"
      style="width: 100%"
      row-key="id"
      border
      lazy
      :load="load"
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
    >
      <el-table-column prop="title" label="名称" width="150"></el-table-column>
      <el-table-column prop="createTime" label="创建时间"></el-table-column>
    </el-table>
  </div>
</template>

<script>
  import subjectAPI from "@/api/vod/subject";

  export default {
    data() {
      return {
        // 课程分类列表数组
        list: [],
      };
    },

    created() {
      this.getSubList(0);
    },

    methods: {
      // 课程分类列表
      getSubList(id) {
        subjectAPI.getChildList(id).then((response) => {
          this.list = response.data;
        });
      },

      // 下一层的课程分类列表
      load(tree, treeNode, resolve) {
        subjectAPI.getChildList(tree.id).then((response) => {
          resolve(response.data);
        });
      },
    },
  };
</script>
```

#### 4、技术点-EasyExcel

##### 4.1、EasyExcel 介绍

EasyExcel 是阿里巴巴开源的一个 excel 处理框架，**以使用简单、节省内存著称**。EasyExcel 能大大减少占用内存的主要原因是在解析 Excel 时没有将文件数据一次性全部加载到内存中，而是从磁盘上一行行读取数据，逐个解析。

##### 4.2、EasyExcel 特点

- Java 领域解析、生成 Excel 比较有名的框架有 Apache poi、jxl 等。但他们都存在一个严重的问题就是非常的耗内存。如果系统并发量不大的话可能还行，但是一旦并发上来后一定会 OOM 或者 JVM 频繁的 Full GC。

- **EasyExcel 采用一行一行的解析模式**，并将一行的解析结果以观察者的模式通知处理（AnalysisEventListener）。

- EasyExcel 是一个基于 Java 的简单、省内存的读写 Excel 的开源项目。在尽可能节约内存的情况下支持读写百 MB 的 Excel。

##### 4.3、EasyExcel 写操作

**（1）pom 中引入 xml 相关依赖。**

```xml
<!-- easyexcel -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>easyexcel</artifactId>
</dependency>
```

**（2）创建实体类。**

**设置表头和添加的数据字段。**

```java
package com.myxh.smart.planet.excel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/10/6
 */
@Data
public class User
{
    // 设置表头名称
    @ExcelProperty("用户编号")
    private Integer id;

    // 设置表头名称
    @ExcelProperty("用户姓名")
    private String name;
}
```

**（3）实现写操作。**

**创建方法循环设置要添加到 Excel 的数据。**

```java
package com.myxh.smart.planet.excel;

import com.myxh.smart.planet.excel.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/6
 */
public class TestWrite
{
    /**
     * 循环设置要添加的数据，最终封装到list集合中
     *
     * @return list 用户表格
     */
    private static List<User> data()
    {
        List<User> list = new ArrayList<User>();

        for (int i = 1; i <= 10; i++)
        {
            User data = new User();
            data.setId(i);
            data.setName("MYXH" + i);
            list.add(data);
        }

        return list;
    }
}
```

**实现最终的添加操作。**

```java
package com.myxh.smart.planet.excel;

import com.alibaba.excel.EasyExcel;
import com.myxh.smart.planet.excel.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/6
 */
public class TestWrite
{
    public static void main(String[] args)
    {
        // 设置文件名称和路径
        String fileName = "service\\service-vod\\src\\test\\resources\\excel\\用户.xlsx";

        // 调用方法
        EasyExcel.write(fileName, User.class)
                .sheet("写操作")
                .doWrite(data());
    }

    /**
     * 循环设置要添加的数据，最终封装到list集合中
     *
     * @return list 用户表格
     */
    private static List<User> data()
    {
        List<User> list = new ArrayList<User>();

        for (int i = 1; i <= 10; i++)
        {
            User data = new User();
            data.setId(i);
            data.setName("MYXH" + i);
            list.add(data);
        }

        return list;
    }
}
```

##### 4.4、EasyExcel 读操作

**（1）创建实体类。**

```java
package com.myxh.smart.planet.excel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/10/6
 */
@Data
public class User
{
    // 设置表头名称
    @ExcelProperty(value = "用户编号", index = 0)
    private Integer id;

    // 设置表头名称
    @ExcelProperty(value = "用户姓名", index = 1)
    private String name;
}
```

**（2）创建读取操作的监听器。**

```java
package com.myxh.smart.planet.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.myxh.smart.planet.excel.entity.User;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/6
 */
public class ExcelListener extends AnalysisEventListener<User>
{


    /**
     * 一行一行读取 excel 内容，把每行内容封装到 User 对象
     * 从 excel 第二行开始读取
     *
     * @param data            one row value. It is same as {@link AnalysisContext#readRowHolder()} 一行值。与 ｛@link AnalysisContext#readRowHolder()｝ 相同
     * @param analysisContext analysis context 分析上下文
     */
    @Override
    public void invoke(User data, AnalysisContext analysisContext)
    {
        System.out.println(data);
    }

    /**
     * 读取表头内容
     *
     * @param headMap 表头信息
     * @param context 上下文
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context)
    {
        System.out.println("表头信息：" + headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext)
    {

    }
}
```

**（3）调用实现最终的读取。**

```java
package com.myxh.smart.planet.excel;

import com.alibaba.excel.EasyExcel;
import com.myxh.smart.planet.excel.entity.User;

/**
 * @author MYXH
 * @date 2023/10/6
 */
public class TestRead
{
    public static void main(String[] args)
    {
        // 设置文件名称和路径
        String fileName = "service\\service-vod\\src\\test\\resources\\excel\\用户.xlsx";

        // 调用方法进行读操作
        EasyExcel.read(fileName, User.class, new ExcelListener()).sheet().doRead();
    }
}
```

#### 5、功能实现-课程分类导出

##### 5.1、查看 model 实体类

**在 model 模块查看实体：com.myxh.smart.planet.vo.vod.SubjectEeVo。**

```java
package com.myxh.smart.planet.vo.vod;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author MYXH
 * @date 2023/9/27
 */
@Data
public class SubjectEeVo
{
    @ExcelProperty(value = "ID", index = 0)
    private Long id;

    @ExcelProperty(value = "课程分类名称", index = 1)
    private String title;

    @ExcelProperty(value = "上级ID", index = 2)
    private Long parentId;

    @ExcelProperty(value = "排序", index = 3)
    private Integer sort;
}
```

##### 5.2、编写 SubjectService 和实现

**SubjectService**

```java
package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.Subject;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author MYXH
 * @date 2023/10/6
 *
 * <p>
 * 课程科目 服务类
 * </p>
 */
public interface SubjectService extends IService<Subject>
{
    /**
     * 课程分类导出为 Excel
     *
     * @param response 响应
     */
    void exportData(HttpServletResponse response);

    /**
     * 从 Excel 导入课程分类
     *
     * @param file 文件
     */
    void importData(MultipartFile file);
}
```

**SubjectServiceImpl**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.model.vod.Subject;
import com.myxh.smart.planet.vo.vod.SubjectEeVo;
import com.myxh.smart.planet.vod.mapper.SubjectMapper;
import com.myxh.smart.planet.vod.service.SubjectService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/6
 *
 * <p>
 * 课程科目 服务实现类
 * </p>
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService
{
    /**
     * 课程分类导出为 Excel
     *
     * @param response 响应
     */
    @Override
    public void exportData(HttpServletResponse response)
    {

        try
        {
            // 设置下载信息
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");

            // 这里 URLEncoder.encode 可以防止中文乱码，当然和 easyexcel 没有关系
            String fileName = URLEncoder.encode("课程分类", StandardCharsets.UTF_8);

            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

            // 查询课程分类表所有数据
            List<Subject> subjectList = baseMapper.selectList(null);

            // List<Subject> 转换为 List<SubjectEeVo>
            List<SubjectEeVo> subjectEeVoList = new ArrayList<>();

            for (Subject subject : subjectList)
            {
                SubjectEeVo subjectEeVo = new SubjectEeVo();
                // subjectEeVo.setId(subject.getId());
                // subjectEeVo.setParentId(subject.getParentId());
                BeanUtils.copyProperties(subject, subjectEeVo);
                subjectEeVoList.add(subjectEeVo);
            }

            // EasyExcel 写操作
            EasyExcel.write(response.getOutputStream(), SubjectEeVo.class)
                    .sheet("课程分类")
                    .doWrite(subjectEeVoList);
        }
        catch (IOException e)
        {
            throw new SmartPlanetException(20001, "导出失败");
        }
    }
}
```

##### 5.3、添加 Controller 方法

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.vod.service.SubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/6
 *
 * <p>
 * 课程科目 前端控制器
 * </p>
 */
@Tag(name = "课程分类接口", description = "课程分类管理接口")
@RestController
@RequestMapping(value = "/admin/vod/subject")
@CrossOrigin
public class SubjectController
{
    @Autowired
    private SubjectService subjectService;

    /**
     * 课程分类导出为 Excel
     *
     * @param response 响应
     */
    @Operation(summary = "课程分类导出", description = "课程分类导出为 Excel")
    @GetMapping("export/data")
    public void exportData(HttpServletResponse response)
    {
        subjectService.exportData(response);
    }
}
```

##### 5.4、数据字典导出前端

**（1）list.vue 页面添加导出按钮。**

```html
<div
  class="el-toolbar"
  style="display: flex; justify-content: center; align-items: center"
>
  <div
    class="el-toolbar-body"
    style="justify-content: flex-start; margin-top: 20px"
  >
    <el-button type="primary" @click="exportData">
      <i class="fa fa-plus" /> 导出
    </el-button>
  </div>
</div>
```

**（2）编写调用方法。**

```javascript
data() {
  return {
    // 课程分类列表数组
    list: [],

    BASE_API: "http://localhost:8301",

    SUBJECT_API: "admin/vod/subject",
  };
},

methods: {
  // 课程分类导出为 Excel
  exportData() {
    window.open(`${this.BASE_API}/${this.SUBJECT_API}/export/data`);
  },
},
```

#### 6、功能实现-课程分类导入

##### 6.1、创建读取监听器

```java
package com.myxh.smart.planet.vod.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.myxh.smart.planet.vo.vod.SubjectEeVo;
import com.myxh.smart.planet.vod.mapper.SubjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.myxh.smart.planet.model.vod.Subject;

/**
 * @author MYXH
 * @date 2023/10/6
 */
@Component
public class SubjectListener extends AnalysisEventListener<SubjectEeVo>
{
    // 注入 subjectMapper
    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * 一行一行读取 excel 内容，把每行内容封装到 User 对象
     * 从 excel 第二行开始读取
     *
     * @param subjectEeVo     one row value. It is same as {@link AnalysisContext#readRowHolder()} 一行值。与 ｛@link AnalysisContext#readRowHolder()｝ 相同
     * @param analysisContext analysis context 分析上下文
     */
    @Override
    public void invoke(SubjectEeVo subjectEeVo, AnalysisContext analysisContext)
    {
        //  SubjectEeVo 转换为 Subject
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectEeVo, subject);

        // 添加 subject
        subjectMapper.insert(subject);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext)
    {

    }
}
```

##### 6.2、添加 controller 方法

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.SubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author MYXH
 * @date 2023/10/6
 *
 * <p>
 * 课程科目 前端控制器
 * </p>
 */
@Tag(name = "课程分类接口", description = "课程分类管理接口")
@RestController
@RequestMapping(value = "/admin/vod/subject")
@CrossOrigin
public class SubjectController
{
    @Autowired
    private SubjectService subjectService;

    /**
     * 从 Excel 导入课程分类
     *
     * @param file 文件
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "课程分类导入", description = "从 Excel 导入课程分类")
    @PostMapping(value = "import/data", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<Void> importData(@RequestParam("file") MultipartFile file)
    {
        subjectService.importData(file);

        return Result.ok(null);
    }
}
```

##### 6.3、添加 service 方法

```java
package com.myxh.smart.planet.vod.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.model.vod.Subject;
import com.myxh.smart.planet.vo.vod.SubjectEeVo;
import com.myxh.smart.planet.vod.listener.SubjectListener;
import com.myxh.smart.planet.vod.mapper.SubjectMapper;
import com.myxh.smart.planet.vod.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author MYXH
 * @date 2023/10/6
 *
 * <p>
 * 课程科目 服务实现类
 * </p>
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService
{
    @Autowired
    private SubjectListener subjectListener;

    /**
     * 从 Excel 导入课程分类
     *
     * @param file 文件
     */
    @Override
    public void importData(MultipartFile file)
    {
        try
        {
            EasyExcel.read(file.getInputStream(),
                    SubjectEeVo.class,
                    subjectListener).sheet().doRead();
        }
        catch (IOException e)
        {
            throw new SmartPlanetException(20001, "导入失败");
        }
    }
}
```

##### 6.4、数据字典导入前端

**（1）在 list.vue 页面添加导入按钮。**

```html
<div
  class="el-toolbar"
  style="display: flex; justify-content: center; align-items: center"
>
  <div
    class="el-toolbar-body"
    style="justify-content: flex-start; margin-top: 20px"
  >
    <el-button type="primary" @click="exportData">
      <i class="fa fa-plus" /> 导出
    </el-button>
    <el-button type="primary" @click="importData">
      <i class="fa fa-plus" /> 导入
    </el-button>
  </div>
</div>
```

**（2）添加导入弹出层**

```html
<el-dialog title="导入" :visible.sync="dialogImportVisible" width="480px">
  <el-form label-position="right" label-width="170px">
    <el-form-item label="文件">
      <el-upload
        :multiple="false"
        :on-success="onUploadSuccess"
        :action="BASE_API + '/' + SUBJECT_API + '/import/data'"
        class="upload-demo"
      >
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">
          只能上传 xlsx 文件，且不超过 500KB
        </div>
      </el-upload>
    </el-form-item>
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="dialogImportVisible = false">取消</el-button>
  </div>
</el-dialog>
```

**（3）添加导入弹出层属性**

```javascript
data() {
  return {
    // 课程分类列表数组
    list: [],

    dialogImportVisible: false,

    BASE_API: "http://localhost:8301",

    SUBJECT_API: "admin/vod/subject",
  };
},
```

**（4）添加导入方法**

```javascript
methods: {
  // 从 Excel 导入课程分类
  importData() {
    this.dialogImportVisible = true;
  },

  onUploadSuccess(response, file) {
    this.$message.info("上传成功");
    this.dialogImportVisible = false;
    this.getSubList(0);
  },
},
```

## Day 7-点播管理模块（一）

### 一、后台管理系统-点播管理模块

#### 1、点播管理模块需求

**添加点播课程，包含课程基本信息，课程章节，课程小结和最终发布。**

![点播管理模块需求](https://img-blog.csdnimg.cn/96d98f1ebfe14c2a9cf30cced3764c92.png)

##### 1.1、创建课程相关表

![创建课程相关表](https://img-blog.csdnimg.cn/3b8d933afeb349d297e1ae9b99c07ce8.png)

#### 2、环境搭建

##### 2.1、生成相关代码

![生成相关代码](https://img-blog.csdnimg.cn/29af3816b1e1475888a029a0c2ee77d5.png)

#### 3、功能实现-课程列表

**实现分页条件查询点播课程功能。**

![功能实现-课程列表](https://img-blog.csdnimg.cn/86e88d564e334468bb7140b1c642ccbb.png)

##### 3.1、开发课程列表接口

**编写 CourseController。**

```java
package com.myxh.smart.planet.vod.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.CourseQueryVo;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 前端控制器
 * </p>
 */
@Tag(name = "课程接口", description = "课程管理接口")
@RestController
@RequestMapping("/admin/vod/course")
@CrossOrigin
public class CourseController
{
    @Autowired
    private CourseService courseService;

    /**
     * 点播课程列表
     *
     * @param current       当前页码
     * @param limit         每页记录数
     * @param courseQueryVo 查询对象
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取点播课程", description = "获取点播课程列表")
    @GetMapping("find/query/page/{current}/{limit}")
    public Result<Map<String, Object>> courseList(@Parameter(name = "current", description = "当前页码", required = true) @PathVariable("current") Long current,
                                                  @Parameter(name = "limit", description = "每页记录数", required = true) @PathVariable("limit") Long limit,
                                                  @Parameter(name = "courseQueryVo", description = "查询对象") CourseQueryVo courseQueryVo)
    {
        Page<Course> coursePageParam = new Page<>(current, limit);
        Map<String, Object> coursePage = courseService.findPage(coursePageParam, courseQueryVo);

        return Result.ok(coursePage);
    }
}
```

**编写 CourseService。**

```java
package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vo.vod.CourseQueryVo;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务类
 * </p>
 */
public interface CourseService extends IService<Course>
{

    /**
     * 点播课程列表
     *
     * @param coursePageParam 课程页面参数
     * @param courseQueryVo   查询对象
     * @return coursePage 课程页面
     */
    Map<String, Object> findPage(Page<Course> coursePageParam, CourseQueryVo courseQueryVo);
}
```

**编写 CourseServiceImpl。**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.model.vod.Subject;
import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.vo.vod.CourseQueryVo;
import com.myxh.smart.planet.vod.mapper.CourseMapper;
import com.myxh.smart.planet.vod.service.CourseService;
import com.myxh.smart.planet.vod.service.SubjectService;
import com.myxh.smart.planet.vod.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务实现类
 * </p>
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService
{
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TeacherService teacherService;

    /**
     * 点播课程列表
     *
     * @param coursePageParam 课程页面参数
     * @param courseQueryVo   查询对象
     * @return coursePage 课程页面
     */
    @Override
    public Map<String, Object> findPage(Page<Course> coursePageParam, CourseQueryVo courseQueryVo)
    {
        // 获取条件值
        // 名称
        String title = courseQueryVo.getTitle();

        // 二级分类
        Long subjectId = courseQueryVo.getSubjectId();

        // 一级分类
        Long subjectParentId = courseQueryVo.getSubjectParentId();

        // 教师
        Long teacherId = courseQueryVo.getTeacherId();

        // 封装条件
        QueryWrapper<Course> wrapper = new QueryWrapper<>();

        if (StringUtils.hasLength(title))
        {
            wrapper.like("title", title);
        }
        if (!ObjectUtils.isEmpty(subjectId))
        {
            wrapper.eq("subject_id", subjectId);
        }
        if (!ObjectUtils.isEmpty(subjectParentId))
        {
            wrapper.eq("subject_parent_id", subjectParentId);
        }
        if (!ObjectUtils.isEmpty(teacherId))
        {
            wrapper.eq("teacher_id", teacherId);
        }

        // 调用方法实现条件查询分页
        Page<Course> coursePage = baseMapper.selectPage(coursePageParam, wrapper);

        // 总记录数
        Long totalCount = coursePage.getTotal();

        // 总页数
        Long totalPage = coursePage.getPages();

        // 每页数据集合
        List<Course> coursePageRecords = coursePage.getRecords();

        // 遍历封装教师和分类名称，获取 id 对应名称，进行封装，最终显示
        coursePageRecords.stream().forEach(this::getTeacherOrSubjectName);

        // 封装返回数据
        Map<String, Object> coursePageMap = new HashMap<>();
        coursePageMap.put("totalCount", totalCount);
        coursePageMap.put("totalPage", totalPage);
        coursePageMap.put("records", coursePageRecords);

        return coursePageMap;
    }

    /**
     * 获取教师和分类名称
     *
     * @param course 课程数据
     * @return course 课程数据
     */
    private Course getTeacherOrSubjectName(Course course)
    {
        // 根据教师 id 获取教师名称
        Teacher teacher = teacherService.getById(course.getTeacherId());

        if (teacher != null)
        {
            course.getParam().put("teacherName", teacher.getName());
        }

        // 根据课程分类 id 获取课程分类名称
        Subject subjectOne = subjectService.getById(course.getSubjectParentId());

        if (subjectOne != null)
        {
            course.getParam().put("subjectParentTitle", subjectOne.getTitle());
        }

        Subject subjectTwo = subjectService.getById(course.getSubjectId());

        if (subjectTwo != null)
        {
            course.getParam().put("subjectTitle", subjectTwo.getTitle());
        }

        return course;
    }
}
```

##### 3.2、开发课程列表前端

**（1）src 目录下 index.js 文件添加路由。**

```javascript
// 课程管理
{
  path: "/vod/course",
  component: Layout,
  redirect: "/vod/course/list",
  name: "vodCourse",
  meta: {
    title: "点播管理",
    icon: "el-icon-bank-card",
  },
  alwaysShow: true,
  children: [
    {
      path: "course/list",
      name: "CourseList",
      component: () => import("@/views/vod/course/list"),
      meta: { title: "课程列表", icon: "table" },
    },
    {
      path: "course/info",
      name: "CourseInfo",
      component: () => import("@/views/vod/course/form"),
      meta: { title: "发布课程", icon: "table" },
    },
    {
      path: "course/info/:id",
      name: "CourseInfoEdit",
      component: () => import("@/views/vod/course/form"),
      meta: { title: "编辑课程", icon: "table" },
      hidden: true,
    },
    {
      path: "course/chapter/:id",
      name: "CourseChapterEdit",
      component: () => import("@/views/vod/course/form"),
      meta: { title: "编辑大纲", icon: "table" },
      hidden: true,
    },
    {
      path: "course/chart/:id",
      name: "CourseChart",
      component: () => import("@/views/vod/course/chart"),
      meta: { title: "课程统计", icon: "table" },
      hidden: true,
    },
  ],
},
```

**（2）创建 vue 页面。**

![创建 vue 页面](https://img-blog.csdnimg.cn/365890884b054c499ee939fb2a9d7252.png)

**（3）在 api 目录创建 course.js 文件。**

```javascript
import request from "@/utils/request";

const COURSE_API = "/admin/vod/course";

export default {
  /**
   * 点播课程列表
   *
   * @param {number} current 当前页码
   * @param {number} limit 每页记录数
   * @param {Object} courseQueryVo 查询对象
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPageList(current, limit, courseQueryVo) {
    return request({
      url: `${COURSE_API}/find/query/page/${current}/${limit}`,
      method: "get",
      params: courseQueryVo,
    });
  },
};
```

**（4）在 api 目录 teacher.js 文件定义接口。**

```javascript
import request from "@/utils/request";

const TEACHER_API = "/admin/vod/teacher";

export default {
  /**
   * 查询所有教师
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  list() {
    return request({
      url: `${TEACHER_API}/find/all`,
      method: `get`,
    });
  },
};
```

**（5）编写 list.vue 页面。**

```html
<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <!-- 查询表单 -->
    <el-card class="operate-container" shadow="never">
      <el-form :inline="true" class="demo-form-inline">
        <!-- 所属分类：级联下拉列表 -->
        <!-- 一级分类 -->
        <el-form-item label="课程类别">
          <el-select
            v-model="searchObj.subjectParentId"
            placeholder="请选择"
            @change="subjectLevelOneChanged"
          >
            <el-option
              v-for="subject in subjectList"
              :key="subject.id"
              :label="subject.title"
              :value="subject.id"
            />
          </el-select>

          <!-- 二级分类 -->
          <el-select v-model="searchObj.subjectId" placeholder="请选择">
            <el-option
              v-for="subject in subjectLevelTwoList"
              :key="subject.id"
              :label="subject.title"
              :value="subject.id"
            />
          </el-select>
        </el-form-item>

        <!-- 标题 -->
        <el-form-item label="标题">
          <el-input v-model="searchObj.title" placeholder="课程标题" />
        </el-form-item>

        <!-- 教师 -->
        <el-form-item label="教师">
          <el-select v-model="searchObj.teacherId" placeholder="请选择教师">
            <el-option
              v-for="teacher in teacherList"
              :key="teacher.id"
              :label="teacher.name"
              :value="teacher.id"
            />
          </el-select>
        </el-form-item>

        <el-button type="primary" icon="el-icon-search" @click="fetchData()"
          >查询</el-button
        >
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form>
    </el-card>

    <!-- 工具按钮 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" @click="add()">添加</el-button>
    </el-card>

    <!-- 表格 -->
    <el-table :data="list" border stripe>
      <el-table-column label="序号" width="50">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column label="封面" width="200" align="center">
        <template slot-scope="scope">
          <img :src="scope.row.cover" alt="scope.row.title" width="100%" />
        </template>
      </el-table-column>
      <el-table-column label="课程信息">
        <template slot-scope="scope">
          <a href="">{{ scope.row.title }}</a>
          <p>
            分类：{{ scope.row.param.subjectParentTitle }} {{
            scope.row.param.subjectTitle }}
          </p>
          <p>
            课时：{{ scope.row.lessonNum }} / 浏览：{{ scope.row.viewCount }} /
            付费学员：{{ scope.row.buyCount }}
          </p>
        </template>
      </el-table-column>
      <el-table-column label="教师" width="100" align="center">
        <template slot-scope="scope">
          {{ scope.row.param.teacherName }}
        </template>
      </el-table-column>
      <el-table-column label="价格(元)" width="100" align="center">
        <template slot-scope="scope">
          <el-tag v-if="Number(scope.row.price) === 0" type="success"
            >免费</el-tag
          >
          <!-- 前端解决保留两位小数的问题 -->
          <!-- <el-tag v-else>{{ Number(scope.row.price).toFixed(2) }}</el-tag> -->

          <!-- 后端解决保留两位小数的问题，前端不用处理 -->
          <el-tag v-else>{{ scope.row.price }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="status"
        label="课程状态"
        width="100"
        align="center"
      >
        <template slot-scope="scope">
          <el-tag :type="scope.row.status === 0 ? 'warning' : 'success'"
            >{{ scope.row.status === 0 ? "未发布" : "已发布" }}</el-tag
          >
        </template>
      </el-table-column>
      <el-table-column label="发布时间" width="140" align="center">
        <template slot-scope="scope">
          {{ scope.row.createTime ? scope.row.createTime.substr(0, 16) : "" }}
        </template>
      </el-table-column>

      <el-table-column label="操作" width="210" align="center">
        <template slot-scope="scope">
          <router-link :to="'/vod/course/course/info/' + scope.row.id">
            <el-button type="text" icon="el-icon-edit">修改</el-button>
          </router-link>
          <router-link :to="'/vod/course/course/chapter/' + scope.row.id">
            <el-button type="text" icon="el-icon-edit">编辑大纲</el-button>
          </router-link>
          <router-link :to="'/vod/course/course/chart/' + scope.row.id">
            <el-button type="text" icon="el-icon-edit">课程统计</el-button>
          </router-link>
          <el-button
            type="text"
            icon="el-icon-delete"
            @click="removeById(scope.row.id)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center"
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="changePageSize"
      @current-change="changeCurrentPage"
    />
  </div>
</template>

<script>
  import teacherAPI from "@/api/vod/teacher";
  import subjectAPI from "@/api/vod/subject";
  import courseAPI from "@/api/vod/course";

  export default {
    data() {
      return {
        // 课程列表
        list: [],
        // 总记录数
        total: 0,
        // 页码
        page: 1,
        // 每页记录数
        limit: 10,

        // 查询条件
        searchObj: {
          // 解决查询表单无法选中二级类别
          subjectId: "",
        },

        // 教师列表
        teacherList: [],
        // 一级分类列表
        subjectList: [],
        // 二级分类列表,
        subjectLevelTwoList: [],
      };
    },

    created() {
      this.fetchData();

      // 初始化分类列表
      this.initSubjectList();

      // 获取教师列表
      this.initTeacherList();
    },

    methods: {
      fetchData() {
        courseAPI
          .getPageList(this.page, this.limit, this.searchObj)
          .then((response) => {
            this.list = response.data.records;
            this.total = response.data.totalCount;
          });
      },

      initTeacherList() {
        teacherAPI.list().then((response) => {
          this.teacherList = response.data;
        });
      },

      initSubjectList() {
        subjectAPI.getChildList(0).then((response) => {
          this.subjectList = response.data;
        });
      },

      subjectLevelOneChanged(value) {
        subjectAPI.getChildList(value).then((response) => {
          this.subjectLevelTwoList = response.data;
          this.searchObj.subjectId = "";
        });
      },

      add() {
        this.$router.push({ path: "/vod/course/course/info" });
      },

      // 每页记录数改变，size：回调参数，表示当前选中的“每页条数”
      changePageSize(size) {
        this.limit = size;
        this.fetchData();
      },

      // 改变页码，page：回调参数，表示当前选中的“页码”
      changeCurrentPage(page) {
        this.page = page;
        this.fetchData();
      },

      // 重置表单
      resetData() {
        this.searchObj = {};

        // 二级分类列表
        this.subjectLevelTwoList = [];
        this.fetchData();
      },
    },
  };
</script>
```

### 二、发布课程-填写课程基本信息

#### 1、界面效果

![界面效果](https://img-blog.csdnimg.cn/fe78e1e39aec46f59bee7989e776d2d9.png)

#### 2、添加课程基本信息接口

##### 2.1、创建课程描述的 service 和 mapper

![创建课程描述的 service 和 mapper](https://img-blog.csdnimg.cn/93682e5992724079b342e222247bcda1.png)

##### 2.2、创建添加课程基本信息接口

**（1）controller**

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.CourseFormVo;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 前端控制器
 * </p>
 */
@Tag(name = "课程接口", description = "课程管理接口")
@RestController
@RequestMapping("/admin/vod/course")
@CrossOrigin
public class CourseController
{
    @Autowired
    private CourseService courseService;

    /**
     * 添加课程基本信息
     *
     * @param courseFormVo 课程基本信息
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加课程基本信息", description = "添加课程基本信息")
    @PostMapping("save")
    public Result<Long> saveCourseInfo(@RequestBody CourseFormVo courseFormVo)
    {
        Long courseId = courseService.saveCourseInfo(courseFormVo);

        return Result.ok(courseId);
    }
}
```

**（2）service**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.model.vod.CourseDescription;
import com.myxh.smart.planet.vo.vod.CourseFormVo;
import com.myxh.smart.planet.vod.mapper.CourseMapper;
import com.myxh.smart.planet.vod.service.CourseDescriptionService;
import com.myxh.smart.planet.vod.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务实现类
 * </p>
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService
{
    @Autowired
    private CourseDescriptionService courseDescriptionService;

    /**
     * 添加课程基本信息
     *
     * @param courseFormVo 课程基本信息
     * @return courseId 课程 id
     */
    @Override
    public Long saveCourseInfo(CourseFormVo courseFormVo)
    {
        // 添加课程基本信息，操作 course 表
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.insert(course);

        // 添加课程详情信息，操作 course_description 表
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseFormVo.getDescription());

        // 设置课程 id
        courseDescription.setCourseId(course.getId());
        courseDescriptionService.save(courseDescription);

        // 返回课程 id
        return course.getId();
    }
}
```

#### 3、添加课程基本信息前端

##### 3.1、课程列表 list.vue 添加方法

```javascript
add() {
  this.$router.push({ path: "/vod/course/course/info" });
},
```

##### 3.2、course.js 定义接口

```javascript
import request from "@/utils/request";

const COURSE_API = "/admin/vod/course";

export default {
  /**
   * 添加课程基本信息
   * @param {Object} courseInfo 课程基本信息
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  saveCourseInfo(courseInfo) {
    return request({
      url: `${COURSE_API}/save`,
      method: "post",
      data: courseInfo,
    });
  },
};
```

##### 3.3、创建课程基本信息添加页面

![创建课程基本信息添加页面](https://img-blog.csdnimg.cn/1396fa96c59f4c759b424428f8f997fc.png)

**（1）form.vue**

```html
<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <h2 style="text-align: center">发布新课程</h2>
    <el-steps
      :active="active"
      finish-status="success"
      simple
      style="margin-bottom: 40px"
    >
      <el-step title="填写课程基本信息" />
      <el-step title="创建课程大纲" />
      <el-step title="发布课程" />
    </el-steps>

    <!-- 填写课程基本信息 -->
    <info v-if="active === 0" />

    <!-- 创建课程大纲 -->
    <chapter v-if="active === 1" />

    <!-- 发布课程 -->
    <publish v-if="active === 2 || active === 3" />
  </div>
</template>

<script>
  // 引入子组件
  import info from "@/views/vod/course/components/info";
  import chapter from "@/views/vod/course/components/chapter";
  import publish from "@/views/vod/course/components/publish";

  export default {
    // 注册子组件
    components: { info, chapter, publish },

    data() {
      return {
        active: 0,
        courseId: null,
      };
    },

    created() {
      // 获取路由id
      if (this.$route.params.id) {
        this.courseId = this.$route.params.id;
      }
      if (this.$route.name === "CourseInfoEdit") {
        this.active = 0;
      }
      if (this.$route.name === "CourseChapterEdit") {
        this.active = 1;
      }
    },
  };
</script>
```

**（2）Info.vue**

```html
<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <!-- 课程信息表单 -->
    <el-form label-width="120px">
      <el-form-item label="课程标题">
        <el-input
          v-model="courseInfo.title"
          placeholder=" 示例：机器学习项目课：从基础到搭建项目视频课程。专业名称注意大小写"
        />
      </el-form-item>

      <!-- 课程教师 -->
      <el-form-item label="课程教师">
        <el-select v-model="courseInfo.teacherId" placeholder="请选择">
          <el-option
            v-for="teacher in teacherList"
            :key="teacher.id"
            :label="teacher.name"
            :value="teacher.id"
          />
        </el-select>
      </el-form-item>

      <!-- 所属分类：级联下拉列表 -->
      <el-form-item label="课程类别">
        <!-- 一级分类 -->
        <el-select
          v-model="courseInfo.subjectParentId"
          placeholder="请选择"
          @change="subjectChanged"
        >
          <el-option
            v-for="subject in subjectList"
            :key="subject.id"
            :label="subject.title"
            :value="subject.id"
          />
        </el-select>

        <!-- 二级分类 -->
        <el-select v-model="courseInfo.subjectId" placeholder="请选择">
          <el-option
            v-for="subject in subjectLevelTwoList"
            :key="subject.id"
            :label="subject.title"
            :value="subject.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="总课时">
        <el-input-number
          :min="0"
          v-model="courseInfo.lessonNum"
          controls-position="right"
          placeholder="请填写课程的总课时数"
        />
      </el-form-item>

      <!-- 课程简介-->
      <el-form-item label="课程简介">
        <el-input v-model="courseInfo.description" type="textarea" rows="5" />
      </el-form-item>

      <!-- 课程封面 -->
      <el-form-item label="课程封面">
        <el-upload
          :show-file-list="false"
          :on-success="handleCoverSuccess"
          :before-upload="beforeCoverUpload"
          :on-error="handleCoverError"
          :action="BASE_API + '/admin/vod/file/upload'"
          class="cover-uploader"
        >
          <img
            v-if="courseInfo.cover"
            :src="courseInfo.cover"
            style="width: 200px; height: auto"
          />
          <i v-else class="el-icon-plus avatar-uploader-icon" />
        </el-upload>
      </el-form-item>
      <el-form-item label="课程价格">
        <el-input-number
          :min="0"
          v-model="courseInfo.price"
          controls-position="right"
          placeholder="免费课程请设置为0元"
        />
        元
      </el-form-item>
    </el-form>

    <div style="text-align: center">
      <el-button
        :disabled="saveBtnDisabled"
        type="primary"
        @click="saveAndNext()"
        >保存并下一步</el-button
      >
    </div>
  </div>
</template>

<script>
  import courseAPI from "@/api/vod/course";
  import teacherAPI from "@/api/vod/teacher";
  import subjectAPI from "@/api/vod/subject";

  export default {
    data() {
      return {
        BASE_API: "http://localhost:8301",
        // 按钮是否禁用
        saveBtnDisabled: false,

        courseId: 0,

        courseInfo: {
          // 表单数据
          price: 0,
          lessonNum: 0,
          // 以下解决表单数据不全时 insert 语句非空校验
          teacherId: "",
          subjectId: "",
          subjectParentId: "",
          cover: "",
          description: "",
        },

        // 教师列表
        teacherList: [],
        // 一级分类列表
        subjectList: [],
        // 二级分类列表
        subjectLevelTwoList: [],
      };
    },

    created() {
      // 初始化分类列表
      this.initSubjectList();

      // 获取教师列表
      this.initTeacherList();
    },

    methods: {
      // 获取教师列表
      initTeacherList() {
        teacherAPI.list().then((response) => {
          this.teacherList = response.data;
        });
      },

      // 初始化分类列表
      initSubjectList() {
        subjectAPI.getChildList(0).then((response) => {
          this.subjectList = response.data;
        });
      },

      // 选择一级分类，切换二级分类
      subjectChanged(value) {
        subjectAPI.getChildList(value).then((response) => {
          this.courseInfo.subjectId = "";
          this.subjectLevelTwoList = response.data;
        });
      },

      // 上传成功回调
      handleCoverSuccess(response, file) {
        this.courseInfo.cover = response.data;
      },

      // 上传校验
      beforeCoverUpload(file) {
        const isJPG = file.type === "image/jpeg";
        const isPNG = file.type === "image/png";
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG && !isPNG) {
          this.$message.error("上传课程封面只能是 JPG 或 PNG 格式!");
        }
        if (!isLt2M) {
          this.$message.error("上传课程封面大小不能超过 2MB!");
        }

        return (isJPG || isPNG) && isLt2M;
      },

      // 错误处理
      handleCoverError() {
        console.log("error");
        this.$message.error("上传失败");
      },

      // 保存并下一步
      saveAndNext() {
        this.saveBtnDisabled = true;

        if (!this.courseInfo.title) {
          this.$message.error("请输入课程标题");
          this.saveBtnDisabled = false;

          return;
        }

        if (!this.courseInfo.description) {
          this.$message.error("请输入课程简介");
          this.saveBtnDisabled = false;

          return;
        }

        if (!this.$parent.courseId) {
          this.saveData();
        } else {
          this.updateData();
        }
      },

      // 保存
      saveData() {
        courseAPI.saveCourseInfo(this.courseInfo).then((response) => {
          this.$message.success(response.message);

          // 获取 courseId
          this.$parent.courseId = response.data;

          // 下一步
          this.$parent.active = 1;
        });
      },

      // 修改
      updateData() {},
    },
  };
</script>
```

### 三、发布课程-修改课程基本信息

![发布课程-修改课程基本信息](https://img-blog.csdnimg.cn/76d67678adac48bf902f0878ad4bf3bc.png)

#### 1、修改课程基本信息接口

##### 1.1、CourseService 定义方法

```java
package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vo.vod.CourseFormVo;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务类
 * </p>
 */
public interface CourseService extends IService<Course>
{
    /**
     * 根据 id 获取课程信息
     *
     * @param id 课程 id
     * @return CourseFormVo 课程基本信息
     */
    CourseFormVo getCourseInfoById(Long id);

    /**
     * 根据 id 修改课程信息
     *
     * @param courseFormVo 课程基本信息
     * @return courseId 课程 id
     */
    Long updateCourseById(CourseFormVo courseFormVo);
}
```

##### 1.2、CourseServiceImpl 实现方法

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.model.vod.CourseDescription;
import com.myxh.smart.planet.vo.vod.CourseFormVo;
import com.myxh.smart.planet.vod.mapper.CourseMapper;
import com.myxh.smart.planet.vod.service.CourseDescriptionService;
import com.myxh.smart.planet.vod.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务实现类
 * </p>
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService
{
    @Autowired
    private CourseDescriptionService courseDescriptionService;

    /**
     * 根据 id 获取课程信息
     *
     * @param id 课程 id
     * @return CourseFormVo 课程基本信息
     */
    @Override
    public CourseFormVo getCourseInfoById(Long id)
    {
        // 从 course 表中获取课程基本信息
        Course course = baseMapper.selectById(id);

        if (course == null)
        {
            return null;
        }

        //从 course_description 表中获取课程描述信息
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        CourseDescription courseDescription = courseDescriptionService.getOne(wrapper);

        // 封装描述信息，创建 CourseFormVo 对象
        CourseFormVo courseFormVo = new CourseFormVo();
        BeanUtils.copyProperties(course, courseFormVo);

        if (courseDescription != null)
        {
            courseFormVo.setDescription(courseDescription.getDescription());
        }

        return courseFormVo;
    }

    /**
     * 根据 id 修改课程信息
     *
     * @param courseFormVo 课程基本信息
     * @return courseId 课程 id
     */
    @Override
    public void updateCourseById(CourseFormVo courseFormVo)
    {
        // 修改课程基本信息
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.updateById(course);

        // 修改课程详情信息
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", course.getId());
        CourseDescription courseDescription = courseDescriptionService.getOne(wrapper);
        courseDescription.setDescription(courseFormVo.getDescription());

        // 设置课程描述 id
        courseDescription.setCourseId(course.getId());
        courseDescriptionService.updateById(courseDescription);

        // 返回课程 id
        return course.getId();
    }
}
```

##### 1.3、CourseController 实现方法

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.CourseFormVo;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 前端控制器
 * </p>
 */
@Tag(name = "课程接口", description = "课程管理接口")
@RestController
@RequestMapping("/admin/vod/course")
@CrossOrigin
public class CourseController
{
    @Autowired
    private CourseService courseService;

    /**
     * 根据 id 获取课程信息
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据 id 获取课程信息", description = "根据 id 获取课程信息")
    @GetMapping("get/{id}")
    public Result<CourseFormVo> get(@PathVariable("id") Long id)
    {
        CourseFormVo courseFormVo = courseService.getCourseInfoById(id);

        return Result.ok(courseFormVo);
    }

    /**
     * 根据 id 修改课程信息
     *
     * @param courseFormVo 课程基本信息
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据 id 修改课程信息", description = "根据 id 修改课程信息")
    @PostMapping("update")
    public Result<Void> updateCourse(@RequestBody CourseFormVo courseFormVo)
    {
        Long courseId = courseService.updateCourseById(courseFormVo);

        return Result.ok(courseId);
    }
}
```

#### 2、修改课程基本信息前端

##### 2.1、course.js 定义方法

```javascript
import request from "@/utils/request";

const COURSE_API = "/admin/vod/course";

export default {
  /**
   * 根据 id 获取课程信息
   *
   * @param {number} id 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getCourseInfoById(id) {
    return request({
      url: `${COURSE_API}/get/${id}`,
      method: "get",
    });
  },

  /**
   * 根据 id 修改课程信息
   *
   * @param {Object} courseInfo 课程基本信息
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateCourseInfoById(courseInfo) {
    return request({
      url: `${COURSE_API}/update`,
      method: "post",
      data: courseInfo,
    });
  },
};
```

##### 2.2、修改 Info.vue 页面

```html
<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <!-- 课程信息表单 -->
    <el-form label-width="120px">
      <el-form-item label="课程标题">
        <el-input
          v-model="courseInfo.title"
          placeholder=" 示例：机器学习项目课：从基础到搭建项目视频课程。专业名称注意大小写"
        />
      </el-form-item>

      <!-- 课程教师 -->
      <el-form-item label="课程教师">
        <el-select v-model="courseInfo.teacherId" placeholder="请选择">
          <el-option
            v-for="teacher in teacherList"
            :key="teacher.id"
            :label="teacher.name"
            :value="teacher.id"
          />
        </el-select>
      </el-form-item>

      <!-- 所属分类：级联下拉列表 -->
      <el-form-item label="课程类别">
        <!-- 一级分类 -->
        <el-select
          v-model="courseInfo.subjectParentId"
          placeholder="请选择"
          @change="subjectChanged"
        >
          <el-option
            v-for="subject in subjectList"
            :key="subject.id"
            :label="subject.title"
            :value="subject.id"
          />
        </el-select>

        <!-- 二级分类 -->
        <el-select v-model="courseInfo.subjectId" placeholder="请选择">
          <el-option
            v-for="subject in subjectLevelTwoList"
            :key="subject.id"
            :label="subject.title"
            :value="subject.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="总课时">
        <el-input-number
          :min="0"
          v-model="courseInfo.lessonNum"
          controls-position="right"
          placeholder="请填写课程的总课时数"
        />
      </el-form-item>

      <!-- 课程简介-->
      <el-form-item label="课程简介">
        <el-input v-model="courseInfo.description" type="textarea" rows="5" />
      </el-form-item>

      <!-- 课程封面 -->
      <el-form-item label="课程封面">
        <el-upload
          :show-file-list="false"
          :on-success="handleCoverSuccess"
          :before-upload="beforeCoverUpload"
          :on-error="handleCoverError"
          :action="BASE_API + '/admin/vod/file/upload'"
          class="cover-uploader"
        >
          <img
            v-if="courseInfo.cover"
            :src="courseInfo.cover"
            style="width: 200px; height: auto"
          />
          <i v-else class="el-icon-plus avatar-uploader-icon" />
        </el-upload>
      </el-form-item>
      <el-form-item label="课程价格">
        <el-input-number
          :min="0"
          v-model="courseInfo.price"
          controls-position="right"
          placeholder="免费课程请设置为0元"
        />
        元
      </el-form-item>
    </el-form>

    <div style="text-align: center">
      <el-button
        :disabled="saveBtnDisabled"
        type="primary"
        @click="saveAndNext()"
        >保存并下一步</el-button
      >
    </div>
  </div>
</template>

<script>
  import courseAPI from "@/api/vod/course";
  import teacherAPI from "@/api/vod/teacher";
  import subjectAPI from "@/api/vod/subject";

  export default {
    data() {
      return {
        BASE_API: "http://localhost:8301",
        // 按钮是否禁用
        saveBtnDisabled: false,

        courseId: 0,

        courseInfo: {
          // 表单数据
          price: 0,
          lessonNum: 0,
          // 以下解决表单数据不全时 insert 语句非空校验
          teacherId: "",
          subjectId: "",
          subjectParentId: "",
          cover: "",
          description: "",
        },

        // 教师列表
        teacherList: [],
        // 一级分类列表
        subjectList: [],
        // 二级分类列表
        subjectLevelTwoList: [],
      };
    },

    created() {
      if (this.$parent.courseId) {
        // 回显数据
        this.fetchCourseInfoById(this.$parent.courseId);
      } else {
        // 新增数据
        // 初始化分类列表
        this.initSubjectList();
      }

      // 获取教师列表
      this.initTeacherList();
    },

    methods: {
      // 获取教师列表
      initTeacherList() {
        teacherAPI.list().then((response) => {
          this.teacherList = response.data;
        });
      },

      // 初始化分类列表
      initSubjectList() {
        subjectAPI.getChildList(0).then((response) => {
          this.subjectList = response.data;
        });
      },

      // 选择一级分类，切换二级分类
      subjectChanged(value) {
        subjectAPI.getChildList(value).then((response) => {
          this.courseInfo.subjectId = "";
          this.subjectLevelTwoList = response.data;
        });
      },

      // 上传成功回调
      handleCoverSuccess(response, file) {
        this.courseInfo.cover = response.data;
      },

      // 上传校验
      beforeCoverUpload(file) {
        const isJPG = file.type === "image/jpeg";
        const isPNG = file.type === "image/png";
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG && !isPNG) {
          this.$message.error("上传课程封面只能是 JPG 或 PNG 格式!");
        }
        if (!isLt2M) {
          this.$message.error("上传课程封面大小不能超过 2MB!");
        }

        return (isJPG || isPNG) && isLt2M;
      },

      // 错误处理
      handleCoverError() {
        console.log("error");
        this.$message.error("上传失败");
      },

      // 保存并下一步
      saveAndNext() {
        this.saveBtnDisabled = true;

        if (!this.courseInfo.title) {
          this.$message.error("请输入课程标题");
          this.saveBtnDisabled = false;

          return;
        }

        if (!this.courseInfo.description) {
          this.$message.error("请输入课程简介");
          this.saveBtnDisabled = false;

          return;
        }

        if (!this.$parent.courseId) {
          this.saveData();
        } else {
          this.updateData();
        }
      },

      // 保存
      saveData() {
        courseAPI.saveCourseInfo(this.courseInfo).then((response) => {
          this.$message.success(response.message);

          // 获取 courseId
          this.$parent.courseId = response.data;

          // 下一步
          this.$parent.active = 1;
        });
      },

      // 获取课程信息
      fetchCourseInfoById(id) {
        courseAPI.getCourseInfoById(id).then((response) => {
          this.courseInfo = response.data;

          // 初始化分类列表
          subjectAPI.getChildList(0).then((response) => {
            this.subjectList = response.data;

            // 填充二级菜单，遍历一级菜单列表
            this.subjectList.forEach((subject) => {
              // 找到和 courseInfo.subjectParentId 一致的父类别记录
              if (subject.id === this.courseInfo.subjectParentId) {
                // 拿到当前类别下的子类别列表，将子类别列表填入二级下拉菜单列表
                subjectAPI.getChildList(subject.id).then((response) => {
                  this.subjectLevelTwoList = response.data;
                });
              }
            });
          });
        });
      },

      // 修改
      updateData() {
        courseAPI.updateCourseInfoById(this.courseInfo).then((response) => {
          this.$message.success(response.message);

          // 获取 courseId
          this.$parent.courseId = response.data;

          // 下一步
          this.$parent.active = 1;
        });
      },
    },
  };
</script>
```

##### 2.3、创建 chapter/index.vue 页面

![创建 chapter/index.vue 页面](https://img-blog.csdnimg.cn/df9569faf29f40dbac00a0764b71a8b9.png)

```html
<template>
  <div class="app-container">
    <div style="text-align: center">
      <el-button type="primary" @click="prev()">上一步</el-button>
      <el-button type="primary" @click="next()">下一步</el-button>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {};
    },

    created() {},

    methods: {
      // 上一步
      prev() {
        this.$parent.active = 0;
      },

      // 下一步
      next() {
        this.$parent.active = 2;
      },
    },
  };
</script>
```

## Day 8-点播管理模块（二）

### 一、发布课程-创建课程大纲

![发布课程-创建课程大纲](https://img-blog.csdnimg.cn/8d000d4a767243ab8552810865d4764a.png)

#### 1、课程章节接口

**实现课程章节的列表、添加、修改和删除功能。**

##### 1.1、编写章节 Controller

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Chapter;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.ChapterVo;
import com.myxh.smart.planet.vod.service.ChapterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 章节 前端控制器
 * </p>
 */
@Tag(name = "章节接口", description = "章节管理接口")
@RestController
@RequestMapping("/admin/vod/chapter")
@CrossOrigin
public class ChapterController
{
    @Autowired
    private ChapterService chapterService;


    /**
     * 大纲列表，获取章节和小节列表
     *
     * @param courseId 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "大纲列表", description = "获取获取章节和小节列表")
    @GetMapping("get/nested/tree/list/{courseId}")
    public Result<List<ChapterVo>> getNestedTreeList(@Parameter(name = "courseId", description = "课程ID", required = true)
                                                     @PathVariable("courseId") Long courseId)
    {
        List<ChapterVo> chapterVoList = chapterService.getNestedTreeList(courseId);

        return Result.ok(chapterVoList);
    }

    /**
     * 添加章节
     *
     * @param chapter 章节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加章节", description = "添加章节")
    @PostMapping("save")
    public Result<Void> saveChapter(@RequestBody Chapter chapter)
    {
        chapterService.save(chapter);

        return Result.ok(null);
    }

    /**
     * 根据 id 查询章节
     *
     * @param id 章节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询章节", description = "根据 id 查询章节")
    @GetMapping("get/{id}")
    public Result<Chapter> getChapter(@Parameter(name = "id", description = "章节ID", required = true)
                                      @PathVariable("id") Long id)
    {
        Chapter chapter = chapterService.getById(id);

        return Result.ok(chapter);
    }

    /**
     * 修改章节
     *
     * @param chapter 章节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改章节", description = "修改章节")
    @PostMapping("update")
    public Result<Void> updateChapter(@RequestBody Chapter chapter)
    {
        chapterService.updateById(chapter);

        return Result.ok(null);
    }

    /**
     * 根据 id 删除章节
     *
     * @param id 章节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除章节", description = "根据 id 删除章节")
    @DeleteMapping("remove/{id}")
    public Result<Void> removeChapter(@Parameter(name = "id", description = "章节ID", required = true)
                                      @PathVariable("id") Long id)
    {
        chapterService.removeById(id);

        return Result.ok(null);
    }
}
```

##### 1.2、编写章节 Service

**（1）ChapterService**

```java
package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.Chapter;
import com.myxh.smart.planet.vo.vod.ChapterVo;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 章节 服务类
 * </p>
 */
public interface ChapterService extends IService<Chapter>
{
    /**
     * 大纲列表，获取章节和小节列表
     *
     * @param courseId 课程 id
     * @return chapterVoList 章节和小节列表
     */
    List<ChapterVo> getNestedTreeList(Long courseId);

    /**
     * 根据课程 id 删除章节
     *
     * @param id 课程 id
     */
    void removeChapterByCourseId(Long id);
}
```

**（2）ChapterServiceImpl**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Chapter;
import com.myxh.smart.planet.model.vod.Video;
import com.myxh.smart.planet.vo.vod.ChapterVo;
import com.myxh.smart.planet.vo.vod.VideoVo;
import com.myxh.smart.planet.vod.mapper.ChapterMapper;
import com.myxh.smart.planet.vod.service.ChapterService;
import com.myxh.smart.planet.vod.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 章节 服务实现类
 * </p>
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService
{
    @Autowired
    private VideoService videoService;

    /**
     * 大纲列表，获取章节和小节列表
     *
     * @param courseId 课程 id
     * @return chapterVoList 章节和小节列表
     */
    @Override
    public List<ChapterVo> getNestedTreeList(Long courseId)
    {
        // 定义章节和小节列表 List 集合
        List<ChapterVo> chapterVoList = new ArrayList<>();

        // 根据 courseId 获取课程里面所有章节
        QueryWrapper<Chapter> chapterQueryWrapper = new QueryWrapper<>();
        chapterQueryWrapper.eq("course_id", courseId);
        List<Chapter> chapterList = baseMapper.selectList(chapterQueryWrapper);

        // 根据 courseId 获取课程里面所有小节
        LambdaQueryWrapper<Video> videoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        videoLambdaQueryWrapper.eq(Video::getCourseId, courseId);
        videoLambdaQueryWrapper.orderByAsc(Video::getSort, Video::getId);
        List<Video> videoList = videoService.list(videoLambdaQueryWrapper);

        // 封装章节
        // 遍历所有的章节
        for (Chapter chapter : chapterList)
        {
            // 创建 ChapterVo 对象
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            chapterVoList.add(chapterVo);

            // 封装章节里面的小节
            // 创建 List 集合用来封装章节所有小节
            List<VideoVo> videoVoList = new ArrayList<>();

            // 遍历小节 List
            for (Video video : videoList)
            {
                // 判断小节是哪个章节下面
                if (chapter.getId().equals(video.getChapterId()))
                {
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    videoVoList.add(videoVo);
                }
            }

            // 把章节里面所有小节集合放到每个章节里面
            chapterVo.setChildren(videoVoList);
        }

        return chapterVoList;
    }

    /**
     * 根据课程 id 删除章节
     *
     * @param id 课程 id
     */
    @Override
    public void removeChapterByCourseId(Long id)
    {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        baseMapper.delete(wrapper);
    }
}
```

#### 2、课程小节接口

##### 2.1、编写 VideoController

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Video;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程视频 前端控制器
 * </p>
 */
@Tag(name = "课程视频小节接口", description = "课程视频小节管理接口")
@RestController
@RequestMapping("/admin/vod/video")
@CrossOrigin
public class VideoController
{
    @Autowired
    private VideoService videoService;

    /**
     * 获取课程视频小节
     *
     * @param id 课程视频小节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取课程视频小节", description = "获取课程视频小节")
    @GetMapping("get/{id}")
    public Result<Video> get(@Parameter(name = "id", description = "课程视频小节ID", required = true)
                             @PathVariable("id") Long id)
    {
        Video video = videoService.getById(id);

        return Result.ok(video);
    }

    /**
     * 新增课程视频小节
     *
     * @param video 课程视频小节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "新增课程视频小节", description = "新增课程视频小节")
    @PostMapping("save")
    public Result<Void> save(@RequestBody Video video)
    {
        videoService.save(video);

        return Result.ok(null);
    }

    /**
     * 修改课程视频小节
     *
     * @param video 课程视频小节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改课程视频小节", description = "修改课程视频小节")
    @PostMapping("update")
    public Result<Void> update(@RequestBody Video video)
    {
        videoService.updateById(video);

        return Result.ok(null);
    }

    /**
     * 删除课程视频小节
     *
     * @param id 课程视频小节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除课程视频小节", description = "删除课程视频小节")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@Parameter(name = "id", description = "课程视频小节ID", required = true)
                               @PathVariable("id") Long id)
    {
        videoService.removeById(id);

        return Result.ok(null);
    }
}
```

#### 3、课程大纲前端

##### 3.1、定义接口

![定义接口](https://img-blog.csdnimg.cn/2dcf3dbc86b24f0ca9ab771dae50704c.png)

**（1）chapter.js**

```javascript
import request from "@/utils/request";

const CHAPTER_API = "/admin/vod/chapter";

export default {
  /**
   * 大纲列表，获取章节和小节列表
   *
   * @param {number} courseId 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getNestedTreeList(courseId) {
    return request({
      url: `${CHAPTER_API}/get/nested/tree/list/${courseId}`,
      method: "get",
    });
  },

  /**
   * 添加章节
   *
   * @param {Object} chapter 章节数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  save(chapter) {
    return request({
      url: `${CHAPTER_API}/save`,
      method: "post",
      data: chapter,
    });
  },

  /**
   * 根据 id 查询章节
   *
   * @param {number} id 章节 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getById(id) {
    return request({
      url: `${CHAPTER_API}/get/${id}`,
      method: "get",
    });
  },

  /**
   * 修改章节
   *
   * @param {Object} chapter 章节数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateById(chapter) {
    return request({
      url: `${CHAPTER_API}/update`,
      method: "post",
      data: chapter,
    });
  },

  /**
   * 根据 id 删除章节
   *
   * @param {number} id 章节 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${CHAPTER_API}/remove/${id}`,
      method: "delete",
    });
  },
};
```

**（2）创建 video.js。**

```javascript
import request from "@/utils/request";

const VIDEO_API = "/admin/vod/video";

export default {
  /**
   * 获取课程视频小节
   *
   * @param {number} id 课程视频小节 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getById(id) {
    return request({
      url: `${VIDEO_API}/get/${id}`,
      method: "get",
    });
  },

  /**
   * 新增课程视频小节
   *
   * @param {Object}video 课程视频小节数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  save(video) {
    return request({
      url: `${VIDEO_API}/save`,
      method: "post",
      data: video,
    });
  },

  /**
   * 修改课程视频小节
   *
   * @param {Object}video 课程视频小节数据
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateById(video) {
    return request({
      url: `${VIDEO_API}/update`,
      method: "post",
      data: video,
    });
  },

  /**
   * 删除课程视频小节
   *
   * @param {number} id 课程视频小节 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${VIDEO_API}/remove/${id}`,
      method: "delete",
    });
  },
};
```

##### 3.2、编写章节页面

![编写章节页面](https://img-blog.csdnimg.cn/b89a4f06b324436caf66223c2c1a83d3.png)

**（1）chapter/index.vue**

```html
<template>
  <div class="app-container">
    <!-- 添加章节按钮 -->
    <div>
      <el-button type="primary" @click="addChapter()">添加章节</el-button>
    </div>

    <!-- 章节列表 -->
    <ul class="chapterList">
      <li v-for="chapter in chapterList" :key="chapter.id">
        <p>
          {{ chapter.title }}
          <span class="acts">
            <el-button type="text" @click="addVideo(chapter.id)"
              >添加课时</el-button
            >
            <el-button type="text" @click="editChapter(chapter.id)"
              >编辑</el-button
            >
            <el-button type="text" @click="removeChapterById(chapter.id)"
              >删除</el-button
            >
          </span>
        </p>

        <!-- 视频 -->
        <ul class="chapterList videoList">
          <li v-for="video in chapter.children" :key="video.id">
            <p>
              {{ video.title }}
              <el-tag v-if="!video.videoSourceId" size="mini" type="danger">
                {{ "尚未上传视频" }}
              </el-tag>
              <span class="acts">
                <el-tag v-if="video.isFree" size="mini" type="success"
                  >{{ "免费观看" }}</el-tag
                >
                <el-button type="text" @click="editVideo(chapter.id, video.id)"
                  >编辑</el-button
                >
                <el-button type="text" @click="removeVideoById(video.id)"
                  >删除</el-button
                >
              </span>
            </p>
          </li>
        </ul>
      </li>
    </ul>

    <!-- 章节表单对话框 -->
    <chapter-form ref="chapterForm" />

    <!-- 课时表单对话框 -->
    <video-form ref="videoForm" />

    <div style="text-align: center">
      <el-button type="primary" @click="prev()">上一步</el-button>
      <el-button type="primary" @click="next()">下一步</el-button>
    </div>
  </div>
</template>

<script>
  import chapterAPI from "@/api/vod/chapter";
  import videoAPI from "@/api/vod/video";

  // 引入组件
  import chapterForm from "@/views/vod/course/components/chapter/form";
  import videoForm from "@/views/vod/course/components/video/form";

  export default {
    // 注册组件
    components: { chapterForm, videoForm },

    data() {
      return {
        // 章节嵌套列表
        chapterList: [],
      };
    },

    created() {
      this.fetchNodeList();
    },

    methods: {
      // 获取章节小节数据
      fetchNodeList() {
        chapterAPI.getNestedTreeList(this.$parent.courseId).then((response) => {
          this.chapterList = response.data;
        });
      },

      // 添加章节
      addChapter() {
        this.$refs.chapterForm.open();
      },

      // 编辑章节
      editChapter(chapterId) {
        this.$refs.chapterForm.open(chapterId);
      },

      // 删除章节
      removeChapterById(chapterId) {
        this.$confirm("此操作将永久删除该章节，是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            return chapterAPI.removeById(chapterId);
          })
          .then((response) => {
            this.fetchNodeList();
            this.$message.success(response.message);
          })
          .catch((response) => {
            if (response === "cancel") {
              this.$message.info("取消删除");
            }
          });
      },

      // 添加课时
      addVideo(chapterId) {
        this.$refs.videoForm.open(chapterId);
      },

      // 编辑课时
      editVideo(chapterId, videoId) {
        this.$refs.videoForm.open(chapterId, videoId);
      },

      // 删除课时
      removeVideoById(videoId) {
        this.$confirm("此操作将永久删除该课时, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            return videoAPI.removeById(videoId);
          })
          .then((response) => {
            this.fetchNodeList();
            this.$message.success(response.message);
          })
          .catch((response) => {
            if (response === "cancel") {
              this.$message.info("取消删除");
            }
          });
      },

      // 上一步
      prev() {
        this.$parent.active = 0;
      },

      // 下一步
      next() {
        this.$parent.active = 2;
      },
    },
  };
</script>
```

**（2）chapter/form.vue**

```html
<template>
  <!-- 添加和修改章节表单 -->
  <el-dialog :visible="dialogVisible" title="添加章节" @close="close()">
    <el-form :model="chapter" label-width="120px">
      <el-form-item label="章节标题">
        <el-input v-model="chapter.title" />
      </el-form-item>
      <el-form-item label="章节排序">
        <el-input-number v-model="chapter.sort" :min="0" />
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="close()">取 消</el-button>
      <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
  import chapterAPI from "@/api/vod/chapter";

  export default {
    data() {
      return {
        dialogVisible: false,

        chapter: {
          sort: 0,
        },
      };
    },

    methods: {
      open(chapterId) {
        this.dialogVisible = true;

        if (chapterId) {
          chapterAPI.getById(chapterId).then((response) => {
            this.chapter = response.data;
          });
        }
      },

      close() {
        this.dialogVisible = false;
        // 重置表单
        this.resetForm();
      },

      resetForm() {
        this.chapter = {
          sort: 0,
        };
      },

      saveOrUpdate() {
        this.dialogVisible = true;

        if (!this.chapter.title) {
          this.$message.error("请输入章节标题");
          this.dialogVisible = false;

          return;
        }

        if (!this.chapter.id) {
          this.save();
        } else {
          this.update();
        }
      },

      save() {
        this.chapter.courseId = this.$parent.$parent.courseId;
        chapterAPI.save(this.chapter).then((response) => {
          this.$message.success(response.message);
          // 关闭组件
          this.close();

          // 刷新列表
          this.$parent.fetchNodeList();
        });
      },

      update() {
        chapterAPI.updateById(this.chapter).then((response) => {
          this.$message.success(response.message);
          // 关闭组件
          this.close();

          // 刷新列表
          this.$parent.fetchNodeList();
        });
      },
    },
  };
</script>
```

##### 3.3、编写小节（课时）页面

![编写小节（课时）页面](https://img-blog.csdnimg.cn/b89a4f06b324436caf66223c2c1a83d3.png)

**（1）video/form.vue**

```html
<template>
  <!-- 添加和修改课时表单 -->
  <el-dialog :visible="dialogVisible" title="添加课时" @close="close()">
    <el-form :model="video" label-width="120px">
      <el-form-item label="课时标题">
        <el-input v-model="video.title" />
      </el-form-item>
      <el-form-item label="课时排序">
        <el-input-number v-model="video.sort" :min="0" />
      </el-form-item>
      <el-form-item label="是否免费">
        <el-radio-group v-model="video.isFree">
          <el-radio :label="0">收费</el-radio>
          <el-radio :label="1">免费</el-radio>
        </el-radio-group>
      </el-form-item>

      <!-- 上传视频 -->
      <el-form-item label="上传视频">
        <el-upload
          ref="upload"
          :auto-upload="false"
          :on-success="handleUploadSuccess"
          :on-error="handleUploadError"
          :on-exceed="handleUploadExceed"
          :file-list="fileList"
          :limit="1"
          :before-remove="handleBeforeRemove"
          :on-remove="handleOnRemove"
          :action="BASE_API + '/admin/vod/upload'"
        >
          <el-button slot="trigger" size="small" type="primary"
            >选择视频</el-button
          >
          <el-button
            :disabled="uploadBtnDisabled"
            style="margin-left: 10px"
            size="small"
            type="success"
            @click="submitUpload()"
            >上传</el-button
          >
        </el-upload>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="close()">取 消</el-button>
      <el-button type="primary" @click="saveOrUpdate()">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
  import videoAPI from "@/api/vod/video";

  export default {
    data() {
      return {
        BASE_API: "http://localhost:8301",
        dialogVisible: false,

        video: {
          sort: 0,
          free: false,
        },

        // 上传文件列表
        fileList: [],
        uploadBtnDisabled: false,
      };
    },

    methods: {
      open(chapterId, videoId) {
        this.dialogVisible = true;
        this.video.chapterId = chapterId;

        if (videoId) {
          videoAPI.getById(videoId).then((response) => {
            this.video = response.data;
            // 回显
            if (this.video.videoOriginalName) {
              this.fileList = [{ name: this.video.videoOriginalName }];
            }
          });
        }
      },

      close() {
        this.dialogVisible = false;

        // 重置表单
        this.resetForm();
      },

      resetForm() {
        this.video = {
          sort: 0,
          free: false,
        };

        // 重置视频上传列表
        this.fileList = [];
      },

      saveOrUpdate() {
        this.dialogVisible = true;

        if (!this.video.title) {
          this.$message.error("请输入课时标题");
          this.dialogVisible = false;

          return;
        }

        if (!this.video.id) {
          this.save();
        } else {
          this.update();
        }
      },

      save() {
        this.video.courseId = this.$parent.$parent.courseId;
        videoAPI.save(this.video).then((response) => {
          this.$message.success(response.message);
          // 关闭组件
          this.close();

          // 刷新列表
          this.$parent.fetchNodeList();
        });
      },

      update() {
        videoAPI.updateById(this.video).then((response) => {
          this.$message.success(response.message);
          // 关闭组件
          this.close();

          // 刷新列表
          this.$parent.fetchNodeList();
        });
      },

      // 处理上传超出一个视频
      handleUploadExceed(files, fileList) {
        this.$message.warning("想要重新上传视频，请先删除已上传的视频");
      },

      // 上传
      submitUpload() {
        this.uploadBtnDisabled = true;

        // 提交上传请求
        this.$refs.upload.submit();
      },

      // 视频上传成功的回调
      handleUploadSuccess(response, file, fileList) {
        this.uploadBtnDisabled = false;
        this.video.videoSourceId = response.data;
        this.video.videoOriginalName = file.name;
      },

      // 失败回调
      handleUploadError() {
        this.uploadBtnDisabled = false;
        this.$message.error("上传失败");
      },

      // 删除视频文件确认
      handleBeforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${file.name}？`);
      },

      // 执行视频文件的删除
      handleOnRemove(file, fileList) {
        if (!this.video.videoSourceId) {
          return;
        }
      },
    },
  };
</script>
```

### 二、发布课程-课程最终发布

#### 1、课程最终发布接口

##### 1.1、编写 CourseController

**添加方法。**

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.CoursePublishVo;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 前端控制器
 * </p>
 */
@Tag(name = "课程接口", description = "课程管理接口")
@RestController
@RequestMapping("/admin/vod/course")
@CrossOrigin
public class CourseController
{
    @Autowired
    private CourseService courseService;

    /**
     * 根据课程 id 查询课程发布信息
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据课程 id 查询课程发布信息", description = "根据课程 id 查询课程发布信息")
    @GetMapping("get/course/publish/vo/{id}")
    public Result<CoursePublishVo> getCoursePublishVoById(@Parameter(name = "id", description = "课程ID", required = true)
                                                          @PathVariable Long id)
    {
        CoursePublishVo coursePublishVo = courseService.getCoursePublishVo(id);

        return Result.ok(coursePublishVo);
    }

    /**
     * 根据课程 id 最终发布课程
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据课程 id 最终发布课程", description = "根据课程 id 最终发布课程")
    @PutMapping("publish/course/{id}")
    public Result<Void> publishCourseById(@Parameter(name = "id", description = "课程ID", required = true)
                                          @PathVariable Long id)
    {
        courseService.publishCourse(id);

        return Result.ok(null);
    }
}
```

##### 1.2、编写 CourseService

```java
package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vo.vod.CoursePublishVo;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务类
 * </p>
 */
public interface CourseService extends IService<Course>
{
    /**
     * 根据课程 id 查询课程发布信息
     *
     * @param id 课程 id
     * @return coursePublishVo 课程发布信息
     */
    CoursePublishVo getCoursePublishVo(Long id);

    /**
     * 根据课程 id 最终发布课程
     *
     * @param id 课程 id
     */
    void publishCourse(Long id);
}
```

##### 1.3、编写 CourseServiceImpl

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vo.vod.CoursePublishVo;
import com.myxh.smart.planet.vod.mapper.CourseMapper;
import com.myxh.smart.planet.vod.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务实现类
 * </p>
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService
{
    /**
     * 根据课程 id 查询课程发布信息
     *
     * @param id 课程 id
     * @return coursePublishVo 课程发布信息
     */
    @Override
    public CoursePublishVo getCoursePublishVo(Long id)
    {
        return baseMapper.selectCoursePublishVoById(id);
    }

    /**
     * 根据课程 id 最终发布课程
     *
     * @param id 课程 id
     */
    @Override
    public void publishCourse(Long id)
    {
        Course course = baseMapper.selectById(id);

        // 已经发布课程
        course.setStatus(1);
        course.setPublishTime(new Date());
        baseMapper.updateById(course);
    }
}
```

##### 1.4、编写 CourseMapper

```java
package com.myxh.smart.planet.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vo.vod.CoursePublishVo;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 Mapper 接口
 * </p>
 */
public interface CourseMapper extends BaseMapper<Course>
{
    /**
     * 根据课程 id 查询课程发布信息
     *
     * @param id 课程 id
     * @return coursePublishVo 课程发布信息
     */
    CoursePublishVo selectCoursePublishVoById(Long id);
}
```

##### 1.5、编写 CourseMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.myxh.smart.planet.vod.mapper.CourseMapper">
    <select id="selectCoursePublishVoById" resultType="com.myxh.smart.planet.vo.vod.CoursePublishVo">
        SELECT c.id,
               c.title,
               c.cover,
               c.lesson_num AS lessonNum,
               c.price,
               t.name       AS teacherName,
               s1.title     AS subjectParentTitle,
               s2.title     AS subjectTitle
        FROM `course` AS c
                 LEFT OUTER JOIN `teacher` t ON c.teacher_id = t.id
                 LEFT OUTER JOIN `subject` s1 ON c.subject_parent_id = s1.id
                 LEFT OUTER JOIN `subject` s2 ON c.subject_id = s2.id
        WHERE c.id = #{id}
    </select>
</mapper>
```

##### 1.6、添加配置

**（1）application.properties 添加。**

```properties
# 设置 mapper.xml 的路径
mybatis-plus.mapper-locations=classpath:com/myxh/smart/planet/vod/mapper/xml/*.xml
```

**（2）service 模块 pom.xml 添加。**

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>

    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.yml</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>

        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.yml</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>false</filtering>
        </resource>
    </resources>
</build>
```

#### 2、课程最终发布前端

##### 2.1、course.js 定义接口

```javascript
import request from "@/utils/request";

const COURSE_API = "/admin/vod/course";

export default {
  /**
   * 根据课程 id 查询课程发布信息
   *
   * @param {number} id 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getCoursePublishById(id) {
    return request({
      url: `${COURSE_API}/get/course/publish/vo/${id}`,
      method: "get",
    });
  },

  /**
   * 根据课程 id 最终发布课程
   *
   * @param {number} id 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  publishCourseById(id) {
    return request({
      url: `${COURSE_API}/publish/course/${id}`,
      method: "put",
    });
  },
};
```

##### 2.2、编写 publish.vue

![编写 publish.vue](https://img-blog.csdnimg.cn/b89a4f06b324436caf66223c2c1a83d3.png)

```html
<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <!-- 课程预览 -->
    <div class="ccInfo">
      <img :src="coursePublish.cover" style="width: 200px; height: auto" />
      <div class="main">
        <h2>{{ coursePublish.title }}</h2>
        <p class="gray">
          <span>共{{ coursePublish.lessonNum }}课时</span>
        </p>
        <p>
          <span
            >所属分类：{{ coursePublish.subjectParentTitle }} — {{
            coursePublish.subjectTitle }}</span
          >
        </p>
        <p>课程教师：{{ coursePublish.teacherName }}</p>
        <h3 class="red">￥{{ coursePublish.price }}</h3>
      </div>
    </div>
    <div style="text-align: center">
      <el-button type="primary" @click="prev()">上一步</el-button>
      <el-button
        :disabled="publishBtnDisabled"
        type="primary"
        @click="publish()"
        >发布课程</el-button
      >
    </div>
  </div>
</template>

<script>
  import courseAPI from "@/api/vod/course";

  export default {
    data() {
      return {
        // 按钮是否禁用
        publishBtnDisabled: false,
        coursePublish: {},
      };
    },

    created() {
      if (this.$parent.courseId) {
        this.fetchCoursePublishById(this.$parent.courseId);
      }
    },

    methods: {
      // 获取课程发布信息
      fetchCoursePublishById(id) {
        courseAPI.getCoursePublishById(id).then((response) => {
          this.coursePublish = response.data;
        });
      },

      // 上一步
      prev() {
        this.$parent.active = 1;
      },

      // 下一步
      publish() {
        this.publishBtnDisabled = true;
        courseAPI.publishCourseById(this.$parent.courseId).then((response) => {
          this.$parent.active = 3;
          this.$message.success(response.message);
          this.$router.push({ path: "/vod/course/course/list" });
        });
      },
    },
  };
</script>
```

### 三、功能实现-课程删除

#### 1、课程删除接口

##### 1.1、编写课程 Controller

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 前端控制器
 * </p>
 */
@Tag(name = "课程接口", description = "课程管理接口")
@RestController
@RequestMapping("/admin/vod/course")
@CrossOrigin
public class CourseController
{
    @Autowired
    private CourseService courseService;

    /**
     * 删除课程
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除课程", description = "删除课程")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@Parameter(name = "id", description = "课程ID", required = true)
                               @PathVariable Long id)
    {
        courseService.removeCourseById(id);

        return Result.ok(null);
    }
}
```

##### 1.2、编写课程 Service

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vod.mapper.CourseMapper;
import com.myxh.smart.planet.vod.service.ChapterService;
import com.myxh.smart.planet.vod.service.CourseDescriptionService;
import com.myxh.smart.planet.vod.service.CourseService;
import com.myxh.smart.planet.vod.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务实现类
 * </p>
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService
{
    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private VideoService videoService;

    /**
     * 删除课程
     *
     * @param id 课程 id
     */
    @Override
    public void removeCourseById(Long id)
    {
        // 根据课程 id 删除小节
        videoService.removeVideoByCourseId(id);

        // 根据课程 id 删除章节
        chapterService.removeChapterByCourseId(id);

        // 根据课程 id 删除描述
        courseDescriptionService.removeByCourseId(id);

        // 根据课程 id 删除课程
        baseMapper.deleteById(id);
    }
}
```

##### 1.3、编写 VideoService

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Video;
import com.myxh.smart.planet.vod.mapper.VideoMapper;
import com.myxh.smart.planet.vod.service.VideoService;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程视频 服务实现类
 * </p>
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService
{
    /**
     * 根据课程 id 删除课程视频小节
     *
     * @param id 课程 id
     */
    @Override
    public void removeVideoByCourseId(Long id)
    {
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        baseMapper.delete(wrapper);
    }
}
```

##### 1.4、编写 ChapterService

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Chapter;
import com.myxh.smart.planet.vod.mapper.ChapterMapper;
import com.myxh.smart.planet.vod.service.ChapterService;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 章节 服务实现类
 * </p>
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService
{
    /**
     * 根据课程 id 删除章节
     *
     * @param id 课程 id
     */
    @Override
    public void removeChapterByCourseId(Long id)
    {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        baseMapper.delete(wrapper);
    }
}
```

##### 1.5 编写 CourseDescriptionService

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.CourseDescription;
import com.myxh.smart.planet.vod.mapper.CourseDescriptionMapper;
import com.myxh.smart.planet.vod.service.CourseDescriptionService;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程简介 服务实现类
 * </p>
 */
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements CourseDescriptionService
{
    /**
     * 根据课程 id 删除描述
     *
     * @param id 课程 id
     */
    @Override
    public void removeByCourseId(Long id)
    {
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        baseMapper.delete(wrapper);
    }
}
```

#### 2、课程删除前端

##### 2.1、course.js 定义接口

```javascript
import request from "@/utils/request";

const COURSE_API = "/admin/vod/course";

export default {
  /**
   * 删除课程
   *
   * @param {number} id 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${COURSE_API}/remove/${id}`,
      method: "delete",
    });
  },
};
```

##### 2.2、course/list.vue 添加方法

```javascript
methods: {
  // 根据 id 删除数据
  removeById(id) {
    this.$confirm(
      "此操作将永久删除该课程，以及该课程下的章节和视频，是否继续?",
      "提示",
      {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }
    )
      .then(() => {
        return courseAPI.removeById(id);
      })
      .then((response) => {
        this.fetchData();
        this.$message.success(response.message);
      });
  },
}
```

## Day 9-点播管理模块（三）

### 一、点播管理模块-课程统计

#### 1、课程统计需求

![课程统计需求](https://img-blog.csdnimg.cn/ebaf7e00a63b47899b77f9ab43dd5454.png)

![课程统计需求](https://img-blog.csdnimg.cn/059b3c8cd5d84afe9d5c923e3a26ab66.png)

#### 2、课程统计接口

##### 2.1、创建相关代码

![创建相关代码](https://img-blog.csdnimg.cn/5b08f2f6e53041139bde0da9208cac15.png)

##### 2.2、编写 Controller

**VideoVisitorController**

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.VideoVisitorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/10
 *
 * <p>
 * 视频来访者记录 前端控制器
 * </p>
 */
@Tag(name = "视频来访者记录接口", description = "视频来访者记录管理接口")
@RestController
@RequestMapping("admin/vod/video/visitor")
@CrossOrigin
public class VideoVisitorController
{
    @Autowired
    private VideoVisitorService videoVisitorService;

    /**
     * 显示课程统计数据
     *
     * @param courseId  课程 id
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "显示课程统计数据", description = "显示课程统计数据")
    @GetMapping("find/count/{courseId}/{startDate}/{endDate}")
    public Result<Map<String, Object>> showChart(
            @Parameter(name = "courseId", description = "课程ID") @PathVariable("courseId") Long courseId,
            @Parameter(name = "startDate", description = "开始时间") @PathVariable("startDate") String startDate,
            @Parameter(name = "endDate", description = "结束时间") @PathVariable("endDate") String endDate)
    {
        Map<String, Object> countMap = videoVisitorService.findCount(courseId, startDate, endDate);

        return Result.ok(countMap);
    }
}
```

##### 2.3、编写 Service 和实现

**VideoVisitorService 和 VideoVisitorServiceImpl。**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.VideoVisitor;
import com.myxh.smart.planet.vo.vod.VideoVisitorCountVo;
import com.myxh.smart.planet.vod.mapper.VideoVisitorMapper;
import com.myxh.smart.planet.vod.service.VideoVisitorService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author MYXH
 * @date 2023/10/10
 *
 *
 * <p>
 * 视频来访者记录 服务实现类
 * </p>
 */
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor> implements VideoVisitorService
{
    /**
     * 显示课程统计数据
     *
     * @param courseId  课程 id
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return countMap 课程统计数据
     */
    @Override
    public Map<String, Object> findCount(Long courseId, String startDate, String endDate)
    {
        // 调用 mapper 的方法
        List<VideoVisitorCountVo> videoVisitorVoList = baseMapper.findCount(courseId, startDate, endDate);

        // 创建 countMap 集合
        Map<String, Object> countMap = new HashMap<>();

        // 创建两个 list 集合，一个代表所有日期，一个代表日期对应数量
        // 代表所有日期
        List<String> dateList = videoVisitorVoList.stream().map(VideoVisitorCountVo::getJoinTime)
                .collect(Collectors.toList());

        // 代表日期对应数量
        List<Integer> countList = videoVisitorVoList.stream().map(VideoVisitorCountVo::getUserCount)
                .collect(Collectors.toList());

        // 放到 countMap 集合
        countMap.put("xData", dateList);
        countMap.put("yData", countList);

        return countMap;
    }
}
```

##### 2.4、编写 Mapper

**（1）VideoVisitorMapper**

```java
package com.myxh.smart.planet.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxh.smart.planet.model.vod.VideoVisitor;
import com.myxh.smart.planet.vo.vod.VideoVisitorCountVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/10
 *
 * <p>
 * 视频来访者记录 Mapper 接口
 * </p>
 */
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor>
{
    /**
     * 显示课程统计数据
     *
     * @param courseId  课程 id
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return countMap 课程统计数据
     */
    List<VideoVisitorCountVo> findCount(
            @Param("courseId") Long courseId,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate);
}
```

**（2）VideoVisitorMapper.xml 文件。**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.myxh.smart.planet.vod.mapper.VideoVisitorMapper">
    <select id="findCount" resultType="com.myxh.smart.planet.vo.vod.VideoVisitorCountVo">
        SELECT
        DATE(join_time) AS joinTime,
        COUNT(*) AS userCount
        FROM video_visitor
        <where>
            <if test="startDate != null and startDate != ''">
                AND DATE(join_time) &gt;= #{startDate}
            </if>
            <if test="endDate != null and endDate != ''">
                AND DATE(join_time) &lt;= #{endDate}
            </if>
            AND course_id=#{courseId}
        </where>
        GROUP BY DATE(join_time)
        ORDER BY DATE(join_time)
    </select>
</mapper>
```

#### 3、课程统计前端

##### 3.1、定义接口

**创建 videoVisitor.js 定义接口。**

```javascript
import request from "@/utils/request";

const VIDEO_VISITOR_API = "/admin/vod/video/visitor";

export default {
  /**
   * 显示课程统计数据
   *
   * @param {number} courseId  课程 id
   * @param {String} startDate 开始时间
   * @param {String} endDate   结束时间
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findCount(courseId, startDate, endDate) {
    return request({
      url: `${VIDEO_VISITOR_API}/find/count/${courseId}/${startDate}/${endDate}`,
      method: "get",
    });
  },
};
```

##### 3.2、安装 ECharts 组件

ECharts 是百度的一个项目，后来百度把 Echart 捐给 apache，用于图表展示，提供了常规的[折线/面积图](https://echarts.apache.org/zh/option.html#series-line)、[散点（气泡）图](https://echarts.apache.org/zh/option.html#series-scatter)、[饼图](https://echarts.apache.org/zh/option.html#series-pie)、[K 线图](https://echarts.apache.org/zh/option.html#series-candlestick)，用于统计的[箱形图](https://echarts.apache.org/zh/option.html#series-boxplot)，用于地理数据可视化的[地图](https://echarts.apache.org/zh/option.html#series-map)、[热力图](https://echarts.apache.org/zh/option.html#series-heatmap)、[路径图](https://echarts.apache.org/zh/option.html#series-lines)，用于关系数据可视化的[关系图](https://echarts.apache.org/zh/option.html#series-graph)、[Treemap](https://echarts.apache.org/zh/option.html#series-treemap)、[旭日图](https://echarts.apache.org/zh/option.html#series-sunburst)，多维数据可视化的[平行坐标图](https://echarts.apache.org/zh/option.html#series-parallel)，还有用于 BI 的[漏斗图](https://echarts.apache.org/zh/option.html#series-funnel)，[仪表盘](https://echarts.apache.org/zh/option.html#series-gauge)，并且支持图与图之间的混搭。

官方网站：https://echarts.apache.org/zh/index.html

```shell
npm install --save echarts@5.4.3
```

##### 3.3、编写页面

**创建 chart.vue 页面。**

![编写页面](https://img-blog.csdnimg.cn/6d84dd39e6cf45a3bb81057586443217.png)

```html
<template>
  <div class="app-container">
    <!-- 表单 -->
    <el-form :inline="true" class="demo-form-inline">
      <el-form-item>
        <el-date-picker
          v-model="startDate"
          type="date"
          placeholder="选择开始日期"
          value-format="yyyy-MM-dd"
        />
      </el-form-item>
      <el-form-item>
        <el-date-picker
          v-model="endDate"
          type="date"
          placeholder="选择截止日期"
          value-format="yyyy-MM-dd"
        />
      </el-form-item>
      <el-button
        :disabled="btnDisabled"
        type="primary"
        icon="el-icon-search"
        @click="showChart()"
        >查询</el-button
      >
    </el-form>
    <div id="chart" class="chart" style="height: 500px" />
  </div>
</template>

<script>
  import * as echarts from "echarts";
  import videoVisitorAPI from "@/api/vod/videoVisitor";

  export default {
    data() {
      return {
        courseId: "",
        startDate: "",
        endDate: "",
        btnDisabled: false,
      };
    },

    created() {
      this.courseId = this.$route.params.id;

      // 初始化最近十天数据
      let currentDate = new Date();
      this.startDate = this.dateFormat(
        new Date(currentDate.getTime() - 7 * 24 * 3600 * 1000)
      );

      this.endDate = this.dateFormat(currentDate);
      this.showChart();
    },

    methods: {
      showChart() {
        videoVisitorAPI
          .findCount(this.courseId, this.startDate, this.endDate)
          .then((response) => {
            this.setChartData(response.data);
          });
      },

      setChartData(data) {
        // 基于准备好的 dom，初始化 echarts 实例
        let myChart = echarts.init(document.getElementById("chart"));

        // 指定图表的配置项和数据
        let option = {
          title: {
            text: "观看课程人数统计",
          },

          xAxis: {
            data: data.xData,
          },

          yAxis: {
            minInterval: 1,
          },

          series: [
            {
              type: "line",
              data: data.yData,
            },
          ],
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
      },

      dateFormat(date) {
        let fmt = "YYYY-mm-dd";
        let ret;

        const opt = {
          // 年
          "Y+": date.getFullYear().toString(),
          // 月
          "m+": (date.getMonth() + 1).toString(),
          // 日
          "d+": date.getDate().toString(),
          // 时
          "H+": date.getHours().toString(),
          // 分
          "M+": date.getMinutes().toString(),
          // 秒
          "S+": date.getSeconds().toString(),
          // 有其他格式化字符需求可以继续添加，必须转化成字符串
        };

        for (let k in opt) {
          ret = new RegExp("(" + k + ")").exec(fmt);

          if (ret) {
            fmt = fmt.replace(
              ret[1],
              ret[1].length == 1 ? opt[k] : opt[k].padStart(ret[1].length, "0")
            );
          }
        }

        return fmt;
      },
    },
  };
</script>
```

### 二、整合腾讯云点播

#### 1、功能需求介绍

##### 1.1、上传视频

在发布课程时候，需要添加课时并且上传课程视频，这个时候需要使用到腾讯云点播服务进行上传视频管理。

![上传视频](https://img-blog.csdnimg.cn/2e29cbceb0c44ab3955d1bafc70049c7.png)

##### 1.2、删除视频

（1）添加小节，上传课程视频。

（2）删除小节时候，需要删除视频。

（3）删除章节时候，需要删除章节，小节和视频。

（4）删除课程时候，需要删除课程，章节，小节和视频。

##### 1.3、视频播放（后续完成）

#### 2、腾讯云点播介绍

腾讯云点播（Video on Demand，VOD）基于腾讯多年技术积累与基础设施建设，为有音视频应用相关需求的客户提供包括音视频存储管理、音视频转码处理、音视频加速播放和音视频通信服务的一站式解决方案。

![腾讯云点播介绍](https://img-blog.csdnimg.cn/609975881d7940bfb9764ad4d61683b8.png)

文档中心：https://cloud.tencent.com/document/product/266

##### 2.1、开通"云点播"服务

![开通"云点播"服务](https://img-blog.csdnimg.cn/09e8336ccc2842899c16191321f7243c.png)

##### 2.2、管理控制台

![管理控制台](https://img-blog.csdnimg.cn/7f9d4687b7fd4d1f895d97ffc088843f.png)

##### 2.3、上传视频

上传视频可将视频上传到云点播的存储中，以进行后续的处理和分发等。

- 单击左侧菜单栏【媒资管理 > 视频管理】，默认展示【已上传】标签页；

- 点击【上传视频】按钮；

- 单击【选择视频】，选择本地视频文件；

- 单击【开始上传】；

- 页面将自动跳转至【正在上传】标签页， 本地文件所在行【状态】栏为“上传成功”时，单击【已上传】标签页，可见完成上传的视频；

  ![上传视频](https://img-blog.csdnimg.cn/3b188601f03e4afcb0087688b55b7ab3.png)

- 单击【管理】，可以查看视频详情。

  ![上传视频](https://img-blog.csdnimg.cn/9c906506d38c48c4940780835b752262.png)

##### 2.4、前端集成

前端集成有两种方式，使用“超级播放器预览”与“web 播放器预览”，后者代码已经不更新，推荐使用前者，因此“web 播放器预览”仅做了解。

1、查看“web 播放器预览”。

![前端集成](https://img-blog.csdnimg.cn/cce012db4a284551aa9c4831655b1e19.png)

说明：需要将视频进行转码，才能支持超级播放器播放，转码为：自适应码流。

2、查看“任务流设置”。

![前端集成](https://img-blog.csdnimg.cn/4c99cd26b491489ab8dd828ca7845f1c.png)

3、查看详情。

![前端集成](https://img-blog.csdnimg.cn/e71698845c0f407fae3df4d35d91989e.png)

当前任务流就是系统默认的“自适应码流”任务流。

4、在【音视频管理】重新上传视频。

![前端集成](https://img-blog.csdnimg.cn/42cb8593045147ffa6938c158df56a7b.png)

5、查看详情。

![前端集成](https://img-blog.csdnimg.cn/eca9af345d034cd787fd87f2e896ef8e.png)

6、复制代码 index.html 到项目，即可播放。

#### 3、编写视频点播接口

##### 3.1、创建相关类

![创建相关类](https://img-blog.csdnimg.cn/81e35b2c07bd460fa76075d7d2973847.png)

##### 3.2、引入相关依赖

**（1）在 service-vod 模块引入。**

```xml
<!-- 腾讯云点播（Video on Demand，VOD） -->
<dependency>
    <groupId>com.qcloud</groupId>
    <artifactId>vod_api</artifactId>
    <version>2.1.5</version>
    <exclusions>
        <exclusion>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

##### 3.3、编写 Controller

**（1）上传视频集成方案：** https://cloud.tencent.com/document/product/266/10276

![编写 Controller](https://img-blog.csdnimg.cn/3deed185b68a4d0e99b6dd6deb5752f9.png)

**（2）删除视频。**

可在线生成代码。

地址：https://console.cloud.tencent.com/api/explorer?Product=vod&Version=2018-07-17&Action=DeleteMedia

![编写 Controller](https://img-blog.csdnimg.cn/a3e4481908064251ae7a5c06de93a56d.png)

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.VodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author MYXH
 * @date 2023/10/11
 */
@Tag(name = "腾讯云点播接口", description = "腾讯云点播接口")
@RestController
@RequestMapping("/admin/vod")
@CrossOrigin
public class VodController
{
    @Autowired
    private VodService vodService;

    /**
     * 上传视频
     *
     * @param file 文件
     * @return videoId 视频 id
     * @throws IOException IO 异常
     */
    @Operation(summary = "上传", description = "上传视频")
    @PostMapping(value = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Result<String> uploadVideo(@Parameter(name = "file", description = "文件", required = true)
                                      @RequestParam("file") MultipartFile file) throws IOException
    {
        InputStream inputStream = file.getInputStream();
        String originalFilename = file.getOriginalFilename();
        String videoId = vodService.uploadVideo(inputStream, originalFilename);

        return Result.ok(videoId);
    }

    /**
     * 删除视频
     *
     * @param videoSourceId 视频源 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除", description = "删除视频")
    @DeleteMapping("remove/{videoSourceId}")
    public Result<Void> removeVideo(@Parameter(name = "videoSourceId", description = "视频源 id", required = true)
                                    @PathVariable("videoSourceId") String videoSourceId)
    {
        vodService.removeVideo(videoSourceId);

        return Result.ok(null);
    }
}
```

##### 3.4、编写 Service

**（1）VodService 定义方法。**

```java
package com.myxh.smart.planet.vod.service;

import java.io.InputStream;

/**
 * @author MYXH
 * @date 2023/10/11
 */
public interface VodService
{
    /**
     * 上传视频
     *
     * @param inputStream 输入流
     * @param originalFilename 原始文件名
     * @return videoId 视频 id
     */
    String uploadVideo(InputStream inputStream, String originalFilename);

    /**
     * 删除视频
     *
     * @param videoSourceId 视频源 id
     */
    void removeVideo(String videoSourceId);
}
```

**（2）VodServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.vod.service.VodService;
import com.myxh.smart.planet.vod.utils.ConstantPropertiesUtil;
import com.qcloud.vod.VodUploadClient;
import com.qcloud.vod.model.VodUploadRequest;
import com.qcloud.vod.model.VodUploadResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.vod.v20180717.VodClient;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaRequest;
import com.tencentcloudapi.vod.v20180717.models.DeleteMediaResponse;
import org.apache.ibatis.javassist.LoaderClassPath;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @author MYXH
 * @date 2023/10/11
 */
@Service
public class VodServiceImpl implements VodService
{
    /**
     * 上传视频
     *
     * @param inputStream      输入流
     * @param originalFilename 原始文件名
     * @return videoId 视频 id
     */
    @Override
    public String uploadVideo(InputStream inputStream, String originalFilename)
    {
        try
        {
            // 指定当前腾讯云账号 id 和 密码
            VodUploadClient client = new VodUploadClient(ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);

            // 视频上传请求对象
            VodUploadRequest request = new VodUploadRequest();

            // 指定要上传的文件
            String path = LoaderClassPath.class.getResource("/video/Java 零基础入门.mp4").getPath();

            // 设置视频文件的本地路径
            request.setMediaFilePath(path);

            // 指定任务流
            request.setProcedure("LongVideoPreset");

            // 调用上传方法，传入接入点地域及上传请求
            VodUploadResponse response = client.upload("ap-beijing", request);

            // 返回文件 id 保存到业务表，用于控制视频播放
            String fileId = response.getFileId();
            System.out.println("fileId = " + fileId);

            return fileId;
        }
        catch (Exception e)
        {
            throw new SmartPlanetException(20001, "上传视频失败");
        }
    }

    /**
     * 删除视频
     *
     * @param videoSourceId 视频源 id
     */
    @Override
    public void removeVideo(String videoSourceId)
    {
        try
        {
            // 实例化一个认证对象，入参需要传入腾讯云账户 secretId，secretKey
            Credential cred = new Credential(ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);

            // 实例化要请求产品的 client 对象，clientProfile 是可选的
            VodClient client = new VodClient(cred, "ap-beijing");

            // 实例化一个请求对象，每个接口都会对应一个 request 对象
            DeleteMediaRequest req = new DeleteMediaRequest();
            req.setFileId(videoSourceId);

            // 返回的 resp 是一个 DeleteMediaResponse 的实例，与请求对象对应
            DeleteMediaResponse resp = client.DeleteMedia(req);

            // 输出 json 格式的字符串回包
            System.out.println("DeleteMediaResponse.toJsonString(resp) = " + DeleteMediaResponse.toJsonString(resp));
        }
        catch (TencentCloudSDKException e)
        {
            throw new SmartPlanetException(20001, "删除视频失败");

        }
    }
}
```

#### 4、完善上传视频功能

##### 4.1、定义接口

**创建 vod.js 定义接口。**

```javascript
import request from "@/utils/request";

const VOD_API = "/admin/vod";

export default {
  /**
   * 删除视频
   *
   * @param {number} id 视频源 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeByVodId(id) {
    return request({
      url: `${VOD_API}/remove/${id}`,
      method: "delete",
    });
  },
};
```

##### 4.1、添加上传视频

**（1）修改 video/form.vue 页面。**

![添加上传视频](https://img-blog.csdnimg.cn/8811cef9db0a4334bedc1301fa91cb5b.png)

```html
<template>
  <!-- 添加和修改课时表单 -->
  <el-dialog :visible="dialogVisible" title="添加课时" @close="close()">
    <el-form :model="video" label-width="120px">
      <el-form-item label="课时标题">
        <el-input v-model="video.title" />
      </el-form-item>
      <el-form-item label="课时排序">
        <el-input-number v-model="video.sort" :min="0" />
      </el-form-item>
      <el-form-item label="是否免费">
        <el-radio-group v-model="video.isFree">
          <el-radio :label="0">收费</el-radio>
          <el-radio :label="1">免费</el-radio>
        </el-radio-group>
      </el-form-item>

      <!-- 上传视频 -->
      <el-form-item label="上传视频">
        <el-upload
          ref="upload"
          action="#"
          :http-request="uploadVideo"
          :limit="1"
          :on-remove="handleRemove"
          :on-change="handleChange"
          :auto-upload="false"
        >
          <el-button
            :visible="!uploading"
            slot="trigger"
            size="small"
            type="primary"
            >选择视频</el-button
          >
          <el-button
            :visible="!uploading"
            style="margin-left: 40px"
            size="small"
            type="success"
            @click="submitUpload()"
            >点击上传</el-button
          >
          <el-progress
            class="progress"
            :text-inside="true"
            :stroke-width="18"
            :percentage="progress"
            status="exception"
          ></el-progress>
          <div slot="tip" class="el-upload__tip">
            只能上传 MP4 文件，且不超过 500MB
          </div>
        </el-upload>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button :visible="!uploading" @click="close()">取 消</el-button>
      <el-button :visible="!uploading" type="primary" @click="saveOrUpdate()"
        >确 定</el-button
      >
    </div>
  </el-dialog>
</template>

<script>
  import TcVod from "vod-js-sdk-v6";
  import request from "@/utils/request";

  import videoAPI from "@/api/vod/video";
  // import vodAPI from "@/api/vod/vod";

  export default {
    data() {
      return {
        BASE_API: "http://localhost:8301",
        dialogVisible: false,
        uploading: false,

        video: {
          sort: 0,
          free: false,
        },

        // 上传文件列表
        fileList: [],

        // 进度条百分比
        progress: 0,

        // 图片原名称和 id
        filename: "",
        fileId: "",

        // 上传成功后的地址
        videoURL: "",
      };
    },

    methods: {
      open(chapterId, videoId) {
        this.dialogVisible = true;
        this.video.chapterId = chapterId;

        if (videoId) {
          videoAPI.getById(videoId).then((response) => {
            this.video = response.data;
            // 回显
            if (this.video.videoOriginalName) {
              this.fileList = [{ name: this.video.videoOriginalName }];
            }
          });
        }
      },

      close() {
        this.dialogVisible = false;

        // 重置表单
        this.resetForm();
      },

      resetForm() {
        this.video = {
          sort: 0,
          free: false,
        };

        // 重置视频上传列表
        this.fileList = [];
      },

      saveOrUpdate() {
        this.dialogVisible = true;

        if (!this.video.title) {
          this.$message.error("请输入课时标题");
          this.dialogVisible = false;

          return;
        }

        if (!this.video.id) {
          this.save();
        } else {
          this.update();
        }
      },

      save() {
        this.video.courseId = this.$parent.$parent.courseId;
        videoAPI.save(this.video).then((response) => {
          this.$message.success(response.message);
          // 关闭组件
          this.close();

          // 刷新列表
          this.$parent.fetchNodeList();
        });
      },

      update() {
        videoAPI.updateById(this.video).then((response) => {
          this.$message.success(response.message);
          // 关闭组件
          this.close();

          // 刷新列表
          this.$parent.fetchNodeList();
        });
      },

      // 处理上传超出一个视频
      handleUploadExceed(files, fileList) {
        this.$message.warning("想要重新上传视频，请先删除已上传的视频");
      },

      // 获取签名，这里的签名请求是由后端提供的，只需要拿到后端给的签名请求即可
      getVodSignature() {
        const url = this.BASE_API + "/admin/vod/sign";
        return request.get(url).then(function (response) {
          return response.data;
        });
      },

      // 文件列表改变时，将文件列表保存到本地
      handleChange(file, fileList) {
        this.fileList = fileList;
        this.filename = this.fileList[0].raw.name;
      },

      // 上传
      submitUpload() {
        if (this.fileList.length === 0) {
          this.$message.warning("请先选择视频，再进行上传");

          return;
        }

        if (this.uploading) {
          // 如果正在上传中，则直接返回，不执行上传逻辑
          return;
        }

        // 设置上传中状态
        this.uploading = true;

        this.uploadVideo();
      },

      // 自定义上传
      uploadVideo() {
        console.log(this.fileList[0].raw);

        if (this.fileList.length === 0) {
          window.alert("您还没有选取文件");
        } else {
          //必须以函数的形式返回，sdk 参数限制
          const getSignature = async () => {
            const data = await this.getVodSignature();

            return data;
          };

          const tcVod = new TcVod({
            // 获取上传签名的函数
            getSignature: getSignature,
          });

          // 获取通过 element-ui 上传到本地的文件，因为参数类型必须为 file，不能直接以对象的形式传输
          const mediaFile = this.fileList[0].raw;

          const uploader = tcVod.upload({
            mediaFile: mediaFile,
          });

          // 监听上传进度
          uploader.on("media_progress", (info) => {
            this.progress = parseInt(info.percent * 100);
          });

          // 上传结束时，将 url 存到本地
          uploader.done().then((doneResult) => {
            // 保存地址
            this.video.videoSourceId = doneResult.fileId;
            this.video.videoOriginalName = this.filename;

            // 将视频的第一帧保存为封面
            const canvas = document.createElement("canvas");
            const img = document.getElementById("video_img");
            const video = document.getElementById("video");
            video.setAttribute("crossOrigin", "anonymous");
            canvas.width = video.clientWidth;
            canvas.height = video.clientHeight;

            video.onloadeddata = (res) => {
              canvas
                .getContext("2d")
                .drawImage(video, 0, 0, canvas.width, canvas.height);
              const dataURL = canvas.toDataURL("image/png");
              img.setAttribute("src", dataURL);

              // 拿到 base64 的字符串，并保存到本地
              this.imgBase = dataURL.split(",")[1];
            };

            // 设置上传完成状态
            this.uploading = false;
          });
        }
      },

      // 点击删除时
      handleRemove(file, fileList) {
        console.log(file, fileList.length);
      },
    },
  };
</script>
```

#### 5、最终使用腾讯云客户端方式上传视频

##### 5.1、客户端上传视频

![客户端上传视频](https://img-blog.csdnimg.cn/3eb52ebc662542e3885623d54c5ae145.png)

##### 5.2、操作步骤一（申请上传签名）

###### 5.2.1、找到 Java 签名示例

![找到 Java 签名示例](https://img-blog.csdnimg.cn/01625a3101e6429f8281b3e76defdeab.png)

![找到 Java 签名示例](https://img-blog.csdnimg.cn/d899de91f276489fa7fec18674172d06.png)

###### 5.2.2、VodController 编写签名接口

**Signature 类。**

```java
package com.myxh.smart.planet.vod.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author MYXH
 * @date 2023/10/11
 * @description 签名工具类
 */
public class Signature
{
    private String secretId;
    private String secretKey;
    private long currentTime;
    private int random;
    private int signValidDuration;

    private String procedure;

    // 签名算法
    private static final String HMAC_ALGORITHM = "HmacSHA1";
    private static final String CONTENT_CHARSET = "UTF-8";

    public static byte[] byteMerger(byte[] byte1, byte[] byte2)
    {
        byte[] byte3 = new byte[byte1.length + byte2.length];
        System.arraycopy(byte1, 0, byte3, 0, byte1.length);
        System.arraycopy(byte2, 0, byte3, byte1.length, byte2.length);

        return byte3;
    }

    // 获取签名
    public String getUploadSignature() throws Exception
    {
        String strSign = "";
        String contextStr = "";

        // 生成原始参数字符串
        long endTime = (currentTime + signValidDuration);
        contextStr += "secretId=" + java.net.URLEncoder.encode(secretId, StandardCharsets.UTF_8);
        contextStr += "&currentTimeStamp=" + currentTime;
        contextStr += "&expireTime=" + endTime;
        contextStr += "&random=" + random;

        // 设置转码任务流
        contextStr += "&procedure=" + procedure;

        try
        {
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            SecretKeySpec secretKey = new SecretKeySpec(this.secretKey.getBytes(CONTENT_CHARSET), mac.getAlgorithm());
            mac.init(secretKey);

            byte[] hash = mac.doFinal(contextStr.getBytes(CONTENT_CHARSET));
            byte[] sigBuf = byteMerger(hash, contextStr.getBytes(StandardCharsets.UTF_8));
            strSign = base64Encode(sigBuf);
            strSign = strSign.replace(" ", "").replace("\n", "").replace("\r", "");
        }
        catch (Exception e)
        {
            throw e;
        }
        return strSign;
    }

    private String base64Encode(byte[] buffer)
    {
        Base64.Encoder encoder = Base64.getEncoder();

        return encoder.encodeToString(buffer);
    }

    public void setSecretId(String secretId)
    {
        this.secretId = secretId;
    }

    public void setSecretKey(String secretKey)
    {
        this.secretKey = secretKey;
    }

    public void setCurrentTime(long currentTime)
    {
        this.currentTime = currentTime;
    }

    public void setRandom(int random)
    {
        this.random = random;
    }

    public void setSignValidDuration(int signValidDuration)
    {
        this.signValidDuration = signValidDuration;
    }

    public void setProcedure(String procedure)
    {
        this.procedure = procedure;
    }
}
```

**VodController 类。**

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.VodService;
import com.myxh.smart.planet.vod.utils.ConstantPropertiesUtil;
import com.myxh.smart.planet.vod.utils.Signature;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author MYXH
 * @date 2023/10/11
 */
@Tag(name = "腾讯云点播接口", description = "腾讯云点播接口")
@RestController
@RequestMapping("/admin/vod")
@CrossOrigin
public class VodController
{
    @Autowired
    private VodService vodService;

    /**
     * 获取客户端上传视频签名
     *
     * @return signature 视频签名
     */
    @Operation(summary = "视频签名", description = "获取客户端上传视频签名")
    @GetMapping("sign")
    public Result<String> sign()
    {
        Signature sign = new Signature();

        // 设置 App 的云 API 密钥
        sign.setSecretId(ConstantPropertiesUtil.ACCESS_KEY_ID);
        sign.setSecretKey(ConstantPropertiesUtil.ACCESS_KEY_SECRET);
        sign.setCurrentTime(System.currentTimeMillis() / 1000);
        sign.setRandom(new Random().nextInt(java.lang.Integer.MAX_VALUE));

        // 签名有效期：2天
        sign.setSignValidDuration(3600 * 24 * 2);

        // 设置转码任务流
        sign.setProcedure("LongVideoPreset");

        try
        {
            String signature = sign.getUploadSignature();
            System.out.println("signature = " + signature);

            return Result.ok(signature);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new SmartPlanetException(20001, "获取签名失败");
        }
    }
}
```

##### 5.3、操作步骤二（SDK 上传）

![操作步骤二（SDK 上传）](https://img-blog.csdnimg.cn/111362d610a34cb588805eb9917152c4.png)

###### 5.3.1、下载 Demo 源码修改

![下载 Demo 源码修改](https://img-blog.csdnimg.cn/ed58db4e049547618054c313bbe7848a.png)

###### 5.3.2、下载腾讯云 Web 端上传 SDK

```shell
npm install --save vod-js-sdk-v6
```

###### 5.3.3、video/form.vue 页面

```html
<template>
  <!-- 添加和修改课时表单 -->
  <el-dialog :visible="dialogVisible" title="添加课时" @close="close()">
    <el-form :model="video" label-width="120px">
      <el-form-item label="课时标题">
        <el-input v-model="video.title" />
      </el-form-item>
      <el-form-item label="课时排序">
        <el-input-number v-model="video.sort" :min="0" />
      </el-form-item>
      <el-form-item label="是否免费">
        <el-radio-group v-model="video.isFree">
          <el-radio :label="0">收费</el-radio>
          <el-radio :label="1">免费</el-radio>
        </el-radio-group>
      </el-form-item>

      <!-- 上传视频 -->
      <el-form-item label="上传视频">
        <el-upload
          ref="upload"
          action="#"
          :http-request="uploadVideo"
          :limit="1"
          :on-remove="handleRemove"
          :on-change="handleChange"
          :auto-upload="false"
        >
          <el-button
            :visible="!uploading"
            slot="trigger"
            size="small"
            type="primary"
            >选择视频</el-button
          >
          <el-button
            :visible="!uploading"
            style="margin-left: 40px"
            size="small"
            type="success"
            @click="submitUpload()"
            >点击上传</el-button
          >
          <el-progress
            class="progress"
            :text-inside="true"
            :stroke-width="18"
            :percentage="progress"
            status="exception"
          ></el-progress>
          <div slot="tip" class="el-upload__tip">
            只能上传 MP4 文件，且不超过 500MB
          </div>
        </el-upload>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button :visible="!uploading" @click="close()">取 消</el-button>
      <el-button :visible="!uploading" type="primary" @click="saveOrUpdate()"
        >确 定</el-button
      >
    </div>
  </el-dialog>
</template>

<script>
  import TcVod from "vod-js-sdk-v6";
  import request from "@/utils/request";

  import videoAPI from "@/api/vod/video";
  // import vodAPI from "@/api/vod/vod";

  export default {
    data() {
      return {
        BASE_API: "http://localhost:8301",
        dialogVisible: false,
        uploading: false,

        video: {
          sort: 0,
          free: false,
        },

        // 上传文件列表
        fileList: [],

        // 进度条百分比
        progress: 0,

        // 图片原名称和 id
        filename: "",
        fileId: "",

        // 上传成功后的地址
        videoURL: "",
      };
    },

    methods: {
      open(chapterId, videoId) {
        this.dialogVisible = true;
        this.video.chapterId = chapterId;

        if (videoId) {
          videoAPI.getById(videoId).then((response) => {
            this.video = response.data;
            // 回显
            if (this.video.videoOriginalName) {
              this.fileList = [{ name: this.video.videoOriginalName }];
            }
          });
        }
      },

      close() {
        this.dialogVisible = false;

        // 重置表单
        this.resetForm();
      },

      resetForm() {
        this.video = {
          sort: 0,
          free: false,
        };

        // 重置视频上传列表
        this.fileList = [];
      },

      saveOrUpdate() {
        this.dialogVisible = true;

        if (!this.video.title) {
          this.$message.error("请输入课时标题");
          this.dialogVisible = false;

          return;
        }

        if (!this.video.id) {
          this.save();
        } else {
          this.update();
        }
      },

      save() {
        this.video.courseId = this.$parent.$parent.courseId;
        videoAPI.save(this.video).then((response) => {
          this.$message.success(response.message);
          // 关闭组件
          this.close();

          // 刷新列表
          this.$parent.fetchNodeList();
        });
      },

      update() {
        videoAPI.updateById(this.video).then((response) => {
          this.$message.success(response.message);
          // 关闭组件
          this.close();

          // 刷新列表
          this.$parent.fetchNodeList();
        });
      },

      // 处理上传超出一个视频
      handleUploadExceed(files, fileList) {
        this.$message.warning("想要重新上传视频，请先删除已上传的视频");
      },

      // 获取签名，这里的签名请求是由后端提供的，只需要拿到后端给的签名请求即可
      getVodSignature() {
        const url = this.BASE_API + "/admin/vod/sign";
        return request.get(url).then(function (response) {
          return response.data;
        });
      },

      // 文件列表改变时，将文件列表保存到本地
      handleChange(file, fileList) {
        this.fileList = fileList;
        this.filename = this.fileList[0].raw.name;
      },

      // 上传
      submitUpload() {
        if (this.fileList.length === 0) {
          this.$message.warning("请先选择视频，再进行上传");

          return;
        }

        if (this.uploading) {
          // 如果正在上传中，则直接返回，不执行上传逻辑
          return;
        }

        // 设置上传中状态
        this.uploading = true;

        this.uploadVideo();
      },

      // 自定义上传
      uploadVideo() {
        console.log(this.fileList[0].raw);

        if (this.fileList.length === 0) {
          window.alert("您还没有选取文件");
        } else {
          //必须以函数的形式返回，sdk 参数限制
          const getSignature = async () => {
            const data = await this.getVodSignature();

            return data;
          };

          const tcVod = new TcVod({
            // 获取上传签名的函数
            getSignature: getSignature,
          });

          // 获取通过 element-ui 上传到本地的文件，因为参数类型必须为 file，不能直接以对象的形式传输
          const mediaFile = this.fileList[0].raw;

          const uploader = tcVod.upload({
            mediaFile: mediaFile,
          });

          // 监听上传进度
          uploader.on("media_progress", (info) => {
            this.progress = parseInt(info.percent * 100);
          });

          // 上传结束时，将 url 存到本地
          uploader.done().then((doneResult) => {
            // 保存地址
            this.video.videoSourceId = doneResult.fileId;
            this.video.videoOriginalName = this.filename;

            // 将视频的第一帧保存为封面
            const canvas = document.createElement("canvas");
            const img = document.getElementById("video_img");
            const video = document.getElementById("video");
            video.setAttribute("crossOrigin", "anonymous");
            canvas.width = video.clientWidth;
            canvas.height = video.clientHeight;

            video.onloadeddata = (res) => {
              canvas
                .getContext("2d")
                .drawImage(video, 0, 0, canvas.width, canvas.height);
              const dataURL = canvas.toDataURL("image/png");
              img.setAttribute("src", dataURL);

              // 拿到 base64 的字符串，并保存到本地
              this.imgBase = dataURL.split(",")[1];
            };

            // 设置上传完成状态
            this.uploading = false;
          });
        }
      },

      // 点击删除时
      handleRemove(file, fileList) {
        console.log(file, fileList.length);
      },
    },
  };
</script>
```

#### 6、完善删除视频功能

##### 6.1、修改 VideoController 方法

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Video;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程视频 前端控制器
 * </p>
 */
@Tag(name = "课程视频小节接口", description = "课程视频小节管理接口")
@RestController
@RequestMapping("/admin/vod/video")
@CrossOrigin
public class VideoController
{
    @Autowired
    private VideoService videoService;

    /**
     * 获取课程视频小节
     *
     * @param id 课程视频小节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取课程视频小节", description = "获取课程视频小节")
    @GetMapping("get/{id}")
    public Result<Video> get(@Parameter(name = "id", description = "课程视频小节ID", required = true)
                             @PathVariable("id") Long id)
    {
        Video video = videoService.getById(id);

        return Result.ok(video);
    }

    /**
     * 新增课程视频小节
     *
     * @param video 课程视频小节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "新增课程视频小节", description = "新增课程视频小节")
    @PostMapping("save")
    public Result<Void> save(@RequestBody Video video)
    {
        videoService.save(video);

        return Result.ok(null);
    }

    /**
     * 修改课程视频小节
     *
     * @param video 课程视频小节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改课程视频小节", description = "修改课程视频小节")
    @PostMapping("update")
    public Result<Void> update(@RequestBody Video video)
    {
        videoService.updateVideoById(video);

        return Result.ok(null);
    }

    /**
     * 删除课程视频小节
     *
     * @param id 课程视频小节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除课程视频小节", description = "删除课程视频小节")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@Parameter(name = "id", description = "课程视频小节ID", required = true)
                               @PathVariable("id") Long id)
    {
        videoService.removeVideoById(id);

        return Result.ok(null);
    }
}
```

##### 6.2、修改 VideoService 方法

**修改 VideoService 和 VideoServiceImpl。**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Video;
import com.myxh.smart.planet.vod.mapper.VideoMapper;
import com.myxh.smart.planet.vod.service.VideoService;
import com.myxh.smart.planet.vod.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程视频 服务实现类
 * </p>
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService
{
    // 注入 VodService
    @Autowired
    private VodService vodService;

    /**
     * 根据课程 id，删除课程视频小节，同时删除视频
     *
     * @param id 课程 id
     */
    @Override
    public void removeVideoByCourseId(Long id)
    {
        // 1、根据课程 id，删除小节中的视频
        // 获取课程里面所有小节
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        List<Video> videoList = baseMapper.selectList(wrapper);

        // 遍历获取每个小节中的视频源 id
        for (Video video : videoList)
        {
            String videoSourceId = video.getVideoSourceId();

            // 如果视频源 id 不为空，调用方法删除
            if (!ObjectUtils.isEmpty(videoSourceId))
            {
                vodService.removeVideo(videoSourceId);
            }
        }

        // 2、根据课程 id，删除小节
        baseMapper.delete(wrapper);
    }

    /**
     * 根据章节 id，删除课程视频小节，同时删除视频
     *
     * @param id 章节 id
     */
    public void removeVideoByChapterId(Long id)
    {
        // 1、根据章节 id，删除小节中的视频
        // 获取章节里的所有小节
        QueryWrapper<Video> wrapper = new QueryWrapper<>();
        wrapper.eq("chapter_id", id);
        List<Video> videoList = baseMapper.selectList(wrapper);

        // 遍历获取每个小节中的视频源 id
        for (Video video : videoList)
        {
            String videoSourceId = video.getVideoSourceId();

            // 如果视频源 id 不为空，调用方法删除
            if (!ObjectUtils.isEmpty(videoSourceId))
            {
                vodService.removeVideo(videoSourceId);
            }
        }

        // 2、根据课程 id，删除小节
        baseMapper.delete(wrapper);
    }

    /**
     * 根据课程视频小节 id，删除课程视频小节，同时删除视频
     *
     * @param id 课程视频小节 id
     */
    @Override
    public void removeVideoById(Long id)
    {
        // 1、根据课程视频小节 id，删除视频
        // 获取课程视频小节
        Video video = baseMapper.selectById(id);

        // 获取视频源 id
        String videoSourceId = video.getVideoSourceId();

        // 如果视频源 id 不为空，调用方法删除
        if (!ObjectUtils.isEmpty(videoSourceId))
        {
            vodService.removeVideo(videoSourceId);
        }

        // 2、根据课程视频小节 id，删除小节
        baseMapper.deleteById(id);
    }

    /**
     * 根据课程视频小节 id，修改课程视频小节
     *
     * @param video 课程视频小节数据
     */
    @Override
    public void updateVideoById(Video video)
    {
        Video oldVideo = baseMapper.selectById(video.getId());

        // 如果新的视频源 id 与旧的不相等
        if (!ObjectUtils.isEmpty(oldVideo.getVideoSourceId()) && !oldVideo.getVideoSourceId().equals(video.getVideoSourceId()))
        {
            // 先删除旧视频
            vodService.removeVideo(oldVideo.getVideoSourceId());
        }

        // 再更新课程视频小节
        baseMapper.updateById(video);
    }
}
```

##### 6.3 修改 ChapterController 方法

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Chapter;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.ChapterVo;
import com.myxh.smart.planet.vod.service.ChapterService;
import com.myxh.smart.planet.vod.service.VideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 章节 前端控制器
 * </p>
 */
@Tag(name = "章节接口", description = "章节管理接口")
@RestController
@RequestMapping("/admin/vod/chapter")
@CrossOrigin
public class ChapterController
{
    @Autowired
    private ChapterService chapterService;

    @Autowired
    private VideoService videoService;

    /**
     * 大纲列表，获取章节和小节列表
     *
     * @param courseId 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "大纲列表", description = "获取获取章节和小节列表")
    @GetMapping("get/nested/tree/list/{courseId}")
    public Result<List<ChapterVo>> getNestedTreeList(@Parameter(name = "courseId", description = "课程ID", required = true)
                                                     @PathVariable("courseId") Long courseId)
    {
        List<ChapterVo> chapterVoList = chapterService.getNestedTreeList(courseId);

        return Result.ok(chapterVoList);
    }

    /**
     * 添加章节
     *
     * @param chapter 章节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加章节", description = "添加章节")
    @PostMapping("save")
    public Result<Void> saveChapter(@RequestBody Chapter chapter)
    {
        chapterService.save(chapter);

        return Result.ok(null);
    }

    /**
     * 根据 id 查询章节
     *
     * @param id 章节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询章节", description = "根据 id 查询章节")
    @GetMapping("get/{id}")
    public Result<Chapter> getChapter(@Parameter(name = "id", description = "章节ID", required = true)
                                      @PathVariable("id") Long id)
    {
        Chapter chapter = chapterService.getById(id);

        return Result.ok(chapter);
    }

    /**
     * 修改章节
     *
     * @param chapter 章节数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改章节", description = "修改章节")
    @PostMapping("update")
    public Result<Void> updateChapter(@RequestBody Chapter chapter)
    {
        chapterService.updateById(chapter);

        return Result.ok(null);
    }

    /**
     * 根据 id 删除章节
     *
     * @param id 章节 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除章节", description = "根据 id 删除章节")
    @DeleteMapping("remove/{id}")
    public Result<Void> removeChapter(@Parameter(name = "id", description = "章节ID", required = true)
                                      @PathVariable("id") Long id)
    {
        // 1、根据章节 id，删除课程视频小节，同时删除视频
        videoService.removeVideoByChapterId(id);

        // 2、根据 id，删除章节
        chapterService.removeById(id);

        return Result.ok(null);
    }
}
```

##### 6.4 修改 ChapterService 方法

**修改 ChapterService 和 ChapterServiceImpl。**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Chapter;
import com.myxh.smart.planet.model.vod.Video;
import com.myxh.smart.planet.vo.vod.ChapterVo;
import com.myxh.smart.planet.vo.vod.VideoVo;
import com.myxh.smart.planet.vod.mapper.ChapterMapper;
import com.myxh.smart.planet.vod.service.ChapterService;
import com.myxh.smart.planet.vod.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 章节 服务实现类
 * </p>
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService
{
    @Autowired
    private VideoService videoService;

    /**
     * 大纲列表，获取章节和小节列表
     *
     * @param courseId 课程 id
     * @return chapterVoList 章节和小节列表
     */
    @Override
    public List<ChapterVo> getNestedTreeList(Long courseId)
    {
        // 定义章节和小节列表 List 集合
        List<ChapterVo> chapterVoList = new ArrayList<>();

        // 根据 courseId 获取课程里面所有章节
        QueryWrapper<Chapter> chapterQueryWrapper = new QueryWrapper<>();
        chapterQueryWrapper.eq("course_id", courseId);
        List<Chapter> chapterList = baseMapper.selectList(chapterQueryWrapper);

        // 根据 courseId 获取课程里面所有小节
        LambdaQueryWrapper<Video> videoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        videoLambdaQueryWrapper.eq(Video::getCourseId, courseId);
        videoLambdaQueryWrapper.orderByAsc(Video::getSort, Video::getId);
        List<Video> videoList = videoService.list(videoLambdaQueryWrapper);

        // 封装章节
        // 遍历所有的章节
        for (Chapter chapter : chapterList)
        {
            // 创建 ChapterVo 对象
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            chapterVoList.add(chapterVo);

            // 封装章节里面的小节
            // 创建 List 集合用来封装章节所有小节
            List<VideoVo> videoVoList = new ArrayList<>();

            // 遍历小节 List
            for (Video video : videoList)
            {
                // 判断小节是哪个章节下面
                if (chapter.getId().equals(video.getChapterId()))
                {
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    videoVoList.add(videoVo);
                }
            }

            // 把章节里面所有小节集合放到每个章节里面
            chapterVo.setChildren(videoVoList);
        }

        return chapterVoList;
    }

    /**
     * 根据课程 id 删除章节
     *
     * @param id 课程 id
     */
    @Override
    public void removeChapterByCourseId(Long id)
    {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        baseMapper.delete(wrapper);
    }
}
```

##### 6.5 修改 CourseController 方法

```java
package com.myxh.smart.planet.vod.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.CourseFormVo;
import com.myxh.smart.planet.vo.vod.CoursePublishVo;
import com.myxh.smart.planet.vo.vod.CourseQueryVo;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 前端控制器
 * </p>
 */
@Tag(name = "课程接口", description = "课程管理接口")
@RestController
@RequestMapping("/admin/vod/course")
@CrossOrigin
public class CourseController
{
    @Autowired
    private CourseService courseService;

    /**
     * 点播课程列表
     *
     * @param current       当前页码
     * @param limit         每页记录数
     * @param courseQueryVo 查询对象
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取点播课程", description = "获取点播课程列表")
    @GetMapping("find/query/page/{current}/{limit}")
    public Result<Map<String, Object>> courseList(@Parameter(name = "current", description = "当前页码", required = true) @PathVariable("current") Long current,
                                                  @Parameter(name = "limit", description = "每页记录数", required = true) @PathVariable("limit") Long limit,
                                                  @Parameter(name = "courseQueryVo", description = "查询对象") CourseQueryVo courseQueryVo)
    {
        Page<Course> coursePageParam = new Page<>(current, limit);
        Map<String, Object> coursePage = courseService.findPage(coursePageParam, courseQueryVo);

        return Result.ok(coursePage);
    }

    /**
     * 添加课程基本信息
     *
     * @param courseFormVo 课程基本信息
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加课程基本信息", description = "添加课程基本信息")
    @PostMapping("save")
    public Result<Long> saveCourseInfo(@RequestBody CourseFormVo courseFormVo)
    {
        Long courseId = courseService.saveCourseInfo(courseFormVo);

        return Result.ok(courseId);
    }

    /**
     * 根据 id 获取课程信息
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据 id 获取课程信息", description = "根据 id 获取课程信息")
    @GetMapping("get/{id}")
    public Result<CourseFormVo> get(@PathVariable("id") Long id)
    {
        CourseFormVo courseFormVo = courseService.getCourseInfoById(id);

        return Result.ok(courseFormVo);
    }

    /**
     * 根据 id 修改课程信息
     *
     * @param courseFormVo 课程基本信息
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据 id 修改课程信息", description = "根据 id 修改课程信息")
    @PostMapping("update")
    public Result<Long> updateCourse(@RequestBody CourseFormVo courseFormVo)
    {
        Long courseId = courseService.updateCourseById(courseFormVo);

        return Result.ok(courseId);
    }

    /**
     * 根据课程 id 查询课程发布信息
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据课程 id 查询课程发布信息", description = "根据课程 id 查询课程发布信息")
    @GetMapping("get/course/publish/vo/{id}")
    public Result<CoursePublishVo> getCoursePublishVoById(@Parameter(name = "id", description = "课程ID", required = true)
                                                          @PathVariable Long id)
    {
        CoursePublishVo coursePublishVo = courseService.getCoursePublishVo(id);

        return Result.ok(coursePublishVo);
    }

    /**
     * 根据课程 id 最终发布课程
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据课程 id 最终发布课程", description = "根据课程 id 最终发布课程")
    @PutMapping("publish/course/{id}")
    public Result<Void> publishCourseById(@Parameter(name = "id", description = "课程ID", required = true)
                                          @PathVariable Long id)
    {
        courseService.publishCourse(id);

        return Result.ok(null);
    }

    /**
     * 删除课程
     *
     * @param id 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除课程", description = "删除课程")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@Parameter(name = "id", description = "课程ID", required = true)
                               @PathVariable Long id)
    {
        courseService.removeCourseById(id);

        return Result.ok(null);
    }
}
```

##### 6.6 修改 CourseService 方法

**修改 CourseService 和 CourseServiceImpl。**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.model.vod.CourseDescription;
import com.myxh.smart.planet.model.vod.Subject;
import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.vo.vod.CourseFormVo;
import com.myxh.smart.planet.vo.vod.CoursePublishVo;
import com.myxh.smart.planet.vo.vod.CourseQueryVo;
import com.myxh.smart.planet.vod.mapper.CourseMapper;
import com.myxh.smart.planet.vod.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务实现类
 * </p>
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService
{
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private VideoService videoService;

    /**
     * 点播课程列表
     *
     * @param coursePageParam 课程页面参数
     * @param courseQueryVo   查询对象
     * @return coursePage 课程页面
     */
    @Override
    public Map<String, Object> findPage(Page<Course> coursePageParam, CourseQueryVo courseQueryVo)
    {
        // 获取条件值
        // 名称
        String title = courseQueryVo.getTitle();

        // 二级分类
        Long subjectId = courseQueryVo.getSubjectId();

        // 一级分类
        Long subjectParentId = courseQueryVo.getSubjectParentId();

        // 教师
        Long teacherId = courseQueryVo.getTeacherId();

        // 封装条件
        QueryWrapper<Course> wrapper = new QueryWrapper<>();

        if (StringUtils.hasLength(title))
        {
            wrapper.like("title", title);
        }
        if (!ObjectUtils.isEmpty(subjectId))
        {
            wrapper.eq("subject_id", subjectId);
        }
        if (!ObjectUtils.isEmpty(subjectParentId))
        {
            wrapper.eq("subject_parent_id", subjectParentId);
        }
        if (!ObjectUtils.isEmpty(teacherId))
        {
            wrapper.eq("teacher_id", teacherId);
        }

        // 调用方法实现条件查询分页
        Page<Course> coursePage = baseMapper.selectPage(coursePageParam, wrapper);

        // 总记录数
        Long totalCount = coursePage.getTotal();

        // 总页数
        Long totalPage = coursePage.getPages();

        // 每页数据集合
        List<Course> coursePageRecords = coursePage.getRecords();

        // 遍历封装教师和分类名称，获取 id 对应名称，进行封装，最终显示
        coursePageRecords.stream().forEach(this::getTeacherOrSubjectName);

        // 封装返回数据
        Map<String, Object> coursePageMap = new HashMap<>();
        coursePageMap.put("totalCount", totalCount);
        coursePageMap.put("totalPage", totalPage);
        coursePageMap.put("records", coursePageRecords);

        return coursePageMap;
    }

    /**
     * 获取教师和分类名称
     *
     * @param course 课程数据
     * @return course 课程数据
     */
    private Course getTeacherOrSubjectName(Course course)
    {
        // 根据教师 id 获取教师名称
        Teacher teacher = teacherService.getById(course.getTeacherId());

        if (teacher != null)
        {
            course.getParam().put("teacherName", teacher.getName());
        }

        // 根据课程分类 id 获取课程分类名称
        Subject subjectOne = subjectService.getById(course.getSubjectParentId());

        if (subjectOne != null)
        {
            course.getParam().put("subjectParentTitle", subjectOne.getTitle());
        }

        Subject subjectTwo = subjectService.getById(course.getSubjectId());

        if (subjectTwo != null)
        {
            course.getParam().put("subjectTitle", subjectTwo.getTitle());
        }

        return course;
    }

    /**
     * 添加课程基本信息
     *
     * @param courseFormVo 课程基本信息
     * @return courseId 课程 id
     */
    @Override
    public Long saveCourseInfo(CourseFormVo courseFormVo)
    {
        // 添加课程基本信息，操作 course 表
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.insert(course);

        // 添加课程详情信息，操作 course_description 表
        CourseDescription courseDescription = new CourseDescription();
        courseDescription.setDescription(courseFormVo.getDescription());

        // 设置课程 id
        courseDescription.setCourseId(course.getId());
        courseDescriptionService.save(courseDescription);

        // 返回课程 id
        return course.getId();
    }

    /**
     * 根据 id 获取课程信息
     *
     * @param id 课程 id
     * @return CourseFormVo 课程基本信息
     */
    @Override
    public CourseFormVo getCourseInfoById(Long id)
    {
        // 从 course 表中获取课程基本信息
        Course course = baseMapper.selectById(id);

        if (course == null)
        {
            return null;
        }

        //从 course_description 表中获取课程描述信息
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", id);
        CourseDescription courseDescription = courseDescriptionService.getOne(wrapper);

        // 封装描述信息，创建 CourseFormVo 对象
        CourseFormVo courseFormVo = new CourseFormVo();
        BeanUtils.copyProperties(course, courseFormVo);

        if (courseDescription != null)
        {
            courseFormVo.setDescription(courseDescription.getDescription());
        }

        return courseFormVo;
    }

    /**
     * 根据 id 修改课程信息
     *
     * @param courseFormVo 课程基本信息
     * @return courseId 课程 id
     */
    @Override
    public Long updateCourseById(CourseFormVo courseFormVo)
    {
        // 修改课程基本信息
        Course course = new Course();
        BeanUtils.copyProperties(courseFormVo, course);
        baseMapper.updateById(course);

        // 修改课程详情信息
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", course.getId());
        CourseDescription courseDescription = courseDescriptionService.getOne(wrapper);
        courseDescription.setDescription(courseFormVo.getDescription());

        // 设置课程描述 id
        courseDescription.setCourseId(course.getId());
        courseDescriptionService.updateById(courseDescription);

        // 返回课程 id
        return course.getId();
    }

    /**
     * 根据课程 id 查询课程发布信息
     *
     * @param id 课程 id
     * @return coursePublishVo 课程发布信息
     */
    @Override
    public CoursePublishVo getCoursePublishVo(Long id)
    {
        return baseMapper.selectCoursePublishVoById(id);
    }

    /**
     * 根据课程 id 最终发布课程
     *
     * @param id 课程 id
     */
    @Override
    public void publishCourse(Long id)
    {
        Course course = baseMapper.selectById(id);

        // 已经发布课程
        course.setStatus(1);
        course.setPublishTime(new Date());
        baseMapper.updateById(course);
    }

    /**
     * 删除课程
     *
     * @param id 课程 id
     */
    @Override
    public void removeCourseById(Long id)
    {
        // 根据课程 id 删除小节
        videoService.removeVideoByCourseId(id);

        // 根据课程 id 删除章节
        chapterService.removeChapterByCourseId(id);

        // 根据课程 id 删除描述
        courseDescriptionService.removeByCourseId(id);

        // 根据课程 id 删除课程
        baseMapper.deleteById(id);
    }
}
```

## Day 10-整合网关与实现订单和营销管理模块

### 一、Spring Cloud 相关概念

#### 1、基本概念

##### 1.1、什么是 Spring Cloud

Spring Cloud 是一系列框架的集合。它利用 Spring Boot 的开发便利性简化了分布式系统基础设施的开发，如服务发现、服务注册、配置中心、消息总线、负载均衡、 熔断器、数据监控等，都可以用 Spring Boot 的开发风格做到一键启动和部署。Spring 并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过 SpringBoot 风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。

##### 1.2、Spring Cloud 和 Spring Boot 关系

Spring Boot 是 Spring 的一套快速配置脚手架，可以基于 Spring Boot 快速开发单个微服务，Spring Cloud 是一个基于 Spring Boot 实现的开发工具；Spring Boot 专注于快速、方便集成的单个微服务个体，Spring Cloud 关注全局的服务治理框架； Spring Boot 使用了默认大于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置，Spring Cloud 很大的一部分是基于 Spring Boot 来实现，必须基于 Spring Boot 开发。可以单独使用 Spring Boot 开发项目，但是 Spring Cloud 离不开 Spring Boot。

#### 2、Spring Cloud 相关基础服务组件

服务发现——Netflix Eureka （Nacos）。

服务调用——Netflix Feign。

熔断器——Netflix Hystrix。

服务网关——Spring Cloud GateWay。

分布式配置——Spring Cloud Config （Nacos）。

消息总线 —— Spring Cloud Bus （Nacos）。

### 二、搭建 Nacos 服务

#### 1、Nacos 概述

##### 1.1、基本概念

​Nacos 是阿里巴巴推出来的一个新开源项目，是一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。Nacos 致力于帮助您发现、配置和管理微服务。Nacos 提供了一组简单易用的特性集，帮助您快速实现动态服务发现、服务配置、服务元数据及流量管理。Nacos 帮助您更敏捷和容易地构建、交付和管理微服务平台。 Nacos 是构建以“服务”为中心的现代应用架构 (例如微服务范式、云原生范式) 的服务基础设施。

##### 1.2、常见的注册中心

（1）Eureka（原生，2.0 遇到性能瓶颈，停止维护）。

（2）Zookeeper（支持，专业的独立产品。例如：dubbo）。

（3）Consul（原生，GO 语言开发）。

（4） Nacos。

- 相对于 Spring Cloud Eureka 来说，Nacos 更强大。Nacos = Spring Cloud Eureka + Spring Cloud Config。

- Nacos 可以与 Spring, Spring Boot, Spring Cloud 集成，并能代替 Spring Cloud Eureka, Spring Cloud Config。

- 通过 Nacos Server 和 spring-cloud-starter-alibaba-nacos-discovery 实现服务的注册与发现。

##### 1.3、Nacos 结构图

![Nacos 结构图](https://img-blog.csdnimg.cn/3ceb715248c245598e7ca673fa6df66c.png)

#### 2、Nacos 下载和安装

##### 2.1、下载地址和版本

下载地址：https://github.com/alibaba/nacos/releases

下载版本：nacos-server-2.2.3.tar.gz 或 nacos-server-2.2.3.zip，解压任意目录即可。

##### 2.2、启动 nacos 服务

**（1） Linux/Unix/Mac**

启动命令(standalone 代表着单机模式运行，非集群模式)。

启动命令：sh startup.sh -m standalone

**（2）Windows**

启动方式，cmd 打开，执行命令： startup.cmd -m standalone

访问：http://localhost:8848/nacos

用户名/密码：nacos/nacos

**（3）登录界面。**

![登录界面](https://img-blog.csdnimg.cn/c93fa06650d7458e9222f6a4add8be1b.png)

**（4）主界面。**

![主界面](https://img-blog.csdnimg.cn/38388629cc514088bdd35a399b578be2.png)

#### 3、服务注册

把 service-vod 微服务注册到注册中心，其他模块注册步骤相同。

##### 3.1、在 service 模块配置 pom

配置 Nacos 客户端的 pom 依赖。

```xml
<!-- alibaba-nacos-discovery 服务注册 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>

<!-- openfeign 服务调用 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

<!-- alibaba-sentinel 流量控制 -->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
</dependency>
```

##### 3.2、配置 service-vod

配置 application.properties，在客户端微服务中添加注册 Nacos 服务的配置信息。

```properties
# nacos 服务地址
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
```

##### 3.3、添加 Nacos 客户端注解

在 service-vod 微服务启动类中添加注解。

```java
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
```

##### 3.4、启动客户端微服务

启动注册中心。

启动已注册的微服务，可以在 Nacos 服务列表中看到被注册的微服务。

![启动客户端微服务](https://img-blog.csdnimg.cn/b920525b4729496eb505e58adc5409a7.png)

### 三、整合 Spring Cloud GateWay 网关

#### 1、网关基本概念

##### 1.1、Gateway 概述

**Spring cloud gateway**是 spring 官方基于 Spring 5.0、Spring Boot2.0 和 Project Reactor 等技术开发的网关，Spring Cloud Gateway 旨在为微服务架构提供简单、有效和统一的 API 路由管理方式，Spring Cloud Gateway 作为 Spring Cloud 生态系统中的网关，目标是替代 Netflix Zuul，其不仅提供统一的路由方式，并且还基于 Filter 链的方式提供了网关基本的功能，例如：安全、监控/埋点、限流等。

![Gateway 概述](https://img-blog.csdnimg.cn/8a5e3db2ada549c285135f28a6461763.png)

##### 1.2、Gateway 核心概念

网关提供 API 全托管服务，丰富的 API 管理功能，辅助企业管理大规模的 API，以降低管理成本和安全风险，包括协议适配、协议转发、安全策略、防刷、流量、监控日志等贡呢。一般来说网关对外暴露的 URL 或者接口信息，统称为路由信息。如果研发过网关中间件或者使用过 Zuul 的人，会知道网关的核心是 Filter 以及 Filter Chain（Filter 责任链）。Sprig Cloud Gateway 也具有路由和 Filter 的概念。下面介绍一下 Spring Cloud Gateway 中几个重要的概念。

**（1）路由：** 路由是网关最基础的部分，路由信息有一个 ID、一个目的 URL、一组断言和一组 Filter 组成。如果断言路由为真，则说明请求的 URL 和配置匹配。

**（2）断言：** Java8 中的断言函数。Spring Cloud Gateway 中的断言函数输入类型是 Spring5.0 框架中的 ServerWebExchange。Spring Cloud Gateway 中的断言函数允许开发者去定义匹配来自于 http request 中的任何信息，比如请求头和参数等。

**（3）过滤器：** 一个标准的 Spring webFilter。Spring cloud gateway 中的 filter 分为两种类型的 Filter，分别是 Gateway Filter 和 Global Filter。过滤器 Filter 将会对请求和响应进行修改处理。

![Gateway 核心概念](https://img-blog.csdnimg.cn/d5cd5ca09e59416d8f9396ad41cae2f7.png)

如图所示，Spring cloud Gateway 发出请求。然后再由 Gateway Handler Mapping 中找到与请求相匹配的路由，将其发送到 Gateway web handler。Handler 再通过指定的过滤器链将请求发送到实际的服务执行业务逻辑，然后返回。

#### 2、实现网关转发功能

##### 2.1、创建网关模块

**（1）在 SmartPlanet 下创建 service-gateway。**

![创建网关模块](https://img-blog.csdnimg.cn/20eb84d20c7b4193ad9f334b88ef5736.png)

##### 2.2、引入网关依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.myxh.smart.planet</groupId>
        <artifactId>SmartPlanet</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>service-gateway</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- service-utils -->
        <dependency>
            <groupId>com.myxh.smart.planet</groupId>
            <artifactId>service-utils</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>

        <!-- alibaba-nacos-discovery 服务注册 -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>

        <!-- gateway 网关 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-gateway</artifactId>
        </dependency>

        <!-- 负载平衡 loadbalancer -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-loadbalancer</artifactId>
        </dependency>
    </dependencies>
</project>
```

##### 2.3、创建启动类

```java
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
```

##### 2.4、配置路由规则

**（1）编写 application.properties。**

```properties
# 服务端口
server.port=8333

# 服务名
spring.application.name=service-gateway

# nacos 服务地址
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848

# 使用服务发现路由
spring.cloud.gateway.discovery.locator.enabled=true

# service-vod 模块配置
# 设置路由 id
spring.cloud.gateway.routes[0].id=service-vod
# 设置路由的 uri，lb 全称为 Load Balance 负载平衡
spring.cloud.gateway.routes[0].uri=lb://service-vod
# 设置路由断言,代理 servicerId 为 auth-service 的 /auth/ 路径，/admin/vod/teacher
spring.cloud.gateway.routes[0].predicates= Path=/*/vod/**
```

#### 3、网关解决跨域问题

##### 3.1、跨域概述

跨域本质是浏览器对于 ajax 请求的一种安全限制：一个页面发起的 ajax 请求，只能是与当前页域名相同的路径，这能有效的阻止跨站攻击。因此：跨域问题 是针对 ajax 的一种限制。但是这却给开发带来了不便，而且在实际生产环境中，肯定会有很多台服务器之间交互，地址和端口都可能不同。

之前通过服务器添加注解实现，现在跨域通过网关来解决跨域问题。

##### 3.2、创建配置类

![创建配置类](https://img-blog.csdnimg.cn/f90c0701dd1441e9b02423b4770760dc.png)

```java
package com.myxh.smart.planet.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @author MYXH
 * @date 2023/10/14
 */
@Configuration
public class CorsConfig
{
    /**
     * 处理跨域
     *
     * @return CorsWebFilter(source) 核心 Web 过滤器
     */
    @Bean
    public CorsWebFilter corsFilter()
    {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*");
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
```

**注意：** 目前已经在网关做了跨域处理，那么 service 服务就不需要再做跨域处理了，将之前在 controller 类上添加过@CrossOrigin 标签的去掉。

#### 4、修改前端配置文件

##### 4.1、修改接口为网关地址

![修改接口为网关地址](https://img-blog.csdnimg.cn/cc9aed6bcdba411088a7411aee783249.png)

### 四、后台管理系统-订单管理模块

#### 1、环境准备

##### 1.1、创建数据库表

![创建数据库表](https://img-blog.csdnimg.cn/5f8377774e264ecfa11abb7b314c4219.png)

##### 1.2、创建订单模块

**（1）service 模块下创建 service-order 模块。**

![创建订单模块](https://img-blog.csdnimg.cn/aacc22eca33b4da1ac3f55855526754d.png)

![创建订单模块](https://img-blog.csdnimg.cn/112ee2d4c65e410eaf803573cf5c12d5.png)

##### 1.3、生成订单相关代码

![生成订单相关代码](https://img-blog.csdnimg.cn/e9cf376a41574902845d6012b735ae58.png)

##### 1.4、创建启动类

```java
package com.myxh.smart.planet.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MYXH
 * @date 2023/10/14
 */
@SpringBootApplication
public class ServiceOrderApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }
}
```

##### 1.5、创建配置文件

```properties
# 服务端口
server.port=8302

# 服务名
spring.application.name=service-order

# 环境设置：dev、test、prod
spring.profiles.active=dev

# MySQL 数据库连接
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/smart_planet_order?characterEncoding=utf-8&useSSL=false
spring.datasource.username=MYXH
spring.datasource.password=520.ILY!

# 返回 Json 的全局时间格式
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8

# MyBatis 日志
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

# 设置 mapper.xml 的路径
mybatis-plus.mapper-locations=classpath:com/myxh/smart/planet/order/mapper/xml/*.xml
```

##### 1.6、创建配置类

```java
package com.myxh.smart.planet.order.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MYXH
 * @date 2023/10/14
 * @description 配置类
 */
@Configuration
@MapperScan("com.myxh.smart.planet.order.mapper")
public class OrderConfig
{
    /**
     * 分页插件
     *
     * @return MyBatis Plus 拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor()
    {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        return interceptor;
    }
}
```

#### 2、开发订单列表接口

##### 2.1、编写 OrderInfoController

```java
package com.myxh.smart.planet.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.model.order.OrderInfo;
import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.order.OrderInfoQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/14
 *
 * <p>
 * 订单信息 前端控制器
 * </p>
 */
@Tag(name = "订单信息管理", description = "订单信息管理接口")
@RestController
@RequestMapping("/admin/order/order/info")
public class OrderInfoController
{
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 条件查询订单分页
     *
     * @param current          当前页码
     * @param limit            每页记录数
     * @param orderInfoQueryVo 查询对象
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "条件查询订单分页", description = "条件查询订单分页")
    @GetMapping("find/query/page/{current}/{limit}")
    public Result<Map<String, Object>> orderInfoList(
            @Parameter(name = "current", description = "当前页码", required = true)
            @PathVariable("current") Long current,
            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable("limit") Long limit,
            @Parameter(name = "orderInfoVo", description = "查询对象")
            OrderInfoQueryVo orderInfoQueryVo)
    {
        // 创建 page 对象
        Page<OrderInfo> orderInfoPageParam = new Page<>(current, limit);
        Map<String, Object> orderInfoPage = orderInfoService.selectOrderInfoPage(orderInfoPageParam, orderInfoQueryVo);

        return Result.ok(orderInfoPage);
    }
}
```

##### 2.2、编写 Service

**（1）OrderInfoService 定义方法。**

```java
package com.myxh.smart.planet.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.order.OrderInfo;
import com.myxh.smart.planet.vo.order.OrderInfoQueryVo;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/14
 *
 * <p>
 * 订单信息 服务类
 * </p>
 */
public interface OrderInfoService extends IService<OrderInfo>
{
    /**
     * 订单信息列表
     *
     * @param orderInfoPageParam 订单信息页面参数
     * @param orderInfoQueryVo 查询对象
     * @return orderInfoPage 订单信息页面
     */
    Map<String, Object> selectOrderInfoPage(Page<OrderInfo> orderInfoPageParam, OrderInfoQueryVo orderInfoQueryVo);
}
```

**（2）OrderInfoServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.order.OrderDetail;
import com.myxh.smart.planet.model.order.OrderInfo;
import com.myxh.smart.planet.order.mapper.OrderInfoMapper;
import com.myxh.smart.planet.order.service.OrderDetailService;
import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.vo.order.OrderInfoQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/14
 *
 * <p>
 * 订单信息 服务实现类
 * </p>
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService
{
    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 订单信息列表
     *
     * @param orderInfoPageParam 订单信息页面参数
     * @param orderInfoQueryVo   查询对象
     * @return orderInfoPage 订单信息页面
     */
    @Override
    public Map<String, Object> selectOrderInfoPage(Page<OrderInfo> orderInfoPageParam, OrderInfoQueryVo orderInfoQueryVo)
    {
        // orderInfoQueryVo 获取查询条件
        Long userId = orderInfoQueryVo.getUserId();
        String outTradeNo = orderInfoQueryVo.getOutTradeNo();
        String phone = orderInfoQueryVo.getPhone();
        String createTimeBegin = orderInfoQueryVo.getCreateTimeBegin();
        String createTimeEnd = orderInfoQueryVo.getCreateTimeEnd();
        Integer orderStatus = orderInfoQueryVo.getOrderStatus();

        // 判断条件值是否为空，不为空，进行条件封装
        QueryWrapper<OrderInfo> wrapper = new QueryWrapper<>();

        if (!ObjectUtils.isEmpty(orderStatus))
        {
            wrapper.eq("order_status", orderStatus);
        }
        if (!ObjectUtils.isEmpty(userId))
        {
            wrapper.eq("user_id", userId);
        }
        if (StringUtils.hasLength(outTradeNo))
        {
            wrapper.eq("out_trade_no", outTradeNo);
        }
        if (StringUtils.hasLength(phone))
        {
            wrapper.eq("phone", phone);
        }
        if (StringUtils.hasLength(createTimeBegin))
        {
            wrapper.ge("create_time", createTimeBegin);
        }
        if (StringUtils.hasLength(createTimeEnd))
        {
            wrapper.le("create_time", createTimeEnd);
        }

        // 调用实现条件分页查询
        Page<OrderInfo> pages = baseMapper.selectPage(orderInfoPageParam, wrapper);
        Long totalCount = pages.getTotal();
        Long pageCount = pages.getPages();
        List<OrderInfo> records = pages.getRecords();

        // 订单里面包含详情内容，封装详情数据，根据订单 id 查询详情
        records.stream().forEach(this::getOrderDetail);

        // 所有需要数据封装 map 集合，最终返回
        Map<String, Object> orderInfoPage = new HashMap<>();
        orderInfoPage.put("total", totalCount);
        orderInfoPage.put("pageCount", pageCount);
        orderInfoPage.put("records", records);

        return orderInfoPage;
    }

    /**
     * 查询订单详情数据
     *
     * @param orderInfo 订单信息
     * @return orderInfo 订单信息
     */
    private OrderInfo getOrderDetail(OrderInfo orderInfo)
    {
        // 订单 id
        Long id = orderInfo.getId();

        // 查询订单详情
        OrderDetail orderDetail = orderDetailService.getById(id);

        if (orderDetail != null)
        {
            String courseName = orderDetail.getCourseName();
            orderInfo.getParam().put("courseName", courseName);
        }

        return orderInfo;
    }
}
```

#### 3、配置网关

##### 3.1、Nacos 注册

**（1）service-order 启动类添加注解。**

```java
package com.myxh.smart.planet.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author MYXH
 * @date 2023/10/14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceOrderApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceOrderApplication.class, args);
    }
}
```

**（2）service-order 配置文件。**

```properties
# 服务端口
server.port=8302

# 服务名
spring.application.name=service-order

# 环境设置：dev、test、prod
spring.profiles.active=dev

# MySQL 数据库连接
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/smart_planet_order?characterEncoding=utf-8&useSSL=false
spring.datasource.username=MYXH
spring.datasource.password=520.ILY!

# 返回 Json 的全局时间格式
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8

# MyBatis 日志
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

# 设置 mapper.xml 的路径
mybatis-plus.mapper-locations=classpath:com/myxh/smart/planet/order/mapper/xml/*.xml

# nacos 服务地址
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
```

##### 3.2、配置路由规则

**（1）service-gateway 配置文件。**

```properties
# service-order 模块配置
# 设置路由 id
spring.cloud.gateway.routes[1].id=service-order
# 设置路由的 uri，lb 全称为 Load Balance 负载平衡
spring.cloud.gateway.routes[1].uri=lb://service-order
# 设置路由断言,代理 servicerId 为 auth-service 的 /auth/ 路径，/admin/order/order/info
spring.cloud.gateway.routes[1].predicates= Path=/*/order/**
```

#### 4、开发订单列表前端

##### 4.1、定义接口

**（1）创建 api/order/orderInfo.js。**

![定义接口](https://img-blog.csdnimg.cn/63e47698cc234ccbaf9763b736a3c6e6.png)

```javascript
import request from "@/utils/request";

const ORDER_INFO_API = "/admin/order/order/info";

export default {
  /**
   * 订单信息列表
   *
   * @param {number} current 当前页码
   * @param {number} limit 每页记录数
   * @param {Object} orderInfoQueryVo 查询对象
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPageList(current, limit, orderInfoQueryVo) {
    return request({
      url: `${ORDER_INFO_API}/find/query/page/${current}/${limit}`,
      method: "get",
      params: orderInfoQueryVo,
    });
  },
};
```

##### 4.2、创建路由

**（1）router/index.js 定义路由。**

```javascript
// 订单管理
{
  path: "/order",
  component: Layout,
  redirect: "/order/order/info/list",
  name: "Order",
  meta: { title: "订单管理", icon: "el-icon-truck" },
  alwaysShow: true,
  children: [
    {
      path: "order/info/list",
      name: "OrderInfo",
      component: () => import("@/views/order/list"),
      meta: { title: "订单列表" },
    },
  ],
},
```

##### 4.3、创建 vue 页面

**（1）创建 views/order/list.vue。**

![创建 vue 页面](https://img-blog.csdnimg.cn/c05dc3f618b34a39985828a42eae6ec9.png)

```html
<template>
  <div class="app-container">
    <el-card class="operate-container" shadow="never">
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="searchObj.outTradeNo" placeholder="订单号" />
        </el-form-item>
        <el-form-item>
          <el-input v-model="searchObj.phone" placeholder="手机" />
        </el-form-item>
        <el-form-item>
          <el-date-picker
            v-model="searchObj.createTimeBegin"
            type="date"
            placeholder="选择下单开始日期"
            value-format="yyyy-MM-dd"
          />
        </el-form-item>
        <el-form-item>
          <el-date-picker
            v-model="searchObj.createTimeEnd"
            type="date"
            placeholder="选择截止日期"
            value-format="yyyy-MM-dd"
          />
        </el-form-item>
        <el-form-item>
          <el-select
            v-model="searchObj.orderStatus"
            placeholder="订单状态"
            class="v-select patient-select"
          >
            <el-option
              v-for="item in statusList"
              :key="item.status"
              :label="item.name"
              :value="item.status"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="fetchData()"
          >查询</el-button
        >
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form>
    </el-card>

    <!-- 列表 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      border
      fit
      highlight-current-row
    >
      <el-table-column label="序号" width="60" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="outTradeNo" label="订单号" width="160" />
      <el-table-column prop="courseName" label="课程名称" width="160">
        <template slot-scope="scope">
          {{ scope.row.param.courseName }}
        </template>
      </el-table-column>
      <el-table-column prop="finalAmount" label="订单金额" width="90" />
      <el-table-column prop="nickName" label="下单用户" />
      <el-table-column prop="phone" label="用户手机" />
      <el-table-column prop="payTime" label="支付时间" width="156" />
      <el-table-column prop="orderStatus" label="订单状态">
        <template slot-scope="scope">
          {{ scope.row.orderStatus == 0 ? "未支付" : "已支付" }}
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="下单时间" width="156" />
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center"
      layout="sizes, prev, pager, next, jumper, ->, total, slot"
      @current-change="fetchData"
      @size-change="changeSize"
    />
  </div>
</template>

<script>
  import orderInfoAPI from "@/api/order/orderInfo";

  export default {
    data() {
      return {
        // 数据是否正在加载
        listLoading: true,

        // banner 列表
        list: null,

        // 数据库中的总记录数
        total: 0,

        // 默认页码
        page: 1,

        // 每页记录数
        limit: 10,

        // 查询表单对象
        searchObj: {},

        statusList: [
          {
            status: 0,
            name: "未支付",
          },
          {
            status: 1,
            name: "已支付",
          },
        ],
      };
    },

    // 生命周期函数：内存准备完毕，页面尚未渲染
    created() {
      this.fetchData();
    },

    // 生命周期函数：内存准备完毕，页面渲染成功
    mounted() {
      console.log("list mounted...");
    },

    methods: {
      // 当页码发生改变的时候
      changeSize(size) {
        this.limit = size;
        this.fetchData(1);
      },

      // 加载 banner 列表数据
      fetchData(page = 1) {
        // 验证开始时间和结束时间的合法性
        if (!this.validateDateRange()) {
          return;
        }

        // 异步获取远程数据（ajax）
        this.page = page;
        orderInfoAPI
          .getPageList(this.page, this.limit, this.searchObj)
          .then((response) => {
            this.list = response.data.records;
            this.total = response.data.total;
            // 数据加载并绑定成功
            this.listLoading = false;
          });
      },

      // 验证开始时间和结束时间的合法性
      validateDateRange() {
        if (
          this.searchObj.createTimeBegin &&
          this.searchObj.createTimeEnd &&
          this.searchObj.createTimeBegin > this.searchObj.createTimeEnd
        ) {
          this.$message.error("开始时间不能晚于结束时间");
          return false;
        }
        return true;
      },

      // 重置查询表单
      resetData() {
        console.log("重置查询表单");
        this.searchObj = {};
        this.fetchData();
      },
    },
  };
</script>
```

### 五、后台管理系统-营销管理模块

#### 1、环境准备

##### 1.1、创建数据库表

![创建数据库表](https://img-blog.csdnimg.cn/68ba4cb8192346d58a83e12585975c8b.png)

##### 1.2、创建营销模块

**（1）service 模块下创建 service-activity 模块。**

![创建营销模块](https://img-blog.csdnimg.cn/055e41e00a72423ba2480fb252299fad.png)

![创建营销模块](https://img-blog.csdnimg.cn/5297012409b6444eb04a000143dc061c.png)

##### 1.3、生成营销相关代码

![生成营销相关代码](https://img-blog.csdnimg.cn/e8472652e2804a8789b0f77b27a84f6e.png)

##### 1.4、创建启动类

```java
package com.myxh.smart.planet.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author MYXH
 * @date 2023/10/15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceActivityApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ServiceActivityApplication.class, args);
    }
}
```

##### 1.5、创建配置文件

```properties
# 服务端口
server.port=8303

# 服务名
spring.application.name=service-activity

# 环境设置：dev、test、prod
spring.profiles.active=dev

# MySQL 数据库连接
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/smart_planet_activity?characterEncoding=utf-8&useSSL=false
spring.datasource.username=MYXH
spring.datasource.password=520.ILY!

# 返回 Json 的全局时间格式
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8

# MyBatis 日志
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

# 设置 mapper.xml 的路径
mybatis-plus.mapper-locations=classpath:com/myxh/smart/planet/activity/mapper/xml/*.xml

# nacos 服务地址
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
```

##### 1.6、创建配置类

```java
package com.myxh.smart.planet.activity.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author MYXH
 * @date 2023/10/15
 * @description 配置类
 */
@Configuration
@MapperScan("com.myxh.smart.planet.activity.mapper")
public class ActivityConfig
{
    /**
     * 分页插件
     *
     * @return MyBatis Plus 拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor()
    {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        return interceptor;
    }
}
```

#### 2、开发优惠券相关接口

##### 2.1、编写 CouponInfoController

```java
package com.myxh.smart.planet.activity.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.activity.service.CouponInfoService;
import com.myxh.smart.planet.model.activity.CouponInfo;
import com.myxh.smart.planet.model.activity.CouponUse;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.activity.CouponUseQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 优惠券信息 前端控制器
 * </p>
 */
@Tag(name = "优惠券信息管理", description = "优惠券信息管理接口")
@RestController
@RequestMapping("/admin/activity/coupon/info")
public class CouponInfoController
{
    @Autowired
    private CouponInfoService couponInfoService;

    /**
     * 条件查询优惠券分页
     *
     * @param current 当前页码
     * @param limit   每页记录数
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "条件查询优惠券分页", description = "条件查询优惠券分页")
    @GetMapping("find/query/page/{current}/{limit}")
    public Result<IPage<CouponInfo>> couponInfoList(
            @Parameter(name = "current", description = "当前页码", required = true) @PathVariable("current") Long current,
            @Parameter(name = "limit", description = "每页记录数", required = true) @PathVariable("limit") Long limit)
    {
        Page<CouponInfo> couponInfoPageParam = new Page<>(current, limit);
        IPage<CouponInfo> couponInfoPageModel = couponInfoService.page(couponInfoPageParam);

        return Result.ok(couponInfoPageModel);
    }

    /**
     * 根据 id 查询优惠券
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询", description = "根据 id 查询优惠券")
    @GetMapping("get/{id}")
    public Result<CouponInfo> get(@PathVariable("id") String id)
    {
        CouponInfo couponInfo = couponInfoService.getById(id);

        return Result.ok(couponInfo);
    }

    /**
     * 添加优惠券
     *
     * @param couponInfo 优惠券数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加", description = "添加优惠券")
    @PostMapping("save")
    public Result<Void> save(@RequestBody CouponInfo couponInfo)
    {
        couponInfoService.save(couponInfo);

        return Result.ok(null);
    }

    /**
     * 修改优惠券
     *
     * @param couponInfo 优惠券数据
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改", description = "修改优惠券")
    @PutMapping("update")
    public Result<Void> updateById(@RequestBody CouponInfo couponInfo)
    {
        couponInfoService.updateById(couponInfo);

        return Result.ok(null);
    }

    /**
     * 逻辑删除优惠券
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除", description = "逻辑删除优惠券")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@PathVariable("id") String id)
    {
        couponInfoService.removeById(id);

        return Result.ok(null);
    }

    /**
     * 批量删除优惠券
     *
     * @param idList id 数组，Json 数组 [1,2,3,...]
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "批量删除", description = "批量删除优惠券")
    @DeleteMapping("remove/batch")
    public Result<Void> batchRemove(@RequestBody List<String> idList)
    {
        couponInfoService.removeByIds(idList);

        return Result.ok(null);
    }

    /**
     * 条件查询已经使用的优惠券分页
     *
     * @param current 当前页码
     * @param limit   每页记录数
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "条件查已经使用的优惠券分页", description = "条件查已经使用的优惠券分页")
    @GetMapping("coupon/use/{current}/{limit}")
    public Result<IPage<CouponUse>> couponUseList(
            @Parameter(name = "current", description = "当前页码", required = true)
            @PathVariable("current") Long current,
            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable("limit") Long limit,
            @Parameter(name = "couponUseVo", description = "查询对象")
            @RequestBody(required = false) CouponUseQueryVo couponUseQueryVo)
    {
        Page<CouponUse> couponUsePageParam = new Page<>(current, limit);
        IPage<CouponUse> couponUsePageModel = couponInfoService.selectCouponUsePage(couponUsePageParam, couponUseQueryVo);

        return Result.ok(couponUsePageModel);
    }
}
```

##### 2.2、编写 Service

**（1）CouponInfoService 定义方法。**

```java
package com.myxh.smart.planet.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.activity.CouponInfo;
import com.myxh.smart.planet.model.activity.CouponUse;
import com.myxh.smart.planet.vo.activity.CouponUseQueryVo;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 优惠券信息 服务类
 * </p>
 */
public interface CouponInfoService extends IService<CouponInfo>
{
    /**
     * 优惠券信息列表
     *
     * @param couponUsePageParam 优惠券使用页面参数
     * @param couponUseQueryVo 查询对象
     * @return couponUsePageModel 优惠券使用页面
     */
    IPage<CouponUse> selectCouponUsePage(Page<CouponUse> couponUsePageParam, CouponUseQueryVo couponUseQueryVo);
}
```

## Day 11-营销管理模块和公众号菜单管理

### 一、优惠券列表接口

#### 1、编写获取用户信息接口

##### 1.1、创建 service-user 模块

**（1）获取优惠券详情时候，需要获取使用者的昵称和手机号，所以使用远程调用实现此功能。**

![创建 service-user 模块](https://img-blog.csdnimg.cn/2e5c845599c143de835655f33107e4e9.png)

![创建 service-user 模块](https://img-blog.csdnimg.cn/89d5c43d62e947ff8a9b7a40cc5b6a4d.png)

##### 1.2、生成相关代码

![生成相关代码](https://img-blog.csdnimg.cn/77ffa85a6d7843aab3795e9a8fa30265.png)

##### 1.3、创建启动类

```java
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
```

##### 1.4、创建配置文件

```properties
# 服务端口
server.port=8304

# 服务名
spring.application.name=service-user

# 环境设置：dev、test、prod
spring.profiles.active=dev

# MySQL 数据库连接
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/smart_planet_user?characterEncoding=utf-8&useSSL=false
spring.datasource.username=MYXH
spring.datasource.password=520.ILY!

# 返回 Json 的全局时间格式
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8

# MyBatis 日志
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

# 设置 mapper.xml 的路径
mybatis-plus.mapper-locations=classpath:com/myxh/smart/planet/user/mapper/xml/*.xml

# nacos 服务地址
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
```

##### 1.5、编写 UserInfocontroller

**实现根据用户 id 获取用户信息接口。**

```java
package com.myxh.smart.planet.user.controller;

import com.myxh.smart.planet.model.user.UserInfo;
import com.myxh.smart.planet.user.service.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 用户信息 前端控制器
 * </p>
 */
@Tag(name = "用户信息管理", description = "用户信息管理接口")
@RestController
@RequestMapping("/admin/user/user/info")
public class UserInfoController
{
    @Autowired
    private UserInfoService userService;

    /**
     * 根据 id 查询用户信息
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询", description = "根据 id 查询用户信息")
    @GetMapping("inner/get/{id}")
    public UserInfo getUserInfoById(@PathVariable("id") Long id)
    {
        UserInfo userInfo = userService.getById(id);

        return userInfo;
    }
}
```

##### 1.6、配置网关

**在网关配置文件配置路径。**

```properties
# service-user 模块配置
# 设置路由 id
spring.cloud.gateway.routes[3].id=service-user
# 设置路由的 uri，lb 全称为 Load Balance 负载平衡
spring.cloud.gateway.routes[3].uri=lb://service-user
# 设置路由断言,代理 servicerId 为 auth-service 的 /auth/ 路径，/admin/user/user/info
spring.cloud.gateway.routes[3].predicates= Path=/*/user/**
```

#### 2、创建模块定义远程接口

##### 2.1、创建模块

**在 SmartPlanet/service-client/service-user-client。**

![创建模块](https://img-blog.csdnimg.cn/752e292664c748ccb4ee9fb138256f3e.png)

##### 2.2、service-client 引入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.myxh.smart.planet</groupId>
        <artifactId>SmartPlanet</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>service-client</artifactId>
    <packaging>pom</packaging>
    <modules>
        <module>service-user-client</module>
    </modules>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- model 数据载体 -->
        <dependency>
            <groupId>com.myxh.smart.planet</groupId>
            <artifactId>model</artifactId>
            <version>0.0.1-SNAPSHOT</version>
            <scope>provided</scope>
        </dependency>

        <!-- service-utils -->
        <dependency>
            <groupId>com.myxh.smart.planet</groupId>
            <artifactId>service-utils</artifactId>
            <version>0.0.1-SNAPSHOT</version>
            <scope>provided</scope>
        </dependency>

        <!-- Web 需要启动项目 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <scope>provided</scope>
        </dependency>

        <!-- openfeign 服务调用 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
            <scope>provided</scope>
        </dependency>
    </dependencies>
</project>
```

##### 2.3、定义远程调用的接口

```java
package com.myxh.smart.planet.client.user;

import com.myxh.smart.planet.model.user.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author MYXH
 * @date 2023/10/15
 */
@FeignClient("service-user")
public interface UserInfoFeignClient
{
    @Operation(summary = "查询", description = "根据 id 查询用户信息")
    @GetMapping("/admin/user/user/info/inner/get/{id}")
    UserInfo getUserInfoById(@PathVariable("id") Long id);
}
```

#### 3、编写 Service 实现方法

##### 3.1、service 引入依赖

```xml
<!-- 负载平衡 loadbalancer -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
</dependency>
```

##### 3.2、service-activity 引入依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.myxh.smart.planet</groupId>
        <artifactId>service</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>service-activity</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- service-user-client -->
        <dependency>
            <groupId>com.myxh.smart.planet</groupId>
            <artifactId>service-user-client</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>

        <!-- mybatis-plus-generator -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.5.3.1</version>
        </dependency>

        <!-- freemarker -->
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>2.3.32</version>
        </dependency>
    </dependencies>
</project>
```

##### 3.2、service-activity 添加注解

```java
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
```

##### 3.3、CouponInfoServiceImpl 实现方法

**远程调用，根据用户 id 获取用户信息。**

```java
package com.myxh.smart.planet.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.activity.mapper.CouponInfoMapper;
import com.myxh.smart.planet.activity.service.CouponInfoService;
import com.myxh.smart.planet.activity.service.CouponUseService;
import com.myxh.smart.planet.client.user.UserInfoFeignClient;
import com.myxh.smart.planet.model.activity.CouponInfo;
import com.myxh.smart.planet.model.activity.CouponUse;
import com.myxh.smart.planet.model.user.UserInfo;
import com.myxh.smart.planet.vo.activity.CouponUseQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 优惠券信息 服务实现类
 * </p>
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService
{
    @Autowired
    private CouponUseService couponUseService;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    /**
     * 优惠券信息列表
     *
     * @param couponUsePageParam 优惠券使用页面参数
     * @param couponUseQueryVo   查询对象
     * @return couponUsePageModel 优惠券使用页面
     */
    @Override
    public IPage<CouponUse> selectCouponUsePage(Page<CouponUse> couponUsePageParam, CouponUseQueryVo couponUseQueryVo)
    {
        // 获取条件
        Long couponId = couponUseQueryVo.getCouponId();
        String couponStatus = couponUseQueryVo.getCouponStatus();
        String getTimeBegin = couponUseQueryVo.getGetTimeBegin();
        String getTimeEnd = couponUseQueryVo.getGetTimeEnd();

        // 封装条件
        QueryWrapper<CouponUse> wrapper = new QueryWrapper<>();

        if (!ObjectUtils.isEmpty(couponId))
        {
            wrapper.eq("coupon_id", couponId);
        }
        if (StringUtils.hasLength(couponStatus))
        {
            wrapper.eq("coupon_status", couponStatus);
        }
        if (StringUtils.hasLength(getTimeBegin))
        {
            wrapper.ge("get_time", getTimeBegin);
        }
        if (StringUtils.hasLength(getTimeEnd))
        {
            wrapper.le("get_time", getTimeEnd);
        }

        // 调用方法查询
        IPage<CouponUse> CouponUsePage = couponUseService.page(couponUsePageParam, wrapper);

        // 封装用户昵称和手机号
        List<CouponUse> couponUseList = CouponUsePage.getRecords();

        // 遍历
        couponUseList.stream().forEach(this::getUserInfoByCouponUse);

        return CouponUsePage;
    }

    /**
     * 封装用户昵称和手机号
     *
     * @param couponUse 优惠券使用数据
     * @return couponUse 优惠券使用数据
     */
    private CouponUse getUserInfoByCouponUse(CouponUse couponUse)
    {
        // 获取用户 id
        Long userId = couponUse.getUserId();

        if (!ObjectUtils.isEmpty(userId))
        {
            // 远程调用
            UserInfo userInfo = userInfoFeignClient.getUserInfoById(userId);

            if (userInfo != null)
            {
                couponUse.getParam().put("nickName", userInfo.getNickName());
                couponUse.getParam().put("phone", userInfo.getPhone());
            }
        }

        return couponUse;
    }
}
```

#### 4、配置网关

##### 4.1、配置路由规则

**（1）service-gateway 配置文件。**

```properties
# service-activity 模块配置
# 设置路由 id
spring.cloud.gateway.routes[2].id=service-activity
# 设置路由的 uri，lb 全称为 Load Balance 负载平衡
spring.cloud.gateway.routes[2].uri=lb://service-activity
# 设置路由断言,代理 servicerId 为 auth-service 的 /auth/ 路径，/admin/activity/coupon/info
spring.cloud.gateway.routes[2].predicates= Path=/*/activity/**
```

#### 5、整合优惠券前端

##### 5.1、定义接口

**（1）创建 api/activity/couponInfo.js。**

![定义接口](https://img-blog.csdnimg.cn/e9ff20a0f43f4b09b3b5b23a32ee5231.png)

```javascript
import request from "@/utils/request";

const COUPON_INFO_API = "/admin/activity/coupon/info";

export default {
  /**
   * 优惠券信息列表
   *
   * @param {number} current 当前页码
   * @param {number} limit 每页记录数
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPageList(current, limit) {
    return request({
      url: `${COUPON_INFO_API}/find/query/page/${current}/${limit}`,
      method: "get",
    });
  },

  /**
   * 根据 id 获取优惠券信息
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getById(id) {
    return request({
      url: `${COUPON_INFO_API}/get/${id}`,
      method: "get",
    });
  },

  /**
   * 添加优惠券信息
   *
   * @param {Object} couponInfo 优惠券信息
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  save(couponInfo) {
    return request({
      url: `${COUPON_INFO_API}/save`,
      method: "post",
      data: couponInfo,
    });
  },

  /**
   * 根据 id 修改优惠券信息
   *
   * @param {Object} couponInfo 优惠券信息
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateById(couponInfo) {
    return request({
      url: `${COUPON_INFO_API}/update`,
      method: "put",
      data: couponInfo,
    });
  },

  /**
   * 删除优惠券信息
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${COUPON_INFO_API}/remove/${id}`,
      method: "delete",
    });
  },

  /**
   * 批量删除优惠券信息
   *
   * @param {Array}idList id 数组，Json 数组 [1,2,3,...]
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeRows(idList) {
    return request({
      url: `${COUPON_INFO_API}/remove/batch`,
      method: "delete",
      data: idList,
    });
  },

  /**
   * 已经使用的优惠券信息列表
   *
   * @param {number} current 当前页码
   * @param {number} limit 每页记录数
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPageCouponUseList(current, limit, searchObj) {
    return request({
      url: `${COUPON_INFO_API}/coupon/use/${current}/${limit}`,
      method: "get",
      params: searchObj,
    });
  },
};
```

##### 5.2、创建路由

**（1）router/index.js 定义路由。**

```javascript
  // 营销活动管理
  {
    path: "/activity",
    component: Layout,
    redirect: "/coupon/info/list",
    name: "Activity",
    meta: { title: "营销活动管理", icon: "el-icon-football" },
    alwaysShow: true,
    children: [
      {
        path: "coupon/info/list",
        name: "CouponInfo",
        component: () => import("@/views/activity/couponInfo/list"),
        meta: { title: "优惠券列表" },
      },
      {
        path: "coupon/info/add",
        name: "CouponInfoAdd",
        component: () => import("@/views/activity/couponInfo/form"),
        meta: { title: "添加优惠券" },
      },
      {
        path: "coupon/info/edit/:id",
        name: "CouponInfoEdit",
        component: () => import("@/views/activity/couponInfo/form"),
        meta: { title: "编辑优惠券", noCache: true },
        hidden: true,
      },
      {
        path: "coupon/info/show/:id",
        name: "CouponInfoShow",
        component: () => import("@/views/activity/couponInfo/show"),
        meta: { title: "优惠券详情", noCache: true },
        hidden: true,
      },
    ],
  },
```

##### 5.3、创建 vue 页面

**（1）创建 views/activity/couponInfo/页面。**

![创建 vue 页面](https://img-blog.csdnimg.cn/9c6d990fbe7d44c397fcdd4efb371e3d.png)

**（2）list.vue**

```html
<template>
  <div class="app-container">
    <!-- 工具条 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" size="mini" @click="add()">添加</el-button>
    </el-card>

    <!-- banner 列表 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="数据正在加载......"
      border
      fit
      highlight-current-row
    >
      <el-table-column label="序号" width="70" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="couponName" label="购物券名称" />
      <el-table-column prop="couponType" label="购物券类型">
        <template slot-scope="scope">
          {{ scope.row.couponType === "1" ? "注册卷" : "推荐赠送卷" }}
        </template>
      </el-table-column>
      <el-table-column label="规则">
        <template slot-scope="scope">
          {{ "现金卷：" + scope.row.amount + "元" }}
        </template>
      </el-table-column>
      <el-table-column label="使用范围 "> 所有商品 </el-table-column>
      <el-table-column prop="publishCount" label="发行数量" />
      <el-table-column prop="expireTime" label="过期时间" />
      <el-table-column prop="createTime" label="创建时间" />
      <el-table-column label="操作" width="150" align="center">
        <template slot-scope="scope">
          <router-link :to="'/activity/coupon/info/edit/' + scope.row.id">
            <el-button size="mini" type="text">修改</el-button>
          </router-link>
          <el-button
            size="mini"
            type="text"
            @click="removeDataById(scope.row.id)"
            >删除</el-button
          >
          <router-link :to="'/activity/coupon/info/show/' + scope.row.id">
            <el-button size="mini" type="text">详情</el-button>
          </router-link>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center"
      layout="sizes, prev, pager, next, jumper, ->, total, slot"
      @current-change="fetchData"
      @size-change="changeSize"
    />
  </div>
</template>

<script>
  import couponInfoAPI from "@/api/activity/couponInfo";

  export default {
    data() {
      return {
        // 数据是否正在加载
        listLoading: true,
        // banner列表
        list: null,
        // 数据库中的总记录数
        total: 0,
        // 默认页码
        page: 1,
        // 每页记录数
        limit: 10,
        // 查询表单对象
        searchObj: {},
        // 批量选择中选择的记录列表
        multipleSelection: [],
      };
    },

    // 生命周期函数：内存准备完毕，页面尚未渲染
    created() {
      console.log("list created...");
      this.fetchData();
    },

    // 生命周期函数：内存准备完毕，页面渲染成功
    mounted() {
      console.log("list mounted...");
    },

    methods: {
      // 当页码发生改变的时候
      changeSize(size) {
        console.log(size);
        this.limit = size;
        this.fetchData(1);
      },

      add() {
        this.$router.push({ path: "/activity/coupon/info/add" });
      },

      // 加载 banner 列表数据
      fetchData(page = 1) {
        console.log("翻页" + page);
        // 异步获取远程数据（ajax）
        this.page = page;

        couponInfoAPI
          .getPageList(this.page, this.limit, this.searchObj)
          .then((response) => {
            this.list = response.data.records;
            this.total = response.data.total;

            // 数据加载并绑定成功
            this.listLoading = false;
          });
      },

      // 重置查询表单
      resetData() {
        console.log("重置查询表单");
        this.searchObj = {};
        this.fetchData();
      },

      // 根据 id 删除数据
      removeDataById(id) {
        // debugger
        this.$confirm("此操作将永久删除该记录, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            // promise
            // 点击确定，远程调用ajax
            return couponInfoAPI.removeById(id);
          })
          .then((response) => {
            this.fetchData(this.page);
            if (response.code) {
              this.$message({
                type: "success",
                message: "删除成功!",
              });
            }
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消删除",
            });
          });
      },
    },
  };
</script>
```

**（3）form.vue**

```html
<template>
  <div class="app-container">
    <el-form label-width="120px">
      <el-form-item label="优惠券名称">
        <el-input v-model="couponInfo.couponName" />
      </el-form-item>
      <el-form-item label="优惠券类型">
        <el-radio-group v-model="couponInfo.couponType">
          <el-radio label="1">注册卷</el-radio>
          <el-radio label="2">推荐购买卷</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="金额">
        <el-input-number v-model="couponInfo.amount" :min="0" />
      </el-form-item>
      <el-form-item label="发行数量">
        <el-input-number v-model="couponInfo.publishCount" :min="0" />
      </el-form-item>
      <el-form-item label="领取时间">
        <el-date-picker
          v-model="couponInfo.startTime"
          type="date"
          placeholder="选择开始日期"
          value-format="yyyy-MM-dd"
        />
        至
        <el-date-picker
          v-model="couponInfo.endTime"
          type="date"
          placeholder="选择结束日期"
          value-format="yyyy-MM-dd"
        />
      </el-form-item>
      <el-form-item label="过期时间">
        <el-date-picker
          v-model="couponInfo.expireTime"
          type="datetime"
          placeholder="选择过期时间"
          value-format="yyyy-MM-dd HH:mm:ss"
        />
      </el-form-item>
      <el-form-item label="直播详情">
        <el-input v-model="couponInfo.ruleDesc" type="textarea" rows="5" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="saveOrUpdate">保存</el-button>
        <el-button @click="back">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import couponInfoAPI from "@/api/activity/couponInfo";

  const defaultForm = {
    id: "",
    couponType: "1",
    couponName: "",
    amount: "0",
    conditionAmount: "0",
    startTime: "",
    endTime: "",
    rangeType: "1",
    ruleDesc: "",
    publishCount: "",
    perLimit: "1",
    useCount: "0",
    receiveCount: "",
    expireTime: "",
    publishStatus: "",
  };

  export default {
    data() {
      return {
        couponInfo: defaultForm,
        saveBtnDisabled: false,

        keyword: "",
        skuInfoList: [],
      };
    },

    // 监听器
    watch: {
      $route(to, from) {
        console.log("路由变化...");
        console.log(to);
        console.log(from);
        this.init();
      },
    },

    // 生命周期方法（在路由切换，组件不变的情况下不会被调用）
    created() {
      console.log("form created...");
      this.init();
    },

    methods: {
      // 表单初始化
      init() {
        // debugger
        if (this.$route.params && this.$route.params.id) {
          const id = this.$route.params.id;
          this.fetchDataById(id);
        } else {
          // 对象拓展运算符：拷贝对象，而不是赋值对象的引用
          this.couponInfo = { ...defaultForm };
        }
      },

      saveOrUpdate() {
        // 防止表单重复提交
        this.saveBtnDisabled = true;

        if (!this.couponInfo.couponName) {
          this.$message.error("请输入优惠券名称");
          this.saveBtnDisabled = false;

          return;
        }

        if (!this.couponInfo.publishCount) {
          this.$message.error("请输入发行数量");
          this.saveBtnDisabled = false;

          return;
        }

        // 验证开始时间和结束时间的合法性
        if (!this.validateDateRange()) {
          return;
        }

        if (!this.couponInfo.id) {
          this.saveData();
        } else {
          this.updateData();
        }
      },

      // 验证开始时间和结束时间的合法性
      validateDateRange() {
        if (
          (this.couponInfo.startTime &&
            this.couponInfo.endTime &&
            this.couponInfo.startTime > this.couponInfo.endTime) ||
          this.couponInfo.endTime > this.couponInfo.expireTime
        ) {
          this.$message.error("开始时间不能晚于结束时间");
          return false;
        }
        return true;
      },

      // 新增
      saveData() {
        couponInfoAPI.save(this.couponInfo).then((response) => {
          if (response.code) {
            this.$message({
              type: "success",
              message: response.message,
            });
            this.$router.push({ path: "/activity/coupon/info/list" });
          }
        });
      },

      // 根据 id 更新记录
      updateData() {
        couponInfoAPI.updateById(this.couponInfo).then((response) => {
          debugger;
          if (response.code) {
            this.$message({
              type: "success",
              message: response.message,
            });
            this.$router.push({ path: "/activity/coupon/info/list" });
          }
        });
      },

      back() {
        this.$router.push({ path: "/activity/coupon/info/list" });
      },

      // 根据 id 查询记录
      fetchDataById(id) {
        couponInfoAPI.getById(id).then((response) => {
          this.couponInfo = response.data;
        });
      },
    },
  };
</script>
```

**（4）show.vue**

```html
<template>
  <div class="app-container">
    <h4>优惠券信息</h4>
    <table
      class="table table-striped table-condenseda table-bordered"
      width="100%"
    >
      <tbody>
        <tr>
          <th width="15%">优惠券名称</th>
          <td width="35%">
            <b style="font-size: 14px">{{ couponInfo.couponName }}</b>
          </td>
          <th width="15%">优惠券类型</th>
          <td width="35%">
            {{ couponInfo.couponType === "1" ? "注册卷" : "推荐赠送卷" }}
          </td>
        </tr>
        <tr>
          <th>发行数量</th>
          <td>{{ couponInfo.publishCount }}</td>
          <th>每人限领次数</th>
          <td>{{ couponInfo.perLimit }}</td>
        </tr>
        <tr>
          <th>领取数量</th>
          <td>{{ couponInfo.receiveCount }}</td>
          <th>使用数量</th>
          <td>{{ couponInfo.useCount }}</td>
        </tr>
        <tr>
          <th>领取时间</th>
          <td>{{ couponInfo.startTime }}至{{ couponInfo.endTime }}</td>
          <th>过期时间</th>
          <td>{{ couponInfo.expireTime }}</td>
        </tr>
        <tr>
          <th>规则描述</th>
          <td colspan="3">{{ couponInfo.ruleDesc }}</td>
        </tr>
      </tbody>
    </table>

    <h4>优惠券发放列表&nbsp;&nbsp;&nbsp;</h4>
    <el-table
      v-loading="listLoading"
      :data="list"
      stripe
      border
      style="width: 100%; margin-top: 10px"
    >
      <el-table-column label="序号" width="70" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column prop="param.nickName" label="用户昵称" />
      <el-table-column prop="param.phone" label="手机号" />
      <el-table-column label="使用状态">
        <template slot-scope="scope">
          {{ scope.row.couponStatus == "NOT_USED" ? "未使用" : "已使用" }}
        </template>
      </el-table-column>
      <el-table-column prop="getTime" label="获取时间" />
      <el-table-column prop="usingTime" label="使用时间" />
      <el-table-column prop="usedTime" label="支付时间" />
      <el-table-column prop="expireTime" label="过期时间" />
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center"
      layout="sizes, prev, pager, next, jumper, ->, total, slot"
      @current-change="fetchData"
      @size-change="changeSize"
    />

    <div style="margin-top: 15px">
      <el-form label-width="0px">
        <el-form-item>
          <el-button @click="back">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  import couponInfoAPI from "@/api/activity/couponInfo";

  export default {
    data() {
      return {
        // 数据是否正在加载
        listLoading: false,
        couponId: null,
        couponInfo: {},
        // banner列表
        list: null,
        // 数据库中的总记录数
        total: 0,
        // 默认页码
        page: 1,
        // 每页记录数
        limit: 10,
        // 查询表单对象
        searchObj: {},
      };
    },

    // 监听器
    watch: {
      $route(to, from) {
        console.log("路由变化...");
        console.log(to);
        console.log(from);
        this.init();
      },
    },

    // 生命周期方法（在路由切换，组件不变的情况下不会被调用）
    created() {
      console.log("form created...");
      this.couponId = this.$route.params.id;
      // 获取优惠券信息
      this.fetchDataById();
      this.fetchData();
    },

    methods: {
      // 根据 id 查询记录
      fetchDataById() {
        couponInfoAPI.getById(this.couponId).then((response) => {
          this.couponInfo = response.data;
        });
      },

      // 当页码发生改变的时候
      changeSize(size) {
        console.log(size);
        this.limit = size;
        this.fetchData(1);
      },

      // 加载 banner 列表数据
      fetchData(page = 1) {
        console.log("翻页..." + page);
        // 异步获取远程数据（ajax）
        this.page = page;
        this.searchObj.couponId = this.couponId;
        couponInfoAPI
          .getPageCouponUseList(this.page, this.limit, this.searchObj)
          .then((response) => {
            this.list = response.data.records;
            this.total = response.data.total;

            // 数据加载并绑定成功
            this.listLoading = false;
          });
      },

      back() {
        this.$router.push({ path: "/activity/coupon/info/list" });
      },
    },
  };
</script>
```

### 二、微信公众号

#### 1、注册公众号

微信公众平台：https://mp.weixin.qq.com/

![注册公众号](https://img-blog.csdnimg.cn/44e6e57017554b45bd99b3ed0b78eda7.png)

硅谷课堂要求基于 H5，具有微信支付等高级功能的，因此需要注册服务号，订阅号不具备支付功能。

注册步骤参考官方注册文档：https://kf.qq.com/faq/120911VrYVrA151013MfYvYV.html

注册过程仅做了解，有公司运营负责申请与认证。

#### 2、公众号功能介绍

在微信公众平台扫码登录后可以发现管理页面左侧菜单栏有丰富的功能：

![公众号功能介绍](https://img-blog.csdnimg.cn/232908fe893d45b183b47acaf5e6a880.png)

大概可以分为这几大模块：

**首页**、**内容与互动**、**数据**、**广告与服务**、**设置与开发**、**新功能**

作为开发人员，首先应该关注的是设置与开发模块；而作为产品运营人员与数据分析人员，关注的是内容与互动、数据及广告与服务模块。

首先不妨各个功能模块都点击看一看，大概了解下能做些什么。可以确认的是，这个微信公众平台当然**不只是给开发人员使用**的，它提供了很多**非技术人员**可在**UI 界面上交互操作**的功能模块。

如配置消息回复、自定义菜单、发布文章等：

![公众号功能介绍](https://img-blog.csdnimg.cn/604a9ddb73c5462a94899ac16f9f241e.png)

这个时候可能会想：这些功能好像非技术人员都能随意操作，那么还需要技术人员去开发吗？

**答案是**： 如果只是日常简单的推送文章，就像关注的大多数公众号一样，那确实不需要技术人员去开发；但是，如果你想将你们的网站嵌入进去公众号菜单里（这里指的是把前端项目的首页链接配置在自定义菜单），并且实现微信端的独立登录认证、获取微信用户信息、微信支付等高级功能，或者觉得 UI 交互的配置方式无法满足你的需求，你需要更加自由、随心所欲的操作，那么就必须启用开发者模式了，通过技术人员的手段去灵活控制公众号。

**这里有一点需要注意，如果决定技术人员开发公众号，必须启用服务器配置，而这将导致 UI 界面设置的自动回复和自定义菜单失效！**

在 **设置与开发 - 基本配置 - 服务器配置** 中点击启用：

![公众号功能介绍](https://img-blog.csdnimg.cn/777815dcc40640ffa31686138453b769.png)

![公众号功能介绍](https://img-blog.csdnimg.cn/1f4e7cf131764bf48ecfa2f920acea78.png)

至于服务器配置中的选项代表什么意思、如何填写，下面再讲。

#### 3、微信公众平台测试帐号

##### 3.1、申请测试帐号

微信公众平台接口测试帐号：https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login&token=399029368&lang=zh_CN

![申请测试帐号](https://img-blog.csdnimg.cn/b34c075a88a341f6aa0c8fbe083d7392.png)

![申请测试帐号](https://img-blog.csdnimg.cn/0006d53a2e6442778545f32e52550696.png)

##### 3.2、查看测试号管理

（1）其中 appID 和 appsecret 用于后面菜单开发使用。

（2）其中 URL 是开发者用来接收微信消息和事件的接口 URL。Token 可由开发者可以任意填写，用作生成签名（该 Token 会和接口 URL 中包含的 Token 进行比对，从而验证安全性）。本地测试，url 改为内网穿透地址。

![查看测试号管理](https://img-blog.csdnimg.cn/7da2d419fc9f4221b04d61ccdb373eb6.png)

##### 3.3、关注公众号

![关注公众号](https://img-blog.csdnimg.cn/27de9b9657194c4e96c367e90d01cda6.png)

![关注公众号](https://img-blog.csdnimg.cn/0b5d5b72f00b40f2a546a0c57d25658d.png)

#### 4、开发业务介绍

硅谷课堂涉及的微信公众号功能模块：自定义菜单、消息、微信支付、授权登录等。

### 三、后台管理系统-公众号菜单管理

#### 1、需求分析

##### 1.1、微信自定义菜单说明

微信自定义菜单文档地址：https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Creating_Custom-Defined_Menu.html

微信自定义菜单注意事项：

1. 自定义菜单最多包括 3 个一级菜单，每个一级菜单最多包含 5 个二级菜单。

2. 一级菜单最多 4 个汉字，二级菜单最多 8 个汉字，多出来的部分将会以“...”代替。

3. 创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号 profile 页时，如果发现上一次拉取菜单的请求在 5 分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。

##### 1.2、硅谷课堂自定义菜单

一级菜单：直播、课程、我的。

二级菜单：根据一级菜单动态设置二级菜单，直播（近期直播课程），课程（课程分类），我的（我的订单、我的课程、我的优惠券以及关于我们）。

说明：

​ 1、二级菜单可以是网页类型，点击跳转 H5 页面。

​ 2、二级菜单可以是消息类型，点击返回消息。

##### 1.3、数据格式

自定义菜单通过后台管理设置到数据库表，数据配置好后，通过微信接口推送菜单数据到微信平台。

**表结构（menu）：**

![数据格式](https://img-blog.csdnimg.cn/00ce62757c13457daa949c500c3d9fb9.png)

![数据格式](https://img-blog.csdnimg.cn/555d17bf9fdc4762b948afa040938fc7.png)

表示例数据：

![数据格式](https://img-blog.csdnimg.cn/89f859c3176145378bd6ff2814b32237.png)

##### 1.4、管理页面

**（1）页面功能“列表、添加、修改与删除”是对 menu 表的操作。**

**（2）页面功能“同步菜单与删除菜单”是对微信平台接口操作。**

![管理页面](https://img-blog.csdnimg.cn/efaac38102474157b35dd9c5d85bd1c2.png)

#### 2、搭建菜单管理后端环境

##### 2.1、创建模块 service-wechat

**（1）在 service 下创建子模块 service-wechat。**

![创建模块 service-wechat](https://img-blog.csdnimg.cn/c1a24355764a4c9cbb5b70944907997a.png)

**（2）引入依赖。**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.myxh.smart.planet</groupId>
        <artifactId>service</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>service-wechat</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- mybatis-plus-generator -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.5.3.1</version>
        </dependency>

        <!-- freemarker -->
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
            <version>2.3.32</version>
        </dependency>

        <!-- weixin-java-mp -->
        <dependency>
            <groupId>com.github.binarywang</groupId>
            <artifactId>weixin-java-mp</artifactId>
            <version>4.5.0</version>
        </dependency>
    </dependencies>
</project>
```

##### 2.2、生成菜单相关代码

![生成菜单相关代码](https://img-blog.csdnimg.cn/cfaeb606e2f14d46b5a3359b4b171ac9.png)

##### 2.3、创建启动类和配置文件

**（1）启动类。**

```java
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
```

**（2）配置文件。**

```properties
# 服务端口
server.port=8305

# 服务名
spring.application.name=service-wechat

# 环境设置：dev、test、prod
spring.profiles.active=dev

# MySQL 数据库连接
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/smart_planet_wechat?characterEncoding=utf-8&useSSL=false
spring.datasource.username=MYXH
spring.datasource.password=520.ILY!

# 返回 Json 的全局时间格式
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8

# MyBatis 日志
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

# 设置 mapper.xml 的路径
mybatis-plus.mapper-locations=classpath:com/myxh/smart/planet/wechat/mapper/xml/*.xml

# nacos 服务地址
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848

# 公众号 id 和秘钥
# 智慧星球微信公众平台 appId
wechat.appId=wxc23b80b9ffaac7bd
# 智慧星球微信公众平台 api 秘钥
wechat.appSecret=5c0271622c4271753310c436b5cd3532
```

##### 2.4、配置网关

```properties
# service-wechat 模块配置
# 设置路由 id
spring.cloud.gateway.routes[4].id=service-wechat
# 设置路由的 uri，lb 全称为 Load Balance 负载平衡
spring.cloud.gateway.routes[4].uri=lb://service-wechat
# 设置路由断言,代理 servicerId 为 auth-service 的 /auth/ 路径，/admin/wechat/menu
spring.cloud.gateway.routes[4].predicates= Path=/*/wechat/**
```

#### 3、开发菜单管理接口

##### 3.1、编写 MenuController

```java
package com.myxh.smart.planet.wechat.controller;

import com.myxh.smart.planet.model.wechat.Menu;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.wechat.MenuVo;
import com.myxh.smart.planet.wechat.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 前端控制器
 * </p>
 */
@Tag(name = "微信公众号菜单管理", description = "微信公众号菜单管理接口")
@RestController
@RequestMapping("/admin/wechat/menu")
public class MenuController
{
    @Autowired
    private MenuService menuService;

    /**
     * 获取所有菜单，按照一级和二级菜单封装
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取所有菜单", description = "获取所有菜单，按照一级和二级菜单封装")
    @GetMapping("find/menu/info")
    public Result<List<MenuVo>> findMenuInfo()
    {
        List<MenuVo> menuList = menuService.findMenuInfo();

        return Result.ok(menuList);
    }

    /**
     * 获取所有一级菜单
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取所有一级菜单", description = "获取所有一级菜单")
    @GetMapping("find/one/menu/info")
    public Result<List<Menu>> findOneMenuInfo()
    {
        List<Menu> oneMenuList = menuService.findMenuOneInfo();

        return Result.ok(oneMenuList);
    }

    /**
     * 根据 id 查询菜单
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询", description = "根据 id 查询菜单")
    @GetMapping("get/{id}")
    public Result<Menu> get(@PathVariable("id") Long id)
    {
        Menu menu = menuService.getById(id);

        return Result.ok(menu);
    }

    /**
     * 添加菜单
     *
     * @param menu 菜单
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加", description = "添加菜单")
    @PostMapping("save")
    public Result<Void> save(@RequestBody Menu menu)
    {
        menuService.save(menu);

        return Result.ok(null);
    }

    /**
     * 修改菜单
     *
     * @param menu 菜单
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改", description = "修改菜单")
    @PutMapping("update")
    public Result<Void> updateById(@RequestBody Menu menu)
    {
        menuService.updateById(menu);

        return Result.ok(null);
    }

    /**
     * 逻辑删除菜单
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除", description = "逻辑删除菜单")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@PathVariable("id") Long id)
    {
        menuService.removeById(id);

        return Result.ok(null);
    }

    /**
     * 批量删除菜单
     *
     * @param idList id 数组，Json 数组 [1,2,3,...]
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "批量删除", description = "批量删除菜单")
    @DeleteMapping("remove/batch")
    public Result<Void> batchRemove(@RequestBody List<Long> idList)
    {
        menuService.removeByIds(idList);

        return Result.ok(null);
    }
}
```

##### 3.2、编写 Service

**（1）MenuService 定义方法。**

```java
package com.myxh.smart.planet.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.wechat.Menu;
import com.myxh.smart.planet.vo.wechat.MenuVo;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 服务类
 * </p>
 */
public interface MenuService extends IService<Menu>
{
    /**
     * 获取所有菜单，按照一级和二级菜单封装
     *
     * @return menuList 菜单列表
     */
    List<MenuVo> findMenuInfo();

    /**
     * 获取所有一级菜单
     *
     * @return oneMenuList 一级菜单列表
     */
    List<Menu> findMenuOneInfo();
}
```

**（2）MenuServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.wechat.Menu;
import com.myxh.smart.planet.vo.wechat.MenuVo;
import com.myxh.smart.planet.wechat.mapper.MenuMapper;
import com.myxh.smart.planet.wechat.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 服务实现类
 * </p>
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService
{
    /**
     * 获取所有菜单，按照一级和二级菜单封装
     *
     * @return menuList 菜单列表
     */
    @Override
    public List<MenuVo> findMenuInfo()
    {
        // 1、创建 List 集合，用于最终数据封装
        List<MenuVo> finalMenuList = new ArrayList<>();

        // 2、查询所有菜单数据（包含一级和二级）
        List<Menu> menuList = baseMapper.selectList(null);

        // 3、从所有菜单数据获取所有一级菜单数据（parentId = 0）
        List<Menu> oneMenuList = menuList.stream().filter(menu -> menu.getParentId() == 0).toList();

        // 4、封装一级菜单数据，封装到最终数据 List 集台
        // 遍历一级菜单 List 集合
        for (Menu oneMenu : oneMenuList)
        {
            MenuVo oneMenuVo = new MenuVo();
            BeanUtils.copyProperties(oneMenu, oneMenuVo);

            // 5、封装二级菜单数据（判断一级菜单和二级菜单 parentId是否相同）
            // 如果相同，把二级菜单数据放到一级菜单里面
            List<Menu> twoMenuList = menuList.stream().filter(menu -> menu.getParentId().longValue() == oneMenu.getId()).sorted(Comparator.comparing(Menu::getSort)).toList();

            List<MenuVo> children = new ArrayList<>();

            for (Menu twoMenu : twoMenuList)
            {
                MenuVo twoMenuVo = new MenuVo();
                BeanUtils.copyProperties(twoMenu, twoMenuVo);
                children.add(twoMenuVo);
            }

            // 把二级菜单数据放到一级菜单里面
            oneMenuVo.setChildren(children);

            // 把 oneMenuVo 放到最终 List 集合
            finalMenuList.add(oneMenuVo);
        }

        // 返回最终数据
        return finalMenuList;
    }

    /**
     * 获取所有一级菜单
     *
     * @return oneMenuList 一级菜单列表
     */
    @Override
    public List<Menu> findMenuOneInfo()
    {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", 0);
        List<Menu> oneMenuList = baseMapper.selectList(wrapper);

        return oneMenuList;
    }
}
```

#### 4、同步菜单（获取 access_token）

##### 4.1、文档查看

**（1）进行菜单同步时候，需要获取到公众号的 access_token，通过 access_token 进行菜单同步。**

接口文档：https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html

![文档查看](https://img-blog.csdnimg.cn/d6321cdcaea04ba891d4e00815694b4d.png)

**（2）调用方式。**

![文档查看](https://img-blog.csdnimg.cn/a701e1781f0a49b4a5f4caaf0ccd652a.png)

![文档查看](https://img-blog.csdnimg.cn/0347658c163d417b9271140015521151.png)

##### 4.2、service-wechat 添加配置

```properties
# 公众号 id 和秘钥
# 智慧星球微信公众平台 appId
wechat.appId=wxc23b80b9ffaac7bd
# 智慧星球微信公众平台 api 秘钥
wechat.appSecret=5c0271622c4271753310c436b5cd3532
```

##### 4.3、添加工具类

```java
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
```

##### 4.4、复制 HttpClient 工具类

![复制 HttpClient 工具类](https://img-blog.csdnimg.cn/ac9b5781a2aa4a8980932c536408c2ff.png)

##### 4.5、添加 Menucontroller 方法

```java
package com.myxh.smart.planet.wechat.controller;

import com.alibaba.fastjson2.JSONObject;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.wechat.utils.ConstantPropertiesUtil;
import com.myxh.smart.planet.wechat.utils.HttpClientUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 前端控制器
 * </p>
 */
@Tag(name = "微信公众号菜单管理", description = "微信公众号菜单管理接口")
@RestController
@RequestMapping("/admin/wechat/menu")
public class MenuController
{
    /**
     * 获取 access_token
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取 access_token", description = "获取 access_token")
    @GetMapping("get/access/token")
    public Result<String> getAccessToken()
    {
        try
        {
            // 拼接请求地址
            String buffer = "https://api.weixin.qq.com/cgi-bin/token" +
                    "?grant_type=client_credential" +
                    "&appid=%s" +
                    "&secret=%s";

            // 请求地址设置参数
            String url = String.format(buffer,
                    ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);

            // 发送 http 请求
            String tokenString = HttpClientUtils.get(url);

            // 获取 access_token
            JSONObject jsonObject = JSONObject.parseObject(tokenString);
            String access_token = jsonObject.getString("access_token");

            // 返回
            return Result.ok(access_token);
        }
        catch (Exception e)
        {
            e.printStackTrace();

            throw new SmartPlanetException(20001, "获取 access_token 失败");
        }
    }
}
```

##### 4.6、测试

#### 5、同步菜单（功能实现）

接口文档：https://developers.weixin.qq.com/doc/offiaccount/Custom_Menus/Creating_Custom-Defined_Menu.html

**接口调用请求说明：**

http 请求方式：POST（请使用 https 协议） https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN

**weixin-java-mp**是封装好了的微信接口客户端，使用起来很方便，后续就使用 weixin-java-mp 处理微信平台接口。

##### 5.1、添加配置类

```java
package com.myxh.smart.planet.wechat.config;

import com.myxh.smart.planet.wechat.utils.ConstantPropertiesUtil;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@Component
public class WeChatMpConfig
{

    @Autowired
    public WeChatMpConfig(ConstantPropertiesUtil constantPropertiesUtil)
    {

    }

    @Bean
    public WxMpService wxMpService(WxMpConfigStorage wxMpConfigStorage)
    {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);

        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage()
    {
        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setAppId(ConstantPropertiesUtil.ACCESS_KEY_ID);
        wxMpConfigStorage.setSecret(ConstantPropertiesUtil.ACCESS_KEY_SECRET);

        return wxMpConfigStorage;
    }
}
```

##### 5.2、定义 Service 方法

**MenuService**

```java
package com.myxh.smart.planet.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.wechat.Menu;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 服务类
 * </p>
 */
public interface MenuService extends IService<Menu>
{
    /**
     * 同步微信公众号菜单
     */
    void syncMenu();
}
```

##### 5.3、实现 Service 方法

**MenuServiceImpl**

```java
package com.myxh.smart.planet.wechat.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.model.wechat.Menu;
import com.myxh.smart.planet.vo.wechat.MenuVo;
import com.myxh.smart.planet.wechat.mapper.MenuMapper;
import com.myxh.smart.planet.wechat.service.MenuService;
import lombok.SneakyThrows;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 服务实现类
 * </p>
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService
{
    @Autowired
    private WxMpService wxMpService;

    /**
     * 同步微信公众号菜单
     */
    @SneakyThrows
    @Override
    public void syncMenu()
    {
        // 获取所有菜单数据
        List<MenuVo> menuVoList = this.findMenuInfo();

        // 封装 button 里面结构，数组格式
        JSONArray buttonList = new JSONArray();

        for (MenuVo oneMenuVo : menuVoList)
        {
            // json 对象，一级菜单
            JSONObject one = new JSONObject();
            one.put("name", oneMenuVo.getName());

            // json 数组，二级菜单
            JSONArray subButton = new JSONArray();

            for (MenuVo twoMenuVo : oneMenuVo.getChildren())
            {
                JSONObject view = new JSONObject();
                view.put("type", twoMenuVo.getType());
                view.put("name", twoMenuVo.getName());

                if (twoMenuVo.getType().equals("view"))
                {
                    view.put("url", "http://smartplanetmobile.free.idcfengye.com/#" + twoMenuVo.getUrl());
                }
                else
                {
                    view.put("key", twoMenuVo.getMenuKey());
                }

                subButton.add(view);
            }

            one.put("sub_button", subButton);
            buttonList.add(one);
        }

        // 封装最外层 button 部分
        JSONObject button = new JSONObject();
        button.put("button", buttonList);

        try
        {
            String menuId = this.wxMpService.getMenuService().menuCreate(button.toJSONString());
            System.out.println("menuId = " + menuId);

        }
        catch (Exception e)
        {
            throw new SmartPlanetException(20001, "微信公众号菜单同步失败");
        }
    }
}
```

##### 5.4、controller 方法

```java
package com.myxh.smart.planet.wechat.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.wechat.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 前端控制器
 * </p>
 */
@Tag(name = "微信公众号菜单管理", description = "微信公众号菜单管理接口")
@RestController
@RequestMapping("/admin/wechat/menu")
public class MenuController
{
    @Autowired
    private MenuService menuService;

    /**
     * 同步微信公众号菜单
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "同步微信公众号菜单", description = "同步微信公众号菜单")
    @GetMapping("sync/menu")
    public Result<Void> createMenu()
    {
        menuService.syncMenu();

        return Result.ok(null);
    }
}
```

#### 6、删除菜单

##### 6.1、service 接口

```java
package com.myxh.smart.planet.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.wechat.Menu;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 服务类
 * </p>
 */
public interface MenuService extends IService<Menu>
{
    /**
     * 删除微信公众号菜单
     */
    void removeMenu();
}
```

##### 6.2、service 接口实现

```java
package com.myxh.smart.planet.wechat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.model.wechat.Menu;
import com.myxh.smart.planet.wechat.mapper.MenuMapper;
import com.myxh.smart.planet.wechat.service.MenuService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 服务实现类
 * </p>
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService
{
    @Autowired
    private WxMpService wxMpService;

    /**
     * 删除微信公众号菜单
     */
    @Override
    public void removeMenu()
    {
        try
        {
            wxMpService.getMenuService().menuDelete();
        }
        catch (WxErrorException e)
        {
            throw new SmartPlanetException(20001, "微信公众号菜单删除失败");
        }
    }
}
```

##### 6.3、controller 方法

```java
package com.myxh.smart.planet.wechat.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.wechat.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/16
 *
 * <p>
 * 菜单 前端控制器
 * </p>
 */
@Tag(name = "微信公众号菜单管理", description = "微信公众号菜单管理接口")
@RestController
@RequestMapping("/admin/wechat/menu")
public class MenuController
{
    @Autowired
    private MenuService menuService;

    /**
     * 删除微信公众号菜单
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除微信公众号菜单", description = "删除微信公众号菜单")
    @DeleteMapping("remove/menu")
    public Result<Void> removeMenu()
    {
        menuService.removeMenu();

        return Result.ok(null);
    }
}
```

#### 7、开发菜单管理前端

##### 7.1、添加路由

**（1）src/router/index.js 添加路由。**

```javascript
// 微信公众号菜单管理
{
  path: "/wechat",
  component: Layout,
  redirect: "/wechat/menu/list",
  name: "Wechat",
  meta: {
    title: "微信公众号菜单管理",
    icon: "el-icon-refrigerator",
  },
  alwaysShow: true,
  children: [
    {
      path: "menu/list",
      name: "Menu",
      component: () => import("@/views/wechat/menu/list"),
      meta: { title: "菜单列表" },
    },
  ],
},
```

##### 7.2、定义接口

**（1）src/api/wechat/menu.js 定义接口。**

```javascript
import request from "@/utils/request";

const MENU_API = "/admin/wechat/menu";

export default {
  /**
   * 获取所有菜单，按照一级和二级菜单封装
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findMenuInfo() {
    return request({
      url: `${MENU_API}/find/menu/info`,
      method: `get`,
    });
  },

  /**
   * 获取所有一级菜单
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findOneMenuInfo() {
    return request({
      url: `${MENU_API}/find/one/menu/info`,
      method: `get`,
    });
  },

  /**
   * 根据 id 查询菜单
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getById(id) {
    return request({
      url: `${MENU_API}/get/${id}`,
      method: `get`,
    });
  },

  /**
   * 添加菜单
   *
   * @param {Object} menu 菜单
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  save(menu) {
    return request({
      url: `${MENU_API}/save`,
      method: `post`,
      data: menu,
    });
  },

  /**
   * 修改菜单
   *
   * @param {Object} menu 菜单
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateById(menu) {
    return request({
      url: `${MENU_API}/update`,
      method: `put`,
      data: menu,
    });
  },

  /**
   * 逻辑删除菜单
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${MENU_API}/remove/${id}`,
      method: "delete",
    });
  },

  /**
   * 同步微信公众号菜单
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  syncMenu() {
    return request({
      url: `${MENU_API}/sync/menu`,
      method: `get`,
    });
  },

  /**
   * 删除微信公众号菜单
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeMenu() {
    return request({
      url: `${MENU_API}/remove/menu`,
      method: `delete`,
    });
  },
};
```

##### 7.3、编写页面

**（1）创建 views/wechat/menu/list.vue。**

```html
<template>
  <div class="app-container">
    <!-- 工具条 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button
        class="btn-add"
        size="mini"
        @click="removeMenu"
        style="margin-left: 10px"
        >删除菜单</el-button
      >
      <el-button class="btn-add" size="mini" @click="syncMenu"
        >同步菜单</el-button
      >
      <el-button class="btn-add" size="mini" @click="add">添 加</el-button>
    </el-card>

    <el-table
      :data="list"
      style="width: 100%; margin-bottom: 20px"
      row-key="id"
      border
      default-expand-all
      :tree-props="{ children: 'children' }"
    >
      <el-table-column label="名称" prop="name" width="350"></el-table-column>
      <el-table-column label="类型" width="100">
        <template slot-scope="scope">
          {{ scope.row.type === "view" ? "链接" : scope.row.type == "click" ?
          "事件" : "" }}
        </template>
      </el-table-column>
      <el-table-column label="菜单URL" prop="url"></el-table-column>
      <el-table-column
        label="菜单KEY"
        prop="menuKey"
        width="130"
      ></el-table-column>
      <el-table-column label="排序号" prop="sort" width="70"></el-table-column>
      <el-table-column label="操作" width="170" align="center">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.parentId > 0"
            type="text"
            size="mini"
            @click="edit(scope.row.id)"
            >修改</el-button
          >
          <el-button
            v-if="scope.row.parentId > 0"
            type="text"
            size="mini"
            @click="removeDataById(scope.row.id)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="40%">
      <el-form
        ref="flashPromotionForm"
        label-width="150px"
        size="small"
        style="padding-right: 40px"
      >
        <el-form-item label="选择一级菜单">
          <el-select v-model="menu.parentId" placeholder="请选择">
            <el-option
              v-for="item in list"
              :key="item.id"
              :label="item.name"
              :value="item.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item v-if="menu.parentId == 1" label="菜单名称">
          <el-select
            v-model="menu.name"
            placeholder="请选择"
            @change="liveCourseChanged"
          >
            <el-option
              v-for="item in liveCourseList"
              :key="item.id"
              :label="item.courseName"
              :value="item"
            />
          </el-select>
        </el-form-item>
        <el-form-item v-if="menu.parentId == 2" label="菜单名称">
          <el-select
            v-model="menu.name"
            placeholder="请选择"
            @change="subjectChanged"
          >
            <el-option
              v-for="item in subjectList"
              :key="item.id"
              :label="item.title"
              :value="item"
            />
          </el-select>
        </el-form-item>
        <el-form-item v-if="menu.parentId == 3" label="菜单名称">
          <el-input v-model="menu.name" />
        </el-form-item>
        <el-form-item label="菜单类型">
          <el-radio-group v-model="menu.type">
            <el-radio label="view">链接</el-radio>
            <el-radio label="click">事件</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item v-if="menu.type == 'view'" label="链接">
          <el-input v-model="menu.url" />
        </el-form-item>
        <el-form-item v-if="menu.type == 'click'" label="菜单KEY">
          <el-input v-model="menu.menuKey" />
        </el-form-item>
        <el-form-item label="排序">
          <el-input v-model="menu.sort" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()" size="small"
          >确 定</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import menuAPI from "@/api/wechat/menu";
  // import liveCourseAPI from '@/api/live/liveCourse'
  import subjectAPI from "@/api/vod/subject";

  const defaultForm = {
    id: null,
    parentId: 1,
    name: "",
    nameId: null,
    sort: 1,
    type: "view",
    menuKey: "",
    url: "",
  };

  export default {
    // 定义数据
    data() {
      return {
        list: [],
        liveCourseList: [],
        subjectList: [],
        dialogVisible: false,
        menu: defaultForm,
        saveBtnDisabled: false,
      };
    },

    // 当页面加载时获取数据
    created() {
      this.fetchData();
      // this.fetchLiveCourse()
      this.fetchSubject();
    },

    methods: {
      // 调用 api 层获取数据库中的数据
      fetchData() {
        console.log("加载列表");
        menuAPI.findMenuInfo().then((response) => {
          this.list = response.data;
          console.log(this.list);
        });
      },

      /*
    fetchLiveCourse() {
      liveCourseAPI.findLatelyList().then((response) => {
        this.liveCourseList = response.data;
        this.liveCourseList.push({ id: 0, courseName: "全部列表" });
      });
    },
     */

      fetchSubject() {
        console.log("加载列表");
        subjectAPI.getChildList(0).then((response) => {
          this.subjectList = response.data;
        });
      },

      syncMenu() {
        this.$confirm("你确定上传菜单吗, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            return menuAPI.syncMenu();
          })
          .then((response) => {
            this.fetchData();
            this.$message.success(response.message);
          })
          .catch((error) => {
            console.log("error", error);
            // 当取消时会进入 catch 语句:error = 'cancel'
            // 当后端服务抛出异常时：error = 'error'
            if (error === "cancel") {
              this.$message.info("取消上传");
            }
          });
      },

      removeMenu() {
        this.$confirm("你确定删除菜单吗, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            return menuAPI.removeMenu();
          })
          .then((response) => {
            this.fetchData();
            this.$message.success(response.message);
          })
          .catch((error) => {
            console.log("error", error);
            // 当取消时会进入 catch 语句:error = 'cancel'
            // 当后端服务抛出异常时：error = 'error'
            if (error === "cancel") {
              this.$message.info("取消删除");
            }
          });
      },

      // 根据 id 删除数据
      removeDataById(id) {
        this.$confirm("此操作将永久删除该记录, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            // 点击确定，远程调用 ajax
            return menuAPI.removeById(id);
          })
          .then((response) => {
            this.fetchData(this.page);
            if (response.code) {
              this.$message({
                type: "success",
                message: "删除成功!",
              });
            }
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消删除",
            });
          });
      },

      add() {
        this.dialogVisible = true;
        this.menu = Object.assign({}, defaultForm);
      },

      edit(id) {
        this.dialogVisible = true;
        this.fetchDataById(id);
      },

      fetchDataById(id) {
        menuAPI.getById(id).then((response) => {
          this.menu = response.data;
        });
      },

      saveOrUpdate() {
        // 防止表单重复提交
        this.saveBtnDisabled = true;

        if (!this.menu.name) {
          this.$message.error("请输入菜单名称");
          this.saveBtnDisabled = false;
          return;
        }

        if (!this.menu.id) {
          this.saveData();
        } else {
          this.updateData();
        }
      },

      // 新增
      saveData() {
        menuAPI.save(this.menu).then((response) => {
          if (response.code) {
            this.$message({
              type: "success",
              message: response.message,
            });
            this.dialogVisible = false;
            this.fetchData(this.page);
          }
        });
      },

      // 根据 id 更新记录
      updateData() {
        menuAPI.updateById(this.menu).then((response) => {
          if (response.code) {
            this.$message({
              type: "success",
              message: response.message,
            });
            this.dialogVisible = false;
            this.fetchData(this.page);
          }
        });
      },

      // 根据 id 查询记录
      fetchDataById(id) {
        menuAPI.getById(id).then((response) => {
          this.menu = response.data;
        });
      },

      subjectChanged(item) {
        console.info(item);
        this.menu.name = item.title;
        this.menu.url = "/course/" + item.id;
      },

      liveCourseChanged(item) {
        console.info(item);
        this.menu.name = item.courseName;
        if (item.id == 0) {
          this.menu.url = "/live";
        } else {
          this.menu.url = "/live/info/" + item.id;
        }
      },
    },
  };
</script>
```

#### 8、公众号菜单功能测试

**（1）在手机公众号可以看到同步之后的菜单。**

![公众号菜单功能测试](https://img-blog.csdnimg.cn/18c9feef63ee4b3bb92da9d677bed4df.png)

## Day 12-公众号消息和微信授权登录

### 一、公众号普通消息

#### 1、实现目标

1、“智慧星球”公众号实现根据关键字搜索相关课程，如：输入“Java”，可返回 Java 相关的一个课程。

2、“智慧星球”公众号点击菜单“关于我们”，返回关于我们的介绍。

3、关注或取消关注等。

#### 2、消息接入

参考文档：https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Access_Overview.html

接入微信公众平台开发，开发者需要按照如下步骤完成：

1、填写服务器配置。

2、验证服务器地址的有效性。

3、依据接口文档实现业务逻辑。

##### 2.1、公众号服务器配置

在测试管理 -> 接口配置信息，点击“修改”按钮，填写服务器地址（URL）和 Token，其中 URL 是开发者用来接收微信消息和事件的接口 URL。Token 可由开发者可以任意填写，用作生成签名（该 Token 会和接口 URL 中包含的 Token 进行比对，从而验证安全性）。

说明：本地测试，url 改为内网穿透地址。

![公众号服务器配置](https://img-blog.csdnimg.cn/cb1d5126ca044b09b7f3840b14b34364.png)

##### 2.2、验证来自微信服务器消息

**（1）概述。**

开发者提交信息后，微信服务器将发送 GET 请求到填写的服务器地址 URL 上，GET 请求携带参数如下表所示：

| 参数      | 描述                                                                                         |
| :-------- | :------------------------------------------------------------------------------------------- |
| signature | 微信加密签名，signature 结合了开发者填写的 token 参数和请求中的 timestamp 参数、nonce 参数。 |
| timestamp | 时间戳。                                                                                     |
| nonce     | 随机数。                                                                                     |
| echostr   | 随机字符串。                                                                                 |

开发者通过检验 signature 对请求进行校验（下面有校验方式）。若确认此次 GET 请求来自微信服务器，请原样返回 echostr 参数内容，则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：

1、将 token、timestamp、nonce 三个参数进行字典序排序。

2、将三个参数字符串拼接成一个字符串进行 sha1 加密。

3、开发者获得加密后的字符串可与 signature 对比，标识该请求来源于微信。

**（2）代码实现。**

**创建 MessageController。**

```java
package com.myxh.smart.planet.wechat.controller;

import com.myxh.smart.planet.wechat.utils.SHA1;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@RestController
@RequestMapping("/api/wechat/message")
public class MessageController
{
    private static final String token = "SmartPlanet";

    /**
     * 服务器有效性验证
     *
     * @param request 请求
     * @return echostr 随机字符串
     */
    @GetMapping
    public String verifyToken(HttpServletRequest request)
    {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        System.out.println("signature: " + signature + " nonce: " + nonce + " echostr: " + echostr + "timestamp: " + timestamp);

        if (this.checkSignature(signature, timestamp, nonce))
        {
            System.out.println("token ok");

            return echostr;
        }

        return echostr;
    }

    private boolean checkSignature(String signature, String timestamp, String nonce)
    {
        String[] str = new String[]{token, timestamp, nonce};

        // 排序
        Arrays.sort(str);

        // 拼接字符串
        StringBuilder buffer = new StringBuilder();

        for (String s : str)
        {
            buffer.append(s);
        }

        // 进行 SHA1 加密
        String temp = SHA1.encode(buffer.toString());

        // 与微信提供的 signature 进行匹对
        return signature.equals(temp);
    }
}
```

完成之后，校验接口就算是开发完成了。接下来就可以开发消息接收接口了。

##### 2.3、消息接收

接下来开发消息接收接口，消息接收接口和上面的服务器校验接口地址是一样的，都是一开始在公众号后台配置的地址。只不过消息接收接口是一个 POST 请求。

在公众号后台配置的时候，消息加解密方式选择了明文模式，这样在后台收到的消息直接就可以处理了。微信服务器给我发来的普通文本消息格式如下：

```xml
<xml>
    <ToUserName><![CDATA[toUser]]></ToUserName>
    <FromUserName><![CDATA[fromUser]]></FromUserName>
    <CreateTime>1348831860</CreateTime>
    <MsgType><![CDATA[text]]></MsgType>
    <Content><![CDATA[this is a test]]></Content>
    <MsgId>1234567890123456</MsgId>
    <MsgDataId>xxxx</MsgDataId>
    <Idx>xxxx</Idx>
</xml>
```

| 参数         | 描述                                                      |
| ------------ | --------------------------------------------------------- |
| ToUserName   | 开发者微信号。                                            |
| FromUserName | 发送方帐号（一个 OpenID）。                               |
| CreateTime   | 消息创建时间（整型）。                                    |
| MsgType      | 消息类型，文本为 text。                                   |
| Content      | 文本消息内容。                                            |
| MsgId        | 消息 id，64 位整型。                                      |
| MsgDataId    | 消息的数据 ID（消息如果来自文章时才有）。                 |
| Idx          | 多图文时第几篇文章，从 1 开始（消息如果来自文章时才有）。 |

看到这里，心里大概就有数了，当收到微信服务器发来的消息之后，就进行 XML 解析，提取出来需要的信息，去做相关的查询操作，再将查到的结果返回给微信服务器。

这里先来个简单的，将收到的消息解析并打印出来：

```java
package com.myxh.smart.planet.wechat.controller;

import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@RestController
@RequestMapping("/api/wechat/message")
public class MessageController
{
    /**
     * 接收微信服务器发送来的消息
     *
     * @param request 请求
     * @return message 消息
     * @throws Exception 异常
     */
    @PostMapping
    public String receiveMessage(HttpServletRequest request) throws Exception
    {
        WxMpXmlMessage wxMpXmlMessage = WxMpXmlMessage.fromXml(request.getInputStream());
        System.out.println(JSONObject.toJSONString(wxMpXmlMessage));

        return "success";
    }

    private Map<String, String> parseXml(HttpServletRequest request) throws Exception
    {
        Map<String, String> map = new HashMap<>();
        InputStream inputStream = request.getInputStream();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();

        for (Element e : elementList)
        {
            map.put(e.getName(), e.getText());
        }

        inputStream.close();
        inputStream = null;

        return map;
    }
}
```

#### 3、配置内网穿透(ngrok)

##### 3.1、注册用户

网址：https://ngrok.cc/login/register

![注册用户](https://img-blog.csdnimg.cn/b6255e993e0041919659b3096f8054b0.png)

##### 3.2、实名认证

**（1）注册成功之后，登录系统，进行实名认证，认证费 2 元，认证通过后才能开通隧道。**

![实名认证](https://img-blog.csdnimg.cn/81784c23ebe240e5872c88836dba8237.png)

##### 3.3、开通隧道

**（1）选择隧道管理 -> 开通隧道。**

**最后一个是免费服务器，建议选择付费服务器，10 元/月，因为免费服务器使用人数很多，经常掉线。**

![开通隧道](https://img-blog.csdnimg.cn/f2a83b39b9f4495b8955eb981cd47946.png)

**（2）点击立即购买 -> 输入相关信息。**

![开通隧道](https://img-blog.csdnimg.cn/d0df65ecd63a496daab9d1dd430e7c78.png)

**（3）开通成功后，查看开通的隧道。**

**这里开通了两个隧道，一个用于后端接口调用，一个用于公众号前端调用。**

![开通隧道](https://img-blog.csdnimg.cn/14eef8f625bf4fc2b1665b74f04536de.png)

![开通隧道](https://img-blog.csdnimg.cn/8d8b863f1789486e8a639add7eb1966d.png)

##### 3.4、启动隧道

**（1）下载客户端工具。**

![启动隧道](https://img-blog.csdnimg.cn/e95a0cb0438f43b893e5b87e89fbf9c4.png)

**（2）选择 windows 版本。**

![启动隧道](https://img-blog.csdnimg.cn/5e19e1db10234721a0504f9e68733e0b.png)

**（3）解压，找到 bat 文件，双击启动。**

![启动隧道](https://img-blog.csdnimg.cn/0c2c83a165cb464d8aac4c03ec70e81f.png)

**（4）输入隧道 id，多个使用逗号隔开，最后回车就可以启动。**

![启动隧道](https://img-blog.csdnimg.cn/49e3b089b0cb405c9030a7985d08d7c2.png)

![启动隧道](https://img-blog.csdnimg.cn/789fedbeef1448babc50e62d3b0e7229.png)

##### 3.5、测试

**启动服务，在智慧星球公众号发送文本消息测试效果。**

#### 4、消息业务实现

##### 4.1、service-vod 模块创建接口

**（1）创建 CourseApiController 方法，根据课程关键字查询课程信息。**

![service-vod 模块创建接口](https://img-blog.csdnimg.cn/52cd8edd79ab4e31ba3f34d5e84462d0.png)

```java
package com.myxh.smart.planet.vod.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@RestController
@RequestMapping("/api/vod/course")
public class CourseApiController
{
    @Autowired
    private CourseService courseService;

    /**
     * 根据关键字查询课程
     * @param keyword 关键字
     * @return courseList 课程信息
     */
    @Operation(summary = "根据关键字查询课程", description = "根据关键字查询课程")
    @GetMapping("inner/find/by/keyword/{keyword}")
    public List<Course> findByKeyword(
            @Parameter(name = "keyword",description = "关键字", required = true)
            @PathVariable("keyword") String keyword)
    {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", keyword);
        List<Course> courseList = courseService.list(queryWrapper);

        return courseList;
    }
}
```

##### 4.2、创建模块定义接口

**（1）service-client 下创建子模块 service-course-client。**

![创建模块定义接口](https://img-blog.csdnimg.cn/0c5c410f5b0b489cbae8006a3ed7004f.png)

**（2）定义根据关键字查询课程接口。**

```java
package com.myxh.smart.planet.client.course;

import com.myxh.smart.planet.model.vod.Course;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@FeignClient("service-vod")
public interface CourseFeignClient
{
    @Operation(summary = "根据关键字查询课程", description = "根据关键字查询课程")
    @GetMapping("/api/vod/course/inner/find/by/keyword/{keyword}")
    List<Course> findByKeyword(@PathVariable("keyword") String keyword);
}
```

##### 4.3、service-wechat 引入依赖

```xml
<!-- service-course-client -->
<dependency>
    <groupId>com.myxh.smart.planet</groupId>
    <artifactId>service-course-client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

##### 4.4、service-wechat 模块实现方法

**（1）MessageService**

```java
package com.myxh.smart.planet.wechat.service;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/17
 */
public interface MessageService
{
    /**
     * 接收微信服务器发送来的消息
     *
     * @param param 请求参数
     * @return message 消息
     */
    String receiveMessage(Map<String, String> param);
}
```

**（2）MessageServiceImpl**

```java
package com.myxh.smart.planet.wechat.service.impl;

import com.myxh.smart.planet.client.course.CourseFeignClient;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.wechat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@Service
public class MessageServiceImpl implements MessageService
{
    @Autowired
    private CourseFeignClient courseFeignClient;

    /**
     * 接收微信服务器发送来的消息
     *
     * @param param 请求参数
     * @return message 消息
     */
    @Override
    public String receiveMessage(Map<String, String> param)
    {
        String content;

        try
        {
            String msgType = param.get("MsgType");

            // 判断是什么类型消息
            switch (msgType)
            {
                // 普通文本类型，输入关键字 Java
                case "text":
                    content = this.search(param);
                    break;
                // 事件类型
                case "event":
                    String event = param.get("Event");
                    String eventKey = param.get("EventKey");

                    if ("subscribe".equals(event))
                    {
                        // 关注公众号
                        content = this.subscribe(param);
                    }
                    else if ("unsubscribe".equals(event))
                    {
                        // 取消关注公众号
                        content = this.unsubscribe(param);
                    }
                    else if ("CLICK".equals(event) && "aboutUs".equals(eventKey))
                    {
                        // 关于我们
                        content = this.aboutUs(param);
                    }
                    else
                    {
                        content = "success";
                    }
                    break;
                default:
                    // 其他情况
                    content = "success";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            content = this.text(param, "请重新输入关键字，没有匹配到相关视频课程").toString();
        }

        return content;
    }

    /**
     * 处理关键字搜索事件
     * 图文消息个数；当用户发送文本、图片、语音、视频、图文、地理位置这六种消息时，开发者只能回复 1 条图文消息；其余场景最多可回复 8 条图文消息
     *
     * @param param 请求参数
     * @return message 消息
     */
    private String search(Map<String, String> param)
    {
        String fromUsername = param.get("FromUserName");
        String toUsername = param.get("ToUserName");
        String content = param.get("Content");

        // 单位为秒，不是毫秒
        long createTime = new Date().getTime() / 1000;
        StringBuffer text = new StringBuffer();
        List<Course> courseList = courseFeignClient.findByKeyword(content);

        if (CollectionUtils.isEmpty(courseList))
        {
            text = this.text(param, "请重新输入关键字，没有匹配到相关视频课程");
        }
        else
        {
            // 一次只能返回一个
            Random random = new Random();
            int num = random.nextInt(courseList.size());
            Course course = courseList.get(num);

            String articles = "<item>" +
                    "<Title><![CDATA[" + course.getTitle() + "]]></Title>" +
                    "<Description><![CDATA[" + course.getTitle() + "]]></Description>" +
                    "<PicUrl><![CDATA[" + course.getCover() + "]]></PicUrl>" +
                    "<Url><![CDATA[http://smartplanetmobile.free.idcfengye.com/#/live/info/" + course.getId() + "]]></Url>" +
                    "</item>";

            text.append("<xml>");
            text.append("<ToUserName><![CDATA[").append(fromUsername).append("]]></ToUserName>");
            text.append("<FromUserName><![CDATA[").append(toUsername).append("]]></FromUserName>");
            text.append("<CreateTime><![CDATA[").append(createTime).append("]]></CreateTime>");
            text.append("<MsgType><![CDATA[news]]></MsgType>");
            text.append("<ArticleCount><![CDATA[1]]></ArticleCount>");
            text.append("<Articles>");
            text.append(articles);
            text.append("</Articles>");
            text.append("</xml>");
        }

        return text.toString();
    }

    /**
     * 回复文本
     *
     * @param param   请求参数
     * @param content 上下文
     * @return message 消息
     */
    private StringBuffer text(Map<String, String> param, String content)
    {
        String fromUsername = param.get("FromUserName");
        String toUsername = param.get("ToUserName");

        // 单位为秒，不是毫秒
        long createTime = new Date().getTime() / 1000;
        StringBuffer text = new StringBuffer();

        text.append("<xml>");
        text.append("<ToUserName><![CDATA[").append(fromUsername).append("]]></ToUserName>");
        text.append("<FromUserName><![CDATA[").append(toUsername).append("]]></FromUserName>");
        text.append("<CreateTime><![CDATA[").append(createTime).append("]]></CreateTime>");
        text.append("<MsgType><![CDATA[text]]></MsgType>");
        text.append("<Content><![CDATA[").append(content).append("]]></Content>");
        text.append("</xml>");

        return text;
    }

    /**
     * 处理关注事件
     *
     * @param param 请求参数
     * @return message 消息
     */
    private String subscribe(Map<String, String> param)
    {
        return this.text(param, "感谢你关注“智慧星球”，可以根据关键字搜索你想看的视频教程，如：Java 基础、Spring Boot、大数据等。").toString();
    }

    /**
     * 处理取消关注事件
     *
     * @param param 请求参数
     * @return message 消息
     */
    private String unsubscribe(Map<String, String> param)
    {
        return "success";
    }

    /**
     * 关于我们
     *
     * @param param 请求参数
     * @return message 消息
     */
    private String aboutUs(Map<String, String> param)
    {
        StringBuffer message = this.text(param, "智慧星球现开设 Java、HTML5 前端 + 全栈、大数据、全链路 UI/UE 设计、人工智能、大数据运维 + Python 自动化、Android + HTML5 混合开发等多门课程；" +
                "同时，通过视频分享、智慧星球在线课堂、大厂学苑直播课堂等多种方式，满足了全国编程爱好者对多样化学习场景的需求，已经为行业输送了大量 IT 技术人才。");

        return message.toString();
    }
}
```

##### 4.5、更改 MessageController 方法

```java
package com.myxh.smart.planet.wechat.controller;

import com.myxh.smart.planet.wechat.service.MessageService;
import jakarta.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@RestController
@RequestMapping("/api/wechat/message")
public class MessageController
{
    @Autowired
    private MessageService messageService;

    /**
     * 接收微信服务器发送来的消息
     *
     * @param request 请求
     * @return message 消息
     * @throws Exception 异常
     */
    @PostMapping
    public String receiveMessage(HttpServletRequest request) throws Exception
    {
        /*
        WxMpXmlMessage wxMpXmlMessage = WxMpXmlMessage.fromXml(request.getInputStream());
        System.out.println(JSONObject.toJSONString(wxMpXmlMessage));

        return "success";
         */

        Map<String, String> param = this.parseXml(request);
        String message = messageService.receiveMessage(param);

        return message;
    }

    private Map<String, String> parseXml(HttpServletRequest request) throws Exception
    {
        Map<String, String> map = new HashMap<>();
        InputStream inputStream = request.getInputStream();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();

        for (Element e : elementList)
        {
            map.put(e.getName(), e.getText());
        }

        inputStream.close();
        inputStream = null;

        return map;
    }
}
```

#### 5、测试公众号消息

**（1）点击个人 -> 关于我们，返回关于我们的介绍。**

![测试公众号消息](https://img-blog.csdnimg.cn/e152a55907de441e8cc0196f743306cb.png)

**（2）在公众号输入关键字，返回搜索的课程信息。**

![测试公众号消息](https://img-blog.csdnimg.cn/e1c507ec36a049799e48cdbb0567b226.png)

### 二、公众号模板消息

#### 1、实现目标

购买课程支付成功微信推送消息。

#### 2、模板消息实现

接口文档：https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html

#### 3、申请模板消息

首先需要知道，模板消息是需要申请的。

但是在申请时还是有一些东西要注意，这个在官方的文档有非常详细的说明。

https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Operation_Specifications.html

![申请模板消息](https://img-blog.csdnimg.cn/21568d4ad8cf4c76a74cd4ff3732cae2.png)

这个好好看看。选择行业的时候可要谨慎些，因为这个一个月只可以修改一次。

下面看看在哪里申请，智慧星球已经申请过，忽略。

![申请模板消息](https://img-blog.csdnimg.cn/32e4d576dad4440f8c62f3012535d052.png)

申请之后就耐心等待，审核通过之后就会出现“广告与服务”模板消息的菜单。

![申请模板消息](https://img-blog.csdnimg.cn/d218a7c6fed849299235e54ae7b86bfd.png)

#### 4、添加模板消息

审核通过之后，就可以添加模板消息，进行开发了。

点击模板消息进入后，直接在模板库中选择你需要的消息模板添加就可以了，添加之后就会在我的模板中。会有一个模板 id，这个模板 id 在发送消息的时候会用到。

模板消息如下：

![添加模板消息](https://img-blog.csdnimg.cn/7abf6395f6ea42d09dd479844c322249.png)

需要模板消息：

​1、订单支付成功通知。

模板库中没有的模板，可以自定义模板，审核通过后可以使用。

#### 5、公众号测试号申请模板消息

##### 5.1、新增测试模板

![新增测试模板](https://img-blog.csdnimg.cn/eecd8cb8e47e4c3a9866b5d7691b65ea.png)

##### 5.2、填写信息

**（1）下载示例参考。**

下载地址：https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Operation_Specifications.html

![下载示例参考](https://img-blog.csdnimg.cn/22b4201a366649508e97de7488b539da.png)

![下载示例参考](https://img-blog.csdnimg.cn/d8bb9807976d41b6ad37b33bc35b3360.png)

**（2）填写模板标题和模板内容。**

![填写模板标题和模板内容](https://img-blog.csdnimg.cn/3cda5f9748aa49f7ab3c98b4ce71dc99.png)

#### 6、模板消息接口封装

##### 6.1、MessageController

**添加方法。**

```java
package com.myxh.smart.planet.wechat.controller;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.wechat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@RestController
@RequestMapping("/api/wechat/message")
public class MessageController
{
    @Autowired
    private MessageService messageService;

    /**
     * 推送支付消息
     *
     * @return Result 全局统一返回结果
     */
    @GetMapping("/push/pay/message")
    public Result<Void> pushPayMessage()
    {
        messageService.pushPayMessage(1L);

        return Result.ok(null);
    }
}
```

##### 6.2、service 接口

**MessageService**

```java
package com.myxh.smart.planet.wechat.service;

/**
 * @author MYXH
 * @date 2023/10/17
 */
public interface MessageService
{
    /**
     * 推送支付消息，订单成功
     */
    void pushPayMessage(long orderId);
}
```

##### 6.3、service 接口实现

**（1）MessageServiceImpl 类。**

**（2）openid 值。**

![openid 值](https://img-blog.csdnimg.cn/8fe28fd55c5a406d9d72b18d1e32a9af.png)

**（3）模板 id 值。**

![模板 id 值](https://img-blog.csdnimg.cn/0cee3586e2794f05abc56a940c431de1.png)

```java
package com.myxh.smart.planet.wechat.service.impl;

import com.myxh.smart.planet.wechat.service.MessageService;
import lombok.SneakyThrows;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@Service
public class MessageServiceImpl implements MessageService
{
    @Autowired
    private WxMpService wxMpService;

    /**
     * 推送支付消息，订单成功
     * 暂时写成固定值测试，后续完善
     */
    @SneakyThrows
    @Override
    public void pushPayMessage(long orderId)
    {
        // 微信 openid
        String openid = "oxM4d64iKq9SD6lduBKcF4MQTjF8";
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                // 要推送的用户 openid
                .toUser(openid)
                // 模板 id
                .templateId("URQAUtz9-IrYVFwsuI5Ul4pKUcRFKGmOTwRAb6lscJM")
                // 点击模板消息要访问的网址
                .url("http://smartplanet.free.idcfengye.com/#/pay/" + orderId)
                .build();

        // 如果是正式版发送消息，这里需要配置信息
        templateMessage.addData(new WxMpTemplateData("first", "亲爱的用户：您有一笔订单支付成功。", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword1", "20231123180908744", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword2", "Java基础课程", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword3", "2023-11-23", "#272727"));
        templateMessage.addData(new WxMpTemplateData("keyword4", "100", "#272727"));
        templateMessage.addData(new WxMpTemplateData("remark", "感谢你购买课程，如有疑问，随时咨询！", "#272727"));
        String message = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        System.out.println(message);
    }
}
```

##### 6.4、通过 swagger 测试效果

**（1）在公众号可以看到发送的模板消息。**

![通过 swagger 测试效果](https://img-blog.csdnimg.cn/e7f3ffc9be9e4335893308052a7a9006.png)

### 三、微信授权登录

#### 1、需求描述

根据流程图通过菜单进入的页面都要授权登录

![需求描述](https://img-blog.csdnimg.cn/9c2d29f7edf44597accb0487db078b8d.png)

#### 2、授权登录

接口文档：https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html

说明：

​1、严格按照接口文档实现。

2、应用授权作用域 scope：scope 为 snsapi_userinfo。

##### 2.1、配置授权回调域名

**（1）在公众号正式号配置。**

在微信公众号请求用户网页授权之前，开发者需要先到公众平台官网中的“设置与开发 - 接口权限 - 网页服务 - 网页帐号 - 网页授权获取用户基本信息”的配置选项中，修改授权回调域名。请注意，这里填写的是域名（是一个字符串），而不是 URL，因此请勿加 http:// 等协议头。

本地测试配置内网穿透地址。

![在公众号正式号配置](https://img-blog.csdnimg.cn/26190fa8ae324b119f8c1db7e23ecd0d.png)

**（2）在公众号测试号配置。**

![在公众号测试号配置](https://img-blog.csdnimg.cn/044b53a4dfed428bab0c6b551e9d5a17.png)

![在公众号测试号配置](https://img-blog.csdnimg.cn/00dcc6bb378741f0b24e814bb9a19892.png)

##### 2.2、部署公众号前端页面

**（1）公众号前端页面已经开发完成，直接部署使用即可。**

![部署公众号前端页面](https://img-blog.csdnimg.cn/ab0e53e2bc6240abac20eecf3f8b1580.png)

**（2）启动公众号页面项目**

**使用命令：npm run serve。**

![部署公众号前端页面](https://img-blog.csdnimg.cn/13b0b9f475014cf9a861041cc3f9d20c.png)

##### 2.3、前端处理

**（1）全局处理授权登录，处理页面：/src/App.vue。**

**说明 1：访问页面时首先判断是否有 token 信息，如果没有跳转到授权登录接口。**

**说明 2：通过 localStorage 存储 token 信息。**

在 HTML5 中，加入了一个**localStorage**特性，这个特性主要是用来作为本地存储来使用的，解决了 cookie 存储空间不足的问题(cookie 中每条 cookie 的存储空间很小，只有几 K)，localStorage 中一般浏览器支持的是 5M 大小，这个在不同的浏览器中 localStorage 会有所不同。它只能存储字符串格式的数据，所以最好在每次存储时把数据转换成 json 格式，取出的时候再转换回来。

**（2）前端代码实现。**

```javascript
<template>
  <div id="app">
    <div id="nav">
      <!-- <router-link to="/">列表页</router-link> | -->
      <!-- <router-link to="/info">详情页</router-link> | -->
      <!-- <router-link to="/list">列表页</router-link> | -->
      <!-- <router-link to="/order">下单页</router-link> -->
      <van-button round block type="info" @click="clearData"
        >清空 localStorage</van-button
      >
    </div>
    <router-view />
  </div>
</template>

<script>
import userInfoAPI from "@/api/userInfo";

export default {
  data() {
    return {
      show: true,
    };
  },

  created() {
    // 处理微信授权登录
    this.wechatLogin();
  },

  methods: {
    wechatLogin() {
      // 处理微信授权登录
      let token = this.getQueryString("token") || "";

      if (token != "") {
        window.localStorage.setItem("token", token);
      }

      // 所有页面都必须登录，两次调整登录，这里与接口返回 208 状态
      token = window.localStorage.getItem("token") || "";

      if (token == "") {
        let url = window.location.href.replace("#", "smartplanet");
        window.location =
          "http://smartplanet.free.idcfengye.com/api/user/wechat/authorize?returnUrl=" +
          url;
      }

      console.log("token：" + window.localStorage.getItem("token"));

      //绑定手机号处理
      /*
      if (token != "") {
        this.bindPhone();
      }
       */
    },

    bindPhone() {
      let userInfoString = window.localStorage.getItem("userInfo") || "";
      alert("userInfoString:" + userInfoString);

      if (userInfoString != "") {
        alert("userInfoString:" + userInfoString);
        let userInfo = JSON.parse(userInfoString);
        let phone = userInfo.phone || "";

        if (phone == "") {
          this.$router.push({ path: "/bindFirst" });
        }
      } else {
        alert("userInfoString:" + userInfoString);
        userInfoAPI.getCurrentUserInfo().then((response) => {
          window.localStorage.setItem(
            "userInfo",
            JSON.stringify(response.data)
          );
          alert("data:" + JSON.stringify(response.data));
          let phone = response.data.phone || "";
          console.log("phone:" + phone);

          if (phone == "") {
            this.$router.push({ path: "/bindFirst" });
          }
        });
      }
    },

    getQueryString(paramName) {
      if (window.location.href.indexOf("?") == -1) return "";

      let searchString = window.location.href.split("?")[1];
      let i,
        val,
        params = searchString.split("&");

      for (i = 0; i < params.length; i++) {
        val = params[i].split("=");

        if (val[0] == paramName) {
          return val[1];
        }
      }

      return "";
    },

    clearData() {
      window.localStorage.setItem("token", "");
      window.localStorage.setItem("userInfo", "");
      let token = window.localStorage.getItem("token");
      alert("token:" + token);
    },
  },
};
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
```

#### 3、授权登录接口

**操作模块：service-user。**

##### 3.1、引入微信工具包

```xml
<!-- aliyun-java-sdk-core -->
<dependency>
    <groupId>com.aliyun</groupId>
    <artifactId>aliyun-java-sdk-core</artifactId>
</dependency>

<!-- weixin-java-mp -->
<dependency>
    <groupId>com.github.binarywang</groupId>
    <artifactId>weixin-java-mp</artifactId>
    <version>4.5.0</version>
</dependency>

<!-- dom4j -->
<dependency>
    <groupId>dom4j</groupId>
    <artifactId>dom4j</artifactId>
    <version>1.4</version>
</dependency>
```

##### 3.2、添加配置

```properties
# 公众号 id 和秘钥
# 智慧星球微信公众平台 appId
wechat.appId=wxc23b80b9ffaac7bd
# 智慧星球微信公众平台 api 秘钥
wechat.appSecret=5c0271622c4271753310c436b5cd3532

# 授权回调获取用户信息接口地址
wechat.userInfoUrl: http://smartplanet.free.idcfengye.com/api/user/wechat/user/info
```

##### 3.3、添加工具类

```java
package com.myxh.smart.planet.user.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/10/18
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
```

```java
package com.myxh.smart.planet.user.config;

import com.myxh.smart.planet.user.utils.ConstantPropertiesUtil;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/10/18
 */
@Component
public class WeChatMpConfig
{
    @Autowired
    public WeChatMpConfig(ConstantPropertiesUtil constantPropertiesUtil)
    {

    }

    @Bean
    public WxMpService wxMpService(WxMpConfigStorage wxMpConfigStorage)
    {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage);

        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage()
    {
        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setAppId(ConstantPropertiesUtil.ACCESS_KEY_ID);
        wxMpConfigStorage.setSecret(ConstantPropertiesUtil.ACCESS_KEY_SECRET);

        return wxMpConfigStorage;
    }
}
```

##### 3.4、controller 类

```java
package com.myxh.smart.planet.user.api;

import com.alibaba.fastjson2.JSON;
import com.myxh.smart.planet.jwt.JwtHelper;
import com.myxh.smart.planet.model.user.UserInfo;
import com.myxh.smart.planet.user.service.UserInfoService;
import jakarta.servlet.http.HttpServletRequest;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author MYXH
 * @date 2023/10/18
 */
@Controller
@RequestMapping("/api/user/wechat")
public class WechatController
{
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private WxMpService wxMpService;

    @Value("${wechat.userInfoUrl}")
    private String userInfoUrl;

    /**
     * 授权跳转
     *
     * @param returnUrl 返回 url
     * @param request   请求
     * @return redirectURL 重定向 url
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl, HttpServletRequest request)
    {
        String redirectURL = wxMpService.getOAuth2Service().buildAuthorizationUrl(userInfoUrl,
                WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                URLEncoder.encode(returnUrl.replace("#", "smartplanet"), StandardCharsets.UTF_8));

        return "redirect:" + redirectURL;
    }

    /**
     * 获取用户信息
     *
     * @param code      密码
     * @param returnUrl 返回 url
     * @return redirectURL 重定向 url
     */
    @GetMapping("/user/info")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl)
    {
        try
        {
            // 拿着 code 发送请求
            WxOAuth2AccessToken wxOAuth2AccessToken = this.wxMpService.getOAuth2Service().getAccessToken(code);

            // 获取 openId
            String openId = wxOAuth2AccessToken.getOpenId();
            System.out.println("微信网页授权 openId = " + openId);

            // 获取微信信息
            WxOAuth2UserInfo wxOAuth2UserInfo = wxMpService.getOAuth2Service().getUserInfo(wxOAuth2AccessToken, null);
            System.out.println("微信网页授权 wxOAuth2UserInfo = " + JSON.toJSONString(wxOAuth2UserInfo));

            // 获取微信信息添加到数据库
            UserInfo userInfo = userInfoService.getUserInfoByOpenid(openId);

            if (userInfo == null)
            {
                userInfo = new UserInfo();
                userInfo.setOpenId(openId);
                userInfo.setUnionId(wxOAuth2UserInfo.getUnionId());
                userInfo.setNickName(wxOAuth2UserInfo.getNickname());
                userInfo.setAvatar(wxOAuth2UserInfo.getHeadImgUrl());
                userInfo.setSex(wxOAuth2UserInfo.getSex());
                userInfo.setProvince(wxOAuth2UserInfo.getProvince());
                userInfoService.save(userInfo);
            }

            // 生成 token，按照一定规则生成字符串，可以包含用户信息
            String token = JwtHelper.createToken(userInfo.getId(), userInfo.getNickName());

            // 授权完成之后，跳转具体功能页面
            if (!returnUrl.contains("?"))
            {
                return "redirect:" + returnUrl + "?token=" + token;
            }
            else
            {
                return "redirect:" + returnUrl + "&token=" + token;
            }
        }
        catch (WxErrorException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
```

##### 3.5、编写 UserInfoService

```java
package com.myxh.smart.planet.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.user.UserInfo;
import com.myxh.smart.planet.user.mapper.UserInfoMapper;
import com.myxh.smart.planet.user.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 用户信息 服务实现类
 * </p>
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService
{
    /**
     * 根据 openId 获取用户信息
     *
     * @param openId openId openId
     * @return userInfo 用户信息
     */
    @Override
    public UserInfo getUserInfoByOpenid(String openId)
    {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("open_id", openId);
        UserInfo userInfo = baseMapper.selectOne(wrapper);

        return userInfo;
    }
}
```

##### 3.6、使用 token

**通过 token 传递用户信息。**

###### 3.6.1、JWT 介绍

**JWT 工具。**

JWT（Json Web Token）是为了在网络应用环境间传递声明而执行的一种基于 JSON 的开放标准。

JWT 的声明一般被用来在身份提供者和服务提供者间传递被认证的用户身份信息，以便于从资源服务器获取资源。比如用在用户登录上

JWT 最重要的作用就是对 token 信息的**防伪**作用。

###### 3.6.2、JWT 的原理

一个 JWT 由**三个部分组成：公共部分、私有部分、签名部分**。最后由这三者组合进行 base64 编码得到 JWT。

![JWT 的原理](https://img-blog.csdnimg.cn/93840fbaae2d492c8162f155cec067e9.png)

**（1）公共部分。**

主要是该 JWT 的相关配置参数，比如签名的加密算法、格式类型、过期时间等等。

**（2）私有部分。**

用户自定义的内容，根据实际需要真正要封装的信息。

userInfo{用户的 Id，用户的昵称 nickName}。

**（3）签名部分。**

SaltiP: 当前服务器的 IP 地址{linux 中配置代理服务器的 ip}。

主要用户对 JWT 生成字符串的时候，进行加密{盐值}。

base64 编码，并不是加密，只是把明文信息变成了不可见的字符串。但是其实只要用一些工具就可以把 base64 编码解成明文，所以不要在 JWT 中放入涉及私密的信息。

###### 3.6.3、整合 JWT

**（1）在 service-utils 模块添加依赖。**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>com.myxh.smart.planet</groupId>
        <artifactId>common</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <artifactId>service-utils</artifactId>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- httpclient -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
        </dependency>

        <!-- jjwt -->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
        </dependency>

        <!-- jjwt-impl -->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>

        <!-- jjwt-jackson -->
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.11.5</version>
            <scope>runtime</scope>
        </dependency>

        <!-- 日期时间工具 -->
        <dependency>
            <groupId>joda-time</groupId>
            <artifactId>joda-time</artifactId>
        </dependency>
    </dependencies>
</project>
```

**（2）添加 JWT 工具类。**

```java
package com.myxh.smart.planet.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * @author MYXH
 * @date 2023/10/19
 */
public class JwtHelper
{
    // token 字符串有效时间
    private static final long tokenExpiration = 24 * 60 * 60 * 1000;

    // 加密编码秘钥
    private static final String tokenSignKey = "SmartPlanetSmartPlanetSmartPlanetSmartPlanetSmartPlanetSmartPlanet";

    /**
     * 根据 userId 和 username 生成 token 字符串
     *
     * @param userId   用户 id
     * @param userName 用户姓名
     * @return token 字符串
     */
    public static String createToken(Long userId, String userName)
    {
        String token = Jwts.builder()
                // 设置 token 分类
                .setSubject("SmartPlanet-USER")

                // token 字符串有效时长
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))

                // 私有部分（用户信息）
                .claim("userId", userId)
                .claim("userName", userName)

                // 根据秘钥使用加密编码方式进行加密，对字符串压缩
                .signWith(Keys.hmacShaKeyFor(tokenSignKey.getBytes()), SignatureAlgorithm.HS512)
                .compressWith(CompressionCodecs.GZIP)
                .compact();

        return token;
    }

    /**
     * 从 token字符串获取 userId
     *
     * @param token token字符串
     * @return 用户 id
     */
    public static Long getUserId(String token)
    {
        if (ObjectUtils.isEmpty(token))
        {
            return null;
        }

        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(tokenSignKey.getBytes()).build().parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer) claims.get("userId");

        return userId.longValue();
    }

    /**
     * 从 token 字符串获取 userName
     *
     * @param token token字符串
     * @return userName 用户姓名
     */
    public static String getUserName(String token)
    {
        if (ObjectUtils.isEmpty(token))
        {
            return "";
        }

        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(tokenSignKey.getBytes()).build().parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        String userName = (String) claims.get("userName");

        return userName;
    }

    public static void main(String[] args)
    {
        String token = JwtHelper.createToken(1L, "MYXH");
        System.out.println("token = " + token);
        System.out.println("JwtHelper.getUserId(token) = " + JwtHelper.getUserId(token));
        System.out.println("JwtHelper.getUserName(token) = " + JwtHelper.getUserName(token));
    }
}
```

## Day 13-公众号点播课程和直播管理

### 一、实现公众号点播课程相关功能

#### 1、课程列表和详情

##### 1.1、需求说明

**（1）点击课程中的分类，根据分类查询课程列表。**

![需求说明](https://img-blog.csdnimg.cn/6fcfadf1c94c42ff8a3e0db221629f93.png)

![需求说明](https://img-blog.csdnimg.cn/87d3c4faa78d4854968abfe9540be71d.png)

**（2）点击去看看，进入课程详情页面。**

![需求说明](https://img-blog.csdnimg.cn/216c56e610564b028aeaeea5a6768566.png)

##### 1.2、编写课程列表和详情接口

**（1）创建 CourseApiController。**

```java
package com.myxh.smart.planet.vod.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.vod.CourseQueryVo;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@Tag(name = "课程 API", description = "课程 API 接口")
@RestController
@RequestMapping("/api/vod/course")
public class CourseApiController
{
    @Autowired
    private CourseService courseService;

    /**
     * 根据课程分类查询课程列表（分页）
     *
     * @param subjectParentId 课程一级分类 id
     * @param current         当前页码
     * @param limit           每页记录数
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据课程分类查询课程列表（分页）", description = "根据课程分类查询课程列表（分页）")
    @GetMapping("{subjectParentId}/{current}/{limit}")
    public Result<Map<String, Object>> findCoursePage(@Parameter(name = "subjectParentId", description = "课程一级分类 ID", required = true) @PathVariable Long subjectParentId,
                                                      @Parameter(name = "current", description = "当前页码", required = true) @PathVariable Long current,
                                                      @Parameter(name = "limit", description = "每页记录数", required = true) @PathVariable Long limit)
    {
        // 封装条件
        CourseQueryVo courseQueryVo = new CourseQueryVo();
        courseQueryVo.setSubjectParentId(subjectParentId);

        // 创建 page 对象
        Page<Course> coursePageParam = new Page<>(current, limit);
        Map<String, Object> coursePageMap = courseService.findCoursePage(coursePageParam, courseQueryVo);
        return Result.ok(coursePageMap);
    }

    /**
     * 根据课程 id 查询课程详情信息
     *
     * @param courseId 课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据课程 id 查询课程详情信息", description = "根据课程 id 查询课程详情信息")
    @GetMapping("get/info/{courseId}")
    public Result<Map<String, Object>> getCourseInfo(
            @Parameter(name = "courseId", description = "课程ID", required = true) @PathVariable Long courseId)
    {
        Map<String, Object> courseInfoMap = courseService.getInfoById(courseId);

        return Result.ok(courseInfoMap);
    }
}
```

**（2）编写 CourseService。**

```java
package com.myxh.smart.planet.vod.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vo.vod.CourseQueryVo;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务类
 * </p>
 */
public interface CourseService extends IService<Course>
{
    /**
     * 根据课程分类查询课程列表（分页）
     *
     * @param coursePageParam 课程页面参数
     * @param courseQueryVo   查询对象
     * @return coursePageMap 课程页面
     */
    Map<String, Object> findCoursePage(Page<Course> coursePageParam, CourseQueryVo courseQueryVo);

    /**
     * 根据课程 id 查询课程详情信息
     *
     * @param courseId 课程 id
     * @return courseInfoMap 课程详情信息
     */
    Map<String, Object> getInfoById(Long courseId);
}
```

**（3）编写 CourseServiceImpl。**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.model.vod.CourseDescription;
import com.myxh.smart.planet.model.vod.Subject;
import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.vo.vod.ChapterVo;
import com.myxh.smart.planet.vo.vod.CourseQueryVo;
import com.myxh.smart.planet.vo.vod.CourseVo;
import com.myxh.smart.planet.vod.mapper.CourseMapper;
import com.myxh.smart.planet.vod.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务实现类
 * </p>
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService
{
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseDescriptionService courseDescriptionService;

    @Autowired
    private ChapterService chapterService;

    /**
     * 根据课程分类查询课程列表（分页）
     *
     * @param coursePageParam 课程页面参数
     * @param courseQueryVo   查询对象
     * @return coursePageMap 课程页面
     */
    @Override
    public Map<String, Object> findCoursePage(Page<Course> coursePageParam, CourseQueryVo courseQueryVo)
    {
        // 获取条件值
        // 课程名称
        String title = courseQueryVo.getTitle();

        // 二级分类
        Long subjectId = courseQueryVo.getSubjectId();

        // 一级分类
        Long subjectParentId = courseQueryVo.getSubjectParentId();

        // 教师
        Long teacherId = courseQueryVo.getTeacherId();

        // 判断条件值是否为空，封装条件
        QueryWrapper<Course> wrapper = new QueryWrapper<>();

        if (StringUtils.hasLength(title))
        {
            wrapper.like("title", title);
        }

        if (!ObjectUtils.isEmpty(subjectId))
        {
            wrapper.eq("subject_id", subjectId);
        }

        if (!ObjectUtils.isEmpty(subjectParentId))
        {
            wrapper.eq("subject_parent_id", subjectParentId);
        }

        if (!ObjectUtils.isEmpty(teacherId))
        {
            wrapper.eq("teacher_id", teacherId);
        }

        // 调用方法进行条件分页查询
        Page<Course> pages = baseMapper.selectPage(coursePageParam, wrapper);

        // 获取分页数据
        // 总记录数
        long totalCount = pages.getTotal();

        // 总页数
        long totalPage = pages.getPages();

        // 每页数据集合
        List<Course> coursePageRecords = pages.getRecords();

        // 封装其他数据（获取教师名称和课程分类名称)
        coursePageRecords.stream().forEach(this::getTeacherAndSubjectName);

        Map<String, Object> coursePageMap = new HashMap<>();
        coursePageMap.put("totalCount", totalCount);
        coursePageMap.put("totalPage", totalPage);
        coursePageMap.put("records", coursePageRecords);

        return coursePageMap;
    }

    /**
     * 获取教师和分类名称
     *
     * @param course 课程数据
     * @return course 课程数据
     */
    private Course getTeacherAndSubjectName(Course course)
    {
        // 教师名称
        Long teacherId = course.getTeacherId();
        Teacher teacher = teacherService.getById(teacherId);

        if (teacher != null)
        {
            course.getParam().put("teacherName", teacher.getName());
        }

        // 课程分类名称
        Long subjectParentId = course.getSubjectParentId();
        Subject subjectOne = subjectService.getById(subjectParentId);

        if (subjectOne != null)
        {
            course.getParam().put("subjectParentTitle", subjectOne.getTitle());
        }

        Long subjectId = course.getSubjectId();
        Subject subjectTwo = subjectService.getById(subjectId);

        if (subjectTwo != null)
        {
            course.getParam().put("subjectTitle", subjectTwo.getTitle());
        }

        return course;
    }

    /**
     * 根据课程 id 查询课程详情信息
     *
     * @param courseId 课程 id
     * @return courseInfoMap 课程详情信息
     */
    @Override
    public Map<String, Object> getInfoById(Long courseId)
    {
        // 更新浏览数量
        Course course = baseMapper.selectById(courseId);
        course.setViewCount(course.getViewCount() + 1);
        baseMapper.updateById(course);

        // 课程详情数据
        CourseVo courseVo = baseMapper.selectCourseVoById(courseId);

        // 课程章节小节数据
        List<ChapterVo> chapterVoList = chapterService.getNestedTreeList(courseId);

        // 课程描述信息
        QueryWrapper<CourseDescription> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        CourseDescription courseDescription = courseDescriptionService.getOne(wrapper);

        // 课程所属教师信息
        Teacher teacher = teacherService.getById(course.getTeacherId());

        // 是否购买，后续完善
        Boolean isBuy = false;

        // 封装 map 集合，返回数据
        Map<String, Object> courseInfoMap = new HashMap<>();
        courseInfoMap.put("courseVo", courseVo);
        courseInfoMap.put("chapterVoList", chapterVoList);
        courseInfoMap.put("description", courseDescription != null ? courseDescription.getDescription() : "");
        courseInfoMap.put("teacher", teacher);

        // 是否购买
        courseInfoMap.put("isBuy", isBuy);

        return courseInfoMap;
    }
}
```

**（4）编写 CourseMapper。**

```java
package com.myxh.smart.planet.vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vo.vod.CourseVo;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 Mapper 接口
 * </p>
 */
public interface CourseMapper extends BaseMapper<Course>
{
    /**
     * 根据课程 id 查询课程详情信息
     *
     * @param courseId 课程 id
     * @return courseInfoMap 课程详情信息
     */
    CourseVo selectCourseVoById(Long courseId);
}
```

**（5）编写 CourseMapper.xml。**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.myxh.smart.planet.vod.mapper.CourseMapper">
    <select id="selectCourseVoById" resultType="com.myxh.smart.planet.vo.vod.CourseVo">
        SELECT
        <include refid="columns"/>
        FROM
        <include refid="tables"/>
        WHERE c.id = #{id}
    </select>

    <sql id="columns">
        c.id,
        c.teacher_id as teacherId,
        c.title,
        c.price,
        c.lesson_num AS lessonNum,
        c.cover,
        c.buy_count AS buyCount,
        c.view_count AS viewCount,
        c.status,
        c.publish_time AS publishTime,
        t.name AS teacherName,
        s1.title AS subjectParentTitle,
        s2.title AS subjectTitle
    </sql>

    <sql id="tables">
        `course` AS c
        LEFT OUTER JOIN `teacher` AS t ON c.teacher_id = t.id
        LEFT OUTER JOIN `subject` AS s1 ON c.subject_parent_id = s1.id
        LEFT OUTER JOIN `subject` AS s2 ON c.subject_id = s2.id
    </sql>
</mapper>
```

##### 1.3、整合课程列表和详情前端

**（1）查看路由文件。**

![查看路由文件](https://img-blog.csdnimg.cn/67b6a380b2e049d49bc180c7956fae63.png)

![查看路由文件](https://img-blog.csdnimg.cn/a7adaa070fd84fb99b9e52050e1c8681.png)

**（2）创建 js 文件定义接口。**

![创建 js 文件定义接口](https://img-blog.csdnimg.cn/2f3a1d5af58e4891b64363dab0f15e54.png)

```javascript
import request from "@/utils/request";

const COURSE_API = "/api/vod/course";

export default {
  /**
   * 课程分页列表
   *
   * @param {number} subjectParentId 课程专业父级 id
   * @param {number} pageNo 页面号
   * @param {number} pageSize 页面大小
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findPage(subjectParentId, pageNo, pageSize) {
    return request({
      url: `${COURSE_API}/${subjectParentId}/${pageNo}/${pageSize}`,
      method: "get",
    });
  },

  /**
   * 课程详情
   *
   * @param {number} courseId 课程 id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getInfo(courseId) {
    return request({
      url: `${COURSE_API}/get/info/${courseId}`,
      method: "get",
    });
  },
};
```

**（3）编写页面。**

![编写页面](https://img-blog.csdnimg.cn/1c855d20dcce41fcacd7d7144ad15dba.png)

**course.vue**

```html
<template>
  <div>
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <van-image
      width="100%"
      height="200"
      src="https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png"
    />
    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <!-- offset：滚动条与底部距离小于 offset 时触发load事件 默认300，因此要改小，否则首次进入一直触发  -->
      <van-list
        v-model="loading"
        :finished="finished"
        finished-text="没有更多了"
        offset="10"
        @load="onLoad"
      >
        <van-card
          v-for="(item, index) in list"
          :key="index"
          :price="item.price"
          :title="item.title"
          :thumb="item.cover"
        >
          <template #tags>
            <van-tag round plain color="#ffe1e1" text-color="#ad0000"
              >课时数：{{ item.lessonNum }}</van-tag
            >
            <br />
            <van-tag round plain color="#ffe1e1" text-color="#ad0000"
              >购买数：{{ item.buyCount }}</van-tag
            >
            <br />
            <van-tag round plain color="#ffe1e1" text-color="#ad0000"
              >访问量：{{ item.viewCount }}</van-tag
            >
          </template>
          <template #footer>
            <van-button size="mini" @click="info(item.id)">去看看</van-button>
          </template>
        </van-card>
      </van-list>
    </van-pull-refresh>
  </div>
</template>

<script>
  import courseAPI from "@/api/course";

  export default {
    name: "Course",

    data() {
      return {
        subjectParentId: 1,
        loading: false,
        finished: false,
        refreshing: false,
        pageNo: 1,
        pageSize: 5,
        pages: 1,
        list: [],
      };
    },

    created() {
      this.subjectParentId = this.$route.params.subjectId;
    },

    methods: {
      onLoad() {
        this.fetchData();
      },

      onRefresh() {
        // 清空列表数据
        this.finished = false;
        this.pageNo = 1;

        // 重新加载数据
        // 将 loading 设置为 true，表示处于加载状态
        this.loading = true;
        this.fetchData();
      },

      fetchData() {
        courseAPI
          .findPage(this.subjectParentId, this.pageNo, this.pageSize)
          .then((response) => {
            console.log(response.data);

            if (this.refreshing) {
              this.list = [];
              this.refreshing = false;
            }

            for (let i = 0; i < response.data.records.length; i++) {
              this.list.push(response.data.records[i]);
            }

            this.pages = response.data.totalPage;
            this.loading = false;

            if (this.pageNo >= this.pages) {
              this.finished = true;
            }

            this.pageNo++;
          });
      },

      info(id) {
        this.$router.push({ path: "/course/info/" + id });
      },
    },
  };
</script>

<style lang="scss" scoped>
  .list {
    li {
      margin: 10px;
      padding-bottom: 5px;
      border-bottom: 1px solid #e5e5e5;

      h1 {
        font-size: 20px;
      }

      .list-box {
        display: flex;
        font-size: 14px;

        ul {
          flex: 1;
          margin: 0;

          li {
            margin: 0;
            border-bottom: none;
          }
        }

        p {
          margin: 0;
          width: 50px;
          align-items: center;
          align-self: flex-end;
        }
      }
    }
  }
</style>
```

**courseInfo.vue**

```html
<template>
  <div>
    <van-image width="100%" height="200" :src="courseVo.cover" />
    <van-row>
      <van-col span="8">
        <div class="course_count">
          <h1>购买数</h1>
          <p>{{ courseVo.buyCount }}</p>
        </div>
      </van-col>
      <van-col span="8">
        <div class="course_count">
          <h1>课时数</h1>
          <p>{{ courseVo.lessonNum }}</p>
        </div>
      </van-col>
      <van-col span="8">
        <div class="course_count">
          <h1>浏览数</h1>
          <p>{{ courseVo.viewCount }}</p>
        </div>
      </van-col>
    </van-row>

    <h1 class="van-ellipsis course_title">{{ courseVo.title }}</h1>

    <div class="course_teacher_price_box">
      <div class="course_teacher_price">
        <div class="course_price">价格：</div>
        <div class="course_price_number">￥{{ courseVo.price }}</div>
      </div>
      <div>
        <van-button
          @click="see()"
          v-if="isBuy || courseVo.price == '0.00'"
          plain
          type="warning"
          size="mini"
          >立即观看</van-button
        >
        <van-button @click="buy" v-else plain type="warning" size="mini"
          >立即购买</van-button
        >
      </div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_teacher_box">
        <div class="course_teacher">教师： {{ teacher.name }}</div>
        <van-image :src="teacher.avatar" round width="50px" height="50px" />
      </div>
    </div>

    <div class="course_contents">
      <div class="course_title_font">课程详情</div>
      <van-divider :style="{ margin: '5px 0 ' }" />
      <div class="course_content" v-html="description"></div>

      <div class="course_title_font">课程大纲</div>
      <div class="gap"></div>
      <van-collapse v-model="activeNames">
        <van-collapse-item
          :title="item.title"
          :name="item.id"
          v-for="item in chapterVoList"
          :key="item.id"
        >
          <ul
            class="course_chapter_list"
            v-for="child in item.children"
            :key="child.id"
          >
            <h2>{{ child.title }}</h2>
            <p v-if="child.isFree == 1">
              <van-button @click="play(child)" type="warning" size="mini" plain
                >免费观看</van-button
              >
            </p>
            <p v-else>
              <van-button @click="play(child)" type="warning" size="mini" plain
                >观看</van-button
              >
            </p>
          </ul>
        </van-collapse-item>
      </van-collapse>
    </div>
    <van-loading vertical="true" v-show="loading">加载中...</van-loading>
  </div>
</template>

<script>
  import courseAPI from "@/api/course";
  import shareAPI from "@/api/share";
  import wxShare from "@/utils/wxShare";

  export default {
    data() {
      return {
        loading: false,
        courseId: null,
        courseVo: {},
        description: "",
        teacher: {},
        chapterVoList: [],
        isBuy: false,
        activeNames: ["1"],
      };
    },

    created() {
      this.courseId = this.$route.params.courseId;
      this.fetchData();
    },

    methods: {
      fetchData() {
        this.loading = true;
        courseAPI.getInfo(this.courseId).then((response) => {
          console.log(response.data);
          this.courseVo = response.data.courseVo;
          this.description = response.data.description;
          this.isBuy = response.data.isBuy;
          this.chapterVoList = response.data.chapterVoList;
          this.teacher = response.data.teacher;
          this.loading = false;

          //分享注册
          this.wxRegister();
        });
      },

      buy() {
        this.$router.push({ path: "/trade/" + this.courseId });
      },

      play(video) {
        let videoId = video.id;
        let isFree = video.isFree;

        if (isFree === 1 || this.isBuy || this.courseVo.price == "0.00") {
          this.$router.push({
            path: "/play/" + this.courseId + "/" + videoId,
          });
        } else {
          // this.$router.push({ path: "/play/" + this.courseId + "/" + videoId });

          if (window.confirm("购买了才可以观看, 是否继续？")) {
            this.buy();
          }
        }
      },

      see() {
        this.$router.push({ path: "/play/" + this.courseId + "/0" });
      },

      wxRegister() {
        // 说明：后台加密 url 必须与当前页面 url 一致
        let url = window.location.href.replace("#", "smartplanet");
        shareAPI.getSignature(url).then((response) => {
          console.log(response.data);
          // 记录分享用户
          let link = "";

          if (window.location.href.indexOf("?") != -1) {
            link =
              window.location.href + "&recommend=" + response.data.userEedId;
          } else {
            link =
              window.location.href + "?recommend=" + response.data.userEedId;
          }

          let option = {
            title: this.courseVo.title,
            desc: this.description,
            link: link,
            imgUrl: this.courseVo.cover,
          };

          wxShare.wxRegister(response.data, option);
        });
      },
    },
  };
</script>

<style lang="scss" scoped>
  .gap {
    height: 10px;
  }
  ::v-deep.van-image {
    display: block;
  }
  .course_count {
    background-color: #82848a;
    color: white;
    padding: 5px;
    text-align: center;
    border-right: 1px solid #939393;
    h1 {
      font-size: 14px;
      margin: 0;
    }
    p {
      margin: 0;
      font-size: 16px;
    }
  }

  .course_title {
    font-size: 20px;
    margin: 10px;
  }

  .course_teacher_price_box {
    margin: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    .course_teacher_price {
      display: flex;
      font-size: 14px;
      align-items: center;
      .course_price_number {
        color: red;
        font-size: 18px;
        font-weight: bold;
      }

      .course_teacher {
        margin-left: 20px;
      }
    }
    .course_teacher_box {
      display: flex;
      justify-content: center;
      align-items: center;

      .course_teacher {
        margin-right: 20px;
      }
    }
  }

  .course_contents {
    margin: 10px;
    .course_title_font {
      color: #68cb9b;
      font-weight: bold;
    }
    .course_content {
      margin-bottom: 20px;
    }
  }

  .course_chapter_list {
    display: flex;
    justify-content: space-between;
    align-items: center;
    h2 {
      font-size: 14px;
    }
    p {
      margin: 0;
    }
  }
</style>
```

#### 2、点播视频播放

![点播视频播放](https://img-blog.csdnimg.cn/8eb5ad5cd62b445ea4ef1630440cc299.png)

##### 1.1、获取视频播放参数

**（1）创建 VodApiController。**

```java
package com.myxh.smart.planet.vod.api;

import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.VodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/20
 */
@Tag(name = "腾讯云点播 API", description = "腾讯云点播 API 接口")
@RestController
@RequestMapping("/api/vod")
public class VodApiController
{
    @Autowired
    private VodService vodService;

    /**
     * 获取播放凭证
     *
     * @param courseId 课程 id
     * @param videoId  视频 id
     * @return Result 全局统一返回结果
     */
    @Operation()
    @GetMapping("get/play/auth/{courseId}/{videoId}")
    public Result<Map<String, Object>> getPlayAuth(
            @Parameter(name = "courseId", description = "课程ID", required = true)
            @PathVariable("courseId") Long courseId,
            @Parameter(name = "videoId", description = "视频ID", required = true)
            @PathVariable("videoId") Long videoId)
    {
        Map<String, Object> playAuthMap = vodService.getPlayAuth(courseId, videoId);

        return Result.ok(playAuthMap);
    }
}
```

**（2）application.properties 添加。**

```properties
# 设置点播账号的子应用 appID
tencent.video.appid=1315007088
```

**（3）service-vod 引入依赖。**

```xml
<!-- java-jwt -->
<dependency>
    <groupId>com.auth0</groupId>
    <artifactId>java-jwt</artifactId>
    <version>3.10.0</version>
</dependency>
```

**（4）创建 Psign 类。**

```java
package com.myxh.smart.planet.vod.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.HashMap;

/**
 * @author MYXH
 * @date 2023/10/21
 */
public class Psign
{
    public static String getPsign(Integer appId, String fileId)
    {
        // 点播应用 appId
        Integer AppId = appId;

        // 点播文件 ID
        String FileId = fileId;

        // 播放的音视频类型，可选值
        // RawAdaptive：未加密的，转自适应码流，输出。
        // ProtectedAdaptive：私有加密或 DRM 保护的，转自适应码流，输出
        // Transcode：转码后输出
        // Original：上传的原始音视频
        String AudioVideoType = "RawAdaptive";

        Integer RawAdaptiveDefinition = 10;
        Integer ImageSpriteDefinition = 10;

        // 派发签名当前 Unix 时间戳
        Integer CurrentTime = Math.toIntExact(System.currentTimeMillis() / 1000);

        // 播放密钥
        String PlayKey = "cw8EdW6d9indO6f3Uk6s";

        HashMap<String, Object> urlAccessInfo = new HashMap<>();

        HashMap<String, Object> contentInfo = new HashMap<>();
        contentInfo.put("audioVideoType", AudioVideoType);
        contentInfo.put("rawAdaptiveDefinition", RawAdaptiveDefinition);
        contentInfo.put("imageSpriteDefinition", ImageSpriteDefinition);


        Algorithm algorithm = Algorithm.HMAC256(PlayKey);

        String token = JWT.create()
                .withClaim("appId", AppId)
                .withClaim("fileId", FileId)
                .withClaim("contentInfo", contentInfo)
                .withClaim("currentTimeStamp", CurrentTime)
                .withClaim("urlAccessInfo", urlAccessInfo).sign(algorithm);

        return token;
    }
}
```

**（5）VodService 创建方法。**

```java
package com.myxh.smart.planet.vod.service;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/11
 */
public interface VodService
{
    /**
     * 获取播放凭证
     *
     * @param courseId 课程 id
     * @param videoId  视频 id
     * @return playAuthMap 播放凭证
     */
    Map<String, Object> getPlayAuth(Long courseId, Long videoId);
}
```

**（6）VodServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.model.vod.Video;
import com.myxh.smart.planet.vod.service.VideoService;
import com.myxh.smart.planet.vod.service.VodService;
import com.myxh.smart.planet.vod.utils.Psign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/11
 */
@Service
public class VodServiceImpl implements VodService
{
    // @Lazy 注解可以延迟 Bean 的初始化，缓解循环引用
    @Lazy
    @Autowired
    private VideoService videoService;

    @Value("${tencent.video.appid}")
    private String appId;

    /**
     * 获取播放凭证
     *
     * @param courseId 课程 id
     * @param videoId  视频 id
     * @return playAuthMap 播放凭证
     */
    @Override
    public Map<String, Object> getPlayAuth(Long courseId, Long videoId)
    {
        // 根据小节 id 获取小节对象，获取腾讯云视频 id
        Video video = videoService.getById(videoId);

        if (video == null)
        {
            throw new SmartPlanetException(20001, "课程视频信息不存在");
        }

        String videoSourceId = video.getVideoSourceId();
        Integer id = Integer.valueOf(appId);
        String psign = Psign.getPsign(id, videoSourceId);

        Map<String, Object> playAuthMap = new HashMap<>();
        playAuthMap.put("videoSourceId", videoSourceId);
        playAuthMap.put("appId", appId);
        playAuthMap.put("psign", psign);

        return playAuthMap;
    }
}
```

##### 1.2、整合点播视频播放前端

![整合点播视频播放前端](https://img-blog.csdnimg.cn/031ecb99c89b42288a42b7c676878203.png)

![整合点播视频播放前端](https://img-blog.csdnimg.cn/0c4b413f5a904d488c5fe786485a00b5.png)

**（1）创建 js 定义接口。**

![创建 js 定义接口](https://img-blog.csdnimg.cn/e6494abe0853493a83ea1a648e6e09c4.png)

```javascript
import request from "@/utils/request";
const api_name = "/api/vod";
export default {
  // 获取播放凭证
  getPlayAuth(courseId, videoId) {
    return request({
      url: `${api_name}/getPlayAuth/${courseId}/${videoId}`,
      method: "get",
    });
  },
};
```

**（2）courseInfo.vue 修改 play 方法。**

```html
<template>
  <div>
    <van-image width="100%" height="200" :src="courseVo.cover" />
    <van-row>
      <van-col span="8">
        <div class="course_count">
          <h1>购买数</h1>
          <p>{{ courseVo.buyCount }}</p>
        </div>
      </van-col>
      <van-col span="8">
        <div class="course_count">
          <h1>课时数</h1>
          <p>{{ courseVo.lessonNum }}</p>
        </div>
      </van-col>
      <van-col span="8">
        <div class="course_count">
          <h1>浏览数</h1>
          <p>{{ courseVo.viewCount }}</p>
        </div>
      </van-col>
    </van-row>

    <h1 class="van-ellipsis course_title">{{ courseVo.title }}</h1>

    <div class="course_teacher_price_box">
      <div class="course_teacher_price">
        <div class="course_price">价格：</div>
        <div class="course_price_number">￥{{ courseVo.price }}</div>
      </div>
      <div>
        <van-button
          @click="see()"
          v-if="isBuy || courseVo.price == '0.00'"
          plain
          type="warning"
          size="mini"
          >立即观看</van-button
        >
        <van-button @click="buy" v-else plain type="warning" size="mini"
          >立即购买</van-button
        >
      </div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_teacher_box">
        <div class="course_teacher">教师： {{ teacher.name }}</div>
        <van-image :src="teacher.avatar" round width="50px" height="50px" />
      </div>
    </div>

    <div class="course_contents">
      <div class="course_title_font">课程详情</div>
      <van-divider :style="{ margin: '5px 0 ' }" />
      <div class="course_content" v-html="description"></div>

      <div class="course_title_font">课程大纲</div>
      <div class="gap"></div>
      <van-collapse v-model="activeNames">
        <van-collapse-item
          :title="item.title"
          :name="item.id"
          v-for="item in chapterVoList"
          :key="item.id"
        >
          <ul
            class="course_chapter_list"
            v-for="child in item.children"
            :key="child.id"
          >
            <h2>{{ child.title }}</h2>
            <p v-if="child.isFree == 1">
              <van-button @click="play(child)" type="warning" size="mini" plain
                >免费观看</van-button
              >
            </p>
            <p v-else>
              <van-button @click="play(child)" type="warning" size="mini" plain
                >观看</van-button
              >
            </p>
          </ul>
        </van-collapse-item>
      </van-collapse>
    </div>
    <van-loading vertical="true" v-show="loading">加载中...</van-loading>
  </div>
</template>

<script>
  import courseAPI from "@/api/course";
  import shareAPI from "@/api/share";
  import wxShare from "@/utils/wxShare";

  export default {
    data() {
      return {
        loading: false,
        courseId: null,
        courseVo: {},
        description: "",
        teacher: {},
        chapterVoList: [],
        isBuy: false,
        activeNames: ["1"],
      };
    },

    created() {
      this.courseId = this.$route.params.courseId;
      this.fetchData();
    },

    methods: {
      fetchData() {
        this.loading = true;
        courseAPI.getInfo(this.courseId).then((response) => {
          console.log(response.data);
          this.courseVo = response.data.courseVo;
          this.description = response.data.description;
          this.isBuy = response.data.isBuy;
          this.chapterVoList = response.data.chapterVoList;
          this.teacher = response.data.teacher;
          this.loading = false;

          //分享注册
          this.wxRegister();
        });
      },

      buy() {
        this.$router.push({ path: "/trade/" + this.courseId });
      },

      play(video) {
        let videoId = video.id;
        let isFree = video.isFree;

        if (isFree === 1 || this.isBuy || this.courseVo.price == "0.00") {
          this.$router.push({ path: "/play/" + this.courseId + "/" + videoId });
        } else {
          // this.$router.push({ path: "/play/" + this.courseId + "/" + videoId });

          if (window.confirm("购买了才可以观看, 是否继续？")) {
            this.buy();
          }
        }
      },

      see() {
        this.$router.push({ path: "/play/" + this.courseId + "/0" });
      },

      wxRegister() {
        // 说明：后台加密 url 必须与当前页面 url 一致
        let url = window.location.href.replace("#", "smartplanet");
        shareAPI.getSignature(url).then((response) => {
          console.log(response.data);
          // 记录分享用户
          let link = "";

          if (window.location.href.indexOf("?") != -1) {
            link =
              window.location.href + "&recommend=" + response.data.userEedId;
          } else {
            link =
              window.location.href + "?recommend=" + response.data.userEedId;
          }

          let option = {
            title: this.courseVo.title,
            desc: this.description,
            link: link,
            imgUrl: this.courseVo.cover,
          };

          wxShare.wxRegister(response.data, option);
        });
      },
    },
  };
</script>

<style lang="scss" scoped>
  .gap {
    height: 10px;
  }
  ::v-deep.van-image {
    display: block;
  }
  .course_count {
    background-color: #82848a;
    color: white;
    padding: 5px;
    text-align: center;
    border-right: 1px solid #939393;
    h1 {
      font-size: 14px;
      margin: 0;
    }
    p {
      margin: 0;
      font-size: 16px;
    }
  }

  .course_title {
    font-size: 20px;
    margin: 10px;
  }

  .course_teacher_price_box {
    margin: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    .course_teacher_price {
      display: flex;
      font-size: 14px;
      align-items: center;
      .course_price_number {
        color: red;
        font-size: 18px;
        font-weight: bold;
      }

      .course_teacher {
        margin-left: 20px;
      }
    }
    .course_teacher_box {
      display: flex;
      justify-content: center;
      align-items: center;

      .course_teacher {
        margin-right: 20px;
      }
    }
  }

  .course_contents {
    margin: 10px;
    .course_title_font {
      color: #68cb9b;
      font-weight: bold;
    }
    .course_content {
      margin-bottom: 20px;
    }
  }

  .course_chapter_list {
    display: flex;
    justify-content: space-between;
    align-items: center;
    h2 {
      font-size: 14px;
    }
    p {
      margin: 0;
    }
  }
</style>
```

**（3）index.html 引入文件。**

![index.html 引入文件](https://img-blog.csdnimg.cn/fab5dd3d61004db0b630a6f3d2e9e075.png)

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,,chrome=1" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no"
    />
    <title>智慧星球</title>
    <link rel="icon" href="<%= BASE_URL %>favicon.ico" />

    <script
      src="http://res2.wx.qq.com/open/js/jweixin-1.6.0.js"
      type="text/javascript"
    ></script>

    <!-- 引入播放器 css 文件 -->
    <link
      href="https://web.sdk.qcloud.com/player/tcplayer/release/v4.7.2/tcplayer.min.css"
      rel="stylesheet"
    />

    <!-- 如果需要在 Chrome 和 Firefox 等现代浏览器中通过 H5 播放 HLS 协议的视频，需要在 tcplayer.vx.x.x.min.js 之前引入 hls.min.x.xx.xm.js。 -->
    <script src="https://web.sdk.qcloud.com/player/tcplayer/release/v4.7.2/libs/hls.min.1.1.6.js"></script>

    <!-- 如果需要在 Chrome 和 Firefox 等现代浏览器中通过 H5 播放 FLV 格式的视频，需要在 tcplayer.vx.x.x.min.js 之前引入 flv.min.x.x.x.js。 -->
    <script src="https://web.sdk.qcloud.com/player/tcplayer/release/v4.7.2/libs/flv.min.1.6.3.js"></script>

    <!-- 如果需要在 Chrome 和 Firefox 等现代浏览器中通过 H5 播放 DASH 视频，需要在 tcplayer.vx.x.x.min.js 之前引入 dash.min.x.x.x.js。 -->
    <script src="https://web.sdk.qcloud.com/player/tcplayer/release/v4.7.2/libs/dash.all.min.4.5.2.js"></script>

    <!-- 引入播放器 js 文件 -->
    <script src="https://web.sdk.qcloud.com/player/tcplayer/release/v4.7.2/tcplayer.v4.7.2.min.js"></script>
  </head>

  <body>
    <script
      type="text/javascript"
      src="https://static-1.talk-fun.com/open/TalkFun_SDK_Pack/v7.0/TalkFunWebSDK-7.7.min.js"
    ></script>

    <noscript>
      <strong
        >We're sorry but <%= htmlWebpackPlugin.options.title %> doesn't work
        properly without JavaScript enabled. Please enable it to
        continue.</strong
      >
    </noscript>
    <div id="app"></div>
    <!-- built files will be auto injected -->
  </body>
</html>
```

**（4）创建 play.vue 页面。**

```html
<template>
  <div>
    <video
      id="player-container-id"
      preload="auto"
      width="400"
      height="280"
      playsinline
      webkit-playsinline
      x5-playsinline
    ></video>
    <h1 class="van-ellipsis course_title">{{ courseVo.title }}</h1>

    <div class="course_teacher_price_box">
      <div class="course_teacher_price">
        <div class="course_price">价格：</div>
        <div class="course_price_number">￥{{ courseVo.price }}</div>
        <div class="course_teacher">教师： {{ courseVo.teacherName }}</div>
      </div>
      <div>
        <van-button
          @click="getPlayAuth('0')"
          v-if="isBuy || courseVo.price == '0.00'"
          plain
          type="warning"
          size="mini"
          >立即观看</van-button
        >
        <van-button @click="buy" v-else plain type="warning" size="mini"
          >立即购买</van-button
        >
      </div>
    </div>

    <div class="course_contents">
      <div class="course_title_font">课程大纲</div>
      <div class="gap"></div>
      <van-collapse v-model="activeNames">
        <van-collapse-item
          :title="item.title"
          :name="item.id"
          v-for="item in chapterVoList"
          :key="item.id"
        >
          <ul
            class="course_chapter_list"
            v-for="child in item.children"
            :key="child.id"
          >
            <h2 :style="activeVideoId == child.id ? 'color:blue' : ''">
              {{ child.title }}
            </h2>
            <p v-if="child.isFree == 1">
              <van-button @click="see(child)" type="warning" size="mini" plain
                >免费观看</van-button
              >
            </p>
            <p v-else>
              <van-button @click="see(child)" type="warning" size="mini" plain
                >观看</van-button
              >
            </p>
          </ul>
        </van-collapse-item>
      </van-collapse>
    </div>

    <van-loading vertical="true" v-show="loading">加载中...</van-loading>
  </div>
</template>

<script>
  import courseAPI from "@/api/course";
  import vodAPI from "@/api/vod";
  import videoVisitorAPI from "@/api/videoVisitor";

  export default {
    data() {
      return {
        loading: false,
        courseId: null,
        videoId: null,
        courseVo: {},
        description: "",
        chapterVoList: [],
        isBuy: false,
        // firstVideo: null,
        activeNames: ["1"],

        // 记录当前正在播放的视频
        activeVideoId: 0,
        player: null,
      };
    },

    created() {
      this.courseId = this.$route.params.courseId;
      this.videoId = this.$route.params.videoId || "0";
      this.fetchData();
      this.getPlayAuth(this.videoId);
    },

    methods: {
      fetchData() {
        this.loading = true;
        courseAPI.getInfo(this.courseId).then((response) => {
          console.log(response.data);
          this.courseVo = response.data.courseVo;
          this.description = response.data.description;
          this.isBuy = response.data.isBuy;
          this.chapterVoList = response.data.chapterVoList;
          this.loading = false;
        });
      },

      see(video) {
        let videoId = video.id;
        let isFree = video.isFree;
        this.getPlayAuth(videoId);

        if (isFree === 1 || this.isBuy || this.courseVo.price == "0.00") {
          this.getPlayAuth(videoId);
        } else {
          if (window.confirm("购买了才可以观看, 是否继续？")) {
            this.buy();
          }
        }
      },

      buy() {
        this.$router.push({ path: "/trade/" + this.courseId });
      },

      getPlayAuth(videoId) {
        if (this.player != null) {
          // 是销毁之前的视频，不销毁的话，它会一直存在
          this.player.dispose();
        }

        vodAPI.getPlayAuth(this.courseId, videoId).then((response) => {
          console.log(response.data);
          this.play(response.data);

          // 展开章节
          this.activeNames = [response.data.chapterId];
          // 选中播放视频
          this.activeVideoId = response.data.videoId;
        });
      },

      // 视频播放
      play(data) {
        // window.location = './video.html?fileID='+data.videoSourceId+'&appID='+data.appId;
        var player = TCPlayer("player-container-id", {
          // player-container-id 为播放器容器 ID，必须与 html 中一致
          // 请传入需要播放的视频 fileID 必须
          fileID: data.videoSourceId,

          // 请传入点播账号的子应用 appID 必须
          appID: data.appId,

          psign: data.psign,

          // 其他参数请在开发文档中查看
        });
      },
    },
  };
</script>

<style lang="scss" scoped>
  .gap {
    height: 10px;
  }

  ::v-deep.van-image {
    display: block;
  }

  .course_count {
    background-color: #82848a;
    color: white;
    padding: 5px;
    text-align: center;
    border-right: 1px solid #939393;

    h1 {
      font-size: 14px;
      margin: 0;
    }

    p {
      margin: 0;
      font-size: 16px;
    }
  }

  .course_title {
    font-size: 20px;
    margin: 10px;
  }

  .course_teacher_price_box {
    margin: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;

    .course_teacher_price {
      display: flex;
      font-size: 14px;
      align-items: center;

      .course_price_number {
        color: red;
        font-size: 18px;
        font-weight: bold;
      }

      .course_teacher {
        margin-left: 20px;
      }
    }
  }

  .course_contents {
    margin: 10px;

    .course_title_font {
      color: #68cb9b;
      font-weight: bold;
    }

    .course_content {
      margin-bottom: 20px;
    }
  }

  .course_chapter_list {
    display: flex;
    justify-content: space-between;
    align-items: center;

    h2 {
      font-size: 14px;
    }

    p {
      margin: 0;
    }
  }
</style>
```

#### 3、付费观看点播课程接口

##### 3.1、需求介绍

**（1）点击课程详情页立即购买。**

![需求介绍](https://img-blog.csdnimg.cn/2a634b7c58944d928db0ab7625ebdeb1.png)

**（2）点击确认下单，生成课程订单。**

![需求介绍](https://img-blog.csdnimg.cn/7bd461990c4c4998a3c1586b10fbaeb8.png)

##### 3.2、编写创建订单接口

**（1）创建 OrderInfoApiController。**

```java
package com.myxh.smart.planet.order.api;

import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.order.OrderFormVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Tag(name = "订单信息 API", description = "订单信息 API 接口")

@RestController
@RequestMapping("api/order/order/info")
public class OrderInfoApiController
{
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 新增点播课程订单
     *
     * @param orderFormVo 订单信息
     * @param request     请求
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "新增点播课程订单", description = "新增点播课程订单")
    @PostMapping("submit/order")
    public Result<Long> submitOrder(@RequestBody OrderFormVo orderFormVo, HttpServletRequest request)
    {
        // 返回订单 id
        Long orderId = orderInfoService.submitOrder(orderFormVo);

        return Result.ok(orderId);
    }
}
```

**（2）编写 Service。**

**OrderInfoService**

```java
package com.myxh.smart.planet.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.order.OrderInfo;
import com.myxh.smart.planet.vo.order.OrderFormVo;

/**
 * @author MYXH
 * @date 2023/10/14
 *
 * <p>
 * 订单信息 服务类
 * </p>
 */
public interface OrderInfoService extends IService<OrderInfo>
{
    /**
     * 新增点播课程订单
     *
     * @param orderFormVo 订单信息
     * @return orderId 订单 id
     */
    Long submitOrder(OrderFormVo orderFormVo);
}
```

##### 3.3、创建获取课程信息接口

**操作 service-vod 模块。**

**（1）CourseApiController 添加方法。**

```java
package com.myxh.smart.planet.vod.api;

import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@Tag(name = "课程 API", description = "课程 API 接口")
@RestController
@RequestMapping("/api/vod/course")
public class CourseApiController
{
    @Autowired
    private CourseService courseService;

    /**
     * 根据课程 id 查询课程信息
     *
     * @param courseId 课程 id
     * @return 课程信息
     */
    @Operation(summary = "根据课程 id 查询课程信息", description = "根据课程 id 查询课程信息")
    @GetMapping("inner/get/by/id/{courseId}")
    public Course getById(@Parameter(name = "courseId", description = "课程ID", required = true) @PathVariable("courseId") Long courseId)
    {
        Course course = courseService.getById(courseId);

        return course;
    }
}
```

**（2）service-course-client 定义方法。**

![创建获取课程信息接口](https://img-blog.csdnimg.cn/025aacb0fded4a49a4f71840fadb1b67.png)

```java
package com.myxh.smart.planet.client.course;

import com.myxh.smart.planet.model.vod.Course;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@FeignClient("service-vod")
public interface CourseFeignClient
{
    @Operation(summary = "根据课程 id 查询课程信息", description = "根据课程 id 查询课程信息")
    @GetMapping("/api/vod/course/inner/get/by/id/{courseId}")
    Course getById(@Parameter(name = "courseId", description = "课程ID", required = true) @PathVariable("courseId") Long courseId);
}
```

##### 3.4、创建获取优惠券接口

**操作 service-activity 模块。**

**（1）创建 CouponInfoApiController。**

```java
package com.myxh.smart.planet.activity.api;

import com.myxh.smart.planet.activity.service.CouponInfoService;
import com.myxh.smart.planet.model.activity.CouponInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Tag(name = "优惠券信息 API", description = "优惠券信息 API 接口")
@RestController
@RequestMapping("/api/activity/coupon/info")
public class CouponInfoApiController
{
    @Autowired
    private CouponInfoService couponInfoService;

    /**
     * 根据优惠券 id 查询优惠券
     *
     * @param couponId 优惠券 id
     * @return 优惠券信息
     */
    @Operation(summary = "根据优惠券 id 查询优惠券", description = "根据优惠券 id 查询优惠券")
    @GetMapping(value = "inner/get/by/id/{couponId}")
    public CouponInfo getById(@PathVariable("couponId") Long couponId)
    {
        CouponInfo couponInfo = couponInfoService.getById(couponId);

        return couponInfo;
    }

    /**
     * 更新优惠券使用状态
     *
     * @param couponUseId 优惠券使用 id
     * @param orderId     订单 id
     * @return true 优惠券使用状态
     */
    @Operation(summary = "更新优惠券使用状态", description = "更新优惠券使用状态")
    @GetMapping(value = "inner/update/coupon/info/use/status/{couponUseId}/{orderId}")
    public Boolean updateCouponInfoUseStatus(@PathVariable("couponUseId") Long couponUseId, @PathVariable("orderId") Long orderId)
    {
        couponInfoService.updateCouponInfoUseStatus(couponUseId, orderId);

        return true;
    }
}
```

**（2）编写 CouponInfoService。**

```java
package com.myxh.smart.planet.activity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.activity.mapper.CouponInfoMapper;
import com.myxh.smart.planet.activity.service.CouponInfoService;
import com.myxh.smart.planet.activity.service.CouponUseService;
import com.myxh.smart.planet.model.activity.CouponInfo;
import com.myxh.smart.planet.model.activity.CouponUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author MYXH
 * @date 2023/10/15
 *
 * <p>
 * 优惠券信息 服务实现类
 * </p>
 */
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo> implements CouponInfoService
{
    @Autowired
    private CouponUseService couponUseService;

    /**
     * 更新优惠券使用状态
     *
     * @param couponUseId 优惠券使用 id
     * @param orderId     订单 id
     */
    @Override
    public void updateCouponInfoUseStatus(Long couponUseId, Long orderId)
    {
        CouponUse couponUse = new CouponUse();
        couponUse.setId(couponUseId);
        couponUse.setOrderId(orderId);
        couponUse.setCouponStatus("1");
        couponUse.setUsingTime(new Date());
        couponUseService.updateById(couponUse);
    }
}
```

**（3）创建 service-activity-client 模块定义接口。**

```java
package com.myxh.smart.planet.client.activity;

import com.myxh.smart.planet.model.activity.CouponInfo;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@FeignClient("service-activity")
public interface CouponInfoFeignClient
{
    @Operation(summary = "根据优惠券 id 查询优惠券", description = "根据优惠券 id 查询优惠券")
    @GetMapping(value = "/api/activity/coupon/info/inner/get/by/id/{couponId}")
    CouponInfo getById(@PathVariable("couponId") Long couponId);

    @Operation(summary = "更新优惠券使用状态", description = "更新优惠券使用状态")
    @GetMapping(value = "/api/activity/coupon/info/inner/update/coupon/info/use/status/{couponUseId}/{orderId}")
    Boolean updateCouponInfoUseStatus(@PathVariable("couponUseId") Long couponUseId, @PathVariable("orderId") Long orderId);
}
```

##### 3.5、获取当前用户 id

**（1）common 模块引入依赖。**

```xml
<!-- Redis -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

<!-- Spring 3.X 集成 Redis 所需 common-pool2 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-pool2</artifactId>
    <version>2.12.0</version>
</dependency>
```

**（2）复制工具类到 common 下的 service-utils 模块。**

![复制工具类到 common 下的 service-utils 模块](https://img-blog.csdnimg.cn/e72f4587b13d48f7887a5d0e0198795f.png)

**（3）前端实现方式。**

![前端实现方式](https://img-blog.csdnimg.cn/48dfe3859e2b43608bc4d79c2e35efc4.png)

```javascript
import axios from "axios";

// 创建 axios 实例
const service = axios.create({
  // api 的 base_url
  baseURL: "http://smartplanet.free.idcfengye.com",
  // 请求超时时间
  timeout: 30000,
});

// http request 拦截器
service.interceptors.request.use(
  (config) => {
    // 获取 localStorage 里面的 token 值
    let token = window.localStorage.getItem("token") || "";

    if (token != "") {
      // 把 token 值放到 header 里面
      config.headers["token"] = token;

      // cookie.get('SmartPlanet');
    }

    return config;
  },

  (err) => {
    return Promise.reject(err);
  }
);

// http response 拦截器
service.interceptors.response.use(
  (response) => {
    if (response.data.code == 208) {
      // 替换 #，后台获取不到 # 后面的参数
      let url = window.location.href.replace("#", "smartplanet");

      window.location =
        "http://smartplanet.free.idcfengye.com/api/user/wechat/authorize?returnUrl=" +
        url;
    } else {
      if (response.data.code == 20000) {
        return response.data;
      } else {
        console.log("response.data:" + JSON.stringify(response.data));
        alert(response.data.message || "error");

        return Promise.reject(response);
      }
    }
  },

  (error) => {
    // 返回接口返回的错误信息
    return Promise.reject(error.response);
  }
);

export default service;
```

##### 3.6、生成订单 Service

**（1）service-order 引入依赖。**

```xml
<!-- service-activity-client -->
<dependency>
    <groupId>com.myxh.smart.planet</groupId>
    <artifactId>service-activity-client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>

<!-- service-course-client -->
<dependency>
    <groupId>com.myxh.smart.planet</groupId>
    <artifactId>service-course-client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>

<!-- service-user-client -->
<dependency>
    <groupId>com.myxh.smart.planet</groupId>
    <artifactId>service-user-client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

**（2）OrderInfoServiceImpl**

```java
package com.myxh.smart.planet.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.client.activity.CouponInfoFeignClient;
import com.myxh.smart.planet.client.course.CourseFeignClient;
import com.myxh.smart.planet.client.user.UserInfoFeignClient;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.model.activity.CouponInfo;
import com.myxh.smart.planet.model.order.OrderDetail;
import com.myxh.smart.planet.model.order.OrderInfo;
import com.myxh.smart.planet.model.user.UserInfo;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.order.AuthContextHolder;
import com.myxh.smart.planet.order.OrderNoUtils;
import com.myxh.smart.planet.order.mapper.OrderInfoMapper;
import com.myxh.smart.planet.order.service.OrderDetailService;
import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.result.ResultCodeEnum;
import com.myxh.smart.planet.vo.order.OrderFormVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author MYXH
 * @date 2023/10/14
 *
 * <p>
 * 订单信息 服务实现类
 * </p>
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService
{
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private CouponInfoFeignClient couponInfoFeignClient;

    @Autowired
    private CourseFeignClient courseFeignClient;

    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    /**
     * 新增点播课程订单
     *
     * @param orderFormVo 订单信息
     * @return orderId 订单 id
     */
    @Override
    public Long submitOrder(OrderFormVo orderFormVo)
    {
        // 1、获取生成订单条件值
        Long userId = AuthContextHolder.getUserId();
        Long courseId = orderFormVo.getCourseId();
        Long couponId = orderFormVo.getCouponId();

        // 2、判断当前用户是否已有当前课程的订单
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getUserId, userId);
        queryWrapper.eq(OrderDetail::getCourseId, courseId);
        OrderDetail orderDetailExist = orderDetailService.getOne(queryWrapper);

        if (orderDetailExist != null)
        {
            // 如果订单已存在，则直接返回订单 id
            return orderDetailExist.getId();
        }

        // 3、根据课程 id 查询课程信息
        Course course = courseFeignClient.getById(courseId);

        if (course == null)
        {
            throw new SmartPlanetException(ResultCodeEnum.DATA_ERROR.getCode(), ResultCodeEnum.DATA_ERROR.getMessage());
        }

        // 4、根据用户 id 查询用户信息
        UserInfo userInfo = userInfoFeignClient.getUserInfoById(userId);

        if (userInfo == null)
        {
            throw new SmartPlanetException(ResultCodeEnum.DATA_ERROR.getCode(), ResultCodeEnum.DATA_ERROR.getMessage());
        }

        // 5、根据优惠券 id 查询优惠券信息
        // 优惠券金额
        BigDecimal couponReduce = new BigDecimal(0);

        if (null != couponId)
        {
            CouponInfo couponInfo = couponInfoFeignClient.getById(couponId);
            couponReduce = couponInfo.getAmount();
        }

        // 6、封装订单生成需要数据到对象，完成添加订单
        // 6.1、封装数据到 orderInfo 对象里面，添加订单基本信息表
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(userId);
        orderInfo.setNickName(userInfo.getNickName());
        orderInfo.setPhone(userInfo.getPhone());
        orderInfo.setProvince(userInfo.getProvince());
        orderInfo.setOriginAmount(course.getPrice());
        orderInfo.setCouponReduce(couponReduce);
        orderInfo.setFinalAmount(orderInfo.getOriginAmount().subtract(orderInfo.getCouponReduce()));
        orderInfo.setOutTradeNo(OrderNoUtils.getOrderNo());
        orderInfo.setTradeBody(course.getTitle());
        orderInfo.setOrderStatus("0");
        baseMapper.insert(orderInfo);

        // 6.2、封装数据到 orderDetail 对象里面，添加订单详情信息表
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderInfo.getId());
        orderDetail.setUserId(userId);
        orderDetail.setCourseId(courseId);
        orderDetail.setCourseName(course.getTitle());
        orderDetail.setCover(course.getCover());
        orderDetail.setOriginAmount(course.getPrice());
        orderDetail.setCouponReduce(new BigDecimal(0));
        orderDetail.setFinalAmount(orderDetail.getOriginAmount().subtract(orderDetail.getCouponReduce()));
        orderDetailService.save(orderDetail);

        // 7、更新优惠券状态
        if (null != orderFormVo.getCouponUseId())
        {
            couponInfoFeignClient.updateCouponInfoUseStatus(orderFormVo.getCouponUseId(), orderInfo.getId());
        }

        // 8、返回订单 id
        return orderInfo.getId();
    }
}
```

#### 4、微信支付

##### 4.1、微信支付

接口文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=7_1

##### 4.2、公众号配置

**（1）绑定域名。**

与微信分享一致

先登录微信公众平台进入“设置与开发”，“公众号设置”的“功能设置”里填写“JS 接口安全域名”。

说明：因为**测试号不支持支付功能**，需要使用正式号才能进行测试。

![绑定域名](https://img-blog.csdnimg.cn/39de7dc34fe049cc9f39f7a15eccf8cd.png)

**（2）商户平台配置支付目录。**

![商户平台配置支付目录](https://img-blog.csdnimg.cn/96a3d2a7834346fbb19a988903379cf0.png)

##### 4.3、创建订单支付接口

**（1）创建 WXPayController。**

```java
package com.myxh.smart.planet.order.api;

import com.myxh.smart.planet.order.service.WXPayService;
import com.myxh.smart.planet.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Tag(name = "微信支付 API", description = "微信支付 API 接口")
@RestController
@RequestMapping("/api/order/wx/pay")
public class WXPayController
{
    @Autowired
    private WXPayService wxPayService;

    /**
     * 微信下单支付
     *
     * @param orderNo 订单号
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "微信下单支付", description = "微信下单支付")
    @GetMapping("/create/js/api/{orderNo}")
    public Result<Map<String, Object>> createJsapi(@Parameter(name = "orderNo", description = "订单号", required = true)
                                                   @PathVariable("orderNo") String orderNo)
    {
        Map<String, Object> map = wxPayService.createJsapi(orderNo);

        return Result.ok(map);
    }
}
```

**（2）创建 WXPayService。**

```java
package com.myxh.smart.planet.order.service;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/21
 */
public interface WXPayService
{
    /**
     * 微信下单支付
     *
     * @param orderNo 订单号
     * @return result 结果
     */
    Map<String, Object> createJsapi(String orderNo);
}
```

**（3）service-order 引入依赖。**

```xml
<!-- wxpay-sdk -->
<dependency>
    <groupId>com.github.wxpay</groupId>
    <artifactId>wxpay-sdk</artifactId>
    <version>0.0.3</version>
</dependency>
```

**（4）创建 WXPayServiceImpl。**

```java
package com.myxh.smart.planet.order.service.impl;

import com.github.wxpay.sdk.WXPayUtil;
import com.myxh.smart.planet.client.user.UserInfoFeignClient;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.order.HttpClientUtils;
import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.order.service.WXPayService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Service
public class WXPayServiceImpl implements WXPayService
{
    @Autowired
    private OrderInfoService orderInfoService;
    @Resource
    private UserInfoFeignClient userInfoFeignClient;

    /**
     * 微信下单支付
     *
     * @param orderNo 订单号
     * @return result 结果
     */
    @Override
    public Map<String, Object> createJsapi(String orderNo)
    {
        try
        {
            // 封装微信支付需要参数，使用 map 集合
            Map<String, String> paramMap = new HashMap<>();

            // 1、设置参数
            // 正式服务公众号商户id = wxf913bfa3a2c7eeeb（固定值）
            paramMap.put("appid", "wxf913bfa3a2c7eeeb");

            // 正式服务公众号商户号 = 1481962542（固定值）
            paramMap.put("mch_id", "1481962542");

            paramMap.put("nonce_str", WXPayUtil.generateNonceStr());
            paramMap.put("body", "test");
            paramMap.put("out_trade_no", orderNo);

            // 为了参数，支付 0.01 元
            paramMap.put("total_fee", "1");
            paramMap.put("spbill_create_ip", "127.0.0.1");
            paramMap.put("notify_url", "http://smartplanet.free.idcfengye.com/api/order/wx/pay/notify");

            // 支付类型，按照生成固定金额支付
            paramMap.put("trade_type", "JSAPI");

            /*
            设置参数值当前微信用户 openid
            现实实现逻辑：第一步、根据订单号获取 userid
                       第二步、根据 userid 获取 openid

            因为当前使用测试号，测试号不支持支付功能，为了使用正式服务公众号进行测试，使用下面写法
            获取正式服务公众号微信 openid
            通过其他方式获取正式服务公众号 openid，直接设置
             */
            // 正式服务公众号 openid = oQTXC56lAy3xMOCkKCImHtHoLL（不定值）
            paramMap.put("openid", "oQTXC56lAy3xMOCkKCImHtHoLL");

            // 2、HTTPClient 来根据 URL 访问第三方接口并且传递参数，调用微信支付接口
            HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/unifiedorder");

            // client 设置请求参数
            // 正式服务公众号商户 key = MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9
            String paramXml = WXPayUtil.generateSignedXml(paramMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9");
            client.setXmlParam(paramXml);
            client.setHttps(true);

            // 发送请求
            client.post();

            // 3、微信支付接口返回第三方的数据
            String contentXml = client.getContent();
            System.out.println("contentXml = " + contentXml);
            Map<String, String> resultMap = WXPayUtil.xmlToMap(contentXml);

            if ((resultMap.get("result_code") != null) && !"SUCCESS".equals(resultMap.get("result_code")))
            {
                throw new SmartPlanetException(20001, "支付失败");
            }

            // 4、再次封装参数
            Map<String, String> parameterMap = new HashMap<>();
            String prepayId = String.valueOf(resultMap.get("prepay_id"));
            String packages = "prepay_id=" + prepayId;
            parameterMap.put("appId", "wxf913bfa3a2c7eeeb");
            parameterMap.put("nonceStr", resultMap.get("nonce_str"));
            parameterMap.put("package", packages);
            parameterMap.put("signType", "MD5");
            parameterMap.put("timeStamp", String.valueOf(new Date().getTime()));
            String sign = WXPayUtil.generateSignature(parameterMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9");

            // 返回结果
            Map<String, Object> result = new HashMap<>();
            result.put("appId", "wxf913bfa3a2c7eeeb");
            result.put("timeStamp", parameterMap.get("timeStamp"));
            result.put("nonceStr", parameterMap.get("nonceStr"));
            result.put("signType", "MD5");
            result.put("paySign", sign);
            result.put("package", packages);
            System.out.println("result = " + result);

            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return new HashMap<>();
        }
    }
}
```

##### 4.4、服务号测试过程

**（1）修改 service-user 模块配置文件。**

```properties
# 公众号 id 和秘钥
# 智慧星球微信公众平台 appId
# wechat.appId=wxc23b80b9ffaac7bd
# 智慧星球微信公众平台 api 秘钥
# wechat.appSecret=5c0271622c4271753310c436b5cd3532

# 公众号 id 和秘钥（测试微信支付功能）
# 硅谷课堂微信公众平台 appId
wechat.appId=wxf913bfa3a2c7eeeb
# 硅谷课堂微信公众平台 api 秘钥
wechat.appSecret=cd360d429e5c8db0c638d5ef9df74f6d
```

**（2）service-user 模块创建 controller。**

```java
package com.myxh.smart.planet.user.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Tag(name = "微信用户 API（测试微信支付功能）", description = "微信用户 API 接口（测试微信支付功能）")
@Controller
@RequestMapping("/api/user/openid")
public class GetOpenIdController
{
    @Autowired
    private WxMpService wxMpService;

    /**
     * 授权跳转
     *
     * @param returnUrl 返回 url
     * @param request   请求
     * @return redirectURL 重定向 url
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl, HttpServletRequest request)
    {
        String userInfoUrl = "http://smartplanet.free.idcfengye.com/api/user/openid/user/info";
        String redirectURL = wxMpService
                .getOAuth2Service().buildAuthorizationUrl(userInfoUrl,
                        WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                        URLEncoder.encode(returnUrl.replace("#", "smartplanet"), StandardCharsets.UTF_8));

        return "redirect:" + redirectURL;
    }

    /**
     * 获取用户信息
     *
     * @param code      密码
     * @param returnUrl 返回 url
     * @return redirectURL 重定向 url
     */
    @GetMapping("/user/info")
    @ResponseBody
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl)
    {
        try
        {
            // 拿着 code 发送请求
            WxOAuth2AccessToken wxOAuth2AccessToken = null;

            wxOAuth2AccessToken = this.wxMpService.getOAuth2Service().getAccessToken(code);


            // 获取 openId
            String openId = wxOAuth2AccessToken.getOpenId();
            System.out.println("正式服务公众号微信网页授权 openId = " + openId);

            return openId;
        }
        catch (WxErrorException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
```

**（3）修改前端 App.vue。**

```html
<template>
  <div id="app">
    <div id="nav">
      <!-- <router-link to="/">列表页</router-link> | -->
      <!-- <router-link to="/info">详情页</router-link> | -->
      <!--  <router-link to="/list">列表页</router-link> | -->
      <!--  <router-link to="/order">下单页</router-link> -->
      <van-button round block type="info" @click="clearData"
        >清空 localStorage</van-button
      >
    </div>
    <router-view />
  </div>
</template>

<script>
  import userInfoAPI from "@/api/userInfo";

  export default {
    data() {
      return {
        show: true,
      };
    },

    created() {
      // 处理微信授权登录
      this.wechatLogin();
    },

    methods: {
      wechatLogin() {
        // 处理微信授权登录
        let token = this.getQueryString("token") || "";

        if (token != "") {
          window.localStorage.setItem("token", token);
        }

        // 所有页面都必须登录，两次调整登录，这里与接口返回 208 状态
        token = window.localStorage.getItem("token") || "";

        if (token == "") {
          let url = window.location.href.replace("#", "smartplanet");

          /*
          window.location =
            "http://smartplanet.free.idcfengye.com/api/user/wechat/authorize?returnUrl=" +
            url;
           */

          // 测试微信支付功能
          window.location =
            "http://smartplanet.free.idcfengye.com/api/user/openid/authorize?returnUrl=" +
            url;
        }

        console.log("token：" + window.localStorage.getItem("token"));

        //绑定手机号处理
        /*
      if (token != "") {
        this.bindPhone();
      }
      */
      },

      bindPhone() {
        let userInfoString = window.localStorage.getItem("userInfo") || "";
        alert("userInfoString:" + userInfoString);

        if (userInfoString != "") {
          alert("userInfoString:" + userInfoString);
          let userInfo = JSON.parse(userInfoString);
          let phone = userInfo.phone || "";

          if (phone == "") {
            this.$router.push({ path: "/bind/first" });
          }
        } else {
          alert("userInfoString:" + userInfoString);
          userInfoAPI.getCurrentUserInfo().then((response) => {
            window.localStorage.setItem(
              "userInfo",
              JSON.stringify(response.data)
            );
            alert("data:" + JSON.stringify(response.data));
            let phone = response.data.phone || "";
            console.log("phone:" + phone);

            if (phone == "") {
              this.$router.push({ path: "/bind/first" });
            }
          });
        }
      },

      getQueryString(paramName) {
        if (window.location.href.indexOf("?") == -1) return "";

        let searchString = window.location.href.split("?")[1];
        let i,
          val,
          params = searchString.split("&");

        for (i = 0; i < params.length; i++) {
          val = params[i].split("=");

          if (val[0] == paramName) {
            return val[1];
          }
        }

        return "";
      },

      clearData() {
        window.localStorage.setItem("token", "");
        window.localStorage.setItem("userInfo", "");
        let token = window.localStorage.getItem("token");
        alert("token:" + token);
      },
    },
  };
</script>

<style lang="scss">
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
  }
</style>
```

**（4）复制返回的 openid 到支付接口中测试。**

![复制返回的 openid 到支付接口中测试](https://img-blog.csdnimg.cn/b64f5a17d1a4473cbb5a04c0041e3d5e.png)

##### 4.5、整合点播视频支付前端

**（1）trade.vue**

```html
<template>
  <template>
    <div>
      <van-image width="100%" height="200" :src="courseVo.cover" />

      <h1 class="van-ellipsis course_title">{{ courseVo.title }}</h1>

      <div class="course_teacher_price_box">
        <div class="course_teacher_price">
          <div class="course_price">价格：</div>
          <div class="course_price_number">￥{{ courseVo.price }}</div>
        </div>
      </div>
      <div class="course_teacher_price_box">
        <div class="course_teacher_box">
          <div class="course_teacher">教师： {{ teacher.name }}</div>
          <van-image :src="teacher.avatar" round width="50px" height="50px" />
        </div>
      </div>

      <van-loading vertical="true" v-show="loading">加载中...</van-loading>

      <div
        style="
        position: fixed;
        left: 0px;
        bottom: 50px;
        width: 100%;
        height: 50px;
        z-index: 999;
      "
      >
        <!-- 优惠券单元格 -->
        <van-coupon-cell
          :coupons="coupons"
          :chosen-coupon="chosenCoupon"
          @click="showList = true"
        />

        <!-- 优惠券列表 -->
        <van-popup
          v-model="showList"
          round
          position="bottom"
          style="height: 90%; padding-top: 4px"
        >
          <van-coupon-list
            :coupons="coupons"
            :chosen-coupon="chosenCoupon"
            :disabled-coupons="disabledCoupons"
            @change="onChange"
          />
        </van-popup>
      </div>

      <van-goods-action>
        <van-submit-bar
          :price="finalAmount"
          button-text="确认下单"
          @submit="sureOrder"
        />
      </van-goods-action>
    </div>
  </template>

  <script>
    import courseAPI from "@/api/course";
    import orderAPI from "@/api/order";
    import couponAPI from "@/api/coupon";

    export default {
      data() {
        return {
          loading: false,
          courseId: null,
          courseVo: {},
          teacher: {},
          orderId: null,
          showList: false,
          chosenCoupon: -1,
          coupons: [],
          disabledCoupons: [],
          couponId: null,
          couponUseId: null,
          couponReduce: 0,
          finalAmount: 0,
        };
      },

      created() {
        this.courseId = this.$route.params.courseId;
        this.fetchData();
        this.getCouponInfo();
      },

      methods: {
        onChange(index) {
          debugger;
          this.showList = false;
          this.chosenCoupon = index;
          this.couponId = this.coupons[index].id;
          this.couponUseId = this.coupons[index].couponUseId;
          this.couponReduce = this.coupons[index].value;
          this.finalAmount =
            parseFloat(this.finalAmount) - parseFloat(this.couponReduce);
        },

        fetchData() {
          this.loading = true;
          courseAPI.getInfo(this.courseId).then((response) => {
            // console.log(response.data);
            this.courseVo = response.data.courseVo;
            this.teacher = response.data.teacher;

            // 转换为分
            this.finalAmount = parseFloat(this.courseVo.price) * 100;
            this.loading = false;
          });
        },

        getCouponInfo() {
          couponAPI.findCouponInfo().then((response) => {
            // console.log(response.data);
            this.coupons = response.data.abledCouponsList;
            this.disabledCoupons = response.data.disabledCouponsList;
          });
        },

        sureOrder() {
          this.loading = true;
          let orderFormVo = {
            courseId: this.courseId,
            couponId: this.couponId,
            couponUseId: this.couponUseId,
          };

          orderAPI.submitOrder(orderFormVo).then((response) => {
            console.log(response.data);
            this.$router.push({ path: "/pay/" + response.data });
          });
        },
      },
    };
  </script>

  <style lang="scss" scoped>
    .gap {
      height: 10px;
    }

    ::v-deep.van-image {
      display: block;
    }

    .course_count {
      background-color: #82848a;
      color: white;
      padding: 5px;
      text-align: center;
      border-right: 1px solid #939393;

      h1 {
        font-size: 14px;
        margin: 0;
      }

      p {
        margin: 0;
        font-size: 16px;
      }
    }

    .course_title {
      font-size: 20px;
      margin: 10px;
    }

    .course_teacher_price_box {
      margin: 10px;
      display: flex;
      justify-content: space-between;
      align-items: center;

      .course_teacher_price {
        display: flex;
        font-size: 14px;
        align-items: center;

        .course_price_number {
          color: red;
          font-size: 18px;
          font-weight: bold;
        }
      }

      .course_teacher_box {
        display: flex;
        justify-content: center;
        align-items: center;

        .course_teacher {
          margin-right: 20px;
        }
      }
    }

    .course_contents {
      margin: 10px;

      .course_title_font {
        color: #68cb9b;
        font-weight: bold;
      }

      .course_content {
        margin-bottom: 20px;
      }
    }

    .course_chapter_list {
      display: flex;
      justify-content: space-between;
      align-items: center;

      h2 {
        font-size: 14px;
      }

      p {
        margin: 0;
      }
    }
  </style></template
>
```

**（2）pay.vue**

```html
<template>
  <div>
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <van-image
      width="100%"
      height="200"
      src="https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png"
    />

    <h1 class="van-ellipsis course_title">
      课程名称: {{ orderInfo.courseName }}
    </h1>

    <div class="course_teacher_price_box">
      <div class="course_price">订单号：{{ orderInfo.outTradeNo }}</div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_price">下单时间：{{ orderInfo.createTime }}</div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_price">
        支付状态：{{ orderInfo.orderStatus == "0" ? "未支付" : "已支付" }}
      </div>
    </div>
    <div class="course_teacher_price_box" v-if="orderInfo.orderStatus == '1'">
      <div class="course_price">支付时间：{{ orderInfo.payTime }}</div>
    </div>
    <van-divider />
    <div class="course_teacher_price_box">
      <div class="course_price">
        订单金额：<span style="color: red">￥{{ orderInfo.originAmount }}</span>
      </div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_price">
        优惠券金额：<span style="color: red"
          >￥{{ orderInfo.couponReduce }}</span
        >
      </div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_price">
        支付金额：<span style="color: red">￥{{ orderInfo.finalAmount }}</span>
      </div>
    </div>

    <van-goods-action>
      <van-goods-action-button
        type="danger"
        text="支付"
        @click="pay"
        v-if="orderInfo.orderStatus == '0'"
      />
      <van-goods-action-button
        type="warning"
        text="去观看"
        @click="see"
        v-else
      />
    </van-goods-action>

    <van-loading vertical="true" v-show="loading">加载中...</van-loading>
  </div>
</template>

<script>
  import orderAPI from "@/api/order";

  export default {
    data() {
      return {
        loading: false,
        orderId: null,
        orderInfo: {},
        showList: false,
        chosenCoupon: -1,
        coupons: [],
        disabledCoupons: [],
        couponReduce: 0,
        finalAmount: 0,
      };
    },

    created() {
      this.orderId = this.$route.params.orderId;
      this.fetchData();
    },

    methods: {
      fetchData() {
        this.loading = true;
        orderAPI.getInfo(this.orderId).then((response) => {
          this.orderInfo = response.data;
          // alert("orderStatus:" + this.orderInfo.orderStatus);
          this.finalAmount = parseFloat(this.orderInfo.finalAmount) * 100;

          this.loading = false;
        });
      },

      pay() {
        this.loading = true;
        orderAPI.createJsapi(this.orderInfo.outTradeNo).then((response) => {
          console.log(response.data);
          this.loading = false;
          this.onBridgeReady(response.data);
        });
      },

      onBridgeReady(data) {
        let that = this;
        console.log(data);
        WeixinJSBridge.invoke(
          "getBrandWCPayRequest",
          {
            //公众号 ID，由商户传入
            appId: data.appId,

            // 时间戳，自 1970 年以来的秒数
            timeStamp: data.timeStamp,

            // 随机串
            nonceStr: data.nonceStr,
            package: data.package,

            // 微信签名方式
            signType: data.signType,

            // 微信签名
            paySign: data.paySign,
          },

          function (res) {
            if (res.err_msg == "get_brand_wcpay_request:ok") {
              // 使用以上方式判断前端返回,微信团队郑重提示：
              // res.err_msg 将在用户支付成功后返回 ok，但并不保证它绝对可靠。
              console.log("支付成功");
              that.queryPayStatus();
            }
          }
        );
      },

      queryPayStatus() {
        // 回调查询
        orderAPI.queryPayStatus(this.orderInfo.outTradeNo).then((response) => {
          console.log(response.data);
          this.fetchData();
        });
      },

      see() {
        this.$router.push({ path: "/course/info/" + this.orderInfo.courseId });
      },
    },
  };
</script>

<style lang="scss" scoped>
  .gap {
    height: 10px;
  }

  ::v-deep.van-image {
    display: block;
  }

  .course_count {
    background-color: #82848a;
    color: white;
    padding: 5px;
    text-align: center;
    border-right: 1px solid #939393;

    h1 {
      font-size: 14px;
      margin: 0;
    }

    p {
      margin: 0;
      font-size: 16px;
    }
  }

  .course_title {
    font-size: 20px;
    margin: 10px;
  }

  .course_teacher_price_box {
    margin: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;

    .course_teacher_price {
      display: flex;
      font-size: 14px;
      align-items: center;

      .course_price_number {
        color: red;
        font-size: 18px;
        font-weight: bold;
      }
    }

    .course_teacher_box {
      display: flex;
      justify-content: center;
      align-items: center;

      .course_teacher {
        margin-right: 20px;
      }
    }
  }

  .course_contents {
    margin: 10px;

    .course_title_font {
      color: #68cb9b;
      font-weight: bold;
    }

    .course_content {
      margin-bottom: 20px;
    }
  }

  .course_chapter_list {
    display: flex;
    justify-content: space-between;
    align-items: center;

    h2 {
      font-size: 14px;
    }

    p {
      margin: 0;
    }
  }
</style>
```

##### 4.6、订单详情接口

**（1）OrderInfoApiController 添加方法。**

```java
package com.myxh.smart.planet.order.api;

import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.order.OrderInfoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Tag(name = "订单信息 API", description = "订单信息 API 接口")

@RestController
@RequestMapping("api/order/order/info")
public class OrderInfoApiController
{
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 根据订单 id 获取订单信息
     *
     * @param id 订单 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据订单 id 获取订单信息", description = "根据订单 id 获取订单信息")
    @GetMapping("get/info/{id}")
    public Result<OrderInfoVo> getInfo(@PathVariable("id") Long id)
    {
        OrderInfoVo orderInfoVo = orderInfoService.getOrderInfoVoById(id);

        return Result.ok(orderInfoVo);
    }
}
```

**（2）OrderInfoServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.order.OrderDetail;
import com.myxh.smart.planet.model.order.OrderInfo;
import com.myxh.smart.planet.order.mapper.OrderInfoMapper;
import com.myxh.smart.planet.order.service.OrderDetailService;
import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.vo.order.OrderInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/14
 *
 * <p>
 * 订单信息 服务实现类
 * </p>
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService
{
    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * 根据订单 id 获取订单信息
     *
     * @param id 订单 id
     * @return orderInfoVo 订单信息
     */
    @Override
    public OrderInfoVo getOrderInfoVoById(Long id)
    {
        //根据订单 id 查询订单基本信息和详情信息
        OrderInfo orderInfo = baseMapper.selectById(id);
        OrderDetail orderDetail = orderDetailService.getById(id);

        // 封装 OrderInfoVo
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        BeanUtils.copyProperties(orderInfo, orderInfoVo);
        orderInfoVo.setCourseId(orderDetail.getCourseId());
        orderInfoVo.setCourseName(orderDetail.getCourseName());

        return orderInfoVo;
    }
}
```

##### 4.7、查询支付结果

**（1）WXPayController 添加方法。**

```java
package com.myxh.smart.planet.order.api;

import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.order.service.WXPayService;
import com.myxh.smart.planet.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Tag(name = "微信支付 API", description = "微信支付 API 接口")
@RestController
@RequestMapping("/api/order/wx/pay")
public class WXPayController
{
    @Autowired
    private WXPayService wxPayService;

    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 查询支付状态
     *
     * @param orderNo 订单号
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询支付状态", description = "查询支付状态")
    @GetMapping("/query/pay/status/{orderNo}")
    public Result<Object> queryPayStatus(@Parameter(name = "orderNo", description = "订单号", required = true)
                                         @PathVariable("orderNo") String orderNo)
    {
        // 根据订单号调用微信接口查询支付状态
        Map<String, String> resultMap = wxPayService.queryPayStatus(orderNo);

        // 判断支付是否成功，根据微信支付状态接口判断
        if (resultMap == null)
        {
            // 出错
            return Result.fail(null).message("支付出错");
        }

        if ("SUCCESS".equals(resultMap.get("trade_state")))
        {
            // 成功
            // 更改订单状态，处理支付结果
            String outTradeNo = resultMap.get("out_trade_no");
            System.out.println("out_trade_no = " + outTradeNo);
            orderInfoService.updateOrderStatus(outTradeNo);

            return Result.ok(null).message("支付成功");
        }

        return Result.ok(null).message("支付中");
    }
}
```

**（2）WXPayServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.order.service.impl;

import com.github.wxpay.sdk.WXPayUtil;
import com.myxh.smart.planet.client.user.UserInfoFeignClient;
import com.myxh.smart.planet.order.HttpClientUtils;
import com.myxh.smart.planet.order.service.OrderInfoService;
import com.myxh.smart.planet.order.service.WXPayService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/21
 */
@Service
public class WXPayServiceImpl implements WXPayService
{
    @Autowired
    private OrderInfoService orderInfoService;
    @Resource
    private UserInfoFeignClient userInfoFeignClient;

    /**
     * 根据订单号调用微信接口查询支付状态
     *
     * @param orderNo 订单号
     * @return resultMap 结果
     */
    @Override
    public Map<String, String> queryPayStatus(String orderNo)
    {
        try
        {
            // 1、封装微信接口需要参数，使用 map
            Map paramMap = new HashMap<>();
            paramMap.put("appid", "wxf913bfa3a2c7eeeb");
            paramMap.put("mch_id", "1481962542");
            paramMap.put("out_trade_no", orderNo);
            paramMap.put("nonce_str", WXPayUtil.generateNonceStr());

            // 2、调用接口 Httpclient，设置请求
            HttpClientUtils client = new HttpClientUtils("https://api.mch.weixin.qq.com/pay/orderquery");
            client.setXmlParam(WXPayUtil.generateSignedXml(paramMap, "MXb72b9RfshXZD4FRGV5KLqmv5bx9LT9"));
            client.setHttps(true);
            client.post();

            // 3、封装返回第三方的数据
            String xml = client.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);

            // 5、返回结果
            return resultMap;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
```

**（3）OrderInfoServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.order.OrderInfo;
import com.myxh.smart.planet.order.mapper.OrderInfoMapper;
import com.myxh.smart.planet.order.service.OrderInfoService;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/14
 *
 * <p>
 * 订单信息 服务实现类
 * </p>
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService
{
    /**
     * 更改订单状态，处理支付结果
     *
     * @param outTradeNo 场外交易编号
     */
    @Override
    public void updateOrderStatus(String outTradeNo)
    {
        // 根据 订单号查询订单
        LambdaQueryWrapper<OrderInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(OrderInfo::getOutTradeNo, outTradeNo);
        OrderInfo orderInfo = baseMapper.selectOne(wrapper);

        // 更新订单状态，1 已经支付
        orderInfo.setOrderStatus("1");

        // 调用方法更新
        baseMapper.updateById(orderInfo);
    }
}
```

### 二、直播介绍

#### 1、项目需求

智慧星球会定期推出直播课程，方便学生与名师之间的交流互动，在直播间老师可以推荐点播课程（类似直播带货），学生可以点赞交流，购买推荐的点播课程。

#### 2、了解直播

一个完整直播实现流程：

​ 1.采集、2.滤镜处理、3.编码、4.推流、5.CDN 分发、6.拉流、7.解码、8.播放、9.聊天互动。

##### 2.1、通用直播模型

![通用直播模型](https://img-blog.csdnimg.cn/bd0ea1d3bf984ba895a699a6e6d79764.png)

![通用直播模型](https://img-blog.csdnimg.cn/f393266b237c4c5a84a10c46e0bc7390.png)

1. 首先是主播方，它是产生视频流的源头，由一系列流程组成：第一，通过一定的设备来采集数据；第二，将采集的这些视频进行一系列的处理，比如水印、美颜和特效滤镜等处理；第三，将处理后的结果视频编码压缩成可观看可传输的视频流；第四，分发推流，即将压缩后的视频流通过网络通道传输出去。

2. 其次是播放端，播放端功能有两个层面，第一个层面是关键性的需求；另一层面是业务层面的。先看第一个层面，它涉及到一些非常关键的指标，比如秒开，在很多场景当中都有这样的要求，然后是对于一些重要内容的版权保护。为了达到更好的效果，还需要配合服务端做智能解析，这在某些场景下也是关键性需求。再来看第二个层面也即业务层面的功能，对于一个社交直播产品来说，在播放端，观众希望能够实时的看到主播端推过来的视频流，并且和主播以及其他观众产生一定的互动，因此它可能包含一些像点赞、聊天和弹幕这样的功能，以及礼物这样更高级的道具。

3. 要知道，内容产生方和消费方一般都不是一一对应的。对于一个直播产品来讲，最直观的体现就是一个主播可能会有很多粉丝。因此，不能直接让主播端和所有播放端进行点对点通信，这在技术上是做不到或者很有难度。主播方播出的视频到达播放端之前，需要经过一系列的中间环节，也就是这里讲的直播服务器端。

4. 直播服务器端提供的最核心功能是收集主播端的视频推流，并将其放大后推送给所有观众端。除了这个核心功能，还有很多运营级别的诉求，比如鉴权认证，视频连线和实时转码，自动鉴黄，多屏合一，以及云端录制存储等功能。另外，对于一个主播端推出的视频流，中间需要经过一些环节才能到达播放端，因此对中间环节的质量进行监控，以及根据这些监控来进行智能调度，也是非常重要的诉求。

5. 实际上无论是主播端还是播放端，他们的诉求都不会仅仅是拍摄视频和播放视频这么简单。在这个核心诉求被满足之后，还有很多关键诉求需要被满足。比如，对于一个消费级的直播产品来说，除了这三大模块之外，还需要实现一个业务服务端来进行推流和播放控制，以及所有用户状态的维持。如此，就构成了一个消费级可用的直播产品。

##### 2.2、如何快速开发完整直播

###### 2.2.1、利用第三方 SDK 开发

- [七牛云](https://link.jianshu.com/?t=http://www.qiniu.com/?utm_campaign=baiduSEM&utm_source=baiduSEM&utm_medium=baiduSEM&utm_content=baiduSEM)：七牛直播云是专为直播平台打造的全球化直播流服务和一站式实现 SDK 端到端直播场景的企业级直播云服务平台。

  - 熊猫 TV，龙珠 TV 等直播平台都是用的七牛云。

- [网易视频云](https://link.jianshu.com/?t=http://vcloud.163.com/live.html#bdpc)：基于专业的跨平台视频编解码技术和大规模视频内容分发网络，提供稳定流畅、低延时、高并发的实时音视频服务，可将视频直播无缝对接到自身 App。

- [阿里云视频直播解决方案](https://www.aliyun.com/solution/media/live)

  - [直播推流 SDK(iOS/Android)](https://help.aliyun.com/document_detail/45270.html)

  - [直播播放器 SDK(iOS/Android)](https://help.aliyun.com/document_detail/45270.html)

- 欢拓云直播平台：欢拓是一家以直播技术为核心的网络平台，旨在帮助人们通过网络也能实现真实互动通讯。

###### 2.2.2、第三方 SDK 好处

- 降低成本：

  - 使用好的第三方企业服务，将不用再花费大量的人力物力去研发。

- 提升效率：

  - 第三方服务的专注与代码集成所带来的方便，所花费的时间可能仅仅是 1-2 个小时
    ，节约近 99% 的时间，足够换取更多的时间去和竞争对手斗智斗勇，增加更大的成功可能性。

- 降低风险：

  - 借助专业的第三方服务，由于它的快速、专业、稳定等特点，能够极大地加强产品的
    竞争能力（优质服务、研发速度等），缩短试错时间，必将是创业中保命的手段之一。

- 专业的事，找专业的人来做。

  - 服务最少是 10-20 人的团队专注地解决同一个问题，做同一件事情。

#### 3、欢拓云直播

根据上面的综合对比和调研，最终选择了“欢拓与直播平台”，它提供了完整的可以直接使用的示例代码，方便开发对接。

欢拓是一家以直播技术为核心的网络平台，旨在帮助人们通过网络也能实现真实互动通讯。从 2010 年开始，欢拓就专注于音频、视频的采样、编码、后处理及智能传输研究,并于 2013 年底正式推出了针对企业/开发者的直播云服务系统，帮助开发者轻松实现真人互动。该系统适用场景包括在线教育、游戏语音、娱乐互动、远程会议（PC、移动均可）等等。针对应用场景，采用先进技术解决方案和产品形态，让客户和客户的用户满意!

官网：https://www.talk-fun.com/

接口文档地址：http://open.talk-fun.com/docs/getstartV2/document.html

![欢拓云直播](https://img-blog.csdnimg.cn/fa4702ab3e7f499f92b44afce444f0e4.png)

### 三、直播对接

#### 1、直播体验

##### 1.1、开通账号

通过官网：https://www.talk-fun.com/ ，联系客户或 400 电话开通账号，开通 **“生活直播”** 权限。开通后注意使用有效期，一般一周左右，可以再次申请延期。

**说明：官网免费试用，功能有限制，不建议使用**

##### 1.2、创建直播

1、在直播管理创建直播。

![创建直播](https://img-blog.csdnimg.cn/369b5492d06a4482a2b744019e59b411.png)

2、创建直播，选择主播模式。

![创建直播](https://img-blog.csdnimg.cn/9fdd9bafd21c4d0cb4156cee75dd82e5.png)

3、配置直播，可以自行查看。

![创建直播](https://img-blog.csdnimg.cn/39ed132fc61f421da055a8d3792a3652.png)

##### 1.3、开始直播

1、在直播列表，点击“直播入口”。

![开始直播](https://img-blog.csdnimg.cn/a7f425a94e474dbe915be1b8534352f5.png)

![开始直播](https://img-blog.csdnimg.cn/00cc8a60bf7244a1b1b9d5fa7d9df51a.png)

主播端下载“云直播客户端”，“频道 id 与密码”为直播客户端的登录账号；

下面还有管理员，主播进行直播时，助教可以在聊天时与观众互动。

2、网页端可以“一键开播”。

3、使用“频道 id 与密码”登录。

4、点击“开始直播”，打开摄像头即可开始直播。

![开始直播](https://img-blog.csdnimg.cn/c15b7dd6489047d9bb1c616c723950c6.png)

##### 1.4、用户观看

1、在直播列表，点击“直播入口”。

2、在观众一栏点击进入，即可在网页端观看直播。

![用户观看](https://img-blog.csdnimg.cn/222019a742864a3ab6ff360e942c6db7.png)

##### 1.5、体验总结

上面的体验完全能够满足业务的需要，智慧星球的需求是定期推出直播课程，方便学生与名师之间的交流互动，在直播间老师可以推荐点播课程（类似直播带货），学生可以点赞交流，购买推荐的点播课程。

直播平台只是做了直播相关的业务，不能与业务进行衔接，期望的是在智慧星球的管理后台管理直播相关的业务，那么怎么做呢？对接直播业务接口，直播平台有对应的直播接口，直接对接即可。

## Day 14-直播管理模块

### 一、后台系统-直播管理

上面已经开通了“生活类直播”。

#### 1、获取 openId 与 openToken

登录进入开放后台，后台首页即可获取 openId 与 openToken。

![获取 openId 与 openToken](https://img-blog.csdnimg.cn/0b70ba433a0b4896a18a824c04258cac.png)

#### 2、对接说明

1、使用 HTTP 协议进行信息交互，字符编码统一采用 UTF-8。

2、除非特殊说明，接口地址统一为：https://api.talk-fun.com/portal.php

3、除非特殊说明，同时支持 GET 和 POST 两种参数传递方式。

4、除非特殊说明，返回信息支持 JSON 格式。

5、除了 sign 外，其余所有请求参数值都需要进行 URL 编码。

6、参数表中，类型一栏声明的定义为：int 代表整数类型；string 代表字符串类型，如果后面有括号，括号中的数字代表该参数的最大长度；array / object 表示数组类型。

7、openID、openToken 参数的获取见[对接流程说明](https://open.talk-fun.com/docs/getstartV2/quickStart.html)。

#### 3、了解接口文档

接口文档地址：https://open.talk-fun.com/docs/getstartV2/api/live_dir.html

##### 3.1、了解接口文档

根据接口文档，了解需要对接哪些接口。

![了解接口文档](https://img-blog.csdnimg.cn/6234bf7fd757455193dde17f21d3de98.png)

###### 3.1.1、添加直播

api 名称：`course.add`，SDK 对应方法：`courseAdd`。

添加直播是一定需要的。

###### 3.1.2、更新直播信息

api 名称：`course.update`，SDK 对应方法`courseUpdate`。

###### 3.1.3、删除直播信息

api 名称：`course.delete`，SDK 对应方法：`courseDelete`。

###### 3.1.4、修改生活直播相关配置

api 名称：`course.updateLifeConfig`，SDK 对应方法：`updateLifeConfig`。

设置功能很多，但是只需要几个即可，这个接口需要做如下设置：

1、**界面模式**：pageViewMode 界面模式，1 全屏模式 0 二分屏 2 课件模式。

​2、**观看人数开关**：number 观看人数开关；number.enable 是否开启；观看人数，0 否 1 是；示例：{"enable":"1"}。

​3、**商城开关**（直播推荐课程）：goodsListEdit 商品列表编辑，状态 goodsListEdit.status，0 覆盖，1 追加，不传默认为 0；示例：{"status":1}。

直播设置最终效果：

![修改生活直播相关配置](https://img-blog.csdnimg.cn/cc18bbfd881843c9b0b0071178188cf4.png)

###### 3.1.5、按照课程 ID 获取访客列表

改接口在："访客/管理员列表"下面。

通过该接口统计课程观看人数信息。

**直播**访客 api 名称：`course.visitor.list`，SDK 对应方法：`courseVisitorList`。

##### 3.2、下载 SDK

直播平台准备了 SDK，直接使用。

下载地址：https://open.talk-fun.com/docs/getstartV2/api/introduce/sdkdownload.html

已下载：当前目录/MTCloud-java-sdk-1.6.zip

![下载 SDK](https://img-blog.csdnimg.cn/5d477a68b3574590b60c9e7c13d436fc.png)

#### 5、搭建 service-live 模块

##### 5.1、创建 service-live 模块

![创建 service-live 模块](https://img-blog.csdnimg.cn/c43ee797e5c541ea9554a9f1e33c16c6.png)

##### 5.2、添加依赖

**添加直播 SDK 需要的依赖。**

```xml
<!-- mybatis-plus-generator -->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-generator</artifactId>
    <version>3.5.3.1</version>
</dependency>

<!-- freemarker -->
<dependency>
    <groupId>org.freemarker</groupId>
    <artifactId>freemarker</artifactId>
    <version>2.3.32</version>
</dependency>

<!-- commons-httpclient  -->
<dependency>
    <groupId>commons-httpclient</groupId>
    <artifactId>commons-httpclient</artifactId>
    <version>3.0.1</version>
</dependency>

<!-- json-lib -->
<dependency>
    <groupId>net.sf.json-lib</groupId>
    <artifactId>json-lib</artifactId>
    <version>2.4</version>
    <classifier>jdk15</classifier>
</dependency>
```

##### 5.3、集成代码

解压 MTCloud-java-sdk-1.6.zip，复制 MTCloud-java-sdk-1.6\MTCloud_java\src\com\mtcloud\sdk 下面的 java 文件到 com.myxh.smart.planet.live.mtcloud 包下，如图。

![集成代码](https://img-blog.csdnimg.cn/4a81c10a58d04399b838182bef935533.png)

![集成代码](https://img-blog.csdnimg.cn/636f09b970a940d9a8ad1669923d9f21.png)

##### 5.4、更改配置

更改 MTCloud 类配置。

说明：

​1、更改 openID 与 openToken。

​2、该类官方已经做了接口集成，可以直接使用。

```java
/**
 * Copyright www.talk-fun.com
 */

package com.myxh.smart.planet.live.mtcloud;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author MYXH
 * @date 2023/10/23
 */
public class MTCloud
{
    /**
     * 合作方 ID：合作方在欢拓平台的唯一 ID
     */
    @Value("${mtcloud.openId}")
    public String openID = "";

    /**
     * 合作方秘钥：合作方 ID 对应的参数加密秘钥
     */
    @Value("${mtcloud.openToken}")
    public String openToken = "";
}
```

##### 5.5、创建配置文件和启动类

**（1）application.properties**

```properties
# 服务端口
server.port=8306

# 服务名
spring.application.name=service-live

# 环境设置：dev、test、prod
spring.profiles.active=dev

# MySQL 数据库连接
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/smart_planet_live?characterEncoding=utf-8&useSSL=false
spring.datasource.username=MYXH
spring.datasource.password=520.ILY!

# 返回 Json 的全局时间格式
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8

# MyBatis 日志
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl

# 设置 mapper.xml 的路径
mybatis-plus.mapper-locations=classpath:com/myxh/smart/planet/live/mapper/xml/*.xml

# nacos 服务地址
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848

# 设置 MTCloud 类的配置 openId 与 openToken
mtcloud.openId=61237
mtcloud.openToken=c2c502add3dabfbbacae160432ccb783
```

**（2）启动类。**

```java
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
```

##### 5.6、生成相关代码

![生成相关代码](https://img-blog.csdnimg.cn/a8e106d25b9c48a8991939f968fbe5fa.png)

#### 6、功能实现-直播课程列表接口

![功能实现-直播课程列表接口](https://img-blog.csdnimg.cn/38004eda8164443fb655664b2f6dc91c.png)

根据直播平台与自身业务设计直播相关的业务表，如：smart_planet_live。

##### 6.1、LiveCourseController 类

```java
package com.myxh.smart.planet.live.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 前端控制器
 * </p>
 */
@Tag(name = "直播课程管理", description = "直播课程管理接口")
@RestController
@RequestMapping("/admin/live/live/course")
public class LiveCourseController
{
    @Autowired
    private LiveCourseService liveCourseService;

    /**
     * 条件查询直播课程分页列表
     *
     * @param current 当前页码
     * @param limit   每页记录数
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "条件查询直播课程分页列表", description = "条件查询直播课程分页列表")
    @GetMapping("find/query/page/{current}/{limit}")
    public Result<IPage<LiveCourse>> index(
            @Parameter(name = "current", description = "当前页码", required = true)
            @PathVariable("current") Long current,
            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable("limit") Long limit)
    {
        Page<LiveCourse> LiveCoursePageParam = new Page<>(current, limit);
        IPage<LiveCourse> LiveCoursePageModel = liveCourseService.selectPage(LiveCoursePageParam);

        return Result.ok(LiveCoursePageModel);
    }
}
```

##### 6.2、LiveCourseService 接口

```java
package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourse;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务类
 * </p>
 */
public interface LiveCourseService extends IService<LiveCourse>
{
    /**
     * 条件查询直播课程分页列表
     *
     * @param liveCoursePageParam 直播课程页面参数
     * @return LiveCoursePageModel 直播课程页面
     */
    IPage<LiveCourse> selectPage(Page<LiveCourse> liveCoursePageParam);
}
```

##### 6.3、service-vod 模块创建接口

**（1）获取讲师信息。**

![获取讲师信息](https://img-blog.csdnimg.cn/21ca1aa297704866b2fc47a6f05ad340.png)

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.vod.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/29
 *
 * <p>
 * 教师 前端控制器
 * </p>
 */
@Tag(name = "教师接口", description = "教师管理接口")
@RestController
@RequestMapping("/admin/vod/teacher")
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    /**
     * 根据 id 查询教师
     *
     * @param id id
     * @return teacher 教师
     */
    @Operation(summary = "查询", description = "根据 id 查询教师")
    @GetMapping("inner/get/teacher/{id}")
    public Teacher getTeacherLive(@Parameter(name = "id", description = "ID", required = true) @PathVariable("id") Long id)
    {
        Teacher teacher = teacherService.getById(id);

        return teacher;
    }
}
```

**（2）service-course-client 定义接口。**

![service-course-client 定义接口](https://img-blog.csdnimg.cn/6478a2e0dae549f8a69a0245ab1f007e.png)

```java
package com.myxh.smart.planet.client.course;

import com.myxh.smart.planet.model.vod.Teacher;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author MYXH
 * @date 2023/10/17
 */
@FeignClient("service-vod")
public interface CourseFeignClient
{
    @Operation(summary = "查询", description = "根据 id 查询教师")
    @GetMapping("admin/vod/teacher/inner/get/teacher/{id}")
    Teacher getTeacherLive(@Parameter(name = "id", description = "ID", required = true) @PathVariable("id") Long id);
}
```

##### 6.4、service-live 引入依赖

```xml
<!-- service-course-client -->
<dependency>
    <groupId>com.myxh.smart.planet</groupId>
    <artifactId>service-course-client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>

<!-- service-user-client -->
<dependency>
    <groupId>com.myxh.smart.planet</groupId>
    <artifactId>service-user-client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

##### 6.5、LiveCourseServiceImpl 实现

```java
package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.client.course.CourseFeignClient;
import com.myxh.smart.planet.live.mapper.LiveCourseMapper;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.model.vod.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务实现类
 * </p>
 */
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService
{
    @Autowired
    private CourseFeignClient teacherFeignClient;

    /**
     * 条件查询直播课程分页列表
     *
     * @param liveCoursePageParam 直播课程页面参数
     * @return LiveCoursePageModel 直播课程页面
     */
    @Override
    public IPage<LiveCourse> selectPage(Page<LiveCourse> liveCoursePageParam)
    {
        // 分页查询
        IPage<LiveCourse> LiveCoursePageModel = baseMapper.selectPage(liveCoursePageParam, null);

        // 获取课程教师信息
        List<LiveCourse> liveCourseList = LiveCoursePageModel.getRecords();

        // 遍历获取直播课程 List 集合
        for (LiveCourse liveCourse : liveCourseList)
        {
            // 获取每个课程教师 id
            Long teacherId = liveCourse.getTeacherId();

            // 根据教师 id 查询教师信息
            Teacher teacher = teacherFeignClient.getTeacherLive(teacherId);

            // 进行封装
            liveCourse.getParam().put("teacherName", teacher.getName());
            liveCourse.getParam().put("teacherLevel", teacher.getLevel());
        }

        return LiveCoursePageModel;
    }
}
```

#### 7、功能实现-直播课程添加接口

![功能实现-直播课程添加接口](https://img-blog.csdnimg.cn/c603687623fc4af18d9d1243013e23a7.png)

##### 7.1、添加工具类

![添加工具类](https://img-blog.csdnimg.cn/6198c942f4d34ed5bf635a8b1ebc47f2.png)

**（1）MTCloudAccountConfig 类。**

```java
package com.myxh.smart.planet.live.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/10/26
 */
@Data
@Component
@ConfigurationProperties(prefix = "mtcloud")
public class MTCloudAccountConfig
{
    private String openId;
    private String openToken;
}
```

**（2）MTCloudConfig 类。**

```java
package com.myxh.smart.planet.live.config;

import com.myxh.smart.planet.live.mtcloud.MTCloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/10/26
 */
@Component
public class MTCloudConfig
{
    @Autowired
    private MTCloudAccountConfig mtCloudAccountConfig;

    @Bean
    public MTCloud mtCloudClient()
    {
        return new MTCloud(mtCloudAccountConfig.getOpenId(), mtCloudAccountConfig.getOpenToken());
    }
}
```

##### 7.2、LiveCourseController 类

```java
package com.myxh.smart.planet.live.controller;

import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.live.LiveCourseFormVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 前端控制器
 * </p>
 */
@Tag(name = "直播课程管理", description = "直播课程管理接口")
@RestController
@RequestMapping("/admin/live/live/course")
public class LiveCourseController
{
    @Autowired
    private LiveCourseService liveCourseService;

    /**
     * 添加直播课程
     *
     * @param liveCourseFormVo 直播课程
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "添加直播课程", description = "添加直播课程")
    @PostMapping("save")
    public Result<Void> save(@RequestBody LiveCourseFormVo liveCourseFormVo)
    {
        liveCourseService.saveLive(liveCourseFormVo);

        return Result.ok(null);
    }
}
```

##### 7.3、LiveCourseService 接口

```java
package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.vo.live.LiveCourseFormVo;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务类
 * </p>
 */
public interface LiveCourseService extends IService<LiveCourse>
{
    /**
     * 添加直播课程
     *
     * @param liveCourseFormVo 直播课程
     */
    void saveLive(LiveCourseFormVo liveCourseFormVo);
}
```

##### 7.4、LiveCourseServiceImpl 实现

```java
package com.myxh.smart.planet.live.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.client.course.CourseFeignClient;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.live.mapper.LiveCourseMapper;
import com.myxh.smart.planet.live.mtcloud.CommonResult;
import com.myxh.smart.planet.live.mtcloud.MTCloud;
import com.myxh.smart.planet.live.service.LiveCourseAccountService;
import com.myxh.smart.planet.live.service.LiveCourseDescriptionService;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.model.live.LiveCourseAccount;
import com.myxh.smart.planet.model.live.LiveCourseDescription;
import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.vo.live.LiveCourseFormVo;
import lombok.SneakyThrows;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务实现类
 * </p>
 */
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService
{
    @Autowired
    private CourseFeignClient teacherFeignClient;

    @Autowired
    private MTCloud mtCloudClient;

    @Autowired
    private LiveCourseDescriptionService liveCourseDescriptionService;

    @Autowired
    private LiveCourseAccountService liveCourseAccountService;

    /**
     * 添加直播课程
     *
     * @param liveCourseFormVo 直播课程
     */
    @SneakyThrows
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void saveLive(LiveCourseFormVo liveCourseFormVo)
    {
        LiveCourse liveCourse = new LiveCourse();
        BeanUtils.copyProperties(liveCourseFormVo, liveCourse);

        // 获取教师信息
        Teacher teacher = teacherFeignClient.getTeacherLive(liveCourseFormVo.getTeacherId());

        // 调用方法添加直播课程
        // 创建 map 集合，封装直播课程其他参数
        HashMap<Object, Object> options = new HashMap<>();

        // 直播类型，1：教育直播，2：生活直播
        // 默认 1，说明：根据平台开通的直播类型填写
        options.put("scenes", 1);
        options.put("password", liveCourseFormVo.getPassword());

        /*
        course_name  课程名称
        bid      发起直播课程的主播账号
        start_time   课程开始时间，格式：2015-01-10 12:00:00
        end_time     课程结束时间，格式：2015-01-10 13:00:00
        nickname     昵称
        accountIntro 主播介绍
        options      其他参数
         */
        String res = mtCloudClient.courseAdd(liveCourse.getCourseName(),
                teacher.getId().toString(),
                new DateTime(liveCourse.getStartTime()).toString("yyyy-MM-dd HH:mm:ss"),
                new DateTime(liveCourse.getEndTime()).toString("yyyy-MM-dd HH:mm:ss"),
                teacher.getName(),
                teacher.getIntro(),
                options);
        System.out.println("res = " + res);
        CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);

        // 把创建之后返回结果进行判断
        if (Integer.parseInt(commonResult.getCode()) == MTCloud.CODE_SUCCESS)
        {
            // 添加直播基本信息
            JSONObject object = commonResult.getData();

            // 直播课程 id
            Long courseId = object.getLong("course_id");
            liveCourse.setCourseId(courseId);
            baseMapper.insert(liveCourse);

            // 添加直播描述信息
            LiveCourseDescription liveCourseDescription = new LiveCourseDescription();
            liveCourseDescription.setLiveCourseId(liveCourse.getId());
            liveCourseDescription.setDescription(liveCourseFormVo.getDescription());
            liveCourseDescriptionService.save(liveCourseDescription);

            // 添加直播账号信息
            LiveCourseAccount liveCourseAccount = new LiveCourseAccount();
            liveCourseAccount.setLiveCourseId(liveCourse.getId());
            liveCourseAccount.setAnchorAccount(object.getString("bid"));
            liveCourseAccount.setAnchorPassword(liveCourseFormVo.getPassword());
            liveCourseAccount.setAdminKey(object.getString("admin_key"));
            liveCourseAccount.setUserKey(object.getString("user_key"));
            liveCourseAccount.setAnchorKey(object.getString("zhubo_key"));
            liveCourseAccountService.save(liveCourseAccount);
        }
        else
        {
            String msg = commonResult.getMsg();
            System.out.println("msg = " + msg);
            throw new SmartPlanetException(20001, "直播创建失败！" + msg);
        }
    }
}
```

#### 8、功能实现-直播课程删除接口

![功能实现-直播课程删除接口](https://img-blog.csdnimg.cn/61dd625f14f24bf790c3083990996579.png)

##### 8.1、LiveCourseController 类

```java
package com.myxh.smart.planet.live.controller;

import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 前端控制器
 * </p>
 */
@Tag(name = "直播课程管理", description = "直播课程管理接口")
@RestController
@RequestMapping("/admin/live/live/course")
public class LiveCourseController
{
    @Autowired
    private LiveCourseService liveCourseService;

    /**
     * 删除直播课程
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "删除直播课程", description = "删除直播课程")
    @DeleteMapping("remove/{id}")
    public Result<Void> remove(@PathVariable("id") Long id)
    {
        liveCourseService.removeLive(id);

        return Result.ok(null);
    }
}
```

##### 8.2、LiveCourseService 接口

```java
package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourse;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务类
 * </p>
 */
public interface LiveCourseService extends IService<LiveCourse>
{
    /**
     * 删除直播课程
     *
     * @param id id
     */
    void removeLive(Long id);
}
```

##### 8.3、LiveCourseServiceImpl 实现

```java
package com.myxh.smart.planet.live.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.live.mapper.LiveCourseMapper;
import com.myxh.smart.planet.live.mtcloud.CommonResult;
import com.myxh.smart.planet.live.mtcloud.MTCloud;
import com.myxh.smart.planet.live.service.LiveCourseAccountService;
import com.myxh.smart.planet.live.service.LiveCourseDescriptionService;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.model.live.LiveCourseAccount;
import com.myxh.smart.planet.model.live.LiveCourseDescription;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务实现类
 * </p>
 */
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService
{
    @Autowired
    private MTCloud mtCloudClient;

    @Autowired
    private LiveCourseDescriptionService liveCourseDescriptionService;

    @Autowired
    private LiveCourseAccountService liveCourseAccountService;

    /**
     * 删除直播课程
     *
     * @param id id
     */
    @SneakyThrows
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void removeLive(Long id)
    {
        // 根据 id 查询直播课程信息
        LiveCourse liveCourse = baseMapper.selectById(id);

        if (liveCourse != null)
        {
            // 获取直播 courseId
            Long courseId = liveCourse.getCourseId();

            // 调用方法删除平台直播课程
            String res = mtCloudClient.courseDelete(courseId.toString());
            System.out.println("res = " + res);
            CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);

            // 把删除之后返回结果进行判断
            if (Integer.parseInt(commonResult.getCode()) == MTCloud.CODE_SUCCESS)
            {
                // 删除直播基本信息
                baseMapper.deleteById(id);

                // 删除直播描述信息
                liveCourseDescriptionService.remove(new LambdaQueryWrapper<LiveCourseDescription>().ge(LiveCourseDescription::getLiveCourseId, id));

                // 删除直播账号信息
                liveCourseAccountService.remove(new LambdaQueryWrapper<LiveCourseAccount>().ge(LiveCourseAccount::getLiveCourseId, id));
            }
            else
            {
                String msg = commonResult.getMsg();
                System.out.println("msg = " + msg);
                throw new SmartPlanetException(20001, "删除直播课程失败！" + msg);
            }
        }
    }
}
```

#### 9、功能实现-直播课程修改接口

![功能实现-直播课程修改接口](https://img-blog.csdnimg.cn/a8474eec41da419a959250f0565fea7c.png)

##### 9.1、LiveCourseController 类

```java
package com.myxh.smart.planet.live.controller;

import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.live.LiveCourseFormVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 前端控制器
 * </p>
 */
@Tag(name = "直播课程管理", description = "直播课程管理接口")
@RestController
@RequestMapping("/admin/live/live/course")
public class LiveCourseController
{
    @Autowired
    private LiveCourseService liveCourseService;

    /**
     * 根据 id 查询直播课程基本信息
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据 id 查询直播课程基本信息", description = "根据 id 查询直播课程基本信息")
    @GetMapping("get/{id}")
    public Result<LiveCourse> get(@PathVariable("id") Long id)
    {
        LiveCourse liveCourse = liveCourseService.getById(id);

        return Result.ok(liveCourse);
    }

    /**
     * 根据 id 查询直播课程基本信息和描述信息
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据 id 查询直播课程基本信息和描述信息", description = "根据 id 查询直播课程基本信息和描述信息")
    @GetMapping("get/info/{id}")
    public Result<LiveCourseFormVo> getInfo(@PathVariable("id") Long id)
    {
        LiveCourseFormVo liveCourseFormVo = liveCourseService.getLiveCourseFormVo(id);

        return Result.ok(liveCourseFormVo);
    }

    /**
     * 更新直播课程
     *
     * @param liveCourseFormVo 直播课程
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "更新直播课程", description = "更新直播课程")
    @PutMapping("update")
    public Result<Void> updateById(@RequestBody LiveCourseFormVo liveCourseFormVo)
    {
        liveCourseService.updateLiveById(liveCourseFormVo);

        return Result.ok(null);
    }
}
```

##### 9.2、LiveCourseService 接口

```java
package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.vo.live.LiveCourseFormVo;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务类
 * </p>
 */
public interface LiveCourseService extends IService<LiveCourse>
{
    /**
     * 根据 id 查询直播课程基本信息和描述信息
     *
     * @param id id
     * @return liveCourseFormVo 直播课程
     */
    LiveCourseFormVo getLiveCourseFormVo(Long id);

    /**
     * 更新直播课程
     *
     * @param liveCourseFormVo 直播课程
     */
    void updateLiveById(LiveCourseFormVo liveCourseFormVo);
}
```

##### 9.3、LiveCourseServiceImpl 实现

```java
package com.myxh.smart.planet.live.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.client.course.CourseFeignClient;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.live.mapper.LiveCourseMapper;
import com.myxh.smart.planet.live.mtcloud.CommonResult;
import com.myxh.smart.planet.live.mtcloud.MTCloud;
import com.myxh.smart.planet.live.service.LiveCourseAccountService;
import com.myxh.smart.planet.live.service.LiveCourseDescriptionService;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.model.live.LiveCourseAccount;
import com.myxh.smart.planet.model.live.LiveCourseDescription;
import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.vo.live.LiveCourseFormVo;
import lombok.SneakyThrows;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务实现类
 * </p>
 */
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService
{
    @Autowired
    private CourseFeignClient teacherFeignClient;

    @Autowired
    private MTCloud mtCloudClient;

    @Autowired
    private LiveCourseDescriptionService liveCourseDescriptionService;

    @Autowired
    private LiveCourseAccountService liveCourseAccountService;

    /**
     * 根据 id 查询直播课程基本信息和描述信息
     *
     * @param id id
     * @return liveCourseFormVo 直播课程
     */
    @Override
    public LiveCourseFormVo getLiveCourseFormVo(Long id)
    {
        // 获取直播课程基本信息
        LiveCourse liveCourse = this.getById(id);

        // 获取直播课程描述信息
        LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getLiveCourseDescriptionByLiveCourseId(id);

        // 封装数据
        LiveCourseFormVo liveCourseFormVo = new LiveCourseFormVo();
        BeanUtils.copyProperties(liveCourse, liveCourseFormVo);
        liveCourseFormVo.setDescription(liveCourseDescription.getDescription());

        return liveCourseFormVo;
    }

    /**
     * 更新直播课程
     *
     * @param liveCourseFormVo 直播课程
     */
    @SneakyThrows
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateLiveById(LiveCourseFormVo liveCourseFormVo)
    {
        // 根据 id 获取直播课程基本信息
        LiveCourse liveCourse = baseMapper.selectById(liveCourseFormVo.getId());
        BeanUtils.copyProperties(liveCourseFormVo, liveCourse);

        // 获取教师信息
        Teacher teacher = teacherFeignClient.getTeacherLive(liveCourseFormVo.getTeacherId());

        /*
        course_id 课程ID
        course_name  课程名称
        bid      发起直播课程的主播账号
        start_time   课程开始时间，格式：2015-01-10 12:00:00
        end_time     课程结束时间，格式：2015-01-10 13:00:00
        nickname     昵称
        accountIntro 主播介绍
        options      其他参数
         */
        HashMap<Object, Object> options = new HashMap<>();

        String res = mtCloudClient.courseUpdate(liveCourse.getCourseId().toString(),
                teacher.getId().toString(),
                liveCourse.getCourseName(),
                new DateTime(liveCourse.getStartTime()).toString("yyyy-MM-dd HH:mm:ss"),
                new DateTime(liveCourse.getEndTime()).toString("yyyy-MM-dd HH:mm:ss"),
                teacher.getName(),
                teacher.getIntro(),
                options);
        System.out.println("res = " + res);

        // 返回结果转换，判断是否成功
        CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);

        if (Integer.parseInt(commonResult.getCode()) == MTCloud.CODE_SUCCESS)
        {
            JSONObject object = commonResult.getData();

            // 更新直播课程基本信息
            liveCourse.setCourseId(object.getLong("course_id"));
            baseMapper.updateById(liveCourse);

            // 直播课程描述信息更新
            LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getLiveCourseDescriptionByLiveCourseId(liveCourse.getId());
            liveCourseDescription.setDescription(liveCourseFormVo.getDescription());
            liveCourseDescriptionService.update(liveCourseDescription, new LambdaQueryWrapper<LiveCourseDescription>().ge(LiveCourseDescription::getLiveCourseId, liveCourse.getId()));

            // 更新直播账号信息
            LiveCourseAccount liveCourseAccount = new LiveCourseAccount();
            liveCourseAccount.setLiveCourseId(liveCourse.getId());
            liveCourseAccount.setAnchorAccount(object.getString("bid"));
            liveCourseAccount.setAnchorPassword(liveCourseFormVo.getPassword());
            liveCourseAccount.setAdminKey(object.getString("admin_key"));
            liveCourseAccount.setUserKey(object.getString("user_key"));
            liveCourseAccount.setAnchorKey(object.getString("zhubo_key"));
            liveCourseAccountService.update(liveCourseAccount, new LambdaUpdateWrapper<LiveCourseAccount>().ge(LiveCourseAccount::getLiveCourseId, liveCourse.getId()));
        }
        else
        {
            String msg = commonResult.getMsg();
            System.out.println("msg = " + msg);
            throw new SmartPlanetException(20001, "修改直播课程失败！" + msg);
        }
    }
}
```

##### 9.4、LiveCourseDescriptionService 添加方法

```java
package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourseDescription;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程简介 服务类
 * </p>
 */
public interface LiveCourseDescriptionService extends IService<LiveCourseDescription>
{
    /**
     * 获取直播课程描述信息
     *
     * @param id id
     * @return liveCourseDescription 直播课程描述信息
     */
    LiveCourseDescription getLiveCourseDescriptionByLiveCourseId(Long id);
}
```

##### 9.5、LiveCourseDescriptionServiceImpl 实现方法

```java
package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.live.mapper.LiveCourseDescriptionMapper;
import com.myxh.smart.planet.live.service.LiveCourseDescriptionService;
import com.myxh.smart.planet.model.live.LiveCourseDescription;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程简介 服务实现类
 * </p>
 */
@Service
public class LiveCourseDescriptionServiceImpl extends ServiceImpl<LiveCourseDescriptionMapper, LiveCourseDescription> implements LiveCourseDescriptionService
{
    /**
     * 获取直播课程描述信息
     *
     * @param id id
     * @return liveCourseDescription 直播课程描述信息
     */
    @Override
    public LiveCourseDescription getLiveCourseDescriptionByLiveCourseId(Long id)
    {
        LambdaQueryWrapper<LiveCourseDescription> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LiveCourseDescription::getLiveCourseId, id);
        LiveCourseDescription liveCourseDescription = baseMapper.selectOne(wrapper);

        return liveCourseDescription;
    }
}
```

#### 10、功能实现-查看账号接口

![功能实现-查看账号接口](https://img-blog.csdnimg.cn/b85aa7c730014396b690c057a0274cf8.png)

##### 10.1、LiveCourseController 类

```java
package com.myxh.smart.planet.live.controller;

import com.myxh.smart.planet.live.service.LiveCourseAccountService;
import com.myxh.smart.planet.model.live.LiveCourseAccount;
import com.myxh.smart.planet.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 前端控制器
 * </p>
 */
@Tag(name = "直播课程管理", description = "直播课程管理接口")
@RestController
@RequestMapping("/admin/live/live/course")
public class LiveCourseController
{
    @Autowired
    private LiveCourseAccountService liveCourseAccountService;

    /**
     * 获取直播账号信息
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取直播账号信息", description = "获取直播账号信息")
    @GetMapping("get/live/course/account/{id}")
    public Result<LiveCourseAccount> getLiveCourseAccount(@PathVariable("id") Long id)
    {
        LiveCourseAccount liveCourseAccount = liveCourseAccountService.getLiveCourseAccountByLiveCourseId(id);

        return Result.ok(liveCourseAccount);
    }
}
```

##### 10.2、LiveCourseAccountService 接口

```java
package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourseAccount;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程账号（受保护信息） 服务类
 * </p>
 */
public interface LiveCourseAccountService extends IService<LiveCourseAccount>
{
    /**
     * 获取直播账号信息
     *
     * @param id id
     * @return liveCourseAccount 直播账号信息
     */
    LiveCourseAccount getLiveCourseAccountByLiveCourseId(Long id);
}
```

##### 10.3、LiveCourseAccountServiceImpl 实现

```java
package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.live.mapper.LiveCourseAccountMapper;
import com.myxh.smart.planet.live.service.LiveCourseAccountService;
import com.myxh.smart.planet.model.live.LiveCourseAccount;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程账号（受保护信息） 服务实现类
 * </p>
 */
@Service
public class LiveCourseAccountServiceImpl extends ServiceImpl<LiveCourseAccountMapper, LiveCourseAccount> implements LiveCourseAccountService
{
    /**
     * 获取直播账号信息
     *
     * @param id id
     * @return liveCourseAccount 直播账号信息
     */
    @Override
    public LiveCourseAccount getLiveCourseAccountByLiveCourseId(Long id)
    {
        LambdaQueryWrapper<LiveCourseAccount> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LiveCourseAccount::getLiveCourseId, id);
        LiveCourseAccount liveCourseAccount = baseMapper.selectOne(wrapper);

        return liveCourseAccount;
    }
}
```

#### 11、功能实现-配置和观看记录接口

![功能实现-配置和观看记录接口](https://img-blog.csdnimg.cn/ac8f2f37b0b64c5cb177e1c324bd7385.png)

##### 11.1、查看配置信息

**（1）LiveCourseController 类。**

```java
package com.myxh.smart.planet.live.controller;

import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.live.LiveCourseConfigVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 前端控制器
 * </p>
 */
@Tag(name = "直播课程管理", description = "直播课程管理接口")
@RestController
@RequestMapping("/admin/live/live/course")
public class LiveCourseController
{
    @Autowired
    private LiveCourseService liveCourseService;

    /**
     * 获取直播配置信息
     *
     * @param id id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取直播配置信息", description = "获取直播配置信息")
    @GetMapping("get/course/config/{id}")
    public Result<LiveCourseConfigVo> getCourseConfig(@PathVariable("id") Long id)
    {
        LiveCourseConfigVo liveCourseConfigVo = liveCourseService.getCourseConfig(id);

        return Result.ok(liveCourseConfigVo);
    }
}
```

**（2）LiveCourseService 添加方法。**

```java
package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.vo.live.LiveCourseConfigVo;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务类
 * </p>
 */
public interface LiveCourseService extends IService<LiveCourse>
{
    /**
     * 获取直播配置信息
     *
     * @param id id
     * @return liveCourseConfigVo 直播配置信息
     */
    LiveCourseConfigVo getCourseConfig(Long id);
}
```

**（3）LiveCourseServiceImpl 实现。**

```java
package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.live.mapper.LiveCourseMapper;
import com.myxh.smart.planet.live.service.LiveCourseConfigService;
import com.myxh.smart.planet.live.service.LiveCourseGoodsService;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.model.live.LiveCourseConfig;
import com.myxh.smart.planet.model.live.LiveCourseGoods;
import com.myxh.smart.planet.vo.live.LiveCourseConfigVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务实现类
 * </p>
 */
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService
{
    @Autowired
    private LiveCourseConfigService liveCourseConfigService;

    @Autowired
    private LiveCourseGoodsService liveCourseGoodsService;

    /**
     * 获取直播配置信息
     *
     * @param id id
     * @return liveCourseConfigVo 直播配置信息
     */
    @Override
    public LiveCourseConfigVo getCourseConfig(Long id)
    {
        LiveCourseConfigVo liveCourseConfigVo = new LiveCourseConfigVo();

        // 根据课程 id 查询直播课程配置信息
        LiveCourseConfig liveCourseConfig = liveCourseConfigService.getLiveCourseConfigByLiveCourseId(id);

        if (liveCourseConfig != null)
        {
            // 查询直播课程商品列表
            List<LiveCourseGoods> liveCourseGoodsList = liveCourseGoodsService.getLiveCourseGoodsByLiveCourseId(id);

            // 封装 LiveCourseConfigVo
            BeanUtils.copyProperties(liveCourseConfig, liveCourseConfigVo);

            // 封装商品列表
            liveCourseConfigVo.setLiveCourseGoodsList(liveCourseGoodsList);
        }

        return liveCourseConfigVo;
    }
}
```

**（4）LiveCourseConfigService 添加方法。**

```java
package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourseConfig;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程配置 服务类
 * </p>
 */
public interface LiveCourseConfigService extends IService<LiveCourseConfig>
{
    /**
     * 根据课程 id 查询直播课程配置信息
     *
     * @param id id
     * @return liveCourseConfig 直播课程配置信息
     */
    LiveCourseConfig getLiveCourseConfigByLiveCourseId(Long id);
}
```

**（5）LiveCourseConfigServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.live.mapper.LiveCourseConfigMapper;
import com.myxh.smart.planet.live.service.LiveCourseConfigService;
import com.myxh.smart.planet.model.live.LiveCourseConfig;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程配置 服务实现类
 * </p>
 */
@Service
public class LiveCourseConfigServiceImpl extends ServiceImpl<LiveCourseConfigMapper, LiveCourseConfig> implements LiveCourseConfigService
{
    /**
     * 根据课程 id 查询直播课程配置信息
     *
     * @param id id
     * @return liveCourseConfig 直播课程配置信息
     */
    @Override
    public LiveCourseConfig getLiveCourseConfigByLiveCourseId(Long id)
    {
        LambdaQueryWrapper<LiveCourseConfig> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LiveCourseConfig::getLiveCourseId, id);
        LiveCourseConfig liveCourseConfig = baseMapper.selectOne(wrapper);

        return liveCourseConfig;
    }
}
```

**（6）LiveCourseGoodsService 添加方法。**

```java
package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourseGoods;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程关联推荐 服务类
 * </p>
 */
public interface LiveCourseGoodsService extends IService<LiveCourseGoods>
{
    /**
     * 查询直播课程商品列表
     *
     * @param id id
     * @return liveCourseGoodsList 直播课程商品列表
     */
    List<LiveCourseGoods> getLiveCourseGoodsByLiveCourseId(Long id);
}
```

**（7）LiveCourseGoodsServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.live.mapper.LiveCourseGoodsMapper;
import com.myxh.smart.planet.live.service.LiveCourseGoodsService;
import com.myxh.smart.planet.model.live.LiveCourseGoods;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程关联推荐 服务实现类
 * </p>
 */
@Service
public class LiveCourseGoodsServiceImpl extends ServiceImpl<LiveCourseGoodsMapper, LiveCourseGoods> implements LiveCourseGoodsService
{
    /**
     * 查询直播课程商品列表
     *
     * @param id id
     * @return liveCourseGoodsList 直播课程商品列表
     */
    @Override
    public List<LiveCourseGoods> getLiveCourseGoodsByLiveCourseId(Long id)
    {
        LambdaQueryWrapper<LiveCourseGoods> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(LiveCourseGoods::getLiveCourseId, id);
        List<LiveCourseGoods> liveCourseGoodsList = baseMapper.selectList(wrapper);

        return liveCourseGoodsList;
    }
}
```

##### 11.2、修改直播配置信息

**（1）LiveCourseController 添加方法。**

```java
package com.myxh.smart.planet.live.controller;

import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.live.LiveCourseConfigVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 前端控制器
 * </p>
 */
@Tag(name = "直播课程管理", description = "直播课程管理接口")
@RestController
@RequestMapping("/admin/live/live/course")
public class LiveCourseController
{
    @Autowired
    private LiveCourseService liveCourseService;

    /**
     * 修改直播配置信息
     *
     * @param liveCourseConfigVo 直播配置信息
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "修改直播配置信息", description = "修改直播配置信息")
    @PutMapping("update/config")
    public Result<Void> updateConfig(@RequestBody LiveCourseConfigVo liveCourseConfigVo)
    {
        liveCourseService.updateCourseConfig(liveCourseConfigVo);

        return Result.ok(null);
    }
}
```

**（2）LiveCourseService 添加方法。**

```java
package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.vo.live.LiveCourseConfigVo;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务类
 * </p>
 */
public interface LiveCourseService extends IService<LiveCourse>
{
    /**
     * 修改直播配置信息
     *
     * @param liveCourseConfigVo 直播配置信息
     */
    void updateCourseConfig(LiveCourseConfigVo liveCourseConfigVo);
}
```

**（3）LiveCourseServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.live.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.live.mapper.LiveCourseMapper;
import com.myxh.smart.planet.live.mtcloud.CommonResult;
import com.myxh.smart.planet.live.mtcloud.MTCloud;
import com.myxh.smart.planet.live.service.LiveCourseConfigService;
import com.myxh.smart.planet.live.service.LiveCourseGoodsService;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.model.live.LiveCourseConfig;
import com.myxh.smart.planet.model.live.LiveCourseGoods;
import com.myxh.smart.planet.vo.live.LiveCourseConfigVo;
import com.myxh.smart.planet.vo.live.LiveCourseGoodsView;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务实现类
 * </p>
 */
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService
{
    @Autowired
    private MTCloud mtCloudClient;

    @Autowired
    private LiveCourseConfigService liveCourseConfigService;

    @Autowired
    private LiveCourseGoodsService liveCourseGoodsService;

    /**
     * 修改直播配置信息
     *
     * @param liveCourseConfigVo 直播配置信息
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateCourseConfig(LiveCourseConfigVo liveCourseConfigVo)
    {
        // 1、修改直播配置表
        LiveCourseConfig liveCourseConfig = new LiveCourseConfig();
        BeanUtils.copyProperties(liveCourseConfigVo, liveCourseConfig);

        if (liveCourseConfigVo.getId() == null)
        {
            liveCourseConfigService.save(liveCourseConfig);
        }
        else
        {
            liveCourseConfigService.update(liveCourseConfig, new LambdaUpdateWrapper<LiveCourseConfig>().eq(LiveCourseConfig::getLiveCourseId, liveCourseConfigVo.getLiveCourseId()));
        }

        // 2、修改直播商品表
        // 根据课程 id 批量删除直播商品列表
        liveCourseGoodsService.remove(new LambdaQueryWrapper<LiveCourseGoods>().eq(LiveCourseGoods::getLiveCourseId, liveCourseConfigVo.getLiveCourseId()));

        // 添加商品列表
        if (!CollectionUtils.isEmpty(liveCourseConfigVo.getLiveCourseGoodsList()))
        {
            liveCourseGoodsService.saveBatch(liveCourseConfigVo.getLiveCourseGoodsList());
        }

        // 3、修改在线直播平台中的直播配置信息
        this.updateLiveConfig(liveCourseConfigVo);
    }

    /**
     * 上传直播配置，修改在线直播平台中的直播配置信息
     *
     * @param liveCourseConfigVo 直播配置信息
     */
    @SneakyThrows
    private void updateLiveConfig(LiveCourseConfigVo liveCourseConfigVo)
    {
        LiveCourse liveCourse = baseMapper.selectById(liveCourseConfigVo.getLiveCourseId());

        // 封装平台方法需要的参数
        // 参数设置
        HashMap<Object, Object> options = new HashMap<>();

        // 界面模式
        options.put("pageViewMode", liveCourseConfigVo.getPageViewMode());

        // 观看人数开关
        JSONObject number = new JSONObject();
        number.put("enable", liveCourseConfigVo.getNumberEnable());
        options.put("number", number.toJSONString());

        // 观看人数开关
        JSONObject store = new JSONObject();
        number.put("enable", liveCourseConfigVo.getStoreEnable());
        number.put("type", liveCourseConfigVo.getStoreType());
        options.put("store", number.toJSONString());

        // 商城列表
        List<LiveCourseGoods> liveCourseGoodsList = liveCourseConfigVo.getLiveCourseGoodsList();

        if (!CollectionUtils.isEmpty(liveCourseGoodsList))
        {
            List<LiveCourseGoodsView> liveCourseGoodsViewList = new ArrayList<>();

            for (LiveCourseGoods liveCourseGoods : liveCourseGoodsList)
            {
                LiveCourseGoodsView liveCourseGoodsView = new LiveCourseGoodsView();
                BeanUtils.copyProperties(liveCourseGoods, liveCourseGoodsView);
                liveCourseGoodsViewList.add(liveCourseGoodsView);
            }

            JSONObject goodsListEdit = new JSONObject();
            goodsListEdit.put("status", "0");
            options.put("goodsListEdit ", goodsListEdit.toJSONString());
            options.put("goodsList", JSON.toJSONString(liveCourseGoodsViewList));
        }

        String res = mtCloudClient.courseUpdateConfig(liveCourse.getCourseId().toString(), options);
        System.out.println("res = " + res);
        CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);

        if (Integer.parseInt(commonResult.getCode()) != MTCloud.CODE_SUCCESS)
        {
            String msg = commonResult.getMsg();
            System.out.println("msg = " + msg);
            throw new SmartPlanetException(20001, "修改配置信息失败！" + msg);
        }
    }
}
```

##### 11.3、获取最近直播课程

**（1）LiveCourseController 添加方法。**

```java
package com.myxh.smart.planet.live.controller;

import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.live.LiveCourseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 前端控制器
 * </p>
 */
@Tag(name = "直播课程管理", description = "直播课程管理接口")
@RestController
@RequestMapping("/admin/live/live/course")
public class LiveCourseController
{
    @Autowired
    private LiveCourseService liveCourseService;

    /**
     * 获取最近的直播
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取最近的直播", description = "获取最近的直播")
    @GetMapping("find/lately/list")
    public Result<List<LiveCourseVo>> findLatelyList()
    {
        List<LiveCourseVo> liveCourseVoList = liveCourseService.getLatelyList();

        return Result.ok(liveCourseVoList);
    }
}
```

**（2）LiveCourseService 添加方法。**

```java
package com.myxh.smart.planet.live.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.vo.live.LiveCourseVo;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务类
 * </p>
 */
public interface LiveCourseService extends IService<LiveCourse>
{
    /**
     * 获取最近的直播
     *
     * @return liveCourseVoList 直播课程列表
     */
    List<LiveCourseVo> getLatelyList();
}
```

**（3）LiveCourseServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.client.course.CourseFeignClient;
import com.myxh.smart.planet.live.mapper.LiveCourseMapper;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.model.vod.Teacher;
import com.myxh.smart.planet.order.DateUtil;
import com.myxh.smart.planet.vo.live.LiveCourseVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务实现类
 * </p>
 */
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService
{
    @Autowired
    private CourseFeignClient teacherFeignClient;

    /**
     * 获取最近的直播
     *
     * @return liveCourseVoList 直播课程列表
     */
    @Override
    public List<LiveCourseVo> getLatelyList()
    {
        List<LiveCourseVo> liveCourseVoList = baseMapper.findLatelyList();

        for (LiveCourseVo liveCourseVo : liveCourseVoList)
        {
            // 封装开始和结束时间
            liveCourseVo.setStartTimeString(new DateTime(liveCourseVo.getStartTime()).toString("yyyy年MM月dd HH:mm:ss"));
            liveCourseVo.setEndTimeString(new DateTime(liveCourseVo.getEndTime()).toString("yyyy年MM月dd HH:mm:ss"));

            // 封装教师
            Long teacherId = liveCourseVo.getTeacherId();
            Teacher teacher = teacherFeignClient.getTeacherLive(teacherId);
            liveCourseVo.setTeacher(teacher);

            // 封装直播状态
            liveCourseVo.setLiveStatus(this.getLiveStatus(liveCourseVo));
        }

        return liveCourseVoList;
    }

    /**
     * 直播状态，0：未开始，1：直播中，2：直播结束
     *
     * @param liveCourse 直播课程
     * @return liveStatus 直播状态
     */
    private int getLiveStatus(LiveCourse liveCourse)
    {
        // 直播状态，0：未开始，1：直播中，2：直播结束
        int liveStatus;
        Date curTime = new Date();

        if (DateUtil.dateCompare(curTime, liveCourse.getStartTime()))
        {
            liveStatus = 0;
        }
        else if (DateUtil.dateCompare(curTime, liveCourse.getEndTime()))
        {
            liveStatus = 1;
        }
        else
        {
            liveStatus = 2;
        }

        return liveStatus;
    }
}
```

**（4）LiveCourseMapper 添加方法。**

```java
package com.myxh.smart.planet.live.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.vo.live.LiveCourseVo;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 Mapper 接口
 * </p>
 */
public interface LiveCourseMapper extends BaseMapper<LiveCourse>
{
    /**
     * 获取最近的直播
     *
     * @return liveCourseVoList 直播课程列表
     */
    List<LiveCourseVo> findLatelyList();
}
```

**（5）LiveCourseMapper.xml 编写 sql 语句。**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.myxh.smart.planet.live.mapper.LiveCourseMapper">
    <resultMap id="liveCourseMap" type="com.myxh.smart.planet.vo.live.LiveCourseVo" autoMapping="true">
    </resultMap>

    <!-- 用于 select 查询公用抽取的列 -->
    <sql id="columns">
        id, course_id, course_name, start_time, end_time, teacher_id, cover, create_time, update_time, is_deleted
    </sql>

    <select id="findLatelyList" resultMap="liveCourseMap">
        SELECT
        <include refid="columns"/>
        FROM `live_course`
        WHERE DATE(start_time) >= CURDATE()
        ORDER BY id
        LIMIT 5
    </select>
</mapper>
```

## Day 15-直播管理模块和微信分享

### 一、后台系统-直播管理模块

#### 1、直播课程管理前端整合

##### 1.1、service-vod 添加方法

**（1）CourseController 添加方法。**

```java
package com.myxh.smart.planet.vod.controller;

import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vod.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 前端控制器
 * </p>
 */
@Tag(name = "课程接口", description = "课程管理接口")
@RestController
@RequestMapping("/admin/vod/course")
public class CourseController
{
    @Autowired
    private CourseService courseService;

    /**
     * 查询所有课程
     *
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "查询所有课程", description = "查询所有课程")
    @GetMapping("find/all")
    public Result<List<Course>> findAll()
    {
        List<Course> courseList = courseService.findlist();

        return Result.ok(courseList);
    }
}
```

**（2）CourseService 实现方法。**

```java
package com.myxh.smart.planet.vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.model.vod.Course;
import com.myxh.smart.planet.vod.mapper.CourseMapper;
import com.myxh.smart.planet.vod.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MYXH
 * @date 2023/10/8
 *
 * <p>
 * 课程 服务实现类
 * </p>
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService
{
    /**
     * 查询所有课程
     *
     * @return courseList 所有课程列表
     */
    @Override
    public List<Course> findlist()
    {
        List<Course> courseList = baseMapper.selectList(null);

        courseList.stream().forEach(this::getTeacherAndSubjectName);

        return courseList;
    }
}
```

##### 1.2、router/index.js 路由

```javascript
  // 直播管理
  {
    path: "/live",
    component: Layout,
    redirect: "/live/liveCourse/list",
    name: "Live",
    meta: {
      title: "直播管理",
      icon: "el-icon-bangzhu",
    },
    alwaysShow: true,
    children: [
      {
        path: "liveCourse/list",
        name: "liveCourseList",
        component: () => import("@/views/live/liveCourse/list"),
        meta: { title: "直播列表" },
      },
      {
        path: "liveCourse/config/:id",
        name: "liveCourseConfig",
        component: () => import("@/views/live/liveCourse/config"),
        meta: { title: "直播配置" },
        hidden: true,
      },
      {
        path: "liveVisitor/list/:id",
        name: "liveVisitor",
        component: () => import("@/views/live/liveVisitor/list"),
        meta: { title: "观看记录" },
        hidden: true,
      },
    ],
  },
```

##### 1.3、定义调用接口

![定义调用接口](https://img-blog.csdnimg.cn/6719e246c7ff4787b0a878103215e5b2.png)

```javascript
import request from "@/utils/request";

const LIVE_COURSE_API = "/admin/live/live/course";

export default {
  /**
   * 直播课程分页列表
   *
   * @param {number} current 当前页码
   * @param {number} limit 每页记录数
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getPageList(page, limit) {
    return request({
      url: `${LIVE_COURSE_API}/find/query/page/${page}/${limit}`,
      method: "get",
    });
  },

  /**
   * 添加直播课程
   *
   * @param {Object} liveCourse 直播课程
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  save(liveCourse) {
    return request({
      url: `${LIVE_COURSE_API}/save`,
      method: "post",
      data: liveCourse,
    });
  },

  /**
   * 删除直播课程
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeById(id) {
    return request({
      url: `${LIVE_COURSE_API}/remove/${id}`,
      method: "delete",
    });
  },

  /**
   * 根据 id 查询直播课程基本信息和描述信息
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getById(id) {
    return request({
      url: `${LIVE_COURSE_API}/get/info/${id}`,
      method: "get",
    });
  },

  /**
   * 根据 id 修改直播课程
   *
   * @param {Object} liveCourse 直播课程
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateById(liveCourse) {
    return request({
      url: `${LIVE_COURSE_API}/update`,
      method: "put",
      data: liveCourse,
    });
  },

  /**
   * 获取直播账号信息
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getLiveCourseAccount(id) {
    return request({
      url: `${LIVE_COURSE_API}/get/live/course/account/${id}`,
      method: "get",
    });
  },

  /**
   * 获取直播配置信息
   *
   * @param {number} id id
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  getCourseConfig(id) {
    return request({
      url: `${LIVE_COURSE_API}/get/course/config/${id}`,
      method: "get",
    });
  },

  /**
   * 修改直播配置信息
   *
   * @param {Object} liveCourseConfigVo 直播配置信息
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  updateConfig(liveCourseConfigVo) {
    return request({
      url: `${LIVE_COURSE_API}/update/config`,
      method: "put",
      data: liveCourseConfigVo,
    });
  },

  /**
   * 获取最近的直播
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findLatelyList() {
    return request({
      url: `${LIVE_COURSE_API}/find/lately/list`,
      method: "get",
    });
  },

  /**
   * 批量删除直播课程
   *
   * @param {Array}idList id 数组，Json 数组 [1,2,3,...]
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  removeRows(idList) {
    return request({
      url: `${LIVE_COURSE_API}/remove/batch`,
      method: "delete",
      data: idList,
    });
  },
};
```

![定义调用接口](https://img-blog.csdnimg.cn/2e302d10cff6409c883aa9a7585d5dc9.png)

```javascript
import request from "@/utils/request";

const COURSE_API = "/admin/vod/course";

export default {
  /**
   * 查询所有课程
   *
   * @returns {Promise} 返回一个 Promise 对象，表示操作的异步结果
   */
  findAll() {
    return request({
      url: `${COURSE_API}/find/all`,
      method: "get",
    });
  },
};
```

##### 1.4、创建直播页面

![创建直播页面](https://img-blog.csdnimg.cn/ece4d9f4204047e38a13edd3a68be33b.png)

###### 1.4.1、list.vue

```html
<template>
  <div class="app-container">
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <!-- 工具条 -->
    <el-card class="operate-container" shadow="never">
      <i class="el-icon-tickets" style="margin-top: 5px"></i>
      <span style="margin-top: 5px">数据列表</span>
      <el-button class="btn-add" size="mini" @click="add">添 加</el-button>
    </el-card>

    <!-- banner 列表 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      stripe
      border
      style="width: 100%; margin-top: 10px"
    >
      <el-table-column label="序号" width="50" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="封面" width="200" align="center">
        <template slot-scope="scope">
          <img :src="scope.row.cover" width="100%" />
        </template>
      </el-table-column>
      <el-table-column prop="courseName" label="直播名称" />
      <el-table-column prop="startTime" label="直播时间">
        <template slot-scope="scope">
          {{ scope.row.startTime }} 至 {{ scope.row.endTime }}
        </template>
      </el-table-column>
      <el-table-column prop="endTime" label="直播结束时间" />
      <el-table-column prop="param.teacherName" label="直播教师" />
      <el-table-column label="头衔" width="90">
        <template slot-scope="scope">
          <el-tag
            v-if="scope.row.param.teacherLevel === 1"
            type="success"
            size="mini"
            >高级教师</el-tag
          >
          <el-tag v-if="scope.row.param.teacherLevel === 0" size="mini"
            >首席教师</el-tag
          >
        </template>
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间" />

      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <el-button type="text" size="mini" @click="edit(scope.row.id)"
            >修改</el-button
          >
          <el-button
            type="text"
            size="mini"
            @click="removeDataById(scope.row.id)"
            >删除</el-button
          >
          <el-button type="text" size="mini" @click="showAccount(scope.row)"
            >查看账号</el-button
          >
          <router-link :to="'/live/liveCourse/config/' + scope.row.id">
            <el-button type="text" size="mini" style="margin-left: 10px"
              >配置</el-button
            >
          </router-link>
          <router-link :to="'/live/liveVisitor/list/' + scope.row.id">
            <el-button type="text" size="mini">观看记录</el-button>
          </router-link>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      :page-sizes="[5, 10, 20, 30, 40, 50, 100]"
      style="padding: 30px 0; text-align: center"
      layout="sizes, prev, pager, next, jumper, ->, total, slot"
      @current-change="fetchData"
      @size-change="changeSize"
    />

    <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="60%">
      <el-form
        ref="flashPromotionForm"
        label-width="150px"
        size="small"
        style="padding-right: 40px"
      >
        <!-- 课程教师 -->
        <el-form-item label="直播教师">
          <el-select v-model="liveCourse.teacherId" placeholder="请选择">
            <el-option
              v-for="teacher in teacherList"
              :key="teacher.id"
              :label="teacher.name"
              :value="teacher.id"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="直播教师登录密码" v-if="liveCourse.id === ''">
          <el-input v-model="liveCourse.password" />
        </el-form-item>
        <el-form-item label="直播名称">
          <el-input v-model="liveCourse.courseName" />
        </el-form-item>
        <el-form-item label="直播开始时间">
          <el-date-picker
            v-model="liveCourse.startTime"
            type="datetime"
            placeholder="选择开始日期"
            value-format="yyyy-MM-dd HH:mm:ss"
          />
        </el-form-item>
        <el-form-item label="直播结束时间">
          <el-date-picker
            v-model="liveCourse.endTime"
            type="datetime"
            placeholder="选择结束日期"
            value-format="yyyy-MM-dd HH:mm:ss"
          />
        </el-form-item>
        <el-form-item label="直播封面">
          <el-upload
            :show-file-list="false"
            :on-success="handleCoverSuccess"
            :before-upload="beforeCoverUpload"
            :on-error="handleCoverError"
            :action="BASE_API + '/admin/vod/file/upload?module=cover'"
            class="cover-uploader"
          >
            <img v-if="liveCourse.cover" :src="liveCourse.cover" width="60%" />
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>
        <el-form-item label="直播详情">
          <el-input v-model="liveCourse.description" type="textarea" rows="5" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdate()" size="small"
          >确 定</el-button
        >
      </span>
    </el-dialog>

    <el-dialog
      title="查看账号"
      :visible.sync="accountDialogVisible"
      width="60%"
    >
      <el-form
        ref="accountForm"
        label-width="150px"
        size="small"
        style="padding-right: 40px"
      >
        <div style="margin-left: 40px">
          <h4>主播帮助信息</h4>
          <el-row style="height: 35px">
            <el-co>
              <span class="spd-info">主播登录链接：</span>
              <span class="spd-info"
                >https://live.zhibodun.com/live/courseLogin.php?course_id={{
                liveCourseAccount.courseId }}&role=admin</span
              >
            </el-co>
          </el-row>
          <el-row style="height: 35px">
            <el-col>
              <span class="spd-info"
                >主播登录密码：{{ liveCourseAccount.anchorKey }}</span
              >
            </el-col>
          </el-row>
        </div>
        <div style="margin-left: 40px">
          <h4>主播客户端账号信息</h4>
          <el-row style="height: 35px">
            <el-col>
              <span class="spd-info"
                >主播登录账户：{{ liveCourseAccount.anchorAccount }}</span
              >
            </el-col>
          </el-row>
          <el-row style="height: 35px">
            <el-col>
              <span class="spd-info"
                >主播登录密码：{{ liveCourseAccount.anchorPassword }}</span
              >
            </el-col>
          </el-row>
        </div>

        <div style="margin-left: 40px">
          <h4>助教信息</h4>
          <el-row style="height: 35px">
            <el-co>
              <span class="spd-info">助教登录连接：</span>
              <span class="spd-info"
                >https://live.zhibodun.com/live/courseLogin.php?course_id={{
                liveCourseAccount.courseId }}&role=admin</span
              >
            </el-co>
          </el-row>
          <el-row style="height: 35px">
            <el-col>
              <span class="spd-info"
                >主播登录密码：{{ liveCourseAccount.adminKey }}</span
              >
            </el-col>
          </el-row>
        </div>
        <div style="margin-left: 40px">
          <h4>学生观看信息</h4>
          <el-row style="height: 35px">
            <el-co>
              <span class="spd-info">观看连接：</span>
              <span class="spd-info"
                >http://smartplanetmobile.free.idcfengye.com/#/live/info/{{
                liveCourseAccount.courseId }}</span
              >
            </el-co>
          </el-row>
          <el-row style="height: 35px">
            <el-col>
              <span class="spd-info"
                >观看二维码：<img src="@/assets/SmartPlanet.png" width="80px"
              /></span>
            </el-col>
          </el-row>
        </div>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="accountDialogVisible = false" size="small"
          >关 闭</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import liveCourseAPI from "@/api/live/liveCourse";
  import teacherAPI from "@/api/vod/teacher";

  const defaultForm = {
    id: "",
    courseName: "",
    startTime: "",
    endTime: "",
    teacherId: "",
    password: "",
    description: "",
    cover: "https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png",
  };

  export default {
    data() {
      return {
        BASE_API: "http://localhost:8333",
        // BASE_API: "http://smartplanet.free.idcfengye.com",

        // 数据是否正在加载
        listLoading: true,

        // banner 列表
        list: null,

        // 数据库中的总记录数
        total: 0,

        // 默认页码
        page: 1,

        // 每页记录数
        limit: 10,

        // 查询表单对象
        searchObj: {},

        // 教师列表
        teacherList: [],

        dialogVisible: false,
        liveCourse: defaultForm,
        saveBtnDisabled: false,
        accountDialogVisible: false,

        liveCourseAccount: {
          courseId: "",
        },
      };
    },

    // 生命周期函数：内存准备完毕，页面尚未渲染
    created() {
      console.log("list created...");
      this.fetchData();

      // 获取教师列表
      this.initTeacherList();
    },

    // 生命周期函数：内存准备完毕，页面渲染成功
    mounted() {
      console.log("list mounted...");
    },

    methods: {
      // 当页码发生改变的时候
      changeSize(size) {
        console.log(size);
        this.limit = size;
        this.fetchData(1);
      },

      // 加载 banner 列表数据
      fetchData(page = 1) {
        console.log("翻页..." + page);

        // 异步获取远程数据（ajax）
        this.page = page;

        liveCourseAPI.getPageList(this.page, this.limit).then((response) => {
          this.list = response.data.records;
          this.total = response.data.total;

          // 数据加载并绑定成功
          this.listLoading = false;
        });
      },

      // 获取教师列表
      initTeacherList() {
        teacherAPI.list().then((response) => {
          this.teacherList = response.data;
        });
      },

      // 重置查询表单
      resetData() {
        console.log("重置查询表单");
        this.searchObj = {};
        this.fetchData();
      },

      // 根据 id 删除数据
      removeDataById(id) {
        this.$confirm("此操作将永久删除该记录, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            // 点击确定，远程调用ajax
            return liveCourseAPI.removeById(id);
          })
          .then((response) => {
            this.fetchData(this.page);

            if (response.code) {
              this.$message({
                type: "success",
                message: "删除成功!",
              });
            }
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消删除",
            });
          });
      },

      add() {
        this.dialogVisible = true;
        this.liveCourse = Object.assign({}, defaultForm);
      },

      edit(id) {
        this.dialogVisible = true;
        this.fetchDataById(id);
      },

      fetchDataById(id) {
        liveCourseAPI.getById(id).then((response) => {
          this.liveCourse = response.data;
        });
      },

      saveOrUpdate() {
        // 防止表单重复提交
        this.saveBtnDisabled = true;

        if (!this.liveCourse.teacherId) {
          this.$message.error("请选择直播教师");
          this.saveBtnDisabled = false;

          return;
        }

        if (!this.liveCourse.id && !this.liveCourse.password) {
          this.$message.error("请输入直播教师登录密码");
          this.saveBtnDisabled = false;

          return;
        }

        if (!this.liveCourse.courseName) {
          this.$message.error("请输入直播名称");
          this.saveBtnDisabled = false;

          return;
        }

        if (!this.liveCourse.courseName) {
          this.$message.error("请输入直播名称");
          this.saveBtnDisabled = false;

          return;
        }

        if (!this.liveCourse.startTime) {
          this.$message.error("请选择直播开始时间");
          this.saveBtnDisabled = false;

          return;
        }

        if (!this.liveCourse.endTime) {
          this.$message.error("请选择直播结束时间");
          this.saveBtnDisabled = false;

          return;
        }

        // 验证开始时间和结束时间的合法性
        if (!this.validateDateRange()) {
          return;
        }

        if (!this.liveCourse.description) {
          this.$message.error("请输入直播详情");
          this.saveBtnDisabled = false;

          return;
        }

        if (!this.liveCourse.id) {
          this.saveData();
        } else {
          this.updateData();
        }
      },

      // 验证开始时间和结束时间的合法性
      validateDateRange() {
        if (
          this.liveCourse.startTime &&
          this.liveCourse.endTime &&
          this.liveCourse.startTime > this.liveCourse.endTime
        ) {
          this.$message.error("开始时间不能晚于结束时间");
          return false;
        }

        const startDateTime = new Date(this.liveCourse.startTime);
        const endDateTime = new Date(this.liveCourse.endTime);
        const durationInMilliseconds = endDateTime - startDateTime;
        const durationInHours = durationInMilliseconds / (1000 * 60 * 60);

        if (durationInHours > 24) {
          this.$message.error("直播时间不能超过24小时");
          return false;
        }

        return true;
      },

      // 新增
      saveData() {
        liveCourseAPI.save(this.liveCourse).then((response) => {
          if (response.code) {
            this.$message({
              type: "success",
              message: response.message,
            });

            this.dialogVisible = false;
            this.fetchData(this.page);
          }
        });
      },

      // 根据 id 更新记录
      updateData() {
        liveCourseAPI.updateById(this.liveCourse).then((response) => {
          if (response.code) {
            this.$message({
              type: "success",
              message: response.message,
            });

            this.dialogVisible = false;
            this.fetchData(this.page);
          }
        });
      },

      // 根据 id 查询记录
      fetchDataById(id) {
        liveCourseAPI.getById(id).then((response) => {
          this.liveCourse = response.data;
        });
      },

      showAccount(row) {
        this.accountDialogVisible = true;
        liveCourseAPI.getLiveCourseAccount(row.id).then((response) => {
          this.liveCourseAccount = response.data;
          this.liveCourseAccount.courseId = row.courseId;
        });
      },

      // 上传成功回调
      handleCoverSuccess(res, file) {
        this.liveCourse.cover = res.data;
      },

      // 上传校验
      beforeCoverUpload(file) {
        const isJPG = file.type === "image/jpeg";
        const isPNG = file.type === "image/png";
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG && !isPNG) {
          this.$message.error("上传直播封面只能是 JPG 或 PNG 格式!");
        }
        if (!isLt2M) {
          this.$message.error("上传直播封面大小不能超过 2MB!");
        }

        return (isJPG || isPNG) && isLt2M;
      },

      // 错误处理
      handleCoverError() {
        console.log("error");
        this.$message.error("上传失败");
      },
    },
  };
</script>
```

###### 1.4.2、config.vue

```html
<template>
  <div class="app-container">
    <el-form label-width="120px" size="small">
      <div
        style="
          background-color: #e0e0e0;
          width: 100%;
          padding: 1px 10px;
          margin: 10px 0;
        "
      >
        <h3>功能设置&nbsp;&nbsp;&nbsp;</h3>
      </div>
      <el-form-item label="界面模式">
        <el-radio-group v-model="liveCourseConfigVo.pageViewMode">
          <el-radio :label="1">全屏模式</el-radio>
          <el-radio :label="0">二分屏</el-radio>
          <el-radio :label="2">课件模式</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="观看人数开关">
        <el-radio-group v-model="liveCourseConfigVo.numberEnable">
          <el-radio :label="1">是</el-radio>
          <el-radio :label="0">否</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="商城开关:">
        <el-radio-group v-model="liveCourseConfigVo.storeEnable">
          <el-radio :label="1">是</el-radio>
          <el-radio :label="0">否</el-radio>
        </el-radio-group>
      </el-form-item>

      <div
        style="
          background-color: #e0e0e0;
          width: 100%;
          padding: 1px 10px;
          margin: 10px 0;
        "
      >
        <h3>
          商品列表&nbsp;&nbsp;&nbsp;
          <el-button type="" size="mini" @click="addCourse()"
            >添加 / 更新</el-button
          >
        </h3>
      </div>
      <el-table
        v-loading="listLoading"
        :data="liveCourseConfigVo.liveCourseGoodsList"
        stripe
        border
        style="width: 100%; margin-top: 10px"
      >
        <el-table-column label="序号" width="70" align="center">
          <template slot-scope="scope"> {{ scope.$index + 1 }} </template>
        </el-table-column>
        <el-table-column label="商品图片" width="120" align="center">
          <template slot-scope="scope">
            <img :src="scope.row.img" width="80px" />
          </template>
        </el-table-column>
        <el-table-column prop="name" label="名称" width="100" />
        <el-table-column prop="price" label="价格" width="100" />
        <el-table-column prop="originalPrice" label="原价" />
      </el-table>

      <el-dialog
        title="添加 / 更新课程"
        :visible.sync="dialogVisible"
        width="50%"
      >
        <el-form
          :inline="true"
          label-width="150px"
          size="small"
          style="padding-right: 40px"
        >
          <el-table
            v-loading="listLoading"
            :data="courseList"
            stripe
            border
            style="width: 100%; margin-top: 10px"
            @selection-change="handleSelectionChange"
          >
            <el-table-column type="selection" width="55" />
            <el-table-column label="序号" width="70" align="center">
              <template slot-scope="scope"> {{ scope.$index + 1 }} </template>
            </el-table-column>
            <el-table-column label="分类">
              <template slot-scope="scope">
                {{ scope.row.param.subjectParentTitle }} > {{
                scope.row.param.subjectTitle }}
              </template>
            </el-table-column>
            <el-table-column prop="title" label="课程名称" width="150" />
            <el-table-column prop="lessonNum" label="课时" width="100" />
            <el-table-column prop="param.teacherName" label="教师" />
          </el-table>
          <el-form-item style="margin-top: 10px">
            <el-button type="" @click="dialogVisible = false">取消</el-button>
            <el-button type="" @click="selectCourse()">保存</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>

      <br /><br />
      <el-form-item>
        <el-button type="primary" @click="saveOrUpdate">保存</el-button>
        <el-button @click="back">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import liveCourseAPI from "@/api/live/liveCourse";
  import courseAPI from "@/api/vod/course";

  const defaultForm = {
    id: "",
    liveCourseId: "",
    pageViewMode: 1,
    numberEnable: 1,
    storeEnable: 1,
    storeType: 1,
    liveCourseGoodsList: [],
  };

  export default {
    data() {
      return {
        // 数据是否正在加载
        listLoading: true,

        liveCourseConfigVo: defaultForm,
        saveBtnDisabled: false,
        dialogVisible: false,
        courseList: [],

        // 批量选择中选择的记录列表
        multipleSelection: [],
      };
    },

    // 监听器
    watch: {
      $route(to, from) {
        console.log("路由变化...");
        console.log(to);
        console.log(from);
        this.init();
      },
    },

    // 生命周期方法（在路由切换，组件不变的情况下不会被调用）
    created() {
      console.log("form created...");
      this.init();
    },

    methods: {
      // 表单初始化
      init() {
        this.liveCourseConfigVo.liveCourseId = this.$route.params.id;
        this.fetchDataById(this.liveCourseConfigVo.liveCourseId);
        this.fetchCourseList();
      },

      back() {
        this.$router.push({ path: "/live/liveCourse/list" });
      },

      // 根据 id 查询记录
      fetchDataById(id) {
        liveCourseAPI.getCourseConfig(id).then((response) => {
          if (null !== response.data.id) {
            this.liveCourseConfigVo = response.data;
          }

          this.listLoading = false;
        });
      },

      fetchCourseList() {
        courseAPI.findAll().then((response) => {
          this.courseList = response.data;
        });
      },

      handleSelectionChange(selection) {
        console.log(selection);
        this.multipleSelection = selection;
      },

      addCourse() {
        this.dialogVisible = true;
      },

      selectCourse() {
        if (this.multipleSelection.length === 0) {
          this.$message({
            type: "warning",
            message: "请选择对应课程!",
          });

          return;
        }

        let list = [];

        this.multipleSelection.forEach((item) => {
          var obj = {
            liveCourseId: this.liveCourseConfigVo.liveCourseId,
            goodsId: item.id,
            name: item.title,
            img: item.cover,
            price: item.price,
            originalPrice: item.price,
            tab: "1",
            url:
              "http://smartplanetmobile.free.idcfengye.com/#/course/info/" +
              item.id,
            putaway: "1",
            pay: "1",
            qrcode: "",
          };

          list.push(obj);
        });

        this.liveCourseConfigVo.liveCourseGoodsList = list;
        this.dialogVisible = false;
      },

      saveOrUpdate() {
        liveCourseAPI.updateConfig(this.liveCourseConfigVo).then((response) => {
          this.$message({
            type: "success",
            message: response.message,
          });

          this.$router.push({ path: "/live/liveCourse/list" });
        });
      },
    },
  };
</script>
```

### 二、公众号直播对接

#### 1、用户观看端集成

接口文档：https://open.talk-fun.com/docs/js/index.html

##### 1.1、获取用户 access_token

用户要观看直播，必须获取对应的用户 access_token，通过 access_token 获取观看的直播课程；

接口参数：直播 id，用户 id。

**（1）创建 LiveCourseApiController。**

```java
package com.myxh.smart.planet.live.api;

import com.alibaba.fastjson2.JSONObject;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.order.AuthContextHolder;
import com.myxh.smart.planet.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/28
 */
@Tag(name = "直播课程 API", description = "直播课程 API 接口")
@RestController
@RequestMapping("api/live/live/course")
public class LiveCourseApiController
{
    @Resource
    private LiveCourseService liveCourseService;

    /**
     * 获取用户 access_token
     *
     * @param id 直播课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "获取用户 access_token", description = "获取用户 access_token")
    @GetMapping("get/play/auth/{id}")
    public Result<JSONObject> getPlayAuth(@PathVariable("id") Long id)
    {
        JSONObject accessToken = liveCourseService.getAccessToken(id, AuthContextHolder.getUserId());

        return Result.ok(accessToken);
    }
}
```

**（2）LiveCourseService 添加方法。**

```java
package com.myxh.smart.planet.live.service;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.myxh.smart.planet.model.live.LiveCourse;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务类
 * </p>
 */
public interface LiveCourseService extends IService<LiveCourse>
{
    /**
     * 获取用户 access_token
     *
     * @param id     id 直播课程 id
     * @param userId 用户 id
     * @return accessToken 访问令牌
     */
    JSONObject getAccessToken(Long id, Long userId);
}
```

**（3）LiveCourseServiceImpl 实现方法。**

```java
package com.myxh.smart.planet.live.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.client.user.UserInfoFeignClient;
import com.myxh.smart.planet.exception.SmartPlanetException;
import com.myxh.smart.planet.live.mapper.LiveCourseMapper;
import com.myxh.smart.planet.live.mtcloud.CommonResult;
import com.myxh.smart.planet.live.mtcloud.MTCloud;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.model.user.UserInfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务实现类
 * </p>
 */
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService
{
    @Autowired
    private UserInfoFeignClient userInfoFeignClient;

    @Autowired
    private MTCloud mtCloudClient;

    /**
     * 获取用户 access_token
     *
     * @param id     id 直播课程 id
     * @param userId 用户 id
     * @return accessToken 访问令牌
     */
    @SneakyThrows
    @Override
    public JSONObject getAccessToken(Long id, Long userId)
    {
        // 根据课程 id 获取直播课程信息
        LiveCourse liveCourse = baseMapper.selectById(id);

        // 根据用户 id 获取用户信息
        UserInfo userInfo = userInfoFeignClient.getUserInfoById(userId);

        // 封装需要的参数
        HashMap<Object, Object> options = new HashMap<>();
        String res = mtCloudClient.courseAccess(liveCourse.getCourseId().toString(),
                userId.toString(),
                userInfo.getNickName(),
                MTCloud.ROLE_USER,
                80 * 80 * 80,
                options);
        System.out.println("res = " + res);
        CommonResult<JSONObject> commonResult = JSON.parseObject(res, CommonResult.class);

        if (Integer.parseInt(commonResult.getCode()) == MTCloud.CODE_SUCCESS)
        {
            JSONObject accessToken = commonResult.getData();
            System.out.println("access_token = " + accessToken.getString("access_token"));

            return accessToken;
        }
        else
        {
            throw new SmartPlanetException(20001, "获取失败");
        }
    }
}
```

##### 1.2、下载前端 SDK

下载地址：https://open.talk-fun.com/docs/js/download.html

![下载前端 SDK](https://img-blog.csdnimg.cn/caf8837affa943ebaaeaa3643064738a.png)

##### 1.3、使用快捷模板

**下载模板，修改 token 获取方式。**

![使用快捷模板](https://img-blog.csdnimg.cn/65249f7c537f4faaa747e5fbf1d57b90.png)

![使用快捷模板](https://img-blog.csdnimg.cn/dfe0cf011eea46e49acba8855106d3bf.png)

```javascript
var url = window.location.search;
var token = url.split("=")[1];
```

##### 1.4、与前端项目结合

**（1）创建直播播放页面 live.html。**

![与前端项目结合](https://img-blog.csdnimg.cn/0cfcd09d96194818928e5cb03c4b38b3.png)

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
    />
    <title>TalkFun Vod QuickStart - v2</title>
    <style type="text/css">
      * {
        margin: 0;
        padding: 0;
        list-style-type: none;
        font-family: "Microsoft YaHei", "STHeiti";
      }

      .flash-wran {
        display: none;
        position: absolute;
        top: 0;
        width: 100%;
        padding: 5px 0;
        text-align: center;
        background: #fff6a2;
        border: 1px solid #ffd913;
      }

      .flash-wran a {
        color: red;
      }

      .wrapper {
        display: flex;
        padding: 10px;
      }

      #cameraPlayer,
      #pptPlayer {
        height: auto;
        flex: 1;
        text-align: center;
        font-size: 12px;
        overflow: hidden;
      }

      #pptPlayer {
        height: 300px;
        width: 100%;
      }

      #modPptPlayer,
      #modCameraPlayer {
        margin-top: 10px;
        border: 1px solid #c7c7c7;
      }

      .chat-wrap {
        padding: 5px;
        margin: 10px;
        border: 2px solid #cccccc;
        background: #f1f1f1;
      }

      .mod-chat-list {
        margin: 20px 0;
        border: 1px solid #cccccc;
        min-height: 100px;
        font-size: 12px;
        background: #dedede;
        padding: 5px;
        max-height: 200px;
        overflow-y: scroll;
      }

      .mod-chat-list li {
        padding: 2px 0;
        margin-bottom: 5px;
        border-bottom: 1px dotted #cccccc;
      }

      input {
        display: inline-block;
        width: 200px;
        padding: 5px;
      }

      button {
        display: inline-block;
        padding: 5px;
        margin-left: 5px;
      }

      #toast {
        padding: 20px;
        position: fixed;
        z-index: 100;
        display: none;
        background: rgba(212, 28, 28, 0.8);
        left: 50%;
        top: 30%;
        border-radius: 50em;
        font-size: 14px;
        color: #ffffff;
        box-shadow: 0 0 6px 0px #bb2d2d;
      }

      #talkfun-video-wrap,
      #talkfun-camera-wrap {
        position: relative;
        background: #000;
      }
    </style>
    <!-- SDK 版本 -->
    <!-- 获取最新版本 ==> http://open.talk-fun.com/docs/js/changelog/live.html -->
    <script
      type="text/javascript"
      src="https://static-1.talk-fun.com/open/TalkFun_SDK_Pack/v7.0/TalkFunWebSDK-7.7.min.js"
    ></script>
  </head>

  <body>
    <!-- wrap -->
    <div class="wrapper">
      <!-- 桌面分享｜视频插播模式 -->
      <div id="videoPlayer">
        <p id="loadplayer"></p>
      </div>
    </div>

    <script>
      // [第一步] 如何获取 access_token => http://open.talk-fun.com/docs/getstartV2/access_token.html
      // [第二步] 根据Api文档方法 监听 / 调用方法 JS Api => http://open.talk-fun.com/docs/js/sdk.js.getstart.html
      var url = window.location.search;
      var token = url.split("=")[1];

      // 更多配置项 => https://open.talk-fun.com/docs/js/sdk.js.getstart.html?h=%E9%85%8D%E7%BD%AE%E9%A1%B9

      var HT = new MT.SDK.main(
        token,
        {
          config: {
            // Safari 浏览器建议设置为 HLS
            techOrder: "FLV",
          },
        },

        function (data) {
          console.warn("sdk 加载完成", data);
        }
      );

      // 连接状态
      HT.on("connect", function () {
        console.log("TalkFun 通信 => 连接成功...");
      });

      // 课件播放器
      HT.whiteboardPlayer("pptPlayer", "docPlayer", function (player) {
        console.log("课件播放器 => 初始化成功");
        document.querySelector("#loadplayer").innerHTML = "画板模块加载完成";
      });

      // 视频插播 | 桌面分享
      HT.videoPlayer("videoPlayer", "modVideoplayer", function (player) {
        console.log("视频播放器 => 初始化成功");
        document.querySelector("#loadplayer").innerHTML = "视频插播加载完成";
      });

      // 摄像头播放器
      HT.camera("cameraPlayer", "modCameraPlayer", function () {
        console.log("摄像头播放器 => 初始化成功");
        document.querySelector("#loadcam").innerHTML = "摄像头模块加载完成";
      });

      // 接收聊天
      var receivedChat = function (chat) {
        var tpl = chat.nickname + ": " + chat.msg;
        var chatItem = document.createElement("li");
        chatItem.innerHTML = tpl;
        chatItem.className = "chat-" + chat.xid;
        document.querySelector("#chat-list").appendChild(chatItem);
      };

      // 接收聊天信息
      HT.on("chat:send", function (chat) {
        receivedChat(chat);
      });

      // 发送聊天信息
      document.querySelector("#chatSubmit").addEventListener(
        "click",
        function () {
          var chatIpt = document.querySelector("#chatVal");
          var chatValue = chatIpt.value;

          HT.emit("chat:send", { msg: chatValue }, function (res) {
            // 发送成功
            if (Number(res.code) === 0) {
              receivedChat(res.data);
              chatIpt.value = "";
            }
            // 发送失败
            else {
              console.warn(res.msg);
            }
          });
        },

        false
      );

      // Flash 插件异常
      HT.on("flash:load:error", function (obj) {
        if (!obj.flash) {
          document.querySelector("#flashTip").style.display = "block";
        }
      });

      // 课程错误信息
      HT.on("live:course:access:error", function (res) {
        console.error("错误信息 ==>", res);
      });

      // 课程错误信息
      HT.on("system:room:error", function (res) {
        var toast = document.querySelector("#toast");

        if (typeof res === "string") {
          toast.innerHTML = res.msg;
        } else if (res.msg) {
          toast.innerHTML = res.msg;
        }

        toast.style.display = "block";
        var _left = toast.clientWidth / 2;
        toast.style.marginLeft = -_left + "px";
      });
    </script>
  </body>
</html>
```

观众在直播详情页面点击观看，获取通过接口获取 access_token，然后带上 access_token 参数跳转到直播观看页面即可，关键代码：

**liveInfo.vue**

```html
<template>
  <div>
    <head>
      <!-- 设置 referrer 为 no-referrer，用于绕过防盗链限制，从而正常显示图片 -->
      <meta name="referrer" content="no-referrer" />
    </head>

    <van-image
      width="100%"
      height="200"
      src="https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png"
    />

    <h1 class="van-ellipsis course_title">{{ liveCourse.courseName }}</h1>

    <div class="course_teacher_price_box">
      <div class="course_teacher_price">
        <div class="course_price">直播时间：</div>
        <div class="course_price_number">
          {{ liveCourse.param.startTimeString }}至{{
          liveCourse.param.endTimeString }}
        </div>
      </div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_teacher_box">
        <div class="course_teacher">教师： {{ teacher.name }}</div>
        <van-image :src="teacher.avatar" round width="50px" height="50px" />
      </div>
    </div>

    <div class="course_contents">
      <div class="course_title_font">课程详情</div>
      <van-divider :style="{ margin: '5px 0 ' }" />
      <div class="course_content" v-html="description"></div>
    </div>

    <van-goods-action>
      <van-goods-action-button type="danger" text="直播中" @click="play" />
    </van-goods-action>

    <van-loading vertical="true" v-show="loading">加载中...</van-loading>
  </div>
</template>

<script>
  import liveAPI from "@/api/live";
  import shareAPI from "@/api/share";
  import wxShare from "@/utils/wxShare";

  export default {
    data() {
      return {
        loading: false,
        liveCourseId: null,
        liveCourse: { param: {} },
        description: "",
        teacher: {},
        liveStatus: 0,
        activeNames: ["1"],
      };
    },

    created() {
      this.liveCourseId = this.$route.params.liveCourseId;
      this.fetchData();
    },

    methods: {
      fetchData() {
        this.loading = true;
        liveAPI.getInfo(this.liveCourseId).then((response) => {
          console.log(response.data);
          this.liveCourse = response.data.liveCourse;
          this.description = response.data.description;
          this.teacher = response.data.teacher;
          this.liveStatus = response.data.liveStatus;
          this.loading = false;

          // 分享注册
          this.wxRegister();
        });
      },

      play() {
        liveAPI.getPlayAuth(this.liveCourseId).then((response) => {
          console.log(response.data);
          // this.$router.push({ path: '/live/online?token='+response.data.access_token })
          window.location = "./live.html?token=" + response.data.access_token;
          this.finished = true;
        });
      },

      wxRegister() {
        // 说明：后台加密 url 必须与当前页面 url 一致
        let url = window.location.href.replace("#", "smartplanet");
        shareAPI.getSignature(url).then((response) => {
          console.log(response.data);

          // 记录分享用户
          let link = "";

          if (window.location.href.indexOf("?") != -1) {
            link =
              window.location.href + "&recommend=" + response.data.userEedId;
          } else {
            link =
              window.location.href + "?recommend=" + response.data.userEedId;
          }

          let option = {
            title: this.liveCourse.courseName,
            desc: this.description,
            link: link,
            imgUrl: this.liveCourse.cover,
          };

          wxShare.wxRegister(response.data, option);
        });
      },
    },
  };
</script>

<style lang="scss" scoped>
  .gap {
    height: 10px;
  }
  ::v-deep.van-image {
    display: block;
  }
  .course_count {
    background-color: #82848a;
    color: white;
    padding: 5px;
    text-align: center;
    border-right: 1px solid #939393;
    h1 {
      font-size: 14px;
      margin: 0;
    }
    p {
      margin: 0;
      font-size: 16px;
    }
  }

  .course_title {
    font-size: 20px;
    margin: 10px;
  }

  .course_teacher_price_box {
    margin: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    .course_teacher_price {
      display: flex;
      font-size: 14px;
      align-items: center;
      .course_price_number {
        color: red;
        font-size: 18px;
        font-weight: bold;
      }

      .course_teacher {
        margin-left: 20px;
      }
    }
    .course_teacher_box {
      display: flex;
      justify-content: center;
      align-items: center;

      .course_teacher {
        margin-right: 20px;
      }
    }
  }

  .course_contents {
    margin: 10px;
    .course_title_font {
      color: #68cb9b;
      font-weight: bold;
    }
    .course_content {
      margin-bottom: 20px;
    }
  }

  .course_chapter_list {
    display: flex;
    justify-content: space-between;
    align-items: center;
    h2 {
      font-size: 14px;
    }
    p {
      margin: 0;
    }
  }
</style>
```

http://localhost:8080/live.html 为直播观看访问方式。

##### 1.5、补充接口

**（1）LiveCourseApiController 类。**

```java
package com.myxh.smart.planet.live.api;

import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/28
 */
@Tag(name = "直播课程 API", description = "直播课程 API 接口")
@RestController
@RequestMapping("api/live/live/course")
public class LiveCourseApiController
{
    @Resource
    private LiveCourseService liveCourseService;

    /**
     * 根据直播课程 id 查询直播课程信息
     *
     * @param liveCourseId 直播课程 id
     * @return Result 全局统一返回结果
     */
    @Operation(summary = "根据直播课程 id 查询直播课程信息", description = "根据直播课程 id 查询直播课程信息")
    @GetMapping("get/info/{liveCourseId}")
    public Result<Map<String, Object>> getInfo(@Parameter(name = "liveCourseId", description = "直播课程 ID", required = true)
                                               @PathVariable("liveCourseId") Long liveCourseId)
    {
        Map<String, Object> liveCourseInfo = liveCourseService.getInfoById(liveCourseId);

        return Result.ok(liveCourseInfo);
    }
}
```

**（2）LiveCourseServiceImpl 实现。**

```java
package com.myxh.smart.planet.live.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myxh.smart.planet.client.course.CourseFeignClient;
import com.myxh.smart.planet.live.mapper.LiveCourseMapper;
import com.myxh.smart.planet.live.service.LiveCourseDescriptionService;
import com.myxh.smart.planet.live.service.LiveCourseService;
import com.myxh.smart.planet.model.live.LiveCourse;
import com.myxh.smart.planet.model.live.LiveCourseDescription;
import com.myxh.smart.planet.model.vod.Teacher;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/10/26
 *
 * <p>
 * 直播课程 服务实现类
 * </p>
 */
@Service
public class LiveCourseServiceImpl extends ServiceImpl<LiveCourseMapper, LiveCourse> implements LiveCourseService
{
    @Autowired
    private CourseFeignClient teacherFeignClient;

    @Autowired
    private LiveCourseDescriptionService liveCourseDescriptionService;

    /**
     * 根据直播课程 id 查询直播课程信息
     *
     * @param liveCourseId 直播课程 id
     * @return liveCourseInfo 直播课程信息
     */
    @Override
    public Map<String, Object> getInfoById(Long liveCourseId)
    {
        LiveCourse liveCourse = this.getById(liveCourseId);
        liveCourse.getParam().put("startTimeString", new DateTime(liveCourse.getStartTime()).toString("yyyy年MM月dd HH:mm"));
        liveCourse.getParam().put("endTimeString", new DateTime(liveCourse.getEndTime()).toString("yyyy年MM月dd HH:mm"));
        Teacher teacher = teacherFeignClient.getTeacherLive(liveCourse.getTeacherId());
        LiveCourseDescription liveCourseDescription = liveCourseDescriptionService.getLiveCourseDescriptionByLiveCourseId(liveCourseId);
        Map<String, Object> liveCourseInfo = new HashMap<>();
        liveCourseInfo.put("liveCourse", liveCourse);
        liveCourseInfo.put("liveStatus", this.getLiveStatus(liveCourse));
        liveCourseInfo.put("teacher", teacher);

        if (liveCourseDescription != null)
        {
            liveCourseInfo.put("description", liveCourseDescription.getDescription());
        }
        else
        {
            liveCourseInfo.put("description", "");
        }

        return liveCourseInfo;
    }
}
```

### 三、微信分享

#### 1、实现目标

1、点播课程详情页面分享。

#### 2、微信分享实现方式

参考文档：https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/JS-SDK.html

##### 2.1、绑定域名

先登录微信公众平台进入“设置与开发”，“公众号设置”的“功能设置”里填写“JS 接口安全域名”。

说明：本地测试设置内网穿透地址。

![绑定域名](https://img-blog.csdnimg.cn/af7a77addd0f4703a99ef0f2669d0066.png)

##### 2.2、公众号测试号配置

![公众号测试号配置](https://img-blog.csdnimg.cn/33f476d04236471796db5004e3078261.png)

##### 2.3、引入 JS 文件

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,,chrome=1" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no"
    />
    <title>智慧星球</title>
    <link rel="icon" href="<%= BASE_URL %>favicon.ico" />

    <script
      src="http://res2.wx.qq.com/open/js/jweixin-1.6.0.js"
      type="text/javascript"
    ></script>

    <!-- 引入播放器 css 文件 -->
    <link
      href="https://web.sdk.qcloud.com/player/tcplayer/release/v4.7.2/tcplayer.min.css"
      rel="stylesheet"
    />

    <!-- 如果需要在 Chrome 和 Firefox 等现代浏览器中通过 H5 播放 HLS 协议的视频，需要在 tcplayer.vx.x.x.min.js 之前引入 hls.min.x.xx.xm.js。 -->
    <script src="https://web.sdk.qcloud.com/player/tcplayer/release/v4.7.2/libs/hls.min.1.1.6.js"></script>

    <!-- 如果需要在 Chrome 和 Firefox 等现代浏览器中通过 H5 播放 FLV 格式的视频，需要在 tcplayer.vx.x.x.min.js 之前引入 flv.min.x.x.x.js。 -->
    <script src="https://web.sdk.qcloud.com/player/tcplayer/release/v4.7.2/libs/flv.min.1.6.3.js"></script>

    <!-- 如果需要在 Chrome 和 Firefox 等现代浏览器中通过 H5 播放 DASH 视频，需要在 tcplayer.vx.x.x.min.js 之前引入 dash.min.x.x.x.js。 -->
    <script src="https://web.sdk.qcloud.com/player/tcplayer/release/v4.7.2/libs/dash.all.min.4.5.2.js"></script>

    <!-- 引入播放器 js 文件 -->
    <script src="https://web.sdk.qcloud.com/player/tcplayer/release/v4.7.2/tcplayer.v4.7.2.min.js"></script>
  </head>

  <body>
    <script
      type="text/javascript"
      src="https://static-1.talk-fun.com/open/TalkFun_SDK_Pack/v7.0/TalkFunWebSDK-7.7.min.js"
    ></script>

    <noscript>
      <strong
        >We're sorry but <%= htmlWebpackPlugin.options.title %> doesn't work
        properly without JavaScript enabled. Please enable it to
        continue.</strong
      >
    </noscript>
    <div id="app"></div>
    <!-- built files will be auto injected -->
  </body>
</html>
```

**引入前端项目/public/index.html 文件。**

![引入 JS 文件](https://img-blog.csdnimg.cn/891242c3ffdc42bcbc9ba48b98d0531b.png)

##### 2.4、封装分享 js

参考官方文档封装接口。

需要分享的页面有直播详情页、点播课程详情页等，因此把分享代码封装后，在对应的页面直接引入与调用即可。

新建 src/util/wxShare.js 文件。

```javascript
/**
 * 微信 js-sdk
 * 参考文档：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421141115
 */
const wxShare = {
  /**
   * [wxRegister 微信 Api 初始化]
   * @param  {Function} callback [ready 回调函数]
   */
  wxRegister(data, option) {
    // data 是微信配置信息，option 是分享的配置内容

    wx.config({
      // 开启调试模式
      debug: false,
      // 必填，公众号的唯一标识
      appId: data.appId,
      // 必填，生成签名的时间戳
      timestamp: data.timestamp,
      // 必填，生成签名的随机串
      nonceStr: data.nonceStr,
      // 必填，签名，见附录 1
      signature: data.signature,
      // 必填，需要使用的 JS 接口列表，所有 JS 接口列表见附录 2
      jsApiList: ["onMenuShareAppMessage"],
    });

    wx.ready(function () {
      wx.onMenuShareAppMessage({
        // 分享标题
        title: option.title,
        // 分享描述
        desc: option.desc,
        // 分享链接
        link: option.link,
        // 分享图标
        imgUrl: option.imgUrl,
        success() {
          // 用户成功分享后执行的回调函数
          //  option.success()
          console.log("ok");
        },
        cancel() {
          // 用户取消分享后执行的回调函数
          // option.error()
          console.log("cancel");
        },
      });
    });

    wx.error(function (res) {
      // config 信息验证失败会执行 error 函数，如签名过期导致验证失败，具体错误信息可以打开 config 的 debug 模式查看，也可以在返回的 res 参数中查看，对于 SPA 可以在这里更新签名。
      alert("error:" + JSON.stringify(res));
    });
  },
};

export default wxShare;
```

##### 2.5、服务器端接口

**新增 ShareController 类。**

说明：微信分享要对当前 url 加密处理，由于 url 路由都是带“#”符号，服务器端接收不到，因此通过“smartplanet”单词代替了“#”。

```java
package com.myxh.smart.planet.wechat.controller;

import com.myxh.smart.planet.order.AuthContextHolder;
import com.myxh.smart.planet.order.Base64Util;
import com.myxh.smart.planet.result.Result;
import com.myxh.smart.planet.vo.wechat.WeChatJsapiSignatureVo;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/10/28
 */
@RestController
@RequestMapping("/api/wechat/share")
@Slf4j
public class ShareController
{
    @Autowired
    private WxMpService wxMpService;

    /**
     *  获取签名
     *
     * @param url url
     * @return Result 全局统一返回结果
     * @throws WxErrorException 微信错误异常
     */
    @GetMapping("/get/signature")
    public Result<WeChatJsapiSignatureVo> getSignature(@RequestParam("url") String url) throws WxErrorException
    {
        String currentUrl = url.replace("smartplanet", "#");
        WxJsapiSignature jsapiSignature = wxMpService.createJsapiSignature(currentUrl);
        WeChatJsapiSignatureVo wxJsapiSignatureVo = new WeChatJsapiSignatureVo();
        BeanUtils.copyProperties(jsapiSignature, wxJsapiSignatureVo);
        wxJsapiSignatureVo.setUserEedId(Base64Util.base64Encode(AuthContextHolder.getUserId() + ""));

        return Result.ok(wxJsapiSignatureVo);
    }
}
```

##### 2.6、点播课程详情分享

**页面：courseInfo.vue。**

（1）引入分享。

```javascript
import shareAPI from "@/api/share";
import wxShare from "@/utils/wxShare";
```

（2）代码实现。

关键代码。

```html
<template>
  <div>
    <van-image width="100%" height="200" :src="courseVo.cover" />
    <van-row>
      <van-col span="8">
        <div class="course_count">
          <h1>购买数</h1>
          <p>{{ courseVo.buyCount }}</p>
        </div>
      </van-col>
      <van-col span="8">
        <div class="course_count">
          <h1>课时数</h1>
          <p>{{ courseVo.lessonNum }}</p>
        </div>
      </van-col>
      <van-col span="8">
        <div class="course_count">
          <h1>浏览数</h1>
          <p>{{ courseVo.viewCount }}</p>
        </div>
      </van-col>
    </van-row>

    <h1 class="van-ellipsis course_title">{{ courseVo.title }}</h1>

    <div class="course_teacher_price_box">
      <div class="course_teacher_price">
        <div class="course_price">价格：</div>
        <div class="course_price_number">￥{{ courseVo.price }}</div>
      </div>
      <div>
        <van-button
          @click="see()"
          v-if="isBuy || courseVo.price == '0.00'"
          plain
          type="warning"
          size="mini"
          >立即观看</van-button
        >
        <van-button @click="buy" v-else plain type="warning" size="mini"
          >立即购买</van-button
        >
      </div>
    </div>
    <div class="course_teacher_price_box">
      <div class="course_teacher_box">
        <div class="course_teacher">教师： {{ teacher.name }}</div>
        <van-image :src="teacher.avatar" round width="50px" height="50px" />
      </div>
    </div>

    <div class="course_contents">
      <div class="course_title_font">课程详情</div>
      <van-divider :style="{ margin: '5px 0 ' }" />
      <div class="course_content" v-html="description"></div>

      <div class="course_title_font">课程大纲</div>
      <div class="gap"></div>
      <van-collapse v-model="activeNames">
        <van-collapse-item
          :title="item.title"
          :name="item.id"
          v-for="item in chapterVoList"
          :key="item.id"
        >
          <ul
            class="course_chapter_list"
            v-for="child in item.children"
            :key="child.id"
          >
            <h2>{{ child.title }}</h2>
            <p v-if="child.isFree == 1">
              <van-button @click="play(child)" type="warning" size="mini" plain
                >免费观看</van-button
              >
            </p>
            <p v-else>
              <van-button @click="play(child)" type="warning" size="mini" plain
                >观看</van-button
              >
            </p>
          </ul>
        </van-collapse-item>
      </van-collapse>
    </div>
    <van-loading vertical="true" v-show="loading">加载中...</van-loading>
  </div>
</template>

<script>
  import courseAPI from "@/api/course";
  import shareAPI from "@/api/share";
  import wxShare from "@/utils/wxShare";

  export default {
    data() {
      return {
        loading: false,
        courseId: null,
        courseVo: {},
        description: "",
        teacher: {},
        chapterVoList: [],
        isBuy: false,
        activeNames: ["1"],
      };
    },

    created() {
      this.courseId = this.$route.params.courseId;
      this.fetchData();
    },

    methods: {
      fetchData() {
        this.loading = true;
        courseAPI.getInfo(this.courseId).then((response) => {
          console.log(response.data);
          this.courseVo = response.data.courseVo;
          this.description = response.data.description;
          this.isBuy = response.data.isBuy;
          this.chapterVoList = response.data.chapterVoList;
          this.teacher = response.data.teacher;
          this.loading = false;

          // 分享注册
          this.wxRegister();
        });
      },

      buy() {
        this.$router.push({ path: "/trade/" + this.courseId });
      },

      play(video) {
        let videoId = video.id;
        let isFree = video.isFree;

        if (isFree === 1 || this.isBuy || this.courseVo.price == "0.00") {
          this.$router.push({ path: "/play/" + this.courseId + "/" + videoId });
        } else {
          // this.$router.push({ path: "/play/" + this.courseId + "/" + videoId });

          if (window.confirm("购买了才可以观看, 是否继续？")) {
            this.buy();
          }
        }
      },

      see() {
        this.$router.push({ path: "/play/" + this.courseId + "/0" });
      },

      wxRegister() {
        // 说明：后台加密 url 必须与当前页面 url 一致
        let url = window.location.href.replace("#", "smartplanet");
        shareAPI.getSignature(url).then((response) => {
          console.log(response.data);
          // 记录分享用户
          let link = "";

          if (window.location.href.indexOf("?") != -1) {
            link =
              window.location.href + "&recommend=" + response.data.userEedId;
          } else {
            link =
              window.location.href + "?recommend=" + response.data.userEedId;
          }

          let option = {
            title: this.courseVo.title,
            desc: this.description,
            link: link,
            imgUrl: this.courseVo.cover,
          };

          wxShare.wxRegister(response.data, option);
        });
      },
    },
  };
</script>

<style lang="scss" scoped>
  .gap {
    height: 10px;
  }
  ::v-deep.van-image {
    display: block;
  }
  .course_count {
    background-color: #82848a;
    color: white;
    padding: 5px;
    text-align: center;
    border-right: 1px solid #939393;
    h1 {
      font-size: 14px;
      margin: 0;
    }
    p {
      margin: 0;
      font-size: 16px;
    }
  }

  .course_title {
    font-size: 20px;
    margin: 10px;
  }

  .course_teacher_price_box {
    margin: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    .course_teacher_price {
      display: flex;
      font-size: 14px;
      align-items: center;
      .course_price_number {
        color: red;
        font-size: 18px;
        font-weight: bold;
      }

      .course_teacher {
        margin-left: 20px;
      }
    }
    .course_teacher_box {
      display: flex;
      justify-content: center;
      align-items: center;

      .course_teacher {
        margin-right: 20px;
      }
    }
  }

  .course_contents {
    margin: 10px;
    .course_title_font {
      color: #68cb9b;
      font-weight: bold;
    }
    .course_content {
      margin-bottom: 20px;
    }
  }

  .course_chapter_list {
    display: flex;
    justify-content: space-between;
    align-items: center;
    h2 {
      font-size: 14px;
    }
    p {
      margin: 0;
    }
  }
</style>
```

##### 2.7、测试

（1）使用手机测试，其他端测试可能会出现错误问题。

## Day 16-腾讯云部署

### 一、项目部署方案

#### 1、原始部署方式

![原始部署方式](https://img-blog.csdnimg.cn/bdc20db29f6c4259a3877b2f7d812ad0.png)

#### 2、整合 Jenkins

> **完整 DevOps 示例如下：**

![整合 Jenkins](https://img-blog.csdnimg.cn/8e4dcc54b0b04ecba8ce1b1a77c15d82.png)

#### 3、整合 CODING

> **整合 CODING 实现 DevOps：**

https://console.cloud.tencent.com/coding/container-devops

![整合 CODING](https://img-blog.csdnimg.cn/ec19c1f5d85c434cb44602cda5327176.png)

### 二、腾讯云 CODING DevOps 概述

**腾讯云使用文档：**

https://help.coding.net/docs/start/new.html

#### 1、产品简介

DevOps 是 Development 和 Operations 的组合词，代表着重视「软件开发人员(Dev)」和「IT 运维技术人员(Ops)」之间沟通合作的文化；旨在透过自动化「软件交付」和「架构变更」的流程，使得构建、 测试、发布软件的过程能够更加地快捷、频繁和可靠。Gartner 咨询公司认为 DevOps 代表了 IT 文化的变化趋势。

![产品简介](https://img-blog.csdnimg.cn/b2efc57537614122936ce0a5f3f218a0.png)

##### 1.1、CODING DevOps 是什么

CODING DevOps 是面向软件研发团队的一站式研发协作管理平台，提供从需求到设计、开发、构建、测试、发布到部署的全流程协同及研发工具支撑。CODING 解决方案可助力企业实现代码的统一安全管控，并快速实践敏捷开发与 DevOps，提升软件交付质量与速度，降低企业研发成本，实现研发效能升级。

![CODING DevOps 是什么](https://img-blog.csdnimg.cn/802c908df905458a82c10b34b6820303.png)

##### 1.2、CODING DevOps 优势

- **一站式协作平台及研发工具链，提升研发效能。**

  CODING 与云端优势相结合，依托业界敏捷项目管理与 DevOps 体系方法融入到产品中，打通研发过程中的工具链孤岛及协作壁垒，覆盖敏捷开发全生命周期，帮助团队实现需求、迭代、开发、测试、持续集成、持续部署全方位研发管理，提升软件研发效能。

- **支持双态研发体系建设，满足多样化业务需求。**

  CODING 适用于不同规模的开发团队以及不同类型的软件开发模式（如瀑布模型、敏捷模型），满足多业务场景的协作需求。

- **项目工作流和度量数据可视化，项目管理更轻松。**

  CODING 提供可视化看板，支持对代码、项目进度、人员工作量等不同维度输出详尽的数据报告，为团队管理者提供决策依据，调整项目计划和合理安排研发人力。

- **丰富的扩展能力，无缝集成第三方平台。**

  CODING 支持无缝集成 GitHub、GitLab 等第三方代码库及各类常见的运维系统和云原生环境，让用户实现跨平台的无缝迁移。

##### 1.3、CODING DevOps 功能特性

CODING DevOps 平台主要提供以下功能特性：

**团队级功能：**

- 团队管理：团队管理员通过可视化的[仪表盘](https://help.coding.net/docs/dashboard/use.html)可以快速掌握团队成员工作数据、监控项目运行状态；通过[团队目标](https://help.coding.net/docs/okr/okr.html)助力团队成员聚焦组织目标，全方位协同执行，凝聚团队战斗力，让战略坚实落地；利用[工作负载](https://help.coding.net/docs/workload/intro.html)统一查看对比成员的工作量和工作安排；利用[研发度量](https://help.coding.net/docs/metric/intro.html)统计并分析团队成员在一段时间内的事项分布、事项概览、代码分布等数据，度量团队成员在周期内完成工作量与工作动态。

**项目级功能：**

- [项目协同](https://help.coding.net/docs/collaboration/intro.html)：软件开发团队可自由选择适合的研发管理模式，支持多项目管理、敏捷迭代管理、需求管理、缺陷跟踪、多维度报表数据等功能。

- [代码仓库](https://help.coding.net/docs/collaboration/intro.html)：提供企业级的 Git/SVN 代码管理服务，支持精细化权限管控、多分支并行开发、多版本管理等功能。

- [代码扫描](https://help.coding.net/docs/code-scan/intro.html)：提供针对不同编程语言的代码扫描方案，支持对扫描规则、度量规则等进行自定义配置。根据代码扫描测试结果，开发人员可及时发现代码缺陷并作出修正，有效管控代码质量。

- [持续集成](https://help.coding.net/docs/ci/intro.html)：提供基于云端的自动化代码构建、测试、分析和部署工作流服务，支持通过模板快速创建构建任务并进行可视化编排，极大提高软件开发团队的构建效率。

- [持续部署](https://help.coding.net/docs/cd/overview.html)：提供全自动化软件部署，可持续、可控地把软件制品在线发布到服务集群中，支持蓝绿分发布、灰度发布（金丝雀发布）等多种发布策略。

- [制品管理](https://help.coding.net/docs/artifacts/intro.html)：提供云端构建产物管理服务，支持云端构建和本地构建推送，可快速索引存档构建物、进行版本控制。

- [测试管理](https://help.coding.net/docs/test-management/start.html)：提供面向敏捷团队的测试一站式云端测试平台，支持可视化的测试规划和多维度的测试报告，满足敏捷团队对测试过程的多样化需求。

- [文档管理](https://help.coding.net/docs/document/wiki.html)：提供灵活易用的文档管理服务，可用于记录整个项目的来龙去脉，展示当前项目状态，也可让项目成员更好地进行文档书写及协作。

![CODING DevOps 功能特性](https://img-blog.csdnimg.cn/b5f694ff68304d80957448f6d086eade.png)

#### 2、使用流程概述

以下流程图展示了 CODING DevOps 软件开发平台的基本操作流程，您可以按照实际需求有选择性阅读。

![使用流程概述](https://img-blog.csdnimg.cn/e535253b80344452bff187c6aaa4e6ee.png)

![使用流程概述](https://img-blog.csdnimg.cn/70e752cee60f4184a07a489661c4b296.png)

##### 2.1、创建或加入团队

如要开始使用 CODING DevOps，您需要先注册创建或接受邀请后加入一个团队。

![创建或加入团队](https://img-blog.csdnimg.cn/031b2f62590148e6839ab66edf2545b7.png)

##### 2.2、新建项目

加入团队之后，您可以在团队内创建项目或受他人邀请加入别的项目。“项目”是核心单元，几乎大部分工作都需要在项目中展开。

![新建项目](https://img-blog.csdnimg.cn/0d27d0efa82b4d119e51d9db16637b59.png)

##### 2.3、开始项目协同

项目创建之后，项目经理、开发、测试等不同的项目角色可通过项目协同实现简单高效的项目协作，包含迭代管理、需求管理、任务管理等。

![开始项目协同](https://img-blog.csdnimg.cn/23ccdb4757cb4ba8a614a017567b0590.png)

##### 2.4、使用代码仓库

完成项目规划之后，可利用代码仓库管理项目代码。该功能提供企业级的基于 Git 的云端代码管理服务，支持精细化权限管控、多分支并行开发、多版本管理等功能。

![使用代码仓库](https://img-blog.csdnimg.cn/2bae6b7a62a34a87aeb95dda560fe151.png)

##### 2.5、启动代码扫描

对于使用 CODING 代码仓库管理的代码，开发者可使用代码扫描功能进行代码检查，以便及时发现代码缺陷并作出修正，有效管控代码质量。

![启动代码扫描](https://img-blog.csdnimg.cn/345f75c10bc044189b7c0a4109f22e6a.png)

##### 2.6、编译构建

项目代码开发完成之后，可通过持续集成功能快速创建构建任务，将项目代码编译打包成软件包。

![编译构建](https://img-blog.csdnimg.cn/a0b5f00babc44e84b4d850b837b2b4a6.png)

##### 2.7、管理制品

在您将项目代码构建好之后，可以使用制品管理功能管理构建产物。CODING 支持多种制品库类型，包括 Docker、Maven、Helm 和 npm。

![管理制品](https://img-blog.csdnimg.cn/05af145f761a4235b800c11e1ca510c1.png)

##### 2.8、实施持续部署

当您的项目代码已经完成构建，可使用持续部署把控构建之后的项目发布与部署到生产环境中去。

![实施持续部署](https://img-blog.csdnimg.cn/05c3e5e875ca4d448d7618b6f29ce3a0.png)

##### 2.9、管理测试用例

当您在 CODING 平台创建项目之后，您可以使用面向敏捷团队的测试管理功能来管理项目内的测试活动，确保产品的高质量交付。

![管理测试用例](https://img-blog.csdnimg.cn/b8adafe4c6d446179fcbe85433b0aa81.png)

##### 2.10、管理项目文档

在项目进行中，必然会产生大量的信息，并且需要对这些信息进行记录、传递、分享。文档管理功能提供灵活易用的文档管理服务，可用于记录整个项目的来龙去脉。

### 三、开通 CODING DevOps

#### 1、搜索 CODING DevOps

**（1）腾讯云搜索 CODING-DevOps。**

![腾讯云搜索 CODING-DevOps](https://img-blog.csdnimg.cn/a33b777373dd47dba734b24e61c5557d.png)

**（2）进入界面。**

![进入界面](https://img-blog.csdnimg.cn/d6a26ec9d6e74cedaf1d96d3b025b96f.png)

#### 2、开通账号

**（1）第一次进入没有账号，去开通。**

![第一次进入没有账号，去开通](https://img-blog.csdnimg.cn/fe6a640f84bb42b0a7d6811d0d595b57.png)

**（2）产品授权。**

![产品授权](https://img-blog.csdnimg.cn/fbc2d56f981c41808eaf27de8d14dc5f.png)

![产品授权](https://img-blog.csdnimg.cn/950ecaec050d4fc6b819b5506e4ae066.png)

**（3）输入信息，邮箱验证。**

![输入信息，邮箱验证](https://img-blog.csdnimg.cn/dc86bf5ae7b04391978c3945434dc98f.png)

#### 3、创建团队

**（1）输入团队名称提交。**

![输入团队名称提交](https://img-blog.csdnimg.cn/b43e9a7b8f0e4fe3a06515855c95091f.png)

**（2）开通成功。**

![开通成功](https://img-blog.csdnimg.cn/cfe5cbb7bd04481c849e0f7f69a6d699.png)

**（3）点击立即使用，进入。**

![点击立即使用，进入](https://img-blog.csdnimg.cn/fb807359356642589caaf28d0af383b3.png)

**（4）进入工作台。**

![进入工作台](https://img-blog.csdnimg.cn/398350c2f20e45a6a14a526e36bfc95c.png)

### 四、使用 CODING DevOps

#### 1、创建项目

在 CODING DevOps 平台建立团队之后，团队内成员可按需创建项目。只有项目创建之后，项目成员才能按需使用**项目协同**、**代码仓库**、**持续集成**、**持续部署**等功能。

##### 1.1、点击创建项目

![点击创建项目](https://img-blog.csdnimg.cn/fecae78300274cec917f27e3b884d649.png)

##### 1.2、选择项目模板

![选择项目模板](https://img-blog.csdnimg.cn/676686de37f9495e8cc7ce6d8b1c2bc2.png)

##### 1.3、填写项目基本信息

![填写项目基本信息](https://img-blog.csdnimg.cn/f0131b7ad790445996007fbe764379ee.png)

##### 1.4、完成创建

![完成创建](https://img-blog.csdnimg.cn/7fe87a9f60884caf9a93637f9e0455b7.png)

#### 2、项目协同

##### 2.1、项目协同初始化

**（1）前往初始化。**

![前往初始化](https://img-blog.csdnimg.cn/f2cda45cb2134e2396710bfc15c944e9.png)

**（2）配置并开启项目协同。**

**选择经典项目管理。**

![配置并开启项目协同](https://img-blog.csdnimg.cn/30ad9f0d8dc04d7b87ac0df95eba7a32.png)

![配置并开启项目协同](https://img-blog.csdnimg.cn/955f15c8ca8742568ae71b380a234a85.png)

##### 2.2、项目协同具体实现

![项目协同具体实现](https://img-blog.csdnimg.cn/b6c08287cb4e4a8588509557cf3f42e7.png)

**（1）点击右上角创建迭代。**

![点击右上角创建迭代](https://img-blog.csdnimg.cn/16fbdab58194405295e643d4781ad56e.png)

**（2）填写迭代信息。**

![填写迭代信息](https://img-blog.csdnimg.cn/5d8f8c8d1a6a462d84081dcdd69ec0f1.png)

**（3）点击创建并规划，创建需求。**

![点击创建并规划，创建需求](https://img-blog.csdnimg.cn/1662023305ab4c15be1e0c433f294069.png)

**（4）点击查看详情。**

![点击查看详情](https://img-blog.csdnimg.cn/81c905dfb1164109ba7fe33be06fdc8c.png)

**（5）设置迭代详情信息。**

![设置迭代详情信息](https://img-blog.csdnimg.cn/be5ee3a19ba94023be096c4335a3169a.png)

**（6）效果。**

![效果](https://img-blog.csdnimg.cn/694e19c757224256b90161da2bb3428d.png)

#### 3、代码仓库

##### 3.1、添加仓库

![添加仓库](https://img-blog.csdnimg.cn/eaeb28a5c5be43d49fdbdc086bfc760c.png)

**（1）填写仓库信息。**

![填写仓库信息](https://img-blog.csdnimg.cn/a8b245b9195d4ab5b02ea86621ac3c28.png)

---

**（2）克隆仓库。**

**点击克隆。**

![克隆仓库](https://img-blog.csdnimg.cn/a3b5ec087b104a059adc3d11a9df2fa2.png)

##### 3.2、克隆代码仓库到本地

**（1）在 Git 客户端中输入克隆命令。**

```shell
git clone <您克隆的代码仓库地址>
```

首次拉取后会提示填写凭据，此处填写在注册 CODING 时所使用的邮箱与密码即可。

![在 Git 客户端中输入克隆命令](https://img-blog.csdnimg.cn/b6c992ddbde24d6990f8be84b4960f6a.png)

命令操作提示成功之后，你可以在本地代码仓库中进行代码修改。

![在 Git 客户端中输入克隆命令](https://img-blog.csdnimg.cn/acacef7aedaf4e228eeedffc50636b2d.png)

##### 3.3、推送本地代码至 CODING 仓库

**（1）在 Git 客户端，运行以下三条命令将代码推送到 CODING 平台上的代码仓库。**

```shell
git add .
git commit -m "<您对本次提交备注的信息>"
git push git仓库地址
```

**（2）创建提交文件。**

![创建提交文件](https://img-blog.csdnimg.cn/0efa2825bd7d40668e9124b467668b55.png)

**（3）进入 cmd 窗口执行。**

![进入 cmd 窗口执行](https://img-blog.csdnimg.cn/121397d4388f43f0afde82f65f9e39ab.png)

**（4）查看所有的提交记录。**

![查看所有的提交记录](https://img-blog.csdnimg.cn/0c1cd51d6ea34e3db6a5dcedcc839b41.png)

##### 3.4、推送项目到代码仓库

**（1）复制两个文件到项目目录。**

![复制两个文件到项目目录](https://img-blog.csdnimg.cn/a64701bc71564dce91a21395f265ca20.png)

![复制两个文件到项目目录](https://img-blog.csdnimg.cn/e2051118893c4a6faa658c86926cdab4.png)

**（2）项目路径 cmd 窗口执行。**

![项目路径 cmd 窗口执行](https://img-blog.csdnimg.cn/a01da19f75174d7ea86464ca3adc4460.png)

![项目路径 cmd 窗口执行](https://img-blog.csdnimg.cn/e560fb3b7f7641428355bc8e4fc424ae.png)

![项目路径 cmd 窗口执行](https://img-blog.csdnimg.cn/086bac708213448e95f4699476638d78.png)

**（3）查看效果。**

![查看效果](https://img-blog.csdnimg.cn/1dca7eb6efb24c93b6dd01300f9aa398.png)

#### 4、持续集成

##### 4.1、创建构建计划

![创建构建计划](https://img-blog.csdnimg.cn/b93a7907f2f045c7826d968bc2628553.png)

##### 4.2、选择类型

![选择类型](https://img-blog.csdnimg.cn/d8fb08f638c14fa2811cb26716831977.png)

##### 4.3、设置构建信息

![设置构建信息](https://img-blog.csdnimg.cn/f6aff5f5db3a409cab54fee3e425024f.png)

![设置构建信息](https://img-blog.csdnimg.cn/e7652fce012844738ddcebad42a31575.png)

![设置构建信息](https://img-blog.csdnimg.cn/c00b5cf317d14cb5a943b88a90f9ce3e.png)

![设置构建信息](https://img-blog.csdnimg.cn/0295bbb12c824183b7116a4164c76748.png)

##### 4.4、修改流程配置

**根据具体需要，自定义执行流程。**

![修改流程配置](https://img-blog.csdnimg.cn/a3133098d8f64272957a0ab3cf22d546.png)

##### 4.5、立即构建

![立即构建](https://img-blog.csdnimg.cn/b41a98feac0247b7ab0acfd6fc9db350.png)

##### 4.6、构建完成

![构建完成](https://img-blog.csdnimg.cn/533bf97e0abe447f9cb27c60f32019d6.png)

#### 5、持续部署（绑定云账号）

##### 5.1、输入账号名称

![输入账号名称](https://img-blog.csdnimg.cn/ed06c6d273094e5bb233ad5cacfeb58e.png)

##### 5.2、创建集群，开放外网 ip

**（1）创建集群。**

**在容器服务中创建集群。**

![创建集群](https://img-blog.csdnimg.cn/b2e3a9e388b34c4fb7ec01e838568354.png)

![创建集群](https://img-blog.csdnimg.cn/415ce26c30c841fe94140d7fade5c818.png)

**（2）开放外网。**

![开放外网](https://img-blog.csdnimg.cn/99113d1966094d2eba1e56bf048b1d4b.png)

![开放外网](https://img-blog.csdnimg.cn/c7c2b44461bf44f2b1064a8064343799.png)

##### 5.3、复制凭证

**（1）复制集群凭证。**

![复制集群凭证](https://img-blog.csdnimg.cn/22859ed557e74eb28b888e75c4e245d9.png)

**（2）复制到云账户。**

![复制到云账户](https://img-blog.csdnimg.cn/ffaf5aeee7434adf8004a52424de0e59.png)

#### 6、持续部署（Kubernetes）

![持续部署（Kubernetes）](https://img-blog.csdnimg.cn/804e12387b554ac0b12d1b8ed6e9d452.png)

##### 6.1、创建部署

![创建部署](https://img-blog.csdnimg.cn/7f0da42b755f4f8885e40abe12c94142.png)

##### 6.2、集群配置

###### 6.2.1、集群配置

![集群配置](https://img-blog.csdnimg.cn/c98d19fc2d7f4f0eb060bca2b9d9d982.png)

###### 6.2.2、镜像配置

**1、选择示例镜像用于测试使用。**

**2、可以选择 CODING Docker 仓库里面自己创建的镜像。**

![镜像配置](https://img-blog.csdnimg.cn/8b1d8100709b43998bfe8a8cb539ea7e.png)

![镜像配置](https://img-blog.csdnimg.cn/5ea21e3a141f4f6c81573646a99fe9d6.png)

###### 6.2.3、应用部署

![应用部署](https://img-blog.csdnimg.cn/457f37757b49479c94868e048a1a3c75.png)

##### 6.3、等待发布

![等待发布](https://img-blog.csdnimg.cn/8b1dbc6962574bdaabd3d27df5cd3081.png)

![等待发布](https://img-blog.csdnimg.cn/6a533ccb3d6647fda79c0c2149c46e91.png)

##### 6.4、获取发布地址

![获取发布地址](https://img-blog.csdnimg.cn/cc0ad8f2e3734c0eac523cccbc576216.png)

![获取发布地址](https://img-blog.csdnimg.cn/60850442d313451c8aa1616927b27d9d.png)

![获取发布地址](https://img-blog.csdnimg.cn/2a878c3856384dc6b6dcb69d0d3f6b4f.png)

##### 6.5、访问测试

![访问测试](https://img-blog.csdnimg.cn/4f1a2541409a47968323a28db840fdac.png)

#### 7、持续部署（腾讯云弹性伸缩）

##### 7.1、创建应用

**（1）在部署控制台创建应用，选择腾讯云弹性伸缩。**

![创建应用](https://img-blog.csdnimg.cn/4e02f356d7c646ecbad893a2fc0acc1a.png)

##### 7.2、创建流程

**（1）点击创建流程。**

![点击创建流程](https://img-blog.csdnimg.cn/449beca49e7341d28c6ef6f041743750.png)

**（2）选择流程。**

![选择流程](https://img-blog.csdnimg.cn/63a07d53e1d94fccb6a460f8adeca080.png)

**（3）修改流程内容。**

![修改流程内容](https://img-blog.csdnimg.cn/3dedcf7f2336489cbc65c5688b45282d.png)

##### 7.3、启动执行

![启动执行](https://img-blog.csdnimg.cn/17f3a1c5e7cf41f294db4c3394e3ff51.png)

##### 7.4、集群查看

**（1）执行成功后，集群中查看。**

![集群查看](https://img-blog.csdnimg.cn/5268b200ebaf444baa18b5deb9148542.png)
