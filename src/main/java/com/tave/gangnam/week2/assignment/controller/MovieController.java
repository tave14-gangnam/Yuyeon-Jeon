package com.tave.gangnam.week2.assignment.controller;

import com.tave.gangnam.week2.assignment.domain.MovieMapper;
import com.tave.gangnam.week2.assignment.dto.MovieRequestDTO;
import com.tave.gangnam.week2.assignment.dto.MovieResponseDTO;
import com.tave.gangnam.week2.assignment.domain.Movie;
import com.tave.gangnam.week2.assignment.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // 영화 등록 API
    @PostMapping("/create")
    public MovieResponseDTO createMovie(
            @RequestBody MovieRequestDTO requestDto
            ) {
        Movie movie = MovieMapper.toEntity(requestDto);
        return MovieMapper.toDTO(movie);
    }

    // 영화 조회 API
    @GetMapping("/register/{title}")
    public Optional<Movie> getMovie(@PathVariable String title) {
        return movieService.findMovie(title);
    }
}
