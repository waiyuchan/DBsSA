/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : dbssa

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 26/02/2023 02:19:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apartment
-- ----------------------------
DROP TABLE IF EXISTS `apartment`;
CREATE TABLE `apartment` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '公寓id，自增',
  `apartment_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓地址',
  `official_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓电话',
  `floor_number` int NOT NULL COMMENT '公寓楼层',
  `number_of_rooms` int NOT NULL COMMENT '房间数量',
  `number_of_bedrooms` int NOT NULL COMMENT '卧室房间数量',
  `number_of_bathrooms` int NOT NULL COMMENT '洗手间数量',
  `number_of_public_rooms` int NOT NULL COMMENT '公共空间数量',
  `floor_space` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '公寓占地空间，单位: 平方米',
  `maximum_rent` int NOT NULL COMMENT '最大限住人数',
  `create_date` date NOT NULL COMMENT '创建日期',
  `start_date` date DEFAULT NULL COMMENT '开始运营时间',
  `status` int NOT NULL DEFAULT '0' COMMENT '状态',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓信息';

-- ----------------------------
-- Table structure for apartment_asset
-- ----------------------------
DROP TABLE IF EXISTS `apartment_asset`;
CREATE TABLE `apartment_asset` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '资产id，自增',
  `apartment_id` int NOT NULL COMMENT '资产所属公寓id',
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '资产名称',
  `create_time` datetime NOT NULL COMMENT '资产创建日期',
  PRIMARY KEY (`id`),
  KEY `ap_asset_ap_fgk` (`apartment_id`),
  CONSTRAINT `ap_asset_ap_fgk` FOREIGN KEY (`apartment_id`) REFERENCES `apartment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓资产信息';

-- ----------------------------
-- Table structure for apartment_asset_allocation_rel
-- ----------------------------
DROP TABLE IF EXISTS `apartment_asset_allocation_rel`;
CREATE TABLE `apartment_asset_allocation_rel` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '公寓资产分配关系id',
  `apartment_asset_id` int NOT NULL COMMENT '公寓资产id',
  `apartment_room_id` int NOT NULL COMMENT '公寓房间id',
  `create_time` int NOT NULL COMMENT '分配时间',
  `status` int NOT NULL DEFAULT '0' COMMENT '分配状态，0: 未分配，1: 已分配，2: 已退回',
  PRIMARY KEY (`id`),
  KEY `ap_asset_alloc_ap_asset_fgk` (`apartment_asset_id`),
  KEY `ap_asset_alloc_ap_room_fgk` (`apartment_room_id`),
  CONSTRAINT `ap_asset_alloc_ap_asset_fgk` FOREIGN KEY (`apartment_asset_id`) REFERENCES `apartment_asset` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap_asset_alloc_ap_room_fgk` FOREIGN KEY (`apartment_room_id`) REFERENCES `apartment_room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓资产分配关系';

-- ----------------------------
-- Table structure for apartment_asset_tag
-- ----------------------------
DROP TABLE IF EXISTS `apartment_asset_tag`;
CREATE TABLE `apartment_asset_tag` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '公寓资产标签id，自增',
  `tag_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓资产标签名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓资产标签信息';

-- ----------------------------
-- Table structure for apartment_asset_tag_marked
-- ----------------------------
DROP TABLE IF EXISTS `apartment_asset_tag_marked`;
CREATE TABLE `apartment_asset_tag_marked` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '公寓资产标签标注id',
  `apartment_asset_id` int NOT NULL COMMENT '公寓资产id',
  `apartment_asset_tag_id` int NOT NULL COMMENT '公寓资产标签id',
  `create_time` datetime NOT NULL COMMENT '标注时间',
  PRIMARY KEY (`id`),
  KEY `ap_asset_tag_makred_ap_asset_fgk` (`apartment_asset_id`),
  KEY `ap_asset_tag_makred_ap_asset_tag_fgk` (`apartment_asset_tag_id`),
  CONSTRAINT `ap_asset_tag_makred_ap_asset_fgk` FOREIGN KEY (`apartment_asset_id`) REFERENCES `apartment_asset` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap_asset_tag_makred_ap_asset_tag_fgk` FOREIGN KEY (`apartment_asset_tag_id`) REFERENCES `apartment_asset_tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓资产标签标注关系';

