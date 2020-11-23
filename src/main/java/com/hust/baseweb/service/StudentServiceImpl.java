package com.hust.baseweb.service;

import com.hust.baseweb.entities.data.StudentEntity;
import com.hust.baseweb.repo.StudentRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepo repo;

    @Override
    public List<StudentEntity> findAll() {
        List<StudentEntity> students = repo.findAll();
        return students;
    }

    @Override
    public StudentEntity findByName(String name) {
        return repo.findAll()
                .stream()
                .filter(object -> object.getName().equals(name))
                .findFirst().get();
    }

}
