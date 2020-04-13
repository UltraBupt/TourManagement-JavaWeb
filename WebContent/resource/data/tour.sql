/*
 Navicat Premium Data Transfer

 Source Server         : asset
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : tour

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 13/04/2020 18:38:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for advertisement
-- ----------------------------
DROP TABLE IF EXISTS `advertisement`;
CREATE TABLE `advertisement`  (
  `advertisement_id` int(11) NOT NULL AUTO_INCREMENT,
  `advertisement_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `advertisement_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `advertisement_benefit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`advertisement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of advertisement
-- ----------------------------
INSERT INTO `advertisement` VALUES (1, '莫斯利安见证女排传奇，买二送一优惠多多', '广告栏位1', '99999');
INSERT INTO `advertisement` VALUES (2, '德芙纵享丝滑', '广告栏位2', '88888');
INSERT INTO `advertisement` VALUES (3, '巴黎欧莱雅三倍呵护，你值得拥有', '广告栏位3', '77777');
INSERT INTO `advertisement` VALUES (4, '山有木兮木有枝，心悦君兮君不知。《花千骨》每晚7：00湖南卫视与您不见不散', '广告栏位4', '66666');

-- ----------------------------
-- Table structure for advertisementbenefit
-- ----------------------------
DROP TABLE IF EXISTS `advertisementbenefit`;
CREATE TABLE `advertisementbenefit`  (
  `advertisementBenefit_id` int(11) NOT NULL AUTO_INCREMENT,
  `advertisementBenefit_benefit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`advertisementBenefit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of advertisementbenefit
-- ----------------------------
INSERT INTO `advertisementbenefit` VALUES (1, '88888');
INSERT INTO `advertisementbenefit` VALUES (2, '99999');
INSERT INTO `advertisementbenefit` VALUES (3, '77777');
INSERT INTO `advertisementbenefit` VALUES (4, '666666');

-- ----------------------------
-- Table structure for agricola
-- ----------------------------
DROP TABLE IF EXISTS `agricola`;
CREATE TABLE `agricola`  (
  `agricola_id` int(11) NOT NULL AUTO_INCREMENT,
  `agricola_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `agricola_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `agricola_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `agricola_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `agricola_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `agricola_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  PRIMARY KEY (`agricola_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agricola
-- ----------------------------
INSERT INTO `agricola` VALUES (1, '/shxt/resource/upload/photo/1fe2b3a2-aca0-464d-82f9-72d1e6bfaf1b.png', '深山茶庄', '129', '济南', '安然舒适', 1);
INSERT INTO `agricola` VALUES (2, '/shxt/resource/upload/photo/bec33c72-6b50-437d-a9d6-c7246e7e788d.png', '又一村', '159', '济南', '安然舒适', 1);
INSERT INTO `agricola` VALUES (3, '/shxt/resource/upload/photo/92fe16f4-cacd-4f2e-87b5-825d07912166.jpg', '三品', '109', '济南', '安然舒适', 1);
INSERT INTO `agricola` VALUES (4, '/shxt/resource/upload/photo/7310d608-5565-48cb-b618-f67be4373b07.jpg', '湖畔仙居', '159', '济南', '安然舒适', 1);
INSERT INTO `agricola` VALUES (5, '/shxt/resource/upload/photo/2480ec71-099a-4c46-9997-b2caf9942759.png', '林家大院', '259', '济南', '安然舒适', 1);
INSERT INTO `agricola` VALUES (6, '/shxt/resource/upload/photo/1c163138-260c-4127-9fc9-c586f3a7e310.png', '美好农家乐', '159', '济南', '安然舒适', 1);

-- ----------------------------
-- Table structure for airline
-- ----------------------------
DROP TABLE IF EXISTS `airline`;
CREATE TABLE `airline`  (
  `airline_id` int(11) NOT NULL AUTO_INCREMENT,
  `airline_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `airline_from` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `airline_to` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `airline_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `airline_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `airline_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  `airline_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`airline_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of airline
-- ----------------------------
INSERT INTO `airline` VALUES (1, '/shxt/resource/upload/photo/f286f7bd-2036-4574-a4d4-2914f15c5579.jpg', '济南', '武汉', '998', '2016/10/05/09:00:00', 1, '遥墙机场');
INSERT INTO `airline` VALUES (2, '/shxt/resource/upload/photo/3dc51feb-18a2-40a9-9489-8c13016778a2.png', '上海', '大理', '799', '2016/10/05/09:00:00', 1, '长虹机场');
INSERT INTO `airline` VALUES (3, '/shxt/resource/upload/photo/240b1c6a-395a-44d8-a3fd-de45592bd70b.jpg', '济南', '罗马', '1999', '2016/10/05/09:00:00', 1, '遥墙机场');
INSERT INTO `airline` VALUES (4, '/shxt/resource/upload/photo/113026ca-0cbe-430c-8a05-9eb7fa2848b1.jpg', '济南', '成都', '1099', '2016/10/05/09:00:00', 1, '遥墙机场');
INSERT INTO `airline` VALUES (5, '/shxt/resource/upload/photo/dae28dcc-2721-40f8-96ed-2b08b722c540.png', '济南', '长春', '599', '2016/10/05/09:00:00', 1, '遥墙机场');
INSERT INTO `airline` VALUES (6, '/shxt/resource/upload/photo/f8ba0d9c-72e0-4dbc-a959-677090ffac3d.jpg', '上海', '桂林', '999', '2016/10/05/09:00:00', 1, '长虹机场');
INSERT INTO `airline` VALUES (7, '/shxt/resource/upload/photo/163bd6a8-1d71-4012-a1d3-55743a8efeaa.jpg', '上海', '西双版纳', '1299', '2016/10/05/09:00:00', 1, '长虹机场');
INSERT INTO `airline` VALUES (8, '/shxt/resource/upload/photo/0efb02ae-b2ba-43f6-bfa1-d2407057ae37.jpg', '济南', '苏州', '799', '2016/10/05/09:00:00', 1, '遥墙机场');

-- ----------------------------
-- Table structure for apartment
-- ----------------------------
DROP TABLE IF EXISTS `apartment`;
CREATE TABLE `apartment`  (
  `apartment_id` int(11) NOT NULL AUTO_INCREMENT,
  `apartment_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `apartment_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `apartment_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `apartment_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `apartment_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `apartment_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  PRIMARY KEY (`apartment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of apartment
-- ----------------------------
INSERT INTO `apartment` VALUES (1, '/shxt/resource/upload/photo/e7df6997-6741-4577-88ee-2efa5f11db22.jpg', '凯悦公寓', '289', '济南', '安静舒适', 1);
INSERT INTO `apartment` VALUES (2, '/shxt/resource/upload/photo/b6e0ca29-c52f-4054-9b11-0c8a23a73a1c.png', '格林公寓', '259', '济南', '安静舒适', 1);
INSERT INTO `apartment` VALUES (3, '/shxt/resource/upload/photo/4effd341-0b62-499e-a384-a8b27d0c489a.jpg', '纤尘公寓', '309', '济南', '安静舒适', 1);
INSERT INTO `apartment` VALUES (4, '/shxt/resource/upload/photo/36776b3f-e358-40ed-88dd-2857dcafbadd.jpg', '利融公寓', '259', '济南', '安静舒适', 1);
INSERT INTO `apartment` VALUES (5, '/shxt/resource/upload/photo/81f5c52b-09f4-4369-87f4-ac2635d6b285.jpg', '梦露公寓', '329', '济南', '安静舒适', 1);
INSERT INTO `apartment` VALUES (6, '/shxt/resource/upload/photo/11719ca8-b871-4364-b885-d4ecf013e592.jpg', '城南公寓', '209', '济南', '安静舒适', 1);
INSERT INTO `apartment` VALUES (7, '/shxt/resource/upload/photo/4c91c9cd-3286-43dc-89fb-36f9d196e50f.jpg', '海蓝公寓', '299', '济南', '安静舒适', 1);
INSERT INTO `apartment` VALUES (8, '/shxt/resource/upload/photo/7242efe7-198d-46e1-aecc-af1227931627.jpg', '晨曦公寓', '209', '济南', '安静舒适', 1);

-- ----------------------------
-- Table structure for aroundticket
-- ----------------------------
DROP TABLE IF EXISTS `aroundticket`;
CREATE TABLE `aroundticket`  (
  `aroundTicket_id` int(11) NOT NULL AUTO_INCREMENT,
  `aroundTicket_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `aroundTicket_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `aroundTicket_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `aroundTicket_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`aroundTicket_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of aroundticket
-- ----------------------------
INSERT INTO `aroundticket` VALUES (1, '门票1', '/shxt/resource/upload/photo/0bd50895-d015-447a-9c85-448c7cf7e44f.jpg', '九如山风景区', '35');
INSERT INTO `aroundticket` VALUES (2, '门票2', '/shxt/resource/upload/photo/16ea1001-cdbe-41ee-9ee2-26e4a2a1de2f.jpg', '大明湖', '45');
INSERT INTO `aroundticket` VALUES (3, '门票3', '/shxt/resource/upload/photo/9cca7219-8784-4236-a621-19869bb7a108.png', '青岛德国旧址博物馆', '50');
INSERT INTO `aroundticket` VALUES (4, '门票4', '/shxt/resource/upload/photo/9d510f4f-8769-4814-90e1-139a9ba76838.jpg', '济南动物园', '25');
INSERT INTO `aroundticket` VALUES (5, '门票5', '/shxt/resource/upload/photo/fd24c802-7747-4f82-9a2c-cbd41c4bf719.jpg', '趵突泉', '30');
INSERT INTO `aroundticket` VALUES (6, '门票6', '/shxt/resource/upload/photo/1839e08a-65f1-4fa3-a2e4-f11a68542f11.png', '海底世界', '50');
INSERT INTO `aroundticket` VALUES (7, '门票7', '/shxt/resource/upload/photo/5061a4be-b5eb-44ad-a32e-2f3e61674dc4.jpg', '信号山公园', '30');
INSERT INTO `aroundticket` VALUES (8, '门票8', '/shxt/resource/upload/photo/db7c2d70-29e5-4442-9e2d-1536b2c779d6.jpg', '栈桥', '20');
INSERT INTO `aroundticket` VALUES (9, '门票9', '/shxt/resource/upload/photo/a096f157-068c-49fa-aeef-534f41849503.jpg', '刘公岛', '30');
INSERT INTO `aroundticket` VALUES (10, '门票10', '/shxt/resource/upload/photo/dd609a1b-ff6f-4f64-8353-f1112972dc1c.jpg', '摩天岭', '40');
INSERT INTO `aroundticket` VALUES (11, '门票11', '/shxt/resource/upload/photo/cb8336b6-b784-426e-a033-a3d470538093.jpg', '五龙潭', '25');
INSERT INTO `aroundticket` VALUES (12, '门票12', '/shxt/resource/upload/photo/2a1ec942-96db-4dac-a795-771334349508.jpg', '青岛国际帆船中心', '33');
INSERT INTO `aroundticket` VALUES (13, '图片1', '/shxt/resource/upload/photo/f4d85844-de82-4973-a67e-c7994e77b23e.jpg', NULL, NULL);
INSERT INTO `aroundticket` VALUES (14, '图片2', '/shxt/resource/upload/photo/b80c6138-41f0-4629-896a-284c1110e2f1.jpg', NULL, NULL);
INSERT INTO `aroundticket` VALUES (15, '图片3', '/shxt/resource/upload/photo/78d8e9d0-2c2a-44a8-aafb-915d6a825d69.jpg', NULL, NULL);

-- ----------------------------
-- Table structure for aroundtourism
-- ----------------------------
DROP TABLE IF EXISTS `aroundtourism`;
CREATE TABLE `aroundtourism`  (
  `aroundTourism_id` int(11) NOT NULL AUTO_INCREMENT,
  `aroundTourism_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `aroundTourism_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `aroundTourism_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`aroundTourism_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of aroundtourism
-- ----------------------------
INSERT INTO `aroundtourism` VALUES (1, '/shxt/resource/upload/photo/13f94483-832c-4a5d-9bc2-c44ceb154bc8.jpg', '天下第一泉--趵突泉', '位置1');
INSERT INTO `aroundtourism` VALUES (2, '/shxt/resource/upload/photo/12508862-08e0-4b49-ae70-140c70070cd9.jpg', '碧波荡漾，澄澈如镜--五龙潭', '位置2');
INSERT INTO `aroundtourism` VALUES (3, '/shxt/resource/upload/photo/b56dc51e-93ed-47de-8644-226447dc64ed.jpg', '四面荷花三面柳，一城山色半城湖--大明湖', '位置3');
INSERT INTO `aroundtourism` VALUES (4, '/shxt/resource/upload/photo/8ba9a484-2a24-4e5f-a09d-91be828a4d82.jpg', '去济南怎能不去--千佛山', '位置4');
INSERT INTO `aroundtourism` VALUES (5, '/shxt/resource/upload/photo/f21540d5-80ac-4a4e-a42a-b53a1f164d10.jpg', '音乐喷泉--泉城广场', '位置5');
INSERT INTO `aroundtourism` VALUES (6, '/shxt/resource/upload/photo/f958c3a4-27b6-4792-864b-57f7f9fb0c55.jpg', '美轮美奂--九如山风景区', '位置6');
INSERT INTO `aroundtourism` VALUES (7, '/shxt/resource/upload/photo/8bc3a6d2-9589-450d-96ed-82bc666e469a.jpg', '动物的天堂--动物园', '位置7');
INSERT INTO `aroundtourism` VALUES (8, '/shxt/resource/upload/photo/b8b88947-d691-4d04-b24b-f05cc9c0e08a.jpg', '海上第一山--崂山', '位置8');
INSERT INTO `aroundtourism` VALUES (9, '/shxt/resource/upload/photo/2904f020-d123-4fcb-a83a-3c4dbb9ff9b7.png', '私会极地来的珍惜动物--青岛海昌极地海洋世界', '位置9');
INSERT INTO `aroundtourism` VALUES (10, '/shxt/resource/upload/photo/afdc7084-362d-4eaf-b12d-8f005429ca1b.jpg', '绿色奥运--青岛国际帆船中心', '位置10');
INSERT INTO `aroundtourism` VALUES (11, '/shxt/resource/upload/photo/e3fcc92f-557e-40e4-9bce-86b19adebe48.png', '古堡式监狱--青岛德国监狱旧址博物馆', '位置11');
INSERT INTO `aroundtourism` VALUES (12, '/shxt/resource/upload/photo/751d0e06-7f27-42b4-92ac-17e496ddc8af.jpg', '山中有海，偶遇美人鱼--青岛海底世界', '位置12');
INSERT INTO `aroundtourism` VALUES (13, '/shxt/resource/upload/photo/4d953c0d-7f0e-4235-968a-08a26c85ac5e.jpg', '俯瞰青岛--信号山公园', '位置13');
INSERT INTO `aroundtourism` VALUES (14, '/shxt/resource/upload/photo/5c6959a8-8ed2-4a99-9e77-bdef5b7e540b.jpg', '在这里感受惊涛拍案，飞阁回澜--栈桥', '位置14');
INSERT INTO `aroundtourism` VALUES (15, '/shxt/resource/upload/photo/7f6a205d-91c8-4bfe-815f-3ad1c0a5bb3e.jpg', '北洋水师诞生地，甲午战争遗址--刘公岛', '位置15');
INSERT INTO `aroundtourism` VALUES (16, '/shxt/resource/upload/photo/1462897f-b21c-4edc-9151-ca9d57250255.jpg', '海市蜃楼摇曳隐现，神秘至神而神灵--摩天岭', '位置16');
INSERT INTO `aroundtourism` VALUES (17, '/shxt/resource/upload/photo/6fc051e1-a3a9-4833-a34f-62a6c8391ab4.jpg', '中国石画艺术，精美的中国山水画卷--西霞口', '位置17');
INSERT INTO `aroundtourism` VALUES (18, '/shxt/resource/upload/photo/ced10f69-730c-4aad-bddd-bf6a626a61bb.jpg', '林海茫茫，动植物种类繁多，自然环境幽美--仰天山国家森林公园', '位置18');
INSERT INTO `aroundtourism` VALUES (19, '/shxt/resource/upload/photo/31dbb2f6-214c-4f49-aaca-c7868eb31871.jpg', '北国江南，鲁中桃源--老龙湾', '位置19');
INSERT INTO `aroundtourism` VALUES (20, '/shxt/resource/upload/photo/e17ea123-e14a-450f-8fc2-a13d6e7695f8.jpg', '享受自然与清静，体验不一样的假期--金宝乐园', '位置20');
INSERT INTO `aroundtourism` VALUES (21, '/shxt/resource/upload/photo/cf73977d-ea05-46d3-8baa-0c2dad6de5d0.jpg', '朝看黄海日出，暮观渤海日落--长岛', '位置21');

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bill_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bill_thing` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bill_memberAccount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bill_memberPhone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bill_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bill_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bill_totalPrice` double(255, 0) NULL DEFAULT NULL,
  `bill_status` int(11) NULL DEFAULT 0 COMMENT '0为未处理，1为已确定，-1为删除订单',
  `bill_createDate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bill_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES (1, '周边游', 'f4531681-d223-49e6-8592-dc519981ef5f', '九如山风景区', 'ching777', '17862916111', '35', '1', 35, -1, '2016-09-25 16:10:18');
INSERT INTO `bill` VALUES (2, '周边游', 'a7185413-dc98-42a0-8ac3-68194c27be0a', '九如山风景区', 'ching777', '17862916111', '35', '10', 346, 1, '2016-09-25 16:12:34');
INSERT INTO `bill` VALUES (3, '周边游', 'bb05393d-dbdd-4b29-b693-f5a808484c15', '九如山风景区', 'ching777', '17862916111', '35', '2', 69, 1, '2016-09-25 16:14:40');
INSERT INTO `bill` VALUES (4, '周边游', 'c3fe49b5-dc85-4ad0-b904-ad89774f6b06', '九如山风景区', 'ching777', '17862916111', '35', '2', 69, 1, '2016-09-25 16:16:22');
INSERT INTO `bill` VALUES (5, '周边游', 'aa8f29f9-427b-4c7e-882c-978f21f5cde1', '九如山风景区', 'ching777', '17862916111', '35', '2', 69, 1, '2016-09-25 16:16:32');
INSERT INTO `bill` VALUES (6, '周边游', '33ad79a4-a517-4bfb-8d82-32964eabf095', '九如山风景区', 'ching777', '17862916111', '35', '3', 104, 1, '2016-09-25 16:17:32');
INSERT INTO `bill` VALUES (7, '周边游', '80a71dcd-fc65-4f2c-bc4d-acb609ff7860', '大明湖', 'ching777', '17862916111', '45', '2', 87, 1, '2016-09-25 16:25:40');
INSERT INTO `bill` VALUES (8, '国内游', 'dd9eff8a-4a5b-4460-8434-d987e264c8fc', '银子岩', 'ching777', '17862916111', '25', '2', 48, 1, '2016-09-25 16:51:46');
INSERT INTO `bill` VALUES (9, '海外游', '8b20dd57-d2fc-4e61-ad23-29e88dfcb7a6', '特莱维喷泉', 'ching777', '17862916111', '119', '2', 231, 1, '2016-09-25 17:13:21');
INSERT INTO `bill` VALUES (10, '保险', '07a12ce2-843f-4988-b628-ea52b58622f6', '泰康人寿旅行意外险', 'ching777', '17862916111', '10', '2', 19, 1, '2016-09-27 14:58:00');
INSERT INTO `bill` VALUES (11, '保险', '5e00425d-6caf-4ead-b4fe-82efc4bbf27e', '泰康人寿旅行意外险', 'ching777', '17862916111', '10', '2', 19, 1, '2016-09-27 14:58:11');
INSERT INTO `bill` VALUES (12, '保险', 'e0939ddf-93da-4be8-8b2b-d9672a054e6d', '泰康人寿交通意外险', 'ching777', '17862916111', '100', '2', 194, 1, '2016-09-27 15:00:47');
INSERT INTO `bill` VALUES (13, '保险', '0d5ec4a0-62f9-427e-b3b3-6e1f52e165a5', '泰康人寿交通意外险', 'ching777', '17862916111', '100', '2', 194, 1, '2016-09-27 15:02:15');
INSERT INTO `bill` VALUES (14, '周边游', '2f83a6bb-0587-4bfd-81bc-9f5a20d6ca4d', '九如山风景区', 'ching777', '17862916111', '35', '2', 68, 1, '2016-09-27 15:02:45');
INSERT INTO `bill` VALUES (15, '保险', '4dc30abb-46d1-4e96-89c5-beb164d54cb0', '泰康人寿交通意外险', 'ching777', '17862916111', '100', '1', 95, 1, '2016-09-27 15:04:41');
INSERT INTO `bill` VALUES (16, '周边游', 'c8604727-d58e-4548-8209-577030b64c15', '九如山风景区', 'ching777', '17862916111', '35', '3', 100, 1, '2016-09-27 15:05:03');
INSERT INTO `bill` VALUES (17, '国内游', '3a88cfc4-961d-49b0-b9ae-075926fbd7c8', '银子岩', 'ching777', '17862916111', '25', '2', 47, 1, '2016-09-27 15:05:28');
INSERT INTO `bill` VALUES (18, '海外游', 'f90b2599-fbb4-4416-8f61-fd5e8fba5877', '卢浮宫', 'ching777', '17862916111', '99', '2', 188, 1, '2016-09-27 15:05:59');
INSERT INTO `bill` VALUES (19, '周边游', '2ddb8803-d867-4e03-b734-317d93a53434', '栈桥', 'ching777', '17862916111', '20', '1', 19, 1, '2016-09-27 15:06:22');
INSERT INTO `bill` VALUES (20, '周边游', '339d8d26-0878-4cc4-bb6e-654380fe895d', '大明湖', 'zhangsan', '17862916111', '45', '1', 45, 1, '2016-09-27 15:10:42');
INSERT INTO `bill` VALUES (21, '国内游', '352917d8-d088-4491-8197-9016f8950937', '中山陵', 'zhangsan', '17862916111', '35', '1', 35, 1, '2016-09-27 15:11:00');
INSERT INTO `bill` VALUES (22, '海外游', 'fdc40446-20e6-46b0-998a-f7beb50e3609', '索菲亚王后艺术中心', 'zhangsan', '17862916111', '188', '11', 2047, 1, '2016-09-27 15:11:16');
INSERT INTO `bill` VALUES (23, '周边游', '24fbbbfa-aeec-4bd4-963b-c188af32ac68', '大明湖', 'zhangsan', '17862916111', '45', '5', 223, 1, '2016-09-27 15:12:45');
INSERT INTO `bill` VALUES (24, '国内游', '680b629f-3e62-4cce-b51a-df183f197250', '银子岩', 'zhangsan', '17862916111', '25', '123456', 3055536, 1, '2016-09-27 15:13:26');
INSERT INTO `bill` VALUES (25, '保险', 'b45edaca-3a13-48f4-9c51-da98e014ef4a', '泰康人寿旅行意外险', 'zhangsan', '17862916111', '10', '2', 20, 1, '2016-09-27 15:13:51');
INSERT INTO `bill` VALUES (26, '保险', 'a253e0df-2b6f-4224-a39e-0a150db861fa', '泰康人寿交通意外险', 'zhangsan', '17862916111', '100', '2', 198, 1, '2016-09-27 15:14:26');
INSERT INTO `bill` VALUES (27, '签证', '9cb4f640-43de-4781-8e31-56ca087e12b7', '英国', 'zhangsan', '17862916111', '700', '5', 3465, 1, '2016-09-28 21:33:46');
INSERT INTO `bill` VALUES (28, '周边游', 'e412b1fd-5f7a-4cc4-87f0-de7356440c2d', '大明湖', 'zhangsan', '17862916111', '45', '1', 45, 1, '2016-09-28 21:34:03');
INSERT INTO `bill` VALUES (29, '周边游', '3919f3f6-feba-41df-8468-3e1c3eff13f7', '九如山风景区', 'zhangsan', '17862916111', '35', '5', 170, 1, '2016-09-28 21:34:28');
INSERT INTO `bill` VALUES (30, '金融', 'ada10bb1-d749-4a1c-8a55-ca56585fada3', '罗马7日游', 'zhangsan', '17862916111', '6999', '1', 6789, 1, '2016-09-29 11:49:56');
INSERT INTO `bill` VALUES (31, '周边游', 'bdc5fd27-2e13-425e-8b9e-33126f3ed2bd', '九如山风景区', 'zhangsan', '17862916111', '35', '2', 68, 1, '2016-09-30 16:55:50');
INSERT INTO `bill` VALUES (32, '周边游', 'cc530056-35b1-4984-99bb-78cb39779c46', '九如山风景区', 'zhangsan', '17862916111', '35', '2', 68, 1, '2016-09-30 20:59:30');
INSERT INTO `bill` VALUES (33, '小吃', '4d225af5-4bed-431f-9c98-1dbdadeddb5b', '竹筒饭', 'zhangsan', '17862916111', '55', '2', 107, 1, '2016-10-01 21:01:53');
INSERT INTO `bill` VALUES (34, '小吃', '02436233-d899-4d07-9524-5c06de9e6016', '炸酸奶', 'zhangsan', '17862916111', '28', '3', 81, 1, '2016-10-01 21:29:46');
INSERT INTO `bill` VALUES (35, '小吃', '967a6478-ec24-4c2c-9b6a-25525e3831a5', '麻辣鸡翅', 'zhangsan', '17862916111', '29', '2', 56, 1, '2016-10-01 21:46:13');
INSERT INTO `bill` VALUES (36, '周边游', '0830ef30-1ccb-466d-9019-78c74d3170bc', '大明湖', 'ching777', '17862916111', '45', '2', 85, 1, '2016-10-02 11:13:16');
INSERT INTO `bill` VALUES (37, '快餐', '358bcc63-1d82-4414-9dd3-9d1b34478078', '鸡翅便当', 'zhangsan', '17862916111', '19', '2', 37, 1, '2016-10-02 17:16:34');
INSERT INTO `bill` VALUES (38, '快餐', '52224be3-170f-4ce0-9f1b-14f227836bcb', '排骨套餐', 'zhangsan', '17862916111', '26', '1', 25, 1, '2016-10-02 17:28:40');
INSERT INTO `bill` VALUES (39, '自助', 'a829a67c-5fb5-405e-a8a1-1da3d19cb252', '炎烧烤', 'ching777', '17862916111', '109', '2', 207, 1, '2016-10-02 21:58:55');
INSERT INTO `bill` VALUES (40, '自助', '251c8c32-2cb9-4697-addb-7b32699e4aa1', '汉丽轩', 'ching777', '17862916111', '39', '1', 37, 1, '2016-10-02 22:21:17');
INSERT INTO `bill` VALUES (41, '主题', '2ec6bc67-4ac8-4cfb-8b33-c2576954d10e', '美国队长主题餐厅', 'ching777', '17862916111', '100', '2', 190, 1, '2016-10-03 11:44:09');
INSERT INTO `bill` VALUES (42, '主题', '0d2744fe-0d57-4e57-bba4-3670bb940ac4', '复古主题餐厅', 'ching777', '17862916111', '80', '1', 76, 1, '2016-10-03 11:59:01');
INSERT INTO `bill` VALUES (43, '西式', '02476179-48bc-42f7-80c0-47c735cb82ee', '简约早餐', 'ching777', '17862916111', '25', '2', 46, 1, '2016-10-03 16:36:28');
INSERT INTO `bill` VALUES (44, '西式', '88b64a6a-bf56-41ce-80c5-d5f62d9282ee', '下午茶套餐', 'ching777', '17862916111', '49', '2', 91, 1, '2016-10-03 16:56:52');
INSERT INTO `bill` VALUES (45, '假日酒店', '3a579d4b-30d9-4eab-8829-2944ab2228eb', '汉森假日酒店', 'zhangsan', '17862916111', '699', '2', 1356, 1, '2016-10-03 20:51:50');
INSERT INTO `bill` VALUES (46, '公寓', 'ae358956-ff32-4690-a858-92ce8cedd7d0', '银座佳驿', 'ching777', '17862916111', '199', '2', 370, 1, '2016-10-04 10:46:36');
INSERT INTO `bill` VALUES (47, '周边游', '42a3724d-4d3f-4359-bf4f-666792f1b947', '大明湖', 'ching777', '17862916111', '45', '2', 84, -1, '2016-10-04 11:28:36');
INSERT INTO `bill` VALUES (48, '别墅', '9503bce6-2bf0-4fb7-9d9b-2c835b552afa', '国华东方美郡', 'zhangsan', '17862916111', '1099', '2', 2132, 1, '2016-10-04 16:15:40');
INSERT INTO `bill` VALUES (49, '农家乐', '7ca608b6-3357-4042-b379-2fad3e07f052', '深山茶庄', 'ching777', '17862916111', '129', '2', 240, 1, '2016-10-04 17:37:36');
INSERT INTO `bill` VALUES (50, '快捷酒店', 'd166ff5f-c870-405b-8097-3dc40695fa8c', '银座佳驿', 'ching777', '17862916111', '109', '2', 203, 1, '2016-10-04 20:55:52');
INSERT INTO `bill` VALUES (51, '机票', '28b12c04-ce65-4e14-ab43-2f2f72b1df00', '遥墙机场', 'ching777', '17862916111', '998', '2', 1856, 1, '2016-10-05 11:06:13');
INSERT INTO `bill` VALUES (52, '火车票', 'b0b06a7a-0cec-44a0-9503-2cd833a9f539', '济南站', 'ching777', '17862916111', '99', '2', 184, 1, '2016-10-05 16:26:50');
INSERT INTO `bill` VALUES (53, '轮船票', '5e8c6066-c115-402f-b4f7-6aeca4d6dfd9', '青岛海港', 'ching777', '17862916111', '108', '2', 201, 1, '2016-10-05 17:39:13');
INSERT INTO `bill` VALUES (54, '汽车票', '8cb734f1-a3b0-4c61-bf2c-cd15099d6c51', '长途总站南区', 'ching777', '17862916111', '128', '2', 238, 1, '2016-10-05 19:13:51');
INSERT INTO `bill` VALUES (55, '汽车票', '44d88e9d-ccdc-4bb5-b21c-e4d6fe7a1459', '长途总站南区', 'ching777', '17862916111', '229', '2', 426, 1, '2016-10-05 19:18:59');
INSERT INTO `bill` VALUES (56, '动车票', '355a2cd1-538d-4d3a-b6b2-c8e109c5ed28', '济南站', 'ching777', '17862916111', '189', '2', 352, 1, '2016-10-05 20:19:30');
INSERT INTO `bill` VALUES (57, '公寓', '0146f6b6-2639-4671-b5e9-bfc9c15829ae', '格林公寓', 'ching777', '17862916111', '259', '2', 482, 1, '2016-10-06 22:55:30');
INSERT INTO `bill` VALUES (58, '动车票', '52d01412-e1a7-4e54-a8cb-e0d0357539b5', '济南站', 'ching777', '17862916111', '199', '1', 185, 0, '2016-10-13 20:34:41');
INSERT INTO `bill` VALUES (59, '周边游', '2dc6a29c-96d7-4a1e-8bd6-7fe0a9d376d7', '九如山风景区', 'ching777', '17862916111', '35', '2', 65, 0, '2016-10-14 13:40:42');
INSERT INTO `bill` VALUES (60, '快捷酒店', 'ec5776fe-872d-4224-aa86-71c968f3888c', '银座佳驿', 'zhangsan123', '17862916111', '109', '100', 10791, 0, '2016-10-14 14:52:34');

-- ----------------------------
-- Table structure for branch
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch`  (
  `branch_id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_status` int(11) NULL DEFAULT 1 COMMENT '1为可用，0为禁用',
  `branch_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `branch_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of branch
-- ----------------------------
INSERT INTO `branch` VALUES (1, 0, '技术部', '主要负责产品的研发');
INSERT INTO `branch` VALUES (2, 1, '销售部', '主要负责公司产品的销售');
INSERT INTO `branch` VALUES (3, 1, '人力资源部', '主要负责人才的招聘');
INSERT INTO `branch` VALUES (4, 1, '行政部', '公司内部管理');

-- ----------------------------
-- Table structure for buffet
-- ----------------------------
DROP TABLE IF EXISTS `buffet`;
CREATE TABLE `buffet`  (
  `buffet_id` int(11) NOT NULL AUTO_INCREMENT,
  `buffet_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `buffet_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `buffet_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `buffet_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `buffet_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `buffet_status` int(11) NULL DEFAULT 1 COMMENT '1为可用，0为禁用',
  PRIMARY KEY (`buffet_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of buffet
-- ----------------------------
INSERT INTO `buffet` VALUES (1, '/shxt/resource/upload/photo/dd97f611-8c74-4d94-a391-b81a36070c16.png', '佰烧', '69', '济南', '营养美味，种类繁多', 1);
INSERT INTO `buffet` VALUES (2, '/shxt/resource/upload/photo/15c13f73-73fa-4999-ac3a-1f67ced3debd.png', '嗨吃', '59', '济南', '让你吃high到爆', 1);
INSERT INTO `buffet` VALUES (3, '/shxt/resource/upload/photo/5fb056fb-8767-4fb2-afe4-d19ccfcbaca9.jpg', '大宇', '49', '济南', '海鲜产品应有尽有', 1);
INSERT INTO `buffet` VALUES (4, '/shxt/resource/upload/photo/331b1298-b7a8-4859-b5e4-97d2eb72824e.jpg', '炎烧烤', '109', '济南', '体验美味来一场味觉的盛宴吧', 1);
INSERT INTO `buffet` VALUES (5, '/shxt/resource/upload/photo/89802ac6-835d-4209-bd18-7fb93063b582.jpg', '比格自助餐厅', '49', '济南', '披萨甜点的盛宴', 1);
INSERT INTO `buffet` VALUES (6, '/shxt/resource/upload/photo/7dad6f25-8515-4bb9-a285-80dd8015a8d2.jpg', '索菲特', '169', '济南', '当旋转遇上美食', 1);
INSERT INTO `buffet` VALUES (7, '/shxt/resource/upload/photo/5dcff490-4fb3-4df7-b6cc-592f668d7540.jpg', '清水海', '219', '济南', '享受刺身的美味', 1);
INSERT INTO `buffet` VALUES (8, '/shxt/resource/upload/photo/c437fcaf-f67d-4768-a32a-931590091b59.jpg', '汉丽轩', '39', '济南', '美味实惠', 1);

-- ----------------------------
-- Table structure for bus
-- ----------------------------
DROP TABLE IF EXISTS `bus`;
CREATE TABLE `bus`  (
  `bus_id` int(11) NOT NULL AUTO_INCREMENT,
  `bus_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bus_from` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bus_to` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bus_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bus_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bus_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bus_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  PRIMARY KEY (`bus_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bus
-- ----------------------------
INSERT INTO `bus` VALUES (1, '/shxt/resource/upload/photo/1fdfd3ba-056e-4738-8c72-73e6489cec1c.png', '济南', '青岛', '128', '2016/10/05/9:00:00', '长途总站南区', 1);
INSERT INTO `bus` VALUES (2, '/shxt/resource/upload/photo/3f9319cb-0ddc-4994-a9f7-e4defd066c99.jpg', '济南', '德州', '85', '2016/10/05/9:00:00', '长途总站南区', 1);
INSERT INTO `bus` VALUES (3, '/shxt/resource/upload/photo/efcde582-04fb-4c0b-9d13-4e8be1fa0e66.jpg', '济南', '聊城', '75', '2016/10/05/9:00:00', '长途总站南区', 1);
INSERT INTO `bus` VALUES (4, '/shxt/resource/upload/photo/65e86b73-cf08-4169-9bb1-4c4c739c7a3e.jpg', '济南', '威海', '105', '2016/10/05/9:00:00', '长途总站南区', 1);
INSERT INTO `bus` VALUES (5, '/shxt/resource/upload/photo/a65bcb62-c3b1-40d1-9644-abc01c4aff12.jpg', '济南', '东营', '65', '2016/10/05/9:00:00', '长途总站南区', 1);
INSERT INTO `bus` VALUES (6, '/shxt/resource/upload/photo/7dcc85d7-0174-4acc-8c06-58e12bd95216.jpg', '济南', '上海', '219', '2016/10/05/9:00:00', '长途总站南区', 1);
INSERT INTO `bus` VALUES (7, '/shxt/resource/upload/photo/7fec7a38-14d1-4204-ab2b-3d1098a580b0.jpg', '济南', '天津', '159', '2016/10/05/9:00:00', '长途总站南区', 1);
INSERT INTO `bus` VALUES (8, '/shxt/resource/upload/photo/d6113d3f-a50a-4d31-8361-7ca93acda3b6.jpg', '济南', '西安', '229', '2016/10/05/9:00:00', '长途总站南区', 1);

-- ----------------------------
-- Table structure for faster
-- ----------------------------
DROP TABLE IF EXISTS `faster`;
CREATE TABLE `faster`  (
  `faster_id` int(11) NOT NULL AUTO_INCREMENT,
  `faster_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `faster_from` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `faster_to` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `faster_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `faster_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `faster_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `faster_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  PRIMARY KEY (`faster_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of faster
-- ----------------------------
INSERT INTO `faster` VALUES (1, '/shxt/resource/upload/photo/44166f53-8c72-4a99-9d47-20f07398bd55.jpg', '济南', '青岛', '199', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `faster` VALUES (2, '/shxt/resource/upload/photo/66bd108e-7527-478c-a816-eb8d5e48dae8.jpg', '济南', '德州', '108', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `faster` VALUES (3, '/shxt/resource/upload/photo/bf0f177d-9546-4544-9e6c-9acb38fcf668.jpg', '济南', '上海', '399', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `faster` VALUES (4, '/shxt/resource/upload/photo/0e251187-aefb-4b63-afc9-3ae5ef00a978.jpg', '济南', '西安', '255', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `faster` VALUES (5, '/shxt/resource/upload/photo/c63315ee-0dc2-497b-828c-0ee59377de1b.jpg', '济南', '聊城', '200', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `faster` VALUES (6, '/shxt/resource/upload/photo/0d01593e-5c97-4d4d-9154-d550dbb25598.jpg', '济南', '泰安', '169', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `faster` VALUES (7, '/shxt/resource/upload/photo/2503694e-026b-47b8-8f60-fc7e2d7c9dee.jpg', '济南', '烟台', '175', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `faster` VALUES (8, '/shxt/resource/upload/photo/7ef3c05c-528b-4d4d-8944-b262ee3e4812.jpg', '济南', '日照', '189', '2016/10/05/9:00:00', '济南站', 1);

-- ----------------------------
-- Table structure for finance
-- ----------------------------
DROP TABLE IF EXISTS `finance`;
CREATE TABLE `finance`  (
  `finance_id` int(11) NOT NULL AUTO_INCREMENT,
  `finance_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `finance_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `finance_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `finance_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `finance_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `finance_status` int(11) NULL DEFAULT 1 COMMENT '1为可用0为禁用',
  PRIMARY KEY (`finance_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of finance
-- ----------------------------
INSERT INTO `finance` VALUES (1, '/shxt/resource/upload/photo/a32231f1-8ece-4312-9d4d-c71efddf9ece.jpg', '伦敦5日游', '4999', '8', '享受欧美风光风俗', 1);
INSERT INTO `finance` VALUES (2, '/shxt/resource/upload/photo/bc6d384b-bfb8-42c4-940a-f37d74bd38f4.jpg', '罗马7日游', '6999', '12', '享受古罗马的热情奔放', 1);
INSERT INTO `finance` VALUES (3, '/shxt/resource/upload/photo/c8bfad59-3693-4a67-b5b9-56dab24e3eb0.jpg', '三亚7日自由行', '3999', '12', '邂逅浪漫，享受纯真', 1);
INSERT INTO `finance` VALUES (4, '/shxt/resource/upload/photo/4bf78e7d-5938-4aec-810b-64a84f089dbe.jpg', '济南3日游', '1000', '6', '享受济南的热情豪放', 1);

-- ----------------------------
-- Table structure for holiday
-- ----------------------------
DROP TABLE IF EXISTS `holiday`;
CREATE TABLE `holiday`  (
  `holiday_id` int(11) NOT NULL AUTO_INCREMENT,
  `holiday_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `holiday_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `holiday_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `holiday_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `holiday_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `holiday_status` int(11) NULL DEFAULT 1 COMMENT '1为可用，0为不可用',
  PRIMARY KEY (`holiday_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of holiday
-- ----------------------------
INSERT INTO `holiday` VALUES (1, '/shxt/resource/upload/photo/245c2b34-9550-49aa-9abf-ea73c71cecb4.jpg', '汉森假日酒店', '699', '圣彼得堡', '湖光山色，静谧悠然', 1);
INSERT INTO `holiday` VALUES (2, '/shxt/resource/upload/photo/658046b6-3662-44db-b77b-ec385dd3dd97.jpg', '璟和假日酒店', '499', '济南', '静谧悠然，享受假期的美好', 1);
INSERT INTO `holiday` VALUES (3, '/shxt/resource/upload/photo/e85840ec-739f-46b6-9cb0-e22403432ccb.jpg', '约翰假日酒店', '599', '巴黎', '静谧悠然，享受假期的美好', 1);
INSERT INTO `holiday` VALUES (4, '/shxt/resource/upload/photo/6adbc303-219b-49f8-b886-3cd7b80e7273.jpg', '贵和假日酒店', '599', '济南', '静谧悠然，享受假期的美好', 1);
INSERT INTO `holiday` VALUES (5, '/shxt/resource/upload/photo/a99983d0-f2fb-4f9e-95a2-6c02a3bd29e9.jpg', '文东假日酒店', '799', '济南', '静谧悠然，享受假期的美好', 1);
INSERT INTO `holiday` VALUES (6, '/shxt/resource/upload/photo/0b1c23f4-7345-442a-8c98-8a9d9f595390.jpg', '曙光假日酒店', '499', '南京', '享受假期的美好', 1);
INSERT INTO `holiday` VALUES (7, '/shxt/resource/upload/photo/b291b22b-b97d-4afb-a20c-c3cbd3119456.jpg', '济州假日酒店', '699', '釜山', '享受假期的美好', 1);
INSERT INTO `holiday` VALUES (8, '/shxt/resource/upload/photo/7068a777-3b8c-4465-bef1-4e5bf213ad6a.jpg', '东山假日宾馆', '599', '济南', '静谧悠然，享受假期的美好', 1);

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel`  (
  `hotel_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `hotel_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `hotel_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `hotel_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `hotel_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `hotel_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  PRIMARY KEY (`hotel_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES (1, '/shxt/resource/upload/photo/41473259-314c-40fa-8d96-13d3eafa1459.png', '银座佳驿', '109', '济南', '安静舒适', 1);
INSERT INTO `hotel` VALUES (2, '/shxt/resource/upload/photo/826aae89-40be-48e2-92d3-2b6d2aabb8a3.jpg', '格林豪泰酒店', '159', '济南', '安静舒适', 1);
INSERT INTO `hotel` VALUES (3, '/shxt/resource/upload/photo/287292c6-b70c-4926-9291-0df4bb309550.jpg', '七天', '129', '济南', '安静舒适', 1);
INSERT INTO `hotel` VALUES (4, '/shxt/resource/upload/photo/5f321f8b-44b4-4118-9bcc-e8c6e98d1065.jpg', '尚客优', '119', '济南', '安静舒适', 1);
INSERT INTO `hotel` VALUES (5, '/shxt/resource/upload/photo/d87528e5-7b9b-4c11-a479-84fe3550172e.jpg', '速八', '129', '济南', '安静舒适', 1);
INSERT INTO `hotel` VALUES (6, '/shxt/resource/upload/photo/73cd7425-7482-4bd6-9879-96da84835cbf.jpg', '如家宾馆', '139', '济南', '安静舒适', 1);
INSERT INTO `hotel` VALUES (7, '/shxt/resource/upload/photo/667f5d54-0783-4e57-b3c0-ef9adfee3c2a.jpg', '汉庭酒店', '139', '济南', '安静舒适', 1);
INSERT INTO `hotel` VALUES (8, '/shxt/resource/upload/photo/ba3f8dc1-97f7-40a7-94cf-7781fa6c073c.jpg', '银座佳驿', '129', '济南', '安静舒适', 1);

-- ----------------------------
-- Table structure for inboundticket
-- ----------------------------
DROP TABLE IF EXISTS `inboundticket`;
CREATE TABLE `inboundticket`  (
  `inboundTicket_id` int(11) NOT NULL AUTO_INCREMENT,
  `inboundTicket_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `inboundTicket_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `inboundTicket_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `inboundTicket_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`inboundTicket_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of inboundticket
-- ----------------------------
INSERT INTO `inboundticket` VALUES (1, '门票1', '/shxt/resource/upload/photo/fa135f1e-c1fc-4485-9327-5929806e8f75.jpg', '银子岩', '25');
INSERT INTO `inboundticket` VALUES (2, '门票2', '/shxt/resource/upload/photo/861e6ede-6455-451a-b878-845a3c42d6fb.jpg', '中山陵', '35');
INSERT INTO `inboundticket` VALUES (3, '门票3', '/shxt/resource/upload/photo/2ce5672c-2459-4b6a-9689-bc151f551f6f.jpg', '上海迪士尼乐园', '138');
INSERT INTO `inboundticket` VALUES (4, '门票4', '/shxt/resource/upload/photo/33731df0-40e7-48a5-8b9c-a60c18e78cb7.jpg', '天涯海角', '35');
INSERT INTO `inboundticket` VALUES (5, '门票5', '/shxt/resource/upload/photo/fcd99d96-0600-4276-8d93-1580e1c974d3.png', '漓江', '20');
INSERT INTO `inboundticket` VALUES (6, '门票6', '/shxt/resource/upload/photo/34b5d5bd-f790-4a6e-a044-84203e54125d.png', '西湖', '35');
INSERT INTO `inboundticket` VALUES (7, '门票7', '/shxt/resource/upload/photo/f86818b1-e517-4c3f-9937-1990b6111424.jpg', '蜈支洲岛', '25');
INSERT INTO `inboundticket` VALUES (8, '门票8', '/shxt/resource/upload/photo/e12fd942-2877-44dd-bce7-a19da539c9ab.jpg', '杜莎夫人蜡像馆', '45');
INSERT INTO `inboundticket` VALUES (9, '门票9', '/shxt/resource/upload/photo/11e52c6d-c76b-428f-8d90-ec14c60d0e90.jpg', '江南贡院', '40');
INSERT INTO `inboundticket` VALUES (10, '门票10', '/shxt/resource/upload/photo/7a85949a-4b25-4a4c-91d7-0ffd738d504c.jpg', '龙脊梯田', '30');
INSERT INTO `inboundticket` VALUES (11, '门票11', '/shxt/resource/upload/photo/f18647e9-9615-4500-884e-21d7a9ce3e8c.jpg', '东方明珠', '20');
INSERT INTO `inboundticket` VALUES (12, '门票12', '/shxt/resource/upload/photo/ba3a2168-9ac5-46ad-bbc1-f6bb42f79972.jpg', '狮子林', '50');
INSERT INTO `inboundticket` VALUES (13, '图片1', '/shxt/resource/upload/photo/72c84430-008b-48eb-813c-9c65e4d0bddb.jpg', NULL, NULL);
INSERT INTO `inboundticket` VALUES (14, '图片2', '/shxt/resource/upload/photo/3106d4a6-17f6-402a-84b7-6c0dd5d38e7e.jpg', NULL, NULL);
INSERT INTO `inboundticket` VALUES (15, '图片3', '/shxt/resource/upload/photo/ae734457-2f20-4c69-8a2d-ddde6865ebbe.jpg', NULL, NULL);

-- ----------------------------
-- Table structure for inboundtourism
-- ----------------------------
DROP TABLE IF EXISTS `inboundtourism`;
CREATE TABLE `inboundtourism`  (
  `inboundTourism_id` int(11) NOT NULL AUTO_INCREMENT,
  `inboundTourism_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `inboundTourism_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `inboundTourism_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`inboundTourism_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of inboundtourism
-- ----------------------------
INSERT INTO `inboundtourism` VALUES (1, '/shxt/resource/upload/photo/d602c007-e603-4484-9a16-1544a4e48a08.jpg', '私人订制主取景地--蜈支洲岛', '位置1');
INSERT INTO `inboundtourism` VALUES (2, '/shxt/resource/upload/photo/5a986b99-c500-4100-af90-5b69aed7505b.jpg', '山无棱，天地合，才敢与君绝--天涯海角', '位置2');
INSERT INTO `inboundtourism` VALUES (3, '/shxt/resource/upload/photo/feb2ad61-538f-4136-a8e3-d6acf80250e2.png', '在这里邂逅你的白娘子吧--西湖', '位置3');
INSERT INTO `inboundtourism` VALUES (4, '/shxt/resource/upload/photo/2a20b3b4-888a-41b7-ada4-4d8ddcfcc8f8.jpg', '游非诚勿扰拍摄地，感受湿地水乡浪漫--西溪湿地（周家村入口）', '位置4');
INSERT INTO `inboundtourism` VALUES (5, '/shxt/resource/upload/photo/2c31caae-d93d-4830-9835-edb96fbdf05e.jpg', '走自己的红毯，与世界明星相遇--上海杜莎夫人蜡像馆', '位置5');
INSERT INTO `inboundtourism` VALUES (6, '/shxt/resource/upload/photo/35277691-6e24-4956-94ec-7066d3930870.jpg', '感受云端漫步，品味老上海风情--东方明珠', '位置6');
INSERT INTO `inboundtourism` VALUES (7, '/shxt/resource/upload/photo/c97e6281-4cfa-4ece-b8ea-69ef9a38f187.jpg', '点亮心中奇梦--上海迪士尼乐园', '位置7');
INSERT INTO `inboundtourism` VALUES (8, '/shxt/resource/upload/photo/ce5bf70a-a853-4195-b2ce-0191f98ec7ef.png', '分明看见青山顶，船在青山顶上行--漓江', '位置8');
INSERT INTO `inboundtourism` VALUES (9, '/shxt/resource/upload/photo/0fe08a81-cc36-4e53-961e-19fb4907879a.jpg', '桂林城徽，最美赏月地领略三月争辉奇景--象鼻山', '位置9');
INSERT INTO `inboundtourism` VALUES (10, '/shxt/resource/upload/photo/b4a2b153-bb3e-4651-8bb6-7e51924f84f6.jpg', '桂林旅游圈新出现的一颗璀璨明珠--银子岩', '位置10');
INSERT INTO `inboundtourism` VALUES (11, '/shxt/resource/upload/photo/5b2600d6-3820-449f-a284-1f2c1a888c45.jpg', '中国最美的梯田，脱离城市去触摸自然--龙脊梯田', '位置11');
INSERT INTO `inboundtourism` VALUES (12, '/shxt/resource/upload/photo/5fdfbe92-8580-4b46-b7b2-bf08ec4146bc.jpg', '一条长江路，半部民国史--夫子庙秦淮河', '位置12');
INSERT INTO `inboundtourism` VALUES (13, '/shxt/resource/upload/photo/6d12d6f1-5dac-42e6-9eb3-5f77ba712665.jpg', '了解中国近代史，切记勿忘国耻--南京总统府', '位置13');
INSERT INTO `inboundtourism` VALUES (14, '/shxt/resource/upload/photo/f3cf9597-78e9-4783-8f8a-0630535eee34.jpg', '被誉为“中国近代建筑史上第一陵”--中山陵', '位置14');
INSERT INTO `inboundtourism` VALUES (15, '/shxt/resource/upload/photo/36a413aa-876e-412f-933b-2410df39f59b.jpg', '是供奉著名思想家、教育家孔子的庙宇--夫子庙大成殿', '位置15');
INSERT INTO `inboundtourism` VALUES (16, '/shxt/resource/upload/photo/dc8adc41-65f8-4b40-a330-3eca32f63fb7.jpg', '中国科举制度场所，科举文物史料机构--江南贡院', '位置16');
INSERT INTO `inboundtourism` VALUES (17, '/shxt/resource/upload/photo/9cc51eea-150c-4860-b90c-d810ae88c4ce.jpg', '庭院错落，花木为胜--拙政园', '位置17');
INSERT INTO `inboundtourism` VALUES (18, '/shxt/resource/upload/photo/2995a5e5-da25-46dc-884e-6c18cbb2b5d3.jpg', '苏州园林中代表清朝艺术风格的私家园林--留园', '位置18');
INSERT INTO `inboundtourism` VALUES (19, '/shxt/resource/upload/photo/ddfe356f-01e9-4f96-abf5-8b68e616be6b.jpg', '苏东坡说到苏州不游虎丘乃憾事也--虎丘', '位置19');
INSERT INTO `inboundtourism` VALUES (20, '/shxt/resource/upload/photo/05fd4f18-2ba8-428e-8f00-cb7c6a7576be.jpg', '苏州园林中代表元朝艺术风格的私家园林--狮子林', '位置20');
INSERT INTO `inboundtourism` VALUES (21, '/shxt/resource/upload/photo/99f8fb49-aa3b-4b51-ad37-2f05d673b757.jpg', '荡舟于此，感受江南的繁华与奢靡--苏州古运河', '位置21');

-- ----------------------------
-- Table structure for insurance
-- ----------------------------
DROP TABLE IF EXISTS `insurance`;
CREATE TABLE `insurance`  (
  `insurance_id` int(11) NOT NULL AUTO_INCREMENT,
  `insurance_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `insurance_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `insurance_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `insurance_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  `insurance_maxPrice` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `insurance_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`insurance_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of insurance
-- ----------------------------
INSERT INTO `insurance` VALUES (1, '/shxt/resource/upload/photo/4f1e5c13-a3b2-4f35-86fa-6a3d07817bcf.jpg', '10', '泰康人寿旅行意外险', 1, '30000', '最高可赔付30000');
INSERT INTO `insurance` VALUES (2, '/shxt/resource/upload/photo/6717a9ba-560e-48e3-81e9-d6c9a897521a.jpg', '100', '泰康人寿交通意外险', 1, '50000', '最高赔付50000元');
INSERT INTO `insurance` VALUES (3, '/shxt/resource/upload/photo/bea0ef65-93e8-4b18-94f0-d65dc019ec82.jpg', '20', '中国人寿旅游保险', 1, '30000', '最高可赔付30000');
INSERT INTO `insurance` VALUES (4, '/shxt/resource/upload/photo/6253f0fa-04d1-4e90-aec4-871b29dedaa7.jpg', '15', '晨曦旅游险', 1, '40000', '最高可赔付40000');

-- ----------------------------
-- Table structure for leave_
-- ----------------------------
DROP TABLE IF EXISTS `leave_`;
CREATE TABLE `leave_`  (
  `leave_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_user_id` int(11) NULL DEFAULT NULL,
  `leave_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `leave_branch` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `leave_role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `leave_day` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `leave_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `leave_startDay` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `leave_overDay` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `leave_agreeUser` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `leave_status` int(11) NULL DEFAULT -1 COMMENT '-1为未处理，1为同意，0为拒绝',
  PRIMARY KEY (`leave_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of leave_
-- ----------------------------
INSERT INTO `leave_` VALUES (1, 2, '张三', '技术部', '技术总监', '2', '孩子结婚', '2016/8/21', '2016/8/23', '', 1);
INSERT INTO `leave_` VALUES (2, NULL, '升哥', '技术部', '超级管理员', '3', '生病', '2016/9/1', '2016/9/3', NULL, 1);
INSERT INTO `leave_` VALUES (3, NULL, '升哥', '技术部', '超级管理员', '2', '病假', '2016/9/18', '2016/9/20', NULL, 1);
INSERT INTO `leave_` VALUES (4, NULL, '升哥', '技术部', '超级管理员', '12', '生病', '2016/9/17', '2016/9/29', NULL, 1);
INSERT INTO `leave_` VALUES (5, NULL, '升哥', '技术部', '超级管理员', '2', '结婚', '2016/10/14', '2016/10/16', NULL, 1);
INSERT INTO `leave_` VALUES (6, NULL, '升哥', '技术部', '超级管理员', '2', '结婚', '2016/9/17', '2016/9/19', NULL, -1);

-- ----------------------------
-- Table structure for login_record
-- ----------------------------
DROP TABLE IF EXISTS `login_record`;
CREATE TABLE `login_record`  (
  `login_record_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_record_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `login_record_create_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `login_record_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`login_record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 358 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login_record
-- ----------------------------
INSERT INTO `login_record` VALUES (1, '帅哥', '2016-08-23 16:48:43', 'admin');
INSERT INTO `login_record` VALUES (2, '帅哥', '2016-08-23 16:49:06', 'admin');
INSERT INTO `login_record` VALUES (3, '帅哥', '2016-08-23 19:32:59', 'admin');
INSERT INTO `login_record` VALUES (4, '帅哥', '2016-08-23 20:11:25', 'admin');
INSERT INTO `login_record` VALUES (5, '帅哥', '2016-08-23 22:02:38', 'admin');
INSERT INTO `login_record` VALUES (6, '帅哥', '2016-08-23 22:03:34', 'admin');
INSERT INTO `login_record` VALUES (7, '帅哥', '2016-08-23 22:39:53', 'admin');
INSERT INTO `login_record` VALUES (8, '帅哥', '2016-08-23 22:45:58', 'admin');
INSERT INTO `login_record` VALUES (9, '帅哥', '2016-08-24 09:38:58', 'admin');
INSERT INTO `login_record` VALUES (10, '帅哥', '2016-08-24 10:47:51', 'admin');
INSERT INTO `login_record` VALUES (11, '帅哥', '2016-08-24 11:37:22', 'admin');
INSERT INTO `login_record` VALUES (12, '帅哥', '2016-08-24 11:47:46', 'admin');
INSERT INTO `login_record` VALUES (13, '帅哥', '2016-08-24 13:49:05', 'admin');
INSERT INTO `login_record` VALUES (14, '帅哥', '2016-08-24 14:01:07', 'admin');
INSERT INTO `login_record` VALUES (15, '帅哥', '2016-08-24 14:14:24', 'admin');
INSERT INTO `login_record` VALUES (16, '帅哥', '2016-08-24 14:37:30', 'admin');
INSERT INTO `login_record` VALUES (17, '帅哥', '2016-08-24 14:59:07', 'admin');
INSERT INTO `login_record` VALUES (18, '帅哥', '2016-08-24 15:57:56', 'admin');
INSERT INTO `login_record` VALUES (19, '帅哥', '2016-08-24 16:12:12', 'admin');
INSERT INTO `login_record` VALUES (20, '帅哥', '2016-08-24 16:16:36', 'admin');
INSERT INTO `login_record` VALUES (21, '帅哥', '2016-08-24 16:28:10', 'admin');
INSERT INTO `login_record` VALUES (22, '帅哥', '2016-08-24 16:39:32', 'admin');
INSERT INTO `login_record` VALUES (23, '萌萌1', '2016-08-24 16:40:04', 'aaaaaa');
INSERT INTO `login_record` VALUES (24, '帅', '2016-08-24 16:48:23', 'admin');
INSERT INTO `login_record` VALUES (25, '帅哥', '2016-08-24 18:04:30', 'admin');
INSERT INTO `login_record` VALUES (26, '帅哥', '2016-08-24 18:07:49', 'admin');
INSERT INTO `login_record` VALUES (27, '帅哥', '2016-08-24 20:46:56', 'admin');
INSERT INTO `login_record` VALUES (28, '帅哥', '2016-08-25 09:36:30', 'admin');
INSERT INTO `login_record` VALUES (29, '帅哥', '2016-08-25 10:55:17', 'admin');
INSERT INTO `login_record` VALUES (30, '帅哥', '2016-08-25 11:06:16', 'admin');
INSERT INTO `login_record` VALUES (31, '升哥', '2016-08-25 11:22:08', 'admin');
INSERT INTO `login_record` VALUES (32, '升哥', '2016-08-25 11:26:53', 'admin');
INSERT INTO `login_record` VALUES (33, '升哥', '2016-08-25 11:28:48', 'admin');
INSERT INTO `login_record` VALUES (34, '升哥', '2016-08-25 11:30:39', 'admin');
INSERT INTO `login_record` VALUES (35, '升哥', '2016-08-25 11:33:58', 'admin');
INSERT INTO `login_record` VALUES (36, '升哥', '2016-08-25 16:34:00', 'admin');
INSERT INTO `login_record` VALUES (37, '升哥', '2016-08-25 19:36:31', 'admin');
INSERT INTO `login_record` VALUES (38, '升哥', '2016-08-25 20:18:10', 'admin');
INSERT INTO `login_record` VALUES (39, '升哥', '2016-08-25 21:32:09', 'admin');
INSERT INTO `login_record` VALUES (40, '升哥', '2016-08-25 22:40:47', 'admin');
INSERT INTO `login_record` VALUES (41, '花花', '2016-08-25 22:52:42', 'huahua');
INSERT INTO `login_record` VALUES (42, '升哥', '2016-08-25 23:03:45', 'admin');
INSERT INTO `login_record` VALUES (43, '升哥', '2016-08-25 23:17:56', 'admin');
INSERT INTO `login_record` VALUES (44, '升哥', '2016-08-25 23:35:01', 'admin');
INSERT INTO `login_record` VALUES (45, '升哥', '2016-08-27 15:31:56', 'admin');
INSERT INTO `login_record` VALUES (46, '升哥', '2016-08-27 16:38:25', 'admin');
INSERT INTO `login_record` VALUES (47, '升哥', '2016-08-27 17:15:44', 'admin');
INSERT INTO `login_record` VALUES (48, '升哥', '2016-08-27 18:17:29', 'admin');
INSERT INTO `login_record` VALUES (49, '升哥', '2016-08-27 18:49:15', 'admin');
INSERT INTO `login_record` VALUES (50, '升哥', '2016-08-27 19:00:43', 'admin');
INSERT INTO `login_record` VALUES (51, '升哥', '2016-08-27 19:39:26', 'admin');
INSERT INTO `login_record` VALUES (52, '升哥', '2016-08-27 21:02:27', 'admin');
INSERT INTO `login_record` VALUES (53, '升哥', '2016-08-27 22:24:33', 'admin');
INSERT INTO `login_record` VALUES (54, '升哥', '2016-08-27 22:55:27', 'admin');
INSERT INTO `login_record` VALUES (55, '升哥', '2016-08-27 22:59:52', 'admin');
INSERT INTO `login_record` VALUES (56, '升哥', '2016-08-27 23:08:03', 'admin');
INSERT INTO `login_record` VALUES (57, '升哥', '2016-08-27 23:19:40', 'admin');
INSERT INTO `login_record` VALUES (58, '升哥', '2016-08-27 23:20:00', 'admin');
INSERT INTO `login_record` VALUES (59, '升哥', '2016-08-28 10:12:32', 'admin');
INSERT INTO `login_record` VALUES (60, '升哥', '2016-08-28 10:33:19', 'admin');
INSERT INTO `login_record` VALUES (61, '升哥', '2016-08-28 10:51:57', 'admin');
INSERT INTO `login_record` VALUES (62, '升哥', '2016-08-28 10:54:38', 'admin');
INSERT INTO `login_record` VALUES (63, '升哥', '2016-08-28 10:57:13', 'admin');
INSERT INTO `login_record` VALUES (64, '升哥', '2016-08-28 10:57:58', 'admin');
INSERT INTO `login_record` VALUES (65, '升哥', '2016-08-28 13:10:14', 'admin');
INSERT INTO `login_record` VALUES (66, '升哥', '2016-08-28 16:55:21', 'admin');
INSERT INTO `login_record` VALUES (67, '升哥', '2016-08-28 17:16:22', 'admin');
INSERT INTO `login_record` VALUES (68, '升哥', '2016-08-28 18:26:03', 'admin');
INSERT INTO `login_record` VALUES (69, '萌萌', '2016-08-28 18:54:01', 'aaaaaa');
INSERT INTO `login_record` VALUES (70, '萌萌', '2016-08-28 18:54:48', 'aaaaaa');
INSERT INTO `login_record` VALUES (71, '升哥', '2016-08-28 19:14:23', 'admin');
INSERT INTO `login_record` VALUES (72, '升哥', '2016-08-28 19:15:27', 'admin');
INSERT INTO `login_record` VALUES (73, '升哥', '2016-08-28 20:59:19', 'admin');
INSERT INTO `login_record` VALUES (74, '升哥', '2016-08-28 21:45:49', 'admin');
INSERT INTO `login_record` VALUES (75, '升哥', '2016-08-28 22:00:25', 'admin');
INSERT INTO `login_record` VALUES (76, '升哥', '2016-08-28 22:02:24', 'admin');
INSERT INTO `login_record` VALUES (77, '升哥', '2016-08-28 23:06:10', 'admin');
INSERT INTO `login_record` VALUES (78, '升哥', '2016-08-29 19:40:52', 'admin');
INSERT INTO `login_record` VALUES (79, '升哥', '2016-08-29 19:49:06', 'admin');
INSERT INTO `login_record` VALUES (80, '升哥', '2016-08-29 19:50:54', 'admin');
INSERT INTO `login_record` VALUES (81, '升哥', '2016-08-29 20:17:39', 'admin');
INSERT INTO `login_record` VALUES (82, '升哥', '2016-08-29 20:25:58', 'admin');
INSERT INTO `login_record` VALUES (83, '升哥', '2016-08-29 20:26:23', 'admin');
INSERT INTO `login_record` VALUES (84, '升哥', '2016-08-29 20:32:50', 'admin');
INSERT INTO `login_record` VALUES (85, '升哥', '2016-08-29 20:36:35', 'admin');
INSERT INTO `login_record` VALUES (86, '升哥', '2016-08-29 21:43:03', 'admin');
INSERT INTO `login_record` VALUES (87, '升哥', '2016-08-29 21:47:10', 'admin');
INSERT INTO `login_record` VALUES (88, '升哥', '2016-08-29 21:49:23', 'admin');
INSERT INTO `login_record` VALUES (89, '升哥', '2016-08-29 22:41:04', 'admin');
INSERT INTO `login_record` VALUES (90, '升哥', '2016-08-30 12:40:56', 'admin');
INSERT INTO `login_record` VALUES (91, '升哥', '2016-08-30 13:18:30', 'admin');
INSERT INTO `login_record` VALUES (92, '升哥', '2016-08-30 14:03:11', 'admin');
INSERT INTO `login_record` VALUES (93, '升哥', '2016-08-30 19:25:18', 'admin');
INSERT INTO `login_record` VALUES (94, '升哥', '2016-08-30 19:27:05', 'admin');
INSERT INTO `login_record` VALUES (95, '升哥', '2016-08-30 19:27:46', 'admin');
INSERT INTO `login_record` VALUES (96, '升哥', '2016-08-30 19:31:28', 'admin');
INSERT INTO `login_record` VALUES (97, '升哥', '2016-08-30 19:33:34', 'admin');
INSERT INTO `login_record` VALUES (98, '升哥', '2016-08-30 19:35:29', 'admin');
INSERT INTO `login_record` VALUES (99, '升哥', '2016-08-30 19:40:13', 'admin');
INSERT INTO `login_record` VALUES (100, '升哥', '2016-08-30 20:17:03', 'admin');
INSERT INTO `login_record` VALUES (101, '升哥', '2016-08-30 20:53:21', 'admin');
INSERT INTO `login_record` VALUES (102, '升哥', '2016-08-30 21:32:16', 'admin');
INSERT INTO `login_record` VALUES (103, '升哥', '2016-08-30 22:55:35', 'admin');
INSERT INTO `login_record` VALUES (104, '升哥', '2016-08-31 16:13:27', 'admin');
INSERT INTO `login_record` VALUES (105, '升哥', '2016-08-31 16:43:05', 'admin');
INSERT INTO `login_record` VALUES (106, '升哥', '2016-08-31 16:44:36', 'admin');
INSERT INTO `login_record` VALUES (107, '升哥', '2016-08-31 19:04:20', 'admin');
INSERT INTO `login_record` VALUES (108, '升哥', '2016-08-31 19:06:00', 'admin');
INSERT INTO `login_record` VALUES (109, '升哥', '2016-09-01 22:50:28', 'admin');
INSERT INTO `login_record` VALUES (110, '升哥', '2016-09-02 14:48:43', 'admin');
INSERT INTO `login_record` VALUES (111, '升哥', '2016-09-02 15:16:09', 'admin');
INSERT INTO `login_record` VALUES (112, '升哥', '2016-09-02 15:25:54', 'admin');
INSERT INTO `login_record` VALUES (113, '升哥', '2016-09-02 15:26:54', 'admin');
INSERT INTO `login_record` VALUES (114, '升哥', '2016-09-03 08:34:55', 'admin');
INSERT INTO `login_record` VALUES (115, '升哥', '2016-09-03 09:11:43', 'admin');
INSERT INTO `login_record` VALUES (116, '升哥', '2016-09-03 09:16:28', 'admin');
INSERT INTO `login_record` VALUES (117, '升哥', '2016-09-03 09:40:44', 'admin');
INSERT INTO `login_record` VALUES (118, '升哥', '2016-09-03 10:08:42', 'admin');
INSERT INTO `login_record` VALUES (119, '升哥', '2016-09-03 10:52:34', 'admin');
INSERT INTO `login_record` VALUES (120, '升哥', '2016-09-03 10:55:22', 'admin');
INSERT INTO `login_record` VALUES (121, '升哥', '2016-09-03 10:56:56', 'admin');
INSERT INTO `login_record` VALUES (122, '升哥', '2016-09-03 10:58:33', 'admin');
INSERT INTO `login_record` VALUES (123, '升哥', '2016-09-03 11:27:23', 'admin');
INSERT INTO `login_record` VALUES (124, '升哥', '2016-09-03 12:41:44', 'admin');
INSERT INTO `login_record` VALUES (125, '升哥', '2016-09-03 12:51:21', 'admin');
INSERT INTO `login_record` VALUES (126, '升哥', '2016-09-03 13:27:12', 'admin');
INSERT INTO `login_record` VALUES (127, '升哥', '2016-09-03 13:59:25', 'admin');
INSERT INTO `login_record` VALUES (128, '升哥', '2016-09-03 15:19:43', 'admin');
INSERT INTO `login_record` VALUES (129, '升哥', '2016-09-03 15:21:44', 'admin');
INSERT INTO `login_record` VALUES (130, '升哥', '2016-09-03 15:34:36', 'admin');
INSERT INTO `login_record` VALUES (131, '升哥', '2016-09-03 15:38:13', 'admin');
INSERT INTO `login_record` VALUES (132, '萌萌', '2016-09-03 15:51:30', 'aaaaaa');
INSERT INTO `login_record` VALUES (133, '升哥', '2016-09-03 15:52:31', 'admin');
INSERT INTO `login_record` VALUES (134, '升哥', '2016-09-03 16:02:13', 'admin');
INSERT INTO `login_record` VALUES (135, '升哥', '2016-09-03 16:13:52', 'admin');
INSERT INTO `login_record` VALUES (136, '升哥', '2016-09-03 18:50:19', 'admin');
INSERT INTO `login_record` VALUES (137, '升哥', '2016-09-03 18:53:20', 'admin');
INSERT INTO `login_record` VALUES (138, '升哥', '2016-09-03 18:53:40', 'admin');
INSERT INTO `login_record` VALUES (139, '升哥', '2016-09-03 18:53:47', 'admin');
INSERT INTO `login_record` VALUES (140, '升哥', '2016-09-03 19:16:48', 'admin');
INSERT INTO `login_record` VALUES (141, '升哥', '2016-09-03 19:19:06', 'admin');
INSERT INTO `login_record` VALUES (142, '升哥', '2016-09-03 20:25:10', 'admin');
INSERT INTO `login_record` VALUES (143, '升哥', '2016-09-04 16:47:31', 'admin');
INSERT INTO `login_record` VALUES (144, '升哥', '2016-09-04 16:55:45', 'admin');
INSERT INTO `login_record` VALUES (145, '美腻的学姐', '2016-09-04 17:41:33', 'dddddd');
INSERT INTO `login_record` VALUES (146, '升哥', '2016-09-04 17:41:47', 'admin');
INSERT INTO `login_record` VALUES (147, '升哥', '2016-09-04 17:44:20', 'admin');
INSERT INTO `login_record` VALUES (148, '升哥', '2016-09-04 17:45:38', 'admin');
INSERT INTO `login_record` VALUES (149, '升哥', '2016-09-04 19:39:34', 'admin');
INSERT INTO `login_record` VALUES (150, '升哥', '2016-09-04 19:41:22', 'admin');
INSERT INTO `login_record` VALUES (151, '升哥', '2016-09-04 19:41:58', 'admin');
INSERT INTO `login_record` VALUES (152, '升哥', '2016-09-04 19:45:59', 'admin');
INSERT INTO `login_record` VALUES (153, '升哥', '2016-09-04 20:16:08', 'admin');
INSERT INTO `login_record` VALUES (154, '升哥', '2016-09-04 20:18:04', 'admin');
INSERT INTO `login_record` VALUES (155, '升哥', '2016-09-04 20:24:28', 'admin');
INSERT INTO `login_record` VALUES (156, '升哥', '2016-09-04 20:33:25', 'admin');
INSERT INTO `login_record` VALUES (157, '升哥', '2016-09-04 20:36:29', 'admin');
INSERT INTO `login_record` VALUES (158, '升哥', '2016-09-04 20:37:43', 'admin');
INSERT INTO `login_record` VALUES (159, '升哥', '2016-09-05 14:15:12', 'admin');
INSERT INTO `login_record` VALUES (160, '升哥', '2016-09-05 15:03:42', 'admin');
INSERT INTO `login_record` VALUES (161, '升哥', '2016-09-05 19:14:49', 'admin');
INSERT INTO `login_record` VALUES (162, '升哥', '2016-09-06 14:38:25', 'admin');
INSERT INTO `login_record` VALUES (163, '升哥', '2016-09-06 14:45:17', 'admin');
INSERT INTO `login_record` VALUES (164, '升哥', '2016-09-06 18:50:27', 'admin');
INSERT INTO `login_record` VALUES (165, '升哥', '2016-09-06 18:56:04', 'admin');
INSERT INTO `login_record` VALUES (166, '升哥', '2016-09-07 15:44:43', 'admin');
INSERT INTO `login_record` VALUES (167, '升哥', '2016-09-07 18:47:08', 'admin');
INSERT INTO `login_record` VALUES (168, '升哥', '2016-09-07 19:12:51', 'admin');
INSERT INTO `login_record` VALUES (169, '升哥', '2016-09-07 19:14:46', 'admin');
INSERT INTO `login_record` VALUES (170, '升哥', '2016-09-07 19:16:22', 'admin');
INSERT INTO `login_record` VALUES (171, '升哥', '2016-09-08 09:13:01', 'admin');
INSERT INTO `login_record` VALUES (172, '升哥', '2016-09-08 10:23:00', 'admin');
INSERT INTO `login_record` VALUES (173, '升哥', '2016-09-08 10:54:15', 'admin');
INSERT INTO `login_record` VALUES (174, '升哥', '2016-09-08 10:54:49', 'admin');
INSERT INTO `login_record` VALUES (175, '升哥', '2016-09-10 09:54:34', 'admin');
INSERT INTO `login_record` VALUES (176, '升哥', '2016-09-10 11:02:44', 'admin');
INSERT INTO `login_record` VALUES (177, '升哥', '2016-09-10 11:12:11', 'admin');
INSERT INTO `login_record` VALUES (178, '升哥', '2016-09-10 12:35:20', 'admin');
INSERT INTO `login_record` VALUES (179, '升哥', '2016-09-10 12:37:37', 'admin');
INSERT INTO `login_record` VALUES (180, '升哥', '2016-09-10 18:56:17', 'admin');
INSERT INTO `login_record` VALUES (181, '升哥', '2016-09-10 19:14:19', 'admin');
INSERT INTO `login_record` VALUES (182, '升哥', '2016-09-10 19:16:09', 'admin');
INSERT INTO `login_record` VALUES (183, '升哥', '2016-09-10 19:17:43', 'admin');
INSERT INTO `login_record` VALUES (184, '升哥', '2016-09-10 19:21:16', 'admin');
INSERT INTO `login_record` VALUES (185, '升哥', '2016-09-10 19:57:06', 'admin');
INSERT INTO `login_record` VALUES (186, '升哥', '2016-09-10 20:21:47', 'admin');
INSERT INTO `login_record` VALUES (187, '升哥', '2016-09-11 08:46:00', 'admin');
INSERT INTO `login_record` VALUES (188, '升哥', '2016-09-11 09:35:29', 'admin');
INSERT INTO `login_record` VALUES (189, '升哥', '2016-09-11 09:38:15', 'admin');
INSERT INTO `login_record` VALUES (190, '美腻的学妹', '2016-09-11 09:38:54', 'eeeeee');
INSERT INTO `login_record` VALUES (191, '升哥', '2016-09-11 09:39:41', 'admin');
INSERT INTO `login_record` VALUES (192, '升哥', '2016-09-11 09:45:21', 'admin');
INSERT INTO `login_record` VALUES (193, '升哥', '2016-09-11 10:10:20', 'admin');
INSERT INTO `login_record` VALUES (194, '升哥', '2016-09-11 10:37:26', 'admin');
INSERT INTO `login_record` VALUES (195, '升哥', '2016-09-11 11:20:03', 'admin');
INSERT INTO `login_record` VALUES (196, '升哥', '2016-09-11 12:09:09', 'admin');
INSERT INTO `login_record` VALUES (197, '升哥', '2016-09-11 19:44:48', 'admin');
INSERT INTO `login_record` VALUES (198, '升哥', '2016-09-11 22:25:57', 'admin');
INSERT INTO `login_record` VALUES (199, '升哥', '2016-09-12 20:33:35', 'admin');
INSERT INTO `login_record` VALUES (200, '升哥', '2016-09-12 21:06:44', 'admin');
INSERT INTO `login_record` VALUES (201, '升哥', '2016-09-12 21:11:18', 'admin');
INSERT INTO `login_record` VALUES (202, '升哥', '2016-09-12 21:35:50', 'admin');
INSERT INTO `login_record` VALUES (203, '升哥', '2016-09-12 22:18:23', 'admin');
INSERT INTO `login_record` VALUES (204, '升哥', '2016-09-13 09:51:41', 'admin');
INSERT INTO `login_record` VALUES (205, '升哥', '2016-09-13 09:52:33', 'admin');
INSERT INTO `login_record` VALUES (206, '升哥', '2016-09-13 19:24:32', 'admin');
INSERT INTO `login_record` VALUES (207, '升哥', '2016-09-13 21:25:50', 'admin');
INSERT INTO `login_record` VALUES (208, '升哥', '2016-09-14 19:31:12', 'admin');
INSERT INTO `login_record` VALUES (209, '升哥', '2016-09-14 20:48:42', 'admin');
INSERT INTO `login_record` VALUES (210, '升哥', '2016-09-14 20:54:33', 'admin');
INSERT INTO `login_record` VALUES (211, '升哥', '2016-09-14 20:56:28', 'admin');
INSERT INTO `login_record` VALUES (212, '升哥', '2016-09-15 10:40:47', 'admin');
INSERT INTO `login_record` VALUES (213, '升哥', '2016-09-15 16:32:45', 'admin');
INSERT INTO `login_record` VALUES (214, '升哥', '2016-09-15 20:09:55', 'admin');
INSERT INTO `login_record` VALUES (215, '升哥', '2016-09-15 20:12:57', 'admin');
INSERT INTO `login_record` VALUES (216, '升哥', '2016-09-16 16:53:03', 'admin');
INSERT INTO `login_record` VALUES (217, '升哥', '2016-09-16 17:32:49', 'admin');
INSERT INTO `login_record` VALUES (218, '升哥', '2016-09-18 07:37:43', 'admin');
INSERT INTO `login_record` VALUES (219, '升哥', '2016-09-18 07:46:34', 'admin');
INSERT INTO `login_record` VALUES (220, '升哥', '2016-09-19 14:59:20', 'admin');
INSERT INTO `login_record` VALUES (221, '升哥', '2016-09-19 15:16:34', 'admin');
INSERT INTO `login_record` VALUES (222, '升哥', '2016-09-19 21:39:41', 'admin');
INSERT INTO `login_record` VALUES (223, '升哥', '2016-09-20 13:06:50', 'admin');
INSERT INTO `login_record` VALUES (224, '升哥', '2016-09-20 13:19:37', 'admin');
INSERT INTO `login_record` VALUES (225, '升哥', '2016-09-20 15:17:29', 'admin');
INSERT INTO `login_record` VALUES (226, '升哥', '2016-09-20 15:20:02', 'admin');
INSERT INTO `login_record` VALUES (227, '升哥', '2016-09-20 18:04:41', 'admin');
INSERT INTO `login_record` VALUES (228, '升哥', '2016-09-20 21:19:29', 'admin');
INSERT INTO `login_record` VALUES (229, '升哥', '2016-09-20 21:57:27', 'admin');
INSERT INTO `login_record` VALUES (230, '升哥', '2016-09-22 08:55:20', 'admin');
INSERT INTO `login_record` VALUES (231, '升哥', '2016-09-22 10:54:23', 'admin');
INSERT INTO `login_record` VALUES (232, '升哥', '2016-09-22 11:54:21', 'admin');
INSERT INTO `login_record` VALUES (233, '升哥', '2016-09-22 14:22:40', 'admin');
INSERT INTO `login_record` VALUES (234, '升哥', '2016-09-23 12:38:12', 'admin');
INSERT INTO `login_record` VALUES (235, '升哥', '2016-09-23 13:58:30', 'admin');
INSERT INTO `login_record` VALUES (236, '升哥', '2016-09-23 15:59:59', 'admin');
INSERT INTO `login_record` VALUES (237, '升哥', '2016-09-23 19:54:32', 'admin');
INSERT INTO `login_record` VALUES (238, '升哥', '2016-09-24 08:54:22', 'admin');
INSERT INTO `login_record` VALUES (239, '升哥', '2016-09-24 09:46:06', 'admin');
INSERT INTO `login_record` VALUES (240, '升哥', '2016-09-24 11:01:48', 'admin');
INSERT INTO `login_record` VALUES (241, '升哥', '2016-09-24 15:14:26', 'admin');
INSERT INTO `login_record` VALUES (242, '升哥', '2016-09-24 15:36:54', 'admin');
INSERT INTO `login_record` VALUES (243, '升哥', '2016-09-24 16:58:58', 'admin');
INSERT INTO `login_record` VALUES (244, '升哥', '2016-09-24 19:36:15', 'admin');
INSERT INTO `login_record` VALUES (245, '升哥', '2016-09-25 16:18:38', 'admin');
INSERT INTO `login_record` VALUES (246, '升哥', '2016-09-25 17:18:40', 'admin');
INSERT INTO `login_record` VALUES (247, '升哥', '2016-09-25 19:41:37', 'admin');
INSERT INTO `login_record` VALUES (248, '升哥', '2016-09-25 20:05:05', 'admin');
INSERT INTO `login_record` VALUES (249, '升哥', '2016-09-26 19:10:11', 'admin');
INSERT INTO `login_record` VALUES (250, '升哥', '2016-09-26 19:56:20', 'admin');
INSERT INTO `login_record` VALUES (251, '升哥', '2016-09-26 20:28:40', 'admin');
INSERT INTO `login_record` VALUES (252, '升哥', '2016-09-26 21:05:59', 'admin');
INSERT INTO `login_record` VALUES (253, '升哥', '2016-09-27 09:57:52', 'admin');
INSERT INTO `login_record` VALUES (254, '升哥', '2016-09-27 10:42:37', 'admin');
INSERT INTO `login_record` VALUES (255, '升哥', '2016-09-27 12:00:49', 'admin');
INSERT INTO `login_record` VALUES (256, '升哥', '2016-09-27 12:50:04', 'admin');
INSERT INTO `login_record` VALUES (257, '升哥', '2016-09-27 13:30:01', 'admin');
INSERT INTO `login_record` VALUES (258, '升哥', '2016-09-27 14:45:10', 'admin');
INSERT INTO `login_record` VALUES (259, '升哥', '2016-09-27 15:06:59', 'admin');
INSERT INTO `login_record` VALUES (260, '升哥', '2016-09-27 15:09:45', 'admin');
INSERT INTO `login_record` VALUES (261, '升哥', '2016-09-27 19:17:48', 'admin');
INSERT INTO `login_record` VALUES (262, '升哥', '2016-09-27 21:11:03', 'admin');
INSERT INTO `login_record` VALUES (263, '升哥', '2016-09-27 21:15:08', 'admin');
INSERT INTO `login_record` VALUES (264, '升哥', '2016-09-27 21:27:38', 'admin');
INSERT INTO `login_record` VALUES (265, '升哥', '2016-09-27 21:31:08', 'admin');
INSERT INTO `login_record` VALUES (266, '升哥', '2016-09-27 21:32:54', 'admin');
INSERT INTO `login_record` VALUES (267, '升哥', '2016-09-27 21:39:17', 'admin');
INSERT INTO `login_record` VALUES (268, '升哥', '2016-09-27 21:43:16', 'admin');
INSERT INTO `login_record` VALUES (269, '升哥', '2016-09-27 21:44:24', 'admin');
INSERT INTO `login_record` VALUES (270, '升哥', '2016-09-27 22:21:23', 'admin');
INSERT INTO `login_record` VALUES (271, '升哥', '2016-09-27 23:06:02', 'admin');
INSERT INTO `login_record` VALUES (272, '升哥', '2016-09-28 21:34:48', 'admin');
INSERT INTO `login_record` VALUES (273, '升哥', '2016-09-28 22:14:01', 'admin');
INSERT INTO `login_record` VALUES (274, '升哥', '2016-09-28 23:45:25', 'admin');
INSERT INTO `login_record` VALUES (275, '升哥', '2016-09-29 11:47:09', 'admin');
INSERT INTO `login_record` VALUES (276, '升哥', '2016-09-29 12:00:55', 'admin');
INSERT INTO `login_record` VALUES (277, '升哥', '2016-09-30 16:34:44', 'admin');
INSERT INTO `login_record` VALUES (278, '升哥', '2016-09-30 17:23:53', 'admin');
INSERT INTO `login_record` VALUES (279, '升哥', '2016-09-30 17:27:00', 'admin');
INSERT INTO `login_record` VALUES (280, '升哥', '2016-09-30 17:45:43', 'admin');
INSERT INTO `login_record` VALUES (281, '升哥', '2016-09-30 20:56:37', 'admin');
INSERT INTO `login_record` VALUES (282, '升哥', '2016-10-01 21:02:54', 'admin');
INSERT INTO `login_record` VALUES (283, '升哥', '2016-10-02 09:27:22', 'admin');
INSERT INTO `login_record` VALUES (284, '升哥', '2016-10-02 10:41:41', 'admin');
INSERT INTO `login_record` VALUES (285, '升哥', '2016-10-02 11:10:39', 'admin');
INSERT INTO `login_record` VALUES (286, '升哥', '2016-10-02 17:15:10', 'admin');
INSERT INTO `login_record` VALUES (287, '升哥', '2016-10-02 21:12:30', 'admin');
INSERT INTO `login_record` VALUES (288, '升哥', '2016-10-02 21:49:53', 'admin');
INSERT INTO `login_record` VALUES (289, '升哥', '2016-10-03 10:56:53', 'admin');
INSERT INTO `login_record` VALUES (290, '升哥', '2016-10-03 11:44:35', 'admin');
INSERT INTO `login_record` VALUES (291, '升哥', '2016-10-03 14:47:20', 'admin');
INSERT INTO `login_record` VALUES (292, '升哥', '2016-10-03 15:50:42', 'admin');
INSERT INTO `login_record` VALUES (293, '升哥', '2016-10-03 16:36:37', 'admin');
INSERT INTO `login_record` VALUES (294, '升哥', '2016-10-03 20:23:29', 'admin');
INSERT INTO `login_record` VALUES (295, '升哥', '2016-10-03 20:52:03', 'admin');
INSERT INTO `login_record` VALUES (296, '升哥', '2016-10-03 21:00:36', 'admin');
INSERT INTO `login_record` VALUES (297, '升哥', '2016-10-04 10:11:45', 'admin');
INSERT INTO `login_record` VALUES (298, '升哥', '2016-10-04 10:15:31', 'admin');
INSERT INTO `login_record` VALUES (299, '升哥', '2016-10-04 10:46:47', 'admin');
INSERT INTO `login_record` VALUES (300, '升哥', '2016-10-04 15:21:51', 'admin');
INSERT INTO `login_record` VALUES (301, '升哥', '2016-10-04 15:59:39', 'admin');
INSERT INTO `login_record` VALUES (302, '升哥', '2016-10-04 17:12:16', 'admin');
INSERT INTO `login_record` VALUES (303, '升哥', '2016-10-04 17:37:45', 'admin');
INSERT INTO `login_record` VALUES (304, '升哥', '2016-10-04 20:15:47', 'admin');
INSERT INTO `login_record` VALUES (305, '升哥', '2016-10-04 20:56:05', 'admin');
INSERT INTO `login_record` VALUES (306, '升哥', '2016-10-05 09:41:50', 'admin');
INSERT INTO `login_record` VALUES (307, '升哥', '2016-10-05 10:15:13', 'admin');
INSERT INTO `login_record` VALUES (308, '升哥', '2016-10-05 10:30:13', 'admin');
INSERT INTO `login_record` VALUES (309, '升哥', '2016-10-05 11:06:24', 'admin');
INSERT INTO `login_record` VALUES (310, '升哥', '2016-10-05 15:56:42', 'admin');
INSERT INTO `login_record` VALUES (311, '升哥', '2016-10-05 16:27:00', 'admin');
INSERT INTO `login_record` VALUES (312, '升哥', '2016-10-05 17:07:23', 'admin');
INSERT INTO `login_record` VALUES (313, '升哥', '2016-10-05 17:39:33', 'admin');
INSERT INTO `login_record` VALUES (314, '升哥', '2016-10-05 18:10:01', 'admin');
INSERT INTO `login_record` VALUES (315, '升哥', '2016-10-05 19:14:05', 'admin');
INSERT INTO `login_record` VALUES (316, '升哥', '2016-10-05 19:52:16', 'admin');
INSERT INTO `login_record` VALUES (317, '升哥', '2016-10-05 20:19:42', 'admin');
INSERT INTO `login_record` VALUES (318, '升哥', '2016-10-06 08:13:51', 'admin');
INSERT INTO `login_record` VALUES (319, '升哥', '2016-10-06 08:34:10', 'admin');
INSERT INTO `login_record` VALUES (320, '升哥', '2016-10-06 22:52:58', 'admin');
INSERT INTO `login_record` VALUES (321, '升哥', '2016-10-07 10:55:12', 'admin');
INSERT INTO `login_record` VALUES (322, '升哥', '2016-10-07 10:57:05', 'admin');
INSERT INTO `login_record` VALUES (323, '升哥', '2016-10-07 11:01:09', 'admin');
INSERT INTO `login_record` VALUES (324, '升哥', '2016-10-07 12:12:38', 'admin');
INSERT INTO `login_record` VALUES (325, '升哥', '2016-10-07 12:28:51', 'admin');
INSERT INTO `login_record` VALUES (326, '升哥', '2016-10-07 15:09:58', 'admin');
INSERT INTO `login_record` VALUES (327, '升哥', '2016-10-07 16:08:14', 'admin');
INSERT INTO `login_record` VALUES (328, '升哥', '2016-10-08 23:29:29', 'admin');
INSERT INTO `login_record` VALUES (329, '升哥', '2016-10-09 16:17:35', 'admin');
INSERT INTO `login_record` VALUES (330, '升哥', '2016-10-09 17:32:08', 'admin');
INSERT INTO `login_record` VALUES (331, '升哥', '2016-10-09 19:27:42', 'admin');
INSERT INTO `login_record` VALUES (332, '升哥', '2016-10-09 20:00:02', 'admin');
INSERT INTO `login_record` VALUES (333, '升哥', '2016-10-09 20:05:52', 'admin');
INSERT INTO `login_record` VALUES (334, '升哥', '2016-10-09 20:12:40', 'admin');
INSERT INTO `login_record` VALUES (335, '升哥', '2016-10-11 13:59:31', 'admin');
INSERT INTO `login_record` VALUES (336, '升哥', '2016-10-11 14:02:51', 'admin');
INSERT INTO `login_record` VALUES (337, '升哥', '2016-10-11 14:14:11', 'admin');
INSERT INTO `login_record` VALUES (338, '升哥', '2016-10-11 18:23:14', 'admin');
INSERT INTO `login_record` VALUES (339, '升哥', '2016-10-11 20:02:10', 'admin');
INSERT INTO `login_record` VALUES (340, '升哥', '2016-10-13 20:21:25', 'admin');
INSERT INTO `login_record` VALUES (341, '升哥', '2016-10-14 11:00:19', 'admin');
INSERT INTO `login_record` VALUES (342, '升哥', '2016-10-14 11:05:35', 'admin');
INSERT INTO `login_record` VALUES (343, '升哥', '2016-10-14 12:44:59', 'admin');
INSERT INTO `login_record` VALUES (344, '升哥', '2016-10-14 13:39:44', 'admin');
INSERT INTO `login_record` VALUES (345, '升哥', '2016-10-14 13:46:27', 'admin');
INSERT INTO `login_record` VALUES (346, '萌萌', '2016-10-14 13:47:31', 'aaaaaa');
INSERT INTO `login_record` VALUES (347, '升哥', '2016-10-14 14:36:29', 'admin');
INSERT INTO `login_record` VALUES (348, '升哥', '2016-10-14 14:46:32', 'admin');
INSERT INTO `login_record` VALUES (349, '蒯老师', '2016-10-14 14:46:59', 'adminhdhdhdh');
INSERT INTO `login_record` VALUES (350, '升哥', '2016-10-14 14:53:04', 'admin');
INSERT INTO `login_record` VALUES (351, '升哥', '2016-10-14 23:18:05', 'admin');
INSERT INTO `login_record` VALUES (352, '??', '2020-04-13 16:54:20', 'admin');
INSERT INTO `login_record` VALUES (353, 'ultra', '2020-04-13 16:55:43', 'admin');
INSERT INTO `login_record` VALUES (354, 'ultra', '2020-04-13 17:52:55', 'admin');
INSERT INTO `login_record` VALUES (355, 'ultra', '2020-04-13 17:54:55', 'admin');
INSERT INTO `login_record` VALUES (356, 'ultra', '2020-04-13 18:22:08', 'admin');
INSERT INTO `login_record` VALUES (357, 'ultra', '2020-04-13 18:36:06', 'admin');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `member_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `member_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `member_number` int(11) NULL DEFAULT 0,
  `member_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `member_benefit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0.99',
  `fk_memberType_id` int(11) NULL DEFAULT 1,
  `member_status` int(11) NULL DEFAULT 1 COMMENT '1可用，0禁用',
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (1, '萌萌', 'ching777', '123456', 27, '钻石', '0.93', 1, 1);
INSERT INTO `member` VALUES (2, '帅帅', 'abcdef', '123456', 0, '青铜', '0.99', 1, 1);
INSERT INTO `member` VALUES (3, '张三', 'zhangsan', '123456', 10, '白银', '0.97', 1, 1);
INSERT INTO `member` VALUES (4, '李四', 'lisi', '123456', 0, '青铜', '0.99', 1, 1);
INSERT INTO `member` VALUES (5, '哈哈', 'haha', '123456', 0, '青铜', '0.99', 1, 1);
INSERT INTO `member` VALUES (6, '王五', 'wangwu', '123456', 0, '青铜', '0.99', 1, 1);
INSERT INTO `member` VALUES (7, '王五', 'wangwu', '123456', 0, '青铜', '0.99', 1, 1);
INSERT INTO `member` VALUES (8, '杨欣欣', 'yangxinxin', '123456', 0, '青铜', '0.99', 1, 1);
INSERT INTO `member` VALUES (9, '帅', 'shuai', '123456', 0, '青铜', '0.99', 1, 1);
INSERT INTO `member` VALUES (10, '张三', 'zhangsan123', '123456', 1, '青铜', '0.99', 1, 1);

-- ----------------------------
-- Table structure for membertype
-- ----------------------------
DROP TABLE IF EXISTS `membertype`;
CREATE TABLE `membertype`  (
  `memberType_id` int(11) NOT NULL AUTO_INCREMENT,
  `memberType_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `memberType_status` int(11) NULL DEFAULT 1 COMMENT '1存在，0不存在',
  `memberType_number` int(11) NULL DEFAULT NULL,
  `memberType_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `memberType_benefit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`memberType_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of membertype
-- ----------------------------
INSERT INTO `membertype` VALUES (1, '青铜', 1, 0, '青铜会员，注册即是青铜', '0.99');
INSERT INTO `membertype` VALUES (2, '白银', 1, 5, '累计消费5次即可升为白银', '0.97');
INSERT INTO `membertype` VALUES (3, '黄金', 1, 10, '累计消费10次即可升级为黄金', '0.95');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `menu_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '内部管理', NULL, NULL);
INSERT INTO `menu` VALUES (2, '前台管理', NULL, NULL);
INSERT INTO `menu` VALUES (3, '客户关系', NULL, NULL);
INSERT INTO `menu` VALUES (4, '账单管理', NULL, NULL);
INSERT INTO `menu` VALUES (5, '收支管理', NULL, NULL);
INSERT INTO `menu` VALUES (6, '安全管理', NULL, NULL);
INSERT INTO `menu` VALUES (7, '员工管理', 'UserListServlet.shxt', 1);
INSERT INTO `menu` VALUES (8, '薪资管理', 'SalaryListServlet.shxt', 1);
INSERT INTO `menu` VALUES (9, '部门管理', 'SectionListServlet.shxt', 1);
INSERT INTO `menu` VALUES (10, '请假管理', 'LeaveListServlet.shxt', 1);
INSERT INTO `menu` VALUES (11, '留言管理', 'MessageListServlet.shxt', 2);
INSERT INTO `menu` VALUES (12, '招聘管理', 'RecruitListServlet.shxt', 2);
INSERT INTO `menu` VALUES (13, '广告管理', 'AdvertisementListServlet.shxt', 2);
INSERT INTO `menu` VALUES (14, '会员类型管理', 'MemberTypeListServlet.shxt', 3);
INSERT INTO `menu` VALUES (15, '会员管理', 'MemberListServlet.shxt', 3);
INSERT INTO `menu` VALUES (16, '合作商类型管理', 'PartnerTypeListServlet.shxt', 3);
INSERT INTO `menu` VALUES (17, '合作商管理', 'PartnerListServlet.shxt', 3);
INSERT INTO `menu` VALUES (18, '周边游热门景点管理', 'AroundTourismServlet.shxt', 30);
INSERT INTO `menu` VALUES (19, '预订管理', 'OrderListServlet.shxt', 4);
INSERT INTO `menu` VALUES (20, '账单管理', 'BillListServlet.shxt', 4);
INSERT INTO `menu` VALUES (21, '利润详情', 'ProfitListServlet.shxt', 5);
INSERT INTO `menu` VALUES (22, '登陆日志管理', 'LoginListServlet.shxt', 6);
INSERT INTO `menu` VALUES (23, '利润统计', 'SumProfitListServlet.shxt', 5);
INSERT INTO `menu` VALUES (24, '角色管理', 'RoleListServlet.shxt', 1);
INSERT INTO `menu` VALUES (25, '周边游景点门票管理', 'AroundTicketServlet.shxt', 30);
INSERT INTO `menu` VALUES (26, '国内游热门景点管理', 'InboundTourismServlet.shxt', 30);
INSERT INTO `menu` VALUES (27, '国内游景点门票管理', 'InboundTicketServlet.shxt', 30);
INSERT INTO `menu` VALUES (28, '出境游热门景点管理', 'OutboundTourismServlet.shxt', 30);
INSERT INTO `menu` VALUES (29, '出境游景点门票管理', 'OutboundTicketServlet.shxt', 30);
INSERT INTO `menu` VALUES (30, '景点推荐', NULL, NULL);
INSERT INTO `menu` VALUES (31, '保险签证金融', NULL, NULL);
INSERT INTO `menu` VALUES (32, '保险管理', 'InsuranceServlet.shxt', 31);
INSERT INTO `menu` VALUES (33, '签证管理', 'VisaProcessing.shxt', 31);
INSERT INTO `menu` VALUES (34, '金融管理', 'FinanceServlet.shxt', 31);
INSERT INTO `menu` VALUES (35, '美食管理', NULL, NULL);
INSERT INTO `menu` VALUES (36, '小吃管理', 'SnackServlet.shxt', 35);
INSERT INTO `menu` VALUES (37, '快餐管理', 'QuickServlet.shxt', 35);
INSERT INTO `menu` VALUES (38, '自助管理', 'BuffetServlet.shxt', 35);
INSERT INTO `menu` VALUES (39, '主题餐厅', 'ThemedServlet.shxt', 35);
INSERT INTO `menu` VALUES (40, '西式餐厅', 'WesternServlet.shxt', 35);
INSERT INTO `menu` VALUES (41, '住宿管理', NULL, NULL);
INSERT INTO `menu` VALUES (42, '假日酒店', 'HolidayServlet.shxt', 41);
INSERT INTO `menu` VALUES (43, '公寓管理', 'ApartmentServlet.shxt', 41);
INSERT INTO `menu` VALUES (44, '别墅管理', 'VillaServlet.shxt', 41);
INSERT INTO `menu` VALUES (45, '农家乐', 'AgricolaServlet.shxt', 41);
INSERT INTO `menu` VALUES (46, '快捷酒店', 'HotelServlet.shxt', 41);
INSERT INTO `menu` VALUES (47, '交通管理', NULL, NULL);
INSERT INTO `menu` VALUES (48, '机票管理', 'AirlineServlet.shxt', 47);
INSERT INTO `menu` VALUES (49, '火车票管理', 'TrainServlet.shxt', 47);
INSERT INTO `menu` VALUES (50, '轮船票管理', 'ShipServlet.shxt', 47);
INSERT INTO `menu` VALUES (51, '汽车票管理', 'BusServlet.shxt', 47);
INSERT INTO `menu` VALUES (52, '动车票管理', 'FasterServlet.shxt', 47);

-- ----------------------------
-- Table structure for newmessage
-- ----------------------------
DROP TABLE IF EXISTS `newmessage`;
CREATE TABLE `newmessage`  (
  `newMessage_id` int(11) NOT NULL AUTO_INCREMENT,
  `newMessage_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `newMessage_createDate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `newMessage_status` int(1) NULL DEFAULT 0 COMMENT '0为未处理，1为已处理',
  `newMessageMember_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `newMessageMember_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`newMessage_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of newmessage
-- ----------------------------
INSERT INTO `newmessage` VALUES (1, 'aa', '2016-09-21 23:36:39', 1, '萌萌', 'ching777');
INSERT INTO `newmessage` VALUES (2, '希望晨曦旅行社越来越好', '2016-09-22 11:00:05', 1, '萌萌', 'ching777');
INSERT INTO `newmessage` VALUES (3, '桃李满天下，教育兴中华。', '2016-10-13 20:33:48', 0, '萌萌', 'ching777');

-- ----------------------------
-- Table structure for outboundticket
-- ----------------------------
DROP TABLE IF EXISTS `outboundticket`;
CREATE TABLE `outboundticket`  (
  `outboundTicket_id` int(11) NOT NULL AUTO_INCREMENT,
  `outboundTicket_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `outboundTicket_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `outboundTicket_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `outboundTicket_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`outboundTicket_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of outboundticket
-- ----------------------------
INSERT INTO `outboundticket` VALUES (1, '门票1', '/shxt/resource/upload/photo/e9a13da5-e0bb-43cd-aae4-6bd8999691c7.jpg', 'Almudena Cathedral', '100');
INSERT INTO `outboundticket` VALUES (2, '门票2', '/shxt/resource/upload/photo/7efbdb49-67db-4219-b87d-2d714d58dfa5.jpg', '凡尔赛宫', '68');
INSERT INTO `outboundticket` VALUES (3, '门票3', '/shxt/resource/upload/photo/f17136e4-a0df-4c01-b4ba-f9c9725378f3.jpg', '卢浮宫', '99');
INSERT INTO `outboundticket` VALUES (4, '门票4', '/shxt/resource/upload/photo/cce6049d-1aca-4a05-b739-4daee87996eb.jpg', '力度夜总会', '88');
INSERT INTO `outboundticket` VALUES (5, '门票5', '/shxt/resource/upload/photo/636cc920-c1b4-4faf-acb8-74a114f8b5ac.jpg', '许愿池', '98');
INSERT INTO `outboundticket` VALUES (6, '门票6', '/shxt/resource/upload/photo/51e6dbfa-b228-49f1-8fee-8e637c89f2cb.jpg', '古罗马竞技场', '78');
INSERT INTO `outboundticket` VALUES (7, '门票7', '/shxt/resource/upload/photo/fdc44a3b-0617-45e9-8a2c-28d8f4f0d332.jpg', '特莱维喷泉', '119');
INSERT INTO `outboundticket` VALUES (8, '门票8', '/shxt/resource/upload/photo/2408b667-7d70-4d75-ac81-cf5789f11838.jpg', '索菲亚王后艺术中心', '188');
INSERT INTO `outboundticket` VALUES (9, '门票9', '/shxt/resource/upload/photo/9882c22a-17d5-4c9b-9e04-0bda75c23963.jpg', '塞纳河观光游船', '50');
INSERT INTO `outboundticket` VALUES (10, '门票10', '/shxt/resource/upload/photo/ce52b22f-702d-4200-b555-8d7f74ecc642.jpg', '埃菲尔铁塔', '108');
INSERT INTO `outboundticket` VALUES (11, '门票11', '/shxt/resource/upload/photo/edb14df7-7b5d-450b-87cb-2428096e2c37.jpg', '西班牙广场', '75');
INSERT INTO `outboundticket` VALUES (12, '门票12', '/shxt/resource/upload/photo/5afce476-fdbd-459a-8a06-f88cf8691753.jpg', '马德里城市通票', '78');
INSERT INTO `outboundticket` VALUES (13, '图片1', '/shxt/resource/upload/photo/21c97998-9bd3-4f93-b7ad-da42166e841c.jpg', NULL, NULL);
INSERT INTO `outboundticket` VALUES (14, '图片2', '/shxt/resource/upload/photo/5e76cea2-bc54-4a70-8b9e-0618c8a107d5.jpg', NULL, NULL);
INSERT INTO `outboundticket` VALUES (15, '图片3', '/shxt/resource/upload/photo/c6623ae5-da36-4a2a-94ef-3db049c5cfb0.jpg', NULL, NULL);

-- ----------------------------
-- Table structure for outboundtourism
-- ----------------------------
DROP TABLE IF EXISTS `outboundtourism`;
CREATE TABLE `outboundtourism`  (
  `outboundTourism_id` int(11) NOT NULL AUTO_INCREMENT,
  `outboundTourism_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `outboundTourism_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `outboundTourism_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`outboundTourism_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of outboundtourism
-- ----------------------------
INSERT INTO `outboundtourism` VALUES (1, '/shxt/resource/upload/photo/a3cf3e37-fb1e-4ce0-a51f-843ac703f79a.jpg', '在活力的巴黎中心来一场流动的盛宴--塞纳河观光游船', '位置1');
INSERT INTO `outboundtourism` VALUES (2, '/shxt/resource/upload/photo/4ae2a8c3-9482-4d57-83e1-6abc993de2dc.jpg', '法国古典主义艺术最杰出的典范--凡尔赛宫', '位置2');
INSERT INTO `outboundtourism` VALUES (3, '/shxt/resource/upload/photo/b856ccbd-5957-4535-96ff-484514c9e2a6.jpg', '有别其它迪斯尼乐园，有欧洲古典宫廷的感觉--巴黎迪士尼乐园', '位置3');
INSERT INTO `outboundtourism` VALUES (4, '/shxt/resource/upload/photo/99a986a8-7cd4-4f06-a531-9e6216fbe5d9.jpg', '世界上最古老、最大、最著名的博物馆之一--卢浮宫', '位置4');
INSERT INTO `outboundtourism` VALUES (5, '/shxt/resource/upload/photo/c654e93a-b6a6-4363-bc85-948b4be446f9.jpg', '巴黎的标志，首都的瞭望台--埃菲尔铁塔', '位置5');
INSERT INTO `outboundtourism` VALUES (6, '/shxt/resource/upload/photo/26c938cf-6a14-43f8-ac18-df2d0bf56d76.jpg', '一出出精美绝伦的表演带给你震撼的视觉享受--丽都夜总会', '位置6');
INSERT INTO `outboundtourism` VALUES (7, '/shxt/resource/upload/photo/47dc45b5-2779-4313-bafb-de030d5ef906.jpg', '赴一场中世纪的聚会，购物真正成了一种享受--老佛爷百货', '位置7');
INSERT INTO `outboundtourism` VALUES (8, '/shxt/resource/upload/photo/f0ea6154-b276-4e2c-abfa-c23a626f1e60.jpg', '和谐包容了宗教、艺术、香艳和爱情的地方--蒙马特高地', '位置8');
INSERT INTO `outboundtourism` VALUES (9, '/shxt/resource/upload/photo/8e4eb50d-2736-4fcd-a1c2-fec6f92ec668.jpg', '参观罗马地标性建筑，拍摄斗兽场全景--古罗马竞技场', '位置9');
INSERT INTO `outboundtourism` VALUES (10, '/shxt/resource/upload/photo/393019d5-daf9-412b-b2c8-60de28c009c9.jpg', '威尼斯广场位于罗马市中心的圆形广场--威尼斯广场', '位置10');
INSERT INTO `outboundtourism` VALUES (11, '/shxt/resource/upload/photo/f36c8759-556f-4681-b2d2-a0cd31d00315.jpg', '特莱维喷泉是罗马最大最著名的喷泉。据说背对着喷泉--特莱维喷泉', '位置11');
INSERT INTO `outboundtourism` VALUES (12, '/shxt/resource/upload/photo/f3fe4f0c-6f52-4d40-8f64-5142d63dc3d1.jpg', '万神殿是古罗马精湛建筑技术的典范--   万神殿', '位置12');
INSERT INTO `outboundtourism` VALUES (13, '/shxt/resource/upload/photo/e9d861be-e858-4ca3-a52a-4203593fbaa9.jpg', '电影「罗马假期」之赐--许愿池', '位置13');
INSERT INTO `outboundtourism` VALUES (14, '/shxt/resource/upload/photo/c919aba6-2bc6-49ec-8c0e-fd477c21a4ea.jpg', '   西班牙广场', '位置14');
INSERT INTO `outboundtourism` VALUES (15, '/shxt/resource/upload/photo/51eaf042-97de-47fd-a5e8-cd7498d04ace.jpg', '世界上保存最完整而且最精美的宫殿之一--马德里皇宫', '位置15');
INSERT INTO `outboundtourism` VALUES (16, '/shxt/resource/upload/photo/bdf1565b-a8b6-4468-b68f-183aca8bb7de.jpg', '球场内必游的景点是奖杯室和更衣室隧道--伯纳乌球场', '位置16');
INSERT INTO `outboundtourism` VALUES (17, '/shxt/resource/upload/photo/fd978535-01a7-4e7b-a38b-01f6b4e36b21.jpg', '马德里的博物馆不少，其中以普拉多博物馆最负盛名--普拉多博物馆', '位置17');
INSERT INTO `outboundtourism` VALUES (18, '/shxt/resource/upload/photo/431e9120-2bf4-4849-b593-c06c73aa4225.jpg', '斗牛士通向成功的必由之路和荣誉象征--拉斯班塔斯斗牛场', '位置18');
INSERT INTO `outboundtourism` VALUES (19, '/shxt/resource/upload/photo/781eaa99-989d-4800-9eb3-745218f8ccc8.jpg', '快速通道，避免排队，快速进入主要景点--马德里城市通票', '位置19');
INSERT INTO `outboundtourism` VALUES (20, '/shxt/resource/upload/photo/c9321bd4-362d-415a-8a86-b7aa1ef79199.jpg', '想看毕加索，索非亚王后艺术中心不可错过--索菲亚王后艺术中心', '位置20');
INSERT INTO `outboundtourism` VALUES (21, '/shxt/resource/upload/photo/d15a9606-1151-4d81-b132-d0581b53c2fd.jpg', '一座新古典主义建筑的教堂--Almudena Cathedral', '位置21');

-- ----------------------------
-- Table structure for partner
-- ----------------------------
DROP TABLE IF EXISTS `partner`;
CREATE TABLE `partner`  (
  `partner_id` int(11) NOT NULL AUTO_INCREMENT,
  `partner_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `partner_position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `partner_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `partner_hobby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `partner_status` int(11) NULL DEFAULT 1 COMMENT '1为可用，0为禁用',
  `partner_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `fk_partnerType_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`partner_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of partner
-- ----------------------------
INSERT INTO `partner` VALUES (1, '??', '??', '????', '??', 1, '?????????', 1);
INSERT INTO `partner` VALUES (2, '张总', '总经理', '七天酒店', '玉石', 1, '七天集团华东负责人', 2);

-- ----------------------------
-- Table structure for partnertype
-- ----------------------------
DROP TABLE IF EXISTS `partnertype`;
CREATE TABLE `partnertype`  (
  `partnerType_id` int(11) NOT NULL AUTO_INCREMENT,
  `partnerType_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `partnerType_status` int(11) NULL DEFAULT 1 COMMENT '1可用，0禁用',
  `partnerType_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`partnerType_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of partnertype
-- ----------------------------
INSERT INTO `partnertype` VALUES (1, '如家酒店', 1, '合作酒店');
INSERT INTO `partnertype` VALUES (2, '七天酒店', 1, '合作酒店');

-- ----------------------------
-- Table structure for quick
-- ----------------------------
DROP TABLE IF EXISTS `quick`;
CREATE TABLE `quick`  (
  `quick_id` int(11) NOT NULL AUTO_INCREMENT,
  `quick_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `quick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `quick_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `quick_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `quick_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `quick_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  PRIMARY KEY (`quick_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of quick
-- ----------------------------
INSERT INTO `quick` VALUES (1, '/shxt/resource/upload/photo/5cc54bbb-8d03-4e0e-a4be-21dc0e6e48cb.jpg', '鸡翅便当', '19', '济南', '美味好吃', 1);
INSERT INTO `quick` VALUES (2, '/shxt/resource/upload/photo/2a57d8f1-c7d8-4a40-ab05-fe6bad6e2f01.jpg', '鸡腿套餐', '25', '济南', '美味好吃', 1);
INSERT INTO `quick` VALUES (3, '/shxt/resource/upload/photo/359f6468-7fd5-4f7d-be15-89e6b806a2ff.jpg', '海鲜套餐', '39', '济南', '美味好吃', 1);
INSERT INTO `quick` VALUES (4, '/shxt/resource/upload/photo/8ed8c039-5e17-45e3-aaad-c076d05e2df6.jpg', '洋葱炒肉盖饭', '25', '济南', '美味好吃', 1);
INSERT INTO `quick` VALUES (5, '/shxt/resource/upload/photo/56d6ddbe-1d53-4d05-8b21-e4ebb4f3c1a2.jpg', '美味便当', '29', '济南', '美味好吃', 1);
INSERT INTO `quick` VALUES (6, '/shxt/resource/upload/photo/20cbfbbb-6c0c-45bf-92c9-727502b0b485.jpg', '排骨套餐', '26', '济南', '美味好吃', 1);
INSERT INTO `quick` VALUES (7, '/shxt/resource/upload/photo/85db32a7-97be-4409-a934-530f12486d06.jpg', '牛肉套餐', '39', '济南', '美味好吃', 1);
INSERT INTO `quick` VALUES (8, '/shxt/resource/upload/photo/d505377b-6db5-4626-9bec-2cff1578f3a0.jpg', '凤爪套餐', '42', '济南', '美味好吃', 1);
INSERT INTO `quick` VALUES (9, '/shxt/resource/upload/photo/69aa1692-b394-407b-aaff-e89298e823f2.jpg', '鸭腿饭', '24', '济南', '美味好吃', 1);

-- ----------------------------
-- Table structure for recruit
-- ----------------------------
DROP TABLE IF EXISTS `recruit`;
CREATE TABLE `recruit`  (
  `recruit_id` int(11) NOT NULL AUTO_INCREMENT,
  `recruit_company` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `recruit_position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `recruit_salary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `recruit_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `recruit_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `recruit_benefit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `recruit_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `recruit_status` int(1) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  `recruit_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`recruit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of recruit
-- ----------------------------
INSERT INTO `recruit` VALUES (1, '百度', 'java工程师', '13000', '北京', '包北京户口，六险二金', '80000', '2016/9/01--2016/10/10', 1, 'baidu@123.com');
INSERT INTO `recruit` VALUES (2, '谷歌', '测试工程师', '25000', '北京', '白盒测试，计算机相关专业有限', '99999', '2016/9/25--2016/10/15', 1, 'gson@163.com');

-- ----------------------------
-- Table structure for recruitbenefit
-- ----------------------------
DROP TABLE IF EXISTS `recruitbenefit`;
CREATE TABLE `recruitbenefit`  (
  `recruitBenefit_id` int(11) NOT NULL AUTO_INCREMENT,
  `recruitBenefit_benefit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`recruitBenefit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of recruitbenefit
-- ----------------------------
INSERT INTO `recruitbenefit` VALUES (1, '99999');
INSERT INTO `recruitbenefit` VALUES (2, '80000');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_status` int(1) NULL DEFAULT 1 COMMENT '1为可用，0为禁用',
  `role_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', 1, '程序最终管理者');
INSERT INTO `role` VALUES (2, '管理员', 1, '程序管理者');
INSERT INTO `role` VALUES (3, '总经理', 1, '负责公司的大小事务');
INSERT INTO `role` VALUES (4, '技术总监', 1, '负责统筹整个项目组研发进度');
INSERT INTO `role` VALUES (5, '项目经理', 1, '负责产品的开发');
INSERT INTO `role` VALUES (6, '服务员', 1, '111');

-- ----------------------------
-- Table structure for role_link_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_link_menu`;
CREATE TABLE `role_link_menu`  (
  `role_link_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_role_id` int(11) NULL DEFAULT NULL,
  `fk_menu_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`role_link_menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 144 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_link_menu
-- ----------------------------
INSERT INTO `role_link_menu` VALUES (1, 1, 7);
INSERT INTO `role_link_menu` VALUES (2, 1, 8);
INSERT INTO `role_link_menu` VALUES (3, 1, 9);
INSERT INTO `role_link_menu` VALUES (4, 1, 10);
INSERT INTO `role_link_menu` VALUES (5, 1, 11);
INSERT INTO `role_link_menu` VALUES (6, 1, 12);
INSERT INTO `role_link_menu` VALUES (7, 1, 13);
INSERT INTO `role_link_menu` VALUES (8, 1, 14);
INSERT INTO `role_link_menu` VALUES (9, 1, 15);
INSERT INTO `role_link_menu` VALUES (10, 1, 16);
INSERT INTO `role_link_menu` VALUES (11, 1, 17);
INSERT INTO `role_link_menu` VALUES (12, 1, 18);
INSERT INTO `role_link_menu` VALUES (14, 1, 20);
INSERT INTO `role_link_menu` VALUES (15, 1, 21);
INSERT INTO `role_link_menu` VALUES (16, 1, 22);
INSERT INTO `role_link_menu` VALUES (18, 1, 24);
INSERT INTO `role_link_menu` VALUES (84, 3, 7);
INSERT INTO `role_link_menu` VALUES (85, 3, 9);
INSERT INTO `role_link_menu` VALUES (86, 3, 10);
INSERT INTO `role_link_menu` VALUES (87, 3, 11);
INSERT INTO `role_link_menu` VALUES (88, 3, 12);
INSERT INTO `role_link_menu` VALUES (89, 3, 19);
INSERT INTO `role_link_menu` VALUES (94, 1, 25);
INSERT INTO `role_link_menu` VALUES (95, 5, 8);
INSERT INTO `role_link_menu` VALUES (96, 5, 9);
INSERT INTO `role_link_menu` VALUES (97, 5, 10);
INSERT INTO `role_link_menu` VALUES (98, 1, 26);
INSERT INTO `role_link_menu` VALUES (99, 1, 27);
INSERT INTO `role_link_menu` VALUES (100, 1, 28);
INSERT INTO `role_link_menu` VALUES (101, 1, 29);
INSERT INTO `role_link_menu` VALUES (102, 1, 32);
INSERT INTO `role_link_menu` VALUES (103, 1, 33);
INSERT INTO `role_link_menu` VALUES (104, 1, 34);
INSERT INTO `role_link_menu` VALUES (105, 1, 36);
INSERT INTO `role_link_menu` VALUES (106, 1, 37);
INSERT INTO `role_link_menu` VALUES (107, 1, 38);
INSERT INTO `role_link_menu` VALUES (108, 1, 39);
INSERT INTO `role_link_menu` VALUES (109, 1, 40);
INSERT INTO `role_link_menu` VALUES (110, 1, 42);
INSERT INTO `role_link_menu` VALUES (111, 1, 43);
INSERT INTO `role_link_menu` VALUES (112, 1, 44);
INSERT INTO `role_link_menu` VALUES (113, 1, 45);
INSERT INTO `role_link_menu` VALUES (114, 1, 46);
INSERT INTO `role_link_menu` VALUES (115, 1, 48);
INSERT INTO `role_link_menu` VALUES (116, 1, 49);
INSERT INTO `role_link_menu` VALUES (117, 1, 50);
INSERT INTO `role_link_menu` VALUES (118, 1, 51);
INSERT INTO `role_link_menu` VALUES (119, 1, 52);
INSERT INTO `role_link_menu` VALUES (120, 2, 46);
INSERT INTO `role_link_menu` VALUES (121, 2, 48);
INSERT INTO `role_link_menu` VALUES (122, 2, 49);
INSERT INTO `role_link_menu` VALUES (134, 4, 7);
INSERT INTO `role_link_menu` VALUES (135, 4, 8);
INSERT INTO `role_link_menu` VALUES (136, 4, 9);
INSERT INTO `role_link_menu` VALUES (137, 4, 12);
INSERT INTO `role_link_menu` VALUES (138, 4, 14);
INSERT INTO `role_link_menu` VALUES (139, 4, 15);
INSERT INTO `role_link_menu` VALUES (140, 4, 18);
INSERT INTO `role_link_menu` VALUES (141, 4, 21);
INSERT INTO `role_link_menu` VALUES (142, 4, 23);
INSERT INTO `role_link_menu` VALUES (143, 6, 42);

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `salary_id` int(11) NOT NULL AUTO_INCREMENT,
  `salary_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `position_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `fk_role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`salary_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (1, '49999', '超级管理员', 1);
INSERT INTO `salary` VALUES (2, '8000', '管理员', 2);
INSERT INTO `salary` VALUES (3, '7000', '总经理', 3);
INSERT INTO `salary` VALUES (4, '6500', '技术总监', 4);

-- ----------------------------
-- Table structure for ship
-- ----------------------------
DROP TABLE IF EXISTS `ship`;
CREATE TABLE `ship`  (
  `ship_id` int(11) NOT NULL AUTO_INCREMENT,
  `ship_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ship_from` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ship_to` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ship_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ship_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ship_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ship_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  PRIMARY KEY (`ship_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ship
-- ----------------------------
INSERT INTO `ship` VALUES (1, '/shxt/resource/upload/photo/4fbf0c48-9ae8-431a-b015-f7520db9adf2.png', '青岛', '大连', '108', '2016/10/05/09:00:00', '青岛海港', 1);
INSERT INTO `ship` VALUES (2, '/shxt/resource/upload/photo/a42dfece-2006-4948-912e-4ef5ee3fbba3.png', '青岛', '珠海', '400', '2016/10/05/09:00:00', '青岛海港', 1);
INSERT INTO `ship` VALUES (3, '/shxt/resource/upload/photo/b129243e-3351-4efb-b2f8-9d62b5b16cbf.jpg', '青岛', '上海', '198', '2016/10/05/09:00:00', '青岛海港', 1);
INSERT INTO `ship` VALUES (4, '/shxt/resource/upload/photo/a349ca0b-89ec-45e8-8bb2-df4f61884764.jpg', '青岛', '福州', '259', '2016/10/05/09:00:00', '青岛海港', 1);
INSERT INTO `ship` VALUES (5, '/shxt/resource/upload/photo/4e218f29-00dc-4dc2-a7e7-4eaef99213af.jpg', '青岛', '威海', '109', '2016/10/05/09:00:00', '青岛海港', 1);

-- ----------------------------
-- Table structure for snack
-- ----------------------------
DROP TABLE IF EXISTS `snack`;
CREATE TABLE `snack`  (
  `snack_id` int(11) NOT NULL AUTO_INCREMENT,
  `snack_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `snack_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `snack_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `snack_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `snack_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `snack_status` int(11) NULL DEFAULT 1 COMMENT '1存在0不存在',
  PRIMARY KEY (`snack_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of snack
-- ----------------------------
INSERT INTO `snack` VALUES (1, '/shxt/resource/upload/photo/e3c9253a-3e67-4286-9777-70850a3593ce.jpg', '竹筒饭', '55', '西双版纳', '粒粒米香混着嫩竹的青涩芬芳，一口下去唇齿留香', 1);
INSERT INTO `snack` VALUES (2, '/shxt/resource/upload/photo/4b7235c8-0248-461b-88ff-4dd96fd0fb5d.png', '炸酸奶', '28', '呼和浩特', '滴滴奶香，外酥里嫩', 1);
INSERT INTO `snack` VALUES (3, '/shxt/resource/upload/photo/baa1b2ad-9e10-4f1a-9e78-86af9cba51ef.png', '麻薯球', '15', '芙蓉街', '外酥里嫩，香脆可口', 1);
INSERT INTO `snack` VALUES (4, '/shxt/resource/upload/photo/b7bcb471-3fec-47fa-b0e8-7a5c120d6d28.png', '花开格枝', '19', '芙蓉街', '感受玫瑰的芬芳，享受美食的恩赐', 1);
INSERT INTO `snack` VALUES (5, '/shxt/resource/upload/photo/4d85ab08-98af-4169-b37c-b3e20eca4a83.jpg', '功夫煮', '26', '济南大学', '美味可口，麻辣鲜香', 1);
INSERT INTO `snack` VALUES (6, '/shxt/resource/upload/photo/9f542f42-ec62-4f3e-b8b3-403ea3005bb9.jpg', '辣炒年糕', '5', '芙蓉街', 'Q弹劲爽', 1);
INSERT INTO `snack` VALUES (7, '/shxt/resource/upload/photo/7b73ac9d-21ca-44ff-91e9-aa5c9239e5ae.jpg', '辣白菜', '30', '长春', '酸爽可口', 1);
INSERT INTO `snack` VALUES (8, '/shxt/resource/upload/photo/1b8bafc8-b073-4707-8d00-5aba57ada3fb.jpg', '麻辣鸡翅', '29', '大巴扎', '鲜嫩多汁', 1);
INSERT INTO `snack` VALUES (9, '/shxt/resource/upload/photo/f2971a65-1393-4071-96b5-b9a0a39b9caf.jpg', '富贵团圆球', '19', '济南', '外酥里嫩，香脆可口', 1);

-- ----------------------------
-- Table structure for themed
-- ----------------------------
DROP TABLE IF EXISTS `themed`;
CREATE TABLE `themed`  (
  `themed_id` int(11) NOT NULL AUTO_INCREMENT,
  `themed_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `themed_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `themed_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `themed_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `themed_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `themed_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  PRIMARY KEY (`themed_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of themed
-- ----------------------------
INSERT INTO `themed` VALUES (1, '/shxt/resource/upload/photo/330062a0-025b-4eda-bb88-eaf1881c5130.jpg', '美国队长主题餐厅', '100', '济南', '电影主题餐厅', 1);
INSERT INTO `themed` VALUES (2, '/shxt/resource/upload/photo/db281ac8-880d-47f3-8f18-2f829c4e4b68.jpg', '茶主题餐厅', '50', '济南', '茶主题餐厅', 1);
INSERT INTO `themed` VALUES (3, '/shxt/resource/upload/photo/5761e2f9-a76a-42ce-b032-dafbf574ee63.jpg', '监狱主题餐厅', '150', '济南', '监狱主题餐厅', 1);
INSERT INTO `themed` VALUES (4, '/shxt/resource/upload/photo/69110d71-84a9-47ca-ad6b-d1e88d4f4ae9.jpg', '公主主题餐厅', '100', '济南', '公主主题餐厅', 1);
INSERT INTO `themed` VALUES (5, '/shxt/resource/upload/photo/5e40a57a-c0f8-41fd-8f78-6026df25fcd6.jpg', '海主题餐厅', '80', '济南', '海主题餐厅', 1);
INSERT INTO `themed` VALUES (6, '/shxt/resource/upload/photo/d83740d7-f043-40fc-ab88-4728fa057c3a.jpg', '机械主题餐厅', '60', '济南', '机械主题餐厅', 1);
INSERT INTO `themed` VALUES (7, '/shxt/resource/upload/photo/5b24954f-2e62-4175-b305-c981a7967e02.jpg', '欧式主题餐厅', '90', '济南', '欧式主题餐厅', 1);
INSERT INTO `themed` VALUES (8, '/shxt/resource/upload/photo/3bbb91f5-fb85-4225-a48d-3148da9db920.jpg', '青春主题餐厅', '70', '济南', '青春主题餐厅', 1);
INSERT INTO `themed` VALUES (9, '/shxt/resource/upload/photo/74f3f78c-6e72-409d-aa02-08e07f2909bb.jpg', '复古主题餐厅', '80', '济南', '复古主题餐厅', 1);

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train`  (
  `train_id` int(11) NOT NULL AUTO_INCREMENT,
  `train_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `train_from` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `train_to` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `train_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `train_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `train_point` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `train_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  PRIMARY KEY (`train_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES (1, '/shxt/resource/upload/photo/1a8d7478-f2ab-49f8-9941-128738d8cb42.jpg', '济南', '烟台', '99', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `train` VALUES (2, '/shxt/resource/upload/photo/0658bf5d-cb48-44cf-bc17-f564303939c1.jpg', '济南', '曲阜', '60', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `train` VALUES (3, '/shxt/resource/upload/photo/50e565a2-ec0d-42ec-bcee-e7d62b04dc3f.jpg', '济南', '苏州', '209', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `train` VALUES (4, '/shxt/resource/upload/photo/b80c6e30-97d8-42b9-b041-178fdd8858b9.jpg', '济南', '潍坊', '75', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `train` VALUES (5, '/shxt/resource/upload/photo/91a348a4-94ec-41d3-bcd4-2e7771077af5.jpg', '济南', '上海', '195', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `train` VALUES (6, '/shxt/resource/upload/photo/eb45fed4-a672-47ad-8d6b-b962dec53403.jpg', '济南', '威海', '115', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `train` VALUES (7, '/shxt/resource/upload/photo/8f5caacf-ed78-42b9-90fb-a722d634ebd6.jpg', '济南', '三亚', '400', '2016/10/05/9:00:00', '济南站', 1);
INSERT INTO `train` VALUES (8, '/shxt/resource/upload/photo/1cea1299-514e-4a38-b33d-4801746907b3.jpg', '济南', '贵州', '300', '2016/10/05/9:00:00', '济南站', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '1为男，2为女',
  `user_status` int(1) NULL DEFAULT 1 COMMENT '1为在职，0为禁用，-1为离职',
  `fk_salary_id` int(11) NULL DEFAULT NULL,
  `fk_role_id` int(11) NULL DEFAULT NULL,
  `fk_org_id` int(11) NULL DEFAULT NULL,
  `user_photo_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'ultra', '340123199609092591', '17862911889', '1', 1, 1, 1, 1, '/shxt/resource/upload/photo/63c7c5bf-a043-443e-bf34-4e3ad59fa73a.jpg', 'zyl@qq.com');
INSERT INTO `user` VALUES (2, 'aaaaaa', 'aaaaaa', '萌萌', '370181199510103001', '17862916112', '1', 1, 4, 4, 2, '/shxt/resource/upload/photo/eda776e7-a7fc-4915-91c4-71d7839c9f57.jpg', 'cyn@qq.com');
INSERT INTO `user` VALUES (3, 'bbbbbb', 'bbbbbb', '帅帅', '370181199510103002', '17862916113', '1', 0, 2, 2, 2, '/shxt/resource/upload/photo/8f62e429-57ac-4a72-a944-24765d3b20cb.jpg', 'lmf@qq.com');
INSERT INTO `user` VALUES (4, 'cccccc', 'cccccc', '萌帅', '370181199510103005', '17862916114', '1', 1, 2, 2, 2, '/shxt/resource/upload/photo/7a9be099-31a1-4bfb-8594-367e4e888a22.jpg', 'gz@qq.com');
INSERT INTO `user` VALUES (5, 'dddddd', 'dddddd', '美腻的学姐', '370181199510103007', '17862916116', '2', 1, 3, 3, 3, '/shxt/resource/upload/photo/1fd32dbb-08b4-41b8-8d41-49be9637ad1c.png', 'lmx@qq.com');
INSERT INTO `user` VALUES (6, 'eeeeee', 'eeeeee', '美腻的学妹', '370181199510103008', '17862916117', '2', 1, 4, 4, 3, '/shxt/resource/upload/photo/b36f8991-3b1b-475f-be3c-5afd0931b696.png', 'llh@qq.com');
INSERT INTO `user` VALUES (7, 'huahua', '123456', '花花', NULL, NULL, NULL, 1, 3, 3, NULL, '/shxt/resource/upload/photo/79e1abdf-ad72-4557-93e4-2f4562e8f38b.jpg', NULL);
INSERT INTO `user` VALUES (8, 'haha', '123456', '哈哈', NULL, NULL, NULL, 1, 2, 2, NULL, NULL, NULL);
INSERT INTO `user` VALUES (9, 'ase', '123456', '阿色', NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (10, 'yongyangyang', '123456', '杨欣欣', NULL, NULL, NULL, 1, 4, 4, NULL, NULL, NULL);
INSERT INTO `user` VALUES (11, 'xiangyun', '123456', '祥云', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (12, 'qqqqqqqqq', '123456', 'hh', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (13, 'zzzzzzzzzzzzz', '123456', 'ko', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (14, 'admin111', '123456', '花花', NULL, NULL, NULL, 1, 3, 3, NULL, '/shxt/resource/upload/photo/e8b5f582-c033-45f7-9cb5-6f73a401e96a.jpg', NULL);
INSERT INTO `user` VALUES (15, 'admin11111111111111', '123456', '萌萌', NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (16, 'admin111m', '123456', '帅', NULL, NULL, NULL, 0, 2, 2, NULL, '/shxt/resource/upload/photo/d7af5ff0-0fb6-48c5-ae6e-dd2df7d7f8bc.jpg', NULL);
INSERT INTO `user` VALUES (17, 'adminqqq', '123456', '好帅', NULL, NULL, NULL, 1, 4, 4, NULL, '/shxt/resource/upload/photo/25e484ca-08b8-4e69-9d06-c5a1478f246f.jpg', NULL);
INSERT INTO `user` VALUES (18, 'adminhdhdhdh', '123456', '蒯老师', NULL, NULL, NULL, 1, 2, 2, NULL, '/shxt/resource/upload/photo/58452fac-ffa3-4575-b6af-91f3f390f9de.jpg', NULL);

-- ----------------------------
-- Table structure for villa
-- ----------------------------
DROP TABLE IF EXISTS `villa`;
CREATE TABLE `villa`  (
  `villa_id` int(11) NOT NULL AUTO_INCREMENT,
  `villa_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `villa_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `villa_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `villa_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `villa_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `villa_status` int(11) NULL DEFAULT 1 COMMENT '1为存在，0为不存在',
  PRIMARY KEY (`villa_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of villa
-- ----------------------------
INSERT INTO `villa` VALUES (1, '/shxt/resource/upload/photo/55ec5102-446a-4580-9d2b-ef52e26957ae.png', '城南别墅', '1299', '济南', '清幽大气，度假首选', 1);
INSERT INTO `villa` VALUES (2, '/shxt/resource/upload/photo/6f33ad77-2b10-41d4-b492-53c4d439d6cc.png', '国华东方美郡', '1099', '济南', '清幽大气，度假首选', 1);
INSERT INTO `villa` VALUES (3, '/shxt/resource/upload/photo/39321195-be03-43d4-a6fe-7b4a60dfd114.png', '晨曦别墅', '1299', '济南', '清幽大气，度假首选', 1);
INSERT INTO `villa` VALUES (4, '/shxt/resource/upload/photo/029d3d57-3007-40bd-8442-025890fa210b.jpg', '耀光别墅', '1599', '济南', '清幽大气，度假首选', 1);
INSERT INTO `villa` VALUES (5, '/shxt/resource/upload/photo/f56130ca-9222-44a3-848c-51cdc8b206ff.jpg', '汉森美墅', '1399', '济南', '清幽大气，度假首选', 1);
INSERT INTO `villa` VALUES (6, '/shxt/resource/upload/photo/015a47b5-8ff6-4fd4-aedd-fe0967570883.jpg', '湖光山色', '1699', '济南', '清幽大气，度假首选', 1);
INSERT INTO `villa` VALUES (7, '/shxt/resource/upload/photo/ddce9aa9-f0c1-4de8-9b93-8a397eb0601f.jpg', '东山花园', '1299', '济南', '清幽大气，度假首选', 1);
INSERT INTO `villa` VALUES (8, '/shxt/resource/upload/photo/14e94b85-1c33-40b2-8daa-8b14ece84389.jpg', '拉菲公馆', '1499', '济南', '清幽大气，度假首选', 1);

-- ----------------------------
-- Table structure for visa
-- ----------------------------
DROP TABLE IF EXISTS `visa`;
CREATE TABLE `visa`  (
  `visa_id` int(11) NOT NULL AUTO_INCREMENT,
  `visa_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `visa_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `visa_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `visa_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `visa_day` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `visa_useful` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `visa_status` int(11) NULL DEFAULT 0 COMMENT '0为未处理，1为同意，-1为拒绝',
  `visa_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`visa_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of visa
-- ----------------------------
INSERT INTO `visa` VALUES (1, '英国', '5', '700', '1', '5', '8个月', 1, '/shxt/resource/upload/photo/f0556b39-28f9-47af-9732-d917a16f00e3.jpg');
INSERT INTO `visa` VALUES (2, '美国', '5', '500', '1', '5', '一年', 1, '/shxt/resource/upload/photo/f7c3a649-4306-4796-b6f3-7241d3e736bb.jpg');
INSERT INTO `visa` VALUES (3, '澳大利亚', '7', '800', '1', '5', '半年', 1, '/shxt/resource/upload/photo/07eb608d-9ce1-4f08-b09a-6a3e9edf1a86.jpg');
INSERT INTO `visa` VALUES (4, '威尼斯', '3', '600', '1', '5', '一年', 1, '/shxt/resource/upload/photo/2edbd88c-26f5-4c66-bde7-4ca2b217b137.jpg');
INSERT INTO `visa` VALUES (5, '俄罗斯', '6', '500', '2', '8', '3个月', 1, '/shxt/resource/upload/photo/b6dbf8fc-7cf2-4ae8-b05c-b7eabed561ae.jpg');
INSERT INTO `visa` VALUES (6, '巴西', '6', '400', '2', '7', '一年', 1, '/shxt/resource/upload/photo/d521c347-91dc-45fd-b9fc-2e80f8e2301e.jpg');
INSERT INTO `visa` VALUES (7, '希腊', '4', '600', '2', '7', '一年', 1, '/shxt/resource/upload/photo/c56445ac-32a0-49a9-913e-985714ac191e.jpg');

-- ----------------------------
-- Table structure for western
-- ----------------------------
DROP TABLE IF EXISTS `western`;
CREATE TABLE `western`  (
  `western_id` int(11) NOT NULL AUTO_INCREMENT,
  `western_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `western_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `western_price` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `western_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `western_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `western_status` int(11) NULL DEFAULT 1 COMMENT '1为存在0为不存在',
  PRIMARY KEY (`western_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of western
-- ----------------------------
INSERT INTO `western` VALUES (1, '/shxt/resource/upload/photo/eccd3745-8703-49f7-a15a-9cc0d9f372ee.png', '简约早餐', '25', '济南', '营养健康，美味可口', 1);
INSERT INTO `western` VALUES (2, '/shxt/resource/upload/photo/72d3bcfd-04f3-4d61-ba88-38d8320347ee.png', '经典下午茶', '49', '济南', '营养健康，美味可口', 1);
INSERT INTO `western` VALUES (3, '/shxt/resource/upload/photo/8ab2495a-2a33-4253-b726-9f4e3dc6d0ed.jpg', '松露舒芙蕾', '29', '济南', '营养健康，美味可口', 1);
INSERT INTO `western` VALUES (4, '/shxt/resource/upload/photo/b1cccffc-4b90-427c-9b9d-a2e9ca138c40.jpg', '樱桃慕斯', '45', '济南', '营养健康，美味可口', 1);
INSERT INTO `western` VALUES (5, '/shxt/resource/upload/photo/a6220d6e-73dc-44e0-9bf9-3fc65934adf2.jpg', '草莓甜心', '159', '济南', '营养健康，美味可口', 1);
INSERT INTO `western` VALUES (6, '/shxt/resource/upload/photo/790d679e-1ed1-4171-a3c2-aa79d01e9c19.jpg', '马卡龙', '20', '济南', '营养健康，美味可口', 1);
INSERT INTO `western` VALUES (7, '/shxt/resource/upload/photo/b26d7dec-f72e-473d-a011-078fbc818a1c.jpg', '沙丁菠萝', '25', '济南', '营养健康，美味可口', 1);
INSERT INTO `western` VALUES (8, '/shxt/resource/upload/photo/4b5fdb6f-6957-40e1-8ce3-8bd682c8af0c.jpg', '焦糖布丁', '35', '济南', '营养健康，美味可口', 1);
INSERT INTO `western` VALUES (9, '/shxt/resource/upload/photo/690a7740-e702-48ce-ab37-4c0fd2e72bd4.jpg', '下午茶套餐', '49', '济南', '营养健康，美味可口', 1);

SET FOREIGN_KEY_CHECKS = 1;
