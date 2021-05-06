-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cooking_recipes
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ingredients`
--

DROP TABLE IF EXISTS `ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredients` (
  `ingredient_id` int NOT NULL AUTO_INCREMENT,
  `meal_id` int NOT NULL,
  `nom` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nombre` int NOT NULL,
  `unite` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ingredient_id`),
  KEY `FKi0yf0d5o7g8fx3y80avay8o3l` (`meal_id`),
  CONSTRAINT `FKi0yf0d5o7g8fx3y80avay8o3l` FOREIGN KEY (`meal_id`) REFERENCES `meals` (`meal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredients`
--

LOCK TABLES `ingredients` WRITE;
/*!40000 ALTER TABLE `ingredients` DISABLE KEYS */;
INSERT INTO `ingredients` VALUES (8,19,'milk',2,'l'),(10,20,'eggs',3,NULL),(11,21,'choco',4,'kg'),(12,19,'abc',32,'sdcsc');
/*!40000 ALTER TABLE `ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meals`
--

DROP TABLE IF EXISTS `meals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meals` (
  `meal_id` int NOT NULL AUTO_INCREMENT,
  `cuisson` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `lien_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `preparation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `titre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`meal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meals`
--

LOCK TABLES `meals` WRITE;
/*!40000 ALTER TABLE `meals` DISABLE KEYS */;
INSERT INTO `meals` VALUES (19,'Preparation 1','https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/190523-vanilla-milkshake-050-square-1559169406.png?crop=1xw:1xh;center,top&resize=768:*','Some preparation 1','Milkshake'),(20,'Preparation 2','https://thumbs.dreamstime.com/z/banquet-restaurant-meals-reception-healthy-eating-variety-prepared-dinner-party-lifestyle-106156900.jpg','Some preparation 2','Eggs'),(21,'Preparation 3','http://www.krofna.com/wp-content/uploads/2017/11/choco-loco.jpg','Some preparation 3','Choco cake'),(23,'asdg','http://www.krofna.com/wp-content/uploads/2017/11/choco-loco.jpg','asdf','dgsa'),(24,'htre','http://www.krofna.com/wp-content/uploads/2017/11/choco-loco.jpg','htr','sdfd'),(25,'htre','http://www.krofna.com/wp-content/uploads/2017/11/choco-loco.jpg','htr','sdfd'),(26,'weqr','http://www.krofna.com/wp-content/uploads/2017/11/choco-loco.jpg',' vds','gas'),(27,'45 min','https://thumbs.dreamstime.com/z/banquet-restaurant-meals-reception-healthy-eating-variety-prepared-dinner-party-lifestyle-106156900.jpg','15 min','Titi'),(28,'44 min','https://thumbs.dreamstime.com/z/banquet-restaurant-meals-reception-healthy-eating-variety-prepared-dinner-party-lifestyle-106156900.jpg','14 min','Recept'),(29,'44 min','https://thumbs.dreamstime.com/z/banquet-restaurant-meals-reception-healthy-eating-variety-prepared-dinner-party-lifestyle-106156900.jpg','14 min','Recept'),(30,'44 min','https://thumbs.dreamstime.com/z/banquet-restaurant-meals-reception-healthy-eating-variety-prepared-dinner-party-lifestyle-106156900.jpg','14 min','Recept');
/*!40000 ALTER TABLE `meals` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-06 15:58:16
