# MySQL - 8.0.31
# Database - smart_planet_vod


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = ''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

# 创建智慧星球视频点播数据库 smart_planet_vod
CREATE DATABASE /*!32312 IF NOT EXISTS */ `smart_planet_vod` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

# 选择智慧星球视频点播数据库 smart_planet_vod
USE `smart_planet_vod`;

# 删除章节表 chapter
DROP TABLE IF EXISTS `chapter`;

# 创建章节表 chapter
CREATE TABLE `chapter`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `course_id`   BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '课程ID',
    `title`       VARCHAR(50)         NOT NULL COMMENT '章节名称',
    `sort`        INT(10) UNSIGNED    NOT NULL DEFAULT '0' COMMENT '显示排序',
    `create_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    KEY `idx_course_id` (`course_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 67
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='章节';

# 添加章节表 chapter 的数据
INSERT INTO `chapter`(`id`, `course_id`, `title`, `sort`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 11, '第一章：Java入门', 1, '2023-11-05 03:05:51', '2023-12-01 05:48:44', 0),
       (2, 2, 'Java基础课程：第一章', 1, '2023-11-05 03:05:51', '2023-11-05 03:38:14', 0),
       (3, 2, 'Java基础课程：第二章', 2, '2023-11-05 03:05:51', '2023-11-05 03:38:24', 0),
       (4, 2, 'Java基础课程：第三章', 3, '2023-11-05 03:05:51', '2023-11-05 03:38:34', 0),
       (5, 14, '第一章：HTML', 1, '2023-11-05 03:05:51', '2023-11-05 03:05:51', 0),
       (6, 14, '第二章：CSS', 2, '2023-11-05 03:05:51', '2023-11-05 03:05:51', 0),
       (7, 5, '大数据技术之Kafka：第一章', 1, '2023-11-05 03:05:51', '2023-11-05 03:38:50', 0),
       (8, 5, '大数据技术之Kafka：第二章', 2, '2023-11-05 03:05:51', '2023-11-05 03:39:03', 0),
       (9, 6, '第一章：数据仓库基础', 1, '2023-11-05 03:05:51', '2023-11-05 03:39:14', 0),
       (10, 7, '第一章：课程基础', 1, '2023-11-05 03:05:51', '2023-11-05 03:39:26', 0),
       (11, 8, '第一章：介绍及原理', 1, '2023-11-05 03:05:51', '2023-11-05 03:39:38', 0),
       (12, 1, '第一章：Spark介绍', 1, '2023-11-05 03:05:51', '2023-11-05 03:39:50', 0),
       (13, 18, '第一章：Java入门', 1, '2023-11-05 03:05:51', '2023-12-01 05:48:35', 0),
       (14, 18, '第二章：控制台输入和输出', 2, '2023-11-05 03:05:51', '2023-12-01 05:48:36', 0),
       (15, 18, '第三章：控制流', 3, '2023-11-05 03:05:51', '2023-12-01 05:48:36', 0),
       (16, 18, '第四章：类的定义', 4, '2023-11-05 03:05:51', '2023-12-01 05:48:38', 0),
       (17, 18, '第五章：数组', 5, '2023-11-05 03:05:51', '2023-12-01 05:48:41', 0),
       (18, 18, '第六章：继承', 6, '2023-11-05 03:05:51', '2023-12-01 05:48:42', 0),
       (19, 13, 'Java 基础 第1阶段：基本语法', 1, '2023-10-10 15:04:00', '2023-10-10 15:14:54', 0),
       (20, 13, 'Java 基础 第2阶段：面向对象编程', 2, '2023-10-10 15:04:27', '2023-10-10 15:14:54', 0),
       (21, 13, 'Java 基础 第3阶段：高级应用', 3, '2023-10-10 15:04:51', '2023-10-10 15:14:54', 0);


# 删除评论表 comment
DROP TABLE IF EXISTS `comment`;

