-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tcd_db
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `t_attribute`
--

DROP TABLE IF EXISTS `t_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_attribute` (
  `ID_ATTRIBUTE` int(11) NOT NULL AUTO_INCREMENT,
  `ATTRIBUTE_NAME` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_ATTRIBUTE`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Tabella degli Attributi';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_attribute`
--

LOCK TABLES `t_attribute` WRITE;
/*!40000 ALTER TABLE `t_attribute` DISABLE KEYS */;
INSERT INTO `t_attribute` VALUES (1,'Strenght'),(2,'Agility'),(3,'Toughness'),(4,'Mind');
/*!40000 ALTER TABLE `t_attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_characters`
--

DROP TABLE IF EXISTS `t_characters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_characters` (
  `CHARACTERS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID del personaggio (PK)',
  `CHARACTER_NAME` varchar(45) NOT NULL COMMENT 'Nome del personaggio',
  `CHARACTER_ROLE` int(11) NOT NULL COMMENT 'Ruolo del personaggio (FK)',
  `CHARACTER_USER` int(11) NOT NULL,
  PRIMARY KEY (`CHARACTERS_ID`),
  KEY `ROLE_idx` (`CHARACTER_ROLE`),
  KEY `CHARACTER_USER_idx` (`CHARACTER_USER`),
  CONSTRAINT `CHARACTER_ROLE` FOREIGN KEY (`CHARACTER_ROLE`) REFERENCES `t_role` (`ID_ROLE`),
  CONSTRAINT `CHARACTER_USER` FOREIGN KEY (`CHARACTER_USER`) REFERENCES `t_users` (`ID_USER`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Tabella dei personaggi';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_characters`
--

LOCK TABLES `t_characters` WRITE;
/*!40000 ALTER TABLE `t_characters` DISABLE KEYS */;
INSERT INTO `t_characters` VALUES (1,'Dalvert',2,1),(2,'Regrell',1,1),(3,'Glaria',1,2);
/*!40000 ALTER TABLE `t_characters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `ID_ROLE` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id del Ruolo (PK)',
  `ROLE_NAME` varchar(45) NOT NULL COMMENT 'Nome del ruolo',
  `ROLE_DESC` text COMMENT 'Descrizione del ruolo',
  `SECONDARY_ATTRIBUTE` int(11) NOT NULL COMMENT 'Attributo Secondario (FK)',
  `PRIMARY_ATTRIBUTE` int(11) NOT NULL COMMENT 'Attributo Primario (FK)',
  PRIMARY KEY (`ID_ROLE`),
  KEY `PRIMARY_ATTRIBUTE_idx` (`PRIMARY_ATTRIBUTE`),
  CONSTRAINT `PRIMARY_ATTRIBUTE` FOREIGN KEY (`PRIMARY_ATTRIBUTE`) REFERENCES `t_attribute` (`ID_ATTRIBUTE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SECONDARY_ATTRIBUET` FOREIGN KEY (`PRIMARY_ATTRIBUTE`) REFERENCES `t_attribute` (`ID_ATTRIBUTE`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Tabella dei Ruoli';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'role.fighter.name','role.fighter.desc',1,3),(2,'role.cleric.name','role.cleric.desc',4,3);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_skill`
--

DROP TABLE IF EXISTS `t_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_skill` (
  `ID_SKILL` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id dell''Abilita (PK)',
  `SKILL_NAME` varchar(45) NOT NULL COMMENT 'Nome dell'' Abilita',
  `SKILL_DESC` text NOT NULL COMMENT 'Descrizione dell'' Abilita',
  `SKILL_LEVEL` int(11) NOT NULL COMMENT 'Livello a cui si ottiene la Skill (se 0 e un Abilita di riposo)',
  `SKILL_ROLE` int(11) NOT NULL COMMENT 'Ruolo a cui e associata l''abilita',
  PRIMARY KEY (`ID_SKILL`),
  KEY `ROLE_idx` (`SKILL_ROLE`),
  CONSTRAINT `ROLE` FOREIGN KEY (`SKILL_ROLE`) REFERENCES `t_role` (`ID_ROLE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Tabella delle Abilita';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_skill`
--

LOCK TABLES `t_skill` WRITE;
/*!40000 ALTER TABLE `t_skill` DISABLE KEYS */;
INSERT INTO `t_skill` VALUES (1,'Prayer','D',0,2),(2,'Second Wind','D',0,1);
/*!40000 ALTER TABLE `t_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_users`
--

DROP TABLE IF EXISTS `t_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_users` (
  `ID_USER` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID utente',
  `USER_NAME` varchar(32) NOT NULL COMMENT 'Nome dell''utente',
  `USER_PASSWORD` varchar(16) NOT NULL COMMENT 'Password dell''utente',
  PRIMARY KEY (`ID_USER`),
  UNIQUE KEY `USER_NAME_UNIQUE` (`USER_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Tabella delle utenze';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_users`
--

LOCK TABLES `t_users` WRITE;
/*!40000 ALTER TABLE `t_users` DISABLE KEYS */;
INSERT INTO `t_users` VALUES (1,'Prova','170690'),(2,'Prova2','170690');
/*!40000 ALTER TABLE `t_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-21 12:08:29
