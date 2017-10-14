CREATE DATABASE  IF NOT EXISTS `scbastosdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `scbastosdb`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: scbastosdb
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bairro`
--

DROP TABLE IF EXISTS bairro;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE bairro (
  id_bairro bigint(20) NOT NULL,
  id_municipio bigint(20) NOT NULL,
  nome_bairro varchar(45) NOT NULL,
  PRIMARY KEY (id_bairro),
  KEY fk_bairro_municipio1_idx (id_municipio),
  CONSTRAINT fk_bairro_municipio1 FOREIGN KEY (id_municipio) REFERENCES municipio (id_municipio) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS endereco;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE endereco (
  id_endereco bigint(20) NOT NULL AUTO_INCREMENT,
  id_bairro bigint(20) NOT NULL,
  logradouro varchar(100) NOT NULL,
  cep varchar(9) NOT NULL,
  numero varchar(10) NOT NULL,
  complemento varchar(45) DEFAULT NULL,
  data_cadastro datetime DEFAULT NULL,
  PRIMARY KEY (id_endereco),
  KEY fk_endereco_bairro1_idx (id_bairro),
  CONSTRAINT fk_endereco_bairro1 FOREIGN KEY (id_bairro) REFERENCES bairro (id_bairro) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS grupo;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE grupo (
  id_grupo bigint(20) NOT NULL,
  nome varchar(45) NOT NULL,
  PRIMARY KEY (id_grupo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grupo_permissao`
--

DROP TABLE IF EXISTS grupo_permissao;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE grupo_permissao (
  id_grupo bigint(20) NOT NULL,
  id_permissao bigint(20) NOT NULL,
  PRIMARY KEY (id_grupo,id_permissao),
  KEY fk_grupo_permissao_permissao1_idx (id_permissao),
  CONSTRAINT fk_grupo_permissao_grupo1 FOREIGN KEY (id_grupo) REFERENCES grupo (id_grupo) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_grupo_permissao_permissao1 FOREIGN KEY (id_permissao) REFERENCES permissao (id_permissao) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `imovel`
--

DROP TABLE IF EXISTS imovel;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE imovel (
  id_imovel bigint(20) NOT NULL AUTO_INCREMENT,
  id_proprietario bigint(20) NOT NULL,
  id_endereco bigint(20) NOT NULL,
  id_valor bigint(20) NOT NULL,
  id_usuario bigint(20) NOT NULL,
  codigosc bigint(20) NOT NULL,
  matricula varchar(45) NOT NULL,
  insc_imob varchar(45) NOT NULL,
  tipo_imovel varchar(45) DEFAULT NULL,
  exclusividade_imovel varchar(45) NOT NULL,
  data_captacao date DEFAULT NULL,
  data_cadastro datetime DEFAULT CURRENT_TIMESTAMP,
  idade_imovel int(11) DEFAULT NULL,
  `status` varchar(45) NOT NULL,
  destinacao varchar(45) DEFAULT NULL,
  area_total decimal(10,2) DEFAULT NULL,
  garagem int(11) NOT NULL,
  situacao varchar(45) DEFAULT NULL,
  classificacao varchar(45) DEFAULT NULL,
  conservacao varchar(45) DEFAULT NULL,
  foto varchar(500) DEFAULT NULL,
  content_type varchar(100) DEFAULT NULL,
  corretor varchar(45) NOT NULL,
  descricao varchar(1000) DEFAULT NULL,
  PRIMARY KEY (id_imovel),
  UNIQUE KEY codigosc_UNIQUE (codigosc),
  UNIQUE KEY matricula_UNIQUE (matricula),
  UNIQUE KEY insc_imob_UNIQUE (insc_imob),
  KEY fk_imovel_endereco_idx (id_endereco),
  KEY fk_imovel_valor1_idx (id_valor),
  KEY fk_imovel_proprietario1_idx (id_proprietario),
  KEY fk_imovel_usuario1_idx (id_usuario),
  CONSTRAINT fk_imovel_endereco FOREIGN KEY (id_endereco) REFERENCES endereco (id_endereco) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_imovel_proprietario1 FOREIGN KEY (id_proprietario) REFERENCES proprietario (id_proprietario) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_imovel_usuario1 FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_imovel_valor1 FOREIGN KEY (id_valor) REFERENCES valor (id_valor) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `imovel_dependencia`
--

DROP TABLE IF EXISTS imovel_dependencia;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE imovel_dependencia (
  id_imovel bigint(20) NOT NULL,
  nomeDependencia varchar(45) DEFAULT NULL,
  area decimal(10,2) DEFAULT NULL,
  qtdDependencia int(11) DEFAULT NULL,
  tipoPiso varchar(45) DEFAULT NULL,
  comprimento decimal(10,2) DEFAULT NULL,
  largura decimal(10,2) DEFAULT NULL,
  altura decimal(10,2) DEFAULT NULL,
  KEY fk_imovel_dependencia_imovel1_idx (id_imovel),
  CONSTRAINT fk_imovel_dependencia_imovel1 FOREIGN KEY (id_imovel) REFERENCES imovel (id_imovel) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS municipio;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE municipio (
  id_municipio bigint(20) NOT NULL,
  nome_municipio varchar(45) NOT NULL,
  PRIMARY KEY (id_municipio)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS permissao;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE permissao (
  id_permissao bigint(20) NOT NULL,
  nome varchar(45) NOT NULL,
  PRIMARY KEY (id_permissao)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `proprietario`
--

DROP TABLE IF EXISTS proprietario;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE proprietario (
  id_proprietario bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(100) NOT NULL,
  telefone varchar(15) NOT NULL,
  email varchar(100) DEFAULT NULL,
  cpf varchar(14) NOT NULL,
  data_cadastro datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id_proprietario),
  UNIQUE KEY cpf_UNIQUE (cpf)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS usuario;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE usuario (
  id_usuario bigint(20) NOT NULL AUTO_INCREMENT,
  senha varchar(120) NOT NULL,
  nome varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  ativo tinyint(1) NOT NULL DEFAULT '1',
  data_cadastro datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  cpf varchar(14) NOT NULL,
  telefone varchar(45) NOT NULL,
  data_nascimento date DEFAULT NULL,
  PRIMARY KEY (id_usuario),
  UNIQUE KEY cpf_UNIQUE (cpf),
  UNIQUE KEY email_UNIQUE (email)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario_grupo`
--

DROP TABLE IF EXISTS usuario_grupo;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE usuario_grupo (
  id_usuario bigint(20) NOT NULL,
  id_grupo bigint(20) NOT NULL,
  PRIMARY KEY (id_usuario,id_grupo),
  KEY fk_usuario_grupo_grupo1_idx (id_grupo),
  CONSTRAINT fk_usuario_grupo_grupo1 FOREIGN KEY (id_grupo) REFERENCES grupo (id_grupo) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_usuario_grupo_usuario1 FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `valor`
--

DROP TABLE IF EXISTS valor;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE valor (
  id_valor bigint(20) NOT NULL AUTO_INCREMENT,
  valor_atual decimal(10,2) NOT NULL,
  sinal decimal(10,2) DEFAULT NULL,
  prazo_financiamento int(11) DEFAULT NULL,
  quitado varchar(45) NOT NULL,
  saldo_devedor decimal(10,2) DEFAULT NULL,
  org_financeira varchar(45) DEFAULT NULL,
  data_inclusao_valor datetime NOT NULL,
  PRIMARY KEY (id_valor)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Tgr_ValorHistorico_Insert AFTER INSERT
ON scbastosdb.valor
FOR EACH ROW
BEGIN
	INSERT INTO scbastosdb.valor_historico (
    valor_historico,
    data_alteracao_valor,
    id_valor
    )
    
   VALUES (
   NEW.valor_atual,
   NOW(),
   NEW.id_valor);
   
   
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER Tgr_Valores_Update AFTER UPDATE
ON scbastosdb.valor
FOR EACH ROW
BEGIN
	IF (NEW.valor_atual != OLD.valor_atual) THEN
		INSERT INTO scbastosdb.valor_historico (
		valor_historico,
		data_alteracao_valor,
		id_valor
		)
    
		VALUES (
		NEW.valor_atual,
		now(), 
		NEW.id_valor);
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `valor_historico`
--

DROP TABLE IF EXISTS valor_historico;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE valor_historico (
  id_valor_historico bigint(20) NOT NULL AUTO_INCREMENT,
  id_valor bigint(20) NOT NULL,
  valor_historico decimal(10,2) NOT NULL,
  data_alteracao_valor datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id_valor_historico),
  KEY fk_valor_historico_valor1_idx (id_valor),
  CONSTRAINT fk_valor_historico_valor1 FOREIGN KEY (id_valor) REFERENCES valor (id_valor) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-13 14:10:33
