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

        /* GridItemPresenter */
        HeaderItem gridItemPresenterHeader = new HeaderItem(0, "Most popular");

        PopularCardPresenter cardPresenter = new PopularCardPresenter();
        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(cardPresenter);

        for (MovieModel movie : movies) {
            gridRowAdapter.add(movie);
        }

        mRowsAdapter.add(new ListRow(gridItemPresenterHeader, gridRowAdapter));

        /* Set */
        setAdapter(mRowsAdapter);
    }
}
