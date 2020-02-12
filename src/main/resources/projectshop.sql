-- MySQL dump 10.13  Distrib 5.7.27, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	5.7.27-log

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
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id_goods` bigint(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(45) NOT NULL,
  `goods_price` double DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `goods_image` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_goods`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`id_goods`, `goods_name`, `goods_price`, `description`, `country`, `goods_image`) VALUES (5,'Bactericidal patch',1.87,'Bactericidal antibiotics kill bacteria','Belarus','plastyr'),(7,'hydrogen peroxide',1.9,'H2O2','India','hydrogen'),(8,'iodine',0.84,'I2','Syria','iodine'),(9,'water',0.4,'H2O','Ukraine','water'),(10,'ibuprofen',2.4,'painkil','Belarus','ibuprofen');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `indent`
--

DROP TABLE IF EXISTS `indent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `indent` (
  `id_indent` bigint(11) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(11) NOT NULL,
  `id_goods` bigint(11) NOT NULL,
  `indent_status` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_indent`),
  KEY `id_user__idx` (`id_user`),
  KEY `id_goods__idx` (`id_goods`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indent`
--

LOCK TABLES `indent` WRITE;
/*!40000 ALTER TABLE `indent` DISABLE KEYS */;
INSERT INTO `indent` (`id_indent`, `id_user`, `id_goods`, `indent_status`) VALUES (5,30,5,0),(6,30,9,0),(7,30,5,0),(8,30,5,0),(9,31,5,1),(10,31,7,1),(11,31,10,1),(12,34,5,1),(13,34,7,1),(14,34,10,1),(15,34,10,1),(16,34,5,1),(17,30,5,0),(18,30,5,0),(19,30,9,0),(20,30,5,0),(21,30,5,0),(22,30,7,0),(23,22,7,0),(24,22,9,0),(25,30,8,0),(26,30,9,0),(27,35,5,0),(28,35,7,0),(29,35,8,0),(30,35,10,0),(31,30,5,0),(32,36,8,0),(33,36,9,0),(34,22,5,0),(35,22,5,0),(36,22,9,1),(37,39,7,0),(38,39,7,0),(39,39,5,0),(40,44,5,0),(41,44,7,0),(42,44,10,0),(43,44,8,0),(44,44,7,0),(45,44,5,0),(46,44,5,0),(47,44,5,0),(48,44,5,0),(49,44,5,0),(50,45,5,0),(51,51,5,0),(52,51,8,0),(53,51,7,0),(54,51,9,1),(55,51,9,1),(56,51,9,1),(57,51,9,1),(58,51,9,1);
/*!40000 ALTER TABLE `indent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `login` varchar(45) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `salt` varchar(45) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `id_user_UNIQUE` (`id_user`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id_user`, `name`, `login`, `age`, `email`, `password`, `salt`) VALUES (50,'kim','kim',19,'ilya@part.1','1FMw0DBLMMQFUepItHQSfFuaMCt9Ou4ToN2z9Lo8xDU=','RdwdwcNayGLlQcaoZbtTITwGDx5TEj'),(51,'Boroda CHCHCH','boroda',19,'BorodA@tut.ue','6Ny6MYniseUYc0uWaiSWk239p9oMLusgx9NPxRO5l34=','r4ydKkRhtIpCGTX88enHMfQdn7oiHV');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-13  1:30:23
