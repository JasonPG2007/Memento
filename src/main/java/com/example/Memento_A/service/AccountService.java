package com.example.Memento_A.service;

import com.example.Memento_A.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {

    // getAccount method
    @Override
    public List<Account> getAccounts() {
        return List.of();
    }
}
