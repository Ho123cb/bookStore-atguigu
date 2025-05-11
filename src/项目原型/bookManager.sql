/*
SQLyog Ultimate v12.14 (64 bit)
MySQL - 8.0.26 : Database - atguigu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`atguigu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `atguigu`;

/*Table structure for table `t_books` */

DROP TABLE IF EXISTS `t_books`;

CREATE TABLE `t_books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `author` varchar(200) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sales` int DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `img_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_books` */

insert  into `t_books`(`id`,`title`,`author`,`price`,`sales`,`stock`,`img_path`) values 
(1,'解忧杂货店','东野圭吾',27.2,105,95,'static/uploads/jieyouzahuodian.jpg'),
(2,'边城','沈从文',23,105,95,'static/uploads/biancheng.jpg'),
(3,'中国哲学史666','冯友兰',45.5,103,99,'static/uploads/zhongguozhexueshi.jpg'),
(4,'忽然七日',' 劳伦',19.33,102,98,'static/uploads/huranqiri.jpg'),
(5,'苏东坡传','林语堂',19.3,101,99,'static/uploads/sudongpozhuan.jpg');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `order_sequence` varchar(200) DEFAULT NULL,
  `create_time` varchar(100) DEFAULT NULL,
  `total_count` int DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `order_status` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_order` */

/*Table structure for table `t_order_item` */

DROP TABLE IF EXISTS `t_order_item`;

CREATE TABLE `t_order_item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `img_path` varchar(50) DEFAULT NULL,
  `item_count` int DEFAULT NULL,
  `item_amount` double DEFAULT NULL,
  `order_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_order_item` */

/*Table structure for table `t_users` */

DROP TABLE IF EXISTS `t_users`;

CREATE TABLE `t_users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
