package com.tave.gangnam.week5.assignment.exception;

import com.tave.gangnam.week5.assignment.type.ErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostException extends RuntimeException{
    private ErrorCode errorCode;
    private String errorMessage;

    public PostException(ErrorCode errorCode){
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}
