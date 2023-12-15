-- MySQL dump 10.13  Distrib 8.1.0, for macos13.3 (x86_64)
--
-- Host: localhost    Database: Crime_Record_Management
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `Punishment_Info`
--

DROP TABLE IF EXISTS `Punishment_Info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Punishment_Info` (
  `punishment_id` varchar(10) NOT NULL,
  `From_date` date NOT NULL,
  `From_time` timestamp NOT NULL,
  `To_date` date NOT NULL,
  `To_time` timestamp NOT NULL,
  `Total_duration` varchar(50) NOT NULL,
  `Type_punishment` varchar(200) NOT NULL,
  `Punishment_des` varchar(200) DEFAULT NULL,
  `Punishment_inc` varchar(20) NOT NULL,
  `Reason_punishment_inc` varchar(250) DEFAULT NULL,
  `Criminal_id` varchar(10) NOT NULL,
  `Prison_id` varchar(20) NOT NULL,
  `Judge_id` varchar(10) NOT NULL,
  `Crime_id` varchar(20) NOT NULL,
  PRIMARY KEY (`punishment_id`),
  KEY `Criminal_id` (`Criminal_id`),
  KEY `Judge_id` (`Judge_id`),
  KEY `Crime_id` (`Crime_id`),
  CONSTRAINT `punishment_info_ibfk_1` FOREIGN KEY (`Criminal_id`) REFERENCES `Offender_Info` (`Criminal_id`),
  CONSTRAINT `punishment_info_ibfk_2` FOREIGN KEY (`Judge_id`) REFERENCES `Judge_Info` (`Judge_id`),
  CONSTRAINT `punishment_info_ibfk_3` FOREIGN KEY (`Crime_id`) REFERENCES `Crime_Info` (`Crime_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Punishment_Info`
--

LOCK TABLES `Punishment_Info` WRITE;
/*!40000 ALTER TABLE `Punishment_Info` DISABLE KEYS */;
INSERT INTO `Punishment_Info` VALUES ('PUN001','2023-11-15','2023-11-15 19:30:00','2023-11-20','2023-11-20 19:30:00','5 days','Imprisonment','Short-term imprisonment','Guilty','Robbery','CRIM001','PRISON001','JUDGE001','CRCRIM001'),('PUN002','2023-11-16','2023-11-16 14:45:00','2023-11-19','2023-11-19 14:45:00','3 days','Imprisonment','Short-term imprisonment','Guilty','Burglary','CRIM002','PRISON002','JUDGE002','CRCRIM002'),('PUN003','2023-11-17','2023-11-18 00:15:00','2023-11-25','2023-11-26 00:15:00','8 days','Imprisonment','Short-term imprisonment','Guilty','Assault','CRIM003','PRISON003','JUDGE003','CRCRIM003'),('PUN004','2023-11-18','2023-11-18 21:20:00','2023-11-23','2023-11-23 21:20:00','5 days','Imprisonment','Short-term imprisonment','Guilty','Forgery','CRIM004','PRISON004','JUDGE004','CRCRIM004'),('PUN005','2023-11-19','2023-11-19 16:10:00','2023-11-24','2023-11-24 16:10:00','5 days','Imprisonment','Short-term imprisonment','Guilty','Drug Possession','CRIM005','PRISON005','JUDGE005','CRCRIM005'),('PUN006','2023-11-20','2023-11-20 13:05:00','2023-11-25','2023-11-25 13:05:00','5 days','Imprisonment','Short-term imprisonment','Guilty','Theft','CRIM006','PRISON006','JUDGE006','CRCRIM006'),('PUN007','2023-11-21','2023-11-22 03:30:00','2023-11-30','2023-12-01 03:30:00','9 days','Imprisonment','Short-term imprisonment','Guilty','Vandalism','CRIM007','PRISON007','JUDGE007','CRCRIM007'),('PUN008','2023-11-22','2023-11-22 20:40:00','2023-11-30','2023-11-30 20:40:00','8 days','Imprisonment','Short-term imprisonment','Guilty','Fraud','CRIM008','PRISON008','JUDGE008','CRCRIM008'),('PUN009','2023-11-23','2023-11-23 18:55:00','2023-12-02','2023-12-02 18:55:00','9 days','Imprisonment','Short-term imprisonment','Guilty','Kidnapping','CRIM009','PRISON009','JUDGE009','CRCRIM009'),('PUN010','2023-11-24','2023-11-24 23:00:00','2023-12-03','2023-12-03 23:00:00','9 days','Imprisonment','Short-term imprisonment','Guilty','Homicide','CRIM010','PRISON010','JUDGE010','CRCRIM010');
/*!40000 ALTER TABLE `Punishment_Info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-15  0:47:13
