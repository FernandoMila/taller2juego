<<<<<<< HEAD
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: taller2
-- ------------------------------------------------------
-- Server version	8.0.38

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
INSERT INTO `ciudad` VALUES (1,'Montevideo','Montevideo, la capital de Uruguay, ofrece una rica historia, cultura vibrante y una cálida hospitalidad, todo a orillas del Río de la Plata.','imagenes/montevideo.jpg'),(2,'Maldonado','Maldonado, combina playas espectaculares y la animada vida nocturna de Punta del Este con un encantador centro histórico lleno de historia colonial.','imagenes/maldonado.jpg'),(3,'Colonia del sacramento','Colonia del Sacramento, es famosa por su casco histórico colonial bien conservado, con calles empedradas y arquitectura portuguesa y española, y su pintoresca ubicación a orillas del Río de la Plata.','imagenes/colonia.jpg'),(4,'Salto','Salto, es conocida por sus termas y balnearios, su vibrante vida cultural y el majestuoso río Uruguay, ofreciendo una mezcla de relajación y entretenimiento.','imagenes/salto.jpg'),(5,'Paysandu','Paysandú, destaca por su rica historia y el río Uruguay, con atracciones como el Festival Nacional de Danzas y espacios recreativos. Su centro histórico y parques ofrecen un ambiente encantador y relajado para disfrutar.','imagenes/paysandu.jpg'),(6,'Rivera','Rivera, destaca por su cultura fronteriza, el comercio con Brasil y su famoso carnaval. La ciudad ofrece una mezcla única de influencias uruguayas y brasileñas, creando un ambiente animado y vibrante.','imagenes/rivera.jpg'),(7,'Mercedes','Mercedes, destaca por su rambla a lo largo del río Negro y su vibrante vida cultural. Su arquitectura histórica y eventos locales reflejan el encanto y la hospitalidad de la ciudad.','imagenes/mercedes.jpg'),(8,'Tacuarembo','acuarembó, es famoso por su rica tradición gaucha, el Festival de la Patria Gaucha y su vibrante cultura folclórica. Rodeado de paisajes naturales, combina encanto rural, arquitectura histórica y cálida hospitalidad.','imagenes/tacuarembo.jpg'),(9,'Durazno','Durazno, es famoso por el Festival Nacional de Folclore y el Parque de la Hispanidad. Situado a orillas del río Yi, combina historia rica, eventos culturales vibrantes y una cálida hospitalidad, ofreciendo un ambiente tranquilo y acogedor.','imagenes/durazno.jpg'),(10,'Juan Lacaze','Juan Lacaze, es una ciudad industrial conocida por su historia en la fabricación de papel y textiles. Situada a orillas del río de la Plata, ofrece playas tranquilas y una comunidad unida, con un ambiente relajado y pintoresco.','imagenes/juanlacaze.jpg'),(11,'Las piedras','Las Piedras, es conocida por la histórica Batalla de Las Piedras y su producción vitivinícola. La ciudad ofrece un ambiente tranquilo, con parques, viñedos y un rico patrimonio cultural para disfrutar y explorar.','imagenes/laspiedras.jpg'),(12,'Artigas','Artigas, famosa por sus canteras de amatistas y su cultura fronteriza con Brasil. Ciudad que ofrece festivales vibrantes, un rico patrimonio cultural y paisajes naturales, brindando una experiencia única.','imagenes/artigas.jpg'),(13,'San Jose de Mayo','San José de Mayo, es conocida por su arquitectura colonial, el Teatro Macció y su animada escena cultural. La ciudad ofrece una mezcla de historia y modernidad en un ambiente acogedor.','imagenes/sanjose.jpg'),(14,'Florida','Florida, es famosa por la Piedra Alta, donde se juró la independencia, y su catedral. Ofrece un ambiente tranquilo con parques, eventos culturales y una rica historia para explorar.','imagenes/florida.jpg'),(15,'Melo','Melo, destaca por su Catedral de Nuestra Señora del Pilar y su vibrante vida cultural. Rodeada de paisajes naturales, la ciudad combina historia, cultura y un ambiente relajado.','imagenes/melo.jpg'),(16,'Punta del diablo','Punta del Diablo, es un pintoresco pueblo costero con playas vírgenes y un ambiente relajado. Popular entre surfistas y turistas, ofrece una experiencia rústica y encantadora junto al mar, ideal para desconectar.','imagenes/puntadeldiablo.jpg'),(17,'Treinta y tres','Treinta y Tres, es conocida por su Plaza 19 de Abril y la Quebrada de los Cuervos. Ofrece un entorno natural, ideal para disfrutar de la belleza rural y actividades al aire libre.','imagenes/treintaytres.jpg'),(18,'Minas','Minas, destaca por el Cerro Arequita y el Salto del Penitente. La ciudad ofrece oportunidades para explorar y disfrutar de la naturaleza.','imagenes/minas.jpg'),(19,'Fray Bentos','Fray Bentos, es famosa por el Museo de la Revolución Industrial y su historia industrial. A orillas del río Uruguay, la ciudad ofrece una mezcla de patrimonio histórico y paisajes naturales en un entorno relajado.','imagenes/fraybentos.jpg'),(20,'Trinidad','Trinidad, es conocida por la Plaza Constitución y el Parque Centenario. La ciudad ofrece un rico patrimonio histórico junto con espacios recreativos y para disfrutar y explorar.','imagenes/trinidad.jpg');
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
INSERT INTO `identifica` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(21,3),(22,3),(23,3),(24,3),(25,3),(26,3),(27,3),(28,3),(29,3),(30,3),(31,4),(32,4),(33,4),(34,4),(35,4),(36,4),(37,4),(38,4),(39,4),(40,4);
/*!40000 ALTER TABLE `identifica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugar`
--

DROP TABLE IF EXISTS `lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugar` (
  `idLugar` int NOT NULL AUTO_INCREMENT,
  `idCiudad` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL,
  PRIMARY KEY (`idLugar`,`idCiudad`),
  KEY `idCiudad` (`idCiudad`),
  CONSTRAINT `lugar_ibfk_1` FOREIGN KEY (`idCiudad`) REFERENCES `ciudad` (`idCiudad`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,1,'Ciudad vieja','El barrio histórico de Montevideo, con calles adoquinadas y arquitectura colonial.','imagenes/ciudadvieja.jpg'),(2,1,'Teatro Solís','Uno de los teatros más antiguos y prestigiosos de América del Sur, inaugurado en 1856.','imagenes/ciudadvieja.jpg'),(3,2,'Catedral de San Fernando','Una iglesia histórica en el centro de Maldonado.','imagenes/ciudadvieja.jpg'),(4,2,'Cuartel de Dragones','Un antiguo cuartel militar y sitio histórico.','imagenes/ciudadvieja.jpg'),(5,3,'Barrio Histórico','Declarado Patrimonio de la Humanidad por la UNESCO, con calles empedradas y edificios coloniales.','imagenes/ciudadvieja.jpg'),(6,3,'Puerta de la Ciudadela','Una antigua puerta de la ciudad y parte de las murallas originales.','imagenes/ciudadvieja.jpg'),(7,4,'Termas del Daymán','Un complejo de aguas termales popular entre turistas y locales.','imagenes/ciudadvieja.jpg'),(8,4,'Parque Harriague','Un espacio verde con monumentos históricos y áreas recreativas.','imagenes/ciudadvieja.jpg'),(9,5,'Basílica Nuestra Señora del Rosario y San Benito de Palermo','Un importante templo católico con una rica historia.','imagenes/ciudadvieja.jpg'),(10,5,'Monumento a Perpetuidad ','Un cementerio histórico y monumento nacional.','imagenes/ciudadvieja.jpg'),(11,6,'Parque Internacional','Un parque que marca la frontera entre Uruguay y Brasil.','imagenes/ciudadvieja.jpg'),(12,6,'Cerro Marconi','Un cerro con una vista panorámica de la ciudad y alrededores.','imagenes/ciudadvieja.jpg'),(13,7,'Teatro 28 de Febrero','Un teatro histórico inaugurado en 1885.','imagenes/ciudadvieja.jpg'),(14,7,'Basílica Nuestra Señora del Carmen','Una iglesia católica con una arquitectura impresionante.','imagenes/ciudadvieja.jpg'),(15,8,'Museo Carlos Gardel','Un museo dedicado al famoso cantante de tango Carlos Gardel.','imagenes/ciudadvieja.jpg'),(16,8,'Valle Edén','Un área natural con senderos y paisajes hermosos, además de un museo ferroviario.','imagenes/ciudadvieja.jpg'),(17,9,'Parque de la Hispanidad','Un parque grande y popular para eventos culturales y recreativos.','imagenes/ciudadvieja.jpg'),(18,9,'Catedral de San Pedro','Una iglesia católica histórica en el centro de Durazno.','imagenes/ciudadvieja.jpg'),(19,10,'Playa Charrúa','Una hermosa playa sobre el río de la Plata, ideal para disfrutar de un día soleado y realizar actividades acuáticas.','imagenes/ciudadvieja.jpg'),(20,10,'Plaza 1° de Mayo','La plaza principal de la ciudad, un lugar de encuentro para los habitantes locales y escenario de eventos comunitarios.','imagenes/ciudadvieja.jpg'),(21,11,'Obelisco de Las Piedras','Monumento que conmemora la batalla de Las Piedras, importante lucha por la independencia de Uruguay.','imagenes/ciudadvieja.jpg'),(22,11,'Parque Artigas','Un gran parque público donde se celebran eventos y actividades recreativas para toda la familia.','imagenes/ciudadvieja.jpg'),(23,12,'Plaza Artigas','La plaza principal de la ciudad, que cuenta con una estatua de José Gervasio Artigas, el prócer nacional de Uruguay.','imagenes/ciudadvieja.jpg'),(24,12,'Carnaval de Artigas','Uno de los carnavales más famosos y coloridos de Uruguay, que atrae a visitantes de todo el país.','imagenes/ciudadvieja.jpg'),(25,13,'Teatro Macció','Un hermoso teatro inaugurado en 1912, conocido por su arquitectura y su activa programación cultural.','imagenes/ciudadvieja.jpg'),(26,13,'Basílica Catedral de San José','Una imponente catedral que es un hito religioso y arquitectónico de la ciudad.','imagenes/ciudadvieja.jpg'),(27,14,'Catedral Basílica de Florida','Un importante sitio religioso que alberga la Virgen de los Treinta y Tres, patrona de Uruguay.','imagenes/ciudadvieja.jpg'),(28,14,'Piedra Alta','Un monumento histórico donde se juró la independencia de Uruguay en 1825.','imagenes/ciudadvieja.jpg'),(29,15,'Catedral de Melo','Una destacada iglesia que es un punto de referencia arquitectónico y religioso en la ciudad.','imagenes/ciudadvieja.jpg'),(30,15,'Museo Histórico Regional de Melo','Un museo que exhibe la historia y la cultura de la región de Cerro Largo.','imagenes/ciudadvieja.jpg'),(31,16,'Playa de los Pescadores','Una playa pintoresca donde se puede ver a los pescadores locales en acción y disfrutar de mariscos frescos.','imagenes/ciudadvieja.jpg'),(32,16,'Parque Nacional Santa Teresa','Un parque natural cercano con hermosas playas, flora y fauna diversa, y una fortaleza histórica.','imagenes/ciudadvieja.jpg'),(33,17,'Plaza 19 de Abril','La plaza principal de la ciudad, un lugar de reunión y eventos comunitarios.','imagenes/ciudadvieja.jpg'),(34,17,'Quebrada de los Cuervos','Una reserva natural cercana conocida por su belleza escénica y su biodiversidad.','imagenes/ciudadvieja.jpg'),(35,18,'Cerro Arequita','Un cerro característico de la región con cuevas y formaciones rocosas interesantes para explorar.','imagenes/ciudadvieja.jpg'),(36,18,'Salto del Penitente','Una cascada pintoresca que es un popular destino turístico y de recreación al aire libre.','imagenes/ciudadvieja.jpg'),(37,19,'Museo de la Revolución Industrial','Un museo que documenta la historia de la industria de la carne en Uruguay y la planta frigorífica Anglo.','imagenes/ciudadvieja.jpg'),(38,19,'Plaza Constitución','La plaza principal de la ciudad, rodeada de edificios históricos y un lugar de encuentro para los habitantes.','imagenes/ciudadvieja.jpg'),(39,20,'Plaza Constitución T','La plaza central de la ciudad, un punto de encuentro comunitario rodeado de edificios históricos.','imagenes/ciudadvieja.jpg'),(40,20,'Parque Centenario','Parque público que ofrece espacios verdes y áreas recreativas para la familia.','imagenes/ciudadvieja.jpg');
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
INSERT INTO `obtiene` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20),(21,21),(22,22),(23,23),(24,24),(25,25),(26,26),(27,27),(28,28),(29,29),(30,30),(31,31),(32,32),(33,33),(34,34),(35,35),(36,36),(37,37),(38,38),(39,39),(40,40);
/*!40000 ALTER TABLE `obtiene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pista`
--

DROP TABLE IF EXISTS `pista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pista` (
  `idPista` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(512) NOT NULL,
  PRIMARY KEY (`idPista`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pista`
--

LOCK TABLES `pista` WRITE;
/*!40000 ALTER TABLE `pista` DISABLE KEYS */;
INSERT INTO `pista` VALUES (1,'La ladrona fue vista paseando por las calles adoquinadas de un barrio histórico de la capital uruguaya. Su siguiente parada podría estar relacionada con un lugar que ha acogido innumerables obras de teatro desde 1856.'),(2,'Se rumorea que después de explorar la Ciudad Vieja, asistió a una función en un teatro icónico. ¡Apresúrate, podría estar dejando la ciudad!'),(3,'Se dirigió hacia el sur, donde fue vista en una iglesia histórica en el centro de la ciudad. Los lugareños hablan de su devoción.'),(4,'Tras dejar la catedral, fue vista en un antiguo cuartel militar que ahora es un sitio histórico. Revisa los registros de los Dragones.'),(5,'Dejó la modernidad de Punta del Este para esconderse entre las calles empedradas y edificios coloniales de un barrio declarado Patrimonio de la Humanidad por la UNESCO.'),(6,'Alguien la vio entrar por una antigua puerta de la ciudad, parte de las murallas originales. Busca entre los recuerdos coloniales.'),(7,'La ladrona cambió de rumbo hacia un lugar conocido por sus aguas termales. Se relajó en un complejo famoso por sus propiedades curativas.'),(8,'Después de disfrutar de las Termas del Daymán, decidió pasear por un parque lleno de monumentos históricos. Busca entre los símbolos de la historia local.'),(9,'La sospechosa cruzó el río Uruguay y fue vista rezando en un templo católico de gran importancia histórica.'),(10,'Se informó que después de visitar la basílica, se dirigió a un cementerio que también es monumento nacional. Busca entre los mausoleos y las antiguas lápidas.'),(11,'La ladrona cruzó la frontera hacia un parque que marca el límite entre Uruguay y Brasil. Podrías encontrarla en un lugar que une dos naciones.\"'),(12,'Desde el Parque Internacional, se dirigió a un cerro con una vista panorámica. Observa desde lo alto del Cerro Marconi.'),(13,'Regresó al litoral para asistir a una función en un teatro histórico inaugurado en 1885. Escucha los murmullos de la audiencia.'),(14,'Luego de la función, fue vista entrando en una iglesia católica con una arquitectura impresionante. Busca entre los bancos de la basílica.'),(15,'La ladrona se dirigió al norte, visitando un museo dedicado a un famoso cantante de tango. Podrías escuchar los ecos del pasado en sus salas.'),(16,'Después de recorrer el museo, fue vista en un área natural con senderos hermosos. Busca entre los rieles del museo ferroviario en Valle Edén.\"'),(17,'Finalmente, fue vista participando en un evento cultural en un gran parque popular. Busca entre los visitantes del Parque de la Hispanidad.'),(18,'Antes de desaparecer, entró en una iglesia católica histórica en el centro de la ciudad. Revisa los altares de la Catedral de San Pedro.'),(19,'La ladrona fue vista en una antigua fábrica textil que es el corazón de esta ciudad costera'),(20,'Después, visitó un parque junto al río donde solía haber una fundición de hierro'),(21,'Fue vista en un campo de batalla histórico donde se libró una batalla crucial por la independencia.'),(22,'Luego se dirigió a un parque conmemorativo donde se erige un monumento a los caídos.'),(23,'La ladrona exploró una cantera famosa por sus amatistas de alta calidad.'),(24,'Después, fue vista cruzando un puente que conecta dos países sobre el río Cuareim.'),(25,'Se detuvo en una basílica que es un emblema arquitectónico de la ciudad.'),(26,'Luego, visitó un teatro histórico conocido por su acústica excepcional.'),(27,'La ladrona rezó en una catedral que guarda el altar de la patria.'),(28,'Después, exploró un parque donde se proclamó la independencia uruguaya.'),(29,'Fue vista en una catedral neogótica que domina el centro de la ciudad.'),(30,'Luego se dirigió a un parque donde se realizan festivales populares.'),(31,'Se escondió en un pequeño pueblo pesquero famoso por sus playas vírgenes.'),(32,'Después, exploró un parque nacional cercano, hogar de fauna diversa.'),(33,'Fue vista en un parque nacional que protege un ecosistema único de quebradas.'),(34,'Luego visitó una plaza central que rinde homenaje a los 33 Orientales'),(35,'La ladrona subió una colina desde donde se divisa toda la ciudad.'),(36,'Después, se dirigió a un santuario religioso en las afueras de la ciudad.'),(37,'Se la vio en un sitio declarado Patrimonio de la Humanidad, donde antiguamente se producía carne enlatada.'),(38,'Luego visitó un museo industrial que muestra la historia de la carne enlatada.'),(39,'La ladrona fue vista en un zoológico famoso por su diversidad de fauna.'),(40,'Después, visitó una plaza central dedicada a un héroe nacional.');
/*!40000 ALTER TABLE `pista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-03 17:39:35
=======
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: taller2
-- ------------------------------------------------------
-- Server version	8.0.38

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
INSERT INTO `ciudad` VALUES (1,'Montevideo','Montevideo, la capital de Uruguay, ofrece una rica historia, cultura vibrante y una cálida hospitalidad, todo a orillas del Río de la Plata.','imagenes/montevideo.jpg'),(2,'Maldonado','Maldonado, combina playas espectaculares y la animada vida nocturna de Punta del Este con un encantador centro histórico lleno de historia colonial.','imagenes/maldonado.jpg'),(3,'Colonia del sacramento','Colonia del Sacramento, es famosa por su casco histórico colonial bien conservado, con calles empedradas y arquitectura portuguesa y española, y su pintoresca ubicación a orillas del Río de la Plata.','imagenes/colonia.jpg'),(4,'Salto','Salto, es conocida por sus termas y balnearios, su vibrante vida cultural y el majestuoso río Uruguay, ofreciendo una mezcla de relajación y entretenimiento.','imagenes/salto.jpg'),(5,'Paysandu','Paysandú, destaca por su rica historia y el río Uruguay, con atracciones como el Festival Nacional de Danzas y espacios recreativos. Su centro histórico y parques ofrecen un ambiente encantador y relajado para disfrutar.','imagenes/paysandu.jpg'),(6,'Rivera','Rivera, destaca por su cultura fronteriza, el comercio con Brasil y su famoso carnaval. La ciudad ofrece una mezcla única de influencias uruguayas y brasileñas, creando un ambiente animado y vibrante.','imagenes/rivera.jpg'),(7,'Mercedes','Mercedes, destaca por su rambla a lo largo del río Negro y su vibrante vida cultural. Su arquitectura histórica y eventos locales reflejan el encanto y la hospitalidad de la ciudad.','imagenes/mercedes.jpg'),(8,'Tacuarembo','acuarembó, es famoso por su rica tradición gaucha, el Festival de la Patria Gaucha y su vibrante cultura folclórica. Rodeado de paisajes naturales, combina encanto rural, arquitectura histórica y cálida hospitalidad.','imagenes/tacuarembo.jpg'),(9,'Durazno','Durazno, es famoso por el Festival Nacional de Folclore y el Parque de la Hispanidad. Situado a orillas del río Yi, combina historia rica, eventos culturales vibrantes y una cálida hospitalidad, ofreciendo un ambiente tranquilo y acogedor.','imagenes/durazno.jpg'),(10,'Juan Lacaze','Juan Lacaze, es una ciudad industrial conocida por su historia en la fabricación de papel y textiles. Situada a orillas del río de la Plata, ofrece playas tranquilas y una comunidad unida, con un ambiente relajado y pintoresco.','imagenes/juanlacaze.jpg'),(11,'Las piedras','Las Piedras, es conocida por la histórica Batalla de Las Piedras y su producción vitivinícola. La ciudad ofrece un ambiente tranquilo, con parques, viñedos y un rico patrimonio cultural para disfrutar y explorar.','imagenes/laspiedras.jpg'),(12,'Artigas','Artigas, famosa por sus canteras de amatistas y su cultura fronteriza con Brasil. Ciudad que ofrece festivales vibrantes, un rico patrimonio cultural y paisajes naturales, brindando una experiencia única.','imagenes/artigas.jpg'),(13,'San Jose de Mayo','San José de Mayo, es conocida por su arquitectura colonial, el Teatro Macció y su animada escena cultural. La ciudad ofrece una mezcla de historia y modernidad en un ambiente acogedor.','imagenes/sanjose.jpg'),(14,'Florida','Florida, es famosa por la Piedra Alta, donde se juró la independencia, y su catedral. Ofrece un ambiente tranquilo con parques, eventos culturales y una rica historia para explorar.','imagenes/florida.jpg'),(15,'Melo','Melo, destaca por su Catedral de Nuestra Señora del Pilar y su vibrante vida cultural. Rodeada de paisajes naturales, la ciudad combina historia, cultura y un ambiente relajado.','imagenes/melo.jpg'),(16,'Punta del diablo','Punta del Diablo, es un pintoresco pueblo costero con playas vírgenes y un ambiente relajado. Popular entre surfistas y turistas, ofrece una experiencia rústica y encantadora junto al mar, ideal para desconectar.','imagenes/puntadeldiablo.jpg'),(17,'Treinta y tres','Treinta y Tres, es conocida por su Plaza 19 de Abril y la Quebrada de los Cuervos. Ofrece un entorno natural, ideal para disfrutar de la belleza rural y actividades al aire libre.','imagenes/treintaytres.jpg'),(18,'Minas','Minas, destaca por el Cerro Arequita y el Salto del Penitente. La ciudad ofrece oportunidades para explorar y disfrutar de la naturaleza.','imagenes/minas.jpg'),(19,'Fray Bentos','Fray Bentos, es famosa por el Museo de la Revolución Industrial y su historia industrial. A orillas del río Uruguay, la ciudad ofrece una mezcla de patrimonio histórico y paisajes naturales en un entorno relajado.','imagenes/fraybentos.jpg'),(20,'Trinidad','Trinidad, es conocida por la Plaza Constitución y el Parque Centenario. La ciudad ofrece un rico patrimonio histórico junto con espacios recreativos y para disfrutar y explorar.','imagenes/trinidad.jpg');
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
INSERT INTO `identifica` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(21,3),(22,3),(23,3),(24,3),(25,3),(26,3),(27,3),(28,3),(29,3),(30,3),(31,4),(32,4),(33,4),(34,4),(35,4),(36,4),(37,4),(38,4),(39,4),(40,4);
/*!40000 ALTER TABLE `identifica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugar`
--

DROP TABLE IF EXISTS `lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugar` (
  `idLugar` int NOT NULL AUTO_INCREMENT,
  `idCiudad` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `imagen` varchar(255) NOT NULL,
  PRIMARY KEY (`idLugar`,`idCiudad`),
  KEY `idCiudad` (`idCiudad`),
  CONSTRAINT `lugar_ibfk_1` FOREIGN KEY (`idCiudad`) REFERENCES `ciudad` (`idCiudad`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,1,'Ciudad vieja','El barrio histórico de Montevideo, con calles adoquinadas y arquitectura colonial.','imagenes/ciudadvieja.jpg'),(2,1,'Teatro Solís','Uno de los teatros más antiguos y prestigiosos de América del Sur, inaugurado en 1856.','imagenes/ciudadvieja.jpg'),(3,2,'Catedral de San Fernando','Una iglesia histórica en el centro de Maldonado.','imagenes/ciudadvieja.jpg'),(4,2,'Cuartel de Dragones','Un antiguo cuartel militar y sitio histórico.','imagenes/ciudadvieja.jpg'),(5,3,'Barrio Histórico','Declarado Patrimonio de la Humanidad por la UNESCO, con calles empedradas y edificios coloniales.','imagenes/ciudadvieja.jpg'),(6,3,'Puerta de la Ciudadela','Una antigua puerta de la ciudad y parte de las murallas originales.','imagenes/ciudadvieja.jpg'),(7,4,'Termas del Daymán','Un complejo de aguas termales popular entre turistas y locales.','imagenes/ciudadvieja.jpg'),(8,4,'Parque Harriague','Un espacio verde con monumentos históricos y áreas recreativas.','imagenes/ciudadvieja.jpg'),(9,5,'Basílica Nuestra Señora del Rosario y San Benito de Palermo','Un importante templo católico con una rica historia.','imagenes/ciudadvieja.jpg'),(10,5,'Monumento a Perpetuidad ','Un cementerio histórico y monumento nacional.','imagenes/ciudadvieja.jpg'),(11,6,'Parque Internacional','Un parque que marca la frontera entre Uruguay y Brasil.','imagenes/ciudadvieja.jpg'),(12,6,'Cerro Marconi','Un cerro con una vista panorámica de la ciudad y alrededores.','imagenes/ciudadvieja.jpg'),(13,7,'Teatro 28 de Febrero','Un teatro histórico inaugurado en 1885.','imagenes/ciudadvieja.jpg'),(14,7,'Basílica Nuestra Señora del Carmen','Una iglesia católica con una arquitectura impresionante.','imagenes/ciudadvieja.jpg'),(15,8,'Museo Carlos Gardel','Un museo dedicado al famoso cantante de tango Carlos Gardel.','imagenes/ciudadvieja.jpg'),(16,8,'Valle Edén','Un área natural con senderos y paisajes hermosos, además de un museo ferroviario.','imagenes/ciudadvieja.jpg'),(17,9,'Parque de la Hispanidad','Un parque grande y popular para eventos culturales y recreativos.','imagenes/ciudadvieja.jpg'),(18,9,'Catedral de San Pedro','Una iglesia católica histórica en el centro de Durazno.','imagenes/ciudadvieja.jpg'),(19,10,'Playa Charrúa','Una hermosa playa sobre el río de la Plata, ideal para disfrutar de un día soleado y realizar actividades acuáticas.','imagenes/ciudadvieja.jpg'),(20,10,'Plaza 1° de Mayo','La plaza principal de la ciudad, un lugar de encuentro para los habitantes locales y escenario de eventos comunitarios.','imagenes/ciudadvieja.jpg'),(21,11,'Obelisco de Las Piedras','Monumento que conmemora la batalla de Las Piedras, importante lucha por la independencia de Uruguay.','imagenes/ciudadvieja.jpg'),(22,11,'Parque Artigas','Un gran parque público donde se celebran eventos y actividades recreativas para toda la familia.','imagenes/ciudadvieja.jpg'),(23,12,'Plaza Artigas','La plaza principal de la ciudad, que cuenta con una estatua de José Gervasio Artigas, el prócer nacional de Uruguay.','imagenes/ciudadvieja.jpg'),(24,12,'Carnaval de Artigas','Uno de los carnavales más famosos y coloridos de Uruguay, que atrae a visitantes de todo el país.','imagenes/ciudadvieja.jpg'),(25,13,'Teatro Macció','Un hermoso teatro inaugurado en 1912, conocido por su arquitectura y su activa programación cultural.','imagenes/ciudadvieja.jpg'),(26,13,'Basílica Catedral de San José','Una imponente catedral que es un hito religioso y arquitectónico de la ciudad.','imagenes/ciudadvieja.jpg'),(27,14,'Catedral Basílica de Florida','Un importante sitio religioso que alberga la Virgen de los Treinta y Tres, patrona de Uruguay.','imagenes/ciudadvieja.jpg'),(28,14,'Piedra Alta','Un monumento histórico donde se juró la independencia de Uruguay en 1825.','imagenes/ciudadvieja.jpg'),(29,15,'Catedral de Melo','Una destacada iglesia que es un punto de referencia arquitectónico y religioso en la ciudad.','imagenes/ciudadvieja.jpg'),(30,15,'Museo Histórico Regional de Melo','Un museo que exhibe la historia y la cultura de la región de Cerro Largo.','imagenes/ciudadvieja.jpg'),(31,16,'Playa de los Pescadores','Una playa pintoresca donde se puede ver a los pescadores locales en acción y disfrutar de mariscos frescos.','imagenes/ciudadvieja.jpg'),(32,16,'Parque Nacional Santa Teresa','Un parque natural cercano con hermosas playas, flora y fauna diversa, y una fortaleza histórica.','imagenes/ciudadvieja.jpg'),(33,17,'Plaza 19 de Abril','La plaza principal de la ciudad, un lugar de reunión y eventos comunitarios.','imagenes/ciudadvieja.jpg'),(34,17,'Quebrada de los Cuervos','Una reserva natural cercana conocida por su belleza escénica y su biodiversidad.','imagenes/ciudadvieja.jpg'),(35,18,'Cerro Arequita','Un cerro característico de la región con cuevas y formaciones rocosas interesantes para explorar.','imagenes/ciudadvieja.jpg'),(36,18,'Salto del Penitente','Una cascada pintoresca que es un popular destino turístico y de recreación al aire libre.','imagenes/ciudadvieja.jpg'),(37,19,'Museo de la Revolución Industrial','Un museo que documenta la historia de la industria de la carne en Uruguay y la planta frigorífica Anglo.','imagenes/ciudadvieja.jpg'),(38,19,'Plaza Constitución','La plaza principal de la ciudad, rodeada de edificios históricos y un lugar de encuentro para los habitantes.','imagenes/ciudadvieja.jpg'),(39,20,'Plaza Constitución T','La plaza central de la ciudad, un punto de encuentro comunitario rodeado de edificios históricos.','imagenes/ciudadvieja.jpg'),(40,20,'Parque Centenario','Parque público que ofrece espacios verdes y áreas recreativas para la familia.','imagenes/ciudadvieja.jpg');
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
INSERT INTO `obtiene` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20),(21,21),(22,22),(23,23),(24,24),(25,25),(26,26),(27,27),(28,28),(29,29),(30,30),(31,31),(32,32),(33,33),(34,34),(35,35),(36,36),(37,37),(38,38),(39,39),(40,40);
/*!40000 ALTER TABLE `obtiene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pista`
--

DROP TABLE IF EXISTS `pista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pista` (
  `idPista` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(512) NOT NULL,
  PRIMARY KEY (`idPista`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pista`
--

LOCK TABLES `pista` WRITE;
/*!40000 ALTER TABLE `pista` DISABLE KEYS */;
INSERT INTO `pista` VALUES (1,'La ladrona fue vista paseando por las calles adoquinadas de un barrio histórico de la capital uruguaya. Su siguiente parada podría estar relacionada con un lugar que ha acogido innumerables obras de teatro desde 1856.'),(2,'Se rumorea que después de explorar la Ciudad Vieja, asistió a una función en un teatro icónico. ¡Apresúrate, podría estar dejando la ciudad!'),(3,'Se dirigió hacia el sur, donde fue vista en una iglesia histórica en el centro de la ciudad. Los lugareños hablan de su devoción.'),(4,'Tras dejar la catedral, fue vista en un antiguo cuartel militar que ahora es un sitio histórico. Revisa los registros de los Dragones.'),(5,'Dejó la modernidad de Punta del Este para esconderse entre las calles empedradas y edificios coloniales de un barrio declarado Patrimonio de la Humanidad por la UNESCO.'),(6,'Alguien la vio entrar por una antigua puerta de la ciudad, parte de las murallas originales. Busca entre los recuerdos coloniales.'),(7,'La ladrona cambió de rumbo hacia un lugar conocido por sus aguas termales. Se relajó en un complejo famoso por sus propiedades curativas.'),(8,'Después de disfrutar de las Termas del Daymán, decidió pasear por un parque lleno de monumentos históricos. Busca entre los símbolos de la historia local.'),(9,'La sospechosa cruzó el río Uruguay y fue vista rezando en un templo católico de gran importancia histórica.'),(10,'Se informó que después de visitar la basílica, se dirigió a un cementerio que también es monumento nacional. Busca entre los mausoleos y las antiguas lápidas.'),(11,'La ladrona cruzó la frontera hacia un parque que marca el límite entre Uruguay y Brasil. Podrías encontrarla en un lugar que une dos naciones.\"'),(12,'Desde el Parque Internacional, se dirigió a un cerro con una vista panorámica. Observa desde lo alto del Cerro Marconi.'),(13,'Regresó al litoral para asistir a una función en un teatro histórico inaugurado en 1885. Escucha los murmullos de la audiencia.'),(14,'Luego de la función, fue vista entrando en una iglesia católica con una arquitectura impresionante. Busca entre los bancos de la basílica.'),(15,'La ladrona se dirigió al norte, visitando un museo dedicado a un famoso cantante de tango. Podrías escuchar los ecos del pasado en sus salas.'),(16,'Después de recorrer el museo, fue vista en un área natural con senderos hermosos. Busca entre los rieles del museo ferroviario en Valle Edén.\"'),(17,'Finalmente, fue vista participando en un evento cultural en un gran parque popular. Busca entre los visitantes del Parque de la Hispanidad.'),(18,'Antes de desaparecer, entró en una iglesia católica histórica en el centro de la ciudad. Revisa los altares de la Catedral de San Pedro.'),(19,'La ladrona fue vista en una antigua fábrica textil que es el corazón de esta ciudad costera'),(20,'Después, visitó un parque junto al río donde solía haber una fundición de hierro'),(21,'Fue vista en un campo de batalla histórico donde se libró una batalla crucial por la independencia.'),(22,'Luego se dirigió a un parque conmemorativo donde se erige un monumento a los caídos.'),(23,'La ladrona exploró una cantera famosa por sus amatistas de alta calidad.'),(24,'Después, fue vista cruzando un puente que conecta dos países sobre el río Cuareim.'),(25,'Se detuvo en una basílica que es un emblema arquitectónico de la ciudad.'),(26,'Luego, visitó un teatro histórico conocido por su acústica excepcional.'),(27,'La ladrona rezó en una catedral que guarda el altar de la patria.'),(28,'Después, exploró un parque donde se proclamó la independencia uruguaya.'),(29,'Fue vista en una catedral neogótica que domina el centro de la ciudad.'),(30,'Luego se dirigió a un parque donde se realizan festivales populares.'),(31,'Se escondió en un pequeño pueblo pesquero famoso por sus playas vírgenes.'),(32,'Después, exploró un parque nacional cercano, hogar de fauna diversa.'),(33,'Fue vista en un parque nacional que protege un ecosistema único de quebradas.'),(34,'Luego visitó una plaza central que rinde homenaje a los 33 Orientales'),(35,'La ladrona subió una colina desde donde se divisa toda la ciudad.'),(36,'Después, se dirigió a un santuario religioso en las afueras de la ciudad.'),(37,'Se la vio en un sitio declarado Patrimonio de la Humanidad, donde antiguamente se producía carne enlatada.'),(38,'Luego visitó un museo industrial que muestra la historia de la carne enlatada.'),(39,'La ladrona fue vista en un zoológico famoso por su diversidad de fauna.'),(40,'Después, visitó una plaza central dedicada a un héroe nacional.');
/*!40000 ALTER TABLE `pista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-03 17:39:35
>>>>>>> 198952f78330934ced1a606eca0393a0762301a3
