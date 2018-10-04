package com.davidemortara.reactmovie.core.service.movie;

import android.content.Context;
import android.content.res.AssetFileDescriptor;

import com.davidemortara.reactmovie.core.R;
import com.davidemortara.reactmovie.core.model.MovieModel;
import com.google.gson.Gson;
import com.shadowings.simplelocator.SimpleLocator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class StubMovieServiceImpl implements MovieService {

    private final Context context;

    public StubMovieServiceImpl(){
        this.context = SimpleLocator.get(Context.class);
    }

    @Override
    public Observable<List<MovieModel>> getPopularList() {

        InputStreamReader reader = new InputStreamReader(context.getResources().openRawResource(R.raw.movie_popular));
        MovieListResponse response = new Gson().fromJson(reader, MovieListResponse.class);

        return Observable.just(response.getMovies());
    }
}
