package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoNew;
import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoView;
import com.salemnabeel.wikicoursesapp.exception.ResourceNotFoundException;
import com.salemnabeel.wikicoursesapp.mapper.CourseMapper;
import com.salemnabeel.wikicoursesapp.model.Classification;
import com.salemnabeel.wikicoursesapp.model.Course;
import com.salemnabeel.wikicoursesapp.model.Lecturer;
import com.salemnabeel.wikicoursesapp.repository.ClassificationRepository;
import com.salemnabeel.wikicoursesapp.repository.CourseRepository;
import com.salemnabeel.wikicoursesapp.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClassificationRepository classificationRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    public List<CourseDtoView> getAllCourses() {

        List<Course> coursesList = courseRepository.findAll();

        coursesList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return CourseMapper.entityToDto(coursesList);
    }

    public List<CourseDtoView> getAllActiveCourses() {

        List<Course> coursesList = courseRepository.getAllActiveCourses();

        coursesList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return CourseMapper.entityToDto(coursesList);
    }

    public CourseDtoView createNewCourse(CourseDtoNew courseDtoNew) {

        Long classificationId = courseDtoNew.getClassificationId();

        if (classificationRepository.findById(classificationId).isEmpty()) {

            throw new ResourceNotFoundException("classification resource not found.");
        }

        Long lecturerId = courseDtoNew.getLecturerId();

        if (lecturerRepository.findById(lecturerId).isEmpty()) {

            throw new ResourceNotFoundException("lecturer resource not found.");
        }

        Classification classification = classificationRepository.findById(classificationId).get();

        Lecturer lecturer = lecturerRepository.findById(lecturerId).get();

        Course course = new Course();

        course.setTitle(courseDtoNew.getTitle());

        course.setSourceUrl(courseDtoNew.getSourceUrl());

        course.setClassification(classification);

        course.setDescription(courseDtoNew.getDescription());

        course.setCoverImageLink(courseDtoNew.getCoverImageLink());

        course.setLecturer(lecturer);

        course.setLanguage(courseDtoNew.getLanguage());

        course.setIsActive(true);

        return CourseMapper.entityToDto(courseRepository.save(course));
    }
}