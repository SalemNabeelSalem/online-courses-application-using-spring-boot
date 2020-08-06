package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.mapper.ClassificationMapper;
import com.salemnabeel.wikicoursesapp.dto.ClassificationCreateNew;
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
    private ClassificationMapper classificationMapper;

    public List<ClassificationDto> getAllActiveClassificationsBySectionId(Long sectionId) {

        List<Classification> classificationsList = classificationRepository.getAllActiveClassificationsBySectionId(sectionId);

        return classificationMapper.entityToDto(classificationsList);
    }

    public ClassificationDto createNewClassification(ClassificationCreateNew classificationCreateNewRequest) {

        Long sectionId = classificationCreateNewRequest.getSectionId();

        String classificationTitle = classificationCreateNewRequest.getTitle();

        if (sectionRepository.getActiveSectionById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("section id: " + sectionId + " not found.");
        }

        Section section = sectionRepository.getActiveSectionById(sectionId).get(0);

        Classification classification = new Classification();

        classification.setIsActive(true);

        classification.setTitle(classificationTitle);

        classification.setSection(section);

        return classificationMapper.entityToDto(
            classificationRepository.save(classification)
        );
    }

    public List<ClassificationDto> getActiveClassificationBySectionId(Long sectionId, Long classificationId) {

        List<Classification> classification = classificationRepository.getActiveClassificationBySectionId(sectionId, classificationId);

        return classificationMapper.entityToDto(classification);
    }

    public ClassificationDto updateClassificationInfoBySectionId(Long sectionId, Long classificationId,
                                                                 Classification classificationRequest) {

        if (classificationRepository.getActiveClassificationBySectionId(sectionId, classificationId).isEmpty()) {

            throw new ResourceNotFoundException("resource not found.");
        }

        Classification classification = classificationRepository.getActiveClassificationBySectionId(sectionId, classificationId).get(0);

        classification.setTitle(classificationRequest.getTitle());

        return classificationMapper.entityToDto(
            classificationRepository.save(classification)
        );
    }

    public ResponseEntity deActivateClassificationBySectionId(Long sectionId, Long classificationId) {

        if (classificationRepository.getActiveClassificationBySectionId(sectionId, classificationId).isEmpty()) {

            throw new ResourceNotFoundException("resource not found.");
        }

        Classification classification = classificationRepository.getActiveClassificationBySectionId(sectionId, classificationId).get(0);

        classification.setIsActive(false);

        classificationRepository.save(classification);

        return ResponseEntity.ok().build();
    }


}