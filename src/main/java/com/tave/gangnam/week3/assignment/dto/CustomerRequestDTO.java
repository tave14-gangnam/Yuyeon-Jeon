package com.tave.gangnam.week3.assignment.dto;

import com.tave.gangnam.week3.assignment.domain.Company;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerRequestDTO {
    private Long id;
    private String customerName;
    private int age;
    private String password;
    private Company company;
}
