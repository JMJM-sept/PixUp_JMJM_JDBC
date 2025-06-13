-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`TBL_DISQUERA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TBL_DISQUERA` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TBL_DISQUERA` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `mydb`.`TBL_DISQUERA` (`id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`TBL_ARTISTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TBL_ARTISTA` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TBL_ARTISTA` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TBL_GENERO_MUSICAL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TBL_GENERO_MUSICAL` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TBL_GENERO_MUSICAL` (
  `id` INT NOT NULL,
  `descripcion` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TBL_DISCO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TBL_DISCO` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TBL_DISCO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `precio` FLOAT(5,2) NOT NULL,
  `existencia` INT NOT NULL,
  `descuento` FLOAT(2,2) NOT NULL,
  `fecha_lanzamiento` DATETIME NOT NULL,
  `imagen` VARCHAR(120) NOT NULL,
  `id_disquera` INT NOT NULL,
  `id_artista` INT NOT NULL,
  `id_genero_musical` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id_disquera`
    FOREIGN KEY (`id_disquera`)
    REFERENCES `mydb`.`TBL_DISQUERA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_artista`
    FOREIGN KEY (`id_artista`)
    REFERENCES `mydb`.`TBL_ARTISTA` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_genero_musical`
    FOREIGN KEY (`id_genero_musical`)
    REFERENCES `mydb`.`TBL_GENERO_MUSICAL` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `id_UNIQUE` ON `mydb`.`TBL_DISCO` (`id` ASC) VISIBLE;

CREATE INDEX `id_idx` ON `mydb`.`TBL_DISCO` (`id_disquera` ASC) VISIBLE;

CREATE INDEX `id_artista_idx` ON `mydb`.`TBL_DISCO` (`id_artista` ASC) VISIBLE;

CREATE INDEX `id_genero_musical_idx` ON `mydb`.`TBL_DISCO` (`id_genero_musical` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`TBL_CANCION`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TBL_CANCION` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TBL_CANCION` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `duracion` TIME NOT NULL,
  `id_disco` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id_disco`
    FOREIGN KEY (`id_disco`)
    REFERENCES `mydb`.`TBL_DISCO` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `id_disco_idx` ON `mydb`.`TBL_CANCION` (`id_disco` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
