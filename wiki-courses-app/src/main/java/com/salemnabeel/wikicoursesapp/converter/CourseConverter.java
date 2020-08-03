package com.salemnabeel.wikicoursesapp.converter;

import com.salemnabeel.wikicoursesapp.dto.CourseDto;
import com.salemnabeel.wikicoursesapp.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseConverter {

    public CourseDto entityToDto(Course course) {

        ModelMapper modelMapper = new ModelMapper();

        CourseDto courseDto = modelMapper.map(course, CourseDto.class);

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