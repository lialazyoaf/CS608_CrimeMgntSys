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
-- Table structure for table `Offender_Info`
--

DROP TABLE IF EXISTS `Offender_Info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Offender_Info` (
  `Criminal_id` varchar(10) NOT NULL,
  `First_name` varchar(20) NOT NULL,
  `Last_name` varchar(20) DEFAULT NULL,
  `Gender` varchar(20) NOT NULL,
  `Age` varchar(20) NOT NULL,
  `Nationality` varchar(50) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `Phone_no` varchar(20) NOT NULL,
  `Alternate_phone_no` varchar(20) DEFAULT NULL,
  `Offense_type` varchar(200) NOT NULL,
  `Bail_status` varchar(20) NOT NULL,
  `Jail_terms` varchar(50) NOT NULL,
  `Prison_location` varchar(50) NOT NULL,
  `Prison_guard` varchar(50) NOT NULL,
  `Victim_id` varchar(20) NOT NULL,
  `Judge_id` varchar(10) NOT NULL,
  `Court_id` varchar(20) NOT NULL,
  PRIMARY KEY (`Criminal_id`),
  KEY `idx_Criminal_id` (`Criminal_id`),
  KEY `idx_Victim_id` (`Victim_id`),
  KEY `FK_Judge_Info` (`Judge_id`),
  KEY `FK_Court_Info` (`Court_id`),
  CONSTRAINT `FK_Court_Info` FOREIGN KEY (`Court_id`) REFERENCES `Court_Info` (`Court_id`),
  CONSTRAINT `FK_Judge_Info` FOREIGN KEY (`Judge_id`) REFERENCES `Judge_Info` (`Judge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Offender_Info`
--

LOCK TABLES `Offender_Info` WRITE;
/*!40000 ALTER TABLE `Offender_Info` DISABLE KEYS */;
INSERT INTO `Offender_Info` VALUES ('CRIM001','John','Doe','Male','32','American','123 Main St','555-1234',NULL,'Robbery','In Custody','10 years','Central Prison','Guard001','VICT001','JUDGE001','COURT001'),('CRIM002','Jane','Smith','Female','25','American','456 Elm St','555-5678',NULL,'Burglary','Released','5 years','Eastern Prison','Guard002','VICT002','JUDGE002','COURT002'),('CRIM003','Robert','Johnson','Male','40','American','789 Oak St','555-9012',NULL,'Assault','In Custody','7 years','Western Prison','Guard003','VICT003','JUDGE003','COURT003'),('CRIM004','Mary','Williams','Female','35','American','101 Pine St','555-3456',NULL,'Forgery','Released','3 years','Northern Prison','Guard004','VICT004','JUDGE004','COURT004'),('CRIM005','Michael','Brown','Male','28','American','202 Cedar St','555-7890',NULL,'Drug Possession','In Custody','6 years','Southern Prison','Guard005','VICT005','JUDGE005','COURT005'),('CRIM006','Emily','Davis','Female','22','American','303 Maple St','555-2345',NULL,'Theft','Released','2 years','Central Prison','Guard006','VICT006','JUDGE006','COURT006'),('CRIM007','William','Anderson','Male','45','American','404 Birch St','555-6789',NULL,'Vandalism','In Custody','8 years','Eastern Prison','Guard007','VICT007','JUDGE007','COURT007'),('CRIM008','Olivia','Martinez','Female','30','American','505 Walnut St','555-1234',NULL,'Fraud','Released','4 years','Western Prison','Guard008','VICT008','JUDGE008','COURT008'),('CRIM009','David','Garcia','Male','38','American','606 Spruce St','555-5678',NULL,'Kidnapping','In Custody','9 years','Northern Prison','Guard009','VICT009','JUDGE009','COURT009'),('CRIM010','Sophia','Rodriguez','Female','27','American','707 Pine St','555-9012',NULL,'Homicide','Released','15 years','Southern Prison','Guard010','VICT010','JUDGE010','COURT010'),('CRIM011','dsfds','vsdv','Male','54','American','one pace','1234','','Drug','Released','0.5 year','Central Prison','Guard003','VICT004','JUDGE010','COURT008');
/*!40000 ALTER TABLE `Offender_Info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-15  0:46:21
