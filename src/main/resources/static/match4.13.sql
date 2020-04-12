/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3006
Source Database       : match

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2020-04-13 01:08:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cms_contest
-- ----------------------------
DROP TABLE IF EXISTS `cms_contest`;
CREATE TABLE `cms_contest` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `organizer_id` bigint(20) DEFAULT NULL COMMENT '主办方id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '赛事标题',
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '赛事类型',
  `details` text COLLATE utf8mb4_unicode_ci COMMENT '详细说明，最大长度为16383个汉字',
  `location` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '比赛地点',
  `logo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '赛事图标',
  `banner` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '宣传轮播图',
  `open_enrollment_time` datetime DEFAULT NULL COMMENT '开放报名时间',
  `close_enrollment_time` datetime DEFAULT NULL COMMENT '截止报名时间',
  `contest_time` datetime DEFAULT NULL COMMENT '比赛开始时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '本条记录创建时间',
  `status` int(255) DEFAULT '0' COMMENT '状态（0->等待审核; 1->审核通过; 2->未通过; 3->标记删除、4->赛事取消）',
  `last_check_id` bigint(20) DEFAULT NULL COMMENT '最近一次审核人id',
  `last_check_time` datetime DEFAULT NULL COMMENT '最近一次审核时间',
  `last_check_note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最近一次审核批注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='赛事信息表';

-- ----------------------------
-- Records of cms_contest
-- ----------------------------
INSERT INTO `cms_contest` VALUES ('0', '0', '其他的', '其他', '细节是1', 'string', 'string', 'hotel.jpg', '2020-03-08 12:12:00', '2020-04-08 12:12:00', '2020-03-10 12:12:00', '2020-03-20 00:08:01', '0', '0', null, 'string');
INSERT INTO `cms_contest` VALUES ('69', '0', '厦门马拉松', '马拉松', '<div class=\"lake-content-editor-core lake-engine lake-typography-traditional\" data-lake-element=\"root\">\r\n  <p data-lake-id=\"a20d224c568e48b9d67847a2c66a8c01_p_0\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">一、赛事组织机构：</p>\r\n  <p data-lake-id=\"942879c0bbf4a3598441608310d8a740\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">指导单位：广东省体育局</p>\r\n  <p data-lake-id=\"c1caf765974485faa502258be8d5ce48\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">主办单位：广东省体育产业协会、广东省自行车运动协会、汕尾市文化广电旅游体育局</p>\r\n  <p data-lake-id=\"ead67891f49ddfb48edd8cce391d8e64\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">承办单位：广州搏浪体育项目策划有限公司</p>\r\n  <p data-lake-id=\"7f84e267e0f16410bc401b1b6cc5ea3d\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">支持单位：广东省人民政府港澳事务办公室</p>\r\n  <p data-lake-id=\"033e8c163e816085b00e8a0e3f239342\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">运营单位：广州搏浪体育项目策划有限公司</p>\r\n  <p data-lake-id=\"0e9be4eb38d56ee2c4695438030447fa\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">协办单位：广东省自行车电动车行业协会</p>\r\n  <p data-lake-id=\"ee42bf0ee2c3caf4d02f533dd4414506\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">汕尾市自行车运动协会</p>\r\n  <p data-lake-id=\"a22837a6b5f51f9a89359ef2c3825c9a\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">广东大通文化有限公司</p>\r\n  <p data-lake-id=\"136adad45f4807df28351e1ae71ce9a2\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">深圳金辉煌体育管理发展有限公司</p>\r\n  <p data-lake-id=\"f245abbbaea9e6206a24d2b0cbee5bc4\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">二、赛事时间与地点</p>\r\n  <p data-lake-id=\"1dba3791280012208a6e32d72d46bc31\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">2019年12月28日-29日在凤山妈祖文化广场举行（主会场），28日为儿童组竞赛以及裁判培训、开闭幕式彩排。</p>\r\n  <p data-lake-id=\"49d8cd2262218ebcd438ad4b4d1736a0\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">三、竞赛线路</p>\r\n  <p class=\"\" data-lake-id=\"5cce4d776c544c8d3d76a7492aa21e48\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\"><br></p>\r\n  <div data-card-type=\"block\" data-lake-card=\"table\" id=\"Eo8fw\" class=\"\">\r\n    <table class=\"lake-table\" style=\"width: 720px; outline: none; border-collapse: collapse;\">\r\n      <colgroup>\r\n        <col width=\"240\">\r\n        <col width=\"240\">\r\n        <col width=\"240\">\r\n      </colgroup>\r\n      <tbody>\r\n        <tr>\r\n          <td style=\"min-width: 90px; font-size: 14px; white-space: normal; overflow-wrap: break-word; border: 1px solid rgb(217, 217, 217); padding: 4px 8px; cursor: default;\">\r\n            <p data-lake-id=\"1d432d7be8278777dbb9d331d1488205\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">表1</p>\r\n          </td>\r\n          <td style=\"min-width: 90px; font-size: 14px; white-space: normal; overflow-wrap: break-word; border: 1px solid rgb(217, 217, 217); padding: 4px 8px; cursor: default;\">\r\n            <p data-lake-id=\"1d432d7be8278777dbb9d331d1488205\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">表1</p>\r\n          </td>\r\n          <td style=\"min-width: 90px; font-size: 14px; white-space: normal; overflow-wrap: break-word; border: 1px solid rgb(217, 217, 217); padding: 4px 8px; cursor: default;\">\r\n            <p data-lake-id=\"1d432d7be8278777dbb9d331d1488205\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">表1</p>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td style=\"min-width: 90px; font-size: 14px; white-space: normal; overflow-wrap: break-word; border: 1px solid rgb(217, 217, 217); padding: 4px 8px; cursor: default;\">\r\n            <p data-lake-id=\"1d432d7be8278777dbb9d331d1488205\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">表1</p>\r\n          </td>\r\n          <td style=\"min-width: 90px; font-size: 14px; white-space: normal; overflow-wrap: break-word; border: 1px solid rgb(217, 217, 217); padding: 4px 8px; cursor: default;\">\r\n            <p data-lake-id=\"1d432d7be8278777dbb9d331d1488205\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">表1</p>\r\n          </td>\r\n          <td style=\"min-width: 90px; font-size: 14px; white-space: normal; overflow-wrap: break-word; border: 1px solid rgb(217, 217, 217); padding: 4px 8px; cursor: default;\">\r\n            <p data-lake-id=\"1d432d7be8278777dbb9d331d1488205\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">表1</p>\r\n          </td>\r\n        </tr>\r\n        <tr>\r\n          <td style=\"min-width: 90px; font-size: 14px; white-space: normal; overflow-wrap: break-word; border: 1px solid rgb(217, 217, 217); padding: 4px 8px; cursor: default;\">\r\n            <p data-lake-id=\"1d432d7be8278777dbb9d331d1488205\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">表1</p>\r\n          </td>\r\n          <td style=\"min-width: 90px; font-size: 14px; white-space: normal; overflow-wrap: break-word; border: 1px solid rgb(217, 217, 217); padding: 4px 8px; cursor: default;\">\r\n            <p data-lake-id=\"1d432d7be8278777dbb9d331d1488205\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">表1</p>\r\n          </td>\r\n          <td style=\"min-width: 90px; font-size: 14px; white-space: normal; overflow-wrap: break-word; border: 1px solid rgb(217, 217, 217); padding: 4px 8px; cursor: default;\">\r\n            <p data-lake-id=\"1d432d7be8278777dbb9d331d1488205\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\">表1</p>\r\n          </td>\r\n        </tr>\r\n      </tbody>\r\n    </table>\r\n  </div>\r\n  <p data-lake-id=\"a1c77a2d7cf7f7009cd513a74d77d537\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\"><br></p>\r\n  <p class=\"\" data-lake-id=\"31c365785a6f93c4ea60a86f34dc6d38\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\"><br></p>\r\n  <p class=\"\" data-lake-id=\"c20b6e46bfac88d398783eaec9163c6f\" style=\"font-size: 14px; color: rgb(38, 38, 38); line-height: 1.74; letter-spacing: 0.05em; outline-style: none; overflow-wrap: break-word; margin: 0px;\"><span class=\"lake-fontsize-16\" style=\"background-color: rgb(255, 240, 143); font-size: 22px;\" data-mce-style=\"font-size: 16px\"><strong>下面加粗肥肉</strong></span></p>\r\n</div>', 'string', 'logo.png', 'hotel.jpg', '2020-03-08 12:12:00', '2020-04-11 12:12:00', '2020-04-15 12:12:00', '2020-03-19 23:43:31', null, null, null, '2020-03-08 12:12:00');
INSERT INTO `cms_contest` VALUES ('70', '0', '桂林国际马拉松', '马拉松', '3333333333333', 'string', 'string', 'hotel.jpg', '2020-03-08 12:12:00', '2020-04-11 12:12:00', '2020-03-10 12:12:00', '2020-03-19 23:48:11', null, null, null, '2020-03-08 12:12:00');
INSERT INTO `cms_contest` VALUES ('71', '0', '32马拉松', '马拉松', '44444444444444', 'string', 'string', 'hotel.jpg', '2020-03-08 12:12:00', '2020-04-11 12:12:00', '2020-03-18 12:12:00', '2020-03-19 23:53:43', null, null, null, '2020-03-08 12:12:00');
INSERT INTO `cms_contest` VALUES ('72', '0', '3越野跑', '越野跑', '555555555555555', 'string', 'string', 'hotel.jpg', '2020-03-08 12:12:00', '2020-04-11 12:12:00', '2020-03-10 12:12:00', null, '3', null, null, '2020-03-08 12:12:00');
INSERT INTO `cms_contest` VALUES ('73', '0', '名字是无关的越野跑', '越野跑', '2222222', 'string', 'string', 'hotel.jpg', '2020-03-08 12:12:00', '2020-04-11 12:12:00', '2020-03-10 12:12:00', '2020-03-20 19:04:30', null, null, null, '2020-03-08 12:12:00');
INSERT INTO `cms_contest` VALUES ('74', '0', '2越野跑', '越野跑', '777777777777777777', 'string', 'string', 'hotel.jpg', '2020-03-08 12:12:00', '2020-04-11 12:12:00', '2020-03-10 12:12:00', null, '0', null, null, '2020-03-08 12:12:00');
INSERT INTO `cms_contest` VALUES ('75', '0', '2越野跑', '越野跑', '8888888888888888888', 'string', 'string', 'hotel.jpg', '2020-03-08 12:12:00', '2020-04-11 12:12:00', '2020-03-10 12:12:00', '2020-03-23 00:17:45', '0', null, null, '2020-03-08 12:12:00');
INSERT INTO `cms_contest` VALUES ('76', '1', '1越野跑', '越野跑', '99999999999999999999', 'string', 'string', 'hotel.jpg', '2020-03-08 12:12:00', '2020-04-11 12:12:00', '2020-03-10 12:12:00', '2020-03-24 01:21:08', '0', null, null, '2020-03-08 12:12:00');
INSERT INTO `cms_contest` VALUES ('77', '0', 'string越野跑', '越野跑', 'string', 'string', 'string', 'hotel.jpg', '2020-03-08 12:12:00', '2020-04-11 12:12:00', '2020-03-10 12:12:00', '2020-03-30 15:50:12', '0', null, null, '2020-03-08 12:12:00');

