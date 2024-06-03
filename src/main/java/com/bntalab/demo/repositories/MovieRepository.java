package com.bntalab.demo.repositories;

import com.bntalab.demo.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}