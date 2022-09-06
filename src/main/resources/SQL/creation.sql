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
-- Schema sakila
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema zoo
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`customer service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`customer service` (
  `id` INT NOT NULL,
  `location` VARCHAR(45) NULL,
  `work_from` VARCHAR(45) NULL,
  `work_till` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`customer` (
  `id` INT NOT NULL,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `phone` INT NULL,
  `email` VARCHAR(45) NULL,
  `cs_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_customer_customer service1_idx` (`cs_id` ASC) VISIBLE,
  CONSTRAINT `fk_customer_customer service1`
    FOREIGN KEY (`cs_id`)
    REFERENCES `mydb`.`customer service` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`order` (
  `id` INT NOT NULL,
  `customer_id` INT NULL,
  `customer_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_id_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `mydb`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`company` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`factories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`factories` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `prod_type` VARCHAR(45) NULL,
  `pa_month` INT NULL,
  `company_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_factories_company1_idx` (`company_id` ASC) VISIBLE,
  CONSTRAINT `fk_factories_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `mydb`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`product` (
  `id` INT NOT NULL,
  `amount` INT NULL,
  `product_type` VARCHAR(45) NULL,
  `factories_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_factories1_idx` (`factories_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_factories1`
    FOREIGN KEY (`factories_id`)
    REFERENCES `mydb`.`factories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`order_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`order_has_product` (
  `ohp_id` INT NOT NULL,
  `order_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  INDEX `fk_order_has_product_product1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_order_has_product_order1_idx` (`order_id` ASC) VISIBLE,
  PRIMARY KEY (`ohp_id`),
  CONSTRAINT `fk_order_has_product_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `mydb`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_product_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`employees` (
  `id` INT NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `company_id` INT NOT NULL,
  `factories_id` INT NULL,
  `cs_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employee_company1_idx` (`company_id` ASC) VISIBLE,
  INDEX `fk_employees_factories1_idx` (`factories_id` ASC) VISIBLE,
  INDEX `fk_employees_customer service1_idx` (`cs_id` ASC) VISIBLE,
  CONSTRAINT `fk_employee_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `mydb`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employees_factories1`
    FOREIGN KEY (`factories_id`)
    REFERENCES `mydb`.`factories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employees_customer service1`
    FOREIGN KEY (`cs_id`)
    REFERENCES `mydb`.`customer service` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`salaries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`salaries` (
  `employee_id` INT NOT NULL,
  `salary` INT NULL,
  INDEX `fk_salaries_employee1_idx` (`employee_id` ASC) VISIBLE,
  CONSTRAINT `fk_salaries_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `mydb`.`employees` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`managers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`managers` (
  `employees_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  CONSTRAINT `fk_managers_employees1`
    FOREIGN KEY (`employees_id`)
    REFERENCES `mydb`.`employees` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
