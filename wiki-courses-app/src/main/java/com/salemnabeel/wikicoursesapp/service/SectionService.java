package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.exception.ResourceNotFoundException;
import com.salemnabeel.wikicoursesapp.model.Section;
import com.salemnabeel.wikicoursesapp.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> getAllActiveSections() {

        return sectionRepository.getAllActiveSections();
    }

    public Section getSectionByTitle(String sectionTitle) {

        return sectionRepository.getSectionByTitle(sectionTitle);
    }

    public Section createNewSection(Section sectionRequest) {

        sectionRequest.setIsActive(true);

        return sectionRepository.save(sectionRequest);
    }

    public Section updateSectionInfo(Long sectionId, Section sectionRequest) {

        if (!sectionRepository.existsById(sectionId)) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Section section = sectionRepository.findById(sectionId).get();

        section.setTitle(sectionRequest.getTitle());

        return sectionRepository.save(section);
    }
}