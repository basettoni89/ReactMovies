package com.davidemortara.reactmovie.feature.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.davidemortara.reactmovie.R;
import com.davidemortara.reactmovie.feature.home.HomeFragment;
import com.davidemortara.reactmovie.feature.home.HomeViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment homeFragment = HomeFragment.newInstance(new HomeViewModel());
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, homeFragment).commit();
    }
}
