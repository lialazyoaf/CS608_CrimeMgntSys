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
-- Table structure for table `Judge_Info`
--

DROP TABLE IF EXISTS `Judge_Info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Judge_Info` (
  `Judge_id` varchar(10) NOT NULL,
  `Judge_age` int NOT NULL,
  `First_name` varchar(20) NOT NULL,
  `Last_name` varchar(20) DEFAULT NULL,
  `Designation` varchar(50) NOT NULL,
  `Court_id` varchar(20) NOT NULL,
  PRIMARY KEY (`Judge_id`),
  KEY `Court_id` (`Court_id`),
  CONSTRAINT `judge_info_ibfk_1` FOREIGN KEY (`Court_id`) REFERENCES `Court_Info` (`Court_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Judge_Info`
--

LOCK TABLES `Judge_Info` WRITE;
/*!40000 ALTER TABLE `Judge_Info` DISABLE KEYS */;
INSERT INTO `Judge_Info` VALUES ('JUDGE001',55,'John','Smith','Chief Judge','COURT001'),('JUDGE002',48,'Jane','Doe','Associate Judge','COURT002'),('JUDGE003',52,'Robert','Johnson','Senior Judge','COURT003'),('JUDGE004',45,'Mary','Williams','Presiding Judge','COURT004'),('JUDGE005',58,'Michael','Brown','Chief Judge','COURT005'),('JUDGE006',51,'Emily','Davis','Associate Judge','COURT006'),('JUDGE007',47,'William','Anderson','Senior Judge','COURT007'),('JUDGE008',53,'Olivia','Martinez','Presiding Judge','COURT008'),('JUDGE009',49,'David','Garcia','Chief Judge','COURT009'),('JUDGE010',56,'Sophia','Rodriguez','Associate Judge','COURT010');
/*!40000 ALTER TABLE `Judge_Info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-15  0:45:55
