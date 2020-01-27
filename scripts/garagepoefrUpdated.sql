-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 23 jan. 2020 à 14:57
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `garagepoefr`
--
CREATE DATABASE IF NOT EXISTS `garagepoefr` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `garagepoefr`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `code_postal` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `cloturer` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `prenom`, `adresse`, `code_postal`, `ville`, `telephone`, `mobile`, `cloturer`) VALUES
(2, 'Glass', 'Imelda', '293-3436 Dui. Route', '20555', 'Flushing', '01 04 73 21 96', '06 23 83 80 58', b'0'),
(3, 'Ross', 'Jescie', '4084 Vitae Ave', '69115', 'Coronel', '02 65 32 94 99', '06 05 16 64 78', b'0'),
(4, 'Dalton', 'Kato', '434-5556 Dictum Ave', '47770', 'Kursk', '01 58 61 91 15', '06 54 65 81 47', b'0'),
(5, 'Raymond', 'Kiona', '731-9200 Vitae Impasse', '44802', 'Pemberton', '09 16 82 50 09', '06 88 47 18 01', b'0'),
(6, 'Lester', 'Oleg', 'Appartement 687-4416 Non, Rue', '88380', 'Cappelle sul Tavo', '02 39 86 08 46', '06 38 64 74 29', b'0'),
(7, 'Hendrix', 'Seth', '336-8860 Id, Route', '72573', 'Moncton', '03 99 49 74 37', '06 17 77 53 38', b'0'),
(8, 'Wooten', 'Uma', 'Appartement 355-9888 Fermentum Av.', '00253', 'Solihull', '07 61 15 20 48', '06 37 75 78 12', b'0'),
(9, 'Dodson', 'Hedy', 'CP 387, 7069 Malesuada. Chemin', '66981', 'Arlon', '08 84 72 18 75', '06 67 50 26 71', b'0'),
(10, 'Marsh', 'Freya', '613-920 Scelerisque Route', '77610', 'Gentinnes', '03 03 82 45 40', '06 74 54 42 50', b'0'),
(11, 'Houston', 'Tad', 'CP 600, 9729 Ac Chemin', '28144', 'Aubervilliers', '07 58 19 68 67', '06 53 52 27 77', b'0'),
(12, 'Fields', 'Tara', '318 Lorem Rue', '64911', 'Keswick', '02 10 64 60 89', '06 22 79 90 43', b'0'),
(13, 'Arnold', 'Carla', 'Appartement 235-5506 Nullam Impasse', '49243', 'Gubkin', '07 92 17 12 27', '06 18 97 30 39', b'0'),
(14, 'Hess', 'Jelani', 'CP 956, 9193 Adipiscing Chemin', '90141', 'Huntsville', '05 95 25 13 01', '06 42 76 03 83', b'0'),
(15, 'Houston', 'Gary', '497-113 Fames Chemin', '71580', 'Vierzon', '09 71 69 22 39', '06 86 73 45 95', b'0'),
(16, 'Dickson', 'Kiayada', '338-6910 Donec Ave', '48439', 'Steenhuffel', '06 62 23 87 37', '06 87 39 77 12', b'0'),
(17, 'Livingston', 'Emery', '8956 Diam Rue', '98846', 'Bannu', '02 63 64 63 95', '06 86 28 54 65', b'0'),
(18, 'Lopez', 'Libby', 'Appartement 102-4410 Parturient Rue', '54462', 'Cochin', '07 48 37 29 53', '06 62 44 08 63', b'0'),
(19, 'Patrick', 'Hamilton', 'Appartement 749-1273 Magnis Rue', '12044', 'Christchurch', '08 64 82 87 47', '06 43 64 87 47', b'0'),
(20, 'Pruitt', 'Warren', 'CP 525, 9403 Non, Rd.', '34952', 'Fogo', '03 19 30 83 33', '06 79 12 99 39', b'0'),
(21, 'Mays', 'Simon', '1601 Porttitor Av.', '29739', 'March', '08 89 97 02 22', '06 40 71 27 09', b'0'),
(22, 'Hardin', 'Ross', 'CP 716, 3394 Magna. Av.', '25483', 'Bellevue', '07 52 03 78 71', '06 94 68 38 99', b'0'),
(23, 'Solomon', 'Zane', '662-8408 Nullam Impasse', '79399', 'Foz do Iguaçu', '01 87 84 32 28', '06 20 27 15 94', b'0'),
(24, 'Rasmussen', 'Rowan', 'Appartement 601-1258 Nulla. Av.', '82398', 'Orciano Pisano', '04 89 27 11 40', '06 03 34 60 40', b'0'),
(25, 'Cooke', 'Luke', '7643 Sapien Rue', '57924', 'Zuienkerke', '02 72 06 28 04', '06 67 92 39 70', b'0'),
(26, 'Ray', 'Anjolie', '9530 Et Chemin', '44904', 'Nagpur', '07 52 92 50 96', '06 42 10 94 31', b'0'),
(27, 'Odonnell', 'Idola', 'CP 290, 2585 Nam Impasse', '75230', 'Joondalup', '01 37 40 82 00', '06 42 37 51 40', b'0'),
(28, 'Hanson', 'Kelsie', '120-1400 Senectus Chemin', '74569', 'Aiseau', '03 87 00 52 19', '06 16 12 54 05', b'0'),
(29, 'Saunders', 'Shad', 'CP 160, 5988 Vulputate, Rue', '58832', 'Raurkela', '01 62 03 59 35', '06 00 01 38 80', b'0'),
(30, 'Day', 'Quin', 'CP 918, 7652 Iaculis Impasse', '99160', 'Hasselt', '08 99 39 03 84', '06 46 84 25 82', b'0'),
(31, 'Bonner', 'Austin', 'Appartement 470-7081 Cursus Route', '37630', 'Toronto', '03 24 84 89 81', '06 82 34 81 71', b'0'),
(32, 'Bolton', 'Moses', 'CP 730, 1058 Ornare. Route', '52039', 'Melazzo', '06 69 86 87 86', '06 92 85 75 10', b'0'),
(33, 'Bolton', 'Emma', 'CP 886, 6167 Porttitor Avenue', '01613', 'Grosseto', '06 34 96 36 15', '06 12 05 81 91', b'0'),
(34, 'Pacheco', 'Nina', '658-7403 Varius Rd.', '97692', 'Gimhae', '01 01 28 80 94', '06 83 09 63 04', b'0'),
(35, 'Preston', 'Wyoming', 'CP 338, 6870 Morbi Rue', '14921', 'Gresham', '03 18 38 14 11', '06 09 94 30 32', b'0'),
(36, 'Acosta', 'Flynn', 'CP 136, 9315 Aenean Chemin', '66949', 'Bairnsdale', '06 14 56 03 94', '06 12 20 56 62', b'0'),
(37, 'Mooney', 'Omar', 'CP 148, 1478 Dapibus Ave', '13663', 'Santarém', '08 08 96 02 10', '06 89 76 59 34', b'0'),
(38, 'Weeks', 'Wylie', 'Appartement 813-831 Nec Impasse', '55493', 'Oxford County', '07 56 43 11 44', '06 67 71 93 97', b'0'),
(39, 'Frederick', 'Haley', 'Appartement 681-8534 Metus. Rd.', '08587', 'Navadwip', '03 65 30 07 78', '06 28 17 56 46', b'0'),
(40, 'Greene', 'Madeline', 'CP 882, 1020 Pede. Rue', '77835', 'Soissons', '06 64 44 00 95', '06 88 74 45 57', b'0'),
(41, 'Obrien', 'George', 'CP 203, 604 Donec Chemin', '90680', 'Cranbrook', '06 45 43 44 25', '06 08 35 79 22', b'0'),
(42, 'Stuart', 'Jesse', '3112 Lobortis. Route', '49396', 'Baardegem', '09 93 52 91 76', '06 79 67 81 32', b'0'),
(43, 'Mills', 'Risa', 'Appartement 470-5528 Est Rue', '67846', 'Scena/Schenna', '02 66 91 66 61', '06 64 84 60 23', b'0'),
(44, 'Todd', 'Patricia', 'Appartement 289-9443 Mauris. Ave', '56626', '100 Mile House', '09 57 42 54 81', '06 47 93 99 73', b'0'),
(45, 'Castro', 'Hilda', '650-2873 Eleifend. Av.', '17581', 'Castelluccio Inferiore', '03 95 48 47 97', '06 98 64 59 10', b'0'),
(46, 'Gray', 'Sawyer', '6216 Vel Route', '38034', 'Fontanigorda', '02 39 16 01 62', '06 46 69 62 90', b'0'),
(47, 'Pope', 'Isaiah', 'Appartement 416-3033 Nonummy Avenue', '29800', 'Caen', '07 12 81 89 72', '06 66 37 38 01', b'0'),
(48, 'Campbell', 'Keiko', 'CP 769, 2011 Tempor Route', '64558', 'King Township', '08 53 94 00 75', '06 93 77 71 97', b'0'),
(49, 'Gillespie', 'Keefe', 'CP 426, 5719 Lectus Route', '68679', 'Río Bueno', '03 25 84 20 37', '06 21 72 88 95', b'0'),
(50, 'Vaughn', 'Noel', 'Appartement 465-9283 Enim, Route', '64376', 'Canora', '03 07 01 08 54', '06 14 41 66 02', b'0'),
(51, 'Barnes', 'Bruno', '5535 Auctor. Av.', '64665', 'Castellina in Chianti', '09 46 57 39 60', '06 76 41 81 79', b'0');

