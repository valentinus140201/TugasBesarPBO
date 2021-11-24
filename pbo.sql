-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 16, 2021 at 12:20 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `absensi_dokter`
--

CREATE TABLE `absensi_dokter` (
  `Tgl_absen` date NOT NULL,
  `Status` varchar(255) NOT NULL,
  `NID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `absensi_dokter`
--

INSERT INTO `absensi_dokter` (`Tgl_absen`, `Status`, `NID`) VALUES
('2020-11-02', 'ALPHA', '1'),
('2020-11-02', 'IZIN', '3'),
('2020-11-02', 'IZIN', '3'),
('2020-11-01', 'ALPHA', '3'),
('2020-11-02', 'HADIR', '4'),
('2020-11-27', 'HADIR', '4'),
('2020-11-01', 'ALPHA', '4'),
('2020-11-22', 'HADIR', '4'),
('2020-11-01', 'HADIR', '4'),
('2020-11-02', 'HADIR', '123');

-- --------------------------------------------------------

--
-- Table structure for table `cabang`
--

CREATE TABLE `cabang` (
  `ID_cabang` varchar(255) NOT NULL,
  `Alamat` varchar(255) NOT NULL,
  `No_telepon` varchar(255) NOT NULL,
  `Nama_cabang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cabang`
--

INSERT INTO `cabang` (`ID_cabang`, `Alamat`, `No_telepon`, `Nama_cabang`) VALUES
('01', 'Antapani No.5', '02209232093', 'Puskesmas Antapani'),
('02', 'Jalan Cihampelas No 3, Bandung, Jawa Barat', '02213113131', 'Puskesmas Cihampelas');

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `NIK` varchar(255) NOT NULL,
  `Nama` varchar(255) NOT NULL,
  `Tgl_Lahir` date NOT NULL,
  `Goldar` varchar(255) NOT NULL,
  `Gender` varchar(255) NOT NULL,
  `NID` varchar(255) NOT NULL,
  `Poliklinik` varchar(255) NOT NULL,
  `No_Telepon` varchar(255) NOT NULL,
  `Alamat` varchar(255) NOT NULL,
  `ID_Cabang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`NIK`, `Nama`, `Tgl_Lahir`, `Goldar`, `Gender`, `NID`, `Poliklinik`, `No_Telepon`, `Alamat`, `ID_Cabang`) VALUES
('1', '1', '2020-11-03', 'O', 'Pria', '1', 'Dokter Spesialis Anak', '1', '1', '01'),
('123', 'Sutomo Rahardjo', '2020-10-07', 'O', 'Pria', '123', 'Belum Dipilih', '082123232323', 'Jalan Dipatiukur Sebelah ITHB', '02'),
('4', '4', '2020-10-08', 'O', 'Pria', '4', 'Dokter Umum', '08123210', 'Aweu', '01');

-- --------------------------------------------------------

--
-- Table structure for table `masa_berlaku_obat`
--

CREATE TABLE `masa_berlaku_obat` (
  `ID_MLO` varchar(255) NOT NULL,
  `ID_obat` varchar(255) NOT NULL,
  `Tgl_beli` date NOT NULL,
  `Tgl_kadaluarsa` date NOT NULL,
  `Stok` int(11) NOT NULL,
  `ID_cabang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `masa_berlaku_obat`
--

INSERT INTO `masa_berlaku_obat` (`ID_MLO`, `ID_obat`, `Tgl_beli`, `Tgl_kadaluarsa`, `Stok`, `ID_cabang`) VALUES
('123', '123', '2020-10-06', '2020-10-06', 123, '01'),
('MLO001', 'M001', '2020-09-28', '2050-09-28', 700, '01'),
('MLO002', 'M001', '2020-09-28', '2050-09-28', 700, '01'),
('MLO003', 'M002', '2020-09-28', '2050-09-28', 500, '01'),
('MLO004', 'M004', '2020-10-16', '2020-10-16', 15, '01'),
('MLO005', 'M005', '2020-10-02', '2020-10-03', 0, '01');

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `ID_Obat` varchar(255) NOT NULL,
  `Nama_obat` varchar(255) NOT NULL,
  `Harga_beli` int(11) NOT NULL,
  `Harga_jual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`ID_Obat`, `Nama_obat`, `Harga_beli`, `Harga_jual`) VALUES
