package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // find by email
    Optional<User> findByEmail(String email);

    // find by name
    List<User> findByEname(String ename);

    // check email exists
    boolean existsByEmail(String email);

    // login
//    Optional<User> findByEmailAndPassword(String email, String password);

    User findByEmailAndPassword(String email,String password);

}