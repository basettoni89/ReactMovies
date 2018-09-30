package com.davidemortara.reactmovie.core.service.movie;

import com.davidemortara.reactmovie.core.model.MovieModel;
import com.shadowings.simplelocator.SimpleLocator;

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

    private MovieApi api;

    public MovieServiceImpl(){
        initialize(SimpleLocator.get(Retrofit.class));
    }

    private void initialize(Retrofit retrofit){
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
