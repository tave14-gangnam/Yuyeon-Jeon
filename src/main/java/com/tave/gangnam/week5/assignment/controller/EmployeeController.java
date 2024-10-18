package com.tave.gangnam.week5.assignment.controller;

import com.tave.gangnam.week5.assignment.dto.EmployeeRequestDTO;
import com.tave.gangnam.week5.assignment.dto.EmployeeResponseDTO;
import com.tave.gangnam.week5.assignment.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // 직원 가입 API
    @PostMapping("/register")
public ResponseEntity<EmployeeResponseDTO> register(
        @RequestBody EmployeeRequestDTO requestDTO
    ) {
        EmployeeResponseDTO responseDTO = employeeService.registerEmployee(
                                            requestDTO.getEmpId(),
                                            requestDTO.getEmployeeNo(),
                                            requestDTO.getPassword(),
                                            requestDTO.getDepartment());
        return ResponseEntity.ok(responseDTO);
    }
}
