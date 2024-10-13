package com.tave.gangnam.week3.assignment.service;

import com.tave.gangnam.week3.assignment.domain.*;
import com.tave.gangnam.week3.assignment.dto.*;
import com.tave.gangnam.week3.assignment.exception.LoanException;
import com.tave.gangnam.week3.assignment.repository.CompanyRepository;
import com.tave.gangnam.week3.assignment.repository.CustomerRepository;
import com.tave.gangnam.week3.assignment.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class LoanService {
    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;

    // 유저 등록하기
    @Transactional
    public CustomerResponseDTO registerCustomer(CustomerRequestDTO requestDto) {
        // 이미 등록된 고객인지 확인


         Customer savedCustomer = customerRepository.save(CustomerMapper.toEntity(requestDto));
         return CustomerMapper.toDTO(savedCustomer);
    }

    // 유저 조회하기
    @Transactional(readOnly = true)
    public CustomerResponseDTO getCustomer(Long id) {
        Customer findCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new LoanException(ErrorCode.USER_NOT_FOUND));
        return CustomerMapper.toDTO(findCustomer);
    }

    // 유저 전체 조회하기
    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // 회사 등록하기
    @Transactional
    public CompanyResponseDTO registerCompany(String companyName) {
        Company savedCompany = companyRepository.save(
                        Company.builder()
                            .companyName(companyName)
                            .build());

        return CompanyMapper.toDTO(savedCompany);
    }

    // 회사 조회하기
    public CompanyResponseDTO getCompany(Long id) {
        return CompanyMapper.toDTO(
                companyRepository.findById(id)
                        .orElseThrow(() -> new LoanException(ErrorCode.COMPANY_NOT_FOUND))
        );
    }

    // 대출 서비스 이용 고객 등록하기 - 신규 고객 등록
    @Transactional
    public LoanResponseDTO registerLoan(LoanRequestDTO requestDto) {
        // 이용하려는 회사의 이름 찾기
        Company findCompany = companyRepository.findByCompanyName(requestDto.getCompanyName())
                .orElseThrow(() -> new LoanException(ErrorCode.COMPANY_NOT_FOUND)); // 찾으려는 회사의 이름이 존재하지 않을 때

        // 이미 등록된 고객인지 확인
        if (customerRepository.findById(requestDto.getUserId()).isPresent()) {
            throw new LoanException(ErrorCode.USER_ALREADY_EXISTS); // 신규 고객이 아님
        }

        Customer savedCustomer = customerRepository.save(
                Customer.builder()
                        .customerName(requestDto.getCustomerName())
                        .password(requestDto.getPassword())
                        .company(findCompany)
                        .loanAmount(requestDto.getLoanAmount())
                        .color(requestDto.colorSetting(requestDto.getLoanAmount()))
                      .build()); // TODO : 코드에서 좀더 중복 제거하기

        LoanResponseDTO responseDTO = LoanMapper.toDTO(savedCustomer);
        return responseDTO;
    }

    // 대출 서비스 이용하기 - 기존의 고객에서 업데이트
    @Transactional
    public LoanResponseDTO useLoan(LoanRequestDTO requestDTO) {
        // 이용하려는 회사의 이름 찾기
        Company findedCompany = companyRepository.findByCompanyName(requestDTO.getCompanyName())
                .orElseThrow(() -> new LoanException(ErrorCode.COMPANY_NOT_FOUND));

        // 이미 등록된 유저인지 확인하기
        Customer findedCustomer = customerRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new LoanException(ErrorCode.USER_NOT_FOUND)); // 유저 조회 실패 -> 새로 등록 요청
        return LoanMapper.toDTO(findedCustomer.update(findedCompany, requestDTO.getLoanAmount()));
    }
}
