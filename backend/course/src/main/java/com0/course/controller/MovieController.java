package com0.course.controller;

import com0.course.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/getallmovies")
    public ResponseEntity<List<Map<String,Object>>> getAllMovies(){

        List<Map<String,Object>> respBody = movieService.getAllMovies();

        System.out.println(respBody);

        return new ResponseEntity<>(respBody, HttpStatus.OK);
    }

    @GetMapping("/getmoviebyid")
    public ResponseEntity<List<Map<String,Object>>> getMovieById(@RequestBody Map<String,Object> reqBody){
        Integer movieId = (Integer) reqBody.get("MovieId");
        List<Map<String,Object>> respBody = movieService.getMovieById(movieId);
        return new ResponseEntity<>(respBody,HttpStatus.OK);
    }


}


