package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoEdit;
import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoNew;
import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoView;
import com.salemnabeel.wikicoursesapp.dto.tag.TagCourseDtoView;
import com.salemnabeel.wikicoursesapp.exception.ResourceNotFoundException;
import com.salemnabeel.wikicoursesapp.mapper.CourseMapper;
import com.salemnabeel.wikicoursesapp.model.Classification;
import com.salemnabeel.wikicoursesapp.model.Course;
import com.salemnabeel.wikicoursesapp.model.Lecturer;
import com.salemnabeel.wikicoursesapp.model.Tag;
import com.salemnabeel.wikicoursesapp.repository.ClassificationRepository;
import com.salemnabeel.wikicoursesapp.repository.CourseRepository;
import com.salemnabeel.wikicoursesapp.repository.LecturerRepository;
import com.salemnabeel.wikicoursesapp.repository.TagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClassificationRepository classificationRepository;

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CourseDtoView> getAllCourses() {

        List<Course> coursesList = courseRepository.findAll();

        coursesList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        List<CourseDtoView> courseDtoViews = CourseMapper.entityToDto(coursesList);

        courseDtoViews.stream().map(obj1 -> {

            List<Tag> tagsList = tagRepository.findAllByCourseId(obj1.getId()).orElse(new ArrayList<>());

            List<TagCourseDtoView> tagCourseDtoViewList = tagsList.stream().map(
                obj2 -> this.modelMapper.map(obj2, TagCourseDtoView.class)
            ).collect(Collectors.toList());

            obj1.setTagsList(tagCourseDtoViewList);

            return true;

        }).collect(Collectors.toList());

        return courseDtoViews;
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

        Classification classification = classificationRepository.findById(classificationId).get();

        Long lecturerId = courseDtoNew.getLecturerId();

        if (lecturerRepository.findById(lecturerId).isEmpty()) {

            throw new ResourceNotFoundException("lecturer resource not found.");
        }

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

    public CourseDtoView updateCourseInfoById(Long courseId, CourseDtoEdit courseDtoEdit) {

        if (courseRepository.findById(courseId).isEmpty()) {

            throw new ResourceNotFoundException("course resource not found.");
        }

        Course course = courseRepository.findById(courseId).get();

        Long classificationId = courseDtoEdit.getClassificationId();

        if (classificationRepository.findById(classificationId).isEmpty()) {

            throw new ResourceNotFoundException("classification resource not found.");
        }

        Classification classification = classificationRepository.findById(classificationId).get();

        Long lecturerId = courseDtoEdit.getLecturerId();

        if (lecturerRepository.findById(lecturerId).isEmpty()) {

            throw new ResourceNotFoundException("lecturer resource not found.");
        }

        Lecturer lecturer = lecturerRepository.findById(lecturerId).get();

        course.setTitle(courseDtoEdit.getTitle());

        course.setSourceUrl(courseDtoEdit.getSourceUrl());

        course.setClassification(classification);

        course.setDescription(courseDtoEdit.getDescription());

        course.setCoverImageLink(courseDtoEdit.getCoverImageLink());

        course.setLecturer(lecturer);

        course.setLanguage(courseDtoEdit.getLanguage());

        course.setIsActive(courseDtoEdit.getIsActive());

        return CourseMapper.entityToDto(courseRepository.save(course));
    }

    public ResponseEntity deleteCourseById(Long courseId) {

        if (courseRepository.findById(courseId).isEmpty()) {

            throw new ResourceNotFoundException("course resource not found.");
        }

        Course course = courseRepository.findById(courseId).get();

        courseRepository.delete(course);

        return ResponseEntity.ok().build();
    }
}