package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.mapper.CourseMapper;
import com.salemnabeel.wikicoursesapp.dto.CourseDto;
import com.salemnabeel.wikicoursesapp.exception.ResourceNotFoundException;
import com.salemnabeel.wikicoursesapp.model.Course;
import com.salemnabeel.wikicoursesapp.model.Lecturer;
import com.salemnabeel.wikicoursesapp.repository.CourseRepository;
import com.salemnabeel.wikicoursesapp.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private CourseMapper courseMapper;

    public List<CourseDto> getAllActiveCoursesByLecturerId(Long lecturerId) {

        List<Course> coursesList = courseRepository.getAllActiveCoursesByLecturerId(lecturerId);

        return courseMapper.entityToDto(coursesList);
    }

    public CourseDto createNewCourseByLecturerId(Long lecturerId, Course courseRequest) {

        if (lecturerRepository.getActiveLecturerById(lecturerId).isEmpty()) {

            throw new ResourceNotFoundException("lecturer id: " + lecturerId + " not found.");
        }

        Lecturer lecturer = lecturerRepository.getActiveLecturerById(lecturerId).get(0);

        courseRequest.setIsActive(true);

        courseRequest.setLecturer(lecturer);

        return courseMapper.entityToDto(
            courseRepository.save(courseRequest)
        );
    }

    public List<CourseDto> getActiveCourseByLecturerId(Long lecturerId, Long courseId) {

        List<Course> coursesList = courseRepository.getActiveCourseByLecturerId(lecturerId, courseId);

        return courseMapper.entityToDto(coursesList);
    }

    public CourseDto updateCourseInfoByLecturerId(Long lecturerId, Long courseId, Course courseRequest) {

        if (courseRepository.getActiveCourseByLecturerId(lecturerId, courseId).isEmpty()) {

            throw new ResourceNotFoundException("resource not found.");
        }

        Course course = courseRepository.getActiveCourseByLecturerId(lecturerId, courseId).get(0);

        course.setTitle(courseRequest.getTitle());

        course.setSourceUrl(courseRequest.getSourceUrl());

        course.setDescription(courseRequest.getDescription());

        return courseMapper.entityToDto(
            courseRepository.save(course)
        );
    }

    public ResponseEntity deActivateCourseByLecturerId(Long lecturerId, Long courseId) {

        if (courseRepository.getActiveCourseByLecturerId(lecturerId, courseId).isEmpty()) {

            throw new ResourceNotFoundException("resource not found.");
        }

        Course course = courseRepository.getActiveCourseByLecturerId(lecturerId, courseId).get(0);

        course.setIsActive(false);

        courseRepository.save(course);

        return ResponseEntity.ok().build();
    }
}