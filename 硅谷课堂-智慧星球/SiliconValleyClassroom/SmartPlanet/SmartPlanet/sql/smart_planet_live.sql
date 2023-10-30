# MySQL - 8.0.31
# Database - smart_planet_live


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = ''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

# 创建智慧星球视频直播数据库 smart_planet_vod
CREATE DATABASE /*!32312 IF NOT EXISTS */`smart_planet_live` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

# 选择智慧星球视频直播数据库 smart_planet_vod
USE `smart_planet_live`;

# 删除直播课程表 live_course
DROP TABLE IF EXISTS `live_course`;

# 创建直播课程表 live_course
CREATE TABLE `live_course`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `subject_id`  BIGINT(20)                   DEFAULT NULL COMMENT '分类ID',
    `course_name` VARCHAR(64)         NOT NULL DEFAULT '' COMMENT '直播名称',
    `start_time`  TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '直播开始时间',
    `end_time`    TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '直播结束时间',
    `cover`       VARCHAR(255)                 DEFAULT NULL COMMENT '直播课程封面图片路径',
    `course_id`   BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '课程ID',
    `teacher_id`  BIGINT(20)                   DEFAULT NULL COMMENT '主播教师ID',
    `create_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8mb4 COMMENT ='直播课程';

# 添加直播课程表 live_course 的数据
INSERT INTO `live_course`(`id`, `subject_id`, `course_name`, `start_time`, `end_time`, `cover`, `course_id`,
                          `teacher_id`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, NULL, 'Spring Cloud源码讲解', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        3513611, 2, '2023-09-01 08:11:33', '2023-09-01 20:00:00', 0),
       (2, NULL, '大数据Spark全面分析', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        3513612, 1, '2023-09-01 08:50:18', '2023-09-01 20:00:00', 0),
       (3, NULL, '微服务架构演进', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        3513613, 2, '2023-09-01 07:42:04', '2023-09-01 20:00:00', 0),
       (4, NULL, 'Java新特性全面讲解', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        3513614, 1, '2023-09-01 08:00:00', '2023-09-01 22:00:00', 0),
       (5, NULL, 'Spring MVC讲解', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        3513615, 2, '2023-09-01 08:00:00', '2023-09-01 22:00:00', 0),
       (6, NULL, 'MySQL源码级讲解', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', 3513616, 1, '2023-09-01 08:00:00',
        '2023-09-01 20:00:00', 0),
       (7, NULL, 'Spark讲解', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', 3513617, 1, '2023-09-01 08:00:00',
        '2023-09-01 20:00:00', 0),
       (8, NULL, '9月1日晚8点求职分享', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        3513618, 6, '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (9, NULL, 'Java 零基础入门', '2023-10-27 20:00:00', '2023-10-27 22:00:00',
        'https://smart-planet-1315007088.cos.ap-beijing.myqcloud.com/ProductionCOS/image/2023/10/27/0b1b4fdcaf664a9d81b7861885664374Java 零基础入门.png',
        3513937, 6, '2023-10-27 21:27:24', '2023-10-27 21:27:24', 0);


# 删除直播课程账号表 live_course_account
DROP TABLE IF EXISTS `live_course_account`;

# 创建直播课程账号表 live_course_account
CREATE TABLE `live_course_account`
(
    `id`              BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `live_course_id`  BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '直播课程ID',
    `anchor_account`  VARCHAR(20)                  DEFAULT NULL COMMENT '主播账号（欢拓系统的主播ID）',
    `anchor_password` VARCHAR(32)                  DEFAULT NULL COMMENT '主播密码',
    `anchor_key`      VARCHAR(64)         NOT NULL DEFAULT '' COMMENT '主播登录秘钥',
    `admin_key`       VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '助教登录秘钥',
    `user_key`        VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '学生登录秘钥',
    `create_time`     TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`      TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8mb4 COMMENT ='直播课程账号（受保护信息）';

