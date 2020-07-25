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

    public SectionDto getSectionById(Long sectionId) {

        if (!sectionRepository.existsById(sectionId)) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Section section = sectionRepository.getSectionById(sectionId);

        return sectionConverter.entityToDto(section);
    }

    public SectionDto createNewSection(Section sectionRequest) {

        sectionRequest.setIsActive(true);

        return sectionConverter.entityToDto(
            sectionRepository.save(sectionRequest)
        );
    }

    public SectionDto updateSectionInfo(Long sectionId, Section sectionRequest) {

        if (!sectionRepository.existsById(sectionId)) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Section section = sectionRepository.findById(sectionId).get();

        section.setTitle(sectionRequest.getTitle());

        return sectionConverter.entityToDto(
            sectionRepository.save(section)
        );
    }

    public ResponseEntity deActivateSection(Long sectionId) {

        if (!sectionRepository.existsById(sectionId)) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Section section = sectionRepository.findById(sectionId).get();

        section.setIsActive(false);

        sectionRepository.save(section);

        return ResponseEntity.ok().build();
    }
}