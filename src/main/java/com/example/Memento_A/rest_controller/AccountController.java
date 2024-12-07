package com.example.Memento_A.rest_controller;

import com.example.Memento_A.model.*;
import com.example.Memento_A.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    // Variable
    @Autowired
    private AccountService accountService;

    // Get method
    @GetMapping("/")
    public ResponseEntity<?> getAccounts() {
        List<Account> listAccount = accountService.getAccounts();
        if (listAccount.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("There are no accounts yet");
        }
        return ResponseEntity.ok(listAccount);
    }
}
