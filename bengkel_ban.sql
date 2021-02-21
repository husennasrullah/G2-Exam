-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 21, 2021 at 05:20 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bengkel_ban`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `idCustomer` varchar(100) COLLATE utf8_bin NOT NULL,
  `namaCustomer` varchar(100) COLLATE utf8_bin NOT NULL,
  `alamat` varchar(100) COLLATE utf8_bin NOT NULL,
  `noTelepon` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`idCustomer`, `namaCustomer`, `alamat`, `noTelepon`) VALUES
('Cust-4d131125-cc32-4ff8-8fc7-25cb3f299155', 'bambank', 'bekasi', 23),
('Cust-82cbd6c2-debe-45db-ba35-943c43a54c3d', 'husain', 'bekasi', 543221),
('Cust-c26cde8d-5eb4-4340-a62f-14ced78bc6b2', 'bobby', 'tangerang', 3312);

-- --------------------------------------------------------

--
-- Table structure for table `detailtransaksi`
--

CREATE TABLE `detailtransaksi` (
  `idDetail` varchar(100) COLLATE utf8_bin NOT NULL,
  `idTransaksi` varchar(100) COLLATE utf8_bin NOT NULL,
  `idBan` varchar(100) COLLATE utf8_bin NOT NULL,
  `hargaSatuanBan` double NOT NULL,
  `idJasa` varchar(100) COLLATE utf8_bin NOT NULL,
  `hargaSatuanJasa` double NOT NULL,
  `quantity` int(100) NOT NULL,
  `totalHargaBan` double NOT NULL,
  `totalHargaJasa` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `detailtransaksi`
--

INSERT INTO `detailtransaksi` (`idDetail`, `idTransaksi`, `idBan`, `hargaSatuanBan`, `idJasa`, `hargaSatuanJasa`, `quantity`, `totalHargaBan`, `totalHargaJasa`) VALUES
('Detail-05d55953-3a2b-443f-a760-498bb1c92d55', 'Trans-1a7739ca-f281-43b7-9925-43c5c8c3b3d1', 'Tire-6e08ae54-7f6e-4f22-b287-bc82acafef90', 1500000, 'Serv-86a929c7-9e2c-4ef2-9239-29c74c4cbb67', 200000, 4, 6000000, 800000),
('Detail-7620f7dd-c6a2-4e0a-9942-7b799ae627a2', 'Trans-1d06c9f5-7375-44b0-885d-d7cbd5f9483a', '12', 1500000, '312313123121', 1500000, 3, 4500000, 4500000),
('Detail-a7302a63-0a87-4997-9d15-e3a969454c9b', 'Trans-48ca28e1-e80f-49ce-93cc-4be1c970b9ce', 'Tire-0b948452-8f0d-4f09-baa3-f25d1d20cacf', 800000, 'Serv-40bb54bd-bcd1-4aa7-b7e4-8a44d4c8547f', 1000000, 6, 4800000, 6000000),
('Detail-c1f18849-2c33-483a-9758-30052e7e350e', 'Trans-849dd098-9a79-44aa-927c-f104ca2ecb8d', '12', 1500000, '31231312312', 1500000, 8, 12000000, 12000000);

-- --------------------------------------------------------

--
-- Table structure for table `hargaban`
--

CREATE TABLE `hargaban` (
  `idBan` varchar(100) COLLATE utf8_bin NOT NULL,
  `merkBan` varchar(100) COLLATE utf8_bin NOT NULL,
  `jenisBan` varchar(100) COLLATE utf8_bin NOT NULL,
  `hargaSatuan` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `hargaban`
--

INSERT INTO `hargaban` (`idBan`, `merkBan`, `jenisBan`, `hargaSatuan`) VALUES
('Tire-0007817e-fe9d-4d59-bcbe-7857d83b1683', 'DUNLOP', 'Tubeless', 1400000),
('Tire-0b948452-8f0d-4f09-baa3-f25d1d20cacf', 'HANKOOK', 'Tubeless', 800000),
('Tire-26ec374c-9b6c-45fa-bf35-a3a30ffedfd0', 'GT-RADIAL', 'Tubeless', 1200000),
('Tire-6e08ae54-7f6e-4f22-b287-bc82acafef90', 'BRIDGESTONE', 'Tubeless', 1500000);

-- --------------------------------------------------------

--
-- Table structure for table `jasa`
--

CREATE TABLE `jasa` (
  `idJasa` varchar(100) COLLATE utf8_bin NOT NULL,
  `jenisJasa` varchar(100) COLLATE utf8_bin NOT NULL,
  `hargaSatuan` int(100) NOT NULL,
  `lamaPengerjaan` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `jasa`
--

INSERT INTO `jasa` (`idJasa`, `jenisJasa`, `hargaSatuan`, `lamaPengerjaan`) VALUES
('Serv-40bb54bd-bcd1-4aa7-b7e4-8a44d4c8547f', 'spooring', 1000000, 2),
('Serv-86a929c7-9e2c-4ef2-9239-29c74c4cbb67', 'pasang ban', 200000, 2),
('Serv-a6376bf9-beb0-498c-bb02-2258d0dd3dda', 'bongkar ban', 1400000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `teknisi`
--

CREATE TABLE `teknisi` (
  `idTeknisi` varchar(100) COLLATE utf8_bin NOT NULL,
  `namaTeknisi` varchar(100) COLLATE utf8_bin NOT NULL,
  `alamat` varchar(100) COLLATE utf8_bin NOT NULL,
  `noTelp` int(100) NOT NULL,
  `bidang` varchar(100) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `teknisi`
--

INSERT INTO `teknisi` (`idTeknisi`, `namaTeknisi`, `alamat`, `noTelp`, `bidang`) VALUES
('Tech-132ec4ca-fc2c-4979-a30f-92f4345deddf', 'ilham', 'tangerang', 43212, 'Spooring'),
('Tech-62de0f58-2dbd-427e-8469-51a83aece68d', 'hasan', 'tangerang', 32, 'Spooring'),
('Tech-c57b2b56-1bbf-4ce2-883e-6ac7be9be90d', 'mark', 'bekasi', 74839213, ''),
('Tech-ecda2566-bb4c-4ee0-a3ad-eaa7b5958d29', 'eric', 'tangerang', 21, 'Spooring'),
('Tech-f1c9d016-c0c3-498f-9221-6c111508c89d', 'salah', 'bogor', 123436, 'Spooring');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` varchar(100) COLLATE utf8_bin NOT NULL,
  `tglTransaksi` date NOT NULL,
  `idCustomer` varchar(100) COLLATE utf8_bin NOT NULL,
  `idTeknisi` varchar(100) COLLATE utf8_bin NOT NULL,
  `totalBayar` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `tglTransaksi`, `idCustomer`, `idTeknisi`, `totalBayar`) VALUES
