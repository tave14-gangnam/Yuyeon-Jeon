package com.tave.gangnam.week3.assignment.dto;

import com.tave.gangnam.week3.assignment.domain.Customer;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompanyResponseDTO {
    private String companyName;
}
