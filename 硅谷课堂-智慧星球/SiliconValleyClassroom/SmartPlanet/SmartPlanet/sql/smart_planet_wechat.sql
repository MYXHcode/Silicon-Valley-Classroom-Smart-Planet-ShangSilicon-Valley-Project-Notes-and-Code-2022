# MySQL - 8.0.31
# Database - smart_planet_wechat

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = ''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

# 创建智慧星球微信数据库 smart_planet_wechat
CREATE DATABASE /*!32312 IF NOT EXISTS */`smart_planet_wechat` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

# 选择智慧星球微信数据库 smart_planet_wechat
USE `smart_planet_wechat`;

# 删除菜单表 menu
DROP TABLE IF EXISTS `menu`;

# 创建菜单表 menu
CREATE TABLE `menu`
(
    `id`          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `parent_id`   BIGINT(20)          DEFAULT NULL COMMENT '上级ID',
    `name`        VARCHAR(50)         DEFAULT NULL COMMENT '菜单名称',
    `type`        VARCHAR(10)         DEFAULT NULL COMMENT '类型',
    `url`         VARCHAR(100)        DEFAULT NULL COMMENT '网页链接，用户点击菜单可打开链接',
    `menu_key`    VARCHAR(20)         DEFAULT NULL COMMENT '菜单Key值，用于消息接口推送',
    `sort`        TINYINT(3)          DEFAULT NULL COMMENT '排序',
    `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 14
  DEFAULT CHARSET = utf8 COMMENT ='菜单';

# 添加菜单表 menu 的数据
INSERT INTO `menu`(`id`, `parent_id`, `name`, `type`, `url`, `menu_key`, `sort`, `create_time`, `update_time`,
                   `is_deleted`)
VALUES (1, 0, '直播', NULL, NULL, NULL, 1, '2023-09-01 08:00:00', '2023-09-01 08:00:00', 0),
       (2, 0, '课程', NULL, NULL, NULL, 2, '2023-09-01 08:00:00', '2023-09-01 08:00:00', 0),
       (3, 0, '我的', NULL, NULL, NULL, 3, '2023-09-01 08:00:00', '2023-09-01 08:00:00', 0),
       (4, 3, '关于我们', 'click', NULL, 'aboutUs', 4, '2023-09-01 08:00:00', '2023-09-01 08:00:00', 0),
       (5, 1, '微服务架构演进', 'view', '/live/info/3', '', 2, '2023-09-01 08:00:00', '2023-09-01 08:00:00', 0),
       (6, 1, '大数据Spark全面分析', 'view', '/live/info/2', '', 3, '2023-09-01 08:00:00', '2023-09-01 08:00:00', 0),
       (7, 2, '后端开发', 'view', '/course/1', '', 1, '2023-09-01 08:00:00', '2023-09-01 08:00:00', 0),
       (8, 2, '大数据', 'view', '/course/13', '', 2, '2023-09-01 08:00:00', '2023-09-01 08:00:00', 0),
       (9, 3, '我的订单', 'view', '/order', '', 2, '2023-09-01 08:00:00', '2023-09-01 08:00:00', 0),
       (10, 3, '我的课程', 'view', '/my/course', '', 1, '2023-09-01 08:00:00', '2023-09-01 08:00:00', 0),
       (11, 1, '全部直播', 'view', '/live', '', 1, '2023-09-01 08:00:00', '2023-09-01 08:00:00', 0),
       (12, 3, '我的优惠券', 'view', '/coupon', NULL, 3, '2023-09-01 08:52:27', '2023-09-01 08:52:40', 0),
       (13, 1, '09月01日晚8点求职分享', 'view', '/live/info/8', '', 4, '2023-09-01 08:21:39', '2023-09-01 08:21:39', 0),
       (14,1,'Java 零基础入门','view','/live/info/9','',5,'2023-10-28 16:00:00', '2023-10-28 16:30:00', 0);

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
