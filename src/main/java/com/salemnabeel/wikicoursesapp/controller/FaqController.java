package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.Faq.FaqDtoNew;
import com.salemnabeel.wikicoursesapp.dto.Faq.ImprovedFaqAnswer;
import com.salemnabeel.wikicoursesapp.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FaqController {

    @Autowired
    private FaqService faqService;

    @PostMapping("add-contact-us-message")
    public FaqDtoNew createNewFaq(@RequestBody FaqDtoNew faqDtoNewRequest) {

        return faqService.createNewFaq(faqDtoNewRequest);
    }

    @GetMapping("/all-answered-faq")
    public List<ImprovedFaqAnswer> getAllImprovedFaqAnswers() {

        return faqService.getAllImprovedFaqAnswers();
    }
}