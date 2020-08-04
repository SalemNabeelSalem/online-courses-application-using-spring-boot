package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.CourseDto;
import com.salemnabeel.wikicoursesapp.model.Course;
import com.salemnabeel.wikicoursesapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/lecturers/{lecturer-id}/courses")
    public List<CourseDto> getAllActiveCoursesByLecturerId(@PathVariable("lecturer-id") Long lecturerId) {

        return courseService.getAllActiveCoursesByLecturerId(lecturerId);
    }

    @PostMapping("/lecturers/{lecturer-id}/courses")
    public CourseDto createNewCourseByLecturerId(@PathVariable("lecturer-id") Long lecturerId,
                                                 @Valid @RequestBody Course courseRequest) {

        return courseService.createNewCourseByLecturerId(lecturerId, courseRequest);
    }

    @GetMapping("/lecturers/{lecturer-id}/courses/{course-id}")
    public List<CourseDto> getActiveCourseByLecturerId(@PathVariable("lecturer-id") Long lecturerId,
                                                       @PathVariable("course-id") Long courseId) {

        return courseService.getActiveCourseByLecturerId(lecturerId, courseId);
    }

    @PutMapping("/lecturers/{lecturer-id}/courses/{course-id}")
    public CourseDto updateCourseInfoByLecturerId(@PathVariable("lecturer-id") Long lecturerId,
                                                  @PathVariable("course-id") Long courseId,
                                                  @Valid @RequestBody Course courseRequest) {

        return courseService.updateCourseInfoByLecturerId(lecturerId, courseId, courseRequest);
    }

    @DeleteMapping("/lecturers/{lecturer-id}/courses/{course-id}")
    public ResponseEntity deActivateCourseByLecturerId(@PathVariable("lecturer-id") Long lecturerId,
                                                       @PathVariable("course-id") Long courseId) {

        return courseService.deActivateCourseByLecturerId(lecturerId, courseId);
    }
}