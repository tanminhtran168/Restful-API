package com.hust.baseweb.service;

import com.hust.baseweb.entities.payload.LoginForm;
import com.hust.baseweb.entities.payload.RegisterForm;

public interface UserService {
    boolean register(RegisterForm form) throws Exception;
    boolean login (LoginForm loginForm);
}
