-- MySQL dump 10.14  Distrib 5.5.43-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: projekti
-- ------------------------------------------------------
-- Server version	5.5.43-MariaDB-1~wheezy-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `dialog`
--

LOCK TABLES `dialog` WRITE;
/*!40000 ALTER TABLE `dialog` DISABLE KEYS */;
INSERT INTO `dialog` VALUES (136,'2015-12-07 09:50:25',1,'Yrittäjädialogi');
/*!40000 ALTER TABLE `dialog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (364,'choice','Onko sinulla tarvetta valvoa yrityksesi työvälineitä tai muuta omaisuutta?',136,NULL);
INSERT INTO `question` VALUES (365,'choice','Soneran M2M in a Box -palveluun sisältyy GPS-paikannin sekä lämpötila- ja kiihtyvyysanturit. Sen avulla pystyt käyttämään kaikkia näitä ominaisuuksia Internetin välityksellä. Haluaisitko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (366,'choice','Käytätkö lämpöherkkiä työkaluja tai raaka-aineita työmaalla?',136,NULL);
INSERT INTO `question` VALUES (367,'choice','Käyttääkö yrityksesi lämpötilaherkkiä työkaluja tai raaka-aineita?',136,NULL);
INSERT INTO `question` VALUES (368,'choice','Onko sinulla tarvetta valvoa yrityksesi myyntiartikkeleita tai muuta omaisuutta?',136,NULL);
INSERT INTO `question` VALUES (369,'choice','Käytätkö lämpöherkkiä työkaluja tai raaka-aineita työmaalla?',136,NULL);
INSERT INTO `question` VALUES (370,'choice','Meillä olisi tarjolla tähän erittäin hyvin soveltuva M2M in a Box -palvelu. Sillä pystyt seuraamaan lämpötiloja reaaliajassa Internetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (371,'choice','Hei, olen SoneraBotti. Haluatko apua oikean tuotteen löytämisessä?',136,NULL);
INSERT INTO `question` VALUES (372,'choice','Onko yritykselläsi kosteudelle herkkiä tuotteita tai vesivahinko riskiä?',136,NULL);
INSERT INTO `question` VALUES (373,'choice','Soneran M2M in a Box -palveluun sisältyy GPS-paikannin sekä lämpötila- ja kiihtyvyysanturit. Sen avulla pystyt käyttämään kaikkia näitä ominaisuuksia Internetin välityksellä. Haluaisitko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (374,'choice','Meillä olisi tarjolla tähän erittäin hyvin soveltuva M2M in a Box -palvelu. Sillä pystyt seuraamaan omaisuutesi sijaintia reaaliajassa Internetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (375,'choice','Onko varastossasi lämpöherkkiå tuotteita tai paloturvallisuusriskejä',136,NULL);
INSERT INTO `question` VALUES (376,'choice','Onko sinulla tarvetta valvoa yrityksesi myyntiartikkeleita tai muuta omaisuutta?',136,NULL);
INSERT INTO `question` VALUES (377,'choice','Käyttääkö yrityksesi lämpötilaherkkiä työkaluja tai raaka-aineita?',136,NULL);
INSERT INTO `question` VALUES (378,'choice','Meillä olisi tarjolla tähän erittäin hyvin soveltuva M2M in a Box -palvelu. Sillä pystyt seuraamaan omaisuutesi sijaintia reaaliajassa Internetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (379,'choice','Meillä olisi tarjolla tähän erittäin hyvin soveltuva M2M in a Box -palvelu. Sillä pystyt seuraamaan omaisuutesi sijaintia reaaliajassa Internetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (380,'choice','Soneran M2M in a Box -palveluun sisältyy GPS-paikannin sekä lämpötila- ja kiihtyvyysanturit. Sen avulla pystyt käyttämään kaikkia näitä ominaisuuksia Internetin välityksellä. Haluaisitko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (381,'choice','Soneran M2M in a Box -palveluun sisältyy GPS-paikannin sekä lämpötila- ja kiihtyvyysanturit. Sen avulla pystyt käyttämään kaikkia näitä ominaisuuksia Internetin välityksellä. Haluaisitko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (382,'choice','Meillä olisi tarjolla tähän erittäin hyvin soveltuva M2M in a Box -palvelu. Sillä pystyt seuraamaan lämpötiloja reaaliajassa Internetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (383,'choice','M2M in a Box palvelulla pystyt seuraamaan kosteutta reaaliajassa internetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (384,'choice','M2M in a Box palvelulla pystyt seuraamaan kosteutta reaaliajassa intenetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (385,'choice','Mikä on yrityksesi toimiala?',136,NULL);
INSERT INTO `question` VALUES (386,'choice','M2M in a Box palvelulla pystyt seuraamaan kosteutta reaaliajassa internetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (387,'choice','Soneran M2M in a Box -palveluun sisältyy GPS-paikannin sekä lämpötila- ja kiihtyvyysanturit. Sen avulla pystyt käyttämään kaikkia näitä ominaisuuksia Internetin välityksellä. Haluaisitko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (388,'choice','Onko sinulla tavetta valvoa fyysistä omaisuutta?',136,NULL);
INSERT INTO `question` VALUES (389,'choice','Onko yritykselläsi kosteudelle herkkiä tuotteita tai vesivahinkoriskiä?',136,NULL);
INSERT INTO `question` VALUES (390,'choice','Onko varastossasi lämpöherkkiä tuotteita tai paloturvallisuusriskejä?',136,NULL);
INSERT INTO `question` VALUES (391,'choice','Soneran M2M in a Box -palveluun sisältyy GPS-paikannin sekä lämpötila- ja kiihtyvyysanturit. Sen avulla pystyt käyttämään kaikkia näitä ominaisuuksia Internetin välityksellä. Haluaisitko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (392,'choice','Onko toimitiloissasi kosteudelle herkkiä tuotteita tai vesivahinko riskiä?',136,NULL);
INSERT INTO `question` VALUES (393,'choice','Meillä olisi tarjolla tähän erittäin hyvin soveltuva M2M in a Box -palvelu. Sillä pystyt seuraamaan omaisuuttasi reaaliajassa Internetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (394,'choice','Meillä olisi tarjolla tähän erittäin hyvin soveltuva M2M in a Box -palvelu. Sillä pystyt seuraamaan lämpötiloja reaaliajassa Internetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (395,'choice','Onko sinulla tarvetta valvoa yrityksesi työvälineitä tai muuta omaisuutta?',136,NULL);
INSERT INTO `question` VALUES (396,'choice','Meillä olisi tarjolla tähän erittäin hyvin soveltuva M2M in a Box -palvelu. Sillä pystyt seuraamaan lämpötiloja reaaliajassa Internetin välityksellä. Haluatko',136,NULL);
INSERT INTO `question` VALUES (397,'choice','Meillä olisi tarjolla tähän erittäin hyvin soveltuva M2M in a Box -palvelu. Sillä pystyt seuraamaan lämpötiloja reaaliajassa Internetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (398,'choice','Meillä olisi tarjolla tähän erittäin hyvin soveltuva M2M in a Box -palvelu. Sillä pystyt seuraamaan omaisuuttasi reaaliajassa Internetin välityksellä. Haluatko kokeilla?',136,NULL);
INSERT INTO `question` VALUES (399,'choice','Onko toimitiloissasi lämpöherkkiä tuotteita tai paloturvallisuusriskejä?',136,NULL);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `answer_option`
--

LOCK TABLES `answer_option` WRITE;
/*!40000 ALTER TABLE `answer_option` DISABLE KEYS */;
INSERT INTO `answer_option` VALUES (474,398,0,'Kyllä',NULL,364);
INSERT INTO `answer_option` VALUES (475,369,0,'Ei',NULL,364);
INSERT INTO `answer_option` VALUES (476,NULL,0,'En halua',NULL,365);
INSERT INTO `answer_option` VALUES (477,NULL,0,'Kyllä haluan',NULL,365);
INSERT INTO `answer_option` VALUES (478,380,0,'En käytä',NULL,366);
INSERT INTO `answer_option` VALUES (479,397,0,'Kyllä käytän',NULL,366);
INSERT INTO `answer_option` VALUES (480,370,0,'Kyllä käyttää',NULL,367);
INSERT INTO `answer_option` VALUES (481,NULL,0,'Ei käytä',NULL,367);
INSERT INTO `answer_option` VALUES (482,375,0,'Ei',NULL,368);
INSERT INTO `answer_option` VALUES (483,378,0,'Kyllä',NULL,368);
INSERT INTO `answer_option` VALUES (484,381,0,'En',NULL,369);
INSERT INTO `answer_option` VALUES (485,373,0,'Ei kuulosta houkuttelevalta',NULL,370);
INSERT INTO `answer_option` VALUES (486,NULL,0,'Kyllä haluan',NULL,370);
INSERT INTO `answer_option` VALUES (487,NULL,0,'En, mene pois!',NULL,371);
INSERT INTO `answer_option` VALUES (488,385,0,'Juu, auta ihmeessä',NULL,371);
INSERT INTO `answer_option` VALUES (489,384,0,'Kyllä on',NULL,372);
INSERT INTO `answer_option` VALUES (490,391,0,'Ei ole',NULL,372);
INSERT INTO `answer_option` VALUES (491,NULL,0,'Kyllä haluan',NULL,373);
INSERT INTO `answer_option` VALUES (492,NULL,0,'En halua',NULL,373);
INSERT INTO `answer_option` VALUES (493,367,0,'Ei kuulosta houkuttelevalta',NULL,374);
INSERT INTO `answer_option` VALUES (494,NULL,0,'Kyllä haluan',NULL,374);
INSERT INTO `answer_option` VALUES (495,372,0,'Ei ole',NULL,375);
INSERT INTO `answer_option` VALUES (496,396,0,'Kyllä on',NULL,375);
INSERT INTO `answer_option` VALUES (497,379,0,'Kyllä',NULL,376);
INSERT INTO `answer_option` VALUES (498,NULL,0,'Ei',NULL,376);
INSERT INTO `answer_option` VALUES (499,365,0,'Ei käytä',NULL,377);
INSERT INTO `answer_option` VALUES (500,393,0,'Kyllä käyttää',NULL,377);
INSERT INTO `answer_option` VALUES (501,NULL,0,'Kyllä haluan',NULL,378);
INSERT INTO `answer_option` VALUES (502,390,0,'Ei kulosta houkuttelevalta',NULL,379);
INSERT INTO `answer_option` VALUES (503,NULL,0,'Kyllä haluan',NULL,379);
INSERT INTO `answer_option` VALUES (504,NULL,0,'En halua',NULL,380);
INSERT INTO `answer_option` VALUES (505,NULL,0,'Kyllä haluan',NULL,380);
INSERT INTO `answer_option` VALUES (506,NULL,0,'En halua',NULL,381);
INSERT INTO `answer_option` VALUES (507,NULL,0,'Kyllä haluan',NULL,381);
INSERT INTO `answer_option` VALUES (508,389,0,'Ei kuulosta houkuttelevalta',NULL,382);
INSERT INTO `answer_option` VALUES (509,NULL,0,'Kyllä haluan',NULL,382);
INSERT INTO `answer_option` VALUES (510,NULL,0,'Kyllä haluan',NULL,383);
INSERT INTO `answer_option` VALUES (511,387,0,'Ei kuulosta houkuttelevalta',NULL,383);
INSERT INTO `answer_option` VALUES (512,NULL,0,'Ei kuulosta houkuttelevalta',NULL,384);
INSERT INTO `answer_option` VALUES (513,NULL,0,'Kyllä haluan',NULL,384);
INSERT INTO `answer_option` VALUES (514,376,0,'Vähittäiskauppa',NULL,385);
INSERT INTO `answer_option` VALUES (515,395,0,'Teollisuus',NULL,385);
INSERT INTO `answer_option` VALUES (516,388,0,'Maatalous',NULL,385);
INSERT INTO `answer_option` VALUES (517,368,0,'Tukkukauppa',NULL,385);
INSERT INTO `answer_option` VALUES (518,364,0,'Rakentaminen',NULL,385);
INSERT INTO `answer_option` VALUES (519,NULL,0,'Kyllä haluan',NULL,386);
INSERT INTO `answer_option` VALUES (520,NULL,0,'Ei kuulosta houkuttelevalta',NULL,386);
INSERT INTO `answer_option` VALUES (521,NULL,0,'En halua',NULL,387);
INSERT INTO `answer_option` VALUES (522,NULL,0,'Kyllä haluan',NULL,387);
INSERT INTO `answer_option` VALUES (523,NULL,0,'Kyllä on',NULL,388);
INSERT INTO `answer_option` VALUES (524,399,0,'Ei ole',NULL,388);
INSERT INTO `answer_option` VALUES (525,NULL,0,'Ei ole',NULL,389);
INSERT INTO `answer_option` VALUES (526,383,0,'Kyllä on',NULL,389);
INSERT INTO `answer_option` VALUES (527,NULL,0,'Ei ole',NULL,390);
INSERT INTO `answer_option` VALUES (528,382,0,'Kyllä on',NULL,390);
INSERT INTO `answer_option` VALUES (529,NULL,0,'Kyllä haluan',NULL,391);
INSERT INTO `answer_option` VALUES (530,NULL,0,'En halua',NULL,391);
INSERT INTO `answer_option` VALUES (531,386,0,'Kyllä on',NULL,392);
INSERT INTO `answer_option` VALUES (532,NULL,0,'Ei ole',NULL,392);
INSERT INTO `answer_option` VALUES (533,NULL,0,'Kyllä haluan',NULL,393);
INSERT INTO `answer_option` VALUES (534,NULL,0,'En kuulosta houkuttelevalta',NULL,393);
INSERT INTO `answer_option` VALUES (535,392,0,'Ei kuulosta houkuttelevalta',NULL,394);
INSERT INTO `answer_option` VALUES (536,NULL,0,'Kyllä haluan',NULL,394);
INSERT INTO `answer_option` VALUES (537,377,0,'Ei',NULL,395);
INSERT INTO `answer_option` VALUES (538,374,0,'Kyllä',NULL,395);
INSERT INTO `answer_option` VALUES (539,NULL,0,'Ei kuulosta houkuttelevalta',NULL,396);
INSERT INTO `answer_option` VALUES (540,NULL,0,'Kyllä haluan',NULL,396);
INSERT INTO `answer_option` VALUES (541,NULL,0,'Ei kuulosta houkuttelevalta',NULL,397);
INSERT INTO `answer_option` VALUES (542,NULL,0,'Kyllä haluan',NULL,397);
INSERT INTO `answer_option` VALUES (543,366,0,'Ei kuulosta houkuttelevalta',NULL,398);
INSERT INTO `answer_option` VALUES (544,NULL,0,'Kyllä haluan',NULL,398);
INSERT INTO `answer_option` VALUES (545,NULL,0,'Ei ole',NULL,399);
INSERT INTO `answer_option` VALUES (546,394,0,'Kyllä on',NULL,399);
/*!40000 ALTER TABLE `answer_option` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-07 12:16:03
