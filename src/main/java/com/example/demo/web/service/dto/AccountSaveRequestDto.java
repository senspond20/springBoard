package com.example.demo.web.service.dto;

import com.example.demo.web.entity.Account;

import lombok.Getter;

@Getter
public class AccountSaveRequestDto {
    private String email;
    private String password;
    private String authority;

    public AccountSaveRequestDto(String email, String password, String authority){
        this.email = email;
        this.password = password;
        this.authority = authority;
    }

    public Account toEntity(){
        return Account.builder()
                      .email(email)
                      .password(password)
                      .authority(authority)
                      .build();
    }
}
