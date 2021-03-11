package com.example.demo.web.repository;
import java.util.List;

import com.example.demo.web.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{ 
    List<Account> findAll();
    
    
    // Account findByEmail();
     
}
