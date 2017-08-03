/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.7.17-log : Database - inventory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`inventory` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `inventory`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`id`,`typeId`) values 
(3,10),
(7,10),
(8,10),
(9,10),
(11,10),
(12,10),
(13,10),
(14,10);

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) NOT NULL,
  `defaultFlat` tinyint(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `countryId` int(11) NOT NULL,
  `stateId` int(11) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `zip` varchar(20) DEFAULT NULL,
  `typeId` int(11) NOT NULL,
  `residentialFlag` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`id`,`accountId`,`defaultFlat`,`name`,`city`,`countryId`,`stateId`,`address`,`zip`,`typeId`,`residentialFlag`) values 
(2,11,1,'Customer1 address1','Phnom Penh',61,NULL,'St. 232, #323 , .. , ..',NULL,10,0),
(3,12,1,'Customer1 address1','Phnom Penh',61,NULL,'St. 232, #323 , .. , ..',NULL,10,0),
(4,13,1,'Customer1 address1','Phnom Penh',61,NULL,'St. 232, #323 , .. , ..',NULL,10,0),
(5,14,1,'Customer1 address1','Phnom Penh',61,NULL,'St. 232, #323 , .. , ..',NULL,10,0);

/*Table structure for table `asso_customer_product` */

DROP TABLE IF EXISTS `asso_customer_product`;

CREATE TABLE `asso_customer_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `customerPartNum` varchar(20) NOT NULL,
  `dateLastPurchased` datetime DEFAULT NULL,
  `lastPrice` float NOT NULL,
  `dateCreated` datetime NOT NULL,
  `dateLastModified` datetime NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `asso_customer_product` */

/*Table structure for table `carrier` */

DROP TABLE IF EXISTS `carrier`;

CREATE TABLE `carrier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL DEFAULT b'1',
  `name` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `readOnlyFlag` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `carrier` */

insert  into `carrier`(`id`,`activeFlag`,`name`,`description`,`readOnlyFlag`) values 
(1,'','Will ','Customer will Pickup',''),
(2,'','Delivery','Deliver to Customer',''),
(3,'','UPS','What can brown do for you?','\0'),
(4,'','FedEx','The best choice for shipments that must meet deadlines reliably and on time.','\0'),
(5,'','USPS','United States Post Office','\0');

/*Table structure for table `carrier_service` */

DROP TABLE IF EXISTS `carrier_service`;

CREATE TABLE `carrier_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carrierId` int(11) DEFAULT NULL,
  `activeFlag` bit(1) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `readOnlyFlag` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `carrier_service` */

insert  into `carrier_service`(`id`,`carrierId`,`activeFlag`,`code`,`name`,`readOnlyFlag`) values 
(1,1,'','01','Next Day Air','');

/*Table structure for table `contact` */

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) NOT NULL,
  `addressId` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `data` varchar(100) NOT NULL,
  `typeId` int(11) NOT NULL,
  `defaultFlag` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `contact` */

insert  into `contact`(`id`,`accountId`,`addressId`,`name`,`data`,`typeId`,`defaultFlag`) values 
(1,11,2,'contact1','855923444',10,0),
(2,12,3,'contact1','855923444',10,0),
(3,13,4,'contact1','855923444',10,0),
(4,14,5,'contact1','855923444',10,0);

/*Table structure for table `cost_layer` */

DROP TABLE IF EXISTS `cost_layer`;

