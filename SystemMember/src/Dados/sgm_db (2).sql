-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Máquina: 127.0.0.1
-- Data de Criação: 13-Dez-2013 às 19:51
-- Versão do servidor: 5.5.32
-- versão do PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `sgm_db`
--
CREATE DATABASE IF NOT EXISTS `sgm_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sgm_db`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE IF NOT EXISTS `disciplina` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ID_MEMBRO` int(11) NOT NULL,
  `DATA_INICIO` varchar(15) NOT NULL,
  `DATA_FIM` varchar(15) DEFAULT NULL,
  `DESCRICAO` text NOT NULL,
  `STATUS` varchar(15) NOT NULL,
  `ID_ANTERIOR` int(11) DEFAULT NULL,
  `STATUS_HISTORICO` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `evento`
--

CREATE TABLE IF NOT EXISTS `evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `TIPO` varchar(45) NOT NULL,
  `ID_MEMBRO` int(11) DEFAULT NULL,
  `INICIO_DATA` varchar(45) DEFAULT NULL,
  `FIM_DATA` varchar(45) DEFAULT NULL,
  `DESCRICAO` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `membro`
--

CREATE TABLE IF NOT EXISTS `membro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL,
  `NOMEPAI` varchar(45) DEFAULT NULL,
  `NOMEMAE` varchar(45) NOT NULL,
  `CPF` varchar(45) NOT NULL,
  `RG` varchar(45) NOT NULL,
  `DATABATISMO` varchar(45) NOT NULL,
  `DATANASCIMENTO` varchar(45) NOT NULL,
  `CONGREGACAO` varchar(45) NOT NULL,
  `NATURALIDADE` varchar(45) NOT NULL,
  `STATUS` varchar(45) NOT NULL,
  `FOTO` blob,
  `SEXO` varchar(45) NOT NULL,
  `TELEFONE` varchar(45) DEFAULT NULL,
  `ID_ANTERIOR` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Extraindo dados da tabela `membro`
--

INSERT INTO `membro` (`id`, `NOME`, `NOMEPAI`, `NOMEMAE`, `CPF`, `RG`, `DATABATISMO`, `DATANASCIMENTO`, `CONGREGACAO`, `NATURALIDADE`, `STATUS`, `FOTO`, `SEXO`, `TELEFONE`, `ID_ANTERIOR`) VALUES
(1, 'Arlindo', 'Arlindo', 'TEste', '05119869556', '01231231', '13/10/2213', '13/10/1990', '12312', 'Teste ', 'ANTIGO', NULL, 'Masculino', '(71)8732-2121', NULL),
(2, 'Arlindo', 'Arlindo', 'TEste', '722.567.591-56', '01231231', '13/10/2213', '13/10/1990', '12312', 'Teste ', 'ANTIGO', NULL, 'Masculino', '(71)8732-2121', NULL),
(8, 'Arlindo', 'Arlindo', 'TEste', '722.567.591-56', '01231231', '13/10/2213', '13/10/1990', '12312', 'Teste ', 'ATUAL', NULL, 'Masculino', '(71)8732-2121', 2),
(9, 'Arlindo', 'Arlindo', 'TEste', '05119869556', '01231231', '13/10/2213', '13/10/1990', '12312', 'Teste ', 'ANTIGO', NULL, 'Masculino', '(71)8743-6712', 1),
(10, 'Arlindo', 'Arlindo', 'TEste', '05119869556', '01231231', '13/10/2213', '13/10/1990', '12312', 'Brasileiro', 'ATUAL', NULL, 'Masculino', '(71)8743-6712', 9);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
