package com.hust.baseweb.security;

import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import static com.hust.baseweb.security.SecurityConstants.*;


import java.util.Date;

@Service
public class JWTService {
    //Tạo token
    public String generateToken(String username) throws Exception{
        return TOKEN_PREFIX + JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SECRET.getBytes()));

    }
    //Giải mã token
    public String decode(String token) {
        try {
            return JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                    .build().verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();
        } catch (Exception ex) {
            return null;
        }
    }
}