CREATE TABLE `cost_layer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `partId` int(11) NOT NULL,
  `orgQty` float NOT NULL,
  `orgTotalCost` double NOT NULL,
  `qty` float NOT NULL,
  `totalCost` double NOT NULL,
  `statusId` int(11) NOT NULL,
  `recordId` int(11) DEFAULT NULL,
  `tableId` int(11) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  `dateLastModified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cost_layer` */

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `abbr` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=utf8;

/*Data for the table `country` */

insert  into `country`(`id`,`name`,`abbr`) values 
(1,'Unknown','Unknown'),
(2,'UNITED STATES','US'),
(3,'CANADA','CA'),
(4,'UNITED KINGDOM','GB'),
(5,'RUSSIAN FEDERATION','RU'),
(6,'CHINA','CN'),
(7,'JAPAN','JP'),
(8,'KOREA, REPUBLIC OF','KR'),
(9,'KOREA, DEMOCRATIC PEOPLE\'S REPUBLIC OF','KP'),
(10,'MEXICO','MX'),
(11,'GERMANY','DE'),
(12,'SPAIN','ES'),
(13,'FRANCE','FR'),
(14,'FINLAND','FI'),
(15,'ICELAND','IS'),
(16,'AUSTRALIA','AU'),
(17,'AFGHANISTAN','AF'),
(18,'ALAND ISLANDS','AX'),
(19,'ALBANIA','AL'),
(20,'ALGERIA','DZ'),
(21,'AMERICAN SAMOA','AS'),
(22,'ANDORRA','AD'),
(23,'ANGOLA','AO'),
(24,'ANGUILLA','AI'),
(25,'ANTARCTICA','AQ'),
(26,'ANTIGUA AND BARBUDA','AG'),
(27,'ARGENTINA','AR'),
(28,'ARMENIA','AM'),
(29,'ARUBA','AW'),
(30,'AUSTRIA','AT'),
(31,'AZERBAIJAN','AZ'),
(32,'BAHAMAS','BS'),
(33,'BAHRAIN','BH'),
(34,'BANGLADESH','BD'),
(35,'BARBADOS','BB'),
(36,'BELARUS','BY'),
(37,'BELGIUM','BE'),
(38,'BELIZE','BZ'),
(39,'BENIN','BJ'),
(40,'BERMUDA','BM'),
(41,'BHUTAN','BT'),
(42,'BOLIVIA','BO'),
(43,'BOSNIA AND HERZEGOVINA','BA'),
(44,'BOTSWANA','BW'),
(45,'BOUVET ISLAND','BV'),
(46,'BRAZIL','BR'),
(47,'BRITISH INDIAN OCEAN TERRITORY','IO'),
(48,'BRUNEI DARUSSALAM','BN'),
(49,'BULGARIA','BG'),
(50,'BURKINA FASO','BF'),
(51,'BURUNDI','BI'),
(52,'CAMBODIA','KH'),
(53,'CAMEROON','CM'),
(54,'CAPE VERDE','CV'),
(55,'CAYMAN ISLANDS','KY'),
(56,'CENTRAL AFRICAN REPUBLIC','CF'),
(57,'CHAD','TD'),
(58,'CHILE','CL'),
(59,'CHRISTMAS ISLAND','CX'),
(60,'COCOS (KEELING) ISLANDS','CC'),
(61,'COLOMBIA','CO'),
(62,'COMOROS','KM'),
(63,'CONGO','CG'),
(64,'CONGO, THE DEMOCRATIC REPUBLIC OF THE','CD'),
(65,'COOK ISLANDS','CK'),
(66,'COSTA RICA','CR'),
(67,'COTE D\'IVOIRE','CI'),
(68,'CROATIA','HR'),
(69,'CUBA','CU'),
(70,'CYPRUS','CY'),
(71,'CZECH REPUBLIC','CZ'),
(72,'DENMARK','DK'),
(73,'DJIBOUTI','DJ'),
(74,'DOMINICA','DM'),
(75,'DOMINICAN REPUBLIC','DO'),
(76,'ECUADOR','EC'),
(77,'EGYPT','EG'),
(78,'EL SALVADOR','SV'),
(79,'EQUATORIAL GUINEA','GQ'),
(80,'ERITREA','ER'),
(81,'ESTONIA','EE'),
(82,'ETHIOPIA','ET'),
(83,'FALKLAND ISLANDS (MALVINAS)','FK'),
(84,'FAROE ISLANDS','FO'),
(85,'FIJI','FJ'),
(86,'FRENCH GUIANA','GF'),
(87,'FRENCH POLYNESIA','PF'),
(88,'FRENCH SOUTHERN TERRITORIES','TF'),
(89,'GABON','GA'),
(90,'GAMBIA','GM'),
(91,'GEORGIA','GE'),
(92,'GHANA','GH'),
(93,'GIBRALTAR','GI'),
(94,'GREECE','GR'),
(95,'GREENLAND','GL'),
(96,'GRENADA','GD'),
(97,'GUADELOUPE','GP'),
(98,'GUAM','GU'),
(99,'GUATEMALA','GT'),
(100,'GUERNSEY','GG'),
(101,'GUINEA','GN'),
(102,'GUINEA-BISSAU','GW'),
(103,'GUYANA','GY'),
(104,'HAITI','HT'),
(105,'HEARD ISLAND AND MCDONALD ISLANDS','HM'),
(106,'HOLY SEE (VATICAN CITY STATE)','VA'),
(107,'HONDURAS','HN'),
(108,'HONG KONG','HK'),
(109,'HUNGARY','HU'),
(110,'INDIA','IN'),
(111,'INDONESIA','ID'),
(112,'IRAN, ISLAMIC REPUBLIC OF','IR'),
(113,'IRAQ','IQ'),
(114,'IRELAND','IE'),
(115,'ISLE OF MAN','IM'),
(116,'ISRAEL','IL'),
(117,'ITALY','IT'),
(118,'JAMAICA','JM'),
(119,'JERSEY','JE'),
(120,'JORDAN','JO'),
(121,'KAZAKHSTAN','KZ'),
(122,'KENYA','KE'),
(123,'KIRIBATI','KI'),
(124,'KUWAIT','KW'),
(125,'KYRGYZSTAN','KG'),
(126,'LATVIA','LV'),
(127,'LEBANON','LB'),
(128,'LESOTHO','LS'),
(129,'LIBERIA','LR'),
(130,'LIBYAN ARAB JAMAHIRIYA','LY'),
(131,'LIECHTENSTEIN','LI'),
(132,'LITHUANIA','LT'),
(133,'LUXEMBOURG','LU'),
(134,'MACAO','MO'),
(135,'MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF','MK'),
(136,'MADAGASCAR','MG'),
(137,'MALAWI','MW'),
(138,'MALAYSIA','MY'),
(139,'MALDIVES','MV'),
(140,'MALI','ML'),
(141,'MALTA','MT'),
(142,'MARSHALL ISLANDS','MH'),
(143,'MARTINIQUE','MQ'),
(144,'MAURITANIA','MR'),
(145,'MAURITIUS','MU'),
(146,'MAYOTTE','YT'),
(147,'MICRONESIA, FEDERATED STATES OF','FM'),
(148,'MOLDOVA, REPUBLIC OF','MD'),
(149,'MONACO','MC'),
(150,'MONGOLIA','MN'),
(151,'MONTSERRAT','MS'),
(152,'MOROCCO','MA'),
(153,'MOZAMBIQUE','MZ'),
(154,'MYANMAR','MM'),
(155,'NAMIBIA','NA'),
(156,'NAURU','NR'),
(157,'NEPAL','NP'),
(158,'NETHERLANDS','NL'),
(159,'NETHERLANDS ANTILLES','AN'),
(160,'NEW CALEDONIA','NC'),
(161,'NEW ZEALAND','NZ'),
(162,'NICARAGUA','NI'),
(163,'NIGER','NE'),
(164,'NIGERIA','NG'),
(165,'NIUE','NU'),
(166,'NORFOLK ISLAND','NF'),
(167,'NORTHERN MARIANA ISLANDS','MP'),
(168,'NORWAY','NO'),
(169,'OMAN','OM'),
(170,'PAKISTAN','PK'),
(171,'PALAU','PW'),
(172,'PALESTINIAN TERRITORY, OCCUPIED','PS'),
(173,'PANAMA','PA'),
(174,'PAPUA NEW GUINEA','PG'),
(175,'PARAGUAY','PY'),
(176,'PERU','PE'),
(177,'PHILIPPINES','PH'),
(178,'PITCAIRN','PN'),
(179,'POLAND','PL'),
(180,'PORTUGAL','PT'),
(181,'PUERTO RICO','PR'),
(182,'QATAR','QA'),
(183,'REUNION','RE'),
(184,'ROMANIA','RO'),
(185,'RWANDA','RW'),
(186,'SAINT HELENA','SH'),
(187,'SAINT KITTS AND NEVIS','KN'),
(188,'SAINT LUCIA','LC'),
(189,'SAINT PIERRE AND MIQUELON','PM'),
(190,'SAINT VINCENT AND THE GRENADINES','VC'),
(191,'SAMOA','WS'),
(192,'SAN MARINO','SM'),
(193,'SAO TOME AND PRINCIPE','ST'),
(194,'SAUDI ARABIA','SA'),
(195,'SENEGAL','SN'),
(196,'SERBIA AND MONTENEGRO','CS'),
(197,'SEYCHELLES','SC'),
(198,'SIERRA LEONE','SL'),
(199,'SINGAPORE','SG'),
(200,'SLOVAKIA','SK'),
(201,'SLOVENIA','SI'),
(202,'SOLOMON ISLANDS','SB'),
(203,'SOMALIA','SO'),
(204,'SOUTH AFRICA','ZA'),
(205,'SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS','GS'),
(206,'SRI LANKA','LK'),
(207,'SUDAN','SD'),
(208,'SURINAME','SR'),
(209,'SVALBARD AND JAN MAYEN','SJ'),
(210,'SWAZILAND','SZ'),
(211,'SWEDEN','SE'),
(212,'SWITZERLAND','CH'),
(213,'SYRIAN ARAB REPUBLIC','SY'),
(214,'TAIWAN, PROVINCE OF CHINA','TW'),
(215,'TAJIKISTAN','TJ'),
(216,'TANZANIA, UNITED REPUBLIC OF','TZ'),
(217,'THAILAND','TH'),
(218,'TIMOR-LESTE','TL'),
(219,'TOGO','TG'),
(220,'TOKELAU','TK'),
(221,'TONGA','TO'),
(222,'TRINIDAD AND TOBAGO','TT'),
(223,'TUNISIA','TN'),
(224,'TURKEY','TR'),
(225,'TURKMENISTAN','TM'),
(226,'TURKS AND CAICOS ISLANDS','TC'),
(227,'TUVALU','TV'),
(228,'UGANDA','UG'),
(229,'UKRAINE','UA'),
(230,'UNITED ARAB EMIRATES','AE'),
(231,'UNITED STATES MINOR OUTLYING ISLANDS','UM'),
(232,'URUGUAY','UY'),
(233,'UZBEKISTAN','UZ'),
(234,'VANUATU','VU'),
(235,'VENEZUELA','VE'),
(236,'VIET NAM','VN'),
(237,'VIRGIN ISLANDS, BRITISH','VG'),
(238,'VIRGIN ISLANDS, U.S.','VI'),
(239,'WALLIS AND FUTUNA','WF'),
(240,'WESTERN SAHARA','EH'),
(241,'YEMEN','YE'),
(242,'ZAMBIA','ZM'),
(243,'ZIMBABWE','ZW');

/*Table structure for table `currency` */

DROP TABLE IF EXISTS `currency`;

CREATE TABLE `currency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `homeCurrencyFlag` bit(1) DEFAULT NULL,
  `rate` float DEFAULT NULL,
  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dateModified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastChangedUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `currency` */

