package com.tave.gangnam.week3.assignment.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Builder
public class LoanRequestDTO {
    private Long userId;
    private String password;
    private String companyName;
    private Long loanAmount;
    private String customerName;
    private String color;


    public String colorSetting(Long loanAmount) {
        if (loanAmount >= 1000) {
            this.color = "red";
        } else {
            this.color = "yellow";
        }
        return color;
    }
}