# 创建评论表 comment
CREATE TABLE `comment`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `course_id`   BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '课程ID',
    `teacher_id`  BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '教师ID',
    `user_id`     BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '会员ID',
    `nickname`    VARCHAR(50)                  DEFAULT NULL COMMENT '会员昵称',
    `avatar`      VARCHAR(255)                 DEFAULT NULL COMMENT '会员头像',
    `content`     VARCHAR(500)                 DEFAULT NULL COMMENT '评论内容',
    `create_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    KEY `idx_course_id` (`course_id`),
    KEY `idx_teacher_id` (`teacher_id`),
    KEY `idx_member_id` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='评论';

# 删除课程表 course
DROP TABLE IF EXISTS `course`;

# 创建课程表 course
CREATE TABLE `course`
(
    `id`                BIGINT(20) UNSIGNED             NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `teacher_id`        BIGINT(20)                      NOT NULL DEFAULT '0' COMMENT '课程教师ID',
    `subject_id`        BIGINT(20)                      NOT NULL DEFAULT '0' COMMENT '课程专业ID',
    `subject_parent_id` BIGINT(20)                      NOT NULL DEFAULT '0' COMMENT '课程专业父级ID',
    `title`             VARCHAR(50)                     NOT NULL COMMENT '课程标题',
    `price`             DECIMAL(10, 2) UNSIGNED         NOT NULL DEFAULT '0.00' COMMENT '课程销售价格，设置为0则可免费观看',
    `lesson_num`        INT(10) UNSIGNED                NOT NULL DEFAULT '0' COMMENT '总课时',
    `duration_sum`      INT(11)                         NOT NULL DEFAULT '0' COMMENT '视频总时长（秒）',
    `cover`             VARCHAR(255) CHARACTER SET utf8 NOT NULL COMMENT '课程封面图片路径',
    `buy_count`         BIGINT(10) UNSIGNED             NOT NULL DEFAULT '0' COMMENT '销售数量',
    `view_count`        BIGINT(10) UNSIGNED             NOT NULL DEFAULT '0' COMMENT '浏览数量',
    `status`            TINYINT(3)                      NOT NULL DEFAULT '0' COMMENT '课程状态：0未发布，1已发布',
    `publish_time`      DATETIME                                 DEFAULT NULL COMMENT '课程发布时间',
    `create_time`       TIMESTAMP                       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`       TIMESTAMP                       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`        TINYINT(3)                      NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    KEY `idx_title` (`title`),
    KEY `idx_subject_id` (`subject_id`),
    KEY `idx_teacher_id` (`teacher_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 20
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='课程';

# 添加课程表 course 的数据
INSERT INTO `course`(`id`, `teacher_id`, `subject_id`, `subject_parent_id`, `title`, `price`, `lesson_num`,
                     `duration_sum`, `cover`, `buy_count`, `view_count`, `status`, `publish_time`, `create_time`,
                     `update_time`, `is_deleted`)
