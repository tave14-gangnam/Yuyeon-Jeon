package com.tave.gangnam.week2.ex.repository;

import com.tave.gangnam.week2.ex.domain.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankUserReposiotry extends JpaRepository<BankUser, Long> {
}
