package com.hust.baseweb.repo;

import com.hust.baseweb.entities.data.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill, Integer> {
    Bill findByIdAndDeletedFalse(Integer billId);
}
