package com.davidemortara.reactmovie.feature.home.card.toprated;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidemortara.reactmovie.R;
import com.davidemortara.reactmvvm.view.BasePresenterView;

public class TopRatedCardPresenter extends BasePresenterView<TopRatedViewModel, TopRatedCardViewHolder> {
    @Override
    public TopRatedCardViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.view_watched_card, parent, false);

        return new TopRatedCardViewHolder(view);
    }
}
