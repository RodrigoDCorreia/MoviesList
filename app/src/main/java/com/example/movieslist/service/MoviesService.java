package com.example.movieslist.service;

import com.example.movieslist.model.MoviesList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesService {
    @GET("db.json")
    Call<MoviesList>getMoviesList();
}
