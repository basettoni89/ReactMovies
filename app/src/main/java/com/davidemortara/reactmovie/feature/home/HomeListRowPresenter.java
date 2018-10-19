package com.davidemortara.reactmovie.feature.home;

import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.RowPresenter;
import android.view.ViewGroup;

public class HomeListRowPresenter extends ListRowPresenter {

    public HomeListRowPresenter(int focusZoomFactor, boolean useFocusDimmer){
        super(focusZoomFactor, useFocusDimmer);
    }

    @Override
    protected ViewHolder createRowViewHolder(ViewGroup parent) {
        ViewHolder vh = (ViewHolder) super.createRowViewHolder(parent);

        vh.getGridView().setHorizontalSpacing(45);

        return vh;
    }
}
