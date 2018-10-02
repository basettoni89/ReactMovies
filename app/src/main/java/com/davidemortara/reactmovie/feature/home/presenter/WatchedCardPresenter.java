package com.davidemortara.reactmovie.feature.home.presenter;

import android.content.Context;
import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.davidemortara.reactmovie.R;
import com.davidemortara.reactmovie.core.model.MovieModel;

public class WatchedCardPresenter extends Presenter {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.view_watched_card, parent, false);

        return new WatchedCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        if(item instanceof MovieModel){
            if(viewHolder instanceof WatchedCardViewHolder){
                ((WatchedCardViewHolder)viewHolder).bind((MovieModel) item);
            }
        }

    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    private class WatchedCardViewHolder extends ViewHolder{

        private final ImageView image;
        private final TextView title;

        public WatchedCardViewHolder(View view) {
            super(view);

            image = view.findViewById(R.id.movie_image);
            title = view.findViewById(R.id.movie_title);
        }

        public void bind(MovieModel movie){
            title.setText(movie.getTitle());
        }
    }
}
