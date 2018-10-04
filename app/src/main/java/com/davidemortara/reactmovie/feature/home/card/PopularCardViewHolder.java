package com.davidemortara.reactmovie.feature.home.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.davidemortara.reactmovie.R;
import com.davidemortara.reactmvvm.view.BaseViewHolder;

public class PopularCardViewHolder extends BaseViewHolder<PopularViewModel> {

    private final ImageView image;
    private final TextView title;
    private final TextView description;

    public PopularCardViewHolder(View view) {
        super(view);

        image = view.findViewById(R.id.movie_image);
        title = view.findViewById(R.id.movie_title);
        description = view.findViewById(R.id.movie_description);
    }

    @Override
    protected void onBind(PopularViewModel viewModel) {
        title.setText(viewModel.movie.getTitle());
        description.setText(viewModel.movie.getOverview());

        Glide.with(view.getContext())
                .load("http://image.tmdb.org/t/p/w342" + viewModel.movie.getBackdropPath())
                .apply(RequestOptions.centerCropTransform())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(image);
    }
}
