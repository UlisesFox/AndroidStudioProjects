-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-08-2023 a las 07:27:26
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `electronics_fox`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codeP` int(255) NOT NULL,
  `nombreP` varchar(255) NOT NULL,
  `precioP` varchar(255) NOT NULL,
  `categoriaP` varchar(255) NOT NULL,
  `descuentoP` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codeP`, `nombreP`, `precioP`, `categoriaP`, `descuentoP`) VALUES
(123, 'Reizer', '5000', 'Laptops', '50%'),
(324, 'Ryzen 7', '4324235234', 'Laptops', '50%'),
(435, 'Corside ', '50000', 'Torres', '25%'),
(4356, 'Ram 18G', '500', 'Hardwares', 'none'),
(4563, 'Iphone', '1000000000', 'Telefonos', '25%');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `code` int(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `costo` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `entrega` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`code`, `nombre`, `costo`, `correo`, `categoria`, `entrega`) VALUES
(1, 'pacmen', '500000', 'waka@outlook.com', 'Hardwares', 'Completada'),
(143, 'blop', '945666', 'blop@outlook.com', 'Dispositivos', 'Pendiente'),
(234, 'Timblim', '100000', 'mitim@outlook.com', 'Softwares', 'Pendiente'),
(423, 'Microfox', '423000', 'micro@outlook.com', 'Dispositivos', 'Completada'),
(23465, 'fofofof', '5000', 'flop@outlook.com', 'Componentes', 'Completada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

CREATE TABLE `tarjeta` (
  `nombreT` varchar(255) NOT NULL,
  `contraT` varchar(255) NOT NULL,
  `bin` varchar(255) NOT NULL,
  `entidad` varchar(255) NOT NULL,
  `tipoT` varchar(255) NOT NULL,
  `cvv` int(255) NOT NULL,
  `caducidad` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tarjeta`
--

INSERT INTO `tarjeta` (`nombreT`, `contraT`, `bin`, `entidad`, `tipoT`, `cvv`, `caducidad`) VALUES
('Eluky', '1234', '4453546354635467', 'Visa', 'Credito', 654, '01/20'),
('flim', '5432432422345', '2937463547345345', 'Mastercard', 'Credito', 451, '05/30'),
('Floxy', '243457362542', '8352637453647589', 'Mastercard', 'Credito', 734, '07/24'),
('Loop', '2435432452342', '9045362345447845', 'American Express', 'Debito', 333, '11/13'),
('Pacmen', '4321864234', '2346578459473546', 'Visa', 'Debito', 323, '05/13');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codeP`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`code`);

--
-- Indices de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD PRIMARY KEY (`nombreT`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
