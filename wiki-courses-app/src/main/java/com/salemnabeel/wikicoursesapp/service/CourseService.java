package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.converter.CourseConverter;
import com.salemnabeel.wikicoursesapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseConverter courseConverter;
}