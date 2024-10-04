package com.tave.gangnam.week3.assignment.controller;

import com.tave.gangnam.week3.assignment.domain.Customer;
import com.tave.gangnam.week3.assignment.dto.*;
import com.tave.gangnam.week3.assignment.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/loan")
@AllArgsConstructor
public class LoanController {
    private final LoanService loanService;

    // 유저 등록 API
    @PostMapping("/register/customer")
    public ResponseEntity<String> register(
            @RequestBody CustomerRequestDTO requestDTO
            ) {
        CustomerResponseDTO responseDTO = loanService.registerCustomer(requestDTO);

        try {
            if (responseDTO != null) {
                String successMessage =
                        responseDTO.getCustomerName() + "가 성공적으로 등록되었습니다.";
                return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);
            }
            else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("등록에 실패했습니다.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("등록에 실패했습니다.");
        }
    }

    // 유저 조회 API
    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomer(
            @PathVariable Long id
    ) {
        return loanService.getCustomer(id);
    }

    // 유저 전체 조회하기 API
    @GetMapping
    public List<Customer> getAllCustomers() {
        return loanService.getAllCustomers();
    }

    // 회사 등록하기 API
    @PostMapping("/register/company")
    public CompanyResponseDTO registerCompany(
            @RequestBody String companyName
    ) {
        return loanService.registerCompany(companyName);
    }


    // 대출 API - 신규 등록
    @PostMapping("/loan")
    public LoanResponseDTO loan(
            @RequestBody LoanRequestDTO requestDTO,
            Model model) {

        LoanResponseDTO responseDTO = loanService.registerLoan(requestDTO);
        if (responseDTO.getLoanAmount() >= 1000) {
            model.addAttribute("color", "red");
        } else {
            model.addAttribute("color", "yellow");
        }
        return responseDTO;
    }

//    // 대출 API - 기존에 있는 고객에서 업데이트
//    @PutMapping("/")
//    public
}
