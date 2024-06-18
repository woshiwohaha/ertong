CREATE DATABASE IF NOT EXISTS `child_care` default charset utf8 COLLATE utf8_general_ci;

USE `child_care`;
drop TABLE if EXISTS `admin_msg`;
CREATE TABLE IF NOT EXISTS `admin_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='管理员';


drop TABLE if EXISTS `user_msg`;
CREATE TABLE IF NOT EXISTS `user_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `login_name` varchar(255) DEFAULT NULL COMMENT '登录名',
 `password` varchar(255) DEFAULT NULL COMMENT '密码',
 `real_name` varchar(255) DEFAULT NULL COMMENT '昵称',
 `cel_phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
 `address` varchar(255) DEFAULT NULL COMMENT '地址',
 `create_time` varchar(30) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户';


drop TABLE if EXISTS `news_msg`;
CREATE TABLE IF NOT EXISTS `news_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `news_name` varchar(255) DEFAULT NULL COMMENT '标题',
 `notice_img` varchar(200) DEFAULT NULL COMMENT '图片',
 `news_detail` text  COLLATE utf8_bin DEFAULT NULL COMMENT '新闻详情',
 `aid` int(11) DEFAULT NULL COMMENT '发布人',
 `create_time` varchar(30) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='新闻';


drop TABLE if EXISTS `news_dis`;
CREATE TABLE IF NOT EXISTS `news_dis` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
 `nid` int(11) DEFAULT NULL COMMENT '新闻ID',
 `uid` int(11) DEFAULT NULL COMMENT '用户ID',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='新闻评论';


drop TABLE if EXISTS `act_msg`;
CREATE TABLE IF NOT EXISTS `act_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `act_name` varchar(255) DEFAULT NULL COMMENT '活动名',
 `act_img` varchar(200) DEFAULT NULL COMMENT '图片',
 `act_time` varchar(255) DEFAULT NULL COMMENT '活动时间',
 `address` varchar(255) DEFAULT NULL COMMENT '活动地点',
 `contact_msg` varchar(255) DEFAULT NULL COMMENT '联系方式',
 `join_num` int(11) DEFAULT NULL COMMENT '已参加的人数',
 `act_detail` text  COLLATE utf8_bin DEFAULT NULL COMMENT '活动详情',
 `create_time` varchar(30) DEFAULT NULL COMMENT '发布时间',
 `act_status` int(11) DEFAULT NULL COMMENT '状态',
 `user_id` int(11) DEFAULT NULL COMMENT '发布用户',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='志愿活动';


drop TABLE if EXISTS `join_log`;
CREATE TABLE IF NOT EXISTS `join_log` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `uid` int(11) DEFAULT NULL COMMENT '用户ID',
 `ureal_name` varchar(255) DEFAULT NULL COMMENT '用户昵称',
 `ucel_phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
 `aid` int(11) DEFAULT NULL COMMENT '志愿活动ID',
 `aact_time` varchar(255) DEFAULT NULL COMMENT '活动时间',
 `aaddress` varchar(255) DEFAULT NULL COMMENT '活动地点',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='参加记录';


drop TABLE if EXISTS `help_msg`;
CREATE TABLE IF NOT EXISTS `help_msg` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `hname` varchar(255) DEFAULT NULL COMMENT '姓名',
 `hage` int(11) DEFAULT NULL COMMENT '年龄',
 `hzp` varchar(200) DEFAULT NULL COMMENT '照片',
 `hsex` int(11) DEFAULT NULL COMMENT '性别',
 `hcel` varchar(255) DEFAULT NULL COMMENT '联系电话',
 `help_intro` varchar(1000) DEFAULT NULL COMMENT '具体情况',
 `amount` int(11) DEFAULT NULL COMMENT '需要金额',
 `create_date` varchar(30) DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='求助信息';


