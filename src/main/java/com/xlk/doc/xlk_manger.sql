/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50643
Source Host           : localhost:3306
Source Database       : xlk_manger

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2022-04-14 09:33:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('1', 'admin', '$2a$10$5BqR9zx9kiZrDgmZmaNOMex8McoS5cxxAp39Qq2xqo5y8UUTjcuem', '1');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '管理部', '管理系统');
INSERT INTO `department` VALUES ('2', '财务部', '发放工资');
INSERT INTO `department` VALUES ('3', '测试部', '测试功能');
INSERT INTO `department` VALUES ('4', '人事部', '人事管理');
INSERT INTO `department` VALUES ('5', '行政部', '行政管理');
INSERT INTO `department` VALUES ('6', '宣传部', '宣传管理');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `level_id` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `status` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '969f2016c4294644ba74', 'zcx', '88888888888', '1489516316@qq.com', '3', '1', 'zcx', '123456', '18', '1', '0');
INSERT INTO `employee` VALUES ('2', '6d673581043e4a4885cd', 'lx', '12345678910', 'lx@qq.com', '2', '2', 'lx', '123456', '15', '0', '0');
INSERT INTO `employee` VALUES ('11', '4e7702551cb147828dab', 'mg', '99999999999', 'mg@qq.com', '1', '9', 'mg', '123456', '20', '1', '0');
INSERT INTO `employee` VALUES ('12', '8ee3d4fbb90f47fa8095', 'test1', '1111111111', 'test1@qq.com', '6', '12', 'test1', 'zcx', '19', '1', '1');

-- ----------------------------
-- Table structure for emp_attendance
-- ----------------------------
DROP TABLE IF EXISTS `emp_attendance`;
CREATE TABLE `emp_attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` date DEFAULT NULL,
  `employee_name` varchar(200) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `worktime` varchar(10) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_attendance
-- ----------------------------
INSERT INTO `emp_attendance` VALUES ('1', '2022-01-26', 'zcx', '2022-01-26 09:00:00', '2022-01-27 18:00:00', '9', '1');
INSERT INTO `emp_attendance` VALUES ('2', '2022-01-27', 'lx', '2022-01-27 03:00:26', '2022-01-27 19:00:30', '16.0', '1');
INSERT INTO `emp_attendance` VALUES ('9', '2022-02-19', 'test1', '2022-02-19 18:03:37', '2022-02-19 18:03:39', '0.0', '1');
INSERT INTO `emp_attendance` VALUES ('10', '2022-02-26', 'test1', '2022-02-26 18:08:17', '2022-02-26 18:08:22', '0.0', '1');
INSERT INTO `emp_attendance` VALUES ('11', '2022-04-13', 'test1', '2022-04-13 15:43:38', '2022-04-13 15:43:57', '0.01', '1');

-- ----------------------------
-- Table structure for emp_health
-- ----------------------------
DROP TABLE IF EXISTS `emp_health`;
CREATE TABLE `emp_health` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) DEFAULT NULL,
  `temperature` varchar(255) DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `image2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_health
-- ----------------------------
INSERT INTO `emp_health` VALUES ('1', 'zcx', '36.0', '2022-04-12', 'image\\zcx20220412jk3d741f37-781b-4416-bcd4-3bfcb09e9b04.jpg', 'image\\zcx20220412xc1cf0f131-6214-4754-b52e-f33561a61be2.jpg');
INSERT INTO `emp_health` VALUES ('6', 'test1', '36.0', '2022-04-14', 'image\\test120220414jk47278ecc-92bb-42a1-87e8-1d4928055d23.png', 'image\\test120220414xc03c4d619-f860-4204-9e10-74f67e5e5424.jpg');

-- ----------------------------
-- Table structure for emp_leave
-- ----------------------------
DROP TABLE IF EXISTS `emp_leave`;
CREATE TABLE `emp_leave` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(255) DEFAULT NULL,
  `leave_message` varchar(255) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `subtime` datetime DEFAULT NULL,
  `oktime` datetime DEFAULT NULL,
  `endmessage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_leave
-- ----------------------------
INSERT INTO `emp_leave` VALUES ('1', 'zcx', '生病', '2022-01-30', '2022-01-31', '-1', '2022-01-30 13:22:49', '2022-02-26 18:49:44', '滚');
INSERT INTO `emp_leave` VALUES ('2', 'test1', '有事', '2022-03-14', '2022-03-15', '-1', '2022-03-14 14:03:52', '2022-03-14 14:04:49', '不行！');
INSERT INTO `emp_leave` VALUES ('3', 'test1', '求求主管了 我真的有事', '2022-03-14', '2022-03-15', '1', '2022-03-14 14:07:57', '2022-03-14 14:08:17', '可以');

