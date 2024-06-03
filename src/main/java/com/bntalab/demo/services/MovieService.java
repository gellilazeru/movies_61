package com.bntalab.demo.services;

import com.bntalab.demo.controllers.MovieController;
import com.bntalab.demo.models.Movie;
import com.bntalab.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }


    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
}


