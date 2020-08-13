
CREATE SCHEMA IF NOT EXISTS `locadora` DEFAULT CHARACTER SET utf8 ;
USE `locadora` ;

CREATE TABLE IF NOT EXISTS `locadora`.`marcas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `marca_UNIQUE` (`marca` ASC) 
  );

CREATE TABLE IF NOT EXISTS `locadora`.`veiculos` (
  `placa` VARCHAR(4) NOT NULL,
  `marca_id` INT NOT NULL,
  `modelo` VARCHAR(20) NOT NULL,
  `cor` VARCHAR(20) NOT NULL,
  `portas` INT(1) NOT NULL,
  `ano` VARCHAR(4) NOT NULL,
  `classe` VARCHAR(1) NOT NULL,
  `preco_dia` FLOAT(7) NOT NULL,
  `categoria` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`placa`),
  INDEX `fk_veiculos_marcas_idx` (`marca_id` ASC) ,
  CONSTRAINT `fk_veiculos_marcas`
    FOREIGN KEY (`marca_id`)
    REFERENCES `locadora`.`marcas` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

CREATE TABLE IF NOT EXISTS `locadora`.`clientes` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `sexo` VARCHAR(1) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `rua` VARCHAR(50) NOT NULL,
  `bairro` VARCHAR(50) NOT NULL,
  `numero` VARCHAR(7) NOT NULL,
  `complemento` VARCHAR(50) NULL,
  `cidade` VARCHAR(30) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `celular` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`cpf`)
  );

CREATE TABLE IF NOT EXISTS `locadora`.`alugados` (
  `veiculo_placa` VARCHAR(4) NOT NULL,
  `cliente_cpf` VARCHAR(11) NOT NULL,
  `preco_total` FLOAT(7) NOT NULL,
  `data_aluguel` DATETIME NOT NULL,
  `data_retorno` DATETIME NOT NULL,
  INDEX `fk_alugados_clientes1_idx` (`cliente_cpf` ASC) ,
  PRIMARY KEY (`veiculo_placa`, `cliente_cpf`),
  UNIQUE INDEX `veiculo_placa_UNIQUE` (`veiculo_placa` ASC) ,
  UNIQUE INDEX `cliente_cpf_UNIQUE` (`cliente_cpf` ASC) ,
  CONSTRAINT `fk_alugados_veiculos`
    FOREIGN KEY (`veiculo_placa`)
    REFERENCES `locadora`.`veiculos` (`placa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alugados_clientes`
    FOREIGN KEY (`cliente_cpf`)
    REFERENCES `locadora`.`clientes` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    );

CREATE VIEW veiculos_view AS SELECT 
	v.placa,
    m.marca,
	v.modelo, 
	v.cor, 
    v.portas,
	v.ano, 
	v.classe, 
	v.preco_dia,
    v.categoria
FROM veiculos AS v
INNER JOIN marcas AS m ON m.id = v.marca_id;

CREATE VIEW alugados_view AS SELECT 
    c.cpf,
    c.nome,
    v.placa,
    m.marca,
    v.modelo,
	a.preco_total,
	a.data_aluguel,
    a.data_retorno
FROM alugados AS a
INNER JOIN veiculos AS v ON v.placa = a.veiculo_placa
INNER JOIN marcas AS m ON m.id = v.marca_id
INNER JOIN clientes AS c ON c.cpf = a.cliente_cpf;


