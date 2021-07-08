package com.example.movieslist.model;

import java.util.List;

public class MoviesList {
    private List<Movies> movies;

    public MoviesList(List<Movies> movies) {
        this.movies = movies;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "MoviesList{" +
                "movies=" + movies +
                '}';
    }
}
