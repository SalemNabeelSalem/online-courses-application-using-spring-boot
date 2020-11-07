package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.section.SectionDtoView;
import com.salemnabeel.wikicoursesapp.model.Section;
import com.salemnabeel.wikicoursesapp.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping("/all-sections")
    public List<SectionDtoView> getAllSections() {

        return sectionService.getAllSections();
    }

    @GetMapping("/active-sections")
    public List<SectionDtoView> getAllActiveSections() {

        return sectionService.getAllActiveSections();
    }

    @PostMapping("/add-section")
    public SectionDtoView createNewSection(@Valid @RequestBody Section sectionRequest) {

        return sectionService.createNewSection(sectionRequest);
    }

    @PutMapping("/edit-section/{section-id}")
    public SectionDtoView updateSectionInfoById(@PathVariable("section-id") Long sectionId,
                                                @Valid @RequestBody Section sectionRequest) {

        return sectionService.updateSectionInfoById(sectionId, sectionRequest);
    }

    @DeleteMapping("/delete-section/{section-id}")
    public ResponseEntity deleteSectionById(@PathVariable("section-id") Long sectionId) {

        return sectionService.deleteSectionById(sectionId);
    }
}