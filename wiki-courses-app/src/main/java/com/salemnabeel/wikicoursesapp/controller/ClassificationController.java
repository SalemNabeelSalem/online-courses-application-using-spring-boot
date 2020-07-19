package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;


}