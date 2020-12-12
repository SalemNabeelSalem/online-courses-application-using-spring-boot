package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoEdit;
import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoNew;
import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoView;
import com.salemnabeel.wikicoursesapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{lecturer-id}/all-courses")
    public List<CourseDtoView> getAllCoursesByLecturerId(@PathVariable("lecturer-id") Long lecturerId) {

        return courseService.getAllCoursesByLecturerId(lecturerId);
    }

    @GetMapping("/{lecturer-id}/active-courses")
    public List<CourseDtoView> getAllActiveCoursesByLecturerId(
            @PathVariable("lecturer-id") Long lecturerId) {

        return courseService.getAllActiveCoursesByLecturerId(lecturerId);
    }

    @GetMapping("/{classification-id}/all-active-courses")
    public List<CourseDtoView> getAllActiveCoursesByClassificationId(
            @PathVariable("classification-id") Long classificationId) {

        return courseService.getAllActiveCoursesByClassificationId(classificationId);
    }

    @PostMapping("/add-courses")
    public CourseDtoView createNewCourse(@RequestBody CourseDtoNew courseDtoNewRequest) {

        return courseService.createNewCourse(courseDtoNewRequest);
    }

    @PutMapping("/edit-course/{course-id}")
    public CourseDtoView updateCourseInfoById(@PathVariable("course-id") Long courseId,
                                              @RequestBody CourseDtoEdit courseDtoEditRequest) {

        return courseService.updateCourseInfoById(courseId, courseDtoEditRequest);
    }

    @DeleteMapping("/delete-course/{course-id}")
    public ResponseEntity deleteCourseById(@PathVariable("course-id") Long courseId) {

        return courseService.deleteCourseById(courseId);
    }
}