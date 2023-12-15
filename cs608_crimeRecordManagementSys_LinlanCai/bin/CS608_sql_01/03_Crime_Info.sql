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
-- Table structure for table `Crime_Info`
--

DROP TABLE IF EXISTS `Crime_Info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Crime_Info` (
  `Crime_id` varchar(20) NOT NULL,
  `Crime_type` varchar(100) NOT NULL,
  `Weapon_used` varchar(200) DEFAULT NULL,
  `Crime_date` date NOT NULL,
  `Crime_time` timestamp NOT NULL,
  `Crime_location` varchar(200) NOT NULL,
  `Criminal_id` varchar(20) NOT NULL,
  `Victim_id` varchar(10) NOT NULL,
  `Crime_description` text,
  PRIMARY KEY (`Crime_id`),
  KEY `Criminal_id` (`Criminal_id`),
  KEY `Victim_id` (`Victim_id`),
  CONSTRAINT `crime_info_ibfk_1` FOREIGN KEY (`Criminal_id`) REFERENCES `Offender_Info` (`Criminal_id`),
  CONSTRAINT `crime_info_ibfk_2` FOREIGN KEY (`Victim_id`) REFERENCES `Offender_Info` (`Victim_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Crime_Info`
--

LOCK TABLES `Crime_Info` WRITE;
/*!40000 ALTER TABLE `Crime_Info` DISABLE KEYS */;
INSERT INTO `Crime_Info` VALUES ('CRCRIM001','Robbery','Knife','2023-11-20','2023-11-20 19:30:00','123 Main St, Cityville, CA','CRIM002','VICT001','A robbery occurred at a convenience store.'),('CRCRIM002','Assault',NULL,'2023-11-21','2023-11-21 15:45:00','456 Elm St, Townsville, NY','CRIM003','VICT002','An assault took place near the park.'),('CRCRIM003','Burglary','Crowbar','2023-11-22','2023-11-22 23:15:00','789 Oak St, Villageton, TX','CRIM004','VICT003','A burglary occurred at a residential property.'),('CRCRIM004','Homicide','Firearm','2023-11-23','2023-11-24 03:00:00','101 Pine St, Hamletville, FL','CRIM005','VICT004','A homicide took place at a local bar.'),('CRCRIM005','Kidnapping','Vehicle','2023-11-24','2023-11-24 21:30:00','202 Cedar St, Mountain City, WA','CRIM006','VICT005','A kidnapping incident involving a vehicle.'),('CRCRIM006','Arson','Gasoline','2023-11-25','2023-11-25 08:00:00','303 Birch St, Lakeside, OR','CRIM007','VICT006','An arson attack at a commercial property.'),('CRCRIM007','Fraud',NULL,'2023-11-26','2023-11-26 14:00:00','404 Redwood St, Riverside, NJ','CRIM008','VICT007','A fraud case involving financial transactions.'),('CRCRIM008','Drug Possession','Cocaine','2023-11-27','2023-11-27 19:15:00','505 Willow St, Beachtown, NC','CRIM009','VICT008','A drug possession incident with cocaine.'),('CRCRIM009','Vandalism','Graffiti','2023-11-28','2023-11-28 16:30:00','606 Aspen St, Forestville, MI','CRIM010','VICT009','A vandalism case with graffiti.'),('CRCRIM010','Shoplifting',NULL,'2023-11-29','2023-11-29 22:45:00','707 Maple St, Summitville, GA','CRIM001','VICT010','A shoplifting incident at a local store.');
/*!40000 ALTER TABLE `Crime_Info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-15  0:44:19
