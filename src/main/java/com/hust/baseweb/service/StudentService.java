package com.hust.baseweb.service;

import com.hust.baseweb.entities.data.StudentEntity;

import java.util.List;

public interface StudentService {
    List<StudentEntity> findAll();

    StudentEntity findByName(String name);
}
