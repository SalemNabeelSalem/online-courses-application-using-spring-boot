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

        classificationsList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return ClassificationMapper.entityToDto(classificationsList);
    }

    public List<ClassificationDtoView> getAllActiveClassifications() {

        List<Classification> classificationsList = classificationRepository.getAllActiveClassifications();

        classificationsList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return ClassificationMapper.entityToDto(classificationsList);
    }

    public List<ClassificationDtoView> getAllActiveClassificationsBySectionId(Long sectionId) {

        if (sectionRepository.findById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("section resource not found.");
        }

        List<Classification> classificationsList = classificationRepository
                .getAllActiveClassificationsBySectionId(sectionId);

        classificationsList.sort((s1, s2) -> s2.getId().compareTo(s1.getId()));

        return ClassificationMapper.entityToDto(classificationsList);
    }

    public ClassificationDtoView createNewClassification(ClassificationDtoNew classificationDtoNew) {

        Long sectionId = classificationDtoNew.getSectionId();

        if (sectionRepository.findById(sectionId).isEmpty()) {

            throw new ResourceNotFoundException("section resource not found.");
        }

        Section section = sectionRepository.findById(sectionId).get();

        Classification classification = new Classification();

        classification.setTitle(classificationDtoNew.getTitle());

        classification.setBrief(classificationDtoNew.getBrief());

        classification.setSection(section);

        classification.setCoverImageLink(classificationDtoNew.getCoverImageLink());

        classification.setIsActive(true);

        return ClassificationMapper.entityToDto(classificationRepository.save(classification));
    }

    public ClassificationDtoView updateClassificationInfoById(Long classificationId,
                                                              ClassificationDtoEdit classificationDtoEdit) {

        if (classificationRepository.findById(classificationId).isEmpty()) {

            throw new ResourceNotFoundException("classification resource not found.");
        }

        Classification classification = classificationRepository.findById(classificationId).get();

        if (sectionRepository.findById(classificationDtoEdit.getSectionId()).isEmpty()) {

            throw new ResourceNotFoundException("section resource not found.");
        }

        Section section = sectionRepository.findById(classificationDtoEdit.getSectionId()).get();

        classification.setTitle(classificationDtoEdit.getTitle());

        classification.setBrief(classificationDtoEdit.getBrief());

        classification.setSection(section);

        classification.setCoverImageLink(classificationDtoEdit.getCoverImageLink());

        classification.setIsActive(classificationDtoEdit.getIsActive());

        return ClassificationMapper.entityToDto(classificationRepository.save(classification));
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