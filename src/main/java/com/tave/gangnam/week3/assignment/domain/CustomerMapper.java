package com.tave.gangnam.week3.assignment.domain;

import com.tave.gangnam.week3.assignment.dto.CustomerRequestDTO;
import com.tave.gangnam.week3.assignment.dto.CustomerResponseDTO;

public class CustomerMapper {
    // DTO -> Entity 변환
    public static Customer toEntity(CustomerRequestDTO requestDTO) {
        return Customer.builder()
                .id(requestDTO.getId())
                .customerName(requestDTO.getCustomerName())
                .age(requestDTO.getAge())
                .password(requestDTO.getPassword())
                .company(requestDTO.getCompany())
                .build();
    }

    // Entity -> DTO 변환
    public static CustomerResponseDTO toDTO(Customer customer) {
        return CustomerResponseDTO.builder()
                .customerName(customer.getCustomerName())
                .company(customer.getCompany())
                .build();
    }
}
