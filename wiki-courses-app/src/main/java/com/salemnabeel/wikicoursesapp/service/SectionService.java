package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.mapper.section.SectionMapper;
import com.salemnabeel.wikicoursesapp.dto.section.SectionDto;
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

    public List<SectionDto> getAllSections() {

        return SectionMapper.entityToDto(sectionRepository.findAll());
    }

    public List<SectionDto> getAllActiveSections() {

        return  SectionMapper.entityToDto(sectionRepository.getAllActiveSections());
    }

    public SectionDto createNewSection(Section sectionRequest) {

        sectionRequest.setIsActive(true);

        return SectionMapper.entityToDto(sectionRepository.save(sectionRequest));
    }

    public List<SectionDto> getActiveSectionById(Long sectionId) {

        List<Section> sectionsList = sectionRepository.getActiveSectionById(sectionId);

        return SectionMapper.entityToDto(sectionsList);
    }

    public SectionDto updateSectionInfoById(Long sectionId, Section sectionRequest) {

        if (sectionRepository.getActiveSectionById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("resource not found.");
        }

        Section section = sectionRepository.getActiveSectionById(sectionId).get(0);

        section.setTitle(sectionRequest.getTitle());

        section.setCoverImageLink(sectionRequest.getCoverImageLink());

        return SectionMapper.entityToDto(
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