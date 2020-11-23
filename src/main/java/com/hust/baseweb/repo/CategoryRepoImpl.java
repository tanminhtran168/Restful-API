package com.hust.baseweb.repo;

import com.hust.baseweb.entities.data.CategoryEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CategoryRepoImpl implements CategoryRepo{

    @PersistenceContext
    private EntityManager manager;

    @Override
    @Transactional
    public boolean insert(CategoryEntity category) {
        category.setId(null);
        manager.persist(category);
        return true;
    }
}
