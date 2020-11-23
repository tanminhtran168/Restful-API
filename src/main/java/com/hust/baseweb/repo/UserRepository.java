package com.hust.baseweb.repo;

import com.hust.baseweb.entities.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    boolean existsByUsernameAndPasswordAndDeletedFalse(String username, String password);

    User findByUsernameAndDeletedFalse(String userId);
}