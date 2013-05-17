/*
SQLyog Enterprise - MySQL GUI v6.5
MySQL - 5.1.37-community : Database - turistainteligente
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

create database if not exists `turistainteligente`;

USE `turistainteligente`;

/*Table structure for table `ciudad` */

DROP TABLE IF EXISTS `ciudad`;

CREATE TABLE `ciudad` (
  `IDCIUDAD` int(11) NOT NULL AUTO_INCREMENT,
  `IDPAIS` int(11) NOT NULL,
  `NOMBRE` varchar(25) NOT NULL,
  PRIMARY KEY (`IDCIUDAD`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `ciudad` */

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `IDCLIENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(25) NOT NULL,
  `PRIMERAPELLIDO` varchar(25) NOT NULL,
  `SEGUNDOAPELLIDO` varchar(25) DEFAULT NULL,
  `TELEFONO` varchar(25) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `CEDULA` varchar(20) DEFAULT NULL,
  `EMPRESA` varchar(100) DEFAULT NULL,
  `TELEFONO2` varchar(25) DEFAULT NULL,
  `USR_REGISTRO` varchar(100) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(100) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL,
  PRIMARY KEY (`IDCLIENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `IDHOTEL` int(11) NOT NULL AUTO_INCREMENT,
  `IDCIUDAD` int(11) DEFAULT NULL,
  `NOMBRE` varchar(25) NOT NULL,
  PRIMARY KEY (`IDHOTEL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hotel` */

/*Table structure for table `pais` */

DROP TABLE IF EXISTS `pais`;

CREATE TABLE `pais` (
  `IDPAIS` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(25) NOT NULL,
  PRIMARY KEY (`IDPAIS`)
) ENGINE=InnoDB AUTO_INCREMENT=255 DEFAULT CHARSET=latin1;

/*Data for the table `pais` */

insert  into `pais`(`IDPAIS`,`NOMBRE`) values (1,'Afganistán'),(2,'Akrotiri'),(3,'Albania'),(4,'Alemania'),(5,'Andorra'),(6,'Angola'),(7,'Anguila'),(8,'Antártida'),(9,'Antigua y Barbuda'),(10,'Antillas Neerlandesas'),(11,'Arabia Saudí'),(12,'Arctic Ocean'),(13,'Argelia'),(14,'Argentina'),(15,'Armenia'),(16,'Aruba'),(17,'Ashmore andCartier Island'),(18,'Atlantic Ocean'),(19,'Australia'),(20,'Austria'),(21,'Azerbaiyán'),(22,'Bahamas'),(23,'Bahráin'),(24,'Bangladesh'),(25,'Barbados'),(26,'Bélgica'),(27,'Belice'),(28,'Benín'),(29,'Bermudas'),(30,'Bielorrusia'),(31,'Birmania Myanmar'),(32,'Bolivia'),(33,'Bosnia y Hercegovina'),(34,'Botsuana'),(35,'Brasil'),(36,'Brunéi'),(37,'Bulgaria'),(38,'Burkina Faso'),(39,'Burundi'),(40,'Bután'),(41,'Cabo Verde'),(42,'Camboya'),(43,'Camerún'),(44,'Canadá'),(45,'Chad'),(46,'Chile'),(47,'China'),(48,'Chipre'),(49,'Clipperton Island'),(50,'Colombia'),(51,'Comoras'),(52,'Congo'),(53,'Coral Sea Islands'),(54,'Corea del Norte'),(55,'Corea del Sur'),(56,'Costa de Marfil'),(57,'Costa Rica'),(58,'Croacia'),(59,'Cuba'),(60,'Dhekelia'),(61,'Dinamarca'),(62,'Dominica'),(63,'Ecuador'),(64,'Egipto'),(65,'El Salvador'),(66,'El Vaticano'),(67,'Emiratos Árabes Unidos'),(68,'Eritrea'),(69,'Eslovaquia'),(70,'Eslovenia'),(71,'España'),(72,'Estados Unidos'),(73,'Estonia'),(74,'Etiopía'),(75,'Filipinas'),(76,'Finlandia'),(77,'Fiyi'),(78,'Francia'),(79,'Gabón'),(80,'Gambia'),(81,'Gaza Strip'),(82,'Georgia'),(83,'Ghana'),(84,'Gibraltar'),(85,'Granada'),(86,'Grecia'),(87,'Groenlandia'),(88,'Guam'),(89,'Guatemala'),(90,'Guernsey'),(91,'Guinea'),(92,'Guinea Ecuatorial'),(93,'Guinea-Bissau'),(94,'Guyana'),(95,'Haití'),(96,'Honduras'),(97,'Hong Kong'),(98,'Hungría'),(99,'India'),(100,'Indian Ocean'),(101,'Indonesia'),(102,'Irán'),(103,'Iraq'),(104,'Irlanda'),(105,'Isla Bouvet'),(106,'Isla Christmas'),(107,'Isla Norfolk'),(108,'Islandia'),(109,'Islas Caimán'),(110,'Islas Cocos'),(111,'Islas Cook'),(112,'Islas Feroe'),(113,'Islas Georgia del Sur y S'),(114,'Islas Heard y McDonald'),(115,'Islas Malvinas'),(116,'Islas Marianas del Norte'),(117,'IslasMarshall'),(118,'Islas Pitcairn'),(119,'Islas Salomón'),(120,'Islas Turcas y Caicos'),(121,'Islas Vírgenes Americanas'),(122,'Islas Vírgenes Británicas'),(123,'Israel'),(124,'Italia'),(125,'Jamaica'),(126,'Jan Mayen'),(127,'Japón'),(128,'Jersey'),(129,'Jordania'),(130,'Kazajistán'),(131,'Kenia'),(132,'Kirguizistán'),(133,'Kiribati'),(134,'Kuwait'),(135,'Laos'),(136,'Lesoto'),(137,'Letonia'),(138,'Líbano'),(139,'Liberia'),(140,'Libia'),(141,'Liechtenstein'),(142,'Lituania'),(143,'Luxemburgo'),(144,'Macao'),(145,'Macedonia'),(146,'Madagascar'),(147,'Malasia'),(148,'Malaui'),(149,'Maldivas'),(150,'Malí'),(151,'Malta'),(152,'Man, Isle of'),(153,'Marruecos'),(154,'Mauricio'),(155,'Mauritania'),(156,'Mayotte'),(157,'México'),(158,'Micronesia'),(159,'Moldavia'),(160,'Mónaco'),(161,'Mongolia'),(162,'Montserrat'),(163,'Mozambique'),(164,'Namibia'),(165,'Nauru'),(166,'Navassa Island'),(167,'Nepal'),(168,'Nicaragua'),(169,'Níger'),(170,'Nigeria'),(171,'Niue'),(172,'Noruega'),(173,'Nueva Caledonia'),(174,'Nueva Zelanda'),(175,'Omán'),(176,'Pacific Ocean'),(177,'Países Bajos'),(178,'Pakistán'),(179,'Palaos'),(180,'Panamá'),(181,'Papúa-Nueva Guinea'),(182,'Paracel Islands'),(183,'Paraguay'),(184,'Perú'),(185,'Polinesia Francesa'),(186,'Polonia'),(187,'Portugal'),(188,'Puerto Rico'),(189,'Qatar'),(190,'Reino Unido'),(191,'República Centroafricana'),(192,'República Checa'),(193,'República Democrática del'),(194,'República Dominicana'),(195,'Ruanda'),(196,'Rumania'),(197,'Rusia'),(198,'Sáhara Occidental'),(199,'Samoa'),(200,'Samoa Americana'),(201,'San Cristóbal y Nieves'),(202,'San Marino'),(203,'San Pedro y Miquelón'),(204,'San Vicente y las Granadi'),(205,'Santa Helena'),(206,'Santa Lucía'),(207,'Santo Tomé y Príncipe'),(208,'Senegal'),(209,'Seychelles'),(210,'Sierra Leona'),(211,'Singapur'),(212,'Siria'),(213,'Somalia'),(214,'Southern Ocean'),(215,'Spratly Islands'),(216,'Sri Lanka'),(217,'Suazilandia'),(218,'Sudáfrica'),(219,'Sudán'),(220,'Suecia'),(221,'Suiza'),(222,'Surinam'),(223,'Svalbard y Jan Mayen'),(224,'Tailandia'),(225,'Taiwán'),(226,'Tanzania'),(227,'Tayikistán'),(228,'TerritorioBritánicodel Oc'),(229,'Territorios Australes Fra'),(230,'Timor Oriental'),(231,'Togo'),(232,'Tokelau'),(233,'Tonga'),(234,'Trinidad y Tobago'),(235,'Túnez'),(236,'Turkmenistán'),(237,'Turquía'),(238,'Tuvalu'),(239,'Ucrania'),(240,'Uganda'),(241,'Unión Europea'),(242,'Uruguay'),(243,'Uzbekistán'),(244,'Vanuatu'),(245,'Venezuela'),(246,'Vietnam'),(247,'Wake Island'),(248,'Wallis y Futuna'),(249,'West Bank'),(250,'World'),(251,'Yemen'),(252,'Yibuti'),(253,'Zambia'),(254,'Zimbabue');

/*Table structure for table `paquete` */

DROP TABLE IF EXISTS `paquete`;

CREATE TABLE `paquete` (
  `IDPAQUETE` int(11) NOT NULL AUTO_INCREMENT,
  `ADULTONAC` int(11) DEFAULT NULL,
  `ADULTOEXT` int(11) DEFAULT NULL,
  `NINIONAC` int(11) DEFAULT NULL,
  `NINIOEXT` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPAQUETE`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `paquete` */

/*Table structure for table `proveedor` */

DROP TABLE IF EXISTS `proveedor`;

CREATE TABLE `proveedor` (
  `IDPROVEEDOR` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(100) NOT NULL,
  `TELEFONO` varchar(25) NOT NULL,
  `EMAIL` varchar(25) DEFAULT NULL,
  `CUENTABANCARIA` varchar(50) NOT NULL,
  `BANCO` varchar(25) NOT NULL,
  `CEDULAJURIDICA` varchar(25) NOT NULL,
  `CUENTABANCARIA2` varchar(50) DEFAULT NULL,
  `IND_SINPE` tinyint(1) DEFAULT NULL,
  `IND_CUENTA_CORRIENTE` tinyint(1) DEFAULT NULL,
  `IND_COLONES` tinyint(1) DEFAULT NULL,
  `IND_DOLARES` tinyint(1) DEFAULT NULL,
  `IMP_SWIFT` tinyint(1) DEFAULT NULL,
  `IMP_AVA` tinyint(1) DEFAULT NULL,
  `COMISION` double DEFAULT NULL,
  PRIMARY KEY (`IDPROVEEDOR`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `proveedor` */

/*Table structure for table `reservacion` */

DROP TABLE IF EXISTS `reservacion`;

CREATE TABLE `reservacion` (
  `IDRESERVACION` int(11) NOT NULL AUTO_INCREMENT,
  `IDHOTEL` int(11) DEFAULT NULL,
  `IDTARIFA` int(11) DEFAULT NULL,
  `IDTARIFANETA` int(11) DEFAULT NULL,
  `IDUSUARIO` int(11) NOT NULL,
  `IDPROVEEDOR` int(11) DEFAULT NULL,
  `IDCLIENTE` int(11) DEFAULT NULL,
  `FECHARESERVACION` datetime NOT NULL,
  `FECHAENTRADA` datetime NOT NULL,
  `FECHASALIDA` datetime NOT NULL,
  `HORARECOGIDA` varchar(10) DEFAULT NULL,
  `LUGARRECOGIDA` varchar(100) DEFAULT NULL,
  `CLIENTES` varchar(200) DEFAULT NULL,
  `DESCRIPCIONSERVICIO` text NOT NULL,
  `OBSERVACIONES` text,
  `usuarioMod` varchar(50) DEFAULT NULL,
  `fechaMod` datetime DEFAULT NULL,
  `fechaCreacion` datetime NOT NULL,
  PRIMARY KEY (`IDRESERVACION`),
  KEY `FK_REFERENCE_3` (`IDHOTEL`),
  KEY `FK_REFERENCE_6` (`IDTARIFANETA`),
  KEY `FK_REFERENCE_7` (`IDUSUARIO`),
  KEY `FK_REFERENCE_8` (`IDPROVEEDOR`),
  KEY `FK_REFERENCE_9` (`IDCLIENTE`),
  KEY `FK_reservacion_tarifapaquete` (`IDTARIFA`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`IDHOTEL`) REFERENCES `hotel` (`IDHOTEL`),
  CONSTRAINT `FK_REFERENCE_6` FOREIGN KEY (`IDTARIFANETA`) REFERENCES `tarifaneta` (`IDTARIFANETA`),
  CONSTRAINT `FK_REFERENCE_7` FOREIGN KEY (`IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`),
  CONSTRAINT `FK_REFERENCE_8` FOREIGN KEY (`IDPROVEEDOR`) REFERENCES `proveedor` (`IDPROVEEDOR`),
  CONSTRAINT `FK_REFERENCE_9` FOREIGN KEY (`IDCLIENTE`) REFERENCES `cliente` (`IDCLIENTE`),
  CONSTRAINT `FK_reservacion_tarifapaquete` FOREIGN KEY (`IDTARIFA`) REFERENCES `tarifapaquete` (`IDTARIFA`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `reservacion` */

/*Table structure for table `reservacion_proveedor` */

DROP TABLE IF EXISTS `reservacion_proveedor`;

CREATE TABLE `reservacion_proveedor` (
  `ID_RESERV_PROVEE` int(11) NOT NULL AUTO_INCREMENT,
  `IDRESERVACION` int(11) NOT NULL,
  `IDPROVEEDOR` int(11) NOT NULL,
  PRIMARY KEY (`ID_RESERV_PROVEE`),
  KEY `FK_reservacion_proveedor_reservacion` (`IDRESERVACION`),
  KEY `FK_reservacion_proveedor_proveedor` (`IDPROVEEDOR`),
  CONSTRAINT `FK_reservacion_proveedor_proveedor` FOREIGN KEY (`IDPROVEEDOR`) REFERENCES `proveedor` (`IDPROVEEDOR`),
  CONSTRAINT `FK_reservacion_proveedor_reservacion` FOREIGN KEY (`IDRESERVACION`) REFERENCES `reservacion` (`IDRESERVACION`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `reservacion_proveedor` */

/*Table structure for table `reservacion_tarifapaq` */

DROP TABLE IF EXISTS `reservacion_tarifapaq`;

CREATE TABLE `reservacion_tarifapaq` (
  `ID_RESERV_TARIFPAQ` int(11) NOT NULL AUTO_INCREMENT,
  `IDTARIFA` int(11) NOT NULL,
  `IDRESERVACION` int(11) NOT NULL,
  PRIMARY KEY (`ID_RESERV_TARIFPAQ`),
  KEY `FK_reservacion_tarifapap_reserv` (`IDRESERVACION`),
  KEY `FK_reservacion_tarifapap_tarpaq` (`IDTARIFA`),
  CONSTRAINT `FK_reservacion_tarifapap_reserv` FOREIGN KEY (`IDRESERVACION`) REFERENCES `reservacion` (`IDRESERVACION`),
  CONSTRAINT `FK_reservacion_tarifapap_tarpaq` FOREIGN KEY (`IDTARIFA`) REFERENCES `tarifapaquete` (`IDTARIFA`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `reservacion_tarifapaq` */

/*Table structure for table `tarifaneta` */

DROP TABLE IF EXISTS `tarifaneta`;

CREATE TABLE `tarifaneta` (
  `IDTARIFANETA` int(11) NOT NULL AUTO_INCREMENT,
  `ADULTONAC` double DEFAULT NULL,
  `ADULTOEXT` double DEFAULT NULL,
  `NINIONAC` double DEFAULT NULL,
  `NINIOEXT` double DEFAULT NULL,
  `TOTAL` double NOT NULL,
  `IMPUESTOS` double DEFAULT NULL,
  PRIMARY KEY (`IDTARIFANETA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tarifaneta` */

/*Table structure for table `tarifapaquete` */

DROP TABLE IF EXISTS `tarifapaquete`;

CREATE TABLE `tarifapaquete` (
  `IDTARIFA` int(11) NOT NULL AUTO_INCREMENT,
  `ADULTONAC` double DEFAULT NULL,
  `ADULTOEXT` double DEFAULT NULL,
  `NINIONAC` double DEFAULT NULL,
  `NINIOEXT` double DEFAULT NULL,
  `TOTAL` double NOT NULL,
  `IMPUESTOS` double DEFAULT NULL,
  `IDPROVEEDOR` int(11) NOT NULL,
  `IDPAQUETE` int(11) DEFAULT NULL,
  `INDINTER` tinyint(1) NOT NULL,
  PRIMARY KEY (`IDTARIFA`),
  KEY `FK_tarifapaquete_proveedor` (`IDPROVEEDOR`),
  KEY `FK_tarifapaquete_paquete` (`IDPAQUETE`),
  CONSTRAINT `FK_tarifapaquete_paquete` FOREIGN KEY (`IDPAQUETE`) REFERENCES `paquete` (`IDPAQUETE`),
  CONSTRAINT `FK_tarifapaquete_proveedor` FOREIGN KEY (`IDPROVEEDOR`) REFERENCES `proveedor` (`IDPROVEEDOR`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `tarifapaquete` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `IDUSUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(25) NOT NULL,
  `PRIMERAPELLIDO` varchar(25) NOT NULL,
  `SEGUNDOAPELLIDO` varchar(25) DEFAULT NULL,
  `PASSWORD` varchar(25) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `TIPOUSUARIO` char(1) NOT NULL,
  `TELEFONO` varchar(15) DEFAULT NULL,
  `USR_REGISTRO` varchar(100) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(100) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL,
  PRIMARY KEY (`IDUSUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`IDUSUARIO`,`NOMBRE`,`PRIMERAPELLIDO`,`SEGUNDOAPELLIDO`,`PASSWORD`,`EMAIL`,`TIPOUSUARIO`,`TELEFONO`,`USR_REGISTRO`,`FEC_REGISTRO`,`USR_MODIFICACION`,`FEC_MODIFICACION`) values (1,'prueba','prueba','prueba','1','prueba','A',NULL,'','0000-00-00 00:00:00',NULL,NULL),(2,'usuario2','usuario2','usuario2','usuario2','usuario2','N',NULL,'','0000-00-00 00:00:00',NULL,NULL),(3,'usuario3','usuario3','usuario3','usuario3','usuario3','A',NULL,'','0000-00-00 00:00:00',NULL,NULL),(4,'usuario4','usuario4','usuario4','usuario4','usuario4','A',NULL,'','0000-00-00 00:00:00',NULL,NULL),(5,'usuario3','usuario3','usuario3','usuario3','usuario3','A',NULL,'','0000-00-00 00:00:00',NULL,NULL),(6,'usuario4','usuario4','usuario4','usuario4','usuario4','A',NULL,'','0000-00-00 00:00:00',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
