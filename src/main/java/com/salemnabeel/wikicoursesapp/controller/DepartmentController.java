package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
}