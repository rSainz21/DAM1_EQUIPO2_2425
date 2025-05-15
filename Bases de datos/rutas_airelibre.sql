-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema rutas_airelibre
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema rutas_airelibre
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `rutas_airelibre` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `rutas_airelibre` ;

-- -----------------------------------------------------
-- Table `rutas_airelibre`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`usuarios` (
  `cod_usu` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `nombre` VARCHAR(25) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `fecha_nac` DATE NOT NULL,
  `rol` ENUM('administrador', 'diseñador', 'profesor', 'alumno', 'invitado') NOT NULL,
  `validado` TINYINT NOT NULL,
  PRIMARY KEY (`cod_usu`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`rutas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`rutas` (
  `id_ruta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `fecha` DATE NOT NULL,
  `latitud_ini` DOUBLE NOT NULL,
  `longitud_ini` DOUBLE NOT NULL,
  `latitud_fin` DOUBLE NOT NULL,
  `longitud_fin` DOUBLE NOT NULL,
  `distancia` INT NOT NULL,
  `desnivel_acumulado` INT NOT NULL,
  `latitud_max` DOUBLE NOT NULL,
  `longitud_max` DOUBLE NOT NULL,
  `duracion` INT NOT NULL,
  `clasificacion` ENUM('circular', 'lineal') CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `tipo_terreno` TINYINT NOT NULL,
  `nivel_riesgo` TINYINT NOT NULL DEFAULT '0',
  `nivel_esfuerzo` TINYINT NOT NULL,
  `indicaciones` TINYINT NOT NULL,
  `accesib_inclusiv` TINYINT NOT NULL,
  `familiar` TINYINT NOT NULL,
  `url_gpx` TEXT CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `estado_ruta_validada` TINYINT NOT NULL,
  `recomendaciones` TEXT CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `zona_geografica` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `valo_media` DOUBLE NOT NULL,
  `usuarios_cod_usu` INT NOT NULL,
  PRIMARY KEY (`id_ruta`),
  INDEX `fk_rutas_usuarios1_idx` (`usuarios_cod_usu` ASC) VISIBLE,
  CONSTRAINT `fk_rutas_usuarios1`
    FOREIGN KEY (`usuarios_cod_usu`)
    REFERENCES `rutas_airelibre`.`usuarios` (`cod_usu`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_as_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`actividades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`actividades` (
  `id_actividad` INT NOT NULL AUTO_INCREMENT,
  `nom_actividad` VARCHAR(25) NOT NULL,
  `descripcion` VARCHAR(125) NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  PRIMARY KEY (`id_actividad`),
  INDEX `fk_actividades_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_actividades_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`calendario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`calendario` (
  `id_calendar` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `recomendaciones` VARCHAR(125) NOT NULL,
  `usuarios_cod_usu` INT NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  PRIMARY KEY (`id_calendar`),
  INDEX `fk_calendario_usuarios1_idx` (`usuarios_cod_usu` ASC) VISIBLE,
  INDEX `fk_calendario_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_calendario_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_calendario_usuarios1`
    FOREIGN KEY (`usuarios_cod_usu`)
    REFERENCES `rutas_airelibre`.`usuarios` (`cod_usu`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`puntospeligro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`puntospeligro` (
  `id_trackpoint` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `num_orden` INT NOT NULL,
  `latitud` DOUBLE NOT NULL,
  `longitud` DOUBLE NOT NULL,
  `timestamp` DATETIME NOT NULL,
  `descripcion` TEXT NOT NULL,
  `km` DOUBLE NOT NULL,
  `nivel_gravedad` TINYINT NOT NULL,
  `descripcion_gravedad` TEXT NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  PRIMARY KEY (`id_trackpoint`),
  INDEX `fk_puntospeligro_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_puntospeligro_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`foto_pp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`foto_pp` (
  `id_foto` INT NOT NULL AUTO_INCREMENT,
  `url` TEXT CHARACTER SET 'armscii8' NOT NULL,
  `descripcion` VARCHAR(125) NOT NULL,
  `puntospeligro_id_trackpoint` INT NOT NULL,
  PRIMARY KEY (`id_foto`),
  INDEX `fk_foto_pp_puntospeligro1_idx` (`puntospeligro_id_trackpoint` ASC) VISIBLE,
  CONSTRAINT `fk_foto_pp_puntospeligro1`
    FOREIGN KEY (`puntospeligro_id_trackpoint`)
    REFERENCES `rutas_airelibre`.`puntospeligro` (`id_trackpoint`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`puntosinteres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`puntosinteres` (
  `id_trackpoint` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `num_orden` INT NOT NULL,
  `latitud` DOUBLE NOT NULL,
  `longitud` DOUBLE NOT NULL,
  `timestamp` DATETIME NOT NULL,
  `tipo` ENUM('historico_arqueologico', 'naturaleza', 'mirador', 'area_de_descanso', 'punto_de_agua', 'refugio_alojamiento', 'cultural', 'geologico', 'fauna_especifica', 'botanico') NOT NULL,
  `descripcion` VARCHAR(125) NOT NULL,
  `caract_especiales` VARCHAR(125) NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  PRIMARY KEY (`id_trackpoint`),
  INDEX `fk_puntosinteres_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_puntosinteres_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`fotos_pi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`fotos_pi` (
  `id_foto` INT NOT NULL AUTO_INCREMENT,
  `url` TEXT NOT NULL,
  `descripcion` VARCHAR(125) NOT NULL,
  `puntosinteres_id_trackpoint` INT NOT NULL,
  PRIMARY KEY (`id_foto`),
  INDEX `fk_fotos_pi_puntosinteres_idx` (`puntosinteres_id_trackpoint` ASC) VISIBLE,
  CONSTRAINT `fk_fotos_pi_puntosinteres`
    FOREIGN KEY (`puntosinteres_id_trackpoint`)
    REFERENCES `rutas_airelibre`.`puntosinteres` (`id_trackpoint`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`periodos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`periodos` (
  `id_periodo` INT NOT NULL AUTO_INCREMENT,
  `nom_periodo` VARCHAR(25) NOT NULL,
  `descrip` VARCHAR(125) NOT NULL,
  PRIMARY KEY (`id_periodo`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`resenas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`resenas` (
  `id_resena` INT NOT NULL AUTO_INCREMENT,
  `text_resena` TEXT NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  `usuarios_cod_usu` INT NOT NULL,
  PRIMARY KEY (`id_resena`),
  INDEX `fk_reseñas_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  INDEX `fk_reseñas_usuarios1_idx` (`usuarios_cod_usu` ASC) VISIBLE,
  CONSTRAINT `fk_reseñas_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_reseñas_usuarios1`
    FOREIGN KEY (`usuarios_cod_usu`)
    REFERENCES `rutas_airelibre`.`usuarios` (`cod_usu`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`rutas_has_periodos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`rutas_has_periodos` (
  `rutas_id_ruta` INT NOT NULL,
  `periodos_id_periodo` INT NOT NULL,
  PRIMARY KEY (`rutas_id_ruta`, `periodos_id_periodo`),
  INDEX `fk_rutas_has_periodos_periodos1_idx` (`periodos_id_periodo` ASC) VISIBLE,
  INDEX `fk_rutas_has_periodos_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_rutas_has_periodos_periodos1`
    FOREIGN KEY (`periodos_id_periodo`)
    REFERENCES `rutas_airelibre`.`periodos` (`id_periodo`),
  CONSTRAINT `fk_rutas_has_periodos_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_as_ci;


-- -----------------------------------------------------
-- Table `rutas_airelibre`.`valoraciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutas_airelibre`.`valoraciones` (
  `id_valo` INT NOT NULL AUTO_INCREMENT,
  `dificultad` TINYINT NOT NULL,
  `belleza` TINYINT NOT NULL,
  `interes_cultu` TINYINT NOT NULL,
  `texto_valo` TEXT NOT NULL,
  `fecha` DATE NOT NULL,
  `es_valo_tecnica` TINYINT NOT NULL,
  `texto_valo_tecnica` TEXT NULL DEFAULT NULL,
  `usuarios_cod_usu` INT NOT NULL,
  `rutas_id_ruta` INT NOT NULL,
  PRIMARY KEY (`id_valo`),
  INDEX `fk_valoraciones_usuarios1_idx` (`usuarios_cod_usu` ASC) VISIBLE,
  INDEX `fk_valoraciones_rutas1_idx` (`rutas_id_ruta` ASC) VISIBLE,
  CONSTRAINT `fk_valoraciones_rutas1`
    FOREIGN KEY (`rutas_id_ruta`)
    REFERENCES `rutas_airelibre`.`rutas` (`id_ruta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_valoraciones_usuarios1`
    FOREIGN KEY (`usuarios_cod_usu`)
    REFERENCES `rutas_airelibre`.`usuarios` (`cod_usu`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `rutas_airelibre`;

DELIMITER $$
USE `rutas_airelibre`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `rutas_airelibre`.`nivel_esfuerzo`
BEFORE INSERT ON `rutas_airelibre`.`rutas`
FOR EACH ROW
begin
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
end$$

USE `rutas_airelibre`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `rutas_airelibre`.`nivel_riesgo`
AFTER INSERT ON `rutas_airelibre`.`puntospeligro`
FOR EACH ROW
begin
declare suma int; -- suma
declare c int; -- num puntospuntospeligro
declare nivel int;

select sum(nivel_gravedad) into suma from puntospeligro 
where rutas_id_ruta=new.rutas_id_ruta; -- suma valores

select count(*) into c from puntospeligro 
where rutas_id_ruta=new.rutas_id_ruta; -- cuenta todos los puntos con el mismo id

set nivel=round(suma/c);
update rutas set nivel_riesgo=nivel where id_ruta=new.rutas_id_ruta;

end$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
