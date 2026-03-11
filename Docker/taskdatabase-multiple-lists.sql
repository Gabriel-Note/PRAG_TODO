-- MySQL dump
--
-- Host: localhost    Database: localdb
-- ------------------------------------------------------

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
-- Skapa databasen om den inte finns
--

CREATE DATABASE IF NOT EXISTS `localdb`;
USE `localdb`;

--
-- Table structure for table `task_list`
-- Måste skapas före `task` pga foreign key
--

DROP TABLE IF EXISTS `task`;
DROP TABLE IF EXISTS `task_list`;

CREATE TABLE `task_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Exempeldata för task_list
--

LOCK TABLES `task_list` WRITE;
INSERT INTO `task_list` VALUES (1,'Min lista');
UNLOCK TABLES;

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `completed` tinyint(1) NOT NULL DEFAULT '0',
  `task_list_id` int,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`task_list_id`) REFERENCES `task_list`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Exempeldata för task
--

LOCK TABLES `task` WRITE;
INSERT INTO `task` VALUES (1,'ut med hunden',1,1),(2,'handla marmelad',0,1),(3,'Städa köket',0,1),(4,'köpa te från CityGross',0,1),(5,'köpa mer te från CityGross',0,1),(6,'köpa mjölk från ica',0,1),(7,'köpa mjöl',0,1),(8,'postwoman',0,1);
UNLOCK TABLES;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed
