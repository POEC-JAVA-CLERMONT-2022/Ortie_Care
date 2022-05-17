-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 17 mai 2022 à 08:52
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ortie_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `conseils_de_culture`
--

DROP TABLE IF EXISTS `conseils_de_culture`;
CREATE TABLE IF NOT EXISTS `conseils_de_culture` (
  `id_conseil` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `titre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_conseil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `conseils_de_culture`
--

INSERT INTO `conseils_de_culture` (`id_conseil`, `description`, `titre`) VALUES
('bdb60c20-d50f-11ec-9d64-0242ac120002', 'Nettoie le sol ', 'Epuration'),
('bdb60d10-d50f-11ec-9d64-0242ac120002', 'Maintient l\'humidité au sol', 'Ombrage'),
('c621238a-b0ee-11ec-b909-0242ac120002', 'Lutte contre le champignon parasite, qui se traduit par des tâches sur les feuilles ainsi qu\'un changement de couleur de l\'écorce.', 'Lutte contre les maladies cryptogamiques'),
('c621265a-b0ee-11ec-b909-0242ac120002', 'Est un répulsif naturel contre les insectes et limaces. ', 'Eloigne les indésirables'),
('c62127e0-b0ee-11ec-b909-0242ac120002', 'Etalage des feuilles sur le sol ce qui conserve l\'humidité du sol et réduit la prolifération des mauvaises herbes.', 'Paillage naturel'),
('c6212948-b0ee-11ec-b909-0242ac120002', 'Les hautes tiges servent de support de croissance aux plantes grimpantes.', 'Tuteur naturel');

-- --------------------------------------------------------

--
-- Structure de la table `legumes`
--

DROP TABLE IF EXISTS `legumes`;
CREATE TABLE IF NOT EXISTS `legumes` (
  `id_legume` varchar(255) NOT NULL,
  `auto_reseme` bit(1) DEFAULT NULL,
  `is_gousse` bit(1) DEFAULT NULL,
  `poids_moyen_fruit_eng` int(11) DEFAULT NULL,
  `temps_avant_recolte_en_mois` int(11) DEFAULT NULL,
  `best_sol_id_sol` varchar(255) DEFAULT NULL,
  `nom` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_legume`),
  KEY `FK1l61jvdc613ajakte1uet5uyc` (`best_sol_id_sol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `legumes`
--

INSERT INTO `legumes` (`id_legume`, `auto_reseme`, `is_gousse`, `poids_moyen_fruit_eng`, `temps_avant_recolte_en_mois`, `best_sol_id_sol`, `nom`) VALUES
('10f0d5d0-e438-4606-b09b-f3c3f5cb37bb', b'0', b'0', 10, 7, '8d5fe500-b011-11ec-b909-0242ac120002', 'Fraise'),
('52ba70fa-ae96-4483-8f10-8cdcb5cf48a3', b'0', b'0', 125, 4, '8d5fe37a-b011-11ec-b909-0242ac120002', 'Carotte'),
('85b58100-b0ea-11ec-b909-0242ac120002', b'1', b'0', 130, 4, '8d5fe762-b011-11ec-b909-0242ac120002', 'Tomate'),
('85b584fc-b0ea-11ec-b909-0242ac120002', b'0', b'0', 100, 2, '8d5fe762-b011-11ec-b909-0242ac120002', 'Courgette'),
('85b586e6-b0ea-11ec-b909-0242ac120002', b'1', b'1', 80, 6, '8d5fe640-b011-11ec-b909-0242ac120002', 'Ail'),
('bdb604f0-d50f-11ec-9d64-0242ac120002', b'0', b'0', 50, 36, '8d5fe37a-b011-11ec-b909-0242ac120002', 'Asperge'),
('bdb606d0-d50f-11ec-9d64-0242ac120002', b'1', b'0', 300, 1, '8d5fe37a-b011-11ec-b909-0242ac120002', 'Betterave'),
('bdb607ca-d50f-11ec-9d64-0242ac120002', b'0', b'0', 300, 5, '8d5fe762-b011-11ec-b909-0242ac120002', 'Aubergine'),
('bdb608b0-d50f-11ec-9d64-0242ac120002', b'1', b'1', 100, 6, '8d5fe37a-b011-11ec-b909-0242ac120002', 'Oignon'),
('bdb6098c-d50f-11ec-9d64-0242ac120002', b'1', b'0', 100, 5, '8d5fe500-b011-11ec-b909-0242ac120002', 'Pomme de terre'),
('c6212ab0-b0ee-11ec-b909-0242ac120002', b'0', b'0', 250, 6, '8d5fe500-b011-11ec-b909-0242ac120002', 'Maïs'),
('c6212d3a-b0ee-11ec-b909-0242ac120002', b'1', b'0', 90, 5, '8d5fe37a-b011-11ec-b909-0242ac120002', 'Basilic'),
('c6212e5c-b0ee-11ec-b909-0242ac120002', b'1', b'0', 1500, 3, '8d5fe762-b011-11ec-b909-0242ac120002', 'Courge'),
('ffb8e4c6-e6fa-405e-86d0-5c57957a5ad5', b'1', b'1', 25, 4, '8d5fe37a-b011-11ec-b909-0242ac120002', 'Échalote');

-- --------------------------------------------------------

--
-- Structure de la table `legumes_conseils_de_culture`
--

DROP TABLE IF EXISTS `legumes_conseils_de_culture`;
CREATE TABLE IF NOT EXISTS `legumes_conseils_de_culture` (
  `legume_id_legume` varchar(255) NOT NULL,
  `conseils_de_culture_id_conseil` varchar(255) NOT NULL,
  PRIMARY KEY (`legume_id_legume`,`conseils_de_culture_id_conseil`),
  UNIQUE KEY `UK_kqgtewe1d9i3tvch3c00e1x9` (`conseils_de_culture_id_conseil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `legumes_conseils_de_culture`
--

INSERT INTO `legumes_conseils_de_culture` (`legume_id_legume`, `conseils_de_culture_id_conseil`) VALUES
('bdb6098c-d50f-11ec-9d64-0242ac120002', 'bdb60c20-d50f-11ec-9d64-0242ac120002'),
('bdb607ca-d50f-11ec-9d64-0242ac120002', 'bdb60d10-d50f-11ec-9d64-0242ac120002'),
('85b586e6-b0ea-11ec-b909-0242ac120002', 'c621238a-b0ee-11ec-b909-0242ac120002'),
('c6212d3a-b0ee-11ec-b909-0242ac120002', 'c621265a-b0ee-11ec-b909-0242ac120002'),
('c6212e5c-b0ee-11ec-b909-0242ac120002', 'c62127e0-b0ee-11ec-b909-0242ac120002'),
('c6212ab0-b0ee-11ec-b909-0242ac120002', 'c6212948-b0ee-11ec-b909-0242ac120002');

-- --------------------------------------------------------

--
-- Structure de la table `legumes_legumes_associes`
--

DROP TABLE IF EXISTS `legumes_legumes_associes`;
CREATE TABLE IF NOT EXISTS `legumes_legumes_associes` (
  `legume_id_legume` varchar(255) NOT NULL,
  `legumes_associes_id_legume` varchar(255) NOT NULL,
  PRIMARY KEY (`legume_id_legume`,`legumes_associes_id_legume`),
  UNIQUE KEY `UK_i9ihda1ib0bk2chpw6gmabsk5` (`legumes_associes_id_legume`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `legumes_legumes_associes`
--

INSERT INTO `legumes_legumes_associes` (`legume_id_legume`, `legumes_associes_id_legume`) VALUES
('85b586e6-b0ea-11ec-b909-0242ac120002', '10f0d5d0-e438-4606-b09b-f3c3f5cb37bb'),
('ffb8e4c6-e6fa-405e-86d0-5c57957a5ad5', '85b58100-b0ea-11ec-b909-0242ac120002'),
('85b58100-b0ea-11ec-b909-0242ac120002', '85b586e6-b0ea-11ec-b909-0242ac120002'),
('85b58100-b0ea-11ec-b909-0242ac120002', 'bdb604f0-d50f-11ec-9d64-0242ac120002'),
('85b58100-b0ea-11ec-b909-0242ac120002', 'c6212d3a-b0ee-11ec-b909-0242ac120002');

-- --------------------------------------------------------

--
-- Structure de la table `sols`
--

DROP TABLE IF EXISTS `sols`;
CREATE TABLE IF NOT EXISTS `sols` (
  `id_sol` varchar(255) NOT NULL,
  `avantage_sol` varchar(255) DEFAULT NULL,
  `inconvenient_sol` varchar(255) DEFAULT NULL,
  `nom_sol` varchar(255) DEFAULT NULL,
  `structure_sol` varchar(255) DEFAULT NULL,
  `texture_sol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_sol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sols`
--

INSERT INTO `sols` (`id_sol`, `avantage_sol`, `inconvenient_sol`, `nom_sol`, `structure_sol`, `texture_sol`) VALUES
('8d5fe37a-b011-11ec-b909-0242ac120002', 'Sol qui se travaille bien et qui draine bien l\'eau; peut être réchauffé très rapidement.', 'Sol peu fertile qui ne retient pas l\'eau; très propice à l\'érosion.', 'Sableux', 'Glisse entre les doigts en raison de l\'absence de cohésion entre les particules; très sensible à l\'érosion par le vent et au lessivage.', 'Contient surtout du sable; sol très poreux qui ne retient pas l\'eau; sèche et se réchauffe en peu de temps.'),
('8d5fe500-b011-11ec-b909-0242ac120002', 'Sol qui se travaille bien et qui est très fertile.', 'Sol très fragile, qui s\'érode facilement.', 'Limoneux', 'Particules relativement serrées permettant à l\'air et à l\'eau de circuler plus ou moins facilement; sujet à la formation superficielle d’une croûte sèche qui limite l’infiltration d’eau, tout en favorisant le ruissellement.', 'Contient surtout du limon; adhésion partielle des particules du sol qui se désagrègent en petits morceaux sous l\'effet de l\'environnement; porosité moyenne.'),
('8d5fe640-b011-11ec-b909-0242ac120002', 'Sol qui retient bien l\'eau et qui est très fertile.', 'Sol qui se travaille mal et qui réagit mal aux variations de température (gèle facilement).', 'Argileux', 'Peu de place pour la circulation de l\'eau et de l\'air; retient bien l\'eau et les éléments nutritifs; sensibilité à l’érosion par le vent; tendance à être alcalin.', 'Sol lourd et compact dont les particules demeurent collées entre elles comme de la pâte à modeler; risque de compaction du sol ; un sol compacté sera alors difficilement drainé ; souvent désigné sous le nom de glaise.'),
('8d5fe762-b011-11ec-b909-0242ac120002', 'Sol très fertile, qui retient bien l\'eau et qui se réchauffe facilement.', 'Sol parfois très acide qui peut nuire au développement des végétaux.', 'Humifère', 'Peut retenir une grande quantité d\'eau sans devenir collant comme le sol argileux; retient bien les engrais; peut être sensible à l\'érosion par le vent.', 'Contient surtout de la matière organique; particules foncées relativement lâches qui glissent entre les doigts; permet à l\'eau de s\'écouler facilement.');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id_user` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `is_admin` bit(1) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id_user`, `email`, `first_name`, `is_admin`, `last_name`, `password`) VALUES
('8d5fdf10-b011-11ec-b909-0242ac120002', 'lol@lol.fr', 'Olivia', b'1', 'LACONTE', 'olivia'),
('8d5fe1cc-b011-11ec-b909-0242ac120002', 'lol@lol.fr', 'Charles', b'1', 'GYORI', 'charles'),
('8d5fe884-b011-11ec-b909-0242ac120002\r\n\r\n', 'nul@pasadmin.fr', 'Michel', b'0', 'PASADMIN', 'michel');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `legumes`
--
ALTER TABLE `legumes`
  ADD CONSTRAINT `FK1l61jvdc613ajakte1uet5uyc` FOREIGN KEY (`best_sol_id_sol`) REFERENCES `sols` (`id_sol`);

--
-- Contraintes pour la table `legumes_conseils_de_culture`
--
ALTER TABLE `legumes_conseils_de_culture`
  ADD CONSTRAINT `FK359qhhw6kwfw6oy5ep09qbv9y` FOREIGN KEY (`conseils_de_culture_id_conseil`) REFERENCES `conseils_de_culture` (`id_conseil`),
  ADD CONSTRAINT `FKr26ntoti5jy9ryvsno7nttnuc` FOREIGN KEY (`legume_id_legume`) REFERENCES `legumes` (`id_legume`);

--
-- Contraintes pour la table `legumes_legumes_associes`
--
ALTER TABLE `legumes_legumes_associes`
  ADD CONSTRAINT `FKdxmqv5csngndrk674li3fxtnd` FOREIGN KEY (`legumes_associes_id_legume`) REFERENCES `legumes` (`id_legume`),
  ADD CONSTRAINT `FKgx92w1jtj35nbnba248xybv1o` FOREIGN KEY (`legume_id_legume`) REFERENCES `legumes` (`id_legume`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
