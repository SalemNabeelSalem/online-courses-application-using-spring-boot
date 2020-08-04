package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.converter.SectionConverter;
import com.salemnabeel.wikicoursesapp.dto.SectionDto;
import com.salemnabeel.wikicoursesapp.exception.ResourceNotFoundException;
import com.salemnabeel.wikicoursesapp.model.Section;
import com.salemnabeel.wikicoursesapp.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private SectionConverter sectionConverter;

    public List<SectionDto> getAllActiveSections() {

        List<Section> sectionsList = sectionRepository.getAllActiveSections();

        return  sectionConverter.entityToDto(sectionsList);
    }

    public SectionDto createNewSection(Section sectionRequest) {

        sectionRequest.setIsActive(true);

        return sectionConverter.entityToDto(
            sectionRepository.save(sectionRequest)
        );
    }

    public List<SectionDto> getActiveSectionById(Long sectionId) {

        List<Section> sectionsList = sectionRepository.getActiveSectionById(sectionId);

        return sectionConverter.entityToDto(sectionsList);
    }

    public SectionDto updateSectionInfoById(Long sectionId, Section sectionRequest) {

        if (sectionRepository.getActiveSectionById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Section section = sectionRepository.getActiveSectionById(sectionId).get(0);

        section.setTitle(sectionRequest.getTitle());

        return sectionConverter.entityToDto(
            sectionRepository.save(section)
        );
    }

    public ResponseEntity deActivateSectionById(Long sectionId) {

        if (sectionRepository.getActiveSectionById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Section section = sectionRepository.getActiveSectionById(sectionId).get(0);

        section.setIsActive(false);

        sectionRepository.save(section);

        return ResponseEntity.ok().build();
    }
}