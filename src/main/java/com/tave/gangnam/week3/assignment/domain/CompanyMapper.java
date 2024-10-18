package com.tave.gangnam.week3.assignment.domain;

import com.tave.gangnam.week3.assignment.dto.CompanyRequestDTO;
import com.tave.gangnam.week3.assignment.dto.CompanyResponseDTO;

public class CompanyMapper {
    // DTO -> Entity 변환
    public static Company toEntity(CompanyRequestDTO requestDTO) {
        return Company.builder()
                .companyName(requestDTO.getCompanyName())
                .build();
    }

    // Entity -> DTO 변환
    public static CompanyResponseDTO toDTO(Company company) {
        return CompanyResponseDTO.builder()
                .companyName(company.getCompanyName())
                .build();
    }
}
