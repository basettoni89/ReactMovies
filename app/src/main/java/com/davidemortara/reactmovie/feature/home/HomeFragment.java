package com.davidemortara.reactmovie.feature.home;

import android.os.Bundle;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.util.Log;

import com.davidemortara.reactmovie.feature.home.card.popular.PopularCardPresenter;
import com.davidemortara.reactmovie.feature.home.card.popular.PopularViewModel;
import com.davidemortara.reactmovie.feature.home.card.toprated.TopRatedCardPresenter;
import com.davidemortara.reactmovie.feature.home.card.toprated.TopRatedViewModel;
import com.davidemortara.reactmvvm.view.BaseRowsSupportFragmentView;

import java.util.List;

public class HomeFragment extends BaseRowsSupportFragmentView<HomeViewModel> {

    private ArrayObjectAdapter rowsAdapter;

    public static HomeFragment newInstance(HomeViewModel viewModel){
        HomeFragment fragment = new HomeFragment();
        fragment.setViewModel(viewModel);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HomeListRowPresenter rowPresenter = new HomeListRowPresenter(0, false);
        rowsAdapter = new ArrayObjectAdapter(rowPresenter);

        setAdapter(rowsAdapter);
    }

    @Override
    protected void registerRules() {

        register(viewModel.popularMovies.subscribe(
                this::loadPopularMovie, (error) -> Log.e("HomeFragment", "Error", error)));

        register(viewModel.topRatedMovies.subscribe(
                this::loadTopRatedMovie, (error) -> Log.e("HomeFragment", "Error", error)));

    }

    private void loadPopularMovie(List<PopularViewModel> movieViewModels) {
        HeaderItem popularPresenterHeader = new HeaderItem(0, "Most popular");

        PopularCardPresenter popularCardPresenter = new PopularCardPresenter();
        ArrayObjectAdapter popularRowAdapter = new ArrayObjectAdapter(popularCardPresenter);

        for (PopularViewModel movieViewModel : movieViewModels) {
            popularRowAdapter.add(movieViewModel);
        }

        rowsAdapter.add(new ListRow(popularPresenterHeader, popularRowAdapter));
    }

    private void loadTopRatedMovie(List<TopRatedViewModel> topRatedViewModels) {
        HeaderItem watchedPresenterHeader = new HeaderItem(1, "Top rated");

        TopRatedCardPresenter topRatedCardPresenter = new TopRatedCardPresenter();
        ArrayObjectAdapter topRatedRowAdapter = new ArrayObjectAdapter(topRatedCardPresenter);

        for (TopRatedViewModel movieViewModel : topRatedViewModels) {
            topRatedRowAdapter.add(movieViewModel);
        }

        rowsAdapter.add(new ListRow(watchedPresenterHeader, topRatedRowAdapter));
    }
}
