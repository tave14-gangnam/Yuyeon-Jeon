package com.tave.gangnam.week3.assignment.dto;

import com.tave.gangnam.week3.assignment.domain.Customer;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompanyRequestDTO {
    private String companyName;
    private Long savingAmount;
    private Long lonaAmount;
}
