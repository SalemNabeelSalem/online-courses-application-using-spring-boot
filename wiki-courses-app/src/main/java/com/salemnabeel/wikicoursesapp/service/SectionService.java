package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.mapper.SectionMapper;
import com.salemnabeel.wikicoursesapp.dto.section.SectionDtoView;
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

    public List<SectionDtoView> getAllSections() {

        return SectionMapper.entityToDto(sectionRepository.findAll());
    }

    public List<SectionDtoView> getAllActiveSections() {

        return  SectionMapper.entityToDto(sectionRepository.getAllActiveSections());
    }

    public SectionDtoView createNewSection(Section sectionRequest) {

        sectionRequest.setIsActive(true);

        return SectionMapper.entityToDto(sectionRepository.save(sectionRequest));
    }

    public SectionDtoView updateSectionInfoById(Long sectionId, Section sectionRequest) {

        if (sectionRepository.findById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("section resource not found.");
        }

        Section section = sectionRepository.findById(sectionId).get();

        section.setTitle(sectionRequest.getTitle());

        section.setBrief(sectionRequest.getBrief());

        section.setCoverImageLink(sectionRequest.getCoverImageLink());

        section.setIsActive(sectionRequest.getIsActive());

        return SectionMapper.entityToDto(sectionRepository.save(section));
    }

    public ResponseEntity deleteSectionById(Long sectionId) {

        if (sectionRepository.findById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("section resource not found.");
        }

        Section section = sectionRepository.findById(sectionId).get();

        sectionRepository.delete(section);

        return ResponseEntity.ok().build();
    }
}