insert  into `currency`(`id`,`activeFlag`,`code`,`name`,`homeCurrencyFlag`,`rate`,`dateCreated`,`dateModified`,`lastChangedUserId`) values 
(1,'','USD','US Dollar','',1,'2017-07-27 16:16:32','2017-07-27 00:00:00',NULL);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) NOT NULL,
  `activeFlag` tinyint(1) NOT NULL,
  `name` varchar(150) NOT NULL,
  `carrierServiceId` int(11) NOT NULL,
  `defaultCarrierId` int(11) NOT NULL,
  `defaultPaymentTermId` int(11) NOT NULL,
  `defaultSalepersonId` int(11) NOT NULL,
  `defaultShipTermId` int(11) NOT NULL,
  `statusId` int(11) NOT NULL,
  `url` varchar(50) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `creditLimit` double NOT NULL,
  `currencyId` int(11) NOT NULL,
  `toBeEmailed` tinyint(1) NOT NULL,
  `toBePrinted` tinyint(1) NOT NULL,
  `dateCreated` datetime NOT NULL,
  `dateLastModified` datetime NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`id`,`accountId`,`activeFlag`,`name`,`carrierServiceId`,`defaultCarrierId`,`defaultPaymentTermId`,`defaultSalepersonId`,`defaultShipTermId`,`statusId`,`url`,`note`,`creditLimit`,`currencyId`,`toBeEmailed`,`toBePrinted`,`dateCreated`,`dateLastModified`,`lastChangedUserId`) values 
(1,1,1,'Customer1',1,1,1,1,1,10,NULL,NULL,100,1,1,1,'2017-08-02 15:43:44','2017-08-02 15:43:48',1),
(2,7,1,'Customer1',1,1,1,1,10,10,NULL,NULL,1000,1,1,1,'2017-08-03 13:35:29','2017-08-03 13:35:29',1),
(3,8,1,'Customer1',1,1,1,1,10,10,NULL,NULL,1000,1,1,1,'2017-08-03 13:37:51','2017-08-03 13:37:51',1),
(4,9,1,'Customer1',1,1,1,1,10,10,NULL,NULL,1000,1,1,1,'2017-08-03 13:38:40','2017-08-03 13:38:40',1),
(6,11,1,'Customer1',1,1,1,1,10,10,NULL,NULL,1000,1,1,1,'2017-08-03 13:40:25','2017-08-03 13:40:25',1),
(7,12,1,'Customer1',1,1,1,1,10,10,NULL,NULL,1000,1,1,1,'2017-08-03 13:45:55','2017-08-03 13:45:55',1),
(8,13,1,'Customer1',1,1,1,1,10,10,NULL,NULL,1000,1,1,1,'2017-08-03 13:48:58','2017-08-03 13:48:58',1),
(9,14,1,'Customer1',1,1,1,1,10,10,NULL,NULL,1000,1,1,1,'2017-08-03 13:53:24','2017-08-03 13:53:24',1);

/*Table structure for table `inventory_history` */

DROP TABLE IF EXISTS `inventory_history`;

CREATE TABLE `inventory_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `partId` int(11) NOT NULL,
  `partTrackingId` int(11) NOT NULL,
  `locationGroupId` int(11) NOT NULL,
  `begLocId` int(11) NOT NULL,
  `begTagId` int(11) NOT NULL,
  `endLocId` int(11) NOT NULL,
  `endTagId` int(11) NOT NULL,
  `cost` double unsigned zerofill NOT NULL,
  `changeQty` float NOT NULL,
  `qtyOnHand` float NOT NULL,
  `typeId` int(11) NOT NULL,
  `info` varchar(100) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  `eventDate` datetime NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `inventory_history` */

/*Table structure for table `location` */

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` tinyint(1) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `defaultFlag` bit(1) NOT NULL,
  `locationGroupId` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  `pickable` tinyint(1) NOT NULL,
  `receivable` tinyint(1) NOT NULL,
  `availableForSale` tinyint(1) DEFAULT NULL,
  `seq` int(11) NOT NULL,
  `dateCreated` datetime NOT NULL,
  `dateLastModified` datetime NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `location` */

