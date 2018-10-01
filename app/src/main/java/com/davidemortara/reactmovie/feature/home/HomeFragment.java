package com.davidemortara.reactmovie.feature.home;

import com.davidemortara.reactmovie.R;
import com.davidemortara.reactmvvm.view.BaseFragmentView;

public class HomeFragment extends BaseFragmentView<HomeViewModel> {

    public static HomeFragment newInstance(HomeViewModel viewModel){
        HomeFragment fragment = new HomeFragment();
        fragment.setViewModel(viewModel);

        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void registerRules() {

    }
}
