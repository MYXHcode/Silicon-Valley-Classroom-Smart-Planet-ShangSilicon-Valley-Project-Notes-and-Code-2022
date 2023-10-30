# MySQL - 8.0.31
# Database - smart_planet_activity


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = ''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

# 创建智慧星球活动数据库 smart_planet_activity
CREATE DATABASE /*!32312 IF NOT EXISTS */`smart_planet_activity` /*!40100 DEFAULT CHARACTER SET utf8 */;

# 选择智慧星球活动数据库 smart_planet_activity
USE `smart_planet_activity`;

# 删除优惠券信息表 coupon_info
DROP TABLE IF EXISTS `coupon_info`;

# 创建优惠券信息表 coupon_info
CREATE TABLE `coupon_info`
(
    `id`               BIGINT(20)     NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `coupon_type`      TINYINT(3)     NOT NULL DEFAULT '1' COMMENT '购物券类型：1注册券，2推荐赠送券',
    `coupon_name`      VARCHAR(100)            DEFAULT NULL COMMENT '优惠卷名字',
    `amount`           DECIMAL(10, 2) NOT NULL DEFAULT '0.00' COMMENT '金额',
    `condition_amount` DECIMAL(10, 2) NOT NULL DEFAULT '0.00' COMMENT '使用门槛：0没门槛',
    `start_time`       DATE                    DEFAULT NULL COMMENT '可以领取的开始日期',
    `end_time`         DATE                    DEFAULT NULL COMMENT '可以领取的结束日期',
    `range_type`       TINYINT(3)     NOT NULL DEFAULT '1' COMMENT '使用范围：1全场通用',
    `rule_desc`        VARCHAR(200)            DEFAULT NULL COMMENT '规则描述',
    `publish_count`    INT(11)        NOT NULL DEFAULT '1' COMMENT '发行数量',
    `per_limit`        INT(11)        NOT NULL DEFAULT '1' COMMENT '每人限领张数',
    `use_count`        INT(11)        NOT NULL DEFAULT '0' COMMENT '已使用数量',
    `receive_count`    INT(11)        NOT NULL DEFAULT '0' COMMENT '领取数量',
    `expire_time`      DATETIME                DEFAULT NULL COMMENT '过期时间',
    `publish_status`   TINYINT(1)     NOT NULL DEFAULT '0' COMMENT '发布状态：0未发布，1已发布',
    `create_time`      TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`       TINYINT(3)     NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8 COMMENT ='优惠券信息';

# 添加优惠券信息表 coupon_info 的数据
INSERT INTO `coupon_info`(`id`, `coupon_type`, `coupon_name`, `amount`, `condition_amount`, `start_time`, `end_time`,
                          `range_type`, `rule_desc`, `publish_count`, `per_limit`, `use_count`, `receive_count`,
                          `expire_time`, `publish_status`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, '双十一新用户注册赠送100元卷', '100.00', '0.00', '2023-11-01', '2023-11-30', 1,
        '双十一新用户注册赠送100元卷，全程场用，没有限制', 100, 1, 0, 23, '2023-11-30 00:00:00', 1, '2023-10-20 18:29:14',
        '2023-11-01 08:30:39', 0),
       (2, 2, '双十一推荐课程并购买600福利卷', '600.00', '0.00', '2023-11-01', '2023-11-30', 1,
        '双十一推荐课程，新用户购买并支付，赠送推荐人600福利卷，全程场用，没有限制', 100, 1, 0, 24, '2023-11-30 00:00:00',
        1,
        '2023-10-20 11:35:56', '2023-11-01 08:31:37', 0),
       (3, 1, '国庆新用户注册赠送100元卷', '100.00', '0.00', '2023-10-01', '2023-10-10', 1,
        '国庆新用户注册赠送100元卷，全程场用，没有限制', 100, 1, 0, 24, '2023-10-01 00:00:00', 1, '2023-09-20 06:14:38',
        '2023-10-01 08:31:10', 0),
       (4, 2, '国庆推荐课程并购买500福利卷', '500.00', '0.00', '2023-10-01', '2023-10-10', 1,
        '双十一推荐课程，新用户购买并支付，赠送推荐人500福利卷，全程场用，没有限制', 100, 1, 0, 25, '2023-10-10 00:00:00',
        1, '2023-09-20 06:50:17', '2023-10-01 08:31:16', 0);

# 删除优惠券领用表 coupon_use
DROP TABLE IF EXISTS `coupon_use`;

# 创建优惠券领用表 coupon_use
CREATE TABLE `coupon_use`
(
    `id`            BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `coupon_id`     BIGINT(20)          DEFAULT NULL COMMENT '购物券ID',
    `user_id`       BIGINT(20)          DEFAULT NULL COMMENT '用户ID',
    `order_id`      BIGINT(20)          DEFAULT NULL COMMENT '订单ID',
    `coupon_status` VARCHAR(10)         DEFAULT NULL COMMENT '购物券状态：1未使用，2已使用',
    `get_time`      DATETIME            DEFAULT NULL COMMENT '获取时间',
    `using_time`    DATETIME            DEFAULT NULL COMMENT '使用时间',
    `used_time`     DATETIME            DEFAULT NULL COMMENT '支付时间',
    `expire_time`   DATETIME            DEFAULT NULL COMMENT '过期时间',
    `create_time`   TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `is_deleted`    TINYINT(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 38
  DEFAULT CHARSET = utf8 COMMENT ='优惠券领用';

# 添加优惠券领用表 coupon_use 的数据
INSERT INTO `coupon_use`(`id`, `coupon_id`, `user_id`, `order_id`, `coupon_status`, `get_time`, `using_time`,
                         `used_time`, `expire_time`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, 1, 1, '2', '2023-11-01 09:02:23', '2023-11-02 09:02:00', '2023-11-02 09:02:00', '2023-11-30 00:00:00',
        '2023-11-01 09:02:23',
        '2023-11-02 09:02:00', 0),
       (2, 2, 1, 2, '2', '2023-11-01 10:02:23', '2023-11-02 10:02:00', '2023-11-02 10:02:00', '2023-11-30 00:00:00',
        '2023-11-01 10:02:23',
        '2023-11-02 09:02:00', 0),
       (3, 3, 1, 3, '2', '2023-10-01 09:02:23', '2023-10-02 09:02:00', '2023-10-02 09:02:00', '2023-10-30 00:00:00',
        '2023-10-01 09:02:23',
        '2023-11-02 09:02:00', 0),
       (4, 4, 1, 4, '2', '2023-10-01 10:02:23', '2023-10-02 10:02:00', '2023-10-02 10:02:00', '2023-10-30 00:00:00',
        '2023-10-01 10:02:23',
        '2023-11-02 09:02:00', 0);

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
