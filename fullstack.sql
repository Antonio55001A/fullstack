-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 10, 2022 alle 13:27
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
  `idquestionariAdmin` int(11) NOT NULL,
  `data` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `questionari`
--

INSERT INTO `questionari` (`idquestionario`, `idutente`, `idquestionariAdmin`, `data`) VALUES
(1, 4, 2, '2022-12-06 18:54:49'),
(2, 4, 2, '2022-12-08 14:50:59'),
(3, 4, 1, '2022-12-08 15:25:39'),
(4, 5, 1, '2022-12-10 13:21:04');

-- --------------------------------------------------------

--
-- Struttura della tabella `questionariadmin`
--

CREATE TABLE `questionariadmin` (
  `idquestionariAdmin` int(11) NOT NULL,
  `titolo` varchar(45) NOT NULL,
  `stato` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `questionariadmin`
--

INSERT INTO `questionariadmin` (`idquestionariAdmin`, `titolo`, `stato`) VALUES
(1, 'Questionario 1', b'1'),
(2, 'Questionario 2', b'0');

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

--
-- Dump dei dati per la tabella `risposte`
--

INSERT INTO `risposte` (`idrisposta`, `iddomanda`, `idquestionario`, `voto`) VALUES
(1, 9, 1, 4),
(2, 10, 1, 5),
(3, 9, 2, 3),
(4, 10, 2, 3),
(5, 7, 3, 5),
(6, 8, 3, 3),
(7, 7, 4, 4),
(8, 8, 4, 5);

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
(3, 'Antonio', 'de Biase', 'antoniodebiase2003@gmail.com', 'e10adc3949ba59abbe56e057f20f883e'),
(4, 'Fabio', 'Fiorattini', 'fabio@mail.com', '42e08734abcd844e77432cb050e7747e'),
(5, 'Hakim', 'Hamse', 'Hakim@mail.com', '218b8847b3a743fea25f6e0b33ed3bae');

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
  ADD KEY `idutente` (`idutente`),
  ADD KEY `idquestionariAdmin` (`idquestionariAdmin`);

--
-- Indici per le tabelle `questionariadmin`
--
ALTER TABLE `questionariadmin`
  ADD PRIMARY KEY (`idquestionariAdmin`);

--
-- Indici per le tabelle `risposte`
--
ALTER TABLE `risposte`
  ADD PRIMARY KEY (`idrisposta`),
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
  MODIFY `idquestionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `questionariadmin`
--
ALTER TABLE `questionariadmin`
  MODIFY `idquestionariAdmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `risposte`
--
ALTER TABLE `risposte`
  MODIFY `idrisposta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT per la tabella `tokens`
--
ALTER TABLE `tokens`
  MODIFY `idtoken` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `utenti`
--
ALTER TABLE `utenti`
  MODIFY `idutente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
  ADD CONSTRAINT `questionari_ibfk_1` FOREIGN KEY (`idutente`) REFERENCES `utenti` (`idutente`),
  ADD CONSTRAINT `questionari_ibfk_2` FOREIGN KEY (`idquestionariAdmin`) REFERENCES `questionariadmin` (`idquestionariAdmin`);

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
