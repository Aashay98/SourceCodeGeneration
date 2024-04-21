/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.7.22-log : Database - db1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db1` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db1`;

/*Table structure for table `complain_table` */

DROP TABLE IF EXISTS `complain_table`;

CREATE TABLE `complain_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ComplainDescription` varchar(255) DEFAULT NULL,
  `ComplainStatus` varchar(255) DEFAULT NULL,
  `ComplainSubject` varchar(255) DEFAULT NULL,
  `ComplainTime` varchar(255) DEFAULT NULL,
  `FilePath` varchar(255) DEFAULT NULL,
  `FilePathName` varchar(255) DEFAULT NULL,
  `Reply` varchar(255) DEFAULT NULL,
  `ReplyTime` varchar(255) DEFAULT NULL,
  `Status` bit(1) DEFAULT NULL,
  `loginvo_loginId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp7nkxtbn71k9wfyr8yytp54d5` (`loginvo_loginId`),
  CONSTRAINT `FKp7nkxtbn71k9wfyr8yytp54d5` FOREIGN KEY (`loginvo_loginId`) REFERENCES `login` (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `complain_table` */

insert  into `complain_table`(`id`,`ComplainDescription`,`ComplainStatus`,`ComplainSubject`,`ComplainTime`,`FilePath`,`FilePathName`,`Reply`,`ReplyTime`,`Status`,`loginvo_loginId`) values (1,'error',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',6),(2,'cdcdszfvvff','pending','complain user','25/29/2019 09:29:03','F:\\SourceCodeGeneration\\ap\\src\\main\\webapp\\document/complain/','file.java',NULL,NULL,'',6);

/*Table structure for table `feedback_table` */

DROP TABLE IF EXISTS `feedback_table`;

CREATE TABLE `feedback_table` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Feedback` varchar(255) DEFAULT NULL,
  `StarRating` varchar(255) DEFAULT NULL,
  `Status` bit(1) DEFAULT NULL,
  `loginvo_loginId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKlto03pct7m35wolwukiea7w47` (`loginvo_loginId`),
  CONSTRAINT `FKlto03pct7m35wolwukiea7w47` FOREIGN KEY (`loginvo_loginId`) REFERENCES `login` (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `feedback_table` */

insert  into `feedback_table`(`Id`,`Feedback`,`StarRating`,`Status`,`loginvo_loginId`) values (1,'sa',NULL,NULL,6),(2,'fdsfdffsdfvsdfc','4','\0',6),(3,'rddtrd','5','',6);

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `loginId` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`loginId`,`enabled`,`password`,`role`,`status`,`username`) values (5,'1','adminadmin','ROLE_ADMIN','','admin@gmail.com'),(6,'1','aashay1998','ROLE_USER','','aashaygandhi1998@gmail.com'),(11,'1','aashay98','ROLE_USER','','aashaygandhi198@gmail.com');

/*Table structure for table `project_table` */

DROP TABLE IF EXISTS `project_table`;

CREATE TABLE `project_table` (
  `ProjectId` int(11) NOT NULL AUTO_INCREMENT,
  `Field_Name` varchar(255) DEFAULT NULL,
  `Field_Type` varchar(255) DEFAULT NULL,
  `Form_Name` varchar(255) DEFAULT NULL,
  `Module_Name` varchar(255) DEFAULT NULL,
  `Project_Name` varchar(255) DEFAULT NULL,
  `Status` bit(1) DEFAULT NULL,
  `loginvo_loginId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ProjectId`),
  KEY `FK5dbt0r5ps84cdsjnhow3aqfke` (`loginvo_loginId`),
  CONSTRAINT `FK5dbt0r5ps84cdsjnhow3aqfke` FOREIGN KEY (`loginvo_loginId`) REFERENCES `login` (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `project_table` */

insert  into `project_table`(`ProjectId`,`Field_Name`,`Field_Type`,`Form_Name`,`Module_Name`,`Project_Name`,`Status`,`loginvo_loginId`) values (1,'un,email,password,password','','login','admin,user','Jarvis','\0',6),(2,'un,password','text,password','login','admin,user','Jarvis','',6),(3,'un','text','login','admin,user','AA','',6),(4,'un','email','login','admin,user','Edith','',11);

/*Table structure for table `register_table` */

DROP TABLE IF EXISTS `register_table`;

CREATE TABLE `register_table` (
  `registerId` int(11) NOT NULL AUTO_INCREMENT,
  `dateOfBirth` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `mobileNumber` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `loginVO_loginId` int(11) DEFAULT NULL,
  PRIMARY KEY (`registerId`),
  KEY `FKimgpanpmccxpx6m343dfm9rmc` (`loginVO_loginId`),
  CONSTRAINT `FKimgpanpmccxpx6m343dfm9rmc` FOREIGN KEY (`loginVO_loginId`) REFERENCES `login` (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `register_table` */

insert  into `register_table`(`registerId`,`dateOfBirth`,`firstName`,`lastName`,`mobileNumber`,`profession`,`loginVO_loginId`) values (4,'09/10/1998','Aashay','Gandhi','7778976277','Cloud Architect',6),(9,'2019-09-09','Aashay','Gandhi','9824475359','Cloud Architect',11);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
