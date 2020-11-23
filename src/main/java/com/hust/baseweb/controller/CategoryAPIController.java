package com.hust.baseweb.controller;

import com.hust.baseweb.entities.data.CategoryEntity;
import com.hust.baseweb.repo.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/public/categories")
public class CategoryAPIController {

    private final CategoryRepo repo;

    @PostMapping
    public ResponseEntity<String> upload(@RequestBody CategoryEntity category) {
        if (repo.insert(category)) {
            return ResponseEntity.ok("insert category successfully!");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