-- ----------------------------
-- Table structure for apartment_electricity_meter
-- ----------------------------
DROP TABLE IF EXISTS `apartment_electricity_meter`;
CREATE TABLE `apartment_electricity_meter` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '电表id，自增',
  `room_id` int NOT NULL COMMENT '房间id',
  `electricity_consumption` int NOT NULL DEFAULT '0' COMMENT '用电量',
  `record_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录时间',
  PRIMARY KEY (`id`),
  KEY `ap_elec_meter_ap_room_fgk` (`room_id`),
  CONSTRAINT `ap_elec_meter_ap_room_fgk` FOREIGN KEY (`room_id`) REFERENCES `apartment_room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓电表';

-- ----------------------------
-- Table structure for apartment_electricity_record
-- ----------------------------
DROP TABLE IF EXISTS `apartment_electricity_record`;
CREATE TABLE `apartment_electricity_record` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用水抄表记录id，自增',
  `electricity_meter_id` int NOT NULL COMMENT '唯一电表id',
  `last_reading` int NOT NULL COMMENT '上次读数',
  `latest_reading` int NOT NULL COMMENT '最新读数',
  `electricity_consumed` int NOT NULL COMMENT '当前用电量',
  `electricity_fee` int NOT NULL COMMENT '当前用电费用',
  `record_time` int NOT NULL COMMENT '抄表日期',
  `settlement_date` date NOT NULL COMMENT '结算日期',
  PRIMARY KEY (`id`),
  KEY `ap_electricity_record_ap_electricity_meter_fgk` (`electricity_meter_id`),
  CONSTRAINT `ap_electricity_record_ap_electricity_meter_fgk` FOREIGN KEY (`electricity_meter_id`) REFERENCES `apartment_electricity_meter` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓用电抄表记录';

-- ----------------------------
-- Table structure for apartment_organization
-- ----------------------------
DROP TABLE IF EXISTS `apartment_organization`;
CREATE TABLE `apartment_organization` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '组织id，自增',
  `parent_id` int NOT NULL DEFAULT '0' COMMENT '组织父id，如果是起始组织的话采用默认值0',
  `apartment_id` int NOT NULL COMMENT '公寓id',
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '组织名称',
  PRIMARY KEY (`id`),
  KEY `ap_ap_org_fgk` (`apartment_id`),
  CONSTRAINT `ap_ap_org_fgk` FOREIGN KEY (`apartment_id`) REFERENCES `apartment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓组织架构信息';

-- ----------------------------
-- Table structure for apartment_rental_order
-- ----------------------------
DROP TABLE IF EXISTS `apartment_rental_order`;
CREATE TABLE `apartment_rental_order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '租赁订单id，自增',
  `apartment_id` int NOT NULL COMMENT '公寓id',
  `apartment_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓名称',
  `apartment_room_id` int NOT NULL COMMENT '公寓房间id',
  `apartment_room_number` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓房间编号',
  `apartment_resident_id` int NOT NULL COMMENT '公寓住户id',
  `apartment_resident_username` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓用户用户名',
  `apartment_resident_reservation_id` int NOT NULL COMMENT '公寓住户预订订单id',
  `price` int NOT NULL COMMENT '租赁价格',
  `pay_by_installment` int NOT NULL DEFAULT '0' COMMENT '是否分期，0: 否，1: 是',
  `status` int NOT NULL DEFAULT '0' COMMENT '订单状态，0: 未付款，1: 分期中，2: 已完成，3: 超时未付款，4: 分期未按时还款',
  `start_date` date NOT NULL COMMENT '开租日期',
  `end_date` date NOT NULL COMMENT '到期日期',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建日期',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓租赁订单';

-- ----------------------------
-- Table structure for apartment_rental_payment
-- ----------------------------
DROP TABLE IF EXISTS `apartment_rental_payment`;
CREATE TABLE `apartment_rental_payment` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '租赁分期id，自增',
  `order_id` int NOT NULL COMMENT '订单id',
  `total_payment_period` int NOT NULL DEFAULT '1' COMMENT '总的分期周期，如果是没有分期，则默认分期周期为1',
  `current_installment_period` int NOT NULL COMMENT '当前分期周期',
  `current_installment_amount` int NOT NULL COMMENT '当前分期金额，单位：分',
  `payment_date` date NOT NULL COMMENT '当前租期的支付日期',
  `status` int NOT NULL DEFAULT '0' COMMENT '当前租期的支付状态，0：未支付，1：已支付',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '分期记录创建时间',
  `update_time` datetime NOT NULL COMMENT '分期记录更新时间',
  PRIMARY KEY (`id`),
  KEY `ap_rent_pay_ap_rent_order_fgk` (`order_id`),
  CONSTRAINT `ap_rent_pay_ap_rent_order_fgk` FOREIGN KEY (`order_id`) REFERENCES `apartment_rental_order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓租赁付款记录';