VALUES (1, 1, 15, 13, '大数据技术之Spark', '21800.00', 27, 100000,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        1679, 34634, 1, '2023-11-05 11:30:14', '2023-11-05 03:05:16', '2023-11-24 06:37:39', 0),
       (2, 1, 2, 1, 'Java基础课程', '0.00', 27, 100000,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        5999, 10048, 1, '2023-11-05 03:05:16', '2023-11-05 03:05:16', '2023-11-24 06:37:37', 0),
       (3, 1, 14, 13, '大数据技术之Flume（2023新版）', '20800.00', 27, 100000,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        4234, 23780, 1, '2023-11-05 03:05:16', '2023-11-05 03:05:16', '2023-11-24 06:37:36', 0),
       (4, 2, 14, 13, '大数据技术之HBase（2023新版）', '19800.00', 27, 100000,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        6675, 90383, 1, '2023-11-05 03:05:16', '2023-11-05 03:05:16', '2023-11-24 06:37:34', 0),
       (5, 1, 14, 13, '大数据技术之Kafka（2023新版）', '22800.00', 27, 100000,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        2349, 13546, 1, '2023-11-05 03:05:16', '2023-11-05 03:05:16', '2023-11-24 06:37:33', 0),
       (6, 2, 15, 13, '大数据项目之电商数仓', '21800.00', 27, 100000,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        898, 8977, 1, '2023-11-05 03:05:16', '2023-11-05 03:05:16', '2023-11-24 06:37:32', 0),
       (7, 2, 15, 13, '大数据技术之Sqoop', '23800.00', 27, 100000,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        1286, 45695, 1, '2023-11-05 03:05:16', '2023-11-05 03:05:16', '2023-11-24 06:37:31', 0),
       (8, 1, 14, 13, 'Scala入门到精通（2023新版）', '0.00', 27, 100000,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        900, 15496, 1, '2023-11-05 03:05:16', '2023-11-05 03:05:16', '2023-11-24 06:37:13', 0),
       (9, 1, 19, 16, 'HTML CSS JavaScript教程', '0.00', 27, 100000,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        3452, 21010, 1, '2023-11-05 03:05:16', '2023-11-05 03:05:16', '2023-11-24 06:37:28', 0),
       (10, 2, 2, 1, 'Spring MVC讲解', '22800.00', 27, 100000,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        892, 9107, 1, '2023-11-05 03:05:16', '2023-11-05 03:05:16', '2023-11-24 06:37:24', 0),
       (11, 2, 2, 1, 'Java精品课程', '0.00', 27, 100000,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png',
        6784, 67629, 1, '2023-11-19 14:16:19', '2023-11-05 03:05:16', '2023-11-24 06:37:25', 0),
       (12, 1, 11, 10, 'MySQL基础', '1000.00', 27, 100201,
        'https://img-blog.csdnimg.cn/b9f45932f6cf471aa53ee24e5555d9c2.png', 0, 155, 1, '2023-11-25 09:57:42',
        '2023-11-22 11:09:22', '2023-11-25 10:57:39', 0),
       (13, 6, 2, 1, 'Java 零基础入门', '9.90', 24, 0,
        'https://smart-planet-1315007088.cos.ap-beijing.myqcloud.com/ProductionCOS/image/2023/10/08/7a890a1382f54e569b9ab742f07de1e8Java 零基础入门.png',
        0, 0, 1, '2023-10-10 15:08:00',
        '2023-10-08 17:03:07', '2023-10-08 17:03:07', 0);

# 删除课程收藏表 course_collect
DROP TABLE IF EXISTS `course_collect`;

# 创建课程收藏表 course_collect
CREATE TABLE `course_collect`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `course_id`   BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '课程教师ID',
    `user_id`     BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '会员ID',
    `create_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='课程收藏';


# 删除课程简介表 course_description
DROP TABLE IF EXISTS `course_description`;

# 创建课程简介表 course_description
CREATE TABLE `course_description`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `course_id`   BIGINT(20)                   DEFAULT NULL COMMENT '课程ID',
    `description` TEXT COMMENT '课程简介',
    `create_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8mb4 COMMENT ='课程简介';

# 添加课程简介表 course_description 的数据
INSERT INTO `course_description`(`id`, `course_id`, `description`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, '大数据技术之Spark', '2023-11-05 03:42:01', '2023-11-08 11:25:30', 0),
       (2, 2,
        '本套Java视频完全针对零基础学生，课堂实录，自发布以来，好评如潮！Java视频中注重与学生互动，讲授幽默诙谐、细致入微，覆盖Java基础所有核心知识点，同类Java视频中也是代码量大、案例多、实战性强的。但是，本Java视频教程注重技术原理剖析，深入JDK源码，辅以代码实战贯穿始终，用实践驱动理论，并辅以必要的代码练习。视频特点：通过学习本Java视频教程，大家能够真正将Java基础知识学以致用、活学活用，构架Java编程思想，牢牢掌握”源码级“的Java SE核心技术，并为后续JavaWeb等技术的学习奠定扎实基础。1. 通俗易懂，细致入微：每个知识点高屋建瓴，深入浅出，简洁明了的说明问题。2. 具实战性：全程真正代码实战，涵盖上百个企业应用案例及练习。3. 深入：源码分析，更有 Java 反射、动态代理的实际应用等。4. 登录智慧星球官网，技术教师免费在线答疑。',
        '2023-11-05 03:42:01', '2023-11-08 11:25:30', 0),
       (3, 3, '大数据技术之Flume（2023新版）', '2023-11-05 03:42:01', '2023-11-08 11:25:30', 0),
       (4, 4, '大数据技术之HBase（2023新版）', '2023-11-05 03:42:01', '2023-11-08 11:25:30', 0),
       (5, 5, '大数据技术之Kafka（2023新版）', '2023-11-05 03:42:01', '2023-11-08 11:25:30', 0),
       (6, 6, '大数据项目之电商数仓', '2023-11-05 03:42:01', '2023-11-08 11:25:30', 0),
       (7, 7, '大数据技术之Sqoop', '2023-11-05 03:42:01', '2023-11-08 11:25:30', 0),
       (8, 8, 'Scala入门到精通（2023新版）', '2023-11-05 03:42:01', '2023-11-08 11:25:30', 0),
       (9, 9, 'HTML CSS JavaScript教程', '2023-11-05 03:42:01', '2023-11-08 11:25:30', 0),
       (10, 10, 'Spring MVC讲解', '2023-11-05 03:42:01', '2023-11-08 11:25:30', 0),
       (11, 11, 'Java精品课程', '2023-11-05 03:42:01', '2023-11-08 11:25:30', 0),
       (12, 12,
        '数据库就像一棵常青的技能树，无论是初级程序员还是CTO、首席架构师都能从中汲取足够的技术养料。菜鸟往往积累单点技术，如 DML、DDL、存储过程和函数、约束、索引的数据结构，大佬则需要吃透底层原理，数据库事务ACID如何实现？锁机制与MVCC又是怎么回事？分布式场景下数据库怎么优化保持高性能？知道怎么用是一方面，知道为什么则是更为稀缺的能力。程序员核心能力中至关重要的一点：精通数据库。精通意味着：第一，形成知识网，更灵活地应对突发问题；第二，懂底层原理，更自由地应对复杂多变的业务场景。',
        '2023-11-22 11:09:22', '2023-11-22 11:09:22', 0),
       (13, 13, 'Java 零基础 24 小时快速入门！', '2023-10-08 17:03:07', '2023-10-08 17:03:07', 0);

