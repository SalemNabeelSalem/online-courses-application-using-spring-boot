package com.salemnabeel.wikicoursesapp.service;

import com.salemnabeel.wikicoursesapp.dto.classification.ClassificationDtoEdit;
import com.salemnabeel.wikicoursesapp.mapper.ClassificationMapper;
import com.salemnabeel.wikicoursesapp.dto.classification.ClassificationDtoNew;
import com.salemnabeel.wikicoursesapp.dto.classification.ClassificationDtoView;
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

    public List<ClassificationDtoView> getAllClassifications() {

        List<Classification> classificationsList = classificationRepository.findAll();

        classificationsList.sort((o1, o2) -> o2.getId().compareTo(o1.getId()));

        return ClassificationMapper.entityToDto(classificationsList);
    }

    public List<ClassificationDtoView> getAllActiveClassifications() {

        List<Classification> classificationsList = classificationRepository.getAllActiveClassifications();

        classificationsList.sort((o1, o2) -> o2.getId().compareTo(o1.getId()));

        return ClassificationMapper.entityToDto(classificationsList);
    }

    public ClassificationDtoView createNewClassification(ClassificationDtoNew classificationDtoNewRequest) {

        Long sectionId = classificationDtoNewRequest.getSectionId();

        if (sectionRepository.findById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("section resource not found.");
        }

        Section section = sectionRepository.findById(sectionId).get();

        Classification classification = new Classification();

        classification.setTitle(classificationDtoNewRequest.getTitle());

        classification.setBrief(classificationDtoNewRequest.getBrief());

        classification.setSection(section);

        classification.setCoverImageLink(classificationDtoNewRequest.getCoverImageLink());

        classification.setIsActive(true);

        return ClassificationMapper.entityToDto(classificationRepository.save(classification));
    }

    public ClassificationDtoView updateClassificationInfoById(
            Long classificationId, ClassificationDtoEdit classificationDtoEditRequest) {

        if (classificationRepository.findById(classificationId).isEmpty()) {

            throw new ResourceNotFoundException("classification resource not found.");
        }

        Classification classification = classificationRepository.findById(classificationId).get();

        if (sectionRepository.findById(classificationDtoEditRequest.getSectionId()).isEmpty()) {

            throw new ResourceNotFoundException("section resource not found.");
        }

        Section section = sectionRepository.findById(classificationDtoEditRequest.getSectionId()).get();

        classification.setTitle(classificationDtoEditRequest.getTitle());

        classification.setBrief(classificationDtoEditRequest.getBrief());

        classification.setSection(section);

        classification.setCoverImageLink(classificationDtoEditRequest.getCoverImageLink());

        classification.setIsActive(classificationDtoEditRequest.getIsActive());

        return ClassificationMapper.entityToDto(
            classificationRepository.save(classification)
        );
    }

    public ResponseEntity deleteClassificationById(Long classificationId) {

        if (classificationRepository.findById(classificationId).isEmpty()) {

            throw new ResourceNotFoundException("classification resource not found.");
        }

        Classification classification = classificationRepository.findById(classificationId).get();

        classificationRepository.delete(classification);

        return ResponseEntity.ok().build();
    }
}