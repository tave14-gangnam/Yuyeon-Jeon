package com.tave.gangnam.week5.assignment.repository;

import com.tave.gangnam.week5.assignment.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
