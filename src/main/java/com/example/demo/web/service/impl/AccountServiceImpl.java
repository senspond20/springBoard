package com.example.demo.web.service.impl;

import java.util.List;

import com.example.demo.web.entity.Account;
import com.example.demo.web.repository.AccountRepository;
import com.example.demo.web.service.AccountService;
import com.example.demo.web.service.dto.AccountSaveRequestDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
    
    private final AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(AccountSaveRequestDto accountSaveRequestDto) {
        return accountRepository.save(accountSaveRequestDto.toEntity());
    }

    @Override
    public Account findByEmail(String email) {
        // return accountRepository.findByEmail();
        return null;
    }
}
