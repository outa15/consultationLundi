-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 19 juil. 2020 à 20:19
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetjee`
--

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(20) DEFAULT 'patient',
  `message` varchar(500) DEFAULT NULL,
  `personne_id` int(11) DEFAULT NULL,
  `reponse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_g69tet6ewyp50jtinypwjr13h` (`personne_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `email`, `password`, `role`, `message`, `personne_id`, `reponse`) VALUES
(1, 'chlihfane.bouchra@gmail.com', '123456789', 'PATIENT', 'Bonjour tout le monde , docteur , je viens de sortir de l\'hôpital la semaine dernière , je ressens des douleurs dans mon dos , j\'ai pris les médicaments que vous m\'avais prescrit mais les douleurs restent encore, je ne sais pas quoi faire ? et s\'il y a quelqu\'un parmis vous qui a déja vécu cela qu\'il nous renseigne , Merci', 13, 'chlihfane.bouchra@gmail.com :        \r\nj\'ai déja vécu la meme chose , tu peux prendre une tisane et de la camomie cela aide beaucoup à se soulager et réduire les douleurs'),
(2, 'dr.ahmed.Alaoui@gmail.com', '123456789', 'MEDECIN', 'NULL', 1, NULL),
(6, 'amrani.meryem@gmail.com', '123456789', 'PATIENT', 'Bonjour tout le monde ,je subis souvent des crise d\'asthme une fois que le printemps approche , comme faire pour y remédier ? et est ce qu\'il y a des médicaments efficaces pour mon cas ? merci a vous tous ', 17, '=> Vous devez obligatoirement faire une consultation , tu dois faire quelques analyses pour savoir ce qui te prend exactement , en attendant tu peux prendre des histamines '),
(4, 'alaoui_amina@gmail.com', '123456789', 'PATIENT', 'Bonjour docteur , je subis des crises respiratoires de temps à autre , ainsi que la fievre , et de temps en temps je perds conscience , qu\'est ce que vous me conseillez , je suis diabètique de type B , merci ', 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

DROP TABLE IF EXISTS `consultation`;
CREATE TABLE IF NOT EXISTS `consultation` (
  `id` bigint(20) NOT NULL,
  `date_debut` varchar(255) DEFAULT NULL,
  `date_fin` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `montant` bigint(20) DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `symptomes` varchar(255) DEFAULT NULL,
  `traitement` varchar(255) DEFAULT NULL,
  `medecin_id` bigint(20) DEFAULT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8hcrvaxsjxg8ln7wis56xa1y` (`medecin_id`),
  KEY `FK7us6be9pm4xnpnf70gx1rt39k` (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `consultation`
--

INSERT INTO `consultation` (`id`, `date_debut`, `date_fin`, `details`, `montant`, `statut`, `symptomes`, `traitement`, `medecin_id`, `patient_id`) VALUES
(9, '06/05/2020', '07/05/2020', ' cardiaque , diabétique', 800, 'DISPONIBLE', 'vertige, perte de conscience', 'traitement par injections ', 1, 2),
(10, '06/05/2020', '06/05/2020', 'patient cardiaque , diabétique', 500, 'DISPONIBLE', 'fièvre, saignement du nez', 'radio', 1, 2),
(12, '06/05/2020', '06/05/2020', 'patient cardiaque et diabétique ', 800, 'DISPONIBLE', 'troubles du sommeil , fievre', 'simple consultation', 1, 2),
(13, '06/06/2020', '06/06/2020', 'patient cardiaque et diabétique', 300, 'DISPONIBLE', 'troubles du sommeil , saignements ', 'simple consultation', 1, 2),
(14, '05/08/2020', '05/08/2020', 'cardiaque', 600, 'ANNULE', 'douleurs au niveau des poumons', 'radio', 12, 17),
(18, '05/05/2020', '05/05/2020', 'cardiaque', 600, 'DISPONIBLE', 'perte de conscience et fievre', 'simmple consultation', 11, 17),
(20, '06/05/2020', '06/05/2020', NULL, 300, 'ANNULE', 'vertige, troubles hormonales', 'simple consultation', 1, 13),
(22, '06/05/2020', '06/05/2020', NULL, 300, 'DISPONIBLE', 'saignement du nez, fievre', 'Radio', 12, 13),
(23, '03/06/2020', '03/06/2020', 'patient cardiaque et asthmatique', 900, 'DISPONIBLE', 'fievres , crise respiratoires', 'simple consultation et analyses ', 1, 2),
(30, '03/08/2020', '03/08/2020', NULL, 200, 'DISPONIBLE', 'saignement du nez , vertige', 'simple consultation', 11, 13);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2),
(2);

-- --------------------------------------------------------

--
-- Structure de la table `hospitalisation`
--

DROP TABLE IF EXISTS `hospitalisation`;
CREATE TABLE IF NOT EXISTS `hospitalisation` (
  `id_reservation` varchar(20) NOT NULL,
  `motif` varchar(20) NOT NULL,
  PRIMARY KEY (`id_reservation`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

DROP TABLE IF EXISTS `medecin`;
CREATE TABLE IF NOT EXISTS `medecin` (
  `specialite` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`specialite`, `id`) VALUES
('cardio', 1),
('tromatho', 11),
('cardio', 12);

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

DROP TABLE IF EXISTS `medicament`;
CREATE TABLE IF NOT EXISTS `medicament` (
  `id_medicament` varchar(20) NOT NULL,
  `type_mal` varchar(20) NOT NULL,
  `nb_jr` int(3) NOT NULL,
  `id_ordon` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_medicament`),
  KEY `id_ordon` (`id_ordon`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ordonnance`
--

DROP TABLE IF EXISTS `ordonnance`;
CREATE TABLE IF NOT EXISTS `ordonnance` (
  `id_ordon` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `id_medicament` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_ordon`),
  KEY `id_medicament` (`id_medicament`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `accompagnateur` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `civilite` varchar(255) DEFAULT NULL,
  `date_naissance` varchar(255) DEFAULT NULL,
  `groupe_sanguin` varchar(255) DEFAULT NULL,
  `lien_familial` varchar(255) DEFAULT NULL,
  `lieu_naissance` varchar(255) DEFAULT NULL,
  `nationalite` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `situation_familial` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`accompagnateur`, `adresse`, `civilite`, `date_naissance`, `groupe_sanguin`, `lien_familial`, `lieu_naissance`, `nationalite`, `profession`, `situation_familial`, `ville`, `id`) VALUES
('Samira', '55,rue sabra,oujda', 'FEMME', '02/03/1990', 'B+', 'soeur', 'Oujda', 'marocaine', 'professeur', 'celibataire', 'oujda', 2),
('Ali', '35,rue sabra,casablanca', 'FEMME', '03/05/2020', 'B', 'frere', 'Oujda', 'Marocaine', 'Professeur', 'Celibataire', 'Oujda', 6),
('samira', '56,rue jaddah,Rabat', 'FEMME', '06/08/1998', 'B', 'soeur', 'Rabat', 'Marocaine', 'sans', 'mariée', 'Tanger', 7),
('adil', '23,rue rabie,Tanger', 'FEMME', '04/08/1997', 'AB', 'frere', 'Casablanca', 'marocaine', 'sans', 'divorcée', 'Tanger', 8),
('ikrame', '35,rue alworod', 'HOMME', '03/05/1991', 'AB+', 'soeur', 'Marrakech ', 'Marocaine', 'Professeur', 'Marié', 'Marrakech ', 9),
('Amira', '23,rue rabie , casablanca', 'FEMME', '05/08/1993', 'A+', 'soeur', 'oujda', 'marocaine', 'sans', 'divorcée', 'Rabat', 10),
('samir', '23,rue adoha ,Oujda', 'FEMME', '03/08/1998', 'AB', 'frere', 'oujda', 'marocaine', 'etudiante', 'celibataire', 'oujda', 13),
('Salim', '23,hay nahda, Rabat', 'FEMME', '03/08/1998', 'B+', 'frere', 'Rabat', 'Marocaine', 'etudiante', 'celibataire', 'Rabat', 17),
('adil', '23,rue rabie, Oujda', 'FEMME', '03/08/1998', 'AB', 'mari', 'oujda', 'marocaine', 'ingenieur', 'mariée', 'oujda', 20),
('malika', '55,rue tayba, casablanca', 'Marocaine', '03/05/1998', 'A+', 'soeur', 'casablanca', 'marocaine', 'sans', 'celibataire', 'Tanger', 21),
('Anis', '25,lotissement nahda , Tetouan ', 'FEMME', '03/08/1999', 'O-', 'mari', 'tetouan', 'marocaine', 'sans', 'mariée', 'Tetouan', 22);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` bigint(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `role`, `telephone`) VALUES
(1, 'DR.AHMED', 'Alaoui', 'MEDECIN', '686496523'),
(2, 'Alaoui', 'Amina', 'PATIENT', '2126535698'),
(6, 'Amrani', 'Meryem', 'PATIENT', '11458796'),
(7, 'Ramdani', 'amina', 'PATIENT', '2259866'),
(8, 'Amrani', 'wadia', 'PATIENT', '2256983'),
(9, 'Tazi', 'Amine', 'PATIENT', '2235698'),
(10, 'Salmani', 'Abir', 'PATIENT', '1145968'),
(11, 'DR.RAHMANI', 'abdel', 'MEDECIN', '2256398'),
(12, 'DR.Salhi', 'Amine', 'MEDECIN', '223658'),
(13, 'chlihfane', 'bouchra', 'PATIENT', '5263987'),
(16, 'DR.Boumdine', 'ahmed', 'MEDECIN', '055698333'),
(17, 'Amraoui', 'Douae', 'PATIENT', '65559863'),
(20, 'batta', 'saloua', 'PATIENT', '2336598'),
(21, 'Zouini', 'soumaya', 'PATIENT', '5669866'),
(22, 'Douhi', 'Salma', 'PATIENT', '25625635');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` bigint(20) NOT NULL,
  `patientt_id` bigint(20) DEFAULT NULL,
  `disponibilite` varchar(255) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `heure` int(11) DEFAULT NULL,
  `medecinn_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKks75ti832d7lncn6ub18ikl0n` (`medecinn_id`),
  KEY `FK5scrb6kwifht2lvro04c73vny` (`patientt_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id`, `patientt_id`, `disponibilite`, `date`, `heure`, `medecinn_id`) VALUES
(1, 2, 'à domicile ', '2020-07-21', 15, 1),
(2, 4, 'DISPONIBLE', '02/08/2020', 6, 1);

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `N_salle` int(5) NOT NULL,
  `id_reservation` varchar(20) NOT NULL,
  PRIMARY KEY (`N_salle`),
  KEY `id_reservation` (`id_reservation`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

DROP TABLE IF EXISTS `service`;
CREATE TABLE IF NOT EXISTS `service` (
  `id_service` varchar(10) NOT NULL,
  `nom_serv` varchar(20) NOT NULL,
  `spe_serv` varchar(20) NOT NULL,
  `id_personne` varchar(20) NOT NULL,
  PRIMARY KEY (`id_service`),
  KEY `id_personne` (`id_personne`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `spring_session`
--

DROP TABLE IF EXISTS `spring_session`;
CREATE TABLE IF NOT EXISTS `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Structure de la table `spring_session_attributes`
--

DROP TABLE IF EXISTS `spring_session_attributes`;
CREATE TABLE IF NOT EXISTS `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD CONSTRAINT `FK7us6be9pm4xnpnf70gx1rt39k` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  ADD CONSTRAINT `FK8hcrvaxsjxg8ln7wis56xa1y` FOREIGN KEY (`medecin_id`) REFERENCES `medecin` (`id`);

--
-- Contraintes pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD CONSTRAINT `FKr0053wn8500h0h9qu0hxkbqlj` FOREIGN KEY (`id`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `FK1py30rhmxo3rrpovp5nci2klq` FOREIGN KEY (`id`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
