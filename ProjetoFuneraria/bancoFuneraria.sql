-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bancoFuneraria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bancoFuneraria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bancoFuneraria` DEFAULT CHARACTER SET utf8 ;
USE `bancoFuneraria` ;

-- -----------------------------------------------------
-- Table `bancoFuneraria`.`plano`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoFuneraria`.`plano` (
  `pla_id` INT NOT NULL AUTO_INCREMENT,
  `pla_nome` VARCHAR(30) NOT NULL,
  `pla_descricao` VARCHAR(100) NOT NULL,
  `pla_preco` DOUBLE NOT NULL,
  PRIMARY KEY (`pla_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoFuneraria`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoFuneraria`.`cliente` (
  `cli_id` INT NOT NULL AUTO_INCREMENT,
  `cli_nome` VARCHAR(50) NOT NULL,
  `cli_sobrenome` VARCHAR(50) NOT NULL,
  `cli_cpf` VARCHAR(11) NOT NULL,
  `cli_rg` VARCHAR(11) NOT NULL,
  `cli_dtNascimento` VARCHAR(11) NOT NULL,
  `cli_genero` VARCHAR(11) NOT NULL,
  `cli_profissao` VARCHAR(45) NOT NULL,
  `cli_estadoCivil` VARCHAR(45) NOT NULL,
  `cli_email` VARCHAR(100) NOT NULL,
  `cli_telefone` VARCHAR(11) NOT NULL,
  `cli_rua` VARCHAR(45) NOT NULL,
  `cli_numero` INT NOT NULL,
  `cli_bairro` VARCHAR(45) NOT NULL,
  `cli_complemento` VARCHAR(50) NULL,
  `cli_cidade` VARCHAR(30) NOT NULL,
  `cli_cep` VARCHAR(8) NOT NULL,
  `cli_uf` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`cli_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoFuneraria`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoFuneraria`.`produto` (
  `prod_id` INT NOT NULL AUTO_INCREMENT,
  `prod_nome` VARCHAR(45) NOT NULL,
  `prod_descricao` VARCHAR(100) NOT NULL,
  `prod_marca` VARCHAR(25) NOT NULL,
  `prod_preco` DOUBLE NOT NULL,
  `prod_largura` DOUBLE NOT NULL,
  `prod_comprimento` DOUBLE NOT NULL,
  `prod_altura` DOUBLE NOT NULL,
  `prod_qtdEstoque` INT NOT NULL,
  PRIMARY KEY (`prod_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoFuneraria`.`contrato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoFuneraria`.`contrato` (
  `contr_id` INT NOT NULL AUTO_INCREMENT,
  `cli_id` INT NOT NULL,
  `pla_id` INT NOT NULL,
  `prod_id` INT NOT NULL,
  `contr_dataInicio` VARCHAR(11) NOT NULL,
  `contr_dataFim` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`contr_id`),
  CONSTRAINT `fk_CONTRATO_CLIENTE1`
    FOREIGN KEY (`cli_id`)
    REFERENCES `bancoFuneraria`.`cliente` (`cli_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CONTRATO_PLANO1`
    FOREIGN KEY (`pla_id`)
    REFERENCES `bancoFuneraria`.`plano` (`pla_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contrato_produto1`
    FOREIGN KEY (`prod_id`)
    REFERENCES `bancoFuneraria`.`produto` (`prod_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bancoFuneraria`.`falecido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bancoFuneraria`.`falecido` (
  `fal_id` INT NOT NULL AUTO_INCREMENT,
  `fal_nome` VARCHAR(50) NOT NULL,
  `fal_sobrenome` VARCHAR(45) NOT NULL,
  `fal_cpf` VARCHAR(11) NOT NULL,
  `fal_matriculaCertidaoObito` VARCHAR(8) NOT NULL,
  `fal_rg` VARCHAR(10) NOT NULL,
  `fal_dataNasc` VARCHAR(11) NOT NULL,
  `fal_dataFalec` VARCHAR(11) NOT NULL,
  `fal_causaMorte` VARCHAR(45) NOT NULL,
  `fal_estadoCivil` VARCHAR(20) NOT NULL,
  `fal_cidadeFalec` VARCHAR(45) NOT NULL,
  `contr_id` INT NULL,
  PRIMARY KEY (`fal_id`),
  CONSTRAINT `fk_FALECIDO_CONTRATO1`
    FOREIGN KEY (`contr_id`)
    REFERENCES `bancoFuneraria`.`contrato` (`contr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------

INSERT INTO plano (pla_nome, pla_descricao, pla_preco) VALUES ('Premium', 'enterro + café da manhã + café da tarde + translado + coroa de flores', 2987.00);
INSERT INTO plano (pla_nome, pla_descricao, pla_preco) VALUES ('Standard', 'translado + coroa de flores', 1500.00);

INSERT INTO produto (prod_nome, prod_descricao, prod_marca, prod_preco, prod_largura, prod_comprimento, prod_altura, prod_qtdEstoque) VALUES ('Caixao de Madeira de Eucalipto', 'Caixão com acabamento de ouro todo feito com madeira de eucalipto', 'UTFcx', 650.70, 1.80, 2.00, 1.00, 5);

INSERT INTO cliente (cli_nome, cli_sobrenome, cli_cpf, cli_rg, cli_dtNascimento, cli_genero, cli_profissao, cli_estadoCivil, cli_email, cli_telefone, cli_rua, cli_numero, cli_bairro, cli_complemento, cli_cidade, cli_cep, cli_uf) VALUES ('Augusto', 'Silva', '47156841832', '542173826', '30/01/1994', 'Masculino', 'Advogado', 'Casado', 'aug_silva@gmail.com', '4336542000', 'Rua Jurere', 463, 'Centro', '', 'Cornelio Procopio', '86300000', 'PR'); 

INSERT INTO contrato (cli_id, pla_id, prod_id, contr_dataInicio, contr_dataFim) VALUES (1, 1, 1, '30/02/2018', '30/02/2020');