-- ----------------------------
-- Table structure for cms_contest_extension_property
-- ----------------------------
DROP TABLE IF EXISTS `cms_contest_extension_property`;
CREATE TABLE `cms_contest_extension_property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contest_id` bigint(20) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '属性类型，已预先定义',
  `key` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '属性名称',
  `value` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '属性值',
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '属性图标，已预先定义',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='赛事拓展属性（这些信息在规程中也应详细指出）';

-- ----------------------------
-- Records of cms_contest_extension_property
-- ----------------------------
INSERT INTO `cms_contest_extension_property` VALUES ('25', '65', 'string', 'string', 'string', 'string');
INSERT INTO `cms_contest_extension_property` VALUES ('28', '68', 'string', 'string', 'string', 'string');
INSERT INTO `cms_contest_extension_property` VALUES ('51', '72', 'string', 'string', 'string', 'string');
INSERT INTO `cms_contest_extension_property` VALUES ('52', '73', 'string', 'string', 'string', 'string');
INSERT INTO `cms_contest_extension_property` VALUES ('54', '74', 'string', 'string', 'string', 'string');
INSERT INTO `cms_contest_extension_property` VALUES ('55', '75', 'string', 'string', 'string', 'string');
INSERT INTO `cms_contest_extension_property` VALUES ('56', '76', 'string', 'string', 'string', 'string');
INSERT INTO `cms_contest_extension_property` VALUES ('57', '77', 'string', 'string', 'string', 'string');

-- ----------------------------
-- Table structure for cms_contest_group
-- ----------------------------
DROP TABLE IF EXISTS `cms_contest_group`;
CREATE TABLE `cms_contest_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contest_id` bigint(20) DEFAULT NULL COMMENT '所属赛事id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '组别名称',
  `size` int(11) DEFAULT '0' COMMENT '小组容量（初始最大，随着报名人数而减少）',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='赛事分组';

-- ----------------------------
-- Records of cms_contest_group
-- ----------------------------
INSERT INTO `cms_contest_group` VALUES ('102', '49', 'string', '0', '0.00');
INSERT INTO `cms_contest_group` VALUES ('107', '54', 'string', '4', '0.00');
INSERT INTO `cms_contest_group` VALUES ('108', '55', 'string', '0', '0.00');
INSERT INTO `cms_contest_group` VALUES ('109', '56', 'string', '0', '0.00');
INSERT INTO `cms_contest_group` VALUES ('110', '57', 'string', '0', '0.00');
INSERT INTO `cms_contest_group` VALUES ('111', '58', 'string', '0', '0.00');
INSERT INTO `cms_contest_group` VALUES ('112', '59', 'string', '0', '0.00');
INSERT INTO `cms_contest_group` VALUES ('113', '60', '棒棒小组', '6', '0.00');
INSERT INTO `cms_contest_group` VALUES ('116', '69', '小组1', '18', '250.00');
INSERT INTO `cms_contest_group` VALUES ('117', '69', '小组2', '36', '260.00');
INSERT INTO `cms_contest_group` VALUES ('118', '69', '小组3', '11', '270.00');
INSERT INTO `cms_contest_group` VALUES ('121', '69', '小组4', '10', '280.00');
INSERT INTO `cms_contest_group` VALUES ('147', '72', 'string', '0', '0.00');
INSERT INTO `cms_contest_group` VALUES ('148', '73', 'string', '0', '0.00');
INSERT INTO `cms_contest_group` VALUES ('150', '68', '小组1', '9', '123.45');
INSERT INTO `cms_contest_group` VALUES ('151', '68', '小组2', '7', '123.45');
INSERT INTO `cms_contest_group` VALUES ('152', '68', '小组3', '7', '123.45');
INSERT INTO `cms_contest_group` VALUES ('153', '68', '小组4', '8', '123.45');

