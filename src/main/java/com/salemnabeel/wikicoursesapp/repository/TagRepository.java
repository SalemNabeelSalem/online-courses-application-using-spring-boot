package com.salemnabeel.wikicoursesapp.repository;

import com.salemnabeel.wikicoursesapp.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query(value = "SELECT * FROM tags WHERE is_active = 1", nativeQuery = true)
    List<Tag> getAllActiveTags();

    @Query(value = "SELECT * FROM tags WHERE course_id = :courseId", nativeQuery = true)
    Optional<List<Tag>> findAllByCourseId(@Param("courseId") Long courseId);
}