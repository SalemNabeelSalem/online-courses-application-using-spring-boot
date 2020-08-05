package com.salemnabeel.wikicoursesapp.converter;

import com.salemnabeel.wikicoursesapp.dto.CourseDto;
import com.salemnabeel.wikicoursesapp.model.Classification;
import com.salemnabeel.wikicoursesapp.model.Course;
import com.salemnabeel.wikicoursesapp.model.Lecturer;
import com.salemnabeel.wikicoursesapp.model.Section;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseConverter {

    public CourseDto entityToDto(Course course) {

        // ModelMapper modelMapper = new ModelMapper();

        // CourseDto courseDto = modelMapper.map(course, CourseDto.class);

        CourseDto courseDto = new CourseDto();

        courseDto.setId(course.getId());

        courseDto.setTitle(course.getTitle());

        courseDto.setSourceUrl(course.getSourceUrl());

        courseDto.setDescription(course.getDescription());

        Classification classification = course.getClassification();

        courseDto.setClassification(classification.getTitle());

        Section section = classification.getSection();

        courseDto.setSection(section.getTitle());

        Lecturer lecturer = course.getLecturer();

        courseDto.setLecturer(lecturer.getFullName());

        courseDto.setCreatedAtDate(course.getCreatedAt());

        return courseDto;
    }

    public List<CourseDto> entityToDto(List<Course> coursesList) {

        return coursesList.stream().map(
            course -> entityToDto(course)).collect(Collectors.toList()
        );
    }

    public Course dtoToEntity(CourseDto courseDto) {

        ModelMapper modelMapper = new ModelMapper();

        Course course = modelMapper.map(courseDto, Course.class);

        return course;
    }

    public List<Course> dtoToEntity(List<CourseDto> coursesDtoList) {

        return coursesDtoList.stream().map(
            courseDto -> dtoToEntity(courseDto)).collect(Collectors.toList()
        );
    }
}