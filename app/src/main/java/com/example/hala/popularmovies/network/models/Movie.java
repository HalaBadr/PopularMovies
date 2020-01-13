package com.example.hala.popularmovies.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("original_title")
    @Expose
    public String original_title;

    @SerializedName("poster_path")
    @Expose
    public String poster;

    @SerializedName("overview")
    @Expose
    public String overview;

    @SerializedName("vote_average")
    @Expose
    public double vote_average;

    @SerializedName("release_date")
    @Expose
    public String release_date;

    @SerializedName("id")
    @Expose
    public int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setOriginal_title(String title) {
        this.original_title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setPoster(String poster_path) {
        this.poster = poster_path;
    }

    public String getPoster() {
        return poster;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOverview() {
        return overview;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRelease_date() {
        return release_date;
    }

}