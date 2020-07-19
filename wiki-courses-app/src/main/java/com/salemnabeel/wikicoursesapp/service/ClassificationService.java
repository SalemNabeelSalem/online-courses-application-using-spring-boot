package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.repository.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassificationService {

    @Autowired
    private ClassificationRepository classificationRepository;

}