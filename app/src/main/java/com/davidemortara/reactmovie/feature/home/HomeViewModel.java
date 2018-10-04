package com.davidemortara.reactmovie.feature.home;

import com.davidemortara.reactmovie.core.model.MovieModel;
import com.davidemortara.reactmovie.core.service.movie.MovieService;
import com.davidemortara.reactmovie.core.service.movie.MovieServiceImpl;
import com.davidemortara.reactmovie.feature.home.card.PopularViewModel;
import com.davidemortara.reactmvvm.viewmodel.BaseViewModel;
import com.shadowings.simplelocator.SimpleLocator;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.BehaviorSubject;

public class HomeViewModel extends BaseViewModel {

    private MovieService movieService;

    public BehaviorSubject<List<PopularViewModel>> popularMovies = BehaviorSubject.create();

    public HomeViewModel(){
        movieService = SimpleLocator.get(MovieService.class);
    }

    @Override
    protected void registerRules() {

        register(
                isActive
                    .flatMap(active -> movieService.getPopularList())
                    .subscribe(movieModels -> {
                        List<PopularViewModel> viewModels = new ArrayList<>();
                        for (MovieModel movie : movieModels) {
                            viewModels.add(new PopularViewModel(movie));
                        }
                        popularMovies.onNext(viewModels);
                    })
        );

    }
}
