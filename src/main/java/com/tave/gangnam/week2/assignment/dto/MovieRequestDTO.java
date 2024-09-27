package com.tave.gangnam.week2.assignment.dto;

import com.tave.gangnam.week2.assignment.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MovieRequestDTO {
    private String title;
    private String genre;
    private String director;
    private String year;

    // DTO -> Entity 변환
    public static Movie toEntity(MovieRequestDTO requestDTO) {
        return Movie.builder()
                .title(requestDTO.getTitle())
                .genre(requestDTO.getGenre())
                .director(requestDTO.getDirector())
                .year(requestDTO.getYear())
                .build();
    }
}
