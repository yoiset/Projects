CREATE DATABASE  IF NOT EXISTS `web_red_VF` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `web_red_VF`;
-- MySQL dump 10.13  Distrib 5.1.70, for debian-linux-gnu (x86_64)
--
-- Host: 192.168.1.150    Database: web_red_VF
-- ------------------------------------------------------
-- Server version	5.0.77-log

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `Parametros`
--

DROP TABLE IF EXISTS `Parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Parametros` (
  `id` int(11) NOT NULL,
  `Q1_inf` tinyint(4) NOT NULL,
  `Q1_sup` tinyint(4) NOT NULL,
  `Q2_inf` tinyint(4) NOT NULL,
  `Q2_sup` tinyint(4) NOT NULL,
  `Q3_inf` tinyint(4) NOT NULL,
  `Q3_sup` tinyint(4) NOT NULL,
  `Calidad_mes_lim` tinyint(4) NOT NULL,
  `Calidad_mes_ventas_min` tinyint(4) NOT NULL,
  `Convergencia_mes_lim` tinyint(4) NOT NULL,
  `Convergencia_mes_ventas_min` tinyint(4) NOT NULL,
  `Calidad_P_lim` tinyint(4) NOT NULL,
  `Calidad_P_ventas_min` tinyint(4) NOT NULL,
  `Convergencia_P_ventas_min` tinyint(4) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Parametros`
--

LOCK TABLES `Parametros` WRITE;
/*!40000 ALTER TABLE `Parametros` DISABLE KEYS */;
INSERT INTO `Parametros` VALUES (1,90,105,8,8,5,10,10,10,20,10,5,20,5);
/*!40000 ALTER TABLE `Parametros` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-08-02 14:44:20
