package com.tave.gangnam.week3.assignment.exception;

import com.tave.gangnam.week3.assignment.type.ErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanException extends RuntimeException {
    private ErrorCode errorCode;
    private String errorMessage; // 직접 프로젝트에 맞는 에러메세지 설정

    public LoanException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}
