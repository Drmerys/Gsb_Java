-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 13 Février 2018 à 05:52
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_cr`
--
CREATE DATABASE IF NOT EXISTS `gestion_cr` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gestion_cr`;

-- --------------------------------------------------------

--
-- Structure de la table `famille`
--

CREATE TABLE `famille` (
  `FAM_CODE` varchar(3) NOT NULL,
  `FAM_LIBELLE` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `famille`
--

INSERT INTO `famille` (`FAM_CODE`, `FAM_LIBELLE`) VALUES
('AA', 'Antalgiques en association'),
('AAA', 'Antalgiques antipyrétiques en association'),
('AAC', 'Antidépresseur d\'action centrale'),
('AAH', 'Antivertigineux antihistaminique H1'),
('ABA', 'Antibiotique antituberculeux'),
('ABC', 'Antibiotique antiacnéique local'),
('ABP', 'Antibiotique de la famille des béta-lactamines (pénicilline A)'),
('AFC', 'Antibiotique de la famille des cyclines'),
('AFM', 'Antibiotique de la famille des macrolides'),
('AH', 'Antihistaminique H1 local'),
('AIM', 'Antidépresseur imipraminique (tricyclique)'),
('AIN', 'Antidépresseur inhibiteur sélectif de la recapture de la sérotonine'),
('ALO', 'Antibiotique local (ORL)'),
('ANS', 'Antidépresseur IMAO non sélectif'),
('AO', 'Antibiotique ophtalmique'),
('AP', 'Antipsychotique normothymique'),
('AUM', 'Antibiotique urinaire minute'),
('CRT', 'Corticoïde, antibiotique et antifongique à  usage local'),
('HYP', 'Hypnotique antihistaminique'),
('PSA', 'Psychostimulant, antiasthénique');

-- --------------------------------------------------------

--
-- Structure de la table `labo`
--

CREATE TABLE `labo` (
  `LAB_CODE` varchar(2) NOT NULL,
  `LAB_NOM` varchar(20) NOT NULL,
  `LAB_CHEFVENTE` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `labo`
--

INSERT INTO `labo` (`LAB_CODE`, `LAB_NOM`, `LAB_CHEFVENTE`) VALUES
('BC', 'Bichat', 'Suzanne Terminus'),
('GY', 'Gyverny', 'Marcel MacDouglas'),
('SW', 'Swiss Kane', 'Alain Poutre');

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE `medicament` (
  `MED_DEPOTLEGAL` varchar(20) NOT NULL,
  `MED_NOMCOMMERCIAL` varchar(20) DEFAULT NULL,
  `FAM_CODE` varchar(3) NOT NULL,
  `MED_COMPOSITION` tinytext,
  `MED_EFFET` tinytext,
  `MED_CONTREINDIC` tinytext,
  `MED_PRIXECHANTILLON` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `medicament`
--

INSERT INTO `medicament` (`MED_DEPOTLEGAL`, `MED_NOMCOMMERCIAL`, `FAM_CODE`, `MED_COMPOSITION`, `MED_EFFET`, `MED_CONTREINDIC`, `MED_PRIXECHANTILLON`) VALUES
('3MYC7', 'TRIMYCINE', 'CRT', 'Triamcinolone (acétonide) + Néomycine + Nystatine', 'Ce médicament est un corticoïde à  activité forte ou très forte associé à  un antibiotique et un antifongique, utilisé en application locale dans certaines atteintes cutanées surinfectées.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants, d\'infections de la peau ou de parasitisme non traités, d\'acné. Ne pas appliquer sur une plaie, ni sous un pansement occlusif.', NULL),
('ADIMOL9', 'ADIMOL', 'ABP', 'Amoxicilline + Acide clavulanique', 'Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie aux pénicillines ou aux céphalosporines.', NULL),
('AMOPIL7', 'AMOPIL', 'ABP', 'Amoxicilline', 'Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie aux pénicillines. Il doit être administré avec prudence en cas d\'allergie aux céphalosporines.', NULL),
('AMOX45', 'AMOXAR', 'ABP', 'Amoxicilline', 'Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.', 'La prise de ce médicament peut rendre positifs les tests de dépistage du dopage.', NULL),
('AMOXIG12', 'AMOXI Gé', 'ABP', 'Amoxicilline', 'Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie aux pénicillines. Il doit être administré avec prudence en cas d\'allergie aux céphalosporines.', NULL),
('APATOUX22', 'APATOUX Vitamine C', 'ALO', 'Tyrothricine + Tétracaïne + Acide ascorbique (Vitamine C)', 'Ce médicament est utilisé pour traiter les affections de la bouche et de la gorge.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants, en cas de phénylcétonurie et chez l\'enfant de moins de 6 ans.', NULL),
('BACTIG10', 'BACTIGEL', 'ABC', 'Erythromycine', 'Ce médicament est utilisé en application locale pour traiter l\'acné et les infections cutanées bactériennes associées.', 'Ce médicament est contre-indiqué en cas d\'allergie aux antibiotiques de la famille des macrolides ou des lincosanides.', NULL),
('BACTIV13', 'BACTIVIL', 'AFM', 'Erythromycine', 'Ce médicament est utilisé pour traiter des infections bactériennes spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie aux macrolides (dont le chef de file est l\'érythromycine).', NULL),
('BITALV', 'BIVALIC', 'AAA', 'Dextropropoxyphène + Paracétamol', 'Ce médicament est utilisé pour traiter les douleurs d\'intensité modérée ou intense.', 'Ce médicament est contre-indiqué en cas d\'allergie aux médicaments de cette famille, d\'insuffisance hépatique ou d\'insuffisance rénale.', NULL),
('CARTION6', 'CARTION', 'AAA', 'Acide acétylsalicylique (aspirine) + Acide ascorbique (Vitamine C) + Paracétamol', 'Ce médicament est utilisé dans le traitement symptomatique de la douleur ou de la fièvre.', 'Ce médicament est contre-indiqué en cas de troubles de la coagulation (tendances aux hémorragies), d\'ulcère gastroduodénal, maladies graves du foie.', NULL),
('CLAZER6', 'CLAZER', 'AFM', 'Clarithromycine', 'Ce médicament est utilisé pour traiter des infections bactériennes spécifiques. Il est également utilisé dans le traitement de l\'ulcère gastro-duodénal, en association avec d\'autres médicaments.', 'Ce médicament est contre-indiqué en cas d\'allergie aux macrolides (dont le chef de file est l\'érythromycine).', NULL),
('DEPRIL9', 'DEPRAMIL', 'AIM', 'Clomipramine', 'Ce médicament est utilisé pour traiter les épisodes dépressifs sévères, certaines douleurs rebelles, les troubles obsessionnels compulsifs et certaines énurésies chez l\'enfant.', 'Ce médicament est contre-indiqué en cas de glaucome ou d\'adénome de la prostate, d\'infarctus récent, ou si vous avez reà§u un traitement par IMAO durant les 2 semaines précédentes ou en cas d\'allergie aux antidépresseurs imipraminiques.', NULL),
('DIMIRTAM6', 'DIMIRTAM', 'AAC', 'Mirtazapine', 'Ce médicament est utilisé pour traiter les épisodes dépressifs sévères.', 'La prise de ce produit est contre-indiquée en cas de d\'allergie à  l\'un des constituants.', NULL),
('DOLRIL7', 'DOLORIL', 'AAA', 'Acide acétylsalicylique (aspirine) + Acide ascorbique (Vitamine C) + Paracétamol', 'Ce médicament est utilisé dans le traitement symptomatique de la douleur ou de la fièvre.', 'Ce médicament est contre-indiqué en cas d\'allergie au paracétamol ou aux salicylates.', NULL),
('DORNOM8', 'NORMADOR', 'HYP', 'Doxylamine', 'Ce médicament est utilisé pour traiter l\'insomnie chez l\'adulte.', 'Ce médicament est contre-indiqué en cas de glaucome, de certains troubles urinaires (rétention urinaire) et chez l\'enfant de moins de 15 ans.', NULL),
('EQUILARX6', 'EQUILAR', 'AAH', 'Méclozine', 'Ce médicament est utilisé pour traiter les vertiges et pour prévenir le mal des transports.', 'Ce médicament ne doit pas être utilisé en cas d\'allergie au produit, en cas de glaucome ou de rétention urinaire.', NULL),
('EVILR7', 'EVEILLOR', 'PSA', 'Adrafinil', 'Ce médicament est utilisé pour traiter les troubles de la vigilance et certains symptomes neurologiques chez le sujet agé.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants.', NULL),
('INSXT5', 'INSECTIL', 'AH', 'Diphénydramine', 'Ce médicament est utilisé en application locale sur les piqûres d\'insecte et l\'urticaire.', 'Ce médicament est contre-indiqué en cas d\'allergie aux antihistaminiques.', NULL),
('JOVAI8', 'JOVENIL', 'AFM', 'Josamycine', 'Ce médicament est utilisé pour traiter des infections bactériennes spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie aux macrolides (dont le chef de file est l\'érythromycine).', NULL),
('LIDOXY23', 'LIDOXYTRACINE', 'AFC', 'Oxytétracycline +Lidocaïne', 'Ce médicament est utilisé en injection intramusculaire pour traiter certaines infections spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants. Il ne doit pas être associé aux rétinoïdes.', NULL),
('LITHOR12', 'LITHORINE', 'AP', 'Lithium', 'Ce médicament est indiqué dans la prévention des psychoses maniaco-dépressives ou pour traiter les états maniaques.', 'Ce médicament ne doit pas être utilisé si vous êtes allergique au lithium. Avant de prendre ce traitement, signalez à  votre médecin traitant si vous souffrez d\'insuffisance rénale, ou si vous avez un régime sans sel.', NULL),
('PARMOL16', 'PARMOCODEINE', 'AA', 'Codéine + Paracétamol', 'Ce médicament est utilisé pour le traitement des douleurs lorsque des antalgiques simples ne sont pas assez efficaces.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants, chez l\'enfant de moins de 15 Kg, en cas d\'insuffisance hépatique ou respiratoire, d\'asthme, de phénylcétonurie et chez la femme qui allaite.', NULL),
('PHYSOI8', 'PHYSICOR', 'PSA', 'Sulbutiamine', 'Ce médicament est utilisé pour traiter les baisses d\'activité physique ou psychique, souvent dans un contexte de dépression.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants.', NULL),
('PIRIZ8', 'PIRIZAN', 'ABA', 'Pyrazinamide', 'Ce médicament est utilisé, en association à  d\'autres antibiotiques, pour traiter la tuberculose.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants, d\'insuffisance rénale ou hépatique, d\'hyperuricémie ou de porphyrie.', NULL),
('POMDI20', 'POMADINE', 'AO', 'Bacitracine', 'Ce médicament est utilisé pour traiter les infections oculaires de la surface de l\'oeil.', 'Ce médicament est contre-indiqué en cas d\'allergie aux antibiotiques appliqués localement.', NULL),
('TROXT21', 'TROXADET', 'AIN', 'Paroxétine', 'Ce médicament est utilisé pour traiter la dépression et les troubles obsessionnels compulsifs. Il peut également être utilisé en prévention des crises de panique avec ou sans agoraphobie.', 'Ce médicament est contre-indiqué en cas d\'allergie au produit.', NULL),
('TXISOL22', 'TOUXISOL Vitamine C', 'ALO', 'Tyrothricine + Acide ascorbique (Vitamine C)', 'Ce médicament est utilisé pour traiter les affections de la bouche et de la gorge.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants et chez l\'enfant de moins de 6 ans.', NULL),
('URIEG6', 'URIREGUL', 'AUM', 'Fosfomycine trométamol', 'Ce médicament est utilisé pour traiter les infections urinaires simples chez la femme de moins de 65 ans.', 'La prise de ce médicament est contre-indiquée en cas d\'allergie à  l\'un des constituants et d\'insuffisance rénale.', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `praticien`
--

CREATE TABLE `praticien` (
  `PRA_NUM` tinyint(4) NOT NULL,
  `PRA_NOM` varchar(20) DEFAULT NULL,
  `PRA_PRENOM` varchar(20) NOT NULL,
  `PRA_ADRESSE` varchar(30) DEFAULT NULL,
  `PRA_CP` mediumint(9) DEFAULT NULL,
  `PRA_VILLE` varchar(30) DEFAULT NULL,
  `PRA_COEFNOTORIETE` float DEFAULT NULL,
  `TYP_CODE` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `praticien`
--

INSERT INTO `praticien` (`PRA_NUM`, `PRA_NOM`, `PRA_PRENOM`, `PRA_ADRESSE`, `PRA_CP`, `PRA_VILLE`, `PRA_COEFNOTORIETE`, `TYP_CODE`) VALUES
(1, 'Notini', 'Alain', '114 r Authie', 85000, 'LA ROCHE SUR YON', 290.03, 'MH'),
(2, 'Gosselin', 'Albert', '13 r Devon', 41000, 'BLOIS', 307.49, 'MV'),
(3, 'Delahaye', 'André', '36 av 6 Juin', 25000, 'BESANCON', 185.79, 'PS'),
(4, 'Leroux', 'André', '47 av Robert Schuman', 60000, 'BEAUVAIS', 172.04, 'PH'),
(5, 'Desmoulins', 'Anne', '31 r St Jean', 30000, 'NIMES', 94.75, 'PO'),
(6, 'Mouel', 'Anne', '27 r Auvergne', 80000, 'AMIENS', 45.2, 'MH'),
(7, 'Desgranges-Lentz', 'Antoine', '1 r Albert de Mun', 29000, 'MORLAIX', 20.07, 'MV'),
(8, 'Marcouiller', 'Arnaud', '31 r St Jean', 68000, 'MULHOUSE', 396.52, 'PS'),
(9, 'Dupuy', 'Benoit', '9 r Demolombe', 34000, 'MONTPELLIER', 395.66, 'PH'),
(10, 'Lerat', 'Bernard', '31 r St Jean', 59000, 'LILLE', 257.79, 'PO'),
(11, 'Marçais-Lefebvre', 'Bertrand', '86Bis r Basse', 67000, 'STRASBOURG', 450.96, 'MH'),
(12, 'Boscher', 'Bruno', '94 r Falaise', 10000, 'TROYES', 356.14, 'MV'),
(13, 'Morel', 'Catherine', '21 r Chateaubriand', 75000, 'PARIS', 379.57, 'PS'),
(14, 'Guivarch', 'Chantal', '4 av Gén Laperrine', 45000, 'ORLEANS', 114.56, 'PH'),
(15, 'Bessin-Grosdoit', 'Christophe', '92 r Falaise', 6000, 'NICE', 222.06, 'PO'),
(16, 'Rossa', 'Claire', '14 av Thiès', 6000, 'NICE', 529.78, 'MH'),
(17, 'Cauchy', 'Denis', '5 av Ste Thérèse', 11000, 'NARBONNE', 458.82, 'MV'),
(18, 'Gaffé', 'Dominique', '9 av 1ère Armée Française', 35000, 'RENNES', 213.4, 'PS'),
(19, 'Guenon', 'Dominique', '98 bd Mar Lyautey', 44000, 'NANTES', 175.89, 'PH'),
(20, 'Prévot', 'Dominique', '29 r Lucien Nelle', 87000, 'LIMOGES', 151.36, 'PO'),
(21, 'Houchard', 'Eliane', '9 r Demolombe', 49100, 'ANGERS', 436.96, 'MH'),
(22, 'Desmons', 'Elisabeth', '51 r Bernières', 29000, 'QUIMPER', 281.17, 'MV'),
(23, 'Flament', 'Elisabeth', '11 r Pasteur', 35000, 'RENNES', 315.6, 'PS'),
(24, 'Goussard', 'Emmanuel', '9 r Demolombe', 41000, 'BLOIS', 40.72, 'PH'),
(25, 'Desprez', 'Eric', '9 r Vaucelles', 33000, 'BORDEAUX', 406.85, 'PO'),
(26, 'Coste', 'Evelyne', '29 r Lucien Nelle', 19000, 'TULLE', 441.87, 'MH'),
(27, 'Lefebvre', 'Frédéric', '2 pl Wurzburg', 55000, 'VERDUN', 573.63, 'MV'),
(28, 'Lemée', 'Frédéric', '29 av 6 Juin', 56000, 'VANNES', 326.4, 'PS'),
(29, 'Martin', 'Frédéric', 'Bât A 90 r Bayeux', 70000, 'VESOUL', 506.06, 'PH'),
(30, 'Marie', 'Frédérique', '172 r Caponière', 70000, 'VESOUL', 313.31, 'PO'),
(31, 'Rosenstech', 'Geneviève', '27 r Auvergne', 75000, 'PARIS', 366.82, 'MH'),
(32, 'Pontavice', 'Ghislaine', '8 r Gaillon', 86000, 'POITIERS', 265.58, 'MV'),
(33, 'Leveneur-Mosquet', 'Guillaume', '47 av Robert Schuman', 64000, 'PAU', 184.97, 'PS'),
(34, 'Blanchais', 'Guy', '30 r Authie', 8000, 'SEDAN', 502.48, 'PH'),
(35, 'Leveneur', 'Hugues', '7 pl St Gilles', 62000, 'ARRAS', 7.39, 'PO'),
(36, 'Mosquet', 'Isabelle', '22 r Jules Verne', 76000, 'ROUEN', 77.1, 'MH'),
(37, 'Giraudon', 'Jean-Christophe', '1 r Albert de Mun', 38100, 'VIENNE', 92.62, 'MV'),
(38, 'Marie', 'Jean-Claude', '26 r Hérouville', 69000, 'LYON', 120.1, 'PS'),
(39, 'Maury', 'Jean-François', '5 r Pierre Girard', 71000, 'CHALON SUR SAONE', 13.73, 'PH'),
(40, 'Dennel', 'Jean-Louis', '7 pl St Gilles', 28000, 'CHARTRES', 550.69, 'PO'),
(41, 'Ain', 'Jean-Pierre', '4 résid Olympia', 2000, 'LAON', 5.59, 'MH'),
(42, 'Chemery', 'Jean-Pierre', '51 pl Ancienne Boucherie', 14000, 'CAEN', 396.58, 'MV'),
(43, 'Comoz', 'Jean-Pierre', '35 r Auguste Lechesne', 18000, 'BOURGES', 340.35, 'PS'),
(44, 'Desfaudais', 'Jean-Pierre', '7 pl St Gilles', 29000, 'BREST', 71.76, 'PH'),
(45, 'Phan', 'JérÃ´me', '9 r Clos Caillet', 79000, 'NIORT', 451.61, 'PO'),
(46, 'Riou', 'Line', '43 bd Gén Vanier', 77000, 'MARNE LA VALLEE', 193.25, 'MH'),
(47, 'Chubilleau', 'Louis', '46 r Eglise', 17000, 'SAINTES', 202.07, 'MV'),
(48, 'Lebrun', 'Lucette', '178 r Auge', 54000, 'NANCY', 410.41, 'PS'),
(49, 'Goessens', 'Marc', '6 av 6 Juin', 39000, 'DOLE', 548.57, 'PH'),
(50, 'Laforge', 'Marc', '5 résid Prairie', 50000, 'SAINT LO', 265.05, 'PO'),
(51, 'Millereau', 'Marc', '36 av 6 Juin', 72000, 'LA FERTE BERNARD', 430.42, 'MH'),
(52, 'Dauverne', 'Marie-Christine', '69 av Charlemagne', 21000, 'DIJON', 281.05, 'MV'),
(53, 'Vittorio', 'Myriam', '3 pl Champlain', 94000, 'BOISSY SAINT LEGER', 356.23, 'PS'),
(54, 'Lapasset', 'Nhieu', '31 av 6 Juin', 52000, 'CHAUMONT', 107, 'PH'),
(55, 'Plantet-Besnier', 'Nicole', '10 av 1ère Armée Française', 86000, 'CHATELLEREAULT', 369.94, 'PO'),
(56, 'Chubilleau', 'Pascal', '3 r Hastings', 15000, 'AURRILLAC', 290.75, 'MH'),
(57, 'Robert', 'Pascal', '31 r St Jean', 93000, 'BOBIGNY', 162.41, 'MV'),
(58, 'Jean', 'Pascale', '114 r Authie', 49100, 'SAUMUR', 375.52, 'PS'),
(59, 'Chanteloube', 'Patrice', '14 av Thiès', 13000, 'MARSEILLE', 478.01, 'PH'),
(60, 'Lecuirot', 'Patrice', 'résid St Pères 55 r Pigacière', 54000, 'NANCY', 239.66, 'PO'),
(61, 'Gandon', 'Patrick', '47 av Robert Schuman', 37000, 'TOURS', 599.06, 'MH'),
(62, 'Mirouf', 'Patrick', '22 r Puits Picard', 74000, 'ANNECY', 458.42, 'MV'),
(63, 'Boireaux', 'Philippe', '14 av Thiès', 10000, 'CHALON EN CHAMPAGNE', 454.48, 'PS'),
(64, 'Cendrier', 'Philippe', '7 pl St Gilles', 12000, 'RODEZ', 164.16, 'PH'),
(65, 'Duhamel', 'Philippe', '114 r Authie', 34000, 'MONTPELLIER', 98.62, 'PO'),
(66, 'Grigy', 'Philippe', '15 r Mélingue', 44000, 'CLISSON', 285.1, 'MH'),
(67, 'Linard', 'Philippe', '1 r Albert de Mun', 81000, 'ALBI', 486.3, 'MV'),
(68, 'Lozier', 'Philippe', '8 r Gaillon', 31000, 'TOULOUSE', 48.4, 'PS'),
(69, 'Dechâtre', 'Pierre', '63 av Thiès', 23000, 'MONTLUCON', 253.75, 'PH'),
(70, 'Goessens', 'Pierre', '22 r Jean Romain', 40000, 'MONT DE MARSAN', 426.19, 'PO'),
(71, 'Leménager', 'Pierre', '39 av 6 Juin', 57000, 'METZ', 118.7, 'MH'),
(72, 'Née', 'Pierre', '39 av 6 Juin', 82000, 'MONTAUBAN', 72.54, 'MV'),
(73, 'Guyot', 'Pierre-Laurent', '43 bd Gén Vanier', 48000, 'MENDE', 352.31, 'PS'),
(74, 'Chauchard', 'Roger', '9 r Vaucelles', 13000, 'MARSEILLE', 552.19, 'PH'),
(75, 'Mabire', 'Roland', '11 r Boutiques', 67000, 'STRASBOURG', 422.39, 'PO'),
(76, 'Leroy', 'Soazig', '45 r Boutiques', 61000, 'ALENCON', 570.67, 'MH'),
(77, 'Guyot', 'Stéphane', '26 r Hérouville', 46000, 'FIGEAC', 28.85, 'MV'),
(78, 'Delposen', 'Sylvain', '39 av 6 Juin', 27000, 'DREUX', 292.01, 'PS'),
(79, 'Rault', 'Sylvie', '15 bd Richemond', 2000, 'SOISSON', 526.6, 'PH'),
(80, 'Renouf', 'Sylvie', '98 bd Mar Lyautey', 88000, 'EPINAL', 425.24, 'PO'),
(81, 'Alliet-Grach', 'Thierry', '14 av Thiès', 7000, 'PRIVAS', 451.31, 'MH'),
(82, 'Bayard', 'Thierry', '92 r Falaise', 42000, 'SAINT ETIENNE', 271.71, 'MV'),
(83, 'Gauchet', 'Thierry', '7 r Desmoueux', 38100, 'GRENOBLE', 406.1, 'PS'),
(84, 'Bobichon', 'Tristan', '219 r Caponière', 9000, 'FOIX', 218.36, 'PH'),
(85, 'Duchemin-Laniel', 'Véronique', '130 r St Jean', 33000, 'LIBOURNE', 265.61, 'PO'),
(86, 'Laurent', 'Younès', '34 r Demolombe', 53000, 'MAYENNE', 496.1, 'MH');

-- --------------------------------------------------------

--
-- Structure de la table `rapport_visite`
--

CREATE TABLE `rapport_visite` (
  `VIS_MATRICULE` varchar(4) NOT NULL,
  `RAP_NUM` mediumint(9) NOT NULL,
  `PRA_NUM` tinyint(4) NOT NULL,
  `RAP_DATE` date DEFAULT NULL,
  `RAP_BILAN` tinytext,
  `TYM_CODE` int(11) DEFAULT NULL,
  `RAP_MOTIF` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `rapport_visite`
--

INSERT INTO `rapport_visite` (`VIS_MATRICULE`, `RAP_NUM`, `PRA_NUM`, `RAP_DATE`, `RAP_BILAN`, `TYM_CODE`, `RAP_MOTIF`) VALUES
('a131', 3, 65, '2002-04-28', 'Médecin curieux, à recontacer en décembre pour réunion', 1, NULL),
('a17', 4, 4, '2003-05-21', 'Changement de direction, redéfinition de la politique médicamenteuse, recours au générique', 2, NULL),
('a131', 7, 41, '2003-03-23', 'RAS', 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `region`
--

CREATE TABLE `region` (
  `REG_CODE` varchar(3) NOT NULL,
  `SEC_CODE` varchar(1) NOT NULL,
  `REG_NOM` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `region`
--

INSERT INTO `region` (`REG_CODE`, `SEC_CODE`, `REG_NOM`) VALUES
('AL', 'E', 'Alsace Lorraine'),
('AQ', 'S', 'Aquitaine'),
('AU', 'P', 'Auvergne'),
('BG', 'O', 'Bretagne'),
('BN', 'O', 'Basse Normandie'),
('BO', 'E', 'Bourgogne'),
('CA', 'N', 'Champagne Ardennes'),
('CE', 'P', 'Centre'),
('FC', 'E', 'Franche Comte'),
('HN', 'N', 'Haute Normandie'),
('IF', 'P', 'Ile de France'),
('LG', 'S', 'Languedoc'),
('LI', 'P', 'Limousin'),
('MP', 'S', 'Midi Pyrenee'),
('NP', 'N', 'Nord Pas de Calais'),
('PA', 'S', 'Provence Alpes Cote d\'Azur'),
('PC', 'O', 'Poitou Charente'),
('PI', 'N', 'Picardie'),
('PL', 'O', 'Pays de Loire'),
('RA', 'E', 'Rhone Alpes'),
('RO', 'S', 'Roussillon'),
('VD', 'O', 'Vendee');

-- --------------------------------------------------------

--
-- Structure de la table `secteur`
--

CREATE TABLE `secteur` (
  `SEC_CODE` varchar(1) NOT NULL,
  `SEC_LIBELLE` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `secteur`
--

INSERT INTO `secteur` (`SEC_CODE`, `SEC_LIBELLE`) VALUES
('E', 'Est'),
('N', 'Nord'),
('O', 'Ouest'),
('P', 'Paris centre'),
('S', 'Sud');

-- --------------------------------------------------------

--
-- Structure de la table `specialite`
--

CREATE TABLE `specialite` (
  `SPE_CODE` varchar(3) NOT NULL,
  `SPE_LIBELLE` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `specialite`
--

INSERT INTO `specialite` (`SPE_CODE`, `SPE_LIBELLE`) VALUES
('ACP', 'anatomie et cytologie pathologiques'),
('AMV', 'angéiologie, médecine vasculaire'),
('ARC', 'anesthésiologie et réanimation chirurgicale'),
('BM', 'biologie médicale'),
('CAC', 'cardiologie et affections cardio-vasculaires'),
('CCT', 'chirurgie cardio-vasculaire et thoracique'),
('CG', 'chirurgie générale'),
('CMF', 'chirurgie maxillo-faciale'),
('COM', 'cancérologie, oncologie médicale'),
('COT', 'chirurgie orthopédique et traumatologie'),
('CPR', 'chirurgie plastique reconstructrice et esthétique'),
('CU', 'chirurgie urologique'),
('CV', 'chirurgie vasculaire'),
('DN', 'diabétologie-nutrition, nutrition'),
('DV', 'dermatologie et vénéréologie'),
('EM', 'endocrinologie et métabolismes'),
('ETD', 'évaluation et traitement de la douleur'),
('GEH', 'gastro-entérologie et hépatologie (appareil digestif)'),
('GMO', 'gynécologie médicale, obstétrique'),
('GO', 'gynécologie-obstétrique'),
('HEM', 'maladies du sang (hématologie)'),
('MBS', 'médecine et biologie du sport'),
('MDT', 'médecine du travail'),
('MMO', 'médecine manuelle - ostéopathie'),
('MN', 'médecine nucléaire'),
('MPR', 'médecine physique et de réadaptation'),
('MTR', 'médecine tropicale, pathologie infectieuse et tropicale'),
('NEP', 'néphrologie'),
('NRC', 'neurochirurgie'),
('NRL', 'neurologie'),
('ODM', 'orthopédie dento maxillo-faciale'),
('OPH', 'ophtalmologie'),
('ORL', 'oto-rhino-laryngologie'),
('PEA', 'psychiatrie de l\'enfant et de l\'adolescent'),
('PME', 'pédiatrie maladies des enfants'),
('PNM', 'pneumologie'),
('PSC', 'psychiatrie'),
('RAD', 'radiologie (radiodiagnostic et imagerie médicale)'),
('RDT', 'radiothérapie (oncologie option radiothérapie)'),
('RGM', 'reproduction et gynécologie médicale'),
('RHU', 'rhumatologie'),
('STO', 'stomatologie'),
('SXL', 'sexologie'),
('TXA', 'toxicomanie et alcoologie');

-- --------------------------------------------------------

--
-- Structure de la table `type_motif`
--

CREATE TABLE `type_motif` (
  `TYM_CODE` int(11) NOT NULL,
  `TYM_LIBELLE` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type_motif`
--

INSERT INTO `type_motif` (`TYM_CODE`, `TYM_LIBELLE`) VALUES
(1, 'Périodicité'),
(2, 'Remontage'),
(3, 'Relance'),
(4, 'Sollicitation pratic'),
(5, 'Autre');

-- --------------------------------------------------------

--
-- Structure de la table `type_praticien`
--

CREATE TABLE `type_praticien` (
  `TYP_CODE` varchar(2) NOT NULL,
  `TYP_LIBELLE` varchar(30) DEFAULT NULL,
  `TYP_LIEU` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type_praticien`
--

INSERT INTO `type_praticien` (`TYP_CODE`, `TYP_LIBELLE`, `TYP_LIEU`) VALUES
('MH', 'Médecin Hospitalier', 'Hopital ou clinique'),
('MV', 'Médecine de Ville', 'Cabinet'),
('PH', 'Pharmacien Hospitalier', 'Hopital ou clinique'),
('PO', 'Pharmacien Officine', 'Pharmacie'),
('PS', 'Personnel de santé', 'Centre paramédical');

-- --------------------------------------------------------

--
-- Structure de la table `type_visiteur`
--

CREATE TABLE `type_visiteur` (
  `TYV_CODE` varchar(2) NOT NULL,
  `TYV_LIBELLE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `type_visiteur`
--

INSERT INTO `type_visiteur` (`TYV_CODE`, `TYV_LIBELLE`) VALUES
('D', 'Delegue'),
('R', 'Responsabl'),
('V', 'Visiteur');

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

CREATE TABLE `visiteur` (
  `VIS_MATRICULE` varchar(10) NOT NULL,
  `VIS_NOM` varchar(20) NOT NULL,
  `VIS_PRENOM` varchar(20) NOT NULL,
  `VIS_ADRESSE` varchar(40) DEFAULT NULL,
  `VIS_CP` mediumint(5) UNSIGNED DEFAULT NULL,
  `VIS_VILLE` varchar(30) DEFAULT NULL,
  `VIS_DATEEMBAUCHE` date NOT NULL,
  `SEC_CODE` varchar(20) DEFAULT NULL,
  `LAB_CODE` varchar(2) DEFAULT NULL,
  `TYV_CODE` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `visiteur`
--

INSERT INTO `visiteur` (`VIS_MATRICULE`, `VIS_NOM`, `VIS_PRENOM`, `VIS_ADRESSE`, `VIS_CP`, `VIS_VILLE`, `VIS_DATEEMBAUCHE`, `SEC_CODE`, `LAB_CODE`, `TYV_CODE`) VALUES
('56', 'Lecornu', 'Ludovic', '4 r Abel Servien', 25000, 'BESANCON', '1996-02-27', NULL, 'SW', 'V'),
('a131', 'Villechalane', 'Louis', '8 cours Lafontaine', 29000, 'BREST', '1992-12-11', NULL, 'SW', 'V'),
('a17', 'Andre', 'David', '1 r Aimon de Chissee', 38100, 'GRENOBLE', '1991-08-26', NULL, 'GY', 'D'),
('a55', 'Bedos', 'Christian', '1 r Benedictins', 65000, 'TARBES', '1987-07-17', NULL, 'GY', 'D'),
('a93', 'Tusseau', 'Louis', '22 r Renou', 65535, 'POITIERS', '1999-01-02', NULL, 'SW', 'V'),
('b13', 'Bentot', 'Pascal', '11 av 6 Juin', 65535, 'STRASBOURG', '1996-03-11', NULL, 'GY', 'V'),
('b16', 'Bioret', 'Luc', '1 r Linne', 35000, 'RENNES', '1997-03-21', NULL, 'SW', 'V'),
('b19', 'Bunisset', 'Francis', '10 r Nicolas Chorier', 65535, 'LA ROCHE SUR YON', '1999-01-31', NULL, 'GY', 'V'),
('b25', 'Bunisset', 'Denise', '1 r Lionne', 49100, 'ANGERS', '1996-07-03', NULL, 'SW', 'D'),
('b28', 'Cacheux', 'Bernard', '114 r Authie', 34000, 'MONTPELLIER', '2000-08-02', NULL, 'GY', 'V'),
('b34', 'Cadic', 'Eric', '123 r Caponiere', 41000, 'BLOIS', '1993-12-06', 'P', 'SW', 'R'),
('b4', 'Charoze', 'Catherine', '100 pl Geants', 33000, 'BORDEAUX', '1997-09-25', NULL, 'SW', 'V'),
('b50', 'Clepkens', 'Christophe', '12 r Federico Garcia Lorca', 13000, '1998-01-18', '1998-01-18', NULL, 'SW', 'V'),
('b59', 'Cottin', 'Vincenne', '36 sq Capucins', 5000, 'GAP', '1996-10-21', NULL, 'GY', 'V'),
('c14', 'Daburon', 'Francois', '13 r Champs Elysees', 6000, 'NICE', '1989-02-01', 'S', 'SW', 'R'),
('c3', 'De', 'Philippe', '13 r Charles Peguy', 10000, 'TROYES', '1992-05-05', NULL, 'SW', 'V'),
('c54', 'Debelle', 'Michel', '181 r Caponiere', 65535, 'EPINAL', '1991-04-09', NULL, 'SW', 'V'),
('d13', 'Debelle', 'Jeanne', '134 r Stalingrad', 44000, 'NANTES', '1991-12-05', NULL, 'SW', 'V'),
('d51', 'Debroise', 'Michel', '2 av 6 Juin', 65535, 'VESOUL', '1997-11-18', 'E', 'GY', 'R'),
('e22', 'Desmarquest', 'Nathalie', '14 r Federico Garcia Lorca', 54000, 'NANCY', '1989-03-24', NULL, 'GY', 'V'),
('e24', 'Desnost', 'Pierre', '16 r Barral de Montferrat', 55000, 'VERDUN', '1993-05-17', 'E', 'SW', 'R'),
('e39', 'Dudouit', 'Frederic', '18 quai Xavier Jouvin', 65535, 'PARIS', '1988-04-26', NULL, 'GY', 'V'),
('e49', 'Duncombe', 'Claude', '19 av Alsace Lorraine', 9000, 'FOIX', '1996-02-19', NULL, 'GY', 'V'),
('e5', 'Enault-Pascreau', 'Celine', '25B r Stalingrad', 40000, 'MONT DE MARSAN', '1990-11-27', 'S', 'GY', 'R'),
('e52', 'Eynde', 'Valerie', '3 r Henri Moissan', 65535, 'ROUEN', '1991-10-31', NULL, 'GY', 'V'),
('f21', 'Finck', 'Jacques', 'rte Montreuil Bellay', 65535, 'ANNECY', '1993-06-08', NULL, 'SW', 'V'),
('f39', 'Fremont', 'Fernande', '4 r Jean Giono', 69000, 'LYON', '1997-02-15', NULL, 'GY', 'V'),
('f4', 'Gest', 'Alain', '30 r Authie', 46000, 'FIGEAC', '1994-05-03', NULL, 'GY', 'V'),
('g19', 'Gheysen', 'Galassus', '32 bd Mar Foch', 75000, 'PARIS', '1996-01-18', NULL, 'SW', 'V'),
('g30', 'Girard', 'Yvon', '31 av 6 Juin', 80000, 'AMIENS', '1999-03-27', 'N', 'GY', 'R'),
('g53', 'Gombert', 'Luc', '32 r Emile Gueymard', 56000, 'VANNES', '1985-10-02', NULL, 'GY', 'V'),
('g7', 'Guindon', 'Caroline', '40 r Mar Montgomery', 87000, 'LIMOGES', '1996-01-13', NULL, 'GY', 'V'),
('h13', 'Guindon', 'Francois', '44 r Picotière', 19000, 'TULLE', '1993-05-08', NULL, 'SW', 'V'),
('h30', 'Igigabel', 'Guy', '33 gal Arlequin', 94000, 'CRETEIL', '1998-04-26', NULL, 'SW', 'V'),
('h35', 'Jourdren', 'Pierre', '34 av Jean Perrot', 15000, 'AURILLAC', '1993-08-26', NULL, 'GY', 'V'),
('h40', 'Juttard', 'Pierre-Raoul', '34 cours Jean Jaures', 8000, 'SEDAN', '1992-11-01', NULL, 'GY', 'V'),
('j45', 'Laboure-Morel', 'Saout', '38 cours Berriat', 52000, 'CHAUMONT', '1998-02-25', 'N', 'SW', 'R'),
('j50', 'Landre', 'Philippe', '4 av Gen Laperrine', 59000, 'LILLE', '1992-12-16', NULL, 'GY', 'V'),
('j8', 'Langeard', 'Hugues', '39 av Jean Perrot', 93000, 'BAGNOLET', '1998-06-18', 'P', 'GY', 'R'),
('k4', 'Lanne', 'Bernard', '4 r Bayeux', 30000, 'NIMES', '1996-11-21', NULL, 'GY', 'V'),
('k53', 'Le', 'Noel', '4 av Beauvert', 68000, 'MULHOUSE', '1983-03-23', NULL, 'SW', 'D'),
('l14', 'Le', 'Jean', '39 r Raspail', 53000, 'LAVAL', '1995-02-02', NULL, 'SW', 'V'),
('l23', 'Leclercq', 'Servane', '11 r Quinconce', 18000, 'BOURGES', '1995-06-05', NULL, 'SW', 'V'),
('l46', 'Lecornu', 'Jean-Bernard', '4 bd Mar Foch', 72000, 'LA FERTE BERNARD', '1997-01-24', NULL, 'GY', 'V'),
('m35', 'Lejard', 'Agnes', '4 r Anthoard', 82000, 'MONTAUBAN', '1987-10-06', NULL, 'SW', 'V'),
('m45', 'Lesaulnier', 'Pascal', '47 r Thiers', 57000, 'METZ', '1990-10-13', NULL, 'SW', 'D'),
('n42', 'Letessier', 'Stephane', '5 chem Capuche', 27000, 'EVREUX', '1996-03-06', NULL, 'GY', 'V'),
('n58', 'Loirat', 'Didier', 'Les Pechers cite Bourg la Croix', 45000, 'ORLEANS', '1992-08-30', NULL, 'GY', 'V'),
('n59', 'Maffezzoli', 'Thibaud', '5 r Chateaubriand', 2000, 'LAON', '1994-12-19', NULL, 'SW', 'V'),
('o26', 'Mancini', 'Anne', '5 r D\'Agier', 48000, 'MENDE', '1995-01-05', NULL, 'GY', 'V'),
('p32', 'Marcouiller', 'Gerard', '7 pl St Gilles', 91000, 'ISSY LES MOULINEAUX', '1992-12-24', NULL, 'GY', 'V'),
('p40', 'Michel', 'Jean-Claude', '5 r Gabriel Peri', 61000, 'FLERS', '1992-12-14', 'O', 'SW', 'R'),
('p41', 'Montecot', 'Francoise', '6 r Paul Valery', 17000, 'SAINTES', '1998-07-27', NULL, 'GY', 'V'),
('p42', 'Notini', 'Veronique', '5 r Lieut Chabal', 60000, 'BEAUVAIS', '1994-12-12', NULL, 'SW', 'V'),
('p49', 'Onfroy', 'Den', '5 r Sidonie Jacolin', 37000, 'TOURS', '1977-10-03', NULL, 'GY', 'V'),
('p6', 'Pascreau', 'Charles', '57 bd Mar Foch', 64000, 'PAU', '1997-03-30', NULL, 'SW', 'V'),
('p7', 'Pernot', 'Claude-Noel', '6 r Alexandre 1 de Yougoslavie', 11000, 'NARBONNE', '1990-03-01', NULL, 'SW', 'V'),
('p8', 'Perrier', 'Maitre', '6 r Aubert Dubayet', 71000, 'CHALON SUR SAONE', '1991-06-23', NULL, 'GY', 'V'),
('q17', 'Petit', 'Jean-Louis', '7 r Ernest Renan', 50000, 'SAINT LO', '1997-09-06', NULL, 'GY', 'V'),
('r24', 'Piquery', 'Patrick', '9 r Vaucelles', 14000, 'CAEN', '1984-07-29', 'O', 'GY', 'R'),
('r58', 'Quiquandon', 'Joel', '7 r Ernest Renan', 29000, 'QUIMPER', '1990-06-30', NULL, 'GY', 'V'),
('s10', 'Retailleau', 'Josselin', '88Bis r Saumuroise', 39000, 'DOLE', '1995-11-14', NULL, 'SW', 'V'),
('s21', 'Retailleau', 'Pascal', '32 bd Ayrault', 23000, 'MONTLUCON', '1992-09-25', NULL, 'SW', 'V'),
('t43', 'Souron', 'Maryse', '7B r Gay Lussac', 21000, 'DIJON', '1995-03-09', NULL, 'SW', 'V'),
('t47', 'Tiphagne', 'Patrick', '7B r Gay Lussac', 62000, 'ARRAS', '1997-08-29', NULL, 'SW', 'V'),
('t55', 'Trehet', 'Alain', '7D chem Barral', 12000, 'RODEZ', '1994-11-29', NULL, 'SW', 'V'),
('t60', 'Tusseau', 'Josselin', '63 r Bon Repos', 28000, 'CHARTRES', '1991-03-29', NULL, 'GY', 'V'),
('zzz', 'swiss', 'bourdin', NULL, NULL, NULL, '2003-06-18', NULL, 'BC', 'V');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `famille`
--
ALTER TABLE `famille`
  ADD PRIMARY KEY (`FAM_CODE`);

--
-- Index pour la table `labo`
--
ALTER TABLE `labo`
  ADD PRIMARY KEY (`LAB_CODE`);

--
-- Index pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`MED_DEPOTLEGAL`),
  ADD KEY `FK_FAM_CODE` (`FAM_CODE`);

--
-- Index pour la table `praticien`
--
ALTER TABLE `praticien`
  ADD PRIMARY KEY (`PRA_NUM`),
  ADD KEY `FK_TYP_CODE` (`TYP_CODE`);

--
-- Index pour la table `rapport_visite`
--
ALTER TABLE `rapport_visite`
  ADD PRIMARY KEY (`RAP_NUM`),
  ADD KEY `FK_VIS_MATRICULE` (`VIS_MATRICULE`),
  ADD KEY `FK_PRA_NUM` (`PRA_NUM`),
  ADD KEY `FK_TYM_CODE` (`TYM_CODE`);

--
-- Index pour la table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`REG_CODE`),
  ADD KEY `FK_SEC_CODE` (`SEC_CODE`);

--
-- Index pour la table `secteur`
--
ALTER TABLE `secteur`
  ADD PRIMARY KEY (`SEC_CODE`);

--
-- Index pour la table `specialite`
--
ALTER TABLE `specialite`
  ADD PRIMARY KEY (`SPE_CODE`);

--
-- Index pour la table `type_motif`
--
ALTER TABLE `type_motif`
  ADD PRIMARY KEY (`TYM_CODE`);

--
-- Index pour la table `type_praticien`
--
ALTER TABLE `type_praticien`
  ADD PRIMARY KEY (`TYP_CODE`);

--
-- Index pour la table `type_visiteur`
--
ALTER TABLE `type_visiteur`
  ADD PRIMARY KEY (`TYV_CODE`);

--
-- Index pour la table `visiteur`
--
ALTER TABLE `visiteur`
  ADD PRIMARY KEY (`VIS_MATRICULE`),
  ADD KEY `FK_SEC_CODE` (`SEC_CODE`),
  ADD KEY `FK_TYV_CODE` (`TYV_CODE`),
  ADD KEY `FK_LAB_CODE` (`LAB_CODE`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `praticien`
--
ALTER TABLE `praticien`
  MODIFY `PRA_NUM` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD CONSTRAINT `FK_FAM_CODE` FOREIGN KEY (`FAM_CODE`) REFERENCES `famille` (`FAM_CODE`);

--
-- Contraintes pour la table `praticien`
--
ALTER TABLE `praticien`
  ADD CONSTRAINT `FK_TYP_CODE` FOREIGN KEY (`TYP_CODE`) REFERENCES `type_praticien` (`TYP_CODE`);

--
-- Contraintes pour la table `rapport_visite`
--
ALTER TABLE `rapport_visite`
  ADD CONSTRAINT `FK_PRA_NUM` FOREIGN KEY (`PRA_NUM`) REFERENCES `praticien` (`PRA_NUM`),
  ADD CONSTRAINT `FK_TYM_CODE` FOREIGN KEY (`TYM_CODE`) REFERENCES `type_motif` (`TYM_CODE`),
  ADD CONSTRAINT `FK_VIS_MATRICULE` FOREIGN KEY (`VIS_MATRICULE`) REFERENCES `visiteur` (`VIS_MATRICULE`);

--
-- Contraintes pour la table `visiteur`
--
ALTER TABLE `visiteur`
  ADD CONSTRAINT `FK_LAB_CODE` FOREIGN KEY (`LAB_CODE`) REFERENCES `labo` (`LAB_CODE`),
  ADD CONSTRAINT `FK_TYV_CODE` FOREIGN KEY (`TYV_CODE`) REFERENCES `type_visiteur` (`TYV_CODE`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;