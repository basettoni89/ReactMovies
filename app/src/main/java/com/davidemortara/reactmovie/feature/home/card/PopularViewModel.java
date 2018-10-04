package com.davidemortara.reactmovie.feature.home.card;

import com.davidemortara.reactmovie.core.model.MovieModel;
import com.davidemortara.reactmvvm.viewmodel.BaseViewModel;

public class PopularViewModel extends BaseViewModel {

    public final MovieModel movie;

    public PopularViewModel(MovieModel movie){
        this.movie = movie;
    }

    @Override
    protected void registerRules() {

    }
}
