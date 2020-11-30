package com.salemnabeel.wikicoursesapp.repository;

import com.salemnabeel.wikicoursesapp.model.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {

    @Query(value = "SELECT * FROM contact_us WHERE is_publish = 1", nativeQuery = true)
    List<ContactUs> getAllImprovedFaqAnswers();
}