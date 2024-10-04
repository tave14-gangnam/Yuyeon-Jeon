package com.tave.gangnam.week3.assignment.dto;

import com.tave.gangnam.week3.assignment.domain.Company;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerResponseDTO {
    private String customerName;
    private Company company;
    private String message;
}
