package com.tave.gangnam.week5.assignment.domain;

import com.tave.gangnam.week5.assignment.dto.CommentRequestDTO;
import com.tave.gangnam.week5.assignment.dto.CommentResponseDTO;

import java.time.LocalDate;

public class CommentsMapper {
    // DTO -> Entity
    public static Comments toEntity(CommentRequestDTO requestDTO, Posts posts){
        return Comments.builder()
                .postId(posts)
                .employeeNo(requestDTO.getEmployeeNo())
                .comment(requestDTO.getComment())
                .commentedAt(LocalDate.now())
                .build();
    }

    // Entity -> DTO
    public static CommentResponseDTO toDto(Comments comments) {
        return CommentResponseDTO.builder()
                .empNo(comments.getEmployeeNo())
                .comment(comments.getComment())
                .commentedAt(comments.getCommentedAt())
                .build();
    }
}
