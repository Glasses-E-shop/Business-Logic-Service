-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema ochi
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ochi
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ochi` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`timestamps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`timestamps` (
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL);

USE `ochi` ;

-- -----------------------------------------------------
-- Table `ochi`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ochi`.`doctor` (
  `id_doctor` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_doctor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ochi`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ochi`.`appointment` (
  `id_appointment` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME(6) NULL DEFAULT NULL,
  `id_doctor` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_appointment`),
  INDEX `FKt1c2s5kifvdqa91dm3wnelnu6` (`id_doctor` ASC) VISIBLE,
  CONSTRAINT `FKt1c2s5kifvdqa91dm3wnelnu6`
    FOREIGN KEY (`id_doctor`)
    REFERENCES `ochi`.`doctor` (`id_doctor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ochi`.`order_entity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ochi`.`order_entity` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_order`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ochi`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ochi`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `age` INT NOT NULL,
  `gender` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `id_appointment` INT NULL DEFAULT NULL,
  `id_order` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK2jarx78nxf9v5h5s8v1rccktf` (`id_appointment` ASC) VISIBLE,
  INDEX `FKljelo6immoipbi6iyowamroej` (`id_order` ASC) VISIBLE,
  CONSTRAINT `FK2jarx78nxf9v5h5s8v1rccktf`
    FOREIGN KEY (`id_appointment`)
    REFERENCES `ochi`.`appointment` (`id_appointment`),
  CONSTRAINT `FKljelo6immoipbi6iyowamroej`
    FOREIGN KEY (`id_order`)
    REFERENCES `ochi`.`order_entity` (`id_order`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ochi`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ochi`.`order` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_order`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ochi`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ochi`.`product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `diopter` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `price` VARCHAR(255) NULL DEFAULT NULL,
  `stock` INT NOT NULL,
  PRIMARY KEY (`id_product`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ochi`.`order_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ochi`.`order_product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_order` INT NULL DEFAULT NULL,
  `id_product` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKsu8nmbw5guhs3yjpd2y4gfdns` (`id_order` ASC) VISIBLE,
  INDEX `FKtb606g1spm8kxo1wy9jrtblvh` (`id_product` ASC) VISIBLE,
  CONSTRAINT `FKsu8nmbw5guhs3yjpd2y4gfdns`
    FOREIGN KEY (`id_order`)
    REFERENCES `ochi`.`order_entity` (`id_order`),
  CONSTRAINT `FKtb606g1spm8kxo1wy9jrtblvh`
    FOREIGN KEY (`id_product`)
    REFERENCES `ochi`.`product` (`id_product`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ochi`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ochi`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `age` VARCHAR(255) NULL DEFAULT NULL,
  `gender` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;