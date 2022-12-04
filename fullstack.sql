-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 04, 2022 alle 04:21
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
  `testo` text NOT NULL,
  `idquestionariAdmin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `domande`
--

INSERT INTO `domande` (`iddomanda`, `testo`, `idquestionariAdmin`) VALUES
(7, 'Come ti sei trovato?', 1),
(8, 'Come è stato il nostro sito?', 1),
(9, 'Di dove sei?', 2),
(10, 'Come è stato il sito?', 2);

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
-- Struttura della tabella `questionariadmin`
--

CREATE TABLE `questionariadmin` (
  `idquestionariAdmin` int(11) NOT NULL,
  `titolo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `questionariadmin`
--

INSERT INTO `questionariadmin` (`idquestionariAdmin`, `titolo`) VALUES
(1, 'Questionario 1'),
(2, 'Questionario 2');

-- --------------------------------------------------------

--
-- Struttura della tabella `risposte`
--

CREATE TABLE `risposte` (
  `idrisposta` int(11) NOT NULL,
  `iddomanda` int(11) NOT NULL,
  `idquestionario` int(11) NOT NULL,
  `voto` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

--
-- Dump dei dati per la tabella `tokens`
--

INSERT INTO `tokens` (`idtoken`, `idutente`, `valore`, `data`) VALUES
(1, 3, 'lJBKGXaEeiY=', '2022-12-01 12:40:47'),
(2, 3, 'bPTaW5qszSI=', '2022-12-04 04:14:09');

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
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`idutente`, `nome`, `cognome`, `email`, `password`) VALUES
(3, 'Antonio', 'de Biase', 'antoniodebiase2003@gmail.com', 'e10adc3949ba59abbe56e057f20f883e');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `domande`
--
ALTER TABLE `domande`
  ADD PRIMARY KEY (`iddomanda`),
  ADD KEY `fk_questionariAdmin` (`idquestionariAdmin`);

--
-- Indici per le tabelle `questionari`
--
ALTER TABLE `questionari`
  ADD PRIMARY KEY (`idquestionario`),
  ADD KEY `idutente` (`idutente`);

--
-- Indici per le tabelle `questionariadmin`
--
ALTER TABLE `questionariadmin`
  ADD PRIMARY KEY (`idquestionariAdmin`);

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
  MODIFY `iddomanda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `questionari`
--
ALTER TABLE `questionari`
  MODIFY `idquestionario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `questionariadmin`
--
ALTER TABLE `questionariadmin`
  MODIFY `idquestionariAdmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `tokens`
--
ALTER TABLE `tokens`
  MODIFY `idtoken` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `utenti`
--
ALTER TABLE `utenti`
  MODIFY `idutente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `domande`
--
ALTER TABLE `domande`
  ADD CONSTRAINT `fk_questionariAdmin` FOREIGN KEY (`idquestionariAdmin`) REFERENCES `questionariadmin` (`idquestionariAdmin`);

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
