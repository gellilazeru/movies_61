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
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getAllMovies(@PathVariable long id){
        Optional<Movie> movie = movieService.getMovieById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }


}