-- ----------------------------
-- Table structure for apartment_resident
-- ----------------------------
DROP TABLE IF EXISTS `apartment_resident`;
CREATE TABLE `apartment_resident` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '公寓住户id，自增',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓住户用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓住户用户密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓住户姓名',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓住户联系电话',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓住户电子邮箱',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓住户住址',
  `status` int NOT NULL DEFAULT '0' COMMENT '公寓住户状态，0: 未入住，1: 已入住，2: 已退租',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓住户信息';

-- ----------------------------
-- Table structure for apartment_resident_reservation
-- ----------------------------
DROP TABLE IF EXISTS `apartment_resident_reservation`;
CREATE TABLE `apartment_resident_reservation` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '预订订单id，自增',
  `apartment_room_id` int NOT NULL COMMENT '预订房间id',
  `apartment_resident_id` int NOT NULL COMMENT '预订住户id',
  `status` int NOT NULL COMMENT '预订状态，0: 订单未付押金，1: 订单已付押金，2: 订单超时未支付，4: 已办理入住，5: 已退订',
  `create_time` datetime NOT NULL COMMENT '预定时间',
  PRIMARY KEY (`id`),
  KEY `ap_res_reser_ap_res_fgk` (`apartment_resident_id`),
  KEY `ap_res_reser_ap_room_fgk` (`apartment_room_id`),
  CONSTRAINT `ap_res_reser_ap_res_fgk` FOREIGN KEY (`apartment_resident_id`) REFERENCES `apartment_resident` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap_res_reser_ap_room_fgk` FOREIGN KEY (`apartment_room_id`) REFERENCES `apartment_room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓住户预订订单信息';

-- ----------------------------
-- Table structure for apartment_room
-- ----------------------------
DROP TABLE IF EXISTS `apartment_room`;
CREATE TABLE `apartment_room` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房间id，自增',
  `apartment_id` int NOT NULL COMMENT '公寓id',
  `room_type_id` int NOT NULL COMMENT '房型id',
  `room_number` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间编号',
  `floor` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '房间所在楼层',
  `status` int NOT NULL DEFAULT '0' COMMENT '房间状态，0: 未入住，1: 入住中',
  PRIMARY KEY (`id`),
  KEY `ap_room_fgk` (`apartment_id`),
  KEY `ap_room_ap_room_type_fgk` (`room_type_id`),
  CONSTRAINT `ap_room_ap_room_type_fgk` FOREIGN KEY (`room_type_id`) REFERENCES `apartment_room_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap_room_fgk` FOREIGN KEY (`apartment_id`) REFERENCES `apartment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓房间信息';

-- ----------------------------
-- Table structure for apartment_room_bill
-- ----------------------------
DROP TABLE IF EXISTS `apartment_room_bill`;
CREATE TABLE `apartment_room_bill` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '账单id，自增',
  `apartment_room_id` int NOT NULL COMMENT '公寓房间id',
  `bill_period` int NOT NULL COMMENT '账单的计费周期，单位：天',
  `bill_date` int NOT NULL COMMENT '账单生成的日期',
  `bill_amount` int NOT NULL COMMENT '账单的总金额，单位：分',
  `status` int NOT NULL DEFAULT '0' COMMENT '账单状态，0: 未付款，1: 已付款',
  PRIMARY KEY (`id`),
  KEY `ap_bill_ap_room_fgk` (`apartment_room_id`),
  CONSTRAINT `ap_bill_ap_room_fgk` FOREIGN KEY (`apartment_room_id`) REFERENCES `apartment_room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓账单';

