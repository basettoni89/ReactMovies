package com.davidemortara.reactmovie.feature.home;

import com.davidemortara.reactmovie.core.model.MovieModel;
import com.davidemortara.reactmovie.core.service.movie.MovieService;
import com.davidemortara.reactmovie.feature.home.card.popular.PopularViewModel;
import com.davidemortara.reactmovie.feature.home.card.toprated.TopRatedViewModel;
import com.davidemortara.reactmvvm.viewmodel.BaseViewModel;
import com.shadowings.simplelocator.SimpleLocator;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

public class HomeViewModel extends BaseViewModel {

    private MovieService movieService;

    public BehaviorSubject<List<PopularViewModel>> popularMovies = BehaviorSubject.create();

    public BehaviorSubject<List<TopRatedViewModel>> topRatedMovies = BehaviorSubject.create();

    public HomeViewModel(){
        movieService = SimpleLocator.get(MovieService.class);
    }

    @Override
    protected void registerRules() {

        register(
                isActive
                    .flatMap(active -> movieService.getPopularList())
                    .subscribe(movieModels -> {
                        List<PopularViewModel> popularViewModels = new ArrayList<>();
                        for (MovieModel movie : movieModels) {
                            popularViewModels.add(new PopularViewModel(movie));
                        }
                        popularMovies.onNext(popularViewModels);
                    })
        );

        register(
                isActive
                        .flatMap(active -> movieService.getTopRatedList())
                        .subscribe(movieModels -> {
                            List<TopRatedViewModel> topRatedViewModels = new ArrayList<>();
                            for (MovieModel movie : movieModels) {
                                topRatedViewModels.add(new TopRatedViewModel(movie));
                            }
                            topRatedMovies.onNext(topRatedViewModels);
                        })
        );
    }
}
