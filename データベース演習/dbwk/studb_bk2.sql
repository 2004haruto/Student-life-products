-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: studb
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Position to start replication or point-in-time recovery from
--

CHANGE MASTER TO MASTER_LOG_FILE='MSI-bin.000040', MASTER_LOG_POS=157;

--
-- Table structure for table `bike`
--

DROP TABLE IF EXISTS `bike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bike` (
  `BIKE_NO` char(5) NOT NULL,
  `BNAME` varchar(50) NOT NULL,
  `BUY_DATE` date NOT NULL,
  `LENGTH` int DEFAULT NULL,
  `HEIGHT` int DEFAULT NULL,
  `WIDTH` int DEFAULT NULL,
  `SEAT_HEIGHT` int DEFAULT NULL,
  `WEIGHT` int DEFAULT NULL,
  `CAPACITY` double(4,1) DEFAULT NULL,
  `DISPLACEMENT` int DEFAULT NULL,
  `STORE_NO` char(3) NOT NULL,
  PRIMARY KEY (`BIKE_NO`),
  KEY `STORE_NO` (`STORE_NO`),
  CONSTRAINT `bike_ibfk_1` FOREIGN KEY (`STORE_NO`) REFERENCES `store` (`STORE_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike`
--

LOCK TABLES `bike` WRITE;
/*!40000 ALTER TABLE `bike` DISABLE KEYS */;
INSERT INTO `bike` VALUES ('00001','スーパーカブ50　プロ','2021-01-12',1860,720,1050,720,108,4.3,49,'002'),('00002','ジャイロ　キャノピー','2021-01-12',1895,660,1690,700,139,5.9,49,'005');
/*!40000 ALTER TABLE `bike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campaign`
--

DROP TABLE IF EXISTS `campaign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campaign` (
  `CAMP_CODE` char(4) NOT NULL,
  `EXP_TEXT` varchar(256) NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `COUPON_NAME` varchar(50) NOT NULL,
  `RED_CLASS` int NOT NULL,
  `RED_VALUE` int NOT NULL,
  `USE_PERIOD` date NOT NULL,
  `VALID_COUNT` int NOT NULL,
  `APPLY_MONEY` int NOT NULL,
  PRIMARY KEY (`CAMP_CODE`),
  KEY `RED_CLASS` (`RED_CLASS`),
  CONSTRAINT `campaign_ibfk_1` FOREIGN KEY (`RED_CLASS`) REFERENCES `reduction` (`CLASS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campaign`
--

LOCK TABLES `campaign` WRITE;
/*!40000 ALTER TABLE `campaign` DISABLE KEYS */;
/*!40000 ALTER TABLE `campaign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliaddress`
--

DROP TABLE IF EXISTS `deliaddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deliaddress` (
  `USER_NO` int NOT NULL,
  `DELI_NO` int NOT NULL,
  `POST_NO` int NOT NULL,
  `ADDRESS` varchar(100) NOT NULL,
  PRIMARY KEY (`USER_NO`,`DELI_NO`),
  CONSTRAINT `deliaddress_ibfk_1` FOREIGN KEY (`USER_NO`) REFERENCES `user` (`USER_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliaddress`
--

LOCK TABLES `deliaddress` WRITE;
/*!40000 ALTER TABLE `deliaddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `deliaddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery` (
  `CLASS` int NOT NULL,
  `DNAME` varchar(10) NOT NULL,
  PRIMARY KEY (`CLASS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery`
--

LOCK TABLES `delivery` WRITE;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` VALUES (1,'受取'),(2,'配達');
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `EMP_NO` char(5) NOT NULL,
  `ENAME` varchar(20) NOT NULL,
  `BIRTHDAY` date NOT NULL,
  `TEL` varchar(10) NOT NULL,
  `ADDRESS` varchar(100) NOT NULL,
  `HIREDATE` date DEFAULT NULL,
  `JOB_NO` int DEFAULT NULL,
  `RANK_POINT` int NOT NULL,
  `SALARY` int NOT NULL,
  `WORK_STORE` char(3) DEFAULT NULL,
  `MGR_NO` char(5) DEFAULT NULL,
  PRIMARY KEY (`EMP_NO`),
  UNIQUE KEY `TEL` (`TEL`),
  KEY `JOB_NO` (`JOB_NO`),
  KEY `EMP_HIR_IDX` (`HIREDATE`),
  KEY `EMP_SAL_IDX` (`SALARY`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`JOB_NO`) REFERENCES `job` (`JOB_NO`),
  CONSTRAINT `employee_chk_1` CHECK ((`SALARY` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('00001','小林友治','1972-07-04','0660030001','京都府京都市下京区東塩小路町７２１－１','2007-06-15',1,2500,5000,'003',NULL),('00002','小林圭輔','1986-03-06','0660010001','大阪市中央区大手前１－１－１','2010-04-01',1,2500,2875,'001','00001'),('00003','友保隼平','1985-08-11','0660010002','大阪市中央区大手前１－１－２','2013-09-10',3,600,950,'001','00002'),('00004','稲田直樹','1984-12-28','0660010003','大阪市中央区大手前１－１－３','2013-04-01',2,700,900,'001','00002'),('00005','河井ゆずる','1980-11-28','0660010004','大阪市中央区大手前１－１－４','2013-05-15',4,600,900,'001','00002'),('00006','村上信五','1982-01-26','0660020001','大阪府大阪市浪速区恵美須東１－１８－１','2010-04-01',1,2500,2875,'002','00001'),('00007','横山裕','1981-05-09','0660020002','大阪府大阪市浪速区恵美須東１－１８－２','2010-04-01',2,700,890,'002','00006'),('00008','大倉忠義','1985-05-16','0660020003','大阪府大阪市浪速区恵美須東１－１８－３','2013-09-20',2,700,1000,'002','00006'),('00009','安田章大','1984-09-11','0660020004','大阪府大阪市浪速区恵美須東１－１８－４','2013-12-01',4,600,890,'002','00006'),('00010','丸山隆平','1983-11-26','0660010005','大阪府大阪市浪速区恵美須東１－１８－５','2016-10-01',3,600,890,'002','00006'),('00011','秋元真夏','1993-08-20','0331112222','東京都港区芝公園４－２－８','2015-05-10',4,600,950,'005','00016'),('00012','生田絵梨花','1997-01-22','0331113333','東京都港区芝公園４－２－７','2015-05-10',2,700,890,'005','00016'),('00014','白石麻衣','1992-08-20','0331115555','東京都港区芝公園４－２－５','2016-10-01',4,600,890,'005','00016'),('00015','高山一実','1994-02-08','0331116666','東京都港区芝公園４－２－４','2015-09-25',3,600,890,'005','00016'),('00016','升野英知','1975-11-28','0332221234','福岡県福岡市博多区住吉１－２','2020-09-01',1,2500,2000,'005','00001'),('00017','松村沙友里','1992-08-27','0332229876','東京都港区南青山１－２４','2020-12-29',2,100,850,'005','00016'),('00018','山名文和','1980-07-03','0748112222','滋賀県東近江市八日市緑町１０－５','2021-01-12',1,1200,800,'006','00001'),('00019','秋山賢太','1983-06-24','0729991000','兵庫県川辺郡猪名川町上野字北畑１１－１','2021-01-12',4,100,800,'006','00018');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `empview`
--

DROP TABLE IF EXISTS `empview`;
/*!50001 DROP VIEW IF EXISTS `empview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `empview` AS SELECT 
 1 AS `SNAME`,
 1 AS `JNAME`,
 1 AS `RANK_NAME`,
 1 AS `ENAME`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `JOB_NO` int NOT NULL,
  `JNAME` varchar(4) NOT NULL DEFAULT '未設定',
  PRIMARY KEY (`JOB_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'店長'),(2,'配達'),(3,'受付'),(4,'調理'),(5,'未設定');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `MATERIAL_NO` char(5) NOT NULL,
  `MNAME` varchar(50) NOT NULL,
  `ORIGIN` varchar(20) DEFAULT NULL,
  `COST` int NOT NULL,
  PRIMARY KEY (`MATERIAL_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES ('00001','チーズ','北海道',50),('00002','モッツァレラチーズ','北海道',650),('00003','パルメザンチーズ','イタリア',450),('00004','チェダーチーズ','イギリス',550),('00005','ブルーチーズ','デンマーク',600),('00006','ソーセージ','アメリカ',300),('00007','サラミ','アメリカ',240),('00008','ベーコン','北海道',350),('00009','ローストチキン',NULL,400),('00010','マッシュルーム','千葉',450),('00011','シーフードミックス',NULL,500),('00012','バジル','イタリア',30),('00013','パセリ','長野',10),('00014','トマト','熊本',55),('00015','ピーマン','茨木',25),('00016','オニオン','兵庫',70),('00017','アスパラガス','長野',120),('00018','コーン','北海道',35),('00019','ナス','高知',70),('00020','トマトソース',NULL,30),('00021','ホワイトソース',NULL,35),('00022','バーベキューソース',NULL,20),('00023','メイプルソース',NULL,30),('00024','ゴーダチーズ','オランダ',550);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetail` (
  `ODR_NO` int NOT NULL,
  `DET_NO` int NOT NULL,
  `PRODUCT_NO` char(4) DEFAULT NULL,
  `PNAME` varchar(50) DEFAULT NULL,
  `CATEGORY` char(4) DEFAULT NULL,
  `SIZE` char(1) DEFAULT NULL,
  `PRICE` int DEFAULT NULL,
  `QTY` int DEFAULT NULL,
  PRIMARY KEY (`ODR_NO`,`DET_NO`),
  KEY `PRODUCT_NO` (`PRODUCT_NO`),
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`ODR_NO`) REFERENCES `orderheader` (`ODR_NO`),
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`PRODUCT_NO`) REFERENCES `product` (`PRODUCT_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderheader`
--

DROP TABLE IF EXISTS `orderheader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderheader` (
  `ODR_NO` int NOT NULL AUTO_INCREMENT,
  `ODR_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `EMP_NO` char(5) DEFAULT NULL,
  `STORE_NO` char(3) DEFAULT NULL,
  `USER_NO` int DEFAULT NULL,
  `UNAME` varchar(20) DEFAULT NULL,
  `TEL` varchar(10) DEFAULT NULL,
  `POST_NO` int DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `CAMP_CODE` char(4) DEFAULT NULL,
  `COUPON_NAME` varchar(50) DEFAULT NULL,
  `USE_PERIOD` date DEFAULT NULL,
  `DELI_CLASS` int DEFAULT NULL,
  `PAY_CLASS` int DEFAULT NULL,
  `TAX` int NOT NULL,
  `APPLY_CAMP_CODE` char(4) DEFAULT NULL,
  `APPLY_COUPON_NAME` varchar(50) DEFAULT NULL,
  `APPLY_USE_PERIOD` date DEFAULT NULL,
  `APPLY_VALID_COUNT` int DEFAULT NULL,
  PRIMARY KEY (`ODR_NO`),
  KEY `EMP_NO` (`EMP_NO`),
  KEY `STORE_NO` (`STORE_NO`),
  KEY `USER_NO` (`USER_NO`),
  KEY `DELI_CLASS` (`DELI_CLASS`),
  KEY `PAY_CLASS` (`PAY_CLASS`),
  KEY `APPLY_CAMP_CODE` (`APPLY_CAMP_CODE`),
  CONSTRAINT `orderheader_ibfk_1` FOREIGN KEY (`EMP_NO`) REFERENCES `employee` (`EMP_NO`),
  CONSTRAINT `orderheader_ibfk_2` FOREIGN KEY (`STORE_NO`) REFERENCES `store` (`STORE_NO`),
  CONSTRAINT `orderheader_ibfk_3` FOREIGN KEY (`USER_NO`) REFERENCES `user` (`USER_NO`),
  CONSTRAINT `orderheader_ibfk_4` FOREIGN KEY (`DELI_CLASS`) REFERENCES `delivery` (`CLASS`),
  CONSTRAINT `orderheader_ibfk_5` FOREIGN KEY (`PAY_CLASS`) REFERENCES `payment` (`CLASS`),
  CONSTRAINT `orderheader_ibfk_6` FOREIGN KEY (`APPLY_CAMP_CODE`) REFERENCES `ownedcp` (`CAMP_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderheader`
--

LOCK TABLES `orderheader` WRITE;
/*!40000 ALTER TABLE `orderheader` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderheader` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ownedcp`
--

DROP TABLE IF EXISTS `ownedcp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ownedcp` (
  `USER_NO` int NOT NULL,
  `CAMP_CODE` char(4) NOT NULL,
  `COUPON_NAME` varchar(50) DEFAULT NULL,
  `RED_CLASS` int DEFAULT NULL,
  `RED_VALUE` int DEFAULT NULL,
  `USE_PERIOD` date DEFAULT NULL,
  `REMAIN_COUNT` int DEFAULT NULL,
  PRIMARY KEY (`USER_NO`,`CAMP_CODE`),
  KEY `CAMP_CODE` (`CAMP_CODE`),
  KEY `RED_CLASS` (`RED_CLASS`),
  CONSTRAINT `ownedcp_ibfk_1` FOREIGN KEY (`USER_NO`) REFERENCES `user` (`USER_NO`),
  CONSTRAINT `ownedcp_ibfk_2` FOREIGN KEY (`CAMP_CODE`) REFERENCES `campaign` (`CAMP_CODE`),
  CONSTRAINT `ownedcp_ibfk_3` FOREIGN KEY (`RED_CLASS`) REFERENCES `reduction` (`CLASS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ownedcp`
--

LOCK TABLES `ownedcp` WRITE;
/*!40000 ALTER TABLE `ownedcp` DISABLE KEYS */;
/*!40000 ALTER TABLE `ownedcp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `CLASS` int NOT NULL,
  `PNAME` varchar(10) NOT NULL,
  PRIMARY KEY (`CLASS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'現金'),(2,'カード');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `PRODUCT_NO` char(4) NOT NULL,
  `PNAME` varchar(50) DEFAULT NULL,
  `CATEGORY` varchar(4) NOT NULL,
  `PRICE` int NOT NULL,
  PRIMARY KEY (`PRODUCT_NO`),
  UNIQUE KEY `PNAME` (`PNAME`),
  KEY `PRO_CAT_IDX` (`CATEGORY`),
  CONSTRAINT `product_chk_1` CHECK ((`PRICE` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('0001','マルゲリータ','ピザ',1200),('0002','デラックスピザ','ピザ',1700),('0003','シーフードピザ','ピザ',1500),('0004','ギガミート','ピザ',2500),('0005','チキン＆ベーコン','ピザ',2200),('0006','BBQチキン','ピザ',2200),('0007','BBQシーフード','ピザ',3000),('0008','MAXチーズピザ','ピザ',3000),('0009','夏野菜ピザ','ピザ',2500),('1001','ポテトフライ','サイド',380),('1002','コンソメポテト','サイド',380),('1003','バターポテト','サイド',380),('1004','チキンナゲット','サイド',450),('1005','シーザーサラダ','サイド',550),('1006','ごまだれサラダ','サイド',510),('1007','コーンポタージュ','サイド',210),('1008','クラムチャウダー','サイド',240),('1009','ミネストローネ','サイド',240),('1010','エッグタルト','サイド',260),('1011','アップルパイ','サイド',250),('1012','バニラアイス','サイド',370),('1013','ストロベリーアイス','サイド',370),('1014','ポテトサラダ','サイド',510),('2001','コーラ','ドリンク',160),('2002','ゼロコーラ','ドリンク',160),('2003','ジンジャエール','ドリンク',160),('2004','メロンソーダ','ドリンク',160),('2005','カフェラテ','ドリンク',160),('2006','コーヒー','ドリンク',160),('2007','オレンジジュース','ドリンク',160),('2008','アップルジュース','ドリンク',160),('3001','タバスコ','その他',250),('3002','保温バック','その他',500),('3003','エコバック','その他',400);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `prodview`
--

DROP TABLE IF EXISTS `prodview`;
/*!50001 DROP VIEW IF EXISTS `prodview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `prodview` AS SELECT 
 1 AS `PRODUCT_NO`,
 1 AS `PNAME`,
 1 AS `CATEGORY`,
 1 AS `PRICE`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `prototype`
--

DROP TABLE IF EXISTS `prototype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prototype` (
  `PROTOTYPE_NO` char(4) NOT NULL,
  `PROTONAME` varchar(50) DEFAULT NULL,
  `CATEGORY` varchar(4) DEFAULT NULL,
  `PRICE` int DEFAULT NULL,
  PRIMARY KEY (`PROTOTYPE_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prototype`
--

LOCK TABLES `prototype` WRITE;
/*!40000 ALTER TABLE `prototype` DISABLE KEYS */;
INSERT INTO `prototype` VALUES ('9003','ミックスジュース','ドリンク',200);
/*!40000 ALTER TABLE `prototype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rankpoint`
--

DROP TABLE IF EXISTS `rankpoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rankpoint` (
  `RANK_NAME` varchar(6) NOT NULL,
  `RANK_DESC` varchar(50) DEFAULT NULL,
  `LO_POINT` int NOT NULL,
  `HI_POINT` int NOT NULL,
  PRIMARY KEY (`LO_POINT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rankpoint`
--

LOCK TABLES `rankpoint` WRITE;
/*!40000 ALTER TABLE `rankpoint` DISABLE KEYS */;
INSERT INTO `rankpoint` VALUES ('ビギナー','仕事内容が未習得の従業員。ベテラン以上と一緒に仕事を行う',0,500),('ミドル','ピークタイム以外であれば仕事を1人でこなせる',501,2000),('ベテラン','見本となる勤務が出来てビギナーに仕事を教えることが出来る',2001,4000),('エキスパート','ピークタイム時に主軸となれる人材',4001,8000),('マスター','仕事に精通しており最高峰のサービスを提供できる人材',8001,9999);
/*!40000 ALTER TABLE `rankpoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `PRODUCT_NO` char(4) NOT NULL,
  `MATERIAL_NO` char(5) NOT NULL,
  `QUANTITY` int NOT NULL,
  PRIMARY KEY (`PRODUCT_NO`,`MATERIAL_NO`),
  KEY `MATERIAL_NO` (`MATERIAL_NO`),
  CONSTRAINT `recipe_ibfk_1` FOREIGN KEY (`MATERIAL_NO`) REFERENCES `material` (`MATERIAL_NO`),
  CONSTRAINT `recipe_ibfk_2` FOREIGN KEY (`PRODUCT_NO`) REFERENCES `product` (`PRODUCT_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES ('0001','00001',1),('0001','00002',2),('0001','00012',1),('0001','00014',3),('0001','00020',1),('0002','00001',1),('0002','00006',3),('0002','00007',3),('0002','00010',1),('0002','00015',1),('0002','00016',1),('0002','00020',1),('0003','00001',1),('0003','00003',1),('0003','00011',1),('0003','00014',1),('0003','00015',1),('0003','00020',1),('0004','00001',1),('0004','00006',2),('0004','00007',2),('0004','00008',2),('0004','00020',1),('0005','00001',1),('0005','00008',2),('0005','00009',2),('0005','00013',1),('0005','00021',1),('0006','00001',1),('0006','00009',3),('0006','00018',1),('0006','00020',1),('0006','00021',1),('0007','00001',1),('0007','00003',1),('0007','00011',1),('0007','00014',1),('0007','00015',1),('0007','00022',1),('0008','00001',1),('0008','00002',2),('0008','00003',2),('0008','00004',2),('0008','00005',2),('0008','00023',1),('0008','00024',1),('0009','00001',1),('0009','00012',1),('0009','00014',1),('0009','00015',1),('0009','00016',1),('0009','00017',1),('0009','00018',1),('0009','00019',1),('0009','00021',1);
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `recipeview`
--

DROP TABLE IF EXISTS `recipeview`;
/*!50001 DROP VIEW IF EXISTS `recipeview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `recipeview` AS SELECT 
 1 AS `PRODUCT_NO`,
 1 AS `PNAME`,
 1 AS `MNAME`,
 1 AS `QUANTITY`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `reduction`
--

DROP TABLE IF EXISTS `reduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reduction` (
  `CLASS` int NOT NULL,
  `RNAME` varchar(10) NOT NULL,
  PRIMARY KEY (`CLASS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reduction`
--

LOCK TABLES `reduction` WRITE;
/*!40000 ALTER TABLE `reduction` DISABLE KEYS */;
INSERT INTO `reduction` VALUES (1,'金額値引'),(2,'％値引');
/*!40000 ALTER TABLE `reduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `size` (
  `CATEGORY` varchar(4) NOT NULL,
  `SIZE` char(1) NOT NULL,
  `DIFF` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`CATEGORY`,`SIZE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES ('ドリンク','L',50),('ドリンク','M',0),('ドリンク','S',-30),('ピザ','L',1000),('ピザ','M',500),('ピザ','S',0);
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store`
--

DROP TABLE IF EXISTS `store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store` (
  `STORE_NO` char(3) NOT NULL,
  `SNAME` varchar(20) NOT NULL,
  `TEL` varchar(10) DEFAULT NULL,
  `PREFECTURES` varchar(3) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `OPEN_TIME` time DEFAULT NULL,
  `CLOSE_TIME` time DEFAULT NULL,
  `HOLIDAY` varchar(7) NOT NULL DEFAULT '年中無休',
  `STATUS` varchar(5) NOT NULL DEFAULT '未オープン',
  PRIMARY KEY (`STORE_NO`),
  UNIQUE KEY `TEL` (`TEL`),
  KEY `STO_STA_IDX` (`STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store`
--

LOCK TABLES `store` WRITE;
/*!40000 ALTER TABLE `store` DISABLE KEYS */;
INSERT INTO `store` VALUES ('001','中崎町店','0663740144','大阪府','大阪市北区中崎西２－３－３５','10:00:00','22:00:00','水','営業中'),('002','森ノ宮店','0669413044','大阪府','大阪市中央区大阪城１－１','09:00:00','22:00:00','水','営業中'),('003','生駒店','0743742173','奈良県','生駒市菜畑２３１２－１','10:00:00','24:00:00','土日','閉店済'),('005','阿倍野店','0666229986','大阪府','大阪市阿倍野区文の里１－１－４０','09:00:00','22:00:00','土日','営業中'),('006','尼崎店','0664879999','兵庫県','尼崎市昭和通２－１７－１６','09:00:00','24:00:00','金','未オープン');
/*!40000 ALTER TABLE `store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tax`
--

DROP TABLE IF EXISTS `tax`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tax` (
  `TAX` int NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date DEFAULT NULL,
  `TAKEOUT_FLG` int NOT NULL,
  PRIMARY KEY (`START_DATE`,`TAKEOUT_FLG`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tax`
--

LOCK TABLES `tax` WRITE;
/*!40000 ALTER TABLE `tax` DISABLE KEYS */;
/*!40000 ALTER TABLE `tax` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `USER_NO` int NOT NULL AUTO_INCREMENT,
  `UNAME` varchar(20) NOT NULL,
  `RUBY` varchar(60) NOT NULL,
  `MAIL` varchar(256) NOT NULL,
  `PASSWORD` char(255) NOT NULL,
  `TEL` varchar(10) NOT NULL,
  `CARD_NO` char(16) DEFAULT NULL,
  PRIMARY KEY (`USER_NO`),
  UNIQUE KEY `MAIL` (`MAIL`),
  UNIQUE KEY `TEL` (`TEL`),
  UNIQUE KEY `CARD_NO` (`CARD_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `empview`
--

/*!50001 DROP VIEW IF EXISTS `empview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `empview` AS select `s`.`SNAME` AS `SNAME`,`j`.`JNAME` AS `JNAME`,`r`.`RANK_NAME` AS `RANK_NAME`,`e`.`ENAME` AS `ENAME` from (((`employee` `e` join `store` `s` on((`e`.`WORK_STORE` = `s`.`STORE_NO`))) join `job` `j` on((`e`.`JOB_NO` = `j`.`JOB_NO`))) join `rankpoint` `r` on((`e`.`RANK_POINT` between `r`.`LO_POINT` and `r`.`HI_POINT`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `prodview`
--

/*!50001 DROP VIEW IF EXISTS `prodview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `prodview` AS select `product`.`PRODUCT_NO` AS `PRODUCT_NO`,`product`.`PNAME` AS `PNAME`,`product`.`CATEGORY` AS `CATEGORY`,`product`.`PRICE` AS `PRICE` from `product` union select `prototype`.`PROTOTYPE_NO` AS `PROTOTYPE_NO`,`prototype`.`PROTONAME` AS `PROTONAME`,`prototype`.`CATEGORY` AS `CATEGORY`,`prototype`.`PRICE` AS `PRICE` from `prototype` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `recipeview`
--

/*!50001 DROP VIEW IF EXISTS `recipeview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `recipeview` AS select `p`.`PRODUCT_NO` AS `PRODUCT_NO`,`p`.`PNAME` AS `PNAME`,`m`.`MNAME` AS `MNAME`,`r`.`QUANTITY` AS `QUANTITY` from ((`product` `p` join `recipe` `r` on((`p`.`PRODUCT_NO` = `r`.`PRODUCT_NO`))) join `material` `m` on((`m`.`MATERIAL_NO` = `r`.`MATERIAL_NO`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-21 10:20:23