drop TABLE if EXISTS `donate_log`;
CREATE TABLE IF NOT EXISTS `donate_log` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `uid` int(11) DEFAULT NULL COMMENT '用户ID',
 `hid` int(11) DEFAULT NULL COMMENT '求助ID',
 `contact_msg` varchar(255) DEFAULT NULL COMMENT '联系方式',
 `donate_goods` varchar(255) DEFAULT NULL COMMENT '捐助物品',
 `donate_amount` varchar(255) DEFAULT NULL COMMENT '捐助金额',
 `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='捐助记录';


drop TABLE if EXISTS `banner`;
CREATE TABLE IF NOT EXISTS `banner` (
 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `bimg` varchar(200) DEFAULT NULL COMMENT '轮播图',
 `help_id` int(11) DEFAULT NULL COMMENT '求助ID',
  PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='轮播图';



INSERT INTO `child_care`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('1','admin','123');
INSERT INTO `child_care`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('2','admin1','123');
INSERT INTO `child_care`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('3','admin2','123');
INSERT INTO `child_care`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('4','admin3','123');
INSERT INTO `child_care`.`admin_msg` (`id`,`login_name`,`password`)  VALUES('5','admin4','123');
INSERT INTO `child_care`.`user_msg` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`address`,`create_time`)  VALUES('1','user','123','昵称0','13052653265','地址0','2023-04-19 23:25:41');
INSERT INTO `child_care`.`user_msg` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`address`,`create_time`)  VALUES('2','user1','123','昵称1','13553613261','地址1','2023-04-19 23:25:41');
INSERT INTO `child_care`.`user_msg` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`address`,`create_time`)  VALUES('3','user2','123','昵称2','13552623265','地址2','2023-04-19 23:25:41');
INSERT INTO `child_care`.`user_msg` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`address`,`create_time`)  VALUES('4','user3','123','昵称3','13052623165','地址3','2023-04-19 23:25:41');
INSERT INTO `child_care`.`user_msg` (`id`,`login_name`,`password`,`real_name`,`cel_phone`,`address`,`create_time`)  VALUES('5','user4','123','昵称4','13052633163','地址4','2023-04-19 23:25:41');
INSERT INTO `child_care`.`news_msg` (`id`,`news_name`,`notice_img`,`news_detail`,`aid`,`create_time`)  VALUES('1','标题0','/child_care/static/images/1/1.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','1','2023-04-19 23:25:42');
INSERT INTO `child_care`.`news_msg` (`id`,`news_name`,`notice_img`,`news_detail`,`aid`,`create_time`)  VALUES('2','标题1','/child_care/static/images/1/2.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2','2023-04-19 23:25:42');
INSERT INTO `child_care`.`news_msg` (`id`,`news_name`,`notice_img`,`news_detail`,`aid`,`create_time`)  VALUES('3','标题2','/child_care/static/images/1/3.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2','2023-04-20 23:25:42');
INSERT INTO `child_care`.`news_msg` (`id`,`news_name`,`notice_img`,`news_detail`,`aid`,`create_time`)  VALUES('4','标题3','/child_care/static/images/1/4.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','1','2023-04-19 23:25:42');
INSERT INTO `child_care`.`news_msg` (`id`,`news_name`,`notice_img`,`news_detail`,`aid`,`create_time`)  VALUES('5','标题4','/child_care/static/images/1/5.jpg','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','4','2023-04-19 23:25:42');
INSERT INTO `child_care`.`news_dis` (`id`,`content`,`nid`,`uid`,`create_time`)  VALUES('1','评论内容0','5','1','2023-04-19 23:25:42');
INSERT INTO `child_care`.`news_dis` (`id`,`content`,`nid`,`uid`,`create_time`)  VALUES('2','评论内容1','1','5','2023-04-19 23:25:42');
INSERT INTO `child_care`.`news_dis` (`id`,`content`,`nid`,`uid`,`create_time`)  VALUES('3','评论内容2','2','5','2023-04-19 23:25:42');
INSERT INTO `child_care`.`news_dis` (`id`,`content`,`nid`,`uid`,`create_time`)  VALUES('4','评论内容3','4','1','2023-04-20 23:25:42');
INSERT INTO `child_care`.`news_dis` (`id`,`content`,`nid`,`uid`,`create_time`)  VALUES('5','评论内容4','4','5','2023-04-20 23:25:42');
INSERT INTO `child_care`.`act_msg` (`id`,`act_name`,`act_img`,`act_time`,`address`,`contact_msg`,`join_num`,`act_detail`,`create_time`,`act_status`,`user_id`)  VALUES('1','活动名0','/child_care/static/images/1/1.jpg','活动时间0','活动地点0','联系方式0','0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2023-04-19 23:25:43','2','1');
INSERT INTO `child_care`.`act_msg` (`id`,`act_name`,`act_img`,`act_time`,`address`,`contact_msg`,`join_num`,`act_detail`,`create_time`,`act_status`,`user_id`)  VALUES('2','活动名1','/child_care/static/images/1/2.jpg','活动时间1','活动地点1','联系方式1','0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2023-04-19 23:25:43','3','1');
INSERT INTO `child_care`.`act_msg` (`id`,`act_name`,`act_img`,`act_time`,`address`,`contact_msg`,`join_num`,`act_detail`,`create_time`,`act_status`,`user_id`)  VALUES('3','活动名2','/child_care/static/images/1/3.jpg','活动时间2','活动地点2','联系方式2','0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2023-04-20 23:25:43','3','5');
INSERT INTO `child_care`.`act_msg` (`id`,`act_name`,`act_img`,`act_time`,`address`,`contact_msg`,`join_num`,`act_detail`,`create_time`,`act_status`,`user_id`)  VALUES('4','活动名3','/child_care/static/images/1/4.jpg','活动时间3','活动地点3','联系方式3','0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2023-04-20 23:25:43','2','3');
INSERT INTO `child_care`.`act_msg` (`id`,`act_name`,`act_img`,`act_time`,`address`,`contact_msg`,`join_num`,`act_detail`,`create_time`,`act_status`,`user_id`)  VALUES('5','活动名4','/child_care/static/images/1/5.jpg','活动时间4','活动地点4','联系方式4','0','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试试测试测试测试测试测试测试测试测试测试测试','2023-04-20 23:25:43','3','3');
INSERT INTO `child_care`.`join_log` (`id`,`uid`,`ureal_name`,`ucel_phone`,`aid`,`aact_time`,`aaddress`,`create_time`)  VALUES('1','4','昵称3','13052623165','3','活动时间2','活动地点2','2023-04-19 23:25:43');
INSERT INTO `child_care`.`join_log` (`id`,`uid`,`ureal_name`,`ucel_phone`,`aid`,`aact_time`,`aaddress`,`create_time`)  VALUES('2','2','昵称1','13553613261','4','活动时间3','活动地点3','2023-04-19 23:25:43');
INSERT INTO `child_care`.`join_log` (`id`,`uid`,`ureal_name`,`ucel_phone`,`aid`,`aact_time`,`aaddress`,`create_time`)  VALUES('3','1','昵称0','13052653265','3','活动时间2','活动地点2','2023-04-19 23:25:43');
INSERT INTO `child_care`.`join_log` (`id`,`uid`,`ureal_name`,`ucel_phone`,`aid`,`aact_time`,`aaddress`,`create_time`)  VALUES('4','4','昵称3','13052623165','5','活动时间4','活动地点4','2023-04-19 23:25:43');
INSERT INTO `child_care`.`join_log` (`id`,`uid`,`ureal_name`,`ucel_phone`,`aid`,`aact_time`,`aaddress`,`create_time`)  VALUES('5','4','昵称3','13052623165','2','活动时间1','活动地点1','2023-04-19 23:25:43');
INSERT INTO `child_care`.`help_msg` (`id`,`hname`,`hage`,`hzp`,`hsex`,`hcel`,`help_intro`,`amount`,`create_date`)  VALUES('1','姓名0','2','/child_care/static/images/1/1.jpg','1','13052653265','具体情况0','29','2023-04-20');
INSERT INTO `child_care`.`help_msg` (`id`,`hname`,`hage`,`hzp`,`hsex`,`hcel`,`help_intro`,`amount`,`create_date`)  VALUES('2','姓名1','34','/child_care/static/images/1/2.jpg','2','13553613261','具体情况1','51','2023-04-20');
INSERT INTO `child_care`.`help_msg` (`id`,`hname`,`hage`,`hzp`,`hsex`,`hcel`,`help_intro`,`amount`,`create_date`)  VALUES('3','姓名2','18','/child_care/static/images/1/3.jpg','1','13552623265','具体情况2','44','2023-04-20');
INSERT INTO `child_care`.`help_msg` (`id`,`hname`,`hage`,`hzp`,`hsex`,`hcel`,`help_intro`,`amount`,`create_date`)  VALUES('4','姓名3','72','/child_care/static/images/1/4.jpg','2','13052623165','具体情况3','0','2023-04-20');
INSERT INTO `child_care`.`help_msg` (`id`,`hname`,`hage`,`hzp`,`hsex`,`hcel`,`help_intro`,`amount`,`create_date`)  VALUES('5','姓名4','11','/child_care/static/images/1/5.jpg','1','13052633163','具体情况4','4','2023-04-20');
INSERT INTO `child_care`.`donate_log` (`id`,`uid`,`hid`,`contact_msg`,`donate_goods`,`donate_amount`,`create_time`)  VALUES('1','1','5','联系方式0','捐助物品0','捐助金额0','2023-04-19 23:25:44');
INSERT INTO `child_care`.`donate_log` (`id`,`uid`,`hid`,`contact_msg`,`donate_goods`,`donate_amount`,`create_time`)  VALUES('2','5','4','联系方式1','捐助物品1','捐助金额1','2023-04-19 23:25:44');
INSERT INTO `child_care`.`donate_log` (`id`,`uid`,`hid`,`contact_msg`,`donate_goods`,`donate_amount`,`create_time`)  VALUES('3','5','1','联系方式2','捐助物品2','捐助金额2','2023-04-20 23:25:44');
INSERT INTO `child_care`.`donate_log` (`id`,`uid`,`hid`,`contact_msg`,`donate_goods`,`donate_amount`,`create_time`)  VALUES('4','5','4','联系方式3','捐助物品3','捐助金额3','2023-04-19 23:25:44');
INSERT INTO `child_care`.`donate_log` (`id`,`uid`,`hid`,`contact_msg`,`donate_goods`,`donate_amount`,`create_time`)  VALUES('5','3','4','联系方式4','捐助物品4','捐助金额4','2023-04-19 23:25:44');
INSERT INTO `child_care`.`banner` (`id`,`bimg`,`help_id`)  VALUES('1','/child_care/static/images/1/1.jpg','1');
INSERT INTO `child_care`.`banner` (`id`,`bimg`,`help_id`)  VALUES('2','/child_care/static/images/1/2.jpg','1');
INSERT INTO `child_care`.`banner` (`id`,`bimg`,`help_id`)  VALUES('3','/child_care/static/images/1/3.jpg','4');
INSERT INTO `child_care`.`banner` (`id`,`bimg`,`help_id`)  VALUES('4','/child_care/static/images/1/4.jpg','2');
INSERT INTO `child_care`.`banner` (`id`,`bimg`,`help_id`)  VALUES('5','/child_care/static/images/1/5.jpg','4');