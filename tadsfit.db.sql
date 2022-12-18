BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Aluno" (
	"Nome"	String,
	"Matricula"	INT,
	"Peso"	INT,
	"Altura"	FLOAT,
	"Sexo"	TEXT,
	"Contato"	NUMERIC,
	"Endereco"	TEXT,
	PRIMARY KEY("Matricula")
);
CREATE TABLE IF NOT EXISTS "Equipamentos" (
	"Patrimonio"	INT,
	"Nome"	STRING,
	"Status"	STRING,
	PRIMARY KEY("Patrimonio"),
	CONSTRAINT "CH_EQP" CHECK("Status" IN ("Em uso", "Manutenção"))
);
CREATE TABLE IF NOT EXISTS "Funcionarios" (
	"Matricula_Fun"	INT,
	"Nome"	STRING,
	"Idade"	INT,
	"Sexo"	STRING,
	"Contato"	NUMERIC,
	"Horario"	STRING,
	PRIMARY KEY("Matricula_Fun"),
	FOREIGN KEY("Matricula_Fun") REFERENCES "Filial"("id_F"),
	CONSTRAINT "CH_SEXOF" CHECK("Sexo" IN ("F", "M"))
);
CREATE TABLE IF NOT EXISTS "Filial" (
	"Id"	INT,
	"Endereco"	STRING,
	"Contato"	NUMERIC,
	"Horario "	INT,
	"id_aluno"	INT,
	"id_eqp"	INT,
	"id_f"	INT,
	PRIMARY KEY("Id","id_aluno","id_eqp","id_f"),
	FOREIGN KEY("id_f") REFERENCES "Funcionarios"("Matricula_Fun"),
	FOREIGN KEY("id_aluno") REFERENCES "Aluno"("Matricula"),
	CONSTRAINT "CH_PT" FOREIGN KEY("id_eqp") REFERENCES "Equipamentos"("Patrimonio")
);
INSERT INTO "Aluno" ("Nome","Matricula","Peso","Altura","Sexo","Contato","Endereco") VALUES ('Ramonie',2304,80,1.7,'M',84999999,'Rua');
INSERT INTO "Equipamentos" ("Patrimonio","Nome","Status") VALUES (1234,'Esteira','Em uso');
COMMIT;
