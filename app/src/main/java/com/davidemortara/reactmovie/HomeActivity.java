package com.davidemortara.reactmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.davidemortara.reactmovie.core.model.MovieModel;
import com.davidemortara.reactmovie.core.service.movie.MovieService;
import com.davidemortara.reactmovie.core.service.movie.MovieServiceImpl;

import io.reactivex.disposables.CompositeDisposable;

public class HomeActivity extends AppCompatActivity {

    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MovieService movieService = new MovieServiceImpl();
        disposable.add(movieService.getPopularList()
                .subscribe(
                    (movies) -> {
                        for (MovieModel movie : movies) {
                            Log.d("HomeActivity", movie.getTitle());
                        }
                    }, (error) -> {
                        Log.e("HomeActivity", "Error", error);
                    }));
    }
}
