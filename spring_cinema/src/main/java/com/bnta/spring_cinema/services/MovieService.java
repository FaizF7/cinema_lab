package com.bnta.spring_cinema.services;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    private Movie movie;

    public MovieService() {
    }

    public Optional<Movie> getMoviebyId(long id){
        return movieRepository.findById(id);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public String saveMovie(Movie movie){
        movieRepository.save(movie);
        return "Movie saved";
    }

    public void updateMovie(long id, Movie newMovie){
        Movie movie = movieRepository.findById(id).get();
        movie.setTitle(newMovie.getTitle());
        movie.setRating(newMovie.getRating());
        movie.setDuration(newMovie.getDuration());
        movieRepository.save(movie);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
