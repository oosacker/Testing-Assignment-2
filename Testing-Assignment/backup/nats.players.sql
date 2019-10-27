-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: nats
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Current Database: `nats`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `nats` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `nats`;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `players` (
  `name` varchar(32) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `club` varchar(32) DEFAULT NULL,
  `nationality` varchar(32) DEFAULT NULL,
  `position` varchar(32) DEFAULT NULL,
  `market_value` double DEFAULT NULL,
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=462 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES ('Alexis Sanchez',28,'Arsenal','Chile','LW',65,1),('Mesut Ozil',28,'Arsenal','Germany','AM',50,2),('Petr Cech',35,'Arsenal','Czech Republic','GK',7,3),('Theo Walcott',28,'Arsenal','England','RW',20,4),('Laurent Koscielny',31,'Arsenal','France','CB',22,5),('Hector Bellerin',22,'Arsenal','Spain','RB',30,6),('Olivier Giroud',30,'Arsenal','France','CF',22,7),('Nacho Monreal',31,'Arsenal','Spain','LB',13,8),('Shkodran Mustafi',25,'Arsenal','Germany','CB',30,9),('Alex Iwobi',21,'Arsenal','Nigeria','LW',10,10),('Granit Xhaka',24,'Arsenal','Switzerland','DM',35,11),('Alex Oxlade-Chamberlain',23,'Arsenal','England','RM',22,12),('Jack Wilshere',25,'Arsenal','England','CM',18,13),('Aaron Ramsey',26,'Arsenal','Wales','CM',35,14),('Francis Coquelin',26,'Arsenal','France','DM',15,15),('Gabriel Paulista',26,'Arsenal','Brazil','CB',13,16),('Kieran Gibbs',27,'Arsenal','England','LB',10,17),('Santi Cazorla',32,'Arsenal','Spain','CM',12,18),('Danny Welbeck',26,'Arsenal','England','CF',15,19),('Rob Holding',21,'Arsenal','England','CB',7,20),('Mohamed Elneny',25,'Arsenal','Egypt','DM',10,21),('Lucas Perez',28,'Arsenal','Spain','CF',15,22),('Emiliano Martinez',24,'Arsenal','Argentina','GK',1,23),('David Ospina',28,'Arsenal','Colombia','GK',7,24),('Carl Jenkinson',25,'Arsenal','England','RB',5,25),('Per Mertesacker',32,'Arsenal','Germany','CB',6,26),('Sead Kolasinac',24,'Arsenal','Bosnia','LB',15,27),('Alexandre Lacazette',26,'Arsenal','France','CF',40,28),('Joshua King',25,'Bournemouth','Norway','SS',8,29),('Jermain Defoe',34,'Bournemouth','England','CF',5,30),('Charlie Daniels',30,'Bournemouth','England','LB',3,31),('Artur Boruc',37,'Bournemouth','Poland','GK',1,32),('Steve Cook',26,'Bournemouth','England','CB',5,33),('Junior Stanislas',27,'Bournemouth','England','LW',4.5,34),('Adam Smith',26,'Bournemouth','England','RB',5,35),('Ryan Fraser',23,'Bournemouth','Scotland','LW',5,36),('Simon Francis',32,'Bournemouth','England','RB',2.5,37),('Benik Afobe',24,'Bournemouth','Congo DR','CF',10,38),('Harry Arter',27,'Bournemouth','Ireland','CM',2.5,39),('Marc Pugh',30,'Bournemouth','England','LW',2,40),('Callum Wilson',25,'Bournemouth','England','CF',10,41),('Nathan Ake',22,'Bournemouth','Netherlands','CB',8,42),('Dan Gosling',27,'Bournemouth','England','CM',3,43),('Andrew Surman',30,'Bournemouth','England','CM',2,44),('Jordon Ibe',21,'Bournemouth','England','RW',8,45),('Lewis Cook',20,'Bournemouth','England','CM',6,46),('Lys Mousset',21,'Bournemouth','France','CF',4,47),('Adam Federici',32,'Bournemouth','Australia','GK',1,48),('Max Gradel',29,'Bournemouth','Cote d\'Ivoire','LW',7,49),('Tyrone Mings',24,'Bournemouth','England','CB',5,50),('Brad Smith',23,'Bournemouth','Australia','LB',2,51),('Asmir Begovic',30,'Bournemouth','Bosnia','GK',8,52),('Niki Maenpaa',32,'Brighton+and+Hove','Finland','GK',0.25,53),('Mathew Ryan',25,'Brighton+and+Hove','Australia','GK',3.5,54),('Lewis Dunk',25,'Brighton+and+Hove','England','CB',5,55),('Shane Duffy',25,'Brighton+and+Hove','Ireland','CB',5,56),('Uwe Hunemeier',31,'Brighton+and+Hove','Germany','CB',1.5,57),('Bruno',36,'Brighton+and+Hove','Argentina','RB',0.5,58),('Gaetan Bong',29,'Brighton+and+Hove','Cameroon','LB',1.5,59),('Liam Rosenior',33,'Brighton+and+Hove','England','RB',1,60),('Connor Goldson',24,'Brighton+and+Hove','England','CB',0.75,61),('Markus Suttner',30,'Brighton+and+Hove','Austria','LB',2,62),('Anthony Knockaert',25,'Brighton+and+Hove','France','RW',8,63),('Dale Stephens',27,'Brighton+and+Hove','England','CM',5,64),('Beram Kayal',29,'Brighton+and+Hove','Israel','CM',1.25,65),('Steve Sidwell',34,'Brighton+and+Hove','England','CM',1,66),('Solly March',23,'Brighton+and+Hove','England','RM',0.5,67),('Jiri Skalak',25,'Brighton+and+Hove','Czech Republic','LW',1.5,68),('Oliver Norwood',26,'Brighton+and+Hove','Northern Ireland','CM',2.5,69),('Jamie Murphy',27,'Brighton+and+Hove','Scotland','LW',1.75,70),('Pascal Gross',26,'Brighton+and+Hove','Germany','CM',4,71),('Glenn Murray',33,'Brighton+and+Hove','England','CF',3.5,72),('Tomer Hemed',30,'Brighton+and+Hove','Israel','CF',2.5,73),('Sam Baldock',28,'Brighton+and+Hove','England','CF',3,74),('Tom Heaton',31,'Burnley','England','GK',4,75),('Sam Vokes',27,'Burnley','Wales','CF',4.5,76),('Andre Gray',26,'Burnley','England','CF',10,77),('Ben Mee',27,'Burnley','England','CB',6,78),('Stephen Ward',31,'Burnley','Ireland','LB',1.5,79),('Matthew Lowton',28,'Burnley','England','RB',2.5,80),('Ashley Barnes',27,'Burnley','England','CF',2.5,81),('Jeff Hendrick',25,'Burnley','Ireland','CM',6,82),('Scott Arfield',28,'Burnley','Canada','LM',3,83),('Steven Defour',29,'Burnley','Belgium','CM',6,84),('Dean Marney',33,'Burnley','England','CM',1,85),('Jack Cork',28,'Burnley','England','DM',5,86),('Johann Berg Gudmundsson',26,'Burnley','Iceland','RW',2.5,87),('Robbie Brady',25,'Burnley','Ireland','LM',10,88),('James Tarkowski',24,'Burnley','England','CB',2,89),('Ashley Westwood',27,'Burnley','England','DM',4,90),('Kevin Long',26,'Burnley','Ireland','CB',0.5,91),('Matthew Taylor',35,'Burnley','England','LM',0.25,92),('Eden Hazard',26,'Chelsea','Belgium','LW',75,93),('Diego Costa',28,'Chelsea','Spain','CF',50,94),('Gary Cahill',31,'Chelsea','England','CB',16,95),('Marcos Alonso Mendoza',26,'Chelsea','Spain','LB',25,96),('Cesar Azpilicueta',27,'Chelsea','Spain','RB',30,97),('Pedro',29,'Chelsea','Spain','RW',28,98),('Thibaut Courtois',25,'Chelsea','Belgium','GK',40,99),('David Luiz',30,'Chelsea','Brazil','CB',30,100),('Cesc Fabregas',30,'Chelsea','Spain','CM',35,101),('Willian',28,'Chelsea','Brazil','RW',32,102),('Victor Moses',26,'Chelsea','Nigeria','RM',18,103),('Nemanja Matic',28,'Chelsea','Serbia','DM',35,104),('N%27Golo Kante',26,'Chelsea','France','DM',50,105),('Willy Caballero',35,'Chelsea','Argentina','GK',1.5,106),('Michy Batshuayi',23,'Chelsea','Belgium','CF',25,107),('Kurt Zouma',22,'Chelsea','France','CB',15,108),('Kenedy',21,'Chelsea','Brazil','LB',7,109),('Eduardo Carvalho',34,'Chelsea','Portugal','LW',0.05,110),('Antonio Rudiger',24,'Chelsea','Germany','CB',25,111),('Tiemoue Bakayoko',22,'Chelsea','France','DM',16,112),('Wilfried Zaha',24,'Crystal+Palace','Cote d\'Ivoire','RW',18,113),('Christian Benteke',26,'Crystal+Palace','Belgium','CF',28,114),('Andros Townsend',26,'Crystal+Palace','England','RW',12,115),('Patrick van Aanholt',26,'Crystal+Palace','Netherlands','LB',9,116),('James McArthur',29,'Crystal+Palace','Scotland','CM',7,117),('Wayne Hennessey',30,'Crystal+Palace','Wales','GK',4,118),('Jason Puncheon',31,'Crystal+Palace','England','AM',5.5,119),('Yohan Cabaye',31,'Crystal+Palace','France','CM',15,120),('Joel Ward',27,'Crystal+Palace','England','RB',5,121),('James Tomkins',28,'Crystal+Palace','England','CB',7,122),('Scott Dann',30,'Crystal+Palace','England','CB',5,123),('Damien Delaney',36,'Crystal+Palace','Ireland','CB',1,124),('Jeffrey Schlupp',24,'Crystal+Palace','Ghana','LB',8,125),('Martin Kelly',27,'Crystal+Palace','England','RB',3,126),('Luka Milivojevic',26,'Crystal+Palace','Serbia','DM',10,127),('Lee Chung-yong',29,'Crystal+Palace','South Korea','RW',1.5,128),('Connor Wickham',24,'Crystal+Palace','England','CF',6,129),('Bakary Sako',29,'Crystal+Palace','Mali','LW',6,130),('Pape Souare',27,'Crystal+Palace','Senegal','LB',6,131),('Ruben Loftus-Cheek',21,'Crystal+Palace','England','CM',5,132),('Julian Speroni',38,'Crystal+Palace','Argentina','GK',0.25,133),('Ross Barkley',23,'Everton','England','AM',25,134),('Leighton Baines',32,'Everton','England','LB',12,135),('Seamus Coleman',28,'Everton','Ireland','RB',17,136),('Ashley Williams',32,'Everton','Wales','CB',8,137),('Kevin Mirallas',29,'Everton','Belgium','RW',13,138),('Michael Keane',24,'Everton','England','CB',18,139),('Phil Jagielka',34,'Everton','England','CB',2,140),('Jordan Pickford',23,'Everton','England','GK',15,141),('Joel Robles',27,'Everton','Spain','GK',5,142),('Idrissa Gueye',27,'Everton','Senegal','CM',18,143),('Wayne Rooney',31,'Everton','England','SS',15,144),('Ramiro Funes Mori',26,'Everton','Argentina','CB',12,145),('Maarten Stekelenburg',34,'Everton','Netherlands','GK',2,146),('Gareth Barry',36,'Everton','England','DM',1.5,147),('Tom Davies',19,'Everton','England','CM',8,148),('Mason Holgate',20,'Everton','England','CB',5,149),('Yannick Bolasie',28,'Everton','Congo DR','LW',20,150),('Morgan Schneiderlin',27,'Everton','France','DM',22,151),('Cuco Martina',27,'Everton','Curacao','RB',2,152),('James McCarthy',26,'Everton','Ireland','CM',15,153),('Aaron Lennon',30,'Everton','England','RW',5,154),('Dominic Calvert-Lewin',20,'Everton','England','SS',3.5,155),('Ademola Lookman',19,'Everton','England','LW',5,156),('Matthew Pennington',22,'Everton','England','CB',0.5,157),('Jonjoe Kenny',20,'Everton','England','RB',0.25,158),('Muhamed Besic',24,'Everton','Germany','DM',5,159),('Davy Klaassen',24,'Everton','Netherlands','AM',18,160),('Sandro Ramirez',22,'Everton','Spain','CF',10,161),('Joel Coleman',21,'Huddersfield','England','GK',0.25,162),('Jonas Lossl',28,'Huddersfield','Denmark','GK',1.5,163),('Christopher Schindler',27,'Huddersfield','Germany','CB',2,164),('Chris Lowe',28,'Huddersfield','Germany','LB',1.5,165),('Tommy Smith',25,'Huddersfield','England','RB',2,166),('Michael Hefele',26,'Huddersfield','Germany','CB',1.5,167),('Martin Cranie',30,'Huddersfield','England','CB',0.5,168),('Jon Gorenc Stankovic',21,'Huddersfield','Slovenia','CB',0.5,169),('Mark Hudson',35,'Huddersfield','England','CB',0.5,170),('Mathias Jorgensen',27,'Huddersfield','Denmark','CB',2.5,171),('Scott Malone',26,'Huddersfield','England','LB',0.75,172),('Aaron Mooy',26,'Huddersfield','Australia','CM',5,173),('Rajiv van La Parra',26,'Huddersfield','Netherlands','LW',2,174),('Jonathan Hogg',28,'Huddersfield','England','CM',1,175),('Philip Billing',21,'Huddersfield','Denmark','CM',0.5,176),('Joe Lolley',24,'Huddersfield','England','RW',0.25,177),('Jack Payne',25,'Huddersfield','England','CM',0.25,178),('Dean Whitehead',35,'Huddersfield','England','CM',0.25,179),('Harry Bunn',24,'Huddersfield','England','LW',0.5,180),('Sean Scannell',26,'Huddersfield','Ireland','RW',0.5,181),('Elias Kachunga',25,'Huddersfield','Congo DR','RW',3.5,182),('Tom Ince',25,'Huddersfield','England','RW',7,183),('Kasey Palmer',20,'Huddersfield','England','AM',0.75,184),('Andy Williams',26,'Huddersfield','Trinidad and Tobago','CB',0.65,185),('Nahki Wells',27,'Huddersfield','Bermuda','CF',5,186),('Collin Quaner',26,'Huddersfield','Germany','CF',1,187),('Laurent Depoitre',28,'Huddersfield','Belgium','CF',3,188),('Steve Mounie',22,'Huddersfield','Benin','CF',5.5,189),('Jamie Vardy',30,'Leicester+City','England','CF',15,190),('Riyad Mahrez',26,'Leicester+City','Algeria','RW',30,191),('Kasper Schmeichel',30,'Leicester+City','Denmark','GK',10,192),('Christian Fuchs',31,'Leicester+City','Austria','LB',6,193),('Marc Albrighton',27,'Leicester+City','England','LM',6,194),('Robert Huth',32,'Leicester+City','Germany','CB',5,195),('Danny Simpson',30,'Leicester+City','England','RB',5,196),('Islam Slimani',29,'Leicester+City','Algeria','CF',25,197),('Harry Maguire',24,'Leicester+City','England','CB',8,198),('Danny Drinkwater',27,'Leicester+City','England','CM',9,199),('Wes Morgan',33,'Leicester+City','Jamaica','CB',3,200),('Shinji Okazaki',31,'Leicester+City','Japan','CF',7,201),('Wilfred Ndidi',20,'Leicester+City','Nigeria','DM',14,202),('Demarai Gray',21,'Leicester+City','England','LW',9,203),('Daniel Amartey',22,'Leicester+City','Ghana','DM',5,204),('Andy King',28,'Leicester+City','Wales','CM',3,205),('Ahmed Musa',24,'Leicester+City','Nigeria','CF',17,206),('Yohan Benalouane',30,'Leicester+City','Tunisia','CB',1,207),('Leonardo Ulloa',30,'Leicester+City','Argentina','CF',6,208),('Ben Chilwell',20,'Leicester+City','England','LB',2.5,209),('Nampalys Mendy',25,'Leicester+City','France','DM',10,210),('Ben Hamer',29,'Leicester+City','England','GK',0.5,211),('Molla Wague',26,'Leicester+City','Mali','CB',1.5,212),('Vicente Iborra',29,'Leicester+City','Spain','DM',9,213),('Roberto Firmino',25,'Liverpool','Brazil','SS',38,214),('Philippe Coutinho',25,'Liverpool','Brazil','AM',45,215),('Sadio Mane',25,'Liverpool','Senegal','LW',40,216),('Georginio Wijnaldum',26,'Liverpool','Netherlands','CM',28,217),('James Milner',31,'Liverpool','England','CM',12,218),('Adam Lallana',29,'Liverpool','England','AM',25,219),('Nathaniel Clyne',26,'Liverpool','England','RB',21,220),('Simon Mignolet',29,'Liverpool','Belgium','GK',12,221),('Dejan Lovren',28,'Liverpool','Croatia','CB',17,222),('Emre Can',23,'Liverpool','Germany','DM',15,223),('Joel Matip',25,'Liverpool','Cameroon','CB',25,224),('Divock Origi',22,'Liverpool','Belgium','CF',12,225),('Jordan Henderson',27,'Liverpool','England','CM',28,226),('Daniel Sturridge',27,'Liverpool','England','CF',20,227),('Lucas Leiva',30,'Liverpool','Brazil','DM',7,228),('Ragnar Klavan',31,'Liverpool','Estonia','CB',3.5,229),('Mamadou Sakho',27,'Liverpool','France','CB',15,230),('Loris Karius',24,'Liverpool','Germany','GK',8,231),('Trent Alexander-Arnold',18,'Liverpool','England','RB',1.5,232),('Alberto Moreno',25,'Liverpool','Spain','LB',10,233),('Ben Woodburn',17,'Liverpool','Wales','LW',1.5,234),('Marko Grujic',21,'Liverpool','Serbia','CM',5,235),('Joe Gomez',20,'Liverpool','England','CB',4,236),('Sheyi Ojo',20,'Liverpool','England','LW',2,237),('Mohamed Salah',25,'Liverpool','Egypt','RW',35,238),('Danny Ings',24,'Liverpool','England','CF',8,239),('Dominic Solanke',19,'Liverpool','England','CF',2,240),('Kevin De Bruyne',26,'Manchester+City','Belgium','AM',65,241),('Sergio Aguero',29,'Manchester+City','Argentina','CF',65,242),('Raheem Sterling',22,'Manchester+City','England','LW',45,243),('Kyle Walker',27,'Manchester+City','England','RB',30,244),('David Silva',31,'Manchester+City','Spain','AM',30,245),('Leroy Sane',21,'Manchester+City','Germany','LW',35,246),('Nicolas Otamendi',29,'Manchester+City','Argentina','CB',30,247),('Aleksandar Kolarov',31,'Manchester+City','Serbia','LB',10,248),('Yaya Toure',34,'Manchester+City','Cote d\'Ivoire','CM',8,249),('Fernandinho',32,'Manchester+City','Brazil','DM',18,250),('Claudio Bravo',34,'Manchester+City','Chile','GK',8,251),('Gabriel Jesus',20,'Manchester+City','Brazil','CF',30,252),('John Stones',23,'Manchester+City','England','CB',35,253),('Vincent Kompany',31,'Manchester+City','Belgium','CB',22,254),('Kelechi Iheanacho',20,'Manchester+City','Nigeria','CF',15,255),('Ilkay Gundogan',26,'Manchester+City','Germany','CM',30,256),('Fernando',32,'Manchester+City','Brazil','DM',18,257),('Fabian Delph',27,'Manchester+City','England','CM',8,258),('Ederson Moraes',23,'Manchester+City','Brazil','GK',22,259),('Bernardo Silva',22,'Manchester+City','Portugal','RW',40,260),('Romelu Lukaku',24,'Manchester+United','Belgium','CF',50,261),('David de Gea',26,'Manchester+United','Spain','GK',40,262),('Antonio Valencia',31,'Manchester+United','Ecuador','RB',10,263),('Paul Pogba',24,'Manchester+United','France','CM',75,264),('Eric Bailly',23,'Manchester+United','Cote d\'Ivoire','CB',30,265),('Juan Mata',29,'Manchester+United','Spain','AM',30,266),('Daley Blind',27,'Manchester+United','Netherlands','LB',22,267),('Ander Herrera',27,'Manchester+United','Spain','CM',30,268),('Anthony Martial',21,'Manchester+United','France','CF',30,269),('Marcos Rojo',27,'Manchester+United','Argentina','CB',18,270),('Marcus Rashford',19,'Manchester+United','England','CF',18,271),('Henrikh Mkhitaryan',28,'Manchester+United','Armenia','AM',35,272),('Matteo Darmian',27,'Manchester+United','Italy','RB',12,273),('Jesse Lingard',24,'Manchester+United','England','LW',12,274),('Phil Jones',25,'Manchester+United','England','CB',14,275),('Chris Smalling',27,'Manchester+United','England','CB',18,276),('Marouane Fellaini',29,'Manchester+United','Belgium','CM',12,277),('Luke Shaw',22,'Manchester+United','England','LB',20,278),('Michael Carrick',35,'Manchester+United','England','DM',1.5,279),('Ashley Young',32,'Manchester+United','England','LM',5,280),('Sergio Romero',30,'Manchester+United','Argentina','GK',6,281),('Axel Tuanzebe',19,'Manchester+United','England','CB',1,282),('Timothy Fosu-Mensah',19,'Manchester+United','Netherlands','DM',2.5,283),('Joel Castro Pereira',21,'Manchester+United','Portugal','GK',0.1,284),('Victor Lindelof',23,'Manchester+United','Sweden','CB',22,285),('Rob Elliot',31,'Newcastle+United','Ireland','GK',1,286),('Karl Darlow',26,'Newcastle+United','England','GK',4.5,287),('DeAndre Yedlin',24,'Newcastle+United','United States','RB',5,288),('Ciaran Clark',27,'Newcastle+United','Ireland','CB',5,289),('Lascelles',27,'Newcastle+United','England','CB',5,290),('Paul Dummett',25,'Newcastle+United','Wales','LB',3.5,291),('Grant Hanley',25,'Newcastle+United','Scotland','CB',4.5,292),('Jesus Gamez',32,'Newcastle+United','Spain','RB',2.5,293),('Florian Lejeune',26,'Newcastle+United','France','CB',5,294),('Massadio Haidara',24,'Newcastle+United','France','LB',1.5,295),('Matt Ritchie',27,'Newcastle+United','Scotland','RM',9,296),('Jonjo Shelvey',25,'Newcastle+United','England','CM',11,297),('Mohamed Diame',30,'Newcastle+United','Senegal','CM',6,298),('Jack Colback',27,'Newcastle+United','England','DM',5,299),('Christian Atsu',25,'Newcastle+United','Ghana','RW',5,300),('Siem de Jong',28,'Newcastle+United','Netherlands','AM',5.5,301),('Rolando Aarons',21,'Newcastle+United','England','LW',0.75,302),('Dwight Gayle',26,'Newcastle+United','England','CF',10,303),('Ayoze Perez',23,'Newcastle+United','Spain','SS',8,304),('Aleksandar Mitrovic',22,'Newcastle+United','Serbia','CF',10,305),('Daryl Murphy',34,'Newcastle+United','Ireland','CF',1.5,306),('Fraser Forster',29,'Southampton','England','GK',15,307),('Nathan Redmond',23,'Southampton','England','RW',15,308),('Ryan Bertrand',27,'Southampton','England','LB',20,309),('DuÅ¡an TadiÄ‡',28,'Southampton','Portugal','LW',17,310),('Cedric Soares',25,'Southampton','Portugal','RB',15,311),('James Ward-Prowse',22,'Southampton','England','CM',15,312),('Oriol Romeu',25,'Southampton','Spain','DM',10,313),('Maya Yoshida',28,'Southampton','Japan','CB',5,314),('Steven Davis',32,'Southampton','Northern Ireland','CM',6,315),('Virgil van Dijk',26,'Southampton','Netherlands','CB',30,316),('Charlie Austin',28,'Southampton','England','CF',13,317),('Jack Stephens',23,'Southampton','England','CB',3.5,318),('Shane Long',30,'Southampton','Ireland','CF',9,319),('Sofiane Boufal',23,'Southampton','Morocco','AM',15,320),('Jordy Clasie',26,'Southampton','Netherlands','DM',10,321),('Pierre-Emile Hojbjerg',21,'Southampton','Denmark','CM',8,322),('Manolo Gabbiadini',25,'Southampton','Italy','CF',15,323),('Sam McQueen',22,'Southampton','England','LM',0.75,324),('Matt Targett',21,'Southampton','England','LB',3,325),('Josh Sims',20,'Southampton','England','RW',0.5,326),('Jeremy Pied',28,'Southampton','France','RM',3.5,327),('Jason McCarthy',21,'Southampton','England','CB',0.25,328),('Jan Bednarek',21,'Southampton','Poland','CB',0.5,329),('Joe Allen',27,'Stoke+City','Wales','CM',15,330),('Marko ArnautoviÄ‡',28,'Stoke+City','England','LW',15,331),('Lee Grant',34,'Stoke+City','England','GK',1,332),('Erik Pieters',28,'Stoke+City','Netherlands','LB',7,333),('Steven Fletcher',30,'Stoke+City','Scotland','CF',3,334),('Ryan Shawcross',29,'Stoke+City','England','CB',11,335),('Xherdan Shaqiri',25,'Stoke+City','Switzerland','RW',15,336),('Peter Crouch',36,'Stoke+City','England','CF',1.5,337),('Glenn Whelan',33,'Stoke+City','Ireland','DM',2.5,338),('Charlie Adam',31,'Stoke+City','Scotland','CM',3.5,339),('Geoff Cameron',32,'Stoke+City','United States','CB',3,340),('Glen Johnson',32,'Stoke+City','England','RB',5,341),('Mame Biram Diouf',29,'Stoke+City','Senegal','CF',7,342),('Ramadan Sobhi',20,'Stoke+City','Egypt','LW',5,343),('Marc Muniesa',25,'Stoke+City','Spain','CB',3,344),('Bojan KrkiÄ‡',26,'Stoke+City','Spain','SS',5,345),('Phil Bardsley',32,'Stoke+City','Scotland','RB',1.5,346),('Saido Berahino',23,'Stoke+City','England','CF',15,347),('Giannelli Imbula',24,'Stoke+City','France','DM',12,348),('Jack Butland',24,'Stoke+City','England','GK',15,349),('Ibrahim Afellay',31,'Stoke+City','Netherlands','LM',3,350),('Josh Tymon',18,'Stoke+City','England','LB',1,351),('Gylfi Sigurdsson',27,'Swansea','Iceland','AM',25,352),('Fernando Llorente',32,'Swansea','Spain','CF',6,353),('Åukasz FabiaÅ„ski',32,'Swansea','Poland','GK',9,354),('Leroy Fer',27,'Swansea','Netherlands','CM',8,355),('Alfie Mawson',23,'Swansea','England','CB',6,356),('Kyle Naughton',28,'Swansea','England','RB',5,357),('Wayne Routledge',32,'Swansea','England','LW',2.5,358),('Federico Fernandez',28,'Swansea','Argentina','CB',9,359),('Martin Olsson',29,'Swansea','Sweden','LB',5,360),('Tom Carroll',25,'Swansea','England','CM',6,361),('Ki Sung-yueng',28,'Swansea','South Korea','DM',7,362),('Jordan Ayew',25,'Swansea','Ghana','CF',7.5,363),('Modou Barrow',24,'Swansea','The Gambia','RW',3,364),('Leon Britton',34,'Swansea','England','CM',1,365),('Stephen Kingsley',22,'Swansea','Scotland','LB',0.75,366),('Ã€ngel Rangel',34,'Swansea','Spain','RB',1,367),('Luciano Narsingh',26,'Swansea','Netherlands','RW',5,368),('Jay Fulton',23,'Swansea','Scotland','CM',0.5,369),('Jefferson Montero',27,'Swansea','Ecuador','LW',4.5,370),('Mike van der Hoorn',24,'Swansea','Netherlands','CB',2,371),('Nathan Dyer',29,'Swansea','England','RW',3.5,372),('Oliver McBurnie',21,'Swansea','Scotland','CF',0.25,373),('Kristoffer Nordfeldt',28,'Swansea','Sweden','GK',1.5,374),('Roque Mesa',28,'Swansea','Spain','CM',12,375),('Tammy Abraham',19,'Swansea','England','CF',8,376),('Dele Alli',21,'Tottenham','England','CM',45,377),('Harry Kane',23,'Tottenham','England','CF',60,378),('Christian Eriksen',25,'Tottenham','Denmark','AM',40,379),('Son Heung-min',25,'Tottenham','South Korea','LW',30,380),('Hugo Lloris',30,'Tottenham','France','GK',24,381),('Jan Vertonghen',30,'Tottenham','Belgium','CB',28,382),('Toby Alderweireld',28,'Tottenham','Belgium','CB',35,383),('Victor Wanyama',26,'Tottenham','Kenya','DM',25,384),('Eric Dier',23,'Tottenham','England','DM',25,385),('Ben Davies',24,'Tottenham','Wales','LB',12,386),('Danny Rose',27,'Tottenham','England','LB',28,387),('Mousa Dembele',30,'Tottenham','Belgium','CM',18,388),('Vincent Janssen',23,'Tottenham','Netherlands','CF',13,389),('Kieran Trippier',26,'Tottenham','England','RB',10,390),('Moussa Sissokho',27,'Tottenham','France','CM',20,391),('Harry Winks',21,'Tottenham','England','CM',4,392),('Erik Lamela',25,'Tottenham','Argentina','RW',25,393),('Michel Vorm',33,'Tottenham','Netherlands','GK',4,394),('Georges-Kevin N%27Koudou',22,'Tottenham','France','LW',7,395),('Kevin Wimmer',24,'Tottenham','Austria','CB',7,396),('Ã‰tienne Capoue',29,'Watford','France','DM',9,397),('Troy Deeney',29,'Watford','England','CF',11,398),('Heurelho Gomes',36,'Watford','Brazil','GK',1,399),('Jose Holebas',33,'Watford','Greece','LB',2,400),('Miguel Britos',32,'Watford','Uruguay','CB',3.5,401),('Sebastian Prodl',30,'Watford','Austria','CB',4,402),('Nordin Amrabat',30,'Watford','Morocco','LW',4.5,403),('YounÃ¨s Kaboul',31,'Watford','France','CB',2.5,404),('Tom Cleverley',27,'Watford','England','CM',8,405),('Daryl Janmaat',27,'Watford','Netherlands','RB',7,406),('Valon Behrami',32,'Watford','Switzerland','DM',2.5,407),('Roberto Pereyra',26,'Watford','Argentina','AM',15,408),('Stefano Okaka',27,'Watford','Italy','CF',6,409),('Abdoulaye Doucoure',24,'Watford','France','CM',6,410),('Kabasele',26,'Watford','Belgium','CB',5.5,411),('Craig Cathcart',28,'Watford','Northern Ireland','CB',4,412),('Isaac Success',21,'Watford','Nigeria','LW',4,413),('Adrian Mariappa',30,'Watford','Jamaica','CB',1,414),('Nathaniel Chalobah',22,'Watford','England','DM',5,415),('Mauro Zarate',30,'Watford','Argentina','SS',2,416),('Costel Pantilimon',30,'Watford','Romania','GK',3,417),('Kiko Femenia',26,'Watford','Spain','RB',4,418),('Steven Berghuis',25,'Watford','Netherlands','RW',5.5,419),('Will Hughes',22,'Watford','England','CM',8,420),('Gareth McAuley',37,'West+Brom','Northern Ireland','CB',1,421),('Salomon Rondon',27,'West+Brom','Venezuela','CF',15,422),('Matt Phillips',26,'West+Brom','Scotland','RW',9,423),('Ben Foster',34,'West+Brom','England','GK',4,424),('Nacer Chadli',27,'West+Brom','Belgium','LW',15,425),('Craig Dawson',27,'West+Brom','England','RB',6,426),('Chris Brunt',32,'West+Brom','Northern Ireland','LM',4,427),('James Morrison',31,'West+Brom','Scotland','CM',5,428),('Jonny Evans',29,'West+Brom','Northern Ireland','CB',7,429),('Jake Livermore',27,'West+Brom','England','DM',7,430),('Allan Nyom',29,'West+Brom','Cameroon','RB',4.5,431),('Jay Rodriguez',27,'West+Brom','England','CF',10,432),('Claudio Yacob',30,'West+Brom','Argentina','DM',4,433),('James McClean',28,'West+Brom','Ireland','LW',3,434),('Hal Robson-Kanu',28,'West+Brom','Wales','LW',2.5,435),('Jonathan Leko',18,'West+Brom','England','RW',1.5,436),('Sam Field',19,'West+Brom','England','CM',0.25,437),('Boaz Myhill',34,'West+Brom','Wales','GK',1.5,438),('Ahmed Hegazy',26,'West+Brom','Egypt','CB',1,439),('Robert Snodgrass',29,'West+Ham','Scotland','RW',8,440),('Manuel Lanzini',24,'West+Ham','Argentina','AM',15,441),('Michail Antonio',27,'West+Ham','England','RW',18,442),('Winston Reid',29,'West+Ham','New Zealand','CB',10,443),('Jose Fonte',33,'West+Ham','Portugal','CB',7,444),('Andre Ayew',27,'West+Ham','Ghana','LW',18,445),('Cheikhou Kouyate',27,'West+Ham','Senegal','DM',12,446),('Mark Noble',30,'West+Ham','England','CM',7,447),('Darren Randolph',30,'West+Ham','Ireland','GK',2.5,448),('James Collins',33,'West+Ham','Wales','CB',2,449),('Andy Carroll',28,'West+Ham','England','CF',10,450),('Adrian',30,'West+Ham','Spain','GK',8,451),('Aaron Cresswell',27,'West+Ham','England','LB',12,452),('Pedro Obiang',25,'West+Ham','Spain','CM',9,453),('Sofiane Feghouli',27,'West+Ham','Algeria','RW',12,454),('Angelo Ogbonna',29,'West+Ham','Italy','CB',9,455),('Pablo Zabaleta',32,'West+Ham','Argentina','RB',7,456),('Edimilson Fernandes',21,'West+Ham','Switzerland','CM',5,457),('Arthur Masuaku',23,'West+Ham','Congo DR','LB',7,458),('Sam Byram',23,'West+Ham','England','RB',4.5,459),('Ashley Fletcher',21,'West+Ham','England','CF',1,460),('Diafra Sakho',27,'West+Ham','Senegal','CF',10,461);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-27 15:24:29
