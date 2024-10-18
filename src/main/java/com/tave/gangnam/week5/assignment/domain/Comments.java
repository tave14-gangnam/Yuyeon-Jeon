package com.tave.gangnam.week5.assignment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writer;
    private String content;
    private LocalDate commentedAt;


}
