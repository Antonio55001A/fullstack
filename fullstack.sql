-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Nov 29, 2022 alle 16:46
-- Versione del server: 10.4.25-MariaDB
-- Versione PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fullstack`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `domande`
--

CREATE TABLE `domande` (
  `iddomanda` int(11) NOT NULL,
  `testo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `questionari`
--

CREATE TABLE `questionari` (
  `idquestionario` int(11) NOT NULL,
  `idutente` int(11) NOT NULL,
  `data` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `risposte`
--

CREATE TABLE `risposte` (
  `idrisposta` int(11) NOT NULL,
  `iddomanda` int(11) NOT NULL,
  `idquestionario` int(11) NOT NULL,
  `voto` tinyint(4) NOT NULL
) ;

-- --------------------------------------------------------

--
-- Struttura della tabella `tokens`
--

CREATE TABLE `tokens` (
  `idtoken` int(11) NOT NULL,
  `idutente` int(11) NOT NULL,
  `valore` char(12) NOT NULL,
  `data` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `idutente` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `domande`
--
ALTER TABLE `domande`
  ADD PRIMARY KEY (`iddomanda`);

--
-- Indici per le tabelle `questionari`
--
ALTER TABLE `questionari`
  ADD PRIMARY KEY (`idquestionario`),
  ADD KEY `idutente` (`idutente`);

--
-- Indici per le tabelle `risposte`
--
ALTER TABLE `risposte`
  ADD KEY `idquestionario` (`idquestionario`),
  ADD KEY `iddomanda` (`iddomanda`);

--
-- Indici per le tabelle `tokens`
--
ALTER TABLE `tokens`
  ADD PRIMARY KEY (`idtoken`),
  ADD KEY `idutente` (`idutente`);

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`idutente`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `domande`
--
ALTER TABLE `domande`
  MODIFY `iddomanda` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `questionari`
--
ALTER TABLE `questionari`
  MODIFY `idquestionario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `tokens`
--
ALTER TABLE `tokens`
  MODIFY `idtoken` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `utenti`
--
ALTER TABLE `utenti`
  MODIFY `idutente` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `questionari`
--
ALTER TABLE `questionari`
  ADD CONSTRAINT `questionari_ibfk_1` FOREIGN KEY (`idutente`) REFERENCES `utenti` (`idutente`);

--
-- Limiti per la tabella `risposte`
--
ALTER TABLE `risposte`
  ADD CONSTRAINT `risposte_ibfk_1` FOREIGN KEY (`idquestionario`) REFERENCES `questionari` (`idquestionario`),
  ADD CONSTRAINT `risposte_ibfk_2` FOREIGN KEY (`iddomanda`) REFERENCES `domande` (`iddomanda`);

--
-- Limiti per la tabella `tokens`
--
ALTER TABLE `tokens`
  ADD CONSTRAINT `tokens_ibfk_1` FOREIGN KEY (`idutente`) REFERENCES `utenti` (`idutente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
