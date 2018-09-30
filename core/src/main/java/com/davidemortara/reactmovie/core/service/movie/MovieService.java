package com.davidemortara.reactmovie.core.service.movie;

import com.davidemortara.reactmovie.core.model.MovieModel;

import java.util.List;

import io.reactivex.Observable;

public interface MovieService {

    Observable<List<MovieModel>> getPopularList();

}
