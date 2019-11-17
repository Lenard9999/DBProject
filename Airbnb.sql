-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: airbnb
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--
CREATE SCHEMA IF NOT EXISTS `airbnb` ;


DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `booking` (
  `user_id` int(11) NOT NULL,
  `property_id` int(11) NOT NULL,
  `booking_date` datetime NOT NULL,
  `number_guests` int(11) NOT NULL,
  `check_in_date` datetime NOT NULL,
  `check_out_date` datetime NOT NULL,
  `amount_paid` float NOT NULL,
  PRIMARY KEY (`user_id`,`property_id`,`booking_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,4,'2018-01-01 21:05:58',5,'2018-01-03 00:00:00','2018-01-05 00:00:00',12000),(1,5,'2018-01-01 21:06:21',4,'2018-01-03 00:00:00','2018-01-06 00:00:00',24000),(2,1,'2018-01-01 21:09:12',3,'2018-01-03 00:00:00','2018-01-07 00:00:00',12000),(2,2,'2018-01-01 21:15:39',2,'2018-01-03 00:00:00','2018-01-08 00:00:00',25000),(2,3,'2018-01-01 21:25:08',1,'2018-01-03 00:00:00','2018-01-09 00:00:00',9000);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `message` (
  `sender_id` int(11) NOT NULL,
  `message_created` datetime NOT NULL,
  `receiver_id` int(11) NOT NULL,
  `message_text` text NOT NULL,
  PRIMARY KEY (`sender_id`,`receiver_id`,`message_created`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'2018-12-10 21:14:04',2,'hello lenard! im curious about your place.'),(1,'2018-12-10 21:14:57',2,'is your place very safe at night? i\'m quite scared.'),(1,'2018-12-10 21:15:26',2,'ohhh alright. i\'ll be booking your place in a short while. thank you for telling me!'),(2,'2018-12-10 21:14:14',1,'hello kyle, sure what about it?'),(2,'2018-12-10 21:15:09',1,'yup! it is the safest place ever on Earth!'),(2,'2018-12-10 21:15:41',1,'alright. glad to be of assistance kyle! :)');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `property` (
  `property_id` int(11) NOT NULL AUTO_INCREMENT,
  `property_name` varchar(45) NOT NULL,
  `host_id` int(11) NOT NULL,
  `unit_number` int(11) NOT NULL,
  `building` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `property_type` varchar(45) NOT NULL,
  `amenities` text NOT NULL,
  `number_bedrooms` int(11) NOT NULL,
  `number_beds` int(11) NOT NULL,
  `number_bathrooms` int(11) NOT NULL,
  `number_guests` int(11) NOT NULL,
  `price_per_day` float NOT NULL,
  `available_start_date` date NOT NULL,
  `available_end_date` date NOT NULL,
  PRIMARY KEY (`property_id`),
  UNIQUE KEY `property_id_UNIQUE` (`property_id`),
  UNIQUE KEY `property_name_UNIQUE` (`property_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'Kyle\'s Awesome House',1,123,'Henry Sy Building','Taft Avenue','Manila','Philippines','This is the greatest house ever built! Come on in and enjoy yourselves.','House','Everything you\'ll ever need guaranteed.',5,10,3,10,3000,'2018-01-01','2025-12-31'),(2,'Ultimate Resthouse',1,456,'Andrew Building','Taft Avenue','Manila','Philippines','The resthouse that you\'ve always dreamed of.','Condominium','Everything you need is here.',6,12,4,12,5000,'2018-01-01','2025-12-31'),(3,'The Lonely Planet',1,789,'Gokongwei Building','Quezon Avenue','Quezon City','Philippines','Where magical softwares are developed.','Townhouse','Billards, swimming pool, bowling alley.',3,6,2,6,1500,'2018-01-01','2025-12-31'),(4,'Hail Alma Mater',2,143,'LS Building','Jaboneros Street','Pasig','Philippines','Hail to De La Salle!','Apartment','Lots of conference rooms for your needs.',7,14,5,14,6000,'2018-01-01','2025-12-31'),(5,'Brilliant Minds',2,168,'Velasco Building','San Nicolas Street','Valenzuela','Philippines','Mind blowing discoveries await you.','Villa','Complex laboratories that have deep secrets hidden.',8,16,6,16,8000,'2018-01-01','2025-12-31');
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `review` (
  `user_id` int(11) NOT NULL,
  `property_id` int(11) NOT NULL,
  `review_created` datetime NOT NULL,
  `rating` int(1) NOT NULL,
  `comments` text NOT NULL,
  PRIMARY KEY (`user_id`,`property_id`,`review_created`),
  UNIQUE KEY `review_created_UNIQUE` (`review_created`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,4,'2018-12-10 21:10:40',5,'awesome and beautiful place!'),(1,5,'2018-12-10 21:10:51',4,'it was an amazing experience..'),(2,1,'2018-12-10 21:11:24',3,'it was fine and okay.'),(2,2,'2018-12-10 21:11:37',5,'truly a magnificent and beautiful place! will come back again.'),(2,3,'2018-12-10 21:11:48',4,'it\'s a nice place to relax and unwind.');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `birthday` date NOT NULL,
  `contact_no` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `contact_no_UNIQUE` (`contact_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kyle','Ty','kyle_ty@dlsu.edu.ph','kylety','1999-07-24','09323105721'),(2,'Lenard','To','lenard_to@dlsu.edu.ph','lenardto','2000-02-12','09178500588'),(3,'Jeddryc','Tiu','jeddryc_tiu@dlsu.edu.ph','jeddryctiu','1999-05-21','09178275643'),(4,'Karl','King','karl_king@dlsu.edu.ph','karlking','1999-05-08','09150758882'),(5,'Stephen','Ngo','stephen_ngo@dlsu.edu.ph','stephenngo','1999-09-24','09271271534');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-10 21:16:40