# 添加直播课程账号表 live_course_account 的数据
INSERT INTO `live_course_account`(`id`, `live_course_id`, `anchor_account`, `anchor_password`, `anchor_key`,
                                  `admin_key`,
                                  `user_key`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, '582523', '123456', '2518', '6240', '8447', '2023-09-01 08:11:33', '2023-09-01 20:11:33', 0),
       (2, 2, '582549', '123456', '1325', '6632', '8582', '2023-09-01 08:50:30', '2023-09-01 20:50:30', 0),
       (3, 3, '582825', '123456', '1758', '5167', '8643', '2023-09-01 07:42:04', '2023-09-01 20:42:04', 0),
       (4, 4, '582549', '123456', '3800', '4233', '8874', '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (5, 5, '582523', '123456', '3060', '4868', '8963', '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (6, 6, '582825', '123456', '3977', '4548', '8658', '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (7, 7, '589813', '123456', '1921', '4328', '8302', '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (8, 8, '589813', '123456', '3108', '6824', '8717', '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (9, 9, '758297', '520.ILY!', '3013', '5517', '9147', '2023-10-27 21:27:24', '2023-10-27 21:27:24', 0);

# 删除直播课程配置表 live_course_config
DROP TABLE IF EXISTS `live_course_config`;

# 创建直播课程配置表 live_course_config
CREATE TABLE `live_course_config`
(
    `id`             BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `live_course_id` BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '直播课程ID',
    `page_view_mode` TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '界面模式：1全屏模式，0二分屏，2课件模式',
    `number_enable`  TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '是否开启观看人数：0否，1是',
    `store_enable`   TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '商城是否开启：0未开启，1开启',
    `store_type`     TINYINT(3)          NOT NULL DEFAULT '1' COMMENT '1商品列表,2商城链接,3商城二维码',
    `create_time`    TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`     TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8mb4 COMMENT ='直播课程配置';

# 添加直播课程配置表 live_course_config 的数据
INSERT INTO `live_course_config`(`id`, `live_course_id`, `page_view_mode`, `number_enable`, `store_enable`,
                                 `store_type`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, 1, 1, 1, 1, '2023-09-01 07:27:23', '2023-09-01 20:27:23', 0),
       (2, 2, 1, 1, 1, 1, '2023-09-01 07:42:29', '2023-09-01 20:42:29', 0),
       (3, 3, 1, 1, 1, 1, '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (4, 4, 1, 1, 1, 1, '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (5, 5, 1, 1, 1, 1, '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (6, 6, 1, 1, 1, 1, '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (7, 7, 1, 1, 1, 1, '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (8, 8, 1, 1, 1, 1, '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (9, 9, 1, 1, 1, 1, '2023-10-27 21:28:03', '2023-10-27 21:28:03', 0);


# 删除直播课程简介表 live_course_description
DROP TABLE IF EXISTS `live_course_description`;

# 创建直播课程简介表 live_course_description
CREATE TABLE `live_course_description`
(
    `id`             BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `live_course_id` BIGINT(20)                   DEFAULT NULL COMMENT '直播课程ID',
    `description`    text COMMENT '课程简介',
    `create_time`    TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`     TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 20
  DEFAULT CHARSET = utf8mb4 COMMENT ='直播课程简介';

# 添加直播课程简介表 live_course_description 的数据
INSERT INTO `live_course_description`(`id`, `live_course_id`, `description`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, 'Spring Cloud源码讲解', '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (2, 2, '大数据Spark全面分析', '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (3, 3, '微服务架构演进', '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (4, 4,
        '本套Java视频完全针对零基础学生，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。但是，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。视频特点：通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握”源码级“的Java SE核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。1. 通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题。2. 具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习。3. 深入：源码分析，更有 Java 反射、动态代理的实际应用等。4. 登录智慧星球官网，技术教师免费在线答疑。',
        '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (5, 5, 'Spring MVC讲解', '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (6, 6,
        '数据库就像一棵常青的技能树，无论是初级程序员还是CTO、首席架构师都能从中汲取足够的技术养料。菜鸟往往积累单点技术，如 DML、DDL、存储过程和函数、约束、索引的数据结构，大佬则需要吃透底层原理，数据库事务ACID如何实现？锁机制与MVCC又是怎么回事？分布式场景下数据库怎么优化保持高性能？<br><br>知道怎么用是一方面，知道为什么则是更为稀缺的能力。程序员核心能力中至关重要的一点：精通数据库。精通意味着：第一，形成知识网，更灵活地应对突发问题；第二，懂底层原理，更自由地应对复杂多变的业务场景。',
        '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (7, 7, 'Spark讲解', '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (8, 8, '9月1日晚8点求职分享', '2023-09-01 08:00:00', '2023-09-01 20:00:00', 0),
       (9, 9, 'Java 零基础入门', '2023-10-27 21:27:24', '2023-10-27 21:50:21', 0);


# 删除直播课程关联推荐表 live_course_goods
DROP TABLE IF EXISTS `live_course_goods`;

# 创建直播课程关联推荐表 live_course_goods
CREATE TABLE `live_course_goods`
(
    `id`             BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `live_course_id` BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '直播课程ID',
    `goods_id`       BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '推荐点播课程ID',
    `name`           VARCHAR(100)                 DEFAULT NULL COMMENT '商品名称',
    `img`            VARCHAR(255)                 DEFAULT NULL COMMENT '图片',
    `price`          decimal(10, 0)               DEFAULT NULL COMMENT '商品现价',
    `originalPrice`  decimal(10, 0)               DEFAULT NULL COMMENT '商品原价',
    `tab`            TINYINT(3)                   DEFAULT NULL COMMENT '商品标签',
    `url`            VARCHAR(255)                 DEFAULT NULL COMMENT '商品链接',
    `put_away`       VARCHAR(255)                 DEFAULT NULL COMMENT '商品状态：0下架，1上架，2推荐',
    `pay`            TINYINT(3)                   DEFAULT NULL COMMENT '购买模式：1链接购买，2二维码购买',
    `qrcode`         VARCHAR(255)                 DEFAULT NULL COMMENT '商品二维码',
    `create_time`    TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`     TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = utf8mb4 COMMENT ='直播课程关联推荐';

# 添加直播课程关联推荐表 live_course_goods 的数据
INSERT INTO `live_course_goods`(`id`, `live_course_id`, `goods_id`, `name`, `img`, `price`, `originalPrice`, `tab`,
                                `url`, `put_away`, `pay`, `qrcode`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, 1, 'Spring Cloud源码讲解', 'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', '10', '10',
        1,
        'http://smartplanetmobile.free.idcfengye.com/#/course/info/1', '1', 1, '', '2023-09-01 07:29:36',
        '2023-09-01 08:54:17', 0),
       (2, 2, 2, '大数据Spark全面分析', 'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', '10', '10',
        1,
        'http://smartplanetmobile.free.idcfengye.com/#/course/info/2', '1', 1, '', '2023-09-01 07:42:30',
        '2023-09-01 08:52:54', 0),
       (3, 3, 3, '微服务架构演进',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        '22800', '22800', 1, 'http://smartplanetmobile.free.idcfengye.com/#/course/info/3', '1', 1, '',
        '2023-09-01 08:00:00',
        '2023-09-01 20:00:00', 0),
       (4, 4, 4, 'Java新特性全面讲解',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        '0', '0', 1, 'http://smartplanetmobile.free.idcfengye.com/#/course/info/4', '1', 1, '', '2023-09-01 08:00:00',
        '2023-09-01 20:00:00', 0),
       (5, 5, 5, 'Spring MVC讲解',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        '22800', '22800', 1, 'http://smartplanetmobile.free.idcfengye.com/#/course/info/5', '1', 1, '',
        '2023-09-01 08:00:00',
        '2023-09-01 20:00:00', 0),
       (6, 6, 6, 'MySQL源码级讲解', 'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', '1000', '1000',
        1, 'http://smartplanetmobile.free.idcfengye.com/#/course/info/6', '1', 1, '', '2023-09-01 08:00:00',
        '2023-09-01 20:00:00', 0),
       (7, 7, 7, 'Spark讲解',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        '22800', '22800', 1, 'http://smartplanetmobile.free.idcfengye.com/#/course/info/7', '1', 1, '',
        '2023-09-01 08:00:00',
        '2023-09-01 20:00:00', 0),
       (8, 8, 8, '面试指南', 'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', '1000', '1000',
        1, 'http://smartplanetmobile.free.idcfengye.com/#/course/info/8', '1', 1, '', '2023-09-01 08:00:00',
        '2023-09-01 20:00:00', 0),
       (9, 9, 13, 'Java 零基础入门',
        'https://smart-planet-1315007088.cos.ap-beijing.myqcloud.com/ProductionCOS/image/2023/10/08/7a890a1382f54e569b9ab742f07de1e8Java 零基础入门.png',
        '10', '10', 1, 'http://smartplanetmobile.free.idcfengye.com/#/course/info/13', NULL, 1, '',
        '2023-10-27 21:28:03',
        '2023-10-27 21:51:14', 0);


# 删除直播来访者记录表 live_visitor
DROP TABLE IF EXISTS `live_visitor`;

# 创建直播来访者记录表 live_visitor
CREATE TABLE `live_visitor`
(
    `id`              BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `live_course_id`  BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '直播课程ID',
    `course_name`     VARCHAR(100)                 DEFAULT NULL COMMENT '直播名称',
    `user_id`         VARCHAR(50)         NOT NULL DEFAULT '0' COMMENT '来访者用户ID',
    `nick_name`       VARCHAR(100)                 DEFAULT NULL COMMENT '昵称',
    `join_time`       VARCHAR(30)                  DEFAULT NULL COMMENT '进入时间',
    `leave_time`      VARCHAR(30)                  DEFAULT NULL COMMENT '离开的时间',
    `location`        VARCHAR(50)                  DEFAULT NULL COMMENT '用户地理位置',
    `duration`        BIGINT(20)                   DEFAULT NULL COMMENT '用户停留的时间(单位：秒)',
    `duration_time`   VARCHAR(30)                  DEFAULT NULL COMMENT '用户停留时间(时:分:秒)',
    `live_visitor_id` VARCHAR(50)                  DEFAULT NULL COMMENT '平台来访者ID，去重使用',
    `create_time`     TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`      TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    KEY `idx_live_visitor_id` (`live_visitor_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8mb4 COMMENT ='直播来访者记录';

# 添加直播来访者记录表 live_visitor 的数据
INSERT INTO `live_visitor`(`id`, `live_course_id`, `course_name`, `user_id`, `nick_name`, `join_time`, `leave_time`,
                           `location`, `duration`, `duration_time`, `live_visitor_id`, `create_time`, `update_time`,
                           `is_deleted`)
VALUES (1, 1, 'Spring Cloud深入源码讲解', '1', '末影小黑xh', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        '中国北京北京',
        3820, '00:20:22', '230172045', '2023-09-01 20:00:00', '2023-09-01 22:00:00', 0),
       (2, 1, 'Spring Cloud深入源码讲解', '2', '末影小黑xh', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        '中国天津天津', 3630, '00:20:03', '230172043', '2023-09-01 20:00:00', '2023-09-01 22:00:00', 0),
       (3, 1, 'Spring Cloud深入源码讲解', '3', '末影小黑xh', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        '中国北京北京',
        1170, '00:15:17', '230171079', '2023-09-01 20:00:00', '2023-09-01 22:00:00', 0),
       (4, 1, 'Spring Cloud深入源码讲解', '4', '末影小黑xh', '2023-09-01 20:00:00', '2023-09-01 22:00:00',
        '中国天津天津', 1828, '00:16:28', '230171077', '2023-09-01 20:00:00', '2023-09-01 22:00:00', 0);

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
