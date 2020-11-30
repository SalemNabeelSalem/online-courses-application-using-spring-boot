package com.salemnabeel.wikicoursesapp.repository;

import com.salemnabeel.wikicoursesapp.model.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long> {
}