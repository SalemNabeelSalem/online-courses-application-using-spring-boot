package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.converter.ClassificationConverter;
import com.salemnabeel.wikicoursesapp.dto.ClassificationDto;
import com.salemnabeel.wikicoursesapp.exception.ResourceNotFoundException;
import com.salemnabeel.wikicoursesapp.model.Classification;
import com.salemnabeel.wikicoursesapp.model.Section;
import com.salemnabeel.wikicoursesapp.repository.ClassificationRepository;
import com.salemnabeel.wikicoursesapp.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationService {

    @Autowired
    private ClassificationRepository classificationRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private ClassificationConverter classificationConverter;

    public List<ClassificationDto> getAllActiveClassificationsBySectionId(Long sectionId) {

        if (!sectionRepository.existsById(sectionId)) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        List<Classification> classificationsList = classificationRepository.getAllActiveClassificationsBySectionId(sectionId);

        return classificationConverter.entityToDto(classificationsList);
    }

    public ClassificationDto createNewClassificationBySectionId(Long sectionId, Classification classificationRequest) {

        if (!sectionRepository.existsById(sectionId)) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Section section = sectionRepository.getSectionById(sectionId);

        classificationRequest.setIsActive(true);

        classificationRequest.setSection(section);

        return classificationConverter.entityToDto(classificationRepository.save(classificationRequest));
    }

    public ClassificationDto getClassificationById(Long sectionId, Long classificationId) {

        if (!sectionRepository.existsById(sectionId)) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Classification classification = classificationRepository.getClassificationById(sectionId, classificationId);

        if (classification == null) {

            throw new ResourceNotFoundException("classification id: " + classificationId + " not found.");
        }

        return classificationConverter.entityToDto(classification);
    }

    public ClassificationDto updateClassificationInfoBySectionId(Long sectionId, Long classificationId,
                                                                 Classification classificationRequest) {

        if (!sectionRepository.existsById(sectionId)) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Classification classification = classificationRepository.getClassificationById(sectionId, classificationId);

        if(classification == null) {

            throw new ResourceNotFoundException("classification id: " + classificationId + " not found.");
        }

        classification.setTitle(classificationRequest.getTitle());

        return classificationConverter.entityToDto(classificationRepository.save(classification));
    }

    public ResponseEntity deActivateClassificationBySectionId(Long sectionId, Long classificationId) {

        if (!sectionRepository.existsById(sectionId)) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Classification classification = classificationRepository.getClassificationById(sectionId, classificationId);

        if (classification == null) {

            throw new ResourceNotFoundException("classification id: " + classificationId + " not found.");
        }

        classification.setIsActive(false);

        classificationRepository.save(classification);

        return ResponseEntity.ok().build();
    }
}