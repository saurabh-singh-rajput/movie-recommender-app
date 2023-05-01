package com0.course.service;

import com0.course.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Map<String, Object>> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @Override
    public List<Map<String, Object>> getMovieById(Integer movieId) {
        return movieRepository.getMovieById((Integer) movieId);
    }
}
