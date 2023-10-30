# MySQL - 8.0.31
# Database - smart_planet_acl


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = ''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

# 创建智慧星球权限管理数据库 smart_planet_acl
CREATE DATABASE /*!32312 IF NOT EXISTS */`smart_planet_acl` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

# 选择智慧星球权限管理数据库 smart_planet_acl
USE `smart_planet_acl`;

# 删除用户表 admin
DROP TABLE IF EXISTS `admin`;

# 创建用户表 admin
CREATE TABLE `admin`
(
    `id`          BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `username`    VARCHAR(20) NOT NULL DEFAULT '' COMMENT '用户名',
    `password`    VARCHAR(32) NOT NULL DEFAULT '' COMMENT '密码',
    `name`        VARCHAR(50)          DEFAULT NULL COMMENT '姓名',
    `phone`       VARCHAR(11)          DEFAULT NULL COMMENT '手机',
    `ware_id`     BIGINT(20)  NOT NULL DEFAULT '0' COMMENT '仓库ID，默认为：0平台用户',
    `create_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3)  NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uname` (`username`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户';

# 添加用户表 admin 的数据
INSERT INTO `admin`(`id`, `username`, `password`, `name`, `phone`, `ware_id`, `create_time`, `update_time`,
                    `is_deleted`)
VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '邓磊', '18812612826', 0, '2023-09-26 08:00:00',
        '2023-09-26 09:00:00',
        0),
       (2, 'MYXH', '55fe763f8d6452a1ae212c59c35da0a4', '邓磊', '18812612826', 0, '2023-09-26 08:00:00',
        '2023-09-26 09:00:00',
        0);

# 删除后台用户登录日志表 admin_login_log
DROP TABLE IF EXISTS `admin_login_log`;

# 创建后台用户登录日志表 admin_login_log
CREATE TABLE `admin_login_log`
(
    `id`          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `admin_id`    BIGINT(20)          DEFAULT NULL COMMENT '用户ID',
    `ip`          VARCHAR(64)         DEFAULT NULL COMMENT 'IP地址',
    `address`     VARCHAR(100)        DEFAULT NULL COMMENT '住址',
    `user_agent`  VARCHAR(100)        DEFAULT NULL COMMENT '浏览器登录类型',
    `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='后台用户登录日志';

# 删除用户角色表 admin_role
DROP TABLE IF EXISTS `admin_role`;

# 创建用户角色表 admin_role
CREATE TABLE `admin_role`
(
    `id`          BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `role_id`     BIGINT(20) NOT NULL DEFAULT '0' COMMENT '角色ID',
    `admin_id`    BIGINT(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
    `create_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    KEY `idx_role_id` (`role_id`),
    KEY `idx_user_id` (`admin_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  DEFAULT CHARSET = utf8 COMMENT ='用户角色';

# 添加用户角色表 admin_role 的数据
INSERT INTO `admin_role`(`id`, `role_id`, `admin_id`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, 1, '2023-09-26 08:00:00', '2023-09-26 09:00:00', 0),
       (2, 2, 1, '2023-06-01 08:53:12', '2023-12-01 06:21:40', 1),
       (3, 3, 1, '2023-06-18 17:18:37', '2023-06-18 17:18:37', 0),
       (4, 4, 1, '2023-09-27 09:37:45', '2023-09-27 09:37:45', 0),
       (5, 1, 2, '2023-12-01 06:21:40', '2023-12-01 06:21:40', 0);

# 删除权限表 permission
DROP TABLE IF EXISTS `permission`;

# 创建权限表 permission
CREATE TABLE `permission`
(
    `id`          BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `pid`         BIGINT(20)  NOT NULL DEFAULT '0' COMMENT '所属上级',
    `name`        VARCHAR(20) NOT NULL DEFAULT '' COMMENT '名称',
    `code`        VARCHAR(50)          DEFAULT NULL COMMENT '名称code',
    `to_code`     VARCHAR(100)         DEFAULT NULL COMMENT '跳转页面code',
    `type`        TINYINT(3)  NOT NULL DEFAULT '0' COMMENT '类型：1菜单，2按钮',
    `status`      TINYINT(4)           DEFAULT NULL COMMENT '状态：0禁止，1正常',
    `create_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3)  NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    KEY `idx_pid` (`pid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 101
  DEFAULT CHARSET = utf8mb4 COMMENT ='权限';

# 添加权限表 permission 的数据
INSERT INTO `permission`(`id`, `pid`, `name`, `code`, `to_code`, `type`, `status`, `create_time`, `update_time`,
                         `is_deleted`)
VALUES (1, 0, '全部数据', 'AllData', 'AllData', 1, 1, '2023-05-31 18:05:37', '2023-09-27 13:37:59', 0),
       (2, 1, '权限管理', 'Acl', 'Acl', 1, 1, '2023-05-31 18:05:37', '2023-05-31 19:36:53', 0),
       (3, 2, '用户管理', 'User', 'User', 1, 1, '2023-05-31 18:05:37', '2023-05-31 19:36:58', 0),
       (4, 2, '角色管理', 'Role', 'Role', 1, 1, '2023-05-31 18:05:37', '2023-05-31 19:37:02', 0),
       (5, 2, '菜单管理', 'Permission', 'Permission', 1, 1, '2023-05-31 18:05:37', '2023-05-31 19:37:05', 0),
       (6, 3, '分配角色', 'btn.User.assgin', 'btn.User.assgin', 2, 1, '2023-05-31 18:05:37', '2023-06-01 08:35:35',
        0),
       (7, 3, '添加', 'btn.User.add', 'btn.User.add', 2, 1, '2023-05-31 18:05:37', '2023-06-01 08:34:29', 0),
       (8, 3, '修改', 'btn.User.update', 'btn.User.update', 2, 1, '2023-05-31 18:05:37', '2023-06-01 08:34:45', 0),
       (9, 3, '删除', 'btn.User.remove', 'btn.User.remove', 2, 1, '2023-05-31 18:05:37', '2023-06-01 08:34:38', 0),
       (10, 4, '修改', 'btn.Role.update', 'btn.Role.update', 2, 1, '2023-05-31 18:05:37', '2023-06-01 08:36:20', 0),
       (11, 4, '分配权限', 'btn.Role.assgin', 'RoleAuth', 2, 1, '2023-05-31 18:05:37', '2023-06-01 08:36:56', 0),
       (12, 4, '添加', 'btn.Role.add', 'btn.Role.add', 2, 1, '2023-05-31 18:05:37', '2023-06-01 08:36:08', 0),
       (13, 4, '删除', 'btn.Role.remove', 'btn.Role.remove', 2, 1, '2023-05-31 18:05:37', '2023-06-01 08:36:32', 0),
       (14, 4, '角色权限', 'role.acl', 'role.acl', 2, 1, '2023-05-31 18:05:37', '2023-06-01 08:37:22', 0),
       (15, 5, '查看', 'btn.permission.list', 'btn.permission.list', 2, 1, '2023-05-31 18:05:37',
        '2023-05-31 19:32:52', 0),
       (16, 5, '添加', 'btn.Permission.add', 'btn.Permission.add', 2, 1, '2023-05-31 18:05:37',
        '2023-06-01 08:37:39', 0),
       (17, 5, '修改', 'btn.Permission.update', 'btn.Permission.update', 2, 1, '2023-05-31 18:05:37',
        '2023-06-01 08:37:47', 0),
       (18, 5, '删除', 'btn.Permission.remove', 'btn.Permission.remove', 2, 1, '2023-05-31 18:05:37',
        '2023-06-01 08:37:54', 0),
       (19, 1, '订单管理', 'Order', 'Order', 1, 1, '2023-06-18 16:38:51', '2023-06-18 16:48:22', 0),
       (20, 19, '订单列表', 'OrderInfo', 'OrderInfo', 1, 1, '2023-06-18 16:39:21', '2023-06-18 16:42:36', 0),
       (23, 1, '点播管理', 'Vod', 'Vod', 1, 1, '2023-06-18 16:45:55', '2023-11-19 11:39:47', 0),
       (24, 23, '课程分类管理', 'Subject', 'Subject', 1, 1, '2023-06-18 16:46:44', '2023-11-19 11:40:12', 0),
       (25, 23, '教师列表', 'TeacherList', 'TeacherList', 1, 1, '2023-06-18 16:48:01', '2023-12-01 06:06:50', 0),
       (26, 23, '课程列表', 'CourseList', 'CourseList', 1, 1, '2023-06-18 16:50:11', '2023-12-01 06:08:49', 0),
       (27, 25, '添加教师', 'AddTeacher', 'TeacherCreate', 2, 1, '2023-06-18 16:52:12', '2023-12-01 06:11:18', 0),
       (28, 25, '编辑教师', 'EditorTeacher', 'TeacherEdit', 2, 1, '2023-06-18 16:53:04', '2023-12-01 06:09:34', 0),
       (29, 26, '发布课程', 'PublishCourse', 'CourseInfo', 2, 1, '2023-06-18 16:53:22', '2023-12-01 06:10:13', 0),
       (30, 26, '编辑课程', 'EditCourse', 'CourseInfoEdit', 2, 1, '2023-06-18 16:54:34', '2023-12-01 06:10:35', 0),
       (31, 26, '编辑大纲', 'EditOutline', 'CourseChapterEdit', 2, 1, '2023-06-18 16:56:42', '2023-12-01 06:10:50',
        0),
       (32, 26, '课程统计', 'CourseStatistics', 'CourseChart', 2, 1, '2023-06-18 16:56:57', '2023-12-01 06:11:01',
        0),
       (36, 1, '营销活动管理', 'Activity', 'Activity', 1, 1, '2023-06-18 17:04:15', '2023-06-18 17:04:15', 0),
       (40, 36, '优惠券列表', 'CouponInfo', 'CouponInfo', 1, 1, '2023-06-18 17:06:41', '2023-06-18 17:07:18', 0),
       (41, 40, '添加', 'Add', 'CouponInfoAdd', 2, 1, '2023-06-18 17:06:57', '2023-06-18 17:07:22', 0),
       (42, 40, '修改', 'Modify', 'CouponInfoEdit', 2, 1, '2023-06-18 17:07:11', '2023-06-18 17:07:25', 0),
       (43, 40, '详情', 'Details', 'CouponInfoShow', 2, 1, '2023-06-18 17:07:49', '2023-12-01 06:12:31', 0),
       (45, 1, '直播管理', 'Live', 'Live', 1, 1, '2023-06-18 17:08:44', '2023-12-01 06:13:25', 0),
       (46, 45, '直播列表', 'liveCourseList', 'liveCourseList', 1, 1, '2023-06-18 17:09:23', '2023-12-01 06:13:50',
        0),
       (47, 45, '直播配置', 'LiveStreamingConfiguration', 'liveCourseConfig', 2, 1, '2023-06-18 17:09:28',
        '2023-12-01 06:14:21', 0),
       (48, 45, '观看记录', 'ViewingRecords', 'liveVisitor', 2, 1, '2023-06-18 17:09:43', '2023-12-01 06:14:29', 0),
       (49, 1, '菜单管理', 'Wechat', 'Wechat', 1, 1, '2023-06-18 17:15:44', '2023-12-01 06:14:50', 0),
       (50, 49, '菜单列表', 'Menu', 'Menu', 1, 1, '2023-06-18 17:16:02', '2023-12-01 06:14:57', 0),
       (51, 1, '全部', 'btn.all', 'btn.all', 2, 1, '2023-09-27 13:35:24', '2023-09-27 13:40:09', 0);

# 删除角色表 role
DROP TABLE IF EXISTS `role`;

# 创建角色表 role
CREATE TABLE `role`
(
    `id`          BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `role_name`   VARCHAR(20) NOT NULL DEFAULT '' COMMENT '角色名称',
    `role_code`   VARCHAR(20)          DEFAULT NULL COMMENT '角色编码',
    `remark`      VARCHAR(255)         DEFAULT NULL COMMENT '备注',
    `create_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3)  NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8 COMMENT ='角色';

# 添加角色表 role 的数据
INSERT INTO `role`(`id`, `role_name`, `role_code`, `remark`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, '系统管理员', 'SYSTEM', NULL, '2023-05-31 18:09:18', '2023-05-31 18:09:18', 0),
       (2, '平台管理员', NULL, NULL, '2023-06-01 08:38:40', '2023-06-18 17:13:17', 0),
       (3, '运营管理员', NULL, NULL, '2023-06-18 17:12:21', '2023-12-01 06:21:14', 0),
       (4, '游客', NULL, NULL, '2023-09-27 09:37:13', '2023-09-27 09:37:13', 0);

# 删除角色权限表 role_permission
DROP TABLE IF EXISTS `role_permission`;

# 创建角色权限表 role_permission
CREATE TABLE `role_permission`
(
    `id`            BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `role_id`       BIGINT(20) NOT NULL DEFAULT '0' COMMENT '角色ID',
    `permission_id` BIGINT(11) NOT NULL DEFAULT '0' COMMENT '权限ID',
    `create_time`   TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`    TINYINT(3) NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    KEY `idx_role_id` (`role_id`),
    KEY `idx_permission_id` (`permission_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 44
  DEFAULT CHARSET = utf8 COMMENT ='角色权限';

# 添加角色权限表 role_permission 的数据
INSERT INTO `role_permission`(`id`, `role_id`, `permission_id`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, 1, '2023-12-01 06:25:27', '2023-12-01 06:25:27', 0),
       (2, 2, 2, '2023-12-01 06:25:27', '2023-12-01 06:25:27', 0),
       (3, 3, 26, '2023-12-01 06:25:27', '2023-12-01 06:25:27', 0);

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
