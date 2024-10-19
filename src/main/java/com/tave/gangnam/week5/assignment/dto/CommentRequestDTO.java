package com.tave.gangnam.week5.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDTO {
    private Long postsId;
    private String comment;
    private String employeeNo;


}
