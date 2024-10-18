package com.tave.gangnam.week5.assignment.controller;

import com.tave.gangnam.week5.assignment.dto.EmployeeRequestDTO;
import com.tave.gangnam.week5.assignment.dto.EmployeeResponseDTO;
import com.tave.gangnam.week5.assignment.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 직원 탈퇴 API
    @DeleteMapping("/delete")
    public void deleteEmployee(
            @RequestParam Long id,
            @RequestParam String password){
        employeeService.deleteEmployee(id, password);
        System.out.println("성공적으로 탈퇴되었습니다!");
    }
}
