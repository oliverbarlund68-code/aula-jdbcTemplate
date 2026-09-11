CREATE TABLE tutor (
    id_tutor INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE animal (
    id_animal INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raca VARCHAR(50) NOT NULL,
    idade INT NOT NULL,
    id_tutor INT,
    FOREIGN KEY (id_tutor) REFERENCES tutor(id_tutor)
);

INSERT INTO tutor (nome, telefone) VALUES ('Carlos Silva', '(34) 99999-8888');
INSERT INTO animal (nome, especie, raca, idade, id_tutor) VALUES ('Rex', 'Cachorro', 'Labrador', 4, 1);