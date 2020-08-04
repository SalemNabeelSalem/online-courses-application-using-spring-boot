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
        value = "SELECT classification.* FROM classifications classification, sections section WHERE classification.section_id = section.id AND classification.section_id = :sectionId AND section.is_active = 1 AND classification.is_active = 1 ORDER BY created_at DESC",
        nativeQuery = true
    )
    List<Classification> getAllActiveClassificationsBySectionId(@Param("sectionId") Long sectionId);

    @Query(
        value = "SELECT classification.* FROM classifications classification, sections section WHERE classification.section_id = section.id AND classification.id = :classificationId AND classification.section_id = :sectionId AND section.is_active = 1 AND classification.is_active = 1",
        nativeQuery = true
    )
    List<Classification> getActiveClassificationBySectionId(
        @Param("sectionId") Long sectionId, @Param("classificationId") Long classificationId
    );
}