package com.tave.gangnam.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // AllArgsConstructor
//    @Builder
//    public Member(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    // 기본 생성자: TODO 생성자를 만드는 이유
//    public Member() {}

    // builder 패턴
}
