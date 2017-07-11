CREATE DATABASE  IF NOT EXISTS `foodapp` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `foodApp`;
-- MySQL dump 10.13  Distrib 5.6.17, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: foodApp
-- ------------------------------------------------------
-- Server version	5.5.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admintable`
--

DROP TABLE IF EXISTS `admintable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admintable` (
  `email` varchar(255) DEFAULT NULL,
  `personID` bigint(20) NOT NULL,
  PRIMARY KEY (`personID`),
  KEY `FK2A22F1DF7220F4F1` (`personID`),
  CONSTRAINT `FK2A22F1DF7220F4F1` FOREIGN KEY (`personID`) REFERENCES `userAccounttable` (`personID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admintable`
--

LOCK TABLES `admintable` WRITE;
/*!40000 ALTER TABLE `admintable` DISABLE KEYS */;
INSERT INTO `admintable` VALUES ('admin@g.com',3);
/*!40000 ALTER TABLE `admintable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheftable`
--

DROP TABLE IF EXISTS `cheftable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheftable` (
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `speciality` varchar(255) DEFAULT NULL,
  `personID` bigint(20) NOT NULL,
  PRIMARY KEY (`personID`),
  KEY `FK1D6513C87220F4F1` (`personID`),
  CONSTRAINT `FK1D6513C87220F4F1` FOREIGN KEY (`personID`) REFERENCES `userAccounttable` (`personID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheftable`
--

LOCK TABLES `cheftable` WRITE;
/*!40000 ALTER TABLE `cheftable` DISABLE KEYS */;
INSERT INTO `cheftable` VALUES ('s@gmail.com','redwoods',1111220,'indian',2);
/*!40000 ALTER TABLE `cheftable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuisinetable`
--

DROP TABLE IF EXISTS `cuisinetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuisinetable` (
  `cuisineid` bigint(20) NOT NULL AUTO_INCREMENT,
  `cuisine_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cuisineid`),
  UNIQUE KEY `cuisineid` (`cuisineid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuisinetable`
--

LOCK TABLES `cuisinetable` WRITE;
/*!40000 ALTER TABLE `cuisinetable` DISABLE KEYS */;
INSERT INTO `cuisinetable` VALUES (1,'indian'),(2,'chinese');
/*!40000 ALTER TABLE `cuisinetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customertable`
--

DROP TABLE IF EXISTS `customertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customertable` (
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `personID` bigint(20) NOT NULL,
  PRIMARY KEY (`personID`),
  KEY `FK8159F6B07220F4F1` (`personID`),
  CONSTRAINT `FK8159F6B07220F4F1` FOREIGN KEY (`personID`) REFERENCES `userAccounttable` (`personID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customertable`
--

LOCK TABLES `customertable` WRITE;
/*!40000 ALTER TABLE `customertable` DISABLE KEYS */;
INSERT INTO `customertable` VALUES ('vegashetty@gmail.com','75 Saint Alphonsus Street',1121120,1),('riti@gmail.com','75 Saint Alphonsus Street',111212120,4),('chitra@gmail.om','75 Saint Alphonsus Street',0,5),('neha@gmail.com','mulund',1121220,6);
/*!40000 ALTER TABLE `customertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderDetailsTable`
--

DROP TABLE IF EXISTS `orderDetailsTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderDetailsTable` (
  `orderDetailsId` bigint(20) NOT NULL AUTO_INCREMENT,
  `orderid` bigint(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `recipeid` bigint(20) DEFAULT NULL,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`orderDetailsId`),
  UNIQUE KEY `orderDetailsId` (`orderDetailsId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderDetailsTable`
--

LOCK TABLES `orderDetailsTable` WRITE;
/*!40000 ALTER TABLE `orderDetailsTable` DISABLE KEYS */;
INSERT INTO `orderDetailsTable` VALUES (1,1,1220,1,2440),(2,1,1220,1,2440),(3,2,1220,1,1220),(4,3,1220,1,1220),(5,4,1220,1,1220),(6,5,1220,1,1220),(7,6,1220,1,1220),(8,7,1220,1,1220),(9,8,1320,1,3960),(10,8,1320,1,3960),(11,8,1320,1,3960);
/*!40000 ALTER TABLE `orderDetailsTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordertable`
--

DROP TABLE IF EXISTS `ordertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordertable` (
  `orderid` bigint(20) NOT NULL AUTO_INCREMENT,
  `customerId` bigint(20) DEFAULT NULL,
  `orderDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  UNIQUE KEY `orderid` (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordertable`
--

LOCK TABLES `ordertable` WRITE;
/*!40000 ALTER TABLE `ordertable` DISABLE KEYS */;
INSERT INTO `ordertable` VALUES (1,1,'2016/04/26 02:33:08'),(2,4,'2016/04/26 03:04:39'),(3,1,'2016/04/26 03:20:59'),(4,4,'2016/04/26 03:24:20'),(5,4,'2016/04/26 03:26:41'),(6,4,'2016/04/26 03:31:47'),(7,4,'2016/04/26 03:32:15'),(8,1,'2016/04/26 04:34:09');
/*!40000 ALTER TABLE `ordertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `personID` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`personID`),
  UNIQUE KEY `personID` (`personID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'vega','shetty'),(2,'sanjeev','kapoor'),(3,'admin','admin'),(4,'Ritika','Shetty'),(5,'chitra','shetty'),(6,'neha','nayak');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipetable`
--

DROP TABLE IF EXISTS `recipetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipetable` (
  `recipeid` bigint(20) NOT NULL AUTO_INCREMENT,
  `approvedStatus` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `distanceDelivery` float DEFAULT NULL,
  `photoName` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `recipeName` varchar(255) DEFAULT NULL,
  `chef` bigint(20) DEFAULT NULL,
  `cuisineid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`recipeid`),
  UNIQUE KEY `recipeid` (`recipeid`),
  KEY `FK78472F004EFE928D` (`chef`),
  KEY `FK78472F00E217D002` (`cuisineid`),
  CONSTRAINT `FK78472F00E217D002` FOREIGN KEY (`cuisineid`) REFERENCES `cuisinetable` (`cuisineid`),
  CONSTRAINT `FK78472F004EFE928D` FOREIGN KEY (`chef`) REFERENCES `cheftable` (`personID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipetable`
--

LOCK TABLES `recipetable` WRITE;
/*!40000 ALTER TABLE `recipetable` DISABLE KEYS */;
INSERT INTO `recipetable` VALUES (1,'','Cottage cheese wd curry',5,'/spring/1461650793175pan.jpg',1320,'paneer makhanwala',2,1),(2,'','chickn gravy',10,'/spring/1461650911795butter.jpg',200,'Butter chicken',2,1),(3,'','Schezwan noodles',10,'/spring/1461659861211ls.jpg',1210,'Noodles',2,2);
/*!40000 ALTER TABLE `recipetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userAccounttable`
--

DROP TABLE IF EXISTS `userAccounttable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userAccounttable` (
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `personID` bigint(20) NOT NULL,
  PRIMARY KEY (`personID`),
  KEY `FK140CED2CB407146` (`personID`),
  CONSTRAINT `FK140CED2CB407146` FOREIGN KEY (`personID`) REFERENCES `person` (`personID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userAccounttable`
--

LOCK TABLES `userAccounttable` WRITE;
/*!40000 ALTER TABLE `userAccounttable` DISABLE KEYS */;
INSERT INTO `userAccounttable` VALUES ('shetty','customer','vega',1),('kapoor','chef','sanjeev',2),('admin','admin','admin',3),('shetty','customer','ritika',4),('shetty','customer','chitra',5),('nayak20','customer','neha',6);
/*!40000 ALTER TABLE `userAccounttable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-26  4:47:14
