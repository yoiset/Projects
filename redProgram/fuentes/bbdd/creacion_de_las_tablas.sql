SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

USE `web_red_VF` ;

-- -----------------------------------------------------
-- Table `web_red_VF`.`Agencias`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Agencias` (
  `id` INT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Coordinador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Coordinador` (
  `id` INT NOT NULL ,
  `Agencias_id` INT NOT NULL ,
  PRIMARY KEY (`id`, `Agencias_id`) ,
  INDEX `fk_Coordinador_Agencias1_idx` (`Agencias_id` ASC) ,
  CONSTRAINT `fk_Coordinador_Agencias1`
    FOREIGN KEY (`Agencias_id` )
    REFERENCES `web_red_VF`.`Agencias` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Agentes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Agentes` (
  `id` INT NOT NULL ,
  `Agencias_id` INT NOT NULL ,
  `Coordinador_id` INT NOT NULL ,
  PRIMARY KEY (`id`, `Agencias_id`, `Coordinador_id`) ,
  INDEX `fk_Agentes_Agencias_idx` (`Agencias_id` ASC) ,
  INDEX `fk_Agentes_Coordinador1_idx` (`Coordinador_id` ASC) ,
  CONSTRAINT `fk_Agentes_Agencias`
    FOREIGN KEY (`Agencias_id` )
    REFERENCES `web_red_VF`.`Agencias` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Agentes_Coordinador1`
    FOREIGN KEY (`Coordinador_id` )
    REFERENCES `web_red_VF`.`Coordinador` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Ej_Fiscal`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Ej_Fiscal` (
  `id` TINYINT(4) NOT NULL ,
  `fecha_in` DATE NOT NULL ,
  `fecha_fin` DATE NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Categoria`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Categoria` (
  `id` INT NOT NULL ,
  `tipo` VARCHAR(7) NOT NULL COMMENT 'ENUM(\\\'TOP\\\',\\n\\\'PREMIUM\\\',\\n\\\'ADVANCE\\\')' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Res_Agencia_Mes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Res_Agencia_Mes` (
  `Agencias_id` INT NOT NULL ,
  `Ej_Fiscal_id` TINYINT(4) NOT NULL ,
  `mes` TINYINT(4) NOT NULL ,
  `Categoria_id` INT NULL ,
  `Calidad` SMALLINT(6) NOT NULL COMMENT 'Si no tiene que ver \\no no se puede calcular\\na partir de la del agente.\\n\\nPara Q1.\\n' ,
  `Convergencia` SMALLINT(6) NOT NULL COMMENT 'Si no tiene que ver \\no no se puede calcular\\na partir de la del agente.\\n\\nPara Q2.' ,
  `Ptos_Clasificacion` TINYINT(4) NOT NULL ,
  `Ptos_Carrera` TINYINT(4) NOT NULL COMMENT 'Sólo pueden ser 3,2,1,0' ,
  `Revelacion` TINYINT(1) NOT NULL ,
  `Ptos_resultado` TINYINT(4) NOT NULL COMMENT 'Sólo es la suma de los\\nptos. de la clasificación\\ny la carrera.' ,
  PRIMARY KEY (`Agencias_id`, `Ej_Fiscal_id`, `mes`) ,
  UNIQUE INDEX `mes_UNIQUE` (`mes` ASC) ,
  INDEX `fk_Res_Agencia_Mes_Ej_Fiscal1_idx` (`Ej_Fiscal_id` ASC) ,
  INDEX `fk_Res_Agencia_Mes_Categoria1_idx` (`Categoria_id` ASC) ,
  CONSTRAINT `fk_Resultados_Mes_Agencias1`
    FOREIGN KEY (`Agencias_id` )
    REFERENCES `web_red_VF`.`Agencias` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Res_Agencia_Mes_Ej_Fiscal1`
    FOREIGN KEY (`Ej_Fiscal_id` )
    REFERENCES `web_red_VF`.`Ej_Fiscal` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Res_Agencia_Mes_Categoria1`
    FOREIGN KEY (`Categoria_id` )
    REFERENCES `web_red_VF`.`Categoria` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Res_Agencia_P`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Res_Agencia_P` (
  `Agencias_id` INT NOT NULL ,
  `P` TINYINT(4) NOT NULL COMMENT '1 al 6' ,
  `Ptos` TINYINT(4) NOT NULL COMMENT 'Es la suma de:\\nPtos_resultado mes 1\\n+\\nPtos_resultado mes 2' ,
  `Ej_Fiscal_id` TINYINT(4) NOT NULL ,
  PRIMARY KEY (`Agencias_id`, `Ej_Fiscal_id`) ,
  INDEX `fk_Res_Agencia_P_Ej_Fiscal1_idx` (`Ej_Fiscal_id` ASC) ,
  CONSTRAINT `fk_Resultados_Mes_Agencias10`
    FOREIGN KEY (`Agencias_id` )
    REFERENCES `web_red_VF`.`Agencias` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Res_Agencia_P_Ej_Fiscal1`
    FOREIGN KEY (`Ej_Fiscal_id` )
    REFERENCES `web_red_VF`.`Ej_Fiscal` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Res_Agente_Semana`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Res_Agente_Semana` (
  `Agentes_id` INT NOT NULL ,
  `Ej_Fiscal_id` TINYINT(4) NOT NULL ,
  `mes` TINYINT(4) NOT NULL ,
  `semana` TINYINT(4) NOT NULL ,
  `Ventas_netas` INT NOT NULL ,
  `Horas` TINYINT(4) NOT NULL ,
  `Ventas_netas_h` INT NOT NULL COMMENT 'Redundante' ,
  `Ptos` TINYINT(4) NOT NULL COMMENT '3,2,1,0' ,
  PRIMARY KEY (`Agentes_id`, `Ej_Fiscal_id`, `mes`, `semana`) ,
  INDEX `fk_Resultados_Semana_Ej_Fiscal1_idx` (`Ej_Fiscal_id` ASC) ,
  CONSTRAINT `fk_Resultados_Semana_Agentes1`
    FOREIGN KEY (`Agentes_id` )
    REFERENCES `web_red_VF`.`Agentes` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Resultados_Semana_Ej_Fiscal1`
    FOREIGN KEY (`Ej_Fiscal_id` )
    REFERENCES `web_red_VF`.`Ej_Fiscal` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Res_Agente_Mes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Res_Agente_Mes` (
  `Agentes_id` INT NOT NULL ,
  `Ej_Fiscal_id` TINYINT(4) NOT NULL ,
  `mes` TINYINT(4) NOT NULL ,
  `Ptos` TINYINT(4) NOT NULL COMMENT 'Suma de los puntos semanales\\n' ,
  `Calidad` SMALLINT(6) NOT NULL ,
  `Convergencia` SMALLINT(6) NOT NULL ,
  `Revelacion` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`Agentes_id`, `Ej_Fiscal_id`, `mes`) ,
  INDEX `fk_Res_Agente_Mes_Ej_Fiscal1_idx` (`Ej_Fiscal_id` ASC) ,
  CONSTRAINT `fk_Res_Mes_Agente_Agentes1`
    FOREIGN KEY (`Agentes_id` )
    REFERENCES `web_red_VF`.`Agentes` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Res_Agente_Mes_Ej_Fiscal1`
    FOREIGN KEY (`Ej_Fiscal_id` )
    REFERENCES `web_red_VF`.`Ej_Fiscal` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Res_Agente_P`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Res_Agente_P` (
  `Agentes_id` INT NOT NULL ,
  `P` TINYINT(4) NOT NULL ,
  `Participa_carrera` TINYINT(1) NOT NULL ,
  `Ptos` TINYINT(4) NOT NULL COMMENT 'Sólo para los participantes\\nen la carrera y que\\nestán entre los 10 primeros:\\n25, 18, 15, ...,1\\n\\nEl resto: 0 puntos.' ,
  `Calidad` SMALLINT(6) NOT NULL COMMENT 'Ordinal: 1º,2º, \\n..., nº agentes.' ,
  `Convergencia` SMALLINT(6) NOT NULL ,
  `Revelacion` TINYINT(1) NOT NULL ,
  `Ej_Fiscal_id` TINYINT(4) NOT NULL ,
  PRIMARY KEY (`Agentes_id`, `Ej_Fiscal_id`) ,
  INDEX `fk_Res_Agente_P_Ej_Fiscal1_idx` (`Ej_Fiscal_id` ASC) ,
  CONSTRAINT `fk_Res_Agente_P_intra_Agentes10`
    FOREIGN KEY (`Agentes_id` )
    REFERENCES `web_red_VF`.`Agentes` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Res_Agente_P_Ej_Fiscal1`
    FOREIGN KEY (`Ej_Fiscal_id` )
    REFERENCES `web_red_VF`.`Ej_Fiscal` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Premios`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Premios` (
  `id` INT NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Parametos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Parametos` (
  `id` INT NOT NULL ,
  `Q1_inf` TINYINT(4) NOT NULL ,
  `Q1_sup` TINYINT(4) NOT NULL ,
  `Q2_inf` TINYINT(4) NOT NULL ,
  `Q2_sup` TINYINT(4) NOT NULL ,
  `Q3_inf` TINYINT(4) NOT NULL ,
  `Q3_sup` TINYINT(4) NOT NULL ,
  `P` ENUM('Abril,Mayo','Junio,Julio','Agosto,Septiembre','Octubre,Noviembre','Diciembre,Enero','Febrero,Marzo') NOT NULL ,
  `Calidad_mes_lim` TINYINT(4) NOT NULL ,
  `Calidad_mes_ventas_min` TINYINT(4) NOT NULL ,
  `Convergencia_mes_lim` TINYINT(4) NOT NULL ,
  `Convergencia_mes_ventas_min` TINYINT(4) NOT NULL ,
  `Calidad_P_lim` TINYINT(4) NOT NULL ,
  `Calidad_P_ventas_min` TINYINT(4) NOT NULL ,
  `Convergencia_P_ventas_min` TINYINT(4) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Noticias`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Noticias` (
  `id` INT NOT NULL ,
  `Ej_Fiscal_id` TINYINT(4) NOT NULL ,
  `mes` TINYINT(4) NOT NULL ,
  `Titulo` VARCHAR(45) NOT NULL ,
  `semana` TINYINT(4) NOT NULL ,
  `Subtitulo` VARCHAR(45) NULL ,
  `Cuerpo` TINYTEXT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Noticias_Ej_Fiscal1_idx` (`Ej_Fiscal_id` ASC) ,
  CONSTRAINT `fk_Noticias_Ej_Fiscal1`
    FOREIGN KEY (`Ej_Fiscal_id` )
    REFERENCES `web_red_VF`.`Ej_Fiscal` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`M_Pilotos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`M_Pilotos` (
  `Agentes_id` INT NOT NULL ,
  `Ej_Fiscal_id` TINYINT(4) NOT NULL ,
  `Ptos` SMALLINT(6) NOT NULL ,
  PRIMARY KEY (`Agentes_id`, `Ej_Fiscal_id`) ,
  INDEX `fk_M_Pilotos_Ej_Fiscal1_idx` (`Ej_Fiscal_id` ASC) ,
  CONSTRAINT `fk_M_Pilotos_Agentes1`
    FOREIGN KEY (`Agentes_id` )
    REFERENCES `web_red_VF`.`Agentes` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_M_Pilotos_Ej_Fiscal1`
    FOREIGN KEY (`Ej_Fiscal_id` )
    REFERENCES `web_red_VF`.`Ej_Fiscal` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`M_Escuderias`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`M_Escuderias` (
  `Ej_Fiscal_id` TINYINT(4) NOT NULL ,
  `Agencias_id` INT NOT NULL ,
  `Ptos` TINYINT(4) NOT NULL ,
  PRIMARY KEY (`Ej_Fiscal_id`, `Agencias_id`) ,
  INDEX `fk_M_Escuderias_Agencias1_idx` (`Agencias_id` ASC) ,
  CONSTRAINT `fk_M_Escuderias_Ej_Fiscal1`
    FOREIGN KEY (`Ej_Fiscal_id` )
    REFERENCES `web_red_VF`.`Ej_Fiscal` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_M_Escuderias_Agencias1`
    FOREIGN KEY (`Agencias_id` )
    REFERENCES `web_red_VF`.`Agencias` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Tipo_Usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Tipo_Usuario` (
  `id` INT NOT NULL ,
  `tipo` VARCHAR(11) NOT NULL COMMENT 'ENUM\\n(\\\'agencia\\\',\\n\\\'coordinador\\\',\\n\\\'agente\\\',\\n\\\'root\\\')' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`UsuarioWeb`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`UsuarioWeb` (
  `id` INT NOT NULL ,
  `Agentes_id` INT NULL ,
  `Coordinador_id` INT NULL ,
  `Agencias_id` INT NULL ,
  `Tipo_Usuario_id` INT NOT NULL ,
  `login` VARCHAR(12) NOT NULL ,
  `pass` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`, `Tipo_Usuario_id`) ,
  INDEX `fk_UsuarioWeb_Agentes1_idx` (`Agentes_id` ASC) ,
  INDEX `fk_UsuarioWeb_Coordinador1_idx` (`Coordinador_id` ASC) ,
  INDEX `fk_UsuarioWeb_Agencias1_idx` (`Agencias_id` ASC) ,
  INDEX `fk_UsuarioWeb_Tipo_UsuariosWeb1_idx` (`Tipo_Usuario_id` ASC) ,
  CONSTRAINT `fk_UsuarioWeb_Agentes1`
    FOREIGN KEY (`Agentes_id` )
    REFERENCES `web_red_VF`.`Agentes` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UsuarioWeb_Coordinador1`
    FOREIGN KEY (`Coordinador_id` )
    REFERENCES `web_red_VF`.`Coordinador` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UsuarioWeb_Agencias1`
    FOREIGN KEY (`Agencias_id` )
    REFERENCES `web_red_VF`.`Agencias` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UsuarioWeb_Tipo_UsuariosWeb1`
    FOREIGN KEY (`Tipo_Usuario_id` )
    REFERENCES `web_red_VF`.`Tipo_Usuario` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Clasi_Q`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Clasi_Q` (
  `id` INT NOT NULL ,
  `tipo` VARCHAR(4) NOT NULL COMMENT 'ENUM(\\\'RED\\\',\\n\\\'BASE\\\',\\n\\\'KO\\\')' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Q1`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Q1` (
  `Res_Agencia_Mes_Agencias_id` INT NOT NULL ,
  `Res_Agencia_Mes_Ej_Fiscal_id` TINYINT(4) NOT NULL ,
  `Res_Agencia_Mes_mes` TINYINT(4) NOT NULL ,
  `Clasi_Q_id` INT NOT NULL ,
  PRIMARY KEY (`Res_Agencia_Mes_Agencias_id`, `Res_Agencia_Mes_Ej_Fiscal_id`, `Res_Agencia_Mes_mes`, `Clasi_Q_id`) ,
  INDEX `fk_Q1_Clasi_Q1_idx` (`Clasi_Q_id` ASC) ,
  CONSTRAINT `fk_Q1_3_Res_Agencia_Mes1`
    FOREIGN KEY (`Res_Agencia_Mes_Agencias_id` , `Res_Agencia_Mes_Ej_Fiscal_id` , `Res_Agencia_Mes_mes` )
    REFERENCES `web_red_VF`.`Res_Agencia_Mes` (`Agencias_id` , `Ej_Fiscal_id` , `mes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Q1_Clasi_Q1`
    FOREIGN KEY (`Clasi_Q_id` )
    REFERENCES `web_red_VF`.`Clasi_Q` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Q2`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Q2` (
  `Res_Agencia_Mes_Agencias_id` INT NOT NULL ,
  `Res_Agencia_Mes_Ej_Fiscal_id` TINYINT(4) NOT NULL ,
  `Res_Agencia_Mes_mes` TINYINT(4) NOT NULL ,
  `Clasi_Q_id` INT NOT NULL ,
  PRIMARY KEY (`Res_Agencia_Mes_Agencias_id`, `Res_Agencia_Mes_Ej_Fiscal_id`, `Res_Agencia_Mes_mes`, `Clasi_Q_id`) ,
  INDEX `fk_Q1_Clasi_Q1_idx` (`Clasi_Q_id` ASC) ,
  CONSTRAINT `fk_Q1_3_Res_Agencia_Mes10`
    FOREIGN KEY (`Res_Agencia_Mes_Agencias_id` , `Res_Agencia_Mes_Ej_Fiscal_id` , `Res_Agencia_Mes_mes` )
    REFERENCES `web_red_VF`.`Res_Agencia_Mes` (`Agencias_id` , `Ej_Fiscal_id` , `mes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Q1_Clasi_Q10`
    FOREIGN KEY (`Clasi_Q_id` )
    REFERENCES `web_red_VF`.`Clasi_Q` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `web_red_VF`.`Q3`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `web_red_VF`.`Q3` (
  `Res_Agencia_Mes_Agencias_id` INT NOT NULL ,
  `Res_Agencia_Mes_Ej_Fiscal_id` TINYINT(4) NOT NULL ,
  `Res_Agencia_Mes_mes` TINYINT(4) NOT NULL ,
  `Clasi_Q_id` INT NOT NULL ,
  PRIMARY KEY (`Res_Agencia_Mes_Agencias_id`, `Res_Agencia_Mes_Ej_Fiscal_id`, `Res_Agencia_Mes_mes`, `Clasi_Q_id`) ,
  INDEX `fk_Q1_Clasi_Q1_idx` (`Clasi_Q_id` ASC) ,
  CONSTRAINT `fk_Q1_3_Res_Agencia_Mes100`
    FOREIGN KEY (`Res_Agencia_Mes_Agencias_id` , `Res_Agencia_Mes_Ej_Fiscal_id` , `Res_Agencia_Mes_mes` )
    REFERENCES `web_red_VF`.`Res_Agencia_Mes` (`Agencias_id` , `Ej_Fiscal_id` , `mes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Q1_Clasi_Q100`
    FOREIGN KEY (`Clasi_Q_id` )
    REFERENCES `web_red_VF`.`Clasi_Q` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
