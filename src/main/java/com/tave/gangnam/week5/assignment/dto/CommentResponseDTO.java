package com.tave.gangnam.week5.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponseDTO {
    private String empNo;
    private String comment;
    private LocalDate commentedAt;
}
