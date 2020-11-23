package com.hust.baseweb.repo;

import com.hust.baseweb.entities.data.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

    @Query("update ProductEntity p set p.deleted = false where p.id = ?1")
    @Modifying
    @Transactional
    int updateDeletedProduct(Integer id);
}
