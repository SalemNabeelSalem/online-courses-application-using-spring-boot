package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.ContactUs.ContactUsDtoNew;
import com.salemnabeel.wikicoursesapp.dto.ContactUs.ContactUsDtoView;
import com.salemnabeel.wikicoursesapp.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @PostMapping("add-contact-us-message")
    public ContactUsDtoView createNewContactUsMessage(@RequestBody ContactUsDtoNew contactUsDtoNewRequest) {

        return contactUsService.createNewContactUsMessage(contactUsDtoNewRequest);
    }
}