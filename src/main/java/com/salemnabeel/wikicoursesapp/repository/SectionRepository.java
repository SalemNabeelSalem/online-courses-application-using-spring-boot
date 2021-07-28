package com.salemnabeel.wikicoursesapp.repository;

import com.salemnabeel.wikicoursesapp.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    @Query(value = "SELECT * FROM sections WHERE is_active = 1", nativeQuery = true)
    List<Section> getAllActiveSections();
}