insert  into `location`(`id`,`activeFlag`,`name`,`description`,`defaultFlag`,`locationGroupId`,`typeId`,`pickable`,`receivable`,`availableForSale`,`seq`,`dateCreated`,`dateLastModified`,`lastChangedUserId`) values 
(3,0,'Front Store','Front Store','\0',1,70,1,0,1,0,'2017-08-03 18:40:34','2017-08-03 18:40:34',0);

/*Table structure for table `location_group` */

DROP TABLE IF EXISTS `location_group`;

CREATE TABLE `location_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  `dateLastModified` datetime NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `location_group` */

/*Table structure for table `object_name` */

DROP TABLE IF EXISTS `object_name`;

CREATE TABLE `object_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `object_name` */

insert  into `object_name`(`id`,`name`) values 
(1,'CUSTOMER_STATUS'),
(2,'PO_STATUS'),
(3,'PO_ITEM_STATUS'),
(4,'PO_TYPE'),
(5,'PO_ITEM_TYPE'),
(6,'CUSTOMER_TYPE'),
(7,'PART_TYPE'),
(8,'ADDRESS_TYPE'),
(9,'CONTACT_TYPE'),
(10,'PAYMENT_TYPE'),
(11,'PAYMENT_TERM_TYPE'),
(12,'VENDOR_STATUS'),
(13,'UOM_TYPE'),
(14,'PART_TRACKING_TYPE'),
(15,'RECEIPT_STATUS'),
(16,'RECEIPT_TYPE'),
(17,'ORDER_TYPE'),
(18,'RECEIP_ITEM_STATUS'),
(19,'RECEIP_ITEM_TYPE'),
(20,'TAG_TYPE'),
(21,'TAX_RATE_TYPE'),
(22,'LOCATION_TYPE'),
(23,'COST_LAYER_STATUS'),
(24,'COA_TYPE'),
(25,'SO_ITEM_TYPE'),
(26,'ACCOUNT_TYPE'),
(27,'ADDRESS_TYPE');

/*Table structure for table `object_status` */

DROP TABLE IF EXISTS `object_status`;

