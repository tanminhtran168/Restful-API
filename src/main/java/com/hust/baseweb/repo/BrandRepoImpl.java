package com.hust.baseweb.repo;

import com.hust.baseweb.entities.data.BrandEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
public class BrandRepoImpl{

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public List<BrandEntity> findAll() {
//        TypedQuery<BrandEntity> query =
//                entityManager.createQuery("select brand from BrandEntity brand " +
//                                                    "where brand.deleted = false", BrandEntity.class);
//        query.setMaxResults(10);
//        return query.getResultList();
//    }
//
//    @Override
//    public BrandEntity findById(int id) {
//        TypedQuery<BrandEntity> query =
//                entityManager.createQuery("select brand from BrandEntity brand where brand.id = ?1", BrandEntity.class);
//        query.setParameter(1, id);
//        return query.getSingleResult();
//    }
//
//    @Override
//    @Transactional(rollbackFor = {Exception.class})
//    public boolean insert(BrandEntity brand) {
//        brand.setId(null);
//        entityManager.persist(brand);
//        return true;
//    }
}
