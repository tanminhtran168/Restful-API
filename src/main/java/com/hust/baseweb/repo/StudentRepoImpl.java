package com.hust.baseweb.repo;

import com.hust.baseweb.entities.data.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
@NoArgsConstructor
@AllArgsConstructor
public class StudentRepoImpl implements StudentRepo{
    private List<StudentEntity> students;

    @PostConstruct
    public void fakeData() {
        students = new ArrayList<>();

        students.add(StudentEntity
                .builder()
                .name("Minh")
                .address("Hanoi")
                .build()
        );
        students.add(StudentEntity
                .builder()
                .name("Chi")
                .address("Haiphong")
                .build()
        );
        students.add(StudentEntity
                .builder()
                .name("Phuong")
                .address("Haiphong")
                .build()
        );
    }

    @Override
    public List<StudentEntity> findAll() {
        return students;
    }
}
