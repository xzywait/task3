/*
Navicat MySQL Data Transfer

Source Server         : myconnection
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-03-30 21:19:39
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) DEFAULT NULL,
  `authors` varchar(30) DEFAULT NULL,
  `publisher` varchar(30) DEFAULT NULL,
  `publishdate` datetime DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '翻译美学理论 ', '刘宓庆 ', '外语教学与研究出版社', '2011-03-01 00:00:00', '99999');
INSERT INTO `book` VALUES ('2', '鲁滨逊漂流记 ', '迪福6', '北方少年出版社', '2003-09-05 00:00:00', '25.2');
INSERT INTO `book` VALUES ('4', '海底两万里', '儒勒.凡尔纳', ' 北方妇女儿童出版社 ', '2009-06-03 00:00:00', '18.8');
INSERT INTO `book` VALUES ('6', '十万个为什么', '米·伊林', '新世纪出版社', '1961-01-20 00:00:00', '80');