-- ----------------------------
-- Table structure for cms_enrollment_record
-- ----------------------------
DROP TABLE IF EXISTS `cms_enrollment_record`;
CREATE TABLE `cms_enrollment_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contest_id` bigint(20) DEFAULT NULL COMMENT '赛事id',
  `contest_group_id` bigint(20) DEFAULT NULL COMMENT '组别id',
  `open_id` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` int(2) DEFAULT NULL COMMENT '类型：0->小程序报名生成;1->主办方导入生成',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mail_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮寄地址',
  `contestant_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者号码牌',
  `contestant_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者状态：0->未参赛; 1->未完赛; 2->完赛',
  `contestant_rank` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者排名',
  `contestant_achievement` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者成绩(时间、长度等量化指标)',
  `contestant_award` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者获得奖项，由主办方导入',
  `status` int(2) DEFAULT '0' COMMENT '0正常支付 1删除  2衍生的临时数据',
  `contestant_real_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者真实姓名',
  `contestant_ID_card` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者证件号码',
  `order_id` bigint(20) DEFAULT NULL COMMENT '由哪个订单创建。没有则留空',
  `phone_number` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='报名记录（参赛记录）表,用户自行支付后生成，或者由主办方导入';

-- ----------------------------
-- Records of cms_enrollment_record
-- ----------------------------
INSERT INTO `cms_enrollment_record` VALUES ('22', '69', '116', 'abcd', '1', '2020-04-04 19:29:49', 'address', '100862019', '1', '11', '4小时5分钟', '二等奖', '1', '村真实', '450521200011202118', '76', null);
INSERT INTO `cms_enrollment_record` VALUES ('23', '70', '117', 'abcd', '1', '2020-04-04 19:29:45', 'address', '100862020', '2', '23', '4小时28分钟', '一等奖', '0', '村长', '450666666661202118', '77', null);
INSERT INTO `cms_enrollment_record` VALUES ('24', '69', '116', 'abcd', '1', '2020-04-04 19:29:49', 'address', '100862019', '1', '11', '4小时5分钟', '二等奖', '0', '村真实', '450521200011202118', '76', null);
INSERT INTO `cms_enrollment_record` VALUES ('25', '70', '117', 'abcd', '1', '2020-04-04 19:29:45', 'address', '100862020', '2', '23', '4小时28分钟', '一等奖', '0', '村长', '450666666661202118', '77', null);
INSERT INTO `cms_enrollment_record` VALUES ('26', '69', '116', 'abcd', '1', '2020-04-04 19:29:49', 'address', '100862019', '1', '11', '4小时5分钟', '二等奖', '0', '村真实', '450521200011202118', '76', null);
INSERT INTO `cms_enrollment_record` VALUES ('27', '70', '117', 'abcd', '1', '2020-04-04 19:29:45', 'address', '100862020', '2', '23', '4小时28分钟', '一等奖', '1', '村长', '450666666661202118', '77', null);
INSERT INTO `cms_enrollment_record` VALUES ('28', '69', '116', 'abcd', '1', '2020-04-04 19:29:49', 'address', '100862019', '1', '11', '4小时5分钟', '二等奖', '0', '村真实', '450521200011202118', '76', null);
INSERT INTO `cms_enrollment_record` VALUES ('29', '70', '117', 'abcd', '1', '2020-04-04 19:29:45', 'address', '100862020', '2', '23', '4小时28分钟', '一等奖', '1', '村长', '450666666661202118', '77', null);
INSERT INTO `cms_enrollment_record` VALUES ('30', '69', '116', 'abcd', '1', '2020-04-04 19:29:49', 'address', '100862019', '1', '11', '4小时5分钟', '二等奖', '1', '村真实', '450521200011202118', '76', null);
INSERT INTO `cms_enrollment_record` VALUES ('31', '70', '117', 'abcd', '1', '2020-04-04 19:29:45', 'address', '100862020', '2', '23', '4小时28分钟', '一等奖', '1', '村长', '450666666661202118', '77', null);
INSERT INTO `cms_enrollment_record` VALUES ('32', '69', '116', 'string', null, null, 'string', null, null, null, null, null, '0', null, null, '95', null);
INSERT INTO `cms_enrollment_record` VALUES ('33', '69', '116', 'string', null, '2020-04-06 21:05:28', 'string', null, null, null, null, null, '2', 'string', 'string', '96', null);
INSERT INTO `cms_enrollment_record` VALUES ('34', '69', '117', 'string', null, '2020-04-06 21:05:43', 'string', null, null, null, null, null, '2', 'string', 'string', '97', null);
INSERT INTO `cms_enrollment_record` VALUES ('35', '69', '116', 'string', null, '2020-04-06 21:08:29', 'string', null, null, null, null, null, '2', 'string', 'str1ing', '98', '189');
INSERT INTO `cms_enrollment_record` VALUES ('36', '69', '116', 'abcd', null, '2020-04-06 21:15:25', 'hepuxianshagangzhen01', null, null, null, null, null, '0', 'zhenshi', '450521200011202119', '99', '18934777393');
INSERT INTO `cms_enrollment_record` VALUES ('37', '69', '121', 'abcd', null, '2020-04-06 21:23:56', '11', null, null, null, null, null, '0', '1', '11', '100', '11');
INSERT INTO `cms_enrollment_record` VALUES ('38', '69', '121', 'abcd', null, '2020-04-06 21:25:28', 'grg r', null, null, null, null, null, '0', 'gre ', 'gr ', '101', 'grg ');
INSERT INTO `cms_enrollment_record` VALUES ('39', '69', '116', 'abcd', null, '2020-04-06 21:26:06', 'eeeee', null, null, null, null, null, '0', 'er ', 'r', '102', 'e');
INSERT INTO `cms_enrollment_record` VALUES ('40', '69', '116', 'abcd', null, '2020-04-06 21:31:20', '', null, null, null, null, null, '0', '', '', '103', '');
INSERT INTO `cms_enrollment_record` VALUES ('41', '69', '116', 'abcd', null, '2020-04-06 21:32:49', '', null, null, null, null, null, '2', '', '1425', '104', '');
INSERT INTO `cms_enrollment_record` VALUES ('42', '69', '116', 'abcd', null, '2020-04-06 21:34:35', '', null, null, null, null, null, '2', '', '14253', '105', '');
INSERT INTO `cms_enrollment_record` VALUES ('43', '69', '116', 'abcd', null, '2020-04-06 21:37:21', '', null, null, null, null, null, '2', '', '7', '106', '');
INSERT INTO `cms_enrollment_record` VALUES ('44', '69', '116', 'abcd', null, '2020-04-06 21:45:24', '', null, null, null, null, null, '0', '', '//8', '107', '');
INSERT INTO `cms_enrollment_record` VALUES ('45', '69', '116', 'abcd', null, '2020-04-06 21:47:19', '', null, null, null, null, null, '0', '', '443', '108', '');
INSERT INTO `cms_enrollment_record` VALUES ('46', '69', '116', 'abcd', null, '2020-04-06 21:48:08', '', null, null, null, null, null, '0', '', 'hythy', '109', '');

