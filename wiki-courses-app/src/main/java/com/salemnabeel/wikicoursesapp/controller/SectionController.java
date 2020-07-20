package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.model.Section;
import com.salemnabeel.wikicoursesapp.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping("/sections")
    public List<Section> getAllActiveSections() {

        return sectionService.getAllActiveSections();
    }

    @GetMapping("/sections/{section-id}")
    public Section getSectionById(@PathVariable("section-id") Long sectionId) {

        return sectionService.getSectionById(sectionId);
    }

    @PostMapping("/sections")
    public Section createNewSection(@Valid @RequestBody Section sectionRequest) {

        return sectionService.createNewSection(sectionRequest);
    }

    @PutMapping("/sections/{section-id}")
    public Section updateSectionInfo(@PathVariable("section-id") Long sectionId,
                                     @Valid @RequestBody Section sectionRequest) {

        return sectionService.updateSectionInfo(sectionId, sectionRequest);
    }

    @DeleteMapping("/sections/{section-id}")
    public ResponseEntity deActivateSection(@PathVariable("section-id") Long sectionId) {

        return sectionService.deActivateSection(sectionId);
    }
}