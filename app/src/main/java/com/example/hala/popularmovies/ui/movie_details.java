package com.example.hala.popularmovies.ui;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.hala.popularmovies.R;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class movie_details extends AppCompatActivity {

    @BindView(R.id.movie_image_detail)
    AppCompatImageView movieImageDetail;
    @BindView(R.id.original_title)
    TextView originalTitle;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.over_view)
    TextView overView;
    @BindView(R.id.vote)
    RatingBar vote;
    @BindView(R.id.vote_text)
    TextView vote_text;

    final String image_base_url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
    String Image , Overview , Date , Title ;
    double Vote = 0 ;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);
        ButterKnife.bind(this);

        bundle = getIntent().getExtras();

        if (bundle != null) {
            if (bundle.get("poster") != null){
                Image = bundle.get("poster").toString();}
            if (bundle.get("overview") != null){
                Overview = bundle.get("overview").toString();}
            if (bundle.get("date") != null){
                Date = bundle.get("date").toString();}
            if (bundle.get("vote") != null){
                Vote = (double) bundle.get("vote")*10;}
            if (bundle.get("title") != null){
                Title = bundle.get("title").toString();}
        }

        Picasso.get()
                .load(image_base_url+Image)
                .placeholder(R.drawable.image)
                .into(movieImageDetail);

        overView.setText(Overview);
        date.setText(Date);
        vote_text.setText(String.valueOf((int) Vote/10));
        originalTitle.setText(Title);
       // vote.setNumStars((int) Vote/2);
        vote.setRating((float)Vote/20);
        vote.getRating();

    }
}
