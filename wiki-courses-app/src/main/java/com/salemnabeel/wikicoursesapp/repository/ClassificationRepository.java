package com.salemnabeel.wikicoursesapp.repository;

import com.salemnabeel.wikicoursesapp.model.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {

    @Query(
        value = "SELECT * FROM classifications WHERE is_active = 1 AND section_id = :sectionId ORDER BY created_at DESC",
        nativeQuery = true
    )
    List<Classification> getAllActiveClassificationsBySectionId(@Param("sectionId") Long sectionId);

    @Query(
        value = "SELECT * FROM classifications WHERE id = :classificationId AND section_id = :sectionId",
        nativeQuery = true
    )
    Classification getClassificationById(
        @Param("sectionId") Long sectionId, @Param("classificationId") Long classificationId
    );
}