package com.davidemortara.reactmovie;

import android.app.Application;

import com.davidemortara.reactmovie.core.CoreModule;

public class ReactMovieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CoreModule.register();
    }
}
