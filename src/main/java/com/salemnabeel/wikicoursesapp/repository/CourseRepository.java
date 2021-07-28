package com.salemnabeel.wikicoursesapp.repository;

import com.salemnabeel.wikicoursesapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT * FROM courses WHERE is_active = 1", nativeQuery = true)
    List<Course> getAllActiveCourses();

    @Query(value = "SELECT * FROM courses WHERE lecturer_id = :lecturerId", nativeQuery = true)
    List<Course> getAllCoursesByLecturerId(@Param("lecturerId") Long lecturerId);

    @Query(value = "SELECT * FROM courses WHERE lecturer_id = :lecturerId AND is_active = 1", nativeQuery = true)
    List<Course> getAllActiveCoursesByLecturerId(@Param("lecturerId") Long lecturerId);

    @Query(value = "SELECT * FROM courses WHERE classification_id = :classificationId AND is_active = 1", nativeQuery = true)
    List<Course> getAllActiveCoursesByClassificationId(@Param("classificationId") Long classificationId);
}