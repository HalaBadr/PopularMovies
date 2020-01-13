package com.example.hala.popularmovies.network.api;

import com.example.hala.popularmovies.network.models.Movie;
import com.example.hala.popularmovies.network.models.Movie_Page;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDBInterface {

    @GET( MovieDBAPI.popular_movies)
    Call<Movie_Page> getPopular_Movies(@Query("page") String page_num);

}
