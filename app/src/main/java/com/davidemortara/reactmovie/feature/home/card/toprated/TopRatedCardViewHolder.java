package com.davidemortara.reactmovie.feature.home.card.toprated;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.davidemortara.reactmovie.R;
import com.davidemortara.reactmvvm.view.BaseViewHolder;

public class TopRatedCardViewHolder extends BaseViewHolder<TopRatedViewModel> {

    private final ImageView image;
    private final TextView title;

    public TopRatedCardViewHolder(View view) {
        super(view);

        image = view.findViewById(R.id.movie_image);
        title = view.findViewById(R.id.movie_title);
    }

    @Override
    protected void onBind(TopRatedViewModel viewModel){
        title.setText(viewModel.movie.getTitle());

        Glide.with(view.getContext())
                .load("http://image.tmdb.org/t/p/w342" + viewModel.movie.getBackdropPath())
                .apply(RequestOptions.centerCropTransform())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(image);
    }
}