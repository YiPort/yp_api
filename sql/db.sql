/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : ypapi

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 01/03/2023 20:45:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for interface_info
-- ----------------------------
DROP TABLE IF EXISTS `interface_info`;
CREATE TABLE `interface_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `url` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '接口地址',
  `requestParams` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求参数',
  `requestHeader` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求头',
  `responseHeader` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '响应头',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '接口状态（0-关闭，1-开启）',
  `method` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求类型',
  `userId` bigint(20) NOT NULL COMMENT '创建人',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除(0-未删, 1-已删)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '接口信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of interface_info
-- ----------------------------
INSERT INTO `interface_info` VALUES (1, 'getNameByGET', 'YiPort测试Get Name By GET', 'http://localhost:8123/api/name/get', '{\"username\":\"username\",\"type\":\"string\"}', '{”Content-Type”: ”application/json”}', '{”Content-Type”: ”application/json”}', 1, 'GET', 1, '2022-11-07 06:03:00', '2022-01-17 20:58:39', 0);
INSERT INTO `interface_info` VALUES (2, 'yiport测试getNameByPOST', 'YiPort测试调用失败样例', 'http://localhost:8123/api/name/get', '{\"username\":\"username\",\"type\":\"string\"}', '{”Content-Type”: ”application/json”}', '{”Content-Type”: ”application/json”}', 1, 'POST', 1, '2022-11-07 06:03:10', '2022-02-12 19:28:23', 0);
INSERT INTO `interface_info` VALUES (3, 'getUserNameByPOST', 'YiPort测试Get UserName By POST', 'http://localhost:8123/api/name/user', '{\"username\":\"username\",\"type\":\"string\"}', '{”Content-Type”: ”application/json”}', '{”Content-Type”: ”application/json”}', 1, 'POST', 1, '2022-11-07 06:03:20', '2022-01-17 20:58:32', 0);

-- ----------------------------
-- Table structure for user_interface_info
-- ----------------------------
DROP TABLE IF EXISTS `user_interface_info`;
CREATE TABLE `user_interface_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` bigint(20) NOT NULL COMMENT '调用用户 id',
  `interfaceInfoId` bigint(20) NOT NULL COMMENT '接口 id',
  `totalNum` int(11) NOT NULL DEFAULT 0 COMMENT '总调用次数',
  `leftNum` int(11) NOT NULL DEFAULT 0 COMMENT '剩余调用次数',
  `status` int(11) NOT NULL DEFAULT 0 COMMENT '0-正常，1-禁用',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除(0-未删, 1-已删)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户调用接口关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_interface_info
-- ----------------------------
INSERT INTO `user_interface_info` VALUES (1, 1, 1, 9011, 776, 0, '2022-12-07 06:03:00', '2023-02-21 19:48:53', 0);
INSERT INTO `user_interface_info` VALUES (2, 1, 2, 900, 787, 0, '2022-12-07 06:03:00', '2023-02-21 19:48:47', 0);
INSERT INTO `user_interface_info` VALUES (3, 1, 3, 9002, 785, 0, '2022-12-07 06:03:00', '2023-02-21 19:48:41', 0);

SET FOREIGN_KEY_CHECKS = 1;
