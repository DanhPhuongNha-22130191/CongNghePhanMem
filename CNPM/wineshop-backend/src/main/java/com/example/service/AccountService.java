package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(long id) {
        return accountRepository.getById(id);
    }

    public Account register(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setRole("customer");
        account.setPassword(encoder.encode(password));
        try {
            return accountRepository.save(account);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Tên tài khoản đã tồn tại!");
        }
    }


    public Account login(String username, String password) {
        Account account = accountRepository.findByUsername(username);
        if (encoder.matches(password, account.getPassword())) {
            return account;
        } else {
            throw new RuntimeException("Tên tài khoản hoặc mật khẩu sai!");
        }
    }
}
