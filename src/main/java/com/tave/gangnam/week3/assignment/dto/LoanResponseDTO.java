package com.tave.gangnam.week3.assignment.dto;

import com.tave.gangnam.week3.assignment.domain.Company;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoanResponseDTO {
    private String customerName;
    private String companyName;
    private Long loanAmount;

    private Company company;
}
