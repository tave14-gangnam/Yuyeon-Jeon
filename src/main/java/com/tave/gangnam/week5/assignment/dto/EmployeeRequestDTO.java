package com.tave.gangnam.week5.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class EmployeeRequestDTO {

    private Long empId;
    private String employeeNo;

    private String password;
    private String department;
}
