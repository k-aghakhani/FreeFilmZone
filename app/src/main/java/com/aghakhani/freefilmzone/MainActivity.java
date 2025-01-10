package com.aghakhani.freefilmzone;

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

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPagerSlider;
    private RecyclerView recyclerCategories, recyclerMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // تنظیم Toolbar
        setSupportActionBar(findViewById(R.id.toolbar));

        // اتصال View ها
        viewPagerSlider = findViewById(R.id.viewPagerSlider);
        recyclerCategories = findViewById(R.id.recyclerCategories);
        recyclerMovies = findViewById(R.id.recyclerMovies);

        // اسلایدر
        setupSlider();

        // لیست دسته‌بندی‌ها
        setupCategories();

        // لیست فیلم‌ها
        setupMovies();

        // مدیریت Padding برای System Bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setupSlider() {
        List<String> sliderImages = new ArrayList<>();
        sliderImages.add("https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg");
        sliderImages.add("https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg");
        sliderImages.add("https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg");

        SliderAdapter sliderAdapter = new SliderAdapter(sliderImages, this);
        viewPagerSlider.setAdapter(sliderAdapter);
    }

    private void setupCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Action");
        categories.add("Comedy");
        categories.add("Drama");
        categories.add("Horror");

        recyclerCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
        recyclerCategories.setAdapter(categoryAdapter);
    }

    private void setupMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Movie 1", "2023", "8.5", "https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg"));
        movies.add(new Movie("Movie 2", "2022", "7.5", "https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg"));
        movies.add(new Movie("Movie 3", "2021", "9.0", "https://img.freepik.com/free-vector/cinema-realistic-poster-with-illuminated-bucket-popcorn-drink-3d-glasses-reel-tickets-blue-background-with-tapes-vector-illustration_1284-77070.jpg"));

        recyclerMovies.setLayoutManager(new LinearLayoutManager(this));
        MovieAdapter movieAdapter = new MovieAdapter(movies,this);
        recyclerMovies.setAdapter(movieAdapter);
    }

    // مدل Movie
    public static class Movie {
        String title;
        String year;
        String rating;
        String imageUrl;

        public Movie(String title, String year, String rating, String imageUrl) {
            this.title = title;
            this.year = year;
            this.rating = rating;
            this.imageUrl = imageUrl;
        }

        // Getters
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
