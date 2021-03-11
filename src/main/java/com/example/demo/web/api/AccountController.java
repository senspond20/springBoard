package com.example.demo.web.api;

import java.util.List;

import com.example.demo.web.entity.Account;
import com.example.demo.web.service.AccountService;
import com.example.demo.web.service.dto.AccountSaveRequestDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {
    
    private final AccountService accountService;


    @GetMapping("/all")
    public List<Account> getAccountList(){
        return accountService.findAll();
    }

    @GetMapping("")
    public Account getAccountByEmail(String email){
        return accountService.findByEmail(email);
    }

    @PostMapping("")
    public Account insertAccount(AccountSaveRequestDto accountSaveRequestDto){
        return accountService.save(accountSaveRequestDto);
    }


}
