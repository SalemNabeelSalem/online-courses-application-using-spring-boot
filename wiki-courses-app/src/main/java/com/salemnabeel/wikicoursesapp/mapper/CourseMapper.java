package com.salemnabeel.wikicoursesapp.mapper;

import com.salemnabeel.wikicoursesapp.dto.view.CourseDto;
import com.salemnabeel.wikicoursesapp.model.Classification;
import com.salemnabeel.wikicoursesapp.model.Course;
import com.salemnabeel.wikicoursesapp.model.Lecturer;
import com.salemnabeel.wikicoursesapp.model.Section;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    @Autowired
    TagMapper tagMapper;

    public CourseDto entityToDto(Course course) {

        // ModelMapper modelMapper = new ModelMapper();

        // CourseDto courseDto = modelMapper.map(course, CourseDto.class);

//        CourseDto courseDto = new CourseDto();

        // For Course Id
//        courseDto.setId(course.getId());

        // For Course Title
//        courseDto.setTitle(course.getTitle());

        // For Course Source Url
//        courseDto.setSourceUrl(course.getSourceUrl());

//        Classification classification = course.getClassification();

//        Section section = classification.getSection();

        // For Section Title
//        courseDto.setSection(section.getTitle());

        // For Classification Title
//        courseDto.setClassification(classification.getTitle());

        // For Course Description
//        courseDto.setDescription(course.getDescription());

        // For Course Cover Image Link
//        courseDto.setCoverImageLink(course.getCoverImageLink());

//        Lecturer lecturer = course.getLecturer();

        // For Lecturer Full Name
//        courseDto.setLecturer(lecturer.getFullName());

        // For Course Language
//        courseDto.setLanguage(course.getLanguage());

        // For Course Created Date
//        courseDto.setCreatedDate(course.getCreatedAt());

        // For The Course Tags
//        courseDto.setTags(tagMapper.entityToDto(course.getTags()));

        return null;
    }

    public List<CourseDto> entityToDto(List<Course> coursesList) {

//        return coursesList.stream().map(
//            course -> entityToDto(course)
//        ).collect(Collectors.toList());

        return null;
    }

    public Course dtoToEntity(CourseDto courseDto) {

//        ModelMapper modelMapper = new ModelMapper();
//
//        Course course = modelMapper.map(courseDto, Course.class);
//
        return null;
    }

    public List<Course> dtoToEntity(List<CourseDto> coursesDtoList) {

//        return coursesDtoList.stream().map(
//            courseDto -> dtoToEntity(courseDto)
//        ).collect(Collectors.toList());

        return null;
    }
}