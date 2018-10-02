package com.davidemortara.reactmovie.feature.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.Presenter;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidemortara.reactmovie.R;
import com.davidemortara.reactmovie.core.model.MovieModel;
import com.davidemortara.reactmovie.feature.home.presenter.PopularCardPresenter;
import com.davidemortara.reactmovie.feature.home.presenter.WatchedCardPresenter;
import com.davidemortara.reactmvvm.view.BaseFragmentView;
import com.davidemortara.reactmvvm.view.BaseRowsSupportFragmentView;

import java.util.List;

public class HomeFragment extends BaseRowsSupportFragmentView<HomeViewModel> {

    private static final int GRID_ITEM_WIDTH = 1700;
    private static final int GRID_ITEM_HEIGHT = 800;

    public static HomeFragment newInstance(HomeViewModel viewModel){
        HomeFragment fragment = new HomeFragment();
        fragment.setViewModel(viewModel);

        return fragment;
    }

    @Override
    protected void registerRules() {

        register(viewModel.popularMovies.subscribe(
                this::loadMovie, (error) -> Log.e("HomeActivity", "Error", error)));

    }

    private void loadMovie(List<MovieModel> movies) {
        ArrayObjectAdapter mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        /* Popular */
        HeaderItem popularPresenterHeader = new HeaderItem(0, "Most popular");

        PopularCardPresenter popularCardPresenter = new PopularCardPresenter();
        ArrayObjectAdapter popularRowAdapter = new ArrayObjectAdapter(popularCardPresenter);

        for (MovieModel movie : movies) {
            popularRowAdapter.add(movie);
        }

        mRowsAdapter.add(new ListRow(popularPresenterHeader, popularRowAdapter));

        /* Watched */
        for(int row = 1; row <= 3; row++){
            HeaderItem watchedPresenterHeader = new HeaderItem(row, "Watched " + row);

            WatchedCardPresenter watchedCardPresenter = new WatchedCardPresenter();
            ArrayObjectAdapter watchedRowAdapter = new ArrayObjectAdapter(watchedCardPresenter);

            for (MovieModel movie : movies) {
                watchedRowAdapter.add(movie);
            }

            mRowsAdapter.add(new ListRow(watchedPresenterHeader, watchedRowAdapter));
        }

        /* Set */
        setAdapter(mRowsAdapter);
    }
}
