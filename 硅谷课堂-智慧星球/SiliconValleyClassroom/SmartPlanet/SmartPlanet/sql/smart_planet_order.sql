# MySQL - 8.0.31
# Database - smart_planet_order


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = ''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

# 创建智慧星球视频订单数据库 smart_planet_order
CREATE DATABASE /*!32312 IF NOT EXISTS */`smart_planet_order` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

# 选择智慧星球视频订单数据库 smart_planet_order
USE `smart_planet_order`;

# 删除订单明细表 order_detail
DROP TABLE IF EXISTS `order_detail`;

# 创建订单明细表 order_detail
CREATE TABLE `order_detail`
(
    `id`            BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `course_id`     BIGINT(20)          DEFAULT NULL COMMENT '课程ID',
    `course_name`   VARCHAR(4000)       DEFAULT NULL COMMENT '课程名称',
    `cover`         VARCHAR(255)        DEFAULT NULL COMMENT '课程封面',
    `order_id`      BIGINT(20)          DEFAULT NULL COMMENT '订单编号',
    `user_id`       BIGINT(20)          DEFAULT NULL COMMENT '用户ID',
    `origin_amount` DECIMAL(16, 2)      DEFAULT NULL COMMENT '原始金额',
    `coupon_reduce` DECIMAL(16, 2)      DEFAULT NULL COMMENT '优惠劵减免金额',
    `final_amount`  DECIMAL(16, 2)      DEFAULT NULL COMMENT '最终金额',
    `session_id`    VARCHAR(4000)       DEFAULT NULL COMMENT '会话ID，当前会话ID继承购物车中会话ID',
    `create_time`   TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`    TINYINT(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_oid_cid` (`order_id`, `course_id`),
    KEY `idx_cid` (`course_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8 COMMENT ='订单明细';

# 添加订单明细表 order_detail 的数据
INSERT INTO `order_detail`(`id`, `course_id`, `course_name`, `cover`, `order_id`, `user_id`, `origin_amount`,
                           `coupon_reduce`, `final_amount`, `session_id`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, '大数据技术之Spark', 'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', 1, 1, '1000.00',
        '0.00', '1000.00', NULL, '2023-11-22 13:38:47', '2023-11-26 03:07:25', 0),
       (2, 2, 'Java基础课程',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        2, 1, '23800.00', '0.00', '23800.00', NULL, '2023-11-23 10:09:08', '2023-11-26 03:08:05', 0),
       (3, 3, '大数据技术之Flume（2023新版）', 'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', 3, 1,
        '1000.00',
        '0.00', '1000.00', NULL, '2023-11-23 10:54:51', '2023-11-26 03:07:26', 0),
       (4, 4, '大数据技术之HBase（2023新版）',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        4, 1, '22800.00', '0.00', '22800.00', NULL, '2023-11-23 10:57:27', '2023-11-26 03:07:41', 0),
       (5, 5, '大数据技术之Kafka（2023新版）', 'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', 5, 1,
        '1000.00',
        '0.00', '1000.00', NULL, '2023-11-23 10:57:52', '2023-11-26 03:07:27', 0),
       (6, 6, '尚硅谷大数据技术之HBase（2023新版）',
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        6, 1, '19800.00', '0.00', '19800.00', NULL, '2023-11-26 08:56:07', '2023-11-26 08:56:07', 0),
       (7, 7, '大数据项目之电商数仓', 'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', 7, 1,
        '1000.00',
        '0.00', '1000.00', NULL, '2023-11-26 10:35:46', '2023-11-26 10:35:46', 0),
       (8, 8, 'Scala入门到精通（2023新版）', 'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', 8, 1,
        '1000.00',
        '0.00', '1000.00', NULL, '2023-12-28 15:25:01', '2023-12-28 15:25:01', 0),
       (9, 13, 'Java 零基础入门', 'https://smart-planet-1315007088.cos.ap-beijing.myqcloud.com/ProductionCOS/image/2023/10/08/7a890a1382f54e569b9ab742f07de1e8Java 零基础入门.png', 9, 2,
        '9.90',
        '0.00', '9.90', NULL, '2023-10-22 15:16:41', '2023-10-22 15:17:51', 0);

# 删除订单信息表 order_info
DROP TABLE IF EXISTS `order_info`;

# 创建订单信息表 order_info
CREATE TABLE `order_info`
(
    `id`            BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_id`       BIGINT(20)          DEFAULT NULL COMMENT '用户ID',
    `nick_name`     VARCHAR(30)         DEFAULT NULL COMMENT '昵称',
    `phone`         VARCHAR(11)         DEFAULT NULL COMMENT '手机',
    `origin_amount` DECIMAL(10, 2)      DEFAULT NULL COMMENT '原始金额',
    `coupon_reduce` DECIMAL(10, 2)      DEFAULT NULL COMMENT '优惠券减免',
    `final_amount`  DECIMAL(10, 2)      DEFAULT NULL COMMENT '最终金额',
    `order_status`  VARCHAR(20)         DEFAULT NULL COMMENT '订单状态',
    `out_trade_no`  VARCHAR(50)         DEFAULT NULL COMMENT '订单交易编号（第三方支付用)',
    `trade_body`    VARCHAR(200)        DEFAULT NULL COMMENT '订单描述(第三方支付用)',
    `session_id`    VARCHAR(100)        DEFAULT NULL COMMENT '会话ID',
    `province`      VARCHAR(20)         DEFAULT NULL COMMENT '地区ID',
    `pay_time`      DATETIME            DEFAULT NULL COMMENT '支付时间',
    `expire_time`   DATETIME            DEFAULT NULL COMMENT '失效时间',
    `create_time`   TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`    TINYINT(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    KEY `idx_uid` (`user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = utf8 COMMENT ='订单信息';

# 添加订单信息表 order_info 的数据
INSERT INTO `order_info`(`id`, `user_id`, `nick_name`, `phone`, `origin_amount`, `coupon_reduce`, `final_amount`,
                         `order_status`, `out_trade_no`, `trade_body`, `session_id`, `province`, `pay_time`,
                         `expire_time`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, '末影小黑xh', '18812612826', '1000.00', '500.00', '500.00', '1', '20231122213847830', '大数据技术之Spark',
        NULL,
        '北京', '2023-11-22 21:39:12', NULL, '2023-11-22 13:38:47', '2023-11-22 13:39:12', 0),
       (2, 1, '末影小黑xh', '18812612826', '23800.00', '0.00', '23800.00', '1', '20231123180908744',
        'Java基础课程', NULL, '北京', '2023-11-23 18:09:32', NULL, '2023-11-23 10:09:08',
        '2023-11-23 10:09:32', 0),
       (3, 1, '末影小黑xh', '18812612826', '1000.00', '0.00', '1000.00', '1', '20231123185451570',
        '大数据技术之Flume（2023新版）',
        NULL, '北京',
        '2023-11-23 18:55:04', NULL, '2023-11-23 10:54:51', '2023-11-23 10:55:04', 0),
       (4, 1, '末影小黑xh', '18812612826', '22800.00', '500.00', '22300.00', '0', '20231123185726513',
        '大数据技术之HBase（2023新版）',
        NULL,
        '北京', NULL, NULL, '2023-11-23 10:57:26', '2023-11-23 10:57:26', 0),
       (5, 1, '末影小黑xh', '18812612826', '1000.00', '500.00', '500.00', '0', '20231123185752103',
        '大数据技术之Kafka（2023新版）',
        NULL, '天津', NULL, NULL, '2023-11-23 10:57:52', '2023-11-23 10:57:52', 0),
       (6, 1, '末影小黑xh', '18812612826', '19800.00', '0.00', '19800.00', '1', '20231126165606808',
        '大数据项目之电商数仓', NULL, '天津', '2023-11-26 16:56:25', NULL, '2023-11-26 08:56:07',
        '2023-11-26 08:56:24', 0),
       (7, 1, '末影小黑xh', '18812612826', '1000.00', '0.00', '1000.00', '1', '20231126183546799', '大数据技术之Sqoop',
        NULL,
        '天津',
        '2023-11-26 18:36:14', NULL, '2023-11-26 10:35:46', '2023-11-26 10:36:13', 0),
       (8, 1, '末影小黑xh', '18812612826', '1000.00', '0.00', '1000.00', '0', '20231228152501327',
        'Scala入门到精通（2023新版）',
        NULL, '天津', NULL,
        NULL, '2023-12-28 15:25:01', '2023-12-28 15:25:01', 0),
       (9, 2, '他整夜在星海', NULL, '9.90', '0.00', '9.90', '0', '20231022151641054',
        'Java 零基础入门',
        NULL, '', NULL,
        NULL, '2023-10-22 15:16:41', '2023-10-22 15:18:20', 0);


# 删除支付信息表 payment_info
DROP TABLE IF EXISTS `payment_info`;

# 创建支付信息表 payment_info
CREATE TABLE `payment_info`
(
    `id`               INT(11)    NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `out_trade_no`     VARCHAR(50)         DEFAULT NULL COMMENT '对外业务编号',
    `order_id`         BIGINT(20)          DEFAULT NULL COMMENT '订单编号',
    `user_id`          BIGINT(20)          DEFAULT NULL COMMENT '用户ID',
    `alipay_trade_no`  VARCHAR(50)         DEFAULT NULL COMMENT '支付宝交易编号',
    `total_amount`     DECIMAL(10, 2)      DEFAULT NULL COMMENT '支付金额',
    `trade_body`       VARCHAR(200)        DEFAULT NULL COMMENT '交易内容',
    `payment_type`     VARCHAR(20)         DEFAULT NULL COMMENT '支付类型',
    `payment_status`   VARCHAR(20)         DEFAULT NULL COMMENT '支付状态',
    `callback_content` VARCHAR(1000)       DEFAULT NULL COMMENT '回调信息',
    `callback_time`    DATETIME            DEFAULT NULL COMMENT '回调时间',
    `create_time`      TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`       TINYINT(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    KEY `idx_oid` (`order_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = utf8 COMMENT ='支付信息';

# 添加支付信息表 payment_info 的数据
INSERT INTO `payment_info`(`id`, `out_trade_no`, `order_id`, `user_id`, `alipay_trade_no`, `total_amount`, `trade_body`,
                           `payment_type`, `payment_status`, `callback_content`, `callback_time`, `create_time`,
                           `update_time`, `is_deleted`)
VALUES (1, '20231122213847830', 1, 1, NULL, '0.01', '大数据技术之Spark', '2', '2',
        '{transaction_id=4200001236202311223264279278, nonce_str=60QD7Oevf9wU02zc, trade_state=SUCCESS, bank_type=OTHERS, openid=oxM4d64iKq9SD6lduBKcF4MQTjF8, sign=1D685646F5D4D5BB4AEA9A3285A322B0, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20231122213847830, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20231122213909, is_subscribe=Y, return_code=SUCCESS}',
        '2023-11-22 21:39:12', '2023-11-22 21:38:55', '2023-11-22 13:39:12', 0),
       (2, '20231123180908744', 2, 1, NULL, '0.01', 'Java基础课程', '2', '2',
        '{transaction_id=4200001120202311230211882387, nonce_str=wn4XulMGtpBWmHvP, trade_state=SUCCESS, bank_type=OTHERS, openid=oxM4d64iKq9SD6lduBKcF4MQTjF8, sign=0F505EC786ECC4C649578D8A71DE139C, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20231123180908744, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20231123180927, is_subscribe=Y, return_code=SUCCESS}',
        '2023-11-23 18:09:32', '2023-11-23 18:09:15', '2023-11-23 10:09:32', 0),
       (3, '20231123185451570', 3, 1, NULL, '0.01', '大数据技术之Flume（2023新版）', '2', '2',
        '{transaction_id=4200001123202311233106099225, nonce_str=VNHOOhJVvGW8V0xo, trade_state=SUCCESS, bank_type=OTHERS, openid=oxM4d64iKq9SD6lduBKcF4MQTjF8, sign=CE0049BC9A1922CF70F423AC406BEB88, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20231123185451570, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20231123185502, is_subscribe=N, return_code=SUCCESS}',
        '2023-11-23 18:55:04', '2023-11-23 18:54:53', '2023-11-23 10:55:04', 0),
       (4, '20231123185726513', 4, 1, NULL, '0.01', '大数据技术之HBase（2023新版）', '2', '1', NULL, NULL,
        '2023-11-23 18:57:30',
        '2023-11-23 10:57:30', 0),
       (5, '20231123185752103', 5, 1, NULL, '0.01', '大数据技术之Kafka（2023新版）', '2', '1', NULL, NULL,
        '2023-11-23 18:57:53',
        '2023-11-23 10:57:53', 0),
       (6, '20231126165606808', 6, 1, NULL, '0.01', '大数据项目之电商数仓', '2', '2',
        '{transaction_id=4200001146202311266807786474, nonce_str=xTJGeq7F0Dz0c0U8, trade_state=SUCCESS, bank_type=OTHERS, openid=oxM4d64iKq9SD6lduBKcF4MQTjF8, sign=201D5B989A83376A3AA34DFDAB457CFF, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20231126165606808, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20231126165619, is_subscribe=Y, return_code=SUCCESS}',
        '2023-11-26 16:56:24', '2023-11-26 16:56:09', '2023-11-26 08:56:24', 0),
       (7, '20231126183546799', 7, 1, NULL, '0.01', '大数据技术之Sqoop', '2', '2',
        '{transaction_id=4200001228202311261700574727, nonce_str=pzhJ1kkbfSwFMslY, trade_state=SUCCESS, bank_type=OTHERS, openid=oxM4d64iKq9SD6lduBKcF4MQTjF8, sign=5B8528ED454C09E24F4297A97345FD87, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20231126183546799, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20231126183611, is_subscribe=Y, return_code=SUCCESS}',
        '2023-11-26 18:36:14', '2023-11-26 18:35:48', '2023-11-26 10:36:13', 0),
       (8, '20231126183546799', 8, 1, NULL, '0.01', 'Scala入门到精通（2023新版）', '2', '2',
        '{transaction_id=4200001228202311261700574727, nonce_str=pzhJ1kkbfSwFMslY, trade_state=SUCCESS, bank_type=OTHERS, openid=oxM4d64iKq9SD6lduBKcF4MQTjF8, sign=5B8528ED454C09E24F4297A97345FD87, return_msg=OK, fee_type=CNY, mch_id=1481962542, cash_fee=1, out_trade_no=20231126183546799, cash_fee_type=CNY, appid=wxf913bfa3a2c7eeeb, total_fee=1, trade_state_desc=支付成功, trade_type=JSAPI, result_code=SUCCESS, attach=, time_end=20231126183611, is_subscribe=Y, return_code=SUCCESS}',
        '2023-11-26 18:36:14', '2023-11-26 18:35:48', '2023-11-26 10:36:13', 0);

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
