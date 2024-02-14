-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.36 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Copiando estrutura para tabela residencia_18.pilotos
CREATE TABLE IF NOT EXISTS `pilotos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pais` varchar(20) NOT NULL,
  `piloto` varchar(30) NOT NULL,
  `vitorias` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela residencia_18.pilotos: ~0 rows (aproximadamente)
INSERT INTO `pilotos` (`id`, `pais`, `piloto`, `vitorias`) VALUES
	(1, 'Reino Unido', 'Lewis Hamilton', 103),
	(2, 'Alemanha', 'Michael Schumacher', 91),
	(3, 'Países Baixos', 'Max Verstappen', 54),
	(4, 'Alemanha', 'Sebastian Vettel', 53),
	(5, 'França', 'Alain Prost', 51),
	(6, 'Brasil', 'Ayrton Senna', 41),
	(7, 'Espanha', 'Fernando Alonso', 32),
	(8, 'Reino Unido', 'Nigel Mansell', 31),
	(9, 'Escócia', 'Jackie Stewart', 27),
	(10, 'Escócia', 'Jim Clark', 25),
	(11, 'Áustria', 'Niki Lauda', 25),
	(12, 'Argentina', 'Juan Manuel Fangio', 24),
	(13, 'Brasil', 'Nelson Piquet', 23),
	(14, 'Alemanha', 'Nico Rosberg', 23),
	(15, 'Reino Unido', 'Damon Hill', 22),
	(16, 'Finlândia', 'Kimi Räikkönen', 21),
	(17, 'Finlândia', 'Mika Häkkinen', 20),
	(18, 'Reino Unido', 'Stirling Moss', 16),
	(19, 'Reino Unido', 'Jenson Button', 15),
	(20, 'Reino Unido', 'Graham Hill', 14),
	(21, 'Austrália', 'Jack Brabham', 14),
	(22, 'Brasil', 'Emerson Fittipaldi', 14),
	(23, 'Itália', 'Alberto Ascari', 13),
	(24, 'Escócia', 'David Coulthard', 13),
	(25, 'Estados Unidos', 'Mario Andretti', 12),
	(26, 'Argentina', 'Carlos Reutemann', 12),
	(27, 'Austrália', 'Alan Jones', 12),
	(28, 'Canadá', 'Jacques Villeneuve', 11),
	(29, 'Brasil', 'Rubens Barrichello', 11),
	(30, 'Brasil', 'Felipe Massa', 11),
	(31, 'Reino Unido', 'James Hunt', 10),
	(32, 'Suécia', 'Ronnie Peterson', 10),
	(33, 'África do Sul', 'Jody Scheckter', 10),
	(34, 'Áustria', 'Gerhard Berger', 10),
	(35, 'Finlândia', 'Valtteri Bottas', 10),
	(36, 'Austrália', 'Mark Webber', 9),
	(37, 'Bélgica', 'Jacky Ickx', 8),
	(38, 'Nova Zelândia', 'Denny Hulme', 8),
	(39, 'Austrália', 'Daniel Ricciardo', 8),
	(40, 'França', 'René Arnoux', 7),
	(41, 'Colômbia', 'Juan Pablo Montoya', 7),
	(42, 'Reino Unido', 'Tony Brooks', 6),
	(43, 'Reino Unido', 'John Surtees', 6),
	(44, 'Áustria', 'Jochen Rindt', 6),
	(45, 'Canadá', 'Gilles Villeneuve', 6),
	(46, 'França', 'Jacques Laffite', 6),
	(47, 'Itália', 'Riccardo Patrese', 6),
	(48, 'Alemanha', 'Ralf Schumacher', 6),
	(49, 'México', 'Sergio Pérez', 6),
	(50, 'Itália', 'Nino Farina', 5),
	(51, 'Suíça', 'Clay Regazzoni', 5),
	(52, 'Reino Unido', 'John Watson', 5),
	(53, 'Itália', 'Michele Alboreto', 5),
	(54, 'Finlândia', 'Keke Rosberg', 5),
	(55, 'Mónaco', 'Charles Leclerc', 5),
	(56, 'Estados Unidos', 'Dan Gurney', 4),
	(57, 'Nova Zelândia', 'Bruce McLaren', 4),
	(58, 'Irlanda do Norte', 'Eddie Irvine', 4),
	(59, 'Reino Unido', 'Mike Hawthorn', 3),
	(60, 'Reino Unido', 'Peter Collins', 3),
	(61, 'Estados Unidos', 'Phil Hill', 3),
	(62, 'França', 'Didier Pironi', 3),
	(63, 'Bélgica', 'Thierry Boutsen', 3),
	(64, 'Alemanha', 'Heinz-Harald Frentzen', 3),
	(65, 'Reino Unido', 'Johnny Herbert', 3),
	(66, 'Itália', 'Giancarlo Fisichella', 3),
	(67, 'Estados Unidos', 'Bill Vukovich', 2),
	(68, 'Argentina', 'José Froilán González', 2),
	(69, 'França', 'Maurice Trintignant', 2),
	(70, 'Alemanha', 'Wolfgang von Trips', 2),
	(71, 'México', 'Pedro Rodríguez', 2),
	(72, 'Suíça', 'Jo Siffert', 2),
	(73, 'Estados Unidos', 'Peter Revson', 2),
	(74, 'França', 'Patrick Depailler', 2),
	(75, 'França', 'Jean-Pierre Jabouille', 2),
	(76, 'França', 'Patrick Tambay', 2),
	(77, 'Itália', 'Elio de Angelis', 2),
	(78, 'Espanha', 'Carlos Sainz Jr.', 2),
	(79, 'Estados Unidos', 'Johnnie Parsons', 1),
	(80, 'Estados Unidos', 'Lee Wallard', 1),
	(81, 'Itália', 'Luigi Fagioli', 1),
	(82, 'Itália', 'Piero Taruffi', 1),
	(83, 'Estados Unidos', 'Troy Ruttman', 1),
	(84, 'Estados Unidos', 'Bob Sweikert', 1),
	(85, 'Itália', 'Luigi Musso', 1),
	(86, 'Estados Unidos', 'Pat Flaherty', 1),
	(87, 'Estados Unidos', 'Sam Hanks', 1),
	(88, 'Estados Unidos', 'Jimmy Bryan', 1),
	(89, 'Estados Unidos', 'Rodger Ward', 1),
	(90, 'Suécia', 'Joakim Bonnier', 1),
	(91, 'Estados Unidos', 'Jim Rathmann', 1),
	(92, 'Itália', 'Giancarlo Baghetti', 1),
	(93, 'Reino Unido', 'Innes Ireland', 1),
	(94, 'Itália', 'Lorenzo Bandini', 1),
	(95, 'Estados Unidos', 'Richie Ginther', 1),
	(96, 'Itália', 'Ludovico Scarfiotti', 1),
	(97, 'Reino Unido', 'Peter Gethin', 1),
	(98, 'França', 'François Cévert', 1),
	(99, 'França', 'Jean-Pierre Beltoise', 1),
	(100, 'Brasil', 'José Carlos Pace', 1),
	(101, 'Alemanha', 'Jochen Mass', 1),
	(102, 'Itália', 'Vittorio Brambilla', 1),
	(103, 'Suécia', 'Gunnar Nilsson', 1),
	(104, 'Itália', 'Alessandro Nannini', 1),
	(105, 'França', 'Jean Alesi', 1),
	(106, 'França', 'Olivier Panis', 1),
	(107, 'Itália', 'Jarno Trulli', 1),
	(108, 'Polónia', 'Robert Kubica', 1),
	(109, 'Finlândia', 'Heikki Kovalainen', 1),
	(110, 'Venezuela', 'Pastor Maldonado', 1),
	(111, 'França', 'Pierre Gasly', 1),
	(112, 'França', 'Esteban Ocon', 1),
	(113, 'Reino Unido', 'George Russell', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
