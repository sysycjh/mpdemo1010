/*
 Navicat Premium Data Transfer

 Source Server         : mysql数据库连接
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : mybatis-plus

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 13/10/2022 14:38:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本号（乐观锁）',
  `deleted` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (5, 'Billie', 24, 'test5@baomidou.com', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (6, 'lucy', 22, '123@qq.com', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (1580026132867371009, 'coco', 18, '456@qq.com', NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (1580038092270989314, 'mary', 18, 'mary@qq.com', '2022-10-12 11:30:11', '2022-10-12 11:30:11', NULL, 0);
INSERT INTO `user` VALUES (1580045547457499137, 'nancy', 99, 'nancy@qq.com', '2022-10-12 11:59:48', '2022-10-12 12:01:11', NULL, 0);
INSERT INTO `user` VALUES (1580089870152679425, 'niko', 33, 'niko@qq.com', '2022-10-12 14:55:56', '2022-10-12 15:02:32', 3, 0);
INSERT INTO `user` VALUES (1580385152333594626, 'neo', 30, 'neo@qq.com', '2022-10-13 10:29:17', '2022-10-13 10:29:17', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
