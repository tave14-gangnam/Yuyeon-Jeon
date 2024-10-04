package com.tave.gangnam.week3.assignment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private int age;
    private String password;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    private Long savingAmount;
    private Long loanAmount;
}
