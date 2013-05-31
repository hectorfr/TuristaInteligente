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

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `ID_CLIENTE` decimal(8,0) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `PRIMER_APELLIDO` varchar(50) NOT NULL,
  `SEGUNDO_APELLIDO` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `TELEFONO` varchar(25) NOT NULL,
  `SEGUNDO_TELEFONO` varchar(25) DEFAULT NULL,
  `CEDULA` varchar(25) DEFAULT NULL,
  `EMPRESA` varchar(100) DEFAULT NULL,
  `USR_REGISTRO` varchar(50) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(50) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cliente` */

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
  `ID_PAQUETE` decimal(8,0) NOT NULL,
  `ID_TIPO_PAQUETE_NAC` decimal(8,0) DEFAULT NULL,
  `ID_TIPO_PAQUETE_INT` decimal(8,0) DEFAULT NULL,
  `NOMBRE_PAQUETE` varchar(50) NOT NULL,
  `DESCRIPCION_SERVICIOS` varchar(1000) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `FECHA_INICIO` datetime DEFAULT NULL,
  `FECHA_FINAL` datetime DEFAULT NULL,
  `USR_REGISTRO` varchar(50) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(50) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_PAQUETE`),
  KEY `FK_REFERENCE_TIPOPAQUETEINT_PAQUETE` (`ID_TIPO_PAQUETE_INT`),
  KEY `FK_REFERENCE_TIPOPAQUETENAC_PAQUETE` (`ID_TIPO_PAQUETE_NAC`),
  CONSTRAINT `FK_REFERENCE_TIPOPAQUETEINT_PAQUETE` FOREIGN KEY (`ID_TIPO_PAQUETE_INT`) REFERENCES `tipo_paquete_int` (`ID_TIPO_PAQUETE_INT`),
  CONSTRAINT `FK_REFERENCE_TIPOPAQUETENAC_PAQUETE` FOREIGN KEY (`ID_TIPO_PAQUETE_NAC`) REFERENCES `tipo_paquete_nac` (`ID_TIPO_PAQUETE_NAC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `paquete` */

/*Table structure for table `proveedor` */

DROP TABLE IF EXISTS `proveedor`;

CREATE TABLE `proveedor` (
  `ID_PROVEEDOR` decimal(8,0) NOT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  `TELEFONO` varchar(25) NOT NULL,
  `SEGUNDO_TELEFONO` varchar(25) DEFAULT NULL,
  `PRIMERA_CUENTA` varchar(50) NOT NULL,
  `BANCO_PRIM_CUENTA` varchar(50) NOT NULL,
  `SEGUNDA_CUENTA` varchar(50) DEFAULT NULL,
  `BANCO_SDA_CUENTA` varchar(50) DEFAULT NULL,
  `IND_SINPE_PRIM_CUENTA` char(1) NOT NULL,
  `IND_SINPE_SDA_CUENTA` char(1) DEFAULT NULL,
  `IND_MONEDA_PRIM_CUENTA` char(1) NOT NULL,
  `IND_MONEDA_SDA_CUENTA` char(1) DEFAULT NULL,
  `IND_IMP_SWIFT` char(1) DEFAULT NULL,
  `IND_IMP_AVA` char(1) DEFAULT NULL,
  `IND_COMISION` char(1) DEFAULT NULL,
  `IND_CREDITO` char(1) DEFAULT NULL,
  `CANT_DIAS_CREDITO` int(11) DEFAULT NULL,
  `USR_REGISTRO` varchar(50) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(50) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_PROVEEDOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `proveedor` */

/*Table structure for table `proveedores_reservacion` */

DROP TABLE IF EXISTS `proveedores_reservacion`;

CREATE TABLE `proveedores_reservacion` (
  `ID_RESERVACION` decimal(8,0) NOT NULL,
  `ID_PROVEEDOR` decimal(8,0) NOT NULL,
  PRIMARY KEY (`ID_RESERVACION`,`ID_PROVEEDOR`),
  KEY `FK_REFERENCE_PROVEEDOR_PROVRES` (`ID_PROVEEDOR`),
  CONSTRAINT `FK_REFERENCE_PROVEEDOR_PROVRES` FOREIGN KEY (`ID_PROVEEDOR`) REFERENCES `proveedor` (`ID_PROVEEDOR`),
  CONSTRAINT `FK_REFERENCE_RESERVACION_PROVRES` FOREIGN KEY (`ID_RESERVACION`) REFERENCES `reservacion` (`ID_RESERVACION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `proveedores_reservacion` */

/*Table structure for table `reservacion` */

DROP TABLE IF EXISTS `reservacion`;

CREATE TABLE `reservacion` (
  `ID_RESERVACION` decimal(8,0) NOT NULL,
  `ID_PAQUETE` decimal(8,0) DEFAULT NULL,
  `ID_TARIFA_RESERVACION` decimal(8,0) DEFAULT NULL,
  `ID_CLIENTE` decimal(8,0) DEFAULT NULL,
  `IND_ESTADO` char(1) NOT NULL,
  `NUM_CONFIRMACION` decimal(6,0) NOT NULL,
  `FECHA_PAGO_INICIO` datetime DEFAULT NULL,
  `FECHA_PAGO_FINAL` datetime DEFAULT NULL,
  `FECHA_LLEGADA` datetime DEFAULT NULL,
  `FECHA_SALIDA` datetime DEFAULT NULL,
  `USR_REGISTRO` varchar(50) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(50) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_RESERVACION`),
  KEY `FK_REFERENCE_CLIENTE_RESERVACION` (`ID_CLIENTE`),
  KEY `FK_REFERENCE_PAQUETE_RESERVACION` (`ID_PAQUETE`),
  CONSTRAINT `FK_REFERENCE_CLIENTE_RESERVACION` FOREIGN KEY (`ID_CLIENTE`) REFERENCES `cliente` (`ID_CLIENTE`),
  CONSTRAINT `FK_REFERENCE_PAQUETE_RESERVACION` FOREIGN KEY (`ID_PAQUETE`) REFERENCES `paquete` (`ID_PAQUETE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reservacion` */

/*Table structure for table `tarifa_habitacion` */

DROP TABLE IF EXISTS `tarifa_habitacion`;

CREATE TABLE `tarifa_habitacion` (
  `ID_TARIFA_HABITACION` decimal(8,0) NOT NULL,
  `TIPO_HABITACION` varchar(20) NOT NULL,
  `CANTIDAD` decimal(2,0) NOT NULL,
  `USR_REGISTRO` varchar(50) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(50) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL,
  `MONTO_PERSONA` decimal(8,2) NOT NULL,
  `MONTO_NINIO` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`ID_TARIFA_HABITACION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tarifa_habitacion` */

/*Table structure for table `tarifa_paquete` */

DROP TABLE IF EXISTS `tarifa_paquete`;

CREATE TABLE `tarifa_paquete` (
  `ID_TARIFA_PAQUETE` decimal(8,0) NOT NULL,
  `CANT_ADULTO_NAC` int(11) DEFAULT NULL,
  `CANT_ADULTO_INT` int(11) DEFAULT NULL,
  `CANT_NINIO_NAC` int(11) DEFAULT NULL,
  `CANT_NINIO_INT` int(11) DEFAULT NULL,
  `MONTO_ADULTO_NAC` decimal(10,2) DEFAULT NULL,
  `MONTO_ADULTO_INT` decimal(10,2) DEFAULT NULL,
  `MONTO_NINIO_NAC` decimal(10,2) DEFAULT NULL,
  `MONTO_NINIO_INT` decimal(10,2) DEFAULT NULL,
  `USR_REGISTRO` varchar(50) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(50) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_TARIFA_PAQUETE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tarifa_paquete` */

/*Table structure for table `tarifa_reservacion` */

DROP TABLE IF EXISTS `tarifa_reservacion`;

CREATE TABLE `tarifa_reservacion` (
  `ID_TARIFA_RESERVACION` decimal(8,0) NOT NULL,
  `CANT_ADULTO_NAC` int(11) DEFAULT NULL,
  `CANT_ADULTO_INT` int(11) DEFAULT NULL,
  `CANT_NINIO_NAC` int(11) DEFAULT NULL,
  `CANT_NINIO_INT` int(11) DEFAULT NULL,
  `MONTO_ADULTO_NAC` decimal(10,2) DEFAULT NULL,
  `MONTO_ADULTO_INT` decimal(10,2) DEFAULT NULL,
  `MONTO_NINIO_NAC` decimal(10,2) DEFAULT NULL,
  `MONTO_NINIO_INT` decimal(10,2) DEFAULT NULL,
  `USR_REGISTRO` varchar(50) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(50) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tarifa_reservacion` */

/*Table structure for table `tipo_paquete_int` */

DROP TABLE IF EXISTS `tipo_paquete_int`;

CREATE TABLE `tipo_paquete_int` (
  `ID_TIPO_PAQUETE_INT` decimal(8,0) NOT NULL,
  `ID_TARIFA_PAQUETE` decimal(8,0) DEFAULT NULL,
  `LOCALIDAD` varchar(25) NOT NULL,
  `TIPO_VEHICULO` varchar(25) DEFAULT NULL,
  `TIPO_TRASLADO` varchar(25) DEFAULT NULL,
  `LUGAR_SALIDA` varchar(100) DEFAULT NULL,
  `LUGAR_LLEGADA` varchar(100) DEFAULT NULL,
  `DIRECCION` varchar(500) DEFAULT NULL,
  `HOTEL` varchar(100) DEFAULT NULL,
  `OBSERVACIONES` varchar(1000) DEFAULT NULL,
  `USR_REGISTRO` varchar(50) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(50) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL,
  `ID_TARIFA_HABITACION` decimal(8,0) DEFAULT NULL,
  `TIPO_TARIFA` varchar(25) NOT NULL,
  PRIMARY KEY (`ID_TIPO_PAQUETE_INT`,`TIPO_TARIFA`),
  KEY `FK_REFERENCE_TARIFAPAQ_TIPOPAQINT` (`ID_TARIFA_PAQUETE`),
  KEY `FK_REFERENCE_TARIFAHAB_TIPOPAQINT` (`ID_TARIFA_HABITACION`),
  CONSTRAINT `FK_REFERENCE_TARIFAHAB_TIPOPAQINT` FOREIGN KEY (`ID_TARIFA_HABITACION`) REFERENCES `tarifa_habitacion` (`ID_TARIFA_HABITACION`),
  CONSTRAINT `FK_REFERENCE_TARIFAPAQ_TIPOPAQINT` FOREIGN KEY (`ID_TARIFA_PAQUETE`) REFERENCES `tarifa_paquete` (`ID_TARIFA_PAQUETE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_paquete_int` */

/*Table structure for table `tipo_paquete_nac` */

DROP TABLE IF EXISTS `tipo_paquete_nac`;

CREATE TABLE `tipo_paquete_nac` (
  `ID_TIPO_PAQUETE_NAC` decimal(8,0) NOT NULL,
  `ID_TARIFA_PAQUETE` decimal(8,0) DEFAULT NULL,
  `TIPO_TARIFA` varchar(25) NOT NULL,
  `DESCRIPCION_SERVICIOS` varchar(1000) DEFAULT NULL,
  `HOTEL` varchar(100) DEFAULT NULL,
  `OBSERVACIONES` varchar(1000) DEFAULT NULL,
  `USR_REGISTRO` varchar(50) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(50) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL,
  `ID_TARIFA_HABITACION` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID_TIPO_PAQUETE_NAC`),
  KEY `FK_REFERENCE_TARIFAPAQ_TIPOPAQ` (`ID_TARIFA_PAQUETE`),
  KEY `FK_REFERENCE_TARIFAHAB_TIPOPAQNAC` (`ID_TARIFA_HABITACION`),
  CONSTRAINT `FK_REFERENCE_TARIFAHAB_TIPOPAQNAC` FOREIGN KEY (`ID_TARIFA_HABITACION`) REFERENCES `tarifa_habitacion` (`ID_TARIFA_HABITACION`),
  CONSTRAINT `FK_REFERENCE_TARIFAPAQ_TIPOPAQ` FOREIGN KEY (`ID_TARIFA_PAQUETE`) REFERENCES `tarifa_paquete` (`ID_TARIFA_PAQUETE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tipo_paquete_nac` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `ID_USUARIO` decimal(8,0) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `PRIMER_APELLIDO` varchar(50) NOT NULL,
  `SEGUNDO_APELLIDO` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `PASSWORD` varchar(25) NOT NULL,
  `IND_TIPO` char(1) NOT NULL,
  `TELEFONO` varchar(25) DEFAULT NULL,
  `USR_REGISTRO` varchar(50) NOT NULL,
  `FEC_REGISTRO` datetime NOT NULL,
  `USR_MODIFICACION` varchar(50) DEFAULT NULL,
  `FEC_MODIFICACION` datetime DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`ID_USUARIO`,`NOMBRE`,`PRIMER_APELLIDO`,`SEGUNDO_APELLIDO`,`EMAIL`,`PASSWORD`,`IND_TIPO`,`TELEFONO`,`USR_REGISTRO`,`FEC_REGISTRO`,`USR_MODIFICACION`,`FEC_MODIFICACION`) values ('1','admin','admin','admin','admin','123456','A','admin','admin','2013-05-30 00:00:00',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
