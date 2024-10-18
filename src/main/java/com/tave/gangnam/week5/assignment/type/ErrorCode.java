package com.tave.gangnam.week5.assignment.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_ALREADY_EXISTS("이미 존재하는 유저입니다.");


    private final String description;

    // AllArgsConstructor
//    ErrorCode(String description) {
//        this.description = description;
//    }
}
