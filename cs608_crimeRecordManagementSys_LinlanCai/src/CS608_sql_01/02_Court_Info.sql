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
-- Table structure for table `Court_Info`
--

DROP TABLE IF EXISTS `Court_Info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Court_Info` (
  `Court_id` varchar(20) NOT NULL,
  `Court_name` varchar(100) NOT NULL,
  `Court_address` varchar(500) NOT NULL,
  `Court_level` varchar(100) NOT NULL,
  PRIMARY KEY (`Court_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Court_Info`
--

LOCK TABLES `Court_Info` WRITE;
/*!40000 ALTER TABLE `Court_Info` DISABLE KEYS */;
INSERT INTO `Court_Info` VALUES ('COURT001','Sample Court 1','123 Main Street, City1','District Court'),('COURT002','Sample Court 2','456 Elm Street, City2','County Court'),('COURT003','Sample Court 3','789 Oak Street, City3','Supreme Court'),('COURT004','Sample Court 4','101 Pine Street, City4','Family Court'),('COURT005','Sample Court 5','202 Maple Street, City5','Municipal Court'),('COURT006','Sample Court 6','303 Birch Street, City6','District Court'),('COURT007','Sample Court 7','404 Cedar Street, City7','County Court'),('COURT008','Sample Court 8','505 Willow Street, City8','Supreme Court'),('COURT009','Sample Court 9','606 Redwood Street, City9','Family Court'),('COURT010','Sample Court 10','707 Sequoia Street, City10','Municipal Court');
/*!40000 ALTER TABLE `Court_Info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-15  0:43:51
