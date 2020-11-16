package com.salemnabeel.wikicoursesapp.mapper;

import com.salemnabeel.wikicoursesapp.dto.classification.ClassificationDtoView;
import com.salemnabeel.wikicoursesapp.model.Classification;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ClassificationMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static ClassificationDtoView entityToDto(Classification classification) {

        // ClassificationDtoView classificationDtoView = new ClassificationDto();

        // classificationDtoView.setId(classification.getId());

        // classificationDtoView.setTitle(classification.getTitle());

        // classificationDtoView.setBrief(classification.getBrief());

        // Section section = classification.getSection();

        // classificationDtoView.setSectionTitle(section.getTitle());

        // classificationDtoView.setCoverImageLink(classification.getCoverImageLink());

        // classificationDtoView.setCreatedAt(classification.getCreatedAt());

        // classificationDtoView.setUpdatedAt(classification.getUpdatedAt());

        // classificationDtoView.setIsActive(classification.getIsActive());

        ClassificationDtoView classificationDto = modelMapper.map(classification, ClassificationDtoView.class);

        return classificationDto;
    }

    public static List<ClassificationDtoView> entityToDto(List<Classification> classificationsList) {

        return classificationsList.stream().map(
            classification -> entityToDto(classification)
        ).collect(Collectors.toList());
    }

    public static Classification dtoToEntity(ClassificationDtoView classificationDto) {

        // Classification classification = new Classification();

        // classification.setId(classificationDto.getId());

        // classification.setTitle(classificationDto.getTitle());

        // classification.setBrief(classificationDtoView.getBrief());

        // classification.setCoverImageLink(classificationDto.getCoverImageLink());

        // classification.setCreatedAt(classificationDtoView.getCreatedAt());

        // classification.setUpdatedAt(classificationDtoView.getUpdatedAt());

        // classification.setIsActive(classificationDtoView.getIsActive());

        Classification classification = modelMapper.map(classificationDto, Classification.class);

        return classification;
    }

    public static List<Classification> dtoToEntity(List<ClassificationDtoView> classificationsDtoList) {
        return classificationsDtoList.stream().map(
            classificationDto -> dtoToEntity(classificationDto)
        ).collect(Collectors.toList());
    }
}