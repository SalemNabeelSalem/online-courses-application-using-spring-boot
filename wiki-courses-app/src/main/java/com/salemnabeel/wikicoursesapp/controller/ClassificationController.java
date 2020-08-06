package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.ClassificationCreateNew;
import com.salemnabeel.wikicoursesapp.dto.ClassificationDto;
import com.salemnabeel.wikicoursesapp.model.Classification;
import com.salemnabeel.wikicoursesapp.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @GetMapping("/sections/{section-id}/classifications")
    public List<ClassificationDto> getAllActiveClassificationsBySectionId(@PathVariable("section-id") Long sectionId) {

        return classificationService.getAllActiveClassificationsBySectionId(sectionId);
    }

    // TODO: Make This URL For The Admin Access Only.
    @PostMapping("/classifications")
    public ClassificationDto createNewClassification(@RequestBody ClassificationCreateNew classificationCreateNewRequest) {

        return classificationService.createNewClassification(classificationCreateNewRequest);
    }

    @GetMapping("/sections/{section-id}/classifications/{classification-id}")
    public List<ClassificationDto> getActiveClassificationBySectionId(@PathVariable("section-id") Long sectionId,
                                                                      @PathVariable("classification-id") Long classificationId) {

        return classificationService.getActiveClassificationBySectionId(sectionId, classificationId);
    }

    // TODO: Make This URL For The Admin Access Only.
    @PutMapping("/sections/{section-id}/classifications/{classification-id}")
    public ClassificationDto updateClassificationInfoBySectionId(@PathVariable("section-id") Long sectionId,
                                                                 @PathVariable("classification-id") Long classificationId,
                                                                 @Valid @RequestBody Classification classificationRequest) {

        return classificationService.updateClassificationInfoBySectionId(
            sectionId, classificationId, classificationRequest
        );
    }

    // TODO: Make This URL For The Admin Access Only.
    @DeleteMapping("/sections/{section-id}/classifications/{classification-id}")
    public ResponseEntity deActivateClassificationBySectionId(@PathVariable("section-id") Long sectionId,
                                                  @PathVariable("classification-id") Long classificationId) {

        return classificationService.deActivateClassificationBySectionId(sectionId, classificationId);
    }
}