package com.tave.gangnam.week3.assignment.domain;

import com.tave.gangnam.week3.assignment.dto.CustomerRequestDTO;
import com.tave.gangnam.week3.assignment.dto.CustomerResponseDTO;
import com.tave.gangnam.week3.assignment.dto.LoanResponseDTO;

public class LoanMapper {
    // DTO -> Entity 변환

    // Entity -> DTO 변환
    public static LoanResponseDTO toDTO(Customer customer) {
        return LoanResponseDTO.builder()
                .customerName(customer.getCustomerName())
                .company(customer.getCompany())
                .loanAmount(customer.getLoanAmount())
                .build();
    }
}
