package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.classification.ClassificationDtoEdit;
import com.salemnabeel.wikicoursesapp.dto.classification.ClassificationDtoNew;
import com.salemnabeel.wikicoursesapp.dto.classification.ClassificationDtoView;
import com.salemnabeel.wikicoursesapp.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @GetMapping("/all-classifications")
    public List<ClassificationDtoView> getAllClassifications() {

        return classificationService.getAllClassifications();
    }

    @GetMapping("/active-classifications")
    public List<ClassificationDtoView> getAllActiveClassifications() {

        return classificationService.getAllActiveClassifications();
    }

    @PostMapping("/add-classification")
    public ClassificationDtoView createNewClassification(@RequestBody ClassificationDtoNew classificationDtoNewRequest) {

        return classificationService.createNewClassification(classificationDtoNewRequest);
    }

    @PutMapping("/edit-classification/{classification-id}")
    public ClassificationDtoView updateClassificationInfoById(
            @PathVariable("classification-id") Long classificationId,
            @RequestBody ClassificationDtoEdit classificationDtoEditRequest) {

        return classificationService.updateClassificationInfoById(classificationId, classificationDtoEditRequest);
    }

    @DeleteMapping("/delete-classification/{classification-id}")
    public ResponseEntity deleteClassificationById(@PathVariable("classification-id") Long classificationId) {

        return classificationService.deleteClassificationById(classificationId);
    }
}