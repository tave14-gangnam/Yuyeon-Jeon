package com.tave.gangnam.week3.assignment.repository;

import com.tave.gangnam.week3.assignment.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
