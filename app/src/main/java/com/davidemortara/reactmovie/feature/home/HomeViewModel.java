package com.davidemortara.reactmovie.feature.home;

import com.davidemortara.reactmovie.core.model.MovieModel;
import com.davidemortara.reactmovie.core.service.movie.MovieService;
import com.davidemortara.reactmovie.core.service.movie.MovieServiceImpl;
import com.davidemortara.reactmvvm.viewmodel.BaseViewModel;

import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

public class HomeViewModel extends BaseViewModel {

    private MovieService movieService;

    public BehaviorSubject<List<MovieModel>> popularMovies = BehaviorSubject.create();

    public HomeViewModel(){
        movieService = new MovieServiceImpl();
    }

    @Override
    protected void registerRules() {

        register(
                isActive
                    .flatMap(active -> movieService.getPopularList())
                    .subscribe(movieModels -> popularMovies.onNext(movieModels))
        );

    }
}
