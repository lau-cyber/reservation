/*
 Navicat Premium Data Transfer

 Source Server         : Project
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : reservation

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 17/04/2022 22:07:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_room_category
-- ----------------------------
DROP TABLE IF EXISTS `t_room_category`;
CREATE TABLE `t_room_category`  (
  `id` int(0) NULL DEFAULT NULL,
  `parent_id` bigint(0) NULL DEFAULT NULL,
  `name` varchar(450) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `sort_order` int(0) NULL DEFAULT NULL,
  `is_parent` int(0) NULL DEFAULT NULL,
  `created_time` datetime(0) NULL DEFAULT NULL,
  `modified_time` datetime(0) NULL DEFAULT NULL,
  `created_user` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modified_user` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_room_category
-- ----------------------------
INSERT INTO `t_room_category` VALUES (1, 0, 'classroom', 1, 1, 0, '2022-04-17 20:00:55', '2022-04-17 22:00:55', 'admin', 'admin');
INSERT INTO `t_room_category` VALUES (2, 1, 'ladder-classroom', 1, 2, 0, '2022-04-17 15:00:55', '2022-04-17 22:00:55', 'admin', 'admin');
INSERT INTO `t_room_category` VALUES (3, 2, 'lab-room', 1, 3, 0, '2022-04-17 22:00:55', '2022-04-17 22:00:55', 'admin', 'admin');
INSERT INTO `t_room_category` VALUES (4, 3, 'metting-room', 1, 4, 0, '2022-04-17 22:00:55', '2022-04-17 22:00:55', 'admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
