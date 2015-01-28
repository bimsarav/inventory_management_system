-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 21, 2015 at 07:22 PM
-- Server version: 5.5.37
-- PHP Version: 5.3.10-1ubuntu3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `INVENTORY`
--

-- --------------------------------------------------------

--
-- CREATE DATABASE
--

CREATE DATABASE INVENTORY;

USE INVENTORY;

--
-- Table structure for table `inventoryData`
--

CREATE TABLE IF NOT EXISTS `inventoryData` (
  `Inventory_Id` varchar(30) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Available_Amount` int(6) DEFAULT NULL,
  `Sold` int(6) DEFAULT NULL,
  `Price_Per_Unit` int(6) DEFAULT NULL,
  `Location` varchar(30) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `Created_Date` date DEFAULT NULL,
  PRIMARY KEY (`Inventory_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventoryData`
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
