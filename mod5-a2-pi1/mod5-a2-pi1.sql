-- titulo e nome do genero de todas as series
SELECT series.title,  genres.name
FROM series INNER JOIN genres
    ON series.genre_id = genres.id;
-- atores e episodios
SELECT actors.first_name, actors.last_name, episodes.title
FROM actor_episode 
INNER JOIN actors
    ON actors.id = actor_episode.actor_id
INNER JOIN episodes
    ON episodes.id = actor_episode.episode_id
-- numero de temporadas por serie
SELECT series.title, COUNT(*) AS temporadas
FROM series INNER JOIN seasons
	ON series.id = seasons.serie_id
GROUP BY seasons.serie_id, series.title
-- nome de todos os gêneros e o número total de filmes de cada um, desde que seja maior ou igual a 3.
SELECT genres.name as genero, COUNT(*) AS num_movies
FROM genres LEFT JOIN movies
    ON genres.id = movies.genre_id
GROUP BY genre_id, genero
ORDER BY num_movies DESC;
-- Mostrar apenas o nome e sobrenome dos atores que atuam em todos os filmes de Star Wars e que estes não se repitam.
SELECT DISTINCT actors.first_name, actors.last_name
FROM actor_movie 
INNER JOIN actors
    ON actor_movie.actor_id = actors.id
INNER JOIN movies
    ON actor_movie.movie_id IN (SELECT id FROM movies WHERE title LIKE 'Guerra nas Estrelas%');
