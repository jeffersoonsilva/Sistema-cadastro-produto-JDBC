CREATE DATABASE cadastroProduto;

USE cadastroProduto;

CREATE TABLE produto (
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    preco DOUBLE NOT NULL
);

describe produto;

SELECT * FROM produto;