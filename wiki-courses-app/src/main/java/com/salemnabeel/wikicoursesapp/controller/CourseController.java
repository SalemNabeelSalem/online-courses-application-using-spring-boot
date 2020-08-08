package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.create.CourseDtoCreate;
import com.salemnabeel.wikicoursesapp.dto.view.CourseDto;
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

    @GetMapping("/sections/{section-id}/classifications/{classification-id}/courses")
    public List<CourseDto> getAllActiveCoursesBySectionAndClassificationId(
                                            @PathVariable("section-id") Long sectionId,
                                            @PathVariable("classification-id") Long classificationId) {

        return courseService.getAllActiveCoursesBySectionAndClassificationId(sectionId, classificationId);
    }

    @GetMapping("/lecturers/{lecturer-id}/courses")
    public List<CourseDto> getAllActiveCoursesByLecturerId(@PathVariable("lecturer-id") Long lecturerId) {

        return courseService.getAllActiveCoursesByLecturerId(lecturerId);
    }

    // TODO: Make This URL For The Admin Access Only.
    @PostMapping("/courses")
    public CourseDto createNewCourse(@RequestBody CourseDtoCreate courseDtoCreateRequest) {

        return courseService.createNewCourse(courseDtoCreateRequest);
    }

    @GetMapping("/lecturers/{lecturer-id}/courses/{course-id}")
    public List<CourseDto> getActiveCourseByLecturerId(@PathVariable("lecturer-id") Long lecturerId,
                                                       @PathVariable("course-id") Long courseId) {

        return courseService.getActiveCourseByLecturerId(lecturerId, courseId);
    }

    // TODO: Make This URL For The Admin Access Only.
    @PutMapping("/lecturers/{lecturer-id}/courses/{course-id}")
    public CourseDto updateCourseInfoByLecturerId(@PathVariable("lecturer-id") Long lecturerId,
                                                  @PathVariable("course-id") Long courseId,
                                                  @Valid @RequestBody Course courseRequest) {

        return courseService.updateCourseInfoByLecturerId(lecturerId, courseId, courseRequest);
    }

    // TODO: Make This URL For The Admin Access Only.
    @DeleteMapping("/lecturers/{lecturer-id}/courses/{course-id}")
    public ResponseEntity deActivateCourseByLecturerId(@PathVariable("lecturer-id") Long lecturerId,
                                                       @PathVariable("course-id") Long courseId) {

        return courseService.deActivateCourseByLecturerId(lecturerId, courseId);
    }
}