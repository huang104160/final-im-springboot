/*
SQLyog Enterprise v12.14 (64 bit)
MySQL - 8.0.32 : Database - im
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`im` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `im`;

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uid` bigint DEFAULT NULL,
  `tid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `apply` */

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uid` bigint DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `comments` */

insert  into `comments`(`id`,`uid`,`username`,`text`) values 

(59,18,'2','sdf'),

(60,18,'2','2234'),

(61,18,'2','asdfd'),

(62,17,'1','这个人挺厉害的，年纪轻轻就能写出这么年轻的程序，但不管怎么说，这还是太年轻了'),

(63,17,'1','牛逼'),

(64,17,'1','这个人挺厉害的，年纪轻轻就能写出这么年轻的程序，但不管怎么说，这还是太年轻了'),

(65,17,'1','这个人一般般吧，其实也不太行，密码居然是明文保存在数据库的'),

(66,17,'1','这个人挺厉害的，年纪轻轻就能写出这么年轻的程序，但不管怎么说，这还是太年轻了'),

(67,17,'1','这个人太菜了，真的是，我大三下都会各种框架了，各种高并发，多线程，高可用，作者还在写curd，有时居然不熟练，还得去csdn，太拉了真的是'),

(68,17,'1','这个人挺厉害的，年纪轻轻就能写出这么年轻的程序，但不管怎么说，这还是太年轻了');

/*Table structure for table `friend` */

DROP TABLE IF EXISTS `friend`;

CREATE TABLE `friend` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uid` bigint DEFAULT NULL,
  `fid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `friend` */

insert  into `friend`(`id`,`uid`,`fid`) values 

(46,17,18),

(47,18,17),

(48,18,19),

(49,19,18),

(50,20,18),

(51,18,20),

(52,17,20),

(53,20,17),

(54,21,17),

(55,17,21);

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `from` bigint DEFAULT NULL COMMENT '来源id',
  `to` bigint DEFAULT NULL COMMENT '给谁',
  `type` int DEFAULT NULL COMMENT '类型  ',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `message` */

insert  into `message`(`id`,`from`,`to`,`type`,`content`,`time`) values 

(178,18,17,1,'nihao 我是2','2023-03-23 16:21:07'),

(179,17,18,1,'你好我是1','2023-03-23 16:21:15'),

(180,18,17,1,'nihao','2023-03-23 18:12:15'),

(181,17,18,1,'nihao\n','2023-03-23 18:12:21'),

(182,18,17,1,'hhh','2023-03-23 19:43:10'),

(183,18,19,1,'hh\n','2023-03-23 19:49:23'),

(184,17,20,1,'hh','2023-03-23 20:19:05'),

(185,17,18,1,'a\n','2023-03-23 20:23:57'),

(186,18,19,1,'adsf','2023-03-24 10:10:40'),

(187,18,20,1,'sadgsdfghsertwrehdfsz','2023-03-24 10:10:47'),

(188,18,17,1,'wertwret','2023-03-24 10:10:51'),

(189,18,20,1,'adsfads','2023-03-24 10:26:19'),

(190,18,20,1,'adfdsf','2023-03-24 10:26:20'),

(191,18,20,1,'adfdsf','2023-03-24 10:26:20'),

(192,18,20,1,'adsfadsf','2023-03-24 10:26:21'),

(193,18,20,1,'adfads','2023-03-24 10:26:22'),

(194,18,20,1,'adfdfadsf','2023-03-24 10:26:26'),

(195,18,20,1,'adf','2023-03-24 10:56:41'),

(196,18,20,1,'asdf','2023-03-24 10:56:52'),

(197,18,20,1,'asdf','2023-03-24 11:01:06'),

(198,18,20,1,'adsfads','2023-03-24 11:01:08'),

(199,18,20,1,'adsfdsfadd','2023-03-24 11:01:11'),

(200,18,20,1,'adsder234234','2023-03-24 11:01:15'),

(201,18,20,1,'dsaf','2023-03-24 11:01:20'),

(202,18,19,1,'zxcv','2023-03-24 11:01:55'),

(203,18,19,1,'zcxv','2023-03-24 11:01:56'),

(204,18,19,1,'sdaf','2023-03-24 11:01:58'),

(205,18,19,1,'adsf','2023-03-24 11:01:59'),

(206,18,19,1,'zxcvz','2023-03-24 11:02:00'),

(207,18,19,1,'asdf','2023-03-24 11:02:02'),

(208,18,19,1,'asdf','2023-03-24 11:02:04'),

(209,18,19,1,'adsfafwerq','2023-03-24 11:02:06'),

(210,18,19,1,'2341324','2023-03-24 11:02:08'),

(211,18,19,1,'t342tw','2023-03-24 11:02:10'),

(212,18,19,1,'ewqr','2023-03-24 11:02:14'),

(213,18,19,1,'adsfxczxv','2023-03-24 11:04:37'),

(214,18,19,1,'sdafdsfew','2023-03-24 11:04:40'),

(215,18,19,1,'sadfdsss','2023-03-24 11:06:38'),

(216,18,19,1,'asdfsdaf','2023-03-24 11:27:56'),

(217,17,18,1,'sdaf','2023-03-24 11:29:08'),

(218,17,18,1,'大师傅','2023-03-24 11:29:16'),

(219,17,18,1,'士大夫','2023-03-24 11:30:53'),

(220,17,18,1,'爱的色放','2023-03-24 11:31:02'),

(221,18,17,1,'dsafsdfadsfwe4235r','2023-03-24 11:32:32'),

(222,18,17,1,'asdfaewfwer','2023-03-24 11:32:35'),

(223,18,17,1,'asdfewr32432','2023-03-24 11:32:42'),

(224,17,18,1,'爱的色放','2023-03-24 11:33:13'),

(225,17,18,1,'a','2023-03-24 11:33:54'),

(226,17,18,1,'啊','2023-03-24 11:35:48'),

(227,17,18,1,'啊','2023-03-24 11:35:50'),

(228,17,20,1,'阿斯蒂芬却无法荣企鹅王','2023-03-24 11:36:12'),

(229,17,18,1,'啊   ','2023-03-24 11:48:25'),

(230,17,18,1,'啊啊啊啊','2023-03-24 11:48:34'),

(231,21,17,1,'asdfasdf','2023-03-24 11:49:26'),

(232,17,21,1,'阿达啊','2023-03-24 11:49:32');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`image`) values 

(17,'1','1','http://127.0.0.1:19000/assets/heads/head1.jpg'),

(18,'2','2','http://127.0.0.1:19000/assets/heads/head4.jpg'),

(19,'3','3','http://127.0.0.1:19000/assets/heads/head1.jpg'),

(20,'hy','1','http://127.0.0.1:19000/assets/heads/head3.jpg'),

(21,'4','4','http://127.0.0.1:19000/assets/heads/head1.jpg'),

(22,'5','5','http://127.0.0.1:19000/assets/heads/head9.jpg');

/*Table structure for table `videoinfo` */

DROP TABLE IF EXISTS `videoinfo`;

CREATE TABLE `videoinfo` (
  `videoDateId` bigint NOT NULL AUTO_INCREMENT,
  `uid` bigint DEFAULT NULL,
  `fid` bigint DEFAULT NULL,
  `videoDate` datetime DEFAULT NULL,
  PRIMARY KEY (`videoDateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `videoinfo` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
