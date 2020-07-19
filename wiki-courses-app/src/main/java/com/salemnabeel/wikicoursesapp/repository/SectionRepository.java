package com.salemnabeel.wikicoursesapp.repository;

import com.salemnabeel.wikicoursesapp.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    @Query(value = "SELECT * FROM sections WHERE is_active = 1 ORDER BY created_at DESC", nativeQuery = true)
    List<Section> getAllActiveSections();

    @Query(value = "SELECT * FROM sections WHERE id = :sectionId", nativeQuery = true)
    Section getSectionById(@Param(value = "sectionId") Long sectionId);
}