-- ----------------------------
-- Table structure for emp_notice
-- ----------------------------
DROP TABLE IF EXISTS `emp_notice`;
CREATE TABLE `emp_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_notice
-- ----------------------------
INSERT INTO `emp_notice` VALUES ('1', '今晚开会', '2022-04-06 15:52:30', 'admin', '2022-04-06');

-- ----------------------------
-- Table structure for emp_reward
-- ----------------------------
DROP TABLE IF EXISTS `emp_reward`;
CREATE TABLE `emp_reward` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_reward
-- ----------------------------
INSERT INTO `emp_reward` VALUES ('1', '测试部', 'zcx', '2月全勤', '0', '200.00', '好好工作');
INSERT INTO `emp_reward` VALUES ('4', '测试部', 'mg', 'mg牛逼', '1', '15000.00', 'mg牛逼');

-- ----------------------------
-- Table structure for emp_salary
-- ----------------------------
DROP TABLE IF EXISTS `emp_salary`;
CREATE TABLE `emp_salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) DEFAULT NULL,
  `employee_name` varchar(100) DEFAULT NULL,
  `creattime` date DEFAULT NULL,
  `base_salary` decimal(10,2) DEFAULT NULL,
  `ad_salary` decimal(10,2) DEFAULT NULL,
  `end_salary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp_salary
-- ----------------------------
INSERT INTO `emp_salary` VALUES ('1', '测试部', 'zcx', '2022-02-10', '10000.00', '200.00', '9800.00');
INSERT INTO `emp_salary` VALUES ('2', '财务部', 'lx', '2022-02-09', '1000.00', '0.00', '1000.00');
INSERT INTO `emp_salary` VALUES ('3', '宣传部', 'test1', '2022-03-01', '10000.00', '0.00', '10000.00');
INSERT INTO `emp_salary` VALUES ('4', '宣传部', 'test1', '2022-04-01', '500.00', '0.00', '500.00');

-- ----------------------------
-- Table structure for file_oa
-- ----------------------------
DROP TABLE IF EXISTS `file_oa`;
CREATE TABLE `file_oa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `filesize` double DEFAULT NULL,
  `filetype` varchar(255) DEFAULT NULL,
  `filesrc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file_oa
-- ----------------------------
INSERT INTO `file_oa` VALUES ('6', 'layuimini-v2', '2480100', 'zip', 'D:\\文档\\Ideaworkpasce\\springbootdemo01\\src\\main\\resources\\static\\FileUpLoad\\layuimini-v2.zip');
INSERT INTO `file_oa` VALUES ('9', 'table_1', '251', 'csv', 'D:\\文档\\Ideaworkpasce\\springbootdemo01\\src\\main\\resources\\static\\FileUpLoad\\table_1.csv');
INSERT INTO `file_oa` VALUES ('10', '28d4817e42e49558!200x200', '39618', 'png', 'D:\\文档\\Ideaworkpasce\\springbootdemo01\\src\\main\\resources\\static\\FileUpLoad\\28d4817e42e49558!200x200.png');

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('1', '人事主管', '人事主管', '人事部');
INSERT INTO `level` VALUES ('2', '财务主管', '财务主管', '财务部');
INSERT INTO `level` VALUES ('3', '管理主管', '管理主管', '管理部');
INSERT INTO `level` VALUES ('4', '测试主管', '测试主管', '测试部');
INSERT INTO `level` VALUES ('5', '测试员工', '测试部员工', '测试部');
INSERT INTO `level` VALUES ('9', '管理部员工', '管理部员工', '管理部');
INSERT INTO `level` VALUES ('10', '人事部员工', '人事部员工', '人事部');
INSERT INTO `level` VALUES ('12', 'test宣传', 'test宣传', '宣传部');
INSERT INTO `level` VALUES ('13', 'test行政', 'test行政', '行政部');

-- ----------------------------
-- Table structure for platform_log
-- ----------------------------
DROP TABLE IF EXISTS `platform_log`;
CREATE TABLE `platform_log` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `login_ip` varchar(40) DEFAULT NULL,
  `login_name` varchar(50) DEFAULT NULL,
  `login_msg` varchar(100) DEFAULT NULL,
  `created_by` bigint(50) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` bigint(50) DEFAULT NULL,
  `last_modified` datetime DEFAULT NULL,
  `owner` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platform_log
-- ----------------------------
INSERT INTO `platform_log` VALUES ('1', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-08 09:26:34', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('2', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-08 09:31:22', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('3', '169.254.125.127', 'test1', '验证码错误', '1', '2022-04-08 09:34:49', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('4', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-08 09:34:56', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('5', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-08 09:35:27', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('6', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-08 09:36:14', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('7', '169.254.125.127', 'test1', '验证码错误', '1', '2022-04-13 15:43:03', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('8', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-13 15:43:08', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('9', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-14 08:44:44', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('10', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-14 09:01:24', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('11', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-14 09:01:48', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('12', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-14 09:26:47', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('13', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-14 09:27:11', null, null, 'zcx');
INSERT INTO `platform_log` VALUES ('14', '169.254.125.127', 'test1', '登陆成功', '1', '2022-04-14 09:32:36', null, null, 'zcx');
