package com.tave.gangnam.week5.assignment.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_ALREADY_EXISTS("이미 존재하는 유저입니다."),
    USER_NOT_FOUND("존재하지 않는 유저입니다."),
    PASSWORD_UNMATCHED("비밀번호가 일치하지 않습니다"),
    POSTS_NOT_FOUND("해당 게시글을 찾을 수 없습니다."),
    WRONG_PASSWORD("비밀번호가 틀렸습니다.");


    private final String description;

    // AllArgsConstructor
//    ErrorCode(String description) {
//        this.description = description;
//    }
}
