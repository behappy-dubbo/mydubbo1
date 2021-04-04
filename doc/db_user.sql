/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100137
 Source Host           : localhost:3306
 Source Schema         : db_user

 Target Server Type    : MySQL
 Target Server Version : 100137
 File Encoding         : 65001

 Date: 23/10/2020 13:18:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for u_base_info
-- ----------------------------
DROP TABLE IF EXISTS `u_base_info`;
CREATE TABLE `u_base_info`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT '主键',
  `user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `create_user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户-基础信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_base_info
-- ----------------------------
INSERT INTO `u_base_info` VALUES (1318522433099145218, '赵维永', '15995795525', NULL, NULL, '2020-10-20 12:00:20', NULL, NULL, '2020-10-20 12:00:20', 0);

SET FOREIGN_KEY_CHECKS = 1;
