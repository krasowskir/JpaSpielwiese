package com.example.jpaSpielwiese.service;

import com.example.jpaSpielwiese.persistence.entities.Account;
import com.example.jpaSpielwiese.persistence.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account sourceAccount){
        return accountRepository.save(sourceAccount);
    }

    public Account getAccount(UUID id){
        return accountRepository.findOne(id);
    }

    public void removeAccount(UUID id){
        accountRepository.delete(id);
    }
}
