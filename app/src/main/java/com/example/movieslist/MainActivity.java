package com.example.movieslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.movieslist.model.MoviesList;
import com.example.movieslist.service.MoviesApiClient;
import com.example.movieslist.service.MoviesService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private MoviesList moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moviesList = new MoviesList(new ArrayList<>());

        RecyclerView recyclerView = findViewById(R.id.movie_recyclerView);
        MovieRecyclerAdapter recyclerAdapter = new MovieRecyclerAdapter(getApplicationContext(),moviesList.getMovies());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);

        MoviesService service = MoviesApiClient.getClient().create(MoviesService.class);
        Call<MoviesList> call = service.getMoviesList();
        call.enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                moviesList = response.body();
                Log.d(TAG, "onResponse: " + moviesList);
                recyclerAdapter.setMoviesList(moviesList.getMovies());
            }

            @Override
            public void onFailure(Call<MoviesList> call, Throwable t) {
                Log.e(TAG, "onFailure: " + toString(),t );
            }
        });
    }
}