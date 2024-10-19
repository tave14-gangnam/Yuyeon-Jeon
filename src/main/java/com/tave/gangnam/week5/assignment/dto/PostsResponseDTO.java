package com.tave.gangnam.week5.assignment.dto;

import com.tave.gangnam.week5.assignment.domain.Posts;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostsResponseDTO {
    private String title;
    private LocalDate postedAt;
    private LocalDate modifiedAt;

    // Entity -> Dto
    public static PostsResponseDTO toDto(Posts posts) {
            return PostsResponseDTO.builder()
                    .title(posts.getTitle())
                    .postedAt(posts.getPostedAt())
                    .modifiedAt(posts.getModifiedAt())
                    .build();
    }
}