-- ----------------------------
-- Table structure for cms_favorite
-- ----------------------------
DROP TABLE IF EXISTS `cms_favorite`;
CREATE TABLE `cms_favorite` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contest_id` bigint(20) DEFAULT NULL COMMENT '赛事id',
  `open_id` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信用户标识',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收藏创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户收藏表';

-- ----------------------------
-- Records of cms_favorite
-- ----------------------------
INSERT INTO `cms_favorite` VALUES ('7', '0', 'string', null);

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `contest_id` bigint(20) DEFAULT NULL,
  `contest_group_id` bigint(20) DEFAULT NULL,
  `open_id` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付人标识',
  `status` int(11) DEFAULT NULL COMMENT '支付状态: 0->未支付;1->已支付;2->申请退款; 3->已退款; 4->临时加锁',
  `mail_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮寄地址',
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单备注',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '金额',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `payment_time` datetime DEFAULT NULL COMMENT '订单支付时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='订单表';

-- ----------------------------
-- Records of oms_order
-- ----------------------------
INSERT INTO `oms_order` VALUES ('70', '69', '1', 'eee', '3', '广西北海市合浦县沙岗镇01号', null, '123.45', '2020-03-23 20:23:05', '2020-04-03 01:20:50');
INSERT INTO `oms_order` VALUES ('71', '69', '1', 'eee', '3', '广西北海市合浦县沙岗镇01号', null, '123.45', '2020-03-23 20:23:05', '2020-04-03 01:20:50');
INSERT INTO `oms_order` VALUES ('72', '69', '1', 'eee', '1', '广西北海市合浦县沙岗镇01号', null, '123.45', '2020-03-23 20:23:05', '2020-04-03 01:20:50');
INSERT INTO `oms_order` VALUES ('76', '69', '153', 'abcd', '1', '广西桂林市合浦县沙岗镇01号1', '', '123.45', '2020-03-23 20:23:03', '2020-04-03 01:20:50');
INSERT INTO `oms_order` VALUES ('77', '69', '153', 'abcd', '5', '广西桂林市合浦县沙岗镇01号2', null, '123.45', '2020-04-03 22:02:15', '2020-04-04 00:53:30');
INSERT INTO `oms_order` VALUES ('78', '69', '153', 'abcd', '1', '广西桂林市合浦县沙岗镇01号3', null, '123.45', '2020-04-03 22:02:18', '2020-04-04 00:53:05');
INSERT INTO `oms_order` VALUES ('79', '69', '153', 'abcd', '1', '广西桂林市合浦县沙岗镇01号4', null, '123.45', '2020-04-03 22:02:21', '2020-04-03 23:51:43');
INSERT INTO `oms_order` VALUES ('80', '69', '153', 'abcd', '1', '广西桂林市合浦县沙岗镇01号5', null, '123.45', '2020-04-03 22:02:25', '2020-04-03 23:55:10');
INSERT INTO `oms_order` VALUES ('81', '69', '153', 'abcd', '1', '广西桂林市合浦县沙岗镇01号6', '', '123.45', '2020-03-23 20:23:03', '2020-04-03 01:20:50');
INSERT INTO `oms_order` VALUES ('82', '69', '153', 'abcd', '5', '广西桂林市合浦县沙岗镇01号7', '', '123.45', '2020-04-03 22:02:15', '2020-04-04 00:53:30');
INSERT INTO `oms_order` VALUES ('83', '69', '153', 'abcd', '1', '广西桂林市合浦县沙岗镇01号8', '', '123.45', '2020-04-03 22:02:18', '2020-04-04 00:53:05');
INSERT INTO `oms_order` VALUES ('84', '69', '153', 'abcd', '1', '广西桂林市合浦县沙岗镇01号9', '', '123.45', '2020-04-03 22:02:21', '2020-04-03 22:23:55');
INSERT INTO `oms_order` VALUES ('85', '69', '153', 'abcd', '1', '广西桂林市合浦县沙岗镇01号10', '', '123.45', '2020-03-23 20:23:03', '2020-04-03 01:20:50');
INSERT INTO `oms_order` VALUES ('86', '69', '153', 'abcd', '5', '广西桂林市合浦县沙岗镇01号11', '', '123.45', '2020-04-03 22:02:15', '2020-04-04 00:53:30');
INSERT INTO `oms_order` VALUES ('88', '69', '153', 'abcd', '1', '广西桂林市合浦县沙岗镇01号13', '', '123.45', '2020-04-03 22:02:21', '2020-04-04 03:21:16');
INSERT INTO `oms_order` VALUES ('89', '69', '153', 'abcd', '1', '广西桂林市合浦县沙岗镇01号14', '', '123.45', '2020-04-03 22:02:25', '2020-04-04 03:19:06');
INSERT INTO `oms_order` VALUES ('90', '0', '107', 'abcd', '1', '', null, '0.00', '2020-04-04 18:59:42', '2020-04-04 19:03:31');
INSERT INTO `oms_order` VALUES ('95', '69', '116', 'string', '1', 'string', null, '250.00', '2020-04-06 20:51:26', '2020-04-06 20:52:53');
INSERT INTO `oms_order` VALUES ('99', '69', '116', 'abcd', '1', 'hepuxianshagangzhen01', null, '250.00', '2020-04-06 21:15:25', '2020-04-06 21:26:33');
INSERT INTO `oms_order` VALUES ('100', '69', '121', 'abcd', '1', '11', null, '280.00', '2020-04-06 21:23:56', '2020-04-06 21:26:31');
INSERT INTO `oms_order` VALUES ('101', '69', '121', 'abcd', '1', 'grg r', null, '280.00', '2020-04-06 21:25:28', '2020-04-06 21:25:31');
INSERT INTO `oms_order` VALUES ('102', '69', '116', 'abcd', '1', 'eeeee', null, '250.00', '2020-04-06 21:26:06', '2020-04-06 21:26:08');
INSERT INTO `oms_order` VALUES ('103', '69', '116', 'abcd', '1', '', null, '250.00', '2020-04-06 21:31:20', '2020-04-06 21:31:23');
INSERT INTO `oms_order` VALUES ('107', '69', '116', 'abcd', '1', '', null, '250.00', '2020-04-06 21:45:24', '2020-04-06 21:45:26');
INSERT INTO `oms_order` VALUES ('108', '69', '116', 'abcd', '1', '', null, '250.00', '2020-04-06 21:47:19', '2020-04-06 21:47:21');
INSERT INTO `oms_order` VALUES ('109', '69', '116', 'abcd', '1', '', null, '250.00', '2020-04-06 21:48:08', '2020-04-06 21:48:11');

