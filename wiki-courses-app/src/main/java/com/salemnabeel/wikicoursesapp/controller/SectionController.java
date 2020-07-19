package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.model.Section;
import com.salemnabeel.wikicoursesapp.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/sections/{section-title}")
    public Section getSectionByTitle(@PathVariable(value = "section-title") String sectionTitle) {

        return sectionService.getSectionByTitle(sectionTitle);
    }

    @PostMapping("/sections")
    public Section createNewSection(@Valid @RequestBody Section sectionRequest) {

        return sectionService.createNewSection(sectionRequest);
    }

    @PutMapping("/sections/{section-id}")
    public Section updateSectionInfo(@PathVariable(value = "section-id") Long sectionId,
                                     @Valid @RequestBody Section sectionRequest) {

        return sectionService.updateSectionInfo(sectionId, sectionRequest);
    }
}