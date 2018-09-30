package com.davidemortara.reactmovie.core.service.movie;

import com.davidemortara.reactmovie.core.model.MovieModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieServiceImpl implements MovieService {

    private final MovieApi api;

    public MovieServiceImpl(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        api = retrofit.create(MovieApi.class);
    }

    @Override
    public Observable<List<MovieModel>> getPopularList() {
        return api.getPopularList(1, "6cbb0f0e7c486b3b4fa8ed1e2ab3f347", "en")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(MovieListResponse::getMovies);
    }
}
