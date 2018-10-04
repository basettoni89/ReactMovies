package com.davidemortara.reactmovie.feature.home.card;

import android.content.Context;
import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.davidemortara.reactmovie.R;
import com.davidemortara.reactmovie.core.model.MovieModel;
import com.davidemortara.reactmvvm.view.BasePresenterView;
import com.davidemortara.reactmvvm.view.BaseViewHolder;

public class PopularCardPresenter extends BasePresenterView<PopularViewModel, PopularCardViewHolder> {

    @Override
    public PopularCardViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.view_popular_card, parent, false);

        return new PopularCardViewHolder(view);
    }
}
