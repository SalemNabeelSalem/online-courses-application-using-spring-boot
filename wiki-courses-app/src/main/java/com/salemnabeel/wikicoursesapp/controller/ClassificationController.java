package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.model.Classification;
import com.salemnabeel.wikicoursesapp.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @GetMapping("/sections/{section-id}/classifications")
    public List<Classification> getAllActiveClassificationsBySectionId(@PathVariable("section-id") Long sectionId) {

        return classificationService.getAllActiveClassificationsBySectionId(sectionId);
    }

    @PostMapping("/sections/{section-id}/classifications")
    public Classification createNewClassificationBySectionId(@PathVariable("section-id") Long sectionId,
                                                 @Valid @RequestBody Classification classificationRequest) {

        return classificationService.createNewClassificationBySectionId(sectionId, classificationRequest);
    }
}