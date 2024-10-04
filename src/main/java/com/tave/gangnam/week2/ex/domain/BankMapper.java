package com.tave.gangnam.week2.ex.domain;

import com.tave.gangnam.week2.ex.dto.BankRequestDTO;
import com.tave.gangnam.week2.ex.dto.BankResponseDTO;
import com.tave.gangnam.week2.ex.type.BankName;

public class BankMapper {
    // DTO -> Entity 변환
    public static Bank toEntity(BankRequestDTO requestDTO) {
        return Bank.builder()
                .bankName(BankName.valueOf(requestDTO.getBankName()))
                .bankUser(requestDTO.getBankUser())
                .installmentSavings(requestDTO.getInstallmentSavings())
                .loan(requestDTO.getLoan())
                .build();
    }

    // Entity -> DTO 변환
    public static BankResponseDTO toDTO(Bank bank) {
        return BankResponseDTO.builder()
                .bankName(bank.getBankName())
                .build();
    }
}
