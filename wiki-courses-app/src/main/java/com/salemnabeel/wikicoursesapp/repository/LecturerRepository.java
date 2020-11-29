package com.salemnabeel.wikicoursesapp.repository;

import com.salemnabeel.wikicoursesapp.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

    @Query(value = "SELECT * FROM lecturers WHERE is_active = 1", nativeQuery = true)
    List<Lecturer> getAllActiveLecturers();

    @Query(value = "SELECT * FROM lecturers WHERE id = :lecturerId AND is_active = 1", nativeQuery = true)
    List<Lecturer> getActiveLecturerById(@Param("lecturerId") Long lecturerId);

    @Query(value = "SELECT \n" +
            "\t(SELECT COUNT(*) FROM lecturers ) AS total_lecturer, \n" +
            "    (SELECT COUNT(*) FROM lecturers WHERE is_active = 1) AS active_lecturers,\n" +
            "\t(SELECT COUNT(*) FROM lecturers WHERE is_active = 0) AS not_active_lecturers", nativeQuery = true)
    Optional<List<Object[]>> getLecturerStatics();
}