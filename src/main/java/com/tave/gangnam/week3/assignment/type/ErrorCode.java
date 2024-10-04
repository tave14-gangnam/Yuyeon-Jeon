package com.tave.gangnam.week3.assignment.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    FAILED_CREATED("사용자 등록에 실패하였습니다."),
    COMPANY_NOT_FOUND("사용하려는 회사를 찾을 수 없습니다."),
    USER_NOT_FOUND("사용자를 찾을 수 없습니다");

    private final String description;
}
