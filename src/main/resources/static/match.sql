/*
Navicat MySQL Data Transfer

Source Server         : challage.cn
Source Server Version : 50722
Source Host           : 119.23.28.245:3306
Source Database       : match

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-03-15 03:25:36
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
  `status` int(255) DEFAULT NULL COMMENT '状态（审核通过、等待审核、未通过、被主办方删除、取消等）',
  `last_check_id` bigint(20) DEFAULT NULL COMMENT '最近一次审核人id',
  `last_check_time` datetime DEFAULT NULL COMMENT '最近一次审核时间',
  `last_check_note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最近一次审核批注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='赛事信息表';

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='赛事拓展属性（这些信息在规程中也应详细指出）';

-- ----------------------------
-- Table structure for cms_contest_group
-- ----------------------------
DROP TABLE IF EXISTS `cms_contest_group`;
CREATE TABLE `cms_contest_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contest_id` bigint(20) DEFAULT NULL COMMENT '所属赛事id',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '组别名称',
  `size` int(11) DEFAULT NULL COMMENT '小组容量（初始最大，随着报名人数而减少）',
  `price` decimal(10,0) DEFAULT '0' COMMENT '价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='赛事分组';

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
  `contestant_status` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者完赛情况:未参赛、未完赛、完赛等',
  `contestant_rank` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者排名',
  `contestant_achievement` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者成绩(时间、长度等量化指标)',
  `contestant_award` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参赛者获得奖项，由主办方导入',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='报名记录（参赛记录）表,用户自行支付后生成，或者由主办方导入';

-- ----------------------------
-- Table structure for cms_favorite
-- ----------------------------
DROP TABLE IF EXISTS `cms_favorite`;
CREATE TABLE `cms_favorite` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contest_id` bigint(20) DEFAULT NULL COMMENT '赛事id',
  `open_id` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信用户标识',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收藏创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户收藏表';

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `contest_id` bigint(20) DEFAULT NULL,
  `contest_group_id` bigint(20) DEFAULT NULL,
  `open_id` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付人标识',
  `status` int(11) DEFAULT NULL COMMENT '支付状态: 0->未支付;1->已支付;2->已退费',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
  `note` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单备注',
  `price` decimal(10,0) DEFAULT '0' COMMENT '金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单表';

-- ----------------------------
-- Table structure for sms_topic
-- ----------------------------
DROP TABLE IF EXISTS `sms_topic`;
CREATE TABLE `sms_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布者id',
  `contest_id` bigint(20) DEFAULT NULL COMMENT '所属赛事id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '所属主题：如果是回复则为主题id，如果是主题则为0',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `text` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '文本内容',
  `attachment` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片等附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='社交话题';

-- ----------------------------
-- Table structure for ums_admin
-- ----------------------------
DROP TABLE IF EXISTS `ums_admin`;
CREATE TABLE `ums_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
  PRIMARY KEY (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='微信小程序用户';

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
  `status` int(11) DEFAULT '0' COMMENT '状态:0->未通过、1->通过、2->停用',
  `last_check_id` bigint(20) DEFAULT NULL COMMENT '最近一次审核人id',
  `last_check_time` datetime DEFAULT NULL COMMENT '最近一次审核时间',
  `last_check_note` datetime DEFAULT NULL COMMENT '最近一次审核批注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='主办方';

-- ----------------------------
-- Table structure for ums_organizer_staff
-- ----------------------------
DROP TABLE IF EXISTS `ums_organizer_staff`;
CREATE TABLE `ums_organizer_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contest_id` bigint(20) DEFAULT NULL COMMENT '关联赛事id',
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='主办方工作人员（志愿者），由系统生成并导出';

-- ----------------------------
-- Table structure for ums_resource
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource`;
CREATE TABLE `ums_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源显示名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '所属父级id',
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资源类别：meun->菜单；api->接口; button->按钮',
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '接口地址',
  `permission` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限标识',
  `component` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '对应前端组件（路由）地址',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细描述',
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图标地址：资源类别为菜单时才设置',
  `sort` int(11) DEFAULT '0' COMMENT '显示顺序：按小到大排序',
  `status` int(2) DEFAULT '1' COMMENT '资源状态：0->停用；1->启用;',
  `admin_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限资源表（菜单、按钮、接口）';

-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tag` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `group` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限组：0->为主办方内建的角色；1->内管系统角色',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `admin_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='角色表';
