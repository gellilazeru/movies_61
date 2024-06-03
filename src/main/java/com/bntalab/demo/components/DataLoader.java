package com.bntalab.demo.components;

import com.bntalab.demo.models.Movie;
import com.bntalab.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        Movie movie1 = new Movie("Titanic", "12A", 180);
        Movie movie2 = new Movie("About Time", "12A", 120);
        Movie movie3 = new Movie("Scream", "18", 180);

        movieService.addMovie(movie1);
        movieService.addMovie(movie2);
        movieService.addMovie(movie3);

    }

}
