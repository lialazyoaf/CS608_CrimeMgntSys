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
-- Table structure for table `Guard_Info`
--

DROP TABLE IF EXISTS `Guard_Info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Guard_Info` (
  `Guard_id` varchar(20) NOT NULL,
  `First_name` varchar(20) NOT NULL,
  `Last_name` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `DOB` date NOT NULL,
  `Age` int NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Phone_no` varchar(20) NOT NULL,
  `Alternate_phone_no` varchar(20) DEFAULT NULL,
  `Shift_timing` varchar(20) NOT NULL,
  `Position` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Guard_Info`
--

LOCK TABLES `Guard_Info` WRITE;
/*!40000 ALTER TABLE `Guard_Info` DISABLE KEYS */;
INSERT INTO `Guard_Info` VALUES ('GUARD001','John','Doe','Male','1990-03-15',30,'123 Main St','555-123-4567',NULL,'Day Shift','Security Officer'),('GUARD002','Jane','Smith','Female','1992-07-21',29,'456 Elm St','555-987-6543',NULL,'Night Shift','Security Officer'),('GUARD003','Robert','Johnson','Male','1985-12-10',36,'789 Oak St','555-111-2222',NULL,'Day Shift','Senior Security Officer'),('GUARD004','Mary','Williams','Female','1988-05-03',33,'567 Pine St','555-444-5555',NULL,'Night Shift','Security Officer'),('GUARD005','Michael','Brown','Male','1994-09-28',27,'890 Cedar St','555-777-8888',NULL,'Day Shift','Security Officer'),('GUARD006','Emily','Davis','Female','1991-02-19',30,'234 Birch St','555-222-3333',NULL,'Night Shift','Security Officer'),('GUARD007','William','Anderson','Male','1987-06-25',34,'456 Oak St','555-888-9999',NULL,'Day Shift','Senior Security Officer'),('GUARD008','Olivia','Martinez','Female','1989-11-08',32,'345 Maple St','555-666-7777',NULL,'Night Shift','Security Officer'),('GUARD009','David','Garcia','Male','1993-04-14',28,'678 Redwood St','555-333-4444',NULL,'Day Shift','Security Officer'),('GUARD010','Sophia','Rodriguez','Female','1996-08-02',25,'789 Cedar St','555-999-1111',NULL,'Night Shift','Security Officer');
/*!40000 ALTER TABLE `Guard_Info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-15  0:45:26
