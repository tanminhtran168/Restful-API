package com.hust.baseweb;

import com.hust.baseweb.entities.payload.RegisterForm;
import com.hust.baseweb.repo.ProductRepo;
import com.hust.baseweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class BasewebApplication implements CommandLineRunner {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ProductRepo productRepo;

    public static void main(String[] args) {
        SpringApplication.run(BasewebApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public void run(String ...args) throws Exception {
//        RegisterForm form = new RegisterForm("tanminh", "123", "minh");
//        userService.register(form);
    }

}
