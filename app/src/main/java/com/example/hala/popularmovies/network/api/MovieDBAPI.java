package com.example.hala.popularmovies.network.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDBAPI {


    public  static Retrofit retrofit = null;
    public static final String Base_url         =   "https://api.themoviedb.org/3/";
    public static final String api_key          =   "e1e34c80b3bf7742f07ffce0f5213a15";
    public static final String popular_movies   =   Base_url +"movie/popular?api_key="+api_key+"&language=en-US";


    public static Retrofit getClient(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Base_url)
                    .build();
        }
        return retrofit;
    }



}
