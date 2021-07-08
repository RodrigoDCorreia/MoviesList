package com.example.movieslist.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesApiClient {
    public static final String BASE_URL ="https://raw.githubusercontent.com/erik-sytnyk/movies-list/master/";
    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
