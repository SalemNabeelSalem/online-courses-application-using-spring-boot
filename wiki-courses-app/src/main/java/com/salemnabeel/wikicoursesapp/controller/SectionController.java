package com.salemnabeel.wikicoursesapp.controller;

import com.salemnabeel.wikicoursesapp.dto.SectionDto;
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
    public List<SectionDto> getAllActiveSections() {

        return sectionService.getAllActiveSections();
    }

    // TODO: Make This URL For The Admin Access Only.
    @PostMapping("/sections")
    public SectionDto createNewSection(@Valid @RequestBody Section sectionRequest) {

        return sectionService.createNewSection(sectionRequest);
    }

    @GetMapping("/sections/{section-id}")
    public List<SectionDto> getActiveSectionById(@PathVariable("section-id") Long sectionId) {

        return sectionService.getActiveSectionById(sectionId);
    }

    // TODO: Make This URL For The Admin Access Only.
    @PutMapping("/sections/{section-id}")
    public SectionDto updateSectionInfoById(@PathVariable("section-id") Long sectionId,
                                            @Valid @RequestBody Section sectionRequest) {

        return sectionService.updateSectionInfoById(sectionId, sectionRequest);
    }

    // TODO: Make This URL For The Admin Access Only.
    @DeleteMapping("/sections/{section-id}")
    public ResponseEntity deActivateSectionById(@PathVariable("section-id") Long sectionId) {

        return sectionService.deActivateSectionById(sectionId);
    }
}