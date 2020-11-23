package com.hust.baseweb.controller;

import com.hust.baseweb.entities.data.User;
import com.hust.baseweb.security.JWTService;
import com.hust.baseweb.service.FacebookService;
import com.hust.baseweb.service.GoogleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class SocialController {

    private final JWTService jwtService;
    private final GoogleService googleService;
    private final FacebookService facebookService;

    @GetMapping("login-google")
    public String loginGoogle() {
        return "redirect:" + googleService.createAuthorizationURL();
    }

    @GetMapping("google-callback")
    public ResponseEntity<Object> googleCallback(@RequestParam(name = "code") String code) {
        try {
            String accessToken = googleService.createAccessToken(code);
            User appUser = googleService.getUser(accessToken);
            return ResponseEntity.ok(jwtService.generateToken(appUser.getUsername()));
        } catch (Exception e){
            return ResponseEntity.status(500).body(e);
        }
    }

    @GetMapping("login-facebook")
    public String loginFacebook() {
        return "redirect:" + facebookService.createAuthorizationURL();
    }

    @GetMapping("facebook-callback")
    public ResponseEntity<Object> facebookCallback(@RequestParam (name = "code") String code) {
        try {
            String accessToken = facebookService.createAccessToken(code);
            User user = facebookService.getUser(accessToken);
            return ResponseEntity.ok(jwtService.generateToken(user.getUsername()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e);
        }
    }
}
