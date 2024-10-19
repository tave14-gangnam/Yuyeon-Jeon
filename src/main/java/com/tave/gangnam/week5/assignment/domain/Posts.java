package com.tave.gangnam.week5.assignment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Posts {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String employeeNo;

    private String title;
    private String content;
    private LocalDate postedAt;
    private LocalDate modifiedAt;

    @OneToMany(mappedBy = "postId")
    private List<Comments> comments = new ArrayList<>();

    public Posts update(String title, String content) {
        if (title != null){
            this.title = title;
        }
        if (content != null){
            this.content = content;
        }
        return null;
    }
}
