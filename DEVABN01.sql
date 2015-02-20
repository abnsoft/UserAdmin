-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Хост: localhost:3306
-- Время создания: Фев 20 2015 г., 16:37
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

-- --------------------------------------------------------

--
-- Структура таблицы `ADDRESS`
--

DROP TABLE IF EXISTS `ADDRESS`;
CREATE TABLE IF NOT EXISTS `ADDRESS` (
  `id` bigint(20) NOT NULL auto_increment,
  `city` varchar(64) default NULL,
  `country` varchar(128) default NULL,
  `housenum` int(11) default NULL,
  `street` varchar(64) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Структура таблицы `PERSON`
--

DROP TABLE IF EXISTS `PERSON`;
CREATE TABLE IF NOT EXISTS `PERSON` (
  `id` bigint(20) NOT NULL auto_increment,
  `created` datetime NOT NULL,
  `email` varchar(128) NOT NULL,
  `isenabled` char(1) NOT NULL,
  `fullname` varchar(128) default NULL,
  `password` varchar(128) NOT NULL,
  `role` varchar(16) NOT NULL,
  `timezone` int(11) NOT NULL default '0',
  `updated` datetime NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_49e74yu04yywdtimptal7g7b5` (`email`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

-- --------------------------------------------------------

--
-- Структура таблицы `PERSON_ADDRESS`
--

DROP TABLE IF EXISTS `PERSON_ADDRESS`;
CREATE TABLE IF NOT EXISTS `PERSON_ADDRESS` (
  `addressid` bigint(20) NOT NULL,
  `personid` bigint(20) NOT NULL,
  KEY `FK_7as3u1bt7t5pcacpt5sa6a1ob` (`personid`),
  KEY `FK_4teiu3kkv7p65gbcd1luoqn0m` (`addressid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
