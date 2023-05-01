package com0.course.repository;

import java.util.List;
import java.util.Map;

public interface MovieRepository {

    public List<Map<String, Object>> getAllMovies();

    public List<Map<String, Object>> getMovieById(Integer movieId);


}
