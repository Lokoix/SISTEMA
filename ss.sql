-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.28-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para se7i
CREATE DATABASE IF NOT EXISTS `se7i` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `se7i`;

-- Copiando estrutura para tabela se7i.bloqueios
CREATE TABLE IF NOT EXISTS `bloqueios` (
  `pkbloqueio` int(11) NOT NULL AUTO_INCREMENT,
  `fkrestricao` int(11) NOT NULL,
  `fklote` int(11) NOT NULL,
  `txprocesso` varchar(30) DEFAULT NULL,
  `txoficio` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pkbloqueio`),
  KEY `fk_bloqueios_restricoes` (`fkrestricao`),
  KEY `fk_bloqueios_lotes` (`fklote`),
  CONSTRAINT `fk_bloqueios_lotes` FOREIGN KEY (`fklote`) REFERENCES `lotes` (`pklote`),
  CONSTRAINT `fk_bloqueios_restricoes` FOREIGN KEY (`fkrestricao`) REFERENCES `restricoes` (`pkrestricao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela se7i.cidades
CREATE TABLE IF NOT EXISTS `cidades` (
  `pkcidade` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `estado` char(2) NOT NULL,
  PRIMARY KEY (`pkcidade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela se7i.judiciais
CREATE TABLE IF NOT EXISTS `judiciais` (
  `pkjudicial` int(11) NOT NULL AUTO_INCREMENT,
  `fkrestricao` int(11) NOT NULL,
  `fklote` int(11) NOT NULL,
  `txprocesso` varchar(30) DEFAULT NULL,
  `txorgao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pkjudicial`),
  KEY `fk_judiciais_restricoes` (`fkrestricao`),
  KEY `fk_judiciais_lotes` (`fklote`),
  CONSTRAINT `fk_judiciais_lotes` FOREIGN KEY (`fklote`) REFERENCES `lotes` (`pklote`),
  CONSTRAINT `fk_judiciais_restricoes` FOREIGN KEY (`fkrestricao`) REFERENCES `restricoes` (`pkrestricao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela se7i.lotes
CREATE TABLE IF NOT EXISTS `lotes` (
  `pklote` int(11) NOT NULL AUTO_INCREMENT,
  `fkproprietario` int(11) DEFAULT NULL,
  `fkveiculo` int(11) DEFAULT NULL,
  `observacao` varchar(100) DEFAULT NULL,
  `dtcadlote` date NOT NULL,
  `numero` int(11) NOT NULL,
  PRIMARY KEY (`pklote`),
  KEY `fkproprietario` (`fkproprietario`),
  KEY `fkveiculo` (`fkveiculo`),
  CONSTRAINT `lotes_ibfk_1` FOREIGN KEY (`fkproprietario`) REFERENCES `proprietarios` (`pkproprietario`),
  CONSTRAINT `lotes_ibfk_2` FOREIGN KEY (`fkveiculo`) REFERENCES `veiculos` (`pkveiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela se7i.proprietarios
CREATE TABLE IF NOT EXISTS `proprietarios` (
  `pkproprietario` int(11) NOT NULL AUTO_INCREMENT,
  `fkcidade` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `rg` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pkproprietario`),
  KEY `fkcidade` (`fkcidade`),
  CONSTRAINT `proprietarios_ibfk_1` FOREIGN KEY (`fkcidade`) REFERENCES `cidades` (`pkcidade`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela se7i.restricoes
CREATE TABLE IF NOT EXISTS `restricoes` (
  `pkrestricao` int(11) NOT NULL AUTO_INCREMENT,
  `txdescricao` varchar(45) NOT NULL,
  `txtipo` varchar(4) NOT NULL,
  PRIMARY KEY (`pkrestricao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela se7i.veiculos
CREATE TABLE IF NOT EXISTS `veiculos` (
  `pkveiculo` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(7) DEFAULT NULL,
  `fkcidade` int(11) DEFAULT NULL,
  `fkproprietario` int(11) DEFAULT NULL,
  PRIMARY KEY (`pkveiculo`),
  KEY `fkcidade` (`fkcidade`),
  KEY `fkproprietario` (`fkproprietario`),
  CONSTRAINT `veiculos_ibfk_1` FOREIGN KEY (`fkcidade`) REFERENCES `cidades` (`pkcidade`),
  CONSTRAINT `veiculos_ibfk_2` FOREIGN KEY (`fkproprietario`) REFERENCES `proprietarios` (`pkproprietario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
