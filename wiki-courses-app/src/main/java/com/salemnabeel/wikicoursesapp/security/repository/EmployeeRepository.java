package com.salemnabeel.wikicoursesapp.security.repository;

import com.salemnabeel.wikicoursesapp.security.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByUserName(String userName);
}