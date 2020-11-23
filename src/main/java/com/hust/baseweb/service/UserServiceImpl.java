package com.hust.baseweb.service;

import com.hust.baseweb.entities.data.User;
import com.hust.baseweb.entities.payload.LoginForm;
import com.hust.baseweb.entities.payload.RegisterForm;
import com.hust.baseweb.repo.UserRepository;
import com.hust.baseweb.utils.EncodeUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public boolean register(RegisterForm form) throws Exception {
        boolean existed = userRepository.existsByUsername(form.getUsername());
        if (!existed) {
            User user = User.builder()
                    .name(form.getName())
                    .password(EncodeUtil.getSHA256(form.getPassword()))
                    .username(form.getUsername())
                    .deleted(false)
                    .build();
            userRepository.save(user);
            System.out.println("New user created!");
            return true;
        }
        return false;
    }

    @Override
    public boolean login(LoginForm loginForm) {
        return userRepository.existsByUsernameAndPasswordAndDeletedFalse(loginForm.getUsername(), loginForm.getPassword());
    }
}
