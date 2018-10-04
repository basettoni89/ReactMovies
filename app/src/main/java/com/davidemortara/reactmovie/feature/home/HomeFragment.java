package com.davidemortara.reactmovie.feature.home;

import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.util.Log;

import com.davidemortara.reactmovie.core.model.MovieModel;
import com.davidemortara.reactmovie.feature.home.card.PopularCardPresenter;
import com.davidemortara.reactmovie.feature.home.card.PopularViewModel;
import com.davidemortara.reactmovie.feature.home.card.WatchedCardPresenter;
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

    private void loadMovie(List<PopularViewModel> movieViewModels) {
        ListRowPresenter rowPresenter = new ListRowPresenter(0, false);

        ArrayObjectAdapter mRowsAdapter = new ArrayObjectAdapter(rowPresenter);

        /* Popular */
        HeaderItem popularPresenterHeader = new HeaderItem(0, "Most popular");

        PopularCardPresenter popularCardPresenter = new PopularCardPresenter();
        ArrayObjectAdapter popularRowAdapter = new ArrayObjectAdapter(popularCardPresenter);

        for (PopularViewModel movieViewModel : movieViewModels) {
            popularRowAdapter.add(movieViewModel);
        }

        mRowsAdapter.add(new ListRow(popularPresenterHeader, popularRowAdapter));

        /* Watched */
        for(int row = 1; row <= 3; row++){
            HeaderItem watchedPresenterHeader = new HeaderItem(row, "Watched " + row);

            WatchedCardPresenter watchedCardPresenter = new WatchedCardPresenter();
            ArrayObjectAdapter watchedRowAdapter = new ArrayObjectAdapter(watchedCardPresenter);

            for (PopularViewModel movieViewModel : movieViewModels) {
                watchedRowAdapter.add(movieViewModel.movie);
            }

            mRowsAdapter.add(new ListRow(watchedPresenterHeader, watchedRowAdapter));
        }

        /* Set */
        setAdapter(mRowsAdapter);
    }
}
