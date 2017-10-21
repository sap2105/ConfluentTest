-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 21, 2017 at 12:18 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `confluenttest`
--

-- --------------------------------------------------------

--
-- Table structure for table `article`
--

CREATE TABLE `article` (
  `aid` int(11) NOT NULL,
  `fid` int(11) NOT NULL,
  `articledesc` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`aid`, `fid`, `articledesc`) VALUES
(1, 1, 'Trump Administration pulls out of Paris Climate Agreement'),
(2, 2, 'World eyes Asian markets to drive global growth'),
(3, 3, 'Confluent successfully completed another round of funding'),
(4, 4, 'New Yorkers brace for major delays, as major construction taking place across subway routes'),
(5, 5, 'Indian economy on a strong path after structural changes'),
(6, 1, 'Trump Admin proposed merit based immigration policy.');

-- --------------------------------------------------------

--
-- Table structure for table `feeds`
--

CREATE TABLE `feeds` (
  `feedid` int(11) NOT NULL,
  `topic` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `feeds`
--

INSERT INTO `feeds` (`feedid`, `topic`) VALUES
(1, 'USA Politics'),
(2, 'World Economy'),
(3, 'Confluent Growth'),
(4, 'New York News'),
(5, 'Indian Economy'),
(6, 'Game of Thrones');

-- --------------------------------------------------------

--
-- Table structure for table `unsubscribe`
--

CREATE TABLE `unsubscribe` (
  `uid` int(11) NOT NULL,
  `fid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `unsubscribe`
--

INSERT INTO `unsubscribe` (`uid`, `fid`) VALUES
(2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `uname` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `uname`) VALUES
(1, 'sap1'),
(2, 'abc1'),
(3, 'xyz'),
(4, 'johnd'),
(5, 'mary');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`aid`,`fid`),
  ADD KEY `FK_feed_article_fid` (`fid`);

--
-- Indexes for table `feeds`
--
ALTER TABLE `feeds`
  ADD PRIMARY KEY (`feedid`);

--
-- Indexes for table `unsubscribe`
--
ALTER TABLE `unsubscribe`
  ADD PRIMARY KEY (`uid`,`fid`),
  ADD KEY `FK_feed_uns_fid` (`fid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `article`
--
ALTER TABLE `article`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `feeds`
--
ALTER TABLE `feeds`
  MODIFY `feedid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `FK_feed_article_fid` FOREIGN KEY (`fid`) REFERENCES `feeds` (`feedid`);

--
-- Constraints for table `unsubscribe`
--
ALTER TABLE `unsubscribe`
  ADD CONSTRAINT `FK_feed_uns_fid` FOREIGN KEY (`fid`) REFERENCES `feeds` (`feedid`),
  ADD CONSTRAINT `FK_user_uns_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
