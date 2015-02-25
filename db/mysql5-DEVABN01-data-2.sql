-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Хост: localhost:3306
-- Время создания: Фев 25 2015 г., 05:34
-- Версия сервера: 5.0.51
-- Версия PHP: 5.4.4-14+deb7u9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `DEVABN01`
--

--
-- Дамп данных таблицы `ADDRESS`
--

INSERT INTO `ADDRESS` (`id`, `city`, `country`, `housenum`, `street`) VALUES
(1, 'Spb', 'RU', 12, 'OBLOMOVA'),
(2, 'Saint Petersburg', 'Russia', 11, 'Kirochnaja'),
(3, 'Saint Petersburg', 'Russia', 13, 'Lenina'),
(4, 'Saint Petersburg', 'RU', 11, 'Lenina'),
(5, 'Saint Petersburg', 'RUSSIA', 22, 'Lenina'),
(6, 'Saint Petersburg', 'Russia', 33, 'Nalichnaja'),
(7, 'Saint Petersburg', 'RU', 12, 'Lenina'),
(8, 'Saint Petersburg', 'RU', 13, 'Lenina'),
(9, 'Saint Petersburg', 'RU', 14, 'Lenina'),
(10, 'Saint Petersburg', 'RU', 15, 'Lenina'),
(11, 'Saint Petersburg', 'Russia', 12, 'Kirochnaja'),
(12, 'Saint Petersburg', 'Russia', 13, 'Kirochnaja'),
(13, 'Saint Petersburg', 'Russia', 14, 'Kirochnaja'),
(14, 'Saint Petersburg', 'Russia', 15, 'Kirochnaja'),
(15, 'Saint Petersburg', 'Russia', 16, 'Kirochnaja'),
(16, 'Saint Petersburg', 'Russia', 17, 'Kirochnaja'),
(17, 'Saint Petersburg', 'RUSSIA', 23, 'Lenina'),
(18, 'Saint Petersburg', 'RUSSIA', 24, 'Lenina'),
(19, 'Saint Petersburg', 'RUSSIA', 25, 'Lenina'),
(20, 'Saint Petersburg', 'RUSSIA', 26, 'Lenina'),
(21, 'Saint Petersburg', 'RUSSIA', 27, 'Lenina'),
(22, 'Saint Petersburg', 'RUSSIA', 28, 'Lenina'),
(23, 'Saint Petersburg', 'RUSSIA', 37, 'Lenina'),
(24, 'Saint Petersburg', 'RUSSIA', 36, 'Lenina'),
(25, 'Saint Petersburg', 'RUSSIA', 35, 'Lenina'),
(26, 'Saint Petersburg', 'RUSSIA', 34, 'Lenina'),
(27, 'Saint Petersburg', 'RUSSIA', 33, 'Lenina'),
(28, 'Saint Petersburg', 'RUSSIA', 32, 'Lenina'),
(29, 'Saint Petersburg', 'RUSSIA', 31, 'Lenina'),
(30, 'Saint Petersburg', 'RUSSIA', 30, 'Lenina'),
(31, 'Saint Petersburg', 'RUSSIA', 29, 'Lenina'),
(32, 'Spb', 'RU', 13, 'OBLOMOVA'),
(33, 'Kiev', 'UA', 1, 'Maydan'),
(34, 'Kiev', 'UA', 1, 'Polizhaeva'),
(35, 'Vena', 'AU', 1, 'Bethovena'),
(36, 'Vena', 'AU', 2, 'Bethovena'),
(37, 'Kiev', 'UA', 2, 'Polizhaeva'),
(38, 'Vena', 'AU', 1, 'Mozarta'),
(39, 'Vena', 'AU', 2, 'Mozarta'),
(40, 'Kiev', 'UA', 2, 'Myadan'),
(41, 'Linz', 'AU', 22, 'Bergen'),
(42, 'Linz', 'AU', 123, 'Forward strb'),
(43, 'Kiev', 'UA', 123, 'Volohova'),
(44, 'Vena', 'AU', 33, 'Bergen');

--
-- Дамп данных таблицы `persistent_logins`
--

INSERT INTO `persistent_logins` (`series`, `last_used`, `token`, `username`) VALUES
('MbAtWNpd+k6P8ole97m5TQ==', '2015-02-25 03:24:43', 'hGorN2ymZNXRGFVH2xw2tA==', 'a1@a.com');

--
-- Дамп данных таблицы `PERSON`
--

INSERT INTO `PERSON` (`id`, `created`, `email`, `isenabled`, `fullname`, `password`, `role`, `timezone`, `updated`) VALUES
(1, '2015-02-21 23:27:03', 'a1@a.com', 'T', 'KESHA', '$2a$10$7c3vWJTW6DRVGVKJFZqSFudkcn1RwA5Fhiz9J1DlsSmumcsl1C0ee', 'ROLE_EDITOR', 10800000, '2015-02-23 06:26:13'),
(2, '2015-02-22 00:47:25', 'a2@a.com', 'T', 'Arkasha', '$2a$10$Xg/HPE32IKlwXG4DdAFZWupSsztrl3VUJq9S1iKX4LALPyPw29Sqi', 'ROLE_USER', 10800000, '2015-02-25 02:12:16'),
(3, '2015-02-22 01:00:01', 'a3@a.com', 'T', 'TOLIK', '$2a$10$Wk9Skrp77zfP/K.oCyRFe.MGnu7o35AyDazTRjUvA74zXbSHGZgFq', 'ROLE_USER', 0, '2015-02-25 04:06:43'),
(4, '2015-02-22 01:05:00', 'a4@a.com', 'T', 'Petr Ivanovich', '$2a$10$scTOQrpqQC4VufLo1abkGO0bsDEK.MeOI0VS0VFrE7bs54bJ9YnMy', 'ROLE_USER', 0, '2015-02-25 04:41:28'),
(5, '2015-02-22 01:39:26', 'a5@a.com', 'T', '', '$2a$10$OO1nkLtYcN7jcU8Srgmj2up6RB6TQ.8RDpgE418GUWftUu2Nt2g.i', 'ROLE_USER', 0, '2015-02-22 01:39:26'),
(6, '2015-02-22 03:22:54', 'a6@a.com', 'T', 'Andre Lukin', '$2a$10$Aez3kJPd4LfFmQh7TBmnfOtsJzDb34uQh9HBCXIPW0iPrHsz1X/f6', 'ROLE_USER', 3600000, '2015-02-22 03:22:54'),
(7, '2015-02-22 04:58:51', 'a7@a.com', 'T', 'Andre Lukin', '$2a$10$hnFg7mw8rFj523jynwJhUe/Ow3cXzxSCTZ9SJsvFRA9HHF.MQRf66', 'ROLE_USER', 3600000, '2015-02-22 04:58:51'),
(8, '2015-02-23 04:05:53', 'a8@a.com', 'T', 'Petr Ivanovich', '$2a$10$9CzcFShMANG.tu560/yOQ.tvugYMc/lZUX.bMDV4DM2VXlPxqQBZy', 'ROLE_USER', -25200000, '2015-02-23 04:05:53');

--
-- Дамп данных таблицы `PERSON_ADDRESS`
--

INSERT INTO `PERSON_ADDRESS` (`personid`, `addressid`) VALUES
(1, 1),
(3, 41),
(4, 43),
(5, 1),
(5, 16),
(6, 3),
(6, 6),
(6, 9),
(6, 10),
(2, 39),
(2, 37),
(2, 1),
(2, 33),
(2, 36),
(3, 38),
(3, 32),
(3, 40),
(3, 42),
(4, 1),
(4, 38),
(4, 44);
