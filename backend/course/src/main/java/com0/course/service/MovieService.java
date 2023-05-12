package com0.course.service;

import java.util.List;
import java.util.Map;

public interface MovieService {

    List<Map<String,Object>> getAllMovies();
    List<Map<String,Object>> getMovieById(Integer movieId);

    Map<String,Object> getFinalMovie();

}
