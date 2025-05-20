CREATE DATABASE  IF NOT EXISTS `rutas_airelibre` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rutas_airelibre`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rutas_airelibre
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `actividades`
--

DROP TABLE IF EXISTS `actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividades` (
  `id_actividad` int NOT NULL AUTO_INCREMENT,
  `nom_actividad` varchar(25) NOT NULL,
  `descripcion` varchar(125) NOT NULL,
  `rutas_id_ruta` int DEFAULT NULL,
  PRIMARY KEY (`id_actividad`),
  KEY `fk_actividades_rutas1_idx` (`rutas_id_ruta`),
  CONSTRAINT `fk_actividades_rutas1` FOREIGN KEY (`rutas_id_ruta`) REFERENCES `rutas` (`id_ruta`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
INSERT INTO `actividades` VALUES (1,'hiking','14km de ruta por el monte',14);
/*!40000 ALTER TABLE `actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendario`
--

DROP TABLE IF EXISTS `calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendario` (
  `id_calendar` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `recomendaciones` varchar(125) NOT NULL,
  `usuarios_cod_usu` int NOT NULL,
  `rutas_id_ruta` int NOT NULL,
  PRIMARY KEY (`id_calendar`),
  KEY `fk_calendario_usuarios1_idx` (`usuarios_cod_usu`),
  KEY `fk_calendario_rutas1_idx` (`rutas_id_ruta`),
  CONSTRAINT `fk_calendario_rutas1` FOREIGN KEY (`rutas_id_ruta`) REFERENCES `rutas` (`id_ruta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_calendario_usuarios1` FOREIGN KEY (`usuarios_cod_usu`) REFERENCES `usuarios` (`cod_usu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario`
--

LOCK TABLES `calendario` WRITE;
/*!40000 ALTER TABLE `calendario` DISABLE KEYS */;
/*!40000 ALTER TABLE `calendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto_pp`
--

DROP TABLE IF EXISTS `foto_pp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foto_pp` (
  `id_foto` int NOT NULL AUTO_INCREMENT,
  `url` text CHARACTER SET armscii8 COLLATE armscii8_general_ci NOT NULL,
  `descripcion` varchar(125) NOT NULL,
  `puntospeligro_id_trackpoint` int NOT NULL,
  PRIMARY KEY (`id_foto`),
  KEY `fk_foto_pp_puntospeligro1_idx` (`puntospeligro_id_trackpoint`),
  CONSTRAINT `fk_foto_pp_puntospeligro1` FOREIGN KEY (`puntospeligro_id_trackpoint`) REFERENCES `puntospeligro` (`id_trackpoint`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto_pp`
--

