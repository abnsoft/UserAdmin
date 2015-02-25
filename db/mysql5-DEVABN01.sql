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

-- --------------------------------------------------------

--
-- Структура таблицы `ADDRESS`
--

CREATE TABLE IF NOT EXISTS `ADDRESS` (
  `id` bigint(20) NOT NULL auto_increment,
  `city` varchar(64) default NULL,
  `country` varchar(128) default NULL,
  `housenum` int(11) default NULL,
  `street` varchar(64) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_21xoq8w80jh7ok1scsj9495ff` (`country`,`city`,`street`,`housenum`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=45 ;

-- --------------------------------------------------------

--
-- Структура таблицы `persistent_logins`
--

CREATE TABLE IF NOT EXISTS `persistent_logins` (
  `series` varchar(64) NOT NULL,
  `last_used` datetime NOT NULL,
  `token` varchar(64) NOT NULL,
  `username` varchar(64) NOT NULL,
  PRIMARY KEY  (`series`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `PERSON`
--

CREATE TABLE IF NOT EXISTS `PERSON` (
  `id` bigint(20) NOT NULL auto_increment,
  `created` datetime NOT NULL,
  `email` varchar(128) NOT NULL,
  `isenabled` char(1) NOT NULL,
  `fullname` varchar(128) default NULL,
  `password` varchar(128) NOT NULL,
  `role` varchar(16) NOT NULL,
  `timezone` int(11) NOT NULL,
  `updated` datetime NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_49e74yu04yywdtimptal7g7b5` (`email`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

-- --------------------------------------------------------

--
-- Структура таблицы `PERSON_ADDRESS`
--

CREATE TABLE IF NOT EXISTS `PERSON_ADDRESS` (
  `personid` bigint(20) NOT NULL,
  `addressid` bigint(20) NOT NULL,
  KEY `FK_4teiu3kkv7p65gbcd1luoqn0m` (`addressid`),
  KEY `FK_7as3u1bt7t5pcacpt5sa6a1ob` (`personid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
