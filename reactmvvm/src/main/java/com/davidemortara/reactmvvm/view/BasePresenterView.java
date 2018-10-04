package com.davidemortara.reactmvvm.view;

import android.support.v17.leanback.widget.Presenter;
import android.view.ViewGroup;

import com.davidemortara.reactmvvm.viewmodel.BaseViewModel;

public abstract class BasePresenterView<TViewModel extends BaseViewModel, TViewHolder extends BaseViewHolder<TViewModel>> extends Presenter {

    @Override
    public abstract TViewHolder onCreateViewHolder(ViewGroup parent);

    @Override
    public final void onBindViewHolder(ViewHolder viewHolder, Object item) {
        ((TViewHolder)viewHolder).bind((TViewModel) item);
    }

    @Override
    public final void onUnbindViewHolder(ViewHolder viewHolder) {
    }
}
