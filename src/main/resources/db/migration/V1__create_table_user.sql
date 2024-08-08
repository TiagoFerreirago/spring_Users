CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(15) NOT NULL,
  `dt_nasc` date NOT NULL,
  `genre` varchar(10) NOT NULL,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
);