LOCK TABLES `foto_pp` WRITE;
/*!40000 ALTER TABLE `foto_pp` DISABLE KEYS */;
/*!40000 ALTER TABLE `foto_pp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fotos_pi`
--

DROP TABLE IF EXISTS `fotos_pi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fotos_pi` (
  `id_foto` int NOT NULL AUTO_INCREMENT,
  `url` text NOT NULL,
  `descripcion` varchar(125) NOT NULL,
  `puntosinteres_id_trackpoint` int NOT NULL,
  PRIMARY KEY (`id_foto`),
  KEY `fk_fotos_pi_puntosinteres_idx` (`puntosinteres_id_trackpoint`),
  CONSTRAINT `fk_fotos_pi_puntosinteres` FOREIGN KEY (`puntosinteres_id_trackpoint`) REFERENCES `puntosinteres` (`id_trackpoint`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fotos_pi`
--

LOCK TABLES `fotos_pi` WRITE;
/*!40000 ALTER TABLE `fotos_pi` DISABLE KEYS */;
/*!40000 ALTER TABLE `fotos_pi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodos`
--

DROP TABLE IF EXISTS `periodos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodos` (
  `id_periodo` int NOT NULL AUTO_INCREMENT,
  `nom_periodo` varchar(25) NOT NULL,
  `descrip` varchar(125) NOT NULL,
  PRIMARY KEY (`id_periodo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodos`
--

LOCK TABLES `periodos` WRITE;
/*!40000 ALTER TABLE `periodos` DISABLE KEYS */;
INSERT INTO `periodos` VALUES (1,'Verano','Epoca de calor'),(2,'Otoño','hojas caducas'),(3,'Primavera','la sangre altera'),(4,'Invierno','qué frio');
/*!40000 ALTER TABLE `periodos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntosinteres`
--

DROP TABLE IF EXISTS `puntosinteres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puntosinteres` (
  `id_trackpoint` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `num_orden` int NOT NULL,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL,
  `timestamp` timestamp NOT NULL,
  `tipo` enum('historico_arqueologico','naturaleza','mirador','area_de_descanso','punto_de_agua') NOT NULL,
  `descripcion` varchar(125) NOT NULL,
  `caract_especiales` varchar(125) NOT NULL,
  `rutas_id_ruta` int NOT NULL,
  PRIMARY KEY (`id_trackpoint`),
  KEY `fk_puntosinteres_rutas1_idx` (`rutas_id_ruta`),
  CONSTRAINT `fk_puntosinteres_rutas1` FOREIGN KEY (`rutas_id_ruta`) REFERENCES `rutas` (`id_ruta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntosinteres`
--

LOCK TABLES `puntosinteres` WRITE;
/*!40000 ALTER TABLE `puntosinteres` DISABLE KEYS */;
INSERT INTO `puntosinteres` VALUES (1,'punto g',2,22.34,43.56,'2025-05-11 22:00:00','historico_arqueologico','muy interesante','acuoso',14);
/*!40000 ALTER TABLE `puntosinteres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntospeligro`
--

DROP TABLE IF EXISTS `puntospeligro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `puntospeligro` (
  `id_trackpoint` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `num_orden` int NOT NULL,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL,
  `timestamp` timestamp NOT NULL,
  `descripcion` text NOT NULL,
  `km` double NOT NULL,
  `nivel_gravedad` tinyint NOT NULL,
  `descripcion_gravedad` text NOT NULL,
  `rutas_id_ruta` int NOT NULL,
  PRIMARY KEY (`id_trackpoint`),
  KEY `fk_puntospeligro_rutas1_idx` (`rutas_id_ruta`),
  CONSTRAINT `fk_puntospeligro_rutas1` FOREIGN KEY (`rutas_id_ruta`) REFERENCES `rutas` (`id_ruta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntospeligro`
--

LOCK TABLES `puntospeligro` WRITE;
/*!40000 ALTER TABLE `puntospeligro` DISABLE KEYS */;
INSERT INTO `puntospeligro` VALUES (2,'puntoprueba',1,33,22,'2025-05-18 22:00:00','hola',37264,5,'mu peligrosu',14);
/*!40000 ALTER TABLE `puntospeligro` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `nivel_riesgo` AFTER INSERT ON `puntospeligro` FOR EACH ROW begin
declare suma int; -- suma
declare c int; -- num puntospuntospeligro
declare nivel int;

select sum(nivel_gravedad) into suma from puntospeligro 
where rutas_id_ruta=new.rutas_id_ruta; -- suma valores

select count(*) into c from puntospeligro 
where rutas_id_ruta=new.rutas_id_ruta; -- cuenta todos los puntos con el mismo id

set nivel=round(suma/c);
update rutas set nivel_riesgo=nivel where id_ruta=new.rutas_id_ruta;

end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `resenas`
--

DROP TABLE IF EXISTS `resenas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resenas` (
  `id_resena` int NOT NULL AUTO_INCREMENT,
  `text_resena` varchar(45) NOT NULL,
  `rutas_id_ruta` int NOT NULL,
  `usuarios_cod_usu` int NOT NULL,
  PRIMARY KEY (`id_resena`),
  KEY `fk_reseñas_rutas1_idx` (`rutas_id_ruta`),
  KEY `fk_reseñas_usuarios1_idx` (`usuarios_cod_usu`),
  CONSTRAINT `fk_reseñas_rutas1` FOREIGN KEY (`rutas_id_ruta`) REFERENCES `rutas` (`id_ruta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_reseñas_usuarios1` FOREIGN KEY (`usuarios_cod_usu`) REFERENCES `usuarios` (`cod_usu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resenas`
--

LOCK TABLES `resenas` WRITE;
/*!40000 ALTER TABLE `resenas` DISABLE KEYS */;
/*!40000 ALTER TABLE `resenas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutas`
--

DROP TABLE IF EXISTS `rutas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rutas` (
  `id_ruta` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fecha` date NOT NULL,
  `latitud_ini` double NOT NULL,
  `longitud_ini` double NOT NULL,
  `latitud_fin` double NOT NULL,
  `longitud_fin` double NOT NULL,
  `distancia` int NOT NULL,
  `desnivel_acumulado` int NOT NULL,
  `latitud_max` double NOT NULL,
  `longitud_max` double NOT NULL,
  `duracion` int NOT NULL,
  `clasificacion` enum('circular','lineal') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tipo_terreno` tinyint NOT NULL,
  `nivel_riesgo` tinyint NOT NULL DEFAULT '0',
  `nivel_esfuerzo` tinyint NOT NULL,
  `indicaciones` tinyint NOT NULL,
  `accesib_inclusiv` tinyint NOT NULL,
  `familiar` tinyint NOT NULL,
  `url_gpx` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `estado_ruta_validada` tinyint NOT NULL,
  `recomendaciones` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zona_geografica` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `valo_media` double NOT NULL,
  `usuarios_cod_usu` int NOT NULL,
  PRIMARY KEY (`id_ruta`),
  KEY `fk_rutas_usuarios1_idx` (`usuarios_cod_usu`),
  CONSTRAINT `fk_rutas_usuarios1` FOREIGN KEY (`usuarios_cod_usu`) REFERENCES `usuarios` (`cod_usu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutas`
--

LOCK TABLES `rutas` WRITE;
/*!40000 ALTER TABLE `rutas` DISABLE KEYS */;
INSERT INTO `rutas` VALUES (14,'El toral','1998-12-12',44.44,22.22,22.22,44.44,345,300,55.65,65.87,456,'circular',4,5,7,3,1,1,'suputamadre.com',1,'lleva una rebequita por si refresca','Sri lanka',3.33,5),(15,'Los puentes','1998-12-12',44.44,22.22,22.22,44.44,345,300,55.65,65.87,456,'lineal',4,0,7,3,1,1,'suputamadre.com',0,'lleva una rebequita por si refresca','Sri lanka',0,5),(16,'Ruta del bacalao','2025-05-20',96.96,69.69,43.34,34.43,619,800,99.99,66.66,230,'circular',3,0,8,4,0,1,'google.com',1,'llevar un palo por si hay lobos','Polaciones',0,6),(17,'Ruta 66','2025-05-20',96.96,69.69,43.34,34.43,25,10,99.99,66.66,56,'lineal',3,0,4,4,1,0,'google.com',1,'papardos fuera','La mies',0,6);
/*!40000 ALTER TABLE `rutas` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `nivel_esfuerzo` BEFORE INSERT ON `rutas` FOR EACH ROW begin
DECLARE puntos INT default 0; 

  SET puntos = puntos + CASE
    WHEN NEW.duracion < 30 THEN 2
    WHEN NEW.duracion < 60 THEN 4
    WHEN NEW.duracion < 120 THEN 6
    ELSE 8
  END;
  
 SET puntos = puntos + CASE
    WHEN NEW.distancia < 5 THEN 2
    WHEN NEW.distancia < 10 THEN 3
    WHEN NEW.distancia < 15 THEN 4
    WHEN NEW.distancia < 20 THEN 5
    WHEN NEW.distancia < 25 THEN 6
    WHEN NEW.distancia < 30 THEN 7
    ELSE 8
  END;

SET puntos = puntos + CASE
    WHEN NEW.desnivel_acumulado < 100 THEN 2
    WHEN NEW.desnivel_acumulado < 300 THEN 3
    WHEN NEW.desnivel_acumulado < 500 THEN 4
    WHEN NEW.desnivel_acumulado < 600 THEN 5
    WHEN NEW.desnivel_acumulado < 800 THEN 6
    WHEN NEW.desnivel_acumulado < 1000 THEN 7
    ELSE 8
  END;

set puntos=round(puntos/3);
set NEW.nivel_esfuerzo=puntos;
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `rutas_has_periodos`
--

DROP TABLE IF EXISTS `rutas_has_periodos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rutas_has_periodos` (
  `rutas_id_ruta` int NOT NULL,
  `periodos_id_periodo` int NOT NULL,
  PRIMARY KEY (`rutas_id_ruta`,`periodos_id_periodo`),
  KEY `fk_rutas_has_periodos_periodos1_idx` (`periodos_id_periodo`),
  KEY `fk_rutas_has_periodos_rutas1_idx` (`rutas_id_ruta`),
  CONSTRAINT `fk_rutas_has_periodos_periodos1` FOREIGN KEY (`periodos_id_periodo`) REFERENCES `periodos` (`id_periodo`),
  CONSTRAINT `fk_rutas_has_periodos_rutas1` FOREIGN KEY (`rutas_id_ruta`) REFERENCES `rutas` (`id_ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutas_has_periodos`
--

LOCK TABLES `rutas_has_periodos` WRITE;
/*!40000 ALTER TABLE `rutas_has_periodos` DISABLE KEYS */;
/*!40000 ALTER TABLE `rutas_has_periodos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `cod_usu` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `password` varchar(50) NOT NULL,
  `fecha_nac` date NOT NULL,
  `rol` enum('administrador','disenador','profesor','alumno','usuario_registrado') NOT NULL,
  `validado` tinyint NOT NULL,
  PRIMARY KEY (`cod_usu`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (5,'rubencio@gmail.com','ruben','cobo','1a1dc91c907325c69271ddf0c944bc72','1994-02-24','alumno',0),(6,'hola@hola','marco','materazzi','81dc9bdb52d04dc20036dbd8313ed055','1994-02-24','administrador',1),(7,'creador@gmail.com','Armando','Casas','81dc9bdb52d04dc20036dbd8313ed055','2005-02-12','disenador',0);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valoraciones`
--

DROP TABLE IF EXISTS `valoraciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valoraciones` (
  `id_valo` int NOT NULL AUTO_INCREMENT,
  `dificultad` tinyint NOT NULL,
  `belleza` tinyint NOT NULL,
  `interes_cultu` tinyint NOT NULL,
  `texto_valo` text NOT NULL,
  `fecha` date NOT NULL,
  `es_valo_tecnica` tinyint NOT NULL,
  `texto_valo_tecnica` text,
  `usuarios_cod_usu` int NOT NULL,
  `rutas_id_ruta` int NOT NULL,
  PRIMARY KEY (`id_valo`),
  KEY `fk_valoraciones_usuarios1_idx` (`usuarios_cod_usu`),
  KEY `fk_valoraciones_rutas1_idx` (`rutas_id_ruta`),
  CONSTRAINT `fk_valoraciones_rutas1` FOREIGN KEY (`rutas_id_ruta`) REFERENCES `rutas` (`id_ruta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_valoraciones_usuarios1` FOREIGN KEY (`usuarios_cod_usu`) REFERENCES `usuarios` (`cod_usu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valoraciones`
--

LOCK TABLES `valoraciones` WRITE;
/*!40000 ALTER TABLE `valoraciones` DISABLE KEYS */;
INSERT INTO `valoraciones` VALUES (1,4,2,4,'Ruta entretenida','2025-05-19',1,'',5,14),(2,4,5,1,'hola','2025-05-19',1,'adios',5,14);
/*!40000 ALTER TABLE `valoraciones` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `calcular_valoracion` AFTER INSERT ON `valoraciones` FOR EACH ROW BEGIN
  UPDATE rutas
  SET valo_media = (
    SELECT ROUND(AVG((dificultad + belleza + interes_cultu) / 3), 2)
    FROM valoraciones
    WHERE rutas_id_ruta = NEW.rutas_id_ruta
  )
  WHERE id_ruta = NEW.rutas_id_ruta;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'rutas_airelibre'
--

--
-- Dumping routines for database 'rutas_airelibre'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-20 17:23:34
