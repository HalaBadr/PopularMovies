package com.example.hala.popularmovies.ui;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.hala.popularmovies.R;
import com.example.hala.popularmovies.adapter.Movie_adapter;
import com.example.hala.popularmovies.network.models.Movie;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements gridInterface {

    @BindView(R.id.movie_grid)
    GridView movieGrid;

    Movie_adapter movieAdapter;
    MovieViewModel movie_viewModel;
    List<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        movieAdapter = new Movie_adapter(this,movies);
        movieGrid.setAdapter(movieAdapter);

        //MVVM
        movie_viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        for (int i = 1 ; i <= 500 ; i++){
            String s = i +"";
            movie_viewModel.getPopular_Movies(s);
        }

        movie_viewModel.moviepostmutableLiveData.observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> moviesModels) {
                sowMovies(moviesModels);
                //Toast.makeText(MainActivity.this, "ll"+movies.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void sowMovies(List<Movie> movies) {
        this.movies.addAll(movies);
        movieAdapter.movies.addAll(movies);
        movieAdapter.notifyDataSetChanged();

    }
}
