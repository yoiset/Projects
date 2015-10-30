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
-- Table structure for table `Res_Agente_Mes`
--

DROP TABLE IF EXISTS `Res_Agente_Mes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Res_Agente_Mes` (
  `Agentes_id` int(11) NOT NULL,
  `Ej_Fiscal_id` tinyint(4) NOT NULL,
  `mes` tinyint(4) NOT NULL,
  `Ptos` tinyint(4) NOT NULL COMMENT 'Suma de los puntos semanales\\n',
  `Calidad` smallint(6) NOT NULL,
  `Convergencia` smallint(6) NOT NULL,
  `Revelacion` tinyint(1) NOT NULL,
  PRIMARY KEY  (`Agentes_id`,`Ej_Fiscal_id`,`mes`),
  KEY `fk_Res_Agente_Mes_Ej_Fiscal1_idx` (`Ej_Fiscal_id`),
  CONSTRAINT `fk_Res_Mes_Agente_Agentes1` FOREIGN KEY (`Agentes_id`) REFERENCES `Agentes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Res_Agente_Mes_Ej_Fiscal1` FOREIGN KEY (`Ej_Fiscal_id`) REFERENCES `Ej_Fiscal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Res_Agente_Mes`
--

LOCK TABLES `Res_Agente_Mes` WRITE;
/*!40000 ALTER TABLE `Res_Agente_Mes` DISABLE KEYS */;
/*!40000 ALTER TABLE `Res_Agente_Mes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-08-02 19:19:25
