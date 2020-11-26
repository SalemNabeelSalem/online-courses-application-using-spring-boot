package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoView;
import com.salemnabeel.wikicoursesapp.mapper.CourseMapper;
import com.salemnabeel.wikicoursesapp.model.Course;
import com.salemnabeel.wikicoursesapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

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

    public Course createNewCourse(Course courseRequest) {

        courseRequest.setIsActive(true);
        return courseRepository.save(courseRequest);
    }
}