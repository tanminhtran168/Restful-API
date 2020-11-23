package com.hust.baseweb.controller;

import com.hust.baseweb.entities.payload.LoginForm;
import com.hust.baseweb.entities.payload.RegisterForm;
import com.hust.baseweb.security.JWTService;
import com.hust.baseweb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/public/user")
public class UserController {

    private final UserService userService;
    private final JWTService jwtService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterForm form) {
        try {
            System.out.println("hello");
            boolean rs = userService.register(form);
            if (rs) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }
}
