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

--
-- Table structure for table `inventoryData`
--

CREATE TABLE IF NOT EXISTS `inventoryData` (
  `Inventory_Id` varchar(30) NOT NULL,
  `Name` varchar(30) DEFAULT NULL,
  `Price` int(6) DEFAULT NULL,
  `Hospital` varchar(30) DEFAULT NULL,
  `User_Note` varchar(100) DEFAULT NULL,
  `Created_Date` date DEFAULT NULL,
  PRIMARY KEY (`Inventory_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventoryData`
--

INSERT INTO `inventoryData` (`Inventory_Id`, `Name`, `Price`, `Hospital`, `User_Note`, `Created_Date`) VALUES
('inv123', 'ECHO Machine', 25000, 'Badulla Hospital', 'User Note', '2015-01-04');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
