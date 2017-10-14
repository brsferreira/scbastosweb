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
-- Dumping data for table `bairro`
--

LOCK TABLES bairro WRITE;
/*!40000 ALTER TABLE bairro DISABLE KEYS */;
INSERT INTO bairro VALUES (1,1,'Alcântara'),(2,1,'Antonina'),(3,1,'Bairro das Palmeiras'),(4,1,'Boaçu'),(5,1,'Brasilândia'),(6,1,'Centro'),(7,1,'Colubandê'),(8,1,'Cruzeiro do Sul'),(9,1,'Estrela do Norte'),(10,1,'Fazenda dos Mineiros'),(11,1,'Galo Branco'),(12,1,'Itaoca'),(13,1,'Itaúna'),(14,1,'Jardim Alcântara'),(15,1,'Lindo Parque'),(16,1,'Luiz Caçador'),(17,1,'Mutuá'),(18,1,'Mutuaguaçu'),(19,1,'Mutuapira'),(20,1,'Mutondo'),(21,1,'Nova Cidade'),(22,1,'Porto do Rosa'),(23,1,'Recanto das Acácias'),(24,1,'Rocha'),(25,1,'Rosane'),(26,1,'Salgueiro'),(27,1,'São Miguel'),(28,1,'Tribobó'),(29,1,'Trindade'),(30,1,'Vila Iara'),(31,1,'Zé Garoto');
/*!40000 ALTER TABLE bairro ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `endereco`
--

LOCK TABLES endereco WRITE;
/*!40000 ALTER TABLE endereco DISABLE KEYS */;
INSERT INTO endereco VALUES (9,4,'Rua Ari Coutinho','35680-343','162','Teste23','2017-10-04 22:47:50'),(10,9,'Rua Concórdia','43534-544','2432','','2017-10-04 22:53:06'),(11,9,'ghfghggg','44353-455','435','','2017-10-04 23:18:07'),(12,9,'ghfghggg','44353-455','435','','2017-10-04 23:24:23'),(13,18,'Rua José Anchieta','23444-234','233','','2017-10-12 18:36:14'),(14,1,'sdfsdfsdf','34444-444','3453','33','2017-10-12 18:42:57'),(15,1,'Rua Felipe Camarão, 853','34534-534','853','bloco 3','2017-10-12 18:53:22'),(17,1,'sdfsdfsdf','34444-444','3453','33','2017-10-12 19:30:03'),(18,13,'Rua João Lopes Hidalgo, 1081','23442-344','1081','bloco 3','2017-10-12 19:57:15'),(19,13,'Rua João Lopes Hidalgo, 1081','23442-344','1081','bloco 3','2017-10-12 20:01:01'),(25,1,'Rua Fernando Febeliano da Costa','23423-442','972','bloco 3','2017-10-12 22:55:32'),(28,1,'werwer','23423-423','234','43','2017-10-13 01:54:20');
/*!40000 ALTER TABLE endereco ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `grupo`
--

LOCK TABLES grupo WRITE;
/*!40000 ALTER TABLE grupo DISABLE KEYS */;
INSERT INTO grupo VALUES (1,'administrador'),(2,'corretor');
/*!40000 ALTER TABLE grupo ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `grupo_permissao`
--

LOCK TABLES grupo_permissao WRITE;
/*!40000 ALTER TABLE grupo_permissao DISABLE KEYS */;
INSERT INTO grupo_permissao VALUES (1,1);
/*!40000 ALTER TABLE grupo_permissao ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `imovel`
--

LOCK TABLES imovel WRITE;
/*!40000 ALTER TABLE imovel DISABLE KEYS */;
/*!40000 ALTER TABLE imovel ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `imovel_dependencia`
--

LOCK TABLES imovel_dependencia WRITE;
/*!40000 ALTER TABLE imovel_dependencia DISABLE KEYS */;
/*!40000 ALTER TABLE imovel_dependencia ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `municipio`
--

LOCK TABLES municipio WRITE;
/*!40000 ALTER TABLE municipio DISABLE KEYS */;
INSERT INTO municipio VALUES (1,'São Gonçalo');
/*!40000 ALTER TABLE municipio ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `permissao`
--

LOCK TABLES permissao WRITE;
/*!40000 ALTER TABLE permissao DISABLE KEYS */;
INSERT INTO permissao VALUES (1,'CADASTRAR_USUARIO');
/*!40000 ALTER TABLE permissao ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `proprietario`
--

LOCK TABLES proprietario WRITE;
/*!40000 ALTER TABLE proprietario DISABLE KEYS */;
/*!40000 ALTER TABLE proprietario ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `usuario`
--

LOCK TABLES usuario WRITE;
/*!40000 ALTER TABLE usuario DISABLE KEYS */;
INSERT INTO usuario VALUES (1,'$2a$10$sjg8CcBR2SfKd66Z4FV2AOtTiq8R5Dq80QyMwDtuO5OPsPGrxFp6O','admin','admin@scbastos.com',1,'2017-09-15 00:00:00','97216952626','(21) 9878-4657',NULL);
/*!40000 ALTER TABLE usuario ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `usuario_grupo`
--

LOCK TABLES usuario_grupo WRITE;
/*!40000 ALTER TABLE usuario_grupo DISABLE KEYS */;
INSERT INTO usuario_grupo VALUES (1,1),(1,2);
/*!40000 ALTER TABLE usuario_grupo ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Dumping data for table `valor`
--

LOCK TABLES valor WRITE;
/*!40000 ALTER TABLE valor DISABLE KEYS */;
/*!40000 ALTER TABLE valor ENABLE KEYS */;
UNLOCK TABLES;
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

--
-- Dumping data for table `valor_historico`
--

LOCK TABLES valor_historico WRITE;
/*!40000 ALTER TABLE valor_historico DISABLE KEYS */;
/*!40000 ALTER TABLE valor_historico ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-13 14:11:55
