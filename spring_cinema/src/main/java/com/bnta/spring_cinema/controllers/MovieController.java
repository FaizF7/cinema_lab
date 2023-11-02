package com.bnta.spring_cinema.controllers;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.repositories.MovieRepository;
import com.bnta.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;



    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String message = movieService.saveMovie(movie);
        return new ResponseEntity<>("Movie added",HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        List<Movie> movies = movieService.getAllMovies();
        if(movies.isEmpty()){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @GetMapping(value= "/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable long id){
        Optional<Movie> optionalMovie = movieService.getMoviebyId(id);

        if(optionalMovie.isEmpty()) {
            return new ResponseEntity<>(optionalMovie, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalMovie,HttpStatus.CREATED);
    }

}