# 删除课程科目表 subject
DROP TABLE IF EXISTS `subject`;

# 创建课程科目表 subject
CREATE TABLE `subject`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL DEFAULT '0' COMMENT '主键ID',
    `title`       VARCHAR(10)         NOT NULL COMMENT '类别名称',
    `parent_id`   BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '父ID',
    `sort`        INT(10) UNSIGNED    NOT NULL DEFAULT '0' COMMENT '排序字段',
    `create_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='课程科目';

# 添加课程科目表 subject 的数据
INSERT INTO `subject`(`id`, `title`, `parent_id`, `sort`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, '后端开发', 0, 1, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (2, 'Java', 1, 1, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (3, '前端开发', 0, 2, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (4, 'JavaScript', 3, 1, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (5, '云计算', 0, 3, '2023-09-29 15:47:25', '2023-11-12 07:13:22', 0),
       (6, 'Docker', 5, 1, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (7, '运维', 0, 4, '2023-09-29 15:47:25', '2023-11-12 07:12:54', 0),
       (8, 'Linux', 7, 1, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (9, 'Windows', 7, 2, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (10, '数据库', 0, 5, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (11, 'MySQL', 10, 1, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (12, 'MongoDB', 10, 2, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (13, '大数据', 0, 6, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (14, 'Hadoop', 13, 1, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (15, 'Spark', 13, 2, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (16, '编程语言', 0, 7, '2023-09-29 15:47:25', '2023-11-12 03:29:04', 0),
       (17, 'Java', 16, 1, '2023-09-29 15:47:25', '2023-09-29 15:47:25', 0),
       (18, 'Python', 16, 2, '2023-09-30 16:19:22', '2023-09-30 16:19:22', 0),
       (19, 'HTML/CSS', 16, 3, '2023-09-30 16:19:22', '2023-09-30 16:19:22', 0),
       (20, '人工智能', 0, 8, '2023-10-06 21:11:09', '2023-10-06 21:11:09', 0),
       (21, '机器学习', 20, 1, '2023-10-06 21:11:09', '2023-10-06 21:11:09', 0);


# 删除教师表 teacher
DROP TABLE IF EXISTS `teacher`;

# 创建教师表 teacher
CREATE TABLE `teacher`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name`        VARCHAR(20)         NOT NULL COMMENT '教师姓名',
    `intro`       VARCHAR(500)        NOT NULL DEFAULT '' COMMENT '教师简介',
    `career`      VARCHAR(500)                 DEFAULT NULL COMMENT '教师资历，一句话说明教师',
    `level`       INT(10) UNSIGNED    NOT NULL COMMENT '头衔：1高级教师，2首席教师',
    `avatar`      VARCHAR(255)                 DEFAULT NULL COMMENT '教师头像',
    `sort`        INT(10) UNSIGNED    NOT NULL DEFAULT '0' COMMENT '排序',
    `join_date`   DATE                         DEFAULT NULL COMMENT '入驻时间',
    `create_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_name` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8mb4 COMMENT ='教师';

