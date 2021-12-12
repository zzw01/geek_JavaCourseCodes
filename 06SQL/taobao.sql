/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : taobao

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 12/12/2021 23:43:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer` (
  `id` int NOT NULL COMMENT '消费者id',
  `consumer_name` varchar(255) NOT NULL COMMENT '消费者名即用户名称，不能为空',
  `consumer_nick` varchar(255) DEFAULT NULL COMMENT '消费者昵称',
  `consumer_age` int DEFAULT NULL COMMENT '消费者年龄',
  `consumer_gender` int DEFAULT NULL COMMENT '消费者性别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for order_d
-- ----------------------------
DROP TABLE IF EXISTS `order_d`;
CREATE TABLE `order_d` (
  `id` int NOT NULL COMMENT '订单明细id',
  `order_no` varchar(255) NOT NULL COMMENT '订单号，和order表对应',
  `sku_no` varchar(255) NOT NULL COMMENT '商品编码',
  `qty` decimal(18,4) NOT NULL COMMENT '商品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for order_m
-- ----------------------------
DROP TABLE IF EXISTS `order_m`;
CREATE TABLE `order_m` (
  `id` int NOT NULL COMMENT 'id',
  `order_no` varchar(255) NOT NULL COMMENT '订单号，唯一，根据用户id、时间、商品编号、商品批属性生成',
  `order_status` int NOT NULL COMMENT '订单状态，10初始化，20已生成拣货任务，30已拣货，40已复核，50已发货，60已收货，70已完成，404取消',
  `consumer_id` int NOT NULL COMMENT '消费者id，即该订单属于谁',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for sku
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku` (
  `id` int NOT NULL,
  `sku_no` int NOT NULL COMMENT '商品编号',
  `sku_name` varchar(255) NOT NULL COMMENT '商品名称',
  `attribute_no` int DEFAULT NULL COMMENT '商品属性',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
