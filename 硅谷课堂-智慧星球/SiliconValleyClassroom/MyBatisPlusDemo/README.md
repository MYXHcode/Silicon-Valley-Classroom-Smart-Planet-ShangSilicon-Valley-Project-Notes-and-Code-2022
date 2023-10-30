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