-- ----------------------------
-- Table structure for sms_topic
-- ----------------------------
DROP TABLE IF EXISTS `sms_topic`;
CREATE TABLE `sms_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布者id',
  `contest_id` bigint(20) DEFAULT NULL COMMENT '所属赛事id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '所属主题：如果是回复则为主题id，如果是主题则为0',
  `text` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文本内容',
  `attachment` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片等附件',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='社交话题';

-- ----------------------------
-- Records of sms_topic
-- ----------------------------
INSERT INTO `sms_topic` VALUES ('1', 'abcd', '69', '0', '哈哈哈,我是01主题', '', '2020-03-15 19:12:57');
INSERT INTO `sms_topic` VALUES ('2', 'abcd', '69', '0', '我是02主题', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-15 19:52:52');
INSERT INTO `sms_topic` VALUES ('3', 'abcd', '69', '1', '666', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-15 20:07:27');
INSERT INTO `sms_topic` VALUES ('6', 'abcd', '69', '1', '天气不错，北京马拉松我来啦', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-15 20:53:04');
INSERT INTO `sms_topic` VALUES ('7', 'abcd', '69', '1', '866', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-15 20:54:58');
INSERT INTO `sms_topic` VALUES ('8', 'abcd', '69', '1', '\"text\": \"66? In Love Face6\", \"at', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-15 20:55:21');
INSERT INTO `sms_topic` VALUES ('10', 'abcd', '69', '0', '我的被解为我是10主题', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-15 20:58:43');
INSERT INTO `sms_topic` VALUES ('18', 'abcd', '69', '10', '4278278', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-15 21:32:00');
INSERT INTO `sms_topic` VALUES ('19', 'abcd', '69', '10', '42782782875', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-15 21:32:03');
INSERT INTO `sms_topic` VALUES ('20', 'abcd', '69', '10', '6', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-15 22:33:30');
INSERT INTO `sms_topic` VALUES ('21', 'abcd', '69', '10', '加油啊', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-17 15:46:29');
INSERT INTO `sms_topic` VALUES ('22', 'abcd', '69', '10', 'good', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-17 15:46:41');
INSERT INTO `sms_topic` VALUES ('23', 'abcd', '69', '10', 'we can', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-17 15:46:50');
INSERT INTO `sms_topic` VALUES ('24', 'abcd', '69', '10', '哈哈，一起加油！', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-17 15:46:58');
INSERT INTO `sms_topic` VALUES ('25', 'abcd', '69', '0', '最新的我是25主题', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-17 18:20:22');
INSERT INTO `sms_topic` VALUES ('47', 'abcd', '69', '0', 'string我是47主题', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-17 21:39:59');
INSERT INTO `sms_topic` VALUES ('48', 'abcd', '69', '0', 'string我是48主题', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-17 21:40:04');
INSERT INTO `sms_topic` VALUES ('49', 'abcd', '69', '0', '主题啦啦啦', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-17 21:41:27');
INSERT INTO `sms_topic` VALUES ('50', 'abcd', '69', '0', '哦是主题可行', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-18 17:19:22');
INSERT INTO `sms_topic` VALUES ('51', 'abcd', '69', '0', '哦是主题可行', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-21 13:20:20');
INSERT INTO `sms_topic` VALUES ('52', 'abcd', '69', '0', '哦是主题可行', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-24 01:22:05');
INSERT INTO `sms_topic` VALUES ('53', 'abcd', '69', '0', '哦是主题可行', '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '2020-03-30 00:21:46');
INSERT INTO `sms_topic` VALUES ('54', 'abcd', '69', '0', '哦是主题可行66666', null, '2020-04-07 03:11:37');
INSERT INTO `sms_topic` VALUES ('55', 'abcd', '69', '0', '8910', null, '2020-04-07 03:12:31');
INSERT INTO `sms_topic` VALUES ('56', 'abcd', '69', '0', '1111', 'cc778e759edb42d3a888c94cb82b09c8.png', '2020-04-07 20:51:45');
INSERT INTO `sms_topic` VALUES ('57', 'abcd', '69', '0', '11113', 'cc778e759edb42d3a888c94cb82b09c8.png', '2020-04-07 20:52:15');
INSERT INTO `sms_topic` VALUES ('58', 'abcd', '69', '0', '11113', 'cc778e759edb42d3a888c94cb82b09c8.png,13b47b6aa1914095a78c43b1bfd83120.png', '2020-04-07 20:54:08');
INSERT INTO `sms_topic` VALUES ('59', 'string', '0', '0', 'string', 'string', '2020-04-08 16:20:55');
INSERT INTO `sms_topic` VALUES ('60', 'abcd', '69', '0', '天气好', 'bf9090849edb4964b0fb4cd6945c1733.png', '2020-04-08 16:43:02');
INSERT INTO `sms_topic` VALUES ('61', 'abcd', '69', '0', '天气好', 'bf9090849edb4964b0fb4cd6945c1733.png', '2020-04-08 16:43:20');
INSERT INTO `sms_topic` VALUES ('62', 'abcd', '69', '0', null, '', '2020-04-08 16:43:39');
INSERT INTO `sms_topic` VALUES ('63', 'abcd', '69', '0', '天气好', '', '2020-04-08 16:44:05');
INSERT INTO `sms_topic` VALUES ('64', 'abcd', '69', '63', null, '', '2020-04-08 17:08:02');
INSERT INTO `sms_topic` VALUES ('65', 'abcd', '69', '0', null, '', '2020-04-08 17:20:41');
INSERT INTO `sms_topic` VALUES ('66', 'abcd', '69', '0', null, '', '2020-04-08 17:23:04');
INSERT INTO `sms_topic` VALUES ('67', 'abcd', '69', '0', '11111', '', '2020-04-08 17:24:22');
INSERT INTO `sms_topic` VALUES ('68', 'abcd', '69', '0', '1212', '', '2020-04-08 17:24:42');
INSERT INTO `sms_topic` VALUES ('69', 'abcd', '69', '0', null, '', '2020-04-08 17:33:03');
INSERT INTO `sms_topic` VALUES ('70', 'abcd', '69', '0', '发一个', '', '2020-04-08 17:34:28');
INSERT INTO `sms_topic` VALUES ('71', 'abcd', '69', '0', null, '', '2020-04-08 17:37:01');
INSERT INTO `sms_topic` VALUES ('72', 'abcd', '69', '0', '再来一个', '', '2020-04-08 17:37:35');
INSERT INTO `sms_topic` VALUES ('73', 'abcd', '69', '0', '666', '', '2020-04-08 17:37:46');
INSERT INTO `sms_topic` VALUES ('74', 'abcd', '69', '0', null, '', '2020-04-08 17:40:04');
INSERT INTO `sms_topic` VALUES ('75', 'abcd', '69', '0', '我来咯', 'd8f9c829014f49f9a8b06c4fbfc1b63a.png', '2020-04-08 17:52:28');
INSERT INTO `sms_topic` VALUES ('76', 'abcd', '69', '75', '哈哈~', '', '2020-04-08 17:53:25');
INSERT INTO `sms_topic` VALUES ('77', 'abcd', '69', '75', '哟', '', '2020-04-08 17:58:06');
INSERT INTO `sms_topic` VALUES ('78', 'abcd', '69', '75', '不错~~~', '86c04a0966ea4e9fbdd9c7ee45140035.png', '2020-04-08 17:58:45');
INSERT INTO `sms_topic` VALUES ('79', 'abcd', '69', '75', '咋爱来', '', '2020-04-08 17:58:58');
INSERT INTO `sms_topic` VALUES ('80', 'abcd', '69', '75', '666', '', '2020-04-08 17:59:06');
INSERT INTO `sms_topic` VALUES ('81', 'abcd', '69', '0', '我来啦！！！', '8369554eebfc4c0b886e8138c9a8dc1d.png', '2020-04-08 18:00:32');
INSERT INTO `sms_topic` VALUES ('82', 'abcd', '69', '81', '666666', '', '2020-04-08 18:00:56');
INSERT INTO `sms_topic` VALUES ('83', 'abcd', '69', '81', '666666', '', '2020-04-08 18:01:01');
INSERT INTO `sms_topic` VALUES ('84', 'abcd', '69', '0', '两张', 'a9cd868eeb414f91acbf8d0d35add80b.png,5cf8fec7f10d4238ac1d36d325626d7b.png', '2020-04-08 18:32:48');
INSERT INTO `sms_topic` VALUES ('85', 'abcd', '69', '0', '5', 'c7e5a5d10c704e4c93d72eb951adfbd3.png,efd1b745a8154f28abf2868589462d3b.png,e4f0cbe03f2144e0908831bdebefcd82.png,a6a2bacb4537440b900a01ee0d22c8c7.png,7d0021702f7846edb55afd1513a18b43.png', '2020-04-08 18:34:20');
INSERT INTO `sms_topic` VALUES ('86', 'abcd', '69', '84', '评论', '35847b657fab482d9faa00baca80f1a1.png,f58be147700144128cf3c66605498f0f.png,09ea0ef9a6d44fa2bb4f6e656d911739.png,6b19ea29e5884d96bfa0503971af1add.png,f51b853d6fde45408f82466347fdc43c.png', '2020-04-08 19:06:36');
INSERT INTO `sms_topic` VALUES ('87', 'abcd', '69', '85', '加油~', '', '2020-04-08 19:12:40');
INSERT INTO `sms_topic` VALUES ('88', 'abcd', '69', '85', '冲啊', '663f397432364722b6b07f3b043708f9.png', '2020-04-08 19:12:51');
INSERT INTO `sms_topic` VALUES ('89', 'abcd', '70', '0', '桂林第一帖子', '', '2020-04-09 17:04:21');
INSERT INTO `sms_topic` VALUES ('90', 'abcd', '76', '0', '1011010101', '1b240f0508f04a9aaa7ea681b7412413.png', '2020-04-09 17:27:29');
INSERT INTO `sms_topic` VALUES ('91', 'abcd', '72', '0', '1', '', '2020-04-09 17:30:03');
INSERT INTO `sms_topic` VALUES ('92', 'abcd', '72', '91', '111111', '', '2020-04-09 17:30:11');
INSERT INTO `sms_topic` VALUES ('93', 'abcd', '72', '91', '212121212121', '', '2020-04-09 17:30:17');

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `status` int(2) DEFAULT '1' COMMENT '状态：0->停用、1->启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of ums_admin
-- ----------------------------
INSERT INTO `ums_admin` VALUES ('1', '110', '$2a$10$xFqC1jkVCaIjxO3c.LE3F.HUFPi1i/WT2Bi/nbFWzszPYNOZPdNfy', '2020-03-26 22:30:33', '1');

-- ----------------------------
-- Table structure for ums_constant
-- ----------------------------
DROP TABLE IF EXISTS `ums_constant`;
CREATE TABLE `ums_constant` (
  `open_id` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键，微信标识码',
  `nick_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信昵称',
  `real_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `avatar_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信头像地址',
  `phone_number` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `ID_card_number` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号码',
  `mail_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮寄地址',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '账户创建时间，即第一次登录时间',
  PRIMARY KEY (`open_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='微信小程序用户';

