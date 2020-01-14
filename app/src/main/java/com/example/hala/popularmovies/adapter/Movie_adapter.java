package com.example.hala.popularmovies.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hala.popularmovies.R;
import com.example.hala.popularmovies.network.models.Movie;
import com.example.hala.popularmovies.ui.movie_details;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Callback;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

import static java.security.AccessController.getContext;

public class Movie_adapter extends ArrayAdapter<Movie> {

        private static Context context;
        public List<Movie> movies = new ArrayList<>();

    public Movie_adapter(@NonNull Context context, List <Movie> movies) {
        super(context, R.layout.activity_main, movies);
        this.context = context;
        this.movies = movies;
    }

        @Override
        public int getCount () {
        return movies.size();
    }

        @Override
        public Movie getItem ( int i){
        return movies.get(i);
    }

        @Override
        public long getItemId ( int i){
        return 0;
    }

        @Override
        public View getView ( int i, View view, ViewGroup viewGroup){
            Movie product = getItem(i);

        final ProductViewHolder holder;

        if (view == null) {
            view = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(inflater);
            assert vi != null;
            view = vi.inflate(R.layout.movie_item, null, false);
            holder = new ProductViewHolder();
            holder.movie_image = (ImageView) view.findViewById(R.id.movie_image_home);
            view.setTag(holder);

        }

        else {
            holder = (ProductViewHolder) view.getTag();
        }

        holder.populate(product, i);
        return view;
    }

        static class ProductViewHolder {
            public ImageView movie_image;
            final String image_base_url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2";
            void populate(final Movie movie, final int i) {

                movie_image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent go_to_movie_details = new Intent(context , movie_details.class);
                        go_to_movie_details.putExtra("poster"  ,   movie.getPoster());
                        go_to_movie_details.putExtra("overview",   movie.getOverview());
                        go_to_movie_details.putExtra("date"    ,   movie.getRelease_date());
                        go_to_movie_details.putExtra("vote"    ,   movie.getVote_average());
                        go_to_movie_details.putExtra("title"   ,   movie.getOriginal_title());
                        context.startActivity(go_to_movie_details);
                    }
                });

                /*Picasso.get()
                        .load(image_base_url+movie.getPoster())
                        .placeholder(R.drawable.image)
                        .into(movie_image);*/
                Picasso.get().load(Uri.parse(image_base_url+movie.getPoster())).fit().into(movie_image, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });

            }


        }

    }


