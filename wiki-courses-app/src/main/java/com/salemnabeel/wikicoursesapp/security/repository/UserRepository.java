package com.salemnabeel.wikicoursesapp.security.repository;

import com.salemnabeel.wikicoursesapp.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE user_name = :userName", nativeQuery = true)
    Optional<User> getUserByUserName(@Param(value = "userName") String userName);
}