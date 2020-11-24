package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.dto.create.CourseDtoCreate;
import com.salemnabeel.wikicoursesapp.mapper.CourseMapper;
import com.salemnabeel.wikicoursesapp.dto.view.CourseDto;
import com.salemnabeel.wikicoursesapp.exception.ResourceNotFoundException;
import com.salemnabeel.wikicoursesapp.model.Classification;
import com.salemnabeel.wikicoursesapp.model.Course;
import com.salemnabeel.wikicoursesapp.model.Lecturer;
import com.salemnabeel.wikicoursesapp.model.enums.Language;
import com.salemnabeel.wikicoursesapp.repository.ClassificationRepository;
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
    private ClassificationRepository classificationRepository;

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }

//    public List<CourseDto> getAllActiveCoursesBySectionAndClassificationId(Long sectionId, Long classificationId) {
//
//        List<Course> coursesList = courseRepository.getAllActiveCoursesBySectionAndClassificationId(
//                sectionId, classificationId);
//
//        return courseMapper.entityToDto(coursesList);
//    }
//
//    public List<CourseDto> getAllActiveCoursesByLecturerId(Long lecturerId) {
//
//        List<Course> coursesList = courseRepository.getAllActiveCoursesByLecturerId(lecturerId);
//
//        return courseMapper.entityToDto(coursesList);
//    }
//
//    public CourseDto createNewCourse(CourseDtoCreate courseDtoCreateRequest) {
//
//        String courseTitle = courseDtoCreateRequest.getTitle();
//
//        String courseSourceUrl = courseDtoCreateRequest.getSourceUrl();
//
//        String courseDescription = courseDtoCreateRequest.getDescription();
//
//        String courseCoverImageLink = courseDtoCreateRequest.getCoverImageLink();
//
//        Language courseLanguage = courseDtoCreateRequest.getLanguage();
//
//        Long classificationId = courseDtoCreateRequest.getClassificationId();
//
//        Classification classification = classificationRepository.findById(classificationId).get();
//
//        Long sectionId = classification.getSection().getId();
//
//        Long lecturerId = courseDtoCreateRequest.getLecturerId();
//
//        if (lecturerRepository.getActiveLecturerById(lecturerId).isEmpty() ||
//            classificationRepository.getActiveClassificationBySectionId(sectionId, classificationId).isEmpty()) {
//
//            throw new ResourceNotFoundException("resource not found.");
//        }
//
//        Lecturer lecturer = lecturerRepository.getActiveLecturerById(lecturerId).get(0);
//
//        classification = classificationRepository.getActiveClassificationBySectionId(sectionId, classificationId).get(0);
//
//        Course course = new Course();
//
//        course.setTitle(courseTitle);
//
//        course.setSourceUrl(courseSourceUrl);
//
//        course.setClassification(classification);
//
//        course.setDescription(courseDescription);
//
//        course.setCoverImageLink(courseCoverImageLink);
//
//        course.setLecturer(lecturer);
//
//        course.setLanguage(courseLanguage);
//
//        course.setIsActive(true);
//
//        return courseMapper.entityToDto(
//            courseRepository.save(course)
//        );
//    }
//
//    public List<CourseDto> getActiveCourseByLecturerId(Long lecturerId, Long courseId) {
//
//        List<Course> coursesList = courseRepository.getActiveCourseByLecturerId(lecturerId, courseId);
//
//        return courseMapper.entityToDto(coursesList);
//    }
//
//    public CourseDto updateCourseInfoByLecturerId(Long lecturerId, Long courseId, Course courseRequest) {
//
//        if (courseRepository.getActiveCourseByLecturerId(lecturerId, courseId).isEmpty()) {
//
//            throw new ResourceNotFoundException("resource not found.");
//        }
//
//        Course course = courseRepository.getActiveCourseByLecturerId(lecturerId, courseId).get(0);
//
//        course.setTitle(courseRequest.getTitle());
//
//        course.setSourceUrl(courseRequest.getSourceUrl());
//
//        course.setDescription(courseRequest.getDescription());
//
//        return courseMapper.entityToDto(
//            courseRepository.save(course)
//        );
//    }
//
//    public ResponseEntity deActivateCourseByLecturerId(Long lecturerId, Long courseId) {
//
//        if (courseRepository.getActiveCourseByLecturerId(lecturerId, courseId).isEmpty()) {
//
//            throw new ResourceNotFoundException("resource not found.");
//        }
//
//        Course course = courseRepository.getActiveCourseByLecturerId(lecturerId, courseId).get(0);
//
//        course.setIsActive(false);
//
//        courseRepository.save(course);
//
//        return ResponseEntity.ok().build();
//    }
}