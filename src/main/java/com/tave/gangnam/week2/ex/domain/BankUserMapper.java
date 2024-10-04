package com.tave.gangnam.week2.ex.domain;

import com.tave.gangnam.week2.ex.dto.BankResponseDTO;
import com.tave.gangnam.week2.ex.dto.BankUserRequestDTO;
import com.tave.gangnam.week2.ex.dto.BankUserResponseDTO;
import com.tave.gangnam.week2.ex.type.BankName;

public class BankUserMapper {
    // DTO -> Entity 변환
    public static BankUser toEntity(BankUserRequestDTO requestDTO) {
        return BankUser.builder()
                .userName(requestDTO.getUserName())
                .password(requestDTO.getPassword())
                .bankName(requestDTO.getBankName())
                .build();
    }

    // Entity -> DTO 변환
    public static BankUserResponseDTO toDTO(BankUser bankUser) {
        return BankUserResponseDTO.builder()
                .bankName(bankUser.getBankName())
                .bankName(bankUser.getBankName())
                .build();
    }
}
