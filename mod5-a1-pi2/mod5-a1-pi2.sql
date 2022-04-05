-- todos registros de filme
SELECT * FROM movies;
-- nome, sobrenome e classificação de todos os atores.
SELECT first_name, last_name, rating FROM actors;
-- título de todas as séries com alias
SELECT title AS "Título" from series;
-- atores cuja classificação é superior a 7,5
SELECT first_name, last_name FROM actors
WHERE rating > 7.5;
-- filmes com classificação superior a 7,5 e com mais de dois prêmios.
SELECT title, rating, awards FROM movies
WHERE rating > 7.5;
-- o título dos filmes e a classificação ordenados por classificação em ordem crescente.
SELECT title, rating FROM movies
ORDER BY rating ASC;
-- três primeiros filmes no banco de dados.
SELECT title FROM movies
LIMIT 3;
-- 5 melhores filmes com a classificação mais alta
SELECT * FROM movies
ORDER BY rating DESC
LIMIT 5;
-- 10 primeiros atores
SELECT * FROM actors
LIMIT 10;
-- todos os filmes cujo título é Toy Story
SELECT title, rating FROM movies
WHERE title = 'Toy Story';
-- nomes começam com Sam.
SELECT * FROM actors
WHERE first_name = 'Sam';
-- filmes que saíram entre 2004 e 2008
SELECT title FROM movies
WHERE release_date BETWEEN '20040101' AND '20081231';
-- varios filtros
SELECT title FROM movies
WHERE rating > 3
AND awards > 1
AND  release_date BETWEEN '19880101' AND '20091231';



-- exemplo inner join
SELECT movies.*, actors.first_name, actors.last_name
FROM movies INNER JOIN actors
ON movies.id = actors.favorite_movie_id;

-- exemplo left join
SELECT *
FROM movies mo LEFT JOIN actors ac
on mo.id = ac.favorite_movie_id;

-- exemplo group by
SELECT COUNT(*), mo.title, mo.rating, mo.awards
FROM movies mo INNER JOIN actors ac
ON mo.id = ac.favorite_movie_id
GROUP BY mo.title, mo.rating, mo.awards;

-- exemplo having
SELECT COUNT(*) AS tot_act, mo.title, mo.rating, mo.awards
FROM movies mo INNER JOIN actors ac
ON mo.id = ac.favorite_movie_id
GROUP BY mo.title, mo.rating, mo.awards
HAVING tot_act > 2;

