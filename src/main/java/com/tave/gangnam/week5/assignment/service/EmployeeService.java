package com.tave.gangnam.week5.assignment.service;

import com.tave.gangnam.week5.assignment.domain.Employee;
import com.tave.gangnam.week5.assignment.domain.EmployeeMapper;
import com.tave.gangnam.week5.assignment.dto.EmployeeRequestDTO;
import com.tave.gangnam.week5.assignment.dto.EmployeeResponseDTO;
import com.tave.gangnam.week5.assignment.exception.PostException;
import com.tave.gangnam.week5.assignment.repository.EmployeeRepository;
import com.tave.gangnam.week5.assignment.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Slf4j
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // 직원 가입 서비스
    @Transactional
    public EmployeeResponseDTO registerEmployee(
            Long id, String empNo, String password, String department) {
        log.info("사원 등록 시작 : " + empNo);
        if (employeeRepository.findById(id).isPresent()) {
            log.info("사원 등록 실패");
            throw new PostException(ErrorCode.USER_ALREADY_EXISTS);
        }

        LocalDate signedAt = LocalDate.now();

        Employee newEmployee = Employee.builder()
                                    .empId(id)
                                    .employeeNo(empNo)
                                    .password(password)
                                    .department(department)
                                    .signedAt(signedAt)
                                    .build();
        return EmployeeMapper.toDTO(newEmployee);
    }


    // 직원 탈퇴 서비스
    public void deleteEmployee(Long id, String password) {
        log.info("회원 탈퇴");

        log.info("회원 조회");
        String findPassword =  employeeRepository.findById(id)
                        .map(emp -> emp.getPassword())
                        .orElseThrow(() -> new PostException(ErrorCode.USER_NOT_FOUND));
        if (!findPassword.equals(password)) {
            log.info("비밀번호 불일치 오류");
            throw new PostException(ErrorCode.PASSWORD_UNMATCHED);
        }
        log.info("회원 탈퇴 성공");
        employeeRepository.deleteById(id);
    }
}
