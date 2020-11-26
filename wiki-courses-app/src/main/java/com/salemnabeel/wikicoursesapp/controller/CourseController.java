package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoNew;
import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoView;
import com.salemnabeel.wikicoursesapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all-courses")
    public List<CourseDtoView> getAllCourses() {

        return courseService.getAllCourses();
    }

    @GetMapping("/active-courses")
    public List<CourseDtoView> getAllActiveCourses() {

        return courseService.getAllActiveCourses();
    }

    @PostMapping("/add-courses")
    public CourseDtoView createNewCourse(@RequestBody CourseDtoNew courseDtoNewRequest) {

        return courseService.createNewCourse(courseDtoNewRequest);
    }
}