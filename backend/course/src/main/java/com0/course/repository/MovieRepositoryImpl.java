package com0.course.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    List<Map<String, Object>> movieList = new ArrayList<>();

    public MovieRepositoryImpl() {
        this.populateMovieList();
    }

    private void populateMovieList() {

        for (int i = 0; i < 10; i++) {
            Map<String, Object> movie = Map.of(
                    "movieId", i,
                    "movieName", "Movie " + i,
                    "movieGenre", "Genre " + i,
                    "movieRating", i + ".0"
            );
            this.movieList.add(movie);
        }

    }

    @Override
    public List<Map<String, Object>> getAllMovies() {
        return this.movieList;
    }

    @Override
    public List<Map<String, Object>> getMovieById(Integer movieId) {
        List<Map<String, Object>> movie = new ArrayList<>();
        movie.add(this.movieList.get(movieId));
        return movie;
    }

}
