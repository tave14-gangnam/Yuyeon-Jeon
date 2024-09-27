package com.tave.gangnam.week2.assignment.service;

import com.tave.gangnam.week2.assignment.domain.Movie;
import com.tave.gangnam.week2.assignment.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // 영화 등록하기
    @Transactional
    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    // ID로 영화 검색하기
    @Transactional
    public Optional<Movie> findMovie(Long id) {
        return movieRepository.findById(id);
    }

    // 제목으로 영화 조회하기
    @Transactional(readOnly = true)
    public List<Movie> findMoviesByTitle(String title) {
        return movieRepository.findByTitleContaining(title);
    }
}
