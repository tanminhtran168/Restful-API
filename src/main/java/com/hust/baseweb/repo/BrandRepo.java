package com.hust.baseweb.repo;

import com.hust.baseweb.entities.data.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BrandRepo extends JpaRepository<BrandEntity, Integer> {
    List<BrandEntity> findByNameContains(String name);

    List<BrandEntity> findByNameStartsWithAndNameEndsWith(String start, String end);

    @Query("update BrandEntity b set b.deleted = false where b.id = ?1")
    @Transactional
    @Modifying
    int updateDeleteById(Integer id);


}
