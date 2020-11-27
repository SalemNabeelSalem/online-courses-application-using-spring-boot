package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;
}