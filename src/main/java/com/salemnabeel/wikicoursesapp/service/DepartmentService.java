package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
}