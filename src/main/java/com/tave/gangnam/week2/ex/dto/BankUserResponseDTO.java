package com.tave.gangnam.week2.ex.dto;

import com.tave.gangnam.week2.ex.type.BankName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankUserResponseDTO {
    private String userName;
    private BankName bankName;
}
