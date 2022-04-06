CREATE TABLE "autor" (
    idAutor SERIAL,
    "nome" varchar(255),
    "nacionalidade" varchar(255),
    PRIMARY KEY (idAutor)
);

CREATE TABLE "aluno" (
    idAluno SERIAL,
    "nome" varchar(255),
    "sobrenome" varchar(255),
    "endereco" varchar(255),
    "carreira" varchar(255),
    "idade" decimal,
    PRIMARY KEY (idAluno)
);

CREATE TABLE "livro" (
    idLivro SERIAL,
    "titulo" varchar(255),
    "editora" varchar(255),
    "area" varchar(255),
    PRIMARY KEY (idLivro)
);

CREATE TABLE "livro_autor" (
    idlivro_autor SERIAL,
    idLivro INTEGER,
    idAutor INTEGER,
    PRIMARY KEY (idlivro_autor),
    CONSTRAINT "idLivro_fk" FOREIGN KEY(idLivro) REFERENCES livro(idLivro),
    CONSTRAINT "idAutor_fk" FOREIGN KEY(idAutor) REFERENCES autor(idAutor)
);

CREATE TABLE "emprestimo" (
    idEmprestimo SERIAL,
    idLeitor INTEGER,
    idLivro INTEGER,
    "data_emprestimo" timestamp,
    "data_devolucao" timestamp,
    "retornou" boolean,
    PRIMARY KEY (idEmprestimo),
    CONSTRAINT "idLeitor_fk" FOREIGN KEY(idLeitor) REFERENCES aluno(idAluno),
    CONSTRAINT "idLivro_fk" FOREIGN KEY(idLivro) REFERENCES livro(idLivro) 
);

INSERT INTO autor(nome, nacionalidade) VALUES 
('Autor1', 'francesa'),
('Autor2', 'italiana'),
('Autor3', 'argentina'),
('Adams', 'ameriacano'),
('J.K. Rowling', 'inglesa');

INSERT INTO aluno(nome, sobrenome, endereco, carreira, idade) VALUES
('Nome1', 'Sobrenome1', 'Rua do Filippo', 'medicina', 18),
('Nome2', 'Sobrenome2', 'Rua do Nome2', 'historia', 19),
('Giselle', 'Alli', 'Rua do Nome3', 'informática', 20),
('Guillermo', 'Galli', 'Rua do Nome4', 'informática', 21),
('Filippo', 'Galli', 'Rua do Filippo', 'informática', 22);

INSERT INTO livro(titulo, editora, area) VALUES
('Titulo1', 'EditoraA', 'Banco de Dados'),
('Titulo2', 'Salamandra', 'internet'),
('Titulo3', 'EditoraA', 'internet'),
('Harry Potter 1', 'Salamandra', 'bruxaria'),
('Titulo4', 'Salamandra', 'Banco de Dados'),
('Harry Potter 2', 'Salamandra', 'bruxaria'),
('O Universo: Guia de Viagem', 'Salamandra', 'espacial');

INSERT INTO livro_autor(idLivro, idAutor) VALUES
(1,1),
(2,2),
(3,3),
(4,5),
(7,4),
(6,5);

INSERT INTO emprestimo(idLeitor, idLivro, data_emprestimo, data_devolucao, retornou) VALUES
(1,2, '2021-01-05 00:00:00', '2021-02-05 00:00:00', true),
(5,4, '2021-03-15 00:00:00', '2021-04-25 00:00:00', true),
(5,6, '2021-05-17 00:00:00', '2021-06-27 00:00:00', false),
(2,1, '2021-07-25 00:00:00', '2021-08-25 00:00:00', false),
(1,5, '2021-09-28 00:00:00', '2021-10-28 00:00:00', true),
(3,2, '2021-09-30 00:00:00', '2021-10-30 00:00:00', true);