# 添加教师表 teacher 的数据
INSERT INTO `teacher`(`id`, `name`, `intro`, `career`, `level`, `avatar`, `sort`, `join_date`, `create_time`,
                      `update_time`, `is_deleted`)
VALUES (1, '张老师', '高级教师', '高级教师', 1,
        'https://img-blog.csdnimg.cn/cd8f70622395464da62c8a41e4e9256f.png',
        1, '2023-11-08', '2023-11-05 03:18:36', '2023-11-08 01:50:46', 0),
       (2, '李老师', '高级教师', '高级教师', 1,
        'https://img-blog.csdnimg.cn/cd8f70622395464da62c8a41e4e9256f.png',
        2, '2023-11-08', '2023-11-05 03:18:51', '2023-11-08 01:50:49', 0),
       (3, '王老师', '高级教师', '高级教师', 1,
        'https://img-blog.csdnimg.cn/cd8f70622395464da62c8a41e4e9256f.png',
        3, '2023-11-08', '2023-11-08 05:51:21', '2023-11-08 06:24:28', 0),
       (4, '赵老师', '高级教师', '高级教师', 1,
        'https://img-blog.csdnimg.cn/cd8f70622395464da62c8a41e4e9256f.png',
        4, '2023-11-23', '2023-11-22 13:26:58', '2023-11-23 10:26:54', 0),
       (5, '孙老师', '高级教师', '高级教师', 1,
        'https://img-blog.csdnimg.cn/cd8f70622395464da62c8a41e4e9256f.png',
        5, '2023-11-23', '2023-11-23 10:25:58', '2023-11-23 10:26:53', 0),
       (6, '邓老师', '邓老师', '首席教师', 0,
        'https://smart-planet-1315007088.cos.ap-beijing.myqcloud.com/ProductionCOS/image/2023/10/06/5958cd8c70234037aadb235e1e8e2c3a大户爱.png',
        6, '2023-10-06', '2023-10-06 16:02:53', '2023-10-06 16:05:09', 0);

# 删除课程视频表 video
DROP TABLE IF EXISTS `video`;