-- ----------------------------
-- Table structure for apartment_room_bill_detail
-- ----------------------------
DROP TABLE IF EXISTS `apartment_room_bill_detail`;
CREATE TABLE `apartment_room_bill_detail` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '账单明细id，自增',
  `bill_id` int NOT NULL COMMENT '账单id',
  `item_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '费用项目名称（如租金、水费、电费）',
  `item_amount` int NOT NULL COMMENT '费用项目的金额，单位：分',
  PRIMARY KEY (`id`),
  KEY `ap_room_bill_detail_ap_bill_fgk` (`bill_id`),
  CONSTRAINT `ap_room_bill_detail_ap_bill_fgk` FOREIGN KEY (`bill_id`) REFERENCES `apartment_room_bill` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓账单明细';

-- ----------------------------
-- Table structure for apartment_room_price
-- ----------------------------
DROP TABLE IF EXISTS `apartment_room_price`;
CREATE TABLE `apartment_room_price` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '定价id，自增',
  `apartment_id` int NOT NULL COMMENT '公寓id',
  `apartment_room_type_id` int NOT NULL COMMENT '公寓房型类型id',
  `price` int NOT NULL COMMENT '价格',
  PRIMARY KEY (`id`),
  KEY `ap_price_fgk` (`apartment_id`),
  KEY `ap_price_ap_room_type_fgk` (`apartment_room_type_id`),
  CONSTRAINT `ap_price_ap_room_type_fgk` FOREIGN KEY (`apartment_room_type_id`) REFERENCES `apartment_room_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap_price_fgk` FOREIGN KEY (`apartment_id`) REFERENCES `apartment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓房间定价信息';

-- ----------------------------
-- Table structure for apartment_room_resident_ownership_rel
-- ----------------------------
DROP TABLE IF EXISTS `apartment_room_resident_ownership_rel`;
CREATE TABLE `apartment_room_resident_ownership_rel` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '公寓房间-住户隶属关系id，自增',
  `apartment_resident_id` int NOT NULL COMMENT '公寓住户id',
  `apartment_room_id` int NOT NULL COMMENT '公寓房间id',
  `apartment_resident_reservation_id` int NOT NULL COMMENT '公寓住户预订订单id',
  `apartment_rental_order_id` int NOT NULL COMMENT '公寓租赁订单id',
  `status` int NOT NULL COMMENT '入住状态，0: 已完成check in，1: 已完成check out',
  `checkin_time` datetime DEFAULT NULL COMMENT '入住时间',
  `checkout_time` datetime DEFAULT NULL COMMENT '退房时间',
  PRIMARY KEY (`id`),
  KEY `ap_room_res_own_ap_res_fgk` (`apartment_resident_id`),
  KEY `ap_room_res_own_ap_room_fgk` (`apartment_room_id`),
  KEY `ap_room_res_own_ap_res_reser_fgk` (`apartment_resident_reservation_id`),
  KEY `ap_room_res_own_ap_rent_order_fgk` (`apartment_rental_order_id`),
  CONSTRAINT `ap_room_res_own_ap_rent_order_fgk` FOREIGN KEY (`apartment_rental_order_id`) REFERENCES `apartment_rental_order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap_room_res_own_ap_res_fgk` FOREIGN KEY (`apartment_resident_id`) REFERENCES `apartment_resident` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap_room_res_own_ap_res_reser_fgk` FOREIGN KEY (`apartment_resident_reservation_id`) REFERENCES `apartment_resident_reservation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap_room_res_own_ap_room_fgk` FOREIGN KEY (`apartment_room_id`) REFERENCES `apartment_room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓房间-住户隶属关系';

-- ----------------------------
-- Table structure for apartment_room_type
-- ----------------------------
DROP TABLE IF EXISTS `apartment_room_type`;
CREATE TABLE `apartment_room_type` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房间类型id，自增',
  `room_type_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '房型名称',
  `room_resident_limit` int NOT NULL COMMENT '该类房型限住人数',
  `room_size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '该类房型面积',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓房型信息';

