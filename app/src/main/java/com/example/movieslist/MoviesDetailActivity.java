package com.example.movieslist;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.movieslist.model.Movies;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class MoviesDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_detail);

        Intent intent = getIntent();
        Movies movie = (Movies) intent.getSerializableExtra(MovieRecyclerAdapter.EXTRA_MOVIES);
        TextView movieDetailTitle = findViewById(R.id.movie_detail_title);
        TextView movieDetailId = findViewById(R.id.movie_detail_id);
        TextView movieDetailGenres = findViewById(R.id.movie_detail_genres);
        TextView movieDetailYear = findViewById(R.id.movie_detail_year);
        TextView movieDetailRuntime= findViewById(R.id.movie_detail_runtime);
        TextView movieDetailPlot= findViewById(R.id.movie_detail_plot);
        ImageView movieDetailImgs = findViewById(R.id.movie_detail_imgs);

        movieDetailTitle.setText(movie.getTitle());
        movieDetailId.setText(movie.getId());
        movieDetailYear.setText(movie.getYear());
        movieDetailRuntime.setText(movie.getRuntime());
        movieDetailGenres.setText(movie.getGenres().toString());
        movieDetailPlot.setText(movie.getPlot());

        Picasso.Builder builder = new Picasso.Builder(getApplicationContext());
        builder.downloader(new OkHttp3Downloader(getApplicationContext()))
                .build().load(movie.getPosterUrl())
                .placeholder(R.drawable.baseline_image_black_48dp)
                .into(movieDetailImgs);
        }

    public void Launch_movie_recycler(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}