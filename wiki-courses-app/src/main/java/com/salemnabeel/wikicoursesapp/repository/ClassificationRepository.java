package com.salemnabeel.wikicoursesapp.repository;

import com.salemnabeel.wikicoursesapp.model.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {

    @Query(value = "SELECT * FROM classifications WHERE is_active = 1", nativeQuery = true)
    List<Classification> getAllActiveClassifications();

    @Query(value = "SELECT * FROM classifications WHERE section_id = :sectionId AND is_active = 1",
           nativeQuery = true
    )
    List<Classification> getAllActiveClassificationsBySectionId(@Param("sectionId") Long sectionId);
}