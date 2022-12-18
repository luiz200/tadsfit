BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS aluno (
	nome TEXT,
	matricula INT,
	id_filial INT,
	id_fun INT,
	idade INT,
	peso FLOAT,
	altura FLOAT,
	sexo TEXT,
	contato	TEXT,
	endereco TEXT,
	PRIMARY KEY(matricula),
	FOREIGN KEY(id_filial) REFERENCES filial(idf),
	FOREIGN KEY(id_fun) REFERENCES funcionarios(matricula)
);
CREATE TABLE IF NOT EXISTS equipamentos (
	patrimonio	INT,
	id_filial INT,
	nome TEXT,
	status1 TEXT,
	PRIMARY KEY(patrimonio),
	FOREIGN KEY(id_filial) REFERENCES filial(idf)
);
CREATE TABLE IF NOT EXISTS funcionarios (
	matricula INT,
	id_filial INT,
	nome TEXT,
	idade INT,
	sexo TEXT,
	contato	TEXT,
	horario	TEXT,
	PRIMARY KEY(matricula),
	FOREIGN KEY(id_filial) REFERENCES filial(idf)
);
CREATE TABLE IF NOT EXISTS filial (
	idf	INT,
	endereco TEXT,
	contato	TEXT,
	horario	TEXT,
	PRIMARY KEY(idf)
);
INSERT INTO "Aluno" ("Nome","Matricula","Peso","Altura","Sexo","Contato","Endereco") VALUES ('Ramonie',2304,80,1.7,'M',84999999,'Rua');
INSERT INTO "Equipamentos" ("Patrimonio","Nome","Status") VALUES (1234,'Esteira','Em uso');
COMMIT;
