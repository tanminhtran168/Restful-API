package com.hust.baseweb.entities.payload;

import lombok.Data;

@Data
public class LoginForm {
    private String username;
    private String password;
}