-- ----------------------------
-- Table structure for apartment_staff
-- ----------------------------
DROP TABLE IF EXISTS `apartment_staff`;
CREATE TABLE `apartment_staff` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '公寓人员id',
  `apartment_id` int NOT NULL COMMENT '公寓id',
  `enterprise_staff_id` int NOT NULL COMMENT '企业员工id',
  `staff_role_id` int NOT NULL COMMENT '工作角色',
  `create_time` datetime NOT NULL COMMENT '岗位分配时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '岗位修改时间',
  PRIMARY KEY (`id`),
  KEY `ap_staff_ap_fgk` (`apartment_id`),
  KEY `ap_staff_enterprise_staff_fgk` (`enterprise_staff_id`),
  KEY `ap_staff_role_fgk` (`staff_role_id`),
  CONSTRAINT `ap_staff_ap_fgk` FOREIGN KEY (`apartment_id`) REFERENCES `apartment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap_staff_enterprise_staff_fgk` FOREIGN KEY (`enterprise_staff_id`) REFERENCES `enterprise_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap_staff_role_fgk` FOREIGN KEY (`staff_role_id`) REFERENCES `apartment_staff_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓工作人员信息';

-- ----------------------------
-- Table structure for apartment_staff_organization_rel
-- ----------------------------
DROP TABLE IF EXISTS `apartment_staff_organization_rel`;
CREATE TABLE `apartment_staff_organization_rel` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '公寓人员-组织归属关系id，自增',
  `apartment_staff_id` int NOT NULL COMMENT '公寓工作人员id',
  `org_id` int NOT NULL COMMENT '公寓组织id',
  `join_time` datetime NOT NULL COMMENT '归属时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `ap_staff_org_rel_ap_staff_fgk` (`apartment_staff_id`),
  KEY `ap_staff_org_rel_ap_org_fgl` (`org_id`),
  CONSTRAINT `ap_staff_org_rel_ap_org_fgl` FOREIGN KEY (`org_id`) REFERENCES `apartment_organization` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ap_staff_org_rel_ap_staff_fgk` FOREIGN KEY (`apartment_staff_id`) REFERENCES `apartment_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓人员-组织归属关系';

-- ----------------------------
-- Table structure for apartment_staff_role
-- ----------------------------
DROP TABLE IF EXISTS `apartment_staff_role`;
CREATE TABLE `apartment_staff_role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '公寓员工角色id，自增',
  `role_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '公寓员工角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓员工工作角色';

-- ----------------------------
-- Table structure for apartment_water_meter
-- ----------------------------
DROP TABLE IF EXISTS `apartment_water_meter`;
CREATE TABLE `apartment_water_meter` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '电表id，自增',
  `room_id` int NOT NULL COMMENT '房间id',
  `water_consumption` int NOT NULL DEFAULT '0' COMMENT '用水量',
  PRIMARY KEY (`id`),
  KEY `ap_elec_meter_ap_room_fgk` (`room_id`),
  CONSTRAINT `apartment_water_meter_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `apartment_room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓电表';

-- ----------------------------
-- Table structure for apartment_water_record
-- ----------------------------
DROP TABLE IF EXISTS `apartment_water_record`;
CREATE TABLE `apartment_water_record` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用水抄表记录id，自增',
  `water_meter_id` int NOT NULL COMMENT '唯一水表id',
  `last_reading` int NOT NULL COMMENT '上次读数',
  `latest_reading` int NOT NULL COMMENT '最新读数',
  `water_consumed` int NOT NULL COMMENT '当前用水量',
  `water_fee` int NOT NULL COMMENT '当前用水费用',
  `record_time` int NOT NULL COMMENT '抄表日期',
  `settlement_date` date NOT NULL COMMENT '结算日期',
  PRIMARY KEY (`id`),
  KEY `ap_water_record_ap_water_meter_fgk` (`water_meter_id`),
  CONSTRAINT `ap_water_record_ap_water_meter_fgk` FOREIGN KEY (`water_meter_id`) REFERENCES `apartment_water_meter` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公寓用水抄表记录';

-- ----------------------------
-- Table structure for enterprise_staff
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_staff`;
CREATE TABLE `enterprise_staff` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '员工id，自增',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '员工用户名，也是登陆账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '员工登陆密码',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '员工姓名',
  `gender` int NOT NULL DEFAULT '0' COMMENT '员工性别，0: 男，1: 女',
  `id_card` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '员工身份证号码',
  `degree` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '员工学历',
  `college` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '毕业院校',
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '电子邮箱',
  `ent_mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '企业员工邮箱，根据用户名自动生成',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '现居地址',
  `entry_date` date NOT NULL COMMENT '入职日期',
  `status` int NOT NULL DEFAULT '0' COMMENT '状态，0: 正常，1: 已辞职',
  `resignation_date` date DEFAULT NULL COMMENT '辞职日期',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '员工创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4548 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公司员工信息';

-- ----------------------------
-- Table structure for movie_lib
-- ----------------------------
DROP TABLE IF EXISTS `movie_lib`;
CREATE TABLE `movie_lib` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '电影id，自增',
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `english_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `directors` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `writer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `actors` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `rate` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `style` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `country` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `language` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `date` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `douban_id` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `pic` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5021 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='影片库';

SET FOREIGN_KEY_CHECKS = 1;
