package com.tave.gangnam.week2.assignment.service;

import com.tave.gangnam.week2.assignment.domain.Movie;
import com.tave.gangnam.week2.assignment.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // 영화 등록하기
    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    // 영화 검색하기
    public Optional<Movie> findMovie(String title) {
        return movieRepository.findByTitle(title);
    }
}