CREATE TABLE `object_status` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `objectId` int(11) NOT NULL,
  PRIMARY KEY (`id`,`objectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `object_status` */

insert  into `object_status`(`id`,`name`,`objectId`) values 
(10,'Normal',1),
(10,'Bid Request',2),
(10,'Entered',3),
(10,'10	Normal',12),
(10,'Entered',15),
(10,'Entered',18),
(10,'Entered',23),
(20,'Preferred',1),
(20,'Issued',2),
(20,'Picking',3),
(20,'20	Preferred',12),
(20,'Reconciled',15),
(20,'Reconciled',18),
(20,'Fulfilled',23),
(30,'Hold Sales',1),
(30,'Picking',2),
(30,'Partial',3),
(30,'30	Hold PO',12),
(30,'Received',15),
(30,'Received',18),
(30,'Void',23),
(40,'Hold Shipment',1),
(40,'Partial',2),
(40,'Picked',3),
(40,'40	Hold Receipt',12),
(40,'Fulfilled',15),
(40,'Fulfilled',18),
(50,'Hold All',1),
(50,'Picked',2),
(50,'Shipped',3),
(50,'50	Hold All',12),
(60,'Shipped',2),
(60,'Fulfilled',3),
(70,'Fulfilled',2),
(70,'Closed Short',3),
(80,'Closed Short',2),
(80,'Void',3),
(90,'Void',2);

/*Table structure for table `object_type` */

DROP TABLE IF EXISTS `object_type`;

CREATE TABLE `object_type` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `objectId` int(11) NOT NULL,
  PRIMARY KEY (`id`,`objectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `object_type` */

insert  into `object_type`(`id`,`name`,`objectId`) values 
(1,'All',6),
(1,'Cash',10),
(1,'Count',13),
(1,'None',17),
(1,'None',19),
(1,'AccountsPayable',24),
(2,'Customer',6),
(2,'Check',10),
(2,'Weight',13),
(2,'AccountsReceivable',24),
(3,'Customer Group',6),
(3,'Length',13),
(3,'Bank',24),
(4,'American Express',10),
(4,'Area',13),
(4,'CostOfGoodsSold',24),
(5,'Discover',10),
(5,'Volume',13),
(5,'CreditCard',24),
(6,'MasterCard',10),
(6,'Time',13),
(6,'Equity',24),
(7,'Visa',10),
(7,'Expense',24),
(8,'Other credit card',10),
(8,'FixedAsset',24),
(9,'Other',10),
(9,'Income',24),
(10,'Standard',4),
(10,'Purchase',5),
(10,'Inventory',7),
(10,'Ship To',8),
(10,'Home',9),
(10,'NET',11),
(10,'Text',14),
(10,'Standard',16),
(10,'PO',17),
(10,'StockRework',19),
(10,'Location',20),
(10,'Percentage',21),
(10,'Stock',22),
(10,'LongTermLiability',24),
(10,'Sale',25),
(10,'Retail',26),
(10,'Ship To',27),
(11,'Misc. Purchase',5),
(11,'Gift Card',10),
(11,'NonPosting',24),
(11,'Misc. Sale',25),
(12,'E-Check',10),
(12,'OtherAsset',24),
(12,'Drop Ship',25),
(13,'OtherCurrentAsset',24),
(14,'OtherCurrentLiability',24),
(15,'OtherExpense',24),
(16,'OtherIncome',24),
(17,'Depreciation',24),
(18,'DirectCosts',24),
(19,'Liability',24),
(20,'Drop Ship',4),
(20,'Credit Return',5),
(20,'Service',7),
(20,'Bill To',8),
(20,'Work',9),
(20,'COD',11),
(20,'Date',14),
(20,'Receive Only',16),
(20,'SO',17),
(20,'RejectReturn',19),
(20,'Parent',20),
(20,'Flat Rate',21),
(20,'Shipping',22),
(20,'NonCurrentAsset',24),
(20,'Credit Return',25),
(20,'Wholesale',26),
(20,'Bill To',27),
(21,'Misc. Credit',5),
(21,'Labor',7),
(21,'OverHeads',24),
(21,'Misc. Credit',25),
(22,'Overhead',7),
(22,'Prepayment',24),
(23,'Revenue',24),
(24,'Sales',24),
(25,'Inventory',24),
(30,'Out Sourced',5),
(30,'Non-Inventory',7),
(30,'Remit To',8),
(30,'Mobile',9),
(30,'CIA',11),
(30,'Expiration Date',14),
(30,'Reconcile Only',16),
(30,'WO',17),
(30,'ScrappedLost',19),
(30,'Child',20),
(30,'Receiving',22),
(30,'Discount Percentage',25),
(30,'Internet',26),
(30,'Remit To',27),
(31,'Discount Amount',25),
(40,'Shipping',5),
(40,'Internal Use',7),
(40,'Home',8),
(40,'Fax',9),
(40,'CCD',11),
(40,'Serial Number',14),
(40,'TO',17),
(40,'Virtual',20),
(40,'Vendor',22),
(40,'Subtotal',25),
(40,'Home',27),
(50,'Capital Equipment',7),
(50,'Main Office',8),
(50,'Main',9),
(50,'None',11),
(50,'Money',14),
(50,'Inspection',22),
(50,'Assoc. Price',25),
(50,'Main Office',27),
(60,'Shipping',7),
(60,'Email',9),
(60,'Month',11),
(60,'Quantity',14),
(60,'Locked',22),
(60,'Shipping',25),
(70,'Tax',7),
(70,'Pager',9),
(70,'Count',14),
(70,'Store Front',22),
(70,'Tax',25),
(80,'Misc',7),
(80,'Other',9),
(80,'Checkbox',14),
(80,'Manufacturing',22),
(80,'Kit',25),
(90,'Web',9),
(90,'Picking',22),
(90,'Note',25),
(100,'In Transit',22),
(110,'Consignment',22);

/*Table structure for table `part` */

DROP TABLE IF EXISTS `part`;

CREATE TABLE `part` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `abcCode` varchar(1) DEFAULT NULL,
  `num` varchar(20) NOT NULL,
  `details` text CHARACTER SET latin1 NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `upc` varchar(20) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `typeId` int(11) NOT NULL,
  `cogsCoaId` int(11) NOT NULL,
  `invCoaId` int(11) NOT NULL,
  `crapCoaId` int(11) NOT NULL,
  `adjCoaId` int(11) NOT NULL,
  `varianceCoaId` int(11) NOT NULL,
  `defaultProductId` int(11) NOT NULL,
  `defaultBomId` int(11) NOT NULL,
  `alertNote` varchar(255) DEFAULT NULL,
  `len` float DEFAULT NULL,
  `width` float DEFAULT NULL,
  `height` float DEFAULT NULL,
  `sizeUomId` int(11) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `weightUomId` int(11) DEFAULT NULL,
  `alwaysManufactureFlag` bit(1) NOT NULL,
  `pickedInUomFlag` bit(1) NOT NULL,
  `stdCost` decimal(10,0) NOT NULL,
  `dateCreated` datetime NOT NULL,
  `dateModified` datetime NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `part` */

/*Table structure for table `part_category` */

DROP TABLE IF EXISTS `part_category`;

CREATE TABLE `part_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `part_category` */

insert  into `part_category`(`id`,`name`,`description`) values 
(1,'General','General Class Of Parts');

/*Table structure for table `part_cost` */

DROP TABLE IF EXISTS `part_cost`;

CREATE TABLE `part_cost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `partId` int(11) NOT NULL,
  `qty` float unsigned zerofill NOT NULL,
  `totalCost` double unsigned zerofill NOT NULL,
  `avgCost` float unsigned zerofill NOT NULL,
  `dateCreated` datetime NOT NULL,
  `dateLastModified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `part_cost` */

/*Table structure for table `part_to_tracking` */

DROP TABLE IF EXISTS `part_to_tracking`;

CREATE TABLE `part_to_tracking` (
  `id` int(11) NOT NULL,
  `partId` int(11) DEFAULT NULL,
  `partTrackingId` int(11) DEFAULT NULL,
  `primaryFlag` bit(1) DEFAULT NULL,
  `nextValue` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `part_to_tracking` */

/*Table structure for table `part_tracking` */

DROP TABLE IF EXISTS `part_tracking`;

CREATE TABLE `part_tracking` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL,
  `abbr` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `typeId` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `seq` smallint(6) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `part_tracking` */

insert  into `part_tracking`(`ID`,`activeFlag`,`abbr`,`name`,`typeId`,`description`,`seq`) values 
(1,'','Lot#','Lot Number',10,'',1),
(2,'','Rev#','Revision Level',10,'',2),
(3,'','ExpDate','Expiration Date',30,'',3),
(4,'','SN(s)','Serial Number',40,'',4);

/*Table structure for table `payment_method` */

DROP TABLE IF EXISTS `payment_method`;

CREATE TABLE `payment_method` (
  `id` int(11) NOT NULL,
  `activeFlag` bit(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `typeId` int(11) NOT NULL,
  `editableFlag` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `payment_method` */

insert  into `payment_method`(`id`,`activeFlag`,`name`,`typeId`,`editableFlag`) values 
(10,'','Cash',1,'\0'),
(20,'','Check',2,'\0'),
(30,'','VISA',7,'\0'),
(40,'','MasterCard',6,'\0'),
(50,'','Discover',5,'\0'),
(60,'','American Express',4,'\0'),
(70,'','Generic Card',8,'\0'),
(80,'','E-Check',12,'\0'),
(90,'','Gift Card',11,'\0');

/*Table structure for table `payment_term` */

DROP TABLE IF EXISTS `payment_term`;

CREATE TABLE `payment_term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` tinyint(1) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `defaultTermFlag` tinyint(1) NOT NULL,
  `discount` float DEFAULT NULL,
  `discountDays` int(11) DEFAULT NULL,
  `netDays` int(11) DEFAULT NULL,
  `nextMonths` int(11) DEFAULT NULL,
  `readOnlyFlag` tinyint(1) DEFAULT NULL,
  `dateCreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dateModified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastChangedUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `payment_term` */

insert  into `payment_term`(`id`,`activeFlag`,`name`,`typeId`,`defaultTermFlag`,`discount`,`discountDays`,`netDays`,`nextMonths`,`readOnlyFlag`,`dateCreated`,`dateModified`,`lastChangedUserId`) values 
(1,1,'COD',20,1,NULL,NULL,NULL,NULL,1,'2017-07-27 16:27:05','2017-07-27 00:00:00',NULL),
(2,1,'CIA',30,0,NULL,NULL,NULL,NULL,1,'2017-07-27 16:27:44','2017-07-27 00:00:00',NULL),
(3,1,'CCD',40,0,NULL,NULL,NULL,NULL,1,'2017-07-27 00:00:00','2017-07-27 00:00:00',NULL),
(4,1,'NET 30',10,0,NULL,NULL,30,NULL,1,'2017-07-27 16:28:43','2017-07-27 00:00:00',NULL);

/*Table structure for table `po` */

DROP TABLE IF EXISTS `po`;

CREATE TABLE `po` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `locationGroupId` int(11) DEFAULT NULL,
  `statusId` int(11) DEFAULT NULL,
  `buyerId` int(11) DEFAULT NULL,
  `currencyId` int(11) DEFAULT NULL,
  `currencyRate` float DEFAULT NULL,
  `customerSO` varchar(50) DEFAULT NULL,
  `venderSO` varchar(50) DEFAULT NULL,
  `paymentTermId` int(11) DEFAULT NULL,
  `vendorId` int(11) DEFAULT NULL,
  `vendorContact` varchar(50) DEFAULT NULL,
  `vendorAddress` varchar(255) DEFAULT NULL,
  `vendorCity` varchar(50) DEFAULT NULL,
  `vendorCountryId` int(11) DEFAULT NULL,
  `vendorStateId` int(11) DEFAULT NULL,
  `vendorZip` varchar(20) DEFAULT NULL,
  `carrierId` int(11) DEFAULT NULL,
  `shipTermId` int(11) DEFAULT NULL,
  `shipToAddress` varchar(255) DEFAULT NULL,
  `shipToCity` varchar(50) DEFAULT NULL,
  `shipToCountryId` int(11) DEFAULT NULL,
  `shipToStateId` int(11) DEFAULT NULL,
  `shipToZip` varchar(20) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateIssued` datetime DEFAULT NULL,
  `dateFirstShip` datetime DEFAULT NULL,
  `dateComfirmed` datetime DEFAULT NULL,
  `dateCompleted` datetime DEFAULT NULL,
  `dateLastModified` datetime DEFAULT NULL,
  `lastChangedUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `po` */

/*Table structure for table `po_item` */

DROP TABLE IF EXISTS `po_item`;

CREATE TABLE `po_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `poId` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `statusId` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `partId` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `repairFlag` bit(1) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `partNum` varchar(50) DEFAULT NULL,
  `vendorPartNum` varchar(50) DEFAULT NULL,
  `uomId` int(11) DEFAULT NULL,
  `qtyToFulfill` float DEFAULT NULL,
  `qtyPicked` float DEFAULT NULL,
  `qtyFulfilled` float DEFAULT NULL,
  `unitCost` float DEFAULT NULL,
  `taxId` int(11) DEFAULT NULL,
  `taxRate` float DEFAULT NULL,
  `totalCost` double DEFAULT NULL,
  `dateScheduledFulfillment` datetime DEFAULT NULL,
  `dateLastFulfillment` datetime DEFAULT NULL,
  `seq` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `po_item` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL,
  `partId` int(11) NOT NULL,
  `num` varchar(20) NOT NULL,
  `incomeCoaId` int(11) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `detail` text,
  `upc` varchar(20) DEFAULT NULL,
  `sku` varchar(20) DEFAULT NULL,
  `taxId` int(11) NOT NULL,
  `taxableFlag` bit(1) NOT NULL,
  `uomId` int(11) NOT NULL,
  `price` float unsigned zerofill NOT NULL,
  `kidFlag` bit(1) NOT NULL,
  `kidGrouFlag` bit(1) DEFAULT NULL,
  `alertNote` varchar(255) DEFAULT NULL,
  `len` float unsigned zerofill NOT NULL,
  `width` float unsigned zerofill NOT NULL,
  `height` float unsigned zerofill NOT NULL,
  `sizeUomId` int(11) NOT NULL,
  `weight` float unsigned zerofill NOT NULL,
  `weightUomId` int(11) NOT NULL,
  `dateCreated` datetime NOT NULL,
  `dateLastModified` datetime NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

/*Table structure for table `product_asso_price` */

DROP TABLE IF EXISTS `product_asso_price`;

CREATE TABLE `product_asso_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) DEFAULT NULL,
  `assPriceTypeId` int(11) NOT NULL,
  `price` float unsigned zerofill NOT NULL,
  `dateCreated` datetime NOT NULL,
  `dateLastModified` datetime NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_asso_price` */

/*Table structure for table `product_asso_price_type` */

DROP TABLE IF EXISTS `product_asso_price_type`;

CREATE TABLE `product_asso_price_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `coaId` int(11) NOT NULL,
  `dateCreated` datetime NOT NULL,
  `dateLastModified` datetime NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_asso_price_type` */

/*Table structure for table `product_substitute` */

DROP TABLE IF EXISTS `product_substitute`;

CREATE TABLE `product_substitute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL,
  `ProductSubstitueId` int(11) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `DateCreated` int(11) NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_substitute` */

/*Table structure for table `product_to_tree` */

DROP TABLE IF EXISTS `product_to_tree`;

CREATE TABLE `product_to_tree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productId` int(11) NOT NULL,
  `productTreeId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_to_tree` */

/*Table structure for table `product_tree` */

DROP TABLE IF EXISTS `product_tree`;

CREATE TABLE `product_tree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `parentId` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product_tree` */

/*Table structure for table `receipt` */

DROP TABLE IF EXISTS `receipt`;

CREATE TABLE `receipt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `locationGroupId` int(11) NOT NULL,
  `orderTypeId` int(11) NOT NULL,
  `poId` int(11) NOT NULL,
  `soId` int(11) NOT NULL,
  `statusId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `receipt` */

/*Table structure for table `ship_term` */

DROP TABLE IF EXISTS `ship_term`;

CREATE TABLE `ship_term` (
  `id` int(11) NOT NULL,
  `activeFlag` tinyint(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `readOnlyFlag` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ship_term` */

