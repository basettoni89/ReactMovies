package com.davidemortara.reactmvvm.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v17.leanback.app.RowsSupportFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidemortara.reactmvvm.viewmodel.IBaseViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseRowsSupportFragmentView<T extends IBaseViewModel> extends RowsSupportFragment {

    protected T viewModel;

    protected T getViewModel() {
        return viewModel;
    }

    protected void setViewModel(T viewModel) {
        this.viewModel = viewModel;
    }

    //region lifecycle

    private CompositeDisposable compositeDisposable;

    @Override
    public void onResume() {
        super.onResume();
        viewModel.activated();
        bind();
    }

    //endregion

    //region rx

    @Override
    public void onPause() {
        super.onPause();
        viewModel.deactivated();
        unbind();
    }

    private void bind() {
        unbind();
        compositeDisposable = new CompositeDisposable();
        registerRules();
    }

    private void unbind() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    protected void register(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    protected abstract void registerRules();
    //endregion

}
