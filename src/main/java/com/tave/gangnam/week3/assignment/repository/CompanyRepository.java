package com.tave.gangnam.week3.assignment.repository;

import com.tave.gangnam.week3.assignment.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByCompanyName(String companyName);
}
