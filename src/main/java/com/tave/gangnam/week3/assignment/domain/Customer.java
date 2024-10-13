package com.tave.gangnam.week3.assignment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    private Long savingAmount;
    private Long loanAmount;

    private String color;

    // update 메소드 생성(this를 사용해야하기 때문에 Customer Entity 안에서 메소드를 생성)
    public Customer update(Company company, Long loanAmount) {
        if (company != null) {
            this.company = company;
        }
        if (loanAmount != null) {
            this.loanAmount = loanAmount;
        }
        return null;
    }
}
