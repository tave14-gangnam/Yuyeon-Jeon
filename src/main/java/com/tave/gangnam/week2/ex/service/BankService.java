package com.tave.gangnam.week2.ex.service;

import com.tave.gangnam.week2.ex.domain.Bank;
import com.tave.gangnam.week2.ex.domain.BankMapper;
import com.tave.gangnam.week2.ex.domain.BankUser;
import com.tave.gangnam.week2.ex.domain.BankUserMapper;
import com.tave.gangnam.week2.ex.dto.BankResponseDTO;
import com.tave.gangnam.week2.ex.dto.BankUserRequestDTO;
import com.tave.gangnam.week2.ex.dto.BankUserResponseDTO;
import com.tave.gangnam.week2.ex.repository.BankRepository;
import com.tave.gangnam.week2.ex.repository.BankUserReposiotry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;
    private final BankUserReposiotry bankUserReposiotry;

    // 가입은행 종류 API
    @Transactional(readOnly = true)
    public BankResponseDTO searchBank(Long id) {
        Bank bank = bankRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없습니다."));
        return BankMapper.toDTO(bank);
    }

    // 대출 적금 API

    // 유저 등록 API
    @Transactional
    public BankUserResponseDTO createUser(BankUserRequestDTO requestDTO) {
        // 존재하지 않은 유저 -> 유저 생성, 존재하는 유저 -> return 존재 유저
//        BankUser savedBankUser = bankUserReposiotry.save(
//                        bankUserReposiotry.findById(requestDTO.getUserId()) // 이미 있는 것이 있으면 있는 것 반환
//                                .orElseGet(() -> BankUserMapper.toEntity(requestDTO)) // 없으면 입력한 dto를 entity로 변환 후 저장
//        );
        BankUser savedBankUser = bankUserReposiotry.save(BankUserMapper.toEntity(requestDTO));
        return BankUserMapper.toDTO(savedBankUser);
    }


//    // 유저 조회 API
//    @Transactional
//    public BankUserResponseDTO searchUser(BankUserRequestDTO requestDTO) {
//
//    }


}
