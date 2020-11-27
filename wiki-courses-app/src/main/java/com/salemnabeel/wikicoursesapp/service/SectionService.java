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

        List<Section> sectionsList = sectionRepository.findAll();

        sectionsList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return SectionMapper.entityToDto(sectionsList);
    }

    public List<SectionDtoView> getAllActiveSections() {

        List<Section> sectionsList = sectionRepository.getAllActiveSections();

        sectionsList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return  SectionMapper.entityToDto(sectionsList);
    }

    public SectionDtoView createNewSection(Section sectionNew) {

        sectionNew.setIsActive(true);

        return SectionMapper.entityToDto(sectionRepository.save(sectionNew));
    }

    public SectionDtoView updateSectionInfoById(Long sectionId, Section sectionNew) {

        if (sectionRepository.findById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("section resource not found.");
        }

        Section section = sectionRepository.findById(sectionId).get();

        section.setTitle(sectionNew.getTitle());

        section.setBrief(sectionNew.getBrief());

        section.setCoverImageLink(sectionNew.getCoverImageLink());

        section.setIsActive(sectionNew.getIsActive());

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