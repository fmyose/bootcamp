
--1. Listar os dados dos autores.
SELECT * FROM autor;

--2. Listar nome e idade dos alunos
SELECT nome, idade FROM aluno;

-- 3. Quais alunos pertencem à carreira de informática?
SELECT nome FROM aluno
WHERE carreira = 'informática';

-- 4. Quais autores são de nacionalidade francesa ou italiana?
SELECT nome, nacionalidade FROM autor
WHERE nacionalidade = 'francesa' OR nacionalidade = 'italiana';

-- 5. Que livros não são da área da internet?
SELECT titulo FROM livro
WHERE area = 'internet';

-- 6. Listar os livros da editora Salamandra.
SELECT titulo FROM livro
WHERE editora = 'Salamandra';

-- 7. Listar os dados dos alunos cuja idade é maior que a média.
SELECT nome, sobrenome, endereco, carreira, idade FROM aluno
GROUP BY nome, sobrenome, endereco, carreira, idade 
HAVING AVG(idade) > (SELECT AVG(idade) FROM aluno);

-- 8. Listar os nomes dos alunos cujo sobrenome começa com a letra G.
SELECT nome, sobrenome FROM aluno
WHERE sobrenome LIKE 'G%';

-- 9. Listar os autores do livro "O Universo: Guia de Viagem". (Apenas nomesd evem ser listados.)
SELECT DISTINCT autor.nome FROM livro_autor
INNER JOIN autor
    ON autor.idAutor = livro_autor.idAutor
INNER JOIN livro
	ON livro_autor.idLivro IN (SELECT idLivro from livro WHERE titulo = 'O Universo: Guia de Viagem' )

-- 10. Listar autores que tenham nacionalidade italiana ou argentina.
SELECT nome, nacionalidade FROM autor
WHERE nacionalidade = 'italiana' OR nacionalidade = 'argentina';

--          11. Que livros foram emprestados ao leitor “Filippo Galli”?
SELECT DISTINCT livro.titulo FROM emprestimo, livro, aluno
WHERE emprestimo.idLivro = livro.idLivro
AND emprestimo.idLeitor IN (
		SELECT idAluno FROM aluno WHERE nome = 'Filippo');

-- 12. Listar o nome do aluno mais novo.
SELECT nome FROM aluno
ORDER BY idade ASC
LIMIT 1;

-- 13. Listar os nomes dos alunos a quem os livros de Banco de Dados foram emprestados.
SELECT aluno.nome FROM emprestimo, livro, aluno
WHERE livro.idLivro = emprestimo.idLivro
AND livro.area = 'Banco de Dados'
AND aluno.idAluno = emprestimo.idLeitor;

-- 14. Listar os livros que pertencem ao autor J.K. Rowling.
SELECT livro.titulo FROM livro_autor
INNER JOIN (SELECT idAutor FROM autor WHERE nome='J.K. Rowling') a 
ON  livro_autor.idAutor = a.idAutor
INNER JOIN livro ON livro.idLivro = livro_autor.idLivro

-- 15. Listar os títulos dos livros que deveriam ser devolvidos até 16/07/2021.
SELECT livro.titulo FROM emprestimo
INNER JOIN livro
    ON emprestimo.idLivro = livro.idLivro
WHERE data_devolucao < '2021-07-16';