-- ----------------------------
-- Records of ums_constant
-- ----------------------------
INSERT INTO `ums_constant` VALUES ('abcd', '村长的昵称', '村真实', 'logo.png', '18934777393', '450521199811202118', '广西北海市合浦县沙岗镇01号', '2020-03-17 17:29:05');
INSERT INTO `ums_constant` VALUES ('c', 'cdename', null, 'cimggggg', null, null, null, '2020-03-17 17:29:13');
INSERT INTO `ums_constant` VALUES ('d', 'cdename', null, 'dimggggg', null, null, null, '2020-03-17 17:29:16');
INSERT INTO `ums_constant` VALUES ('e', null, null, null, null, null, null, '2020-03-17 18:35:24');
INSERT INTO `ums_constant` VALUES ('eee', '村长的昵称', '村真实', 'http头像地址', '18934777393', '450521199811202118', '广西北海市合浦县沙岗镇01号', '2020-03-17 17:29:05');

-- ----------------------------
-- Table structure for ums_organizer
-- ----------------------------
DROP TABLE IF EXISTS `ums_organizer`;
CREATE TABLE `ums_organizer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登陆用户名',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登陆密码',
  `open_id` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '可绑定的微信账户',
  `admin_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主办方管理员姓名',
  `admin_phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主办方管理员电话号码，用于实名认证',
  `admin_ID_card` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主办方管理员身份证号',
  `organizer_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主办方全称，个人则填写真实姓名',
  `organizer_type` int(11) DEFAULT NULL COMMENT '单位属性: 1->政府与事业单位; 2->企业; 3->其他组织; 4->个人  ',
  `organizer_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '组织机构代码:9位组织机构代码，或18位统一社会信用代码，或15位注册号, 或18位身份证号码',
  `identity_document` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资质证明材料,包含机构和管理员',
  `status` int(11) DEFAULT '-1' COMMENT '状态:-1->初始态; 0->等待审核、1->审核通过、2->审核未通过； 3->停用； 4->删除标记',
  `last_check_id` bigint(20) DEFAULT NULL COMMENT '最近一次审核人id',
  `last_check_time` datetime DEFAULT NULL COMMENT '最近一次审核时间',
  `last_check_note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最近一次审核批注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='主办方';

-- ----------------------------
-- Records of ums_organizer
-- ----------------------------
INSERT INTO `ums_organizer` VALUES ('1', null, null, null, null, null, null, null, null, null, '754ca045f0fd40e1aed755b9d7ee7994.png,893f941d14aa4f0c85950eda3dfd9041.png,e0b2fcd88a2449208a4f297ce3bba9f5.png', '0', '0', null, 'lastGreg人日日日', '2020-03-25 22:25:59');
INSERT INTO `ums_organizer` VALUES ('2', '111', '111', null, null, null, null, null, null, null, null, '1', '0', null, 'lastGreg人日日日', '2020-03-25 22:25:59');
INSERT INTO `ums_organizer` VALUES ('3', 'string', 'string', null, null, null, null, null, null, null, null, '0', null, null, null, null);
INSERT INTO `ums_organizer` VALUES ('4', '2525', '666111666', null, null, null, null, null, null, null, null, '-1', null, null, null, '2020-03-25 23:50:59');

-- ----------------------------
-- Table structure for ums_organizer_staff
-- ----------------------------
DROP TABLE IF EXISTS `ums_organizer_staff`;
CREATE TABLE `ums_organizer_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contest_id` bigint(20) DEFAULT NULL COMMENT '关联赛事id',
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色',
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  `status` int(2) DEFAULT '1' COMMENT '状态：0->停用; 1->启用',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='主办方工作人员（志愿者），由系统生成并导出';

