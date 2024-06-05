package com.bntalab.demo.controllers;

import com.bntalab.demo.models.Movie;
import com.bntalab.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")

public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping(value = "/movies")
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(required = false) Integer maxDuration) {
        List<Movie> movies;
        if (maxDuration == null) {
            movies = movieService.getAllMovies();
        } else {
            movies = movieService.filterMoviesByDuration(maxDuration);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }


}