insert  into `ship_term`(`id`,`activeFlag`,`name`,`readOnlyFlag`) values 
(10,1,'Prepaid & Billed',1),
(20,1,'Prepaid',1),
(30,1,'Freight Collect',1);

/*Table structure for table `state` */

DROP TABLE IF EXISTS `state`;

CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryId` int(11) NOT NULL,
  `code` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;

/*Data for the table `state` */

insert  into `state`(`id`,`countryId`,`code`,`name`) values 
(1,1,'ZZ','Unknown'),
(2,2,'AL','Alabama'),
(3,2,'AK','Alaska'),
(4,2,'AZ','Arizona'),
(5,2,'AR','Arkansas'),
(6,2,'CA','California'),
(7,2,'CO','Colorado'),
(8,2,'CT','Connecticut'),
(9,2,'DE','Delaware'),
(10,2,'DC','District of Columbia'),
(11,2,'FL','Florida'),
(12,2,'GA','Georgia'),
(13,2,'GU','Guam'),
(14,2,'HI','Hawaii'),
(15,2,'ID','Idaho'),
(16,2,'IL','Illinois'),
(17,2,'IN','Indiana'),
(18,2,'IA','Iowa'),
(19,2,'KS','Kansas'),
(20,2,'KY','Kentucky'),
(21,2,'LA','Louisiana'),
(22,2,'ME','Maine'),
(23,2,'MD','Maryland'),
(24,2,'MA','Massachusetts'),
(25,2,'MI','Michigan'),
(26,2,'MN','Minnesota'),
(27,2,'MS','Mississippi'),
(28,2,'MO','Missouri'),
(29,2,'MT','Montana'),
(30,2,'NE','Nebraska'),
(31,2,'NV','Nevada'),
(32,2,'NH','New Hampshire'),
(33,2,'NJ','New Jersey'),
(34,2,'NM','New Mexico'),
(35,2,'NY','New York'),
(36,2,'NC','North Carolina'),
(37,2,'ND','North Dakota'),
(38,2,'MP','Northern Mariana Islands'),
(39,2,'OH','Ohio'),
(40,2,'OK','Oklahoma'),
(41,2,'OR','Oregon'),
(42,2,'PA','Pennsylvania'),
(43,2,'RI','Rhode Island'),
(44,2,'SC','South Carolina'),
(45,2,'SD','South Dakota'),
(46,2,'TN','Tennessee'),
(47,2,'TX','Texas'),
(48,2,'UT','Utah'),
(49,2,'VT','Vermont'),
(50,2,'VA','Virginia'),
(51,2,'VI','Virgin Islands, U.S.'),
(52,2,'WA','Washington'),
(53,2,'WV','West Virginia'),
(54,2,'WI','Wisconsin'),
(55,2,'WY','Wyoming'),
(56,2,'XX','Unknown State'),
(57,3,'AB','Alberta'),
(58,3,'BC','British Columbia'),
(59,3,'MB','Manitoba'),
(60,3,'NB','New Brunswick'),
(61,3,'NL','Newfoundland'),
(62,3,'NT','Northwest Territories'),
(63,3,'NS','Nova Scotia'),
(64,3,'NU','Nunavut'),
(65,3,'ON','Ontario'),
(66,3,'PE','Prince Edward Island'),
(67,3,'QC','Quebec'),
(68,3,'SK','Saskatchewan'),
(69,3,'YT','Yukon'),
(70,2,'TS','Tarsonis'),
(71,16,'ACT','Australian Capital Territory'),
(72,16,'NSW','New South Wales'),
(73,16,'NT','Northern Territory'),
(74,16,'QLD','Queensland'),
(75,16,'SA','South Australia'),
(76,16,'TAS','Tasmania'),
(77,16,'VIC','Victoria'),
(78,16,'WA','Western Australia'),
(79,2,'AA','U.S. Armed Forces - Americas'),
(80,2,'AE','U.S. Armed Forces - Europe'),
(81,2,'AP','U.S. Armed Forces - Pacific');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`activeFlag`,`firstName`,`lastName`,`userName`,`password`,`email`,`phone`) values 
(1,'','admin','admin','admin','admin',NULL,NULL);

/*Table structure for table `tag` */

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
  `id` int(11) NOT NULL,
  `locationId` int(11) NOT NULL,
  `partId` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  `qty` float NOT NULL,
  `qtyCommitted` float NOT NULL,
  `usedFlag` bit(1) NOT NULL,
  `serializedFlag` bit(1) NOT NULL,
  `dateLastCycleCount` datetime DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  `dataLastModified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tag` */

/*Table structure for table `tax_rate` */

DROP TABLE IF EXISTS `tax_rate`;

CREATE TABLE `tax_rate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` int(11) NOT NULL,
  `taxCoaId` int(11) NOT NULL,
  `orderTypeId` int(11) NOT NULL,
  `typeId` int(11) NOT NULL,
  `code` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `rate` float NOT NULL,
  `defaultFlag` bit(1) NOT NULL,
  `dateCreated` datetime NOT NULL,
  `dataLastModified` datetime NOT NULL,
  `lastChangedUserId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tax_rate` */

/*Table structure for table `tracking_date` */

DROP TABLE IF EXISTS `tracking_date`;

CREATE TABLE `tracking_date` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagId` int(11) DEFAULT NULL,
  `partTrackingId` int(11) DEFAULT NULL,
  `dateValue` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tracking_date` */

/*Table structure for table `tracking_numeric` */

DROP TABLE IF EXISTS `tracking_numeric`;

CREATE TABLE `tracking_numeric` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagId` int(11) DEFAULT NULL,
  `partTrackingId` int(11) DEFAULT NULL,
  `numberValue` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tracking_numeric` */

/*Table structure for table `tracking_serial` */

DROP TABLE IF EXISTS `tracking_serial`;

CREATE TABLE `tracking_serial` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `partTrackingId` int(11) NOT NULL DEFAULT '3',
  `tagId` int(11) NOT NULL,
  `serial` varchar(20) NOT NULL,
  `commitedFlag` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tracking_serial` */

