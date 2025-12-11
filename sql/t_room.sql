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

 Date: 17/04/2022 20:39:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_room
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `category_id` int(0) NULL DEFAULT NULL,
  `item_type` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `point` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rotime` double(20, 1) NULL DEFAULT NULL,
  `num` int(0) NULL DEFAULT NULL,
  `image` varchar(1500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `priority` int(0) NULL DEFAULT NULL,
  `created_time` datetime(0) NULL DEFAULT NULL,
  `modified_time` datetime(0) NULL DEFAULT NULL,
  `created_user` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modified_user` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_room
-- ----------------------------
INSERT INTO `t_room` VALUES (10000001, 1, 'small-classroom', 'FB345', 'Rember to check to the timetable and notice of the campus before enter in! ', 0.5, 99999, '/images/portal/00FB345/', 1, 1, '2022-04-17 19:08:55', '2022-04-17 19:08:55', 'admin', 'admin');
INSERT INTO `t_room` VALUES (10000002, 2, 'ladder-classroom', 'FB111', 'Rember to check the timetable and the notice of the campus before enter in! ', 1.0, 99999, '/images/portal/02FB111/', 1, 2, '2022-04-17 19:08:55', '2022-04-17 19:08:55', 'admin', 'admin');
INSERT INTO `t_room` VALUES (10000003, 3, 'lab-room', 'FB303', 'Rember to check the timetable and the notice of the campus before enter in! | Obey lab rules!', 1.5, 99999, '/images/portal/03FB303/', 1, 3, '2022-04-17 19:08:55', '2022-04-17 19:08:55', 'admin', 'admin');
INSERT INTO `t_room` VALUES (10000004, 4, 'meeting-room', 'FB603', 'Rember to check the email and the notice of the campus before enter in! ', 0.5, 99999, '/images/portal/04FB603/', 1, 4, '2022-04-17 19:08:55', '2022-04-17 19:08:55', 'admin', 'admin');
INSERT INTO `t_room` VALUES (10000005, 1, 'classroom', 'FB103', 'Rember to check the timetable and the notice of the campus before enter in! ', 1.0, 99999, '/images/portal/05FB103/', 1, 5, '2022-04-17 19:08:55', '2022-04-17 19:08:55', 'admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
