package com.davidemortara.reactmovie;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetFileDescriptor;

import com.davidemortara.reactmovie.core.CoreModule;
import com.shadowings.simplelocator.SimpleLocator;

public class ReactMovieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        register();
    }

    private void register(){

        SimpleLocator.register(Context.class, this::getApplicationContext);
        CoreModule.registerStub();

    }
}
