package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.ContactUs.ContactUsDtoNew;
import com.salemnabeel.wikicoursesapp.dto.ContactUs.ImprovedFaqAnswer;
import com.salemnabeel.wikicoursesapp.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsService;

    @PostMapping("add-contact-us-message")
    public ContactUsDtoNew createNewContactUsMessage(@RequestBody ContactUsDtoNew contactUsDtoNewRequest) {

        return contactUsService.createNewContactUsMessage(contactUsDtoNewRequest);
    }

    @GetMapping("/all-answered-faq")
    public List<ImprovedFaqAnswer> getAllImprovedFaqAnswers() {

        return contactUsService.getAllImprovedFaqAnswers();
    }
}