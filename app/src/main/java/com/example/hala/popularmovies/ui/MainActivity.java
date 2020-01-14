package com.example.hala.popularmovies.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.GridView;

import com.example.hala.popularmovies.R;
import com.example.hala.popularmovies.ViewModel.MovieViewModel;
import com.example.hala.popularmovies.adapter.Movie_adapter;
import com.example.hala.popularmovies.network.models.Movie;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements gridInterface {

    @BindView(R.id.movie_grid)
    GridView movieGrid;

    Movie_adapter movieAdapter;
    MovieViewModel movie_viewModel;
    List<Movie> movies = new ArrayList<>();
    Unbinder unbind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbind = ButterKnife.bind(this);

        //MVVM
        movie_viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movie_viewModel.getPopular_Movies();

        movieAdapter = new Movie_adapter(this,movies);
        movieGrid.setAdapter(movieAdapter);

        movie_viewModel.moviepostmutableLiveData.observe(this, moviesModels -> {
            sowMovies(moviesModels);
            //Toast.makeText(MainActivity.this , "ll"+movies.size(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void sowMovies(List<Movie> movies) {
        movieAdapter.movies=movies;
        movieAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroy() {
        //unbind.unbind();
        super.onDestroy();
    }

}
