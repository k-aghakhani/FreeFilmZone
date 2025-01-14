// Package declaration
package com.aghakhani.freefilmzone;

// Import necessary Android and AndroidX libraries
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.graphics.Insets;

import java.util.ArrayList;
import java.util.List;

// MainActivity class extending AppCompatActivity
public class MainActivity extends AppCompatActivity {
    // Declare ViewPager2 for the slider and RecyclerViews for categories and movies
    private ViewPager2 viewPagerSlider;
    private RecyclerView recyclerCategories, recyclerMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for this activity
        setContentView(R.layout.activity_main);

        // Set up the toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        // Initialize views by finding them by their IDs
        viewPagerSlider = findViewById(R.id.viewPagerSlider);
        recyclerCategories = findViewById(R.id.recyclerCategories);
        recyclerMovies = findViewById(R.id.recyclerMovies);

        // Set up the image slider
        setupSlider();

        // Set up the categories list
        setupCategories();

        // Set up the movies list
        setupMovies();

        // Manage padding for system bars (status bar, navigation bar, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Method to set up the image slider
    private void setupSlider() {
        // Create a list of image URLs for the slider
        List<String> sliderImages = new ArrayList<>();
        sliderImages.add("https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg");
        sliderImages.add("https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg");
        sliderImages.add("https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg");

        // Create a SliderAdapter and set it to the ViewPager2
        SliderAdapter sliderAdapter = new SliderAdapter(sliderImages, this);
        viewPagerSlider.setAdapter(sliderAdapter);
    }

    // Method to set up the categories list
    private void setupCategories() {
        // Create a list of categories
        List<String> categories = new ArrayList<>();
        categories.add("Action");
        categories.add("Comedy");
        categories.add("Drama");
        categories.add("Horror");

        // Set up a horizontal LinearLayoutManager for the RecyclerView
        recyclerCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        // Create a CategoryAdapter and set it to the RecyclerView
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
        recyclerCategories.setAdapter(categoryAdapter);
    }

    // Method to set up the movies list
    private void setupMovies() {
        // Create a list of Movie objects
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie 1", "2023", "8.5", "https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg"));
        movies.add(new Movie("Movie 2", "2022", "7.5", "https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg"));
        movies.add(new Movie("Movie 3", "2021", "9.0", "https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg"));

        // Set up a vertical LinearLayoutManager for the RecyclerView
        recyclerMovies.setLayoutManager(new LinearLayoutManager(this));
        // Create a MovieAdapter and set it to the RecyclerView
        MovieAdapter movieAdapter = new MovieAdapter(movies, this);
        recyclerMovies.setAdapter(movieAdapter);
    }

    // Movie model class
    public static class Movie {
        // Declare fields for movie title, year, rating, and image URL
        String title;
        String year;
        String rating;
        String imageUrl;

        // Constructor to initialize the Movie object
        public Movie(String title, String year, String rating, String imageUrl) {
            this.title = title;
            this.year = year;
            this.rating = rating;
            this.imageUrl = imageUrl;
        }

        // Getter methods for the Movie fields
        public String getTitle() {
            return title;
        }

        public String getYear() {
            return year;
        }

        public String getRating() {
            return rating;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }
}