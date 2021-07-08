package com.example.movieslist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieslist.model.Movies;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder> {
    Context context;
    List<Movies> moviesList;
    public static final String EXTRA_MOVIES = "EXTRA_MOVIES";

    public MovieRecyclerAdapter(Context context, List<Movies> moviesList) {
        this.context = context;
        this.moviesList = moviesList;
    }

    public void setMoviesList(List<Movies> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieRecyclerAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_recyclerview_layout,parent,false);
        return new MovieViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movies movie = moviesList.get(position);
        holder.movieName.setText(movie.getTitle());
        holder.movieId.setText(movie.getId());
        holder.movieGenres.setText(movie.getGenres().toString());
        holder.movieDirector.setText(movie.getDirector());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context))
                .build().load(movie.getPosterUrl())
                .placeholder(R.drawable.baseline_image_black_48dp)
                .into(holder.movieImage);



    }

    @Override
    public int getItemCount() {
        if (moviesList != null) {
            return moviesList.size();
        }
        return 0;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView movieName;
        TextView movieId;
        TextView movieGenres;
        TextView movieDirector;
        ImageView movieImage;


        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieName = itemView.findViewById(R.id.movie_name);
            movieId = itemView.findViewById(R.id.movie_id);
            movieGenres = itemView.findViewById(R.id.movie_genres);
            movieDirector = itemView.findViewById(R.id.movie_director);
            movieImage = itemView.findViewById(R.id.movie_detail_img);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, MoviesDetailActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(EXTRA_MOVIES, moviesList.get(position));
            context.startActivity(intent);

        }
    }
}
