package com.tave.gangnam.week3.assignment.type;

import lombok.Getter;

@Getter
public enum ErrorCode {
    FAILED_CREATED("사용자 등록에 실패하였습니다.", "4"),
    COMPANY_NOT_FOUND("사용하려는 회사를 찾을 수 없습니다.", "1"),
    USER_NOT_FOUND("사용자를 찾을 수 없습니다", "2"),
    USER_ALREADY_EXISTS("이미 존재하는 사용자입니다.", "3");

    private final String description;
    private final String id;

    private ErrorCode(String description, String id) {
        this.description = description;
        this.id = id;
    }
}
