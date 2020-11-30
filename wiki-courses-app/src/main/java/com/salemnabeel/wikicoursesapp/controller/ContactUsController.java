package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;
}