/*Table structure for table `tracking_text` */

DROP TABLE IF EXISTS `tracking_text`;

CREATE TABLE `tracking_text` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagId` int(11) DEFAULT NULL,
  `partTrackingId` int(11) DEFAULT NULL,
  `textValue` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tracking_text` */

/*Table structure for table `uom` */

DROP TABLE IF EXISTS `uom`;

CREATE TABLE `uom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL,
  `defaultFlag` bit(1) DEFAULT NULL,
  `code` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `uomTypeId` int(11) NOT NULL,
  `readOnlyFlag` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `uom` */

insert  into `uom`(`id`,`activeFlag`,`defaultFlag`,`code`,`name`,`description`,`uomTypeId`,`readOnlyFlag`) values 
(1,'','','ea','Each','A single item.',1,''),
(2,'','\0','ea','Each','A single item.',1,''),
(3,'','\0','ft','Foot','English measurement in Feet.',3,''),
(4,'','\0','lbs','Pound','American pound.',2,''),
(5,'','\0','hr','Hour','One hour.',6,''),
(6,'','\0','gal','Gallon','Basic US unit of liquid volume.',5,'\0'),
(7,'','\0','floz','Fluid Ounce','US unit of liquid volume.',5,'\0'),
(8,'','\0','in','Inch','US unit of length.',3,'\0'),
(9,'','\0','kg','Kilogram','metric unit of weight.',2,''),
(10,'','\0','m','Meter','Basic metric unit of length.',3,''),
(11,'','\0','L','Liter','Basic metric unit of liquid volume.',5,'\0'),
(12,'','\0','mm','Millimeter','1/1000 of a meter',3,'\0'),
(13,'','\0','cm','Centimeter','1/100 of a meter',3,''),
(14,'','\0','km','Kilometer','1000 meters',3,'\0'),
(15,'','\0','g','Gram','Metric unit of weight',2,'\0'),
(16,'','\0','mg','Milligram','1/1000 of a gram',2,'\0'),
(17,'','\0','mL','Milliliter','1/1000 of a Liter',5,'\0'),
(18,'','\0','pr','Pair','Two of one part',1,'\0'),
(19,'','\0','pk','Package','Package of 20',1,'\0'),
(20,'','\0','day','Day','',6,'\0');

/*Table structure for table `uom_conversion` */

DROP TABLE IF EXISTS `uom_conversion`;

CREATE TABLE `uom_conversion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activeFlag` bit(1) NOT NULL,
  `fromUomId` int(11) NOT NULL,
  `multiply` float NOT NULL,
  `toUomId` int(11) NOT NULL,
  `factor` float NOT NULL,
  `descripton` varchar(100) DEFAULT NULL,
  `readOnlyFlag` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `uom_conversion` */

insert  into `uom_conversion`(`id`,`activeFlag`,`fromUomId`,`multiply`,`toUomId`,`factor`,`descripton`,`readOnlyFlag`) values 
(1,'',7,1,2,12,'1 Foot = 12 Inch',''),
(2,'',2,12,7,1,'1 Foot = 12 Inch',''),
(3,'',6,1,5,128,'1 Gallon = 128 Fluid Ounce',''),
(4,'',5,128,6,1,'1 Gallon = 128 Fluid Ounce',''),
(5,'',8,2.2046,3,1,'1 Kilogram = 2.2046 Pound',''),
(6,'',3,1,8,2.2046,'1 Kilogram = 2.2046 Pound',''),
(7,'',9,3.2808,2,1,'1 Meter = 3.2808 Foot',''),
(8,'',2,1,9,3.2808,'1 Meter = 3.2808 Foot',''),
(9,'',5,3.7854,10,1,'1 Gallon = 3.7854 Liter',''),
(10,'',10,1,5,3.7854,'1 Gallon = 3.7854 Liter',''),
(11,'',11,1,9,1000,'1 Meter = 1000.0 Millimeter',''),
(12,'',9,1000,11,1,'1 Meter = 1000.0 Millimeter',''),
(13,'',12,1,9,100,'1 Meter = 100.0 Centimeter',''),
(14,'',9,100,12,1,'1 Meter = 100.0 Centimeter',''),
(15,'',13,1000,9,1,'1 Kilometer = 1000.0 Meter',''),
(16,'',9,1,13,1000,'1 Kilometer = 1000.0 Meter',''),
(17,'',8,1000,14,1,'1 Kilogram = 1000.0 Gram',''),
(18,'',14,1,8,1000,'1 Kilogram = 1000.0 Gram',''),
(19,'',15,1,14,1000,'1 Gram = 1000.0 Milligram',''),
(20,'',14,1000,15,1,'1 Gallon = 1000.0 Milligram',''),
(21,'',16,1,10,1000,'1 Liter = 1000.0 Milliliter',''),
(22,'',10,1000,16,1,'1 Liter = 1000.0 Milliliter',''),
(23,'',7,25.4,11,1,'1 Inch = 25.4 Millimeter',''),
(24,'',11,1,7,25.4,'1 Inch = 25.4 Millimeter',''),
(25,'',17,2,1,1,'1 Pair = 2.0 Each',''),
(26,'',1,1,17,2,'1 Pair = 2.0 Each',''),
(27,'',18,20,1,1,'1 Package = 20.0 Each',''),
(28,'',1,1,18,20,'1 Package = 20.0 Each','');

/*Table structure for table `vendor` */

DROP TABLE IF EXISTS `vendor`;

CREATE TABLE `vendor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountId` int(11) NOT NULL,
  `statusId` int(11) NOT NULL,
  `activeFlag` bit(1) NOT NULL,
  `name` varchar(100) NOT NULL,
  `note` text CHARACTER SET latin1,
  `currencyId` int(11) NOT NULL,
  `currencyRate` float NOT NULL,
  `creditLimit` decimal(10,0) NOT NULL,
  `minOrderAmount` decimal(10,0) NOT NULL,
  `leadTime` smallint(6) NOT NULL,
  `defaultPaymentTermId` int(11) NOT NULL,
  `defaultShipTermId` int(11) NOT NULL,
  `defaultCarrierId` int(11) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `taxRateId` int(11) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  `dateModified` datetime NOT NULL,
  `lastChangedUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vendor` */

/*Table structure for table `vendor_part` */

DROP TABLE IF EXISTS `vendor_part`;

CREATE TABLE `vendor_part` (
  `id` int(11) NOT NULL,
  `vendorId` int(11) NOT NULL,
  `partId` int(11) NOT NULL,
  `vendorPartNum` varchar(20) DEFAULT NULL,
  `qtyMin` double NOT NULL,
  `qtyMax` double NOT NULL,
  `uomId` int(11) NOT NULL,
  `leadTime` int(11) DEFAULT NULL,
  `lastCost` double DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `dateModified` datetime DEFAULT NULL,
  `lastChangedUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `vendor_part` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
