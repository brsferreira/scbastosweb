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
-- Dumping data for table `bairro`
--

LOCK TABLES bairro WRITE;
/*!40000 ALTER TABLE bairro DISABLE KEYS */;
INSERT INTO bairro VALUES (1,1,'Alcântara'),(2,1,'Antonina'),(3,1,'Bairro das Palmeiras'),(4,1,'Boaçu'),(5,1,'Brasilândia'),(6,1,'Centro'),(7,1,'Colubandê'),(8,1,'Cruzeiro do Sul'),(9,1,'Estrela do Norte'),(10,1,'Fazenda dos Mineiros'),(11,1,'Galo Branco'),(12,1,'Itaoca'),(13,1,'Itaúna'),(14,1,'Jardim Alcântara'),(15,1,'Lindo Parque'),(16,1,'Luiz Caçador'),(17,1,'Mutuá'),(18,1,'Mutuaguaçu'),(19,1,'Mutuapira'),(20,1,'Mutondo'),(21,1,'Nova Cidade'),(22,1,'Porto do Rosa'),(23,1,'Recanto das Acácias'),(24,1,'Rocha'),(25,1,'Rosane'),(26,1,'Salgueiro'),(27,1,'São Miguel'),(28,1,'Tribobó'),(29,1,'Trindade'),(30,1,'Vila Iara'),(31,1,'Zé Garoto');
/*!40000 ALTER TABLE bairro ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `endereco`
--

LOCK TABLES endereco WRITE;
/*!40000 ALTER TABLE endereco DISABLE KEYS */;
INSERT INTO endereco VALUES (9,4,'Rua Ari Coutinho','35680-343','162','Teste23','2017-10-04 22:47:50'),(10,9,'Rua Concórdia','43534-544','2432','','2017-10-04 22:53:06'),(11,9,'ghfghggg','44353-455','435','','2017-10-04 23:18:07'),(12,9,'ghfghggg','44353-455','435','','2017-10-04 23:24:23'),(13,18,'Rua José Anchieta','23444-234','233','','2017-10-12 18:36:14'),(14,1,'sdfsdfsdf','34444-444','3453','33','2017-10-12 18:42:57'),(15,1,'Rua Felipe Camarão, 853','34534-534','853','bloco 3','2017-10-12 18:53:22'),(17,1,'sdfsdfsdf','34444-444','3453','33','2017-10-12 19:30:03'),(18,13,'Rua João Lopes Hidalgo, 1081','23442-344','1081','bloco 3','2017-10-12 19:57:15'),(19,13,'Rua João Lopes Hidalgo, 1081','23442-344','1081','bloco 3','2017-10-12 20:01:01'),(25,1,'Rua Fernando Febeliano da Costa','23423-442','972','bloco 3','2017-10-12 22:55:32'),(28,1,'werwer','23423-423','234','43','2017-10-13 01:54:20');
/*!40000 ALTER TABLE endereco ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `grupo`
--

LOCK TABLES grupo WRITE;
/*!40000 ALTER TABLE grupo DISABLE KEYS */;
INSERT INTO grupo VALUES (1,'administrador'),(2,'corretor');
/*!40000 ALTER TABLE grupo ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `grupo_permissao`
--

LOCK TABLES grupo_permissao WRITE;
/*!40000 ALTER TABLE grupo_permissao DISABLE KEYS */;
INSERT INTO grupo_permissao VALUES (1,1);
/*!40000 ALTER TABLE grupo_permissao ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `imovel`
--

LOCK TABLES imovel WRITE;
/*!40000 ALTER TABLE imovel DISABLE KEYS */;
/*!40000 ALTER TABLE imovel ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `imovel_dependencia`
--

LOCK TABLES imovel_dependencia WRITE;
/*!40000 ALTER TABLE imovel_dependencia DISABLE KEYS */;
/*!40000 ALTER TABLE imovel_dependencia ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `municipio`
--

LOCK TABLES municipio WRITE;
/*!40000 ALTER TABLE municipio DISABLE KEYS */;
INSERT INTO municipio VALUES (1,'São Gonçalo');
/*!40000 ALTER TABLE municipio ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permissao`
--

LOCK TABLES permissao WRITE;
/*!40000 ALTER TABLE permissao DISABLE KEYS */;
INSERT INTO permissao VALUES (1,'CADASTRAR_USUARIO');
/*!40000 ALTER TABLE permissao ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `proprietario`
--

LOCK TABLES proprietario WRITE;
/*!40000 ALTER TABLE proprietario DISABLE KEYS */;
/*!40000 ALTER TABLE proprietario ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

LOCK TABLES usuario WRITE;
/*!40000 ALTER TABLE usuario DISABLE KEYS */;
INSERT INTO usuario VALUES (1,'$2a$10$sjg8CcBR2SfKd66Z4FV2AOtTiq8R5Dq80QyMwDtuO5OPsPGrxFp6O','admin','admin@scbastos.com',1,'2017-09-15 00:00:00','97216952626','(21) 9878-4657',NULL);
/*!40000 ALTER TABLE usuario ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario_grupo`
--

LOCK TABLES usuario_grupo WRITE;
/*!40000 ALTER TABLE usuario_grupo DISABLE KEYS */;
INSERT INTO usuario_grupo VALUES (1,1),(1,2);
/*!40000 ALTER TABLE usuario_grupo ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2017-10-13 14:11:10
