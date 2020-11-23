package com.hust.baseweb.repo;

import com.hust.baseweb.entities.data.StudentEntity;

import java.util.List;

public interface StudentRepo{

    List<StudentEntity> findAll();

}
