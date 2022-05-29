-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 03, 2021 at 07:23 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cuahangnuoc`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_chitiethoadon`
--

CREATE TABLE `tb_chitiethoadon` (
  `maHDchitiet` varchar(15) NOT NULL,
  `maSP` varchar(6) NOT NULL,
  `chitietsoluongSP` int(11) NOT NULL,
  `chitietgiaSP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_hoadon`
--

CREATE TABLE `tb_hoadon` (
  `maHD` varchar(15) NOT NULL,
  `ngayHD` varchar(10) NOT NULL,
  `noidungHD` varchar(600) NOT NULL,
  `tonggiaHD` int(11) NOT NULL,
  `maNV` varchar(10) NOT NULL,
  `tenNV` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tb_nhanvien`
--

CREATE TABLE `tb_nhanvien` (
  `cmnd_cccd` varchar(10) NOT NULL,
  `tenNV` varchar(50) NOT NULL,
  `diachiNV` varchar(60) NOT NULL,
  `ngaysinhNV` varchar(11) NOT NULL,
  `anhNV` varchar(200) NOT NULL,
  `sdtNV` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_nhanvien`
--

INSERT INTO `tb_nhanvien` (`cmnd_cccd`, `tenNV`, `diachiNV`, `ngaysinhNV`, `anhNV`, `sdtNV`) VALUES
('23331234', 'Phạm Ngọc Quang', '99 An Dương Vương, Phường 16, Quận 8', '2001-09-10', 'C:\\Users\\ACER\\Pictures\\anhbannuoc\\nguoinghien.jpg', '0120452185');

-- --------------------------------------------------------

--
-- Table structure for table `tb_sanpham`
--

CREATE TABLE `tb_sanpham` (
  `maSP` varchar(60) NOT NULL,
  `tenSP` varchar(50) NOT NULL,
  `anhSP` varchar(200) NOT NULL,
  `soluongSP` int(2) NOT NULL,
  `tinhtrangSP` varchar(10) NOT NULL,
  `giaSP` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_sanpham`
--

INSERT INTO `tb_sanpham` (`maSP`, `tenSP`, `anhSP`, `soluongSP`, `tinhtrangSP`, `giaSP`) VALUES
('90522', 'Cà phê đen đá', 'C:\\Users\\ACER\\Pictures\\anhbannuoc\\Anh-3-8461-1458632460.jpg', 15, 'Còn hàng', 20000),
('96398', 'Cà phê sữa đá', 'C:\\Users\\ACER\\Pictures\\anhbannuoc\\cafe-sua-da_9073dfe2143d428a91a370e79df77e49_master.jpg', 15, 'Còn hàng', 22000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_chitiethoadon`
--
ALTER TABLE `tb_chitiethoadon`
  ADD KEY `fk_maHD` (`maHDchitiet`),
  ADD KEY `fk_maSP` (`maSP`);

--
-- Indexes for table `tb_hoadon`
--
ALTER TABLE `tb_hoadon`
  ADD PRIMARY KEY (`maHD`),
  ADD KEY `fk_maNV` (`maNV`);

--
-- Indexes for table `tb_nhanvien`
--
ALTER TABLE `tb_nhanvien`
  ADD PRIMARY KEY (`cmnd_cccd`),
  ADD UNIQUE KEY `sdtNV` (`sdtNV`);

--
-- Indexes for table `tb_sanpham`
--
ALTER TABLE `tb_sanpham`
  ADD PRIMARY KEY (`maSP`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_chitiethoadon`
--
ALTER TABLE `tb_chitiethoadon`
  ADD CONSTRAINT `fk_maHD` FOREIGN KEY (`maHDchitiet`) REFERENCES `tb_hoadon` (`maHD`),
  ADD CONSTRAINT `fk_maSP` FOREIGN KEY (`maSP`) REFERENCES `tb_sanpham` (`maSP`);

--
-- Constraints for table `tb_hoadon`
--
ALTER TABLE `tb_hoadon`
  ADD CONSTRAINT `fk_maNV` FOREIGN KEY (`maNV`) REFERENCES `tb_nhanvien` (`cmnd_cccd`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
