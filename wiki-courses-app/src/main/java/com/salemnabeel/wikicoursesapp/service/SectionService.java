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
import java.util.stream.Collectors;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public List<SectionDtoView> getAllSections() {

        List<Section> sectionsList = sectionRepository.findAll();

        sectionsList.sort((o1, o2) -> o2.getId().compareTo(o1.getId()));

        return SectionMapper.entityToDto(sectionsList);
    }

    public List<SectionDtoView> getAllActiveSections() {

        List<Section> sectionsList = sectionRepository.getAllActiveSections();

        sectionsList.sort((o1, o2) -> o2.getId().compareTo(o1.getId()));

        return  SectionMapper.entityToDto(sectionsList);
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