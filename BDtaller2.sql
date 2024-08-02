CREATE DATABASE  IF NOT EXISTS `taller2carmensandiego` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `taller2carmensandiego`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: taller2carmensandiego
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `idCiudad` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL,
  PRIMARY KEY (`idCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'Montevideo','Ciudad 1','/imagenes/montevideo.jpg');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criminal`
--

DROP TABLE IF EXISTS `criminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criminal` (
  `idCriminal` int NOT NULL,
  `nombreCriminal` varchar(50) NOT NULL,
  `hobbie` varchar(50) NOT NULL,
  `sexo` enum('Femenino','Masculino','Otro') NOT NULL,
  `colorPelo` varchar(50) NOT NULL,
  `ocupacion` varchar(50) NOT NULL,
  `vehiculo` varchar(50) NOT NULL,
  `caracteristicas` varchar(512) NOT NULL,
  PRIMARY KEY (`idCriminal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criminal`
--

LOCK TABLES `criminal` WRITE;
/*!40000 ALTER TABLE `criminal` DISABLE KEYS */;
INSERT INTO `criminal` VALUES (1,'Silvio \"El Zorro\" Márquez','Coleccionar máscaras antiguas','Masculino','Negro','Ladrón de obras de arte y objetos históricos','Moto deportiva negra','Silvio \"El Zorro\" Márquez es un ladrón astuto y escurridizo, conocido por su habilidad innata para escapar de cualquier trampa. Su apodo, \"El Zorro\", proviene de su ingenio y su costumbre de dejar un rastro de huellas de zorro en cada lugar que roba. Siempre lleva un antifaz negro que oculta su identidad, reforzando el misterio que lo rodea.'),(2,'Isabela \"La Sombra\" Rivas','Estudiar y restaurar artefactos antiguos','Femenino','Castaño oscuro','Ladrona experta en sigilo y camuflaje','Automóvil compacto negro','Isabela \"La Sombra\" Rivas es una maestra del sigilo y el camuflaje, capaz de mezclarse con las multitudes y desaparecer sin dejar rastro. Su apodo, \"La Sombra\", se debe a su habilidad para moverse silenciosamente y sin ser detectada, tal como una sombra.'),(3,'Ramón \"El Huracán\" Gómez','Coleccionar disfraces y artículos de camuflaje','Masculino','Negro','Ladrón de tesoros nacionales y joyas','Moto de alta velocidad','Ramón \"El Huracán\" Gómez es conocido por su rapidez y fuerza, actuando siempre con la velocidad y la potencia de un huracán. Es un maestro del disfraz y cambia constantemente su apariencia para evitar ser capturado. Sus objetivos principales son los tesoros nacionales y las joyas.'),(4,'Clara \"La Dama del Engaño\" Fernández','Coleccionar libros de psicología y  persuasión','Femenino','Rubio','Ladrona experta en engaño y manipulación','Sedán elegante y discreto','Clara \"La Dama del Engaño\" Fernández es una maestra del engaño y la manipulación. Utiliza su inteligencia y encanto para acceder a lugares aparentemente inalcanzables. Su pasión es robar objetos con gran valor simbólico o cultural. Su apodo, \"La Dama del Engaño\", refleja su capacidad para engañar a todos a su alrededor con maestría.');
/*!40000 ALTER TABLE `criminal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identifica`
--

DROP TABLE IF EXISTS `identifica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `identifica` (
  `idPista` int NOT NULL,
  `idCriminal` int NOT NULL,
  PRIMARY KEY (`idPista`,`idCriminal`),
  KEY `idCriminal` (`idCriminal`),
  CONSTRAINT `identifica_ibfk_1` FOREIGN KEY (`idPista`) REFERENCES `pista` (`idPista`),
  CONSTRAINT `identifica_ibfk_2` FOREIGN KEY (`idCriminal`) REFERENCES `criminal` (`idCriminal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identifica`
--

LOCK TABLES `identifica` WRITE;
/*!40000 ALTER TABLE `identifica` DISABLE KEYS */;
/*!40000 ALTER TABLE `identifica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugar`
--

DROP TABLE IF EXISTS `lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugar` (
  `idLugar` int NOT NULL,
  `idCiudad` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL,
  PRIMARY KEY (`idLugar`,`idCiudad`),
  KEY `idCiudad` (`idCiudad`),
  CONSTRAINT `lugar_ibfk_1` FOREIGN KEY (`idCiudad`) REFERENCES `ciudad` (`idCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obtiene`
--

DROP TABLE IF EXISTS `obtiene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `obtiene` (
  `idLugar` int NOT NULL,
  `idPista` int NOT NULL,
  PRIMARY KEY (`idLugar`,`idPista`),
  KEY `idPista` (`idPista`),
  CONSTRAINT `obtiene_ibfk_1` FOREIGN KEY (`idLugar`) REFERENCES `lugar` (`idLugar`),
  CONSTRAINT `obtiene_ibfk_2` FOREIGN KEY (`idPista`) REFERENCES `pista` (`idPista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obtiene`
--

LOCK TABLES `obtiene` WRITE;
/*!40000 ALTER TABLE `obtiene` DISABLE KEYS */;
/*!40000 ALTER TABLE `obtiene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pista`
--

DROP TABLE IF EXISTS `pista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pista` (
  `idPista` int NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  PRIMARY KEY (`idPista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pista`
--

LOCK TABLES `pista` WRITE;
/*!40000 ALTER TABLE `pista` DISABLE KEYS */;
/*!40000 ALTER TABLE `pista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proximos`
--

DROP TABLE IF EXISTS `proximos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proximos` (
  `idCiudad` int NOT NULL,
  `idCiudadProximo` int NOT NULL,
  PRIMARY KEY (`idCiudad`,`idCiudadProximo`),
  KEY `idCiudadProximo` (`idCiudadProximo`),
  CONSTRAINT `proximos_ibfk_1` FOREIGN KEY (`idCiudad`) REFERENCES `ciudad` (`idCiudad`),
  CONSTRAINT `proximos_ibfk_2` FOREIGN KEY (`idCiudadProximo`) REFERENCES `ciudad` (`idCiudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proximos`
--

LOCK TABLES `proximos` WRITE;
/*!40000 ALTER TABLE `proximos` DISABLE KEYS */;
/*!40000 ALTER TABLE `proximos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'taller2carmensandiego'
--

--
-- Dumping routines for database 'taller2carmensandiego'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-02 17:20:02
