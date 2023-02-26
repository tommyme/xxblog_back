/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 21/02/2023 19:40:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章标题',
  `class_id` bigint NOT NULL COMMENT '文章分类',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章内容',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (2, 'java', 3, '<h1>example</h1>', 'f\'f\'f', '2023-02-21 16:01:14', '2023-02-21 16:01:28');
INSERT INTO `article` VALUES (3, 'python的基础语法', 3, '<h2>第一个 Python 程序</h2><h3>交互式编程</h3><p>交互式编程不需要创建脚本文件，是通过 Python 解释器的交互模式进来编写代码。</p><p>linux上你只需要在命令行中输入 Python 命令即可启动交互式编程,提示窗口如下：</p><p>$ python</p><p>Python 2.7.6&nbsp;<span style=\"color: olive;\">(</span>default<span style=\"color: gray;\">,</span>&nbsp;Sep&nbsp;<span style=\"color: maroon;\">9</span>&nbsp;<span style=\"color: maroon;\">2014</span><span style=\"color: gray;\">,</span>&nbsp;<span style=\"color: maroon;\">15</span>:<span style=\"color: maroon;\">04</span>:<span style=\"color: maroon;\">36</span><span style=\"color: olive;\">)</span></p><p><span style=\"color: olive;\">[</span>GCC 4.2.1 Compatible Apple LLVM&nbsp;<span style=\"color: maroon;\">6.0</span>&nbsp;<span style=\"color: olive;\">(</span>clang-600.0.39<span style=\"color: olive;\">)]</span>&nbsp;on darwin</p><p>Type&nbsp;<span style=\"color: rgb(170, 17, 17);\">\"help\"</span><span style=\"color: gray;\">,</span>&nbsp;<span style=\"color: rgb(170, 17, 17);\">\"copyright\"</span><span style=\"color: gray;\">,</span>&nbsp;<span style=\"color: rgb(170, 17, 17);\">\"credits\"</span>&nbsp;<strong style=\"color: green;\">or</strong>&nbsp;<span style=\"color: rgb(170, 17, 17);\">\"license\"</span>&nbsp;<strong style=\"color: green;\">for</strong>&nbsp;more information.</p><p><span style=\"color: gray;\">&gt;&gt;&gt;</span></p><h1>Window 上在安装 Python 时已经安装了交互式编程客户端，提示窗口如下：</h1>', '对python基础语法的介绍', '2023-02-21 19:38:35', '2023-02-21 19:38:35');

-- ----------------------------
-- Table structure for article_class
-- ----------------------------
DROP TABLE IF EXISTS `article_class`;
CREATE TABLE `article_class`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文章分类名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_class
-- ----------------------------
INSERT INTO `article_class` VALUES (3, 'python');
INSERT INTO `article_class` VALUES (4, 'java');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `article_id` bigint NOT NULL COMMENT '文章id',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父评论id，如果为空则表示该评论是一级评论',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论内容',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论人用户名',
  `create_time` datetime NOT NULL COMMENT '评论创建时间',
  `is_show` tinyint NOT NULL COMMENT '是否显示',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_article_id`(`article_id` ASC) USING BTREE,
  INDEX `idx_parent_id`(`parent_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (2, 2, NULL, '好好好', 'kkkk', '2023-02-21 19:32:41', 1);
INSERT INTO `comment` VALUES (3, 2, NULL, '差差差', 'kk', '2023-02-21 19:34:56', 1);
INSERT INTO `comment` VALUES (4, 2, NULL, '好好好', 'hhh', '2023-02-21 19:36:32', 1);
INSERT INTO `comment` VALUES (5, 2, NULL, '好好好', 'ggg', '2023-02-21 19:37:01', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '12345678');

SET FOREIGN_KEY_CHECKS = 1;
