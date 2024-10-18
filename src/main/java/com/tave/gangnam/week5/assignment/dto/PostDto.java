package com.tave.gangnam.week5.assignment.dto;

import com.tave.gangnam.week5.assignment.domain.Posts;
import lombok.*;

import java.time.LocalDate;

public class PostDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {
        private String title;
        private String content;

        // Dto -> Entity

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String title;
        private LocalDate postedAt;

        // Entity -> Dto
        public static PostDto.Response toDto(Posts posts) {
            return Response.builder()
                    .title(posts.getTitle())
                    .postedAt(posts.getPostedAt())
                    .build();
        }
    }
}
