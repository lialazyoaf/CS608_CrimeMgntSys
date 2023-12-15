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
-- Table structure for table `Victim_Info`
--

DROP TABLE IF EXISTS `Victim_Info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Victim_Info` (
  `Victim_id` varchar(20) NOT NULL,
  `First_name` varchar(50) NOT NULL,
  `Last_name` varchar(50) NOT NULL,
  `Age` int DEFAULT NULL,
  `Nationality` varchar(50) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Phone_no` varchar(20) NOT NULL,
  `Alternate_phone_no` varchar(20) DEFAULT NULL,
  `Judge_id` varchar(10) NOT NULL,
  `Court_id` varchar(20) NOT NULL,
  PRIMARY KEY (`Victim_id`),
  KEY `Judge_id` (`Judge_id`),
  KEY `Court_id` (`Court_id`),
  CONSTRAINT `victim_info_ibfk_1` FOREIGN KEY (`Judge_id`) REFERENCES `Judge_Info` (`Judge_id`),
  CONSTRAINT `victim_info_ibfk_2` FOREIGN KEY (`Court_id`) REFERENCES `Court_Info` (`Court_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Victim_Info`
--

LOCK TABLES `Victim_Info` WRITE;
/*!40000 ALTER TABLE `Victim_Info` DISABLE KEYS */;
INSERT INTO `Victim_Info` VALUES ('VIC001','Alice','Smith',35,'USA','123 Main St, Cityville, CA','555-1234','555-5678','JUDGE001','COURT001'),('VIC002','Bob','Johnson',42,'USA','456 Elm St, Townsville, NY','555-5678',NULL,'JUDGE002','COURT002'),('VIC003','Charlie','Wilson',28,'USA','789 Oak St, Villageton, TX','555-6789',NULL,'JUDGE003','COURT003'),('VIC004','David','Clark',50,'USA','101 Pine St, Hamletville, FL','555-7890','555-1234','JUDGE004','COURT004'),('VIC005','Eva','Adams',47,'USA','202 Cedar St, Mountain City, WA','555-8901',NULL,'JUDGE005','COURT005'),('VIC006','Frank','Brown',33,'USA','303 Birch St, Lakeside, OR','555-9012','555-5678','JUDGE006','COURT006'),('VIC007','Grace','Lee',38,'USA','404 Redwood St, Riverside, NJ','555-0123',NULL,'JUDGE007','COURT007'),('VIC008','Hank','Martin',27,'USA','505 Willow St, Beachtown, NC','555-1234','555-7890','JUDGE008','COURT008'),('VIC009','Ivy','Wright',45,'USA','606 Aspen St, Forestville, MI','555-2345',NULL,'JUDGE009','COURT009'),('VIC010','Jack','Hall',31,'USA','707 Maple St, Summitville, GA','555-3456',NULL,'JUDGE010','COURT010');
/*!40000 ALTER TABLE `Victim_Info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-15  0:47:35
