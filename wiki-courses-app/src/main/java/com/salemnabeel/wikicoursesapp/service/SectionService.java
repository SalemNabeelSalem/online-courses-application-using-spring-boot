package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.mapper.SectionMapper;
import com.salemnabeel.wikicoursesapp.dto.view.SectionDto;
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
    private SectionMapper sectionMapper;

    public List<SectionDto> getAllActiveSections() {

        List<Section> sectionsList = sectionRepository.getAllActiveSections();

        return  sectionMapper.entityToDto(sectionsList);
    }

    public SectionDto createNewSection(Section sectionRequest) {

        sectionRequest.setIsActive(true);

        return sectionMapper.entityToDto(
            sectionRepository.save(sectionRequest)
        );
    }

    public List<SectionDto> getActiveSectionById(Long sectionId) {

        List<Section> sectionsList = sectionRepository.getActiveSectionById(sectionId);

        return sectionMapper.entityToDto(sectionsList);
    }

    public SectionDto updateSectionInfoById(Long sectionId, Section sectionRequest) {

        if (sectionRepository.getActiveSectionById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("resource not found.");
        }

        Section section = sectionRepository.getActiveSectionById(sectionId).get(0);

        section.setTitle(sectionRequest.getTitle());

        section.setCoverImageLink(sectionRequest.getCoverImageLink());

        return sectionMapper.entityToDto(
            sectionRepository.save(section)
        );
    }

    public ResponseEntity deActivateSectionById(Long sectionId) {

        if (sectionRepository.getActiveSectionById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("resource not found.");
        }

        Section section = sectionRepository.getActiveSectionById(sectionId).get(0);

        section.setIsActive(false);

        sectionRepository.save(section);

        return ResponseEntity.ok().build();
    }
}