('Trans-1a7739ca-f281-43b7-9925-43c5c8c3b3d1', '2021-02-21', 'Cust-c26cde8d-5eb4-4340-a62f-14ced78bc6b2', 'Tech-c57b2b56-1bbf-4ce2-883e-6ac7be9be90d', 7480000),
('Trans-1d06c9f5-7375-44b0-885d-d7cbd5f9483a', '2021-02-21', '3123123141', 'Tech-62de0f58-2dbd-427e-8469-51a83aece68d', 9900000),
('Trans-48ca28e1-e80f-49ce-93cc-4be1c970b9ce', '2021-02-21', 'Cust-4d131125-cc32-4ff8-8fc7-25cb3f299155', 'Tech-62de0f58-2dbd-427e-8469-51a83aece68d', 11880000),
('Trans-849dd098-9a79-44aa-927c-f104ca2ecb8d', '2021-02-21', '3123123141', 'Tech-ecda2566-bb4c-4ee0-a3ad-eaa7b5958d29', 26400000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`idCustomer`);

--
-- Indexes for table `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  ADD PRIMARY KEY (`idDetail`);

--
-- Indexes for table `hargaban`
--
ALTER TABLE `hargaban`
  ADD PRIMARY KEY (`idBan`);

--
-- Indexes for table `jasa`
--
ALTER TABLE `jasa`
  ADD PRIMARY KEY (`idJasa`);

--
-- Indexes for table `teknisi`
--
ALTER TABLE `teknisi`
  ADD PRIMARY KEY (`idTeknisi`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
