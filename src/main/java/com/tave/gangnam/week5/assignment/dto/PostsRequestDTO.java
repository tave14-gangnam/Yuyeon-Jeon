package com.tave.gangnam.week5.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostsRequestDTO {
        private Long postsId;
        private String employeeNo;
        private String password;
        private String title;
        private String content;

        public PostsRequestDTO(Long postsId, String title){
            this.postsId = postsId;
            this.title = title;
        }

    // Dto -> Entity
}
