package com.davidemortara.reactmovie.core.service.movie;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("3/movie/popular")
    Observable<MovieListResponse> getPopularList(
            @Query("page")int page,
            @Query("api_key") String apiKey,
            @Query("language") String lang);

    @GET("3/movie/top_rated")
    Observable<MovieListResponse> getTopRatedList(
            @Query("page")int page,
            @Query("api_key") String apiKey,
            @Query("language") String lang);

}
