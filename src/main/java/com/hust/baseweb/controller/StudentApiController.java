package com.hust.baseweb.controller;

import com.hust.baseweb.entities.data.StudentEntity;
import com.hust.baseweb.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/public/students")
@AllArgsConstructor
public class StudentApiController {

    private final StudentService service;

    @GetMapping(value = "/all")
    public List<StudentEntity> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{name}")
    public StudentEntity findById(@PathVariable(value = "name") String name) {
        return service.findByName(name);
    }

    @GetMapping(value = "/one")
    public StudentEntity findOne() {
        return new StudentEntity(1, "Minh", "Haiphong");
    }

    @PostMapping
    public void createStudent() {

    }
}
