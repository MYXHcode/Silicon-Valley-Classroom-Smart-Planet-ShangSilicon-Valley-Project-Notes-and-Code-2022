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

# user 表中添加 deleted 字段
ALTER TABLE `user` ADD COLUMN `deleted` BOOLEAN DEFAULT 0;