# 创建课程视频表 video
CREATE TABLE `video`
(
    `id`                  BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `course_id`           BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '课程ID',
    `chapter_id`          BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '章节ID',
    `title`               VARCHAR(50)         NOT NULL COMMENT '节点名称',
    `video_source_id`     VARCHAR(100)                 DEFAULT NULL COMMENT '云端视频资源',
    `video_original_name` VARCHAR(100)                 DEFAULT NULL COMMENT '原始文件名称',
    `sort`                INT(10) UNSIGNED    NOT NULL DEFAULT '0' COMMENT '排序字段',
    `play_count`          BIGINT(20) UNSIGNED NOT NULL DEFAULT '0' COMMENT '播放次数',
    `is_free`             TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否可以试听：0收费，1免费',
    `duration`            FLOAT               NOT NULL DEFAULT '0' COMMENT '视频时长（秒）',
    `size`                BIGINT(20) UNSIGNED NOT NULL DEFAULT '0' COMMENT '视频源文件大小（字节）',
    `version`             BIGINT(20) UNSIGNED NOT NULL DEFAULT '1' COMMENT '乐观锁',
    `status`              TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '课程状态：0未发布，1已发布',
    `create_time`         TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`         TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`          TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`),
    KEY `idx_course_id` (`course_id`),
    KEY `idx_chapter_id` (`chapter_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 42
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='课程视频';

# 添加课程视频表 video 的数据
INSERT INTO `video`(`id`, `course_id`, `chapter_id`, `title`, `video_source_id`, `video_original_name`, `sort`,
                    `play_count`, `is_free`, `duration`, `size`, `version`, `status`, `create_time`, `update_time`,
                    `is_deleted`)
VALUES (1, 2, 2, 'Java基础课程：第一课时', '1796645922420424025', 'Java基础课程：第一课时.mp4', 1, 0, 0,
        7200, 4294967296,
        1, 0, '2023-11-05 03:06:04', '2023-12-03 10:17:58', 0),
       (2, 2, 2, 'Java基础课程：第二课时', '1796645922420424025', 'Java基础课程：第二课时.mp4', 2, 0, 0,
        7200, 4294967296,
        1, 0, '2023-11-05 03:06:04', '2023-12-03 10:17:57', 0),
       (3, 2, 2, 'Java基础课程：第三课时', '1796645922420424025', 'Java基础课程：第三课时.mp4', 3, 0, 0,
        7200, 4294967296,
        1, 0, '2023-11-05 03:06:04', '2023-12-03 10:18:20', 0),
       (4, 2, 2, 'Java基础课程：第四课时', '1796645922420424025', 'Java基础课程：第四课时.mp4', 4, 0, 0,
        7200, 4294967296,
        1, 0, '2023-11-05 03:06:04', '2023-12-03 10:18:20', 0),
       (5, 2, 2, 'Java基础课程：第五课时', '1796645922420424025', 'Java基础课程：第五课时.mp4', 5, 0, 0,
        3600, 2147483648,
        1, 0, '2023-11-05 03:06:04', '2023-12-03 10:18:19', 0),
       (6, 3, 3, '01-Flume-课程介绍', '1796645922420424025', '01-Flume-课程介绍.mp4', 1,
        0, 1, 3600, 2147483648, 1, 0, '2023-11-05 03:06:04', '2023-12-03 10:18:21', 0),
       (7, 3, 3, '02-Flume-概念', '1796645922420424025', '02-Flume-概念.mp4', 2, 0, 0, 3600,
        2147483648, 1, 1, '2023-11-05 03:06:04', '2023-12-03 10:18:21', 0),
       (8, 3, 3, '03-Flume-概念', '1796645922420424025', '03-Flume-架构.mp4', 3, 0, 0, 3600,
        2147483648, 1, 1, '2023-11-05 03:06:04', '2023-12-03 10:18:22', 0),
       (9, 4, 4, '01-HBase-课程介绍', '1796645922420424025', '01-HBase-课程介绍.mp4', 1, 0, 1, 3600,
        2147483648, 1, 1,
        '2023-11-05 03:06:04', '2023-12-03 10:18:23', 0),
       (10, 4, 4, '02-HBase-介绍', '1796645922420424025', '02-HBase-介绍.mp4', 2, 0, 0, 3600, 2147483648,
        1, 0,
        '2023-11-05 03:06:04', '2023-12-03 10:18:23', 0),
       (11, 4, 4, '03-HBase-特点', '1796645922420424025', '03-HBase-特点.mp4', 3, 0, 0, 3600, 2147483648,
        1, 0,
        '2023-11-05 03:06:04', '2023-12-03 10:18:24', 0),
       (12, 5, 7, '01-Kafka-课程介绍', '1796645922420424025', '01-Kafka-课程介绍.mp4', 1, 0, 1, 3600,
        2147483648, 1, 1,
        '2023-11-05 03:06:04', '2023-12-03 10:18:16', 0),
       (13, 5, 7, '02-Kafka-消息队列介绍', '1796645922420424025', '02-Kafka-消息队列介绍.mp4', 2, 0, 0,
        3600, 2147483648, 1, 0,
        '2023-11-05 03:06:04', '2023-12-03 10:18:15', 0),
       (14, 5, 7, '03-Kafka-概念', '1796645922420424025', '03-Kafka-概念.mp4', 3, 0, 0, 3600, 2147483648,
        1, 0,
        '2023-11-05 03:06:04', '2023-12-03 10:18:14', 0),
       (15, 6, 9, '01-数仓项目-课程介绍', '1796645922420424025', '01-数仓项目-课程介绍.mp4', 1, 0, 0, 3600,
        2147483648, 1, 1,
        '2023-11-05 03:06:04', '2023-12-03 10:18:12', 0),
       (16, 6, 9, '02-数仓项目-采集课程介绍', '1796645922420424025', '02-数仓项目-采集课程介绍.mp4', 2, 0,
        1, 7200, 4294967296, 1, 1,
        '2023-11-05 03:06:04', '2023-12-03 10:18:12', 0),
       (17, 6, 9, '03-数仓项目-数仓概念-业务数据', '1796645922420424025',
        '03-数仓项目-数仓概念-业务数据.mp4', 3, 0, 0, 7200, 4294967296, 1, 1,
        '2023-11-05 03:06:04', '2023-12-03 10:18:11', 0),
       (18, 7, 10, '01-Sqoop-课程介绍', '1796645922420424025', '01-Sqoop-课程介绍.mp4', 1, 0, 0, 7200,
        4294967296, 1, 1,
        '2023-11-05 03:06:04', '2023-12-03 10:18:10', 0),
       (19, 7, 10, '02-Sqoop-安装', '1796645922420424025', '02-Sqoop-安装.mp4', 2, 0, 1, 7200, 4294967296,
        1, 0,
        '2023-11-05 03:06:04', '2023-12-03 10:18:10', 0),
       (20, 7, 10, '03-Sqoop-原理', '1796645922420424025', '03-Sqoop-原理.mp4', 3, 0, 1, 7200, 4294967296,
        1, 0,
        '2023-11-05 03:06:04', '2023-12-03 10:18:09', 0),
       (21, 8, 11, '01-Scala-语言介绍', '1796645922420424025', '01-Scala-语言介绍.mp4', 1, 0, 1, 7200,
        4294967296, 1, 1,
        '2023-11-05 03:06:04', '2023-12-03 10:18:09', 0),
       (22, 8, 11, '02-Scala-map集合', '1796645922420424025', '02-Scala-map集合.mp4', 2, 0, 0, 7200,
        4294967296, 1, 1,
        '2023-11-05 03:06:04', '2023-12-03 10:18:08', 0),
       (23, 1, 12, '01-Spark之课程体系介绍', '1796645922420424025', '01-Spark之课程体系介绍.mp4', 1, 0, 1,
        7200, 4294967296, 1, 1,
        '2023-11-05 03:06:04', '2023-12-03 10:18:08', 0),
       (24, 1, 12, '02-Spark之课程原理', '1796645922420424025', '02-Spark之课程原理.mp4', 2, 0, 0, 7200,
        4294967296, 1, 1,
        '2023-11-05 03:06:04', '2023-12-03 10:18:07', 0),
       (25, 13, 19, '第 1 章 Java 语言概述', '5576678022420424355', 'Java 零基础入门.mp4', 1, 0, 1, 0, 0, 1, 0,
        '2023-10-10 15:05:53',
        '2023-10-10 15:15:26', 0),
       (26, 13, 20, '第 6 章 面向对象——基础', null, null, 1, 0, 0, 0, 0, 1, 0, '2023-10-10 15:06:36',
        '2023-10-10 15:15:26', 0),
       (27, 13, 21, '第 9 章 异常处理', null, null, 1, 0, 0, 0, 0, 1, 0, '2023-10-10 15:07:19', '2023-10-10 15:15:26',
        0);

# 删除视频来访者记录表 video_visitor
DROP TABLE IF EXISTS `video_visitor`;

# 创建视频来访者记录表 video_visitor
CREATE TABLE `video_visitor`
(
    `id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `course_id`   BIGINT(20)                   DEFAULT NULL COMMENT '课程ID',
    `video_id`    BIGINT(20)          NOT NULL DEFAULT '0' COMMENT '视频ID',
    `user_id`     VARCHAR(50)         NOT NULL DEFAULT '0' COMMENT '来访者用户ID',
    `nick_name`   VARCHAR(100)                 DEFAULT NULL COMMENT '昵称',
    `join_time`   VARCHAR(30)                  DEFAULT NULL COMMENT '进入的时间',
    `leave_time`  VARCHAR(30)                  DEFAULT NULL COMMENT '离开的时间',
    `duration`    BIGINT(20)                   DEFAULT NULL COMMENT '用户停留的时间(单位：秒)',
    `create_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  TINYINT(3)          NOT NULL DEFAULT '0' COMMENT '逻辑删除标志：0没有删除，1已经删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 24
  DEFAULT CHARSET = utf8mb4 COMMENT ='视频来访者记录';

# 添加视频来访者记录表 video_visitor 的数据
INSERT INTO `video_visitor`(`id`, `course_id`, `video_id`, `user_id`, `nick_name`, `join_time`, `leave_time`,
                            `duration`, `create_time`, `update_time`, `is_deleted`)
VALUES (1, 1, 23, '1', '末影小黑xh', '2023-11-22 21:39:27.089', '2023-11-22 21:39:31.089', 4, '2023-11-22 13:39:27',
        '2023-11-22 13:39:27', 0),
       (2, 2, 24, '1', '末影小黑xh', '2023-11-22 21:39:32.071', '2023-11-22 21:44:24.026', 696, '2023-11-22 13:39:32',
        '2023-11-25 02:12:41', 0),
       (3, 13, 25, '1', '末影小黑xh', '2023-10-01 18:09:46.899', '2023-11-23 18:10:13.004', 5, '2023-10-01 10:09:47',
        '2023-11-23 10:09:47', 0),
       (4, 13, 26, '24', '末影小黑xh', '2023-10-02 18:14:53.542', '2023-11-23 18:14:55.542', 2, '2023-10-02 10:14:53',
        '2023-11-23 10:14:53', 0),
       (5, 13, 27, '27', '末影小黑xh', '2023-10-03 18:54:29.848', '2023-11-23 18:54:34.864', 3, '2023-10-03 10:54:29',
        '2023-11-23 10:54:29', 0),
       (6, 13, 25, '1', '末影小黑xh', '2023-10-11 18:09:46.899', '2023-11-23 18:10:13.004', 5, '2023-10-11 10:09:47',
        '2023-11-23 10:09:47', 0),
       (7, 13, 26, '24', '末影小黑xh', '2023-10-12 18:14:53.542', '2023-11-23 18:14:55.542', 2, '2023-10-12 10:14:53',
        '2023-11-23 10:14:53', 0),
       (8, 13, 27, '27', '末影小黑xh', '2023-10-13 18:54:29.848', '2023-11-23 18:54:34.864', 3, '2023-10-13 10:54:29',
        '2023-11-23 10:54:29', 0),
       (9, 13, 25, '1', '末影小黑xh', '2023-10-11 18:09:46.899', '2023-11-23 18:10:13.004', 5, '2023-10-11 10:09:47',
        '2023-11-23 10:09:47', 0),
       (10, 13, 26, '24', '末影小黑xh', '2023-10-12 18:14:53.542', '2023-11-23 18:14:55.542', 2, '2023-10-12 10:14:53',
        '2023-11-23 10:14:53', 0),
       (11, 13, 27, '27', '末影小黑xh', '2023-10-13 18:54:29.848', '2023-11-23 18:54:34.864', 3, '2023-10-13 10:54:29',
        '2023-11-23 10:54:29', 0);

# 删除视频最大访问浏览量表 video_visitor_max_view
DROP TABLE IF EXISTS `video_visitor_max_view`;

/*!50001 DROP VIEW IF EXISTS `video_visitor_max_view` */;
/*!50001 DROP TABLE IF EXISTS `video_visitor_max_view` */;

# 创建视频最大访问浏览量表 video_visitor_max_view
/*!50001 CREATE TABLE `video_visitor_max_view`
(
    `max_id`    BIGINT(20) UNSIGNED COMMENT '最大访问浏览量ID',
    `course_id` BIGINT(20) COMMENT '课程ID',
    `video_id`  BIGINT(20) COMMENT '视频ID',
    `user_id`   VARCHAR(50) COMMENT '会员ID'
)*/;

# 删除视频最大访问浏览量视图 video_visitor_max_view
/*!50001 DROP TABLE IF EXISTS `video_visitor_max_view` */;
/*!50001 DROP VIEW IF EXISTS `video_visitor_max_view` */;

# 创建视频最大访问浏览量视图 video_visitor_max_view
    /*!50001 CREATE ALGORITHM = UNDEFINED DEFINER =`MYXH`@`%` SQL SECURITY DEFINER VIEW `video_visitor_max_view` AS
SELECT MAX(`video_visitor`.`id`)   AS `max_id`,
       `video_visitor`.`course_id` AS `course_id`,
       `video_visitor`.`video_id`  AS `video_id`,
       `video_visitor`.`user_id`   AS `user_id`
FROM `video_visitor`
GROUP BY `video_visitor`.`course_id`, `video_visitor`.`video_id`, `video_visitor`.`user_id`
        */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
