package com.bnta.spring_cinema.models;

public class Reply {
    private Movie movie;
    private String message;

    public Reply(Movie movie, String message) {
        this.movie = movie;
        this.message = message;
    }

    public Reply() {
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