-- --------------------------------------------------------

--
-- Structure de la table `commande_piece`
--

CREATE TABLE `commande_piece` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_piece` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `date_cloture` date DEFAULT NULL,
  `etat` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande_piece`
--

INSERT INTO `commande_piece` (`id`, `id_user`, `id_piece`, `quantite`, `date_creation`, `date_cloture`, `etat`) VALUES
(1, 2, 3, 1, '2020-01-23', '2020-01-23', b'1'),
(2, 1, 1, 2, '2020-01-23', NULL, b'0'),
(3, 1, 10, 1, '2020-01-23', NULL, b'0'),
(4, 2, 10, 1, '2020-01-23', NULL, b'0');

-- --------------------------------------------------------

--
-- Structure de la table `commande_vehicule`
--

CREATE TABLE `commande_vehicule` (
  `id` int(11) NOT NULL,
  `id_devis` int(11) DEFAULT NULL,
  `etat` bit(1) DEFAULT b'0',
  `date_creation` date DEFAULT NULL,
  `date_cloture` date DEFAULT NULL,
  `livre` bit(1) NOT NULL DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande_vehicule`
--

INSERT INTO `commande_vehicule` (`id`, `id_devis`, `etat`, `date_creation`, `date_cloture`, `livre`) VALUES
(1, 1, b'1', '2020-01-23', NULL, b'0'),
(2, 1, b'0', '2020-01-23', NULL, b'0');

-- --------------------------------------------------------

--
-- Structure de la table `devis`
--

CREATE TABLE `devis` (
  `id` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_vehicule` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `etatdevis` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `devis`
--

INSERT INTO `devis` (`id`, `id_client`, `id_vehicule`, `id_user`, `date_creation`, `etatdevis`) VALUES
(1, 2, 3, 1, '2020-01-06', b'1'),
(2, 3, 2, 2, '2020-01-21', b'0'),
(3, 12, 9, 2, '2020-01-22', b'1');

-- --------------------------------------------------------

--
-- Structure de la table `facture_devis`
--

CREATE TABLE `facture_devis` (
  `id` int(11) NOT NULL,
  `id_devis` int(11) NOT NULL,
  `prixHT` float DEFAULT 0,
  `tauxTVA` float DEFAULT 0.2,
  `date_creation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `facture_fiche`
--

CREATE TABLE `facture_fiche` (
  `id` int(11) NOT NULL,
  `id_fiche` int(11) NOT NULL,
  `prixHT` float DEFAULT 0,
  `tauxTVA` float DEFAULT 0.2,
  `date_creation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fiche`
--

CREATE TABLE `fiche` (
  `id` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `etatfiche` bit(1) DEFAULT b'0',
  `id_priorite` int(11) NOT NULL,
  `Date_creation` date NOT NULL,
  `Date_cloture` date DEFAULT NULL,
  `description` text DEFAULT NULL,
  `prixht` float NOT NULL DEFAULT 0,
  `tauxTVA` float NOT NULL DEFAULT 0.2
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fiche`
--

INSERT INTO `fiche` (`id`, `id_client`, `id_user`, `etatfiche`, `id_priorite`, `Date_creation`, `Date_cloture`, `description`, `prixht`, `tauxTVA`) VALUES
(1, 11, 1, b'0', 1, '2020-01-23', NULL, 'Voiture qui ne fonctionne plus', 1000, 0.2),
(2, 6, 1, b'0', 4, '2020-01-23', NULL, 'Problème d\'essuie glace', 50, 0.2);

-- --------------------------------------------------------

--
-- Structure de la table `pieces`
--

CREATE TABLE `pieces` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `quantite` int(11) DEFAULT NULL,
  `date_saisie` date DEFAULT NULL,
  `description` text DEFAULT NULL,
  `prixht` float NOT NULL DEFAULT 0,
  `tauxTVA` float NOT NULL DEFAULT 0.2
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pieces`
--

INSERT INTO `pieces` (`id`, `libelle`, `quantite`, `date_saisie`, `description`, `prixht`, `tauxTVA`) VALUES
(1, 'Moteur', 3, '2020-01-06', NULL, 0, 0.2),
(2, 'Roue', 8, '2019-12-25', NULL, 0, 0.2),
(3, 'Bougie', 50, '2019-11-12', NULL, 0, 0.2),
(4, 'Volant', 4, '2019-11-05', NULL, 0, 0.2),
(5, 'Vitre', 1, '2020-01-07', NULL, 0, 0.2),
(6, 'Pare choc', 7, '2019-09-09', NULL, 0, 0.2),
(7, 'Portière', 2, '2019-11-19', NULL, 0, 0.2),
(8, 'Siège', 6, '2019-10-14', NULL, 0, 0.2),
(9, 'Essuie Glace', 100, '2019-02-03', NULL, 0, 0.2),
(10, 'Pare brise', 10, '2018-03-22', NULL, 0, 0.2),
(11, 'Poignée', 60, '2017-12-22', NULL, 0, 0.2),
(12, 'Poignée', 60, '2017-12-22', NULL, 0, 0.2);

-- --------------------------------------------------------

--
-- Structure de la table `priorite`
--

CREATE TABLE `priorite` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `priorite`
--

INSERT INTO `priorite` (`id`, `libelle`) VALUES
(1, 'Très Urgent'),
(2, 'Urgent'),
(3, 'Normal'),
(4, 'Non prioritaire');

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `profil`
--

INSERT INTO `profil` (`id`, `name`) VALUES
(1, 'MECANICIEN'),
(2, 'ADMINISTRATEUR'),
(3, 'COMMERCIAL'),
(4, 'CHEF_ATELIER'),
(5, 'MAGASINIER');

-- --------------------------------------------------------

--
-- Structure de la table `profil_user`
--

CREATE TABLE `profil_user` (
  `id_user` int(11) NOT NULL,
  `id_profil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `profil_user`
--

INSERT INTO `profil_user` (`id_user`, `id_profil`) VALUES
(1, 2),
(1, 4),
(2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

CREATE TABLE `tache` (
  `id` int(11) NOT NULL,
  `commentaire` varchar(200) DEFAULT NULL,
  `id_user` int(11) NOT NULL,
  `id_fiche` int(11) NOT NULL,
  `id_priorite` int(11) NOT NULL,
  `id_piece` int(11) NOT NULL,
  `qte` int(11) DEFAULT 0,
  `etattache` bit(1) DEFAULT b'0',
  `libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`id`, `commentaire`, `id_user`, `id_fiche`, `id_priorite`, `id_piece`, `qte`, `etattache`, `libelle`) VALUES
(1, '', 1, 1, 3, 9, 2, b'0', 'Changement d\'essuie glace'),
(2, '', 2, 2, 1, 1, 1, b'0', 'Changement moteur');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `login` varchar(15) NOT NULL,
  `pwd` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `lastname`, `firstname`, `login`, `pwd`) VALUES
(1, 'DURAND', 'JEAN', 'JDURAND', '1234'),
(2, 'MARTIN', 'JEANNE', 'JMARTIN', '1234');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `id` int(11) NOT NULL,
  `modele` varchar(50) NOT NULL,
  `quantite` int(11) NOT NULL,
  `prixHT` float DEFAULT 0,
  `date_creation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`id`, `modele`, `quantite`, `prixHT`, `date_creation`) VALUES
(1, '307', 12, 15345, '2019-12-12'),
(2, 'GOLF IV', 6, 17450, '2019-12-11'),
(3, 'Porsche 911', 2, 120000, '2019-10-05'),
(4, 'Tesla Modèle 3', 1, 200000, '2017-10-08'),
(5, 'Afla Romeo 166', 10, 30000, '2018-11-06'),
(6, 'Audi A4', 2, 40000, '2019-08-05'),
(7, 'Bugatti Type 35', 1, 1300000, '2020-01-22'),
(8, 'Chevrolet Orlando', 5, 20000, '2018-11-25'),
(9, 'Ford Puma', 6, 15000, '2018-01-11'),
(10, 'Jaguar F-Type', 2, 70000, '2019-11-02'),
(11, 'Maserati Granturismo', 1, 80000, '2018-08-15');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande_piece`
--
ALTER TABLE `commande_piece`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_piece` (`id_piece`);

--
-- Index pour la table `commande_vehicule`
--
ALTER TABLE `commande_vehicule`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_devis` (`id_devis`);

--
-- Index pour la table `devis`
--
ALTER TABLE `devis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_vehicule` (`id_vehicule`);

--
-- Index pour la table `facture_devis`
--
ALTER TABLE `facture_devis`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_devis` (`id_devis`);

--
-- Index pour la table `facture_fiche`
--
ALTER TABLE `facture_fiche`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_fiche` (`id_fiche`);

--
-- Index pour la table `fiche`
--
ALTER TABLE `fiche`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_priorite` (`id_priorite`);

--
-- Index pour la table `pieces`
--
ALTER TABLE `pieces`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `priorite`
--
ALTER TABLE `priorite`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `profil_user`
--
ALTER TABLE `profil_user`
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_profil` (`id_profil`);

--
-- Index pour la table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_fiche` (`id_fiche`),
  ADD KEY `id_priorite` (`id_priorite`),
  ADD KEY `id_piece` (`id_piece`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT pour la table `commande_piece`
--
ALTER TABLE `commande_piece`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `commande_vehicule`
--
ALTER TABLE `commande_vehicule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `devis`
--
ALTER TABLE `devis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `facture_devis`
--
ALTER TABLE `facture_devis`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `facture_fiche`
--
ALTER TABLE `facture_fiche`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `fiche`
--
ALTER TABLE `fiche`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `pieces`
--
ALTER TABLE `pieces`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `priorite`
--
ALTER TABLE `priorite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `profil`
--
ALTER TABLE `profil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `tache`
--
ALTER TABLE `tache`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande_piece`
--
ALTER TABLE `commande_piece`
  ADD CONSTRAINT `commande_piece_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `commande_piece_ibfk_2` FOREIGN KEY (`id_piece`) REFERENCES `pieces` (`id`);

--
-- Contraintes pour la table `commande_vehicule`
--
ALTER TABLE `commande_vehicule`
  ADD CONSTRAINT `commande_vehicule_ibfk_1` FOREIGN KEY (`id_devis`) REFERENCES `devis` (`id`);

--
-- Contraintes pour la table `devis`
--
ALTER TABLE `devis`
  ADD CONSTRAINT `devis_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `devis_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `devis_ibfk_3` FOREIGN KEY (`id_vehicule`) REFERENCES `vehicule` (`id`);

--
-- Contraintes pour la table `facture_devis`
--
ALTER TABLE `facture_devis`
  ADD CONSTRAINT `facture_devis_ibfk_1` FOREIGN KEY (`id_devis`) REFERENCES `devis` (`id`);

--
-- Contraintes pour la table `facture_fiche`
--
ALTER TABLE `facture_fiche`
  ADD CONSTRAINT `facture_fiche_ibfk_1` FOREIGN KEY (`id_fiche`) REFERENCES `fiche` (`id`);

--
-- Contraintes pour la table `fiche`
--
ALTER TABLE `fiche`
  ADD CONSTRAINT `fiche_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `fiche_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `fiche_ibfk_3` FOREIGN KEY (`id_priorite`) REFERENCES `priorite` (`id`);

--
-- Contraintes pour la table `profil_user`
--
ALTER TABLE `profil_user`
  ADD CONSTRAINT `profil_user_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `profil_user_ibfk_2` FOREIGN KEY (`id_profil`) REFERENCES `profil` (`id`);

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
  ADD CONSTRAINT `tache_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `tache_ibfk_2` FOREIGN KEY (`id_fiche`) REFERENCES `fiche` (`id`),
  ADD CONSTRAINT `tache_ibfk_3` FOREIGN KEY (`id_priorite`) REFERENCES `priorite` (`id`),
  ADD CONSTRAINT `tache_ibfk_4` FOREIGN KEY (`id_piece`) REFERENCES `pieces` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
