# MySQL - 8.0.31
# Database - smart_planet_user

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = ''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

# 创建智慧星球用户数据库 smart_planet_user
CREATE DATABASE /*!32312 IF NOT EXISTS */`smart_planet_user` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

# 选择智慧星球用户数据库 smart_planet_user
USE `smart_planet_user`;

# 删除用户信息表 user_info
DROP TABLE IF EXISTS `user_info`;

# 创建用户信息表 user_info
CREATE TABLE `user_info`
(
    `id`           BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `phone`        VARCHAR(200)        DEFAULT NULL COMMENT '手机号',
    `password`     VARCHAR(200)        DEFAULT NULL COMMENT '用户密码',
    `name`         VARCHAR(200)        DEFAULT NULL COMMENT '用户姓名',
    `nick_name`    VARCHAR(100)        DEFAULT NULL COMMENT '昵称',
    `sex`          TINYINT(3)          DEFAULT NULL COMMENT '性别',
    `avatar`       VARCHAR(200)        DEFAULT NULL COMMENT '头像',
    `province`     VARCHAR(30)         DEFAULT NULL COMMENT '地区ID',
    `subscribe`    TINYINT(3) NOT NULL DEFAULT '0' COMMENT '订阅状态：0未订阅，1已订阅',
    `open_id`      VARCHAR(45)         DEFAULT NULL COMMENT '小程序openID',
    `union_id`     VARCHAR(45)         DEFAULT NULL COMMENT '微信开放平台unionID',
    `recommend_id` BIGINT(20)          DEFAULT NULL COMMENT '推荐人用户ID',
    `status`       TINYINT(3)          DEFAULT NULL COMMENT '状态',
    `create_time`  TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`   TINYINT(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 34
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户信息';

# 添加用户信息表 user_info 的数据
INSERT INTO `user_info`(`id`, `phone`, `password`, `name`, `nick_name`, `sex`, `avatar`, `province`, `subscribe`,
                        `open_id`, `union_id`, `recommend_id`, `status`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, '18812612826', '520.ILY!', '邓磊', '末影小黑xh', 0,
        'https://img-blog.csdnimg.cn/cd8f70622395464da62c8a41e4e9256f.png',
        '天津', 0, null, NULL, NULL, NULL, '2023-10-21 07:19:29', '2023-11-23 11:32:44', 0),
       (2, null, null, null, '他整夜在星海', 0,
        'https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83ep2rldp10WSEGqN07iaicr3gR3Ub2mXIoicv8bB7xOjORZ5rjgFqj0FIR5przLqcRr0FxLWKHKyIPKpg/132',
        '', 0, 'oxM4d64iKq9SD6lduBKcF4MQTjF8', NULL, NULL, NULL, '2023-10-21 07:19:29', '2023-11-23 11:32:44', 0);

# 删除用户登陆日志表 user_login_log
DROP TABLE IF EXISTS `user_login_log`;

# 创建用户登陆日志表 user_login_log
CREATE TABLE `user_login_log`
(
    `id`          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_id`     BIGINT(20)          DEFAULT NULL COMMENT '用户ID',
    `ip`          VARCHAR(64)         DEFAULT NULL COMMENT '登录IP',
    `city`        VARCHAR(64)         DEFAULT NULL COMMENT '登录城市',
    `type`        TINYINT(1)          DEFAULT NULL COMMENT '登录类型：0Web，1移动',
    `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户登陆日志';

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
