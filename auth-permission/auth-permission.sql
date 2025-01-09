/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80100 (8.1.0)
 Source Host           : localhost:3306
 Source Schema         : auth-permission

 Target Server Type    : MySQL
 Target Server Version : 80100 (8.1.0)
 File Encoding         : 65001

 Date: 09/01/2025 21:30:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_functional
-- ----------------------------
DROP TABLE IF EXISTS `sys_functional`;
CREATE TABLE `sys_functional`  (
  `functional_id` bigint NOT NULL AUTO_INCREMENT,
  `functional_name_cn` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource_id` bigint NOT NULL,
  `functional_name_en` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `functional_description_cn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `functional_description_en` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`functional_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_functional
-- ----------------------------

-- ----------------------------
-- Table structure for sys_language
-- ----------------------------
DROP TABLE IF EXISTS `sys_language`;
CREATE TABLE `sys_language`  (
  `i18n_id` bigint NOT NULL AUTO_INCREMENT,
  `locale` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `i18n_module` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `i18n_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `i18n_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`i18n_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_language
-- ----------------------------
INSERT INTO `sys_language` VALUES (2, 'en-US', 'login', 'username', 'username', '1', '2024-03-17 20:17:50', '1', '2024-05-28 22:17:55');
INSERT INTO `sys_language` VALUES (3, 'zh-CN', 'login', 'password', '密码', '1', '2024-03-17 23:10:12', '1', '2024-05-28 22:18:03');
INSERT INTO `sys_language` VALUES (4, 'en-US', 'login', 'password', 'password', '1', '2024-03-17 23:10:52', '1', '2024-05-28 22:18:07');
INSERT INTO `sys_language` VALUES (5, 'zh-CN', 'system', 'locale', '地区', NULL, '2024-05-28 21:38:01', '', '2024-05-28 22:17:48');
INSERT INTO `sys_language` VALUES (6, 'en-US', 'system', 'locale', 'locale', NULL, '2024-05-28 21:38:04', '', '2024-05-28 22:18:13');
INSERT INTO `sys_language` VALUES (7, 'zh-CN', 'system', 'i18nModule', '模块', NULL, '2024-05-28 21:38:06', '', '2024-05-28 22:18:18');
INSERT INTO `sys_language` VALUES (8, 'en-US', 'system', 'i18nModule', 'module', NULL, '2024-05-28 21:38:09', '', '2024-05-28 22:18:22');
INSERT INTO `sys_language` VALUES (9, 'zh-CN', 'system', 'i18nKey', '键', NULL, '2024-05-28 21:38:11', '', '2024-05-28 22:18:26');
INSERT INTO `sys_language` VALUES (10, 'en-US', 'system', 'i18nKey', 'key', NULL, '2024-05-28 21:38:14', '', '2024-05-28 22:18:34');
INSERT INTO `sys_language` VALUES (11, 'zh-CN', 'system', 'i18nValue', '值', NULL, '2024-05-28 21:38:16', '', '2024-05-28 22:18:38');
INSERT INTO `sys_language` VALUES (12, 'en-US', 'system', 'i18nValue', 'value', NULL, '2024-05-28 21:38:19', '', '2024-05-28 22:18:50');
INSERT INTO `sys_language` VALUES (37, 'en-US', 'system', 'i18nId', 'id', NULL, '2024-03-26 22:31:57', '', '2024-05-28 22:18:55');
INSERT INTO `sys_language` VALUES (38, 'zh-CN', 'system', 'i18nId', 'id', NULL, '2024-03-26 22:31:57', '', '2024-05-28 22:18:59');
INSERT INTO `sys_language` VALUES (39, 'en-US', 'common', 'appName', 'mAuth', NULL, '2024-05-28 21:53:33', '', '2024-05-28 21:54:43');
INSERT INTO `sys_language` VALUES (40, 'zh-CN', 'common', 'appName', '权限管理', NULL, '2024-05-28 21:54:17', '', '2024-05-28 21:54:17');
INSERT INTO `sys_language` VALUES (41, 'en-US', 'common', 'login', 'login', NULL, '2024-05-28 22:02:46', '', '2024-05-28 22:02:46');
INSERT INTO `sys_language` VALUES (42, 'zh-CN', 'common', 'login', '登录', NULL, '2024-05-28 22:02:46', '', '2024-05-28 22:02:46');
INSERT INTO `sys_language` VALUES (43, 'en-US', 'common', 'required', 'required', NULL, '2024-05-28 22:03:08', '', '2024-05-28 22:03:08');
INSERT INTO `sys_language` VALUES (44, 'zh-CN', 'common', 'required', '该项为必填项', NULL, '2024-05-28 22:03:08', '', '2024-05-28 22:03:08');
INSERT INTO `sys_language` VALUES (45, 'en-US', 'common', 'status', 'status', NULL, '2024-05-28 22:03:31', '', '2024-05-28 22:03:31');
INSERT INTO `sys_language` VALUES (46, 'zh-CN', 'common', 'status', '状态', NULL, '2024-05-28 22:03:31', '', '2024-05-28 22:03:31');
INSERT INTO `sys_language` VALUES (47, 'en-US', 'common', 'search', 'search', NULL, '2024-05-28 22:03:56', '', '2024-05-28 22:03:56');
INSERT INTO `sys_language` VALUES (48, 'zh-CN', 'common', 'search', '搜索', NULL, '2024-05-28 22:03:56', '', '2024-05-28 22:03:56');
INSERT INTO `sys_language` VALUES (49, 'en-US', 'common', 'reset', 'reset', NULL, '2024-05-28 22:04:18', '', '2024-05-28 22:04:18');
INSERT INTO `sys_language` VALUES (50, 'zh-CN', 'common', 'reset', '重置', NULL, '2024-05-28 22:04:18', '', '2024-05-28 22:04:18');
INSERT INTO `sys_language` VALUES (51, 'en-US', 'common', 'createTime', 'createTime', NULL, '2024-05-28 22:04:44', '', '2024-05-28 22:04:44');
INSERT INTO `sys_language` VALUES (52, 'zh-CN', 'common', 'createTime', '创建时间', NULL, '2024-05-28 22:04:44', '', '2024-05-28 22:04:44');
INSERT INTO `sys_language` VALUES (53, 'en-US', 'common', 'effectivity', 'effectivity', NULL, '2024-05-28 22:05:06', '', '2024-05-28 22:05:06');
INSERT INTO `sys_language` VALUES (54, 'zh-CN', 'common', 'effectivity', '有效', NULL, '2024-05-28 22:05:06', '', '2024-05-28 22:05:06');
INSERT INTO `sys_language` VALUES (55, 'en-US', 'common', 'ineffective', 'ineffective', NULL, '2024-05-28 22:05:27', '', '2024-05-28 22:05:27');
INSERT INTO `sys_language` VALUES (56, 'zh-CN', 'common', 'ineffective', '无效', NULL, '2024-05-28 22:05:27', '', '2024-05-28 22:05:27');
INSERT INTO `sys_language` VALUES (57, 'en-US', 'common', 'add', 'add', NULL, '2024-05-28 22:05:48', '', '2024-05-28 22:05:48');
INSERT INTO `sys_language` VALUES (58, 'zh-CN', 'common', 'add', '新增', NULL, '2024-05-28 22:05:48', '', '2024-05-28 22:05:48');
INSERT INTO `sys_language` VALUES (59, 'en-US', 'common', 'edit', 'edit', NULL, '2024-05-28 22:06:09', '', '2024-05-28 22:06:09');
INSERT INTO `sys_language` VALUES (60, 'zh-CN', 'common', 'edit', '修改', NULL, '2024-05-28 22:06:09', '', '2024-05-28 22:06:09');
INSERT INTO `sys_language` VALUES (61, 'zh-CN', 'login', 'username', '用户名', NULL, '2024-05-31 20:18:46', '', '2024-05-31 20:18:46');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `resource_id` bigint NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `resource_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '资源类型（M菜单 B按钮）',
  `parent_id` bigint NOT NULL,
  `order_num` int NULL DEFAULT NULL,
  `permission_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限标识',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`resource_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, '资源管理', NULL, 'M', 0, 1, 'm:resource', '1', '2024-06-19 21:47:22', '1', '2024-06-19 21:47:26');
INSERT INTO `sys_resource` VALUES (2, '权限设计', NULL, 'M', 0, 2, 'm:permission', '1', '2024-06-19 21:55:14', '1', '2024-06-19 21:55:18');
INSERT INTO `sys_resource` VALUES (3, '角色设计', NULL, 'M', 0, 3, 'm:role', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `role_name_cn` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_name_en` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_description_cn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role_description_en` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `order_num` int NOT NULL,
  `functional_list` json NULL COMMENT '功能权限列表',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `update_time` datetime NULL DEFAULT NULL,
  `status` bit(1) NULL DEFAULT NULL COMMENT '状态（1正常 0停用）',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'admin', '系统管理员', 'system admin', 1, NULL, '1', '2024-01-21 16:34:14', '1', '2024-01-21 16:34:35', b'0');

SET FOREIGN_KEY_CHECKS = 1;
