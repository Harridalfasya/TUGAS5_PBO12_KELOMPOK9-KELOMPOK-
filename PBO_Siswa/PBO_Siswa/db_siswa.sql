/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.1.10-MariaDB : Database - db_siswa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_siswa` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_siswa`;

/*Table structure for table `kelas` */

DROP TABLE IF EXISTS `kelas`;

CREATE TABLE `kelas` (
  `Kode_Kelas` char(10) NOT NULL,
  `Nama_Kelas` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Kode_Kelas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kelas` */

insert  into `kelas`(`Kode_Kelas`,`Nama_Kelas`) values ('01','1A'),('02','1B'),('03','1C'),('04','2A'),('05','2B'),('06','2C'),('07','3A'),('08','3B');

/*Table structure for table `nilai` */

DROP TABLE IF EXISTS `nilai`;

CREATE TABLE `nilai` (
  `Nis` char(10) DEFAULT NULL,
  `Mata_Pelajaran` varchar(30) DEFAULT NULL,
  `Niali` char(19) DEFAULT NULL,
  KEY `Nis` (`Nis`),
  CONSTRAINT `nilai_ibfk_1` FOREIGN KEY (`Nis`) REFERENCES `siswa` (`Nis`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `nilai` */

insert  into `nilai`(`Nis`,`Mata_Pelajaran`,`Niali`) values ('101124520','B.Indonesia','80'),('101124520','Matematika','75'),('101124520','B.Inggris','76'),('101124520','Ipa','85'),('101124521','B.Indonesia','85'),('101124521','Matematika','70'),('101124521','B.inggris','78'),('101124521','Ipa','80');

/*Table structure for table `pendaftaran` */

DROP TABLE IF EXISTS `pendaftaran`;

CREATE TABLE `pendaftaran` (
  `Id_Pendaftaran` char(10) NOT NULL,
  `Nis` char(10) NOT NULL,
  `Nama_Pendaftar` varchar(30) DEFAULT NULL,
  `Jenis_Kelamin` enum('Laki-Laki','Perempuan') DEFAULT NULL,
  `Alamat` varchar(40) DEFAULT NULL,
  `Tanggal_Pendaftaran` date DEFAULT NULL,
  `Kode_Kelas` char(10) NOT NULL,
  PRIMARY KEY (`Id_Pendaftaran`),
  KEY `Kode_Kelas` (`Kode_Kelas`),
  KEY `Nis` (`Nis`),
  CONSTRAINT `pendaftaran_ibfk_2` FOREIGN KEY (`Kode_Kelas`) REFERENCES `kelas` (`Kode_Kelas`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pendaftaran` */

insert  into `pendaftaran`(`Id_Pendaftaran`,`Nis`,`Nama_Pendaftar`,`Jenis_Kelamin`,`Alamat`,`Tanggal_Pendaftaran`,`Kode_Kelas`) values ('P001','101124520','Rikan','Laki-Laki','Chicaheum','1996-11-28','01'),('P002','101124521','Ahmad','Laki-Laki','Chicaheum','1996-09-04','01'),('P003','101124522','Agus','Laki-Laki','Ahmad Yani','1998-09-30','02');

/*Table structure for table `siswa` */

DROP TABLE IF EXISTS `siswa`;

CREATE TABLE `siswa` (
  `Id_Pendaftaran` char(10) DEFAULT NULL,
  `Nis` char(10) NOT NULL,
  `Nama` varchar(30) DEFAULT NULL,
  `Jenis_Kelamin` enum('Laki-Laki','Perempuan') DEFAULT NULL,
  `Alamat` varchar(40) DEFAULT NULL,
  `Kode_Kelas` char(10) DEFAULT NULL,
  PRIMARY KEY (`Nis`),
  KEY `siswa_ibfk_1` (`Kode_Kelas`),
  KEY `Id_Pendaftaran` (`Id_Pendaftaran`),
  CONSTRAINT `siswa_ibfk_1` FOREIGN KEY (`Kode_Kelas`) REFERENCES `kelas` (`Kode_Kelas`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `siswa_ibfk_2` FOREIGN KEY (`Id_Pendaftaran`) REFERENCES `pendaftaran` (`Id_Pendaftaran`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `siswa` */

insert  into `siswa`(`Id_Pendaftaran`,`Nis`,`Nama`,`Jenis_Kelamin`,`Alamat`,`Kode_Kelas`) values ('P001','101124520','Ahmad','Laki-Laki','Chicaheum','01'),('P002','101124521','Rikan','Laki-Laki','Chicaheum','01'),('P003','101124522','Daniar','Laki-Laki','dsag','01');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
