package com.davidemortara.reactmvvm.view;

import android.support.v17.leanback.widget.Presenter;
import android.view.View;

import com.davidemortara.reactmvvm.viewmodel.BaseViewModel;
import com.davidemortara.reactmvvm.viewmodel.IBaseViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseViewHolder<T extends BaseViewModel> extends Presenter.ViewHolder {

    protected T viewModel;

    protected T getViewModel() {
        return viewModel;
    }

    protected void setViewModel(T viewModel) {
        this.viewModel = viewModel;
    }

    public BaseViewHolder(View view) {
        super(view);
    }

    public final void bind(T viewModel){
        setViewModel(viewModel);
        viewModel.activated();

        onBind(viewModel);
    }

    protected abstract void onBind(T viewModel);
}
