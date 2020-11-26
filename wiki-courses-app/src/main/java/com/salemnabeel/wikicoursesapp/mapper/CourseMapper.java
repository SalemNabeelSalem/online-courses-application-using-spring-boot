package com.salemnabeel.wikicoursesapp.mapper;

import com.salemnabeel.wikicoursesapp.dto.course.CourseDtoView;
import com.salemnabeel.wikicoursesapp.model.Course;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    public static ModelMapper modelMapper = new ModelMapper();

    public static CourseDtoView entityToDto(Course course) {

        CourseDtoView courseDtoView = modelMapper.map(course, CourseDtoView.class);

        return courseDtoView;
    }

    public static List<CourseDtoView> entityToDto(List<Course> coursesList) {

        return coursesList.stream().map(
            obj -> entityToDto(obj)
        ).collect(Collectors.toList());
    }

    public static Course dtoToEntity(CourseDtoView courseDtoView) {

        Course course = modelMapper.map(courseDtoView, Course.class);

        return course;
    }

    public static List<Course> dtoToEntity(List<CourseDtoView> coursesDtoList) {

        return coursesDtoList.stream().map(
            obj -> dtoToEntity(obj)
        ).collect(Collectors.toList());
    }
}