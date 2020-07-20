package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.exception.ResourceNotFoundException;
import com.salemnabeel.wikicoursesapp.model.Classification;
import com.salemnabeel.wikicoursesapp.model.Section;
import com.salemnabeel.wikicoursesapp.repository.ClassificationRepository;
import com.salemnabeel.wikicoursesapp.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationService {

    @Autowired
    private ClassificationRepository classificationRepository;

    @Autowired
    private SectionRepository sectionRepository;

    public List<Classification> getAllActiveClassificationsBySectionId(Long sectionId) {

        return classificationRepository.getAllActiveClassificationsBySectionId(sectionId);
    }

    public Classification createNewClassificationBySectionId(Long sectionId, Classification classificationRequest) {

        if (!sectionRepository.existsById(sectionId)) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Section section = sectionRepository.getSectionById(sectionId);

        classificationRequest.setIsActive(true);

        classificationRequest.setSection(section);

        return classificationRepository.save(classificationRequest);
    }
}