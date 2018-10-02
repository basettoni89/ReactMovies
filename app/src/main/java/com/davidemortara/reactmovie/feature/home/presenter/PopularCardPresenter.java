package com.davidemortara.reactmovie.feature.home.presenter;

import android.content.Context;
import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.davidemortara.reactmvvm.R;

import com.davidemortara.reactmovie.core.model.MovieModel;

public class PopularCardPresenter extends Presenter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.view_popular_card, parent, false);

        return new PopularCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        if(item instanceof MovieModel){
            if(viewHolder instanceof PopularCardViewHolder){
                ((PopularCardViewHolder)viewHolder).bind((MovieModel) item);
            }
        }
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    private class PopularCardViewHolder extends ViewHolder{

        private final ImageView image;
        private final TextView title;
        private final TextView description;

        public PopularCardViewHolder(View view) {
            super(view);

            image = view.findViewById(R.id.movie_image);
            title = view.findViewById(R.id.movie_title);
            description = view.findViewById(R.id.movie_description);
        }

        public void bind(MovieModel movie){
            title.setText(movie.getTitle());
            description.setText(movie.getOverview());
        }
    }
}
