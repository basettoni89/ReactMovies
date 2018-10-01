package com.davidemortara.reactmovie.feature.home;

import android.util.Log;

import com.davidemortara.reactmovie.core.model.MovieModel;
import com.davidemortara.reactmovie.core.service.movie.MovieService;
import com.davidemortara.reactmovie.core.service.movie.MovieServiceImpl;
import com.davidemortara.reactmvvm.viewmodel.BaseViewModel;

public class HomeViewModel extends BaseViewModel {

    private MovieService movieService;

    public HomeViewModel(){
        movieService = new MovieServiceImpl();
    }

    @Override
    protected void registerRules() {

        register(movieService.getPopularList()
                .subscribe(
                        (movies) -> {
                            for (MovieModel movie : movies) {
                                Log.d("HomeActivity", movie.getTitle());
                            }
                        }, (error) -> {
                            Log.e("HomeActivity", "Error", error);
                        }));

    }
}
