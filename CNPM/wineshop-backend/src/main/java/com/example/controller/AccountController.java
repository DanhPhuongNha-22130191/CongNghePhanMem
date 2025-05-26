package com.example.controller;

import com.example.model.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "https://cnpm-frontend.vercel.app",
        methods = {RequestMethod.GET, RequestMethod.POST},
        allowedHeaders = {"Content-Type", "Authorization"},
        maxAge = 3600)
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String username, @RequestParam String password) {
        try {
            Account account = accountService.register(username, password);
            return ResponseEntity.ok().body(Map.of("message", "Đăng ký thành công", "account", account));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace(); // vẫn in ra để debug nếu cần
            return ResponseEntity.status(500).body(Map.of("message", "Lỗi server"));
        }
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            Account account = accountService.login(username, password);
            return ResponseEntity.ok().body(Map.of("message", "Đăng nhập thành công", "account", account));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(Map.of("message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "Lỗi server"));
        }
    }


}