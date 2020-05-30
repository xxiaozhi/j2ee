-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: yzj
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cjb`
--

DROP TABLE IF EXISTS `cjb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cjb` (
  `XH` char(6) NOT NULL,
  `KCH` char(3) NOT NULL,
  `CJ` int(11) DEFAULT NULL,
  `XF` int(11) DEFAULT NULL,
  PRIMARY KEY (`XH`,`KCH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cjb`
--

LOCK TABLES `cjb` WRITE;
/*!40000 ALTER TABLE `cjb` DISABLE KEYS */;
INSERT INTO `cjb` VALUES ('081101','101',99,5),('081101','102',99,4);
/*!40000 ALTER TABLE `cjb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_table`
--

DROP TABLE IF EXISTS `course_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_table` (
  `CID` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `stu_num` int(11) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_table`
--

LOCK TABLES `course_table` WRITE;
/*!40000 ALTER TABLE `course_table` DISABLE KEYS */;
INSERT INTO `course_table` VALUES ('1000','J2EE',5,50,3),('1001','GUI',5,45,3),('1002','J2SE',3,45,4);
/*!40000 ALTER TABLE `course_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dlb`
--

DROP TABLE IF EXISTS `dlb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dlb` (
  `ID` int(11) NOT NULL,
  `XH` char(6) DEFAULT NULL,
  `KL` char(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dlb`
--

LOCK TABLES `dlb` WRITE;
/*!40000 ALTER TABLE `dlb` DISABLE KEYS */;
INSERT INTO `dlb` VALUES (1,'081101','1'),(2,'002yzj','1');
/*!40000 ALTER TABLE `dlb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kcb`
--

DROP TABLE IF EXISTS `kcb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kcb` (
  `KCH` char(3) NOT NULL,
  `KCM` char(12) DEFAULT NULL,
  `KXXQ` int(11) DEFAULT NULL,
  `XS` int(11) DEFAULT NULL,
  `XF` int(11) DEFAULT NULL,
  PRIMARY KEY (`KCH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kcb`
--

LOCK TABLES `kcb` WRITE;
/*!40000 ALTER TABLE `kcb` DISABLE KEYS */;
INSERT INTO `kcb` VALUES ('101','computerBase',1,80,5),('102','language',2,68,4);
/*!40000 ALTER TABLE `kcb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_table`
--

DROP TABLE IF EXISTS `login_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_table` (
  `SID` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_table`
--

LOCK TABLES `login_table` WRITE;
/*!40000 ALTER TABLE `login_table` DISABLE KEYS */;
INSERT INTO `login_table` VALUES ('1000','1000');
/*!40000 ALTER TABLE `login_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major_table`
--

DROP TABLE IF EXISTS `major_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `major_table` (
  `MID` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major_table`
--

LOCK TABLES `major_table` WRITE;
/*!40000 ALTER TABLE `major_table` DISABLE KEYS */;
INSERT INTO `major_table` VALUES (1,'CS'),(2,'SE'),(3,'IS');
/*!40000 ALTER TABLE `major_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` int(11) NOT NULL,
  `q1` varchar(30) DEFAULT NULL,
  `q2` varchar(30) DEFAULT NULL,
  `q3` varchar(30) DEFAULT NULL,
  `q4` varchar(30) DEFAULT NULL,
  `q5` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'1','1','1','1','1'),(2,'1','1','1','1','1'),(3,'1','1','1','1','1'),(4,'1','1','1','1','1'),(5,'1','1','1','1','1'),(6,'1','1','1','1','1'),(7,'1','1','1','1','1');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `runoob_tbl`
--

DROP TABLE IF EXISTS `runoob_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `runoob_tbl` (
  `runoob_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `runoob_title` varchar(100) NOT NULL,
  `runoob_author` varchar(40) NOT NULL,
  `submission_date` date DEFAULT NULL,
  PRIMARY KEY (`runoob_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `runoob_tbl`
--

LOCK TABLES `runoob_tbl` WRITE;
/*!40000 ALTER TABLE `runoob_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `runoob_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stu_cour`
--

DROP TABLE IF EXISTS `stu_cour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stu_cour` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SID` varchar(45) DEFAULT NULL,
  `CID` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `SID` (`SID`),
  KEY `CID` (`CID`),
  CONSTRAINT `stu_cour_ibfk_1` FOREIGN KEY (`SID`) REFERENCES `stu_table` (`SID`),
  CONSTRAINT `stu_cour_ibfk_2` FOREIGN KEY (`CID`) REFERENCES `course_table` (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu_cour`
--

LOCK TABLES `stu_cour` WRITE;
/*!40000 ALTER TABLE `stu_cour` DISABLE KEYS */;
INSERT INTO `stu_cour` VALUES (3,'1000','1001'),(4,'1000','1002'),(5,'1000','1000');
/*!40000 ALTER TABLE `stu_cour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stu_table`
--

DROP TABLE IF EXISTS `stu_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stu_table` (
  `SID` varchar(45) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `photo` longblob,
  `MID` int(11) DEFAULT NULL,
  PRIMARY KEY (`SID`),
  KEY `MID` (`MID`),
  CONSTRAINT `stu_table_ibfk_1` FOREIGN KEY (`MID`) REFERENCES `major_table` (`MID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu_table`
--

LOCK TABLES `stu_table` WRITE;
/*!40000 ALTER TABLE `stu_table` DISABLE KEYS */;
INSERT INTO `stu_table` VALUES ('1000','Peter',0,'2000-04-05',40,'',NULL,1);
/*!40000 ALTER TABLE `stu_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t1`
--

DROP TABLE IF EXISTS `t1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t1`
--

LOCK TABLES `t1` WRITE;
/*!40000 ALTER TABLE `t1` DISABLE KEYS */;
INSERT INTO `t1` VALUES (1,'yzj');
/*!40000 ALTER TABLE `t1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(8) DEFAULT NULL,
  `pass` char(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (25,'yzj','1'),(26,'yzj2','2');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertable`
--

DROP TABLE IF EXISTS `usertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertable` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` char(8) DEFAULT NULL,
  `password` char(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertable`
--

LOCK TABLES `usertable` WRITE;
/*!40000 ALTER TABLE `usertable` DISABLE KEYS */;
INSERT INTO `usertable` VALUES (1,'yzj','1');
/*!40000 ALTER TABLE `usertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertablee`
--

DROP TABLE IF EXISTS `usertablee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertablee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertablee`
--

LOCK TABLES `usertablee` WRITE;
/*!40000 ALTER TABLE `usertablee` DISABLE KEYS */;
INSERT INTO `usertablee` VALUES (34,25,'2020-04-03 17:04:55','Yezhengjie',''),(35,25,'2020-04-03 17:09:43','sasasdasdasd',''),(36,25,'2020-04-03 17:09:47','sasas',''),(37,25,'2020-04-03 17:09:52','11111111111111',''),(38,25,'2020-04-03 17:09:55','',''),(39,25,'2020-04-03 17:10:02','qqq',''),(40,26,'2020-04-03 17:11:15','1111','111'),(41,25,'2020-04-09 20:10:18','1111','111');
/*!40000 ALTER TABLE `usertablee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xsb`
--

DROP TABLE IF EXISTS `xsb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `xsb` (
  `xh` char(6) NOT NULL DEFAULT '081102',
  `XM` char(8) DEFAULT NULL,
  `XB` tinyint(4) DEFAULT NULL,
  `CSSJ` date DEFAULT NULL,
  `ZY_ID` int(11) DEFAULT NULL,
  `ZXF` int(11) DEFAULT NULL,
  `BZ` varchar(500) DEFAULT NULL,
  `ZP` longblob,
  PRIMARY KEY (`xh`),
  KEY `xsbwj` (`ZY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xsb`
--

LOCK TABLES `xsb` WRITE;
/*!40000 ALTER TABLE `xsb` DISABLE KEYS */;
INSERT INTO `xsb` VALUES ('081102','yzj',1,'1999-02-28',1,50,'11',NULL);
/*!40000 ALTER TABLE `xsb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yzj-1`
--

DROP TABLE IF EXISTS `yzj-1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `yzj-1` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yzj-1`
--

LOCK TABLES `yzj-1` WRITE;
/*!40000 ALTER TABLE `yzj-1` DISABLE KEYS */;
INSERT INTO `yzj-1` VALUES (22,'22');
/*!40000 ALTER TABLE `yzj-1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zyb`
--

DROP TABLE IF EXISTS `zyb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zyb` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ZYM` char(12) DEFAULT NULL,
  `RS` int(11) DEFAULT NULL,
  `FDY` char(8) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zyb`
--

LOCK TABLES `zyb` WRITE;
/*!40000 ALTER TABLE `zyb` DISABLE KEYS */;
INSERT INTO `zyb` VALUES (1,'computer',150,'huang'),(2,'tongxin',131,'hong');
/*!40000 ALTER TABLE `zyb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-30 20:46:16
