package com.davidemortara.reactmovie.core.service.movie;

import com.davidemortara.reactmovie.core.model.MovieModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieListResponse {
    private long page;
    private long totalResults;
    private long totalPages;

    @SerializedName("results")
    private List<MovieModel> movies;

    public long getPage() { return page; }
    public void setPage(long value) { this.page = value; }

    public long getTotalResults() { return totalResults; }
    public void setTotalResults(long value) { this.totalResults = value; }

    public long getTotalPages() { return totalPages; }
    public void setTotalPages(long value) { this.totalPages = value; }

    public List<MovieModel> getMovies() { return movies; }
    public void setMovies(List<MovieModel> movies) { this.movies = movies; }
}
