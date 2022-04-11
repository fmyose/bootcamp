package com.example.mod6a3pi4;

import com.example.mod6a3pi4.model.Actor;
import com.example.mod6a3pi4.model.Genre;
import com.example.mod6a3pi4.model.Movie;
import com.example.mod6a3pi4.service.ActorService;
import com.example.mod6a3pi4.service.GenreService;
import com.example.mod6a3pi4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Mod6A3Pi4Application implements CommandLineRunner {

    @Autowired
	ActorService actorService;
    @Autowired
	GenreService genreService;
    @Autowired
	MovieService movieService;

	public static void main(String[] args) {
		SpringApplication.run(Mod6A3Pi4Application.class, args);
	}

	// Overriding the CommandLineRunner to make easier testing
	@Override
	public void run(String... args) throws Exception {
		System.out.println("teste");
		Genre genre1 = Genre.builder().name("genre1").active(1).ranking(4).build();
		Genre genre2 = Genre.builder().name("genre2").active(1).ranking(4).build();
		genreService.save(genre1);
		genreService.save(genre2);

		Actor actor1 = Actor.builder().first_name("Name1").last_name("Surname1").rating(1).build();
		Actor actor2 = Actor.builder().first_name("Name2").last_name("Surname2").rating(2).build();
		Actor actor3 = Actor.builder().first_name("Name3").last_name("Surname3").rating(3).build();
		Actor actor4 = Actor.builder().first_name("Name4").last_name("Surname4").rating(4).build();
		actorService.save(actor1);
		actorService.save(actor2);
		actorService.save(actor3);
		actorService.save(actor4);

		Set<Actor> actorsSet1 = new HashSet<>(Arrays.asList(actor1, actor2));
		Set<Actor> actorsSet2 = new HashSet<>(Arrays.asList(actor1, actor2, actor3, actor4));
		Movie movie1 = Movie.builder().title("Movie1").awards(1).genre(genre1).actors(actorsSet1).length(100).build();
		Movie movie2 = Movie.builder().title("Movie2").awards(2).genre(genre2).actors(actorsSet2).length(200).build();
		movieService.save(movie1);
		movieService.save(movie2);

		// update actor favorite movie
		Actor a = actorService.findById(3L);
		a.setFavoritemovie(movie1);
		actorService.save(a);
		System.out.println("items saved");
	}
}