('123', '123', 123, 123),
('M001', 'Amoxicilin', 6500, 75000),
('M002', 'Cataflam', 6500, 75000),
('M003', 'Cetinal', 6500, 75000),
('M004', 'Tramadhol', 15000, 15000),
('M005', 'Tramadhol', 10000, 10000);

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `NIK` varchar(255) NOT NULL,
  `Nama` varchar(255) NOT NULL,
  `Tgl_Lahir` date NOT NULL,
  `Goldar` varchar(255) NOT NULL,
  `Gender` varchar(255) NOT NULL,
  `Alergi` varchar(255) NOT NULL,
  `Penyakit_Menurun` varchar(255) NOT NULL,
  `Golongan` varchar(255) NOT NULL,
  `No_Telepon` varchar(255) NOT NULL,
  `Alamat` varchar(255) NOT NULL,
  `ID_cabang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`NIK`, `Nama`, `Tgl_Lahir`, `Goldar`, `Gender`, `Alergi`, `Penyakit_Menurun`, `Golongan`, `No_Telepon`, `Alamat`, `ID_cabang`) VALUES
('1', '1', '2020-11-04', '+AB', 'Wanita', '1', '1', '¬í\0~r\0Model.GolonganPasien\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0BPJS', '1', '1', '01'),
('10', '10', '2020-11-02', '+B', 'Pria', '10', '10', 'NON_BPJS', '10', '10', '02'),
('111', 'Klee', '2020-11-06', '-B', 'Wanita', 'seafood', '-', 'BPJS', '1203571', 'Jl.kircon no 10', '01'),
('123', 'judi', '2000-02-26', 'AB', 'Wanita', '-', '-', 'BPJS', '0888', 'jl.abc no 4', ''),
('13', '13', '2020-11-02', '+B', 'Pria', '13', '13', 'NON_BPJS', '13', '13', '01'),
('135', 'jmsd', '2020-11-13', '+B', 'Pria', '-', '-', 'NON_BPJS', '021934', 'Jl.FWE', '01'),
('145', 'Kyle', '2020-10-02', 'O', 'Pria', 'something', 'hemorhoid', 'BPJS', '02953', 'south park', ''),
('2', '2', '2020-11-05', '+B', 'Pria', '2', '2', 'NON_BPJS', '2', '2', '01'),
('222', 'alex', '2020-11-05', '+AB', 'Pria', 'baso', '-', 'NON_BPJS', '08782356', 'jl burangrang dalem', '01'),
('4', '4', '2020-11-04', '+B', 'Pria', '4', '', '¬í\0~r\0Model.GolonganPasien\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0NON_BPJS', '4', '4', '01'),
('6', '6', '2020-11-03', '+B', 'Pria', '6', '6', 'NON_BPJS', '6', '6', '01');

-- --------------------------------------------------------

--
-- Table structure for table `resep_obat_pasien`
--

CREATE TABLE `resep_obat_pasien` (
  `ID_Obat` varchar(255) NOT NULL,
  `NIK` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resep_obat_pasien`
--

INSERT INTO `resep_obat_pasien` (`ID_Obat`, `NIK`) VALUES
('M001', '123'),
('M002', '123'),
('M004', '2'),
('M004', '2'),
('M004', '2'),
('M004', '2'),
('M005', '6');

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_pasien`
--

CREATE TABLE `riwayat_pasien` (
  `ID_Riwayat` int(11) NOT NULL COMMENT 'AUTO_INCREMENT',
  `Penyakit` varchar(255) NOT NULL,
  `Tgl_kunjungan` date NOT NULL,
  `Keluhan` varchar(255) NOT NULL,
  `NIK` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `riwayat_pasien`
--

INSERT INTO `riwayat_pasien` (`ID_Riwayat`, `Penyakit`, `Tgl_kunjungan`, `Keluhan`, `NIK`) VALUES
(1, 'gigi berlubang', '2020-09-19', 'sakit gigi', '123'),
(3, 'Kanker Perut', '2020-11-02', 'Sakit Perut', '6'),
(2, 'Sakit Perut', '2020-11-01', 'Sakit Perut', '2');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `ID_cabang` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`username`, `password`, `ID_cabang`) VALUES
('Asri', 'Asri123', '02'),
('intan', 'intan', '01');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `ID_Transaksi` varchar(255) NOT NULL,
  `idPasien` int(11) NOT NULL,
  `Tanggal_masuk` date NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `Jenis_pasien` varchar(255) NOT NULL,
  `Harga_konsul` int(11) NOT NULL,
  `Harga_obat` int(11) NOT NULL,
  `Total_harga` int(11) NOT NULL,
  `ID_cabang` varchar(255) NOT NULL,
  `isBayar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`ID_Transaksi`, `idPasien`, `Tanggal_masuk`, `Jumlah`, `Jenis_pasien`, `Harga_konsul`, `Harga_obat`, `Total_harga`, `ID_cabang`, `isBayar`) VALUES
('T001', 0, '2020-11-22', 1, '2', 15000, 10000, 25000, '01', 0),
('T002', 1, '2021-11-16', 1, '0', 15000, 1500000, 1515000, '01', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absensi_dokter`
--
ALTER TABLE `absensi_dokter`
  ADD KEY `NID` (`NID`);

--
-- Indexes for table `cabang`
--
ALTER TABLE `cabang`
  ADD PRIMARY KEY (`ID_cabang`);

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`NIK`);

--
-- Indexes for table `masa_berlaku_obat`
--
ALTER TABLE `masa_berlaku_obat`
  ADD PRIMARY KEY (`ID_MLO`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`ID_Obat`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`NIK`);

--
-- Indexes for table `resep_obat_pasien`
--
ALTER TABLE `resep_obat_pasien`
  ADD KEY `ID_Obat` (`ID_Obat`),
  ADD KEY `NIK` (`NIK`);

--
-- Indexes for table `riwayat_pasien`
--
ALTER TABLE `riwayat_pasien`
  ADD PRIMARY KEY (`Penyakit`),
  ADD UNIQUE KEY `ID_pasien` (`NIK`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`ID_Transaksi`),
  ADD KEY `ID_cabang` (`ID_cabang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
