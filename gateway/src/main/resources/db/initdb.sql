-- password: ldvv

USE iam;

-- ----------------------------
-- Table structure for iam_role_t
-- ----------------------------
DROP TABLE IF EXISTS `iam_role_t`;
CREATE TABLE `iam_role_t` (
  `id` varchar(255) NOT NULL,
  `roleName` varchar(255) NOT NULL,
  `desc` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `createDate` varchar(255) NOT NULL,
  `lastUpdateDate` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户角色表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iam_role_t
-- ----------------------------
INSERT INTO `iam_role_t` VALUES ('admin_role', 'admin', '超级管理员角色', '2018-10-29 19:46:00', '2018-10-29 19:46:00');
INSERT INTO `iam_role_t` VALUES ('tenent_admin_role', 'tenantAdmin', '租户管理员角色', '2018-10-29 19:46:00', '2018-10-29 19:46:00');
INSERT INTO `iam_role_t` VALUES ('user_role', 'user', '普通用户角色', '2018-10-29 19:46:00', '2018-10-29 19:46:00');

-- ----------------------------
-- Table structure for iam_tenant_t
-- ----------------------------
DROP TABLE IF EXISTS `iam_tenant_t`;
CREATE TABLE `iam_tenant_t` (
  `id` varchar(100) NOT NULL,
  `tenantName` varchar(255) NOT NULL,
  `desc` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `createDate` varchar(255) NOT NULL,
  `lastUpdateDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iam_tenant_t
-- ----------------------------
INSERT INTO `iam_tenant_t` VALUES ('admin_tenant', 'admin', '管理员组', '2018-10-29 20:00:00', '2018-10-29 20:00:00');

-- ----------------------------
-- Table structure for iam_user_t
-- ----------------------------
DROP TABLE IF EXISTS `iam_user_t`;
CREATE TABLE `iam_user_t` (
  `id` varchar(100) CHARACTER SET utf8 NOT NULL,
  `username` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `PASSWORD` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `sex` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `proviceAddress` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `cityAddress` varchar(255) DEFAULT NULL,
  `countyAddress` varchar(255) DEFAULT NULL,
  `provice` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `idCard` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `workNumber` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `image` bigint(20) DEFAULT NULL,
  `createdate` varchar(100) DEFAULT NULL,
  `lastupdatedate` varchar(100) DEFAULT NULL,
  `tenant` varchar(100) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `autobiography` varchar(10000) DEFAULT NULL,
  `nickName` varchar(255) DEFAULT NULL,
  `enable` varchar(255) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iam_user_t
-- ----------------------------
INSERT INTO `iam_user_t` VALUES ('admin_user', 'admin', '$2a$04$eRzw2yWp/zLDIti2dwTyD.CisEeL4XZkP7Sd2JibMfnNI8GeVO49q', '18129934135', '1210754789@qq.com', 'X', 'XXX', 'XXX', 'XXX', 'XXX', 'XXX', 'XXX', 'XXX', 'TTL0001', null, '2018-10-29 19:46:00', '2018-10-29 19:46:00', 'admin_tenant', 'XXX', '超级管理员', 'Admin', 'true', 'admin_role');
