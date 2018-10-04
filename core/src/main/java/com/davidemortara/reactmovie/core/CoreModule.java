package com.davidemortara.reactmovie.core;

import com.davidemortara.reactmovie.core.service.movie.MovieService;
import com.davidemortara.reactmovie.core.service.movie.MovieServiceImpl;
import com.davidemortara.reactmovie.core.service.movie.StubMovieServiceImpl;
import com.shadowings.simplelocator.SimpleLocator;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoreModule {

    public static void register(){

        SimpleLocator.register(
                Retrofit.class,
                () ->{
                    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
                    logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

                    OkHttpClient client = new OkHttpClient.Builder()
                            .addInterceptor(logging)
                            .build();

                    return new Retrofit.Builder()
                            .baseUrl("https://api.themoviedb.org/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(client)
                            .build();
                });

        SimpleLocator.register(MovieService.class, MovieServiceImpl::new);
    }

    public static void registerStub(){

        register();

        SimpleLocator.register(MovieService.class, StubMovieServiceImpl::new);
    }
}
