-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 17-06-2026 a las 01:32:20
-- Versión del servidor: 8.4.7
-- Versión de PHP: 8.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informes`
--

DROP TABLE IF EXISTS `informes`;
CREATE TABLE IF NOT EXISTS `informes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `total_prestamos` int DEFAULT NULL,
  `libros_devueltos` int DEFAULT NULL,
  `libros_mora` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

DROP TABLE IF EXISTS `libros`;
CREATE TABLE IF NOT EXISTS `libros` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `autor` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `anio_publicacion` int NOT NULL,
  `estado` enum('DISPONIBLE','PRESTADO') COLLATE utf8mb4_unicode_ci DEFAULT 'DISPONIBLE',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `titulo`, `autor`, `anio_publicacion`, `estado`) VALUES
(1, 'Cien años de soledad', 'Gabriel Garcia Marquez', 1967, 'DISPONIBLE'),
(2, 'El Principito', 'Antoine de Saint-Exupery', 1943, 'PRESTADO'),
(3, 'Don Quijote de la Mancha', 'Miguel de Cervantes', 1605, 'PRESTADO'),
(4, 'Moby Dick', 'Herman Melville', 1851, 'DISPONIBLE'),
(5, 'El Perfume del Rey', 'Karine Bernal Lobo', 2023, 'DISPONIBLE'),
(6, 'Las Cadenas del Rey', 'Karine Bernal Lobo', 2024, 'DISPONIBLE'),
(8, 'Orgullo y Prejuicio', 'Jane Austen', 1813, 'DISPONIBLE'),
(9, 'Crimen y Castigo', 'Fiódor Dostoievski', 1866, 'PRESTADO'),
(10, 'El Señor de los Anillos', 'JRR Tolkien', 1954, 'DISPONIBLE'),
(11, 'El mapa de los anhelos', 'Alice Kellen', 2022, 'DISPONIBLE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

DROP TABLE IF EXISTS `personas`;
CREATE TABLE IF NOT EXISTS `personas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cedula` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `rol` enum('ADMINISTRADOR','BIBLIOTECARIO','USUARIO') COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cedula` (`cedula`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `cedula`, `nombre`, `apellido`, `telefono`, `email`, `username`, `password`, `rol`) VALUES
(1, '100000001', 'Principal', 'Sistema', '3001234567', 'principal@biblioteca.com', 'principal', '12345', 'ADMINISTRADOR'),
(5, '1006455458', 'Juan Esteban', 'Valencia', '1234567890', 'juanes@correo.com', 'juanes_10', 'juanes.10', 'BIBLIOTECARIO'),
(4, '1113303955', 'esteban', 'hernandez', '3184087366', 'steban@gmail.com', 'teban_herna', '12345678', 'USUARIO'),
(6, '1115358903', 'Luna Samantha', 'Candela Garcia', '3158193563', 'lunaCandela@gmail.com', 'luna_candela', 'Hellokitty.18', 'BIBLIOTECARIO'),
(7, '1115576200', 'Diego Alejandro', 'Pelaez Morales', '3508328434', 'diegoPelaez@gmail.com', 'diego_pelaez', 'Juego.18', 'BIBLIOTECARIO'),
(8, '12812231', 'David', 'Escobar', '3172860019', 'davidEscobar@gmail.com', 'david_escobar', '12812231', 'USUARIO'),
(9, '20357041', 'Nina', 'Juárez', '3176811044', 'ninaJuarez@gmail.com', 'nina_juarez', '20357041', 'USUARIO'),
(10, '5370381', 'Moisés', 'Tomás', '3025885860', 'moisesTomas@gmail.com', 'moises_52', 'moises.52', 'USUARIO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

DROP TABLE IF EXISTS `prestamos`;
CREATE TABLE IF NOT EXISTS `prestamos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `persona_id` int NOT NULL,
  `libro_id` int NOT NULL,
  `fecha_prestamo` date NOT NULL,
  `fecha_limite` date NOT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  `estado` enum('PENDIENTE','DEVUELTO','EN_MORA') COLLATE utf8mb4_unicode_ci DEFAULT 'PENDIENTE',
  PRIMARY KEY (`id`),
  KEY `persona_id` (`persona_id`),
  KEY `libro_id` (`libro_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`id`, `persona_id`, `libro_id`, `fecha_prestamo`, `fecha_limite`, `fecha_devolucion`, `estado`) VALUES
(1, 4, 1, '2026-06-14', '2026-07-04', '2026-06-14', 'DEVUELTO'),
(2, 4, 1, '2026-06-15', '2026-07-05', '2026-06-15', 'DEVUELTO'),
(3, 4, 1, '2026-06-15', '2026-07-05', '2026-06-16', 'DEVUELTO'),
(4, 4, 4, '2026-06-15', '2026-07-05', '2026-06-16', 'DEVUELTO'),
(5, 9, 9, '2026-06-16', '2026-07-06', NULL, 'PENDIENTE'),
(6, 4, 3, '2026-06-16', '2026-07-06', NULL, 'PENDIENTE');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