-- ----------------------------
-- Records of ums_organizer_staff
-- ----------------------------
INSERT INTO `ums_organizer_staff` VALUES ('1', null, 'c80e96dabe3d4ae8b1cb188372d59cdf', 'fba9322bbbef408f98fc9ef2c8339dad', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('2', null, 'b1aa5c62c0f4461489e450be9a889acc', '5340da8d4c454421bb279616643dea76', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('3', null, 'dfbfc44784a1464b9c5f66b61e9395ab', '4a3fbe8f8a904a26a8b1946d24745cd3', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('4', null, '51ff42e3e9de471eb45a3826da959d13', '1e1be76b49364bccb32db5a2164d52d0', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('5', null, '2d8f57eed7ce40dbb42f5f16d84ca3bd', 'aebb87a14e4042019ff694f1744d8b1d', 'role-1', null, '0', null);
INSERT INTO `ums_organizer_staff` VALUES ('6', null, 'b16005115f84403992a41e7d34034601', '6f37770e9e2b40739ff76c6c1da73df6', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('7', null, '70a7640bef6c4f3eb38fb0849e4c1082', '8a47ef44a95e47cf8263f660cb1d605c', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('8', null, 'd962e10674ec4540add5bd98704128bb', '9fad4e21d13340a28a1764ebf4cc8403', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('9', null, 'adf838beb76e4c4fab6f9c073a1a77ec', '39d5148a286d49a8a6a443f74a7c7eb2', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('10', null, 'ee07e6fe12094ef09663d1336fe82bed', 'b0e5a020792f43238bd8f7b5fb30e191', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('11', '0', '53418af6a10e4c2bbdb5ca55b6e5aab9', '2290054078884ce3ad71494cd6f471ae', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('12', '0', 'f5fa2f847b8449d5bdced7ec20556759', '9803ce9616114c71b81f6eb656fb14f7', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('13', '0', 'ca12c60601874e679188b69eb58ef540', '3dc31cec0dc54b808d4ac10d45cd9c40', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('14', '0', 'bfae1f9a07f3412987d7ab70bae8a5bb', '8133b541500f4befbaf24ace34d90d2a', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('15', '0', '3a16c0863502497f85813c4205e27aa4', 'ea1ccd16653a44fc89fa239e9b23527a', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('16', '0', 'f61de90a9454436193efcdb58e76076e', '5a3f454136504b4ab7b477d7bef6382f', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('17', '0', '8d3e8ed581fc4ea1b3204fd5479a0eb0', '272e9c2679b844ceb8b602ca56da527c', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('18', '0', '3d9e544ef49a4fd18c3566efa061d44f', 'f9878a28d5dc4231a6180d31670fe0fd', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('19', '0', 'a6315015a4a54d30bfca0b98e19bd332', 'c6783301df0f42fa9c79ebe81b292c7b', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('20', '0', 'a56adefc332245ca8145431bcaccfd0c', '56914476502c4ffb96db1eb98282d33a', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('21', '0', '3badb522e91f494da1d24244b1cd00d2', 'e4ce91cbdd444280ae5fc9931dd64534', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('22', '0', '02cc68366e94400f98f9037399de4cf5', '03f2baddc44840a0bfd4f3c63915530f', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('23', '0', 'a1137af66c174f0bbb27992b1c14eb9e', 'fb7b3225f93b4bb18917345769f243b4', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('24', '0', '69c58161d65b437dbf3de597840f8e5d', 'a619b090d50a41238d35fb97e6a1d115', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('25', '0', 'f2eddccf8f9c475fa7381b427eb610a7', '9b23be293db642b1b3bcbc98e6f5fc51', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('26', '0', '8bcd8ee161834e34a09ae3c921fa5198', '251c5400bdc54717a9b84cf16468e342', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('27', '0', '17f883f4ca324f55a5b78a4b13006e85', '7a63fdf42f80436fb1c014271808cec4', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('28', '0', '3c509e387f8544099a0427c3d081d177', '45ff941d61764f8492c12f613775eb35', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('29', '0', '45b729b97aa84d15b9a93e38b6e4638c', '2c5a190509bc4155846852d78660d6b4', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('30', '0', '66184fc6c7a84abbbdeefec393872691', 'd70baf2875c94b68ae566088f4bde3cf', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('31', '0', 'e3861b084ac44cf78988c21105996160', 'd8c32294f9fa4928a80c9a07b4bcc1e5', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('32', '0', 'f84d484b6fb84454a89496bdf5e2352d', '44f35c70c19d446db62dbba65cad1995', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('33', '0', '580b334ffa424ee588836df82b1b32c0', '477caf4c316b49ff973e0082517e1fb5', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('34', '0', '93976c1d1e984d2985405099c3da97ed', '2801c98e8bac46c588c48bbcead4b09f', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('35', '0', '319d919927644379814a65ff53063e2b', '2142fb81e7a941c3b914d30a7e53999d', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('36', '0', 'ec68bad83a6b4d87bffbd7b306bf86ea', '4174f62c9e9f4d4b98d38e1b73ed0891', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('37', '0', 'c3ae40732dd64b5c85e128ba9eac9b58', '17b2781f34be40f38ee9efc219969154', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('38', '0', '990bc58c32864ef88170f03409083394', '52a3fcf0011046a7b635c7f03afe8c8f', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('39', '0', '593808b2107d40bb83882cd1ac6d2b6b', '8a0cacd7ce64497982c2d06e4e028100', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('40', '0', '52e663194a6740f8b3f0b29255ee46da', '2d265402a5604591876c02e93f3fdac4', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('41', '0', '4573399fc47a4cc8bde8b7a2f3ae4e53', '110e4a9236d640159bb355e8e42ed05d', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('42', '0', 'f9552536764b4e47a4f484e16f111735', 'cec50085ec0a45679119360d64c34c20', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('43', '0', '9192b83c733f43b38f41978a8dca3d65', '0b7e6f8ff712486e9c5e6343982d4ff8', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('44', '0', '182ded7cb07048318afce03f51c912a1', 'f710215072cc4e5f90053b512a108ba9', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('45', '0', '71683e915a1a40ae8df5c707b063931c', 'bd61752c083b41f18849919307acb3bc', 'role-1', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('46', '1', '083284cf4c554af6aa9d7dff46e651e9', 'd48d5ed27ae94a8a82c14378a5ac59fc', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('47', '1', 'd0ddb6dc5dea4d1b8b74aa89cc885457', 'e980647658ff47ca9d3c349002dd6bd6', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('48', '1', 'd5cdbda3b9444d08981f715b19de6c94', 'addebb0b7e3c49abade3fcfc0dca208b', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('49', '1', '1cf1c14119af4143948f9861145097ce', '6e9dafb7e2554d6f82739c2a17741120', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('50', '1', 'd97b2f57aea440f98f182556cc64aaae', 'b8fde38c92f54de284f64ad2bafb6ebf', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('51', '1', '0a7d11f62b714da3845119878bad4813', '7d1d8e85d5fe47fc8775e8a46e9e1161', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('52', '1', '1ef11fa665774a4a9fb2fd7ca20d988d', '074373d638db43e18106e9d4c24774e1', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('53', '1', '61b438d603984252b681d424d74f385f', '2d1a20fc3400440bba69b14298101703', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('54', '1', '64659fea49fb4f209e9406dd94891e96', '935acf8b060242f896e43b7fa4e5c51c', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('55', '1', 'ee8abcc6b0fb42cb89126ec97aa2c24e', '26e65a3ae6d746409eb474e0aba534ad', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('56', '1', 'f5835f80a0424cbeadc1d9907f296060', 'ebecda48b08742cba829e70054812d5e', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('57', '1', '89ce8667032141ccbf4179afde08f7f9', 'bdeec65a5063494187ffeed0e8aaae00', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('58', '1', 'ca6c97c579d747bb9ee1dc2d4a46c42d', '77f4fd7a438a45b881b4352916d57760', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('59', '1', '71d48d33e7b841abb1446402d41bde16', 'db8152ed7cc94763963643ffd114fc29', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('60', '1', 'a5983d1f1ae44582b95cfcc441352514', '6732b792bf404bdf9204c005cbed4db0', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('61', '1', 'f4c9463da97c40cf8a5ac0d17564b009', '13b4894798564c07bd1934a7261451c9', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('62', '1', '140bb33213ca4bd3b5fb582d44cd365b', 'fca5b199d6bb48e4bb0cefd97a1f5083', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('63', '1', '34c5ffded6314698a6446b88a20ad8f8', '00ade96f64e841c4b6fc0e7dcf9dfbb7', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('64', '1', '31f1e3ef4ba24578815903ace9f950f9', 'e5a033ca821e46e897e6e457874576db', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('65', '1', '6b4d0a38ebd14f7ca6feadc3f0ad3e8d', 'a83abe2c6d88495d8628a4699658383b', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('66', '1', '9614d5374243417a81fad8688f106919', '1b2093021dd14fc58cd5ad2cbb267831', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('67', '1', '3d7cbd814d4e4a4793f0541538e0427f', '14804144094b473e860946db49f63d8b', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('68', '1', '7bb5715ea9e5434d8e3eb115dc09b80a', '7bc5a05ee5f641bf87a187cb77f22536', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('69', '1', 'dbc430c1d0644e67bb593a5d2534aa13', '97ab584c7b3f4445939e66da9221132c', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('70', '1', 'e17fd05c13404f3296f4b4c2aa1a266f', 'f9b0b53018f54cce844d4b63428fa4b8', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('71', '1', '3e0f7c320e124b30a81804fb24d82ffa', '216b21de52c748c0939a7184ef019202', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('72', '1', '6adf6b2e741346268d1979225ea722a4', '165fdcaa3a7f4949b9b3009701d83066', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('73', '1', 'e44bf4bc8c2c4107ae58361a75d7ce53', '97bbab3a114d419b9ea0d5c056f47971', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('74', '1', '3408d12d29e74e92af11e711c8e1d931', 'f5774f4cb754445d8f8fcaa6b79309d2', 'string', null, '1', null);
INSERT INTO `ums_organizer_staff` VALUES ('75', '1', 'b8d5a7649afb49c0bf340528f32ff2dc', 'c45b46c454d044c3b1325d1a0bb2ccb9', 'string', null, '1', null);

-- ----------------------------
-- Table structure for ums_resource
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource`;
CREATE TABLE `ums_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源显示名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '所属父级id',
  `type` int(2) DEFAULT NULL COMMENT '资源类别：1->菜单；2->接口; 3->按钮',
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '接口地址',
  `permission` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限标识',
  `component` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '对应前端组件（路由）地址',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细描述',
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标地址：资源类别为菜单时才设置',
  `sort` int(11) DEFAULT '0' COMMENT '显示顺序：按小到大排序',
  `status` int(2) DEFAULT '1' COMMENT '资源状态：0->停用；1->启用;',
  `admin_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='权限资源表（菜单、按钮、接口）';

-- ----------------------------
-- Records of ums_resource
-- ----------------------------
INSERT INTO `ums_resource` VALUES ('1', 'string', '0', '0', 'string', 'pms:product:read', 'string', 'string', 'string', '0', '1', '0', '2020-03-29 17:40:01');
INSERT INTO `ums_resource` VALUES ('2', 'string', '0', '1', 'string', 'pms:product:create', 'string', 'string', 'string', '0', '1', '0', '2020-03-29 17:40:29');
INSERT INTO `ums_resource` VALUES ('3', 'string', '0', '1', 'string', 'pms:productCategory:read', 'string', 'string', 'string', '0', '1', '0', '2020-03-29 17:41:35');
INSERT INTO `ums_resource` VALUES ('4', 'string', '0', '1', 'string', 'pms:productAttribute:read', 'string', 'string', 'string', '0', '1', '0', '2020-03-29 17:41:38');
INSERT INTO `ums_resource` VALUES ('5', 'string', '0', '1', 'string', 'sms:topic:get', 'string', 'string', 'string', '0', '1', '0', '2020-03-29 17:41:38');
INSERT INTO `ums_resource` VALUES ('6', 'string', '0', '1', 'string', 'sms:topic:update', 'string', 'string', 'string', '0', '1', '0', '2020-03-29 17:41:38');
INSERT INTO `ums_resource` VALUES ('7', 'string', '0', '1', 'string', 'sms:topic:add', 'string', 'string', 'string', '0', '1', '0', '2020-03-29 17:41:38');
INSERT INTO `ums_resource` VALUES ('8', 'string', '0', '1', 'string', 'sms:topic:delete', 'string', 'string', 'string', '0', '1', '0', '2020-03-29 17:41:39');
INSERT INTO `ums_resource` VALUES ('9', 'string', '0', '1', 'string', 'cms:contest:get', 'string', 'string', 'string', '0', '1', '0', '2020-03-29 17:41:39');
INSERT INTO `ums_resource` VALUES ('10', 'string', '0', '1', 'string', 'cms:contest:add', 'string', 'string', 'string', '0', '1', '0', '2020-03-29 17:41:39');
INSERT INTO `ums_resource` VALUES ('11', 'string', '0', '11', 'string', 'cms:contest:update', 'string', 'string', 'string', '0', '0', '0', '2020-03-29 17:41:39');
INSERT INTO `ums_resource` VALUES ('13', 'string', '0', '0', 'string', 'cms:contest:delete', 'string', 'string', 'string', '0', '1', '0', '2020-03-29 18:59:28');
INSERT INTO `ums_resource` VALUES ('14', 'string', '0', '0', 'string', 'ums:admin:get', '组件', 'string', 'string', '0', '1', '0', '2020-03-29 18:59:38');

-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` int(2) DEFAULT '1' COMMENT '角色类型：1->内管系统； 2->主办方',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `admin_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO `ums_role` VALUES ('1', 'string', '角色1pre', '1', 'string', '0', '2020-03-26 22:26:44');
INSERT INTO `ums_role` VALUES ('2', 'string', '角色1', '1', '角色1', '0', '2020-03-26 22:27:08');
INSERT INTO `ums_role` VALUES ('3', 'string', '角色2', '1', '角色2', '0', '2020-03-26 22:27:18');
INSERT INTO `ums_role` VALUES ('4', 'string', '角色3', '1', '角色3', '1', '2020-03-26 22:27:25');
INSERT INTO `ums_role` VALUES ('5', 'tag tag', '角色4', '1', '角色4', '1', '2020-03-26 22:27:43');
INSERT INTO `ums_role` VALUES ('6', 'string', 'string', '1', 'string', '0', '2020-03-30 02:55:22');

-- ----------------------------
-- Table structure for ums_role_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_admin`;
CREATE TABLE `ums_role_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `admin_id` bigint(20) NOT NULL COMMENT '管理员id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of ums_role_admin
-- ----------------------------
INSERT INTO `ums_role_admin` VALUES ('1', '4', '1');
INSERT INTO `ums_role_admin` VALUES ('2', '5', '1');
INSERT INTO `ums_role_admin` VALUES ('3', '4', '9');
INSERT INTO `ums_role_admin` VALUES ('4', '5', '10');
INSERT INTO `ums_role_admin` VALUES ('5', '5', '11');

-- ----------------------------
-- Table structure for ums_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_resource`;
CREATE TABLE `ums_role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='角色资源关系表';

-- ----------------------------
-- Records of ums_role_resource
-- ----------------------------
INSERT INTO `ums_role_resource` VALUES ('1', '4', '7');
INSERT INTO `ums_role_resource` VALUES ('2', '4', '8');
INSERT INTO `ums_role_resource` VALUES ('3', '4', '9');
INSERT INTO `ums_role_resource` VALUES ('4', '5', '10');
INSERT INTO `ums_role_resource` VALUES ('5', '5', '11');
INSERT INTO `ums_role_resource` VALUES ('6', '5', '13');
