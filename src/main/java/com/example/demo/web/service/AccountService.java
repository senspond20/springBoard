package com.example.demo.web.service;

import java.util.List;

import com.example.demo.web.entity.Account;
import com.example.demo.web.service.dto.AccountSaveRequestDto;

public interface AccountService{
    
    
    List<Account> findAll();
    
    Account findByEmail(String email);

    Account save(AccountSaveRequestDto accountSaveRequestDto);
    
}
