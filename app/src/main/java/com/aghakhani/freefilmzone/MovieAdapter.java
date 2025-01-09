package com.aghakhani.freefilmzone;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final List<MainActivity.Movie> movies;
    private final Context context;

    // Constructor
    // Constructor
    public MovieAdapter(List<MainActivity.Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      //  View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MainActivity.Movie movie = movies.get(position);

        // Set movie details
        holder.textViewTitle.setText(movie.getTitle());
        holder.textViewYear.setText("Year: " + movie.getYear());
        holder.textViewRating.setText("Rating: " + movie.getRating());

        // Load movie poster using Glide
        Glide.with(context)
                .load(movie.getImageUrl())
                .into(holder.imageViewPoster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    // ViewHolder class for MovieAdapter
    static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPoster;
        TextView textViewTitle, textViewYear, textViewRating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewYear = itemView.findViewById(R.id.textViewYear);
            textViewRating = itemView.findViewById(R.id.textViewRating);
        }
    }
}
