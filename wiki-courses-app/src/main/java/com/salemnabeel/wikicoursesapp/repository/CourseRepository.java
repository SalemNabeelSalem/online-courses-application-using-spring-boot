package com.salemnabeel.wikicoursesapp.repository;

import com.salemnabeel.wikicoursesapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(
        value = "SELECT course.* FROM courses course, lecturers lecturer WHERE course.lecturer_id = lecturer.id AND course.lecturer_id = :lecturerId AND lecturer.is_active = 1 AND course.is_active = 1 ORDER BY created_at DESC",
        nativeQuery = true
    )
    List<Course> getAllActiveCoursesByLecturerId(@Param("lecturerId") Long lecturerId);

    @Query(
        value = "SELECT course.* FROM courses course, lecturers lecturer WHERE course.lecturer_id = lecturer.id AND course.id = :courseId AND course.lecturer_id = :lecturerId AND lecturer.is_active = 1 AND course.is_active = 1",
        nativeQuery = true
    )
    List<Course> getActiveCourseByLecturerId(@Param("lecturerId") Long lecturerId, @Param("courseId") Long courseId);
}