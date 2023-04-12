CREATE DATABASE bancoTrabalhoDesktop;
USE bancoTrabalhoDesktop;

CREATE TABLE usuario (
	usuario_id SERIAL NOT NULL,
	usuario_nome VARCHAR(45) NOT NULL,
	usuario_email VARCHAR(100) NOT NULL,
	usuario_telefone VARCHAR(11) NOT NULL,
	usuario_data_criacao TIMESTAMP DEFAULT now() NOT NULL,
	PRIMARY KEY (usuario_id)
);

CREATE TABLE emprestimo (
	emprestimo_id SERIAL NOT NULL,
	emprestimo_item VARCHAR(45) NOT NULL,
	emprestimo_data_criacao TIMESTAMP DEFAULT now() NOT NULL,
	usuario_id INT NOT NULL,
	PRIMARY KEY (emprestimo_id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id)
);

CREATE TABLE observacao (
	observacao_id SERIAL NOT NULL,
	observacao_descricao VARCHAR(200) NOT NULL,
	observacao_data_criacao TIMESTAMP DEFAULT now() NOT NULL,
	emprestimo_id INT NOT NULL,
	PRIMARY KEY (observacao_id),
	FOREIGN KEY (emprestimo_id) REFERENCES emprestimo(emprestimo_id)
);

INSERT INTO usuario (usuario_nome, usuario_email, usuario_telefone, usuario_data_criacao) VALUES 
	('Eduardo Spagna', 'eduardo@gmail.com', '77999999999', now()),
	('Bianca Canezin', 'bianca@gmail.com', '77999999999', now()),
	('Fabricio Desktop', 'fabricio@gmail.com', '77999999999', now()),
	('Aluno 1', 'aluno1@gmail.com', '77999999999', now()),
	('Aluno 2', 'aluno2@gmail.com', '77999999999', now()),
	('Aluno 3', 'aluno3@gmail.com', '77999999999', now()),
	('Aluno 4', 'aluno4@gmail.com', '77999999999', now()),
	('Aluno 5', 'aluno5@gmail.com', '77999999999', now());
	
INSERT INTO emprestimo (emprestimo_item, emprestimo_data_criacao, usuario_id) VALUES
	('Jogo Playstation 4 - Fifa 19', now(), 1),
	('Caderno', now(), 2),
	('Celular Nokia Tijolão', now(), 2),
	('Jogo de PC', now(), 3),
	('Garrafinha de agua', now(), 4),
	('Notebook', now(), 5),
	('Caneca da Furia', now(), 1),
	('Samba da C7', now(), 1),
	('10 reais', now(), 1),
	('Chave da Incubadora', now(), 1),
	('Camisa social Preta', now(), 1),
	('Conta Steam', now(), 8),
	('Jogo Playstation 3 - GTA V', now(), 1);
	
INSERT INTO observacao (observacao_descricao, observacao_data_criacao, emprestimo_id) VALUES 
	('Obs 1_1', now(), 1),
	('Obs 1_2', now(), 1),
	('Obs 1_3', now(), 1),
	('Obs 1_4', now(), 1),
	('Obs 2_1', now(), 2),
	('Obs 2_2', now(), 2),
	('Obs 3_1', now(), 3),
	('Obs 4_1', now(), 4),
	('Obs 5_1', now(), 5),
	('Obs 6_1', now(), 6),
	('Obs 7_1', now(), 7),
	('Obs 8_1', now(), 8),
	('Obs 9_1', now(), 9),
	('Obs 10_1', now(), 10),
	('Obs 11_1', now(), 11),
	('Obs 11_2', now(), 11),
	('Obs 12_1', now(), 12);