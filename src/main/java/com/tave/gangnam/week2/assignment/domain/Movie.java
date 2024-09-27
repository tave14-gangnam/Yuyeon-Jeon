package com.tave.gangnam.week2.assignment.domain;

import com.tave.gangnam.week2.assignment.dto.MovieResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private String director;

    private String year;

    // Entity -> DTO 변환
    public static MovieResponseDTO toDTO(Movie movie) {
        return MovieResponseDTO.builder()
                .title(movie.getTitle())
                .director(movie.getDirector())
                .genre(movie.getGenre())
                .year(movie.getYear())
                .build();
    }
}
