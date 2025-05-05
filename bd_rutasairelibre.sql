
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
CREATE SCHEMA IF NOT EXISTS rutas_airelibre DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE rutas_airelibre ;

-- -----------------------------------------------------
-- Table rutas_airelibre.actividades
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.actividades (
  id_actividad INT NOT NULL,
  nom_actividad VARCHAR(25) NOT NULL,
  descripcion VARCHAR(125) NOT NULL,
  PRIMARY KEY (id_actividad))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.calendario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.calendario (
  id_calendar INT NOT NULL,
  fecha DATE NOT NULL,
  recomendaciones VARCHAR(125) NOT NULL,
  PRIMARY KEY (id_calendar))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.foto_pp
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.foto_pp (
  id_foto INT NOT NULL,
  url TEXT CHARACTER SET 'armscii8' NOT NULL,
  descripcion VARCHAR(125) NOT NULL,
  PRIMARY KEY (id_foto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.fotos_pi
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.fotos_pi (
  id_foto INT NOT NULL,
  url TEXT NOT NULL,
  descripcion VARCHAR(125) NOT NULL,
  PRIMARY KEY (id_foto))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.periodos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.periodos (
  id_periodo INT NOT NULL,
  nom_periodo VARCHAR(25) NOT NULL,
  descrip VARCHAR(125) NOT NULL,
  PRIMARY KEY (id_periodo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.puntosinteres
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.puntosinteres (
  id_trackpoint INT NOT NULL AUTO_INCREMENT,
  nombre INT NOT NULL,
  num_orden VARCHAR(45) NOT NULL,
  latitud DOUBLE NOT NULL,
  longitud DOUBLE NOT NULL,
  elevacion DOUBLE NOT NULL,
  timestamp TEXT NOT NULL,
  tipo ENUM('histórico-arqueológico') NOT NULL,
  descripcion VARCHAR(125) NOT NULL,
  caract_especiales VARCHAR(125) NOT NULL,
  imagenes TEXT NOT NULL,
  fotos_pi_id_foto INT NOT NULL,
  PRIMARY KEY (id_trackpoint),
  INDEX fk_puntosinteres_fotos_pi1_idx (fotos_pi_id_foto ASC) VISIBLE,
  CONSTRAINT fk_puntosinteres_fotos_pi1
    FOREIGN KEY (fotos_pi_id_foto)
    REFERENCES rutas_airelibre.fotos_pi (id_foto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.puntospeligro
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.puntospeligro (
  id_trackpoint INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(25) NOT NULL,
  num_orden INT NOT NULL,
  latitud DOUBLE NOT NULL,
  longitud DOUBLE NOT NULL,
  elevacion DOUBLE NOT NULL,
  timestamp VARCHAR(45) NOT NULL,
  tipo ENUM('histórico-arqueológico') NOT NULL,
  descripcion VARCHAR(125) NOT NULL,
  km DOUBLE NOT NULL,
  nivel_gravedad ENUM('1', '2', '3', '4', '5') NOT NULL,
  foto_pp_id_foto INT NOT NULL,
  PRIMARY KEY (id_trackpoint),
  INDEX fk_puntospeligro_foto_pp1_idx (foto_pp_id_foto ASC) VISIBLE,
  CONSTRAINT fk_puntospeligro_foto_pp1
    FOREIGN KEY (foto_pp_id_foto)
    REFERENCES rutas_airelibre.foto_pp (id_foto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.reseñas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.reseñas (
  id_resena INT NOT NULL,
  text_resena VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_resena))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.rutas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.rutas (
  id_ruta INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(25) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  fecha DATE NOT NULL,
  punto_ini DOUBLE NOT NULL,
  punto_fin DOUBLE NOT NULL,
  distancia INT NOT NULL,
  duracion INT NOT NULL,
  clasificacion ENUM('circular', 'lineal') CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  nivel_riesgo ENUM('1', '2', '3', '4', '5') CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  nivel_esfuerzo ENUM('1', '2', '3', '4', '5') CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  tipo_terreno ENUM('1', '2', '3', '4', '5') CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  indicaciones VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  accesib_inclusiv TINYINT NOT NULL,
  familiar VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  url_gpx TEXT CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  estado_ruta ENUM('pendiente', 'valida') CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  recomendaciones VARCHAR(125) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  zona_geografica VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  valo_media DOUBLE NOT NULL,
  reseñas_id_resena INT NOT NULL,
  calendario_id_calendar INT NOT NULL, -- Esta columna es clave para las relaciones
  puntospeligro_id_trackpoint INT NOT NULL,
  puntosinteres_id_trackpoint INT NOT NULL,
  actividades_id_actividad INT NOT NULL,
  PRIMARY KEY (id_ruta),
  INDEX fk_rutas_reseñas1_idx (reseñas_id_resena ASC) VISIBLE,
  INDEX fk_rutas_calendario1_idx (calendario_id_calendar ASC) VISIBLE,
  INDEX fk_rutas_puntospeligro1_idx (puntospeligro_id_trackpoint ASC) VISIBLE,
  INDEX fk_rutas_puntosinteres1_idx (puntosinteres_id_trackpoint ASC) VISIBLE,
  INDEX fk_rutas_actividades1_idx (actividades_id_actividad ASC) VISIBLE,
  CONSTRAINT fk_rutas_reseñas1
    FOREIGN KEY (reseñas_id_resena)
    REFERENCES rutas_airelibre.reseñas (id_resena)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_rutas_calendario1
    FOREIGN KEY (calendario_id_calendar)
    REFERENCES rutas_airelibre.calendario (id_calendar)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_rutas_puntospeligro1
    FOREIGN KEY (puntospeligro_id_trackpoint)
    REFERENCES rutas_airelibre.puntospeligro (id_trackpoint)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_rutas_puntosinteres1
    FOREIGN KEY (puntosinteres_id_trackpoint)
    REFERENCES rutas_airelibre.puntosinteres (id_trackpoint)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_rutas_actividades1
    FOREIGN KEY (actividades_id_actividad)
    REFERENCES rutas_airelibre.actividades (id_actividad)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_as_ci;

-- -----------------------------------------------------
-- Table rutas_airelibre.usuarios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.usuarios (
  cod_usu INT NOT NULL,
  email VARCHAR(50) NOT NULL,
  nombre VARCHAR(25) NOT NULL,
  apellidos VARCHAR(45) NOT NULL,
  password VARCHAR(50) NOT NULL,
  fecha_nac DATE NOT NULL,
  rol ENUM('administrador', 'diseñador', 'profesor', 'alumno', 'usuario_registrado') NOT NULL,
  reseñas_id_resena INT NOT NULL,
  calendario_id_calendar INT NOT NULL,
  PRIMARY KEY (cod_usu, calendario_id_calendar),
  UNIQUE INDEX email_UNIQUE (email ASC) VISIBLE,
  INDEX fk_usuarios_reseñas1_idx (reseñas_id_resena ASC) VISIBLE,
  INDEX fk_usuarios_calendario1_idx (calendario_id_calendar ASC) VISIBLE,
  CONSTRAINT fk_usuarios_reseñas1
    FOREIGN KEY (reseñas_id_resena)
    REFERENCES rutas_airelibre.reseñas (id_resena)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_usuarios_calendario1
    FOREIGN KEY (calendario_id_calendar)
    REFERENCES rutas_airelibre.calendario (id_calendar)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.valoraciones
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.valoraciones (
  id_valo INT NOT NULL,
  id_usu INT NOT NULL,
  dificultad VARCHAR(45) NOT NULL,
  belleza VARCHAR(45) NOT NULL,
  interes_cultu VARCHAR(45) NOT NULL,
  texto_valo VARCHAR(45) NOT NULL,
  fecha DATE NOT NULL,
  texto_valo_tecnica VARCHAR(45) NOT NULL,
  rutas_id_ruta INT NOT NULL,
  PRIMARY KEY (id_valo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.rutas_has_periodos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.rutas_has_periodos (
  rutas_id_ruta INT NOT NULL,
  rutas_calendario_id_calendar INT NOT NULL,
  periodos_id_periodo INT NOT NULL,
  PRIMARY KEY (rutas_id_ruta, rutas_calendario_id_calendar, periodos_id_periodo),
  INDEX fk_rutas_has_periodos_periodos1_idx (periodos_id_periodo ASC) VISIBLE,
  INDEX fk_rutas_has_periodos_rutas1_idx (rutas_id_ruta ASC, rutas_calendario_id_calendar ASC) VISIBLE,
  CONSTRAINT fk_rutas_has_periodos_rutas1
    FOREIGN KEY (rutas_id_ruta , rutas_calendario_id_calendar)
    REFERENCES rutas_airelibre.rutas (id_ruta , calendario_id_calendar)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_rutas_has_periodos_periodos1
    FOREIGN KEY (periodos_id_periodo)
    REFERENCES rutas_airelibre.periodos (id_periodo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_as_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.rutas_has_periodos1
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.rutas_has_periodos1 (
  rutas_id_ruta INT NOT NULL,
  rutas_calendario_id_calendar INT NOT NULL,
  periodos_id_periodo INT NOT NULL,
  PRIMARY KEY (rutas_id_ruta, rutas_calendario_id_calendar, periodos_id_periodo),
  INDEX fk_rutas_has_periodos1_periodos1_idx (periodos_id_periodo ASC) VISIBLE,
  INDEX fk_rutas_has_periodos1_rutas1_idx (rutas_id_ruta ASC, rutas_calendario_id_calendar ASC) VISIBLE,
  CONSTRAINT fk_rutas_has_periodos1_rutas1
    FOREIGN KEY (rutas_id_ruta , rutas_calendario_id_calendar)
    REFERENCES rutas_airelibre.rutas (id_ruta , calendario_id_calendar)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_rutas_has_periodos1_periodos1
    FOREIGN KEY (periodos_id_periodo)
    REFERENCES rutas_airelibre.periodos (id_periodo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_as_ci;


-- -----------------------------------------------------
-- Table rutas_airelibre.rutas_has_periodos2
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS rutas_airelibre.rutas_has_periodos2 (
  rutas_id_ruta INT NOT NULL,
  rutas_calendario_id_calendar INT NOT NULL,
  periodos_id_periodo INT NOT NULL,
  PRIMARY KEY (rutas_id_ruta, rutas_calendario_id_calendar, periodos_id_periodo),
  INDEX fk_rutas_has_periodos2_periodos1_idx (periodos_id_periodo ASC) VISIBLE,
  INDEX fk_rutas_has_periodos2_rutas1_idx (rutas_id_ruta ASC, rutas_calendario_id_calendar ASC) VISIBLE,
  CONSTRAINT fk_rutas_has_periodos2_rutas1
    FOREIGN KEY (rutas_id_ruta , rutas_calendario_id_calendar)
    REFERENCES rutas_airelibre.rutas (id_ruta , calendario_id_calendar)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_rutas_has_periodos2_periodos1
    FOREIGN KEY (periodos_id_periodo)
    REFERENCES rutas_airelibre.periodos (id_periodo)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_as_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

