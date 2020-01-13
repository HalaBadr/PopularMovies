package com.example.hala.popularmovies.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie_Page {
    @SerializedName("results")
    @Expose
    List<Movie> results = new ArrayList<>();

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}



