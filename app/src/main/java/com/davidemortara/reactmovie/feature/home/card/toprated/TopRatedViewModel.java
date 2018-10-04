package com.davidemortara.reactmovie.feature.home.card.toprated;

import com.davidemortara.reactmovie.core.model.MovieModel;
import com.davidemortara.reactmvvm.viewmodel.BaseViewModel;

public class TopRatedViewModel extends BaseViewModel {

    public final MovieModel movie;

    public TopRatedViewModel(MovieModel movie){
        this.movie = movie;
    }

    @Override
    protected void registerRules() {

    }
}
