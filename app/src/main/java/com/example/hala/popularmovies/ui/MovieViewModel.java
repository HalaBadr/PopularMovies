package com.example.hala.popularmovies.ui;

import com.example.hala.popularmovies.network.api.MovieDBAPI;
import com.example.hala.popularmovies.network.api.MovieDBInterface;
import com.example.hala.popularmovies.network.models.Movie;
import com.example.hala.popularmovies.network.models.Movie_Page;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    public MutableLiveData<List<Movie>> moviepostmutableLiveData = new MutableLiveData<>();


    public void getPopular_Movies(String i ) {
        MovieDBInterface apiInterface = MovieDBAPI.getClient().create(MovieDBInterface.class);
        //for (int i = 1; i <= 500; i++){
            apiInterface.getPopular_Movies(i).enqueue(new Callback<Movie_Page>() {
                @Override
                public void onResponse(Call<Movie_Page> call, Response<Movie_Page> response) {
                    moviepostmutableLiveData.setValue(response.body().getResults());
                }

                @Override
                public void onFailure(Call<Movie_Page> call, Throwable t) {
                    System.out.println("there is error : " + t);
                }
            });
        //}
    }
}
