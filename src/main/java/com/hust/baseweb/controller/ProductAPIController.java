package com.hust.baseweb.controller;

import com.hust.baseweb.aop.LogTime;
import com.hust.baseweb.entities.data.ProductEntity;
import com.hust.baseweb.repo.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("api/public/products")
public class ProductAPIController {

    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> post (@RequestBody ProductEntity product) {
        manager.persist(product);
        return ResponseEntity.ok().build();
    }

    @Value("${my-config.name}")
    private String name;

}
