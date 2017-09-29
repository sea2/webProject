/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : data_info

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-08-26 15:05:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_class`
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('1', '1-2班');
INSERT INTO `t_class` VALUES ('2', '2-2班');

-- ----------------------------
-- Table structure for `t_data`
-- ----------------------------
DROP TABLE IF EXISTS `t_data`;
CREATE TABLE `t_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_remark` varchar(255) DEFAULT NULL,
  `string1` varchar(255) DEFAULT NULL,
  `string2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_data
-- ----------------------------
INSERT INTO `t_data` VALUES ('40', '', '', '');
INSERT INTO `t_data` VALUES ('41', '', '渠道名称（open后台获取）', '渠道号（open后台获取）');
INSERT INTO `t_data` VALUES ('42', '', '360手机助手-展示广告1', '140299391');
INSERT INTO `t_data` VALUES ('43', '', '应用宝', '10010');
INSERT INTO `t_data` VALUES ('44', '', '360手机助手', '10020');
INSERT INTO `t_data` VALUES ('45', '', '百度助手', '10030');
INSERT INTO `t_data` VALUES ('46', '', '安卓市场', '10040');
INSERT INTO `t_data` VALUES ('47', '', '91手机助手', '10050');
INSERT INTO `t_data` VALUES ('48', '', '豌豆荚', '10060');
INSERT INTO `t_data` VALUES ('49', '', '安智市场', '10070');
INSERT INTO `t_data` VALUES ('50', '', '机锋市场', '10080');
INSERT INTO `t_data` VALUES ('51', '', '淘宝手机助手(PP助手)', '10090');
INSERT INTO `t_data` VALUES ('52', '', '小米应用商店', '10100');
INSERT INTO `t_data` VALUES ('53', '', '三星', '10110');
INSERT INTO `t_data` VALUES ('54', '', '华为', '10120');
INSERT INTO `t_data` VALUES ('55', '', 'vivo', '10130');
INSERT INTO `t_data` VALUES ('56', '', 'oppo', '10140');
INSERT INTO `t_data` VALUES ('57', '', '联想', '10150');
INSERT INTO `t_data` VALUES ('58', '', '魅族', '10170');
INSERT INTO `t_data` VALUES ('59', '', '点睛CPD1', '140079245');
INSERT INTO `t_data` VALUES ('60', '', '点睛CPD2', '140116041');
INSERT INTO `t_data` VALUES ('61', '', '点睛CPD3', '140116043');
INSERT INTO `t_data` VALUES ('62', '', '点睛CPD4', '140256920');
INSERT INTO `t_data` VALUES ('63', '', '点睛CPD5', '140256923');
INSERT INTO `t_data` VALUES ('64', '', '点睛CPD6', '140256953');
INSERT INTO `t_data` VALUES ('65', '', '点睛CPD7', '140256959');
INSERT INTO `t_data` VALUES ('66', '', '有米网络1', '140300858');
INSERT INTO `t_data` VALUES ('67', '', '有米网络2', '140300868');
INSERT INTO `t_data` VALUES ('68', '', '有米网络3', '140300870');
INSERT INTO `t_data` VALUES ('69', '', '有米网络4', '140300875');
INSERT INTO `t_data` VALUES ('70', '', '锁财宝', '10200 ');
INSERT INTO `t_data` VALUES ('71', '', '今天头条1', '140099866');
INSERT INTO `t_data` VALUES ('72', '', '今天头条2', '140099868');
INSERT INTO `t_data` VALUES ('73', '', '今天头条3', '140099870');
INSERT INTO `t_data` VALUES ('74', '', '今天头条4', '140099874');
INSERT INTO `t_data` VALUES ('75', '', 'sina1', '18616390715');
INSERT INTO `t_data` VALUES ('76', '', 'sina2', '18616390715');
INSERT INTO `t_data` VALUES ('77', '', 'sina3', '18616390715');
INSERT INTO `t_data` VALUES ('78', '', 'sina4', '18616390715');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_class_id` int(11) DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', '熊勇', '56', '1');
INSERT INTO `t_user` VALUES ('3', '小明', '56', '1');
INSERT INTO `t_user` VALUES ('4', '五羊', '12', '1');
