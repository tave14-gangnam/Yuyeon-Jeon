package com.tave.gangnam.week5.assignment.domain;

import com.tave.gangnam.week5.assignment.dto.EmployeeRequestDTO;
import com.tave.gangnam.week5.assignment.dto.EmployeeResponseDTO;

public class EmployeeMapper {
    // DTO -> Entity
    public static Employee toEntity(EmployeeRequestDTO requestDTO){
        return Employee.builder()
                .empId(requestDTO.getEmpId())
                .employeeNo(requestDTO.getEmployeeNo())
                .password(requestDTO.getPassword())
                .department(requestDTO.getDepartment())
                .build();
    }

    // Entity -> DTO
    public static EmployeeResponseDTO toDTO(Employee employee){
        return EmployeeResponseDTO.builder()
                .empId(employee.getEmpId())
                .employeeNo(employee.getEmployeeNo())
                .singedAt(employee.getSignedAt())
                .build();
    }
}
