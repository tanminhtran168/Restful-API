package com.hust.baseweb.repo;

import com.hust.baseweb.entities.data.BillHasProduct;
import com.hust.baseweb.key.BillProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillHasProductRepo extends JpaRepository<BillHasProduct, BillProductKey> {
    List<BillHasProduct> findById_BillId(Integer billId);
}
